package LLVMIR.Type;

public class ArrayType extends BaseType{
    public BaseType elementType;
    public Integer  dimSize;
    public ArrayType(BaseType _elementType, int _dimSize) {
        elementType = _elementType;
        dimSize     = _dimSize;
    }
    @Override public String toString() {
        return " ["+dimSize.toString()+" x "+elementType.toString()+"] ";
    }
}
