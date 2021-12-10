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
import LLVMIR.Function;
import LLVMIR.IRModule;
import LLVMIR.Inst.*;
import LLVMIR.Oprand.*;
import LLVMIR.Type.*;
import Util.error.irError;
import Util.scope.IRScope;

import java.util.ArrayList;

//class member: add to type
public class IRBuilder implements ASTVisitor {
    IRModule   root = null;
    IRScope    currentScope = null;
    Function   currentFunction = null;
    ClassType  currentClass = null;
    boolean    classCheck = false;
    boolean    memberCheck = false;
    boolean    constructCheck = false;
    Function   globalVarInit = null;
    public IRBuilder() {}
    public IRModule BuiltRoot() { return root; }

    @Override public void visit(RootNode node) {
        root = new IRModule();
        currentScope = new IRScope(currentScope);
        globalVarInit = new Function("global_var_init", new VoidType(), null);
        // class constructor && global initializer
        for (DeclrNode declare : node.declrs) {
            if (declare instanceof ClassDeclrNode) {
                classCheck = true;
                declare.accept(this);
                classCheck = false;
            }
            else if ((declare instanceof AssignDeclrNode) || (declare instanceof ListDeclrNode)) {
                currentFunction = globalVarInit;
                declare.accept(this);
                currentFunction = null;
            }
        }
        if (!globalVarInit.isEmpty()) root.addCustomFunction(globalVarInit);
        for (DeclrNode declare : node.declrs)  declare.accept(this);
        currentScope = currentScope.getParent();
    }

    @Override public void visit(ClassDeclrNode node) {
        ConstructDeclrNode constructor = null;
        currentScope = new IRScope(currentScope);
        currentClass = new ClassType(node.name);
        if (classCheck) {
            root.addCustomClass(node.name);
            ArrayList<BaseType> args = new ArrayList<>(); args.add(new PointerType(new ClassType(node.name)));
            currentFunction = new Function(currentClass.className, new VoidType(), args);
            for (DeclrNode declare : node.declrs) {
                if (declare instanceof ConstructDeclrNode) constructor = (ConstructDeclrNode) declare;
                else if (declare instanceof AssignDeclrNode || declare instanceof ListDeclrNode)  {
                    memberCheck = true; declare.accept(this); memberCheck = false;
                }
            }
            if  (constructor != null) { constructCheck = true; constructor.accept(this); constructCheck = false; }
            if  (!currentFunction.isEmpty()) root.addCustomFunction(currentFunction);
            currentFunction = null;
        }
        else {
            for (DeclrNode declare : node.declrs) declare.accept(this);
        }
        currentClass = null;
        currentScope = currentScope.getParent();
    }

    @Override public void visit(ConstructDeclrNode node) {
        if (constructCheck) node.block.accept(this);
    }

    @Override public void visit(EmptyDeclrNode node) {}

    @Override public void visit(FuncDeclrNode node) {
        String _name = node.name;
        ArrayList<BaseType> _argsType = new ArrayList<>();
        if (currentClass != null)  {
            _name = currentClass.className+"."+node.name;
            _argsType.add(new PointerType(new ClassType(currentClass.className)));
        }
        node.retType.accept(this);

        currentScope = new IRScope(currentScope);
        currentFunction = new Function(_name, node.retType.baseType, _argsType);
        node.paraList.accept(this); // append other args, alloc variable from now
        node.block.accept(this);
        root.addCustomFunction(currentFunction);
        currentFunction = null;
        currentScope = currentScope.getParent();
    }

    @Override public void visit(AssignDeclrNode node) { //static or class member
        node.typeNode.accept(this);
        node.valueNode.accept(this);    // no forward reference
        Oprand load;
        VirtualReg ptrReg, srcReg, defReg;
        if (node.valueNode.isLvalue()) {
            load = new VirtualReg(node.valueNode.getValueType(), currentFunction.takeLabel());
            currentFunction.append(new LoadInst((VirtualReg) load, node.valueNode.address));
        }
        else load = node.valueNode.value;
        // TODO: 2021/12/10 why fixed 3? try 2...
        if (memberCheck) {  // member declare
            root.appendClassMember(currentClass.className, node.typeNode.baseType, node.id);
            ptrReg = new VirtualReg(new PointerType(node.typeNode.baseType), currentFunction.takeLabel());
            srcReg = new VirtualReg(new PointerType(new ClassType(currentClass.className)), 3);
            currentFunction.append(new GetElementPtrInst(ptrReg, srcReg, new ConstInt(32, root.getClassMemberIndex(currentClass.className, node.id))));
            currentFunction.append(new StoreInst(load, ptrReg));
        }
        else {  //global declare
            defReg = new VirtualReg(new PointerType(node.valueNode.getValueType()), node.id);
            currentFunction.append(new StoreInst(load, defReg));
            currentScope.defineVar(node.id, defReg);
            root.addStaticData(node.id, node.valueNode.getValueType());
        }
    }

