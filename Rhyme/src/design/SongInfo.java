/*
 * Author : Duckho
 */
package design;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;

import process.MusicPlayer;

@SuppressWarnings("serial")
public class SongInfo extends JPanel {
	private JLabel singerInfo;
	private JLabel songNameInfo;
	private JLabel fileNameInfo;
	public String singerName;
	public String songName;
	public String fileName;
	private boolean showFileName=false;
	
	public SongInfo() {
		setLayout(new GridLayout(2, 1));
		setOpaque(false);
		getSongInfo("", "");
		loadInfoPanel();
	}
	public void getSongInfo(String songName, String singerName) {
		if(songName !=null & singerName !=null) {
			this.singerName = singerName;
			this.songName = songName;
			showFileName=false;
		}
		else {
			this.fileName=new File(MusicPlayer.list.get(MusicPlayer.queue)).getName();
			showFileName=true;
		}
	}
	private void makeLabel() {	
//			Foreground = text color
		if(showFileName) {
			fileNameInfo = new JLabel(fileName);
			fileNameInfo.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
			fileNameInfo.setForeground(Color.BLACK); // text color
			fileNameInfo.setHorizontalAlignment(JLabel.CENTER);
			}
		else {
			singerInfo = new JLabel(singerName);
			singerInfo.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
			singerInfo.setForeground(Color.GRAY); 
			singerInfo.setHorizontalAlignment(JLabel.CENTER);
			
			songNameInfo = new JLabel(songName); 
			songNameInfo.setFont(new Font("Malgun Gothic", Font.PLAIN, 19));
			songNameInfo.setForeground(Color.BLACK);
			songNameInfo.setHorizontalAlignment(JLabel.CENTER); 
		}
	}    
	public void loadInfoPanel() {
		makeLabel();
		if(showFileName)
			this.add(fileNameInfo);
		else {
			this.add(songNameInfo);
			this.add(singerInfo);
		}
	}
}
