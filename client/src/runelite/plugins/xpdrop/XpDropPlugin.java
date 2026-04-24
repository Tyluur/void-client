package runelite.plugins.xpdrop;

import com.google.inject.Inject;
import runelite.api.Client;
import runelite.api.ClientThread;
import runelite.config.ConfigGroup;
import runelite.config.ConfigItem;
import runelite.eventbus.Subscribe;
import runelite.events.GameTick;
import runelite.plugins.Plugin;
import runelite.plugins.PluginDescriptor;
import runelite.ui.ColorScheme;
import runelite.ui.NavigationButton;
import runelite.ui.PluginPanel;
import runelite.ui.overlay.OverlayManager;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

/**
 * Example plugin demonstrating @Inject, @ConfigGroup, and @Subscribe.
 * This shows how to port RuneLite plugins with minimal changes.
 */
@PluginDescriptor(
	name = "XP Drop",
	description = "Shows experience drops with custom styling"
)
public class XpDropPlugin extends Plugin
{
	@Inject private Client client;
	@Inject private ClientThread clientThread;
	@Inject private OverlayManager overlayManager;

	// Config interface - injected by PluginManager (not Guice)
	private XpDropConfig config;

	private NavigationButton navButton;
	private int lastTickCount = 0;

	@Override
	protected void startUp()
	{
		System.out.println("XP Drop plugin started with @Inject: " + (client != null));
		System.out.println("Config value: showDrops = " + config.showDrops());

		navButton = NavigationButton.builder()
			.priority(20)
			.icon(createIcon())
			.tooltip("XP Drop Settings")
			.panel(new XpDropPanel())
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
		if (!config.showDrops())
		{
			return;
		}

		int currentTick = client.getTickCount();
		if (currentTick != lastTickCount)
		{
			lastTickCount = currentTick;
			// XP drop logic would go here
		}
	}

	private static BufferedImage createIcon()
	{
		BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = img.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(new Color(255, 200, 0));
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
		g.drawString("XP", 0, 12);
		g.dispose();
		return img;
	}

	/**
	 * Config interface with @ConfigGroup and @ConfigItem annotations.
	 * This mirrors RuneLite's config pattern.
	 */
	@ConfigGroup("xpdrop")
	public interface XpDropConfig
	{
		@ConfigItem(
			keyName = "showDrops",
			name = "Show XP Drops",
			description = "Enable/disable XP drop display",
			position = 0
		)
		default boolean showDrops()
		{
			return true;
		}

		@ConfigItem(
			keyName = "dropColor",
			name = "Drop Color",
			description = "Color of the XP drop text",
			position = 1
		)
		default Color dropColor()
		{
			return new Color(255, 200, 0);
		}

		@ConfigItem(
			keyName = "fontSize",
			name = "Font Size",
			description = "Size of the XP drop text",
			position = 2
		)
		default int fontSize()
		{
			return 18;
		}
	}

	private class XpDropPanel extends PluginPanel
	{
		XpDropPanel()
		{
			JLabel title = new JLabel("XP Drop Settings");
			title.setForeground(Color.WHITE);
			title.setFont(title.getFont().deriveFont(Font.BOLD, 14f));
			add(title);

			JCheckBox showDrops = new JCheckBox("Show XP Drops", config.showDrops());
			showDrops.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
			showDrops.setEnabled(false); // TODO: implement setter
			add(showDrops);

			JLabel colorLabel = new JLabel("Drop Color:");
			colorLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
			add(colorLabel);

			JLabel sizeLabel = new JLabel("Font Size: " + config.fontSize());
			sizeLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
			add(sizeLabel);

			JLabel info = new JLabel("<html><i>This plugin demonstrates @Inject and @ConfigGroup.</i></html>");
			info.setForeground(new Color(150, 150, 150));
			add(info);
		}
	}
}
