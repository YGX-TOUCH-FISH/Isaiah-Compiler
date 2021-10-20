package Util;

import Util.error.semanticError;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Objects;

public class Type {
    public String name;
    public int dims;
    public Type() {
        name = null;
        dims = 0;
    }
    public Type(Type etc) {
        name = etc.name;
        dims = etc.dims;
    }
    public Type(String type, int dimSize) {
        name = type;
        dims = dimSize;
    }

    @Override public boolean equals(Object other) {
        if (other instanceof Type) {
            Type _type = (Type) other;
            return name.equals(_type.name) && dims == _type.dims;
        }
        return false;
    }

    @Override public int hashCode() {
        return name.hashCode()*dims;
    }

    public boolean isNull() {
        return Objects.equals(name, "null") && dims == 0;
    }
    public boolean isInt() {
        return Objects.equals(name, "int") && dims == 0;
    }
    public boolean isBool() {
        return Objects.equals(name, "bool") && dims == 0;
    }
    public boolean isString() {
        return Objects.equals(name, "string") && dims == 0;
    }
    public boolean isVoid() {
        return Objects.equals(name, "void") && dims == 0;
    }
    public boolean isConstructor() {
        return Objects.equals(name, "class") && dims == 0;
    }
    public boolean isClass() {
        return !isNull() && !isInt() && !isBool() && !isString() && !isVoid() && !isArray() && !isConstructor();
    }
    public boolean isArray() {
        return dims >= 1;
    }

    public boolean equalwith(Type etc) {
        return Objects.equals(name, etc.name) && dims == etc.dims;
    }

    public boolean assignable(Type etc) {
        if (etc.isNull()) return (isClass() || isArray());
        else return equalwith(etc);
    }
}
