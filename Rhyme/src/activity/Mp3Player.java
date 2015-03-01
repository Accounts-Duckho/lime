package activity;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.Player;
import process.MusicPlayer;
import process.Update;

public class Mp3Player {
	private final static int NOTSTARTED = 0;
	private final static int PLAYING = 1;
	private final static int PAUSED = 2;
	private final static int FINISHED = 3;
	private final Player player;
	
	private final Object playerLock = new Object();
	
	private int playerStatus = NOTSTARTED;
	public Mp3Player(final InputStream inputStream) throws JavaLayerException {
		this.player = new Player(inputStream);
	}
	public Mp3Player(final InputStream inputStream, final AudioDevice audioDevice) throws JavaLayerException {
		this.player = new Player(inputStream, audioDevice);
	}
	
	// Starts playback (resumes if paused)
	public void play() throws JavaLayerException {
		synchronized(playerLock) {
			switch(playerStatus) {
			case NOTSTARTED:
				MusicPlayer.ctr_panel.switch_btn(true);
				final Runnable r = new Runnable() {
					public void run() {
						playInternal();
					}
				};
				final Thread t = new Thread(r);
				t.setDaemon(true);
				t.setPriority(Thread.MAX_PRIORITY);
				playerStatus = PLAYING;
				t.start();
				break;
			case PAUSED:
				MusicPlayer.ctr_panel.switch_btn(true);
				resume();
				break;
			default:
				break;
			}
		}
	}
	public void pause() {
		synchronized(playerLock) {
			if(playerStatus == PLAYING) {
				playerStatus = PAUSED;
			}
//			return playerStatus == PLAYING;
		}
	}
	public void resume() {
		synchronized(playerLock) {
			if(playerStatus == PAUSED) {
				playerStatus = PLAYING;
				playerLock.notifyAll();
			}
//			return playerStatus == PLAYING;
		}
	}
	public void stop() {
		synchronized(playerLock) {
			MusicPlayer.ctr_panel.switch_btn(false);
			playerStatus = FINISHED;
			playerLock.notifyAll();
		}
	}
	private void playInternal() {
		while(playerStatus != FINISHED) {
			try {
				if(!player.play(1)) {
					break;
				}
			} catch (final JavaLayerException e) {
				break;
			}
			synchronized(playerLock) {
				while(playerStatus == PAUSED) {
					try {
						playerLock.wait();
					} catch (final InterruptedException e) {
						break;
					}
				}
			}
		}
		if(MusicPlayer.changed || ListAdmin.loaddir(MusicPlayer.queue+1)==null) {
			MusicPlayer.ctr_panel.switch_btn(false);
			player.close();
		MusicPlayer.changed=false; }
		else
			close();
	}
	public void close() {
		synchronized(playerLock) {
			playerStatus = FINISHED;
			FileInputStream input;
			try {
				exit();
				MusicPlayer.queue++;  
				input = new FileInputStream(ListAdmin.loaddir(MusicPlayer.queue));
				MusicPlayer.mp3play=new Mp3Player(input);
				if (MusicPlayer.demand_list.songinfo.get(MusicPlayer.queue) != MusicPlayer.demand_list.singerinfo.get(MusicPlayer.queue))
					Update.SongInfo(MusicPlayer.queue);
				else
					Update.SongInfo(new File(ListAdmin.loaddir(MusicPlayer.queue)).getName());
				Update.Background(MusicPlayer.queue);
				MusicPlayer.mp3play.play(); 
			} catch (Exception e) {
				e.printStackTrace();
				}
			}
	}
	public int getStatus() {
		return playerStatus;
	}
	public void exit() {
		try {
			player.close();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
