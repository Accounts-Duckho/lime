/*
 *  Author : SooMan & Duckho
 */
package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.swing.JFileChooser;

import process.MusicPlayer;
import process.Update;
public class LoadSong implements ActionListener {
	private File[] music;
	private File musicdir;
	MetaData songdata = new MetaData();
	private boolean selected=false;
	public void actionPerformed(ActionEvent e) {
		getSong();
		if(selected) 
		loadSong();
		}
	public void getSong() {
		int value = MusicPlayer.browser.showOpenDialog(null); // get Info whether user has selected or not
		if (value == JFileChooser.APPROVE_OPTION) {
			if (MusicPlayer.browser.getSelectedFile().isFile())
				music = MusicPlayer.browser.getSelectedFiles(); // file link
			else {
				musicdir = MusicPlayer.browser.getSelectedFile();
				music = musicdir.listFiles(new SongFilter());
			}
			selected=true;
		}
	}
	public void loadSong() {
		int pre_count=MusicPlayer.albumArt.getAlbumArtLength();
		if (pre_count+music.length < 100) {
			for (int i = 0; i < music.length; i++) {
				songdata.load(music[i]);
				songdata.extractInfo();
				MusicPlayer.albumArt.setAlbumArt(pre_count+i, songdata.getAlbumArt());
				try {
					ListAdmin.getList(songdata.getSongName(), music[i].getPath());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				MusicPlayer.demand_list.addtolist(songdata.getSinger(), songdata.getSongName());
				music[i]=null;
			}
			if(MusicPlayer.play_mp3==null) {
			Update.Background(0);
			
			if(MusicPlayer.demand_list.songinfo.get(0) != MusicPlayer.demand_list.singerinfo.get(0))
			Update.SongInfo(0);
			else
			Update.SongInfo(new File(ListAdmin.loaddir(0)).getName());
			
			FileInputStream firstInit;
			try {
				firstInit = new FileInputStream(ListAdmin.loaddir(0));
				MusicPlayer.play_mp3=new Mp3Player(firstInit);
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
		}			
			MusicPlayer.albumArt.setAlbumArtLength(pre_count+music.length);
			}
		else System.out.println("Limited to 100 song");
	}
	}
class SongFilter implements FilenameFilter {
	public boolean accept(File dir, String name) {
		if(name.toLowerCase().endsWith(".mp3") || name.toLowerCase().endsWith(".wav") || name.toLowerCase().endsWith(".m4a"))
			return true;
		else
			return false;
	}
}