package jagdx;

import jaclib.peer.hb;
import jaclib.peer.uda;

public final class VertexElementCollection extends uda {

	public VertexElementCollection(hb arg0) {
		super(arg0);
		this.init();
	}

	private native void init();

	public native void finish();

	public native void addElement(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5);

	private native void reset();
}
