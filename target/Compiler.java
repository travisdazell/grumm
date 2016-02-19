import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Compiler {
	public static void main(String args[]) {
		System.out.println("----");
		System.out.println("Starting Compiler...");
		
		InputStream is = null;
		ANTLRInputStream input = null;
		
		try {
			is = new FileInputStream("testcode\\Test.grumm");
			input = new ANTLRInputStream(is);
		}
		catch (FileNotFoundException e) {
			System.err.println("Source code file not found");
		}
		catch (IOException e) {
			System.err.println("Error processing input file");
		}
		
		System.out.println("Running Lexical Analysis...");
		GrummLexer lexer = new GrummLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		System.out.println("\nRunning Parser...");
		GrummParser parser = new GrummParser(tokens);
		parser.setBuildParseTree(true);
		ParseTree tree = parser.file();
		
		System.out.println("\nPerforming Semantic Analysis...\n");
        CheckSymbols symbolChecker = new CheckSymbols();
        symbolChecker.process(tree);
        
        //TODO: code generator
	}
}