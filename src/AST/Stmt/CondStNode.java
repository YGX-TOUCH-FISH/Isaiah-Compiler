package AST.Stmt;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import Util.position;

public class CondStNode extends StmtNode{
    public ExprNode condition;
    public ExprNode ifExpr;
    public ExprNode elseExpr;
    public CondStNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
