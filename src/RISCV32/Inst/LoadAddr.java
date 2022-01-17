package RISCV32.Inst;

import RISCV32.Oprand.Reg;

public class LoadAddr extends Inst{

    String variable;
    public LoadAddr(Reg _rd, String _variable) {
        super(_rd, null, null);
        variable = _variable;
    }

    @Override public String toString() {
        return "la\t"+rd+" "+variable;
    }
}
