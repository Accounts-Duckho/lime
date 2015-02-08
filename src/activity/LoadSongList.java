package activity;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LoadSongList implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		/* List of songs */
	}
}

class History{
	public void save_history(String str){
		PlayList pl=new PlayList();
		String st=str;
		ArrayList<String> slist=new ArrayList<String>();
		slist.add(st);
		pl.ShowPlayList(slist);
		Review_History(slist);
	}
	public void Review_History(ArrayList<String> slist){
		ArrayList<String> rlist=slist;
		for(int i=0; i<rlist.size(); i++)
			System.out.println(rlist.get(i));
	}
}
class PlayList{
	public void ShowPlayList(ArrayList<String> list){
		ArrayList<String> plist=list;
		JButton[] btn=new JButton[plist.size()];
		
		JFrame jf=new JFrame("PlayList");
		jf.setSize(300,500);
		for(int i=0; i<plist.size(); i++){
			btn[i]=new JButton(plist.get(i));
			jf.add(btn[i]);
			btn[i].setPreferredSize(new Dimension(50,50));
		}
		jf.setVisible(true);
	}
}