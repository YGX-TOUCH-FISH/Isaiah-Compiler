package LLVMIR.Type;

import LLVMIR.Oprand.ConstNull;
import LLVMIR.Oprand.Oprand;

public class PointerType extends BaseType{
    public BaseType referType;
    public PointerType(BaseType _referType) {
        referType = _referType;
    }
    @Override public String toString() {
        return referType.toString()+"*";
    }

    @Override public Oprand getZeroInit() {
        return new ConstNull();
    }
}
