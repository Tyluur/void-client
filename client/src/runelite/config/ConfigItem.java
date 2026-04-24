package runelite.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a method in a config interface as a configuration item.
 * Mirrors RuneLite's @ConfigItem.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ConfigItem
{
	/**
	 * The config key name.
	 */
	String keyName();

	/**
	 * Display name.
	 */
	String name();

	/**
	 * Description text.
	 */
	String description() default "";

	/**
	 * Position for ordering in UI.
	 */
	int position() default 0;

	/**
	 * Section this config item belongs to.
	 */
	String section() default "";

	/**
	 * Whether this config item is hidden.
	 */
	boolean hidden() default false;
}
