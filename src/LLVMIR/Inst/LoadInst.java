package LLVMIR.Inst;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Pass;
import LLVMIR.Type.PointerType;

public class LoadInst extends Inst{
    public VirtualReg resultReg;       // load to ...
    public VirtualReg address;         // load address
    public LoadInst(VirtualReg _result, VirtualReg _address) {
        resultReg  = _result;
        address    = _address;
    }
    @Override public String toString() {
        PointerType addrType = (PointerType) address.baseType;
        return resultReg.toName()+" = load "+addrType.referType.toString()+", "+ address.toString();
    }
    @Override public void accept(Pass visitor) {visitor.visit(this);}
}
