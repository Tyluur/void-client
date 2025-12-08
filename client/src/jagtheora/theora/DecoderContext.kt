package jagtheora.theora;

import jagtheora.misc.SimplePeer;
import jagtheora.ogg.OggPacket;

public final class DecoderContext extends SimplePeer {

	public DecoderContext(TheoraInfo arg0, SetupInfo arg1) {
		this.init(arg0, arg1);
		if (this.b()) {
			throw new IllegalArgumentException("");
		}
	}

	public native long granuleFrame(GranulePos arg0);

	protected native void clear();

	public native int setPostProcessingLevel(int arg0);

	public native int decodePacketIn(OggPacket arg0, GranulePos arg1);

	public native int getMaxPostProcessingLevel();

	public native double granuleTime(GranulePos arg0);

	private native int setGranulePosition(long arg0);

	private native void init(TheoraInfo arg0, SetupInfo arg1);

	public native int decodeFrame(Frame arg0);
}
