package LLVMIR.Type;

public class PointerType extends BaseType{
    public BaseType referType;
    public PointerType(BaseType _referType) {
        referType = _referType;
    }
    @Override public String toString() {
        return referType.toString()+"*";
    }
}
