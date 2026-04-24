package runelite.plugins;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import runelite.config.ConfigGroup;
import runelite.config.ConfigInvocationHandler;
import runelite.config.ConfigManager;
import runelite.eventbus.EventBus;
import runelite.ui.ClientUI;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manages plugin lifecycle: loading, starting, stopping.
 * Uses Guice for dependency injection so plugins can use @Inject.
 * Mirrors RuneLite's PluginManager API.
 */
public class PluginManager
{
	private static final PluginManager INSTANCE = new PluginManager();
	private static final String CONFIG_GROUP = "pluginmanager";

	private final List<Plugin> plugins = new ArrayList<>();
	private final EventBus eventBus = EventBus.getInstance();
	private final ConfigManager configManager = ConfigManager.getInstance();
	private ClientUI clientUI;
	private Injector injector;

	public static PluginManager getInstance()
	{
		return INSTANCE;
	}

	public void setClientUI(ClientUI clientUI)
	{
		this.clientUI = clientUI;
	}

	/**
	 * Set the Guice injector for @Inject support in plugins.
	 */
	public void setInjector(Injector injector)
	{
		this.injector = injector;
	}

	/**
	 * Register a plugin class. Creates an instance via Guice (supports @Inject)
	 * and optionally starts it.
	 */
	public void add(Class<? extends Plugin> pluginClass)
	{
		try
		{
			Plugin plugin;
			if (injector != null)
			{
				plugin = injector.getInstance(pluginClass);
			}
			else
			{
				plugin = pluginClass.newInstance();
			}

			// Auto-inject config interfaces annotated with @ConfigGroup
			injectConfigs(plugin);

			plugins.add(plugin);

			PluginDescriptor desc = pluginClass.getAnnotation(PluginDescriptor.class);
			boolean enabledByDefault = desc == null || desc.enabledByDefault();

			// Check saved config for enabled state
			Boolean savedState = configManager.getConfiguration(CONFIG_GROUP, pluginClass.getSimpleName(), Boolean.class);
			boolean shouldEnable = savedState != null ? savedState : enabledByDefault;

			if (shouldEnable)
			{
				startPlugin(plugin);
			}
		}
		catch (Exception e)
		{
			System.err.println("Failed to load plugin " + pluginClass.getSimpleName() + ": " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Inject config proxy instances into fields whose type is a @ConfigGroup interface.
	 */
	private void injectConfigs(Plugin plugin)
	{
		for (Field field : plugin.getClass().getDeclaredFields())
		{
			Class<?> fieldType = field.getType();
			if (fieldType.isInterface() && fieldType.isAnnotationPresent(ConfigGroup.class))
			{
				try
				{
					field.setAccessible(true);
					Object proxy = ConfigInvocationHandler.createProxy(fieldType, configManager);
					field.set(plugin, proxy);
				}
				catch (Exception e)
				{
					System.err.println("Failed to inject config " + fieldType.getSimpleName()
						+ " into " + plugin.getClass().getSimpleName() + ": " + e.getMessage());
				}
			}
		}
	}

	/**
	 * Start a plugin.
	 */
	public void startPlugin(Plugin plugin)
	{
		if (plugin.isEnabled())
		{
			return;
		}

		try
		{
			plugin.startUp();
			plugin.setEnabled(true);
			eventBus.register(plugin);

			// Add navigation button if the plugin provides one
			if (clientUI != null && plugin.getNavigationButton() != null)
			{
				clientUI.addNavigation(plugin.getNavigationButton());
			}

			System.out.println("Started plugin: " + plugin.getName());
		}
		catch (Exception e)
		{
			System.err.println("Failed to start plugin " + plugin.getName() + ": " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Stop a plugin.
	 */
	public void stopPlugin(Plugin plugin)
	{
		if (!plugin.isEnabled())
		{
			return;
		}

		try
		{
			eventBus.unregister(plugin);

			if (clientUI != null && plugin.getNavigationButton() != null)
			{
				clientUI.removeNavigation(plugin.getNavigationButton());
			}

			plugin.shutDown();
			plugin.setEnabled(false);

			System.out.println("Stopped plugin: " + plugin.getName());
		}
		catch (Exception e)
		{
			System.err.println("Failed to stop plugin " + plugin.getName() + ": " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Toggle a plugin on/off and save the state.
	 */
	public void setPluginEnabled(Plugin plugin, boolean enabled)
	{
		if (enabled)
		{
			startPlugin(plugin);
		}
		else
		{
			stopPlugin(plugin);
		}
		configManager.setConfiguration(CONFIG_GROUP, plugin.getClass().getSimpleName(), enabled);
	}

	public List<Plugin> getPlugins()
	{
		return Collections.unmodifiableList(plugins);
	}
}
