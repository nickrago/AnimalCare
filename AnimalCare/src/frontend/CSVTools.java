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

public class CSVTools
{

	//create toString method in gameCharacter - back end
	public static void writeCSV(String file, List<GameCharacter> pets)
	{
		PrintWriter pw = null; 
		try
		{
			pw = new PrintWriter(new File(file));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		StringBuilder sb = new StringBuilder();
		
		//headlines
		sb.append("Character,Current Status,Days Alive,Hygiene Level,Hunger Level,Health Level\n");
		
		for (int row = 1; row < pets.size(); row ++)
		{
//			sb.append(pets.get(row).getCharName() + "," + pets.get(row).getIsAlive() + "," + pets.get(row).getDaysAlive() + "," + pets.get(row).getCharCleanliness() + "," + pets.get(row).getCharHunger() + "," + pets.get(row).getCharHealth());
			sb.append(pets.get(row).toString());
		}
		
		pw.write(sb.toString());
		
		//make sb go back to empty so it writes over the same line instead of going further
		pw.close();
	}
	public static void writeToCSV(String file, String info)
	{ 
		//writes a new line for each pet
		try (FileWriter fw = new FileWriter(Paths.get(file).toString(), true);) 
		{
			fw.append("\n"+info);
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
				String[] infoArr=info.split(",");
				boolean isAlive=false;
				if(infoArr[1].toUpperCase().equals("TRUE"))
				{
					isAlive=true;
				}
				GameCharacter newCharacter=new GameCharacter(infoArr[0],isAlive,Integer.parseInt(infoArr[2]),Integer.parseInt(infoArr[3]),Integer.parseInt(infoArr[4]),Integer.parseInt(infoArr[5]));
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
