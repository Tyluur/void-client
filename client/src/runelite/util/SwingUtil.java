package runelite.util;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.SecondaryLoop;
import java.awt.Toolkit;
import javax.annotation.Nullable;
import javax.swing.AbstractButton;
import javax.swing.SwingUtilities;
import runelite.ui.Activatable;

/**
 * Various Swing utilities.
 * Adapted from RuneLite for void-client integration.
 */
public class SwingUtil
{
	public static void removeButtonDecorations(AbstractButton button)
	{
		button.putClientProperty(FlatClientProperties.STYLE_CLASS, "iconButton legacyIconButton");
	}

	public static void addModalTooltip(AbstractButton button, String on, String off)
	{
		button.setToolTipText(button.isSelected() ? on : off);
		button.addItemListener(l -> button.setToolTipText(button.isSelected() ? on : off));
	}

	/**
	 * Removes all of a component's children faster than calling removeAll() on it in many cases
	 */
	public static void fastRemoveAll(Container c)
	{
		// If we are not on the EDT this will deadlock, in addition to being totally unsafe
		assert SwingUtilities.isEventDispatchThread();

		// when a component is removed it has to be resized for some reason, but only if it's valid
		// so we make sure to invalidate everything before removing it
		c.invalidate();
		for (int i = 0; i < c.getComponentCount(); i++)
		{
			Component ic = c.getComponent(i);

			// removeAll and removeNotify are both recursive, so we have to recurse before them
			if (ic instanceof Container)
			{
				fastRemoveAll((Container) ic);
			}

			// each removeNotify needs to remove anything from the event queue that is for that widget
			// this however requires taking a lock, and is moderately slow, so we just execute all of
			// those events with a secondary event loop
			pumpPendingEvents();

			// call removeNotify early; this is most of the work in removeAll, and generates events that
			// the next secondaryLoop will pickup
			ic.removeNotify();
		}

		// Actually remove anything
		c.removeAll();
	}

	/**
	 * Run any events currently in the event queue
	 */
	public static void pumpPendingEvents()
	{
		EventQueue eq = Toolkit.getDefaultToolkit().getSystemEventQueue();

		if (eq.peekEvent() != null)
		{
			SecondaryLoop l = eq.createSecondaryLoop();
			SwingUtilities.invokeLater(l::exit);
			l.enter();
		}
	}

	public static void activate(@Nullable Object maybeActivatable)
	{
		if (maybeActivatable instanceof Activatable)
		{
			try
			{
				((Activatable) maybeActivatable).onActivate();
			}
			catch (Exception e)
			{
				System.err.println("uncaught exception in activate: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static void deactivate(@Nullable Object maybeActivatable)
	{
		if (maybeActivatable instanceof Activatable)
		{
			try
			{
				((Activatable) maybeActivatable).onDeactivate();
			}
			catch (Exception e)
			{
				System.err.println("uncaught exception in deactivate: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
