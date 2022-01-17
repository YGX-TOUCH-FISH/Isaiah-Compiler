package RISCV32.Inst;

import RISCV32.Oprand.Imm;
import RISCV32.Oprand.Reg;

// li
public class LoadImm extends Inst{
    Imm imm;
    public LoadImm(Reg _rd, Long immValue) {
        super(_rd, null, null);
        imm = new Imm(immValue);
    }

    @Override public String toString() {
        return "li\t"+rd+" "+imm;
    }
}
