package jagdx;

import jaclib.peer.IUnknown;
import jaclib.peer.hb;

public final class IDirect3DSwapChain extends IUnknown {

	private final hb b;

	public IDirect3DSwapChain(hb arg0) {
		super(arg0);
		this.b = arg0;
	}

	public IDirect3DSurface a(int arg0, int arg1) {
		IDirect3DSurface local5 = new IDirect3DSurface(this.b);
		int local11 = this._GetBackBuffer(arg0, arg1, local5);
		if (ue.a((byte) 97, local11)) {
			throw new fda(String.valueOf(local11));
		}
		return local5;
	}

	private native int _GetBackBuffer(int arg0, int arg1, IDirect3DSurface arg2);

	public native int Present(int arg0);
}
