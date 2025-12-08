package jagtheora.vorbis;

import jagtheora.misc.SimplePeer;
import jagtheora.ogg.OggPacket;

public final class VorbisBlock extends SimplePeer {

	public VorbisBlock(DSPState arg0) {
		this.init(arg0);
		if (this.b()) {
			throw new IllegalStateException();
		}
	}

	protected native void clear();

	private native void init(DSPState arg0);

	public native int synthesis(OggPacket arg0);
}
