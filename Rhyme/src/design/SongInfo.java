/*
 * Author : Duckho
 */
package design;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SongInfo extends JPanel {
	private JLabel showsinger;
	private JLabel showsong;
	public String singer="Singer";
	public String songname="SongName";
	public SongInfo() {
		setLayout(new GridLayout(3, 1));
		loadInfoPanel(false);
		setBackground(new Color(0, 0, 0, 0));
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
    
	public void loadInfoPanel(boolean music_loaded) {
//		if(!music_loaded)
//		getSongInfo("Singer", "SongName");
		makeLabel();
		applyFeature();
		addToPanel();
	}

	private JLabel createLabel(String s) {
		JLabel label = new JLabel(s);
		return label;
	}
//	private String encoder(String str) {
//
//	}
}
