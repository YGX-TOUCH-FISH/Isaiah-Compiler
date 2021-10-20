package FrontEnd;

import AST.ASTVisitor;
import AST.RootNode;
import AST.Declare.*;
import AST.Expr.*;
import AST.List.*;
import AST.Stmt.*;
import AST.Type.*;
import AST.Value.*;
import Util.ClassDef;
import Util.FunctionDef;
import Util.Type;
import Util.error.semanticError;
import Util.scope.GlobalScope;
import Util.scope.Scope;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class SemanticChecker implements ASTVisitor{
    private GlobalScope globalScope;
    private Scope currentScope;
    private FunctionDef currentFunc;
    private ClassDef currentClass;

    public SemanticChecker(GlobalScope _gScope) {
        currentScope = _gScope;
        globalScope = _gScope;
        globalScope.initialize();
    }
    // TODO: 2021/10/17 如何确保函数必有返回值？ （部分有，部分没有）
    // TODO: 2021/10/20 collection重写
    @Override public void visit(RootNode node) {
        ArrayList<Integer> classDeclrIndex = new ArrayList<>();
        ArrayList<Integer> funcDeclrIndex = new ArrayList<>();
        ArrayList<Integer> otherDeclrIndex = new ArrayList<>();
        for (int i = 0 ; i < node.declrs.size() ; i++) {
            //collect all classes
            DeclrNode declare = node.declrs.get(i);
            if (declare instanceof ClassDeclrNode) {
                classDeclrIndex.add(i);
                ClassDeclrNode classDeclare = (ClassDeclrNode) declare;
                globalScope.addClassDef(classDeclare.name, new ClassDef(classDeclare.name), node.pos);
                continue;
            }
            otherDeclrIndex.add(i);
            if (declare instanceof FuncDeclrNode) funcDeclrIndex.add(i);
        }
        for (int i : funcDeclrIndex) {
            //collect all global functions
            DeclrNode declare = node.declrs.get(i);
            FuncDeclrNode funcDeclare = (FuncDeclrNode) declare;
            funcDeclare.retType.accept(this);
            funcDeclare.paraList.accept(this);
            globalScope.addFuncDef(new FunctionDef(funcDeclare.retType.typeOfNode, funcDeclare.name, funcDeclare.paraList.types), node.pos);
        }
        if (!globalScope.containsFunc("main"))
            throw new semanticError("[ERROR]main function not found: ", node.pos);
        FunctionDef mainDef = globalScope.getFunc("main");
        if (!mainDef.retType.isInt() || mainDef.paraType.size() != 0)
            throw new semanticError("[ERROR]main function return-type error not match: ", node.pos);

        for (int i : classDeclrIndex) {
            //collect all class members/functions
            DeclrNode declare = node.declrs.get(i);
            ClassDeclrNode classDeclare = (ClassDeclrNode) declare;
            ClassDef classDef = globalScope.getClassByName(classDeclare.name);
            for (DeclrNode classDeclrNode : classDeclare.declrs) {
                if (classDeclrNode instanceof AssignDeclrNode) {
                    AssignDeclrNode classAssignDeclrNode = (AssignDeclrNode) classDeclrNode;
                    classAssignDeclrNode.type.accept(this);
                    //不要再visit value了 type-equal check交给visit
                    classDef.addMember(classAssignDeclrNode.id, classAssignDeclrNode.type.typeOfNode, classAssignDeclrNode.pos);
                }
                else if (classDeclrNode instanceof ListDeclrNode) {
                    ListDeclrNode classListDeclrNode = (ListDeclrNode) classDeclrNode;
                    classListDeclrNode.type.accept(this);
                    for (String id : classListDeclrNode.ids) {
                        classDef.addMember(id, classListDeclrNode.type.typeOfNode, classListDeclrNode.pos);
                    }
                }
                else if (classDeclrNode instanceof FuncDeclrNode) {
                    FuncDeclrNode classFuncDeclrNode = (FuncDeclrNode) classDeclrNode;
                    classFuncDeclrNode.retType.accept(this);
                    classFuncDeclrNode.paraList.accept(this);
                    classDef.addFuncDef(new FunctionDef(classFuncDeclrNode.retType.typeOfNode, classFuncDeclrNode.name, classFuncDeclrNode.paraList.types), classDeclrNode.pos);
                }
                else if (classDeclrNode instanceof ConstructDeclrNode) {
                    ConstructDeclrNode classConstrDeclrNode = (ConstructDeclrNode) classDeclrNode;
                    if (!classConstrDeclrNode.name.equals(classDef.identifier))
                        throw new semanticError("[ERROR]constructor name not match with class name: ", classDeclrNode.pos);
                    classDef.addFuncDef(new FunctionDef(new Type("class", 0), classConstrDeclrNode.name, null), classDeclrNode.pos);
                }
            }
            FunctionDef constructor = new FunctionDef(new Type("class", 0), classDef.identifier, null);
            if (!classDef.containsFunc(classDef.identifier)) {
                classDef.addFuncDef(constructor, classDeclare.pos);
            }
        }
        //symbol collector finished
        for (DeclrNode declare : node.declrs) {
            declare.accept(this);
        }
        //semantic checker finished
    }

    @Override public void visit(ClassDeclrNode node) {
        currentClass = globalScope.getClassByName(node.name);
        currentScope = new Scope(currentScope);
        ArrayList<Integer> otherIndexs = new ArrayList<>();
        //先在scope中define变量
        for (int i = 0 ; i < node.declrs.size() ; i++) {
            DeclrNode declare = node.declrs.get(i);
            if (declare instanceof ListDeclrNode || declare instanceof AssignDeclrNode)
                declare.accept(this);
            else
                otherIndexs.add(i);
        }
        for (int i : otherIndexs) {
            DeclrNode declare = node.declrs.get(i);
            declare.accept(this);
        }
        currentScope = currentScope.getParent();
        currentClass = null;
    }

    @Override public void visit(FuncDeclrNode node) {
        currentScope = new Scope(currentScope);
        FunctionDef funcDef = new FunctionDef(node.retType.typeOfNode, node.name, node.paraList.types);
        for (int i = 0 ; i < node.paraList.para.size() ; i++) {
            if (globalScope.inCollection(node.paraList.ids.get(i)))
                throw new semanticError("[ERROR]duplicated name: ", node.paraList.pos);
            currentScope.defineVar(node.paraList.ids.get(i), node.paraList.types.get(i), node.paraList.para.get(i).pos);
        }
        currentFunc = funcDef;
        node.block.accept(this);
        currentFunc = null;
        if (node.block.retType.isNull() && !funcDef.retType.isVoid()) {
            FunctionDef mainDef = new FunctionDef(new Type("int", 0), "main", null);
            if (!funcDef.equalwith(mainDef))
                throw new semanticError("[ERROR]non-void function "+funcDef.name+" need return-sentence: ", node.pos);
        }
        currentScope = currentScope.getParent();
    }

    @Override public void visit(EmptyDeclrNode node) {}

    @Override public void visit(ConstructDeclrNode node) {
        if (currentClass == null)
            throw new semanticError("[ERROR]constructor must be in class declare: ", node.pos);

        currentFunc = new FunctionDef(new Type("class", 0), node.name, null);
        currentScope = new Scope(currentScope);
        node.block.accept(this);
        currentScope = currentScope.getParent();
        currentFunc = null;
    }

    @Override public void visit(BlockNode node) {
        for (StmtNode stmt : node.stmts) {
            stmt.accept(this);
        }
        //check all return type legal
        node.retType = new Type("null", 0);
        if (currentScope.isInLambda()) {
            for (StmtNode stmt : node.stmts) {
                if (!stmt.retType.isNull()) {
                    if (node.retType.isNull()) node.retType = stmt.retType;
                    if (!node.retType.equalwith(stmt.retType))
                        throw new semanticError("[ERROR]lambda function return-type should be consensus: ", node.pos);
                }
            }
            if (node.retType.isNull()) node.retType = new Type("void", 0);
        }   //优先级lambda > function
        else if (currentFunc != null) {
            for (StmtNode stmt : node.stmts) {
                if (!stmt.retType.isNull()) {
                    if (node.retType.isNull()) node.retType = stmt.retType;
                    if (!node.retType.equalwith(stmt.retType))
                        throw new semanticError("[ERROR]function "+currentFunc.name+" return-type should be consensus: ", node.pos);
                }
            }
        }
        // lambda function:  void/type
        // simple function:  void/null/type
        // constr function:  class/null
    }

    @Override public void visit(AssignDeclrNode node) {
        node.value.accept(this);
        node.type.accept(this);
        if (!node.type.typeOfNode.assignable(node.value.type))
            throw new semanticError("[ERROR]lhs-type cannot be assigned by rhs-type: ", node.pos);
        if (globalScope.inCollection(node.id))
            throw new semanticError("[ERROR]duplicated variable name:", node.pos);
        currentScope.defineVar(node.id, node.type.typeOfNode, node.pos);
    }

    @Override public void visit(ListDeclrNode node) {
        node.type.accept(this);

        for (String id : node.ids) {
            if (globalScope.inCollection(id))
                throw new semanticError("[ERROR]duplicated variable name:", node.pos);
            currentScope.defineVar(id, node.type.typeOfNode, node.pos);
        }
    }

    @Override public void visit(VoidTypeNode node) {
        node.typeOfNode = new Type("void", 0);
    }

    @Override public void visit(BoolTypeNode node) {
        node.typeOfNode = new Type("bool", 0);
    }

    @Override public void visit(IntTypeNode node) {
        node.typeOfNode = new Type("int", 0);
    }

    @Override public void visit(StringTypeNode node) {
        node.typeOfNode = new Type("string", 0);
    }

    @Override public void visit(ClassTypeNode node) {
        if (!globalScope.containsClass(node.name))
            throw new semanticError("[ERROR]cannot find classType "+node.name+": ", node.pos);
        node.typeOfNode = new Type(node.name, 0);
    }

    @Override public void visit(ArrayTypeNode node) {
        node.baseType.accept(this);
        //recursion to find baseType
        node.typeOfNode = new Type(node.baseType.typeOfNode.name, node.dims);
    }

    @Override public void visit(EmptyStNode node) {}

    @Override public void visit(AssignStNode node) {
        node.type.accept(this);
        node.value.accept(this);

        if (!node.type.typeOfNode.assignable(node.value.type))
            throw new semanticError("[ERROR]lhs-type cannot be assigned by rhs-type: ", node.pos);
        if (globalScope.inCollection(node.name))
            throw new semanticError("[ERROR]duplicated variable name:", node.pos);
        currentScope.defineVar(node.name, node.type.typeOfNode, node.pos);
    }

    @Override public void visit(ListStNode node) {
        node.type.accept(this);
        for (String id : node.ids) {
            if (globalScope.inCollection(id))
                throw new semanticError("[ERROR]duplicated variable name:", node.pos);
            currentScope.defineVar(id, node.type.typeOfNode, node.pos);
        }
    }

    @Override public void visit(ExprStNode node) {
        node.expr.accept(this);
    }

    @Override public void visit(CondStNode node) {
        node.condition.accept(this);
        if (!node.condition.type.isBool())
            throw new semanticError("[ERROR]if-sentence condition must be bool: ", node.pos);
        currentScope = new Scope(currentScope);
        node.ifStmt.accept(this);
        currentScope = currentScope.getParent();

        if (node.elseStmt != null) {
            currentScope = new Scope(currentScope);
            node.elseStmt.accept(this);
            currentScope = currentScope.getParent();

            if (node.ifStmt.retType.isNull() && node.elseStmt.retType.isNull())
                node.retType = new Type("null", 0);
            else if (!node.ifStmt.retType.isNull()&&!node.elseStmt.retType.isNull()) {
                if (!node.ifStmt.retType.equalwith(node.elseStmt.retType))
                    throw new semanticError("[ERROR]return-type should be consensus: ", node.pos);
                node.retType = new Type(node.ifStmt.retType);
            }
            else if (!node.ifStmt.retType.isNull()&&node.elseStmt.retType.isNull())
                node.retType = new Type(node.ifStmt.retType);
            else if (node.ifStmt.retType.isNull()&&!node.elseStmt.retType.isNull())
                node.retType = new Type(node.elseStmt.retType);
        }
        else {
            node.retType = new Type(node.ifStmt.retType);
        }
    }

    @Override public void visit(ForStNode node) {
        node.init.accept(this);
        if (node.condition != null) {
            node.condition.accept(this);
            if (!node.condition.type.isBool())
                throw new semanticError("[ERROR]for-sentence condition must be bool: ", node.pos);
        }
        if (node.increment != null) {
            node.increment.accept(this);
        }
        currentScope = new Scope(currentScope);
        currentScope.intoLoop();
        node.stmt.accept(this);
        currentScope = currentScope.getParent();

        node.retType = node.stmt.retType;
    }

    @Override public void visit(WhileStNode node) {
        node.condition.accept(this);
        if (!node.condition.type.isBool())
            throw new semanticError("[ERROR]while-sentence condition must be bool: ", node.pos);

        currentScope = new Scope(currentScope);
        currentScope.intoLoop();
        node.stmt.accept(this);
        currentScope = currentScope.getParent();

        node.retType = node.stmt.retType;
    }

    @Override public void visit(BreakStNode node) {
        if (!currentScope.isInLoop())
            throw new semanticError("[ERROR]break-sentence must be in loop field: ", node.pos);
    }

    @Override public void visit(RetStNode node) {
        if (currentScope.isInLambda()) {
            if (node.retType == null) node.retType = new Type("void", 0);
            else {
                node.retExpr.accept(this);
                node.retType = new Type(node.retExpr.type);
            }
        } //out lambda?
        else {
            if (currentFunc == null)
                throw new semanticError("[ERROR]return-sentence must be in function field: ", node.pos);

            if (node.retExpr != null) {
                node.retExpr.accept(this);
                if (node.retExpr.type.isNull()) {
                    if (!currentFunc.retType.isArray() && !currentFunc.retType.isClass())
                        throw new semanticError("[ERROR]return-type not match: ", node.pos);

                }
                else {
                    if (!node.retExpr.type.equalwith(currentFunc.retType))
                        throw new semanticError("[ERROR]return-type not match: ", node.pos);
                }
                node.retType = new Type(node.retExpr.type);
            }
            else {
                if (currentFunc.retType.isConstructor()) {
                    node.retType = new Type("class", 0);
                }
                else if (currentFunc.retType.isVoid()) {
                    node.retType = new Type("void", 0);
                }
                else throw new semanticError("[ERROR]return-type not match: ", node.pos);
            }
        }

    }

    @Override
    public void visit(ContinStNode node) {
        if (!currentScope.isInLoop())
            throw new semanticError("[ERROR]continue-sentence must be in loop field: ", node.pos);
    }

    @Override public void visit(BlockStNode node) {
        currentScope = new Scope(currentScope);
        node.block.accept(this);
        currentScope = currentScope.getParent();

        node.retType = node.block.retType;
    }

    @Override public void visit(ValueExprNode node) {
        node.value.accept(this);
        node.type = node.value.type;
        node.catagory = node.value.catagory;
    }

    @Override public void visit(IndexExprNode node) {
        node.array.accept(this);
        node.index.accept(this);
        if (!node.index.type.isInt())
            throw new semanticError("[ERROR]index must be int type: ", node.pos);
        if (node.array.type.dims == 0)
            throw new semanticError("[ERROR]index dimension error: ", node.pos);
        node.type = new Type(node.array.type.name, node.array.type.dims-1);
        node.catagory = ExprNode.Catagory.LVALUE;
        //数组及其下标调用都为右值
    }
    @Override public void visit(CallExprNode node) {
        node.object.accept(this);
        if (!globalScope.containsClass(node.object.type.name))
            throw new semanticError("[ERROR]failed to find classType "+node.object.type.name+": ", node.pos);
        ClassDef classDef;
        if (node.object.type.isArray()) classDef = globalScope.getClassByName("class[]");
        else classDef = globalScope.getClassByName(node.object.type.name);
        if (node.exprList == null) {
            if (!classDef.containsMember(node.memberID))
                throw new semanticError("[ERROR]cannot find member variable "+node.memberID+" in class "+node.object.type.name+": ", node.pos);
            node.type = classDef.getMemberType(node.memberID);
            node.catagory = ExprNode.Catagory.LVALUE;
        }
        else {
            if (!classDef.containsFunc(node.memberID))
                throw new semanticError("[ERROR]cannot find member function "+node.memberID+" in class "+node.object.type.name+": ", node.pos);
            node.exprList.accept(this);
            FunctionDef classFunc = classDef.getFunc(node.memberID);
            if (!classFunc.assignBy(node.exprList.types))
                throw new semanticError("[ERROR]function parameter not matched: ", node.pos);
            node.type = classFunc.retType;
            node.catagory = ExprNode.Catagory.RVALUE;
        }
    }
    @Override public void visit(UnaryExprNode node) {
        node.rhs.accept(this);
        if (node.op == UnaryExprNode.UnaryOp.LNOT) {
            if (!node.rhs.type.isBool())
                throw new semanticError("[ERROR]logic NOT must match bool type: ", node.pos);
        }
        else {
            if (!node.rhs.type.isInt())
                throw new semanticError("[ERROR]bitwiseNOT/pos/neg must match int type: ", node.pos);
        }
        node.type = new Type(node.rhs.type.name, node.rhs.type.dims);
        node.catagory = ExprNode.Catagory.RVALUE;
    }

    @Override public void visit(BinaryExprNode node) {
        node.lhs.accept(this);
        node.rhs.accept(this);
        switch (node.op) {
            case ADD:
                if (!node.lhs.type.equalwith(node.rhs.type))
                    throw new semanticError("[ERROR]lhs-type not equal to rhs-type: ", node.pos);
                if (!node.lhs.type.isInt() && !node.lhs.type.isString())
                    throw new semanticError("[ERROR]oprand need int/string type: ", node.pos);
                if (node.lhs.type.isInt()) node.type = new Type("int", 0);
                else node.type = new Type("string", 0);
                node.catagory = ExprNode.Catagory.RVALUE;
                break;
            case LT: case GT: case LEQ: case REQ:
                if (!node.lhs.type.equalwith(node.rhs.type))
                    throw new semanticError("[ERROR]lhs-type not equal to rhs-type: ", node.pos);
                if (!node.lhs.type.isInt() && !node.lhs.type.isString())
                    throw new semanticError("[ERROR]oprand need int/string type: ", node.pos);
                node.type = new Type("bool", 0);
                node.catagory = ExprNode.Catagory.RVALUE;
                break;
            case SUB: case MUL: case DIV: case MOD: case LSH: case RSH: case AND: case XOR: case OR:
                if (!node.lhs.type.equalwith(node.rhs.type))
                    throw new semanticError("[ERROR]lhs-type not equal to rhs-type: ", node.pos);
                if (!node.lhs.type.isInt())
                    throw new semanticError("[ERROR]oprand need int type: ", node.pos);
                node.type = new Type("int", 0);
                node.catagory = ExprNode.Catagory.RVALUE;
                break;
            case EQ: case NEQ:
                if (node.lhs.type.isNull() && !node.rhs.type.isNull()) {
                    if (!node.rhs.type.isArray() && !node.rhs.type.isClass())
                        throw new semanticError("[ERROR]lhs-type(null) not equal to rhs-type: ", node.pos);
                }
                else if (!node.lhs.type.isNull() && node.rhs.type.isNull()) {
                    if (!node.lhs.type.isArray() && !node.lhs.type.isClass())
                        throw new semanticError("[ERROR]lhs-type not equal to rhs-type(null): ", node.pos);
                }
                else if (!node.lhs.type.isNull() && !node.rhs.type.isNull()) {
                    if (!node.lhs.type.equalwith(node.rhs.type))
                        throw new semanticError("[ERROR]lhs-type not equal to rhs-type: ", node.pos);
                }
                node.type = new Type("bool", 0);
                node.catagory = ExprNode.Catagory.RVALUE;
                break;
            case ANDAND: case OROR:
                if (!node.lhs.type.equalwith(node.rhs.type))
                    throw new semanticError("[ERROR]lhs-type not equal to rhs-type: ", node.pos);
                if (!node.lhs.type.isBool())
                    throw new semanticError("[ERROR]oprand need bool type: ", node.pos);
                node.type = new Type("bool", 0);
                node.catagory = ExprNode.Catagory.RVALUE;
                break;
            case ASSIGN:
                if (node.lhs.catagory == ExprNode.Catagory.RVALUE)
                    throw new semanticError("[ERROR]assign-lhs must be lvalue: ", node.pos);
                if (!node.lhs.type.assignable(node.rhs.type))
                    throw new semanticError("[ERROR]lhs-type cannot be assigned by rhs-type: ", node.pos);
                node.type = new Type(node.lhs.type);        //被赋值为null后类型不变
                node.catagory = ExprNode.Catagory.LVALUE;
                break;
        }
    }

    @Override public void visit(PrefixExprNode node) {
        node.rhs.accept(this);
        if (node.rhs.catagory == ExprNode.Catagory.RVALUE)
            throw new semanticError("[ERROR]rvalue cannot be used in prefix-expr: ", node.pos);
        if (!node.rhs.type.isInt())
            throw new semanticError("[ERROR]prefix-expr need int-type: ", node.pos);
        node.type = new Type(node.rhs.type);
        node.catagory = ExprNode.Catagory.LVALUE;
    }

    @Override public void visit(SuffixExprNode node) {
        node.lhs.accept(this);
        if (node.lhs.catagory == ExprNode.Catagory.RVALUE)
            throw new semanticError("[ERROR]rvalue cannot be used in suffix-expr: ", node.pos);
        if (!node.lhs.type.isInt())
            throw new semanticError("[ERROR]suffix-expr need int-type: ", node.pos);
        node.type = new Type(node.lhs.type);
        node.catagory = ExprNode.Catagory.RVALUE;
    }

    @Override public void visit(VariValNode node) {
        if (node.name != null) {
            //exist class
            Type findType = currentScope.getType(node.name, true);
            if (findType == null)
                throw new semanticError("[ERROR]variable "+node.name+" use before declaration: ", node.pos);
            node.type = new Type(findType);
        }
        else {
            if (!globalScope.containsClass(node.type.name))
                throw new semanticError("[ERROR]variable classType "+node.type.name+" not defined: ", node.pos);
            //generate random string
            currentScope.defineVar(UUID.randomUUID().toString(), node.type, node.pos);
        }
        //node.name == null: newClass
        node.catagory = ExprNode.Catagory.LVALUE;
    }

    @Override public void visit(IntValNode node) {
        node.type = new Type("int", 0);
        node.catagory = ExprNode.Catagory.RVALUE;
    }

    @Override public void visit(StringValNode node) {
        node.type = new Type("string", 0);
        node.catagory = ExprNode.Catagory.RVALUE;
    }

    @Override public void visit(BoolValNode node) {
        node.type = new Type("bool", 0);
        node.catagory = ExprNode.Catagory.RVALUE;

    }

    @Override public void visit(NullValNode node) {
        node.type = new Type("null", 0);
        node.catagory = ExprNode.Catagory.RVALUE;

    }

    @Override public void visit(NewArrayNode node) {
        node.baseType.accept(this);
        for (ExprNode exprNode : node.sizeofDim) {
            exprNode.accept(this);
            if (!exprNode.type.isInt())
                throw new semanticError("[ERROR]index must be int type: ", node.pos);
        }
        node.type = new Type(node.baseType.typeOfNode.name, node.dims);
        node.catagory = ExprNode.Catagory.LVALUE;
    }

    @Override public void visit(FuncValNode node) {
        node.exprList.accept(this);

        String funcName = node.name;
        if (currentClass != null) {
            if (!globalScope.containsFunc(funcName) && !currentClass.containsFunc(funcName))
                throw new semanticError("[ERROR]cannot find function "+node.name+" :", node.pos);
            else if (currentClass.containsFunc(funcName)) {
                FunctionDef classFunc = currentClass.getFunc(funcName);
                if (!classFunc.assignBy(node.exprList.types))
                    throw new semanticError("[ERROR]class function "+funcName+" parameter not matched: ",node.pos);
                node.type = new Type(classFunc.retType);
            }
            else {
                FunctionDef globalFunc = globalScope.getFunc(funcName);
                if (!globalFunc.assignBy(node.exprList.types))
                    throw new semanticError("[ERROR]global function "+funcName+" parameter not matched: ",node.pos);
                node.type = new Type(globalFunc.retType);
            }
        }
        else {
            if (!globalScope.containsFunc(funcName))
                throw new semanticError("[ERROR]cannot find function "+node.name+" :", node.pos);
            FunctionDef globalFunc = globalScope.getFunc(funcName);
            if (!globalFunc.assignBy(node.exprList.types))
                throw new semanticError("[ERROR]global function "+funcName+" parameter not matched: ",node.pos);
            node.type = new Type(globalFunc.retType);
        }

        node.catagory = ExprNode.Catagory.LVALUE;
        currentScope.defineVar(UUID.randomUUID().toString(), node.type, node.pos);
    }

    @Override public void visit(LambdaValNode node) {
        currentScope = new Scope(currentScope);
        node.paraList.accept(this);
        for (int i = 0 ; i < node.paraList.para.size() ; i++) {
            currentScope.defineVar(node.paraList.ids.get(i), node.paraList.types.get(i), node.paraList.para.get(i).pos);
        }
        currentScope.intoLambda();
        node.block.accept(this);
        currentScope = currentScope.getParent();
        node.exprList.accept(this);
        node.type = node.block.retType;
        node.catagory = ExprNode.Catagory.RVALUE;
        for (int i = 0 ; i < node.paraList.para.size() ; i++) {
            Type paraType = node.paraList.types.get(i);
            Type exprType = node.exprList.types.get(i);
            if (!paraType.assignable(exprType))
                throw new semanticError("[ERROR]paraType cannot be assigned by exprType in lambda function: ", node.pos);
        }
        currentScope.defineVar(UUID.randomUUID().toString(), node.type, node.pos);
    }

    @Override public void visit(ThisValNode node) {
        if (currentClass == null)
            throw new semanticError("[ERROR]'this' pointer must in class declaration: ", node.pos);
        node.type = new Type(currentClass.identifier, 0);
        node.catagory = ExprNode.Catagory.RVALUE;
    }

    @Override public void visit(ParaListNode node) {
        for (TypeNode typeNode : node.para) {
            typeNode.accept(this);
            node.types.add(new Type(typeNode.typeOfNode));
        }
        for (String id : node.ids) {
            if (globalScope.inCollection(id))
                throw new semanticError("[ERROR]duplicated variable name:", node.pos);
        }
    }

    @Override public void visit(ExprListNode node) {
        for (ExprNode exprNode : node.exprs) {
            exprNode.accept(this);
            node.types.add(new Type(exprNode.type));
        }
    }

    @Override public void visit(ForInitNode node) {
        for (ExprNode exprNode : node.exprs) {
            exprNode.accept(this);
        }
    }
}
