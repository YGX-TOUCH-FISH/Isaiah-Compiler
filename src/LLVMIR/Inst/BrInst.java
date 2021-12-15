package LLVMIR.Inst;

import LLVMIR.BasicBlock;
import LLVMIR.Oprand.ConstInt;
import LLVMIR.Oprand.Oprand;

// conditional branch
public class BrInst extends Inst{
    public Oprand cond;  //always i1
    public BasicBlock iftrue, iffalse;
    public BrInst(Oprand _cond, BasicBlock _iftrue, BasicBlock _iffalse) {
        cond    = _cond;
        iftrue  = _iftrue;
        iffalse = _iffalse;
    }
    @Override public String toString() {
        return "br "+cond.toString()+", label "+iftrue.toName()+", label "+iffalse.toName();
    }
}
