package backend;

import javafx.scene.media.*;
import javafx.util.Duration;

public class SoundEffect
{	
	private Media soundFile;
	public MediaPlayer soundPlayer;
	public SoundEffect(String filePath, boolean loop)
	{
		if(loop)
		{
			this.soundFile = new Media(filePath);
			this.soundPlayer = new MediaPlayer(soundFile);
			this.soundPlayer.setOnEndOfMedia(new Runnable()
			{
				public void run()
				{
					soundPlayer.seek(Duration.ZERO);
				}
			});
		}
		else
		{
			this.soundFile = new Media(filePath);
			this.soundPlayer = new MediaPlayer(soundFile);
		}
	}
	public void play()
	{
		soundPlayer.play();
	}
	public void stop()
	{
		soundPlayer.stop();
	}
}