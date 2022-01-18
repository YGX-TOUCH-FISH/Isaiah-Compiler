package LLVMIR;

import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;
import LLVMIR.Type.IntType;
import LLVMIR.Type.PointerType;
import LLVMIR.Type.VoidType;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.HashMap;

// Top Module
public class IRModule {
    public ArrayList<String> builtInFunctionName = new ArrayList<>();
    public ArrayList<String> customFunctionName  = new ArrayList<>();
    public ArrayList<String> customClassName     = new ArrayList<>();
    public ArrayList<String> staticDataName      = new ArrayList<>();
    public HashMap<String, Function>  builtInFunctions = new HashMap<>();
    public HashMap<String, Function>  customFunctions  = new HashMap<>();  // "classname.func" or "func"
    public HashMap<String, ClassInfo> customClasses    = new HashMap<>();
    public HashMap<String, BaseType>  staticData       = new HashMap<>(); // .data & .bss
    public ArrayList<Pair<String, VirtualReg>> strConstants = new ArrayList<>();
    public ArrayList<Pair<String, VirtualReg>> asmStrings = new ArrayList<>();
    public Function malloc;
    public Function strADD;
    public Function strLT;
    public Function strGT;
    public Function strLEQ;
    public Function strGEQ;
    public Function strEQ;
    public Function strNE;
    public Function length;
    public Function substring;
    public Function parseInt;
    public Function ord;
    public Function size;   // size: no built-in function?
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

        builtInFunctionName.add("malloc");
        malloc = new Function("malloc", new PointerType(new IntType(8)));
        malloc.appendArgument(new IntType(32));
        builtInFunctions.put("malloc", malloc);

        builtInFunctionName.add("string_add");
        strADD = new Function("string_add", new PointerType(new IntType(8)));
        strADD.appendArgument(new PointerType(new IntType(8)));
        strADD.appendArgument(new PointerType(new IntType(8)));
        builtInFunctions.put("string_add", strADD);

        builtInFunctionName.add("string_lt");
        strLT = new Function("string_lt", new IntType(1));
        strLT.appendArgument(new PointerType(new IntType(8)));
        strLT.appendArgument(new PointerType(new IntType(8)));
        builtInFunctions.put("string_lt", strLT);

        builtInFunctionName.add("string_gt");
        strGT = new Function("string_gt", new IntType(1));
        strGT.appendArgument(new PointerType(new IntType(8)));
        strGT.appendArgument(new PointerType(new IntType(8)));
        builtInFunctions.put("string_gt", strGT);

        builtInFunctionName.add("string_le");
        strLEQ = new Function("string_le", new IntType(1));
        strLEQ.appendArgument(new PointerType(new IntType(8)));
        strLEQ.appendArgument(new PointerType(new IntType(8)));
        builtInFunctions.put("string_le", strLEQ);

        builtInFunctionName.add("string_ge");
        strGEQ = new Function("string_ge", new IntType(1));
        strGEQ.appendArgument(new PointerType(new IntType(8)));
        strGEQ.appendArgument(new PointerType(new IntType(8)));
        builtInFunctions.put("string_ge", strGEQ);

        builtInFunctionName.add("string_eq");
        strEQ = new Function("string_eq", new IntType(1));
        strEQ.appendArgument(new PointerType(new IntType(8)));
        strEQ.appendArgument(new PointerType(new IntType(8)));
        builtInFunctions.put("string_eq", strEQ);

        builtInFunctionName.add("string_ne");
        strNE = new Function("string_ne", new IntType(1));
        strNE.appendArgument(new PointerType(new IntType(8)));
        strNE.appendArgument(new PointerType(new IntType(8)));
        builtInFunctions.put("string_ne", strNE);

        builtInFunctionName.add("string_length");
        length = new Function("string_length", new IntType(32));
        length.appendArgument(new PointerType(new IntType(8)));
        builtInFunctions.put("string_length", length);

        builtInFunctionName.add("string_subString");
        substring = new Function("string_subString", new PointerType(new IntType(8)));
        substring.appendArgument(new PointerType(new IntType(8)));
        substring.appendArgument(new IntType(32));
        substring.appendArgument(new IntType(32));
        builtInFunctions.put("string_subString", substring);

        builtInFunctionName.add("string_parseInt");
        parseInt = new Function("string_parseInt", new IntType(32));
        parseInt.appendArgument(new PointerType(new IntType(8)));
        builtInFunctions.put("string_parseInt", parseInt);

        builtInFunctionName.add("string_ord");
        ord = new Function("string_ord", new IntType(32));
        ord.appendArgument(new PointerType(new IntType(8)));
        ord.appendArgument(new IntType(32));
        builtInFunctions.put("string_ord", ord);

        builtInFunctionName.add("array_size");
        size = new Function("array_size", new IntType(32));
        size.appendArgument(new PointerType(new IntType(8)));
        builtInFunctions.put("array_size", size);

        builtInFunctionName.add("print");
        print = new Function("print", new VoidType());
        print.appendArgument(new PointerType(new IntType(8)));
        builtInFunctions.put("print", print);

        builtInFunctionName.add("println");
        println = new Function("println", new VoidType());
        println.appendArgument(new PointerType(new IntType(8)));
        builtInFunctions.put("println", println);

        builtInFunctionName.add("printInt");
        printInt = new Function("printInt", new VoidType());
        printInt.appendArgument(new IntType(32));
        builtInFunctions.put("printInt", printInt);

        builtInFunctionName.add("printlnInt");
        printlnInt = new Function("printlnInt", new VoidType());
        printlnInt.appendArgument(new IntType(32));
        builtInFunctions.put("printlnInt", printlnInt);

        builtInFunctionName.add("getString");
        getString = new Function("getString", new PointerType(new IntType(8)));
        builtInFunctions.put("getString", getString);

        builtInFunctionName.add("getInt");
        getInt = new Function("getInt", new IntType(32));
        builtInFunctions.put("getInt", getInt);

        builtInFunctionName.add("toString");
        toString = new Function("toString", new PointerType(new IntType(8)));
        toString.appendArgument(new IntType(32));
        builtInFunctions.put("toString", toString);
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
    public void accept(Pass visitor) { visitor.visit(this); }
}
