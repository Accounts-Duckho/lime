/*
 * Author : JungSang
 * Edited by Duckho
 */
package process;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import action.Get;
import action.Set;

@SuppressWarnings("serial")
public class FunctionDock extends JPanel {
	private JButton loadBtn;
	private JButton repeatBtn;
	
	private JButton lightGreenBtn;
	private JButton greenBtn;
	private JButton darkGreenBtn;
	private JButton magentaBtn;
	private JButton lightPurpleBtn;
	private JButton purpleBtn;
	private JButton darkPurpleBtn;
	private JButton darkenBtn;
	private JButton tealBtn;
	private JButton blueBtn;
	private JButton darkBlueBtn;
	private JButton yellowBtn;
	private JButton darkOrangeBtn;
	private JButton redBtn;
	private JButton darkRedBtn;
	/* Icon Load */
	final URL icon_load = getClass().getResource("/images/icons/load.png");
	final URL icon_repeat = getClass().getResource("/images/icons/repeat.png");
	final URL icon_repeat_clicked = getClass().getResource("/images/icons/repeat_clicked.png");
	final URL icon_lightGreen = getClass().getResource("/images/colors/lightgreen.png");
	final URL icon_green = getClass().getResource("/images/colors/green.png");
	final URL icon_darkGreen = getClass().getResource("/images/colors/darkgreen.png");
	final URL icon_magenta = getClass().getResource("/images/colors/magenta.png");
	final URL icon_lightPurple = getClass().getResource("/images/colors/lightpurple.png");
	final URL icon_purple = getClass().getResource("/images/colors/purple.png");
	final URL icon_darkPurple = getClass().getResource("/images/colors/darkpurple.png");
	final URL icon_darken = getClass().getResource("/images/colors/darken.png");
	final URL icon_teal = getClass().getResource("/images/colors/teal.png");
	final URL icon_blue = getClass().getResource("/images/colors/blue.png");
	final URL icon_darkBlue = getClass().getResource("/images/colors/darkblue.png");
	final URL icon_yellow = getClass().getResource("/images/colors/yellow.png");
	final URL icon_darkOrange = getClass().getResource("/images/colors/darkorange.png");
	final URL icon_red = getClass().getResource("/images/colors/red.png");
	final URL icon_darkRed = getClass().getResource("/images/colors/darkred.png");

