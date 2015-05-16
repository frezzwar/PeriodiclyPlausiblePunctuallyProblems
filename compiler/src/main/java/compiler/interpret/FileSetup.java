package compiler.interpret;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;


public class FileSetup {
	
	public static void Setup()
	{
		CreateHtmlFile();
		//delete the output file if it already exists
	    File fileTemp = new File("out.js");
	    if (fileTemp.exists()){
	       fileTemp.delete();
	    }
	}

	private static void CreateHtmlFile(){
		File htmlFile = new File("program.html");
		if (htmlFile.exists()){
			htmlFile.delete();
		}
		if (!htmlFile.exists()) {
			try {
				PrintWriter htmlWriter = new PrintWriter(new BufferedWriter(new FileWriter("program.html", true)));
				htmlWriter.println("<!DOCTYPE html>");
				htmlWriter.println("<html lang=\"en\">");
				htmlWriter.println("  <head>");
				htmlWriter.println("    <meta charset=\"utf-8\">");
				htmlWriter.println("    <title>Test Game</title>");
				htmlWriter.println("  </head>");
				htmlWriter.println("  <body>");
				htmlWriter.println("    <script src=\"out.js\"></script>");
				htmlWriter.println("  </body>");
				htmlWriter.println("</html>");
				htmlWriter.close();
			}
			catch (Exception e) {
				System.out.println("HTML file write error");
			}
		}
	}
}
