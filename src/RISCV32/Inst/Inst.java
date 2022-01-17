package RISCV32.Inst;

import RISCV32.Oprand.Reg;

abstract public class Inst {
    public Inst prev, next;
    public Reg rs1, rs2, rd;
    public Inst(Reg _rd, Reg _rs1, Reg _rs2) {
        rs1 = _rs1;
        rs2 = _rs2;
        rd  = _rd;
    }
    abstract public String toString();
}
