package LLVMIR.Oprand;

import LLVMIR.Type.BaseType;

public class VirtualReg extends Oprand{
    public Integer label;
    public VirtualReg(BaseType _type, int _label) {
        super(_type);
        label = _label;
    }
    public String toString() {
        //print Type & name
        return baseType.toString()+" %"+ label.toString();
    }
    public String toName() {
        return "%"+ label.toString();
    }
}
