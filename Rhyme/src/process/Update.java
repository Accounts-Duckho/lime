package process;

public class Update {
  public static void SongInfo(int n) {
	String singer = MusicPlayer.demand_list.singerinfo.get(n);
	String songname = MusicPlayer.demand_list.songinfo.get(n);
    MusicPlayer.info_panel.removeAll();
    MusicPlayer.info_panel.getSongInfo(singer, songname);
    MusicPlayer.info_panel.loadInfoPanel();
    MusicPlayer.info_panel.updateUI();
  }
  public static void SongInfo(String singer, String songname) {
    MusicPlayer.info_panel.removeAll();
    MusicPlayer.info_panel.getSongInfo(singer, songname);
    MusicPlayer.info_panel.loadInfoPanel();
    MusicPlayer.info_panel.updateUI();
  }
  public static void SongInfo(String name) {
	    MusicPlayer.info_panel.removeAll();
	    MusicPlayer.info_panel.getSongInfo(name);
	    MusicPlayer.info_panel.loadInfoPanel();
	    MusicPlayer.info_panel.updateUI();
	  }
  public static void SongList() throws Exception {
		MusicPlayer.demand_list.refresh();
  }
  public static void Background(int i) {
	  MusicPlayer.albumArt.changeBg(i);
  }
  public static void Charset(String songname, String singer) {
	  MusicPlayer.demand_list.fix(songname, singer);
  }
}
