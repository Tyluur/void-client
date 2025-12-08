package jagtheora.ogg;

import jagtheora.misc.SimplePeer;

public final class OggStreamState extends SimplePeer {

	public OggStreamState(int arg0) {
		if (!this.init(arg0)) {
			throw new IllegalStateException();
		}
	}

	public native int packetPeek(OggPacket arg0);

	private native int packetPeek();

	private native boolean init(int arg0);

	private native boolean isEOS();

	protected native void clear();

	public native boolean pageIn(OggPage arg0);

	private native boolean reset();

	public native int packetOut();

	public native int packetOut(OggPacket arg0);

	private native boolean resetSerialNo(int arg0);
}
