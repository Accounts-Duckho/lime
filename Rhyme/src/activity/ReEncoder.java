package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import process.MusicPlayer;
import process.Update;

public class ReEncoder implements ActionListener {
	private boolean clicked = false ;
	private String singer;
	private String songname;
	private String temp_singer;
	private String temp_songname;
	public void actionPerformed(ActionEvent e) {
		singer=MusicPlayer.info_panel.singer;
		songname=MusicPlayer.info_panel.songname;
		temp_singer=singer;
		temp_songname=songname;
		
		
		/* Repeat */
		if (clicked == false) {
			try {
				singer = new String(singer.getBytes("ksc5601"), "euc-kr");
				songname = new String(songname.getBytes("ksc5601"), "euc-kr");
				Update.SongInfo(singer, songname);
				MusicPlayer.info_panel.singer=temp_singer;
				MusicPlayer.info_panel.songname=temp_songname;
				clicked=true;
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			try {
				singer = new String(singer.getBytes("iso-8859-1"), "euc-kr");
				songname = new String(songname.getBytes("iso-8859-1"),
						"euc-kr");
				Update.SongInfo(singer, songname);
				MusicPlayer.info_panel.singer=temp_singer;
				MusicPlayer.info_panel.songname=temp_songname;
				clicked=false;
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}