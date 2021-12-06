package LLVMIR.Oprand;

import LLVMIR.Type.BaseType;

public class VirtualReg extends Oprand{
    public Integer number;
    public VirtualReg(BaseType _type, int _number) {
        super(_type);
        number  = _number;
    }
    public String toString() {
        //print Type & name
        return type.toString()+" %"+number.toString();
    }
    public String toName() {
        return "%"+number.toString();
    }
}
