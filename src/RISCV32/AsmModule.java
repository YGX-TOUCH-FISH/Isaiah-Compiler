package RISCV32;

import LLVMIR.Type.BaseType;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

public class AsmModule {
    public ArrayList<Pair<String, AsmFunction>> textSection    = new ArrayList<>();
    public ArrayList<Pair<String, String>>      rodataSection  = new ArrayList<>();
    public ArrayList<String>    bssSection     = new ArrayList<>();
    public AsmModule() {}
}
