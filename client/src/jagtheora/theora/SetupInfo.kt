package jagtheora.theora;

import jagtheora.misc.SimplePeer;
import jagtheora.ogg.OggPacket;

public final class SetupInfo extends SimplePeer {

	public native int decodeHeader(TheoraInfo arg0, TheoraComment arg1, OggPacket arg2);

	protected native void clear();
}
