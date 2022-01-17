package LLVMIR.Inst;

import LLVMIR.Function;
import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Pass;

import java.util.ArrayList;

public class CallInst extends Inst{
    public VirtualReg        allocReg;    //null: void
    public Function          func;
    public ArrayList<Oprand> inputArgs;
    public CallInst(VirtualReg _allocReg, Function _callFunction, ArrayList<Oprand> _inputArgs) {
        allocReg     = _allocReg;
        func         = _callFunction;
        inputArgs    = new ArrayList<>();
        if (_inputArgs != null) {
            inputArgs.addAll(_inputArgs);
        }
    }
    public String toString() {
        StringBuilder ret;
        if (allocReg != null) {
            ret = new StringBuilder(allocReg.toName() + " = call " + func.retType.toString() + " @" + func.name);
        }
        else {
            ret = new StringBuilder("call " + func.retType.toString() + " @" + func.name);
        }
        ret.append("(");
        for (int i = 0 ; i < inputArgs.size() ; i++) {
            ret.append(inputArgs.get(i).toString());
            if (i != inputArgs.size()-1) ret.append(", ");
        }
        ret.append(")");
        return ret.toString();
    }
    @Override public void accept(Pass visitor) {visitor.visit(this);}
}
