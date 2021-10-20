package Util;

import Util.error.semanticError;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ClassDef {
    public HashMap<String, Type> varDefs = new HashMap<>();
    public HashMap<String, FunctionDef> funcDefs = new HashMap<>();
    public String identifier;
    public ClassDef(String _identifier) {
        identifier = _identifier;
    }



    public void addMember(String _id, Type _type, position _pos) {
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
        if (_def.name.equals(identifier) && !_def.retType.isConstructor())
            throw new semanticError("[ERROR]constructor return-type error: ", _pos);
        funcDefs.put(_def.name, _def);
    }
    public boolean containsFunc(String _funcName) {
        return funcDefs.containsKey(_funcName);
    }
//    public Type getFuncType(String _funcName) {
//        return funcDefs.get(_funcName).retType;
//    }
    public FunctionDef getFunc(String _funcName) {
        return funcDefs.get(_funcName);
    }
//    public ArrayList<Type> getFuncPara(String _funcName) {return funcDefs.get(_funcName).paraType;}
}
