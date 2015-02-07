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
	public boolean reload=false;
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
		SongInfo info = new SongInfo();
		MusicController ctr_music = new MusicController();
		FunctionDock dock = new FunctionDock();
		if(reload) {			
			ctr_music.loadCtrMusic(true);
			this.add(ctr_music, BorderLayout.CENTER);
		}
		else {
			reload=true;
			/* load */
			info.loadSongInfo();
			actionHandler(ctr_music, dock);
			ctr_music.loadCtrMusic(false);
			dock.loadDock();
			
			/* add */
			this.add(info, BorderLayout.NORTH);
			this.add(ctr_music, BorderLayout.CENTER);
			this.add(dock, BorderLayout.SOUTH);
		}
	}

	private void actionHandler(MusicController ctr_music, FunctionDock dock) {
		ctr_music.getAction(null, null, new Play(), new Pause());
		dock.getAction(new LoadSong(), new LoadSongList(),
				new LoadFavoriteSong(), new ControllVolume());
	}
	public void showMetheLime() {
		applyDesign();
		super.setVisible(true);
	}

	public static void main(String[] args) {
		new MusicPlayer().showMetheLime();
	}
}
