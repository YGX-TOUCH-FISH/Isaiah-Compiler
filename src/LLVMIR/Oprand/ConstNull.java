package LLVMIR.Oprand;

import LLVMIR.Type.IntType;
import LLVMIR.Type.NullType;
import LLVMIR.Type.PointerType;

public class ConstNull extends Oprand{
    public ConstNull() {
        super(new NullType());
    }
    @Override public String toString() {
        return "null";
    }

    @Override
    public String toName() {
        return "null";
    }
}
