package design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Function {
	private void load(boolean b) {
		/* for the test */
		JPanel func = new JPanel();
		JButton load_btn = new JButton("+");// load song
		JButton list_btn = new JButton("L");// play list
		JButton favorite_btn = new JButton("F");// most_played songs
		JButton Volume = new JButton("V");// volume control
		
		func.setPreferredSize(new Dimension(120, 30));
		
		func.add(load_btn);
		load_btn.setBackground(Color.WHITE);
		load_btn.setForeground(Color.BLACK);
		
		func.add(list_btn);
		list_btn.setBackground(Color.WHITE);
		list_btn.setForeground(Color.BLACK);
		
		func.add(favorite_btn);
		favorite_btn.setBackground(Color.WHITE);
		favorite_btn.setForeground(Color.BLACK);
		
		func.add(Volume);
		Volume.setBackground(Color.WHITE);
		Volume.setForeground(Color.BLACK);
		
		MainFrame.main.add(func, BorderLayout.SOUTH);
	}
	public void loadFunc(boolean b) {
		load(b);
	}
}
