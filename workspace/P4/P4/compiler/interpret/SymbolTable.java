package compiler.interpret;

import java.util.HashMap;
import java.util.Stack;

public class SymbolTable {
	private HashMap<String, Type> types = new HashMap<String, Type>();
	private Stack<Scope> scopes = new Stack<Scope>();
	
	public Scope CurrentScope(){
		if (scopes.isEmpty()){
			return null;
		}
		return scopes.pop();
	}
	
	public void OpenScope(){
		scopes.push(new Scope(CurrentScope()));
	}
	
	public void OpenScope(Scope containing){
		scopes.push(new Scope(containing));
	}

}
