package LLVMIR.Inst;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;

public class IcmpInst extends Inst{
    // always comparing same type
    public enum CompareType {
        eq, ne, sgt, slt, sge, sle
    }
    CompareType cmpType;
    VirtualReg  resultReg;
    Oprand lhs, rhs;
    public IcmpInst(VirtualReg _result, CompareType _cmpType, Oprand _lhs, Oprand _rhs) {
        resultReg = _result;
        cmpType = _cmpType;
        lhs = _lhs;
        rhs = _rhs;
    }
    @Override public String toString() {
        return resultReg.toName()+" = icmp "+cmpType.toString()+lhs.baseType.toString()+" "+lhs.toName()+", "+rhs.toName();
    }

}
