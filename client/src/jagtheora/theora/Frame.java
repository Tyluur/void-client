package jagtheora.theora;

import jagtheora.misc.SimplePeer;

public final class Frame extends SimplePeer {

	public final int b;

	public final int a;

	public final int[] pixels;

	static {
		init();
	}

	protected static native void init();

	public Frame(int arg0, int arg1) {
		this.b = arg1;
		this.a = arg0;
		this.pixels = new int[this.a * this.b];
	}

	protected native void clear();
}
