package AST.Expr;

import AST.ASTVisitor;
import Util.position;

public class UnaryExprNode extends ExprNode{
    public enum unaryOp {
        LNOT, BNOT, //Logic NOT(!) ; Bitwise NOT(~)
        POS , NEG , //POSITIVE(+)  ; NEGATIVE(-)
    }
    public unaryOp op;
    public ExprNode rhs;
    //form like [Op Expr]
    public UnaryExprNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
