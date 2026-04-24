package runelite.ui.laf;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatSystemProperties;
import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.swing.UIDefaults;
import runelite.ui.ColorScheme;

/**
 * Custom Look and Feel based on FlatLaf Dark with RuneLite color scheme.
 * Adapted from RuneLite for void-client integration.
 */
public class RuneLiteLAF extends FlatDarkLaf
{
	public static boolean setup()
	{
		// flatlaf always gets this wrong
		System.setProperty(FlatSystemProperties.UI_SCALE_ENABLED, "false");

		return setup(new RuneLiteLAF());
	}

	public RuneLiteLAF()
	{
		Map<String, String> extras = new HashMap<>();

		// load the properties ourselves to avoid platform specific styles
		Properties p = new Properties();
		for (Class<?> clazz : new Class[]{
			FlatLaf.class,
			FlatDarkLaf.class,
			RuneLiteLAF.class,
		})
		{
			try (InputStream is = clazz.getResourceAsStream("/" + clazz.getName().replace('.', '/') + ".properties"))
			{
				if (is != null)
				{
					p.load(new InputStreamReader(is, StandardCharsets.UTF_8));
				}
			}
			catch (Exception e)
			{
				// Ignore if properties file not found
			}
		}
		for (Map.Entry<Object, Object> ent : p.entrySet())
		{
			String k = (String) ent.getKey();
			String v = (String) ent.getValue();
			if (k.charAt(0) == '[' && !k.startsWith("[style]"))
			{
				// platform rule
				continue;
			}
			extras.put(k, v);
		}

		// add all of ColorScheme as variables for the properties
		for (Field f : ColorScheme.class.getDeclaredFields())
		{
			if (Modifier.isStatic(f.getModifiers()) && Color.class == f.getType())
			{
				String name = f.getName();
				if (name.endsWith("_COLOR"))
				{
					name = name.substring(0, name.length() - 6);
				}

				try
				{
					Color color = (Color) f.get(null);
					extras.put("@" + name, String.format("#%06x%02x", color.getRGB() & 0xFFFFFF, color.getRGB() >>> 24));
				}
				catch (IllegalAccessException e)
				{
					// Skip fields we can't access
				}
			}
		}

		setExtraDefaults(extras);
	}

	@Override
	protected List<Class<?>> getLafClassesForDefaultsLoading()
	{
		return Collections.emptyList();
	}

	@Override
	public String getName()
	{
		return "Void-Client RuneLite";
	}

	@Override
	public String getDescription()
	{
		return "Void-Client with RuneLite UI";
	}

	@Override
	public UIDefaults getDefaults()
	{
		UIDefaults d = super.getDefaults();

		// Use default font instead of custom RuneLite font
		d.put("defaultFont", new Font(Font.DIALOG, Font.PLAIN, 12));
		d.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);

		return d;
	}
}
