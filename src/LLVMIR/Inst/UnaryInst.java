package LLVMIR.Inst;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;

public class UnaryInst extends Inst{
    // support extend inst for now
    public enum UArOp {
        sext, zext
    }
    UArOp operator;
    VirtualReg resultReg;
    Oprand oprand;
    BaseType targetType;
    public UnaryInst(VirtualReg _result, UArOp _operator, Oprand _oprand, BaseType _target) {
        resultReg = _result;
        operator = _operator;
        oprand = _oprand;
        targetType = _target;
    }
    @Override public String toString() {
        return resultReg.toName()+" = "+operator.toString()+" "+oprand.toString()+" to "+targetType.toString();
    }
}
