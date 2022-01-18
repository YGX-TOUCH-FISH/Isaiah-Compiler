package RISCV32;

import LLVMIR.Oprand.VirtualReg;
import RISCV32.Oprand.PhyReg;
import RISCV32.Oprand.Reg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class AsmFunction {

    public final String name;
    public ArrayList<Reg> parameters = new ArrayList<>();
    public Integer labelCounter;
    public AsmBlock entryBlock;
    public HashSet<Integer> stackVars = new HashSet<>();
    public AsmFunction(String _name) {
        name = _name;
        labelCounter = 0;
        entryBlock = new AsmBlock(null, null, _name, takeLabel());
    }
    public void allocaStackVar(VirtualReg reg) {
        stackVars.add(reg.label);
    }
    public boolean containStackVar(VirtualReg reg) {
        return stackVars.contains(reg.label);
    }
    public AsmBlock getEntry() {return entryBlock;}
    public int takeLabel() {return labelCounter++;}
    public void accept(AsmVisitor visitor) {visitor.visit(this);}
}
