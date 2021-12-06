package Util.scope;

import LLVMIR.Function;
import LLVMIR.Oprand.Oprand;
import LLVMIR.Type.ClassType;
import Util.position;

import java.util.ArrayList;
import java.util.HashMap;

public class IRScope {
    IRScope father;
    HashMap<String, Function>  functions;
    HashMap<String, ClassType> classes;
    HashMap<String, Oprand>    variables;
    public IRScope(IRScope _father) {
        father = _father;
        functions = new HashMap<>();
        classes = new HashMap<>();
        variables = new HashMap<>();
    }
    public boolean isGlobal() {
        return father == null;
    }
    public void addClassDef(String _name, ClassType _classType, position _pos) {

    }
}
