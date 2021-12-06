package LLVMIR.Type;
// i32, i8
public class IntType extends BaseType{
    Integer bitWidth;
    public IntType(int _bitWidth) {
        bitWidth = _bitWidth;
    }
    @Override public String toString() {
        return "i"+bitWidth.toString();
    }
}
