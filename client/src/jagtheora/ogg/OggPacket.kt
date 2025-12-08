package jagtheora.ogg;

import jagtheora.misc.SimplePeer;

public final class OggPacket extends SimplePeer {

	public native boolean isTheora();

	protected native void clear();

	public native byte[] getData();

	private native int isHeader();

	public native int isKeyFrame();

	public native boolean isVorbis();
}
