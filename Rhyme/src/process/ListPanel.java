package process;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import action.Get;
import action.PlaySong;

@SuppressWarnings("serial")
public class ListPanel extends JPanel {
	private JPanel[] songBtn;
	private JScrollPane scroll=new JScrollPane();
	public ListPanel() {
		setVisible(false);
		setLayout(new BorderLayout());
//		setBackground(new Color(255,182,193));
		songBtn = new JPanel[149];
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll,BorderLayout.WEST);
	}

	public JComponent loadWaitList() {
		JLayeredPane list = new JLayeredPane();
		Get get = new Get();
		scroll = new JScrollPane();
		if (MusicPlayer.list.size() <= 150) {
			for (int i = 0; i < MusicPlayer.list.size(); i++) {
				songBtn[i] = new JPanel(new BorderLayout());
				JComponent container=new JLayeredPane();
				JLabel songname = new JLabel(new String (new File(MusicPlayer.list.get(i)).getName()).replaceFirst("[.][^.]+$", ""));
				get.metaData(i);
				JLabel genre = new JLabel("0");
				switch (get.genre()) {
				case "Rap / Hip-hop" :
					genre = new JLabel("1");
					break;
				case "Ballad" :
					genre = new JLabel("2");
					break;
				
				}
				songname.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
//				container.add(genre, 1);
//				container.add(songname, 2);
				songBtn[i].setBorder(null);
				songBtn[i].setFocusable(false);
				songBtn[i].addMouseListener(new songBtnAction(i));
				songBtn[i].setBounds(0, 10 + 19 * i, 200, 11);
//				songBtn[i].add(container);
				songBtn[i].add(songname, BorderLayout.CENTER);
				list.add(songBtn[i]);
			}
			scroll.setViewportView(list);
		} else {
			System.out.println("Error : Too many song to load");
		}
		return list;
	}

	public void refreshList() {
		setVisible(false);
		removeAll();
		add(loadWaitList());
		setVisible(true);
	}

	class songBtnAction implements MouseListener {
		PlaySong playAction = new PlaySong();
		private int count;

		public songBtnAction(int n) {
			count = n;
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				try {
					MusicPlayer.changed = true;
					MusicPlayer.queue = count;
					playAction.readySong();
					playAction.playSong();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}

		public void mouseEntered(MouseEvent e1) {
		}

		public void mouseExited(MouseEvent e2) {
		}

		public void mouseReleased(MouseEvent e3) {
		}

		public void mousePressed(MouseEvent e4) {
		}
	}
}
