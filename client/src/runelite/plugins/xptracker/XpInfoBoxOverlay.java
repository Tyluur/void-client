package runelite.plugins.xptracker;

import runelite.api.Skill;
import runelite.ui.overlay.Overlay;
import runelite.ui.overlay.OverlayLayer;
import runelite.ui.overlay.OverlayPosition;

import java.awt.*;

/**
 * Overlay showing XP tracker info box on the canvas.
 * Mirrors RuneLite's XpInfoBoxOverlay.
 */
public class XpInfoBoxOverlay extends Overlay
{
	private final XpTrackerPlugin plugin;
	private final XpTrackerConfig config;
	private final Skill skill;

	public XpInfoBoxOverlay(XpTrackerPlugin plugin, XpTrackerConfig config, Skill skill, Image icon)
	{
		super("XP Info: " + skill.getName(), OverlayPosition.TOP_LEFT, OverlayLayer.ABOVE_WIDGETS);
		this.plugin = plugin;
		this.config = config;
		this.skill = skill;
	}

	public Skill getSkill()
	{
		return skill;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.enableOverlay())
		{
			return null;
		}

		XpState xpState = plugin.getXpState();
		if (xpState == null)
		{
			return null;
		}

		XpState.SkillSnapshot snapshot = xpState.getSnapshot(skill);
		if (snapshot == null)
		{
			return null;
		}

		// Draw XP info box
		int width = 120;
		int height = 50;

		graphics.setColor(new Color(0, 0, 0, 180));
		graphics.fillRect(0, 0, width, height);

		graphics.setColor(config.overlayColor());
		graphics.setFont(new Font(Font.DIALOG, Font.BOLD, config.overlayFontSize()));

		int xpGained = snapshot.getXpGained();
		String xpText = String.format("+%,d XP", xpGained);
		graphics.drawString(skill.getName(), 10, 20);
		graphics.drawString(xpText, 10, 40);

		return new Dimension(width, height);
	}
}
