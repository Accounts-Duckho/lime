package process;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import action.PlaySong;

@SuppressWarnings("serial")
final public class DemandList extends JFrame {
	private JButton[] songBtn;
	private JPanel subpanel = new JPanel();
	private int limitValue;

	public DemandList(int songLimit) {
		setSize(200, 700);
		setVisible(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		limitValue = songLimit;
		songBtn = new JButton[limitValue - 1];

		Dimension windowSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// Make screen position next to main
		this.setLocation(screenSize.width / 2 + windowSize.width,
				screenSize.height / 2 - windowSize.height / 2);
		
		subpanel.setLayout(new BorderLayout());
		subpanel.setVisible(false);
		add(subpanel, BorderLayout.CENTER);
	}

	public JComponent loadWaitList() {
		JLayeredPane list = new JLayeredPane();
		if (MusicPlayer.list.size() <= limitValue) {
			for (int i = 0; i < MusicPlayer.list.size(); i++) {
				songBtn[i] = new JButton(
						new File(MusicPlayer.list.get(i)).getName());
				songBtn[i].setFont(new Font("GODIC", Font.PLAIN, 15));
				songBtn[i].setHorizontalAlignment(JLabel.LEFT);
				songBtn[i].setBorder(null);
				songBtn[i].setFocusable(false);
				songBtn[i].setContentAreaFilled(false);
				songBtn[i].addMouseListener(new songBtnAction(i));
				songBtn[i].setBounds(0, 10 + 19 * i, 200, 15);
				list.add(songBtn[i]);
			}
		} else {
			System.out.println("Error : Too many song to load");
		}
		return list;
	}

	public void showList() {
		subpanel.removeAll();
		subpanel.add(loadWaitList());
		this.setVisible(true);
		subpanel.setVisible(true);
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
