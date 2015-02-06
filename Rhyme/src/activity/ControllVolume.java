package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import design.VolumeBar;

public class ControllVolume implements ActionListener {
	VolumeBar bar = new VolumeBar();
	public void actionPerformed(ActionEvent e) {
			bar.loadVolumeBar();
	}
}