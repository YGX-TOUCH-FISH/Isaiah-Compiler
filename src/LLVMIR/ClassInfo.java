package LLVMIR;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Type.BaseType;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class ClassInfo {
//    private HashMap<String, BaseType> members;
    private ArrayList<String> ids;
    private ArrayList<BaseType> types;
    public ClassInfo() {
        ids   = new ArrayList<>();
        types = new ArrayList<>();
    }
    public void appendMember(BaseType _baseType, String _id) {
        if (!ids.contains(_id)) {
            ids.add(_id);
            types.add(_baseType);
        }
    }
    public ArrayList<String> getIDs() {
        return ids;
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
}
