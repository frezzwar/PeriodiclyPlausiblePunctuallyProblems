package compiler.interpret;
import compiler.node.*;
import compiler.analysis.*;
import compiler.interpret.Typecheck;

import java.util.*;

public class SemanticAnalyzer extends DepthFirstAdapter {

	SymbolTable symbolTable = new SymbolTable();
	
	
	public void outAVariableDeclaration(AVariableDeclaration node)
	{
		TIdentifier ident = node.getIdentifier();
		
		String key = ident.toString().toUpperCase().trim();
		
		List<TypeExpression> TypeExpression = Typecheck.TypeExpressions(node.getVariables(), node.getVariableTail());
		Type type = Typecheck.typeChecker(TypeExpression, symbolTable, node.getVariables());

		if(symbolTable.VarDeclaredInCurrentScope(key))
		{
			System.out.println("Identifier already defined");
			System.exit(0);
		}
		else
		{
			symbolTable.AddVariable(key, type);
		}
	}
	
	public void outAParams(AParams node)
	{
		TIdentifier ident = node.getIdentifier();
		
		String key = ident.toString().toUpperCase().trim();
		
		if(symbolTable.VarDeclaredInCurrentScope(key))
		{
			System.out.println("Identifier already defined");
			System.exit(0);
		}
		else
		{
			/*
			List<TypeExpression> Type = new ArrayList<TypeExpression>();
			symbolTable.AddVariable(key, Type);
			*/
		}
	}
	
	public void outAVarname(AVarname node)
	{
		TIdentifier ident = node.getIdentifier();
		
		String key = ident.toString().toUpperCase().trim();
		if(!key.equals("GRID"))
		{
			if(!symbolTable.VarPrevDeclared(key))
			{
				System.out.println("Identifier not defined: " + node.getIdentifier());
				System.exit(0);
			}
		}
	}

	
	public void outAProgram(AProgram node)
	{
		//Printer symble tablet man kan se om det virker :D
		System.out.println(symbolTable.toString());
	}
	
	public void outAFuncDecl(AFuncDecl node){
		TIdentifier ident = node.getIdentifier();
		
		String key = ident.toString().toUpperCase().trim();
		
		if (!symbolTable.VarDeclaredInCurrentScope(key))
		{
			System.out.println("Identifier already defined");
			System.exit(0);
		}
	}
	
}
