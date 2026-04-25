package runelite.plugins.xptracker;

import com.google.inject.Inject;
import runelite.api.Client;
import runelite.api.Experience;
import runelite.api.GameState;
import runelite.api.Skill;
import runelite.config.ConfigGroup;
import runelite.eventbus.Subscribe;
import runelite.events.GameTick;
import runelite.plugins.Plugin;
import runelite.plugins.PluginDescriptor;
import runelite.ui.ColorScheme;
import runelite.ui.NavigationButton;
import runelite.ui.overlay.OverlayManager;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

/**
 * XP Tracker plugin - tracks experience gains across all skills.
 * Ported from RuneLite with adaptations for void-client.
 */
@PluginDescriptor(
	name = "XP Tracker",
	description = "Track experience gains and levels"
)
public class XpTrackerPlugin extends Plugin
{
	@Inject private Client client;
	@Inject private OverlayManager overlayManager;

	// Config interface - injected by PluginManager (not Guice)
	private XpTrackerConfig config;

	private NavigationButton navButton;
	private XpPanel xpPanel;
	private XpState xpState = new XpState();
	private int lastTick = 0;

	@Override
	protected void startUp()
	{
		xpState = new XpState();
		xpPanel = new XpPanel(this, config, client);

		navButton = NavigationButton.builder()
			.priority(5)
			.icon(createIcon())
			.tooltip("XP Tracker")
			.panel(xpPanel)
			.build();

		// Initialize with current XP if logged in
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			initializeSkills();
		}
	}

	@Override
	protected void shutDown()
	{
		overlayManager.removeIf(e -> e instanceof XpInfoBoxOverlay);
		xpState = null;
	}

	@Override
	public NavigationButton getNavigationButton()
	{
		return navButton;
	}

	@Subscribe
	private void onGameTick(GameTick tick)
	{
		GameState state = client.getGameState();
		if (state != GameState.LOGGED_IN)
		{
			return;
		}

		checkSkillChanges();
	}

	private void initializeSkills()
	{
		for (Skill skill : Skill.values())
		{
			if (skill == Skill.OVERALL)
			{
				continue;
			}

			int currentXp = client.getSkillExperience(skill);
			int currentLevel = client.getRealSkillLevel(skill);

			xpState.updateSkill(skill, currentXp, currentXp, currentLevel, currentLevel);
		}
	}

	private void checkSkillChanges()
	{
		java.util.Set<Skill> changedSkills = new java.util.HashSet<>();

		// Iterate through skills in the stored order, falling back to enum order if empty
		java.util.List<Skill> skillsToCheck = xpState.getOrder().isEmpty()
			? java.util.Arrays.asList(Skill.values())
			: new java.util.ArrayList<>(xpState.getOrder());

		for (Skill skill : skillsToCheck)
		{
			if (skill == Skill.OVERALL)
			{
				continue;
			}

			int currentXp = client.getSkillExperience(skill);
			int currentLevel = client.getRealSkillLevel(skill);

			if (!xpState.isTracking(skill))
			{
				xpState.updateSkill(skill, currentXp, currentXp, currentLevel, currentLevel);
			}
			else
			{
				XpState.SkillSnapshot snapshot = xpState.getSnapshot(skill);
				// Re-initialize if snapshot was created with 0 XP before real data loaded
				if (snapshot.getStartXp() == 0 && currentXp > 0)
				{
					xpState.updateSkill(skill, currentXp, currentXp, currentLevel, currentLevel);
					changedSkills.add(skill);
				}
				else if (currentXp != snapshot.getCurrentXp() || currentLevel != snapshot.getCurrentLevel())
				{
					snapshot.update(currentXp, currentLevel);
					changedSkills.add(skill);
					// Update order to prioritize this skill (recent XP)
					xpState.updateOrder(skill, true);
				}
			}
		}

		// Update panel with snapshot data for all tracked skills in order
		for (Skill skill : xpState.getOrder())
		{
			if (skill == Skill.OVERALL)
			{
				continue;
			}

			XpState.SkillSnapshot snapshot = xpState.getSnapshot(skill);
			if (snapshot == null)
			{
				continue;
			}

			boolean skillChanged = changedSkills.contains(skill);
			XpSnapshotSingle singleSnapshot = createSnapshot(snapshot);
			xpPanel.updateSkillExperience(skillChanged, skill, singleSnapshot);
		}

		// Update overall panel
		XpSnapshotSingle overall = createOverallSnapshot();
		xpPanel.updateTotal(overall);
	}

	private static XpSnapshotSingle createSnapshot(XpState.SkillSnapshot snapshot)
	{
		return new XpSnapshotSingle(
			snapshot.getStartLevel(),
			snapshot.getCurrentLevel(),
			Experience.getXpForLevel(snapshot.getStartLevel()),
			Experience.getXpForLevel(snapshot.getCurrentLevel() + 1),
			snapshot.getXpGained(),
			snapshot.getXpRemainingToGoal(),
			snapshot.getXpPerHour(),
			snapshot.getSkillProgressToGoal(),
			snapshot.getTimeTillGoalShort(),
			snapshot.isCompactView()
		);
	}

	private XpSnapshotSingle createOverallSnapshot()
	{
		return new XpSnapshotSingle(
			0, 0, 0, 0,
			xpState.getTotalXpGained(),
			0,
			xpState.getTotalXpPerHour(),
			0.0,
			"N/A",
			false
		);
	}

	XpState getXpState()
	{
		return xpState;
	}

	XpTrackerConfig getConfig()
	{
		return config;
	}

	/**
	 * Update the stored order of a skill, following a drag-and-drop operation.
	 *
	 * @param skill       Skill that has been moved
	 * @param newPosition New 0-indexed position of this skill
	 */
	void updateSkillOrderState(Skill skill, int newPosition)
	{
		xpState.setOrder(skill, newPosition);
	}

	/**
	 * Update the stored 'compact view' state of a skill, following it being toggled via the UI.
	 *
	 * @param skill       Skill that has been toggled
	 * @param compactView New 'compact view' flag
	 */
	void setSkillCompactViewState(Skill skill, boolean compactView)
	{
		xpState.setCompactView(skill, compactView);
	}

	private static BufferedImage createIcon()
	{
		BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = img.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(new Color(255, 200, 0));
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
		g.drawString("XP", 0, 12);
		g.dispose();
		return img;
	}
}
