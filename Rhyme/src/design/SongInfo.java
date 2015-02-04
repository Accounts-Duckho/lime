package design;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class SongInfo {
	JPanel songinfo = new JPanel();
	private void load(boolean b) {
		if (b) {
			songinfo.setLayout(new GridLayout(3,1));
			String singer="«—±π ªÁ∂˜";
			String song="æ÷±π∞°";
			JLabel showsinger = new JLabel(singer);
			JLabel showsong = new JLabel(song);
			showsong.setHorizontalAlignment(JLabel.RIGHT);
			showsinger.setFont(new Font("Nanum", Font.PLAIN, 14));
			showsong.setFont(new Font("Nanum", Font.PLAIN, 14));
			songinfo.add(showsinger);
			songinfo.add(showsong);
			songinfo.add(new JSeparator(JSeparator.HORIZONTAL)); // ¬±¬∏¬∫√ê¬º¬± 
			MainFrame.main.add(songinfo, BorderLayout.NORTH);
		}
	}
	public void loadSongInfo(boolean b) {
		load(b);
	}
}
