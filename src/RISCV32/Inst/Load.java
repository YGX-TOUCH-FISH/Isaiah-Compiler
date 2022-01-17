package RISCV32.Inst;

import RISCV32.Oprand.Imm;
import RISCV32.Oprand.Reg;

public class Load extends Inst{
    private final StepWidth width;
    private final Imm imm;
    public Load(StepWidth _width, Reg _rd, Reg _rs1, Long immValue) {
        super(_rd, _rs1, null);
        width = _width;
        imm = new Imm(immValue);
    }
    @Override public String toString() {
        String ret;
        if (width == StepWidth.word) ret = "lw\t";
        else if (width == StepWidth.half) ret = "lh\t";
        else ret = "lb\t";

        ret += rd+", "+imm+"("+rs1+")";
        return ret;
    }
}
