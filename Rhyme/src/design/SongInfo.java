/*
 * Author : Duckho
 */
package design;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
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
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setOpaque(false);
		setSize(223, 60);
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
			fileNameInfo.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
			fileNameInfo.setForeground(Color.BLACK); // text color
			fileNameInfo.setAlignmentX(CENTER_ALIGNMENT);
			}
		else {
			singerInfo = new JLabel(singerName);
			singerInfo.setFont(new Font("Malgun Gothic", Font.PLAIN, 10));
			singerInfo.setForeground(Color.GRAY); 
			singerInfo.setAlignmentX(CENTER_ALIGNMENT);
			
			songNameInfo = new JLabel(songName); 
			songNameInfo.setFont(new Font("Malgun Gothic", Font.PLAIN, 30));
			songNameInfo.setForeground(Color.BLACK);
			songNameInfo.setAlignmentX(CENTER_ALIGNMENT); 
		}
	}    
	public void loadInfoPanel() {
		makeLabel();
		if(showFileName) {
			this.add(Box.createRigidArea(new Dimension(19, 0))); /* empty block */
			this.add(fileNameInfo);
			this.add(Box.createRigidArea(new Dimension(19, 0))); /* empty block */
		} else {
			this.add(songNameInfo);
			this.add(Box.createRigidArea(new Dimension(3, 0))); /* empty block */
			this.add(singerInfo);
			this.add(Box.createRigidArea(new Dimension(15, 0))); /* empty block */
		}
	}
}
