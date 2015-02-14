package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import process.MusicPlayer;
public class Pause implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		MusicPlayer.ctr_panel.switch_btn(false); // switch_btn(playing) ->  playing = false 
	}
}