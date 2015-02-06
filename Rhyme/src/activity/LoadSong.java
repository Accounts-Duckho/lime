/*
 *  Author : SooMan
 */
package activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LoadSong implements ActionListener {
	public void actionPerformed(ActionEvent e) {
  JFileChooser chooser=new JFileChooser();
  FileFilter filter=new FileNameExtensionFilter("music file","mp3", "wav", "m4a");
  chooser.addChoosableFileFilter(filter); 
  int value = chooser.showOpenDialog(null);
  if(value==JFileChooser.APPROVE_OPTION)
  {
   File file=chooser.getSelectedFile(); // file link
  }
 }
}