package runelite.ui.laf;

import com.formdev.flatlaf.ui.FlatRootPaneUI;
import java.beans.PropertyChangeEvent;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

/**
 * Custom RootPaneUI for RuneLite-style title bar.
 * Adapted from RuneLite for void-client integration.
 */
public class RuneLiteRootPaneUI extends FlatRootPaneUI
{
	public static final String PROP_RUNELITE_TITLEBAR = "runelite.titleBar";

	public static ComponentUI createUI(JComponent c)
	{
		return new RuneLiteRootPaneUI();
	}

	@Override
	public void propertyChange(PropertyChangeEvent e)
	{
		super.propertyChange(e);

		if (e.getPropertyName().equals(PROP_RUNELITE_TITLEBAR))
		{
			boolean titleBar = rootPane.getClientProperty(PROP_RUNELITE_TITLEBAR) == Boolean.TRUE;
			if (!titleBar)
			{
				throw new IllegalStateException();
			}

			setTitlePane(createTitlePane());

			rootPane.setLayout(createRootLayout());
		}
	}
}
