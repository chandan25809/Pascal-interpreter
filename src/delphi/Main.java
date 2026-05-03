import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        // Check if a file path was provided
        if (args.length < 1) {
            System.err.println("Usage: java Main <input-file>");
            return;
        }

        // Read the input file from command-line arguments
        String inputFile = args[0]; 
        InputStream inputStream = new FileInputStream(inputFile);

        // Create a lexer and parser
        CharStream input = CharStreams.fromStream(inputStream);
        delphiLexer lexer = new delphiLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        delphiParser parser = new delphiParser(tokens);

        // Parse the input file (start from the 'program' rule)
        delphiParser.ProgramContext tree = parser.program();

        // Create the interpreter (listener) and execute
        Interpreter interpreter = new Interpreter();
        interpreter.interpret(tree);
    }
}
