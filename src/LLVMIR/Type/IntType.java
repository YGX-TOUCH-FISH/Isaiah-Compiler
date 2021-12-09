package LLVMIR.Type;

import LLVMIR.Oprand.ConstInt;
import LLVMIR.Oprand.Oprand;

// i64, i32, i8, i1
public class IntType extends BaseType{
    Integer bitWidth;
    public IntType(int _bitWidth) {
        bitWidth = _bitWidth;
    };
    @Override public String toString() {
        return "i"+bitWidth.toString();
    }
    @Override public Oprand getZeroInit() {
        return new ConstInt(bitWidth, 0);
    }
}
