package runelite.eventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a method as an event subscriber.
 * The method must have exactly one parameter (the event type).
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe
{
	/**
	 * Priority for ordering subscribers. Lower values run first.
	 */
	float priority() default 0;
}
