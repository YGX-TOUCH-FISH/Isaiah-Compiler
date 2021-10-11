package AST.Stmt;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import Util.position;

public class RetStNode extends StmtNode{
    public ExprNode retExpr;
    public RetStNode(ExprNode _retExpr, position pos) {
        super(pos);
        retExpr = _retExpr;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
