package LLVMIR.Type;

import LLVMIR.Oprand.Oprand;

public class NullType extends BaseType{
    public NullType(){

    }
    @Override public String toString() {
        return "";
    }

    @Override public Oprand getZeroInit() {
        return null;
    }
}
