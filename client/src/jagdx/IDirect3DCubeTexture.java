package jagdx;

import jaclib.peer.hb;

public final class IDirect3DCubeTexture extends IDirect3DBaseTexture {

	public IDirect3DCubeTexture(hb arg0) {
		super(arg0);
	}

	public native int LockRect(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, PixelBuffer arg7);

	public native boolean UnlockRect(int arg0, int arg1);
}
