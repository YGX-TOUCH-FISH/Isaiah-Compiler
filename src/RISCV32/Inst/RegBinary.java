package RISCV32.Inst;

import RISCV32.Oprand.Reg;

public class RegBinary extends Inst{
    public enum RegOperator {
        add, sub, mul, div, rem,
        sll, sra, slt, sltu,
        or, and, xor
    }
    final RegOperator op;
    public RegBinary(RegOperator _op, Reg _rd, Reg _rs1, Reg _rs2) {
        super(_rd, _rs1, _rs2);
        op = _op;
    }
    @Override public String toString() {
        return op+"\t"+rd+", "+rs1+","+rs2;
    }
}
