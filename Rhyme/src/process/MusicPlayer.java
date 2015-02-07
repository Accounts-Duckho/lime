/*
 *  Made by PI
 */
package process;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import activity.ControllVolume;
import activity.LoadFavoriteSong;
import activity.LoadSong;
import activity.LoadSongList;
import activity.Pause;
import activity.Play;
import design.FunctionDock;
import design.MusicController;
import design.SongInfo;
@SuppressWarnings("serial")
final public class MusicPlayer extends JFrame {
	public static SongInfo info_panel;
	public static MusicController ctr_panel;
	public static FunctionDock dock_panel;
	public MusicPlayer() {
		super("LimE");
		setSize(250, 250);
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Exit_on_close = exit all jframe , Dispose_on_close = exit only this */

		Dimension windowSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenCenter_x = screenSize.width / 2 - windowSize.width / 2;
		int screenCenter_y = screenSize.height / 2 - windowSize.height / 2;
		setLocation(screenCenter_x, screenCenter_y);
	}

	private void applyDesign() {
		addPanel();
	}

	private void addPanel() {
		info_panel=new SongInfo();
		info_panel.loadInfoPanel(false);
		ctr_panel=new MusicController();
		ctr_panel.getAction(null, null, new Play(), new Pause());
		ctr_panel.loadCtrPanel();
		dock_panel=new FunctionDock();
		dock_panel.getAction(new LoadSong(), new LoadSongList(),
				new LoadFavoriteSong(), new ControllVolume());
		dock_panel.loadDock();
			/* add */
			this.add(info_panel, BorderLayout.NORTH);
			this.add(ctr_panel, BorderLayout.CENTER);
			this.add(dock_panel, BorderLayout.SOUTH);
		}

	private void showMetheLime() {
		applyDesign();
		super.setVisible(true);
	}

	public static void main(String[] args) {
		new MusicPlayer().showMetheLime();
	}
}
