package LLVMIR.Oprand;

import LLVMIR.Inst.Inst;
import LLVMIR.Type.IntType;

public class ConstInt extends Oprand{
    public Long intValue;
    public ConstInt(int _width, long _value) {
        super(new IntType(_width));
        intValue = _value;
    }
    public long getIntValue() { return intValue; }
    @Override public String toString() {
        if (((IntType) baseType).bitWidth == 1) {
            String value = intValue == 0 ? "false" : "true";
            return baseType+" "+value;
        }
        else return baseType+" "+ intValue.toString();
    }

    @Override
    public String toName() {
        if (((IntType) baseType).bitWidth == 1) return intValue == 0 ? "false" : "true";
        else return intValue.toString();
    }
}
