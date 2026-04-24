package runelite.events;

/**
 * Posted every game tick (~600ms).
 */
public class GameTick
{
	private static final GameTick INSTANCE = new GameTick();

	public static GameTick getInstance()
	{
		return INSTANCE;
	}
}
