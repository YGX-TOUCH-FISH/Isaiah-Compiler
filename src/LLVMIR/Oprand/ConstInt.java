package LLVMIR.Oprand;

import LLVMIR.Type.BaseType;

public class ConstInt extends Oprand{
    Integer value;
    public ConstInt(BaseType _type, int _value) {
        super(_type);
        value = _value;
    }

    @Override public String toString() {
        return type.toString()+" "+value.toString();
    }

    @Override
    public String toName() {
        return value.toString();
    }
}
