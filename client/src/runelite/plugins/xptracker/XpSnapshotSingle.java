package runelite.plugins.xptracker;

class XpSnapshotSingle
{
	private final int startLevel;
	private final int endLevel;
	private final int startGoalXp;
	private final int endGoalXp;
	private final int xpGainedInSession;
	private final int xpRemainingToGoal;
	private final int xpPerHour;
	private final double skillProgressToGoal;
	private final String timeTillGoalShort;
	private final boolean compactView;

	XpSnapshotSingle(int startLevel, int endLevel, int startGoalXp, int endGoalXp,
					 int xpGainedInSession, int xpRemainingToGoal, int xpPerHour,
					 double skillProgressToGoal, String timeTillGoalShort, boolean compactView)
	{
		this.startLevel = startLevel;
		this.endLevel = endLevel;
		this.startGoalXp = startGoalXp;
		this.endGoalXp = endGoalXp;
		this.xpGainedInSession = xpGainedInSession;
		this.xpRemainingToGoal = xpRemainingToGoal;
		this.xpPerHour = xpPerHour;
		this.skillProgressToGoal = skillProgressToGoal;
		this.timeTillGoalShort = timeTillGoalShort;
		this.compactView = compactView;
	}

	int getStartLevel()
	{
		return startLevel;
	}

	int getEndLevel()
	{
		return endLevel;
	}

	int getStartGoalXp()
	{
		return startGoalXp;
	}

	int getEndGoalXp()
	{
		return endGoalXp;
	}

	int getXpGainedInSession()
	{
		return xpGainedInSession;
	}

	int getXpRemainingToGoal()
	{
		return xpRemainingToGoal;
	}

	int getXpPerHour()
	{
		return xpPerHour;
	}

	double getSkillProgressToGoal()
	{
		return skillProgressToGoal;
	}

	String getTimeTillGoalShort()
	{
		return timeTillGoalShort;
	}

	boolean isCompactView()
	{
		return compactView;
	}
}
