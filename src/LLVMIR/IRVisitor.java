package LLVMIR;

import LLVMIR.Inst.*;
import LLVMIR.Oprand.ConstInt;
import LLVMIR.Oprand.ConstNull;
import LLVMIR.Oprand.ConstStr;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.*;

public interface IRVisitor {
    void visit(IRModule node);
    void visit(Function node);
    void visit(BasicBlock node);
    void visit(ClassInfo node);
}
