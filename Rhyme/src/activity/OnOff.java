/**
 * @author Wizard
 * 
 */
package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javazoom.jlgui.basicplayer.BasicPlayerException;
import process.MusicPlayer;
import process.Update;

public class OnOff implements ActionListener {
	private int count = 0;

/* < BasicPlayer Status info >
-1 = before load any file
0 = playing
1 = stop
2 = finished song
3 = opened?
*/
	public void actionPerformed(ActionEvent e) {
		if (MusicPlayer.mp3play.getStatus() == -1) {
			MusicPlayer.mp3play.load(ListAdmin.loaddir(count));
			if (count < (ListAdmin.getCount() - 1))
				count++; // example : load first song
			try {
				MusicPlayer.ctr_panel.switch_btn(true);
				MusicPlayer.mp3play.play();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {
			switch (MusicPlayer.mp3play.getStatus()) {
			case 0:
				try {
					MusicPlayer.mp3play.pause();
					MusicPlayer.ctr_panel.switch_btn(false); // change btn img to '>'
				} catch (BasicPlayerException e2) {
					e2.printStackTrace();
				}
				break;
			case 1:
				try {
					MusicPlayer.mp3play.resume();
					MusicPlayer.ctr_panel.switch_btn(true); // change btn img to '||'
				} catch (BasicPlayerException e1) {
					e1.printStackTrace();
				}
				break;
			case 2:
				try {
					Update.Background(count);
					Update.SongInfo(count);
					MusicPlayer.mp3play.load(ListAdmin.loaddir(count)); // change song
					count++;
					MusicPlayer.mp3play.play();
					MusicPlayer.ctr_panel.switch_btn(true); // change btn img to '||'
				} catch (BasicPlayerException e1) {
					e1.printStackTrace();
				}
				break;
			case 3:
				try {
					MusicPlayer.mp3play.play();
					MusicPlayer.ctr_panel.switch_btn(false); // change btn img to '||'
				} catch (BasicPlayerException e1) {
					e1.printStackTrace();
				}
				break;

			}
		}
	}
}