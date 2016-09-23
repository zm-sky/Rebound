package me.zmsky.rebound.sound;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public enum SoundEffect {

	UI_SELECT("me/zmsky/rebound/resources/Select.wav");
	
	private String Path;
	
	SoundEffect(String Path) { this.Path = Path; }
	
	public void play() {
		new Thread(new Runnable() {
			public void run() {
		        try {
		          URL url = SoundEffect.class.getClassLoader().getResource(SoundEffect.this.Path);
		          final AudioInputStream ais = AudioSystem.getAudioInputStream(url);
		          final Clip clip = AudioSystem.getClip();
		          
			      LineListener list = new LineListener() {
						public void update(LineEvent event) {
							if(event.getType() == LineEvent.Type.STOP){
								clip.stop();
								clip.close();
								
								try{ ais.close(); }catch(Exception e){ e.printStackTrace(); }
							}
						}
			      };
		           
		          clip.addLineListener(list);
		          clip.open(ais);

		          clip.start();
		         } catch (Exception e) { e.printStackTrace(); }
			}
		}).start();
	}
}
