/*
 *  Made by PI
 */
package process;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import design.AlbumArt;
import design.SongInfo;
import design.VolumeBar;

@SuppressWarnings("serial")
final public class MusicPlayer extends JFrame {
//	Resources
	public static SongInfo info_panel; // Notify SongInfo to user 
	public static MusicController ctr_panel; // Music Contoroller -> Previous, Play, Pause, Resume, Next 
	public static FunctionDock dock_panel; // Items Dock as Add Item, Two Lists, and so on
	public static VolumeBar volume_bar; // Volume Slider which position will be sound level
	public static AlbumArt albumArt; // Get , Set AlbumArt from Music  
	public static JFileChooser browser; // File Browser
	public static Mp3Player play_mp3; // Play Instance for mp3 extension
	public static DemandList demand_list; // When Opened this player , create , Until Exit, saved at ram
	public static PlayList play_list; // When Opened this player , load data , When Exit, save data
	public static ArrayList<String> list = new ArrayList<String>();
	private JButton minimiseBtn; // remove screen still playing
	private JButton closeBtn; // Exit This Program
	public static int queue=0; // Songs Order , 0~N ( N < 100 ) limited to 100 songs
	public static boolean changed=false; // When GoNext , GoPrevious or Play at demand list , false -> true , to notify no need to changing 
	static Point mouseDownCompCoords; // I don't know , but It tracks mouse

	private JPanel paint_w; // White Square to painting
	private JPanel paint_g; // Grey Square to painting

	public MusicPlayer() {
		mouseDownCompCoords = null;
		setLayout(new BorderLayout());
		setSize(350, 172); // ( width, height )
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* Exit_on_close = exit all jframe , Dispose_on_close = exit only this */

		setResizable(false); // Not allow to spoil Design
		setUndecorated(true); // Do not show OS specific frame
		setLocationRelativeTo(null); /* make it locate center */
		add(buildContentPane()); /* load Contents */
		
		// Enabling Mouse Button Tracking
		addMouseListener(new MouseListener(){
            public void mouseReleased(MouseEvent e) {
                mouseDownCompCoords = null;
            }
            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords = e.getPoint();
            }
            public void mouseExited(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {
            }
            public void mouseClicked(MouseEvent e) {
            }
        });
		// Enabling Draging Position Tracking
		addMouseMotionListener(new MouseMotionListener(){
            public void mouseMoved(MouseEvent e) {
            }
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
            }
        });
	}
	private void makeContents() {

		/* Volume Bar */
		volume_bar = new VolumeBar();

		/* Panel */
		info_panel = new SongInfo();
		ctr_panel = new MusicController();	
		dock_panel = new FunctionDock();
		
		/* Lists */
		demand_list = new DemandList(100);
		play_list = new PlayList();

		/* Album Art */
		albumArt = new AlbumArt();

		/* Paints */
		paint_w = new JPanel();
		paint_w.setBackground(new Color(255, 255, 255)); 
		
		paint_g = new JPanel();
		paint_g.setBackground(new Color(179, 179, 179));

		/* File Browser Setting */
		browser = new JFileChooser();
		FileFilter songFilter = new FileNameExtensionFilter("Music File",
				"mp3", "wav"); // 'showing name' , 'extensions .... '
										// ,,,,
		browser.addChoosableFileFilter(songFilter);
		browser.setFileFilter(songFilter); // make own filter to default
		browser.setMultiSelectionEnabled(true); // but can't use drag ... 
		browser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // can select file or dir
		
		/* Icons _ minimize / close */
		final URL icon_mini = getClass().getResource("/images/icons/mini.png");
		minimiseBtn = new JButton(new ImageIcon(icon_mini));
		minimiseBtn.addActionListener(new MinimizeAction());
		
		minimiseBtn.setBorder(null);
		minimiseBtn.setFocusable(false);
		minimiseBtn.setContentAreaFilled(false);
		
		final URL icon_close = getClass().getResource("/images/icons/close.png");
		closeBtn = new JButton(new ImageIcon(icon_close));
		closeBtn.addActionListener(new CloseAction());
		
		closeBtn.setBorder(null);
		closeBtn.setFocusable(false);
		closeBtn.setContentAreaFilled(false);
	}

	private JComponent buildContentPane() {
		JLayeredPane combo = new JLayeredPane();
		/* Actually build process is almost done at this */
		makeContents();
		
		/* Set position & size (x, y, width, height) */
		albumArt.setBounds(1, 1, 170, 170);
		info_panel.setBounds(172, 31, 168, 50);
		minimiseBtn.setBounds(310,0,20,20);
		closeBtn.setBounds(330,0,20,20);
		ctr_panel.setBounds(172, 81, 168, 70);
		dock_panel.setBounds(172, 151, 168, 20);
		volume_bar.setBounds(339, 22, 10, 149);
		paint_g.setBounds(0, 0, 350, 172);
		paint_w.setBounds(172, 1, 177, 170);
		
		/* Lower loading is top , Higher is bottom 
		   but I don't know exactly about the number */
		combo.add(albumArt, 1);
		combo.add(info_panel, 2);
		combo.add(minimiseBtn, 3);
		combo.add(closeBtn, 4);
		combo.add(ctr_panel, 5);
		combo.add(dock_panel, 6);
		combo.add(volume_bar, 7);
		combo.add(paint_w, 8);
		combo.add(paint_g, 9);
		return combo;
	}

	public static void main(String[] args) throws Exception 
		{
		/* Default UI is windows */
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// make and visible
		new MusicPlayer().setVisible(true); 	
		}
	
    class MinimizeAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
    		setExtendedState(ICONIFIED);
    	}
    }
    
    class CloseAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(play_mp3!=null) {
        		play_mp3.exit(); }
            dispose();
        }
    }
}