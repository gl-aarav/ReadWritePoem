/* Aarav Goyal
 * 1/24/2025
 * ReadWritePoem.java
 * Reads a poem in (poem.txt), then writes the first word of each line to a file called output.txt.
 * First FileIO Program
 * Working on: Reading and writing to files compared to the terminal.
 */
 
 import java.util.Scanner;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.PrintWriter;
 import java.io.IOException;
 
 public class ReadWritePoem
 {
	 private Scanner input;
	 private PrintWriter output;
	 private String inFileName;
	 private String outFileName;
  
	public ReadWritePoem()
	{
		input = null;
		output = null;
		inFileName = new String("poem.txt");
		outFileName = new String("output.txt");
	}
 
	public static void main(String[] args)
	{
		ReadWritePoem rwp = new ReadWritePoem();
		rwp.readIt();
	}
 
	public void readIt()
	{
		openIt();
		makeIt();
		getWords();
	}
	
	//openIt uses a try-catch block to open a file
	public void openIt()
	{
		File inFile = new File(inFileName);
		try
		{
			input = new Scanner(inFile);
		}
		catch (FileNotFoundException e)
		{
			System.err.printf("\n\n\nERROR: Cannot find/open file %s.\n\n\n", inFileName);
			System.exit(1);
		}
	}
	
	public void makeIt()
	{
		File outFile = new File(outFileName);
		try
		{
			output = new PrintWriter(outFile);
		}
		catch (IOException e)
		{
			System.err.println("\n\n\nERROR: Cannot create " + outFileName + " file.\n\n\n");
			System.exit(2);
		}
	}
	
	public void getWords()
	{
		System.out.println("\n\n\n");
		String word = "";
		while(input.hasNext())
		{
				word = input.next();
				input.nextLine();
				output.println(word);
		}
		output.close();
	}
 }
