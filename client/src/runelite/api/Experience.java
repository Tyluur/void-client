package runelite.api;

/**
 * Utility class for experience calculations.
 * Mirrors RuneLite's Experience class.
 */
public class Experience
{
	public static final int MAX_SKILL_XP = 200000000;

	private static final int[] XP_TABLE = new int[100];

	static
	{
		int xp = 0;
		for (int level = 1; level < 100; level++)
		{
			xp += (int) (level + 300 * Math.pow(2.0, level / 7.0));
			XP_TABLE[level] = xp / 4;
		}
	}

	/**
	 * Gets the XP required for a given level.
	 */
	public static int getXpForLevel(int level)
	{
		if (level < 1) return 0;
		if (level >= 99) return XP_TABLE[98];
		return XP_TABLE[level - 1];
	}

	/**
	 * Gets the level for a given XP amount.
	 */
	public static int getLevelForXp(int xp)
	{
		int level = 1;
		while (level < 99 && xp >= XP_TABLE[level])
		{
			level++;
		}
		return level;
	}

	/**
	 * Gets the XP remaining to reach the next level.
	 */
	public static int getXpRemainingToLevel(int currentXp, int targetLevel)
	{
		return getXpForLevel(targetLevel) - currentXp;
	}

	/**
	 * Gets the XP remaining to reach the next level from current level.
	 */
	public static int getXpRemainingToNextLevel(int currentXp)
	{
		int currentLevel = getLevelForXp(currentXp);
		return getXpRemainingToLevel(currentXp, currentLevel + 1);
	}

	/**
	 * Gets the XP gained between two XP values.
	 */
	public static int getXpGained(int startXp, int endXp)
	{
		return endXp - startXp;
	}
}
