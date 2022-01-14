package BackEnd;

import LLVMIR.*;

import java.io.PrintStream;

public class AsmPrinter {
    private final PrintStream printPort;
    public AsmPrinter(PrintStream _printPort) {
        printPort = _printPort;
    }

}
