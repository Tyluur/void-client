package jagtheora.theora;

import jagtheora.misc.SimplePeer;

public final class TheoraInfo extends SimplePeer {

	private int colourSpace;

	private byte versionSubMinor;

	public int fpsNumerator;

	private int pixelFormat;

	private int picY;

	private int aspectDenominator;

	private int picWidth;

	private byte versionMinor;

	private int picX;

	private int picHeight;

	public int fpsDenominator;

	private byte versionMajor;

	public int frameWidth;

	private int aspectNumerator;

	public int frameHeight;

	static {
		initFields();
	}

	private static native void initFields();

	public TheoraInfo() {
		this.init();
		if (this.b()) {
			throw new IllegalStateException();
		}
	}

	protected native void clear();

	protected static native void init();
}
