/*
 * Author : SooMan
 * Edited by Duckho
 */
package design;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollBar;

class ControllVolume extends JFrame {
private static final long serialVersionUID = 1L;
	private void load(boolean b) {
		if (b) {
			this.setTitle("Control Volume");
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // this option means exit only this
			this.setResizable(false);
			this.setSize(250, 60);
			this.setVisible(true);
			Dimension windowSize = this.getSize();
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(screenSize.width / 2 - windowSize.width/2,
					screenSize.height/2 + (windowSize.height*5)/2);
			
			/* make */
			JScrollBar volume_bar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1,
					0, 10);
			
			/* add */
			this.add(volume_bar);
		}
	}
	public void loadCtrVolume(boolean b) {
		load(b);
	}
	
}