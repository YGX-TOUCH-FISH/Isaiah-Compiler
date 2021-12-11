package LLVMIR.Type;

import LLVMIR.Oprand.Oprand;
import Util.error.irError;
import Util.error.semanticError;
import Util.position;

public class VoidType extends BaseType{
    public VoidType() {}
    @Override public String toString() {
        return "void";
    }
    @Override public Oprand getZeroInit() {
        throw new irError("[ERROR] void type has no initial value.", new position(0, 0));
    }

    @Override
    public boolean isStringType() {
        return false;
    }
}
