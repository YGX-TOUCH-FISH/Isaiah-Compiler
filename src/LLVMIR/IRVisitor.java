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
    public void visit(AllocaInst node);
    public void visit(BinaryInst node);
    public void visit(BitCastInst node);
    public void visit(BrInst node);
    public void visit(CallInst node);
    public void visit(GetElementPtrInst node);
    public void visit(IcmpInst node);
    public void visit(JumpInst node);
    public void visit(LoadInst node);
    public void visit(RetInst node);
    public void visit(StoreInst node);
    public void visit(UnaryInst node);
    public void visit(ConstInt node);
    public void visit(ConstNull node);
    public void visit(ConstStr node);
    public void visit(VirtualReg node);
    public void visit(ArrayType node);
    public void visit(ClassType node);
    public void visit(IntType node);
    public void visit(NullType node);
    public void visit(PointerType node);
    public void visit(VoidType node);

}
