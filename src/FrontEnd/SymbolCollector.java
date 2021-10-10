package FrontEnd;

import AST.ASTVisitor;
import Util.scope.GlobalScope;
import Util.scope.Scope;

public class SymbolCollector implements ASTVisitor {
    public GlobalScope globalScope;
    public SymbolCollector(GlobalScope _globalScope) {
        globalScope = _globalScope;
    }


}
