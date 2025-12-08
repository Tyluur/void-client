package jagdx;


import java.awt.*;

public final class D3DPRESENT_PARAMETERS {

	public boolean Windowed;

	private int Flags;

	private int FullScreen_RefreshRateInHz;

	public boolean EnableAutoDepthStencil;

	private final int SwapEffect = 1;

	public int BackBufferFormat = 0;

	public int MultiSampleQuality = 0;

	public int MultiSampleType = 0;

	public int AutoDepthStencilFormat = 0;

	public int BackBufferHeight = 0;

	public int PresentationInterval = 0;

	private final int BackBufferCount = 0;

	public int BackBufferWidth = 0;

	private final Canvas DeviceWindow;

	public D3DPRESENT_PARAMETERS(Canvas arg0) {
		this.DeviceWindow = arg0;
	}
}
