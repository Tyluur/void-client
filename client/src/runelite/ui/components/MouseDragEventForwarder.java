package runelite.ui.components;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

/**
 * Forwards left mouse button drag events to the target Component.
 */
public class MouseDragEventForwarder extends MouseAdapter
{
	private final Component target;

	public MouseDragEventForwarder(Component target)
	{
		this.target = target;
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		processEvent(e);
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		processEvent(e);
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		processEvent(e);
	}

	private void processEvent(MouseEvent e)
	{
		if (SwingUtilities.isLeftMouseButton(e))
		{
			MouseEvent eventForTarget = SwingUtilities.convertMouseEvent((Component) e.getSource(), e, target);
			target.dispatchEvent(eventForTarget);
		}
	}
}
