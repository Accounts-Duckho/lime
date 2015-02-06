/*
 * Author : SooMan
 * Edited by Duckho
 */
package design;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollBar;

@SuppressWarnings("serial")
public class VolumeBar extends JFrame {
	private JScrollBar volume_bar;
	
	private void load() {
		this.setTitle("Controll Volume");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // this option
																// means exit
																// only this
		this.setResizable(false);
		this.setSize(250, 60);
		this.setVisible(true);
		Dimension windowSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(screenSize.width / 2 - windowSize.width / 2,
				screenSize.height / 2 + (windowSize.height * 5) / 2);

		/* make */
		volume_bar = createScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 10);

		/* add */
		this.add(volume_bar);
	}
	public void loadVolumeBar() {
		load();	
	}

	private JScrollBar createScrollBar(int orientation, int value, int extent,
			int min, int max) {
		JScrollBar bar = new JScrollBar(orientation, value, extent, min, max);
		return bar;
	}

}