package simpleAdder.interpret;

import simpleAdder.node.*;
import simpleAdder.analysis.*;
import java.util.*;

public class SymbolTable extends DepthFirstAdapter {

	Hashtable symbol_table = new Hashtable();
	
	//Override metod from DepthFirstAdapter
	public void outAIdentifierValue(AIdentifierValue node){
		//Gets the identifier tokens value (name of the identifier)
		TIdentifier ident = node.getIdentifier();
		
		// Convert ident to uppercase text and stores it in String key
		String key = ident.getText().toUpperCase();
		
		if (symbol_table.containsKey(key))
		{
			System.out.println("Identifier already defined: " + key);
			System.exit(0);
		}
		else
		{
			symbol_table.put(key, key);
		}
	}
}
