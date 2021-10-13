package Util;

import java.util.ArrayList;

public class FunctionDef {
    public Type retType;
    public ArrayList<Type> paraType = new ArrayList<>();
    public String name;
    public FunctionDef(Type _retType, String _name, ArrayList<Type> _paraType) {
        retType = new Type(_retType.baseType, _retType.dims);
        name = _name;
        for (Type paraMember : _paraType)
            paraType.add(new Type(paraMember.baseType, paraMember.dims));
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof FunctionDef etc) {
            if (!retType.equals(etc.retType)) return false;
            if (paraType.size() != etc.paraType.size()) return false;
            if (!name.equals(etc.name)) return false;
            for (int i = 0 ; i < paraType.size() ; i++) {
                if (!paraType.get(i).equals(etc.paraType.get(i))) return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = retType.hashCode() + name.hashCode();
        for (Type paraMember : paraType) result += paraMember.hashCode();
        return result;
    }
}
