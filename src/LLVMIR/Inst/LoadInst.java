package LLVMIR.Inst;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.PointerType;

public class LoadInst extends Inst{
    VirtualReg resultReg;
    Oprand address;             //
    public LoadInst(VirtualReg _result, Oprand _address) {
        resultReg  = _result;
        address    = _address;
    }
    @Override public String toString() {
        PointerType addrType = (PointerType) address.type;
        return resultReg.toName()+" = load "+addrType.referType.toString()+", "+ address.toString();
    }
}
