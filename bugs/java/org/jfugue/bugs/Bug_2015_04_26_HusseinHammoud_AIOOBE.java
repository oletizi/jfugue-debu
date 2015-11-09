package org.jfugue.bugs;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

/**
 * Problem:
 * 
Pattern p = MidiFileManager.loadPatternFromMidi(f);
 
f is my midi file.
This call is giving me an ArrayIndexOutOfBoundException.
Please find the file in question attached (named “mz_333_1_Bbmajor.mid”).
 
 
 Also, I would like to point out another potential bug:
After parsing a midi file successfully (using JFugue 5), the obtained pattern says “Key:Cmin” rather than “Key:Cmaj”.
Using JFugue 5 the beta version gave me “Cmaj” key which is correct.
Please also find the involved file in question attached.

 *
 * Solution: Fixed with StephenDunn_KeySig
 *  
 * @author dkoelle
 *
 */
public class Bug_2015_04_26_HusseinHammoud_AIOOBE {
	public static void main(String[] args) throws IOException, InvalidMidiDataException {
		Pattern p = MidiFileManager.loadPatternFromMidi(new File("src/bugs/resources/mz_333_1_Bbmajor.mid"));
		System.out.println(p);
		
		Pattern p2 = MidiFileManager.loadPatternFromMidi(new File("src/bugs/resources/mz_545_1_Cmajor.mid"));
		System.out.println(p2);
	}

}
