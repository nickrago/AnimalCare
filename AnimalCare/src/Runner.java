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
	       Button btn = new Button();
	       
	       //Creates text object
	       Text txt = new Text(0,10,"Button Not Pressed");
	       
	       //Sets the text on the button
	       btn.setText("Press Me");
	      
	       //Sets the height and width of the button
	       btn.setPrefHeight(100);
	       btn.setPrefWidth(100);
	       
	       //Set the location of the button
	       btn.setLayoutX(50);
	       btn.setLayoutY(50);
	       
	       
	       primaryStage.setHeight(635);
	       primaryStage.setWidth(635);
      
	       //Tells the button what to do when clicked
	       btn.setOnAction(new EventHandler<ActionEvent>() {

	    	   //The on-click operation
	           @Override
	           public void handle(ActionEvent event) {
	        	   
	        	   txt.setText("Button Pressed");
	           }
	       });


		   
	       
	       //Sets the GUI and adds button to the scene
	       Group g = new Group();
	       
	       g.getChildren().add(btn);
	       g.getChildren().add(txt);
	       Scene scene = new Scene(g);
	       
	       //Shows
	       primaryStage.setScene(scene);
	       scene.getStylesheets().add("style.css");
	       primaryStage.show();
	   }

}
