package LLVMIR.Inst;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;

public class BitCastInst extends Inst{
    public Oprand     origin;
    public VirtualReg destReg;
    public BaseType   destType;
    public BitCastInst(Oprand _origin, BaseType _destType, VirtualReg _destReg) {
        origin   = _origin;
        destType = _destType;
        destReg  = _destReg;
    }
    @Override public String toString() {
        return destReg.toName()+" = bitcast "+origin.toString()+" to "+destType.toString();
    }
}
