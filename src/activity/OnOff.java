/**
 * @author Wizard
 * 
 */
package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import process.MusicPlayer;
import process.Update;

public class OnOff implements ActionListener {
	private FileInputStream input;
	private boolean loaded = false;
	public static boolean repeat = false;
	private static int count = 0;
	private static int change_cnt = 0;
	public void actionPerformed(ActionEvent e) {
		if (ListAdmin.loaddir(0) != null) {
			try {
				if (!loaded) {
					input = new FileInputStream(ListAdmin.loaddir(count));
					count++;
					MusicPlayer.mp3play = new Mp3Player(input);
					loaded = true;
				}
				
//	 NOTSTARTED = 0;
//	 PLAYING = 1;
//	 PAUSED = 2;
//	 FINISHED = 3;

				switch (MusicPlayer.mp3play.getStatus()) {
				case 0:
					MusicPlayer.ctr_panel.switch_btn(true);
					MusicPlayer.mp3play.play();
					break;
				case 1:
					MusicPlayer.ctr_panel.switch_btn(false);
					MusicPlayer.mp3play.pause();
					break;
				case 2:
					MusicPlayer.ctr_panel.switch_btn(true);
					MusicPlayer.mp3play.play();
					break;
				case 3:
					input = new FileInputStream(ListAdmin.loaddir(count));
					Update.SongInfo(count);
					Update.Background(count);
					count++;
					change_cnt++;
					MusicPlayer.mp3play = new Mp3Player(input);
					MusicPlayer.mp3play.play();
					break;
				}
			} catch (final Exception ex) {
				throw new RuntimeException(ex);
			}
		} else {
			LoadSong loader = new LoadSong();
			loader.getSong();
			loader.loadSong();
		}
	}

	public static int getCount() {
		return change_cnt;
	}

	public static void setCount(int n) {
		change_cnt = n;
		count = change_cnt;
	}
}
