package activity;

import java.util.LinkedList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;

public final class VolumeControl
{
	public FloatControl getVolumeControl() throws Exception {
		try {
			Mixer.Info mixers[] = AudioSystem.getMixerInfo();
			for (Mixer.Info mixerInfo : mixers) {
				Mixer mixer = AudioSystem.getMixer(mixerInfo);
				mixer.open();

				// we check only target type lines, because we are looking for
				// "SPEAKER target port"
				for (Line.Info info : mixer.getTargetLineInfo()) {
					if (info.toString().contains("SPEAKER")) {
						Line line = mixer.getLine(info);
						try {
							line.open();
						} catch (IllegalArgumentException iae) {
						}
						return (FloatControl) line
								.getControl(FloatControl.Type.VOLUME);
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("problem creating volume control object:" + ex);
			throw ex;
		}
		throw new Exception("unknown problem creating volume control object");
	}
}