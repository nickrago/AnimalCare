package backend;

import javafx.scene.media.*;
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

// Front End classes that have other classes that I need but don't know which is which
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

public class SoundEffect {
	
	private Media soundFile;
	private MediaPlayer soundPlayer;
	
	public SoundEffect(String filePath, boolean loop) {
		if(loop = true) {
			this.soundFile = new Media(filePath);
		    this.soundPlayer = new MediaPlayer(soundFile);
		    this.soundPlayer.setOnEndOfMedia(new Runnable() {
		        public void run() {
		        	soundPlayer.seek(Duration.ZERO);
		        }
		     });
		if(loop = false) {
			this.soundFile = new Media(filePath);
		    this.soundPlayer = new MediaPlayer(soundFile);
			}		    
		}
	}
	/*
	public SoundEffect(String filePath) {
		this.soundFile = new Media(filePath);
	    this.soundPlayer = new MediaPlayer(soundFile);
	}
	*/
	public void play(){
	    soundPlayer.play();
	}

	public void stop(){
	    soundPlayer.stop();
	}
	
	public static void main(String[] args) {
		String uriString = new File("C:\\Users\\BT_1N3_18\\git\\AnimalCare\\Say\\AnimalCare\\src\\sound\\news.mp3").toURI().toString();
		SoundEffect test = new SoundEffect(uriString, true);
		test.play();
	}
}

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

//String uriString = new File("C:\\Users\\BT_1N3_18\\git\\AnimalCare\\Say\\AnimalCare\\src\\sound\\animalforest.mp3").toURI().toString();
//SoundEffect test = new SoundEffect(uriString, true);
//test.play();