package runelite.plugins;

import runelite.config.ConfigManager;
import runelite.eventbus.EventBus;
import runelite.ui.NavigationButton;

/**
 * Base class for all plugins.
 * Mirrors RuneLite's Plugin API.
 */
public abstract class Plugin
{
	private boolean enabled;

	/**
	 * Called when the plugin is started.
	 */
	protected void startUp() throws Exception
	{
	}

	/**
	 * Called when the plugin is stopped.
	 */
	protected void shutDown() throws Exception
	{
	}

	/**
	 * Get the plugin's name.
	 */
	public String getName()
	{
		PluginDescriptor desc = getClass().getAnnotation(PluginDescriptor.class);
		return desc != null ? desc.name() : getClass().getSimpleName();
	}

	/**
	 * Get the plugin's description.
	 */
	public String getDescription()
	{
		PluginDescriptor desc = getClass().getAnnotation(PluginDescriptor.class);
		return desc != null ? desc.description() : "";
	}

	/**
	 * Override to provide a navigation button for the sidebar.
	 */
	public NavigationButton getNavigationButton()
	{
		return null;
	}

	/**
	 * Convenience: get the EventBus singleton.
	 */
	protected EventBus getEventBus()
	{
		return EventBus.getInstance();
	}

	/**
	 * Convenience: get the ConfigManager singleton.
	 */
	protected ConfigManager getConfigManager()
	{
		return ConfigManager.getInstance();
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}
}
