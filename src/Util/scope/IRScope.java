package Util.scope;

import LLVMIR.Function;
import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;
import LLVMIR.Type.ClassType;
import Util.position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
// how to manage static vars?
public class IRScope {
    IRScope parent;
    HashMap<String, VirtualReg> varsReg;

    public IRScope(IRScope _parent) {
        parent    = _parent;
        varsReg   = new HashMap<>();
    }
    public void defineVar(String name, VirtualReg reg) {
        varsReg.put(name, reg);
    }
    public int getVarLabel(String name, boolean lookUpon) {
        if (varsReg.containsKey(name)) return varsReg.get(name).label;
        else if (lookUpon && parent != null) return parent.getVarLabel(name, true);
        else return -1;
    }
    public IRScope getParent() {
        return parent;
    }


}
