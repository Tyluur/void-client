package jaclib.hardware_info;


public final class HardwareInfo {

	private static native String[][] getDXDiagDisplayDevicesProps();

	public static native int[] getCPUInfo();

	private static native String[] getOpenGLProps();

	private static native String[] getDXDiagSystemProps();

	private HardwareInfo() {
	}
}
