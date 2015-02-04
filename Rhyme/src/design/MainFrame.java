/*
 * This is made by duckho
 */
package design;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame {

    public static JFrame main = new JFrame();
    private boolean initialized = false;
    /* commands to show frame */

    public void initialize() {
        initializeGui();
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setResizable(false); // Don't allow resizing window to preserve ui
	/* Exit_on_close = exit all jframe , Dispose_on_close = exit only this */
    }
    /* make frame */

    private void initializeGui() {
        if (initialized) {
            return;
        }
        initialized = true;
        // MainFrame Size 
        main.setSize(250, 250);
        main.setLayout(new BorderLayout()); // use East, North, West, South, Center 
        main.setTitle("LimE");
        Dimension windowSize = main.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Make screen position center 
        main.setLocation(screenSize.width / 2 - windowSize.width / 2,
                screenSize.height / 2 - windowSize.height / 2);
    }
    /* Hide and Show */

    public void setVisible(boolean b) {
        initialize();
        main.setVisible(b);
    }
    /* For test this and show how to load method */

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
        new SongInfo().loadSongInfo(true);
        new ControllMusic().loadCtrMusic(true);
        new Function().loadFunc(true); // load before ctrvol
        new ControllVolume().loadCtrVolume(true);
    }
}
