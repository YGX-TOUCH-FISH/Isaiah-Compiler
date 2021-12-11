package LLVMIR;

import LLVMIR.Inst.Inst;

import java.util.ArrayList;

public class BasicBlock {
    Function fatherFunction;
    public Integer label;
    public BasicBlock prev, next;
    ArrayList<BasicBlock> prevPaths;
    ArrayList<Inst> insts;
    public BasicBlock(BasicBlock _prev, BasicBlock _next, int _label) {
        prevPaths = new ArrayList<>();
        insts     = new ArrayList<>();
        prev      = _prev;
        next      = _next;
        label     = _label;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder(label.toString()+": ; preds = ");
        int prevCounter = 0;
        for (BasicBlock basicBlock : prevPaths) {
            ret.append(basicBlock.toName());
            prevCounter++;
            if (prevCounter != prevPaths.size()) ret.append(", ");
        }
        ret.append('\n');
        for (Inst inst : insts) {
            ret.append(inst.toString());
        }
        return ret.toString();
    }
    public String toName() {
        return "%"+label.toString();
    }
    public void append(Inst _inst) {
        insts.add(_inst);
    }
}
