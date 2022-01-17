package LLVMIR.Inst;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Pass;

public class IcmpInst extends Inst{
    // always comparing same type
    public enum CompareType {
        eq, ne, sgt, slt, sge, sle
    }
    public final CompareType cmpType;
    public VirtualReg  resultReg;
    public Oprand lhs, rhs;
    public IcmpInst(VirtualReg _result, CompareType _cmpType, Oprand _lhs, Oprand _rhs) {
        resultReg = _result;
        cmpType = _cmpType;
        lhs = _lhs;
        rhs = _rhs;
    }
    @Override public String toString() {
        return resultReg.toName()+" = icmp "+cmpType.toString()+" "+lhs.baseType.toString()+" "+lhs.toName()+", "+rhs.toName();
    }
    @Override public void accept(Pass visitor) {visitor.visit(this);}

}
