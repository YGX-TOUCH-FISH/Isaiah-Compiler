package LLVMIR;

import LLVMIR.Inst.Inst;
import LLVMIR.Type.BaseType;

import java.util.ArrayList;
import java.util.Map;

public class Function {
    public Integer      regCounter;
    public String       name;
    public BaseType     retType;
    public BasicBlock   headBlock, curBlock;
    public ArrayList<BaseType>  argsType;
//    public Map<String, Integer> localVars;  // varName -> Virtual Reg
    //define alloca in the front of BB
    public Function(String _name, BaseType _retType, ArrayList<BaseType> _argsType) {
        regCounter = 0;
        name       = _name;
        retType    = _retType;
        headBlock  = new BasicBlock();
        curBlock   = headBlock;
        if (_argsType != null) argsType = _argsType;
        else argsType = new ArrayList<>();
    }
    public void append(Inst inst) {
        curBlock.append(inst);
    }
    public String toString() {
        //
        StringBuilder ret = new StringBuilder("define dso_local "+retType.toString()+" @"+name);
        // arguments
        int argsCounter = 0;
        ret.append("(");
        for (BaseType baseType : argsType) {
            ret.append(baseType.toString());
            argsCounter++;
            if (argsCounter != argsType.size()) ret.append(", ");
        }
        ret.append(")");
        // attributes

        // body
        BasicBlock curBlock = headBlock;
        ret.append("{\n");
        while (curBlock != null) {
            ret.append(curBlock.toString());
            curBlock = curBlock.next;
        }
        ret.append("}\n");
        return ret.toString();
    }
    public int takeLabel() {
        return regCounter++;
    }
    public boolean isEmpty() { return regCounter == 0; }
}
//for : 1. init part (in cur blk) 2. cmp: new blk (to exit or exe) 3.exe part (to cmp) 4. exit: new block
// 1. append 2. visit cmp, new blk ... what about label? 3. visit body, branch to prev (feedback to prev? )4. exit