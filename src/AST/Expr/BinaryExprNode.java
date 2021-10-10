package AST.Expr;

import AST.ASTVisitor;
import Util.position;

public class BinaryExprNode extends ExprNode{
    public enum binaryOp{
        DOT,
        ADD, SUB,
        MUL, DIV, MOD,
        SHL, SHR,
        LT , GT ,
        LEQ, REQ,
        EQ , NEQ,
        AND,
        XOR,
        OR,
        ANDAND,
        OROR,
        ASSIGN
    }
    public ExprNode lhs;
    public ExprNode rhs;
    public binaryOp op;
    public BinaryExprNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
