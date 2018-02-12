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
	public static void feed(GameCharacter c)
	{
		c.changeHunger(5);
	}
	public static void med(GameCharacter c)
	{
		c.changeHealth(5);
	}
	public static void clean(GameCharacter c)
	{
		c.changeCleanliness(5);
	}
}