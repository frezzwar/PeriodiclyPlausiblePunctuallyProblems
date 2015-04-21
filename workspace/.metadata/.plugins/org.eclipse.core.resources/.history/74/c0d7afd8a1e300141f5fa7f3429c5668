/* An interpreter for the simple math language we all espouse. */
package compiler.interpret;
 
import compiler.node.* ;
import compiler.analysis.* ;

import java.lang.System;

public class Interpreter extends DepthFirstAdapter {
 
	
	public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
		System.out.println(node.getClass() + " : " + node);
    }
   /*
        // Print tokens and ignores bland and EOF tokens
    	if (!token.getClass().toString().endsWith("TBlank") && !token.getClass().toString().endsWith("EOF")){
    		System.out.println(token.getClass() +
                    ", state : " + state.id() +
                    ", text : [" + token.getText() + "]");
    	}
   */
} 