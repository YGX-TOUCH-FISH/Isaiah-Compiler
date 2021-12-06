package LLVMIR;

import LLVMIR.Type.BaseType;
import Util.position;

import java.util.HashMap;

// Top
public class IRRoot {
    public HashMap<String, Function> systemBuiltInFunctions;
    public HashMap<String, Function> stringBuiltInFunctions;
    public HashMap<String, Function> arrayBuiltInFunctions;
    public HashMap<String, Function> customFunctions;

    public IRRoot() {
        // load built-in functions.
        functionBuild();
    }
    private void functionBuild() {
        // global here.

        // string here.

        // array  here.
    }

    public void addCustomFunction(Function func, position pos) {
        // add function, whatever class-method or global
    }

    // check contain
}
