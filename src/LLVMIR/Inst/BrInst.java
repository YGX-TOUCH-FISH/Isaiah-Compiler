package LLVMIR.Inst;

import LLVMIR.BasicBlock;
import LLVMIR.Oprand.ConstBool;
import LLVMIR.Oprand.Oprand;

// conditional branch
public class BrInst extends Inst{
    public ConstBool  cond;  //always i1
    public BasicBlock iftrue, iffalse;
    public BrInst(ConstBool _cond, BasicBlock _iftrue, BasicBlock _iffalse) {
        cond    = _cond;
        iftrue  = _iftrue;
        iffalse = _iffalse;
    }
    @Override public String toString() {
        return cond.toString()+", label "+iftrue.toName()+", label "+iffalse.toName();
    }
}
