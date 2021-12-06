package LLVMIR.Oprand;

import LLVMIR.Type.BaseType;

public class ConstBool extends Oprand{
    Boolean value;

    public ConstBool(BaseType _type, boolean _value) {
        super(_type);
        value = _value;
    }

    @Override
    public String toString() {
        return type.toString()+" "+value.toString();
    }

    @Override
    public String toName() {
        return value.toString();
    }
}
