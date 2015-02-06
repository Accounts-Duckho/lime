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
	private boolean playing = false;
	private JButton previous_btn;
	private JButton next_btn;
	private JButton onoff_btn;
	private ActionListener loadprevious;
	private ActionListener loadnext;
	private ActionListener onandoff;
	
	private void makeButtons() {	
		previous_btn = createButton();
		previous_btn.addActionListener(loadprevious);
		next_btn = createButton();
		next_btn.addActionListener(loadnext);
		onoff_btn = createButton();
		onoff_btn.addActionListener(onandoff);
	}
	private void applyFeature() {

		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		/* previous */
		previous_btn.setBackground(Color.WHITE);
		previous_btn.setForeground(Color.BLACK);
		previous_btn.setMaximumSize(new Dimension(30, 30));

		/* on off */
		// /* make transparaent */
		// onoff_btn.setContentAreaFilled(false);
		// onoff_btn.setBorder(null);
		onoff_btn.setBackground(Color.WHITE);
		onoff_btn.setForeground(Color.BLACK);
		onoff_btn.setMaximumSize(new Dimension(150, 150));
		if (!playing) {
			onoff_btn.setText("Play"); // Play song
		} else {
			onoff_btn.setText("Pause"); // Stop song
		}

		/* next */
		next_btn.setBackground(Color.WHITE);
		next_btn.setForeground(Color.BLACK);
		next_btn.setMaximumSize(new Dimension(30, 30));
		
	}
	public void addButtons() {
		this.add(previous_btn);
		this.add(Box.createRigidArea(new Dimension(17, 0))); /* empty block */
		this.add(onoff_btn);
		this.add(Box.createRigidArea(new Dimension(17, 0))); /* empty block */
		this.add(next_btn);
	}
	public void getAction(ActionListener previous, ActionListener next,
			ActionListener onoff) {
		makeButtons();
		loadprevious=previous;
		loadnext=next;
		onandoff=onoff;
	}
	public void getStatue(boolean b) {
		playing = b;
	}

	public void loadCtrMusic() {
		makeButtons();
		applyFeature();
		addButtons();	
	}

	private JButton createButton() {
		JButton button = new JButton();
		return button;
	}
}
