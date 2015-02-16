package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javazoom.jlgui.basicplayer.BasicPlayerException;
import process.MusicPlayer;

public class OnOff implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (MusicPlayer.mp3play.getStatus() == -1) {
			MusicPlayer.mp3play.load(ListAdmin.loaddir(0)); // example : load first song 
			try {
				MusicPlayer.ctr_panel.switch_btn(true);
				MusicPlayer.mp3play.play();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else
			switch (MusicPlayer.mp3play.getStatus()) {
			case 0:
				try {
					MusicPlayer.ctr_panel.switch_btn(false); // change btn img to '>'
					MusicPlayer.mp3play.pause();
				} catch (BasicPlayerException e2) {
					e2.printStackTrace();
				}
				break;
			case 1:
				try {
					MusicPlayer.ctr_panel.switch_btn(true); // change btn img to '||'
					MusicPlayer.mp3play.resume();
				} catch (BasicPlayerException e1) {
					e1.printStackTrace();
				}
				break;
			case 2:
				try {
					MusicPlayer.ctr_panel.switch_btn(true); // change btn img to '||'
					MusicPlayer.mp3play.play();
				} catch (BasicPlayerException e1) {
					e1.printStackTrace();
				}
				break;
			case 3:
				try {
					MusicPlayer.ctr_panel.switch_btn(true); // change btn img to '||'
					MusicPlayer.mp3play.play();
				} catch (BasicPlayerException e1) {
					e1.printStackTrace();
				}
				break;

			}
	}
}