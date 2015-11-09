package org.jfugue.midi;

import javax.sound.midi.MidiMessage;

public class NullMidiMessage extends MidiMessage {

  public NullMidiMessage() {
    this(new byte[4]);
  }

  /**
   * Constructs a new <code>MidiMessage</code>.  This protected
   * constructor is called by concrete subclasses, which should
   * ensure that the data array specifies a complete, valid MIDI
   * message.
   *
   * @param data an array of bytes containing the complete message.
   *             The message data may be changed using the <code>setMessage</code>
   *             method.
   * @see #setMessage
   */
  protected NullMidiMessage(byte[] data) {
    super(data);
  }

  @Override
  public Object clone() {
    return this;
  }
}
