package design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControllMusic {
	JPanel ctr_music = new JPanel();
	private int playing = 0;

	private void load(boolean b) {
		if (b) {
			ctr_music.setLayout(new BoxLayout(ctr_music, BoxLayout.X_AXIS));
			/* previous */
			JButton previous_btn=new JButton(); // ÀÌÀü°î
			previous_btn.setBackground(Color.WHITE);
			previous_btn.setForeground(Color.BLACK);
			previous_btn.setMaximumSize(new Dimension(30,150));
			ctr_music.add(previous_btn);
			// make some space
			ctr_music.add(Box.createRigidArea(new Dimension(20, 0)));
			/* on off */
			JButton onoff_btn = new JButton();
			onoff_btn.setBackground(Color.WHITE);
			onoff_btn.setForeground(Color.BLACK);
			onoff_btn.setMaximumSize(new Dimension(150,150));
			if (playing != 1) {
				onoff_btn.setText("Àç»ý");
			} else {
				onoff_btn.setText("¸ØÃã");
			}
			ctr_music.add(onoff_btn);
			// make some space
			ctr_music.add(Box.createRigidArea(new Dimension(20, 0)));
			/* next */
			JButton next_btn=new JButton(); // ´ÙÀ½°î
			next_btn.setBackground(Color.WHITE);
			next_btn.setForeground(Color.BLACK);
			next_btn.setMaximumSize(new Dimension(30,150));
			ctr_music.add(next_btn);
			MainFrame.main.add(ctr_music, BorderLayout.CENTER);
		}
	}

	public void loadCtrMusic(boolean b) {
		load(b);
	}
}