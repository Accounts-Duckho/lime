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

import activity.GoNext;
import activity.GoPrevious;
import activity.OnOff;

@SuppressWarnings("serial")
public class MusicController extends JPanel {

	private JButton previous_btn;
	private JButton next_btn;
	private JButton onoff_btn;
	final URL icon_previous = getClass().getResource("/images/icons/previous.png");
	final URL icon_next = getClass().getResource("/images/icons/next.png");
	final URL icon_play = getClass().getResource("/images/icons/play.png");
	final URL icon_pause = getClass().getResource("/images/icons/pause.png");
	public MusicController() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		makeButtons();
		getAction(new GoPrevious(), new GoNext(), new OnOff());
		loadCtrPanel();
		setBackground(new Color(0, 0, 0, 0));
		setOpaque(false);
	}

	private void makeButtons() {		
		previous_btn = createButton(new ImageIcon(icon_previous));
		next_btn = createButton(new ImageIcon(icon_next));
		onoff_btn = createButton(new ImageIcon(icon_play));
	}

	private void applyFeature() {

		/* previous */
		previous_btn.setBorder(null);
		previous_btn.setFocusable(false);
		previous_btn.setContentAreaFilled(false);
		previous_btn.setMaximumSize(new Dimension(30, 30));

		/* play & pause */
		onoff_btn.setBorder(null);
		onoff_btn.setFocusable(false);
		onoff_btn.setContentAreaFilled(false);
		onoff_btn.setMaximumSize(new Dimension(150, 150));

		/* next */
		next_btn.setBorder(null);
		next_btn.setFocusable(false);
		next_btn.setContentAreaFilled(false);
		next_btn.setMaximumSize(new Dimension(30, 30));

	}

	private void addButtons() {
		this.add(Box.createRigidArea(new Dimension(24, 0))); /* empty block */
		this.add(previous_btn);
		this.add(Box.createRigidArea(new Dimension(1, 0))); /* empty block */
		this.add(onoff_btn);
		this.add(Box.createRigidArea(new Dimension(1, 0))); /* empty block */
		this.add(next_btn);
		this.add(Box.createRigidArea(new Dimension(24, 0))); /* empty block */
	}

	public void switch_btn(boolean playing) {
		if(playing) {
			onoff_btn.setIcon(new ImageIcon(icon_pause));
		}
		else {
			onoff_btn.setIcon(new ImageIcon(icon_play));
		}
	}

	public void getAction(ActionListener previous, ActionListener next,
			ActionListener onoff) {
		assignAct(previous_btn, previous);
		assignAct(next_btn, next);
		assignAct(onoff_btn, onoff);
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
