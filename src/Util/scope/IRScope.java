package Util.scope;

import LLVMIR.BasicBlock;
import LLVMIR.ClassInfo;
import LLVMIR.Function;
import LLVMIR.Inst.GetElementPtrInst;
import LLVMIR.Inst.LoadInst;
import LLVMIR.Oprand.ConstInt;
import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;
import LLVMIR.Type.ClassType;
import LLVMIR.Type.PointerType;
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
                VirtualReg thisReg = new VirtualReg(new PointerType(new ClassType(classInfo.className)), currentFunction.takeLabel());
                VirtualReg thisStoreReg = getVarReg("this", true);
                currentBlock.append(new LoadInst(thisReg, thisStoreReg));
                VirtualReg ptrReg = new VirtualReg(new PointerType(classInfo.getBaseType(name)), currentFunction.takeLabel());
                ArrayList<Oprand> offsets = new ArrayList<>();
                offsets.add(new ConstInt(32, 0));
                offsets.add(new ConstInt(32, classInfo.getIndex(name)));
                currentBlock.append(new GetElementPtrInst(ptrReg, thisReg, offsets));    // get from 'this'
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
