package RISCV32.Inst;

import RISCV32.Oprand.Reg;

public class Return extends Inst{
    public Return() {
        super(null, null, null);
    }

    @Override
    public String toString() {
        return "ret";
    }
}
