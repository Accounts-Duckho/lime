/*
 * Author : JungSang
 * Edited by Duckho
 */
package design;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import activity.LoadDemandList;
import activity.LoadFavoriteSong;
import activity.LoadSong;
import activity.Repeat;

@SuppressWarnings("serial")
public class FunctionDock extends JPanel {
	private JButton load_btn;
	private JButton list_btn;
	private JButton favorite_btn;
	private JButton repeat_btn;
	public JLabel volume_icon;
	public static DemandList demand_list;
	public static PlayList play_list;
	
	public FunctionDock() {
		setLayout(new GridLayout(1,5));
		makeContents();
		getAction(new LoadSong(), new LoadDemandList(),
				new LoadFavoriteSong(), new Repeat());
		loadDock();
		setOpaque(false);
		setBackground(new Color(255,255,255,128));
	}
	
	private void makeContents() {
		final URL icon_load = getClass()
				.getResource("/images/icons/load.png");
		final URL icon_demand_list = getClass().getResource("/images/icons/demand_list.png");
		final URL icon_favorite_list = getClass().getResource("/images/icons/favorite_list.png");
		final URL icon_volume_bar = getClass().getResource("/images/icons/volume.png");
		final URL icon_repeat = getClass().getResource("/images/icons/repeat.png");
		load_btn = createButton(new ImageIcon(icon_load));// load song
		list_btn = createButton(new ImageIcon(icon_demand_list));// play list
		favorite_btn = createButton(new ImageIcon(icon_favorite_list));// most_played songs
		repeat_btn = createButton(new ImageIcon(icon_repeat));
		volume_icon = new JLabel(new ImageIcon(icon_volume_bar));// open volume control	
		demand_list = new DemandList();
		play_list = new PlayList();
	}
	
	private void applyFeature() {
		/* load button */
		load_btn.setBorder(null);
		load_btn.setFocusable(false);
		load_btn.setContentAreaFilled(false);
		
		/* list button */
		list_btn.setBorder(null);
		list_btn.setFocusable(false);
		list_btn.setContentAreaFilled(false);

		/* favorite button */
		favorite_btn.setBorder(null);
		favorite_btn.setFocusable(false);
		favorite_btn.setContentAreaFilled(false);

		/* Volume button */
		volume_icon.setBorder(null);
		volume_icon.setFocusable(false);
		
		/* favorite button */
		repeat_btn.setBorder(null);
		repeat_btn.setFocusable(false);
		repeat_btn.setContentAreaFilled(false);
	}

	public void getAction(ActionListener song, ActionListener list,
			ActionListener favorite, ActionListener repeat) {	
		assignAct(load_btn, song);
		assignAct(list_btn, list);
		assignAct(favorite_btn, favorite);	
		assignAct(repeat_btn, repeat);
	}
	
	private void assignAct(JButton btn, ActionListener act) {
		btn.addActionListener(act);
	}
	
	private void addButtons() {
		this.add(load_btn);
		this.add(list_btn);
		this.add(favorite_btn);
		this.add(repeat_btn);
		this.add(volume_icon);
	}
	
	public void loadDock() {
		applyFeature();
		addButtons();
	}

	private JButton createButton(Icon icon) {
		JButton button = new JButton(icon);
		return button;
	}
}
