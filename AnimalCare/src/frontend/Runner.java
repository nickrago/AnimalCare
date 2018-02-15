package frontend;

/**
*	Authors: Nick Ragovski, Amir Hasan, Dana Ravvin, Anis Tarafdar, Justin Fagan
*	Description: Runner for Tamagachi application.
*/

import backend.GameCharacter;
import backend.SoundEffect;
import backend.Utilities;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.util.List;

public class Runner extends Application
{
	//fileName is the name of the csv file being used for saving/loading.
	static String fileName = "characters.csv";
	//dimX and dimY are the width and height, respectively, of each scene.
	static int dimX = 1000;
	static int dimY = 700;
	//The long variables used by each timer are initialized here.
	long timeDay;
	long timeDec;
	long timeSwap;
	//day, dec, and swap represent how long it takes to shift one day, to decrease stats, and to swap images, respectively.
	static long day=30000000000L;
	static long dec=5000000000L;
	static long swap=3000000000L;
	//maxHunger, maxHealth, and maxClean represent the current character's max stats.
	int maxHunger=0;
	int maxHealth=0;
	int maxClean=0;
	//currentChar is the character that the player selects.
	GameCharacter currentChar;
	//Creates a list of characters by reading the CSV file.
	static List<GameCharacter> pets = CSVTools.readCSV(fileName);
	public static void main(String args[])
	{
		launch(args);
	}
	public void start(Stage primaryStage)
	{ 
		//Sets the title of the window.
		primaryStage.setTitle("Animal Care: Game of the Year Edition");
		//Character buttons for main screen.
		Button martha = new Button("");
		Button amelie = new Button("");
		Button mimi = new Button("");
		Button ned = new Button("");
		Button holden = new Button("");
		Button back = new Button("Back");
		
		//Text objects
		Text txt = new Text(0,10,"Please select a character");
		Text days = new Text(0,10, "");
		Text hunger = new Text(0,20, "");
		Text cleanliness = new Text(0,30, "");
		Text health = new Text(0,40, "");
		days.setFill(Color.RED);
		hunger.setFill(Color.BLACK);
		cleanliness.setFill(Color.BLACK);
		health.setFill(Color.BLACK);
		
		//Character Scene
		BorderPane characterLayout = new BorderPane();
		VBox buttonContainer = new VBox(20);
		Label name = new Label("");   
		HBox characterName = new HBox(20);
		characterName.getChildren().add(name);
		characterName.setAlignment(Pos.CENTER);
		Pane characterDisplay = new Pane();
		Button feed = new Button("Feed");
		feed.setPrefSize(200, 100);
		Button clean = new Button("Clean");
		clean.setPrefSize(200, 100);
		Button medicate = new Button("Medicate");
		medicate.setPrefSize(200, 100);
		//Puts the stats into their own region of the screen.
		VBox daysAliveBox = new VBox(10);
		daysAliveBox.getChildren().addAll(back, days,hunger,cleanliness,health);
		daysAliveBox.setStyle("-fx-background-color: #FFFFFF;");
		
		buttonContainer.getChildren().addAll(feed, clean, medicate);
		characterLayout.setTop(characterName);
		characterLayout.setCenter(characterDisplay);
		characterLayout.setRight(buttonContainer);
		characterLayout.setLeft(daysAliveBox);
		characterLayout.getStylesheets().add("stylesheets/NurturePage.css");
		Scene nurturePage = new Scene(characterLayout, dimX, dimY);
		nurturePage.getStylesheets().add("stylesheets/NurturePage.css");
		
		//Sets the height and width of the buttons.
		martha.setPrefHeight(1000);
		martha.setPrefWidth(250);
		amelie.setPrefHeight(1000);
		amelie.setPrefWidth(165);
		mimi.setPrefHeight(1000);
		mimi.setPrefWidth(110);
		ned.setPrefHeight(1000);
		ned.setPrefWidth(200);
		holden.setPrefHeight(1000);
		holden.setPrefWidth(130);
		
		primaryStage.setHeight(dimY);
		primaryStage.setWidth(dimX);
		//Title screen music is initialized. It loops, too!
		String titleURI = new File("src/sound/animalforest.mp3").toURI().toString();
		SoundEffect titleMusic = new SoundEffect(titleURI, true);
		titleMusic.play();
		//swapTimer is the timer that swaps the character image back to the main image after a few seconds following pressing the feed, medicate, or clean buttons.
		AnimationTimer swapTimer = new AnimationTimer()
		{
			public void handle(long now)
			{
				if(now > timeSwap)
				{
					//cString is built so that the character's image is retrieved no matter which character it is. (So we don't need any extra files or 100 lines to do this.)
					String cString="-fx-background-image: url(\""+currentChar.getCharName().toLowerCase()+"characterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;";
					characterDisplay.setStyle(cString);
				}
			}
		};
		//dTimer is the timer that increments the day stat after a set amount of seconds.
		AnimationTimer dTimer= new AnimationTimer()
		{
			public void handle(long now)
			{
				if(now > timeDay)
				{
					timeDay=now + day;
					currentChar.changeDaysAlive(1);
					days.setText("Days Alive: " + currentChar.getDaysAlive());
					CSVTools.update(fileName, currentChar.toString());
				}
			}
		};
		//decTimer is the timer that decreases all the character's stats after a set amount of seconds.
		AnimationTimer decTimer = new AnimationTimer()
		{
			public void handle(long now)
			{
				if(now > timeDec)
				{
					currentChar.changeCleanliness(-10);
					currentChar.changeHealth(-10);
					currentChar.changeHunger(-10);
					hunger.setText("Hunger: " + currentChar.getCharHunger() + "/" + maxHunger);
					cleanliness.setText("Hygiene: " + currentChar.getCharCleanliness() + "/" + maxClean);
					health.setText("Health: " + currentChar.getCharHealth() + "/" + maxHealth);
					//check the character's status
					if(Utilities.checkPulse(currentChar))
					{
						//if still breathing, keep decreasing stats
						timeDec=System.nanoTime()+dec;
					}
					else
					{
						//if not, RIP, show game over screen.
						dTimer.stop();
						currentChar.changeIsAlive();
						CSVTools.update(fileName, currentChar.toString());
						GridPane deathScreen = new GridPane(); 
						deathScreen.setId("deathScreen");
						deathScreen.getStylesheets().add("stylesheets/DeathPage.css"); 
						Scene deathPage = new Scene(deathScreen, dimX, dimY);
						deathPage.getStylesheets().add("stylesheets/DeathPage.css");
						primaryStage.setScene(deathPage);
						this.stop();
					}
				}
			}
		};
		//Each character button has basically the same code in it, just using a different name each.
		martha.setOnAction(e->
		{
			currentChar=new GameCharacter("Martha");
			initCharacter(txt, characterDisplay, primaryStage, nurturePage, characterLayout, hunger, cleanliness, health, days, titleMusic);
			//Starts the timer for decreasing the stats of the character.
			timeDec=System.nanoTime()+dec;
			decTimer.start();
			//Starts timing the in-game days.
			timeDay = System.nanoTime() + day;
			dTimer.start();
		});
		amelie.setOnAction(e->
		{
			currentChar=new GameCharacter("Amelie");
			initCharacter(txt, characterDisplay, primaryStage, nurturePage, characterLayout, hunger, cleanliness, health, days, titleMusic);
			timeDec=System.nanoTime()+dec;
			decTimer.start();
			timeDay = System.nanoTime() + day;
			dTimer.start();
		});
		mimi.setOnAction(e->
		{
			currentChar=new GameCharacter("Mimi");
			initCharacter(txt, characterDisplay, primaryStage, nurturePage, characterLayout, hunger, cleanliness, health, days, titleMusic);
			timeDec=System.nanoTime()+dec;
			decTimer.start();
			timeDay = System.nanoTime() + day;
			dTimer.start();
		});
		ned.setOnAction(e->
		{
			currentChar=new GameCharacter("Ned");
			initCharacter(txt, characterDisplay, primaryStage, nurturePage, characterLayout, hunger, cleanliness, health, days, titleMusic);
			timeDec=System.nanoTime()+dec;
			decTimer.start();
			timeDay = System.nanoTime() + day;
			dTimer.start();
		});
		holden.setOnAction(e->
		{
			currentChar = new GameCharacter("Holden");
			initCharacter(txt, characterDisplay, primaryStage, nurturePage, characterLayout, hunger, cleanliness, health, days, titleMusic);
			timeDec=System.nanoTime()+dec;
			decTimer.start();
			timeDay = System.nanoTime() + day;
			dTimer.start();
		});
		//The three player actions directly below do the same thing for different stats.
		feed.setOnAction(e->
		{
			//Checks first if the animal can be fed without going over the character's max limit for the stat.
			if(currentChar.getCharHunger()<=maxHunger-Utilities.feed)
			{
				//The character's image for eating is displayed.
				String cString="-fx-background-image: url(\""+currentChar.getCharName().toLowerCase()+"characterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;";
				characterDisplay.setStyle(cString);
				//The timer for swapping the image back to the main one is started.
				timeSwap = System.nanoTime() + swap;
				swapTimer.start();
				//The character's stat for hunger is increased and the text field is updated.
				Utilities.feed(currentChar);
				hunger.setText("Hunger: " + currentChar.getCharHunger() + "/" + maxHunger);
			}
		});
		clean.setOnAction(e->
		{
			if(currentChar.getCharCleanliness()<=maxClean-Utilities.clean)
			{
				String cString="-fx-background-image: url(\""+currentChar.getCharName().toLowerCase()+"characterimages/shower.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;";
				characterDisplay.setStyle(cString);
				timeSwap = System.nanoTime() + swap;
				swapTimer.start();
				Utilities.clean(currentChar);
				cleanliness.setText("Hygiene: " + currentChar.getCharCleanliness() + "/" + maxClean);
			}
		});
		
		medicate.setOnAction(e->
		{
			if(currentChar.getCharHealth()<=maxHealth-Utilities.med)
			{
				String cString="-fx-background-image: url(\""+currentChar.getCharName().toLowerCase()+"characterimages/medicate.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;";
				characterDisplay.setStyle(cString);
				timeSwap = System.nanoTime() + swap;
				swapTimer.start();
				Utilities.med(currentChar);
				health.setText("Health: " + currentChar.getCharHealth() + "/" + maxHealth);
			}
		});
		
		
		GridPane gameScreen = new GridPane();
		gameScreen.setId("gamescreen");
		
		gameScreen.getStylesheets().add("stylesheets/style.css");
		
		//Sets the GUI and adds the character buttons to the main screen.
		gameScreen.add(martha,1,6);
		gameScreen.add(amelie,2,6);
		gameScreen.add(mimi,3,6);
		gameScreen.add(ned,4,6);
		gameScreen.add(holden,5,6);
		
		Scene scene = new Scene(gameScreen, dimX, dimY);
		//When the user goes back to the main screen, the current character is changed to null and the timers are stopped.
		back.setOnAction(e->
		{
			dTimer.stop();
			decTimer.stop();
			currentChar = null;
			primaryStage.setScene(scene);
			titleMusic.play();
		});
		scene.getStylesheets().add("stylesheets/style.css");
		
		back.setOnAction(e->{
			primaryStage.setScene(scene);
			currentChar = null;
		});
		//Starts the game on the main screen.
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	/**
	 * Initializes the game by taking in the front-end elements as parameters and updating them.
	 * 	@param txt
	 * 			Changes the text to tell the player which character they chose.
	 * @param characterDisplay
	 * 			Updates the character display based on the character chosen
	 * @param primaryStage
	 * 			the Stage of the program
	 * @param nurturePage
	 * 			the Scene of the character
	 * @param characterLayout
	 * 			the BorderPane of the game that holds buttons and the characters
	 * @param hunger 
	 * 			the hunger level of the character
	 * @param cleanliness
	 * 			the cleanliness level of the character
	 * @param health
	 * 			the health level of the character
	 * @param days
	 * 			the amount of days the character has been alive
	 * @param titleMusic
	 * 			the sound effect of the main screen
	 * 
	*/
	public void initCharacter(Text txt, Pane characterDisplay, Stage primaryStage, Scene nurturePage, BorderPane characterLayout, Text hunger, Text cleanliness, Text health, Text days, SoundEffect titleMusic)
	{
		//The background and main images are set according to the characters' names.
		String imagePath = "-fx-background-image: url(\""+currentChar.getCharName().toLowerCase()+"characterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;";
		String backgroundImagePath = "-fx-background-image: url(\""+"backgroundimages/"+currentChar.getCharName().toLowerCase()+".png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;";
		txt.setText("You Have Selected" + currentChar.getCharName());
		characterLayout.setStyle(backgroundImagePath);
		characterDisplay.setStyle(imagePath);
		primaryStage.setScene(nurturePage);
		//The max stats of each character are retrieved from the Utilities file.
		maxHunger = Utilities.baseHunger[currentChar.getPos()];
		maxClean = Utilities.baseClean[currentChar.getPos()];
		maxHealth = Utilities.baseHealth[currentChar.getPos()];
		CSVTools.writeToCSV(fileName, currentChar.toString(), pets);
		//Sets up the text fields for the stats.
		hunger.setText("Hunger: " + currentChar.getCharHunger() + "/" + maxHunger);
		cleanliness.setText("Hygiene: " + currentChar.getCharCleanliness() + "/" + maxClean);
		health.setText("Health: " + currentChar.getCharHealth() + "/" + maxHealth);
		days.setText("Days Alive: " + currentChar.getDaysAlive());
		//Stops the title screen music.
		titleMusic.stop();
	}
}
