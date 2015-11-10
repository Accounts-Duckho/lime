package process;

import java.io.InputStream;

import action.PlaySong;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.Player;

public class Mp3Player {
	private final static int NOTSTARTED = 0;
	private final static int PLAYING = 1;
	private final static int PAUSED = 2;
	private final static int FINISHED = 3;

	private final int STOP = 0;

	private final int NoChanged = 0;
	private final int stopRequested = 3;

	private final Player player;
	private final Object playerLock = new Object();

	private int playerStatus = NOTSTARTED;

	public Mp3Player(final InputStream inputStream) throws JavaLayerException {
		this.player = new Player(inputStream);
	}

	public Mp3Player(final InputStream inputStream, final AudioDevice audioDevice) throws JavaLayerException {
		this.player = new Player(inputStream, audioDevice);
	}

	PlaySong playAction = new PlaySong();

	// Starts playback (resumes if paused)
	public void play() throws JavaLayerException {
		MusicPlayer.setDefault();
		synchronized (playerLock) {
			switch (playerStatus) {
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

	public void pause() {
		synchronized (playerLock) {
			if (playerStatus == PLAYING) {
				playerStatus = PAUSED;
			}
			// return playerStatus == PLAYING;
		}
	}

	public void resume() {
		synchronized (playerLock) {
			if (playerStatus == PAUSED) {
				playerStatus = PLAYING;
				playerLock.notifyAll();
			}
			// return playerStatus == PLAYING;
		}
	}

	public void stop() {
		synchronized (playerLock) {
			playerStatus = FINISHED;
			playerLock.notifyAll();
		}
	}

	private void playInternal() {
		while (playerStatus != FINISHED) {
			try {
				if (!player.play(1)) {
					break;
				}
			} catch (final JavaLayerException e) {
				break;
			}
			synchronized (playerLock) {
				while (playerStatus == PAUSED) {
					try {
						playerLock.wait();
					} catch (final InterruptedException e) {
						break;
					}
				}
			}
		}
		player.close();
		if (!MusicPlayer.isRepeating) {
			if (MusicPlayer.getStatus() == stopRequested || MusicPlayer.songQueue + 1 == MusicPlayer.songList.size()) {
				MusicPlayer.playStatus = STOP;
				MusicPlayer.control_panel.switch_btn();
				playAction.readySong();
			} else if (MusicPlayer.getStatus() != NoChanged) {
				try {
					playAction.readySong();
					playAction.playSong();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				if (!MusicPlayer.closeRequested && !MusicPlayer.changeRequested)
					playAction.playNext();
			}
		} else
			try {
				playAction.readySong();
				playAction.playSong();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void close() {
		synchronized (playerLock) {
			playerStatus = FINISHED;
			player.close();
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
