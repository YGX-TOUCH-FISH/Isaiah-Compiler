package LLVMIR.Inst;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Pass;
import LLVMIR.Type.BaseType;
import LLVMIR.Type.PointerType;

public class StoreInst extends Inst{
    public Oprand storeValue;
    public VirtualReg storeTarget;
    public StoreInst(Oprand _storeValue, VirtualReg _storeAddr) {
        storeValue = _storeValue;
        storeTarget = _storeAddr;
    }
    @Override public String toString() {
        BaseType ptrType = ((PointerType)((VirtualReg) storeTarget).baseType).referType;
        return "store "+ptrType.toString()+" "+storeValue.toName()+", "+ storeTarget.toString();
    }
    @Override public void accept(Pass visitor) {visitor.visit(this);}
}
