package frontend;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.*;

import backend.GameCharacter;

import java.awt.Image;
import java.awt.Label;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.scene.image.*;

public class Runner extends Application{

	static String fileName = "characters.csv";
	long timeStep;

//	
	public static void main(String args[]) {
		launch(args);
		//Creates the CSV
		List<GameCharacter> pets = CSVTools.readCSV(fileName);
		CSVTools.writeCSV(fileName, pets);
	}
	
	public void start(Stage primaryStage) { 
		   //Sets the title of the window
	       primaryStage.setTitle("Hello World!");
	       
	       //Instances of the characters (Do not delete)
	       GameCharacter marthaChar = new GameCharacter("Martha");
	       GameCharacter amelieChar = new GameCharacter("Amelie");
	       GameCharacter mimiChar = new GameCharacter("Mimi");
	       GameCharacter nedChar = new GameCharacter("Ned");
	       GameCharacter holdenChar = new GameCharacter("Holden");
	              
	       //Creates new button
	       Button martha = new Button("");
	       Button amelie = new Button("");
	       Button mimi = new Button("");
	       Button ned = new Button("");
	       Button holden = new Button("");
	       
	       //Creates text object
	       Text txt = new Text(0,10,"Please select a character");
	      
	       //Character Scene
	       BorderPane characterLayout = new BorderPane();
	       VBox buttonContainer = new VBox(10);
	       Pane characterDisplay = new Pane();
	       Button feed = new Button("Feed");
	       Button clean = new Button("Clean");
	       Button medicate = new Button("Medicate");
	       Button back = new Button("Go Back");
	       
	       
	       buttonContainer.getChildren().addAll(feed, clean, medicate);
	       characterLayout.setCenter(characterDisplay);
	       characterLayout.setRight(buttonContainer);
	       characterLayout.getStylesheets().add("stylesheets/NurturePage.css");
	       Scene nurturePage = new Scene(characterLayout);
	       nurturePage.getStylesheets().add("stylesheets/NurturePage.css");
	       
	       //Sets the height and width of the button
	       martha.setPrefHeight(400);
	       martha.setPrefWidth(165);
	       
	       amelie.setPrefHeight(400);
	       amelie.setPrefWidth(165);
	       
	       mimi.setPrefHeight(400);
	       mimi.setPrefWidth(110);
	       
	       ned.setPrefHeight(400);
	       ned.setPrefWidth(200);
	       
	       holden.setPrefHeight(400);
	       holden.setPrefWidth(130);
	       
	       //Set the location of the button
	       /*
	       martha.setLayoutX(50);
	       martha.setLayoutY(50);
	       
	       amelie.setLayoutX(200);
	       amelie.setLayoutY(50);
	       
	       mimi.setLayoutX(350);
	       mimi.setLayoutY(50);
	       
	       ned.setLayoutX(500);
	       ned.setLayoutY(50);
	       
	       holden.setLayoutX(650);
	       holden.setLayoutY(50);
	       */
	       
	       
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
	           });
	       
	       amelie.setOnAction(e-> {
	    	   
	    	   //The on-click operation
	        	   txt.setText("You Have Selected Amelie");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/amelie.png\"); -fx-background-size: stretch;");
	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, amelieChar.toString());
	       });	       
	      
	       
	       mimi.setOnAction(e->{

	        	   txt.setText("You Have Selected Mimi");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/mimi.png\"); -fx-background-size: stretch;");
	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, mimiChar.toString());
	       });
	       
	       ned.setOnAction(e-> {
	    	   
	    	   //The on-click operation

	        	   txt.setText("You Have Selected Ned");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/ned.png\"); -fx-background-size: stretch;");
	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, nedChar.toString());
	        	   
	       });
	       holden.setOnAction(e-> {
	    	   
	    	   //The on-click operation

	        	   txt.setText("You Have Selected Holden");
	        	   characterLayout.setStyle("-fx-background-image: url(\"backgroundimages/holden.png\"); -fx-background-size: stretch;");
	        	   primaryStage.setScene(nurturePage);
	        	   CSVTools.writeToCSV(fileName, holdenChar.toString());
	       });

	       GridPane gameScreen = new GridPane();
	       gameScreen.setId("gamescreen");
	       
	       gameScreen.getStylesheets().add("stylesheets/style.css");
	       
	       //Sets the GUI and adds button to the scene
	       //gameScreen.getChildren().addAll(martha, amelie, mimi, ned, holden); //, txt);
	       gameScreen.add(martha,1,6);
	       gameScreen.add(amelie,2,6);
	       gameScreen.add(mimi,3,6);
	       gameScreen.add(ned,4,6);
	       gameScreen.add(holden,5,6);
	       Scene scene = new Scene(gameScreen);
	       scene.getStylesheets().add("stylesheets/style.css");
	       
	       //Shows
	       primaryStage.setScene(scene);
	       primaryStage.show();
	       
	       //Timer for setting daily events, Timer is functional but not doing anything yet, needs work
	       timeStep = System.nanoTime() + 180000000000L;
	       new AnimationTimer() {
	    	   public void handle(long now) {
	    		   if (now >timeStep) {
	    			   timeStep = now + 180000000000L;
	    			   //currentCharacter.daysAlive++ or whatever code
	    		   }
	    	   }
	       }.start();
	}
}