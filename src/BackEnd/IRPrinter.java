package BackEnd;

import LLVMIR.*;
import LLVMIR.Inst.Inst;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IRPrinter implements IRVisitor {
    private PrintStream port;
    public IRPrinter(PrintStream _port) {
        port = _port;
    }
    @Override public void visit(IRModule node) {
        for (String name : node.staticDataName) {
            BaseType baseType = node.staticData.get(name);
            port.println("@"+name+" = dso_local global "+baseType.toString()+" "+baseType.getZeroInit().toString());
        }
        port.print('\n');
        for (String name : node.buildInFunctionName) {
            node.builtInFunctions.get(name).accept(this);
            port.print('\n');
        }
        for (String name : node.customClassName) {
            node.customClasses.get(name).accept(this);
            port.print('\n');
        }
        for (String name : node.customFunctionName) {
            node.customFunctions.get(name).accept(this);
            port.print('\n');
        }

    }

    @Override public void visit(Function node) {
        port.print("define dso_local "+node.retType.toString()+" @"+node.name);
        int argsCounter = 0;
        port.print('(');
        for (VirtualReg arg : node.args) {
            port.print(arg.toString());
            argsCounter++;
            if (argsCounter != node.args.size()) port.print(", ");
        }
        port.print(')');

        port.println('{');
        BasicBlock curBlock = node.entryBlock;
        while (curBlock != null) {
            if (curBlock != node.entryBlock) port.println(curBlock.label+":");
            curBlock.accept(this);
            curBlock = curBlock.next;
        }
        port.println('}');
    }

    @Override public void visit(BasicBlock node) {
        for (Inst inst = node.headInst; inst != null ; inst = inst.next){
            port.print('\t');
            port.println(inst);
        }
    }

    @Override public void visit(ClassInfo node) {
        int argsCounter = 0;
        port.print("%"+node.className+" = type { ");
        for (BaseType baseType : node.types) {
            port.print(baseType.toString());
            argsCounter++;
            if (argsCounter != node.types.size()) port.print(", ");
        }
        port.println('}');
    }
}
