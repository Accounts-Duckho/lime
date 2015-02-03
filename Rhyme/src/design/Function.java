package design;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Function {
	private void load(boolean b) {
		/* for the test */
		JPanel func = new JPanel();
		JButton function = new JButton("Function Area");
		func.add(function);
		func.setPreferredSize(new Dimension(120, 30));
		function.setBackground(Color.WHITE);
		function.setForeground(Color.BLACK);
		MainFrame.main.add(func);
	}
	public void loadFunc(boolean b) {
		load(b);
	}
}

// It would be perfect by JungSang ~~