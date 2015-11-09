package org.jfugue.experiments;

import org.jfugue.devtools.DiagnosticParserListener;
import org.jfugue.pattern.Pattern;
import org.staccato.StaccatoParser;

/**
 * http://stackoverflow.com/questions/29095780/transposing-the-key-using-jfugue-some-questions-concerning-jfugue
 * 
 * I have a couple of questions concerning JFugue (5, the beta version). 
 * 
 * From The complete guide to JFugue, it is mentioned that depending on the Key Signature in the pattern, 
 * JFugue interprets the note value. As an example, in the case of an F-major key, B would be automatically 
 * translated to B-flat, unless we write "Bn" instead. The question is that if we are dealing with an F major 
 * key and write "Bb" how would JFugue interpret it ? As "Bbb" or as a "Bb" note ?
 * 
 * My second question is about transposing Keys in JFugue. 
 * What is the fastest way of doing so ?
 * 
 */
public class Exp_2015_03_17_HusseinHammoud_Transposing {
	public static void main(String[] args) {
		StaccatoParser parser = new StaccatoParser();
		DiagnosticParserListener dpl = new DiagnosticParserListener();
		parser.addParserListener(dpl);

		Pattern pattern = new Pattern("KEY:Cmaj B Bn Bb   KEY:FMaj B Bn Bb");
		parser.parse(pattern);
	}
}
