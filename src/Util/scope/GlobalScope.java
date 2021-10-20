package Util.scope;

import Util.ClassDef;
import Util.Type;
import Util.FunctionDef;
import Util.error.semanticError;
import Util.position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GlobalScope extends Scope{
    //TODO: collect all Type definition
    //      because of cannot define Class in any Function

    HashMap<String, ClassDef> classDefs = new HashMap<>();
    HashMap<String, FunctionDef> functionDefs = new HashMap<>();
    HashSet<String> nameCollection = new HashSet<>();

    public GlobalScope(Scope _parent) {
        super(_parent);
    }

    public void addClassDef(String _name, ClassDef _classDef, position pos) {
        if (classDefs.containsKey(_name))
            throw new semanticError("[ERROR]redefinition CLASS of " + _name+": ", pos);
        if (nameCollection.contains(_name))
            throw new semanticError("[ERROR]duplicated name for "+_name+": ", pos);
        nameCollection.add(_name);
        classDefs.put(_name, _classDef);
    }
    public boolean containsClass(String _name) {
        return classDefs.containsKey(_name);
    }
    public ClassDef getClassByName(String _name) {
        return classDefs.get(_name);
    }

    public void addFuncDef(FunctionDef _funcDef, position pos) {
        if (functionDefs.containsKey(_funcDef))
            throw new semanticError("[ERROR]redefinition FUNCTION of " + _funcDef.name+": ", pos);
        if (nameCollection.contains(_funcDef.name))
            throw new semanticError("[ERROR]duplicated name for "+_funcDef.name+": ", pos);
//        nameCollection.add(_funcDef.name);
        functionDefs.put(_funcDef.name, _funcDef);
    }
    public boolean containsFunc(String _funcName) {
        return functionDefs.containsKey(_funcName);
    }
//    public Type getFuncType(String _funcName) { return functionDefs.get(_funcName).retType; }

    public FunctionDef getFunc(String _funcName) {
        return functionDefs.get(_funcName);
    }
//    public ArrayList<Type> getFuncPara(String _funcName) {return functionDefs.get(_funcName).paraType;}
    //getFuncType(String)
    public boolean inCollection(String _name) {
        return nameCollection.contains(_name);
    }
    public void initialize() {
        ClassDef strDef = new ClassDef("string");
        FunctionDef length = new FunctionDef(new Type("int", 0), "length", null);
        FunctionDef substring = new FunctionDef(new Type("string", 0), "substring", null);
        substring.paraType.add(new Type("int", 0));
        substring.paraType.add(new Type("int", 0));
        FunctionDef parseInt = new FunctionDef(new Type("int", 0), "parseInt", null);
        FunctionDef ord = new FunctionDef(new Type("int", 0), "ord", null);
        ord.paraType.add(new Type("int", 0));
        strDef.addFuncDef(length, new position(0, 0));
        strDef.addFuncDef(substring, new position(0,0));
        strDef.addFuncDef(parseInt, new position(0, 0));
        strDef.addFuncDef(ord, new position(0, 0));

        ClassDef arrayDef = new ClassDef("class[]");
        FunctionDef size = new FunctionDef(new Type("int", 0), "size", null);
        arrayDef.addFuncDef(size, new position(0, 0));

        addClassDef("bool", new ClassDef("bool"), new position(0, 0));
        addClassDef("int", new ClassDef("int"), new position(0, 0));
        addClassDef("string", strDef, new position(0, 0));
        addClassDef("class[]", arrayDef, new position(0, 0)); //arrayDef
        //basic function
        FunctionDef print = new FunctionDef(new Type("void", 0), "print", null);
        print.paraType.add(new Type("string", 0));

        FunctionDef println = new FunctionDef(new Type("void", 0), "println", null);
        println.paraType.add(new Type("string", 0));

        FunctionDef printInt = new FunctionDef(new Type("void", 0), "printInt", null);
        printInt.paraType.add(new Type("int", 0));

        FunctionDef printlnInt = new FunctionDef(new Type("void", 0), "printlnInt", null);
        printlnInt.paraType.add(new Type("int", 0));

        FunctionDef getString = new FunctionDef(new Type("string", 0), "getString", null);

        FunctionDef getInt = new FunctionDef(new Type("int", 0), "getInt", null);

        FunctionDef toString = new FunctionDef(new Type("string", 0), "toString", null);
        toString.paraType.add(new Type("int", 0));

        addFuncDef(print,new position(0, 0));
        addFuncDef(println, new position(0, 0));
        addFuncDef(printInt, new position(0, 0));
        addFuncDef(printlnInt, new position(0, 0));
        addFuncDef(getString, new position(0, 0));
        addFuncDef(getInt, new position(0, 0));
        addFuncDef(toString, new position(0, 0));
    }
}
