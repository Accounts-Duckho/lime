package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import process.MusicPlayer;

public class LoadSongList implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		/* List of songs */
		MusicPlayer.songlist.showList();
	}
}