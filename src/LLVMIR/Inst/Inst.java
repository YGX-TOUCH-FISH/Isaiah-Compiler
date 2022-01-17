package LLVMIR.Inst;

import LLVMIR.Pass;

public abstract class Inst {
    public Inst next;
    abstract public String toString();
    abstract public void accept(Pass visitor);
}
