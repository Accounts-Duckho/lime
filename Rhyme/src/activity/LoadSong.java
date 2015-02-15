/*
 *  Author : SooMan & Duckho
 */
package activity;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.images.Artwork;

import process.MusicPlayer;
import process.Update;
import design.FunctionDock;

public class LoadSong implements ActionListener {
	private File[] music;
	private File musicdir;
	private Tag tag;
	public static AudioFile audioFile;
	public void actionPerformed(ActionEvent e) {
		int value = MusicPlayer.browser.showOpenDialog(null); // open browser and notice chose or cancel 
		if (value == JFileChooser.APPROVE_OPTION) {
			if(MusicPlayer.browser.getSelectedFile().isFile())
			music = MusicPlayer.browser.getSelectedFiles(); // file link
			else {
			musicdir= MusicPlayer.browser.getSelectedFile();
			music = musicdir.listFiles(); }		
		}
		
		/* load songinfo */
		try {
			audioFile = AudioFileIO.read(music[0]);
	        tag = audioFile.getTag();
			String singer = tag.getFirst(FieldKey.ARTIST);
			String songname = tag.getFirst(FieldKey.TITLE);		
			Update.SongInfo(singer, songname);
			Update.Background(getImage());
		} catch (Exception e1) {
			String singer = "can't load", songname = "can't load";
			Update.SongInfo(singer, songname);
			e1.printStackTrace(); }
		
		FunctionDock.demand_list.addtolist(tag.getFirst(FieldKey.TITLE),tag.getFirst(FieldKey.ARTIST));
	}
	
    public Image getImage() {
    	try{
    		final List<Artwork> artworkList = tag.getArtworkList(); // load
	        if (artworkList.size() > 0) { // If exist
	            InputStream in = new ByteArrayInputStream(tag.getFirstArtwork().getBinaryData());
	            return ImageIO.read(in);
	        }
    	} catch (Exception e) {}
    	return null;       
    }
}