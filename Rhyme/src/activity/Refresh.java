package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import process.Update;

public class Refresh implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		try {
			Update.SongList();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}