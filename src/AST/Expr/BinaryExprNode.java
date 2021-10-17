package AST.Expr;

import AST.ASTVisitor;
import Util.position;

public class BinaryExprNode extends ExprNode{
    public enum BinaryOp{
        ADD, SUB,
        MUL, DIV, MOD,
        LSH, RSH,
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
    public BinaryOp op;
    public BinaryExprNode(ExprNode _lhs, BinaryOp _op, ExprNode _rhs, position pos) {
        super(pos);
        lhs = _lhs;
        op  = _op;
        rhs = _rhs;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
