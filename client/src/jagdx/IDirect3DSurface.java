package jagdx;

import jaclib.peer.IUnknown;
import jaclib.peer.hb;

public final class IDirect3DSurface extends IUnknown {

	public IDirect3DSurface(hb arg0) {
		super(arg0);
	}

	public native int LockRect(int arg0, int arg1, int arg2, int arg3, int arg4, PixelBuffer arg5);

	public native boolean UnlockRect();
}
