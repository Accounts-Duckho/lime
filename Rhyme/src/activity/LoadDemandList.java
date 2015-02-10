package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import design.FunctionDock;

public class LoadDemandList implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		/* List of songs */
		FunctionDock.demand_list.showList();
	}
}