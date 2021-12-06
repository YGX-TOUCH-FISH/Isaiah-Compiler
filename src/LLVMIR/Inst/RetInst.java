package LLVMIR.Inst;

import LLVMIR.Oprand.VirtualReg;

public class RetInst extends Inst{
    VirtualReg destReg;
    public RetInst(VirtualReg _destReg) {
        destReg = _destReg;
    }
    @Override public String toString() {
        return "ret "+destReg.toString();
    }
}
