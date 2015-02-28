/*
 * Author : SooMan
 * Edited by Duckho
 */
package design;

import java.awt.Dimension;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import activity.VolumeControl;

@SuppressWarnings("serial")
public class VolumeBar extends JSlider {
	VolumeControl vc=new VolumeControl();
	public VolumeBar() {
		setOrientation(JSlider.VERTICAL);
		setMinimum(0);
		setMaximum(100);
		setValue(1);
		setFocusable(false);
		setOpaque(false);
		setPreferredSize(new Dimension(10, 170));
		setVisible(true);
		addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider src = (JSlider) e.getSource();
				// if (src.getValueIsAdjusting()) return; //optional
				if (src.getValue() % 5 != 0)
					return;
				float value = src.getValue() / 100.0f;
				try {
					vc.getVolumeControl().setValue(value);
					// you can put a click play code here to have nice feedback
					// when moving slider
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

		// and this is for getting the value
		try {
			setValue((int) (vc.getVolumeControl().getValue() * 100.0f));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}