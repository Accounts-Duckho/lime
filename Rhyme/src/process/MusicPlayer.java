/*
 *  Made by PI
 */
package process;

import java.awt.BorderLayout;
import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

import design.FunctionDock;
import design.MusicController;
import design.ProgressBarUI;
import design.SongInfo;

@SuppressWarnings("serial")
final public class MusicPlayer extends JFrame {
	public static SongInfo info_panel;
	public static MusicController ctr_panel;
	public static FunctionDock dock_panel;
	private JLabel background;
	private JProgressBar bar;

	public MusicPlayer() {
		super("LimE");
		setLayout(new BorderLayout());
		setSize(250, 250);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setUndecorated(true); -> It disables window frame 
		/* Exit_on_close = exit all jframe , Dispose_on_close = exit only this */

		setLocationRelativeTo(null); /* make the frame locate center */
		add(buildContentPane()); /* set Contents */
	}

	private void makeContents() {
		/* Panel */
		info_panel = new SongInfo();
		ctr_panel = new MusicController();
		dock_panel = new FunctionDock();
		
		/* Progress Bar */
		bar = createBar(0,100);
		bar.setValue(0);
		bar.setBackground(new Color(0, 0, 0, 255));
		bar.setBorderPainted(false);
		bar.setUI(new ProgressBarUI());
		
		/* Background label*/
        final URL path = getClass().getResource("/images/background/lime2.png");
		background = new JLabel(new ImageIcon(path));
	}

	private JComponent buildContentPane() {
		JLayeredPane pane = new JLayeredPane();
		pane.setOpaque(false);
		makeContents();
		info_panel.setBounds(0,5,250,45);
		bar.setBounds(25,45,200,5);
		ctr_panel.setBounds(0,50,250,140);
		dock_panel.setBounds(0,190,250,50);		
		background.setBounds(0, 0, 250, 250);
		
		/* 4th -> 3th -> 2th -> 1th */
		/* but I don't know exactly about the number */
		pane.add(info_panel, 1);
		pane.add(bar, 2);
		pane.add(ctr_panel, 3);
		pane.add(dock_panel, 4);
		pane.add(background, 5);
		return pane;
	}
	public static void main(String[] args) {
        try{
        UIManager.setLookAndFeel(
       		    "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        
        } catch (Exception e) {
          System.out.println("failed to load windows look and feel");
          }  
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MusicPlayer().setVisible(true);
			}
		});
	}
	private JProgressBar createBar(int start, int endline) {
		JProgressBar bar = new JProgressBar(start, endline);
		return bar;
	}
}