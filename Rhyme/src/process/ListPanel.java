package process;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import action.Get;
import action.PlaySong;

@SuppressWarnings("serial")
public class ListPanel extends JPanel {
	private final int PLAY = 1;
	private JButton[] songBtn;

	public ListPanel() {
		setVisible(false);
		setLayout(new BorderLayout());
		setBackground(new Color(255, 255, 255));
		songBtn = new JButton[149];
		setPreferredSize(new Dimension(348, 206));
	}

	public JComponent loadWaitList() {
		JLayeredPane list = new JLayeredPane();
		Get get = new Get();
		if (MusicPlayer.songList.size() <= 150) {
			for (int i = 0; i < MusicPlayer.songList.size(); i++) {
				songBtn[i] = new JButton();
				songBtn[i].setBorder(null);
				songBtn[i].setFocusable(false);
				songBtn[i].setContentAreaFilled(false);
				String songname = new String(new File(MusicPlayer.songList.get(i)).getName()).replaceFirst("[.][^.]+$",
						"");
				get.metaData(i);
				int minute = get.duration() / 60;
				int second = get.duration() % 60;
				songBtn[i].addMouseListener(new songBtnAction(i));
				songBtn[i].setBounds(0, 10 + 17 * i, 348, 17);
				songBtn[i].setText(songname + "|" + minute + ":" + String.format("%02d", second));
				songBtn[i].setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
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
		setPreferredSize(new Dimension(348, 10 + 17 * MusicPlayer.songList.size()));
		MusicPlayer.songList_scrollBar.getViewport().add(MusicPlayer.songList_panel);
		setVisible(true);
	}

	class songBtnAction extends MouseAdapter {
		private int count;

		public songBtnAction(int n) {
			count = n;
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				try {
					PlaySong playAction = new PlaySong();
					MusicPlayer.changeRequested=true;
					System.out.println(count);
					MusicPlayer.songQueue = count;
					MusicPlayer.playStatus = PLAY;
					MusicPlayer.control_panel.switch_btn();
					playAction.readySong();
					playAction.playSong();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
