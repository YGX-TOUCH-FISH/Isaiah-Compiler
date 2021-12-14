package Util.scope;

import Util.Type;
import Util.error.semanticError;
import Util.position;

import java.util.HashMap;
import java.util.HashSet;

public class Scope {
    private HashMap<String, Type> define;
//    private HashMap<String, Entity> entity = new HashMap<>();

    //only used by globalScope
    // TODO: 2021/10/14 Waiting for IR implement
    private Scope parent;

    private boolean inLoop;
    private boolean inLambda;
    public Scope(Scope _parent) {
        define = new HashMap<>();
        parent = _parent;
        if (_parent != null) {
            inLoop = _parent.inLoop;
            inLambda = _parent.inLambda;
        }
        else {
            inLoop = false;
            inLambda = false;
        }
    }

    public Scope getParent() { return parent; }

    public void defineVar(String _name, Type _type, position _pos) {
        if (define.containsKey(_name)) {
            throw new semanticError("[ERROR]variable redefine: ", _pos);
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

//    public Entity getEntity(String _name, boolean lookUpon) {
//        if (entity.containsKey(_name)) return entity.get(_name);
//        else if (lookUpon && parent != null) return parent.getEntity(_name, true);
//        else return null;
//    }

    public void intoLoop() {
        inLoop = true;
    }
    public void intoLambda() {
        inLambda = true;
    }

    public boolean isInLoop() {
        return inLoop;
    }
    public boolean isInLambda() { return inLambda; }

}
