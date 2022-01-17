package LLVMIR;


public interface IRVisitor {
    void visit(IRModule node);
    void visit(Function node);
    void visit(BasicBlock node);
    void visit(ClassInfo node);
}
