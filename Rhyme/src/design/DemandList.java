package design;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import activity.Refresh;

@SuppressWarnings("serial")
final public class DemandList extends JFrame {
	private ArrayList<String> songlist;
	private JPanel listPanel;
	private JButton[] song;
	private JButton refresh;
	public DemandList() {
		super("SongList");
		setSize(300,500);
		setVisible(false);
		setResizable(false);
		songlist = new ArrayList<String>();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		listPanel=new JPanel();
		listPanel.setLayout(new GridLayout(songlist.size(),1));
		add(listPanel, BorderLayout.CENTER);
		refresh = new JButton("Refresh");
		assignAct(refresh, new Refresh());
		add(refresh, BorderLayout.SOUTH);
	}
	public void addtolist(String songname) {
		song = new JButton[99]; //limit 100 song
		songlist.add(songname);
	}
	public void load() {
		for(int i=0; i<songlist.size(); i++) {
			song[i]=new JButton(songlist.get(i));
			song[i].setBorder(null);
			song[i].setFocusable(false);
			song[i].setContentAreaFilled(false);
			listPanel.add(song[i]);
		}
	}
	public void showList() {
		listPanel.removeAll();
		this.load();
		this.setVisible(true);
	}
	public void refresh() {
		showList();
	}
	
	private void assignAct(JButton btn, ActionListener act) {
		btn.addActionListener(act);
	}
}
