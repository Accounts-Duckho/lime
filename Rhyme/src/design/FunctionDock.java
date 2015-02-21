/*
 * Author : JungSang
 * Edited by Duckho
 */
package design;

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

@SuppressWarnings("serial")
public class FunctionDock extends JPanel {
	private JButton load_btn;
	private JButton list_btn;
	private JButton favorite_btn;
	public JLabel volume_icon;
	
	public FunctionDock() {
		setLayout(new GridLayout(1,5));
		makeContents();
		getAction(new LoadSong(), new LoadDemandList(),
				new LoadFavoriteSong());
		loadDock();
		setOpaque(false); // transparent option : false is actually true of transparent 
	}
	
	private void makeContents() {
		/* Icon Load */
		final URL icon_load = getClass().getResource("/images/icons/load.png");
		final URL icon_demand_list = getClass().getResource("/images/icons/demand_list.png");
		final URL icon_favorite_list = getClass().getResource("/images/icons/favorite_list.png");
		final URL icon_volume_bar = getClass().getResource("/images/icons/volume.png");
		
		/* Make Button with Icon */
		load_btn = createButton(new ImageIcon(icon_load));
		list_btn = createButton(new ImageIcon(icon_demand_list));
		favorite_btn = createButton(new ImageIcon(icon_favorite_list));
		volume_icon = new JLabel(new ImageIcon(icon_volume_bar));
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
	}

	public void getAction(ActionListener song, ActionListener list,
			ActionListener favorite) {	
		assignAct(load_btn, song);
		assignAct(list_btn, list);
		assignAct(favorite_btn, favorite);
	}
	
	private void assignAct(JButton btn, ActionListener act) {
		btn.addActionListener(act);
	}
	
	private void addButtons() {
		this.add(load_btn);
		this.add(list_btn);
		this.add(favorite_btn);
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
