package jagtheora.ogg;

import jagtheora.misc.SimplePeer;

public final class OggSyncState extends SimplePeer {

	public OggSyncState() {
		this.init();
		if (this.b()) {
			throw new IllegalStateException();
		}
	}

	private native boolean reset();

	protected static native void init();

	protected native void clear();

	public native boolean write(byte[] arg0, int arg1);

	public native int pageOut(OggPage arg0);

	private native long pageSeek(OggPage arg0);
}
