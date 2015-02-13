/*
 *  Made by PI
 */
package process;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Painter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
	private JButton fix_btn;
	public static Image bg;
	private JProgressBar bar;

	public MusicPlayer() {
		super("LimE");
		setLayout(new BorderLayout());
		setSize(250, 250);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setUndecorated(true); //-> It disables window frame 
		/* Exit_on_close = exit all jframe , Dispose_on_close = exit only this */

		setLocationRelativeTo(null); /* make the frame locate center */
		add(buildContentPane()); /* set Contents */
	}

	private void makeContents() {
		/* Panel */
		info_panel = new SongInfo();
		ctr_panel = new MusicController();
		dock_panel = new FunctionDock();
		volume_bar=new VolumeBar();
		background=new Background();
		fix_btn = new JButton();
		fix_btn.addActionListener(new ReEncoder());
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UIManager.getLookAndFeelDefaults().put("defaultFont",  new Font(Font.SANS_SERIF, 0, 10));
		bar = new JProgressBar(0,100);
		bar.setValue(78);
		bar.setStringPainted(true);
		bar.setString("3:14"); // sample string
		bar.setFocusable(false);
//		bar.setIndeterminate(true); 
		
		/* Background label*/
	}

	private JComponent buildContentPane() {
		JLayeredPane pane = new JLayeredPane();
		pane.setOpaque(false);
		makeContents();
		info_panel.setBounds(0,5,250,45);
		fix_btn.setBounds(200,5,30,30);
		bar.setBounds(25,40,200,15);
		ctr_panel.setBounds(0,60,250,130);
		dock_panel.setBounds(55,180,120,50);		
		volume_bar.setBounds(175,200,70,10);
		background.setBounds(0, 0, 250, 250);
		JPanel filter = new JPanel();
		filter.setBackground(new Color(255,255,255,150));
		filter.setBounds(0,0,250,250);
		/* 4th -> 3th -> 2th -> 1th */
		/* but I don't know exactly about the number */
		pane.add(info_panel, 1);
		pane.add(fix_btn, 2);
		pane.add(bar, 3);
		pane.add(ctr_panel, 4);
		pane.add(dock_panel, 5);
		pane.add(volume_bar, 6);
		pane.add(filter, 7);
		pane.add(background, 8);
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
}
class MyPainter implements Painter<JProgressBar> {

    private final Color color;

    public MyPainter(Color c1) {
        this.color = c1;
    }
    @Override
    public void paint(Graphics2D gd, JProgressBar t, int width, int height) {
        gd.setColor(color);
        gd.fillRect(0, 0, width, height);
    }
}