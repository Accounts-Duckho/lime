package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import process.MusicPlayer;
import process.Update;

public class GoNext implements ActionListener {
	private int next_count;
	private FileInputStream input;
	private boolean clicked = false;

	public void actionPerformed(ActionEvent e) {
		if (MusicPlayer.mp3play != null) {
			clicked = true;
			MusicPlayer.mp3play.ifnext(clicked);
			next_count = OnOff.getCount() + 1;
			if (next_count < ListAdmin.getCount()) {
				String songdir = ListAdmin.loaddir(next_count);
				try {
					input = new FileInputStream(songdir);
					MusicPlayer.mp3play = new Mp3Player(input);
					Update.SongInfo(next_count);
					Update.Background(next_count);
					OnOff.setCount(next_count);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else
				System.out.println("NextSong isn't available");
		}
	}
}