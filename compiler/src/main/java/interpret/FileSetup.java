package compiler.interpret;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;


public class FileSetup {
	
	public static void Setup()
	{
		
		//delete the output file if it already exists
	    File fileTemp = new File("out.js");
	    if (fileTemp.exists()){
	       fileTemp.delete();
	    }
	}
}
