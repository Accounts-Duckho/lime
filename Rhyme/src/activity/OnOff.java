/**
 * @author Wizard
 * 
 */
package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javazoom.jl.decoder.JavaLayerException;
import process.MusicPlayer;

public class OnOff implements ActionListener {
	public static boolean repeat = false;
	public void actionPerformed(ActionEvent e) {
		if (ListAdmin.loaddir(0) != null) {
				
//	 NOTSTARTED = 0;
//	 PLAYING = 1;
//	 PAUSED = 2;
//	 FINISHED = 3; auto play mod : so that doesn't showing 

					try {
						switch (MusicPlayer.mp3play.getStatus()) {
						case 0:
						MusicPlayer.mp3play.play();
						break;
						case 1:
							MusicPlayer.ctr_panel.switch_btn(false);
							MusicPlayer.mp3play.pause();
							break;
						case 2:
							MusicPlayer.mp3play.play();
							break;
						}
					} catch (JavaLayerException e1) {
						e1.printStackTrace();
					}
		} else {
			LoadSong loader = new LoadSong();
			loader.getSong();
			loader.loadSong();
		}
	}
}

