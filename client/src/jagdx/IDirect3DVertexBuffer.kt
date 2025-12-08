package jagdx;

import jaclib.memory.Source;
import jaclib.peer.IUnknown;
import jaclib.peer.hb;

public final class IDirect3DVertexBuffer extends IUnknown {

	public int b;

	public IDirect3DVertexBuffer(hb arg0) {
		super(arg0);
	}

	private native boolean _Update(long arg0, int arg1, int arg2, int arg3);

	public boolean a(Source arg0, int arg1, int arg2, int arg3, int arg4) {
		if (arg0 == null || arg3 > arg0.getSize() + arg1) {
			throw new fda("");
		} else if (arg3 > arg2 + this.b) {
			throw new fda("");
		} else {
			return this._Update((long) arg1 + arg0.getAddress(), arg2, arg3, arg4);
		}
	}

	public native int Unlock();

	@Override
	protected long a() {
		this.b = 0;
		return super.a();
	}

	public native int Lock(int arg0, int arg1, int arg2, GeometryBuffer arg3);
}
