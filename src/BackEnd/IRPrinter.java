package BackEnd;

import LLVMIR.*;
import LLVMIR.Inst.CallInst;
import LLVMIR.Inst.Inst;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;
import LLVMIR.Type.PointerType;
import org.antlr.v4.runtime.misc.Pair;

import java.io.*;
import java.util.Objects;

public class IRPrinter implements IRVisitor {
    private final PrintStream printPort;
    public IRPrinter(PrintStream output) {
        printPort = output;
    }


    @Override public void visit(IRModule node) {
//        printPort.println("@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @global_var_init, i8* null }]");
        for (String name : node.builtInFunctionName) {
            Function function = node.getBuiltInFunction(name);
            printPort.print("declare "+function.retType.toString()+" @"+name);
            printPort.print('(');
            for (int i = 0 ; i < function.args.size() ; i++) {
                printPort.print(function.args.get(i).baseType.toString());
                if (i != function.args.size()-1) printPort.print(", ");
            }
            printPort.println(')');
        }
        printPort.println();
        for (String name : node.staticDataName) {
            BaseType baseType = node.staticData.get(name);
            printPort.println("@"+name+" = global "+baseType.toString()+" "+baseType.getZeroInit().toName());
        }
        for (Pair<String, VirtualReg> pair : node.strConstants) {
            String strValue = pair.a;
            VirtualReg strConstReg = pair.b;
            BaseType strType = ((PointerType) strConstReg.baseType).referType;
            printPort.println(strConstReg.toName()+" = constant "+strType.toString()+" c"+strValue);
        }
        printPort.println();
        for (String name : node.customClassName) {
            node.customClasses.get(name).accept(this);
            printPort.println();
        }
        for (String name : node.customFunctionName) {
            node.customFunctions.get(name).accept(this);
            printPort.println();
        }

    }

    @Override public void visit(Function node) {
        printPort.print("define "+node.retType.toString()+" @"+node.name);
        int argsCounter = 0;
        printPort.print('(');
        for (VirtualReg arg : node.args) {
            printPort.print(arg.toString());
            argsCounter++;
            if (argsCounter != node.args.size()) printPort.print(", ");
        }
        printPort.print(')');

        printPort.println('{');
        BasicBlock curBlock = node.entryBlock;
        while (curBlock != null) {
            if (curBlock != node.entryBlock) printPort.println(curBlock.label+":");
            curBlock.accept(this);
            curBlock = curBlock.next;
        }
        printPort.println('}');
    }

    @Override public void visit(BasicBlock node) {
        for (Inst inst = node.headInst; inst != null ; inst = inst.next){
            printPort.print('\t');
            printPort.println(inst);
        }
    }

    @Override public void visit(ClassInfo node) {
        int argsCounter = 0;
        printPort.print("%"+node.className+" = type { ");
        for (BaseType baseType : node.types) {
            printPort.print(baseType.toString());
            argsCounter++;
            if (argsCounter != node.types.size()) printPort.print(", ");
        }
        printPort.println(" }");
    }
}
