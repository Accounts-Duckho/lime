package process;

import java.awt.Image;

import design.FunctionDock;

public class Update {
  public static void SongInfo(String singer, String songname) {
    MusicPlayer.info_panel.removeAll();
    MusicPlayer.info_panel.getSongInfo(singer, songname);
    MusicPlayer.info_panel.loadInfoPanel();
    MusicPlayer.info_panel.updateUI();
  }
  public static void SongList() {
		FunctionDock.demand_list.refresh();
  }
  public static void Background(Image img) {
	  MusicPlayer.background.changeBg(img);
  }
  public static void Charset(String songname, String singer) {
	  FunctionDock.demand_list.fix(songname, singer);
  }
}
