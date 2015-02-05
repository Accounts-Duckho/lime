/*
 * Author : Duckho 
 */
package design;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControllMusic extends JPanel {
	private static final long serialVersionUID = 1L;
	private int playing = 0;

	private void load(boolean b) {
		if (b) {
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			JButton previous_btn = new JButton(); // Play Previous song
			JButton next_btn = new JButton(); // Play Next song
			JButton onoff_btn = new JButton();
			
			/* previous */
			previous_btn.setBackground(Color.WHITE);
			previous_btn.setForeground(Color.BLACK);
			previous_btn.setMaximumSize(new Dimension(30, 30));
			
			/* on off */
//		    Image img;
//			try {
//				img = ImageIO.read(getClass().getResource("Img address"));
//			    onoff_btn.setIcon(new ImageIcon(img));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//			}
			
//			/* make transparaent */
//			onoff_btn.setContentAreaFilled(false);
//			onoff_btn.setBorder(null);
			
			onoff_btn.setBackground(Color.WHITE);
			onoff_btn.setForeground(Color.BLACK);
			onoff_btn.setMinimumSize(new Dimension(150, 150));
			onoff_btn.setMaximumSize(new Dimension(150, 150));
			if (playing != 1) {
				onoff_btn.setText("Play"); // Play song
			} else {
				onoff_btn.setText("Pause"); // Stop song
			}
			
			/* next */
			next_btn.setBackground(Color.WHITE);
			next_btn.setForeground(Color.BLACK);
			next_btn.setMaximumSize(new Dimension(30, 30));
			
			/* add */
			this.add(previous_btn);
			this.add(Box.createRigidArea(new Dimension(17, 0))); // = make a empty block
			this.add(onoff_btn);
			this.add(Box.createRigidArea(new Dimension(17, 0))); // = make a empty block
			this.add(next_btn);
		}
	}

	public void loadCtrMusic(boolean b) {
		load(b);
	}
}
