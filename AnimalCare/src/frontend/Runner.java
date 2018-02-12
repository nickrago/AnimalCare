package frontend;

import java.util.HashMap;

import backend.GameCharacter;
import backend.Utilities;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Runner extends Application
{
	static String fileName = "characters.csv";
	//static List<GameCharacter> pets = CSVTools.readCSV(fileName);
	//static int pos = pets.size() - 1;
	long timeStep;
	long timeDec;
	long timeThree;
	int daysAlive=0;
	int maxHunger=0;
	int maxHealth=0;
	int maxClean=0;
	
	/*static GameCharacter marthaChar = new GameCharacter("Martha");
    static GameCharacter amelieChar = new GameCharacter("Amelie");
    static GameCharacter mimiChar = new GameCharacter("Mimi");
    static GameCharacter nedChar = new GameCharacter("Ned");
    static GameCharacter holdenChar = new GameCharacter("Holden");
<<<<<<< HEAD
    

    static Image marthaImg = new Image("./marthacharacterimages/main.png", true);
    static Image amelieImg = new Image("./ameliecharacterimages/main.png", true);
    static Image mimiImg = new Image("./mimicharacterimages/main.png", true);
    static Image nedImg = new Image("./nedcharacterimages/main.png", true);
    static Image holdenImg = new Image("./holdencharacterimages/main.png", true);
    
    static HashMap<String,Image>characterImages = new HashMap<>(5);

	private static int maxHunger;
	private static int maxClean;
	private static int maxHealth;
	
	public static Text hunger;
	public static Text cleanliness;
	public static Text health;


	public static void main(String args[]) {
=======
	*/
	GameCharacter currentChar;
	public static void main(String args[])
	{
		launch(args);
		//CSVTools.clearCSV(fileName);
		//Creates the CSV
		//List<GameCharacter> pets = CSVTools.readCSV(fileName);
		//CSVTools.writeCSV(fileName, pets);
	}
	public void start(Stage primaryStage)
	{ 
		//Sets the title of the window
	    primaryStage.setTitle("Hello World!");
	    /*
	    //Starts main music loop
	    URL resource = getClass().getResource("animalforest.mp3");
	    MediaPlayer titleScreen =new MediaPlayer(new Media(resource.toString()));
	    titleScreen.setOnEndOfMedia(new Runnable()
	    {
	    	public void run()
	    	{
	        	titleScreen.seek(Duration.ZERO);
	        }
	    });
	    titleScreen.play();
	    */
	       int dimX = 1000;
	       int dimY = 700;
	       
	              
	       //Creates new button
	       Button martha = new Button("");
	       Button amelie = new Button("");
	       Button mimi = new Button("");
	       Button ned = new Button("");
	       Button holden = new Button("");
	       
	       //Creates text object
	       Text txt = new Text(0,10,"Please select a character");
	       Text days = new Text(0,10, "Days Alive: " + daysAlive);
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
	       ImageView characterDisplay = new ImageView();
	       Button feed = new Button("Feed");
	       feed.setPrefSize(200, 100);
	       Button clean = new Button("Clean");
	       clean.setPrefSize(200, 100);
	       Button medicate = new Button("Medicate");
	       medicate.setPrefSize(200, 100);
	       
	       VBox daysAliveBox = new VBox(10);
	       daysAliveBox.getChildren().addAll(days,hunger,cleanliness,health);
	       
	       
	       buttonContainer.getChildren().addAll(feed, clean, medicate);
	       characterLayout.setTop(characterName);
	       characterLayout.setCenter(characterDisplay);
	       characterLayout.setRight(buttonContainer);
	       characterLayout.setLeft(daysAliveBox);
	       characterLayout.getStylesheets().add("stylesheets/NurturePage.css");
	       Scene nurturePage = new Scene(characterLayout, dimX, dimY);
	       nurturePage.getStylesheets().add("stylesheets/NurturePage.css");
	       
	       //Sets the height and width of the button
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
	       
	       //timer for swapping images
           

           /*AnimationTimer feedTimer = new AnimationTimer() {
               public void handle(long now) {
                       if(now > timeThree) {
                           if(marthaChar.isSelected()) {
                                characterDisplay.setImage(marthaImg);
                            }
                            if(holdenChar.isSelected()) {
                            	characterDisplay.setImage(holdenImg);
                            };
                            if(mimiChar.isSelected()) {
                            	characterDisplay.setImage(mimiImg);
                            };
                            if(amelieChar.isSelected()) {
                            	characterDisplay.setImage(amelieImg);
                            };
                            if(nedChar.isSelected()) {
                            	characterDisplay.setImage(nedImg);
                            };
                            this.stop();
                            */
           AnimationTimer feedTimer = new AnimationTimer()
           {
        	   public void handle(long now)
               {
            	   if(now > timeThree)
                   {
            		   String cString="-fx-background-image: url(\""+currentChar.getCharName().toLowerCase()+"characterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;";
            		   characterDisplay.setStyle(cString);
                   }
           }};
           
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
		        	   timeDec=System.nanoTime()+15000000000L;
                   }
           }};
	       
	       //Tells the button what to do when clicked
	       martha.setOnAction(e-> {
	    	   
	    	   //The on-click operation
	        	   txt.setText("You Have Selected Martha");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/martha.png\"); -fx-background-size: stretch; -fx-background-repeat: no-repeat; -fx-background-position: center;");
	        	   //characterDisplay.setImage(marthaImg);
	        	   primaryStage.setScene(nurturePage);
	        	   currentChar=new GameCharacter("Martha");
	        	   maxHunger = Utilities.baseHunger[currentChar.getPos()];
	        	   maxClean = Utilities.baseClean[currentChar.getPos()];
	        	   maxHealth = Utilities.baseHealth[currentChar.getPos()];
	        	   
	        	   CSVTools.writeToCSV(fileName, currentChar.toString());
	        	  
	        	   
		        	   hunger.setText("Hunger: " + currentChar.getCharHunger() + "/" + maxHunger);
		        	   cleanliness.setText("Hygiene: " + currentChar.getCharCleanliness() + "/" + maxClean);
		        	   health.setText("Health: " + currentChar.getCharHealth() + "/" + maxHealth);
		        	   timeDec=System.nanoTime()+15000000000L;
		        	   decTimer.start();
	           });
	       
	       amelie.setOnAction(e-> {
	    	   
	    	   //The on-click operation
	        	   txt.setText("You Have Selected Amelie");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/amelie.png\"); -fx-background-size: stretch;");

	        	   //characterDisplay.setImage(amelieImg);

	        	   primaryStage.setScene(nurturePage);
	        	   currentChar=new GameCharacter("Amelie");
	        	   maxHunger = Utilities.baseHunger[currentChar.getPos()];
	        	   maxClean = Utilities.baseClean[currentChar.getPos()];
	        	   maxHealth = Utilities.baseHealth[currentChar.getPos()];

	        	   CSVTools.writeToCSV(fileName, currentChar.toString());
	        	
	        	   
	        	   hunger.setText("Hunger: " + currentChar.getCharHunger() + "/" + maxHunger);
	        	   cleanliness.setText("Hygiene: " + currentChar.getCharCleanliness() + "/" + maxClean);
	        	   health.setText("Health: " + currentChar.getCharHealth() + "/" + maxHealth);
	        	   timeDec=System.nanoTime()+15000000000L;
	        	   decTimer.start();
	       });	       
	      
	       mimi.setOnAction(e->{

	        	   txt.setText("You Have Selected Mimi");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/mimi.png\"); -fx-background-size: stretch;");

	        	   //characterDisplay.setImage(mimiImg);

	        	   primaryStage.setScene(nurturePage);
	        	   currentChar=new GameCharacter("Mimi");
	        	   maxHunger = Utilities.baseHunger[currentChar.getPos()];
	        	   maxClean = Utilities.baseClean[currentChar.getPos()];
	        	   maxHealth = Utilities.baseHealth[currentChar.getPos()];
	        	   
	        	   CSVTools.writeToCSV(fileName, currentChar.toString());
	        	  
	        	   
	        	   hunger.setText("Hunger: " + currentChar.getCharHunger() + "/" + maxHunger);
	        	   cleanliness.setText("Hygiene: " + currentChar.getCharCleanliness() + "/" + maxClean);
	        	   health.setText("Health: " + currentChar.getCharHealth() + "/" + maxHealth);
	        	   timeDec=System.nanoTime()+15000000000L;
	        	   decTimer.start();
	       });
	       
	       ned.setOnAction(e-> {
	    	   
	    	   //The on-click operation

	        	   txt.setText("You Have Selected Ned");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/ned.png\"); -fx-background-size: stretch;");

	        	   //characterDisplay.setImage(nedImg);

	        	   primaryStage.setScene(nurturePage);
	        	   currentChar=new GameCharacter("Ned");
	        	   maxHunger = Utilities.baseHunger[currentChar.getPos()];
	        	   maxClean = Utilities.baseClean[currentChar.getPos()];
	        	   maxHealth = Utilities.baseHealth[currentChar.getPos()];
	        	   
	        	   CSVTools.writeToCSV(fileName, currentChar.toString());
	        	  
	        	   
	        	   hunger.setText("Hunger: " + currentChar.getCharHunger() + "/" + maxHunger);
	        	   cleanliness.setText("Hygiene: " + currentChar.getCharCleanliness() + "/" + maxClean);
	        	   health.setText("Health: " + currentChar.getCharHealth() + "/" + maxHealth);
	        	   timeDec=System.nanoTime()+15000000000L;
	        	   decTimer.start();
	       });
	       holden.setOnAction(e-> {
	    	   
	    	   //The on-click operation

	        	   txt.setText("You Have Selected Holden");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/holden.png\"); -fx-background-size: stretch;");
	        	   
	        	   //characterDisplay.setImage(holdenImg);
	        	   
	        	   primaryStage.setScene(nurturePage);
	        	   currentChar=new GameCharacter("Holden");
	        	   maxHunger = Utilities.baseHunger[currentChar.getPos()];
	        	   maxClean = Utilities.baseClean[currentChar.getPos()];
	        	   maxHealth = Utilities.baseHealth[currentChar.getPos()];
	        	   
	        	   CSVTools.writeToCSV(fileName, currentChar.toString());
	        	   
	        	   
	        	   hunger.setText("Hunger: " + currentChar.getCharHunger() + "/" + maxHunger);
	        	   cleanliness.setText("Hygiene: " + currentChar.getCharCleanliness() + "/" + maxClean);
	        	   health.setText("Health: " + currentChar.getCharHealth() + "/" + maxHealth);
	        	   timeDec=System.nanoTime()+15000000000L;
	        	   decTimer.start();
	       });

		feed.setOnAction(e -> {
			if(currentChar.getCharHunger()<=maxHunger-5)
			{
				String cString="-fx-background-image: url(\""+currentChar.getCharName().toLowerCase()+"characterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;";
		 		   characterDisplay.setStyle(cString);
		 		  timeThree = System.nanoTime() + 3000000000L;
		          feedTimer.start();
		          Utilities.feed(currentChar);
		          hunger.setText("Hunger: " + currentChar.getCharHunger() + "/" + maxHunger);
			}
		});

		clean.setOnAction(e -> {
			if(currentChar.getCharCleanliness()<=maxClean-5)
			{
				String cString="-fx-background-image: url(\""+currentChar.getCharName().toLowerCase()+"characterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;";
		 		   characterDisplay.setStyle(cString);
		 		  timeThree = System.nanoTime() + 3000000000L;
		          feedTimer.start();
		          Utilities.feed(currentChar);
		          hunger.setText("Hunger: " + currentChar.getCharHunger() + "/" + maxHunger);
			}
		});

		medicate.setOnAction(e -> {
			if(currentChar.getCharHealth()<=maxHealth-5)
			{
				String cString="-fx-background-image: url(\""+currentChar.getCharName().toLowerCase()+"characterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;";
		 		   characterDisplay.setStyle(cString);
		 		  timeThree = System.nanoTime() + 3000000000L;
		          feedTimer.start();
		          Utilities.feed(currentChar);
		          hunger.setText("Hunger: " + currentChar.getCharHunger() + "/" + maxHunger);
			}
		});
       
	       GridPane gameScreen = new GridPane();
	       gameScreen.setId("gamescreen");
	       
	       gameScreen.getStylesheets().add("stylesheets/style.css");
	       
	       //Sets the GUI and adds button to the scene

	       gameScreen.add(martha,1,6);
	       gameScreen.add(amelie,2,6);
	       gameScreen.add(mimi,3,6);
	       gameScreen.add(ned,4,6);
	       gameScreen.add(holden,5,6);

	       Scene scene = new Scene(gameScreen, dimX, dimY);

	       scene.getStylesheets().add("stylesheets/style.css");
	       
	       //Shows
	       primaryStage.setScene(scene);
	       primaryStage.show();
	       

	       //Timer for setting daily events : 60000000000L
	       timeStep = System.nanoTime() + 60000000000L;
	       new AnimationTimer()
	       {
	    	   public void handle(long now)
	    	   {
	    		   if (now >timeStep)
	    		   {
	    			   timeStep = now + 60000000000L;
	    			   daysAlive+=1;
	    			   days.setText("Days Alive: " + daysAlive);
	    		   }
	    	   }
	       }.start();
	       
	       //when program ends
	       /*if (marthaChar.getIsAlive())
	       {
	    	   marthaChar.changeIsAlive(false);
	       }
	       if (amelieChar.getIsAlive())
	       {
	    	   amelieChar.changeIsAlive(false);
	       }
	       if (mimiChar.getIsAlive())
	       {
	    	   mimiChar.changeIsAlive(false);
	       }
	       if (nedChar.getIsAlive())
	       {
	    	   nedChar.changeIsAlive(false); 
	       }
	       if (holdenChar.getIsAlive())
	       {
	    	   holdenChar.changeIsAlive(false);
	       }*/
	}
	

	/**
	 * Changes the character display based on the activity and the character currently selected.
	 * @param action
	 * 			An action from the Enum "Actions" 
	 * @param characterDisplay
	 * 			the display to be manipulated in displaying the Game Character
	 * @return void
	 * 
	 * 
	 */ 
	
	/*public static void initAction(Actions action, HashMap<String, Image> characterImages) {
		Animals[] petCollection = Animals.values();
		switch (action) {
		case FEED:
			for (int i = 0; i < petCollection.length; i++) {
				switch (petCollection[i]) {
				case MARTHA:
					if (marthaChar.isSelected()) {
						characterImage = new Image("./marthacharacterimages/main.png", true);
						marthaChar.changeHunger(diff);
					}
					break;
				case AMELIE:
					if (amelieChar.isSelected()) {
						characterImage.setStyle(
								"-fx-background-image: url(\"ameliecharacterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
						amelieChar.changeHunger(diff);
					}
					break;
				case MIMI:
					if (mimiChar.isSelected()) {
						characterImage.setStyle(
								"-fx-background-image: url(\"mimicharacterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
						mimiChar.changeHunger(diff);
					}
					break;
				case NED:
					if (nedChar.isSelected())
						characterImage.setStyle(
								"-fx-background-image: url(\"nedcharacterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
						nedChar.changeHunger(diff);
					break;
				case HOLDEN:
					if (holdenChar.isSelected()) {
						characterImage.setStyle(
								"-fx-background-image: url(\"holdencharacterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
						holdenChar.changeHunger(diff);
						hunger.setText("Hunger: " + holdenChar.getCharHunger() + "/" + maxHunger);
					}
					break;
				}
			}
			break;

		case CLEAN:
			for (int i = 0; i < petCollection.length; i++) {
				switch (petCollection[i]) {
				case MARTHA:
					if (marthaChar.isSelected()) {
						characterImage.setStyle(
								"-fx-background-image: url(\"marthacharacterimages/shower.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
						marthaChar.changeCleanliness(diff);
					}
					break;
				case AMELIE:
					if (amelieChar.isSelected()) {
						characterImage.setStyle(
								"-fx-background-image: url(\"ameliecharacterimages/shower.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
						amelieChar.changeCleanliness(diff);
					}
					break;
				case MIMI:
					if (mimiChar.isSelected()) {
						characterImage.setStyle(
								"-fx-background-image: url(\"mimicharacterimages/shower.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
						mimiChar.changeCleanliness(diff);
					}
					break;
				case NED:
					if (nedChar.isSelected()) {
						characterImage.setStyle(
								"-fx-background-image: url(\"nedcharacterimages/shower.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
						nedChar.changeCleanliness(diff);
					}
					break;
				case HOLDEN:
					if (holdenChar.isSelected()) {
						characterImage.setStyle(
								"-fx-background-image: url(\"holdencharacterimages/shower.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
						holdenChar.changeCleanliness(diff);
					}
					break;
				}
			}
			break;
			
			

		case MEDICATE:
			for (int i = 0; i < petCollection.length; i++) {
				switch (petCollection[i]) {
				case MARTHA:
					if (marthaChar.isSelected()) {
						characterImage.setStyle(
								"-fx-background-image: url(\"marthacharacterimages/medicate.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
						marthaChar.changeHealth(diff);
					}
					break;
				case AMELIE:
					if (amelieChar.isSelected()) {
						characterImage.setStyle(
								"-fx-background-image: url(\"ameliecharacterimages/medicate.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
						amelieChar.changeHealth(diff);
					}
					break;
				case MIMI:
					if (mimiChar.isSelected()) {
						characterImage.setStyle(
								"-fx-background-image: url(\"mimicharacterimages/medicate.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
						mimiChar.changeHealth(diff);
					}
					break;
				case NED:
					if (nedChar.isSelected()) {
						characterImage.setStyle(
								"-fx-background-image: url(\"nedcharacterimages/medicate.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
						nedChar.changeHealth(diff);
					}
					break;
				case HOLDEN:
					if (holdenChar.isSelected()) {
						characterImage.setStyle(
								"-fx-background-image: url(\"holdencharacterimages/medicate.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
						holdenChar.changeHealth(diff);
					}
					break;
				}
			}
			break;
		}

	}*/
}
/*
URL resource = getClass().getResource("abcd.mp3");
MediaPlayer a =new MediaPlayer(new Media(resource.toString()));
a.setOnEndOfMedia(new Runnable() {
      public void run() {
        a.seek(Duration.ZERO);
      }
  });
 a.play();
*/
