package RISCV32.Oprand;

public class Imm {
    public final Long value;
    public Imm(long _value) {
        value = _value;
    }
    public String toString() {
        return value.toString();
    }
}
