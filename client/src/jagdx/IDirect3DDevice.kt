package jagdx;

import jaclib.peer.IUnknown;
import jaclib.peer.hb;

public final class IDirect3DDevice extends IUnknown {

	private static final float[] c = new float[4];

	private final hb b;

	public IDirect3DDevice(hb arg0) {
		super(arg0);
		this.b = arg0;
	}

	public IDirect3DEventQuery b() {
		IDirect3DEventQuery local5 = new IDirect3DEventQuery(this.b);
		if (ue.a(this._CreateEventQuery(local5), false)) {
			return local5;
		} else {
			return null;
		}
	}

	public IDirect3DSwapChain b(int arg0) {
		IDirect3DSwapChain local5 = new IDirect3DSwapChain(this.b);
		int local10 = this._GetSwapChain(arg0, local5);
		if (ue.a((byte) 97, local10)) {
			throw new fda(String.valueOf(local10));
		}
		return local5;
	}

	public native int SetStreamSource(int arg0, IDirect3DVertexBuffer arg1, int arg2, int arg3);

	private native int _CreateEventQuery(IDirect3DEventQuery arg0);

	public int a(int arg0, float[] arg1) {
		return this.SetVertexShaderConstantF(arg0, arg1, arg1.length / 4);
	}

	private native int _CreateCubeTexture(int arg0, int arg1, int arg2, int arg3, int arg4, IDirect3DCubeTexture arg5);

	public int a(int arg0, boolean arg1) {
		return this.SetRenderStateb(arg0, arg1);
	}

	private native int SetRenderStateb(int arg0, boolean arg1);

	public native int Clear(int arg0, int arg1, float arg2, int arg3);

	private native int _CreateVertexBuffer(int arg0, int arg1, int arg2, int arg3, IDirect3DVertexBuffer arg4);

