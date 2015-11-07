package action;

import java.awt.Image;

import process.MusicPlayer;

class Update {
	public void songInfo() {
		Get get = new Get();
		get.metaData(true);
		String singerName = get.singerName();
		String songName = get.songName();
		Image albumArt = get.albumArt();
		
		MusicPlayer.songInfo_panel.removeAll();
		MusicPlayer.songInfo_panel.getSongInfo(songName, singerName);
		MusicPlayer.songInfo_panel.loadInfoPanel();
		MusicPlayer.songInfo_panel.updateUI();
		
		MusicPlayer.albumArt.changeBg(albumArt);
	}
	public void songInfo(String songName, String singerName) {
		MusicPlayer.songInfo_panel.removeAll();
		MusicPlayer.songInfo_panel.getSongInfo(songName, singerName);
		MusicPlayer.songInfo_panel.loadInfoPanel();
		MusicPlayer.songInfo_panel.updateUI();
	}
	}
