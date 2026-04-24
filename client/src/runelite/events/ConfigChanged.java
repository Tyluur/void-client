package runelite.events;

/**
 * Posted when a configuration value changes.
 */
public class ConfigChanged
{
	private final String group;
	private final String key;
	private final String oldValue;
	private final String newValue;

	public ConfigChanged(String group, String key, String oldValue, String newValue)
	{
		this.group = group;
		this.key = key;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	public String getGroup()
	{
		return group;
	}

	public String getKey()
	{
		return key;
	}

	public String getOldValue()
	{
		return oldValue;
	}

	public String getNewValue()
	{
		return newValue;
	}
}
