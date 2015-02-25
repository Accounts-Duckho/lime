package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import process.MusicPlayer;
import process.Update;

public class GoPrevious implements ActionListener {
	private int pre_count;
	private FileInputStream input;
	private boolean clicked = false;

	public void actionPerformed(ActionEvent e) {
		if (MusicPlayer.mp3play != null) {
			clicked = true;
			MusicPlayer.mp3play.ifpre(clicked);
			pre_count = OnOff.getCount() - 1;
			if (pre_count >= 0) {
				String songdir = ListAdmin.loaddir(pre_count);
				try {
					input = new FileInputStream(songdir);
					MusicPlayer.mp3play = new Mp3Player(input);
					if (MusicPlayer.demand_list.songinfo.get(pre_count) != MusicPlayer.demand_list.singerinfo.get(pre_count))
						Update.SongInfo(pre_count);
					else
						Update.SongInfo(new File(ListAdmin.loaddir(pre_count)).getName());
					Update.Background(pre_count);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				OnOff.setCount(pre_count);
			} else
				System.out.println("Previous Song isn't available");
		}
	}
}