/*
 *  Author : SooMan
 */
package activity;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
import org.jaudiotagger.tag.datatype.Artwork;

import process.Update;
import design.FunctionDock;

public class LoadSong implements ActionListener {
	private JFileChooser browser;
	private FileFilter songFilter;
	File music;
	Tag tag;
	public void actionPerformed(ActionEvent e) {
		try{
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			
		} catch (Exception ex) {
			System.out.println("failed to load windows look and feel");
		}  
		browser = createFileChooser();
		songFilter = createSongFilter();
		browser.addChoosableFileFilter(songFilter);
		browser.setFileFilter(songFilter);
		int value = browser.showOpenDialog(null);
		if (value == JFileChooser.APPROVE_OPTION) {
			music = browser.getSelectedFile(); // file link
			if(e==null){
				Mp3 mp3=new Mp3(music);
			}
		}
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (InstantiationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (UnsupportedLookAndFeelException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		/* load songinfo */
		AudioFile audioFile;
		try {
			audioFile = AudioFileIO.read(music);
	        tag = audioFile.getTag();
			String singer = tag.getFirst(FieldKey.ARTIST);
			String songname = tag.getFirst(FieldKey.TITLE); /* example */
			Update.SongInfo(singer, songname);
			Update.Background(getImage());
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
		FunctionDock.demand_list.addtolist(tag.getFirst(FieldKey.TITLE));
	}
    public Image getImage() {
    	try{
    		final List<Artwork> artworkList = tag.getArtworkList();
	        if (artworkList.size() > 0) {
	            InputStream in = new ByteArrayInputStream(tag.getFirstArtwork().getBinaryData());
	            return ImageIO.read(in);
	        }
    	}catch (Exception e) {}
    	return null;       
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