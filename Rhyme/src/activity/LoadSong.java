/*
 *  Author : SooMan & Duckho
 */
package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.swing.JFileChooser;

import process.MusicPlayer;
import process.Update;
public class LoadSong implements ActionListener {
	private File[] music;
	private File musicdir;
	MetaData songdata = new MetaData();
	public void actionPerformed(ActionEvent e) {
		int value = MusicPlayer.browser.showOpenDialog(null); // get Info whether user has selected or not
		if (value == JFileChooser.APPROVE_OPTION) {
			if (MusicPlayer.browser.getSelectedFile().isFile())
				music = MusicPlayer.browser.getSelectedFiles(); // file link
			else {
				musicdir = MusicPlayer.browser.getSelectedFile();
				music = musicdir.listFiles(new SongFilter());
			}
		}

		/* load songinfo */
		if (music.length < 50) {
			for (int i = 0; i < music.length; i++) {
				songdata.load(music[i]);
				songdata.extractInfo();
				MusicPlayer.background.setAlbumArt(i, songdata.getAlbumArt());
				try {
					ListAdmin.getList(songdata.getSongName(), music[i].getPath());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				MusicPlayer.demand_list.addtolist(songdata.getSinger(), songdata.getSongName());
				music[i]=null;
				}
			Update.Background(0);
			Update.SongInfo(0);
			}
		}
	}
class SongFilter implements FilenameFilter {
	public boolean accept(File dir, String name) {
		if(name.toLowerCase().endsWith(".mp3") || name.toLowerCase().endsWith(".wav"))
			return true;
		else
			return false;
	}
}