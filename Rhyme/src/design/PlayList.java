/*
 *  Authors : JungSang, DuckHo
 */
package design;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import activity.AddList;

@SuppressWarnings("serial")
public class PlayList extends JFrame {
	@SuppressWarnings("unused")
	private ArrayList<String> playlist;
	@SuppressWarnings("unused")
	private JButton delete;
	private JButton add_btn;
	public PlayList()
	{
		super("Favorite List");
		setSize(200, 300);
		setVisible(false);
		setResizable(false);
		playlist=new ArrayList<String>();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		add_btn = new JButton("add");
		add_btn.addActionListener(new AddList());
		add(add_btn, BorderLayout.NORTH);
		Dimension windowSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// Make screen position next to main
		this.setLocation(screenSize.width/2 + windowSize.width,
						screenSize.height / 2 - windowSize.height / 2);
	}
	public void showList() {
		super.setVisible(true);
	}
}