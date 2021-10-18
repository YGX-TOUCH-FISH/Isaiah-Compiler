package FrontEnd;

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
import Util.ClassDef;
import Util.FunctionDef;
import Util.Type;
import Util.error.semanticError;
import Util.scope.GlobalScope;
import Util.scope.Scope;

import java.util.Objects;

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
    // TODO: 2021/10/18 函数形参可作为左值
    @Override public void visit(RootNode node) {
        for (DeclrNode declare : node.declrs) {
            if (declare instanceof ClassDeclrNode) {
                ClassDeclrNode classDeclare = (ClassDeclrNode) declare;
                globalScope.addClassDef(classDeclare.name, new ClassDef(classDeclare.name), node.pos);
            }
        }
        for (DeclrNode declare : node.declrs) {
            if (declare instanceof FuncDeclrNode) {
                FuncDeclrNode funcDeclare = (FuncDeclrNode) declare;
                funcDeclare.retType.accept(this);
                funcDeclare.paraList.accept(this);
                globalScope.addFuncDef(new FunctionDef(funcDeclare.retType.typeOfNode, funcDeclare.name, funcDeclare.paraList.types), node.pos);
            }
        }
        FunctionDef mainDef = new FunctionDef(new Type(), "main", null);
        if (!globalScope.containsFunc(mainDef))
            throw new semanticError("[ERROR]main function not found: ", node.pos);
        if (!globalScope.getFuncType(mainDef).isInt())
            throw new semanticError("[ERROR]main function return-type error not match: ", node.pos);

        for (DeclrNode declare : node.declrs) {
            declare.accept(this);
        }
    }

    @Override public void visit(ClassDeclrNode node) {
        currentClass = globalScope.getClassByName(node.name);
        currentScope = new Scope(currentScope);
        for (DeclrNode declare : node.declrs) {
            declare.accept(this);
        }
        currentScope = currentScope.getParent();
        currentClass = null;
    }

    @Override public void visit(FuncDeclrNode node) {
        FunctionDef funcDef;
        if (currentClass != null) {
            node.retType.accept(this);
            node.paraList.accept(this);
            funcDef = new FunctionDef(node.retType.typeOfNode, node.name, node.paraList.types);
            currentClass.addFuncDef(funcDef, node.pos);     //class private function
        }
        else {
            //已经遍历过一次
            funcDef = new FunctionDef(node.retType.typeOfNode, node.name, node.paraList.types);
        }
        currentFunc = funcDef;
        currentScope = new Scope(currentScope);
        node.block.accept(this);
        currentScope = currentScope.getParent();
        currentFunc = null;

        if (node.block.retType.isNull() && !funcDef.retType.isVoid()) {
            FunctionDef mainDef = new FunctionDef(new Type("int", 0), "main", null);
            if (!funcDef.equalwith(mainDef))
                throw new semanticError("[ERROR]non-void function "+funcDef.name+" need return-sentence: ", node.pos);
        }
        //
    }

    @Override public void visit(EmptyDeclrNode node) {}

    @Override public void visit(ConstructDeclrNode node) {
        if (currentClass == null)
            throw new semanticError("[ERROR]constructor must be in class declare: ", node.pos);
        if (!Objects.equals(node.name, currentClass.identifier))
            throw new semanticError("[ERROR]constructor name not matched: ", node.pos);

        FunctionDef funcDef = new FunctionDef(new Type("class", 0), node.name, null);
        currentClass.addFuncDef(funcDef, node.pos);

        currentFunc = funcDef;
        currentScope = new Scope(currentScope);
        node.block.accept(this);
        currentScope = currentScope.getParent();
        currentFunc = null;

        if (!node.block.retType.isNull() && node.block.stmts.size() != 1)
            throw new semanticError("[ERROR]only single return-sentence is permitted: ", node.pos);

        //add constructor function
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

        if (!node.type.typeOfNode.equalwith(node.value.type))
            throw new semanticError("[ERROR]assign type not matched: ", node.pos);

        currentScope.defineVar(node.id, node.type.typeOfNode, node.pos);

        if (currentClass != null)
            currentClass.addMember(node.id, node.type.typeOfNode, node.pos);
    }

    @Override public void visit(ListDeclrNode node) {
        node.type.accept(this);

        for (String id : node.ids) {
            currentScope.defineVar(id, node.type.typeOfNode, node.pos);
        }

        if (currentClass != null) {
            for (String id : node.ids)
                currentClass.addMember(id, node.type.typeOfNode, node.pos);
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
        if (!node.type.typeOfNode.equalwith(node.value.type))
            throw new semanticError("[ERROR]assign type not matched: ", node.pos);

        currentScope.defineVar(node.name, node.type.typeOfNode, node.pos);
    }

    @Override public void visit(ListStNode node) {
        node.type.accept(this);
        for (String id : node.ids) {
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
        node.condition.accept(this);
        if (!node.condition.type.isBool())
            throw new semanticError("[ERROR]for-sentence condition must be bool: ", node.pos);
        node.increment.accept(this);

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
                if (!node.retExpr.type.equalwith(currentFunc.retType))
                    throw new semanticError("[ERROR]return-type not match: ", node.pos);
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
    }
    @Override public void visit(CallExprNode node) {
        node.object.accept(this);
        if (!globalScope.containsClass(node.object.type.name))
            throw new semanticError("[ERROR]failed to find classType "+node.object.type.name+": ", node.pos);

        ClassDef classDef = globalScope.getClassByName(node.object.type.name);

        if (node.exprList == null) {
            if (!classDef.containsMember(node.memberID))
                throw new semanticError("[ERROR]cannot find member variable "+node.memberID+" in class "+node.object.type.name+": ", node.pos);

            node.type = classDef.getMemberType(node.memberID);
            node.catagory = ExprNode.Catagory.LVALUE;
        }
        else {
            node.exprList.accept(this);
            FunctionDef _func = new FunctionDef(new Type(), node.memberID, node.exprList.types);
            if (!classDef.containsFunc(_func))
                throw new semanticError("[ERROR]cannot find member function "+node.memberID+" in class "+node.object.type.name+": ", node.pos);

            node.type = classDef.getFuncType(_func);
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
                if (node.lhs.type.isArray()) {
                    if (node.rhs.type.isArray()) {
                        if (!node.lhs.type.equalwith(node.rhs.type))
                            throw new semanticError("[ERROR]lhs-type not equal to rhs-type: ", node.pos);
                    } else if (!node.rhs.type.isNull())
                        throw new semanticError("[ERROR]array (N)EQ need array-type or null-type: ", node.pos);
                } else if (node.rhs.type.isArray()) {
                    if (node.lhs.type.isArray()) {
                        if (!node.lhs.type.equalwith(node.rhs.type))
                            throw new semanticError("[ERROR]lhs-type not equal to rhs-type: ", node.pos);
                    } else if (!node.lhs.type.isNull())
                        throw new semanticError("[ERROR]array (N)EQ need array-type or null-type: ", node.pos);
                } else {
                    if (!node.lhs.type.equalwith(node.rhs.type))
                        throw new semanticError("[ERROR]lhs-type not equal to rhs-type: ", node.pos);
                    else if (!node.lhs.type.isInt() && !node.lhs.type.isString() && !node.lhs.type.isClass() && !node.lhs.type.isBool())
                        throw new semanticError("[ERROR](N)EQ oprand type error: ", node.pos);
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
                if (node.lhs.type.isArray()) {
                    if (node.rhs.type.isArray()) {
                        if (!node.lhs.type.equalwith(node.rhs.type))
                            throw new semanticError("[ERROR]lhs-type not equal to rhs-type: ", node.pos);
                    } else if (!node.rhs.type.isNull())
                        throw new semanticError("[ERROR]array assign value must be array-type/null: ", node.pos);
                } else {
                    if (!node.lhs.type.equalwith(node.rhs.type))
                        throw new semanticError("[ERROR]lhs-type not equal to rhs-type: ", node.pos);
                }
                node.type = new Type(node.rhs.type);
                node.catagory = ExprNode.Catagory.LVALUE;
                break;
        }
    }

    @Override public void visit(PrefixExprNode node) {
        node.rhs.accept(this);
        if (!node.rhs.type.isInt())
            throw new semanticError("[ERROR]prefix-expr need int-type: ", node.pos);
        node.type = new Type(node.rhs.type);
        node.catagory = ExprNode.Catagory.LVALUE;
    }

    @Override public void visit(SuffixExprNode node) {
        node.lhs.accept(this);
        if (!node.lhs.type.isInt())
            throw new semanticError("[ERROR]suffix-expr need int-type: ", node.pos);
        node.type = new Type(node.lhs.type);
        node.catagory = ExprNode.Catagory.RVALUE;
    }

    @Override public void visit(VariValNode node) {
        Type findType = currentScope.getType(node.name, true);
        if (findType == null)
            throw new semanticError("[ERROR]variable "+node.name+" use before declaration: ", node.pos);
        node.type = new Type(findType);
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
        node.catagory = ExprNode.Catagory.RVALUE;
    }

    @Override public void visit(FuncValNode node) {
        node.exprList.accept(this);

        FunctionDef funcDef = new FunctionDef(new Type(), node.name, node.exprList.types);
        //only need to consider global function
        if (!globalScope.containsFunc(funcDef))
            throw new semanticError("[ERROR]cannot find function "+node.name+": ", node.pos);

        node.type = new Type(globalScope.getFuncType(funcDef));
        node.catagory = ExprNode.Catagory.RVALUE;
    }

    @Override public void visit(LambdaValNode node) {
        node.paraList.accept(this);

        currentScope = new Scope(currentScope);
        currentScope.intoLambda();
        node.block.accept(this);
        currentScope = currentScope.getParent();

        node.exprList.accept(this);

        node.type = node.block.retType;
        node.catagory = ExprNode.Catagory.RVALUE;
    }

    @Override public void visit(ThisValNode node) {
        if (currentClass == null)
            throw new semanticError("[ERROR]'this' pointer must in class declaration: ", node.pos);
        node.type = new Type(currentClass.identifier, 0);
        node.catagory = ExprNode.Catagory.LVALUE;
    }

    @Override public void visit(ParaListNode node) {
        for (TypeNode typeNode : node.para) {
            typeNode.accept(this);
            node.types.add(new Type(typeNode.typeOfNode));
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
