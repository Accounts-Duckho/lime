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
	private JLabel showname;
	public String singer="Singer";
	public String songname="SongName";
	public String filename;
	private boolean showonlyname=false;
	public SongInfo() {
		setLayout(new GridLayout(2, 1));
		loadInfoPanel();
		setOpaque(false);
	}
	public void getSongInfo(String singer, String songname) {
		this.singer=singer;
		this.songname=songname;
		showonlyname=false;
	}
	public void getSongInfo(String name) {
		this.singer="";
		this.songname="";
		this.filename=name;
		showonlyname=true;
	}
	private void makeLabel() {	
		if(!showonlyname) {
		showsinger = createLabel(singer);
		showsong = createLabel(songname); }
		else 
		{ 
			showname = createLabel(filename);
		}
	}
	private void applyFeature() {
		if(!showonlyname) {
		/* RGB Color site : http://www.rapidtables.com/web/color/RGB_Color.htm */
		
		/* Singer */
		showsinger.setFont(new Font("NANUM", Font.PLAIN, 12));
		showsinger.setForeground(new Color(0,128,128)); // text color
		showsinger.setHorizontalAlignment(JLabel.CENTER);

		/* Song */
		showsong.setFont(new Font("NANUM", Font.PLAIN, 13));
		showsong.setForeground(new Color(65,105,225));
		showsong.setHorizontalAlignment(JLabel.CENTER); }
		else {
			/* Name */
			showname.setFont(new Font("NANUM", Font.PLAIN, 12));
			showname.setForeground(new Color(0,128,128)); // text color
			showname.setHorizontalAlignment(JLabel.CENTER);
		}
	}
	
    private void addToPanel() {
    	if(!showonlyname) {
    	this.add(showsinger);
    	this.add(showsong); }
    	else {
    		this.add(showname);
    	}
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