    @Override public void visit(ListDeclrNode node) {
        node.typeNode.accept(this);
        if (memberCheck) {
            for (String id : node.ids) {
                root.appendClassMember(currentClass.className, node.typeNode.baseType, id);
            }
        }
        else {
            for (String id : node.ids) {
                VirtualReg defReg = new VirtualReg(new PointerType(node.typeNode.baseType), id);
                currentFunction.append(new StoreInst(node.typeNode.baseType.getZeroInit(), defReg));
                currentScope.defineVar(id, defReg);
                root.addStaticData(id, node.typeNode.baseType);
            }
        }
        //for array, transfer into:
        //     @x = common dso_local global i32 ** null;
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
            currentFunction.append(new LoadInst(loadReg, node.valueNode.address));
            allocReg = new VirtualReg(new PointerType(node.valueNode.getValueType()), currentFunction.takeLabel());
            currentScope.defineVar(node.name, allocReg);
            currentFunction.append(new AllocaInst(allocReg));
            currentFunction.append(new StoreInst(loadReg, allocReg));
        }
        else {
            allocReg = new VirtualReg(new PointerType(node.valueNode.getValueType()), currentFunction.takeLabel());
            currentScope.defineVar(node.name, allocReg);
            currentFunction.append(new AllocaInst(allocReg));
            currentFunction.append(new StoreInst(node.valueNode.value, allocReg));
        }
    }

    @Override public void visit(ListStNode node) {
        node.type.accept(this);
        for (String id : node.ids) {
            VirtualReg allocReg = new VirtualReg(new PointerType(node.type.baseType), currentFunction.takeLabel());
            currentScope.defineVar(id, allocReg);
            currentFunction.append(new AllocaInst(allocReg));
        }
    }

    @Override public void visit(ExprStNode node) {
        node.expr.accept(this);
    }

    @Override public void visit(CondStNode node) {

    }

    @Override
    public void visit(ForStNode node) {

    }

    @Override
    public void visit(WhileStNode node) {

    }

    @Override
    public void visit(BreakStNode node) {

    }

    @Override
    public void visit(RetStNode node) {

    }

    @Override
    public void visit(ContinStNode node) {

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
            currentFunction.append(new LoadInst(arrayReg, node.array.address));
        }
        else if (node.array.getValueType() instanceof ArrayType) {
            ArrayType arrayType = (ArrayType) node.array.getValueType();
            arrayReg = new VirtualReg(new PointerType(arrayType.elementType), currentFunction.takeLabel());
            currentFunction.append(new LoadInst(arrayReg, node.array.address));
        }
        else {
            throw new irError("[ERROR] array must be array-type or pointer-type: ", node.pos);
        }
        // get index
        if (node.index.isLvalue()) {
            indexReg = new VirtualReg(new PointerType(node.index.getValueType()), currentFunction.takeLabel());
            currentFunction.append(new LoadInst(indexReg, node.index.address));
            offset  = new VirtualReg(new PointerType(new IntType(64)), currentFunction.takeLabel());
            currentFunction.append(new UnaryInst((VirtualReg) offset, UnaryInst.UArOp.sext, indexReg, new IntType(64)));
        }
        else {
            offset = node.index.value;
        }
        // get element
        if (node.array.getValueType() instanceof PointerType) {
            ptrReg = new VirtualReg(node.array.getValueType(), currentFunction.takeLabel());
        }
        else {
            ArrayType arrayType = (ArrayType) node.array.getValueType();
            ptrReg = new VirtualReg(new PointerType(arrayType.elementType), currentFunction.takeLabel());
        }
        currentFunction.append(new GetElementPtrInst(ptrReg, arrayReg, offset));

        node.address = ptrReg;
        node.value   = null;
    }

    @Override public void visit(CallExprNode node) {    // node must be lvalue
        node.object.accept(this);
        if (node.exprList == null) {
            BaseType memberBaseType = root.getClassMemberBaseType(node.object.type.name, node.memberID);
            VirtualReg ptrReg = new VirtualReg(new PointerType(memberBaseType), currentFunction.takeLabel());
            Oprand offset = new ConstInt(32, root.getClassMemberIndex(node.object.type.name, node.memberID));
            currentFunction.append(new GetElementPtrInst(ptrReg, node.object.address, offset));
            node.address = ptrReg;
            node.value   = null;
        }
        else {  // function call

        }
    }

    @Override public void visit(UnaryExprNode node) {
        node.rhs.accept(this);
        Oprand load, result;
        if (node.rhs.isLvalue()) {
            load = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
            currentFunction.append(new LoadInst((VirtualReg) load, node.address));
        }
        else load = node.rhs.value;

        if (load instanceof VirtualReg) {
            switch (node.op){
                case LNOT:
                    result = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
                    currentFunction.append(new BinaryInst((VirtualReg) result, BinaryInst.BiArOp.xor, load, new ConstInt(1, 1)));
                    break;
                case BNOT:
                    result = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
                    currentFunction.append(new BinaryInst((VirtualReg) result, BinaryInst.BiArOp.xor, load, new ConstInt(32, -1)));
                    break;
                case POS:
                    result = load;
                    break;
                case NEG:
                    result = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
                    currentFunction.append(new BinaryInst((VirtualReg) result, BinaryInst.BiArOp.sub, new ConstInt(32, 0), load));
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
        // TODO: 2021/12/9 Finish Assign (lvalue), '&&', '||' , special operation
        node.lhs.accept(this);
        node.rhs.accept(this);
        Oprand left, right, result = null;
        if (node.lhs.isLvalue()) {
            left = new VirtualReg(node.lhs.getValueType(), currentFunction.takeLabel());
            currentFunction.append(new LoadInst((VirtualReg) left, node.lhs.address));
        }
        else left = node.lhs.value;
        if (node.rhs.isLvalue()) {
            right = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
            currentFunction.append(new LoadInst((VirtualReg) right, node.rhs.address));
        }
        else right = node.rhs.value;
        IcmpInst.CompareType compareType = node.getCmpType();
        BinaryInst.BiArOp    biArOp      = node.getBiArType();
        if (left instanceof VirtualReg || right instanceof VirtualReg) {
            switch (node.op) {
                case ADD:
                    if (node.lhs.getValueType() instanceof IntType) { // int add
                        result = new VirtualReg(node.lhs.getValueType(), currentFunction.takeLabel());
                        currentFunction.append(new BinaryInst((VirtualReg) result, BinaryInst.BiArOp.add, left, right));
                    }
                    else { //string add

                    }
                    break;
                case LT: case GT: case LEQ: case GEQ:
                    if (node.lhs.getValueType() instanceof IntType) { // int cmp
                        result = new VirtualReg(new IntType(1), currentFunction.takeLabel());
                        currentFunction.append(new IcmpInst((VirtualReg) result, compareType, left, right));
                    }
                    else { //string cmp

                    }
                    break;
                case SUB: case MUL: case DIV: case MOD: case LSH: case RSH: case AND: case XOR: case OR: // int arith
                    result = new VirtualReg(node.lhs.getValueType(), currentFunction.takeLabel());
                    currentFunction.append(new BinaryInst((VirtualReg) result, biArOp, left, right));
                    break;
                case EQ: case NEQ:
                    if (node.lhs.getValueType() instanceof IntType) {
                        result = new VirtualReg(new IntType(1), currentFunction.takeLabel());
                        currentFunction.append(new IcmpInst((VirtualReg) result, compareType, left, right));
                    }
                    else {  // compare address
                        Oprand leftAddress  = (left instanceof ConstNull) ? left : new VirtualReg(new PointerType(new IntType(8)), currentFunction.takeLabel());
                        Oprand rightAddress = (left instanceof ConstNull) ? right: new VirtualReg(new PointerType(new IntType(8)),currentFunction.takeLabel());
                        if (!(left instanceof ConstNull)) {
                            currentFunction.append(new BitCastInst((VirtualReg) left, (VirtualReg) leftAddress));
                        }
                        if (!(right instanceof ConstNull)) {
                            currentFunction.append(new BitCastInst((VirtualReg) right, (VirtualReg) rightAddress));
                        }
                        result = new VirtualReg(new IntType(1), currentFunction.takeLabel());
                        currentFunction.append(new IcmpInst((VirtualReg) result, compareType, leftAddress, rightAddress));
                    }
                    break;
                case ANDAND: case OROR:

                    break;
                case ASSIGN:
                    currentFunction.append(new StoreInst(right, node.lhs.address));    //useless load of left
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

                    }
                    break;
                case LT: case GT: case LEQ: case GEQ:
                    if (node.lhs.getValueType() instanceof IntType) {
                        long l = ((ConstInt)node.lhs.value).getIntValue(), r = ((ConstInt)node.rhs.value).getIntValue();
                        switch (node.op) {
                            case LT: result = new ConstInt(1, l <  r ? 1 : 0); break;
                            case GT: result = new ConstInt(1, l >  r ? 1 : 0); break;
                            case LEQ:result = new ConstInt(1, l <= r ? 1 : 0); break;
                            case GEQ:result = new ConstInt(1, l >= r ? 1 : 0); break;
                        }
                    }
                    else {

                    }
                    break;
                case SUB: case MUL: case DIV: case MOD: case LSH: case RSH: case AND: case XOR: case OR:
                    long l = ((ConstInt)node.lhs.value).getIntValue(), r = ((ConstInt)node.rhs.value).getIntValue();
                    switch (node.op) {
                        case SUB: result = new ConstInt(32, l - r);  break;
                        case MUL: result = new ConstInt(32, l * r);  break;
                        case DIV: result = new ConstInt(32, l / r);  break;
                        case MOD: result = new ConstInt(32, l % r);  break;
                        case LSH: result = new ConstInt(32, l << r); break;
                        case RSH: result = new ConstInt(32, l >> r); break;     //ashr
                        case AND: result = new ConstInt(32, l & r);  break;
                        case XOR: result = new ConstInt(32, l ^ r);  break;
                        case OR : result = new ConstInt(32, l | r);  break;
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
                case ANDAND: case OROR:

                    break;
                case ASSIGN:
                    currentFunction.append(new StoreInst(right, node.lhs.address));
                    break;
            }
        }
        if (node.op == BinaryExprNode.BinaryOp.ASSIGN) {
            node.address = node.lhs.address;
            node.value   = null;
        }
        else {
            node.address = null;
            node.value   = result;
        }
    }

    @Override public void visit(PrefixExprNode node) { //must be lvalue
        node.rhs.accept(this);
        VirtualReg loadReg, resultReg;
        loadReg = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
        currentFunction.append(new LoadInst(loadReg, node.rhs.address));
        resultReg = new VirtualReg(node.rhs.getValueType(), currentFunction.takeLabel());
        currentFunction.append(new BinaryInst(resultReg, BinaryInst.BiArOp.add, loadReg, new ConstInt(32, 1)));
        currentFunction.append(new StoreInst(resultReg, node.rhs.address));
        node.address = node.rhs.address;
        node.value   = null;
    }

    @Override public void visit(SuffixExprNode node) {
        node.lhs.accept(this);
        VirtualReg loadReg, resultReg;
        loadReg = new VirtualReg(node.lhs.getValueType(), currentFunction.takeLabel());
        currentFunction.append(new LoadInst(loadReg, node.lhs.address));
        resultReg = new VirtualReg(node.lhs.getValueType(), currentFunction.takeLabel());
        currentFunction.append(new BinaryInst(resultReg, BinaryInst.BiArOp.add, loadReg, new ConstInt(32, 1)));
        currentFunction.append(new StoreInst(resultReg, node.lhs.address));
        node.address = null;
        node.value   = loadReg;
    }
// value node: (care about compile-time constant!)
// vari: load_inst, return vreg ; int: return constint
// string: add to constant?     ; true/false: return constint
// null : return const null     ;
// newArray: for-loop, call-malloc, return oprand;
// newClass: for-loop, alloca, return oprand
// function: call-function
// this: return args[0] (this pointer is args[0])
    @Override public void visit(VariValNode node) {
        node.address = currentScope.getVarReg(node.name, true);
        node.imm = null;
    }

    @Override public void visit(IntValNode node) {
        node.address = null;
        node.imm = new ConstInt(32, node.intValue);
    }

    @Override public void visit(StringValNode node) {
        node.address = null;
        node.imm = new ConstStr(node.strValue);
        // TODO: 2021/12/10 add str to constant
    }

    @Override public void visit(BoolValNode node) {
        node.address = null;
        node.imm = new ConstInt(32, node.boolValue ? 1 : 0);
    }

    @Override public void visit(NullValNode node) {
        node.address = null;
        node.imm = new ConstNull();
    }

    @Override public void visit(NewArrayNode node) {

    }

    @Override public void visit(FuncValNode node) {

    }

    @Override public void visit(LambdaValNode node) {}

    @Override public void visit(ThisValNode node) {

    }

    @Override public void visit(ParaListNode node) {
        for (TypeNode typeNode : node.para) {
            typeNode.accept(this);
        }

    }

    @Override public void visit(ExprListNode node) {

    }

    @Override public void visit(ForInitNode node) {

    }

    @Override public void visit(BlockNode node) {
        currentScope = new IRScope(currentScope);
        for (StmtNode stmtNode : node.stmts) stmtNode.accept(this);
        currentScope = currentScope.getParent();
    }
}
