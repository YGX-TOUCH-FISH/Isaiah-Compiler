package BackEnd;

import AST.ASTVisitor;
import AST.Declare.*;
import AST.Expr.*;
import AST.List.BlockNode;
import AST.List.ExprListNode;
import AST.List.ForInitNode;
import AST.List.ParaListNode;
import AST.RootNode;
import AST.Stmt.*;
import AST.Type.*;
import AST.Value.*;
import LLVMIR.BasicBlock;
import LLVMIR.Function;
import LLVMIR.IRModule;
import LLVMIR.Inst.*;
import LLVMIR.Oprand.*;
import LLVMIR.Type.*;
import Util.error.irError;
import Util.position;
import Util.scope.IRScope;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

//class member: add to type
public class IRBuilder implements ASTVisitor {
    IRModule   root;
    IRScope    currentScope     = null;
    Function   currentFunction  = null;
    BasicBlock currentBlock     = null;
    ClassType  currentClass     = null;
    boolean    preCheck         = false;
    Function globalVarInit;
    Stack<ArrayList<BasicBlock>> loopBreakStack  = new Stack<>();
    Stack<ArrayList<BasicBlock>> loopContinStack = new Stack<>();

    public IRBuilder() {
        root = new IRModule();
    }
    public IRModule BuiltRoot() { return root; }

    @Override public void visit(RootNode node) {
        currentScope = new IRScope(null);
        // pre-stage
        preCheck = true;
        for (DeclrNode declare : node.declrs) {
            if (declare instanceof FuncDeclrNode) declare.accept(this);
        }
        for (DeclrNode declare : node.declrs) {
            if (declare instanceof ClassDeclrNode) {
                currentClass = new ClassType(((ClassDeclrNode) declare).name);
                for (DeclrNode funcDeclr : ((ClassDeclrNode) declare).declrs) {
                    if (funcDeclr instanceof FuncDeclrNode) funcDeclr.accept(this);
                }
                currentClass = null;
            }
        }
        globalVarInit = new Function("global_var_init", new VoidType());
        currentFunction = globalVarInit;
        currentBlock = currentFunction.getEntry();
        for (DeclrNode declare : node.declrs)
            if (declare instanceof AssignDeclrNode || declare instanceof ListDeclrNode) declare.accept(this);
        currentBlock.append(new RetInst());
        currentBlock = null;
        currentFunction = null;
        root.addCustomFunction(globalVarInit);

        for (DeclrNode declare : node.declrs) {
            if (declare instanceof ClassDeclrNode) {
                ConstructDeclrNode constructor = null;
                root.addCustomClass(((ClassDeclrNode) declare).name);
                currentClass    = new ClassType(((ClassDeclrNode) declare).name);
                currentFunction = new Function(currentClass.className, new VoidType());
                currentFunction.appendArgument(new PointerType(new ClassType(currentClass.className)));
                currentBlock    = currentFunction.getEntry();
                currentScope    = new IRScope(currentScope);
                VirtualReg thisStoreReg = new VirtualReg(new PointerType(new ClassType(currentClass.className), 2), currentFunction.takeLabel());
                currentBlock.append(new AllocaInst(thisStoreReg));
                currentBlock.append(new StoreInst(currentFunction.args.get(0), thisStoreReg));
                currentScope.defineVar("this", thisStoreReg);

                for (DeclrNode memberDeclr :  ((ClassDeclrNode) declare).declrs) {
                    if (memberDeclr instanceof ConstructDeclrNode) constructor = (ConstructDeclrNode) memberDeclr;
                    if (memberDeclr instanceof AssignDeclrNode || memberDeclr instanceof ListDeclrNode) memberDeclr.accept(this);
                }
                currentScope.classInfo = root.getClassInfo(currentClass.className);
                if (constructor != null) constructor.accept(this);
                if (!currentBlock.hasTerminal) currentBlock.append(new RetInst());
                root.addCustomFunction(currentFunction);

                currentScope    = currentScope.getParent();
                currentBlock    = null;
                currentFunction = null;
                currentClass    = null;
            }
        }
        preCheck = false;
        // formal visit
        for (DeclrNode declare : node.declrs) declare.accept(this);
        currentScope = currentScope.getParent();
    }

    @Override public void visit(ClassDeclrNode node) {
        currentClass = new ClassType(node.name);
        for (DeclrNode declare : node.declrs) declare.accept(this);
        currentClass = null;
    }

    @Override public void visit(ConstructDeclrNode node) {
        if (preCheck) node.block.accept(this);
    }

    @Override public void visit(EmptyDeclrNode node) {}

    @Override public void visit(FuncDeclrNode node) {
        String name = currentClass != null ? currentClass.className+"."+node.name : node.name;
        if (preCheck) {
            node.retType.accept(this);
            currentFunction = new Function(name, node.retType.baseType);
            node.paraList.accept(this);
            root.addCustomFunction(currentFunction);
            currentFunction = null;
        }
        else {
            currentScope    = new IRScope(currentScope);
            currentFunction = root.getCustomFunction(name);
            currentBlock    = currentFunction.getEntry();   // build entry block
            if (currentClass != null) currentScope.classInfo = root.getClassInfo(currentClass.className);
            if (Objects.equals(node.name, "main")) currentBlock.append(new CallInst(null, globalVarInit, null));
            node.paraList.accept(this);
            node.block.accept(this);
            if (!currentBlock.hasTerminal) currentBlock.append(new RetInst(currentFunction.retType.getZeroInit(), currentFunction.retType)); // add efficient ret
            currentBlock    = null;
            currentFunction = null;
            currentScope    = currentScope.getParent();
        }
    }

