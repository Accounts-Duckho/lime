package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JProgressBar;
import javax.swing.Timer;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;

public class ActiveProgress {
	static JProgressBar progress_bar;
	int duration = 0;
	int i=0;
	
	Timer t;

	public void SetProgress(JProgressBar jp){
		progress_bar=jp;
	}
	public void Progress(String str){
		try {

			File file = new File(str);

			AudioFile audioFile = AudioFileIO.read(file);
			duration = audioFile.getAudioHeader().getTrackLength();
			JProgressTimer();

		} catch (Exception e) {

			System.out.print("ERROR " + e);
		}
	}
	public void JProgressTimer(){
		progress_bar.setMinimum(0);
		// End at 1000
		progress_bar.setMaximum(duration);
		Timer t;
		t = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (i == 1000)
					i = 0;
				progress_bar.setValue(i++);
			}
		});
		// Start the timer
		t.start();
	}
}
