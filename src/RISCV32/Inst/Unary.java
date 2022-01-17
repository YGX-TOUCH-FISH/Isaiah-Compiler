package RISCV32.Inst;

import RISCV32.Oprand.Reg;

public class Unary extends Inst{
    public enum UnaryOperator {
        seqz, snez, sgtz, sltz
    }
    final UnaryOperator op;
    public Unary(UnaryOperator _op, Reg _rd, Reg _rs1) {
        super(_rd, _rs1, null);
        op = _op;
    }
    @Override public String toString() {
        return op+"\t"+rd+", "+rs1;
    }
}
