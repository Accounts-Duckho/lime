/*
 *  Authors : JungSang, DuckHo
 */
package design;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import activity.AddList;

@SuppressWarnings("serial")
public class PlayList extends JFrame {
	private ArrayList<String> playlist;
	private JButton delete;
	private JButton add_btn;
	public PlayList()
	{
		super("Favorite List");
		setSize(100, 400);
		setVisible(false);
		setResizable(false);
		playlist=new ArrayList<String>();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		add_btn = new JButton("add");
		add_btn.addActionListener(new AddList());
		add(add_btn, BorderLayout.NORTH);
	}
	public void showList() {
		super.setVisible(true);
	}
}