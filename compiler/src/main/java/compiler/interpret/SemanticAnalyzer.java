package compiler.interpret;
import compiler.node.*;
import compiler.analysis.*;
import compiler.interpret.Typecheck;

import java.util.*;

public class SemanticAnalyzer extends DepthFirstAdapter {
	
	Hashtable symble_table = new Hashtable();
	
	
	public void outAVariableDeclaration(AVariableDeclaration node)
	{
		TIdentifier ident = node.getIdentifier();
		
		String key = ident.toString().toUpperCase().trim();
		
		List<TypeExpression> TypeExpression = Typecheck.TypeExpressions(node.getVariables(), node.getVariableTail());
		Type Type = Typecheck.typeChecker(TypeExpression, symble_table, node.getVariables());

		if(symble_table.containsKey(key))
		{
			System.out.println("Identifier already defined");
			System.exit(0);
		}
		else
		{
			symble_table.put(key,Type);
		}
	}
	
	public void outAParams(AParams node)
	{
		TIdentifier ident = node.getIdentifier();
		
		String key = ident.toString().toUpperCase().trim();
		
		if(symble_table.containsKey(key))
		{
			System.out.println("Identifier already defined");
			System.exit(0);
		}
		else
		{
			List<TypeExpression> Type = new ArrayList<TypeExpression>();
			symble_table.put(key, Type);
		}
	}
	
	public void outAVarname(AVarname node)
	{
		TIdentifier ident = node.getIdentifier();
		
		String key = ident.toString().toUpperCase().trim();
		if(!key.equals("GRID"))
		{
			if(!symble_table.containsKey(key))
			{
				System.out.println("Identifier not defined: " + node.getIdentifier());
				System.exit(0);
			}
		}
	}

	
	public void outAProgram(AProgram node)
	{
		//Printer symble tablet man kan se om det virker :D
		System.out.println(symble_table);
	}
	
	public void outAFuncDecl(AFuncDecl node){
		TIdentifier ident = node.getIdentifier();
		
		String key = ident.toString().toUpperCase().trim();
		
		if (!symble_table.containsKey(key))
		{
			System.out.println("Identifier already defined");
			System.exit(0);
		}
	}
	
}