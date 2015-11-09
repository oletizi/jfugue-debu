package org.jfugue.bugs;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

/**
 * Hi David, I just started trying out jFugue for some research I'm doing. I've got it to work with some files following your tutorial:

Pattern pattern = MidiFileManager.loadPatternFromMidi(new File("res/bwv903.mid"));
System.out.println(pattern);

However, sometimes I get messages like the following:

java.lang.ArrayIndexOutOfBoundsException: -4
	at org.staccato.SignatureSubparser.createKeyString(SignatureSubparser.java:117)
	at org.staccato.StaccatoUtil.createKeySignatureElement(StaccatoUtil.java:90)
	at org.staccato.StaccatoParserListener.onKeySignatureParsed(StaccatoParserListener.java:72)
	at org.jfugue.parser.Parser.fireKeySignatureParsed(Parser.java:96)
	at org.jfugue.midi.MidiParser.keySigParsed(MidiParser.java:269)
	at org.jfugue.midi.MidiParser.parseMetaMessage(MidiParser.java:167)
	at org.jfugue.midi.MidiParser.parseEvent(MidiParser.java:123)
	at org.jfugue.midi.MidiParser.parse(MidiParser.java:64)
	at org.jfugue.midi.MidiFileManager.loadPatternFromMidi(MidiFileManager.java:65)
	at org.jfugue.midi.MidiFileManager.loadPatternFromMidi(MidiFileManager.java:71)


Which traces back to here (last line is 117, where the error occurs):

public String createKeyString(byte notePositionInOctave, byte scale) {
       StringBuilder buddy = new StringBuilder();
       buddy.append(Note.NOTE_NAMES_COMMON[notePositionInOctave]);

For whatever reason I don't have time to look into, "notePositionInOctave" holds a negative byte value. Looks like it has to do with keySigParsed and meta[0] holding bad values. I don't know your API well enough to offer a fix at the current time, but just thought you should know. The mid file to reproduce this is attached.


 * Requires: beethoven-fifth.mid
 * 
 * Solution: When reading from MIDI, MidiParser incorrectly interpreted the first data item of the Key Signature to be the root note's position in octave,
 * but really it is the accidental count. Added a convertAccidentalCountToKeyRootPositionInOctave() method to KeyProvider.
 * 
 */
public class Bug_2015_04_05_StephenDunn_KeySig {
	public static void main(String[] args) throws IOException, InvalidMidiDataException {
		Pattern pattern = MidiFileManager.loadPatternFromMidi(new File("src/bugs/resources/beethoven-fifth.mid"));
		System.out.println(pattern);
		new Player().play(pattern);
	}
}
