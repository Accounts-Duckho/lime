/*
 * Author : JungSang
 * Edited by Duckho
 */
package process;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import action.Get;
import action.Set;

@SuppressWarnings("serial")
public class FunctionDock extends JPanel {
	private JButton loadBtn;
	private JButton fixBtn; 
	private JButton repeatBtn;

	public FunctionDock() {
		setLayout(new GridLayout(1, 5));
		makePanel();
		setOpaque(false); // transparent option : false is actually true
	}

	private void makePanel() {
		/* Icon Load */
		final URL icon_load = getClass().getResource("/images/icons/load.png");
//		final URL icon_demandList = getClass().getResource(
//				"/images/icons/demand_list.png");
//		final URL icon_playList = getClass().getResource(
//				"/images/icons/favorite_list.png");
		final URL icon_repeat = getClass().getResource(
				"/images/icons/repeat.png");
		final URL icon_refresh = getClass().getResource(
				"/images/icons/refresh.png");

		/* Make Button with Icon */
		loadBtn = new JButton(new ImageIcon(icon_load));
		loadBtn.setBorder(null);
		loadBtn.setFocusable(false);
		loadBtn.setContentAreaFilled(false);
		loadBtn.addActionListener(new LoadBtnAction());

//		demandListBtn = new JButton(new ImageIcon(icon_demandList));
//		demandListBtn.setBorder(null);
//		demandListBtn.setFocusable(false);
//		demandListBtn.setContentAreaFilled(false);
//		demandListBtn.addActionListener(new DemandListBtnAction());
//		
//		playListBtn = new JButton(new ImageIcon(icon_playList));
//		playListBtn.setBorder(null);
//		playListBtn.setFocusable(false);
//		playListBtn.setContentAreaFilled(false);
//		playListBtn.addActionListener(new PlayListBtnAction());
		
		repeatBtn = new JButton(new ImageIcon(icon_repeat));
		repeatBtn.setBorder(null);
		repeatBtn.setFocusable(false);
		repeatBtn.setContentAreaFilled(false);
		
		fixBtn = new JButton(new ImageIcon(icon_refresh));
		fixBtn.addActionListener(new FixBtnAction());
		fixBtn.setBorder(null);
		fixBtn.setFocusable(false);
		fixBtn.setContentAreaFilled(false);
		
//		this.add(demandListBtn);
//		this.add(playListBtn);
		this.add(repeatBtn);
		this.add(fixBtn);
		this.add(loadBtn);
	}
	
	class LoadBtnAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Get get = new Get();
			get.song();
			Set set = new Set();
			set.song(get);
			MusicPlayer.list_panel.refreshList();
		}
	}
//	class DemandListBtnAction implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			MusicPlayer.demand_list.showList();
//		}
//	}
//
//	class PlayListBtnAction implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			MusicPlayer.play_list.showList();
//		}
//	}

	class FixBtnAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				Get get = new Get();
				get.metaData(false);
				Set set = new Set();
				set.fixEncode(get.songName(), get.singerName());
		}
	}
	
}
