package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;
import process.MusicPlayer;
public class Play implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		MusicPlayer.ctr_panel.switch_btn(true);
		LoadSong ls=new LoadSong();
		ls.actionPerformed(null);
	}
}

class Mp3{
	public Mp3(File path){
		try {
			FileInputStream fis = new FileInputStream(path);
			Player playMp3 = new Player(fis);
			playMp3.play();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}