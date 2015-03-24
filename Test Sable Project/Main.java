import java.io.FileReader;
import java.io.PushbackReader;

import simpleAdder.interpret.Interpreter;
import simpleAdder.interpret.SymbolTable;
import simpleAdder.lexer.Lexer;
import simpleAdder.node.Start;
import simpleAdder.parser.Parser;


public class Main {
	public static void main(String[] args) {
	      if (args.length > 0) {
	         try {
	            // Form our AST 
	            Lexer lexer = new Lexer (new PushbackReader(
	               new FileReader(args[0]), 1024));
	            Parser parser = new Parser(lexer);
	            Start ast = parser.parse() ;
	 
	            // Get our Interpreter going.
	            Interpreter interp = new Interpreter () ;
	            System.out.println();
	            ast.apply(interp) ;
	            
	            SymbolTable symboltab = new SymbolTable();
	            ast.apply(symboltab);

	         }
	         catch (Exception e) {
	            System.out.println (e) ;
	         }
	      } else {
	         System.err.println("usage: java simpleAdder inputFile");
	         System.exit(1);
	      }
	   }
}
