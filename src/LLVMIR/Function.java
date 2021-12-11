package LLVMIR;

import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;
import LLVMIR.Type.VoidType;

import java.util.ArrayList;

public class Function {
    public Integer      regCounter;
    public String       name;
    public BaseType     retType;
    public BasicBlock   entryBlock;
    public ArrayList<VirtualReg> args;
//    public Map<String, Integer> localVars;  // varName -> Virtual Reg
    //define alloca in the front of BB
    public Function(String _name, BaseType _retType) {
        regCounter = 0;
        name       = _name;
        retType    = _retType;
        entryBlock = new BasicBlock(null, null, 0);
        args       = new ArrayList<>();
    }
    public BasicBlock getEntry() { return entryBlock; }
    public String toString() {
        //
        StringBuilder ret = new StringBuilder("define dso_local "+retType.toString()+" @"+name);
        // arguments
        int argsCounter = 0;
        ret.append("(");
        for (VirtualReg arg : args) {
            ret.append(arg.toString());
            argsCounter++;
            if (argsCounter != args.size()) ret.append(", ");
        }
        ret.append(")");
        // attributes

        // body
        BasicBlock curBlock = entryBlock;
        ret.append("{\n");
        while (curBlock != null) {
            ret.append(curBlock.toString());
            curBlock = curBlock.next;
        }
        ret.append("}\n");
        return ret.toString();
    }
    public void appendArgument(BaseType baseType) { args.add(new VirtualReg(baseType, takeLabel()));}
    public int takeLabel() {
        return regCounter++;
    }
    public boolean isEmpty() { return regCounter == 0; }
    public boolean isVoid() { return retType instanceof VoidType;}
}
//for : 1. init part (in cur blk) 2. cmp: new blk (to exit or exe) 3.exe part (to cmp) 4. exit: new block
// 1. append 2. visit cmp, new blk ... what about label? 3. visit body, branch to prev (feedback to prev? )4. exit