package LLVMIR.Inst;

import LLVMIR.Oprand.ConstNull;
import LLVMIR.Oprand.Oprand;
import LLVMIR.Type.BaseType;

public class RetInst extends Inst{
    Oprand retValue;
    BaseType nullptrType;
    public RetInst(Oprand _retValue, BaseType _Type) {
        retValue = _retValue;
        nullptrType = _Type;
    }
    public RetInst() {
        retValue = null;
    }
    @Override public String toString() {
        String retValueStr;
        if (retValue == null) retValueStr = "void";
        else {
            if (retValue instanceof ConstNull) retValueStr = nullptrType.toString()+" null";
            else retValueStr = retValue.toString();
        }
        return "ret "+retValueStr;
    }
}
