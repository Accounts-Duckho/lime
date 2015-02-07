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
final public class SongInfo extends JPanel {
	private JLabel showsinger;
	private JLabel showsong;
	public SongInfo() {
		setLayout(new GridLayout(3, 1));
	}
	private void makeLabel() {	
		String singer = "Apink";
		String songname = "No No No";
		showsinger = createLabel(singer);
		showsong = createLabel(songname);		
	}
	
	private void applyFeature() {

		/* Singer */
		showsinger.setFont(new Font("GODIC", Font.BOLD, 12));
		showsinger.setForeground(Color.darkGray); // text color
		showsinger.setHorizontalAlignment(JLabel.CENTER);

		/* Song */
		showsong.setFont(new Font("GODIC", Font.BOLD, 14));
		showsong.setHorizontalAlignment(JLabel.CENTER);
	}
	
    private void addToPanel() {
    	this.add(showsinger);
    	this.add(showsong);
    	this.add(new JSeparator(JSeparator.HORIZONTAL)); // Separator    	
    }
    
	public void loadSongInfo() {
		makeLabel();
		applyFeature();
		addToPanel();
	}

	private JLabel createLabel(String s) {
		JLabel label = new JLabel(s);
		return label;
	}
}
