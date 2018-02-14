package frontend;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
	//test code
	/*public static void main(String[] args)
	{
		GameCharacter c=new GameCharacter("Holden");
		writeToCSV("characters.csv",c.toString());
		List<GameCharacter> list=readCSV("characters.csv");
		for(GameCharacter x:list)
		{
			System.out.println(x.getCharName());
			System.out.println(x.getIsAlive());
			System.out.println(x.getDaysAlive());
			System.out.println(x.getCharCleanliness());
			System.out.println(x.getCharHunger());
			System.out.println(x.getCharHealth());
		}
	}*/
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
		StringBuilder sb=new StringBuilder();
		//headlines
		sb.append("Character,Current Status,Days Alive,Hygiene Level,Hunger Level,Health Level");
		for (int row=1; row<pets.size(); row++)
		{
			sb.append(pets.get(row).toString());
		}
		pw.write(sb.toString());
		//make sb go back to empty so it writes over the same line instead of going further
		pw.close();
	}
	/**
	* Writes a new line to the CSV file.
	* @param file - The name/path of the csv file.
	* @param info - The comma-separated information of one character retrieved by calling the toString() function on it.
	*/
	public static void writeToCSV(String file, String info, List<GameCharacter> pets)
	{
		//Creates a File object according to the filename specified in the file parameter.
		File csv=new File(file);
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)))
		{
			//Adds the information of the character on a new line.
			bw.append("\n"+info);
			bw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		StringBuilder sb=new StringBuilder();
		for (int row=1; row<pets.size(); row++)
		{
			sb.append(pets.get(row).toString());
		}
	}
	/**
	* Retrieves all characters from the csv data file.
	* @param file - The name/path of the csv file.
	* @return A List containing all characters listed in the csv file.
	*/
	public static List<GameCharacter> readCSV(String file)
	{
		List<GameCharacter> pets=new ArrayList<>();
		Path path = Paths.get(file);
		try(BufferedReader br=Files.newBufferedReader(path,StandardCharsets.US_ASCII))
		{
			String line=br.readLine();
			line=br.readLine();
			while (line!=null)
			{
				String info=line;
				String[] infoArr=info.split(",");
				boolean isAlive=false;
				if(infoArr[1].toUpperCase().equals("TRUE"))
				{
					isAlive=true;
				}
				GameCharacter newCharacter=new GameCharacter(infoArr[0],isAlive,Integer.parseInt(infoArr[2]),Integer.parseInt(infoArr[3]),Integer.parseInt(infoArr[4]),Integer.parseInt(infoArr[5]));
				pets.add(newCharacter); 
				line=br.readLine();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return pets;
	}
	/**
	* Clears the CSV file - used for testing.
	* @param file - The name/path of the csv file.
	*/
	public static void clearCSV(String file)
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
		pw.close();
	}
	/**
	* Writes a new line to the CSV file.
	* @param file - The name/path of the csv file.
	* @param info - The comma-separated information of one character retrieved by calling the toString() function on it.
	*/
	public static void update(String file, String info)
	{
		List<GameCharacter> pets = readCSV(file);
		int row = pets.size();
		pets.remove(pets.get(row-1));
		writeToCSV(file, info, pets);
	}
}
