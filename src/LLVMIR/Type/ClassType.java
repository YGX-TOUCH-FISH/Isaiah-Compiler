package LLVMIR.Type;

import LLVMIR.Oprand.ConstNull;
import LLVMIR.Oprand.Oprand;

import java.util.ArrayList;

public class ClassType extends BaseType{
    public String className;
//    ArrayList<BaseType> memberType;
    public ClassType(String _className) {
        className = _className;
//        memberType = new ArrayList<>();
    }
    @Override public String toString() {
        return "%class."+className;
    }
    @Override public Oprand getZeroInit() {
        return new ConstNull();
    }
}
