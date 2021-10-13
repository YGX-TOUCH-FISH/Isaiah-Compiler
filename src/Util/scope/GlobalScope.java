package Util.scope;

import Util.Type;
import Util.FunctionDef;
import Util.error.semanticError;
import Util.position;

import java.util.HashSet;

public class GlobalScope extends Scope{
    //TODO: collect all Type definition
    //      because of cannot define Class in any Function

    HashSet<String> classDefs = new HashSet<>();
    HashSet<FunctionDef> functionDefs = new HashSet<>();
    public GlobalScope(Scope _parent) {
        super(_parent);
    }

    public void addClassType(String _name, position pos) {
        if (classDefs.contains(_name))
            throw new semanticError("[ERROR]redefinition CLASS of " + _name, pos);
        classDefs.add(_name);
    }
    public boolean containsClass(String _name) {
        return classDefs.contains(_name);
    }
    public void addFuncDef(FunctionDef _funcDef, position pos) {
        if (functionDefs.contains(_funcDef))
            throw new semanticError("[ERROR]redefinition FUNCTION of " + _funcDef.name, pos);
        functionDefs.add(_funcDef);
    }
    public boolean containsFunc(FunctionDef _funcDef) {
        return functionDefs.contains(_funcDef);
    }
}
