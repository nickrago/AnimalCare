package backend;
/**
*	Authors: Justin Fagan, Amir Hasan, Anis Tarafdar
*	Description: GameCharacter represents the animal that the player cares for.
*/
public class GameCharacter
{
	private String charName;
	private String charGreeting;
	private int charHealth;
	private int charHunger;
	private int charCleanliness;
	private int daysAlive;
	private boolean isAlive;
	//this constructor is for making NEW CHARACTERS.
	public GameCharacter(String charName) 
	{
		this.charName=charName;
		int pos=0;
		for(int i=0;i<Utilities.names.length;i++)
		{
			if(charName.equals(Utilities.names[i]))
			{
				this.charGreeting=Utilities.greetings[i];
				pos=i;
				break;
			}
		}
		this.charHealth=Utilities.baseHealth[pos];
		this.charHunger=Utilities.baseHunger[pos];
		this.charCleanliness=Utilities.baseClean[pos];
		this.daysAlive=0;
		this.isAlive=true;
	}
	//this constructor is for LOADING CHARACTERS.
	public GameCharacter(String charName, boolean isAlive, int daysAlive, int charCleanliness, int charHunger, int charHealth)
	{
		this.charName=charName.toLowerCase();
		for(int i=0;i<Utilities.names.length;i++)
		{
			if(charName.equals(Utilities.names[i]))
			{
				this.charGreeting=Utilities.greetings[i];
				break;
			}
		}
		this.charCleanliness=charCleanliness;
		this.charHealth=charHealth;
		this.charHunger=charHunger;
		this.daysAlive=daysAlive;
		this.isAlive=isAlive;
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
	public int getCharHealth()
	{
		return charHealth;
	}
	public void changeHealth(int diff)
	{
		this.charHealth+=diff;
	}
	public int getCharHunger()
	{
		return charHunger;
	}
	public void changeHunger(int diff)
	{
		this.charHunger+=diff;
	}
	public int getCharCleanliness()
	{
		return charCleanliness;
	}
	public void changeCleanliness(int diff)
	{
		this.charCleanliness+=diff;
	}
	public int getDaysAlive()
	{
		return daysAlive;
	}
	public void setDaysAlive(int daysAlive)
	{
		this.daysAlive=daysAlive;
	}
	public boolean getIsAlive()
	{
		return isAlive;
	}
	public void changeIsAlive(boolean isAlive)
	{
		this.isAlive=isAlive;
	}
	public String toString()
	{ 
		return this.charName + "," + this.isAlive + "," + this.daysAlive + "," + this.charCleanliness + "," + this.charHunger + "," + this.charHealth;
	}
}