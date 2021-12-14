package LLVMIR;

import LLVMIR.Inst.*;
import LLVMIR.Oprand.ConstInt;
import LLVMIR.Oprand.ConstNull;
import LLVMIR.Oprand.ConstStr;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.*;

public interface IRVisitor {
    public void visit(IRModule node);
    public void visit(Function node);
    public void visit(BasicBlock node);
    public void visit(ClassInfo node);

}
