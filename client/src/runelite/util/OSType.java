package runelite.util;

/**
 * An enum and util function to determine the OS.
 * Adapted from RuneLite for void-client integration.
 */
public enum OSType
{
	Windows,
	MacOS,
	Linux,
	Other;

	private final static OSType OS_TYPE;

	static
	{
		final String OS = System
			.getProperty("os.name", "generic")
			.toLowerCase();

		if ((OS.contains("mac")) || (OS.contains("darwin")))
		{
			OS_TYPE = OSType.MacOS;
		}
		else if (OS.contains("win"))
		{
			OS_TYPE = OSType.Windows;
		}
		else if (OS.contains("nux"))
		{
			OS_TYPE = OSType.Linux;
		}
		else
		{
			OS_TYPE = OSType.Other;
		}
	}

	public static OSType getOSType()
	{
		return OS_TYPE;
	}
}
