package design;

import javax.swing.JProgressBar;

import activity.ActiveProgress;

public class ProgressBar {
	int i=0;
	static JProgressBar progress_bar;
	public ProgressBar(JProgressBar jp){
		progress_bar=jp;
		progress_bar.setValue(30); // start position
		progress_bar.setStringPainted(true);
		progress_bar.setFocusable(false);
		ActiveProgress ap=new ActiveProgress();
		ap.SetProgress(progress_bar);
	}
}
