package design;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Background extends JLabel {
	private Image bg;
	public Image[] albumArt= new Image[49]; // limit
	final URL img_url = getClass().getResource("/images/background/Pi.png"); // Default Bg
	private ImageIcon defaultBg = new ImageIcon(img_url);
	public Background() {
		this.setIcon(defaultBg); 
	}
	public void changeBg(int n) {
		if(albumArt[n]!=null) {
		this.bg=albumArt[n].getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		this.setIcon(new ImageIcon(bg)); }
		else 
			this.setIcon(defaultBg);
		repaint(); // Update
	}
	public void setAlbumArt(int num, Image img) {
		albumArt[num]=img;
	}
	public Image getBackground(int num) {
		return albumArt[num];
	}
}
