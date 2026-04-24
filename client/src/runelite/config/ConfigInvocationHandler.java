package runelite.config;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Dynamic proxy handler for config interfaces annotated with @ConfigGroup/@ConfigItem.
 * Generates config implementations at runtime, reading/writing to ConfigManager.
 * This allows copy-paste of RuneLite config interfaces.
 */
public class ConfigInvocationHandler implements InvocationHandler
{
	private final String group;
	private final ConfigManager configManager;

	private ConfigInvocationHandler(String group, ConfigManager configManager)
	{
		this.group = group;
		this.configManager = configManager;
	}

	/**
	 * Create a proxy instance for the given config interface.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T createProxy(Class<T> configInterface, ConfigManager configManager)
	{
		ConfigGroup cg = configInterface.getAnnotation(ConfigGroup.class);
		if (cg == null)
		{
			throw new IllegalArgumentException(configInterface.getName() + " is not annotated with @ConfigGroup");
		}

		return (T) Proxy.newProxyInstance(
			configInterface.getClassLoader(),
			new Class[]{configInterface},
			new ConfigInvocationHandler(cg.value(), configManager)
		);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		// Handle Object methods
		if (method.getDeclaringClass() == Object.class)
		{
			return method.invoke(this, args);
		}

		ConfigItem item = method.getAnnotation(ConfigItem.class);
		if (item == null)
		{
			// ConfigSection methods return their name
			ConfigSection section = method.getAnnotation(ConfigSection.class);
			if (section != null)
			{
				return section.name();
			}
			// Default method or unrecognized — return default value for type
			return getDefaultForType(method.getReturnType());
		}

		String key = item.keyName();

		// Setter: method has 1 parameter
		if (method.getParameterCount() == 1)
		{
			Object val = args[0];
			configManager.setConfiguration(group, key, val);
			return null;
		}

		// Getter: no parameters, has return type
		Class<?> returnType = method.getReturnType();
		Object value = configManager.getConfiguration(group, key, returnType);

		if (value != null)
		{
			return value;
		}

		// Return the method's default return value if the config is unset
		return getDefaultForMethod(method);
	}

	/**
	 * Gets the default value for a config method by invoking it as a default interface method,
	 * or falling back to the type default.
	 */
	private Object getDefaultForMethod(Method method)
	{
		// Try to invoke the default method on the interface (Java 8+)
		if (method.isDefault())
		{
			try
			{
				// Java 8 way to invoke default methods
				return java.lang.invoke.MethodHandles.lookup()
					.in(method.getDeclaringClass())
					.unreflectSpecial(method, method.getDeclaringClass())
					.bindTo(Proxy.newProxyInstance(
						method.getDeclaringClass().getClassLoader(),
						new Class[]{method.getDeclaringClass()},
						(p, m, a) -> getDefaultForType(m.getReturnType())
					))
					.invoke();
			}
			catch (Throwable e)
			{
				// Fall through to type defaults
			}
		}
		return getDefaultForType(method.getReturnType());
	}

	private static Object getDefaultForType(Class<?> type)
	{
		if (type == boolean.class || type == Boolean.class) return false;
		if (type == int.class || type == Integer.class) return 0;
		if (type == long.class || type == Long.class) return 0L;
		if (type == double.class || type == Double.class) return 0.0;
		if (type == float.class || type == Float.class) return 0.0f;
		if (type == String.class) return "";
		if (type == java.awt.Color.class) return java.awt.Color.WHITE;
		return null;
	}
}
