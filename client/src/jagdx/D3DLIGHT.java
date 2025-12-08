package jagdx;

import jaclib.peer.hb;
import jaclib.peer.uda;

public final class D3DLIGHT extends uda {

	public D3DLIGHT(hb arg0) {
		super(arg0);
		this.Init();
	}

	public native void SetAttenuation(float arg0, float arg1, float arg2);

	public native void SetDiffuse(float arg0, float arg1, float arg2, float arg3);

	private native void Init();

	private native void SetSpecular(float arg0, float arg1, float arg2, float arg3);

	public native void SetAmbient(float arg0, float arg1, float arg2, float arg3);

	private native void SetSpotParams(float arg0, float arg1, float arg2);

	public native void SetPosition(float arg0, float arg1, float arg2);

	public native void SetDirection(float arg0, float arg1, float arg2);

	public native void SetRange(float arg0);

	public native void SetType(int arg0);
}
