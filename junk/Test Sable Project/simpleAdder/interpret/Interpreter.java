/* An interpreter for the simple math language we all espouse. */
package simpleAdder.interpret;
 
import simpleAdder.node.* ;
import simpleAdder.analysis.* ;

import java.lang.System;

public class Interpreter extends DepthFirstAdapter {
 
   public void defaultIn(@SuppressWarnings("unused") Node node)
   {
       // Do nothing
   	//System.out.println(GlobalString.space + node.getClass() + " : " + node);
   }
   /*
	   System.out.println(token.getClass() +
               ", state : " + state.id() +
               ", text : [" + token.getText() + "]");
   
   */
} 