package AST.Expr;

import AST.ASTVisitor;
import Util.position;

public class UnaryExprNode extends ExprNode{
    public enum UnaryOp {
        LNOT, BNOT, //Logic NOT(!) ; Bitwise NOT(~)
        POS , NEG , //POSITIVE(+)  ; NEGATIVE(-)
    }
    public UnaryOp op;
    public ExprNode rhs;
    //form like [Op Expr]
    public UnaryExprNode(UnaryOp _op, ExprNode _rhs, position pos) {
        super(pos);
        op = _op;
        rhs = _rhs;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
