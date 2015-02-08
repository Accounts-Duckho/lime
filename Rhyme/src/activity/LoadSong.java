/*
 *  Author : SooMan
 */
package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import process.Update;

public class LoadSong implements ActionListener {
	private JFileChooser browser;
	private FileFilter songFilter;
	public void actionPerformed(ActionEvent e) {
		browser = createFileChooser();
		songFilter = createSongFilter();
		browser.addChoosableFileFilter(songFilter);
		browser.setFileFilter(songFilter);
		int value = browser.showOpenDialog(null);
		if (value == JFileChooser.APPROVE_OPTION) {
			@SuppressWarnings("unused")
			File music = browser.getSelectedFile(); // file link
		}
		
		/* load songinfo */
		String singer = "hello", songname = "how are you"; /* example */
		Update.SongInfo(singer, songname);
	}
	private JFileChooser createFileChooser() {
		JFileChooser chooser = new JFileChooser();
		return chooser;
	}
	private FileFilter createSongFilter() {
	 FileFilter filter =	new FileNameExtensionFilter("Music File", "mp3",
				"wav", "m4a");
	 return filter;
	}
}