package LLVMIR;

import LLVMIR.Inst.Inst;
import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;
import LLVMIR.Type.VoidType;

import java.util.ArrayList;

public class Function {
    public Integer      regCounter;
    public String       name;
    public BaseType     retType;
    public BasicBlock   entryBlock;
    public ArrayList<VirtualReg> args = new ArrayList<>();
    //define alloca in the front of BB

    // assign order: 1. paraReg 2. entry block
    public Function(String _name, BaseType _retType) {
        regCounter = 0;
        name       = _name;
        retType    = _retType;
        entryBlock = null;
    }
    public BasicBlock getEntry() {
        entryBlock = new BasicBlock(null, null, takeLabel());
        return entryBlock;
    }
    public void accept(IRVisitor visitor) {visitor.visit(this);}
    public void accept(Pass visitor) {visitor.visit(this);}
    public void appendArgument(BaseType baseType) { args.add(new VirtualReg(baseType, takeLabel()));}
    public int takeLabel() {
        return regCounter++;
    }
    public int getLabel() { return regCounter; }
    public boolean isEmpty() { return regCounter == 0; }
    public boolean isVoid() { return retType instanceof VoidType;}
}
//for : 1. init part (in cur blk) 2. cmp: new blk (to exit or exe) 3.exe part (to cmp) 4. exit: new block
// 1. append 2. visit cmp, new blk ... what about label? 3. visit body, branch to prev (feedback to prev? )4. exit