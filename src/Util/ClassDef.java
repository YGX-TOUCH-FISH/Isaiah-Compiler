package Util;

import Util.error.semanticError;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ClassDef {
//    public ArrayList<String> ids = new ArrayList<>();
//    public ArrayList<Type> types = new ArrayList<>();
    public HashMap<String, Type> varDefs = new HashMap<>();
    public HashMap<FunctionDef, Type> funcDefs = new HashMap<>();
    public String identifier;
    public ClassDef(String _identifier) {
        identifier = _identifier;
    }



    public void addMember(String _id, Type _type, position _pos) {
//        if (ids.contains(_id))
//            throw new semanticError("[ERROR]redefinition of member variable in class "+ identifier + ": ", _pos);
//        types.add(_type);
//        ids.add(_id);
        if (varDefs.containsKey(_id))
            throw new semanticError("[ERROR]redefinition of member variable in class "+ identifier + ": ", _pos);

        varDefs.put(_id, _type);

    }
    public boolean containsMember(String _id) {
        return varDefs.containsKey(_id);
    }
    public Type getMemberType(String _id) {
        return varDefs.get(_id);
    }

    public void addFuncDef(FunctionDef _def, position _pos) {
        if (funcDefs.containsKey(_def))
            throw new semanticError("[ERROR]redefinition of member function in class "+ identifier + ": ", _pos);
        funcDefs.put(_def, _def.retType);
    }
    public boolean containsFunc(FunctionDef _def) {
        return funcDefs.containsKey(_def);
    }
    public Type getFuncType(FunctionDef _def) {
        return funcDefs.get(_def);
    }
}
