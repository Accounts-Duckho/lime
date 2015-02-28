package activity;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;

import process.MusicPlayer;
import process.Update;

public class PlayInList implements MouseListener {
	private FileInputStream input;
	private int count;
	public PlayInList(int n) {
		count=n;
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			try {
				MusicPlayer.changed=true;
				MusicPlayer.mp3play.exit();
				MusicPlayer.queue=count;
				String songdir = ListAdmin.loaddir(count);			
				input = new FileInputStream(songdir);
				MusicPlayer.mp3play = new Mp3Player(input);
				Update.SongInfo(MusicPlayer.queue);
				Update.Background(MusicPlayer.queue);
				MusicPlayer.mp3play.play();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	public void mouseEntered(MouseEvent e1) { }
	public void mouseExited(MouseEvent e2) { }
	public void mouseReleased(MouseEvent e3) { }
	public void mousePressed(MouseEvent e4) { }
}