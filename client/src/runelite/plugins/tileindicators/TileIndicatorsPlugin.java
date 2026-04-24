package runelite.plugins.tileindicators;

import runelite.eventbus.Subscribe;
import runelite.events.GameTick;
import runelite.plugins.Plugin;
import runelite.plugins.PluginDescriptor;
import runelite.ui.ColorScheme;
import runelite.ui.NavigationButton;
import runelite.ui.PluginPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

@PluginDescriptor(
	name = "Tile Indicators",
	description = "Highlight tiles under the player and destination"
)
public class TileIndicatorsPlugin extends Plugin
{
	private NavigationButton navButton;

	@Override
	protected void startUp()
	{
		navButton = NavigationButton.builder()
			.priority(10)
			.icon(createIcon())
			.tooltip("Tile Indicators")
			.panel(new TileIndicatorsPanel())
			.build();
	}

	@Override
	protected void shutDown()
	{
		navButton = null;
	}

	@Override
	public NavigationButton getNavigationButton()
	{
		return navButton;
	}

	@Subscribe
	private void onGameTick(GameTick tick)
	{
		// Future: update tile highlight state
	}

	private static BufferedImage createIcon()
	{
		BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = img.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(new Color(0, 255, 128));
		g.setStroke(new BasicStroke(1.5f));
		// Draw a diamond/tile shape
		int[] xPoints = {8, 14, 8, 2};
		int[] yPoints = {2, 8, 14, 8};
		g.drawPolygon(xPoints, yPoints, 4);
		g.dispose();
		return img;
	}

	private static class TileIndicatorsPanel extends PluginPanel
	{
		TileIndicatorsPanel()
		{
			JLabel title = new JLabel("Tile Indicators");
			title.setForeground(Color.WHITE);
			title.setFont(title.getFont().deriveFont(Font.BOLD, 14f));
			add(title);

			JCheckBox highlightDest = new JCheckBox("Highlight destination tile");
			highlightDest.setSelected(true);
			highlightDest.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
			add(highlightDest);

			JCheckBox highlightTrue = new JCheckBox("Highlight true tile");
			highlightTrue.setSelected(false);
			highlightTrue.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
			add(highlightTrue);

			JLabel colorLabel = new JLabel("Tile color:");
			colorLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
			add(colorLabel);
		}
	}
}
