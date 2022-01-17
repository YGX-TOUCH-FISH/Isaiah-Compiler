package RISCV32.Inst;

import RISCV32.Oprand.Imm;
import RISCV32.Oprand.Reg;

public class Store extends Inst{
    private final StepWidth width;
    private final Imm imm;
    public Store(StepWidth _width, Reg _rs2, Reg _rs1, Long immValue) {
        super(null , _rs1, _rs2);
        width = _width;
        imm   = new Imm(immValue);
    }
    @Override
    public String toString() {
        String ret;
        if (width == StepWidth.word) ret = "sw\t";
        else if (width == StepWidth.half) ret = "sh\t";
        else ret = "sb\t";
        ret += rs2+", "+imm+"("+rs1+")";
        return ret;
    }
}
