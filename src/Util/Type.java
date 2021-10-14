package Util;

public class Type {
    String baseType;
    int dims;
    public Type() {
        baseType = "";
        dims = 0;
    }
    public Type(String type, int dimSize) {
        baseType = type;
        dims = dimSize;
    }

    @Override public boolean equals(Object other) {
        if (other instanceof Type) {
            Type _type = (Type) other;
            return baseType.equals(_type.baseType) && dims == _type.dims;
        }
        return false;
    }

    @Override public int hashCode() {
        return baseType.hashCode()*dims;
    }
}
