package Util;

public class Type {
    String baseType;
    int dims;
    public Type(String type, int dimSize) {
        baseType = type;
        dims = dimSize;
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof Type _type) {
            return baseType.equals(_type.baseType) && dims == _type.dims;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return baseType.hashCode()*dims;
    }
}
