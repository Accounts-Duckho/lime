/*
 *  Author : SooMan
 */
package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import process.MusicPlayer;
import process.Update;

public class LoadSong implements ActionListener {
	private JFileChooser browser;
	private FileFilter songFilter;
	File music;
	Tag tag;
	public void actionPerformed(ActionEvent e) {
		browser = createFileChooser();
		songFilter = createSongFilter();
		browser.addChoosableFileFilter(songFilter);
		browser.setFileFilter(songFilter);
		int value = browser.showOpenDialog(null);
		if (value == JFileChooser.APPROVE_OPTION) {
			music = browser.getSelectedFile(); // file link
		}
		
		/* load songinfo */
		AudioFile audioFile;
		try {
			audioFile = AudioFileIO.read(music);
	        tag = audioFile.getTag();
			String singer = tag.getFirst(FieldKey.ARTIST);
			String songname = tag.getFirst(FieldKey.TITLE); /* example */
			Update.SongInfo(singer, songname);
		} catch (CannotReadException e1) {
			// TODO Auto-generated catch block
			String singer = "can't load", songname = "can't load";
			Update.SongInfo(singer, songname);
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			String singer = "can't load", songname = "can't load";
			Update.SongInfo(singer, songname);
			e1.printStackTrace();
		} catch (TagException e1) {
			// TODO Auto-generated catch block
			String singer = "can't load", songname = "can't load";
			Update.SongInfo(singer, songname);
			e1.printStackTrace();
		} catch (ReadOnlyFileException e1) {
			// TODO Auto-generated catch block
			String singer = "can't load", songname = "can't load";
			Update.SongInfo(singer, songname);
			e1.printStackTrace();
		} catch (InvalidAudioFrameException e1) {
			// TODO Auto-generated catch block
			String singer = "can't load", songname = "can't load";
			Update.SongInfo(singer, songname);
			e1.printStackTrace();
		}
		MusicPlayer.songlist.addtolist(tag.getFirst(FieldKey.TITLE));
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