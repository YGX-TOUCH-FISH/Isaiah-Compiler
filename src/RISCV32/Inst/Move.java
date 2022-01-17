package RISCV32.Inst;

import RISCV32.Oprand.Reg;

public class Move extends Inst{
    public Move(Reg _rd, Reg _rs1) {
        super(_rd, _rs1, null);
    }

    @Override
    public String toString() {
        return "mv\t"+rd+", "+rs1;
    }
}
