package LLVMIR.Inst;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Pass;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
// before optimize, maybe only support 2 argument phi-sentence
public class PhiInst extends Inst{
//      %15 = phi i1 [ false, %0 ], [ %13, %8 ]
    public VirtualReg resultReg;
    public ArrayList<Pair<Oprand, Integer>> paths;
    public PhiInst(VirtualReg _result, ArrayList<Pair<Oprand, Integer>> _paths) {
        resultReg = _result;
        paths = _paths;
    }
    @Override public String toString() {
        StringBuilder ret = new StringBuilder(resultReg.toName()+" = phi "+resultReg.baseType.toString());
        for (int i = 0 ; i < paths.size() ; i++) {
            ret.append(" [ ").append(paths.get(i).a.toName()).append(", %").append(paths.get(i).b.toString()).append(" ]");
            if (i != paths.size()-1) ret.append(',');
        }
        return ret.toString();
    }
    @Override public void accept(Pass visitor) {visitor.visit(this);}
}
