package LLVMIR.Inst;

import LLVMIR.BasicBlock;
import LLVMIR.Oprand.ConstInt;

// conditional branch
public class BrInst extends Inst{
    public ConstInt cond;  //always i1
    public BasicBlock iftrue, iffalse;
    public BrInst(ConstInt _cond, BasicBlock _iftrue, BasicBlock _iffalse) {
        cond    = _cond;
        iftrue  = _iftrue;
        iffalse = _iffalse;
    }
    @Override public String toString() {
        return cond.toString()+", label "+iftrue.toName()+", label "+iffalse.toName();
    }
}
