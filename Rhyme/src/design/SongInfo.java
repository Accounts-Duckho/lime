/*
 * Author : Duckho
 */
package design;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class SongInfo extends JPanel {
	private JLabel showsinger;
	private JLabel showsong;
	private String singer;
	private String songname;
	private JProgressBar bar;
	public SongInfo() {
		setLayout(new GridLayout(3, 1));
	}
	public void getSongInfo(String singer, String songname) {
		this.singer=singer;
		this.songname=songname;
	}
	private void makeLabel() {	
		showsinger = createLabel(singer);
		showsong = createLabel(songname);		
	}
	private void makeProgressBar() {
		bar=createBar(0, 100);
		bar.setValue(0);
		bar.setStringPainted(true);
		Dimension prefSize = bar.getPreferredSize();
		prefSize.height = 10;
		bar.setPreferredSize(prefSize);
	}
	private void applyFeature() {

		/* Singer */
		showsinger.setFont(new Font("GODIC", Font.BOLD, 11));
		showsinger.setForeground(Color.darkGray); // text color
		showsinger.setHorizontalAlignment(JLabel.CENTER);

		/* Song */
		showsong.setFont(new Font("GODIC", Font.BOLD, 12));
		showsong.setHorizontalAlignment(JLabel.CENTER);
	}
	
    private void addToPanel() {
    	this.add(showsinger);
    	this.add(showsong);
    	this.add(bar); 
    }
    
	public void loadInfoPanel(boolean music_loaded) {
		if(!music_loaded)
		getSongInfo("Singer", "SongName");
		makeLabel();
		makeProgressBar();
		applyFeature();
		addToPanel();
	}

	private JLabel createLabel(String s) {
		JLabel label = new JLabel(s);
		return label;
	}
	private JProgressBar createBar(int start, int endline) {
		JProgressBar bar = new JProgressBar(start, endline);
		return bar;
	}
}
