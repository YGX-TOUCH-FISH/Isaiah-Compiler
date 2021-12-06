package LLVMIR.Inst;

import LLVMIR.BasicBlock;

public class JumpInst {
    BasicBlock dest;
    public JumpInst(BasicBlock _dest) {
        dest = _dest;
    }
    public String toString() {
        return "br label "+dest.toName();
    }
}
