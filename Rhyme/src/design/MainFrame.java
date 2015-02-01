package design;

import java.awt.*;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 7526472295622776147L;
	private boolean initialized = false;
	/* commands to show frame */
	public void initialize() {
		initializeGui();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	/* Exit_on_close = exit all jframe , Dispose_on_close = exit only this */
	}
	/* make frame */
	private void initializeGui() {
		if (initialized) {
			return;
		}
		initialized = true;
		// MainFrame Size 
		this.setSize(250, 250);
		Dimension windowSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// Make screen position center 
		this.setLocation(screenSize.width / 2 - windowSize.width / 2,
				screenSize.height / 2 - windowSize.height / 2);
	}
	/* Hide and Show */
	public void setVisible(boolean b) {
		initialize();
		// use Jframe method with super keyword
		super.setVisible(b);
	}
	/* For test this and show how to load method */
	public static void main(String[] args) {
		new MainFrame().setVisible(true);
	}
}