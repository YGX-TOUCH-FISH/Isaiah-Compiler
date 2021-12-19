import AST.RootNode;
import BackEnd.IRBuilder;
import BackEnd.IRPrinter;
import FrontEnd.*;
import LLVMIR.IRModule;
import Parser.*;
import Util.error.IsaiahErrorListener;
import Util.error.error;
import Util.scope.GlobalScope;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        String DataInFile = "testcases/codegen/t30.mx";
        String LLVMOutFile = "Isaiah.ll";
        InputStream input = new FileInputStream(DataInFile);
        PrintStream output;
        boolean toConsole = false;
        try {
            output = toConsole ? System.out : new PrintStream(LLVMOutFile);
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
            new SemanticChecker(gScope).visit(ASTRoot);
            System.out.println("[1] Semantic check passed.");
            // IR generate & Print
            IRBuilder irBuilder = new IRBuilder();
            ASTRoot.accept(irBuilder);
            IRModule Module = irBuilder.BuiltRoot();
            new IRPrinter(output).visit(Module);
            System.out.println("[2] LLVM code generated over.");

        } catch (error er) {
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }
}