	public IDirect3DTexture a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		IDirect3DTexture local5 = new IDirect3DTexture(this.b);
		int local15 = this._CreateTexture(arg0, arg1, arg2, arg3, arg4, arg5, local5);
		if (ue.a((byte) 97, local15)) {
			throw new fda(String.valueOf(local15));
		}
		return local5;
	}

	public native int EndScene();

	private native int _CreateVolumeTexture(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, IDirect3DVolumeTexture arg7);

	public native int SetTransform(int arg0, float[] arg1);

	private native int SetRenderStatef(int arg0, float arg1);

	public int a(int arg0, float arg1) {
		return this.SetRenderStatef(arg0, arg1);
	}

	public native int BeginScene();

	private native int _GetBackBuffer(int arg0, int arg1, int arg2, IDirect3DSurface arg3);

	public native int SetViewport(int arg0, int arg1, int arg2, int arg3, float arg4, float arg5);

	public native int SetLight(int arg0, D3DLIGHT arg1);

	public IDirect3DPixelShader a(byte[] arg0) {
		if (arg0 == null) {
			return null;
		}
		IDirect3DPixelShader local11 = new IDirect3DPixelShader(this.b);
		int local16 = this._CreatePixelShader(arg0, local11);
		if (ue.a((byte) 97, local16)) {
			throw new fda(String.valueOf(local16));
		}
		return local11;
	}

	public IDirect3DCubeTexture a(int arg0, int arg1, int arg2, int arg3, int arg4) {
		IDirect3DCubeTexture local5 = new IDirect3DCubeTexture(this.b);
		int local14 = this._CreateCubeTexture(arg0, arg1, arg2, arg3, arg4, local5);
		if (ue.a((byte) 97, local14)) {
			throw new fda(String.valueOf(local14));
		}
		return local5;
	}

	public native int Reset(D3DPRESENT_PARAMETERS arg0);

	public native int SetScissorRect(int arg0, int arg1, int arg2, int arg3);

	public native int DrawIndexedPrimitive(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5);

	private native int SetPixelShaderConstantF(int arg0, float[] arg1, int arg2);

	private native int _CreateDepthStencilSurface(int arg0, int arg1, int arg2, int arg3, int arg4, boolean arg5, IDirect3DSurface arg6);

	private native int _CreateVertexDeclaration(VertexElementCollection arg0, IDirect3DVertexDeclaration arg1);

	private native int _GetDepthStencilSurface(IDirect3DSurface arg0);

	public native int SetTextureStageState(int arg0, int arg1, int arg2);

	public native int SetSamplerState(int arg0, int arg1, int arg2);

	private native int _CreateRenderTarget(int arg0, int arg1, int arg2, int arg3, int arg4, boolean arg5, IDirect3DSurface arg6);

	private native int SetFVF(int arg0);

	public native int SetVertexDeclaration(IDirect3DVertexDeclaration arg0);

	public native int DrawPrimitive(int arg0, int arg1, int arg2);

	private native int _CreateTexture(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, IDirect3DTexture arg6);

	private native int _CreateIndexBuffer(int arg0, int arg1, int arg2, int arg3, IDirect3DIndexBuffer arg4);

	public native int SetPixelShader(IDirect3DPixelShader arg0);

	public native int SetVertexShaderConstantF(int arg0, float[] arg1, int arg2);

	public native boolean LightEnable(int arg0, boolean arg1);

	public IDirect3DSurface c(int arg0) {
		IDirect3DSurface local5 = new IDirect3DSurface(this.b);
		int local10 = this._GetRenderTarget(arg0, local5);
		if (ue.a((byte) 97, local10)) {
			throw new fda(String.valueOf(local10));
		}
		return local5;
	}

	public IDirect3DSurface c() {
		IDirect3DSurface local5 = new IDirect3DSurface(this.b);
		int local9 = this._GetDepthStencilSurface(local5);
		if (ue.a((byte) 97, local9)) {
			throw new fda(String.valueOf(local9));
		}
		return local5;
	}

	public native int StretchRect(IDirect3DSurface arg0, int arg1, int arg2, int arg3, int arg4, IDirect3DSurface arg5, int arg6, int arg7, int arg8, int arg9, int arg10);

	public native int SetIndices(IDirect3DIndexBuffer arg0);

	public IDirect3DVertexDeclaration a(VertexElementCollection arg0, IDirect3DVertexDeclaration arg1) {
		if (arg1 == null) {
			arg1 = new IDirect3DVertexDeclaration(this.b);
		} else {
			arg1.a(9275);
		}
		int local18 = this._CreateVertexDeclaration(arg0, arg1);
		if (ue.a((byte) 97, local18)) {
			throw new fda(String.valueOf(local18));
		}
		return arg1;
	}

	public IDirect3DVertexShader b(byte[] arg0) {
		if (arg0 == null) {
			return null;
		}
		IDirect3DVertexShader local11 = new IDirect3DVertexShader(this.b);
		int local16 = this._CreateVertexShader(arg0, local11);
		if (ue.a((byte) 97, local16)) {
			throw new fda(String.valueOf(local16));
		}
		return local11;
	}

	private native int _GetRenderTarget(int arg0, IDirect3DSurface arg1);

	public native int SetVertexShader(IDirect3DVertexShader arg0);

	public IDirect3DIndexBuffer a(int arg0, int arg1, int arg2, int arg3, IDirect3DIndexBuffer arg4) {
		if (arg4 == null) {
			arg4 = new IDirect3DIndexBuffer(this.b);
		} else {
			arg4.a(9275);
		}
		int local21 = this._CreateIndexBuffer(arg0, arg1, arg2, arg3, arg4);
		if (ue.a((byte) 97, local21)) {
			throw new fda(String.valueOf(local21));
		}
		return arg4;
	}

	private native int _CreateVertexShader(byte[] arg0, IDirect3DVertexShader arg1);

	public int a(int arg0, float arg1, float arg2, float arg3, float arg4) {
		c[0] = arg1;
		c[2] = arg3;
		c[3] = arg4;
		c[1] = arg2;
		return this.SetVertexShaderConstantF(arg0, c, 1);
	}

	public int b(int arg0, float arg1, float arg2, float arg3, float arg4) {
		c[3] = arg4;
		c[0] = arg1;
		c[1] = arg2;
		c[2] = arg3;
		return this.SetPixelShaderConstantF(arg0, c, 1);
	}

	public IDirect3DVolumeTexture a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		IDirect3DVolumeTexture local5 = new IDirect3DVolumeTexture(this.b);
		int local16 = this._CreateVolumeTexture(arg0, arg1, arg2, arg3, arg4, arg5, arg6, local5);
		if (ue.a((byte) 97, local16)) {
			throw new fda(String.valueOf(local16));
		}
		return local5;
	}

	public IDirect3DSurface a(int arg0, int arg1, int arg2, int arg3, int arg4, boolean arg5) {
		IDirect3DSurface local5 = new IDirect3DSurface(this.b);
		int local15 = this._CreateRenderTarget(arg0, arg1, arg2, arg3, arg4, arg5, local5);
		if (ue.a((byte) 97, local15)) {
			throw new fda(String.valueOf(local15));
		}
		return local5;
	}

	public IDirect3DVertexBuffer a(int arg0, int arg1, int arg2, int arg3, IDirect3DVertexBuffer arg4) {
		if (arg4 == null) {
			arg4 = new IDirect3DVertexBuffer(this.b);
		} else {
			arg4.a(9275);
		}
		int local20 = this._CreateVertexBuffer(arg0, arg1, arg2, arg3, arg4);
		if (ue.a((byte) 97, local20)) {
			throw new fda(String.valueOf(local20));
		}
		arg4.b = arg0;
		return arg4;
	}

	public native int SetTexture(int arg0, IDirect3DBaseTexture arg1);

	public native int SetRenderState(int arg0, int arg1);

	public native int TestCooperativeLevel();

	private native int _CreateOffscreenPlainSurface(int arg0, int arg1, int arg2, int arg3, IDirect3DSurface arg4);

	private native int _CreatePixelShader(byte[] arg0, IDirect3DPixelShader arg1);

	private native int _GetSwapChain(int arg0, IDirect3DSwapChain arg1);
}
