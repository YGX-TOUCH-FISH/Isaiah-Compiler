package LLVMIR.Inst;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;
import LLVMIR.Type.PointerType;

public class StoreInst extends Inst{
    public Oprand storeValue, storeAddr;
    public StoreInst(Oprand _storeValue, Oprand _storeAddr) {
        storeValue = _storeValue;
        storeAddr  = _storeAddr;
    }
    @Override public String toString() {
        BaseType ptrType = ((PointerType)((VirtualReg) storeAddr).baseType).referType;
        return "store "+ptrType.toString()+" "+storeValue.toName()+", "+storeAddr.toString();
    }
}
