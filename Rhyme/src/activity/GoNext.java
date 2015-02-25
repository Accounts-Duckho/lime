package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
					/* If Two are Unknown either , that 'll be false */
					if (MusicPlayer.demand_list.songinfo.get(next_count) != MusicPlayer.demand_list.singerinfo.get(next_count))
						Update.SongInfo(next_count);
					else
						Update.SongInfo(new File(ListAdmin.loaddir(next_count)).getName());
					Update.Background(next_count);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				OnOff.setCount(next_count);
			} else
				System.out.println("NextSong isn't available");
		}
	}
}