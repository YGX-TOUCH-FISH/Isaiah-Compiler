package LLVMIR.Inst;

import LLVMIR.Oprand.Oprand;

public class StoreInst extends Inst{
    public Oprand storeValue, storeAddr;
    public StoreInst(Oprand _storeValue, Oprand _storeAddr) {
        storeValue = _storeValue;
        storeAddr  = _storeAddr;
    }
    @Override public String toString() {
        return "store "+storeValue.toString()+", "+storeAddr.toString();
    }
}
