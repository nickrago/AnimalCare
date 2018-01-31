package frontend;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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

	//create toString method in gameCharacter
	
	public static List<GameCharacter> pets = new ArrayList<>();
	
	public static void writeCSV(String file)
	{
		PrintWriter pw = null; 
		try
		{
			pw = new PrintWriter(new File(file));
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
			sb.append(pets.get(row).getCharName() + "," + pets.get(row).getDaysAlive() + "," + pets.get(row).getCharCleanliness() + "," + pets.get(row).getCharHunger() + "," + pets.get(row).getCharHealth());
			
			//pull getIsAlive from the backend
			// + "," + pets.get(row).getIsAlive()
		}
		
		pw.write(sb.toString());
		pw.close();
	}
	
	public static void writeToCSV(String file, String info)
	{
		try (FileWriter fw = new FileWriter(Paths.get(file).toString(), true);) 
		{
			for (String string : info.split(",")) 
			{
		 		fw.append(string);
		 		fw.append(',');
		 	}
		 	fw.append('\n');
		 	fw.flush();
		 	fw.close();
		} 
		catch (IOException e) 
		{
		 	e.printStackTrace();
		}
	}
	
	public static List<GameCharacter> readCSV(String file)
	{
		List<GameCharacter> pets = new ArrayList<>();
		
		Path path = Paths.get(file);
		try(BufferedReader br = Files.newBufferedReader(path,StandardCharsets.US_ASCII))
		{	
			String line = br.readLine();
			
			while (line != null)
			{
				String info = line;
				
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
