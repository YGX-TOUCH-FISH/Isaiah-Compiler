package AST.Stmt;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import Util.position;

public class CondStNode extends StmtNode{
    public ExprNode condition;
    public StmtNode ifExpr;
    public StmtNode elseExpr;
    public CondStNode(ExprNode _cond, StmtNode _if, StmtNode _else, position pos) {
        super(pos);
        condition = _cond;
        ifExpr = _if;
        elseExpr = _else;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
