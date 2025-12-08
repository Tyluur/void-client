package jagdx;

import jaclib.peer.hb;

public final class IDirect3DVolumeTexture extends IDirect3DBaseTexture {

	public IDirect3DVolumeTexture(hb arg0) {
		super(arg0);
	}

	public native boolean UnlockBox(int arg0);

	public native int LockBox(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, PixelBuffer arg8);
}
