/*
 * Author : Duckho
 */
package design;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class SongInfo extends JPanel {
	private JLabel showsinger;
	private JLabel showsong;

	private void load() {
		this.setLayout(new GridLayout(3, 1));
		String singer = "Apink";
		String song = "No No No";

		/* make */
		showsinger = createLabel(singer);
		showsong = createLabel(song);

		/* Singer */
		showsinger.setFont(new Font("GODIC", Font.BOLD, 12));
		showsinger.setForeground(Color.darkGray); // text color
		showsinger.setHorizontalAlignment(JLabel.CENTER);

		/* Song */
		showsong.setFont(new Font("GODIC", Font.BOLD, 14));
		showsong.setHorizontalAlignment(JLabel.CENTER);

		/* add */
		this.add(showsinger);
		this.add(showsong);
		this.add(new JSeparator(JSeparator.HORIZONTAL)); // Separator
	}

	public void loadSongInfo() {
		load();
	}

	private JLabel createLabel(String s) {
		JLabel label = new JLabel(s);
		return label;
	}
}
