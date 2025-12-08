package jagdx;

import jaclib.peer.IUnknown;
import jaclib.peer.hb;

public final class IDirect3DEventQuery extends IUnknown {

	public IDirect3DEventQuery(hb arg0) {
		super(arg0);
	}

	public native int Issue();

	public native int IsSignaled();
}
