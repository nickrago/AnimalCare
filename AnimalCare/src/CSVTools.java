import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class CSVTools {

	public static PrintWriter pw = null;
	public static List<Character> pets = new ArrayList<>();
	
	public static void writeCSV()
	{
		try
		{
			pw = new PrintWriter(new File("currentUser.csv"));
		}
		catch (FileNotFoundException e)
		{
			System.err.println(e);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("Character,Current Status,Days Alive,Hygeine Level,Hunger Level,Health Level\n");
		
		pw.write(sb.toString());
		//pw.close();
	}
	
	public static void writeToCSV(String info)
	{
		for (String s : info.split(","))
		{
			pw.append(s);
			pw.append(",");
		}
	}
	
	public static List<Character> readCSV(String file)
	{
		Path path = Paths.get(file);
		try(BufferedReader br = Files.newBufferedReader(path,StandardCharsets.US_ASCII))
		{	
			String line = br.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
