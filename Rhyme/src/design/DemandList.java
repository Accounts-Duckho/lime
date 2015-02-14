package design;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import activity.Refresh;

@SuppressWarnings("serial")
final public class DemandList extends JFrame implements MouseWheelListener {
	public static ArrayList<String> songlist;
	private JButton[] song;
	private JButton refresh;
	private JPanel subpanel=new JPanel();
	public DemandList() {
		super("SongList");
		setSize(200,300);
		setVisible(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		addMouseWheelListener(this);
		songlist = new ArrayList<String>();
		song = new JButton[49]; //limit 50 song
			
		refresh = new JButton("Refresh");
		assignAct(refresh, new Refresh());
		Dimension windowSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// Make screen position next to main
		this.setLocation(screenSize.width/2 + windowSize.width,
						screenSize.height / 2 - windowSize.height / 2);
		add(refresh, BorderLayout.NORTH);
		subpanel.setLayout(new BorderLayout());
		subpanel.setVisible(false);
		add(subpanel, BorderLayout.CENTER);
	}
	public void addtolist(String songname) {
		songlist.add(songname);
	}
	public JComponent load() {
		JLayeredPane list = new JLayeredPane();
		if(songlist.size()<=50) {
		for(int i=0; i<songlist.size(); i++) {
			song[i]=new JButton(songlist.get(i));
			song[i].setFont(new Font("GODIC", Font.PLAIN, 15));
			song[i].setHorizontalAlignment(JLabel.LEFT);
			song[i].setBorder(null);
			song[i].setFocusable(false);
			song[i].setContentAreaFilled(false);
			song[i].setBounds(0,10+16*i,200,15);
			list.add(song[i]);
			}
		}
		else { System.out.println("Error : Too many Song Loaded exceed Limit"); }
		return list;
	}
	public void showList() {
		subpanel.removeAll();
		subpanel.add(load());
		this.add(subpanel);
		subpanel.setVisible(true);
		this.setVisible(true);
	}
	public void refresh() {
		showList();
	}
	
	private void assignAct(JButton btn, ActionListener act) {
		btn.addActionListener(act);
	}
	public void mouseWheelMoved(MouseWheelEvent e) {
		
	}
	public void fix(String songname) {
		songlist.set(songlist.size()-1, songname);
	}
}
