package LLVMIR.Type;

import LLVMIR.Oprand.ConstInt;
import LLVMIR.Oprand.ConstNull;
import LLVMIR.Oprand.Oprand;

public class PointerType extends BaseType{
    public BaseType referType;
    public PointerType(BaseType _referType) {
        referType = _referType;
    }
    public PointerType(BaseType _referType, int _dim) {
        if (_dim == 1) referType = _referType;
        else referType = new PointerType(_referType, _dim-1);
    }
    @Override public String toString() {
        return referType.toString()+"*";
    }

    @Override public Oprand getZeroInit() {
        return new ConstNull();
    }

    @Override
    public boolean isStringType() {
        return (referType instanceof IntType && ((IntType)referType).bitWidth == 8);
    }
}
