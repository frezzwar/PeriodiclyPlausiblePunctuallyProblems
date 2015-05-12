package compiler.interpret;
import compiler.node.*;
import compiler.analysis.*;
import compiler.interpret.Typecheck;

import java.util.*;

public class SemanticAnalyzer extends DepthFirstAdapter {

	SymbolTable symbolTable = new SymbolTable();
	
	@Override
	public void outAVariableDeclaration(AVariableDeclaration node)
	{
		TIdentifier ident = node.getIdentifier();
		
		String key = ident.toString().toUpperCase().trim();
		
		List<TypeExpression> TypeExpression = Typecheck.TypeExpressions(node.getVariables(), node.getVariableTail());
		Type type = Typecheck.typeChecker(TypeExpression, symbolTable, node.getVariables());

		if(symbolTable.VarDeclaredInCurrentScope(key))
		{
			System.out.println("Identifier already defined: " + ident);
			System.exit(0);
		}
		else
		{
			symbolTable.AddVariable(key, type);
		}
	}

	@Override
	public void outAParams(AParams node)
	{
		TIdentifier ident = node.getIdentifier();
		String key = ident.toString().toUpperCase().trim();
		
		if(symbolTable.VarDeclaredInCurrentScope(key))
		{
			System.out.println("Identifier already defined: " + ident);
			System.exit(0);
		}
		else
		{
			/*
			List<TypeExpression> Type = new ArrayList<TypeExpression>();
			symbolTable.AddVariable(key, Type);
			*/
		}
		// TODO correct type
		symbolTable.AddVariable(key, Type.undefined);
	}

	@Override
	public void outAParamsTail(AParamsTail node){
		TIdentifier ident = node.getIdentifier();
		String key = ident.toString().toUpperCase().trim();

		if (symbolTable.VarDeclaredInCurrentScope(key)){
			System.out.println("Identifier already defined: " + ident);
			System.exit(0);
		}
		// TODO correct type
		symbolTable.AddVariable(key, Type.undefined);
	}

	@Override
	public void outAVarname(AVarname node)
	{
		TIdentifier ident = node.getIdentifier();
		
		String key = ident.toString().toUpperCase().trim();
		if(!key.equals("GRID"))
		{
			if(!symbolTable.VarPrevDeclared(key))
			{
				System.out.println("Identifier not defined: " + ident);
				System.exit(0);
			}
		}
	}

	@Override
	public void outAProgram(AProgram node)
	{
		//Temp: Printer symboltable for at se om det virker
		System.out.println(symbolTable.toString());
	}

	@Override
	public void inAFuncDecl(AFuncDecl node){
		TIdentifier ident = node.getIdentifier();

		String key = ident.toString().toUpperCase().trim();

		if (symbolTable.VarDeclaredInCurrentScope(key))
		{
			System.out.println("Identifier already defined: " + ident);
			System.exit(0);
		}

		//TODO correct types
		symbolTable.AddVariable(key, Type.undefined);
		symbolTable.OpenScope();
	}
	
}
