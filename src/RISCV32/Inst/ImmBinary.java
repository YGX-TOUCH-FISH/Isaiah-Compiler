package RISCV32.Inst;

import RISCV32.Oprand.Imm;
import RISCV32.Oprand.Reg;

public class ImmBinary extends Inst{
    public enum immOperator {
        addi, slti, sltiu, andi, ori, xori, slli
    }
    final immOperator op;
    final Imm imm;
    public ImmBinary(immOperator _op, Reg _rd, Reg _rs1, Long immValue) {
        super(_rd, _rs1, null);
        op  = _op;
        imm = new Imm(immValue);
    }
    @Override public String toString() {
        return op+"\t"+rd+", "+rs1+", "+imm;
    }

}
