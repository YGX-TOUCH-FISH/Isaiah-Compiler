package RISCV32;

public interface AsmVisitor {
    void visit(AsmModule node);
    void visit(AsmFunction node);
    void visit(AsmBlock node);
}
