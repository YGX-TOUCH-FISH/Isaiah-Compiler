package LLVMIR.Inst;

import LLVMIR.BasicBlock;
import LLVMIR.Pass;

public class JumpInst extends Inst{
    public final BasicBlock dest;
    public JumpInst(BasicBlock _dest) {
        dest = _dest;
    }
    public String toString() {
        return "br label "+dest.toName();
    }
    @Override public void accept(Pass visitor) {visitor.visit(this);}
}
