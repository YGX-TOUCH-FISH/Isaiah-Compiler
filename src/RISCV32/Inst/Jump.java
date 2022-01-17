package RISCV32.Inst;

import RISCV32.Oprand.Reg;

public class Jump extends Inst {
    final String target;
    public Jump(String _target) {
        super(null, null, null);
        target = _target;
    }

    @Override
    public String toString() {
        return "j\t"+target;
    }
}
