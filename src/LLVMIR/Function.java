package LLVMIR;

import LLVMIR.Type.BaseType;

import java.util.ArrayList;

public class Function {
    public Integer  regCounter;
    public BaseType retType;
    public ArrayList<BaseType> argsType;
    public BasicBlock head;
    public String name;
    public Function(String _name) {
        regCounter = 0;
        name = _name;

    }
}
