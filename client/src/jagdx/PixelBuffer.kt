package jagdx;

import jaclib.memory.Buffer;
import jaclib.peer.hb;
import jaclib.peer.uda;

public final class PixelBuffer extends uda implements Buffer {

	public PixelBuffer(hb arg0) {
		super(arg0);
		this.init();
	}

	public native int getRowPitch();

	private native void getub(byte[] arg0, int arg1, int arg2, int arg3);

	@Override
	public void a(byte[] arg0, int arg1, int arg2, int arg3) {
		if (arg2 < 0 | arg0 == null | arg1 < 0 | arg3 + arg1 > arg0.length || this.getSize() < arg3 + arg2) {
			throw new fda();
		}
		this.putub(arg0, arg1, arg2, arg3);
	}

	private native void putub(byte[] arg0, int arg1, int arg2, int arg3);

	public void a(int[] arg0, int arg1, int arg2, int arg3) {
		if (arg2 < 0 | arg1 + arg3 > arg0.length | arg1 < 0 | arg0 == null || arg3 * 4 + arg2 > this.getSize()) {
			throw new fda();
		}
		this.puti(arg0, arg1, arg2, arg3);
	}

	private native void init();

	@Override
	public long getAddress() {
		return 0L;
	}

	public native int getSize();

	public void b(int[] arg0, int arg1, int arg2, int arg3) {
		if (arg1 < 0 | arg0 == null | arg3 + arg1 > arg0.length | arg2 < 0 || this.getSize() < arg3 * 4 + arg2) {
			throw new fda();
		}
		this.geti(arg0, arg1, arg2, arg3);
	}

	private native void puti(int[] arg0, int arg1, int arg2, int arg3);

	private native void geti(int[] arg0, int arg1, int arg2, int arg3);

	public native int getSlicePitch();
}
