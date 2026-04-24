package runelite.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Simple event bus for publishing and subscribing to events.
 * Mirrors RuneLite's EventBus API.
 */
public class EventBus
{
	private static final EventBus INSTANCE = new EventBus();

	private final Map<Class<?>, List<Subscriber>> subscribers = new ConcurrentHashMap<>();

	public static EventBus getInstance()
	{
		return INSTANCE;
	}

	/**
	 * Register all @Subscribe-annotated methods on the given object.
	 */
	public void register(Object object)
	{
		for (Method method : object.getClass().getDeclaredMethods())
		{
			if (method.isAnnotationPresent(Subscribe.class)
				&& method.getParameterCount() == 1)
			{
				Class<?> eventType = method.getParameterTypes()[0];
				method.setAccessible(true);

				subscribers
					.computeIfAbsent(eventType, k -> new CopyOnWriteArrayList<>())
					.add(new Subscriber(object, method, method.getAnnotation(Subscribe.class).priority()));
			}
		}
	}

	/**
	 * Unregister all subscriptions for the given object.
	 */
	public void unregister(Object object)
	{
		for (List<Subscriber> subs : subscribers.values())
		{
			subs.removeIf(s -> s.target == object);
		}
	}

	/**
	 * Post an event to all subscribers of its type.
	 */
	public void post(Object event)
	{
		List<Subscriber> subs = subscribers.get(event.getClass());
		if (subs == null || subs.isEmpty())
		{
			return;
		}

		// Sort by priority (lower = first) on each post for thread safety
		List<Subscriber> sorted = new ArrayList<>(subs);
		sorted.sort((a, b) -> Float.compare(a.priority, b.priority));

		for (Subscriber sub : sorted)
		{
			try
			{
				sub.method.invoke(sub.target, event);
			}
			catch (Exception e)
			{
				System.err.println("Error dispatching event " + event.getClass().getSimpleName()
					+ " to " + sub.target.getClass().getSimpleName() + ": " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	private static class Subscriber
	{
		final Object target;
		final Method method;
		final float priority;

		Subscriber(Object target, Method method, float priority)
		{
			this.target = target;
			this.method = method;
			this.priority = priority;
		}
	}
}
