package LLVMIR.Type;

import LLVMIR.Oprand.ConstNull;
import LLVMIR.Oprand.Oprand;
import Util.error.irError;
import Util.position;

public class NullType extends BaseType{
    public NullType(){

    }
    @Override public String toString() {
        return "";
    }

    @Override public Oprand getZeroInit() {
        return new ConstNull();
    }

    @Override
    public boolean isStringType() {
        return false;
    }

    @Override
    public int getByteWidth() {
        throw new irError("[ERROR] illegal visit : no valid method to access sizeof(Null)", new position(0, 0));
    }

}
