package Util;

import java.util.ArrayList;

public class FunctionDef {
    public Type retType;
    public ArrayList<Type> paraType = new ArrayList<>();
    public String name;
    public FunctionDef(Type _retType, String _name, ArrayList<Type> _paraType) {
        retType = new Type(_retType.name, _retType.dims);
        name = _name;

        if (_paraType != null) {
            for (Type paraMember : _paraType) {
                paraType.add(new Type(paraMember.name, paraMember.dims));
            }
        }
    }

    @Override public boolean equals(Object other) {
        //ignore retType differences
        if (other instanceof FunctionDef ) {
            FunctionDef etc = (FunctionDef) other;

            if (!name.equals(etc.name)) return false;
            if (paraType.size() != etc.paraType.size()) return false;
            for (int i = 0 ; i < paraType.size() ; i++) {
                if (!paraType.get(i).equals(etc.paraType.get(i))) return false;
            }
            return true;
        }
        return false;
    }

    @Override public int hashCode() {
        int result = name.hashCode();
        if (paraType != null)
            for (Type paraMember : paraType) result += paraMember.hashCode();
        return result;
    }
    public boolean equalwith(FunctionDef _def) {
        return equals(_def) && retType.equalwith(_def.retType);
    }
}
