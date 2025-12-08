package jagdx;

import jaclib.peer.IUnknown;
import jaclib.peer.hb;

import java.awt.*;

public final class IDirect3D extends IUnknown {

	private final hb b;

	public static IDirect3D a(int arg0, hb arg1) {
		IDirect3D local4 = new IDirect3D(arg1);
		int local8 = _Direct3DCreate(arg0, local4);
		if (ue.a((byte) 97, local8)) {
			throw new fda(String.valueOf(local8));
		}
		return local4;
	}

	private static native int _Direct3DCreate(int arg0, IDirect3D arg1);

	private IDirect3D(hb arg0) {
		super(arg0);
		this.b = arg0;
	}

	public int a(int arg0, D3DDISPLAYMODE arg1) {
		return this._GetAdapterDisplayMode(arg0, arg1);
	}

	public IDirect3DDevice a(int arg0, int arg1, Canvas arg2, int arg3, D3DPRESENT_PARAMETERS arg4) {
		IDirect3DDevice local5 = new IDirect3DDevice(this.b);
		int local14 = this._CreateDevice(arg0, arg1, arg2, arg3, arg4, local5);
		if (ue.a((byte) 97, local14)) {
			throw new fda(String.valueOf(local14));
		}
		return local5;
	}

	public D3DADAPTER_IDENTIFIER a(int arg0, int arg1) {
		D3DADAPTER_IDENTIFIER local3 = new D3DADAPTER_IDENTIFIER();
		int local9 = this._GetAdapterIdentifier(arg0, arg1, local3);
		if (ue.a((byte) 97, local9)) {
			throw new fda(String.valueOf(local9));
		}
		return local3;
	}

	public native int CheckDeviceType(int arg0, int arg1, int arg2, int arg3, boolean arg4);

	public D3DCAPS b(int arg0, int arg1) {
		D3DCAPS local3 = new D3DCAPS();
		int local9 = this._GetDeviceCaps(arg0, arg1, local3);
		if (ue.a((byte) 97, local9)) {
			throw new fda(String.valueOf(local9));
		}
		return local3;
	}

	public native int CheckDeviceMultiSampleType(int arg0, int arg1, int arg2, boolean arg3, int arg4);

	private native int _GetAdapterDisplayMode(int arg0, D3DDISPLAYMODE arg1);

	private native int _CreateDevice(int arg0, int arg1, Canvas arg2, int arg3, D3DPRESENT_PARAMETERS arg4, IDirect3DDevice arg5);

	public native int CheckDepthStencilMatch(int arg0, int arg1, int arg2, int arg3, int arg4);

	public native int CheckDeviceFormat(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5);

	private native int _GetAdapterIdentifier(int arg0, int arg1, D3DADAPTER_IDENTIFIER arg2);

	private native int _GetDeviceCaps(int arg0, int arg1, D3DCAPS arg2);
}
