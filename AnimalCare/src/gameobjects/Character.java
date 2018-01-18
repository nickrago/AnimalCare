package gameobjects;

public abstract class Character {
	private String charName;
	private String charGreeting;
	private String charImgPath;
	private int charHealth;
	private int charHunger;
	private int charCleanliness;
	private String[] greetingArray;
	private int daysAlive;
	
	public Character(String charName,String charGreeting, String charImgPath, int charHealth, int charHunger, int charCleanliness, String[] greetingArray, int daysAlive) 
	{
		this.setCharName(charName);
		this.setCharGreeting(charGreeting);
		this.setCharImgPath(charImgPath);
		this.setCharHealth(charHealth);
		this.setCharHunger(charHunger);
		this.setCharCleanliness(charCleanliness);
		this.setGreetingArray(greetingArray);
		this.setDaysAlive(daysAlive);
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public String getCharGreeting() {
		return charGreeting;
	}

	public void setCharGreeting(String charGreeting) {
		this.charGreeting = charGreeting;
	}

	public String getCharImgPath() {
		return charImgPath;
	}

	public void setCharImgPath(String charImgPath) {
		this.charImgPath = charImgPath;
	}

	public int getCharHealth() {
		return charHealth;
	}

	public void setCharHealth(int charHealth) {
		this.charHealth = charHealth;
	}

	public int getCharHunger() {
		return charHunger;
	}

	public void setCharHunger(int charHunger) {
		this.charHunger = charHunger;
	}

	public int getCharCleanliness() {
		return charCleanliness;
	}

	public void setCharCleanliness(int charCleanliness) {
		this.charCleanliness = charCleanliness;
	}

	public String[] getGreetingArray() {
		return greetingArray;
	}

	public void setGreetingArray(String[] greetingArray) {
		this.greetingArray = greetingArray;
	}

	public int getDaysAlive() {
		return daysAlive;
	}

	public void setDaysAlive(int daysAlive) {
		this.daysAlive = daysAlive;
	}

	public static int decrementStat()
	{
		//What do I put in here??
		return 0;
	}

}
