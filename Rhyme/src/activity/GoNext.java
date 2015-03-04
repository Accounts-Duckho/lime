package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import process.MusicPlayer;
import process.Update;

public class GoNext implements ActionListener {
	private FileInputStream input;

	public void actionPerformed(ActionEvent e) {
		if (MusicPlayer.play_mp3 != null) {
			if (MusicPlayer.queue+1 < ListAdmin.getCount()) {
				MusicPlayer.queue++;
				String songdir = ListAdmin.loaddir(MusicPlayer.queue);
				try {
					input = new FileInputStream(songdir);
					MusicPlayer.changed=true;
					MusicPlayer.play_mp3.exit();
					MusicPlayer.play_mp3 = new Mp3Player(input);
					/* If Two are Unknown either , that 'll be false */
					if (MusicPlayer.demand_list.songinfo.get(MusicPlayer.queue) != MusicPlayer.demand_list.singerinfo.get(MusicPlayer.queue))
						Update.SongInfo(MusicPlayer.queue);
					else
						Update.SongInfo(new File(ListAdmin.loaddir(MusicPlayer.queue)).getName());
					Update.Background(MusicPlayer.queue);
					MusicPlayer.play_mp3.play();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else
				System.out.println("NextSong isn't available");
		}
	}
}