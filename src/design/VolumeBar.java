/*
 * Author : SooMan
 * Edited by Duckho
 */
package design;

import java.awt.Dimension;

import javax.swing.JSlider;

@SuppressWarnings("serial")
public class VolumeBar extends JSlider {
	public VolumeBar() {
		setOrientation(JSlider.HORIZONTAL);
		setMinimum(0);
		setMaximum(10);
		setValue(1);
		setFocusable(false);
		setOpaque(false);
		setPreferredSize(new Dimension(100, 10));
		setVisible(true);
	}
}