package compiler.interpret;

import java.util.HashMap;
import java.util.Stack;

public class SymbolTable {
	private HashMap<String, Type> types = new HashMap<>();
	private HashMap<String, Type> globalVariables = new HashMap<>(); // TEMP, REVISE
	private Stack<Scope> scopes = new Stack<Scope>();
	
	public Scope CurrentScope(){
		if (scopes.isEmpty()){
			return null;
		}
		return scopes.peek();
	}
	
	public void OpenScope(){
		scopes.push(new Scope(CurrentScope()));
	}
	
	public void OpenScope(Scope containing){
		scopes.push(new Scope(containing));
	}

	public void CloseScope(){
		scopes.pop();
	}

	public void AddType(String name, Type type){
		types.put(name, type);
	}

	public void AddGlobalVar(String name, Type type){
		globalVariables.put(name, type);
	}

}
