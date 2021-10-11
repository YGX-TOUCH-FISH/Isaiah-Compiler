package AST.Expr;

import AST.ASTVisitor;
import Util.position;

public class PrefixExprNode extends ExprNode{
    public enum PreOp {
        INC, DEC
    }
    public ExprNode rhs;
    public PreOp op;
    public PrefixExprNode(PreOp _op, ExprNode _rhs, position pos) {
        super(pos);
        op = _op;
        rhs = _rhs;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
