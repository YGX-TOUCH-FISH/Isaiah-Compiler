package LLVMIR;

import LLVMIR.Inst.Inst;

import java.util.ArrayList;

public class BasicBlock {
    Function fatherFunction;
    public Integer label;
    public BasicBlock prev, next;
//    ArrayList<BasicBlock> prevPaths;
    public Inst headInst, tailInst;
    public BasicBlock(BasicBlock _prev, BasicBlock _next, int _label) {
//        prevPaths = new ArrayList<>();
        headInst  = null;
        prev      = _prev;
        next      = _next;
        label     = _label;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder(label.toString()+": ; preds = ");
        ret.append('\n');
        for (Inst inst = headInst ; inst != null ; inst = inst.next) ret.append(inst);
        return ret.toString();
    }
    public String toName() {
        return "%"+label.toString();
    }
    public void append(Inst _inst) {
        if (headInst == null) headInst = _inst;
        else tailInst.next = _inst;
        tailInst = _inst;
    }
}
