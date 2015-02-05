/*
 * Author : Duckho
 */
package design;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class SongInfo extends JPanel {
	private static final long serialVersionUID = 1L;
	private void load(boolean b) {
		if (b) {
			this.setLayout(new GridLayout(3,1));
			String singer="  Apink"; // Please add empty block rather than space
			String song="No No No  "; // this too
			
			/* make */
			JLabel showsinger = new JLabel(singer);
			JLabel showsong = new JLabel(song);
			
			/* Singer */
			showsinger.setFont(new Font("GODIC", Font.PLAIN, 14));
			
			/* Song */
			showsong.setHorizontalAlignment(JLabel.RIGHT);
			showsong.setFont(new Font("GODIC", Font.PLAIN, 14));
			
			/* add */
			this.add(showsinger);
			this.add(showsong);
			this.add(new JSeparator(JSeparator.HORIZONTAL)); // Separator 
		}
	}
	public void loadSongInfo(boolean b) {
		load(b);
	}
}
