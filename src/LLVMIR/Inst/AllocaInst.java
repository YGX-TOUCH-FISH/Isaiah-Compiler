package LLVMIR.Inst;

import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;

public class AllocaInst extends Inst{
    public VirtualReg allocReg;
    public BaseType   allocType;
    public Integer    allocSize;
    public AllocaInst(VirtualReg _alloc, BaseType _type, int _size) {
        allocReg  = _alloc;
        allocType = _type;
        allocSize = _size;
    }
    @Override public String toString() {
        String ret = allocReg.toName()+" = alloca "+allocType.toString();
        if (allocSize > 1) ret += " "+allocSize.toString();
        return ret;
    }
}
