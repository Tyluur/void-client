package runelite.plugins.xptracker;

import runelite.api.Experience;
import runelite.api.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tracks XP state for each skill.
 * Mirrors RuneLite's XpState.
 */
public class XpState
{
	private final Map<Skill, SkillSnapshot> skillSnapshots = new HashMap<>();
	// Maintains the order of skills as they appear in the UI
	private final List<Skill> order = new ArrayList<>(Skill.values().length);

	public void reset()
	{
		skillSnapshots.clear();
		order.clear();
	}

	public void updateSkill(Skill skill, int startXp, int currentXp, int startLevel, int currentLevel)
	{
		skillSnapshots.put(skill, new SkillSnapshot(startXp, currentXp, startLevel, currentLevel));
	}

	public SkillSnapshot getSnapshot(Skill skill)
	{
		return skillSnapshots.get(skill);
	}

	public boolean isTracking(Skill skill)
	{
		return skillSnapshots.containsKey(skill);
	}

	/**
	 * Update the stored order of a skill, following a drag-and-drop operation.
	 *
	 * @param skill       Skill that has been moved
	 * @param newPosition New 0-indexed position of this skill
	 */
	public void setOrder(Skill skill, int newPosition)
	{
		int oldPosition = order.indexOf(skill);
		if (oldPosition != -1 && oldPosition != newPosition)
		{
			order.remove(oldPosition);
			order.add(newPosition, skill);
		}
	}

	/**
	 * Update the order list when a skill gains XP.
	 * If prioritizeRecentSkills is true, moves the skill to the front.
	 * Otherwise, adds it to the end if not already present.
	 *
	 * @param skill                Skill that gained XP
	 * @param prioritizeRecentSkills Whether to prioritize recent skills
	 */
	public void updateOrder(Skill skill, boolean prioritizeRecentSkills)
	{
		if (prioritizeRecentSkills)
		{
			int idx = order.indexOf(skill);
			if (idx != 0)
			{
				order.remove(skill);
				order.add(0, skill);
			}
		}
		else
		{
			if (!order.contains(skill))
			{
				order.add(skill);
			}
		}
	}

	/**
	 * Get the ordered list of skills.
	 *
	 * @return List of skills in their display order
	 */
	public List<Skill> getOrder()
	{
		return order;
	}

	void setCompactView(Skill skill, boolean compactView)
	{
		SkillSnapshot snapshot = skillSnapshots.get(skill);
		if (snapshot != null)
		{
			snapshot.setCompactView(compactView);
		}
	}

	public int getTotalXpGained()
	{
		return skillSnapshots.values().stream().mapToInt(SkillSnapshot::getXpGained).sum();
	}

	public int getTotalXpPerHour()
	{
		long totalElapsed = skillSnapshots.values().stream()
			.filter(s -> s.getXpGained() > 0)
			.mapToLong(SkillSnapshot::getElapsedMs)
			.max().orElse(0);

		if (totalElapsed == 0)
		{
			return 0;
		}

		int totalXp = getTotalXpGained();
		return (int) ((totalXp * 3600000L) / totalElapsed);
	}

	public static class SkillSnapshot
	{
		private final int startXp;
		private int currentXp;
		private final int startLevel;
		private int currentLevel;
		private final long startTime;
		private long lastUpdateTime;
		private boolean compactView;

		public SkillSnapshot(int startXp, int currentXp, int startLevel, int currentLevel)
		{
			this.startXp = startXp;
			this.currentXp = currentXp;
			this.startLevel = startLevel;
			this.currentLevel = currentLevel;
			this.startTime = System.currentTimeMillis();
			this.lastUpdateTime = startTime;
		}

		public void update(int currentXp, int currentLevel)
		{
			this.currentXp = currentXp;
			this.currentLevel = currentLevel;
			this.lastUpdateTime = System.currentTimeMillis();
		}

		public int getStartXp()
		{
			return startXp;
		}

		public int getCurrentXp()
		{
			return currentXp;
		}

		public void setCurrentXp(int xp)
		{
			this.currentXp = xp;
		}

		public int getStartLevel()
		{
			return startLevel;
		}

		public int getCurrentLevel()
		{
			return currentLevel;
		}

		public void setCurrentLevel(int level)
		{
			this.currentLevel = level;
		}

		public void setCompactView(boolean compactView)
		{
			this.compactView = compactView;
		}

		public boolean isCompactView()
		{
			return compactView;
		}

		public int getXpGained()
		{
			return currentXp - startXp;
		}

		public int getLevelsGained()
		{
			return currentLevel - startLevel;
		}

		public long getElapsedMs()
		{
			return lastUpdateTime - startTime;
		}

		public int getXpPerHour()
		{
			long elapsed = getElapsedMs();
			if (elapsed == 0)
			{
				return 0;
			}
			return (int) ((getXpGained() * 3600000L) / elapsed);
		}

		public int getXpRemainingToGoal()
		{
			if (currentLevel >= 99)
			{
				return 0;
			}
			return Experience.getXpForLevel(currentLevel + 1) - currentXp;
		}

		public double getSkillProgressToGoal()
		{
			if (currentLevel >= 99)
			{
				return 100.0;
			}
			int currentLevelBaseXp = Experience.getXpForLevel(currentLevel);
			int nextLevelBaseXp = Experience.getXpForLevel(currentLevel + 1);
			if (nextLevelBaseXp == currentLevelBaseXp)
			{
				return 100.0;
			}
			return ((currentXp - currentLevelBaseXp) * 100.0) / (nextLevelBaseXp - currentLevelBaseXp);
		}

		public String getTimeTillGoalShort()
		{
			int xpRemaining = getXpRemainingToGoal();
			if (xpRemaining <= 0)
			{
				return "Done";
			}
			int xpPerHour = getXpPerHour();
			if (xpPerHour <= 0)
			{
				return "N/A";
			}
			long secondsRemaining = (xpRemaining * 3600L) / xpPerHour;
			if (secondsRemaining < 60)
			{
				return secondsRemaining + "s";
			}
			if (secondsRemaining < 3600)
			{
				return (secondsRemaining / 60) + "m";
			}
			if (secondsRemaining < 86400)
			{
				return (secondsRemaining / 3600) + "h";
			}
			return (secondsRemaining / 86400) + "d";
		}
	}
}
