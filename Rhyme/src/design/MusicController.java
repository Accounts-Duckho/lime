/*
 * Author : Duckho 
 */
package design;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MusicController extends JPanel {
	private JButton previous_btn;
	private JButton next_btn;
	private JButton play_btn;
	private JButton pause_btn;

	public MusicController() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		makeButtons();
	}

	private void makeButtons() {
		previous_btn = createButton();
		next_btn = createButton();
		play_btn = createButton();
		pause_btn = createButton();
	}

	private void applyFeature() {

		/* previous */
		previous_btn.setBackground(Color.WHITE);
		previous_btn.setForeground(Color.BLACK);
		previous_btn.setMaximumSize(new Dimension(30, 30));

		/* play or pause */
		// /* make transparaent */
		// onoff_btn.setContentAreaFilled(false);
		// onoff_btn.setBorder(null);
		play_btn.setBackground(Color.WHITE);
		play_btn.setForeground(Color.BLACK);
		play_btn.setMaximumSize(new Dimension(150, 150));
		play_btn.setText("Play");
		
		pause_btn.setBackground(Color.WHITE);
		pause_btn.setForeground(Color.BLACK);
		pause_btn.setMaximumSize(new Dimension(150, 150));
		pause_btn.setText("Pause"); 		

		/* next */
		next_btn.setBackground(Color.WHITE);
		next_btn.setForeground(Color.BLACK);
		next_btn.setMaximumSize(new Dimension(30, 30));

	}

	private void addButtons() {
		this.add(previous_btn);
		this.add(Box.createRigidArea(new Dimension(17, 0))); /* empty block */
		this.add(play_btn);
		this.add(pause_btn);
		this.add(Box.createRigidArea(new Dimension(17, 0))); /* empty block */
		this.add(next_btn);
	}
	public void switch_btn(boolean playing) {
		play_btn.setVisible(!playing);
		pause_btn.setVisible(playing);
	}
	public void getAction(ActionListener previous, ActionListener next,
			ActionListener play, ActionListener pause) {
		assignAct(previous_btn, previous);
		assignAct(next_btn, next);
		assignAct(play_btn, play);
		assignAct(pause_btn, pause);
	}

	private void assignAct(JButton btn, ActionListener act) {
		btn.addActionListener(act);
	}

	public void loadCtrPanel() {
		applyFeature();
		switch_btn(false);
		addButtons();
	}
	private JButton createButton() {
		JButton button = new JButton();
		return button;
	}
}
