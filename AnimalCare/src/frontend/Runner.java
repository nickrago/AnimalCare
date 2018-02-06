package frontend;
import java.util.List;

import backend.GameCharacter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Runner extends Application{

	static String fileName = "characters.csv";

//	
	public static void main(String args[]) {
		launch(args);
		
		//CSVTools.clearCSV(fileName);
		
		//Creates the CSV
		List<GameCharacter> pets = CSVTools.readCSV(fileName);
		//CSVTools.writeCSV(fileName, pets);
	}
	
	public void start(Stage primaryStage) { 
		   //Sets the title of the window
	       primaryStage.setTitle("Hello World!");
	       int dimX = 1000;
	       int dimY = 1000;
	       
	       primaryStage.setHeight(1000);
	       primaryStage.setWidth(1500);
	       
	       //Instances of the characters (Do not delete)
	       GameCharacter marthaChar = new GameCharacter("Martha");
	       GameCharacter amelieChar = new GameCharacter("Amelie");
	       GameCharacter mimiChar = new GameCharacter("Mimi");
	       GameCharacter nedChar = new GameCharacter("Ned");
	       GameCharacter holdenChar = new GameCharacter("Holden");
	              
	       //Creates new button
	       Button martha = new Button("Martha");
	       Button amelie = new Button("Amelie");
	       Button mimi = new Button("Mimi");
	       Button ned = new Button("Ned");
	       Button holden = new Button("Holden");
	       
	       
	       //Creates text object
	       Text txt = new Text(0,10,"Please select a character");
	       	      
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
	       Button back = new Button("Go Back");
	       
	       buttonContainer.getChildren().addAll(feed, clean, medicate);
	       characterLayout.setTop(characterName);
	       characterLayout.setCenter(characterDisplay);
	       characterLayout.setRight(buttonContainer);
	       characterLayout.getStylesheets().add("stylesheets/NurturePage.css");
	       Scene nurturePage = new Scene(characterLayout, dimX, dimY);
	       nurturePage.getStylesheets().add("stylesheets/NurturePage.css");
	       
	       //Sets the height and width of the button
	       martha.setPrefHeight(100);
	       martha.setPrefWidth(200);
	       
	       amelie.setPrefHeight(100);
	       amelie.setPrefWidth(200);
	       
	       mimi.setPrefHeight(100);
	       mimi.setPrefWidth(200);
	       
	       ned.setPrefHeight(100);
	       ned.setPrefWidth(200);
	       
	       holden.setPrefHeight(100);
	       holden.setPrefWidth(200);
	       
	       
	      
	       
	       
	       
	     //Tells the button what to do when clicked
	       martha.setOnAction(e-> {
	    	   
	    	   //The on-click operation
	        	   txt.setText("You Have Selected Martha");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/martha.png\"); -fx-background-size: stretch;");
	        	   characterDisplay.setStyle("-fx-background-image: url(\"marthacharacterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	        	   //iv.setImage(marthaImg);
	        	   name.setText("Martha");
	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, marthaChar.toString());
	           });
	       
	       amelie.setOnAction(e-> {
	    	   
	    	   //The on-click operation
	        	   txt.setText("You Have Selected Amelie");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/amelie.png\"); -fx-background-size: stretch;");
	        	   characterDisplay.setStyle("-fx-background-image: url(\"ameliecharacterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, amelieChar.toString());
	       });	       
	      
	       
	       mimi.setOnAction(e->{

	        	   txt.setText("You Have Selected Mimi");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/mimi.png\"); -fx-background-size: stretch;");
	        	   characterDisplay.setStyle("-fx-background-image: url(\"mimicharacterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, mimiChar.toString());
	       });
	       
	       ned.setOnAction(e-> {
	    	   
	    	   //The on-click operation

	        	   txt.setText("You Have Selected Ned");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/ned.png\"); -fx-background-size: stretch;");
	        	   characterDisplay.setStyle("-fx-background-image: url(\"nedcharacterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, nedChar.toString());
	        	   
	       });
	       holden.setOnAction(e-> {
	    	   
	    	   //The on-click operation

	        	   txt.setText("You Have Selected Holden");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/holden.png\"); -fx-background-size: stretch;");
	        	   characterDisplay.setStyle("-fx-background-image: url(\"holdencharacterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, holdenChar.toString());
	       });

	       feed.setOnAction(e->{
	    	  
	    	   	//current.changeHunger(10);
	       });
	       
	       clean.setOnAction(e->{
		    	  
	    	   	//current.changeCleanliness(10);
	       });
	       
	       medicate.setOnAction(e->{
		    	  
	    	   	//current.changeHealth(10);
	    	   
	       });
       
	       AnchorPane gameScreen = new AnchorPane();
	       gameScreen.setId("gamescreen");
	       
	       gameScreen.getStylesheets().add("stylesheets/style.css");
	       
	       //Sets the GUI and adds button to the scene
	       //grid.getChildren().addAll(martha, amelie, mimi, ned, holden); //, txt);
	       HBox buttons = new HBox(50, martha, amelie, mimi, ned, holden);
	       buttons.setPadding(new Insets(0, 10, 10, 10));
	       
	       gameScreen.getChildren().addAll(buttons); // Add grid from Example 1-5
	       AnchorPane.setBottomAnchor(buttons, 10.0);
	       Scene scene = new Scene(gameScreen);
	       scene.getStylesheets().add("stylesheets/style.css");
	       
	       //Shows
	       primaryStage.setScene(scene);
	       primaryStage.show();
	       /*
	       //Timer for setting daily events, Timer is functional but not doing anything yet, needs work
	       long timeStep = System.nanoTime() + 180000000000L;
	       new AnimationTimer() {
	    	   public void handle(long now) {
	    		   if (now >timeStep) {
	    			   timeStep = now + 180000000000L;
	    			   currentCharacter.daysAlive++;
	    		   }
	    	   }
	       }.start(); 
	       */
	}
}
