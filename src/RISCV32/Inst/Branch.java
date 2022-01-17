package RISCV32.Inst;

import RISCV32.Oprand.Reg;

public class Branch extends Inst{
    public enum condOperator{
        beqz, bnez, bltu, blt, bge, bgeu
    }
    private final condOperator op;
    private final String target;
    public Branch(condOperator _op, Reg _rs1, Reg _rs2, String _target) {
        super(null , _rs1, _rs2);
        op     = _op;
        target = _target;
    }

    @Override public String toString() {
        String ret = op+" "+rs1;
        if (rs2 != null) ret += ", "+rs2;
        ret += " "+target;
        return ret;
    }
}
