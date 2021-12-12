package LLVMIR.Inst;

import LLVMIR.Oprand.Oprand;

public class RetInst extends Inst{
    Oprand retValue;
    public RetInst(Oprand _retValue) {
        retValue = _retValue;
    }
    @Override public String toString() {
        String retValueStr = retValue != null ? retValue.toString() : "void";
        return "ret "+retValueStr;
    }
}
