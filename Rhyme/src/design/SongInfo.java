/*
 * Author : Duckho
 */
package design;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SongInfo extends JPanel {
	private JLabel showsinger;
	private JLabel showsong;
	public String singer="Singer";
	public String songname="SongName";
	public SongInfo() {
		setLayout(new GridLayout(2, 1));
		loadInfoPanel();
		setOpaque(false);
	}
	public void getSongInfo(String singer, String songname) {
		this.singer=singer;
		this.songname=songname;
	}
	private void makeLabel() {	
		showsinger = createLabel(singer);
		showsong = createLabel(songname);		
	}
	private void applyFeature() {
		/* RGB Color site : http://www.rapidtables.com/web/color/RGB_Color.htm */
		
		/* Singer */
		showsinger.setFont(new Font("NANUM", Font.PLAIN, 12));
		showsinger.setForeground(new Color(0,128,128)); // text color
		showsinger.setHorizontalAlignment(JLabel.CENTER);

		/* Song */
		showsong.setFont(new Font("NANUM", Font.PLAIN, 13));
		showsong.setForeground(new Color(65,105,225));
		showsong.setHorizontalAlignment(JLabel.CENTER);
	}
	
    private void addToPanel() {
    	this.add(showsinger);
    	this.add(showsong);
    }
    
	public void loadInfoPanel() {
		makeLabel();
		applyFeature();
		addToPanel();
	}

	private JLabel createLabel(String s) {
		JLabel label = new JLabel(s);
		return label;
	}
}
