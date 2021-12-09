package LLVMIR.Inst;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;

public class BitCastInst extends Inst{
    public VirtualReg srcReg;
    public VirtualReg destReg;
    public BitCastInst(VirtualReg _srcReg, VirtualReg _destReg) {
        srcReg   = _srcReg;
        destReg  = _destReg;
    }
    @Override public String toString() {
        return destReg.toName()+" = bitcast "+srcReg.toString()+" to "+destReg.baseType.toString();
    }
}
