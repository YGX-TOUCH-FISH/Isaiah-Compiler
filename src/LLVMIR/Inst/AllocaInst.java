package LLVMIR.Inst;

import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;
import LLVMIR.Type.PointerType;

public class AllocaInst extends Inst{
    public VirtualReg allocReg;
    public AllocaInst(VirtualReg _reg) {
        allocReg = _reg;
    }
    @Override public String toString() {
        PointerType pointerType = (PointerType) allocReg.baseType;
        return  allocReg.toName()+" = alloca "+pointerType.referType.toString();
    }
}
