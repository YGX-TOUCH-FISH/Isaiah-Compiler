import AST.RootNode;
import FrontEnd.ASTBuilder;
import FrontEnd.SymbolCollector;
import Parser.*;
import Util.error.IsaiahErrorListener;
import Util.error.error;
import Util.scope.GlobalScope;
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

        try {
            RootNode ASTRoot;
            GlobalScope gScope = new GlobalScope(null);

            IsaiahLexer lexer = new IsaiahLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new IsaiahErrorListener());
            IsaiahParser parser = new IsaiahParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new IsaiahErrorListener());
            ParseTree parseTreeRoot = parser.program();

            ASTBuilder astBuilder = new ASTBuilder(gScope);
            ASTRoot = (RootNode) astBuilder.visit(parseTreeRoot);

            new SymbolCollector(gScope).visit(ASTRoot);
//        new SemanticChecker(gScope).visit(ASTRoot);
            int a = 1;
        } catch (error er) {
            System.err.println(er.toString());
            throw new RuntimeException();
        }
        // TODO: 2021/10/14
        //  1 hashmap check                                     over
        //  2 definition check
        //  4 null element? throw error in SemanticChecker
    }
}