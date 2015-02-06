/*
 * Author : JungSang
 * Edited by Duckho
 */
package design;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FunctionDock extends JPanel {
	private JButton load_btn;
	private JButton list_btn;
	private JButton favorite_btn;
	private JButton volume_btn;
	private ActionListener loadsong;
	private ActionListener loadlist;
	private ActionListener loadfavorite;
	private ActionListener loadvolumebar;
	
	private void makeButtons() {
		load_btn = createButton("+");// load song
		load_btn.addActionListener(loadsong);
		list_btn = createButton("L");// play list
		list_btn.addActionListener(loadlist);
		favorite_btn = createButton("F");// most_played songs
		favorite_btn.addActionListener(loadfavorite);
		volume_btn = createButton("V");// open volume control	
		volume_btn.addActionListener(loadvolumebar);
	}
	private void applyFeature() {
		/* load button */
		load_btn.setBackground(Color.WHITE);
		load_btn.setForeground(Color.BLACK);
		
		/* list button */
		list_btn.setBackground(Color.WHITE);
		list_btn.setForeground(Color.BLACK);

		/* favorite button */
		favorite_btn.setBackground(Color.WHITE);
		favorite_btn.setForeground(Color.BLACK);

		/* Volume button */
		volume_btn.setBackground(Color.WHITE);
		volume_btn.setForeground(Color.BLACK);
	}

	public void getAction(ActionListener song, ActionListener list,
			ActionListener favorite, ActionListener volume_bar) {	
		loadsong=song;
		loadlist=list;
		loadfavorite=favorite;
		loadvolumebar=volume_bar;
	}
	private void addButtons() {
		this.add(load_btn);
		this.add(list_btn);
		this.add(favorite_btn);
		this.add(volume_btn);
	}
	public void loadDock() {
		makeButtons();
		applyFeature();
		addButtons();
	}

	private JButton createButton(String s) {
		JButton button = new JButton(s);
		return button;
	}
}
