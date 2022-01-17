package BackEnd;

import RISCV32.AsmBlock;
import RISCV32.AsmFunction;
import RISCV32.AsmModule;
import RISCV32.AsmVisitor;
import RISCV32.Inst.Inst;
import org.antlr.v4.runtime.misc.Pair;

import java.io.PrintStream;

public class AsmPrinter implements AsmVisitor {
    private final PrintStream printPort;
    public AsmPrinter(PrintStream _printPort) {
        printPort = _printPort;
    }

    @Override public void visit(AsmModule node) {
        printPort.println("\t.text");
        printPort.println("\t.file Isaiah.ll");
        for (Pair<String, AsmFunction> pair : node.textSection) {
            pair.b.accept(this);
        }
        printPort.println();
        printBss(node);
        printPort.println();
        printRodata(node);
        printPort.println("\t.section\t\".note.GNU-stack\",\"\",@progbits");
    }

    @Override public void visit(AsmFunction node) {
        printPort.println("\t.globl\t"+node.name);
        printPort.println("\t.p2align\t2");
        printPort.println("\t.type\t"+node.name+",@function");
        printPort.println(node.name+":");
        AsmBlock block = node.getEntry();
        while (block != null) {
            if (block != node.entryBlock) printPort.println(block.getLabel());
            block.accept(this);
            block = block.next;
        }
        printPort.println();
    }

    @Override public void visit(AsmBlock node) {
        Inst inst = node.headInst;
        while (inst != null) {
            printPort.println("\t"+inst);
            inst = inst.next;
        }
    }
    private void printBss(AsmModule node) {
        printPort.println("\t.section\t.bss,\"aw\",@nobits");
        for (String bssName : node.bssSection) {
            printPort.println("\t.type\t"+bssName+",@object");
            printPort.println("\t.globl\t"+bssName);
            printPort.println(bssName+":");
            printPort.println("\t.word\t0");
            printPort.println("\t.size\t"+bssName+", 4");
            printPort.println();
        }
    }
    private void printRodata(AsmModule node) {
        printPort.println("\t.section\t.rodata,\"a\",@progbits");
        for (Pair<String, String> pair : node.rodataSection) {
            String strName  = pair.a;
            String strValue = pair.b;
            printPort.println("\t.type\t"+strName+",@object");
            printPort.println("\t.globl\t"+strName);
            printPort.println(strName+": ");
            printPort.println("\t.asciz\t"+strValue);
            printPort.println("\t.size\t"+strName+", "+(strValue.length()+1));
            printPort.println();
        }
    }

}
