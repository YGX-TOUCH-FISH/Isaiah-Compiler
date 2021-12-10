package LLVMIR.Oprand;

import LLVMIR.Type.IntType;

public class ConstInt extends Oprand{
    public Long intValue;
    public ConstInt(int _width, long _value) {
        super(new IntType(_width));
        intValue = _value;
    }
    public long getIntValue() { return intValue; }
    @Override public String toString() {
        return baseType.toString()+" "+ intValue.toString();
    }

    @Override
    public String toName() {
        return intValue.toString();
    }
}
