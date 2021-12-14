package Util.scope;

import LLVMIR.BasicBlock;
import LLVMIR.ClassInfo;
import LLVMIR.Function;
import LLVMIR.Inst.GetElementPtrInst;
import LLVMIR.Oprand.ConstInt;
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
    public ClassInfo classInfo;         // class level scope: no

    public IRScope(IRScope _parent) {
        parent = _parent;
        varsReg = new HashMap<>();
        classInfo = null;
    }
    public void defineVar(String name, VirtualReg reg) {
        varsReg.put(name, reg);
    }
    public VirtualReg getVarReg(String name, boolean lookUpon) {
        if (varsReg.containsKey(name)) return varsReg.get(name);
        else if (lookUpon && parent != null) return parent.getVarReg(name, true);
        else return null;
    }
    public VirtualReg getVarReg(String name, boolean lookUpon, BasicBlock currentBlock, Function currentFunction) {
        if (classInfo != null) {
            if (classInfo.contains(name)) {
                VirtualReg ptrReg = new VirtualReg(classInfo.getBaseType(name), currentFunction.takeLabel());
                Oprand offset = new ConstInt(32, classInfo.getIndex(name));
                currentBlock.append(new GetElementPtrInst(ptrReg, currentFunction.args.get(0) ,offset));
                return ptrReg;
            }
            else if (lookUpon && parent != null) return getVarReg(name, true, currentBlock, currentFunction);
            else return null;
        }
        else {
            if (varsReg.containsKey(name)) return varsReg.get(name);
            else if (lookUpon && parent != null) return parent.getVarReg(name, true, currentBlock, currentFunction);
            else return null;
        }
    }
    public IRScope getParent() {
        return parent;
    }
}
