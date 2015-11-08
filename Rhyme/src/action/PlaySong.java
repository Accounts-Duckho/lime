package action;

import java.io.FileInputStream;

import javazoom.jl.decoder.JavaLayerException;
import process.Mp3Player;
import process.MusicPlayer;

public class PlaySong {
	Update update = new Update();
	private final int PLAY = 1;
	public void readySong() {
		
		// Remove Current Player if exist
		if (MusicPlayer.playInstance != null) {
			MusicPlayer.playInstance.exit();
		}

		FileInputStream songStream;
		String currentSongDir;
		try {
			currentSongDir = MusicPlayer.songList.get(MusicPlayer.songQueue);
			songStream = new FileInputStream(currentSongDir);
			MusicPlayer.playInstance = new Mp3Player(songStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void playSong() {
		try {
			update.songInfo();
			MusicPlayer.playStatus=PLAY;
			MusicPlayer.control_panel.switch_btn();
			MusicPlayer.playInstance.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}

	public void playPrevious() {
		if (MusicPlayer.songQueue > 0) {
			MusicPlayer.songQueue--;
			readySong();
			update.songInfo();
			playSong();
		}
	}

	public void playNext() {
		if (MusicPlayer.songQueue + 1 < MusicPlayer.songList.size()) {
			MusicPlayer.songQueue++;
			readySong();
			update.songInfo();
			playSong();
		} else {
			MusicPlayer.songQueue = 0;
			readySong();
			update.songInfo();
			playSong();
		}
	}
}
