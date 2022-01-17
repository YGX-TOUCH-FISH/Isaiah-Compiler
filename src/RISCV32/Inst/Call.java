package RISCV32.Inst;

import RISCV32.Oprand.Reg;

public class Call extends Inst{
    private final String functionName;
    public Call(String _name) {
        super(null, null, null);
        functionName = _name;
    }

    @Override public String toString() {
        return "call\t"+functionName;
    }
}
