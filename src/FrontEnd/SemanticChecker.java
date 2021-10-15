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

import java.util.ArrayList;
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

    @Override public void visit(RootNode node) {
        for (DeclrNode declare : node.declrs) {
            declare.accept(this);
        }
        FunctionDef mainDef = new FunctionDef(new Type("int", 0), "main", null);
        if (!globalScope.containsFunc(mainDef))
            throw new semanticError("[ERROR]main function not found: ", node.pos);

    }

    @Override public void visit(ClassDeclrNode node) {
        currentClass = new ClassDef(node.name);
        for (DeclrNode declare : node.declrs) {
            declare.accept(this);
        }
        globalScope.addClassDef(node.name, currentClass, node.pos);
        currentClass = null;
    }

    @Override public void visit(FuncDeclrNode node) {
        node.retType.accept(this);
        node.paraList.accept(this);
        ArrayList<Type> paraType = new ArrayList<>();
        for (Type type : node.paraList.type) {
            paraType.add(new Type(type));
        }
        FunctionDef funcDef = new FunctionDef(node.retType.typeOfNode, node.name, paraType);

        if (currentClass != null)
            currentClass.addFuncDef(funcDef, node.pos);     //class private function
        else
            globalScope.addFuncDef(funcDef, node.pos);      //global share function

        currentFunc = funcDef;
        node.block.accept(this);
        currentFunc = null;
    }

    @Override public void visit(EmptyDeclrNode node) {}

    @Override public void visit(ConstructDeclrNode node) {
        if (currentClass == null)
            throw new semanticError("[ERROR]constructor must be in class declare: ", node.pos);
        if (!Objects.equals(node.name, currentClass.identifier))
            throw new semanticError("[ERROR]constructor name not matched: ", node.pos);


        currentFunc = new FunctionDef(new Type("class", 0), node.name, null);
        globalScope.intoConstruct();
        node.block.accept(this);
        globalScope.outConstruct();
        currentClass.addFuncDef(currentFunc, node.pos);
        currentFunc = null;
        //add constructor function
    }

    @Override public void visit(AssignDeclrNode assignNode) {
        assignNode.value.accept(this);
        assignNode.type.accept(this);
        if (!globalScope.containsClass(assignNode.type.typeOfNode.name))
            throw new semanticError("[ERROR]cannot find classType: "+ assignNode.type.typeOfNode.name + ": ", assignNode.pos);
        if (!assignNode.type.typeOfNode.equals(assignNode.value.type))
            throw new semanticError("[ERROR]assign type not matched: ", assignNode.pos);

        currentScope.defineVar(assignNode.id, assignNode.type.typeOfNode, assignNode.pos);

        if (currentClass != null)
            currentClass.addMember(assignNode.id, assignNode.type.typeOfNode, assignNode.pos);

    }

    @Override public void visit(ListDeclrNode listDeclrNode) {
        listDeclrNode.type.accept(this);
        if (!globalScope.containsClass(listDeclrNode.type.typeOfNode.name))
            throw new semanticError("[ERROR]cannot find classType "+ listDeclrNode.type.typeOfNode.name+": ", listDeclrNode.pos);

        for (String id : listDeclrNode.ids) {
            currentScope.defineVar(id, listDeclrNode.type.typeOfNode, listDeclrNode.pos);
        }

        if (currentClass != null) {
            for (String id : listDeclrNode.ids)
                currentClass.addMember(id, listDeclrNode.type.typeOfNode, listDeclrNode.pos);
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
        node.typeOfNode = new Type(node.name, 0);
    }

    @Override public void visit(ArrayTypeNode node) {
        node.baseType.accept(this);
        node.typeOfNode = new Type(node.baseType.typeOfNode.name, node.dims);
    }

    @Override public void visit(EmptyStNode node) {}

    @Override public void visit(AssignStNode node) {
        if (!currentScope.containVar(node.name, true))
            throw new semanticError("[ERROR]variable need declaration "+node.name+": ", node.pos);
        node.type.accept(this);
        node.value.accept(this);
        if (!node.type.typeOfNode.equals(node.value.type))
            throw new semanticError("[ERROR]assign type not matched: ", node.pos);
    }

    @Override public void visit(ListStNode node) {
        for (String id : node.ids) {
            if (currentScope.containVar(id, false))
                throw new semanticError("[ERROR]redefinition of variable "+id+": ", node.pos);
        }
        node.type.accept(this);
        if (!globalScope.containsClass(node.type.typeOfNode.name))
            throw new semanticError("[ERROR]cannot find classType "+ node.type.typeOfNode.name+": ", node.pos);

    }

    @Override public void visit(ExprStNode node) {
        node.expr.accept(this);
    }

    @Override public void visit(CondStNode node) {
        node.condition.accept(this);
        if (!node.condition.type.isBool())
            throw new semanticError("[ERROR]if-sentence condition must be bool: ", node.pos);
        node.ifStmt.accept(this);
        node.elseStmt.accept(this);
    }

    @Override public void visit(ForStNode node) {
        node.init.accept(this);
        node.condition.accept(this);
        if (!node.condition.type.isBool())
            throw new semanticError("[ERROR]for-sentence condition must be bool: ", node.pos);
        node.increment.accept(this);

        globalScope.intoLoop();
        node.stmt.accept(this);
        globalScope.outLoop();
    }

    @Override public void visit(WhileStNode node) {
        node.condition.accept(this);
        if (!node.condition.type.isBool())
            throw new semanticError("[ERROR]while-sentence condition must be bool: ", node.pos);

        globalScope.intoLoop();
        node.stmt.accept(this);
        globalScope.outLoop();
    }

    @Override public void visit(BreakStNode node) {
        if (!globalScope.isInLoop())
            throw new semanticError("[ERROR]break-sentence must be in loop field: ", node.pos);
    }

    @Override public void visit(RetStNode node) {
        if (currentFunc == null)
            throw new semanticError("[ERROR]return-sentence must be in function field: ", node.pos);

        if (globalScope.isInConstruct()) {
            //  construct function
            if (node.retExpr != null)
                throw new semanticError("[ERROR]constructor return-type error: ", node.pos);
        }
        else {
            //  return ;
            if (node.retExpr == null) {
                if (!currentFunc.retType.isVoid()) {
                    throw new semanticError("[ERROR]return-type not match: ", node.pos);
                }
            }
            //  return expression;
            else {
                node.retExpr.accept(this);
                if (!node.retExpr.type.equals(currentFunc.retType))
                    throw new semanticError("[ERROR]return-type not match: ", node.pos);
            }
        }
    }

    @Override
    public void visit(ContinStNode node) {
        if (!globalScope.isInLoop())
            throw new semanticError("[ERROR]continue-sentence must be in loop field: ", node.pos);
    }

    @Override
    public void visit(BlockStNode node) {
        node.block.accept(this);
    }

    @Override
    public void visit(ValueExprNode node) {
        node.value.accept(this);
    }

    @Override
    public void visit(IndexExprNode node) {
        // TODO: 2021/10/15 index must be Int type
        node.array.accept(this);
        node.index.accept(this);
        if (!Objects.equals(node.index.type.name, "int"))
            throw new semanticError("[ERROR]index must be int type: ", node.pos);

        node.type = new Type(node.array.type.name, node.array.type.dims-1);
        node.catagory = ExprNode.Catagory.LVALUE;
    }

    @Override
    public void visit(UnaryExprNode node) {
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
        node.catagory = ExprNode.Catagory.LVALUE;
    }

    @Override
    public void visit(BinaryExprNode node) {
        node.lhs.accept(this);
        node.rhs.accept(this);

        switch (node.op) {
            // TODO: 2021/10/15 not finish yet
            case DOT:
                if (!node.lhs.type.isClass())
                    throw new semanticError("[ERROR]dot oprand need classType subject: ", node.pos);

                //check member / function 
                break;
            case ADD:
            case SUB:
            case MUL:
            case DIV:
            case MOD:
        }
    }

    @Override
    public void visit(PrefixExprNode node) {

    }

    @Override
    public void visit(SuffixExprNode node) {

    }

    @Override
    public void visit(ClassValNode node) {

    }

    @Override
    public void visit(IntValNode node) {

    }

    @Override
    public void visit(StringValNode node) {

    }

    @Override
    public void visit(BoolValNode node) {

    }

    @Override
    public void visit(NullValNode node) {

    }

    @Override
    public void visit(NewArrayNode node) {

    }

    @Override
    public void visit(FuncValNode node) {

    }

    @Override
    public void visit(LambdaValNode node) {

    }

    @Override
    public void visit(ThisValNode node) {

    }

    @Override
    public void visit(ParaListNode node) {

    }

    @Override
    public void visit(ExprListNode node) {

    }

    @Override
    public void visit(ForInitNode node) {

    }

    @Override
    public void visit(BlockNode node) {

    }
}
