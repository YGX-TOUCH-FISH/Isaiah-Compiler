package BackEnd;

import LLVMIR.*;
import LLVMIR.Inst.*;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;
import RISCV32.AsmFunction;
import RISCV32.AsmModule;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

public class AsmBuilder implements Pass {
    AsmModule root;
    public ArrayList<Pair<String, AsmFunction>> textSection    = new ArrayList<>();
    public ArrayList<Pair<String, String>>      rodataSection  = new ArrayList<>();
    public ArrayList<Pair<String, BaseType>>    bssSection     = new ArrayList<>();
    public AsmBuilder() {

    }
    @Override public void visit(IRModule node) {
        for (String name : node.staticDataName)
            bssSection.add(new Pair<>(name, node.staticData.get(name)));

        for (Pair<String, VirtualReg> pair : node.strConstants)
            rodataSection.add(new Pair<>(pair.b.name, pair.a));

        for (String name : node.customFunctionName)
            node.customFunctions.get(name).accept(this);
    }

    @Override
    public void visit(Function node) {

    }

    @Override
    public void visit(BasicBlock node) {

    }

    @Override
    public void visit(ClassInfo node) {

    }

    @Override
    public void visit(AllocaInst node) {

    }

    @Override
    public void visit(BinaryInst node) {

    }

    @Override
    public void visit(BitCastInst node) {

    }

    @Override
    public void visit(BrInst node) {

    }

    @Override
    public void visit(CallInst node) {

    }

    @Override
    public void visit(GetElementPtrInst node) {

    }

    @Override
    public void visit(IcmpInst node) {

    }

    @Override
    public void visit(JumpInst node) {

    }

    @Override
    public void visit(LoadInst node) {

    }

    @Override
    public void visit(PhiInst node) {

    }

    @Override
    public void visit(RetInst node) {

    }

    @Override
    public void visit(StoreInst node) {

    }

    @Override
    public void visit(UnaryInst node) {

    }
}
