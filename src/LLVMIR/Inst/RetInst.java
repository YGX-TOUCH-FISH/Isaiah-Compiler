package LLVMIR.Inst;

import LLVMIR.Oprand.ConstNull;
import LLVMIR.Oprand.Oprand;
import LLVMIR.Pass;
import LLVMIR.Type.BaseType;

public class RetInst extends Inst{
    public Oprand retValue;
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
    @Override public void accept(Pass visitor) {visitor.visit(this);}
}
