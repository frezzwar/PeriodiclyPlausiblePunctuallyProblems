package compiler.interpret;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SymbolTable {
	private HashMap<String, List<TypeExpression>> functions = new HashMap<>();
	private HashMap<String, Figure> figures = new HashMap<>();
	private Stack<Scope> scopes = new Stack<>();
	private Scope currentScope = null;

	public SymbolTable(){
		this.OpenScope();
	}

	public boolean IdentifierUsedInCurrentScope(String key){
		return CurrentScope().IdentifierUsedInScope(key);
	}

	public Type GetList(String key){
		return getList(key, CurrentScope());
	}

	private Type getList(String key, Scope scope){
		if (scope.GetList(key) != null){
			return scope.GetList(key);
		}
		else if (scope.Parent() != null){
			return getList(key, scope.Parent());
		}
		return null;
	}

	public void AddList(String key, Type type){
		CurrentScope().AddList(key, type);
	}

	public boolean ListDeclared(String key){
		return listDeclared(key, CurrentScope());
	}

	private boolean listDeclared(String key, Scope scope){
		if (scope.ListDeclared(key)){
			return true;
		}
		else if (scope.Parent() != null){
			return listDeclared(key, scope.Parent());
		}
		return false;
	}

	public Type GetMember(String figure, String member){
		if (this.GetFigure(figure) == null)
			return null;
		return this.GetFigure(figure).GetMember(member);
	}

	public List<TypeExpression> GetMethod(String figure, String method){
		if (this.GetFigure(figure) == null)
			return null;
		return this.GetFigure(figure).GetMethod(method);
	}

	public boolean FigureDeclared(String key){
		return figures.containsKey(key);
	}

	public Figure GetFigure(String key){
		return figures.get(key);
	}

	public void AddFigure(String key){
		figures.put(key, new Figure());
	}

	public void AddMember(String figure, String name, Type type){
		this.GetFigure(figure).AddMember(name, type);
	}

	public boolean MemberDeclaredInFigure(String figure, String mem){
		if (figures.isEmpty())
			return false;
		return figures.get(figure).HasMember(mem);
	}

	public boolean MethodDeclaredInFigure(String figure, String method){
		if (figures.isEmpty())
			return false;
		return  figures.get(figure).HasMethod(method);
	}

	public void AddMethod(String figure, String name, List<TypeExpression> types){
		this.GetFigure(figure).AddMethod(name, types);
	}

	public void ChangeType(String key, Type type)
	{
		changeType(currentScope, key, type);
	}

	private void changeType(Scope scope, String key, Type type)
	{
		if (scope.GetVariable(key) != null){
			scope.ChangeVariable(key, type);
		}
		else if (scope.Parent() != null){
			changeType(scope.Parent(), key, type);
		}
	}

	public void AddFunction(String name, List<TypeExpression> inf){
		List<TypeExpression> temp = new LinkedList<>();
		for (int i = 0; i < inf.size(); i++)
		{
			temp.add(inf.get(i).Copy());
		}
		functions.put(name, temp);
	}

	public List<TypeExpression> GetFunction(String key)
	{
		if (functions.containsKey(key))
		{
			return functions.get(key);
		}
		else
		{
			return null;
		}
	}

	public boolean FuncPrevDeclared(String name){
		return functions.containsKey(name);
	}

	public Scope CurrentScope(){
		if (scopes.empty())
			return null;
		return scopes.peek();
	}
	
	public void OpenScope(){
		scopes.push(new Scope(CurrentScope()));
		this.currentScope = scopes.peek();
	}
	
	public void OpenScope(Scope containing){
		scopes.push(new Scope(containing));
	}

	public void CloseScope(){
		//TODO		Keeping old scopes for overview, update later
		currentScope.CloseScope();
		currentScope = currentScope.Parent();
		//scopes.pop();
	}

	public void AddVariable(String name, Type type){
		CurrentScope().AddVariable(name, type);
	}

	public boolean VarDeclaredInCurrentScope(String name){
		if (CurrentScope().Parent() == null){
			return VarGloballyDeclared(name);
		}
		return CurrentScope().VarDeclaredInScope(name);
	}

	private boolean VarGloballyDeclared(String key){
		if (scopes.empty())
			return false;
		return scopes.firstElement().VarDeclaredInScope(key) ||
				this.FigureDeclared(key) ||
				this.FuncPrevDeclared(key);
	}

	public boolean VarPrevDeclared(String key){
		return varPrevDeclared(key, CurrentScope());
	}

	private boolean varPrevDeclared(String key, Scope scope){
		if (scope.GetVariable(key) != null){
			return scope.VarDeclaredInScope(key);
		}
		else if (scope.Parent() != null){
			return varPrevDeclared(key, scope.Parent());
		}
		return false;
	}

	public Type GetVariable(String name){
		return getVariable(CurrentScope(), name);
	}

	private Type getVariable(Scope scope, String name){
		if (scope.GetVariable(name) != null){
			return scope.GetVariable(name);
		}
		else if (scope.Parent() != null){
			return getVariable(scope.Parent(), name);
		}

		return null;
	}

	@Override
	public String toString(){
		String st = "\nSymboltable:\n";

		st += "Functions: " + functions.toString() + "\n";

		if (!scopes.empty()){
			for (Scope s : scopes){
				st += s.toString() + "\n" + s.GetAllVariables().toString() + "\n";
			}
		}
		return st;
	}
}
