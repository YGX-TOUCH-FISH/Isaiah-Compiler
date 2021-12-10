package LLVMIR.Oprand;

import LLVMIR.Type.BaseType;

public class VirtualReg extends Oprand{
    public Integer label;
    public String  name;
    public VirtualReg(BaseType _type, int _label) {
        super(_type);
        label = _label;
        name  = null;
    }
    public VirtualReg(BaseType _type, String _name) {
        super(_type);
        name = _name;   // _name != null
    }
    public String toString() {
        //print Type & name
        if (name == null) return baseType.toString()+" %"+ label.toString();
        else return baseType.toString()+" @"+name;
    }
    public String toName() {
        if (name == null) return "%"+ label.toString();
        else return "@"+name;

    }
}
