package LLVMIR;

import LLVMIR.Inst.*;

public interface Pass {
    void visit(IRModule node);
    void visit(Function node);
    void visit(BasicBlock node);

    void visit(AllocaInst node);
    void visit(BinaryInst node);
    void visit(BitCastInst node);
    void visit(BrInst node);
    void visit(CallInst node);
    void visit(GetElementPtrInst node);
    void visit(IcmpInst node);
    void visit(JumpInst node);
    void visit(LoadInst node);
    void visit(PhiInst node);
    void visit(RetInst node);
    void visit(StoreInst node);
}
