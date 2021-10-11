package AST.Stmt;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import Util.position;

public class ExprStNode extends StmtNode{
    public ExprNode expr;
    public ExprStNode(ExprNode _expr, position pos) {
        super(pos);
        expr = _expr;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
