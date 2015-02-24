package activity;

import java.io.InputStream;

import process.MusicPlayer;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.Player;

public class Mp3Player {
	private final static int NOTSTARTED = 0;
	private final static int PLAYING = 1;
	private final static int PAUSED = 2;
	private final static int FINISHED = 3;
	
	private final Player player;
	
	private final Object playerLock = new Object();
	
	private boolean next_clicked=false;
	private boolean pre_clicked=false;
	
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
				resume();
				break;
			default:
				break;
			}
		}
	}
	public boolean pause() {
		synchronized(playerLock) {
			if(playerStatus == PLAYING) {
				playerStatus = PAUSED;
			}
			return playerStatus == PLAYING;
		}
	}
	public boolean resume() {
		synchronized(playerLock) {
			if(playerStatus == PAUSED) {
				playerStatus = PLAYING;
				playerLock.notifyAll();
			}
			return playerStatus == PLAYING;
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
				if(!player.play(1)|| next_clicked == true || pre_clicked == true) {
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
		close();
	}
	public void close() {
		synchronized(playerLock) {
			playerStatus = FINISHED;
			MusicPlayer.ctr_panel.switch_btn(false);
		}
		try {
			player.close();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	public int getStatus() {
		return playerStatus;
	}
	public void ifnext(boolean clicked) {
		next_clicked=clicked;
	}
	public void ifpre(boolean clicked) {
		pre_clicked=clicked;
	}
}
