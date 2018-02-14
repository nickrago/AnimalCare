package backend;

import javafx.scene.media.*;
import javax.sound.sampled.Clip;
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
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javafx.util.Duration;


public class SoundEffect{
	
	private Media soundFile;
	public MediaPlayer soundPlayer;
	private Clip soundFX;
	
	public SoundEffect(String filePath, boolean loop) {
		if(loop == true) {
			this.soundFile = new Media(filePath);
		    this.soundPlayer = new MediaPlayer(soundFile);
		    this.soundPlayer.setOnReady(new Runnable() {

		        public void run() {

		            System.out.println("Duration: "+soundFile.getDuration().toSeconds());

		            // display media's metadata
		            for (Map.Entry<String, Object> entry : soundFile.getMetadata().entrySet()){
		                System.out.println(entry.getKey() + ": " + entry.getValue());
		            }

		        }
		    /*this.soundPlayer.setStopTime(Duration.minutes(1.0));/*setOnEndOfMedia(new Runnable() {
		      public void run() {
		        	soundPlayer.seek(Duration.ONE);
		        }
		     });*/
		});}
		else{
			this.soundFile = new Media(filePath);
			this.soundPlayer = new MediaPlayer(soundFile);
			this.soundPlayer.setCycleCount(1);
			this.soundPlayer.setOnEndOfMedia(new Runnable() {
		        public void run() {
		        	soundPlayer.setMute(true);
		        	
		        }
			});		    
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

	//public void start(){
	//    soundFX.start();
	//}
	
	public void stop(){
	    soundPlayer.stop();
	    soundFX.stop();
	}
	
	/*public static void main(String[] args) {
		String uriString = new File("C:\\Users\\BT_1N3_18\\git\\AnimalCare\\Say\\AnimalCare\\src\\sound\\news.mp3").toURI().toString();
		SoundEffect test = new SoundEffect(uriString, true);
		test.play();
	}*/
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