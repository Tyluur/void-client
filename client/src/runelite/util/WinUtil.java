package runelite.util;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;
import java.awt.Frame;
import java.awt.Window;

/**
 * Windows-specific utility functions.
 * Adapted from RuneLite for void-client integration.
 */
public class WinUtil
{
	private static boolean isWindowArrangedSupported = OSType.getOSType() == OSType.Windows;

	/**
	 * Forcibly set focus to the given component
	 *
	 */
	public static void requestForeground(Frame frame)
	{
		// SetForegroundWindow can't set iconified windows to foreground, so set the
		// frame state to normal first
		frame.setState(Frame.NORMAL);

		User32 user32 = User32.INSTANCE;

		// Windows does not allow any process to set the foreground window, but it will if
		// the process received the last input event. So we send a F22 key event to the process.
		// https://docs.microsoft.com/en-us/windows/win32/api/winuser/nf-winuser-setforegroundwindow
		WinUser.INPUT input = new WinUser.INPUT();
		input.type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
		input.input.ki.wVk = new WinDef.WORD(0x85); // VK_F22
		user32.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());

		// Now we may set the foreground window
		WinDef.HWND hwnd = new WinDef.HWND(Native.getComponentPointer(frame));
		user32.SetForegroundWindow(hwnd);
	}

	interface RLUser32 extends StdCallLibrary
	{
		RLUser32 INSTANCE = Native.load("user32", RLUser32.class, W32APIOptions.DEFAULT_OPTIONS);

		boolean IsWindowArranged(Pointer hwnd);
	}

	public static boolean isWindowArranged(Window window)
	{
		if (!isWindowArrangedSupported || !window.isDisplayable())
		{
			return false;
		}

		try
		{
			Pointer hwnd = Native.getComponentPointer(window);
			return RLUser32.INSTANCE.IsWindowArranged(hwnd);
		}
		catch (LinkageError ignored)
		{
			// IsWindowArranged is only since Win 10 1903
			isWindowArrangedSupported = false;
			return false;
		}
	}
}
