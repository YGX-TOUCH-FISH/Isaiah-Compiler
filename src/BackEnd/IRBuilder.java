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
import Util.error.semanticError;
import Util.scope.IRScope;

import java.util.ArrayList;

//class member: add to type
public class IRBuilder implements ASTVisitor {
    IRModule   root = null;
    IRScope    currentScope = null;
    Function   currentFunction = null;
    BasicBlock currentBlock = null;
    ClassType  currentClass = null;
    boolean    preCheck = false;
    Function   globalVarInit = null;
    public IRBuilder() {
        root = new IRModule();
    }
    public IRModule BuiltRoot() { return root; }

    @Override public void visit(RootNode node) {
        currentScope = new IRScope(currentScope);
        // pre-stage
        preCheck = true;
        for (DeclrNode declare : node.declrs) {
            if (declare instanceof FuncDeclrNode) declare.accept(this);
        }
        for (DeclrNode declare : node.declrs) {
            if (declare instanceof ClassDeclrNode) {
                currentClass = new ClassType(((ClassDeclrNode) declare).name);
                for (DeclrNode memberDeclr : ((ClassDeclrNode) declare).declrs) {
                    if (memberDeclr instanceof FuncDeclrNode)  memberDeclr.accept(this);
                }
                currentClass = null;
            }
        }
        globalVarInit   = new Function("global_var_init", new VoidType());
        currentFunction = globalVarInit;
        for (DeclrNode declare : node.declrs) {
            if (declare instanceof AssignDeclrNode || declare instanceof ListDeclrNode) declare.accept(this);
        }
        currentFunction = null;
        if (!globalVarInit.isEmpty()) root.addCustomFunction(globalVarInit);

        for (DeclrNode declare : node.declrs) {
            ConstructDeclrNode constructor = null;
            if (declare instanceof ClassDeclrNode) {
                root.addCustomClass(((ClassDeclrNode) declare).name);
                currentClass    = new ClassType(((ClassDeclrNode) declare).name);
                currentFunction = new Function(currentClass.className, new VoidType());
                currentFunction.appendArgument(new PointerType(new ClassType(currentClass.className)));
                currentBlock    = currentFunction.getEntry();
                currentScope    = new IRScope(currentScope);

                for (DeclrNode memberDeclr :  ((ClassDeclrNode) declare).declrs) {
                    if (memberDeclr instanceof ConstructDeclrNode) constructor = (ConstructDeclrNode) declare;
                    if (memberDeclr instanceof AssignDeclrNode || memberDeclr instanceof ListDeclrNode) declare.accept(this);
                }
                if (constructor != null) constructor.accept(this);
                if (!currentFunction.isEmpty()) root.addCustomFunction(currentFunction);

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
        currentScope = new IRScope(currentScope);
        currentClass = new ClassType(node.name);
        for (DeclrNode declare : node.declrs) declare.accept(this);
        currentClass = null;
        currentScope = currentScope.getParent();
    }

    @Override public void visit(ConstructDeclrNode node) {
        if (!preCheck) return;
        node.block.accept(this);
    }

    @Override public void visit(EmptyDeclrNode node) {}

    @Override public void visit(FuncDeclrNode node) {
        String name = currentClass != null ? currentClass.className+"."+node.name : node.name;
        if (preCheck) {
            node.retType.accept(this);
            currentFunction = new Function(name, node.retType.baseType);
            node.paraList.accept(this); // append args
            root.addCustomFunction(currentFunction);
            currentFunction = null;
        }
        else {
            currentScope    = new IRScope(currentScope);
            currentFunction = root.getCustomFunction(name);
            currentBlock    = currentFunction.getEntry();
            node.block.accept(this);
            currentBlock    = null;
            currentFunction = null;
            currentScope    = currentScope.getParent();
        }
    }

    @Override public void visit(AssignDeclrNode node) { //static or class member
        if (!preCheck) return;
        node.typeNode.accept(this);
        node.valueNode.accept(this);    // no forward reference
        Oprand load;
        VirtualReg ptrReg, srcReg, defReg;
        if (node.valueNode.isLvalue()) {
            load = new VirtualReg(node.valueNode.getValueType(), currentFunction.takeLabel());
            currentBlock.append(new LoadInst((VirtualReg) load, node.valueNode.address));
        }
        else load = node.valueNode.value;
        // TODO: 2021/12/10 why fixed 3? try 2...
        if (currentClass != null) {  // member declare, don't add to currentScope
            root.appendClassMember(currentClass.className, node.typeNode.baseType, node.id);
            ptrReg = new VirtualReg(new PointerType(node.typeNode.baseType), currentFunction.takeLabel());
            srcReg = new VirtualReg(new PointerType(new ClassType(currentClass.className)), 3);
            currentBlock.append(new GetElementPtrInst(ptrReg, srcReg, new ConstInt(32, root.getClassMemberIndex(currentClass.className, node.id))));
            currentBlock.append(new StoreInst(load, ptrReg));
        }
        else {  //global declare
            defReg = new VirtualReg(new PointerType(node.valueNode.getValueType()), node.id);
            currentBlock.append(new StoreInst(load, defReg));
            currentScope.defineVar(node.id, defReg);
            root.addStaticData(node.id, node.valueNode.getValueType()); // add global declare
        }
    }

    @Override public void visit(ListDeclrNode node) {
        if (!preCheck) return;
        node.typeNode.accept(this);
        if (currentClass != null)
            for (String id : node.ids) root.appendClassMember(currentClass.className, node.typeNode.baseType, id);
        else {
            for (String id : node.ids) {
                VirtualReg defReg = new VirtualReg(new PointerType(node.typeNode.baseType), id);
                currentScope.defineVar(id, defReg);
                ArrayList<Oprand> args = new ArrayList<>(); args.add(defReg);
                if (node.typeNode.baseType instanceof ClassType) {
                    ClassType classType  = (ClassType) node.typeNode.baseType;
                    Function constructor = root.getCustomFunction(classType.className);
                    currentBlock.append(new CallInst(null, constructor, args));
                }
                root.addStaticData(id, node.typeNode.baseType);
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
        node.baseType = new ClassType(node.name);
    }
    @Override public void visit(ArrayTypeNode node) {
        node.elementType.accept(this);
        node.baseType = new PointerType(node.elementType.baseType);
    }

    @Override public void visit(EmptyStNode node) {}

    @Override public void visit(AssignStNode node) {    //dynamic
        node.valueNode.accept(this);
        VirtualReg loadReg, allocReg;
        if (node.valueNode.isLvalue()) {
            loadReg = new VirtualReg(node.valueNode.getValueType(), currentFunction.takeLabel());
            currentBlock.append(new LoadInst(loadReg, node.valueNode.address));
            allocReg = new VirtualReg(new PointerType(node.valueNode.getValueType()), currentFunction.takeLabel());
            currentScope.defineVar(node.name, allocReg);
            currentBlock.append(new AllocaInst(allocReg));
            currentBlock.append(new StoreInst(loadReg, allocReg));
        }
        else {
            allocReg = new VirtualReg(new PointerType(node.valueNode.getValueType()), currentFunction.takeLabel());
            currentScope.defineVar(node.name, allocReg);
            currentBlock.append(new AllocaInst(allocReg));
            currentBlock.append(new StoreInst(node.valueNode.value, allocReg));
        }
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
        VirtualReg condReg = new VirtualReg(new IntType(1), currentFunction.takeLabel());
        Oprand left, right;
        if (node.condition.isLvalue()) {
            left = new VirtualReg(node.condition.getValueType(), currentFunction.takeLabel());
            currentBlock.append(new LoadInst((VirtualReg) left, node.condition.address));
        } else left = node.condition.value;
        right = new ConstInt(32, 0);

        if (left instanceof ConstInt) {                 // constant optimize
            if (((ConstInt)left).getIntValue() == 0) {  // false condition
                if (node.elseStmt != null) node.elseStmt.accept(this);
            } else node.ifStmt.accept(this);
            return;
        }
        currentBlock.append(new IcmpInst(condReg, IcmpInst.CompareType.ne, left, right));
        ifHeadBlock   = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
        currentBlock.next = ifHeadBlock;
        rootBlock    = currentBlock;
        currentBlock = ifHeadBlock;
        node.ifStmt.accept(this);
        ifTailBlock  = currentBlock;
        if (node.elseStmt != null) {
            elseHeadBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
            currentBlock.next = elseHeadBlock;

            currentBlock = elseHeadBlock;
            rootBlock.append(new BrInst(condReg, ifHeadBlock, elseHeadBlock));
            node.elseStmt.accept(this);
            elseTailBlock = currentBlock;
            exitBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
            currentBlock.next = exitBlock;

            ifTailBlock.append(new JumpInst(exitBlock));
            elseTailBlock.append(new JumpInst(exitBlock));
        }
        else {
            exitBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
            currentBlock.next = exitBlock;
            rootBlock.append(new BrInst(condReg, ifHeadBlock, exitBlock));
            ifTailBlock.append(new JumpInst(exitBlock));
        }
        currentBlock = exitBlock;
        // TODO: 2021/12/11 scope problem
    }

    @Override public void visit(ForInitNode node) {
        for (ExprNode expr : node.exprs) expr.accept(this);
    }

    @Override public void visit(ForStNode node) {
        if (node.init != null) node.init.accept(this);
        BasicBlock rootBlock, condBlock;
        rootBlock = currentBlock;
        condBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
        currentBlock.next = condBlock;
        currentBlock = currentBlock.next;
// TODO: 2021/12/12 not finish yet
    }

    @Override public void visit(WhileStNode node) {
        BasicBlock condHeadBlock, condTailBlock, exeHeadBlock, exeTailBlock, exitBlock;
        Oprand condValue;  VirtualReg condReg;
        condHeadBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
        currentBlock.append(new JumpInst(condHeadBlock));
        currentBlock.next = condHeadBlock;
        currentBlock = currentBlock.next;
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
        currentBlock.next = exeHeadBlock;
        currentBlock = currentBlock.next;
        node.stmt.accept(this);
        exeTailBlock = currentBlock;
        exitBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
        condTailBlock.append(new BrInst(condReg, exeHeadBlock, exitBlock));
        exeTailBlock.append(new JumpInst(exitBlock));
        // TODO: 2021/12/12 condition: zero extend i1 to i32?
    }

    @Override public void visit(BreakStNode node) {

    }

    @Override public void visit(RetStNode node) {

    }

    @Override public void visit(ContinStNode node) {

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

    @Override public void visit(IndexExprNode node) {
        node.array.accept(this);    // lvalue
        node.index.accept(this);    // l or r
        VirtualReg arrayReg, indexReg, ptrReg;
        Oprand offset;
        // get array
        if (node.array.getValueType() instanceof PointerType) {
            arrayReg = new VirtualReg(node.array.getValueType(), currentFunction.takeLabel());
            currentBlock.append(new LoadInst(arrayReg, node.array.address));
        }
        else if (node.array.getValueType() instanceof ArrayType) {
            ArrayType arrayType = (ArrayType) node.array.getValueType();
            arrayReg = new VirtualReg(new PointerType(arrayType.elementType), currentFunction.takeLabel());
            currentBlock.append(new LoadInst(arrayReg, node.array.address));
        }
        else throw new irError("[ERROR] array must be array-type or pointer-type: ", node.pos);
        // get index
        if (node.index.isLvalue()) {
            indexReg = new VirtualReg(new PointerType(node.index.getValueType()), currentFunction.takeLabel());
            currentBlock.append(new LoadInst(indexReg, node.index.address));
            offset  = new VirtualReg(new PointerType(new IntType(64)), currentFunction.takeLabel());
            currentBlock.append(new UnaryInst((VirtualReg) offset, UnaryInst.UArOp.sext, indexReg, new IntType(64)));
        }
        else offset = node.index.value;
        // get element
        if (node.array.getValueType() instanceof PointerType) {
            ptrReg = new VirtualReg(node.array.getValueType(), currentFunction.takeLabel());
        }
        else {
            ArrayType arrayType = (ArrayType) node.array.getValueType();
            ptrReg = new VirtualReg(new PointerType(arrayType.elementType), currentFunction.takeLabel());
        }
        currentBlock.append(new GetElementPtrInst(ptrReg, arrayReg, offset));
        node.address = ptrReg;
        node.value   = null;
    }

    @Override public void visit(CallExprNode node) {    // node must be lvalue
        node.object.accept(this);
        if (node.exprList == null) {
            BaseType memberBaseType = root.getClassMemberBaseType(node.object.type.name, node.memberID);
            VirtualReg ptrReg = new VirtualReg(new PointerType(memberBaseType), currentFunction.takeLabel());
            Oprand offset = new ConstInt(32, root.getClassMemberIndex(node.object.type.name, node.memberID));
            currentBlock.append(new GetElementPtrInst(ptrReg, node.object.address, offset));
            node.address = ptrReg;
            node.value   = null;
        }
        else {  // function call
            Function function; VirtualReg resultReg ; ArrayList<Oprand> functionArgs;
            node.exprList.accept(this);
            functionArgs = new ArrayList<>(node.exprList.oprands);
            if (node.object.getValueType() instanceof ClassType) {
                functionArgs.add(0, node.object.address);       // add 'this' pointer
                String className = ((ClassType) node.object.getValueType()).className;
                function = root.getCustomFunction(className+"."+node.memberID);
                } else function = root.getBuiltInFunction(node.memberID);
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
            currentBlock.append(new LoadInst((VirtualReg) load, node.address));
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
                    result = load;
                    break;
                case NEG:
                    result = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
                    currentBlock.append(new BinaryInst((VirtualReg) result, BinaryInst.BiArOp.sub, new ConstInt(32, 0), load));
                    break;
                default:
                    throw new irError("[ERROR] reaching unknown unary-arith operator: ", node.pos);
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
                            result = new VirtualReg(new PointerType(new IntType(8), 2), currentFunction.takeLabel());
                            ArrayList<Oprand> args = new ArrayList<>();
                            args.add(left); args.add(right);
                            currentBlock.append(new CallInst((VirtualReg) result, root.strADD, args));
                        }
                        break;
                    case LT: case GT: case LEQ: case GEQ:
                        result = new VirtualReg(new IntType(1), currentFunction.takeLabel());
                        if (node.lhs.getValueType() instanceof IntType) { // int cmp
                            currentBlock.append(new IcmpInst((VirtualReg) result, compareType, left, right));
                        }
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
                        if (node.lhs.getValueType() instanceof IntType) {
                            result = new VirtualReg(new IntType(1), currentFunction.takeLabel());
                            currentBlock.append(new IcmpInst((VirtualReg) result, compareType, left, right));
                        }
                        else {  // compare address
                            Oprand leftAddress  = (left instanceof ConstNull) ? left : new VirtualReg(new PointerType(new IntType(8)), currentFunction.takeLabel());
                            Oprand rightAddress = (left instanceof ConstNull) ? right: new VirtualReg(new PointerType(new IntType(8)),currentFunction.takeLabel());
                            if (!(left instanceof ConstNull)) {
                                currentBlock.append(new BitCastInst((VirtualReg) left, (VirtualReg) leftAddress));
                            }
                            if (!(right instanceof ConstNull)) {
                                currentBlock.append(new BitCastInst((VirtualReg) right, (VirtualReg) rightAddress));
                            }
                            result = new VirtualReg(new IntType(1), currentFunction.takeLabel());
                            currentBlock.append(new IcmpInst((VirtualReg) result, compareType, leftAddress, rightAddress));
                        }
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
                        else {
                            String leftStr = ((ConstStr) node.lhs.value).str, rightStr = ((ConstStr) node.rhs.value).str;
                            result = new ConstStr(leftStr+rightStr);
                        }
                        break;
                    case LT: case GT: case LEQ: case GEQ:
                        long l, r;
                        if (node.lhs.getValueType() instanceof IntType) {
                            l = ((ConstInt)node.lhs.value).getIntValue();
                            r = ((ConstInt)node.rhs.value).getIntValue();
                        }
                        else {
                            l = ((ConstStr)node.lhs.value).str.length();
                            r = ((ConstStr) node.rhs.value).str.length();
                        }
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
                IcmpInst.CompareType cmpType     = node.op == BinaryExprNode.BinaryOp.ANDAND ? IcmpInst.CompareType.ne : IcmpInst.CompareType.eq;
                BinaryInst.BiArOp resultArithOp  = node.op == BinaryExprNode.BinaryOp.ANDAND ? BinaryInst.BiArOp.and   : BinaryInst.BiArOp.or;

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
                        currentBlock.append(new IcmpInst((VirtualReg) result, cmpType, right, new ConstInt(1, 0)));
                        node.value = result;
                    }
                    node.address = null;
                    return;
                }
                firstValue = new VirtualReg(new IntType(1), currentFunction.takeLabel());
                currentBlock.append(new IcmpInst(firstValue, cmpType, left, new ConstInt(1, 0)));
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
                currentBlock.append(new IcmpInst(secondValue, cmpType, right, new ConstInt(1, 0)));
                resultBlock = new BasicBlock(currentBlock, null, currentFunction.takeLabel());
                currentBlock.append(new JumpInst(resultBlock));                     //   supply branch inst for root and alter
                rootBlock.append(new BrInst(firstValue, resultBlock, alterBlock));
                currentBlock.next = resultBlock;
                currentBlock = currentBlock.next;
                // result calculate.
                result = new VirtualReg(new IntType(1), currentFunction.takeLabel());
                currentBlock.append(new BinaryInst((VirtualReg) result, resultArithOp, firstValue, secondValue));
            }
        }
        node.address = node.op == BinaryExprNode.BinaryOp.ASSIGN ? node.lhs.address : null;
        node.value   = node.op == BinaryExprNode.BinaryOp.ASSIGN ? null : result;
    }

    @Override public void visit(PrefixExprNode node) { //must be lvalue
        node.rhs.accept(this);
        VirtualReg loadReg, resultReg;
        loadReg = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
        currentBlock.append(new LoadInst(loadReg, node.rhs.address));
        resultReg = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
        currentBlock.append(new BinaryInst(resultReg, BinaryInst.BiArOp.add, loadReg, new ConstInt(32, 1)));
        currentBlock.append(new StoreInst(resultReg, node.rhs.address));
        node.address = node.rhs.address;
        node.value   = null;
    }

    @Override public void visit(SuffixExprNode node) {
        node.lhs.accept(this);
        VirtualReg loadReg, resultReg;
        loadReg = new VirtualReg(node.lhs.getValueType(), currentFunction.takeLabel());
        currentBlock.append(new LoadInst(loadReg, node.lhs.address));
        resultReg = new VirtualReg(node.lhs.getValueType(), currentFunction.takeLabel());
        currentBlock.append(new BinaryInst(resultReg, BinaryInst.BiArOp.add, loadReg, new ConstInt(32, 1)));
        currentBlock.append(new StoreInst(resultReg, node.lhs.address));
        node.address = null;
        node.value   = loadReg;
    }

    @Override public void visit(VariValNode node) {
        if (currentClass != null && root.classContainsMember(currentClass.className, node.name)) {
            Oprand thisPointer, offsetImm; VirtualReg memberAddress;
            thisPointer = currentFunction.args.get(0);
            memberAddress = new VirtualReg(root.getClassMemberBaseType(currentClass.className, node.name), currentFunction.takeLabel());
            offsetImm = new ConstInt(32, root.getClassMemberIndex(currentClass.className, node.name));
            currentBlock.append(new GetElementPtrInst(memberAddress, thisPointer, offsetImm));
            node.address = memberAddress;
        } else node.address = currentScope.getVarReg(node.name, true);
        node.imm = null;
    }

    @Override public void visit(IntValNode node) {
        node.address = null;
        node.imm     = new ConstInt(32, node.intValue);
    }

    @Override public void visit(StringValNode node) {
        node.address = null;
        node.imm     = new ConstStr(node.strValue);
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
        for (ExprNode size : node.sizeofDim) {
            size.accept(this);
            if (!(size.getValueType() instanceof IntType)) {
                throw new irError("[ERROR] array space must be allocated over integer: ", node.pos);
            }
        }
        BaseType baseType = node.elementType.getBaseType();
        if (node.sizeofDim.size() != node.dims) baseType = new PointerType(baseType, node.dims-node.sizeofDim.size());
        // TODO: 2021/12/11 not finish yet
    }

    @Override public void visit(FuncValNode node) {
        // TODO: 2021/12/11 not finish yet: what about inner call in class?
        node.exprList.accept(this);
        Function callFunction;
        VirtualReg resultReg;
        ArrayList<Oprand> arguments = new ArrayList<>();
        if (currentClass != null) {
            callFunction = root.getCustomFunction(currentClass.className+"."+node.name);
            if (callFunction == null) callFunction = root.getFunction(node.name);
            else arguments.add(currentFunction.args.get(0));        // get inner function, add first argument:
        }
        else callFunction = root.getFunction(node.name);
        node.exprList.accept(this);
        arguments.addAll(node.exprList.oprands);
        if (callFunction == null)
            throw new irError("[ERROR] function not found", node.pos);
        resultReg = callFunction.isVoid() ? new VirtualReg(callFunction.retType, currentFunction.takeLabel()) : null;
        currentBlock.append(new CallInst(resultReg, callFunction, arguments));
        node.address = null;
        node.imm     = resultReg != null ? resultReg : new ConstNull();
    }

    @Override public void visit(LambdaValNode node) {}  // none

    @Override public void visit(ThisValNode node) {
        VirtualReg self = new VirtualReg(new ClassType(currentClass.className), currentFunction.takeLabel());
        VirtualReg thisPointer = currentFunction.args.get(0);
        currentBlock.append(new LoadInst(self, thisPointer));
        node.address = null;
        node.imm     = self;
    }

    @Override public void visit(ParaListNode node) {    // only in pre-stage
        if (currentClass != null) currentFunction.appendArgument(new PointerType(new ClassType(currentClass.clas        sName)));
        for (TypeNode typeNode : node.para) {
            typeNode.accept(this);
            currentFunction.appendArgument(typeNode.baseType);
        }
    }

    @Override public void visit(ExprListNode node) {
        for (ExprNode expr : node.exprs) {
            expr.accept(this);
            if (expr.isLvalue()) node.oprands.add(expr.address);
            else node.oprands.add(expr.value);
        }
    }


    @Override public void visit(BlockNode node) {
        currentScope = new IRScope(currentScope);
        for (StmtNode stmtNode : node.stmts) stmtNode.accept(this);
        currentScope = currentScope.getParent();
    }
}
