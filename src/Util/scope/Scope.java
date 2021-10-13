package Util.scope;

import Util.Type;
import Util.error.semanticError;
import Util.obj.Entity;
import Util.position;

import java.util.HashMap;

public class Scope {
    // TODO: 2021/10/14 waiting for REWRITE!!
    private HashMap<String, Type> define;
    private HashMap<String, Entity> entity = new HashMap<>();
    // TODO: 2021/10/14 Waiting for IR implement
    private Scope parent;

    public Scope(Scope _parent) {
        define = new HashMap<>();
        parent = _parent;
    }

    public Scope getParent() { return parent; }

    public void defineVar(String _name, Type _type, position _pos) {
        if (define.containsKey(_name)) {
            throw new semanticError("Semantic Error: variable redefine", _pos);
        }
        define.put(_name, _type);
    }

    public boolean containVar(String _name, boolean lookUpon) {
        if (define.containsKey(_name)) return true;
        else if (lookUpon && parent != null) return parent.containVar(_name, true);
        else return false;
    }

    public Type getType(String _name, boolean lookUpon) {
        if (define.containsKey(_name)) return define.get(_name);
        else if (lookUpon && parent != null) return parent.getType(_name, true);
        else return null;
    }

    public Entity getEntity(String _name, boolean lookUpon) {
        if (entity.containsKey(_name)) return entity.get(_name);
        else if (lookUpon && parent != null) return parent.getEntity(_name, true);
        else return null;
    }
}
