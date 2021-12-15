package LLVMIR;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Type.BaseType;
import LLVMIR.Type.ClassType;
import LLVMIR.Type.IntType;
import LLVMIR.Type.PointerType;
import Util.error.irError;
import Util.position;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// Top Module
public class IRModule {
    public ArrayList<String> buildInFunctionName = new ArrayList<>();
    public ArrayList<String> customFunctionName  = new ArrayList<>();
    public ArrayList<String> customClassName     = new ArrayList<>();
    public ArrayList<String> staticDataName      = new ArrayList<>();
    public HashMap<String, Function>  builtInFunctions = new HashMap<>();
    public HashMap<String, Function>  customFunctions  = new HashMap<>();  // "classname.func" or "func"
    public HashMap<String, ClassInfo> customClasses    = new HashMap<>();
    public HashMap<String, BaseType>  staticData       = new HashMap<>(); // .data & .bss

    public Function malloc;
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
        // load built-in functions.
        functionBuild();
    }

    private void functionBuild() {
        // global here.
        buildInFunctionName.add("malloc");
        malloc = new Function("malloc", new PointerType(new IntType(8)));
        malloc.appendArgument(new IntType(64));
        builtInFunctions.put("malloc", malloc);
        // string here.

        // array  here.
    }
    // function relative info
    public void addCustomFunction(Function func) {
        // add function, whatever class-method or global
        customFunctionName.add(func.name);
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
        customClassName.add(name);
        customClasses.put(name, new ClassInfo(name));
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
    public ClassInfo getClassInfo(String name) { return customClasses.get(name); }
//    public boolean classContainsMember(String name, String id) {return customClasses.get(name).contains(id); }
    // global variable info
    public void addStaticData(String name, BaseType baseType) {
        staticDataName.add(name);
        staticData.put(name, baseType);
    }
}
