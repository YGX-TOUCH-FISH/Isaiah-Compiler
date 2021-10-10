package Util.scope;

import Util.Type;
import Util.error.semanticError;
import Util.position;

import java.util.HashMap;

public class GlobalScope extends Scope{
    //TODO: collect all Type definition
    //      because cannot define Class in Function

    HashMap<String, Type> globalDef = new HashMap<>();

    public GlobalScope(Scope _parent) {
        super(_parent);
    }

    public void addType(String _name, Type _type, position pos) {
        if (globalDef.containsKey(_name))
            throw new semanticError("[ERROR]redefinition of " + _name, pos);
        globalDef.put(_name, _type);
    }

    public Type getTypeByName(String _name, position pos) {
        if (globalDef.containsKey(_name)) return globalDef.get(_name);
        else throw new semanticError("[ERROR]no such type: "+_name, pos);
    }
}
