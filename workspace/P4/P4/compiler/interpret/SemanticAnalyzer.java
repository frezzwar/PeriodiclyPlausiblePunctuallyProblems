package compiler.interpret;
import compiler.node.*;
import compiler.analysis.*;

import java.util.*;

public class SemanticAnalyzer extends DepthFirstAdapter {
	
	Hashtable symble_table = new Hashtable();
	
	
	public void outAVariableDeclaration(AVariableDeclaration node)
	{
		TIdentifier ident = node.getIdentifier();
		
		String key = ident.toString().toUpperCase();
		//System.out.println(node.getVariables());
		
		if(symble_table.containsKey(key))
		{
			System.out.println("Identifier already defined");
			System.exit(0);
		}
		else
		{
			symble_table.put(key,key);
		}
	}
	
	public void outAParams(AParams node)
	{
		TIdentifier ident = node.getIdentifier();
		
		String key = ident.toString().toUpperCase();
		
		if(symble_table.containsKey(key))
		{
			System.out.println("Identifier already defined");
			System.exit(0);
		}
		else
		{
			symble_table.put(key,key);
		}
	}
	
	public void outAVarname(AVarname node)
	{
		TIdentifier ident = node.getIdentifier();
		
		String key = ident.toString().toUpperCase();
		if(!key.equals("GRID "))
		{
			if(!symble_table.containsKey(key))
			{
				System.out.println("Identifier not defined: " + node.getIdentifier());
				System.exit(0);
			}
		}
	}
	

}