	public FunctionDock() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		makePanel();
		setOpaque(false); // transparent option : false is actually true
	}

	private void makePanel() {
		/* Make Button with Icon */
		loadBtn = new JButton(new ImageIcon(icon_load));
		loadBtn.setBorder(null);
		loadBtn.setFocusable(false);
		loadBtn.setContentAreaFilled(false);
		loadBtn.addActionListener(new LoadBtnAction());
		loadBtn.setMaximumSize(new Dimension(20, 20));

		repeatBtn = new JButton(new ImageIcon(icon_repeat));
		repeatBtn.setBorder(null);
		repeatBtn.setFocusable(false);
		repeatBtn.setContentAreaFilled(false);
		repeatBtn.setMaximumSize(new Dimension(20, 20));
		repeatBtn.addActionListener(new repeatBtnAction());
		
		lightGreenBtn = new JButton(new ImageIcon(icon_lightGreen));
		lightGreenBtn.setBorder(null);
		lightGreenBtn.setFocusable(false);
		lightGreenBtn.setContentAreaFilled(false);
		lightGreenBtn.setMaximumSize(new Dimension(20, 20));
		lightGreenBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        setBackgroundColor(new Color(153,180,51));
		    }
		    public final void setBackgroundColor(Color background) 
		    { 
		    	MusicPlayer.paint_titleArea.setBackground(background); 
		    	MusicPlayer.paint_controlArea.setBackground(background);
		    	MusicPlayer.paint_dockArea.setBackground(background);
		    	MusicPlayer.rhyme.repaint();
		    } 
		});

		
		greenBtn = new JButton(new ImageIcon(icon_green));
		greenBtn.setBorder(null);
		greenBtn.setFocusable(false);
		greenBtn.setContentAreaFilled(false);
		greenBtn.setMaximumSize(new Dimension(20, 20));
		greenBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        setBackgroundColor(new Color(0,163,0));
		    }
		    public final void setBackgroundColor(Color background) 
		    { 
		    	MusicPlayer.paint_titleArea.setBackground(background); 
		    	MusicPlayer.paint_controlArea.setBackground(background);
		    	MusicPlayer.paint_dockArea.setBackground(background);
		    	MusicPlayer.rhyme.repaint();
		    } 
		});
		
		darkGreenBtn = new JButton(new ImageIcon(icon_darkGreen));
		darkGreenBtn.setBorder(null);
		darkGreenBtn.setFocusable(false);
		darkGreenBtn.setContentAreaFilled(false);
		darkGreenBtn.setMaximumSize(new Dimension(20, 20));
		darkGreenBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        setBackgroundColor(new Color(30,113,69));
		    }
		    public final void setBackgroundColor(Color background) 
		    { 
		    	MusicPlayer.paint_titleArea.setBackground(background); 
		    	MusicPlayer.paint_controlArea.setBackground(background);
		    	MusicPlayer.paint_dockArea.setBackground(background);
		    	MusicPlayer.rhyme.repaint();
		    } 
		});
		
		magentaBtn = new JButton(new ImageIcon(icon_magenta));
		magentaBtn.setBorder(null);
		magentaBtn.setFocusable(false);
		magentaBtn.setContentAreaFilled(false);
		magentaBtn.setMaximumSize(new Dimension(20, 20));
		magentaBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        setBackgroundColor(new Color(255,0,151));
		    }
		    public final void setBackgroundColor(Color background) 
		    { 
		    	MusicPlayer.paint_titleArea.setBackground(background); 
		    	MusicPlayer.paint_controlArea.setBackground(background);
		    	MusicPlayer.paint_dockArea.setBackground(background);
		    	MusicPlayer.rhyme.repaint();
		    } 
		});
		
		lightPurpleBtn = new JButton(new ImageIcon(icon_lightPurple));
		lightPurpleBtn.setBorder(null);
		lightPurpleBtn.setFocusable(false);
		lightPurpleBtn.setContentAreaFilled(false);
		lightPurpleBtn.setMaximumSize(new Dimension(20, 20));
		lightPurpleBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        setBackgroundColor(new Color(159,0,167));
		    }
		    public final void setBackgroundColor(Color background) 
		    { 
		    	MusicPlayer.paint_titleArea.setBackground(background); 
		    	MusicPlayer.paint_controlArea.setBackground(background);
		    	MusicPlayer.paint_dockArea.setBackground(background);
		    	MusicPlayer.rhyme.repaint();
		    } 
		});
		
		purpleBtn = new JButton(new ImageIcon(icon_purple));
		purpleBtn.setBorder(null);
		purpleBtn.setFocusable(false);
		purpleBtn.setContentAreaFilled(false);
		purpleBtn.setMaximumSize(new Dimension(20, 20));
		purpleBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        setBackgroundColor(new Color(126,56,120));
		    }
		    public final void setBackgroundColor(Color background) 
		    { 
		    	MusicPlayer.paint_titleArea.setBackground(background); 
		    	MusicPlayer.paint_controlArea.setBackground(background);
		    	MusicPlayer.paint_dockArea.setBackground(background);
		    	MusicPlayer.rhyme.repaint();
		    } 
		});
		
		darkPurpleBtn = new JButton(new ImageIcon(icon_darkPurple));
		darkPurpleBtn.setBorder(null);
		darkPurpleBtn.setFocusable(false);
		darkPurpleBtn.setContentAreaFilled(false);
		darkPurpleBtn.setMaximumSize(new Dimension(20, 20));
		darkPurpleBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        setBackgroundColor(new Color(96,60,186));
		    }
		    public final void setBackgroundColor(Color background) 
		    { 
		    	MusicPlayer.paint_titleArea.setBackground(background); 
		    	MusicPlayer.paint_controlArea.setBackground(background);
		    	MusicPlayer.paint_dockArea.setBackground(background);
		    	MusicPlayer.rhyme.repaint();
		    } 
		});
		
		darkenBtn = new JButton(new ImageIcon(icon_darken));
		darkenBtn.setBorder(null);
		darkenBtn.setFocusable(false);
		darkenBtn.setContentAreaFilled(false);
		darkenBtn.setMaximumSize(new Dimension(20, 20));
		darkenBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        setBackgroundColor(new Color(29,29,29));
		    }
		    public final void setBackgroundColor(Color background) 
		    { 
		    	MusicPlayer.paint_titleArea.setBackground(background); 
		    	MusicPlayer.paint_controlArea.setBackground(background);
		    	MusicPlayer.paint_dockArea.setBackground(background);
		    	MusicPlayer.rhyme.repaint();
		    } 
		});
		
		tealBtn = new JButton(new ImageIcon(icon_teal));
		tealBtn.setBorder(null);
		tealBtn.setFocusable(false);
		tealBtn.setContentAreaFilled(false);
		tealBtn.setMaximumSize(new Dimension(20, 20));
		tealBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        setBackgroundColor(new Color(0,171,169));
		    }
		    public final void setBackgroundColor(Color background) 
		    { 
		    	MusicPlayer.paint_titleArea.setBackground(background); 
		    	MusicPlayer.paint_controlArea.setBackground(background);
		    	MusicPlayer.paint_dockArea.setBackground(background);
		    	MusicPlayer.rhyme.repaint();
		    } 
		});
		
		blueBtn = new JButton(new ImageIcon(icon_blue));
		blueBtn.setBorder(null);
		blueBtn.setFocusable(false);
		blueBtn.setContentAreaFilled(false);
		blueBtn.setMaximumSize(new Dimension(20, 20));
		blueBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        setBackgroundColor(new Color(45,137,239));
		    }
		    public final void setBackgroundColor(Color background) 
		    { 
		    	MusicPlayer.paint_titleArea.setBackground(background); 
		    	MusicPlayer.paint_controlArea.setBackground(background);
		    	MusicPlayer.paint_dockArea.setBackground(background);
		    	MusicPlayer.rhyme.repaint();
		    } 
		});
		
		darkBlueBtn = new JButton(new ImageIcon(icon_darkBlue));
		darkBlueBtn.setBorder(null);
		darkBlueBtn.setFocusable(false);
		darkBlueBtn.setContentAreaFilled(false);
		darkBlueBtn.setMaximumSize(new Dimension(20, 20));
		darkBlueBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        setBackgroundColor(new Color(43,87,151));
		    }
		    public final void setBackgroundColor(Color background) 
		    { 
		    	MusicPlayer.paint_titleArea.setBackground(background); 
		    	MusicPlayer.paint_controlArea.setBackground(background);
		    	MusicPlayer.paint_dockArea.setBackground(background);
		    	MusicPlayer.rhyme.repaint();
		    } 
		});
		
		yellowBtn = new JButton(new ImageIcon(icon_yellow));
		yellowBtn.setBorder(null);
		yellowBtn.setFocusable(false);
		yellowBtn.setContentAreaFilled(false);
		yellowBtn.setMaximumSize(new Dimension(20, 20));
		yellowBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        setBackgroundColor(new Color(255,196,13));
		    }
		    public final void setBackgroundColor(Color background) 
		    { 
		    	MusicPlayer.paint_titleArea.setBackground(background); 
		    	MusicPlayer.paint_controlArea.setBackground(background);
		    	MusicPlayer.paint_dockArea.setBackground(background);
		    	MusicPlayer.rhyme.repaint();
		    } 
		});
		
		darkOrangeBtn = new JButton(new ImageIcon(icon_darkOrange));
		darkOrangeBtn.setBorder(null);
		darkOrangeBtn.setFocusable(false);
		darkOrangeBtn.setContentAreaFilled(false);
		darkOrangeBtn.setMaximumSize(new Dimension(20, 20));
		darkOrangeBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        setBackgroundColor(new Color(218,83,44));
		    }
		    public final void setBackgroundColor(Color background) 
		    { 
		    	MusicPlayer.paint_titleArea.setBackground(background); 
		    	MusicPlayer.paint_controlArea.setBackground(background);
		    	MusicPlayer.paint_dockArea.setBackground(background);
		    	MusicPlayer.rhyme.repaint();
		    } 
		});
		
		redBtn = new JButton(new ImageIcon(icon_red));
		redBtn.setBorder(null);
		redBtn.setFocusable(false);
		redBtn.setContentAreaFilled(false);
		redBtn.setMaximumSize(new Dimension(20, 20));
		redBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        setBackgroundColor(new Color(238,17,17));
		    }
		    public final void setBackgroundColor(Color background) 
		    { 
		    	MusicPlayer.paint_titleArea.setBackground(background); 
		    	MusicPlayer.paint_controlArea.setBackground(background);
		    	MusicPlayer.paint_dockArea.setBackground(background);
		    	MusicPlayer.rhyme.repaint();
		    } 
		});

		darkRedBtn = new JButton(new ImageIcon(icon_darkRed));
		darkRedBtn.setBorder(null);
		darkRedBtn.setFocusable(false);
		darkRedBtn.setContentAreaFilled(false);
		darkRedBtn.setMaximumSize(new Dimension(20, 20));
		darkRedBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        setBackgroundColor(new Color(185,29,71));
		    }
		    public final void setBackgroundColor(Color background) 
		    { 
		    	MusicPlayer.paint_titleArea.setBackground(background); 
		    	MusicPlayer.paint_controlArea.setBackground(background);
		    	MusicPlayer.paint_dockArea.setBackground(background);
		    	MusicPlayer.rhyme.repaint();
		    } 
		});
		
		this.add(repeatBtn);
		this.add(loadBtn);
		this.add(lightGreenBtn);
		this.add(greenBtn);
		this.add(darkGreenBtn);
		this.add(magentaBtn);
		this.add(lightPurpleBtn);
		this.add(purpleBtn);
		this.add(darkPurpleBtn);
		this.add(darkenBtn);
		this.add(tealBtn);
		this.add(blueBtn);
		this.add(darkBlueBtn);
		this.add(yellowBtn);
		this.add(darkOrangeBtn);
		this.add(redBtn);
		this.add(darkRedBtn);
	}

	class LoadBtnAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Get get = new Get();
			get.song();
			Set set = new Set();
			set.song(get);
			MusicPlayer.songList_panel.refreshList();
		}
	}

	class repeatBtnAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			MusicPlayer.isRepeating = !MusicPlayer.isRepeating;
			if (MusicPlayer.isRepeating) {
				repeatBtn.setIcon(new ImageIcon(icon_repeat_clicked));
			} else {
				repeatBtn.setIcon(new ImageIcon(icon_repeat));

			}
		}
	}
}
