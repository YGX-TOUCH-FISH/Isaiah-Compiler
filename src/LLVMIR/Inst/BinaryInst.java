package LLVMIR.Inst;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
// ensure lhs-type equals with rhs-type
public class BinaryInst extends Inst{
    public enum BiArOp {
        add, sub, mul, sdiv, srem,          //basic op, but some tags? nsw...
        shl, ashr, and, or, xor      //bit op, support '!' by zext
    }
    BiArOp operator;
    Oprand        lhs, rhs;
    VirtualReg    resultReg;

    public BinaryInst(VirtualReg _result, BiArOp _operator, Oprand _lhs, Oprand _rhs) {
        resultReg = _result;
        lhs = _lhs; rhs = _rhs;
        operator = _operator;
    }

    @Override public String toString() {
        return resultReg.toName()+" = "+operator.toString()+" "+lhs.toString()+", "+rhs.toString();
    }

}
