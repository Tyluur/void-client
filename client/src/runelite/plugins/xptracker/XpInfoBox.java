package runelite.plugins.xptracker;

import runelite.api.Client;
import runelite.api.Experience;
import runelite.api.Skill;
import runelite.game.SkillIconManager;
import runelite.ui.ColorScheme;
import runelite.ui.DynamicGridLayout;
import runelite.ui.FontManager;
import runelite.ui.SkillColor;
import runelite.ui.components.ProgressBar;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Collections;

class XpInfoBox extends JPanel
{
	private final XpTrackerPlugin xpTrackerPlugin;
	private final XpTrackerConfig xpTrackerConfig;
	private final Client client;
	private final JPanel panel;
	private final Skill skill;

	private final JPanel container = new JPanel();
	private final JPanel headerPanel = new JPanel();
	private final JPanel statsPanel = new JPanel();
	private final JPanel progressWrapper = new JPanel();
	private final ProgressBar progressBar = new ProgressBar();

	private final JLabel topLeftStat = new JLabel();
	private final JLabel bottomLeftStat = new JLabel();
	private final JLabel topRightStat = new JLabel();
	private final JLabel bottomRightStat = new JLabel();

	XpInfoBox(XpTrackerPlugin xpTrackerPlugin, XpTrackerConfig xpTrackerConfig, Client client, JPanel panel, Skill skill, SkillIconManager iconManager)
	{
		this.xpTrackerPlugin = xpTrackerPlugin;
		this.xpTrackerConfig = xpTrackerConfig;
		this.client = client;
		this.panel = panel;
		this.skill = skill;

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

		container.setLayout(new BorderLayout());
		container.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		headerPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		headerPanel.setLayout(new BorderLayout());

		statsPanel.setLayout(new DynamicGridLayout(2, 2));
		statsPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		statsPanel.setBorder(BorderFactory.createEmptyBorder(9, 2, 9, 2));

		topLeftStat.setFont(FontManager.getRunescapeSmallFont());
		bottomLeftStat.setFont(FontManager.getRunescapeSmallFont());
		topRightStat.setFont(FontManager.getRunescapeSmallFont());
		bottomRightStat.setFont(FontManager.getRunescapeSmallFont());

		statsPanel.add(topLeftStat);
		statsPanel.add(topRightStat);
		statsPanel.add(bottomLeftStat);
		statsPanel.add(bottomRightStat);

		JLabel headerSkillIcon = getSkillIcon(iconManager, skill, 35, 35);
		headerPanel.add(headerSkillIcon, BorderLayout.WEST);
		headerPanel.add(statsPanel, BorderLayout.CENTER);

		progressWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		progressWrapper.setLayout(new BorderLayout());
		progressWrapper.setBorder(BorderFactory.createEmptyBorder(0, 7, 7, 7));

		progressBar.setMaximumValue(100);
		progressBar.setBackground(new Color(61, 56, 49));
		progressBar.setForeground(SkillColor.find(skill).getColor());
		progressBar.setDimmedText("Paused");

		progressWrapper.add(progressBar, BorderLayout.CENTER);

		container.add(headerPanel, BorderLayout.NORTH);
		container.add(progressWrapper, BorderLayout.SOUTH);

		add(container, BorderLayout.NORTH);
	}

	void reset()
	{
		if (getParent() != null)
		{
			panel.remove(this);
			panel.revalidate();
		}
	}

	void update(boolean updated, XpSnapshotSingle snapshot)
	{
		if (updated)
		{
			if (getParent() != panel)
			{
				panel.add(this);
				panel.revalidate();
			}

			// Update progress bar
			progressBar.setValue((int) snapshot.getSkillProgressToGoal());
			progressBar.setCenterLabel(formatXp(snapshot.getXpGainedInSession()));
			progressBar.setLeftLabel("Lvl. " + snapshot.getStartLevel());
			progressBar.setRightLabel(snapshot.getEndGoalXp() == Experience.MAX_SKILL_XP
				? "200M"
				: "Lvl. " + snapshot.getEndLevel());
			progressBar.setPositions(Collections.emptyList());
		}

		// Update information labels
		topLeftStat.setText(htmlLabel("Gained: ", formatXp(snapshot.getXpGainedInSession())));
		topRightStat.setText(htmlLabel("Left: ", formatXp(snapshot.getXpRemainingToGoal())));
		bottomLeftStat.setText(htmlLabel("XP/hr: ", formatXp(snapshot.getXpPerHour())));
		bottomRightStat.setText(htmlLabel("TTL: ", snapshot.getTimeTillGoalShort()));
	}

	private static JLabel getSkillIcon(SkillIconManager iconManager, Skill skill, int width, int height)
	{
		JLabel skillIcon = new JLabel();
		ImageIcon icon = null;
		BufferedImage img = iconManager.getSkillImage(skill);
		if (img != null)
		{
			icon = new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH));
		}
		skillIcon.setIcon(icon);
		skillIcon.setPreferredSize(new Dimension(width, height));
		skillIcon.setHorizontalAlignment(SwingConstants.CENTER);
		skillIcon.setVerticalAlignment(SwingConstants.CENTER);
		return skillIcon;
	}

	private static String htmlLabel(String key, String value)
	{
		return String.format("<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>",
			colorToHex(ColorScheme.LIGHT_GRAY_COLOR), key, value);
	}

	private static String formatXp(int xp)
	{
		if (xp == Integer.MAX_VALUE)
		{
			return "N/A";
		}
		if (xp >= 1000000)
		{
			return String.format("%,.1fM", xp / 1000000.0);
		}
		if (xp >= 1000)
		{
			return String.format("%,.1fk", xp / 1000.0);
		}
		return String.format("%,d", xp);
	}

	private static String colorToHex(Color color)
	{
		return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
	}

	Skill getSkill()
	{
		return skill;
	}
}
