package Util;

import Util.error.semanticError;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.HashSet;

public class ClassDef {
    public ArrayList<String> ids = new ArrayList<>();
    public ArrayList<Type> types = new ArrayList<>();
    public HashSet<FunctionDef> funcDefs = new HashSet<>();
    public String identifier;
    public ClassDef(String _identifier) {
        identifier = _identifier;
    }

    public void addFuncDef(FunctionDef _def, position _pos) {
        if (funcDefs.contains(_def))
            throw new semanticError("[ERROR]redefinition of member function in class "+ identifier + ": ", _pos);
        funcDefs.add(_def);
    }

    public void addMember(String _id, Type _type, position _pos) {
//        if (ids.contains(_id))
//            throw new semanticError("[ERROR]redefinition of member variable in class "+ identifier + ": ", _pos);
        types.add(_type);
        ids.add(_id);
    }

    public boolean containsMember(String _id) {
        return ids.contains(_id);
    }
    public Type getMemberType(String _id) {
        return types.get(ids.indexOf(_id));
    }
    public boolean containsFunc(FunctionDef _def) {
        return funcDefs.contains(_def);
    }
}
