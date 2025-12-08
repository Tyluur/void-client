package jagtheora.vorbis;

import jagtheora.misc.SimplePeer;
import jagtheora.ogg.OggPacket;

public final class VorbisInfo extends SimplePeer {

	public int rate;

	public int channels;

	static {
		initFields();
	}

	private static native void initFields();

	public VorbisInfo() {
		this.init();
		if (this.b()) {
			throw new IllegalStateException();
		}
	}

	protected static native void init();

	public native int headerIn(VorbisComment arg0, OggPacket arg1);

	protected native void clear();
}
