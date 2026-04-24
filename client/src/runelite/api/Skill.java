package runelite.api;

/**
 * RuneLite-compatible Skill enum.
 */
public enum Skill
{
	ATTACK,
	DEFENCE,
	STRENGTH,
	HITPOINTS,
	RANGED,
	PRAYER,
	MAGIC,
	COOKING,
	WOODCUTTING,
	FLETCHING,
	FISHING,
	FIREMAKING,
	CRAFTING,
	SMITHING,
	MINING,
	HERBLORE,
	AGILITY,
	THIEVING,
	SLAYER,
	FARMING,
	RUNECRAFT,
	HUNTER,
	CONSTRUCTION,
	SUMMONING,
	DUNGEONEERING,
	OVERALL;

	private static final Skill[] VALUES = values();

	/**
	 * Gets the skill name in title case.
	 */
	public String getName()
	{
		String name = name();
		return name.charAt(0) + name.substring(1).toLowerCase();
	}

	/**
	 * Gets a skill by its ordinal index.
	 */
	public static Skill fromIndex(int index)
	{
		if (index >= 0 && index < VALUES.length)
		{
			return VALUES[index];
		}
		return null;
	}
}
