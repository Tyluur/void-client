package jagdx;

import jaclib.peer.hb;

public final class IDirect3DTexture extends IDirect3DBaseTexture {

	public IDirect3DTexture(hb arg0) {
		super(arg0);
	}

	public native int LockRect(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, PixelBuffer arg6);

	public native boolean UnlockRect(int arg0);
}
