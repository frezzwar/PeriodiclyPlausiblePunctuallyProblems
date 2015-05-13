package compiler.interpret;




import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;

import compiler.analysis.DepthFirstAdapter;
import compiler.node.*;
import org.sablecc.sablecc.node.AIdBasic;

public class ClassGenerator extends DepthFirstAdapter
{	
	public void write(String output)
	{
		try{
			PrintWriter out
			   = new PrintWriter(new BufferedWriter(new FileWriter("out.js", true)));
			out.print(output);
			//System.out.print(output);
			out.close();
		}catch(Exception e)
		{
			System.out.println("File write error");
		}
	}
	String code = "";
	
	public void inAVariableDeclaration(AVariableDeclaration node)
	{
		code = "var " + node.getIdentifier() + node.getAssign() + node.getVariables() + ";\n";
		write(code);
	}
	
	public void inAAssignExpr(AAssignExpr node)
	{
		code = node.getValue().toString() + node.getAssign() + node.getExpr() + ";\n";
		write(code);

		// TODO -- WHAT'S THIS FOR?
		if(!node.parent().parent().getClass().toString().equals("class compiler.node.ABody"))
		{
			// Do nothing
		}
		
	}
	
	public void inAIfstructureControlStatments(AIfstructureControlStatments node)
	{
		code = node.getIf().toString() + "( ";
		write(code);
	}

	@Override
	public void inAElseElsestructure(AElseElsestructure node){
		code = node.getElse().toString();
		write(code);
	}

	@Override
	public void inABody(ABody node){
		code = node.getCurlyL() + "\n";
		write(code);
	}

	@Override
	public void outABody(ABody node){
		code = node.getCurlyR() + "\n";
		write(code);
	}

	@Override
	public void inAFuncDecl(AFuncDecl node){
		code = "function " + node.getIdentifier() + node.getParL();
		write(code);
	}

	@Override
	public void outAFuncDecl(AFuncDecl node){
		code = "}";
		write(code);
	}

	@Override
	public void inAParams(AParams node){
		code = node.getIdentifier().toString();
		write(code);
	}

	@Override
	public void inAParamsTail(AParamsTail node){
		code = node.getComma().toString() + node.getIdentifier().toString();
		write(code);
	}

	@Override
	public void outAParams(AParams node){
		code = "){\n";
		write(code);
	}

	@Override
	public void inAForeachControlStatments(AForeachControlStatments node){
		code = "for ( " + node.getIdentifier() + "of " + node.getVarname() + ")";
		write(code);
	}

	@Override
	public void inAWhileControlStatments(AWhileControlStatments node){
		code = "while " + node.getParL();
		write(code);
	}

	// TODO FIX NESTED REPEATS, NOT WORKING PROPERLY
	private static String counter = "i";
	@Override
	public void inARepeatControlStatments(ARepeatControlStatments node){
		if (node.parent().getClass() == AControlStatementsDecl.class){
			AControlStatementsDecl temp = (AControlStatementsDecl)node.parent();
			if (temp.getControlStatments().getClass() == ARepeatControlStatments.class){
				counter += "i";
			}

		}
		code = "for (" + counter + " = 1; " + counter +" <= "
				+ node.getValue() + "; "+ counter + "++)";
		write(code);
	}


	@Override
	public void inABooleanExpr(ABooleanExpr node){
		if (node.parent().getClass() != AExprVariables.class){
			code = node.toString();
			write(code);
		}
	}

	@Override
	public void outABooleanExpr(ABooleanExpr node){
		if (node.parent().getClass() != AExprVariables.class){
			code = ")";
			write(code);
		}
	}
}
