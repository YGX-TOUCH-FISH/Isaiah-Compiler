package RISCV32.Inst;

import RISCV32.Oprand.Reg;

public class Jump extends Inst {
    final Integer target;
    public Jump(int _target) {
        super(null, null, null);
        target = _target;
    }

    @Override
    public String toString() {
        return "j\t.BB_"+target;
    }
}
