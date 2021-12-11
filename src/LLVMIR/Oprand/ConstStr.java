package LLVMIR.Oprand;

import LLVMIR.Type.ArrayType;
import LLVMIR.Type.BaseType;
import LLVMIR.Type.IntType;

public class ConstStr extends Oprand{
    public String str;
    public ConstStr(String _str) {
        super(new ArrayType(new IntType(8), _str.length()));
        str = _str;
    }

    @Override public String toString() {
        return null;
    }

    @Override public String toName() {
        return null;
    }
}
