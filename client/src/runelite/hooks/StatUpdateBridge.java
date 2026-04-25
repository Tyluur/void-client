package runelite.hooks;

import runelite.api.Client;
import runelite.api.Skill;
import runelite.eventbus.EventBus;
import runelite.events.StatChanged;

/**
 * Bridge between void-client's StatUpdateCallback and RuneLite's StatChanged event.
 * This converts the low-level callback from the void-client into a RuneLite event
 * that plugins can subscribe to.
 */
public class StatUpdateBridge implements StatUpdateCallback
{
	private final EventBus eventBus;
	private final Client client;

	public StatUpdateBridge(EventBus eventBus, Client client)
	{
		this.eventBus = eventBus;
		this.client = client;
	}

	@Override
	public void onStatUpdate(int skillIndex, int xp, int boostedLevel)
	{
		// Convert skill index to Skill enum
		if (skillIndex < 0 || skillIndex >= Skill.values().length)
		{
			System.err.println("[StatUpdateBridge] Invalid skill index: " + skillIndex);
			return; // Invalid skill index
		}

		Skill skill = Skill.values()[skillIndex];

		// Calculate real level from XP
		int realLevel = runelite.api.Experience.getLevelForXp(xp);

		System.out.println("[StatUpdateBridge] Stat update: " + skill + " XP=" + xp + " Level=" + realLevel + " Boosted=" + boostedLevel);

		// Fire StatChanged event
		eventBus.post(new StatChanged(skill, xp, realLevel, boostedLevel));
	}

	/**
	 * Register this bridge with the void-client's callback system.
	 */
	public static void register(EventBus eventBus, Client client)
	{
		StatUpdateBridge bridge = new StatUpdateBridge(eventBus, client);
		StatCallbackManager.setCallback(bridge);
		System.out.println("[StatUpdateBridge] Registered callback with void-client");
	}

	/**
	 * Unregister the bridge from the void-client.
	 */
	public static void unregister()
	{
		StatCallbackManager.setCallback(null);
		System.out.println("[StatUpdateBridge] Unregistered callback from void-client");
	}
}
