package AST.Stmt;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import Util.position;

public class CondStNode extends StmtNode{
    public ExprNode condition;
    public StmtNode ifStmt;
    public StmtNode elseStmt;
    public CondStNode(ExprNode _cond, StmtNode _if, StmtNode _else, position pos) {
        super(pos);
        condition = _cond;
        ifStmt = _if;
        elseStmt = _else;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
