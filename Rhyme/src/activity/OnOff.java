/**
 * @author Wizard
 * 
 */
package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import process.Update;

public class OnOff implements ActionListener {
	private FileInputStream input;
	private Mp3Player mp3play;
	private boolean loaded = false;
	public static boolean repeat = false;
	private int count = 0;

	public void actionPerformed(ActionEvent e) {
		try {
				if (!loaded) {
					input = new FileInputStream(ListAdmin.loaddir(count));
					count++;
					mp3play = new Mp3Player(input);
					loaded = true;
				}
				switch (mp3play.getStatus()) {
				case 0:
					mp3play.play();					
					break;
				case 1:
					mp3play.pause();
					break;
				case 2:
					mp3play.play();
					break;
				case 3:
					input = new FileInputStream(ListAdmin.loaddir(count));
					Update.SongInfo(count);
					Update.Background(count);		
					mp3play = new Mp3Player(input);
					mp3play.play();
					break;
				}
		} catch (final Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}