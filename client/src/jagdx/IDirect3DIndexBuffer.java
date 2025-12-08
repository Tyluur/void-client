package jagdx;

import jaclib.peer.IUnknown;
import jaclib.peer.hb;

public final class IDirect3DIndexBuffer extends IUnknown {

	public IDirect3DIndexBuffer(hb arg0) {
		super(arg0);
	}

	@Override
	protected long a() {
		return super.a();
	}

	public native int Unlock();

	public native int Lock(int arg0, int arg1, int arg2, GeometryBuffer arg3);

	private native boolean _Update(long arg0, int arg1, int arg2);
}
