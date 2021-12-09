package LLVMIR.Oprand;

import LLVMIR.Type.IntType;

public class ConstInt extends Oprand{
    public Integer value;
    public ConstInt(int _width, int _value) {
        super(new IntType(_width));
        value = _value;
    }
    public int getIntValue() { return value; }
    @Override public String toString() {
        return baseType.toString()+" "+value.toString();
    }

    @Override
    public String toName() {
        return value.toString();
    }
}
