package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import process.MusicPlayer;

public class LoadFavoriteSong implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		/* Favorite Song lists */
		MusicPlayer.play_list.showList();
	}
}