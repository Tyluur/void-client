package runelite.hooks;

/**
 * Callback interface for stat/XP updates from the void-client.
 * This allows the RuneLite integration to be notified immediately when stats change
 * without polling, matching RuneLite's event-driven architecture.
 */
public interface StatUpdateCallback
{
	/**
	 * Called when a skill's XP or boosted level is updated from the server.
	 *
	 * @param skillIndex The skill index (0-22, matching Skill enum ordinals)
	 * @param xp The new XP value
	 * @param boostedLevel The new boosted level
	 */
	void onStatUpdate(int skillIndex, int xp, int boostedLevel);
}
