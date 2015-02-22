package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Repeat implements ActionListener {
	private boolean clicked = false;
	public void actionPerformed(ActionEvent e) {
		if(clicked)
			clicked=false;
		else
			clicked=true;
			OnOff.repeat=clicked;
	}
}