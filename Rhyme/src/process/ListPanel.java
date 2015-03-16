package process;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import action.PlaySong;

@SuppressWarnings("serial")
public class ListPanel extends JPanel {
	private JButton[] songBtn;

	public ListPanel() {
		setVisible(false);
		setLayout(new BorderLayout());
//		setBackground(new Color(255,182,193));
		songBtn = new JButton[149];
	}

	public JComponent loadWaitList() {
		JLayeredPane list = new JLayeredPane();
		if (MusicPlayer.list.size() <= 150) {
			for (int i = 0; i < MusicPlayer.list.size(); i++) {
				songBtn[i] = new JButton(
						new String (new File(MusicPlayer.list.get(i)).getName()).replaceFirst("[.][^.]+$", ""));
				songBtn[i].setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
				songBtn[i].setHorizontalAlignment(JLabel.LEFT);
				songBtn[i].setBorder(null);
				songBtn[i].setFocusable(false);
				songBtn[i].setContentAreaFilled(false);
				songBtn[i].addMouseListener(new songBtnAction(i));
				songBtn[i].setBounds(0, 10 + 19 * i, 200, 12);
				list.add(songBtn[i]);
			}
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