    @Override public void visit(AssignDeclrNode node) { //static or class member
        if (preCheck) {
            node.typeNode.accept(this);
            node.valueNode.accept(this);    // no forward reference
            Oprand load;
            VirtualReg ptrReg, thisStoreReg, thisReg, defReg;
            if (node.valueNode.isLvalue()) {
                load = new VirtualReg(node.valueNode.getValueType(), currentFunction.takeLabel());
                currentBlock.append(new LoadInst((VirtualReg) load, node.valueNode.address));
            } else load = node.valueNode.value;

            if (currentClass != null) {  // member declare, don't add to currentScope
                root.appendClassMember(currentClass.className, node.typeNode.baseType, node.id);
                thisStoreReg = currentScope.getVarReg("this", true, currentBlock, currentFunction);
                thisReg = new VirtualReg(new PointerType(new ClassType(currentClass.className)), currentFunction.takeLabel());
                ptrReg = new VirtualReg(new PointerType(node.typeNode.baseType), currentFunction.takeLabel());
                currentBlock.append(new LoadInst(thisReg, thisStoreReg));
                ArrayList<Oprand> offsets = new ArrayList<>();
                offsets.add(new ConstInt(32, 0));       // deference of 'this', get struct object
                offsets.add(new ConstInt(32, root.getClassMemberIndex(currentClass.className, node.id)));
                currentBlock.append(new GetElementPtrInst(ptrReg, thisReg, offsets));
                currentBlock.append(new StoreInst(load, ptrReg));
            }
            else {  //global declare
                defReg = new VirtualReg(new PointerType(node.valueNode.getValueType()), node.id);
                currentBlock.append(new StoreInst(load, defReg));
                currentScope.defineVar(node.id, defReg);
                root.addStaticData(node.id, node.valueNode.getValueType());
            }
        }
    }

    @Override public void visit(ListDeclrNode node) {
        if (preCheck) {
            node.typeNode.accept(this);
            if (currentClass != null)
                for (String id : node.ids) root.appendClassMember(currentClass.className, node.typeNode.baseType, id);
            else {
                for (String id : node.ids) {
                    VirtualReg defReg = new VirtualReg(new PointerType(node.typeNode.baseType), id);
                    currentScope.defineVar(id, defReg);
                    ArrayList<Oprand> args = new ArrayList<>(); args.add(defReg);
                    if (node.typeNode.baseType instanceof ClassType) {
                        Function constructor = root.getCustomFunction(((ClassType) node.typeNode.baseType).className);
                        currentBlock.append(new CallInst(null, constructor, args));
                    }
                    root.addStaticData(id, node.typeNode.baseType);
                }
            }
        }
    }

    @Override public void visit(VoidTypeNode node) {
        node.baseType = new VoidType();
    }
    @Override public void visit(BoolTypeNode node) {
        node.baseType = new IntType(1);
    }
    @Override public void visit(IntTypeNode node) {
        node.baseType = new IntType(32);
    }
    @Override public void visit(StringTypeNode node) {
        node.baseType = new PointerType(new IntType(8));
    }
    @Override public void visit(ClassTypeNode node) {
        node.baseType = new PointerType(new ClassType(node.name));
    }

    @Override public void visit(ArrayTypeNode node) {
        node.elementType.accept(this);
        node.baseType = new PointerType(node.elementType.baseType, node.dims);
    }

    @Override public void visit(EmptyStNode node) {}

    @Override public void visit(AssignStNode node) {
        node.typeNode.accept(this); // typeNode.baseType: basic or 'this'
        node.valueNode.accept(this);
        VirtualReg allocReg;
        Oprand assignValue;
        if (node.valueNode.isLvalue())  {
            assignValue = new VirtualReg(node.valueNode.getValueType(), currentFunction.takeLabel());
            currentBlock.append(new LoadInst((VirtualReg) assignValue, node.valueNode.address));
        } else assignValue = node.valueNode.value;
        allocReg = new VirtualReg(new PointerType(node.typeNode.getBaseType()), currentFunction.takeLabel());
        currentScope.defineVar(node.name, allocReg);
        currentBlock.append(new AllocaInst(allocReg));
        currentBlock.append(new StoreInst(assignValue, allocReg));
    }

    @Override public void visit(ListStNode node) {
        node.type.accept(this);
        for (String id : node.ids) {
            VirtualReg allocReg = new VirtualReg(new PointerType(node.type.baseType), currentFunction.takeLabel());
            currentScope.defineVar(id, allocReg);
            currentBlock.append(new AllocaInst(allocReg));
        }
    }

    @Override public void visit(ExprStNode node) {
        node.expr.accept(this);
    }

