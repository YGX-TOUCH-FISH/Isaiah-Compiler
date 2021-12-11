package LLVMIR;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Type.BaseType;
import LLVMIR.Type.ClassType;
import Util.error.irError;
import Util.position;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// Top Module
public class IRModule {
    public HashMap<String, Function>  builtInFunctions;
    public HashMap<String, Function>  customFunctions;  // "classname.func" or "func"
    public HashMap<String, ClassInfo> customClasses;
    public HashMap<String, BaseType>  staticData; // .data & .bss

    public Function strADD;
    public Function strLT;
    public Function strGT;
    public Function strLEQ;
    public Function strGEQ;
    public Function length;
    public Function substring;
    public Function parseInt;
    public Function ord;
    public Function size;
    public Function print;
    public Function println;
    public Function printInt;
    public Function printlnInt;
    public Function getString;
    public Function getInt;
    public Function toString;
    public IRModule() {
        // alloc space
        allocSpace();
        // load built-in functions.
        functionBuild();
    }
    private void allocSpace() {
        builtInFunctions = new HashMap<>();
        customFunctions  = new HashMap<>();
        customClasses    = new HashMap<>();
        staticData       = new HashMap<>();
    }

    private void functionBuild() {
        // global here.

        // string here.

        // array  here.
    }
    // function relative info
    public void addCustomFunction(Function func) {
        // add function, whatever class-method or global
        customFunctions.put(func.name, func);
    }

    public Function getBuiltInFunction(String name) {
        return builtInFunctions.getOrDefault(name, null);
    }
    public Function getCustomFunction(String name) {
        return customFunctions.getOrDefault(name, null);
    }
    public Function getFunction(String name) {
        if (getBuiltInFunction(name) != null) return getBuiltInFunction(name);
        else return getCustomFunction(name);
    }
    // class relative info
    public void addCustomClass(String name) {
        customClasses.put(name, new ClassInfo());
    }
    public void appendClassMember(String name, BaseType baseType, String id) {
        customClasses.get(name).appendMember(baseType, id);
    }
    public int getClassMemberIndex(String name, String id) {
        return customClasses.get(name).getIndex(id);
    }
    public BaseType getClassMemberBaseType(String name, String id) {
        return customClasses.get(name).getBaseType(id);
    }
    public boolean classContainsMember(String name, String id) {return customClasses.get(name).contains(id); }
    public ArrayList<String> getClassMemberIds(String name) {
        return customClasses.get(name).getIDs();
    }
    // global variable info
    public void addStaticData(String name, BaseType baseType) {
        staticData.put(name, baseType);
    }
    public boolean containVar(String name) {
        return staticData.containsKey(name);
    }

}
