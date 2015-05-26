package compiler.interpret;
import compiler.node.*;
import compiler.analysis.*;
import compiler.interpret.Typecheck;
import org.sablecc.sablecc.node.TId;

import java.io.File;
import java.util.*;

public class SemanticAnalyzer extends DepthFirstAdapter {

	private SymbolTable symbolTable;

	private String currObj;
	private boolean inEventDecl = false;
	private boolean inObjDecl = false;
	private boolean inForeach = false;
	private boolean inFuncDecl = false;

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
			if (symbolTable.IdentifierUsedInCurrentScope(key)){
				System.out.println("Identifier already used: " + key);
				System.exit(0);
			}
			symbolTable.AddList(key, type);
		}


	}

	public void outAVarAssignExpr(AVarAssignExpr node)
	{
		AValueExpr expr = (AValueExpr) node.getExpr();
		if(expr.getValue().getClass() == AFuncCallValue.class)
		{
			AFuncCall call = (AFuncCall)((AFuncCallValue) expr.getValue()).getFuncCall();
			List<TypeExpression> typeExpressions = symbolTable.GetFunction(call.getIdentifier().toString().toUpperCase().trim());
			Type type = Typecheck.typeChecker(typeExpressions, symbolTable, call.getCallParams().toString());
			if (type != symbolTable.GetVariable(call.getIdentifier().toString().toUpperCase().trim()))
			{
				System.out.println("TypeError " + call.getIdentifier() + "is of type " + symbolTable.GetVariable(call.getIdentifier().toString().toUpperCase().trim()) + " and you are trying to assign it a " + type);
				System.exit(0);
			}
		}
		else if (null == node.getMember())
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
			List<TypeExpression> TypeExpression = Typecheck.TypeExpressions(node.getExpr().toString());
			Type type = Typecheck.typeChecker(TypeExpression, symbolTable, node.getExpr().toString());
			if (type != symbolTable.GetMember(node.getIdentifier().toString().toUpperCase().trim(), ((AMember) node.getMember()).getIdentifier().toString().toUpperCase().trim()))
			{
				System.out.println(((AMember)node.getMember()).getIdentifier() + "is of type" + symbolTable.GetMember(node.getIdentifier().toString().toUpperCase().trim(), node.getMember().toString().toUpperCase().trim()) + " and you are trying to assign it a expresion of type" + type);
				System.exit(0);
			}
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


	@Override
	public void inAObjectDecl(AObjectDecl node){
		String key = node.getId1().toString().toUpperCase().trim();

		if (symbolTable.FigureDeclared(key) || symbolTable.VarDeclaredInCurrentScope(key)){
			System.out.println("Variable with name already declared: " + key);
			System.exit(0);
		}
		symbolTable.AddFigure(key);

		/*
			Checks if specified figure file exists
		String filePath = "\"" + node.getId2().toString().trim() + "\"";
		if (!new File(filePath).isFile()) {
			System.out.println("File does not exist: " + filePath);
			System.exit(0);
		}
		*/

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
		String name =  node.getIdentifier().toString().toUpperCase().trim();
		List<TypeExpression> typeExpressions = Typecheck.TypeExpressions(node.getVariable().toString());
		Type type = Typecheck.typeChecker(typeExpressions, symbolTable, node.getVariable().toString());

		if (inObjDecl){
			if(symbolTable.MemberDeclaredInFigure(currObj, name)){
				System.out.println("Member already defined: " + "memName");
				System.exit(0);
			}
			symbolTable.AddMember(currObj, name, type);
		}
		if(symbolTable.VarDeclaredInCurrentScope(name)){
			System.out.println("Variable already defined: " + "memName");
			System.exit(0);
		}
		symbolTable.AddVariable(name, type);

	}

	@Override
	public void inAFuncDecl(AFuncDecl node){
		inFuncDecl = true;
		String methodName =  node.getIdentifier().toString().toUpperCase().trim();
		List<TypeExpression> typeExpressions = new LinkedList<>();
		node.apply(new FunctionChecker(typeExpressions));

		if(inObjDecl){
			if(symbolTable.MethodDeclaredInFigure(currObj, methodName)){
				System.out.println("Method already defined: " + "memName");
				System.exit(0);
			}
			symbolTable.AddMethod(currObj, methodName, typeExpressions);
		}
	}

	@Override
	public void outAFuncDecl(AFuncDecl node){
		inFuncDecl = false;
	}

	@Override
	public void inAEventDecl(AEventDecl node){
		inEventDecl = true;
	}

	@Override
	public void outAEventDecl(AEventDecl node){
		inEventDecl = false;
	}

	@Override
	public void inAForeachControlStmt(AForeachControlStmt node){
		inForeach = true;
		String key = node.getList().toString().toUpperCase().trim();
		if (!symbolTable.ListDeclared(key)){
			System.out.println("List not previously declared: " + key);
		}
	}

	@Override
	public void outAForeachControlStmt(AForeachControlStmt node){
		inForeach = false;
	}

	@Override
	public void inABody(ABody node){
		symbolTable.OpenScope();

		if (inEventDecl){
			AEventDecl event = (AEventDecl) node.parent();
			symbolTable.AddVariable(event.getIdentifier().toString().toUpperCase().trim(), Type.keypress);
		}

		if (inForeach){
			AForeachControlStmt stmt = (AForeachControlStmt) node.parent();

			String item = stmt.getIdentifier().toString().toUpperCase().trim();
			String list = stmt.getList().toString().toUpperCase().trim();

			symbolTable.AddVariable(item, symbolTable.GetList(list));
		}

		if(inFuncDecl){
			AFuncDecl func = (AFuncDecl) node.parent();
			String[] params = func.getParams().toString().split(",");
			for (String item : params){
				if (symbolTable.IdentifierUsedInCurrentScope(item.toUpperCase().trim())){
					System.out.println("Identifier already used" + item);
					System.exit(0);
				}
				if (item.trim().endsWith("[]")){
					symbolTable.AddList(item, Type.parameter);
				}
				symbolTable.AddVariable(item, Type.parameter);
			}
		}
	}

	@Override
	public void outABody(ABody node){
		symbolTable.CloseScope();
	}

}
