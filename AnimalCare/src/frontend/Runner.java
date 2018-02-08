package frontend;
import java.util.List;

import backend.GameCharacter;
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

public class Runner extends Application{

	static String fileName = "characters.csv";
	//static List<GameCharacter> pets = CSVTools.readCSV(fileName);
	//static int pos = pets.size() - 1;
	long timeStep;
	int daysAlive;
	
	static GameCharacter marthaChar = new GameCharacter("Martha");
    static GameCharacter amelieChar = new GameCharacter("Amelie");
    static GameCharacter mimiChar = new GameCharacter("Mimi");
    static GameCharacter nedChar = new GameCharacter("Ned");
    static GameCharacter holdenChar = new GameCharacter("Holden");

	public static void main(String args[]) {
		launch(args);
		
		//CSVTools.clearCSV(fileName);
		
		//Creates the CSV
		//List<GameCharacter> pets = CSVTools.readCSV(fileName);
		//CSVTools.writeCSV(fileName, pets);
	}
	
	public void start(Stage primaryStage) { 
		
			
		  
		   //Sets the title of the window
	       primaryStage.setTitle("Hello World!");
	      
	       /*
	       //Starts main music loop
	       URL resource = getClass().getResource("animalforest.mp3");
	       MediaPlayer titleScreen =new MediaPlayer(new Media(resource.toString()));
	       titleScreen.setOnEndOfMedia(new Runnable() {
	             public void run() {
	            	 titleScreen.seek(Duration.ZERO);
	             }
	         });
	       titleScreen.play();
	        */
	       int dimX = 2000;
	       int dimY = 2000;
	       
	       //Instances of the characters (Do not delete)
	       GameCharacter marthaChar = new GameCharacter("Martha");
	       GameCharacter amelieChar = new GameCharacter("Amelie");
	       GameCharacter mimiChar = new GameCharacter("Mimi");
	       GameCharacter nedChar = new GameCharacter("Ned");
	       GameCharacter holdenChar = new GameCharacter("Holden");
	       
	       //GameCharacter current = new GameCharacter("Martha");
	              
	       //Creates new button
	       Button martha = new Button("");
	       Button amelie = new Button("");
	       Button mimi = new Button("");
	       Button ned = new Button("");
	       Button holden = new Button("");
	       
	       //Creates text object
	       Text txt = new Text(0,10,"Please select a character");
	       Text days = new Text(0,10, "Days Alive: " + daysAlive);
	       days.setFill(Color.RED);
	       
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
	       
	       VBox daysAliveBox = new VBox(10);
	       daysAliveBox.getChildren().addAll(days);
	       
	       
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
      
	       primaryStage.setHeight(500);
	       primaryStage.setWidth(800);
	       
	       
	       
	       //Tells the button what to do when clicked
	       martha.setOnAction(e-> {
	    	   
	    	   //The on-click operation
	        	   txt.setText("You Have Selected Martha");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/martha.png\"); -fx-background-size: stretch;");
	        	   characterDisplay.setStyle("-fx-background-image: url(\"marthacharacterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, marthaChar.toString());
	        	   marthaChar.setSelected(true);
	           });
	       
	       amelie.setOnAction(e-> {
	    	   
	    	   //The on-click operation
	        	   txt.setText("You Have Selected Amelie");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/amelie.png\"); -fx-background-size: stretch;");

	        	   characterDisplay.setStyle("-fx-background-image: url(\"ameliecharacterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");

	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, amelieChar.toString());
	        	   amelieChar.setSelected(true);
	       });	       
	      
	       
	       mimi.setOnAction(e->{

	        	   txt.setText("You Have Selected Mimi");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/mimi.png\"); -fx-background-size: stretch;");

	        	   characterDisplay.setStyle("-fx-background-image: url(\"mimicharacterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");

	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, mimiChar.toString());
	        	   mimiChar.setSelected(true);
	       });
	       
	       ned.setOnAction(e-> {
	    	   
	    	   //The on-click operation

	        	   txt.setText("You Have Selected Ned");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/ned.png\"); -fx-background-size: stretch;");

	        	   characterDisplay.setStyle("-fx-background-image: url(\"nedcharacterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");

	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, nedChar.toString());
	        	   nedChar.setSelected(true);
	        	   
	       });
	       holden.setOnAction(e-> {
	    	   
	    	   //The on-click operation

	        	   txt.setText("You Have Selected Holden");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/holden.png\"); -fx-background-size: stretch;");
	        	   characterDisplay.setStyle("-fx-background-image: url(\"holdencharacterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, holdenChar.toString());
	        	   holdenChar.setSelected(true);
	       });

		feed.setOnAction(e -> {

			initAction(Actions.FEED, characterDisplay);
		});

		clean.setOnAction(e -> {

			initAction(Actions.CLEAN, characterDisplay);
		});

		medicate.setOnAction(e -> {

			initAction(Actions.MEDICATE, characterDisplay);
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
	       new AnimationTimer() {
	    	   public void handle(long now) {
	    		   if (now >timeStep) {
	    			   timeStep = now + 60000000000L;
	    			   daysAlive+=1;
	    			   days.setText("Days Alive: " + daysAlive);

	    		   }
	    	   }
	       }.start();
	}
	

	
	public static void initAction(Actions action, Pane characterDisplay) {
		Animals[] petCollection = Animals.values();
		switch (action) {
		case FEED:
			for (int i = 0; i < petCollection.length; i++) {
				switch (petCollection[i]) {
				case MARTHA:
					if (marthaChar.isSelected()) {
						characterDisplay.setStyle(
								"-fx-background-image: url(\"marthacharacterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
					}
					break;
				case AMELIE:
					if (amelieChar.isSelected()) {
						characterDisplay.setStyle(
								"-fx-background-image: url(\"ameliecharacterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
					}
					break;
				case MIMI:
					if (mimiChar.isSelected()) {
						characterDisplay.setStyle(
								"-fx-background-image: url(\"mimicharacterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
					}
					break;
				case NED:
					if (nedChar.isSelected())
						characterDisplay.setStyle(
								"-fx-background-image: url(\"nedcharacterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
					break;
				case HOLDEN:
					if (holdenChar.isSelected()) {
						characterDisplay.setStyle(
								"-fx-background-image: url(\"holdencharacterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
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
						characterDisplay.setStyle(
								"-fx-background-image: url(\"marthacharacterimages/shower.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
					}
					break;
				case AMELIE:
					if (amelieChar.isSelected()) {
						characterDisplay.setStyle(
								"-fx-background-image: url(\"ameliecharacterimages/shower.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
					}
					break;
				case MIMI:
					if (mimiChar.isSelected()) {
						characterDisplay.setStyle(
								"-fx-background-image: url(\"mimicharacterimages/shower.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
					}
					break;
				case NED:
					if (nedChar.isSelected()) {
						characterDisplay.setStyle(
								"-fx-background-image: url(\"nedcharacterimages/shower.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
					}
					break;
				case HOLDEN:
					if (holdenChar.isSelected()) {
						characterDisplay.setStyle(
								"-fx-background-image: url(\"holdencharacterimages/shower.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
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
						characterDisplay.setStyle(
								"-fx-background-image: url(\"marthacharacterimages/medicate.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
					}
					break;
				case AMELIE:
					if (amelieChar.isSelected()) {
						characterDisplay.setStyle(
								"-fx-background-image: url(\"ameliecharacterimages/medicate.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
					}
					break;
				case MIMI:
					if (mimiChar.isSelected()) {
						characterDisplay.setStyle(
								"-fx-background-image: url(\"mimicharacterimages/medicate.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
					}
					break;
				case NED:
					if (nedChar.isSelected()) {
						characterDisplay.setStyle(
								"-fx-background-image: url(\"nedcharacterimages/medicate.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
					}
					break;
				case HOLDEN:
					if (holdenChar.isSelected()) {
						characterDisplay.setStyle(
								"-fx-background-image: url(\"holdencharacterimages/medicate.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
					}
					break;
				}
			}
			break;
		}

	}
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
