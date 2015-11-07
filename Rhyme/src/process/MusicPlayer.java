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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import design.AlbumArt;
import design.SongInfo;

@SuppressWarnings("serial")
final public class MusicPlayer extends JFrame {
	public static MusicPlayer rhyme;
	public static SongInfo songInfo_panel;
	public static MusicController control_panel; // Previous, Play, Pause, Resume, Next
	public static FunctionDock dock_panel; // Items Dock as Add Item, Repeat
	public static ListPanel songList_panel;
	public static AlbumArt albumArt; // Get , Set AlbumArt from Music
	public static JFileChooser browser; // File Browser
	public static Mp3Player playInstance; // Play Instance for mp3 extension
	public static ArrayList<String> songList = new ArrayList<String>();
	private JButton minimizeBtn; 
	private JButton closeBtn;
	private JButton expandBtn;
	public static JScrollPane songList_scrollBar;
	private JPanel dragArea=new JPanel();
	public static int songQueue = 0; // limited to 150
	public static boolean isChanged = false; // notify no need to changing for continuous play
	public static boolean isRepeating = false;
	public static boolean hasSongList = false;
	public static boolean isFlowing = true;
	public static boolean allowChange = true;
	public static boolean skip = false;
	static Point mouseDownCompCoords; // It tracks mouse

	public static JPanel paint_titleArea;
	public static JPanel paint_controlArea;
	public static JPanel paint_dockArea;
	public static JPanel paint_frame;
	public static int colorCode=0;
	
	final private int default_height=193;
	
	public MusicPlayer() {
		mouseDownCompCoords = null; // Initialize Mouse Tracker
		setLayout(new BorderLayout());
		setSize(350, 193);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* Exit_on_close = exit all jframe , Dispose_on_close = exit only this */

		setResizable(false); // Not allow to spoil Design
		setUndecorated(true); // Do not show OS specific frame
		setLocationRelativeTo(null); /* make it locate center */

		// Enabling Mouse Button Tracking
		dragArea.addMouseListener(new MouseListener() {
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
		// Enabling Dragging Position Tracking
		dragArea.addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {
			}

			public void mouseDragged(MouseEvent e) {
				Point currCoords = e.getLocationOnScreen();
				rhyme.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y
						- mouseDownCompCoords.y);
			}
		});
		
		add(buildContentPane()); /* load Compositions */
	}

	private void makeCompositions() {

		/* Panel */
		songInfo_panel = new SongInfo();
		control_panel = new MusicController();
		dock_panel = new FunctionDock();

		/* Lists */
		songList_panel = new ListPanel();

		/* Album Art */
		albumArt = new AlbumArt();

		/* Paints */
		paint_titleArea = paint(new Color(45,137,239)); // Metro Blue
		paint_controlArea = paint(new Color(45,137,239));
		paint_dockArea = paint(new Color(45,137,239));
		paint_frame = paint(new Color(255,255,255)); // White
		
		paint_titleArea = paint(new Color(126,56,120)); // Purple
		paint_controlArea = paint(new Color(126,56,120));
		paint_dockArea = paint(new Color(126,56,120));

		paint_titleArea = paint(new Color(30,113,69)); // Dark Green
		paint_controlArea = paint(new Color(30,113,69));
		paint_dockArea = paint(new Color(30,113,69));
		
		/* File Browser Setting */
		browser = new JFileChooser();
		FileFilter songFilter = new FileNameExtensionFilter("Music File",
				"mp3", "wav"); // 'showing name' , 'extensions .... '
		browser.addChoosableFileFilter(songFilter);
		browser.setFileFilter(songFilter); // make own filter to default
		browser.setMultiSelectionEnabled(true); // but can't use drag ... only shift key
		browser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		/* Icons of Title */
		final URL icon_mini = getClass().getResource("/images/icons/mini.png");
		minimizeBtn = new JButton(new ImageIcon(icon_mini));
		minimizeBtn.addActionListener(new MinimizeAction());
		minimizeBtn.setBorder(null);
		minimizeBtn.setFocusable(false);
		minimizeBtn.setContentAreaFilled(false);

		final URL icon_close = getClass().getResource("/images/icons/close.png");
		closeBtn = new JButton(new ImageIcon(icon_close));
		closeBtn.addActionListener(new CloseAction());
		closeBtn.setBorder(null);
		closeBtn.setFocusable(false);
		closeBtn.setContentAreaFilled(false);
		

		final URL icon_expand = getClass().getResource("/images/icons/expand.png");
		expandBtn = new JButton(new ImageIcon(icon_expand));
		expandBtn.setBorder(null);
		expandBtn.setFocusable(false);
		expandBtn.setContentAreaFilled(false);
		expandBtn.addActionListener(new expandBtnAction());
		
		songList_scrollBar=new JScrollPane(songList_panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		dragArea.setOpaque(false);
	}

	private JComponent buildContentPane() {
		JLayeredPane design = new JLayeredPane();
		makeCompositions();

		/* Set position & size (x, y, width, height) */
		dragArea.setBounds(1,1,348,25);
		paint_frame.setBounds(0, 0, 350, 400);
		paint_titleArea.setBounds(1,1,348,25);
		paint_controlArea.setBounds(126, 27, 223, 125);
		paint_dockArea.setBounds(1, 152, 348, 40);
		minimizeBtn.setBounds(286, 3, 21, 21);
		expandBtn.setBounds(307,3,21,21);
		closeBtn.setBounds(328, 3, 21, 21);
		albumArt.setBounds(1, 27, 124, 124);
		songInfo_panel.setBounds(126, 42, 223, 40);
		control_panel.setBounds(126, 97, 223, 50);
		dock_panel.setBounds(1, 152, 348, 40);
		songList_panel.setBounds(1, 193, 348, 206);
		songList_scrollBar.setBounds(1, 193, 348, 206);


//		Lower loading is top , Higher is bottom 
		design.add(minimizeBtn);
		design.add(expandBtn);
		design.add(closeBtn);
		design.add(dragArea);
		design.add(paint_titleArea);
		design.add(albumArt);
		design.add(songInfo_panel);
		design.add(control_panel);
		design.add(paint_controlArea);
		design.add(dock_panel);
		design.add(paint_dockArea);
		design.add(songList_panel);
		design.add(songList_scrollBar);
		design.add(paint_frame);
		return design;
	}	

	public static void main(String[] args) throws Exception {
		/* OS Specific Design at File Browsing */
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		// make instance
		rhyme = new MusicPlayer();
		rhyme.setVisible(true);
	}

	public JPanel paint(Color c) {
		JPanel paint = new JPanel();
		paint.setBackground(c);
		return paint;
	}

	class MinimizeAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setExtendedState(ICONIFIED);
		}
	}

	class CloseAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (playInstance != null) {
				playInstance.exit(); 
			}
			dispose();
		}
	}
	class expandBtnAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(MusicPlayer.rhyme.getHeight()!=default_height)
				MusicPlayer.rhyme.setSize(350,193);
			else 
				MusicPlayer.rhyme.setSize(350,400);
		}
	}
}