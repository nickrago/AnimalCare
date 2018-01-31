package frontend;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

import java.awt.Image;
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

	public static void main(String args[]) {
		launch(args);
	}
	
	public void start(Stage primaryStage) { 
		   //Sets the title of the window
	       primaryStage.setTitle("Hello World!");
	              
	       //Creates new button
	       Button martha = new Button();
	       Button amelie = new Button();
	       Button mimi = new Button();
	       Button ned = new Button();
	       Button holden = new Button();
	       
	       //Creates text object
	       Text txt = new Text(0,10,"Button Not Pressed");
	       
	       //Sets the text on the button
	       martha.setText("Choose Martha");
	       amelie.setText("Choose Amelie");
	       mimi.setText("Choose Mimi");
	       ned.setText("Choose Ned");
	       holden.setText("Choose Holden");
	      
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
	       
	       //Adds the photo
	      // Image image = new Image("mainScreen.png");
	       
	       
	       
	       
	       
	       //Tells the button what to do when clicked
	       martha.setOnAction(new EventHandler<ActionEvent>() {

	    	   //The on-click operation
	           @Override
	           public void handle(ActionEvent event) {
	        	   
	        	   txt.setText("You Have Selected Martha");
	           }
	       });
	       amelie.setOnAction(new EventHandler<ActionEvent>() {

	    	   //The on-click operation
	           @Override
	           public void handle(ActionEvent event) {
	        	   
	        	   txt.setText("You Have Selected Amelie!");
	           }
	       });
	       mimi.setOnAction(new EventHandler<ActionEvent>() {

	    	   //The on-click operation
	           @Override
	           public void handle(ActionEvent event) {
	        	   
	        	   txt.setText("You Have Selected Mimi!");
	           }
	       });
	       ned.setOnAction(new EventHandler<ActionEvent>() {

	    	   //The on-click operation
	           @Override
	           public void handle(ActionEvent event) {
	        	   
	        	   txt.setText("You Have Selected Ned");
	           }
	       });
	       holden.setOnAction(new EventHandler<ActionEvent>() {

	    	   //The on-click operation
	           @Override
	           public void handle(ActionEvent event) {
	        	   
	        	   txt.setText("You Have Selected Holden");
	           }
	       });


	       BorderPane gameScreen = new BorderPane();
	       gameScreen.setId("gamescreen");
	       
	       //Sets the GUI and adds button to the scene
	       Group g = new Group();
	       
	       g.getChildren().addAll(martha, amelie, mimi, ned, holden, txt);
	       Scene scene = new Scene(g);
	       
	       
	       //Shows
	       primaryStage.setScene(scene);
	       scene.getStylesheets().add("style.css");
	       primaryStage.show();
	   }

}
