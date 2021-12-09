package LLVMIR;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Type.BaseType;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

public class ClassInfo {
    private ArrayList<BaseType> baseTypes;
    private ArrayList<String> ids;
    private ArrayList<Oprand> initValues;
    public ClassInfo() {
        baseTypes = new ArrayList<>();
        ids = new ArrayList<>();
        initValues = new ArrayList<>();
    }
    public void appendMember(BaseType _baseType, String _id, Oprand _initValues) {
        baseTypes.add(_baseType);
        ids.add(_id);
        initValues.add(_initValues);
    }
    public int getIndex(String _id) {
        return ids.indexOf(_id);
    }
}
