/*
 * Author : JungSang
 * Edited by Duckho
 */
package design;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Function extends JPanel {
	private static final long serialVersionUID = 1L;
	private void load(boolean b) {
		this.setPreferredSize(new Dimension(120, 30));
		/* make buttons */
		JButton load_btn = new JButton("+");// load song
		JButton list_btn = new JButton("L");// play list
		JButton favorite_btn = new JButton("F");// most_played songs
		JButton Volume = new JButton("V");// open volume control
		
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
		Volume.setBackground(Color.WHITE);
		Volume.setForeground(Color.BLACK);
		
		/* add */
		this.add(load_btn);
		this.add(list_btn);
		this.add(favorite_btn);
		this.add(Volume);
	}
	public void loadFunc(boolean b) {
		load(b);
	}
}
