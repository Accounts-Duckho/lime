package activity;

import java.io.File;

import javazoom.jlgui.basicplayer.BasicPlayer;


public class Mp3Player extends BasicPlayer{
	private File songdir;
	public Mp3Player() {
		setSleepTime(1);
	}
	public void load(String dir) {
		songdir=new File(dir);
		try {
			open(songdir);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}
