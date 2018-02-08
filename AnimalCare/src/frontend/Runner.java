package frontend;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

import backend.GameCharacter;
import backend.Utilities;
import javafx.scene.image.Image;
import javafx.scene.control.Label;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.scene.image.*;

public class Runner extends Application{

	static String fileName = "characters.csv";
	//static List<GameCharacter> pets = CSVTools.readCSV(fileName);
	//static int pos = pets.size() - 1;
	long timeStep;
	int daysAlive;
	boolean amelieSelected = false;
	boolean marthaSelected = false;
	boolean holdenSelected = false;
	boolean mimiSelected = false;
	boolean nedSelected = false;

//	
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
	        	   marthaSelected = true;
	           });
	       
	       amelie.setOnAction(e-> {
	    	   
	    	   //The on-click operation
	        	   txt.setText("You Have Selected Amelie");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/amelie.png\"); -fx-background-size: stretch;");

	        	   characterDisplay.setStyle("-fx-background-image: url(\"ameliecharacterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");

	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, amelieChar.toString());
	        	   amelieSelected = true;
	       });	       
	      
	       
	       mimi.setOnAction(e->{

	        	   txt.setText("You Have Selected Mimi");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/mimi.png\"); -fx-background-size: stretch;");

	        	   characterDisplay.setStyle("-fx-background-image: url(\"mimicharacterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");

	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, mimiChar.toString());
	        	   mimiSelected = true;
	       });
	       
	       ned.setOnAction(e-> {
	    	   
	    	   //The on-click operation

	        	   txt.setText("You Have Selected Ned");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/ned.png\"); -fx-background-size: stretch;");

	        	   characterDisplay.setStyle("-fx-background-image: url(\"nedcharacterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");

	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, nedChar.toString());
	        	   nedSelected = true;
	        	   
	       });
	       holden.setOnAction(e-> {
	    	   
	    	   //The on-click operation

	        	   txt.setText("You Have Selected Holden");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/holden.png\"); -fx-background-size: stretch;");
	        	   characterDisplay.setStyle("-fx-background-image: url(\"holdencharacterimages/main.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, holdenChar.toString());
	        	   holdenSelected = true;
	       });

	       feed.setOnAction(e->{
		    	  
	    	   	//Utilities.feed(setCharacter());
	    	   	//CSVTools.writeToCSV(fileName, setCharacter().toString());
	    	   	if(marthaSelected == true) {
	    	   		characterDisplay.setStyle(null);
	    	   		characterDisplay.setStyle("-fx-background-image: url(\"marthacharacterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	    	   	}
	    	   	if(holdenSelected == true) {
	    	   		characterDisplay.setStyle(null);
	    	   		characterDisplay.setStyle("-fx-background-image: url(\"holdencharacterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	    	   	};
	    	   	if(mimiSelected == true) {
	    	   		characterDisplay.setStyle(null);
	    	   		characterDisplay.setStyle("-fx-background-image: url(\"mimicharacterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	    	   	};
	    	   	if(amelieSelected == true) {
	    	   		characterDisplay.setStyle(null);
	    	   		characterDisplay.setStyle("-fx-background-image: url(\"ameliecharacterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	    	   	};
	    	   	if(nedSelected == true) {
	    	   		characterDisplay.setStyle(null);
	    	   		characterDisplay.setStyle("-fx-background-image: url(\"nedcharacterimages/eat.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	    	   	};
	    	   
	    	   	
	       });
	       
	       clean.setOnAction(e->{
		    	  
	    	   	//Utilities.clean(setCharacter());
	    	   	//CSVTools.writeToCSV(fileName, setCharacter().toString());
	    	   if(marthaSelected == true) {
	    	   		characterDisplay.setStyle(null);
	    	   		characterDisplay.setStyle("-fx-background-image: url(\"marthacharacterimages/shower.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	    	   	}
	    	   	if(holdenSelected == true) {
	    	   		characterDisplay.setStyle(null);
	    	   		characterDisplay.setStyle("-fx-background-image: url(\"holdencharacterimages/shower.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	    	   	};
	    	   	if(mimiSelected == true) {
	    	   		characterDisplay.setStyle(null);
	    	   		characterDisplay.setStyle("-fx-background-image: url(\"mimicharacterimages/shower.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	    	   	};
	    	   	if(amelieSelected == true) {
	    	   		characterDisplay.setStyle(null);
	    	   		characterDisplay.setStyle("-fx-background-image: url(\"ameliecharacterimages/shower.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	    	   	};
	    	   	if(nedSelected == true) {
	    	   		characterDisplay.setStyle(null);
	    	   		characterDisplay.setStyle("-fx-background-image: url(\"nedcharacterimages/shower.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	    	   	};
	       });
	       
	       medicate.setOnAction(e->{
		    	  
	    	   	//Utilities.med(setCharacter());
	    	   	//CSVTools.writeToCSV(fileName, setCharacter().toString());
	    	   if(marthaSelected == true) {
	    	   		characterDisplay.setStyle(null);
	    	   		characterDisplay.setStyle("-fx-background-image: url(\"marthacharacterimages/medicate.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	    	   	}
	    	   	if(holdenSelected == true) {
	    	   		characterDisplay.setStyle(null);
	    	   		characterDisplay.setStyle("-fx-background-image: url(\"holdencharacterimages/medicate.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	    	   	};
	    	   	if(mimiSelected == true) {
	    	   		characterDisplay.setStyle(null);
	    	   		characterDisplay.setStyle("-fx-background-image: url(\"mimicharacterimages/medicate.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	    	   	};
	    	   	if(amelieSelected == true) {
	    	   		characterDisplay.setStyle(null);
	    	   		characterDisplay.setStyle("-fx-background-image: url(\"ameliecharacterimages/medicate.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	    	   	};
	    	   	if(nedSelected == true) {
	    	   		characterDisplay.setStyle(null);
	    	   		characterDisplay.setStyle("-fx-background-image: url(\"nedcharacterimages/medicate.png\"); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-position: center;");
	    	   	};
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
	
	//sets the character to a variable so we don't need different buttons for each character
	public static GameCharacter setCharacter()
	{
		return null;
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
