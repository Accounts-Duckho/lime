package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import javazoom.jl.decoder.JavaLayerException;

public class PlayInList implements ActionListener {
	private FileInputStream input;
	private Mp3Player mp3play;

	public PlayInList(int n) {
		String songdir = ListAdmin.loaddir(n);
		try {
			input = new FileInputStream(songdir);
			mp3play = new Mp3Player(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		try {
			mp3play.play();
		} catch (JavaLayerException e1) {
			e1.printStackTrace();
		}
	}
}