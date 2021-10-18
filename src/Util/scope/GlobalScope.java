package Util.scope;

import Util.ClassDef;
import Util.Type;
import Util.FunctionDef;
import Util.error.semanticError;
import Util.position;

import java.util.HashMap;
import java.util.HashSet;

public class GlobalScope extends Scope{
    //TODO: collect all Type definition
    //      because of cannot define Class in any Function

    HashMap<String, ClassDef> classDefs = new HashMap<>();
    HashMap<FunctionDef, Type> functionDefs = new HashMap<>();
    public GlobalScope(Scope _parent) {
        super(_parent);
    }

    public void addClassDef(String _name, ClassDef _classDef, position pos) {
        if (classDefs.containsKey(_name))
            throw new semanticError("[ERROR]redefinition CLASS of " + _name, pos);
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
            throw new semanticError("[ERROR]redefinition FUNCTION of " + _funcDef.name, pos);
        functionDefs.put(_funcDef, _funcDef.retType);
    }
    public boolean containsFunc(FunctionDef _funcDef) {
        return functionDefs.containsKey(_funcDef);
    }
    public Type getFuncType(FunctionDef _funcDef) { return functionDefs.get(_funcDef); }
    public void initialize() {
        //basic class
        addClassDef("bool", new ClassDef("bool"), new position(0, 0));
        addClassDef("int", new ClassDef("bool"), new position(0, 0));
        addClassDef("string", new ClassDef("bool"), new position(0, 0));
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
