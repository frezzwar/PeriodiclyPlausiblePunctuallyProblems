package compiler.interpret;
import compiler.node.*;
import compiler.analysis.*;
import compiler.interpret.Typecheck;
import org.sablecc.sablecc.node.TId;

import java.io.File;
import java.util.*;

public class SemanticAnalyzer extends DepthFirstAdapter {

	private SymbolTable symbolTable;

	public SemanticAnalyzer(SymbolTable symTable){
		this.symbolTable = symTable;
	}

	@Override
	public void outAVariableDecl(AVariableDecl node)
	{
		TIdentifier ident = node.getIdentifier();
		Type type = null;
		String key = ident.toString().toUpperCase().trim();

		if (node.getVariable().getClass() != AListVariable.class)
		{
			List<TypeExpression> TypeExpression = Typecheck.TypeExpressions(node.getVariable().toString());
			type = Typecheck.typeChecker(TypeExpression, symbolTable, node.getVariable().toString());
		}
		else
		{
			AListVariable listVariables = (AListVariable) node.getVariable();
			String[] temp = listVariables.getListVar().toString().split(",");
			for (int i = 0; i < temp.length; i++)
			{
				if (type == null)
				{
					List<TypeExpression> TypeExpression = Typecheck.TypeExpressions(temp[0].toString().trim());
					type = Typecheck.typeChecker(TypeExpression, symbolTable, temp[0].toString().trim());
				}
				else
				{
					List<TypeExpression> TypeExpression = Typecheck.TypeExpressions(temp[i].toString().trim());
					if(type != Typecheck.typeChecker(TypeExpression, symbolTable, temp[i].toString().trim()))
					{
						System.out.println("Type Error" + node.getIdentifier());
					}
				}
			}
		}

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

	public void ooutAVarAssignExpr(AVarAssignExpr node)
	{

		if (null != node.getMember())
		{
			String key = node.getIdentifier().toString().toUpperCase().trim();
			List<TypeExpression> TypeExpression = Typecheck.TypeExpressions(node.getExpr().toString());
			Type type = Typecheck.typeChecker(TypeExpression, symbolTable, node.getExpr().toString());

			if (symbolTable.VarPrevDeclared(key))
			{
				if (symbolTable.GetVariable(key) != type)
				{
					System.out.println(node.getIdentifier() + "is of type " + symbolTable.GetVariable(key) + ", but you are trying to assign it a " + type);
					System.exit(0);
				}
			}
		}
		else
		{
			//TODO typecheck figur
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
		symbolTable.AddVariable(key, Type.parameter);
	}

	@Override
	public void outAParamsTail(AParamsTail node){
		TIdentifier ident = node.getIdentifier();
		String key = ident.toString().toUpperCase().trim();

		if (symbolTable.VarDeclaredInCurrentScope(key)){
			System.out.println("Identifier already defined: " + ident);
			System.exit(0);
		}
		symbolTable.AddVariable(key, Type.parameter);
	}

	@Override
	public void outAProgram(AProgram node)
	{
		//Temp: Printer symboltable for at se om det virker
		System.out.println(symbolTable.toString());
	}

	@Override
	public void inAIfStmtControlStmt(AIfStmtControlStmt node){

		symbolTable.OpenScope();
	}

	@Override
	public void outAIfStmtControlStmt(AIfStmtControlStmt node){
		symbolTable.CloseScope();
	}

	@Override
	public void inAElseStmtElseStmt(AElseStmtElseStmt node){
		symbolTable.OpenScope();
	}

	@Override
	public void outAElseStmtElseStmt(AElseStmtElseStmt node){
		symbolTable.CloseScope();
	}

	@Override
	public void inAForeachControlStmt(AForeachControlStmt node){
		TIdentifier ident = node.getIdentifier();
		String key = ident.toString().toUpperCase().trim();
		String listKey = node.getList().toString().toUpperCase().trim();

		symbolTable.OpenScope();
		symbolTable.AddVariable(key, symbolTable.GetVariable(listKey));
	}

	@Override
	public void outAForeachControlStmt(AForeachControlStmt node){
		symbolTable.CloseScope();
	}

	@Override
	public void inARepeatControlStmt(ARepeatControlStmt node){
		symbolTable.OpenScope();
	}

	@Override
	public void outARepeatControlStmt(ARepeatControlStmt node){
		symbolTable.CloseScope();
	}

	@Override
	public void inAWhileControlStmt(AWhileControlStmt node){
		symbolTable.OpenScope();
	}

	@Override
	public void outAWhileControlStmt(AWhileControlStmt node){
		symbolTable.CloseScope();
	}

	@Override
	public void inAFuncCall(AFuncCall node){
		TIdentifier ident = node.getIdentifier();
		String key = ident.toString().toUpperCase().trim();
		if (!symbolTable.FuncPrevDeclared(key)){
			System.out.println("Function not declared: " + ident.toString());
			System.exit(0);
		}
		else
		{
			List<TypeExpression> typeExpressions = symbolTable.GetFunction(key);
			//Typecheck.typeChecker()
		}
	}

	@Override
	public void inAGridDecl(AGridDecl node){
		String ident = node.getIdentifier().toString();
		String key = ident.toUpperCase().trim();
		if (symbolTable.CurrentScope().VarDeclaredInScope(key)){
			System.out.println("Identifier already declared: " + ident);
			System.exit(0);
		}
		symbolTable.AddVariable(key, Type.grid);
	}

	private String currObj;
	private boolean inObjDecl = false;
	@Override
	public void inAObjectDecl(AObjectDecl node){
		String key = node.getId1().toString().toUpperCase().trim();

		if (symbolTable.FigureDeclared(key) || symbolTable.VarDeclaredInCurrentScope(key)){
			System.out.println("Variable with name already declared: " + key);
			System.exit(0);
		}
		symbolTable.AddFigure(key);

		/* Checks if specified figure file exists */
		String filePath = "\"" + node.getId2().toString().trim() + "\"";
		if (!new File(filePath).isFile()) {
			System.out.println("File does not exist: " + filePath);
			System.exit(0);
		}

		currObj = key;
		inObjDecl = true;
	}

	@Override
	public void outAObjectDecl(AObjectDecl node){
		currObj = "";
		inObjDecl = false;
	}

	@Override
	public void inAMemberInObjDecl(AMemberInObjDecl node){

	}

	@Override
	public void inAVariableDecl(AVariableDecl node){
		String memName =  node.getIdentifier().toString().toUpperCase().trim();
		List<TypeExpression> typeExpressions = Typecheck.TypeExpressions(node.getVariable().toString());
		Type type = Typecheck.typeChecker(typeExpressions, symbolTable, node.getVariable().toString());

		if(inObjDecl){
			if(symbolTable.MemberDeclaredInFigure(currObj, memName)){
				System.out.println("Member already defined: " + "memName");
				System.exit(0);
			}
			symbolTable.AddMember(currObj, memName, type);
		}
	}

	@Override
	public void inAFuncDecl(AFuncDecl node){
		String methodName =  node.getIdentifier().toString().toUpperCase().trim();
		node.apply(new FunctionChecker(symbolTable));

		List<TypeExpression> typeExpressions = Typecheck.TypeExpressions(node.).toString());
		Type type = Typecheck.typeChecker(typeExpressions, symbolTable, node.getVariable().toString());

		if(inObjDecl){
			if(symbolTable.MemberDeclaredInFigure(currObj, memName)){
				System.out.println("Member already defined: " + "memName");
				System.exit(0);
			}
			symbolTable.AddMember(currObj, memName, type);
		}
	}


}
