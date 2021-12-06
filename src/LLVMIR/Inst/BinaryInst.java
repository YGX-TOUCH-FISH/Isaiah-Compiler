package LLVMIR.Inst;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
// ensure lhs-type equals with rhs-type
public class BinaryInst extends Inst{
    enum ArithOperator {
        add, sub, mul, sdiv, srem,          //basic op, but some tags? nsw...
        shl, ashr, and, or, xor, zext,      //bit op, support '!' by zext
    }
    ArithOperator operator;
    Oprand        lhs, rhs;
    VirtualReg    resultReg;

    public BinaryInst(VirtualReg _result, ArithOperator _operator, Oprand _lhs, Oprand _rhs) {
        resultReg = _result;
        lhs = _lhs; rhs = _rhs;
        operator = _operator;
    }

    @Override public String toString() {
        return resultReg.toName()+" = "+operator.toString()+" "+lhs.toString()+", "+rhs.toString();
    }

}
