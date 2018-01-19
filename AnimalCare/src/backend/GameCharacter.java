package backend;
/**
*	Authors: Justin Fagan, Amir Hasan, Anis Tarafdar
*	Description: Character represents the animal that the player cares for.
*/
public class GameCharacter
{
	private String charName;
	private String charGreeting;
	private String charImgPath;
	private static String backgroundImgPath;
	private int charHealth;
	private int charHunger;
	private int charCleanliness;
	private int daysAlive;
	//this constructor is for making NEW CHARACTERS.
	public GameCharacter(String charName) 
	{
		this.charName=charName;
		for(int i=0;i<Utilities.names.length;i++)
		{
			if(charName.equals(Utilities.names[i]))
			{
				this.charGreeting=Utilities.greetings[i];
				break;
			}
		}
		this.charImgPath=charName+".png";
		this.charHealth=100;
		this.charHunger=100;
		this.charCleanliness=100;
		this.daysAlive=0;
	}
	//this constructor is for LOADING CHARACTERS.
	public GameCharacter(String charName, String charGreeting)
	{
		this.charName=charName;
		this.charGreeting=charGreeting;
		this.charImgPath=charName+".png";
		this.backgroundImgPath=charName+"BGImg"+".png";
	}
	public String getCharName()
	{
		return charName;
	}
	public void setCharName(String charName)
	{
		this.charName = charName;
	}
	public String getCharGreeting()
	{
		return charGreeting;
	}
	public void setCharGreeting(String charGreeting)
	{
		this.charGreeting = charGreeting;
	}

	public String getCharImgPath()
	{
		return charImgPath;
	}

	public void setCharImgPath(String charImgPath)
	{
		this.charImgPath = charImgPath;
	}
	public int getCharHealth()
	{
		return charHealth;
	}
	public void setCharHealth(int charHealth)
	{
		this.charHealth = charHealth;
	}
	public int getCharHunger()
	{
		return charHunger;
	}
	public void setCharHunger(int charHunger)
	{
		this.charHunger = charHunger;
	}
	public int getCharCleanliness()
	{
		return charCleanliness;
	}
	public void setCharCleanliness(int charCleanliness)
	{
		this.charCleanliness = charCleanliness;
	}
	public int getDaysAlive()
	{
		return daysAlive;
	}
	public void setDaysAlive(int daysAlive)
	{
		this.daysAlive = daysAlive;
	}
	public static String getImageBackground()
	{
		return backgroundImgPath;
	}
}