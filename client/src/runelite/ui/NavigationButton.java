package runelite.ui;

import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.Map;

/**
 * UI navigation button.
 * Adapted from RuneLite for void-client integration.
 */
public class NavigationButton
{
	static final Comparator<NavigationButton> COMPARATOR = Comparator.comparing(NavigationButton::getPriority)
		.thenComparing(NavigationButton::getTooltip);

	/**
	 * Icon of button.
	 */
	private final BufferedImage icon;

	/**
	 * Tooltip to show when hovered.
	 */
	private final String tooltip;

	/**
	 * On click action of the button.
	 */
	private final Runnable onClick;

	/**
	 * Plugin panel, used when expanding and contracting sidebar.
	 */
	private final PluginPanel panel;

	/**
	 * The order in which the button should be displayed in the side bar. (from lower to higher)
	 */
	private final int priority;

	/**
	 * Map of key-value pairs for setting the popup menu
	 */
	private final Map<String, Runnable> popup;

	public NavigationButton(BufferedImage icon, String tooltip, Runnable onClick, PluginPanel panel, int priority, Map<String, Runnable> popup)
	{
		this.icon = icon;
		this.tooltip = tooltip != null ? tooltip : "";
		this.onClick = onClick;
		this.panel = panel;
		this.priority = priority;
		this.popup = popup;
	}

	public BufferedImage getIcon()
	{
		return icon;
	}

	public String getTooltip()
	{
		return tooltip;
	}

	public Runnable getOnClick()
	{
		return onClick;
	}

	public PluginPanel getPanel()
	{
		return panel;
	}

	public int getPriority()
	{
		return priority;
	}

	public Map<String, Runnable> getPopup()
	{
		return popup;
	}

	public static Builder builder()
	{
		return new Builder();
	}

	public static class Builder
	{
		private BufferedImage icon;
		private String tooltip = "";
		private Runnable onClick;
		private PluginPanel panel;
		private int priority;
		private Map<String, Runnable> popup;

		public Builder icon(BufferedImage icon)
		{
			this.icon = icon;
			return this;
		}

		public Builder tooltip(String tooltip)
		{
			this.tooltip = tooltip;
			return this;
		}

		public Builder onClick(Runnable onClick)
		{
			this.onClick = onClick;
			return this;
		}

		public Builder panel(PluginPanel panel)
		{
			this.panel = panel;
			return this;
		}

		public Builder priority(int priority)
		{
			this.priority = priority;
			return this;
		}

		public Builder popup(Map<String, Runnable> popup)
		{
			this.popup = popup;
			return this;
		}

		public NavigationButton build()
		{
			return new NavigationButton(icon, tooltip, onClick, panel, priority, popup);
		}
	}
}
