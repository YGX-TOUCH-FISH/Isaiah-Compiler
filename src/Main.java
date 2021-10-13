import AST.RootNode;
import FrontEnd.ASTBuilder;
import Parser.*;
import Util.scope.GlobalScope;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

// TODO: 2021/10/14 single return is permitted in constructor 
public class Main {
    public static void main(String[] args) throws Exception{
        String name = "test.mx";
        InputStream input = new FileInputStream(name);

        RootNode ASTRoot;
        GlobalScope gScope = new GlobalScope(null);

        IsaiahLexer lexer = new IsaiahLexer(CharStreams.fromStream(input));
        lexer.removeErrorListeners();
        IsaiahParser parser = new IsaiahParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        ParseTree parseTreeRoot = parser.program();

        ASTBuilder astBuilder = new ASTBuilder(gScope);
        ASTRoot = (RootNode) astBuilder.visit(parseTreeRoot);
        int a = 1;
    }
}