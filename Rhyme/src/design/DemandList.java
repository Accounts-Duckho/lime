package design;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
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
		setSize(200,300);
		setVisible(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		songlist = new ArrayList<String>();
		song = new JButton[49]; //limit 50 song
		listPanel=new JPanel();
		listPanel.setLayout(new GridLayout(songlist.size(),1));
		add(listPanel, BorderLayout.CENTER);
		
		refresh = new JButton("Refresh");
		assignAct(refresh, new Refresh());
		add(refresh, BorderLayout.SOUTH);
		
		Dimension windowSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// Make screen position next to main
		this.setLocation(screenSize.width/2 + windowSize.width,
						screenSize.height / 2 - windowSize.height / 2);
	}
	public void addtolist(String songname) {
		songlist.add(songname);
	}
	public void load() {
		if(songlist.size()<=50) {
		for(int i=0; i<songlist.size(); i++) {
			song[i]=new JButton(songlist.get(i));
			
			song[i].setBorder(null);
			song[i].setFocusable(false);
			song[i].setContentAreaFilled(false);
			listPanel.add(song[i]);
			}
		}
		else { System.out.println("Error : Too many Song Loaded exceed Limit"); }
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
