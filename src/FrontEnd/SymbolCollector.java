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
import Util.scope.GlobalScope;
import Util.scope.Scope;

public class SymbolCollector implements ASTVisitor{
    public GlobalScope globalScope;
    public SymbolCollector(GlobalScope _globalScope) {
        globalScope = _globalScope;
    }


    @Override
    public void visit(RootNode node) {

    }

    @Override
    public void visit(ClassDeclrNode node) {

    }

    @Override
    public void visit(ConstructDeclrNode node) {

    }

    @Override
    public void visit(EmptyDeclrNode node) {

    }

    @Override
    public void visit(FuncDeclrNode node) {

    }

    @Override
    public void visit(AssignDeclrNode node) {

    }

    @Override
    public void visit(ListDeclrNode node) {

    }

    @Override
    public void visit(VoidTypeNode node) {

    }

    @Override
    public void visit(BoolTypeNode node) {

    }

    @Override
    public void visit(IntTypeNode node) {

    }

    @Override
    public void visit(StringTypeNode node) {

    }

    @Override
    public void visit(ClassTypeNode node) {

    }

    @Override
    public void visit(DigitTypeNode node) {

    }

    @Override
    public void visit(ArrayTypeNode node) {

    }

    @Override
    public void visit(EmptyStNode node) {

    }

    @Override
    public void visit(AssignStNode node) {

    }

    @Override
    public void visit(ListStNode node) {

    }

    @Override
    public void visit(ExprStNode node) {

    }

    @Override
    public void visit(CondStNode node) {

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

    @Override
    public void visit(BlockStNode node) {

    }

    @Override
    public void visit(ValueExprNode node) {

    }

    @Override
    public void visit(IndexExprNode node) {

    }

    @Override
    public void visit(UnaryExprNode node) {

    }

    @Override
    public void visit(BinaryExprNode node) {

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
