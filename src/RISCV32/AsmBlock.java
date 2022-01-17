package RISCV32;

import RISCV32.Inst.Inst;

public class AsmBlock {
    public Integer label;
    public AsmBlock prev, next;
    public Inst headInst, tailInst;
    public AsmBlock(AsmBlock _prev, AsmBlock _next, int _label) {
        headInst = null;
        prev = _prev;
        next = _next;
        label = _label;
    }
    public void append(Inst _inst) {
        if (headInst == null) {
            headInst = _inst;
            headInst.prev = null;
            headInst.next = null;
            tailInst = _inst;
        }
        else {
            tailInst.next = _inst;
            _inst.prev = tailInst;
            tailInst = tailInst.next;
        }
    }
    public void accept(AsmVisitor visitor) {visitor.visit(this);}
}
