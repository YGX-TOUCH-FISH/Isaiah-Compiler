import Parser.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception{
        String name = "test.mx";
        InputStream input = new FileInputStream(name);

        IsaiahLexer lexer = new IsaiahLexer(CharStreams.fromStream(input));
        lexer.removeErrorListeners();
        IsaiahParser parser = new IsaiahParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        ParseTree parseTreeRoot = parser.program();
        int a = 1;

    }
}
