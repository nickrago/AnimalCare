package backend;
/**
*	Authors: Justin Fagan, Amir Hasan, Anis Tarafdar
*	Description: Functions & objects pertaining to the character class. The functions will be used directly by the front end.
*/
public class Utilities
{
	public static String[] greetings= {"Bonjour! Comment tu vas?","Hi! How was your day?","Howdy, sure is a thing being old!","Hey!!! What's up?!!","What's going on, dude?"};
	public static String[] names= {"Amelie","Martha","Holden","Mimi","Ned"};
	public static int[] baseHealth= {100, 110, 80, 100, 90};
	public static int[] baseHunger= {120, 100, 110, 100, 80};
	public static int[] baseClean= {100, 100, 80, 90, 70};
	public void feed(GameCharacter c)
	{
		int c1=c.getCharHunger();
		c1+=10;
		c.setCharHunger(c1);
	}
	public void med(GameCharacter c)
	{
		int c1=c.getCharHealth();
		c1+=10;
		c.setCharHealth(c1);
	}
	public void clean(GameCharacter c)
	{
		int c1=c.getCharCleanliness();
		c1+=10;
		c.setCharCleanliness(c1);
	}
}