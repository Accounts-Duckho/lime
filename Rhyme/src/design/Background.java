package design;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Background extends JLabel {
	private Image bg;
	public Background() {
        final URL DefaultBg = getClass().getResource("/images/background/Pi.png"); // Default Bg
		this.setIcon(new ImageIcon(DefaultBg)); 
	}
	public void changeBg(Image albumart) {
		this.bg=albumart.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		this.setIcon(new ImageIcon(bg));
		repaint(); // Update
	}
}
