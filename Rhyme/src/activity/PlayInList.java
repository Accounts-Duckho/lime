package activity;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;

import process.MusicPlayer;
import process.Update;
import javazoom.jl.decoder.JavaLayerException;

public class PlayInList implements MouseListener {
	private FileInputStream input;
	private int count;
	public PlayInList(int n) {
		count=n;
		String songdir = ListAdmin.loaddir(n);
		try {
			input = new FileInputStream(songdir);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void mouseEntered(MouseEvent e1) { }
	public void mouseExited(MouseEvent e2) { }
	public void mouseReleased(MouseEvent e3) { }
	public void mousePressed(MouseEvent e4) { }
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			try {
				MusicPlayer.mp3play = new Mp3Player(input);
				Update.SongInfo(count);
				Update.Background(count);
				OnOff.setCount(count);
			} catch (JavaLayerException e1) {
				e1.printStackTrace();
			}
		}
	}
}