package Util.symbols;

import Util.Type;
import Util.scope.Scope;

import java.util.ArrayList;

public class FuncSymbol extends Symbol{
    public Type retType;
    public ArrayList<Type> parameters = new ArrayList<>();
    public FuncSymbol(String _identifier, Scope _scope) {
        super(_identifier, _scope);
    }
}
