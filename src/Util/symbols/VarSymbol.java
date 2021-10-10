package Util.symbols;

import Util.Type;
import Util.scope.Scope;

public class VarSymbol extends Symbol{
    public Type type;
    public VarSymbol(String _identifier, Scope _scope) {
        super(_identifier, _scope);
    }
}
