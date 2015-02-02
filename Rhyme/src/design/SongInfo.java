package design;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SongInfo {
	JPanel songinfo = new JPanel(new GridLayout(2, 1));
	private void load(boolean b) {
		if (b) {
			String singer="에이핑크";
			String song="So Long";
			JLabel showsinger = new JLabel(singer);
			JLabel showsong = new JLabel(song);
			showsinger.setHorizontalAlignment(JLabel.LEFT);
			showsinger.setVerticalAlignment(JLabel.TOP);
			showsinger.setFont(new Font("Nanum", Font.PLAIN, 14));
			showsong.setHorizontalAlignment(JLabel.RIGHT);
			showsong.setVerticalAlignment(JLabel.BOTTOM);
			showsong.setFont(new Font("Nanum", Font.PLAIN, 14));
			songinfo.add(showsinger);
			songinfo.add(showsong);
			songinfo.setLocation(250, 100);
			MainFrame.main.setLayout(new GridLayout(6,1));
			MainFrame.main.add(songinfo);
		}
	}
	public void loadSongInfo(boolean b) {
		load(b);
	}
}
