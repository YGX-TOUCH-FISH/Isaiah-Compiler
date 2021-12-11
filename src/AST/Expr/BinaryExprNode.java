package AST.Expr;

import AST.ASTVisitor;
import LLVMIR.Inst.BinaryInst;
import LLVMIR.Inst.IcmpInst;
import Util.position;

import static LLVMIR.Inst.BinaryInst.BiArOp.*;

public class BinaryExprNode extends ExprNode{
    public enum BinaryOp{
        ADD, SUB,
        MUL, DIV, MOD,
        LSH, RSH,
        LT , GT ,
        LEQ, GEQ,
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
    @Override public void accept(ASTVisitor visitor) {visitor.visit(this);}
    public IcmpInst.CompareType getCmpType() {
        switch (op) {
            case LT: return IcmpInst.CompareType.slt;
            case GT: return IcmpInst.CompareType.sgt;
            case LEQ:return IcmpInst.CompareType.sle;
            case GEQ:return IcmpInst.CompareType.sge;
            case EQ: return IcmpInst.CompareType.eq;
            case NEQ:return IcmpInst.CompareType.ne;
            default: return null;
        }
    }
    public BinaryInst.BiArOp getBiArType() {
        switch (op) {
            case ADD: return add;
            case SUB: return sub;
            case MUL: return mul;
            case DIV: return sdiv;
            case MOD: return srem;
            case LSH: return shl;
            case RSH: return ashr;
            case AND: return and;
            case XOR: return xor;
            case OR:  return or;
            default:  return null;
        }
    }
}
