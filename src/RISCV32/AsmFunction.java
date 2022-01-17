package RISCV32;

import RISCV32.Oprand.PhyReg;
import RISCV32.Oprand.Reg;

import java.util.ArrayList;
import java.util.Arrays;

public class AsmFunction {

    public final String name;
    public ArrayList<Reg> parameters = new ArrayList<>();
    public Integer labelCounter;
    public AsmBlock entryBlock;

    public AsmFunction(String _name) {
        name = _name;
        labelCounter = 0;
        entryBlock = new AsmBlock(null, null, takeLabel());
    }

    public AsmBlock getEntry() {return entryBlock;}
    public int takeLabel() {return labelCounter++;}
    public void accept(AsmVisitor visitor) {visitor.visit(this);}
}
