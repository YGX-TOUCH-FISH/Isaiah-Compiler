package LLVMIR.Inst;

import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;
import LLVMIR.Type.PointerType;

public class AllocaInst extends Inst{
    public VirtualReg allocReg;
//    public Integer    allocSize;
//    public AllocaInst(VirtualReg _reg, int _size) {
//        allocReg  = _reg;
//        allocSize = _size;
//    }
    public AllocaInst(VirtualReg _reg) {
        allocReg = _reg;
    }
    @Override public String toString() {
        PointerType pointerType = (PointerType) allocReg.baseType;
        return  allocReg.toName()+" = alloca "+pointerType.referType.toString();
//        if (allocSize > 1) ret += " "+allocSize.toString();
//        return ret;
    }
}
