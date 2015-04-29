package compiler.interpret;

import java.util.ArrayList;
import java.util.List;

import compiler.interpret.Type;


public class TypeExpression
{		
	private List<Type> inputList = new ArrayList<Type>();
	private Type output;
	public void Output(Type output) 
	{
		this.output = output;
	}	
	
	public void Input(Type input)
	{
		this.inputList.add(input);
	}
	
	public List<Type> getInput()
	{
		return inputList;
	}
	
	public Type getOutput()
	{
		return output;
	}
	
	public TypeExpression(List<Type> Input, Type Output)
	{
		if(Input != null)
		{
			inputList = Input;
		}
		else
		{
			inputList.clear();
		}
		output = Output;
	}
	
	@Override public String toString() 
	{
		String result = "";

		for(int i = 0; i < inputList.size(); i++)
		{
			result += inputList.get(i) + " ";
		}
	    result += " --> ";
	    result += output.toString();
	    
		return result;
	}
}
	
	

