package runelite.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines a section within a config group for UI grouping.
 * Mirrors RuneLite's @ConfigSection.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ConfigSection
{
	String name();

	String description() default "";

	int position() default 0;

	boolean closedByDefault() default false;
}
