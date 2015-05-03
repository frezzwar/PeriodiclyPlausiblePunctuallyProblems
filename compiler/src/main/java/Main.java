/* Create an AST, then invoke our interpreter. */


import interpret.ClassGenerator;
import interpret.FileSetup;
import interpret.Interpreter;
import interpret.SemanticAnalyzer;
import parser.* ;
import lexer.* ;
import node.* ;

import java.io.* ;
 
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
            System.out.println("Ok");
            
            ast.apply(new SemanticAnalyzer());
            
            FileSetup.Setup();
            //ast.apply(new ClassGenerator());
            
         }
         catch (Exception e) {
            System.out.println (e) ;
         }
      } else {
         System.err.println("Missing indput file");
         System.exit(1);
      }
   }
}
