/*
 *  Author : Duckho 
 */
package design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private boolean initialized = false;

	/* commands to show frame */

	public void initialize() {
		initializeGui();
		/* Exit_on_close = exit all jframe , Dispose_on_close = exit only this */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Don't allow resizing window to preserve ui
		this.setResizable(false); 
	}

	/* make frame */

	private void initializeGui() {
		if (initialized) {
			return;
		}
		initialized = true;
		
		SongInfo info=new SongInfo();
		ControllMusic cm=new ControllMusic();
		Function f=new Function();
		
		// MainFrame Size
		this.setSize(250, 250);
		this.setLayout(new BorderLayout()); // use East, North, West, South,
											// Center
		this.setTitle("LimE");
		Dimension windowSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		// Make screen position center
		this.setLocation(screenSize.width / 2 - windowSize.width / 2,
				screenSize.height / 2 - windowSize.height / 2);
		
		/* load */
		info.loadSongInfo(true);
		cm.loadCtrMusic(true);
		f.loadFunc(true);
		
		/* add */
		this.add(info, BorderLayout.NORTH);
		this.add(cm, BorderLayout.CENTER);
		this.add(f, BorderLayout.SOUTH);
		
	}

	/* Hide and Show */

	public void setVisible(boolean b) {
		initialize();
		super.setVisible(b);
	}

	/* This for test */

	public static void main(String[] args) {
		new MainFrame().setVisible(true);
		new ControllVolume().loadCtrVolume(true);
	}
}
