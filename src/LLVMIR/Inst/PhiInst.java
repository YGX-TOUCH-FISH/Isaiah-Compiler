package LLVMIR.Inst;

import LLVMIR.BasicBlock;
import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import org.antlr.v4.runtime.misc.Pair;

import java.util.Set;

public class PhiInst extends Inst{
    public VirtualReg              resultReg;
    public Set<Pair<BasicBlock, Oprand>> prevPaths;
    public PhiInst(VirtualReg _result, Set<Pair<BasicBlock, Oprand>> _prevPaths) {
        resultReg = _result;
        prevPaths = _prevPaths;
    }
    public String toString() {
        StringBuilder ret = new StringBuilder(resultReg.toName() + " = phi " + resultReg.baseType.toString());
        int iter = 0;
        for (Pair<BasicBlock, Oprand> prevPath : prevPaths) {
            ret.append(" [ ");
            ret.append(prevPath.b.toName());
            ret.append(", ");
            ret.append(prevPath.a.toName());
            ret.append(" ] ");
            iter++;
            if (iter != prevPaths.size()) ret.append(", ");
        }
        return ret.toString();
    }
}
