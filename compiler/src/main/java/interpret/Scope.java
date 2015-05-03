package compiler.interpret;

import compiler.node.*;

import java.util.HashMap;


public class Scope {
	private Scope containingScope;
	private HashMap<String, ALiteralValue> variables = new HashMap<String, ALiteralValue>();
		
	public Scope(Scope containing){
		this.containingScope = containing;
	}
	
	public void AddVariable(String str, ALiteralValue literal){
		variables.put(str, literal);
	}

}
