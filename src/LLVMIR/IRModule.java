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
    public HashSet<Function>  systemBuiltInFunctions;
    public HashSet<Function>  stringBuiltInFunctions;
    public HashSet<Function>  arrayBuiltInFunctions;
    public HashSet<Function>  customFunctions;
    public HashMap<String, ClassInfo> customClasses;
    public HashMap<String, BaseType> staticData; // .data & .bss

    public Function length;
    public Function substring;
    public IRModule() {
        // alloc space
        allocSpace();
        // load built-in functions.
        functionBuild();
    }
    private void allocSpace() {
        systemBuiltInFunctions = new HashSet<>();
        stringBuiltInFunctions = new HashSet<>();
        arrayBuiltInFunctions = new HashSet<>();
        customFunctions = new HashSet<>();
        customClasses = new HashMap<>();
        staticData = new HashMap<>();
    }

    private void functionBuild() {
        // global here.

        // string here.

        // array  here.
    }

    public void addCustomFunction(Function func) {
        // add function, whatever class-method or global
        customFunctions.add(func);
    }
    public void addCustomClass(String name) {
        customClasses.put(name, new ClassInfo());
    }
    // only record member with init value.
    public void appendClassMember(String name, BaseType baseType, String id) {
        customClasses.get(name).appendMember(baseType, id);
    }
    public int getClassMemberIndex(String name, String id) {
        return customClasses.get(name).getIndex(id);
    }
    public BaseType getClassMemberBaseType(String name, String id) {
        return customClasses.get(name).getBaseType(id);
    }
    public ArrayList<String> getClassMemberIds(String name) {
        return customClasses.get(name).getIDs();
    }
    public boolean classMemberInitialized(String name, String id) {
        return customClasses.get(name).contains(id);
    }
    public void addStaticData(String name, BaseType baseType) {
        staticData.put(name, baseType);
    }
    public boolean containVar(String name) {
        return staticData.containsKey(name);
    }
    // check contain
}
