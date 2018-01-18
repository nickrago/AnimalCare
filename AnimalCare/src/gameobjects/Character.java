package gameobjects;

public abstract class Character {
	private static String charName;
	private static String charGreeting;
	private static String charImgPath;
	private static int charHealth;
	private static int charHunger;
	private static int charCleanliness;
	private static String[] greetingArray;
	private static int daysAlive;
	
	public Character(String charName,String charGreeting, String charImagePath, int charHealth, int charHunger, int charCleanliness, String[] greetingArray, int daysAlive) 
	{
		Character.charName=charName;
		this.charGreeting=charGreeting;
		this.charImgPath=charImgPath;
		this.charHealth=charHealth;
		this.charHunger=charHunger;
		this.charCleanliness=charCleanliness;
	}

	public static String getCharName() {
		return charName;
	}

	public static void setCharName(String charName) {
		Character.charName = charName;
	}

	public static String getCharGreeting() {
		return charGreeting;
	}

	public static void setCharGreeting(String charGreeting) {
		Character.charGreeting = charGreeting;
	}

	public static String getCharImgPath() {
		return charImgPath;
	}

	public static void setCharImgPath(String charImgPath) {
		Character.charImgPath = charImgPath;
	}

	public static int getCharHealth() {
		return charHealth;
	}

	public static void setCharHealth(int charHealth) {
		Character.charHealth = charHealth;
	}

	public static int getCharHunger() {
		return charHunger;
	}

	public static void setCharHunger(int charHunger) {
		Character.charHunger = charHunger;
	}

	public static int getCharCleanliness() {
		return charCleanliness;
	}

	public static void setCharCleanliness(int charCleanliness) {
		Character.charCleanliness = charCleanliness;
	}

	public static String[] getGreetingArray() {
		return greetingArray;
	}

	public static void setGreetingArray(String[] greetingArray) {
		Character.greetingArray = greetingArray;
	}

	public static int getDaysAlive() {
		return daysAlive;
	}

	public static void setDaysAlive(int daysAlive) {
		Character.daysAlive = daysAlive;
	}

}
