package runelite.hooks;

/**
 * Manager for stat update callbacks.
 * This holds the reference to the callback that the void-client will call.
 */
public class StatCallbackManager
{
	private static StatUpdateCallback callback;

	public static void setCallback(StatUpdateCallback callback)
	{
		StatCallbackManager.callback = callback;
	}

	public static StatUpdateCallback getCallback()
	{
		return callback;
	}
}
