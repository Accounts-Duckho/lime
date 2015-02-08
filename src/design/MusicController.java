/*

 * Author : Duckho 
 */
package design;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
		final URL icon_previous = getClass().getResource("/images/icons/previous.png");
		final URL icon_next = getClass().getResource("/images/icons/next.png");
		final URL icon_play = getClass().getResource("/images/icons/play.png");
		final URL icon_pause = getClass().getResource("/images/icons/pause.png");
		previous_btn = createButton(new ImageIcon(icon_previous));
		next_btn = createButton(new ImageIcon(icon_next));
		play_btn = createButton(new ImageIcon(icon_play));
		pause_btn = createButton(new ImageIcon(icon_pause));
	}
	private void applyFeature() {

		/* previous */
		previous_btn.setBorder(null);
		previous_btn.setFocusable(false);
		previous_btn.setContentAreaFilled(false);
		previous_btn.setBackground(Color.WHITE);
		previous_btn.setForeground(Color.BLACK);
		previous_btn.setMaximumSize(new Dimension(30, 30));
		
		/* play & pause */
		play_btn.setBorder(null);
		play_btn.setFocusable(false);
		play_btn.setContentAreaFilled(false);
		play_btn.setBackground(Color.WHITE);
		play_btn.setForeground(Color.BLACK);
		play_btn.setMaximumSize(new Dimension(150, 150));
//		play_btn.setText("Play");
		
		pause_btn.setBorder(null);
		pause_btn.setFocusable(false);
		pause_btn.setContentAreaFilled(false);
		pause_btn.setBackground(Color.WHITE);
		pause_btn.setForeground(Color.BLACK);
		pause_btn.setMaximumSize(new Dimension(150, 150));
//		pause_btn.setText("Pause"); 

		/* next */
		next_btn.setBorder(null);
		next_btn.setFocusable(false);
		next_btn.setContentAreaFilled(false);
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
	private JButton createButton(Icon icon) {
		JButton button = new JButton(icon);
		return button;
	}
}
