/*
 *  Made by PI
 */
package process;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import activity.ReEncoder;
import design.Background;
import design.FunctionDock;
import design.MusicController;
import design.SongInfo;
import design.VolumeBar;

@SuppressWarnings("serial")
final public class MusicPlayer extends JFrame {
	public static SongInfo info_panel;
	public static MusicController ctr_panel;
	public static FunctionDock dock_panel;
	public static VolumeBar volume_bar;
	public static Background background;
	public static JProgressBar progress_bar;
	public static JFileChooser browser;
	private JButton fix_btn; // It fixes hangul encode error 
	private JPanel filter;

	public MusicPlayer() {
		super("LimE");
		setLayout(new BorderLayout());
		setSize(250, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* Exit_on_close = exit all jframe , Dispose_on_close = exit only this */

		setResizable(false);
		setLocationRelativeTo(null); /* make the frame locate center */
		add(buildContentPane()); /* load Contents */
	}

	private void makeContents() {
		/* Volume Bar */
		volume_bar=new VolumeBar();
		
		/* Panel */
		info_panel = new SongInfo();
		ctr_panel = new MusicController();
		dock_panel = new FunctionDock();
		
		/* UI envset for Progress Bar */
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			UIManager.getLookAndFeelDefaults().put("defaultFont",  new Font(Font.SANS_SERIF, 0, 10));
		} catch (Exception e) { e.printStackTrace(); }
		
		
		/* Progress Bar */
		progress_bar = new JProgressBar(0,100); // (first, end); endline will be changed to music length
		progress_bar.setValue(30); // start position
		progress_bar.setStringPainted(true);
		progress_bar.setString("3:14"); // sample string
		progress_bar.setFocusable(false);
		
		/* UI change for File Browser */
        try {
        UIManager.setLookAndFeel(
       		    "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        
        } catch (Exception e) { }  
		
		/* and so on */
		background=new Background();
		
		final URL icon_refresh = getClass().getResource("/images/icons/refresh.png");
		fix_btn = new JButton(new ImageIcon(icon_refresh));
		fix_btn.addActionListener(new ReEncoder());
		fix_btn.setBorder(null);
		fix_btn.setFocusable(false);
		fix_btn.setContentAreaFilled(false);
		
		filter = new JPanel();
		filter.setBackground(new Color(255,255,255,150));
		
		/* File Browser Setting */
		browser = new JFileChooser();
		FileFilter songFilter = new FileNameExtensionFilter("Music File", "mp3",
					"wav", "m4a"); // 'showing name' , 'extensions .... ' ,,,, 
		browser.addChoosableFileFilter(songFilter);
		browser.setFileFilter(songFilter); // make own filter to default		
	}

	private JComponent buildContentPane() {
		JLayeredPane combo = new JLayeredPane();
		makeContents();
		/* Set	position & size (x, y ,width, height) */
		info_panel.setBounds(0,5,250,30);
		fix_btn.setBounds(180,75,20,20);
		progress_bar.setBounds(25,40,200,15);
		ctr_panel.setBounds(0,75,250,100);
		dock_panel.setBounds(55,180,120,50);		
		volume_bar.setBounds(175,200,70,10);
		background.setBounds(0, 0, 250, 250);
		filter.setBounds(0,0,250,250);
		/* Lower loading is top , Higher is bottom */
		/* but I don't know exactly about the number */
		combo.add(info_panel, 1);
		combo.add(fix_btn, 2);
		combo.add(progress_bar, 3);
		combo.add(ctr_panel, 4);
		combo.add(dock_panel, 5);
		combo.add(volume_bar, 6);
		combo.add(filter, 7);
		combo.add(background, 8);
		return combo;
	}
	
	public static void main(String[] args) {
		/* Default UI is windows */
        try {
        UIManager.setLookAndFeel(
       		    "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        
        } catch (Exception e) { }  
        new MusicPlayer().setVisible(true);
	}
}