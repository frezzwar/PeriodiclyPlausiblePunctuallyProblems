package compiler.interpret;




import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;

import compiler.analysis.DepthFirstAdapter;
import compiler.node.*;

public class ClassGenerator extends DepthFirstAdapter
{	
	public void write(String output)
	{
		try{
			PrintWriter out
			   = new PrintWriter(new BufferedWriter(new FileWriter("out.js", true)));
			out.println(output);
			System.out.print(output);
			out.close();
		}catch(Exception e)
		{
			
		}
	}
	String code = "";
	
	public void inAVariableDeclaration(AVariableDeclaration node)
	{
		code = "var " + node.getIdentifier() + node.getAssign() + node.getVariableTypes() + ";\n";
		//System.out.println(code);
		write(code);
	}
	
	public void inAAssignExpr(AAssignExpr node)
	{
		if(!node.parent().parent().getClass().toString().equals("class compiler.node.ABody"))
		{
			code = node.getOpor().toString() + node.getAssign() + node.getExpr() + ";\n";
			//System.out.println(code);
			write(code);
		}
		
	}
	
	public void inAIfstructureControlStatments(AIfstructureControlStatments node)
	{
		code = node.getIf().toString() + "(" + node.getExpr() + ")\n" + node.getBody().toString() +"\n";
		write(code);
		if(node.getElsestructure() != null)
		{
			code = node.getElsestructure().toString();
			write(code);
		}
	}
}
