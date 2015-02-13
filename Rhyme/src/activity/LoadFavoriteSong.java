package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import design.FunctionDock;

public class LoadFavoriteSong implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		/* Favorite Song lists */
		FunctionDock.play_list.showList();
	}
}