package process;

import design.FunctionDock;

public class Update {
  public static void SongInfo(String singer, String songname) {
    MusicPlayer.info_panel.removeAll();
    MusicPlayer.info_panel.getSongInfo(singer, songname);
    MusicPlayer.info_panel.loadInfoPanel(true);
    MusicPlayer.info_panel.updateUI();
  }
  public static void SongList() {
		FunctionDock.demand_list.refresh();
  }
}
