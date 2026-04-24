package runelite.config;

import runelite.eventbus.EventBus;
import runelite.events.ConfigChanged;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Manages configuration key-value pairs, persisted to disk.
 * Mirrors RuneLite's ConfigManager API.
 */
public class ConfigManager
{
	private static final ConfigManager INSTANCE = new ConfigManager();

	private final String configDir;
	private final String configFile;
	private final Properties properties = new Properties();

	private ConfigManager()
	{
		String home = System.getProperty("user.home");
		if (home == null)
		{
			home = ".";
		}
		configDir = home + File.separator + ".void-client";
		configFile = configDir + File.separator + "settings.properties";
		load();
	}

	public static ConfigManager getInstance()
	{
		return INSTANCE;
	}

	/**
	 * Get a configuration value.
	 */
	public String getConfiguration(String group, String key)
	{
		return properties.getProperty(group + "." + key);
	}

	/**
	 * Get a typed configuration value.
	 */
	@SuppressWarnings("unchecked")
	public <T> T getConfiguration(String group, String key, Class<T> type)
	{
		String value = getConfiguration(group, key);
		if (value == null)
		{
			return null;
		}

		if (type == Boolean.class || type == boolean.class)
		{
			return (T) Boolean.valueOf(value);
		}
		if (type == Integer.class || type == int.class)
		{
			return (T) Integer.valueOf(value);
		}
		if (type == Long.class || type == long.class)
		{
			return (T) Long.valueOf(value);
		}
		if (type == Double.class || type == double.class)
		{
			return (T) Double.valueOf(value);
		}
		if (type == String.class)
		{
			return (T) value;
		}
		if (type.isEnum())
		{
			try
			{
				return (T) Enum.valueOf((Class<Enum>) type, value);
			}
			catch (IllegalArgumentException e)
			{
				return null;
			}
		}

		return (T) value;
	}

	/**
	 * Set a configuration value.
	 */
	public void setConfiguration(String group, String key, String value)
	{
		String fullKey = group + "." + key;
		String oldValue = properties.getProperty(fullKey);

		if (value == null)
		{
			properties.remove(fullKey);
		}
		else
		{
			properties.setProperty(fullKey, value);
		}

		save();

		EventBus.getInstance().post(new ConfigChanged(group, key, oldValue, value));
	}

	/**
	 * Set a configuration value (auto-converts to string).
	 */
	public void setConfiguration(String group, String key, Object value)
	{
		setConfiguration(group, key, value != null ? value.toString() : null);
	}

	/**
	 * Unset a configuration value.
	 */
	public void unsetConfiguration(String group, String key)
	{
		setConfiguration(group, key, (String) null);
	}

	private void load()
	{
		File file = new File(configFile);
		if (!file.exists())
		{
			return;
		}

		try (FileInputStream fis = new FileInputStream(file))
		{
			properties.load(fis);
		}
		catch (Exception e)
		{
			System.err.println("Failed to load config: " + e.getMessage());
		}
	}

	private void save()
	{
		File dir = new File(configDir);
		if (!dir.exists())
		{
			dir.mkdirs();
		}

		try (FileOutputStream fos = new FileOutputStream(configFile))
		{
			properties.store(fos, "Void Client Configuration");
		}
		catch (Exception e)
		{
			System.err.println("Failed to save config: " + e.getMessage());
		}
	}
}
