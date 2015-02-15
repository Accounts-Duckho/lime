package activity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class ListAdmin {
	private static ArrayList<String> songs = new ArrayList<String>();
	private static ArrayList<String> dirs = new ArrayList<String>();
	private static int count=0;
	static String userHome = System.getProperty("user.home");
	public static void getList(String song, String dir) throws IOException {
		songs.add(song);
		dirs.add(dir);
		count++;
	}
	public static void saveList() throws IOException {
		Writer count_value = new FileWriter(userHome+"\\count.txt", false);
		count_value.write(Integer.toString(count));
		count_value.close();
		Writer songlist = new FileWriter(userHome+"\\songlist.txt", true);
		Writer dirlist = new FileWriter(userHome+"\\dirlist.txt", true);
		for(int i=0; i<count; i++) 
		{
		songlist.write(songs.get(i)+"\n");
		dirlist.write(dirs.get(i)+"\n"); 
		}
		songlist.close();
		dirlist.close();
	}
	public static void loadList() throws Exception {
		BufferedReader readcount = new BufferedReader(new FileReader(userHome+"\\count.txt"));
		count = Integer.parseInt(readcount.readLine());
		readcount.close();
		BufferedReader readsongs = new BufferedReader(new FileReader(userHome+"\\songlist.txt"));
		BufferedReader readdirs = new BufferedReader(new FileReader(userHome+"\\dirs.txt"));
		songs = null;
		dirs = null;
		songs = new ArrayList<String>();
		dirs = new ArrayList<String>();
		while(readsongs.readLine()!=null | readdirs.readLine()!=null) {
			songs.add(readsongs.readLine());
			dirs.add(readdirs.readLine());
		}
		readsongs.close();
		readdirs.close();
	}
}
