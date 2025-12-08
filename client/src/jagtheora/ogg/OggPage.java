package jagtheora.ogg;

import jagtheora.misc.SimplePeer;

public final class OggPage extends SimplePeer {

	private native int getVersion();

	private native boolean isContinued();

	public native int getSerialNumber();

	private native boolean isEOS();

	private native long getGranulePos();

	public native boolean isBOS();

	protected native void clear();

	private native long getPageNumber();

	private native int getCompletedPackets();
}
