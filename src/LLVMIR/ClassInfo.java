package LLVMIR;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Type.BaseType;
import LLVMIR.Type.ClassType;
import LLVMIR.Type.IntType;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class ClassInfo {
//    private HashMap<String, BaseType> members;
    public String className;
    public ArrayList<String> ids;
    public ArrayList<BaseType> types;
    public ClassInfo(String name) {
        className = name;
        ids   = new ArrayList<>();
        types = new ArrayList<>();
    }
    public void appendMember(BaseType _baseType, String _id) {
        if (!ids.contains(_id)) {
            ids.add(_id);
            types.add(_baseType);
        }
    }
    public int getIndex(String _id) {
        return ids.indexOf(_id);
    }
    public BaseType getBaseType(String _id) {
        return types.get(ids.indexOf(_id));
    }
    public boolean contains(String _id) {
        return ids.contains(_id);
    }
    public void accept(IRVisitor visitor) {visitor.visit(this);}
    public int getByteWidth(IRModule module){
        int byteWidth = 0;
        for (BaseType baseType : types) {
            if (baseType instanceof IntType && ((IntType) baseType).bitWidth == 1) byteWidth += 1;
            else if (baseType instanceof ClassType) byteWidth += module.getClassInfo(((ClassType) baseType).className).getByteWidth(module);
            else byteWidth += baseType.getByteWidth();
        }
        return byteWidth;
    }
}
