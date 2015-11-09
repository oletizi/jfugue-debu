package org.jfugue.midi;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;

public class NullMidiEvent extends MidiEvent {

  public NullMidiEvent() {
    super(new NullMidiMessage(), 0);
  }

  /**
   * Constructs a new <code>MidiEvent</code>.
   *
   * @param message the MIDI message contained in the event
   * @param tick    the time-stamp for the event, in MIDI ticks
   */
  public NullMidiEvent(MidiMessage message, long tick) {
    super(message, tick);
  }

}
