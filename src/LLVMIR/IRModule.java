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
    public HashMap<String, Pair<BaseType, Oprand>> staticData; // .data & .bss
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
    public void appendClassMember(String name, BaseType baseType, String id, Oprand initValue) {
        customClasses.get(name).appendMember(baseType, id, initValue);
    }
    public void addStaticData(String name, BaseType baseType, Oprand oprand) {
        staticData.put(name, new Pair<>(baseType, oprand));
    }
    public boolean containVar(String name) {
        return staticData.containsKey(name);
    }
    public BaseType getVarType(String name) {
        return staticData.get(name).a;
    }
    public Oprand getVarValue(String name) {
        return staticData.get(name).b;
    }
    // check contain
}
