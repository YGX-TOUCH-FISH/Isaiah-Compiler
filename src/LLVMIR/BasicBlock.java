package LLVMIR;

import LLVMIR.Inst.Inst;

public class BasicBlock {
    Function fatherFunction;
    public Integer label;
    BasicBlock prev, next;
    Inst head, tail;
    public BasicBlock() {
        head = null;
        tail = null;
    }

    public String toName() {
        return "%"+label.toString();
    }
}
