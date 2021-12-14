package LLVMIR;

import LLVMIR.Inst.BrInst;
import LLVMIR.Inst.Inst;
import LLVMIR.Inst.JumpInst;
import LLVMIR.Inst.RetInst;

import java.util.ArrayList;

public class BasicBlock {
    public Integer label;
    public BasicBlock prev, next;
//    ArrayList<BasicBlock> prevPaths;
    public Inst headInst, tailInst;
    public boolean hasTerminal = false;
    public BasicBlock(BasicBlock _prev, BasicBlock _next, int _label) {
//        prevPaths = new ArrayList<>();
        headInst  = null;
        prev      = _prev;
        next      = _next;
        label     = _label;
    }

    public String toName() {
        return "%"+label.toString();
    }
    public void accept(IRVisitor visitor) {visitor.visit(this);}
    public void append(Inst _inst) {
        if (headInst == null) headInst = _inst;
        else tailInst.next = _inst;
        tailInst = _inst;
    }
//    public void appendTerminal(Inst _inst) {
//        if (!hasTerminal) append(_inst);
//    }
}
