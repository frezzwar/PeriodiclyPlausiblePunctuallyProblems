/* Create an AST, then invoke our interpreter. */
package compiler;

import compiler.interpret.*;
import compiler.parser.* ;
import compiler.lexer.* ;
import compiler.node.* ;

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

            SymbolTable symTable = new SymbolTable();

            ast.apply(new FuncInit(symTable));
            ast.apply(new SemanticAnalyzer(symTable));

            FileSetup.Setup();
            ast.apply(new CodeGenerator());
            System.out.println("Done");

         }
         catch (Exception e) {
            e.printStackTrace();
         }
      } else {
         System.err.println("Missing input file");
         System.exit(1);
      }
   }
}
