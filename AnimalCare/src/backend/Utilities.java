package backend;
/**
*	Authors: Justin Fagan, Amir Hasan, Anis Tarafdar
*	Description: Functions & objects pertaining to the character class. The functions will be used directly by the front end.
*/
public class Utilities
{
	public static String[] greetings= {"","","","",""};
	public static String[] names= {"","","","",""};
	
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
