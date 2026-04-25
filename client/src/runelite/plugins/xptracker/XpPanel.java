package runelite.plugins.xptracker;

import runelite.api.Client;
import runelite.api.Skill;
import runelite.game.SkillIconManager;
import runelite.ui.ColorScheme;
import runelite.ui.FontManager;
import runelite.ui.PluginPanel;
import runelite.ui.components.DragAndDropReorderPane;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class XpPanel extends PluginPanel
{
	private final Map<Skill, XpInfoBox> infoBoxes = new HashMap<>();
	private final JLabel overallExpGained = new JLabel(htmlLabel("Gained: ", "0"));
	private final JLabel overallExpHour = new JLabel(htmlLabel("Per hour: ", "0"));
	private final JPanel overallPanel = new JPanel();
	private final JPanel errorPanel = new JPanel();
	private final DragAndDropReorderPane infoBoxPanel;
	private final SkillIconManager iconManager;

	XpPanel(XpTrackerPlugin xpTrackerPlugin, XpTrackerConfig xpTrackerConfig, Client client)
	{
		setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new BorderLayout());

		iconManager = new SkillIconManager();

		final JPanel layoutPanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(layoutPanel, BoxLayout.Y_AXIS);
		layoutPanel.setLayout(boxLayout);
		layoutPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		add(layoutPanel, BorderLayout.NORTH);

		overallPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		overallPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		overallPanel.setLayout(new BorderLayout());
		overallPanel.setVisible(false);

		ImageIcon overallIcon = loadOverallIcon();
		JLabel overallIconLabel = new JLabel(overallIcon);

		final JPanel overallInfo = new JPanel();
		overallInfo.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		overallInfo.setLayout(new GridLayout(2, 1));
		overallInfo.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

		overallExpGained.setFont(FontManager.getRunescapeSmallFont());
		overallExpHour.setFont(FontManager.getRunescapeSmallFont());

		overallInfo.add(overallExpGained);
		overallInfo.add(overallExpHour);

		overallPanel.add(overallIconLabel, BorderLayout.WEST);
		overallPanel.add(overallInfo, BorderLayout.CENTER);

		infoBoxPanel = new DragAndDropReorderPane();
		infoBoxPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		infoBoxPanel.addDragListener(component ->
		{
			XpInfoBox c = (XpInfoBox) component;
			xpTrackerPlugin.updateSkillOrderState(c.getSkill(), infoBoxPanel.getPosition(component));
		});

		layoutPanel.add(overallPanel);
		layoutPanel.add(infoBoxPanel);

		for (Skill skill : Skill.values())
		{
			if (skill == Skill.OVERALL)
			{
				continue;
			}
			infoBoxes.put(skill, new XpInfoBox(xpTrackerPlugin, xpTrackerConfig, client, infoBoxPanel, skill, iconManager));
		}

		// Error panel
		errorPanel.setLayout(new BorderLayout());
		errorPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		JLabel errorTitle = new JLabel("Exp trackers");
		errorTitle.setForeground(Color.WHITE);
		errorTitle.setFont(FontManager.getRunescapeFont());
		JLabel errorMsg = new JLabel("You have not gained experience yet.");
		errorMsg.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		errorMsg.setFont(FontManager.getRunescapeSmallFont());
		errorPanel.add(errorTitle, BorderLayout.NORTH);
		errorPanel.add(errorMsg, BorderLayout.CENTER);
		add(errorPanel, BorderLayout.CENTER);
	}

	void resetAllInfoBoxes()
	{
		infoBoxes.forEach((skill, xpInfoBox) -> xpInfoBox.reset());
	}

	void resetSkill(Skill skill)
	{
		final XpInfoBox xpInfoBox = infoBoxes.get(skill);
		if (xpInfoBox != null)
		{
			xpInfoBox.reset();
		}
	}

	void updateSkillExperience(boolean updated, Skill skill, XpSnapshotSingle xpSnapshotSingle)
	{
		final XpInfoBox xpInfoBox = infoBoxes.get(skill);
		if (xpInfoBox != null)
		{
			xpInfoBox.update(updated, xpSnapshotSingle);
		}
	}

	void updateTotal(XpSnapshotSingle xpSnapshotTotal)
	{
		if (xpSnapshotTotal.getXpGainedInSession() > 0 && !overallPanel.isVisible())
		{
			overallPanel.setVisible(true);
			remove(errorPanel);
		}
		else if (xpSnapshotTotal.getXpGainedInSession() == 0 && overallPanel.isVisible())
		{
			overallPanel.setVisible(false);
			add(errorPanel);
		}

		SwingUtilities.invokeLater(() -> rebuildAsync(xpSnapshotTotal));
	}

	private void rebuildAsync(XpSnapshotSingle xpSnapshotTotal)
	{
		overallExpGained.setText(htmlLabel("Gained: ", formatXp(xpSnapshotTotal.getXpGainedInSession())));
		overallExpHour.setText(htmlLabel("Per hour: ", formatXp(xpSnapshotTotal.getXpPerHour())));
	}

	private static String htmlLabel(String key, String value)
	{
		return String.format("<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>",
			colorToHex(ColorScheme.LIGHT_GRAY_COLOR), key, value);
	}

	private static String formatXp(int xp)
	{
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

	private ImageIcon loadOverallIcon()
	{
		java.awt.image.BufferedImage img = iconManager.getSkillImage(Skill.OVERALL, true);
		if (img != null)
		{
			return new ImageIcon(img);
		}
		return null;
	}
}
