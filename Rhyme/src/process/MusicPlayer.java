/*
 *  Made by PI
 */
package process;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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

import activity.Mp3Player;
import design.Background;
import design.DemandList;
import design.FunctionDock;
import design.MusicController;
import design.PlayList;
import design.ProgressBar;
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
	public static Mp3Player mp3play;
	public static DemandList demand_list;
	public static PlayList play_list;
	private JButton minimiseBtn;
	private JButton closeBtn;
	public static int queue;
	public static boolean changed=false;
	static Point mouseDownCompCoords;

	private JPanel filter_w;
	private JPanel filter_g;

	public MusicPlayer() {
		// super("L. I. M. E"); decide title name
		mouseDownCompCoords = null;
		setLayout(new BorderLayout());
		setSize(350, 172);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* Exit_on_close = exit all jframe , Dispose_on_close = exit only this */

		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null); /* make the frame locate center */
		add(buildContentPane()); /* load Contents */
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

		
		/* Load List Once */
		demand_list = new DemandList();
		play_list = new PlayList();
		
		/* Volume Bar */
		volume_bar = new VolumeBar();

		/* Panel */
		info_panel = new SongInfo();
		ctr_panel = new MusicController();
		dock_panel = new FunctionDock();

		/* UI envset for Progress Bar */
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			UIManager.getLookAndFeelDefaults().put("defaultFont",
					new Font(Font.SANS_SERIF, 0, 10));
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Progress Bar */
		progress_bar = new JProgressBar(); // (first, end); endline will

			new ProgressBar(progress_bar);


		/* UI change for File Browser */
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		} catch (Exception e) {
		}

		/* Background */
		background = new Background();

		/* Filter */
		filter_w = new JPanel();
		filter_w.setBackground(new Color(255, 255, 255));
		filter_g = new JPanel();
		filter_g.setBackground(new Color(128, 128, 128));

		/* File Browser Setting */
		browser = new JFileChooser();
		FileFilter songFilter = new FileNameExtensionFilter("Music File",
				"mp3", "wav"); // 'showing name' , 'extensions .... '
										// ,,,,
		browser.addChoosableFileFilter(songFilter);
		browser.setFileFilter(songFilter); // make own filter to default
		browser.setMultiSelectionEnabled(true);
		browser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		minimiseBtn = new JButton();
		minimiseBtn.addActionListener(new MinimizeAction());
		
		closeBtn = new JButton();
		closeBtn.addActionListener(new CloseAction());
	}

	private JComponent buildContentPane() {
		JLayeredPane combo = new JLayeredPane();
		makeContents();
		/* Set position & size (x, y ,width, height) */
		background.setBounds(1, 1, 170, 170);
		info_panel.setBounds(172, 31, 168, 35);
		minimiseBtn.setBounds(310,0,20,20);
		closeBtn.setBounds(330,0,20,20);
		ctr_panel.setBounds(172, 81, 168, 70);
		dock_panel.setBounds(172, 151, 168, 20);
		volume_bar.setBounds(339, 22, 10, 149);
//		repeat_btn.setBounds(180,75,20,20);
//		fix_btn.setBounds(180, 105, 20, 20);
//		progress_bar.setBounds(15, 40, 200, 15);
		filter_g.setBounds(0, 0, 350, 172);
		filter_w.setBounds(1, 1, 348, 170);
		/* Lower loading is top , Higher is bottom */
		/* but I don't know exactly about the number */
		combo.add(background, 1);
		combo.add(info_panel, 2);
		combo.add(minimiseBtn, 3);
		combo.add(closeBtn, 4);
//		combo.add(repeat_btn, 2);
//		combo.add(fix_btn, 3);
//		combo.add(progress_bar, 4);
		combo.add(ctr_panel, 5);
		combo.add(dock_panel, 6);
		combo.add(volume_bar, 7);
		combo.add(filter_w, 8);
		combo.add(filter_g, 9);
		return combo;
	}

	public static void main(String[] args) {
		/* Default UI is windows */
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		} catch (Exception e) {
		}
		new MusicPlayer().setVisible(true);
	}
    class MinimizeAction implements ActionListener {
    	@Override
        public void actionPerformed(ActionEvent e) {
    		setExtendedState(ICONIFIED);
    	}
    }
    class CloseAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	if(mp3play!=null) {
        		mp3play.exit(); }
            dispose();
        }
    }
}