package activity;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.images.Artwork;

public class MetaData {
	// private File song;
	private AudioFile music;
	private Tag infoTag;
	private String singer;
	private String songname;
	private Image albumArt;

	public void load(File song) {
		try {
			music = AudioFileIO.read(song);
			infoTag = music.getTag();
		} catch (Exception e) {
			System.out.println("File Reading Error");
		}
	}

	public void extractInfo() {
		singer = infoTag.getFirst(FieldKey.ALBUM_ARTIST);
		songname = infoTag.getFirst(FieldKey.TITLE);
		try {
			singer = new String(singer.getBytes("iso-8859-1"), "euc-kr");
			songname = new String(songname.getBytes("iso-8859-1"),
					"euc-kr");
			final List<Artwork> artworkList = infoTag.getArtworkList(); // load
			if (artworkList.size() > 0) { // If exist
				InputStream in = new ByteArrayInputStream(infoTag.getFirstArtwork()
						.getBinaryData());
				albumArt = ImageIO.read(in);
			}
			else {
				albumArt=null; }
		} catch (Exception e) {
			System.out.println("AlbumArt loading Error");
			albumArt=null;
		}
	}
	public String getSinger() {
		if(singer=="")
			return "Unknown";
		else
		return singer;
	}
	public String getSongName() {
		if(songname=="")
			return "Unknown";
		else
		return songname;
	}
	public Image getAlbumArt() {
		return albumArt;
	}
}
