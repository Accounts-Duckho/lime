/*
 * This frame is made by Soo Man
 */
package design;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollBar;

class ControllVolume {
	private void load(boolean b) {
		if (b) {
			JFrame volume = new JFrame("Control Volume");
			volume.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			volume.setResizable(false);
			volume.setSize(250, 60);
			JScrollBar ctr_volume = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1,
					0, 10);
			volume.add(ctr_volume);
			volume.setVisible(true);
			Dimension windowSize = volume.getSize();
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			// Make screen position center 
			volume.setLocation(screenSize.width / 2 - windowSize.width/2,
					screenSize.height/2 + (windowSize.height*5)/2);
		}
	}
	public void loadCtrVolume(boolean b) {
		load(b);
	}
	
}