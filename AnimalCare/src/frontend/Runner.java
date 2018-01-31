package frontend;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

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

public class Runner extends Application{
	private String charLabel = "";
	
	public static void main(String args[]) {
		launch(args);
	}
	
	public void start(Stage primaryStage) { 
		   //Sets the title of the window
	       primaryStage.setTitle("Hello World!");
	              
	       //Creates new button
	       Button martha = new Button("Choose Martha");
	       Button amelie = new Button("Choose Amelie");
	       Button mimi = new Button("Choose Mimi");
	       Button ned = new Button("Choose Ned");
	       Button holden = new Button("Choose Holden");
	       
	       //Creates text object
	       Text txt = new Text(0,10,"Please select a character");
	      
	       //Character Scene
	       BorderPane characterLayout = new BorderPane();
	       VBox buttonContainer = new VBox(10);
	       Button feed = new Button("Feed");
	       Button clean = new Button("Clean");
	       Button medicate = new Button("Medicate");
	       
	       VBox charName = new VBox();
	       Label name = new Label(charLabel);
	       buttonContainer.getChildren().addAll(feed, clean, medicate);
	       characterLayout.setRight(buttonContainer);
	       Scene nurturePage = new Scene(characterLayout);
	       nurturePage.getStylesheets().add("stylesheets/NuturePage.css");
	       
	       //Sets the height and width of the button
	       martha.setPrefHeight(50);
	       martha.setPrefWidth(100);
	       
	       amelie.setPrefHeight(50);
	       amelie.setPrefWidth(100);
	       
	       mimi.setPrefHeight(50);
	       mimi.setPrefWidth(100);
	       
	       ned.setPrefHeight(50);
	       ned.setPrefWidth(100);
	       
	       holden.setPrefHeight(50);
	       holden.setPrefWidth(100);
	       
	       //Set the location of the button
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
	       
	       
	       primaryStage.setHeight(500);
	       primaryStage.setWidth(850);
	       
	       
	       
	       //Tells the button what to do when clicked
	       martha.setOnAction(e-> {
	    	   
	    	   //The on-click operation
	        	   txt.setText("You Have Selected Martha");
	        	   primaryStage.setScene(nurturePage);
	       });
	       amelie.setOnAction(e-> {
	    	   
	    	   //The on-click operation
	        	   txt.setText("You Have Selected Amelie");
	        	   primaryStage.setScene(nurturePage);
	       });	       
	       
	       mimi.setOnAction(e-> {
	    	   
	    	   //The on-click operation
	        	   txt.setText("You Have Selected Martha");
	        	   primaryStage.setScene(nurturePage);
	       });
	       
	       ned.setOnAction(e-> {
	    	   
	    	   //The on-click operation
	        	   txt.setText("You Have Selected Martha");
	        	   primaryStage.setScene(nurturePage);
	       });
	       
	       holden.setOnAction(e-> {
	    	   
	    	   //The on-click operation
	        	   txt.setText("You Have Selected Martha");
	        	   primaryStage.setScene(nurturePage);
	       });

	       GridPane gameScreen = new GridPane();
	       gameScreen.setId("gamescreen");
	       gameScreen.getStylesheets().add("stylesheets/style.css");
	       
	       //Sets the GUI and adds button to the scene
	       gameScreen.getChildren().addAll(martha, amelie, mimi, ned, holden); //, txt);
	       Scene scene = new Scene(gameScreen);
	       scene.getStylesheets().add("stylesheets/style.css");
	       
	       //Shows
	       primaryStage.setScene(scene);
	       primaryStage.show();
	   }
	
	public static void changeScene() {
		
	}

}
