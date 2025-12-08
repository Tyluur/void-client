package jagtheora.vorbis;

import jagtheora.misc.SimplePeer;

public final class VorbisComment extends SimplePeer {

	public VorbisComment() {
		this.init();
		if (this.b()) {
			throw new IllegalStateException();
		}
	}

	protected native void clear();

	protected static native void init();
}
