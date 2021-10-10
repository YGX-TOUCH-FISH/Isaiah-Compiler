package AST;

import AST.Declare.*;
import AST.List.ExprListNode;
import AST.List.ParaListNode;
import AST.Type.*;
import AST.Stmt.*;
import AST.Expr.*;
import AST.Value.*;
public interface ASTVisitor {
    void visit(RootNode node);

    void visit(ClassDeclrNode node);
    void visit(ConstructDeclrNode node);
    void visit(EmptyDeclrNode node);
    void visit(FuncDeclrNode node);
    void visit(VarDeclrNode node);

    void visit(VoidTypeNode node);
    void visit(BoolTypeNode node);
    void visit(IntTypeNode node);
    void visit(StringTypeNode node);
    void visit(ClassTypeNode node);
    void visit(ArrayTypeNode node);

    void visit(VarDeclrStNode node);
    void visit(CondStNode node);
    void visit(ForStNode node);
    void visit(WhileStNode node);
    void visit(BreakStNode node);
    void visit(RetStNode node);
    void visit(ContinStNode node);
    void visit(BlockStNode node);

    void visit(ValueExprNode node);
    void visit(IndexExprNode node);
    void visit(UnaryExprNode node);
    void visit(BinaryExprNode node);
    void visit(PrefixExprNode node);
    void visit(SuffixExprNode node);

    void visit(VariValNode node);
    void visit(ConstValNode node);
    void visit(NewValNode node);
    void visit(FuncValNode node);
    void visit(LambdaValNode node);
    void visit(ThisValNode node);

    void visit(ParaListNode node);
    void visit(ExprListNode node);
}
