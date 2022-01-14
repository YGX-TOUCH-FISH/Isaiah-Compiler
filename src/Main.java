import AST.RootNode;
import BackEnd.AsmPrinter;
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
        String DataInFile = "test.mx";
        String LLVMOutFile = "Isaiah.ll";
        String ASMOutFile = "Isaiah.s";
        InputStream input = new FileInputStream(DataInFile);
        PrintStream llvmOutput, asmOutput;
        boolean toConsole = false;
        try {
            llvmOutput = toConsole ? System.out : new PrintStream(LLVMOutFile);
            asmOutput  = toConsole ? System.out : new PrintStream(ASMOutFile);
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
            IRModule irModule = irBuilder.BuiltRoot();
            new IRPrinter(llvmOutput).visit(irModule);
            System.out.println("[2] LLVM code generated over.");

            // ASM generate & Print

//            new AsmPrinter(asmOutput).visit();
            System.out.println("[3] Assemble code generated over.");
        } catch (error er) {
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }
}