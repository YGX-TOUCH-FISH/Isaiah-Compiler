package LLVMIR.Type;

import java.util.ArrayList;

public class ClassType extends BaseType{
    String className;
//    ArrayList<BaseType> memberType;
    @Override public String toString() {
        return "%struct."+className;
    }
}
