package jagtheora.theora;

import jagtheora.misc.SimplePeer;

public final class TheoraComment extends SimplePeer {

	public TheoraComment() {
		this.init();
		if (this.b()) {
			throw new IllegalStateException();
		}
	}

	protected native void clear();

	protected static native void init();
}
