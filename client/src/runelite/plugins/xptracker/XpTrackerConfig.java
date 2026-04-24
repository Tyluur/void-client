package runelite.plugins.xptracker;

import runelite.api.Skill;
import runelite.config.ConfigGroup;
import runelite.config.ConfigItem;

import java.awt.Color;

/**
 * Configuration for the XP Tracker plugin.
 * Mirrors RuneLite's XpTrackerConfig.
 */
@ConfigGroup("xptracker")
public interface XpTrackerConfig
{
	@ConfigItem(
		keyName = "enableOverlay",
		name = "Enable Canvas Overlay",
		description = "Show XP tracker overlay on game canvas",
		position = 0
	)
	default boolean enableOverlay()
	{
		return false;
	}

	@ConfigItem(
		keyName = "overlayColor",
		name = "Overlay Color",
		description = "Color of the XP tracker overlay text",
		position = 1
	)
	default Color overlayColor()
	{
		return new Color(0, 255, 128);
	}

	@ConfigItem(
		keyName = "overlayFontSize",
		name = "Overlay Font Size",
		description = "Font size of the overlay text",
		position = 2
	)
	default int overlayFontSize()
	{
		return 18;
	}

	@ConfigItem(
		keyName = "showSkills",
		name = "Show Skills",
		description = "Which skills to track in the panel",
		position = 3
	)
	default String showSkills()
	{
		return "all"; // "all", "selected"
	}

	@ConfigItem(
		keyName = "hideMaxed",
		name = "Hide Maxed Skills",
		description = "Hide skills that are already level 99",
		position = 4
	)
	default boolean hideMaxed()
	{
		return false;
	}

	@ConfigItem(
		keyName = "pauseOnLogout",
		name = "Pause on Logout",
		description = "Pause XP tracking when logging out",
		position = 5
	)
	default boolean pauseOnLogout()
	{
		return true;
	}
}