    @Override public void visit(CondStNode node) {
        node.condition.accept(this);
        BasicBlock rootBlock, ifHeadBlock, elseHeadBlock, ifTailBlock, elseTailBlock, exitBlock;
        Oprand left, right;
        if (node.condition.isLvalue()) {
            left = new VirtualReg(node.condition.getValueType(), currentFunction.takeLabel());
            currentBlock.append(new LoadInst((VirtualReg) left, node.condition.address));
        } else left = node.condition.value;
        right = new ConstInt(32, 0);
        if (left instanceof ConstInt) {                 // constant optimize
            if (((ConstInt)left).getIntValue() == 0) {  // false condition
                if (node.elseStmt != null) {
                    currentScope = new IRScope(currentScope);
                    node.elseStmt.accept(this);
                    currentScope = currentScope.getParent();
                }
            } else {
                currentScope = new IRScope(currentScope);
                node.ifStmt.accept(this);
                currentScope = currentScope.getParent();
            }
            return;
        }
        VirtualReg condReg = new VirtualReg(new IntType(1), currentFunction.takeLabel());
        currentBlock.append(new IcmpInst(condReg, IcmpInst.CompareType.ne, left, right));
        ifHeadBlock   = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
        rootBlock    = currentBlock;
        currentBlock.next = ifHeadBlock;
        currentBlock = currentBlock.next;
        currentScope = new IRScope(currentScope);
        node.ifStmt.accept(this);
        currentScope = currentScope.getParent();
        ifTailBlock  = currentBlock;
        if (node.elseStmt != null) {
            elseHeadBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
            currentBlock.next = elseHeadBlock;
            currentBlock = currentBlock.next;
            rootBlock.append(new BrInst(condReg, ifHeadBlock, elseHeadBlock)); rootBlock.hasTerminal =true;
            currentScope = new IRScope(currentScope);
            node.elseStmt.accept(this);
            currentScope = currentScope.getParent();
            elseTailBlock = currentBlock;
            currentBlock.next = exitBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());

            if (!ifTailBlock.hasTerminal)   ifTailBlock.append(new JumpInst(exitBlock));
            if (!elseTailBlock.hasTerminal) elseTailBlock.append(new JumpInst(exitBlock));
            ifTailBlock.hasTerminal   = true;
            elseTailBlock.hasTerminal = true;
        }
        else {
            currentBlock.next = exitBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
            rootBlock.append(new BrInst(condReg, ifHeadBlock, exitBlock)); rootBlock.hasTerminal = true;
            if (!ifTailBlock.hasTerminal)  ifTailBlock.append(new JumpInst(exitBlock));  ifTailBlock.hasTerminal = true;
        }
        currentBlock = currentBlock.next;
    }

    @Override public void visit(ForInitNode node) {
        for (ExprNode expr : node.exprs) expr.accept(this);
    }

    @Override public void visit(ForStNode node) {
        loopBreakStack.push(new ArrayList<>());
        loopContinStack.push(new ArrayList<>());
        currentScope = new IRScope(currentScope);
        BasicBlock condHeadBlock, condTailBlock, exeHeadBlock, exeTailBlock, increHeadBlock, increTailBlock, exitBlock;
        Oprand condValue = null; VirtualReg resultReg = null;

        node.init.accept(this);
        condHeadBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
        currentBlock.append(new JumpInst(condHeadBlock)); currentBlock.hasTerminal = true;
        currentBlock = currentBlock.next = condHeadBlock;
        if (node.condition != null) {
            node.condition.accept(this);
            if (node.condition.isLvalue()) {
                condValue = new VirtualReg(node.condition.getValueType(), currentFunction.takeLabel());
                currentBlock.append(new LoadInst((VirtualReg) condValue, node.condition.address));
            } else condValue = node.condition.value;
            resultReg = new VirtualReg(new IntType(1), currentFunction.takeLabel());
        }
        condTailBlock = currentBlock;
        exeHeadBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
        currentBlock = currentBlock.next = exeHeadBlock;
        node.stmt.accept(this);
        exeTailBlock = currentBlock;
        increHeadBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
        currentBlock = currentBlock.next = increHeadBlock;
        if (node.increment != null) node.increment.accept(this);
        increTailBlock = currentBlock;
        exitBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
        if (node.condition != null) {
            condTailBlock.append(new IcmpInst(resultReg, IcmpInst.CompareType.ne, condValue, new ConstInt(32, 0)));
            condTailBlock.append(new BrInst(resultReg, exeHeadBlock, exitBlock));
        } else condTailBlock.append(new JumpInst(exeHeadBlock));
        condTailBlock.hasTerminal = true;
        if (!exeTailBlock.hasTerminal)   exeTailBlock.append(new JumpInst(increHeadBlock));
        if (!increTailBlock.hasTerminal) increTailBlock.append(new JumpInst(condHeadBlock));
        exeTailBlock.hasTerminal = true;
        increTailBlock.hasTerminal = true;
        ArrayList<BasicBlock> breakBlocks  = loopBreakStack.pop();
        ArrayList<BasicBlock> continBlocks = loopContinStack.pop();
        for (BasicBlock breakBlock : breakBlocks)   {
            breakBlock.append(new JumpInst(exitBlock));
        }
        for (BasicBlock continBlock : continBlocks) {
            continBlock.append(new JumpInst(increHeadBlock));
        }
        currentBlock = currentBlock.next = exitBlock;
        currentScope = currentScope.getParent();
    }

    @Override public void visit(WhileStNode node) {
        loopBreakStack.push(new ArrayList<>());
        loopContinStack.push(new ArrayList<>());
        BasicBlock condHeadBlock, condTailBlock, exeHeadBlock, exeTailBlock, exitBlock;
        Oprand condValue;  VirtualReg condReg;
        condHeadBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
        currentBlock.append(new JumpInst(condHeadBlock)); currentBlock.hasTerminal = true;
        currentBlock = currentBlock.next = condHeadBlock;
        node.condition.accept(this);    // condition execute
        if (node.condition.isLvalue()) {
            condValue = new VirtualReg(new IntType(1), currentFunction.takeLabel());
            currentBlock.append(new LoadInst((VirtualReg) condValue, node.condition.address));
        } else condValue = node.condition.value;
        if (condValue instanceof ConstInt && ((ConstInt) condValue).getIntValue() == 0) return; // constant optimize
        condReg = new VirtualReg(new IntType(1), currentFunction.takeLabel());
        currentBlock.append(new IcmpInst(condReg, IcmpInst.CompareType.ne, condValue, new ConstInt(32, 0)));
        condTailBlock = currentBlock;
        exeHeadBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
        currentBlock = currentBlock.next = exeHeadBlock;
        currentScope = new IRScope(currentScope);
        node.stmt.accept(this);
        currentScope = currentScope.getParent();
        exeTailBlock = currentBlock;
        exitBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
        condTailBlock.append(new BrInst(condReg, exeHeadBlock, exitBlock));
        condTailBlock.hasTerminal = true;
        if (!exeTailBlock.hasTerminal) exeTailBlock.append(new JumpInst(condHeadBlock));
        exeTailBlock.hasTerminal  = true;

        ArrayList<BasicBlock> breakBlocks  = loopBreakStack.pop();
        ArrayList<BasicBlock> continBlocks = loopContinStack.pop();
        for (BasicBlock breakBlock : breakBlocks)   {
            breakBlock.append(new JumpInst(exitBlock));
        }
        for (BasicBlock continBlock : continBlocks) {
            continBlock.append(new JumpInst(condHeadBlock));
        }
        currentBlock = currentBlock.next = exitBlock;
    }

    @Override public void visit(BreakStNode node) {
        loopBreakStack.peek().add(currentBlock);
        currentBlock.hasTerminal = true;
    }

    @Override public void visit(RetStNode node) {
        Oprand retValue; // void-return
        if (node.retExpr != null) {
            node.retExpr.accept(this);
            if (node.retExpr.isLvalue()) {
                retValue = new VirtualReg(node.retExpr.getValueType(), currentFunction.takeLabel());
                currentBlock.append(new LoadInst((VirtualReg) retValue, node.retExpr.address));
            } else retValue = node.retExpr.value;
            currentBlock.append(new RetInst(retValue, currentFunction.retType));
        } else currentBlock.append(new RetInst());
        currentBlock.hasTerminal = true;
    }

    @Override public void visit(ContinStNode node) {
        loopContinStack.peek().add(currentBlock);
        currentBlock.hasTerminal = true;
    }

    @Override public void visit(BlockStNode node) {
        currentScope = new IRScope(currentScope);
        node.block.accept(this);
        currentScope = currentScope.getParent();
    }

    @Override public void visit(ValueExprNode node) {
        node.valueNode.accept(this);
        node.address = node.valueNode.address;
        node.value   = node.valueNode.imm;
    }

    @Override public void visit(IndexExprNode node) {   // array: IndexExpr or other
        VirtualReg  ptrReg, thisReg;
        Oprand offset;
        node.array.accept(this);
        node.index.accept(this);
        if (!(node.array.getValueType() instanceof PointerType)) throw new irError("[ERROR] array must be pointer-type: ", node.pos);
        if (node.index.isLvalue()) {
            offset = new VirtualReg(node.index.getValueType(), currentFunction.takeLabel());
            currentBlock.append(new LoadInst((VirtualReg) offset, node.index.address));
        } else offset = node.index.value;

        thisReg = new VirtualReg(node.array.getValueType(), currentFunction.takeLabel());
        currentBlock.append(new LoadInst(thisReg, node.array.address));
        ptrReg = new VirtualReg(node.array.getValueType(), currentFunction.takeLabel());
        currentBlock.append(new GetElementPtrInst(ptrReg, thisReg, offset));
        node.address = ptrReg;
        node.value   = null;
        // always return thisStoreReg.
    }

    @Override public void visit(CallExprNode node) {    // node could be rvalue.
        node.object.accept(this);
        Oprand thisReg;
        if (node.object.isLvalue()) {
            thisReg = new VirtualReg(node.object.getValueType(), currentFunction.takeLabel());
            currentBlock.append(new LoadInst((VirtualReg) thisReg, node.object.address));
        } else thisReg = node.object.value;
        if (node.exprList == null) {
            // TODO: 2021/12/14 be cautious on 'this' pointer!
            BaseType memberBaseType = root.getClassMemberBaseType(node.object.type.name, node.memberID);
            VirtualReg ptrReg = new VirtualReg(new PointerType(memberBaseType), currentFunction.takeLabel());
            ArrayList<Oprand> offsets = new ArrayList<>();
            offsets.add(new ConstInt(32, 0));   // skip load
            offsets.add(new ConstInt(32, root.getClassMemberIndex(node.object.type.name, node.memberID)));
            currentBlock.append(new GetElementPtrInst(ptrReg, thisReg, offsets));
            node.address = ptrReg;
            node.value   = null;
        }
        else {  // function call
            Function function = null; VirtualReg resultReg ; ArrayList<Oprand> functionArgs;
            node.exprList.accept(this);
            functionArgs = new ArrayList<>(node.exprList.oprands);
            if (node.object.type.isClass()) {
                functionArgs.add(0, thisReg);                 // add 'this' pointer
                String className = node.object.type.name;
                function = root.getCustomFunction(className+"."+node.memberID);
            } else {
                if (Objects.equals(node.memberID, "size")) {    // array method
                    VirtualReg thisCastReg;
                    thisCastReg = new VirtualReg(new PointerType(new IntType(8)), currentFunction.takeLabel());
                    currentBlock.append(new BitCastInst((VirtualReg) thisReg, thisCastReg));
                    functionArgs.add(thisCastReg);
                    function = root.size;
                }
                else {  // string method
                    if (Objects.equals(node.memberID, "length")) function = root.getBuiltInFunction("string_length");
                    else if (Objects.equals(node.memberID, "substring")) function = root.getBuiltInFunction("string_subString");
                    else if (Objects.equals(node.memberID, "parseInt")) function = root.getBuiltInFunction("string_parseInt");
                    else if (Objects.equals(node.memberID, "ord")) function = root.getBuiltInFunction("string_ord");
                    else throw new irError("unknown string-builtIn function error", new position(0, 0));
                    functionArgs.add(0, thisReg);
                }
            }
            resultReg = null;
            if (!(function.retType instanceof VoidType)) resultReg = new VirtualReg(function.retType, currentFunction.takeLabel());
            currentBlock.append(new CallInst(resultReg, function, functionArgs));
            node.address = null;
            node.value   = resultReg;
        }
    }

    @Override public void visit(UnaryExprNode node) {
        node.rhs.accept(this);
        Oprand load, result;
        if (node.rhs.isLvalue()) {
            load = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
            currentBlock.append(new LoadInst((VirtualReg) load, node.rhs.address));
        } else load = node.rhs.value;

        if (load instanceof VirtualReg) {
            switch (node.op){
                case LNOT:
                    result = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
                    currentBlock.append(new BinaryInst((VirtualReg) result, BinaryInst.BiArOp.xor, load, new ConstInt(1, 1)));
                    break;
                case BNOT:
                    result = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
                    currentBlock.append(new BinaryInst((VirtualReg) result, BinaryInst.BiArOp.xor, load, new ConstInt(32, -1)));
                    break;
                case POS:
                    result = load; break;
                case NEG:
                    result = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
                    currentBlock.append(new BinaryInst((VirtualReg) result, BinaryInst.BiArOp.sub, new ConstInt(32, 0), load));
                    break;
                default: throw new irError("[ERROR] reaching unknown unary-arith operator: ", node.pos);
            }
        }
        else {
            switch (node.op) {
                case LNOT:  result = new ConstInt(1, ((ConstInt) load).getIntValue()^1); break;
                case BNOT:  result = new ConstInt(32, ~((ConstInt) load).getIntValue()); break;
                case POS:   result = node.rhs.value; break;
                case NEG:   result = new ConstInt(32, -((ConstInt) load).getIntValue()); break;
                default:    throw new irError("[ERROR] reaching unknown unary-arith operator: ", node.pos);
            }
        }
        node.address = null;
        node.value   = result;
    }

    @Override public void visit(BinaryExprNode node) {
            Oprand left, right, result = null;
        if (node.op != BinaryExprNode.BinaryOp.ANDAND && node.op != BinaryExprNode.BinaryOp.OROR && node.op != BinaryExprNode.BinaryOp.ASSIGN) {
            node.lhs.accept(this);
            node.rhs.accept(this);
            if (node.lhs.isLvalue()) {
                left = new VirtualReg(node.lhs.getValueType(), currentFunction.takeLabel());
                currentBlock.append(new LoadInst((VirtualReg) left, node.lhs.address));
            } else left = node.lhs.value;
            if (node.rhs.isLvalue()) {
                right = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
                currentBlock.append(new LoadInst((VirtualReg) right, node.rhs.address));
            } else right = node.rhs.value;
            IcmpInst.CompareType compareType = node.getCmpType();
            BinaryInst.BiArOp    biArOp      = node.getBiArType();
            if (left instanceof VirtualReg || right instanceof VirtualReg) {
                switch (node.op) {
                    case ADD:
                        if (node.lhs.getValueType() instanceof IntType) { // int add
                            result = new VirtualReg(node.lhs.getValueType(), currentFunction.takeLabel());
                            currentBlock.append(new BinaryInst((VirtualReg) result, BinaryInst.BiArOp.add, left, right));
                        }
                        else { //string add
                            result = new VirtualReg(new PointerType(new IntType(8)), currentFunction.takeLabel());
                            ArrayList<Oprand> args = new ArrayList<>();
                            args.add(left); args.add(right);
                            currentBlock.append(new CallInst((VirtualReg) result, root.strADD, args));
                        }
                        break;
                    case LT: case GT: case LEQ: case GEQ:
                        result = new VirtualReg(new IntType(1), currentFunction.takeLabel());
                        if (node.lhs.getValueType() instanceof IntType)  // int cmp
                            currentBlock.append(new IcmpInst((VirtualReg) result, compareType, left, right));
                        else { //string cmp
                            ArrayList<Oprand> args = new ArrayList<>();
                            args.add(left); args.add(right);
                            switch (node.op) {
                                case LT: currentBlock.append(new CallInst((VirtualReg) result, root.strLT, args));  break;
                                case GT: currentBlock.append(new CallInst((VirtualReg) result, root.strGT, args));  break;
                                case LEQ:currentBlock.append(new CallInst((VirtualReg) result, root.strLEQ, args)); break;
                                case GEQ:currentBlock.append(new CallInst((VirtualReg) result, root.strGEQ, args)); break;
                            }
                        }
                        break;
                    case SUB: case MUL: case DIV: case MOD: case LSH: case RSH: case AND: case XOR: case OR: // int arith
                        result = new VirtualReg(node.lhs.getValueType(), currentFunction.takeLabel());
                        currentBlock.append(new BinaryInst((VirtualReg) result, biArOp, left, right));
                        break;
                    case EQ: case NEQ:
                        result = new VirtualReg(new IntType(1), currentFunction.takeLabel());
                        if (node.lhs.type.isString() && node.rhs.type.isString()) {
                            ArrayList<Oprand> args = new ArrayList<>();
                            args.add(left); args.add(right);
                            switch (node.op) {
                                case EQ: currentBlock.append(new CallInst((VirtualReg) result, root.strEQ, args)); break;
                                case NEQ:currentBlock.append(new CallInst((VirtualReg) result, root.strNE, args)); break;
                            }
                        }
                        else currentBlock.append(new IcmpInst((VirtualReg) result, compareType, left, right));
                        break;
                }
            }
            else {
                switch (node.op) {
                    case ADD:
                        if (node.lhs.getValueType() instanceof IntType) {
                            long l = ((ConstInt)node.lhs.value).getIntValue(), r = ((ConstInt)node.rhs.value).getIntValue();
                            result = new ConstInt(32, l + r);
                        }
                        else throw new irError("[ERROR] unknown error occurred in constant add", node.pos);
                        break;
                    case LT: case GT: case LEQ: case GEQ:
                        long l, r;
                        if (node.lhs.getValueType() instanceof IntType) {
                            l = ((ConstInt)node.lhs.value).getIntValue();
                            r = ((ConstInt)node.rhs.value).getIntValue();
                        }
                        else throw new irError("[ERROR] unknown error occurred in constant compare", node.pos);
                        switch (node.op) {
                            case LT: result = new ConstInt(1, l <  r ? 1 : 0); break;
                            case GT: result = new ConstInt(1, l >  r ? 1 : 0); break;
                            case LEQ:result = new ConstInt(1, l <= r ? 1 : 0); break;
                            case GEQ:result = new ConstInt(1, l >= r ? 1 : 0); break;
                        }
                        break;
                    case SUB: case MUL: case DIV: case MOD: case LSH: case RSH: case AND: case XOR: case OR:
                        long lval = ((ConstInt)node.lhs.value).getIntValue(), rval = ((ConstInt)node.rhs.value).getIntValue();
                        switch (node.op) {
                            case SUB: result = new ConstInt(32, lval -  rval);  break;
                            case MUL: result = new ConstInt(32, lval *  rval);  break;
                            case DIV: result = new ConstInt(32, lval /  rval);  break;
                            case MOD: result = new ConstInt(32, lval %  rval);  break;
                            case LSH: result = new ConstInt(32, lval << rval);  break;
                            case RSH: result = new ConstInt(32, lval >> rval);  break;     //ashr
                            case AND: result = new ConstInt(32, lval &  rval);  break;
                            case XOR: result = new ConstInt(32, lval ^  rval);  break;
                            case OR : result = new ConstInt(32, lval |  rval);  break;
                        }
                        break;
                    case EQ: case NEQ:
                        if (node.lhs.getValueType() instanceof IntType) {   // int-imm to int-imm
                            long lImm = ((ConstInt)node.lhs.value).getIntValue(), rImm = ((ConstInt)node.rhs.value).getIntValue();
                            if (node.op == BinaryExprNode.BinaryOp.EQ) result = new ConstInt(1, lImm == rImm ? 1 : 0);
                            else result = new ConstInt(1, lImm != rImm ? 1 : 0);
                        }
                        else result = new ConstInt(1, node.op == BinaryExprNode.BinaryOp.EQ ? 1 : 0);   // compare null with null
                        break;
                }
            }
        }
        else {
            if (node.op == BinaryExprNode.BinaryOp.ASSIGN) {
                node.lhs.accept(this);
                node.rhs.accept(this);
                if (node.rhs.isLvalue()) {
                    right = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
                    currentBlock.append(new LoadInst((VirtualReg) right, node.rhs.address));
                } else right = node.rhs.value;
                currentBlock.append(new StoreInst(right, node.lhs.address));

            }
            else { // short path  && : (ne) & (ne), || : (eq) | (eq)
                VirtualReg firstValue, secondValue;
                BasicBlock rootBlock, alterBlock, resultBlock;
                node.lhs.accept(this);
                if (node.lhs.isLvalue()) {
                    left = new VirtualReg(node.lhs.getValueType(), currentFunction.takeLabel());
                    currentBlock.append(new LoadInst((VirtualReg) left, node.lhs.address));
                } else left = node.lhs.value;
                if (left instanceof ConstInt) {                 // constant optimize
                    ConstInt leftValue = (ConstInt) left;
                    if ((node.op == BinaryExprNode.BinaryOp.ANDAND && leftValue.intValue == 0) || (node.op == BinaryExprNode.BinaryOp.OROR && leftValue.intValue == 1)) {
                        node.value = new ConstInt(1, node.op == BinaryExprNode.BinaryOp.ANDAND ? 0 : 1);
                    }
                    else {
                        node.rhs.accept(this);
                        if (node.rhs.isLvalue()) {
                            right = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
                            currentBlock.append(new LoadInst((VirtualReg) right, node.rhs.address));
                        } else right = node.rhs.value;
                        result = new VirtualReg(new IntType(1), currentFunction.takeLabel());
                        currentBlock.append(new IcmpInst((VirtualReg) result, IcmpInst.CompareType.ne, right, new ConstInt(1, 0)));
                        node.value = result;
                    }
                    node.address = null;
                    return;
                }
                firstValue = new VirtualReg(new IntType(1), currentFunction.takeLabel());
                currentBlock.append(new IcmpInst(firstValue, IcmpInst.CompareType.ne, left, new ConstInt(1, 0)));
                rootBlock  = currentBlock;
                alterBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
                currentBlock.next = alterBlock;
                currentBlock = currentBlock.next;
                node.rhs.accept(this);
                if (node.rhs.isLvalue()) {
                    right = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
                    currentBlock.append(new LoadInst((VirtualReg) right, node.rhs.address));
                } else right = node.rhs.value;
                secondValue = new VirtualReg(new IntType(1), currentFunction.takeLabel());
                currentBlock.append(new IcmpInst(secondValue, IcmpInst.CompareType.ne, right, new ConstInt(1, 0)));
                resultBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
                currentBlock.append(new JumpInst(resultBlock));                     //   supply branch inst for root and alter
                if (node.op == BinaryExprNode.BinaryOp.ANDAND) rootBlock.append(new BrInst(firstValue, alterBlock, resultBlock));
                else rootBlock.append(new BrInst(firstValue, resultBlock, alterBlock));
                currentBlock.next = resultBlock;
                currentBlock = currentBlock.next;
                // result calculate.
                result = new VirtualReg(new IntType(1), currentFunction.takeLabel());
                ArrayList<Pair<Oprand, Integer>> paths = new ArrayList<>();
                if (node.op == BinaryExprNode.BinaryOp.ANDAND) paths.add(new Pair<>(new ConstInt(1, 0), rootBlock.label));
                else paths.add(new Pair<>(new ConstInt(1, 1), rootBlock.label));
                paths.add(new Pair<>(secondValue, alterBlock.label));
                currentBlock.append(new PhiInst((VirtualReg) result, paths));
            }
        }
        node.address = node.op == BinaryExprNode.BinaryOp.ASSIGN ? node.lhs.address : null;
        node.value   = node.op == BinaryExprNode.BinaryOp.ASSIGN ? null : result;
    }

    @Override public void visit(PrefixExprNode node) { //must be lvalue
        BinaryInst.BiArOp binaryOp = node.op == PrefixExprNode.PreOp.INC ? BinaryInst.BiArOp.add : BinaryInst.BiArOp.sub;
        node.rhs.accept(this);
        VirtualReg loadReg, resultReg;
        loadReg = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
        currentBlock.append(new LoadInst(loadReg, node.rhs.address));
        resultReg = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
        currentBlock.append(new BinaryInst(resultReg, binaryOp, loadReg, new ConstInt(32, 1)));
        currentBlock.append(new StoreInst(resultReg, node.rhs.address));
        node.address = node.rhs.address;
        node.value   = null;
    }

    @Override public void visit(SuffixExprNode node) {
        BinaryInst.BiArOp binaryOp = node.op == SuffixExprNode.SufOp.INC ? BinaryInst.BiArOp.add : BinaryInst.BiArOp.sub;
        node.lhs.accept(this);
        Oprand loadReg, resultReg;
        if (node.lhs.isLvalue()) {
            loadReg = new VirtualReg(node.lhs.getValueType(), currentFunction.takeLabel());
            currentBlock.append(new LoadInst((VirtualReg) loadReg, node.lhs.address));
        } else loadReg = node.lhs.value;
        resultReg = new VirtualReg(node.lhs.getValueType(), currentFunction.takeLabel());
        currentBlock.append(new BinaryInst((VirtualReg) resultReg, binaryOp, loadReg, new ConstInt(32, 1)));
        currentBlock.append(new StoreInst(resultReg, node.lhs.address));
        node.address = null;
        node.value   = loadReg;
    }

    @Override public void visit(VariValNode node) {
        // anonymous variable: new Class()
        if (node.name != null)
            node.address = currentScope.getVarReg(node.name, true, currentBlock, currentFunction);
        else {  // call malloc
            Function constructor;
            VirtualReg thisStoreReg, thisReg, mallocReg;
            ArrayList<Oprand> mallocArgs = new ArrayList<>(), constructArgs = new ArrayList<>();
            constructor = root.getFunction(node.type.name);
            thisStoreReg = new VirtualReg(new PointerType(new ClassType(node.type.name), 2), currentFunction.takeLabel());
            currentBlock.append(new AllocaInst(thisStoreReg));
            mallocReg = new VirtualReg(new PointerType(new IntType(8)), currentFunction.takeLabel());
            mallocArgs.add(new ConstInt(32, root.getClassInfo(node.type.name).getByteWidth(root)));
            currentBlock.append(new CallInst(mallocReg, root.malloc, mallocArgs));
            thisReg = new VirtualReg(new PointerType(new ClassType(node.type.name)), currentFunction.takeLabel());
            currentBlock.append(new BitCastInst(mallocReg, thisReg));
            constructArgs.add(thisReg);
            currentBlock.append(new CallInst(null, constructor, constructArgs));
            currentBlock.append(new StoreInst(thisReg, thisStoreReg));
            node.address = thisStoreReg;
        }
        node.imm = null;
    }

    @Override public void visit(IntValNode node) {
        node.address = null;
        node.imm     = new ConstInt(32, node.intValue);
    }

    @Override public void visit(StringValNode node) {
        String constantName = ".str."+root.strConstants.size();
        String strValue = node.strValue.substring(1, node.strValue.length()-1);
        StringBuilder llvmStr = new StringBuilder("\"");
        int i, strLength = 0;
        for (i = 0 ; i < strValue.length() ; i++) {
            if (strValue.charAt(i) == '\\') {
                i++;
                if (strValue.charAt(i) == '\\') llvmStr.append("\\5C");
                else if (strValue.charAt(i) == '\"') llvmStr.append("\\22");
                else if (strValue.charAt(i) == 'n') llvmStr.append("\\0A");
                else if (strValue.charAt(i) == '0') llvmStr.append("\\00");
            }
            else llvmStr.append(strValue.charAt(i));
            strLength++;
        }
        llvmStr.append("\\00\""); strLength++;  // append '\0'
        VirtualReg strConstReg = new VirtualReg(new PointerType(new ArrayType(new IntType(8), strLength)), constantName);
        root.strConstants.add(new Pair<>(llvmStr.toString(), strConstReg));
        VirtualReg strReg = new VirtualReg(new PointerType(new IntType(8)), currentFunction.takeLabel());
        currentBlock.append(new BitCastInst(strConstReg, strReg));
        node.address = null;
        node.imm = strReg;
    }

    @Override public void visit(BoolValNode node) {
        node.address = null;
        node.imm     = new ConstInt(1, node.boolValue ? 1 : 0);
    }

    @Override public void visit(NullValNode node) {
        node.address = null;
        node.imm     = new ConstNull();
    }

    @Override public void visit(NewArrayNode node) {
        node.elementType.accept(this);
        BaseType bottomBaseType;
        ArrayList<Oprand> sizes = new ArrayList<>();
        Oprand indexValue;
        VirtualReg thisReg, thisStoreReg;
        if (node.sizeofDim.size() == node.dims) bottomBaseType = node.elementType.getBaseType();
        else bottomBaseType = new PointerType(node.elementType.getBaseType(), node.dims-node.sizeofDim.size());
        for (int i = 0 ; i < node.sizeofDim.size() ; i++) {
            node.sizeofDim.get(i).accept(this);
            if (node.sizeofDim.get(i).isLvalue()) {
                indexValue = new VirtualReg(new IntType(32), currentFunction.takeLabel());
                currentBlock.append(new LoadInst((VirtualReg) indexValue, node.sizeofDim.get(i).address));
            } else indexValue = node.sizeofDim.get(i).value;
            sizes.add(indexValue);
        }
        thisReg = multiAllocate(node, bottomBaseType, sizes,0);
        thisStoreReg = new VirtualReg(new PointerType(thisReg.baseType), currentFunction.takeLabel());
        currentBlock.append(new AllocaInst(thisStoreReg));
        currentBlock.append(new StoreInst(thisReg, thisStoreReg));
        node.address = thisStoreReg;
        node.imm = null;
    }

    private VirtualReg multiAllocate(NewArrayNode node, BaseType bottomBaseType, ArrayList<Oprand> sizes, int depth) {
        // constant optimize
        ArrayList<Oprand> mallocArgs = new ArrayList<>();
        Oprand indexSize, byteSize, arraySize, mallocSize;
        VirtualReg mallocReg, sizeReg, arrayReg, thisReg, iterStoreReg, iterReg, iterLoadReg, iterPlusReg, condReg, indexPtrReg, elementReg;
        BasicBlock rootBlock, condBlock, exeHeadBlock, exeTailBlock, increBlock, exitBlock;
        BaseType depthBaseType = depth == node.sizeofDim.size()-1 ? bottomBaseType : new PointerType(bottomBaseType, node.sizeofDim.size()-1-depth);
        byteSize = new ConstInt(32, depthBaseType.getByteWidth());
        indexSize = sizes.get(depth);
        if (indexSize instanceof ConstInt) arraySize = new ConstInt(32, ((ConstInt) byteSize).intValue*((ConstInt)indexSize).intValue);
        else {
            arraySize = new VirtualReg(new IntType(32), currentFunction.takeLabel());
            currentBlock.append(new BinaryInst((VirtualReg) arraySize, BinaryInst.BiArOp.mul, indexSize, byteSize));
        }
        mallocSize = new VirtualReg(new IntType(32), currentFunction.takeLabel());
        currentBlock.append(new BinaryInst((VirtualReg) mallocSize, BinaryInst.BiArOp.add, arraySize, new ConstInt(32, 4)));
        mallocArgs.add(mallocSize);
        mallocReg = new VirtualReg(new PointerType(new IntType(8)), currentFunction.takeLabel());
        currentBlock.append(new CallInst(mallocReg, root.malloc, mallocArgs));
        sizeReg = new VirtualReg(new PointerType(new IntType(32)), currentFunction.takeLabel());
        currentBlock.append(new BitCastInst(mallocReg, sizeReg));
        currentBlock.append(new StoreInst(sizes.get(depth), sizeReg));
        arrayReg = new VirtualReg(new PointerType(new IntType(8)), currentFunction.takeLabel());
        currentBlock.append(new GetElementPtrInst(arrayReg, mallocReg, new ConstInt(32, 4)));   // 4-byte to store size
        thisReg = new VirtualReg(new PointerType(depthBaseType), currentFunction.takeLabel());
        currentBlock.append(new BitCastInst(arrayReg, thisReg));
        if (depth == node.sizeofDim.size()-1)  return thisReg;
        // make loop
        iterStoreReg = new VirtualReg(new PointerType(new IntType(32)), currentFunction.takeLabel());
        currentBlock.append(new AllocaInst(iterStoreReg));
        currentBlock.append(new StoreInst(new ConstInt(32, 0), iterStoreReg));
        rootBlock = currentBlock;
        condBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
        currentBlock.next = condBlock;
        currentBlock = currentBlock.next;
        iterReg = new VirtualReg(new IntType(32), currentFunction.takeLabel());
        currentBlock.append(new LoadInst(iterReg, iterStoreReg));
        condReg = new VirtualReg(new IntType(1), currentFunction.takeLabel());
        exeHeadBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
        currentBlock.next = exeHeadBlock;
        currentBlock = currentBlock.next;
        elementReg = multiAllocate(node, bottomBaseType, sizes, depth+1);
        exeTailBlock = currentBlock;
        indexPtrReg = new VirtualReg(new PointerType(depthBaseType), currentFunction.takeLabel());
        currentBlock.append(new GetElementPtrInst(indexPtrReg, thisReg, iterReg));
        currentBlock.append(new StoreInst(elementReg, indexPtrReg));
        increBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
        currentBlock.next = increBlock;
        currentBlock = currentBlock.next;
        iterLoadReg = new VirtualReg(new IntType(32), currentFunction.takeLabel());
        currentBlock.append(new LoadInst(iterLoadReg, iterStoreReg));
        iterPlusReg = new VirtualReg(new IntType(32), currentFunction.takeLabel());
        currentBlock.append(new BinaryInst(iterPlusReg, BinaryInst.BiArOp.add, iterReg, new ConstInt(32, 1)));
        currentBlock.append(new StoreInst(iterPlusReg, iterStoreReg));
        exitBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
        currentBlock.next = exitBlock;
        currentBlock = currentBlock.next;
        rootBlock.append(new JumpInst(condBlock));
        condBlock.append(new IcmpInst(condReg, IcmpInst.CompareType.slt, iterReg, indexSize));
        condBlock.append(new BrInst(condReg, exeHeadBlock, exitBlock));
        exeTailBlock.append(new JumpInst(increBlock));
        increBlock.append(new JumpInst(condBlock));
        return thisReg;
    }


    @Override public void visit(FuncValNode node) {
        Function callFunction;
        VirtualReg resultReg;
        ArrayList<Oprand> arguments = new ArrayList<>();
        if (currentClass != null) {
            callFunction = root.getCustomFunction(currentClass.className+"."+node.name);    // try inner function
            if (callFunction == null) callFunction = root.getFunction(node.name);                 // try global function
            else arguments.add(currentFunction.args.get(0));        // get inner function, add first argument:
        } else callFunction = root.getFunction(node.name);          // get global function
        if (callFunction == null) throw new irError("[ERROR] function not found", node.pos);
        node.exprList.accept(this);
        arguments.addAll(node.exprList.oprands);
        resultReg = callFunction.isVoid() ? null : new VirtualReg(callFunction.retType, currentFunction.takeLabel());
        currentBlock.append(new CallInst(resultReg, callFunction, arguments));
        node.address = null;
        node.imm = resultReg;
    }

    @Override public void visit(LambdaValNode node) {
        // none
    }

    @Override public void visit(ThisValNode node) {
        VirtualReg thisStoreReg = currentScope.getVarReg("this", true, currentBlock, currentFunction);
        VirtualReg thisReg = new VirtualReg(new PointerType(new ClassType(currentClass.className)), currentFunction.takeLabel());
        currentBlock.append(new LoadInst(thisReg, thisStoreReg));
        node.address = null;
        node.imm = thisReg;
        // TODO: 2021/12/14  'this' is RVALUE type, using 'this' in CallExprNode will cause fatal ERROR!
    }

    @Override public void visit(ParaListNode node) {
        if (preCheck) {
            if (currentClass != null) currentFunction.appendArgument(new PointerType(new ClassType(currentClass.className)));
            for (TypeNode typeNode : node.para) {
                typeNode.accept(this);
                typeNode.accept(this);
                currentFunction.appendArgument(typeNode.baseType);
            }
        }
        else {
            VirtualReg argReg;
            int index = 0;
            if (currentClass != null){
                argReg = new VirtualReg(new PointerType(new ClassType(currentClass.className), 2), currentFunction.takeLabel());
                currentBlock.append(new AllocaInst(argReg));
                currentBlock.append(new StoreInst(currentFunction.args.get(0), argReg));
                currentScope.defineVar("this", argReg); // thisStoreReg
                index++;
            }
            for ( ; index < currentFunction.args.size() ; index++) {
                argReg = new VirtualReg(new PointerType(currentFunction.args.get(index).baseType), currentFunction.takeLabel());
                currentBlock.append(new AllocaInst(argReg));
                currentBlock.append(new StoreInst(currentFunction.args.get(index), argReg));
                if (currentClass != null) currentScope.defineVar(node.ids.get(index-1), argReg);
                else currentScope.defineVar(node.ids.get(index), argReg);
            }
        }
    }

    @Override public void visit(ExprListNode node) {
        Oprand exprValue;
        for (ExprNode expr : node.exprs) {
            expr.accept(this);
            if (expr.isLvalue()) {
                exprValue = new VirtualReg(expr.getValueType(), currentFunction.takeLabel());
                currentBlock.append(new LoadInst((VirtualReg) exprValue, expr.address));
            } else exprValue = expr.value;
            node.oprands.add(exprValue);
        }
    }

    @Override public void visit(BlockNode node) {
        currentScope = new IRScope(currentScope);
        for (StmtNode stmtNode : node.stmts)
            if (!currentBlock.hasTerminal) stmtNode.accept(this);
        currentScope = currentScope.getParent();
    }
}
