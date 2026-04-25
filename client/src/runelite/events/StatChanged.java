package runelite.events;

import runelite.api.Skill;

/**
 * An event where the experience, level, or boosted level of a {@link Skill} has been modified.
 * Mirrors RuneLite's StatChanged event for plugin compatibility.
 */
public class StatChanged
{
	private final Skill skill;
	private final int xp;
	private final int level;
	private final int boostedLevel;

	public StatChanged(Skill skill, int xp, int level, int boostedLevel)
	{
		this.skill = skill;
		this.xp = xp;
		this.level = level;
		this.boostedLevel = boostedLevel;
	}

	public Skill getSkill()
	{
		return skill;
	}

	public int getXp()
	{
		return xp;
	}

	public int getLevel()
	{
		return level;
	}

	public int getBoostedLevel()
	{
		return boostedLevel;
	}
}
