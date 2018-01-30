package frontend;
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

import backend.GameCharacter;

import java.util.ArrayList;

public class CSVTools {

	public static PrintWriter pw = null;
	public static List<GameCharacter> pets = new ArrayList<>();
	
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
		
		//headlines
		sb.append("Character,Current Status,Days Alive,Hygeine Level,Hunger Level,Health Level\n");
		
		for (int row = 1; row < pets.size(); row ++)
		{
			sb.append(pets.get(row).getCharName() + "," + pets.get(row).getIsAlive() + "," + pets.get(row).getDaysAlive() + "," + pets.get(row).getCharCleanliness() + "," + pets.get(row).getCharHunger() + "," + pets.get(row).getCharHealth());
		}
		
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
		pw.append("\n");
		
		//implement into runner to constantly push information into the csv
	}
	
	public static List<GameCharacter> readCSV(String file)
	{
		Path path = Paths.get(file);
		try(BufferedReader br = Files.newBufferedReader(path,StandardCharsets.US_ASCII))
		{	
			String line = br.readLine();
			
			while (line != null)
			{
				String info = line;
				//implement for each i in info, add to game character
				GameCharacter newCharacter = new GameCharacter(info);
				pets.add(newCharacter); 
				line = br.readLine();
				
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		 
		return pets;
	}
}
