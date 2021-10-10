package AST.Expr;

import AST.ASTVisitor;
import Util.position;

public class SuffixExprNode extends ExprNode{
    public enum SufOp{
        INC, DEC
    }
    public ExprNode lhs;
    public SufOp op;
    public SuffixExprNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
