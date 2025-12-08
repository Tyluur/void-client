package jagtheora.vorbis;

import jagtheora.misc.SimplePeer;

public final class DSPState extends SimplePeer {

	public DSPState(VorbisInfo arg0) {
		this.init(arg0);
		if (this.b()) {
			throw new IllegalStateException();
		}
	}

	public native float[][] pcmOut(int arg0);

	private native void init(VorbisInfo arg0);

	public native void read(int arg0);

	public native void blockIn(VorbisBlock arg0);

	protected native void clear();

	public native double granuleTime();
}
