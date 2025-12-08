package jagtheora.theora;

import jagtheora.misc.SimplePeer;

public final class GranulePos extends SimplePeer {

	private long position;

	static {
		init();
	}

	protected static native void init();

	protected native void clear();
}
