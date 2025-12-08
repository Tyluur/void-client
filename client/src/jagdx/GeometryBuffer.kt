package jagdx;

import jaclib.memory.Buffer;
import jaclib.peer.hb;
import jaclib.peer.uda;

public final class GeometryBuffer extends uda implements Buffer {

	public GeometryBuffer(hb arg0) {
		super(arg0);
		this.init();
	}

	public native long getAddress();

	@Override
	public void a(byte[] arg0, int arg1, int arg2, int arg3) {
		if (arg2 < 0 | arg0 == null | arg1 < 0 | arg1 + arg3 > arg0.length || arg3 + arg2 > this.getSize()) {
			throw new fda();
		}
		this.putub(arg0, arg1, arg2, arg3);
	}

	private native void getub(byte[] arg0, int arg1, int arg2, int arg3);

	private native void init();

	private native void putub(byte[] arg0, int arg1, int arg2, int arg3);

	public native int getSize();
}
