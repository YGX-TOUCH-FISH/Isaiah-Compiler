package Util.symbols;

import Util.position;
import Util.scope.Scope;

public class Symbol {
    public String identifier;
    public Scope scope;
    public Symbol(String _identifier, Scope _scope) {
        this.identifier = _identifier;
        this.scope = _scope;
    }
}
