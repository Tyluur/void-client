package runelite.ui.overlay;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Base class for overlays that can be rendered on top of the game client.
 */
public abstract class Overlay
{
	private final String name;
	private final OverlayPosition position;
	private final OverlayLayer layer;
	private final Rectangle bounds = new Rectangle();
	private Point preferredLocation;
	private OverlayPosition preferredPosition;
	private boolean muted = false;

	protected Overlay(String name, OverlayPosition position, OverlayLayer layer)
	{
		this.name = name;
		this.position = position;
		this.layer = layer;
	}

	public abstract Dimension render(Graphics2D graphics);

	public String getName()
	{
		return name;
	}

	public OverlayPosition getPosition()
	{
		return position;
	}

	public OverlayLayer getLayer()
	{
		return layer;
	}

	public Rectangle getBounds()
	{
		return bounds;
	}

	public Point getPreferredLocation()
	{
		return preferredLocation;
	}

	public void setPreferredLocation(Point preferredLocation)
	{
		this.preferredLocation = preferredLocation;
	}

	public OverlayPosition getPreferredPosition()
	{
		return preferredPosition;
	}

	public void setPreferredPosition(OverlayPosition preferredPosition)
	{
		this.preferredPosition = preferredPosition;
	}

	public Dimension getPreferredSize()
	{
		return null;
	}

	public void setPreferredSize(Dimension preferredSize)
	{
		bounds.setSize(preferredSize);
	}

	public boolean isMovable()
	{
		return true;
	}

	public boolean isResizable()
	{
		return false;
	}

	public boolean isSnappable()
	{
		return true;
	}

	public boolean isResettable()
	{
		return true;
	}

	public boolean isDragTargetable()
	{
		return false;
	}

	public boolean isMuted()
	{
		return muted;
	}

	public void setMuted(boolean muted)
	{
		this.muted = muted;
	}

	public Rectangle getParentBounds()
	{
		return null;
	}

	public int getMinimumSize()
	{
		return 20;
	}

	public void onMouseOver()
	{
	}

	public boolean onDrag(Overlay overlay)
	{
		return false;
	}

	public void revalidate()
	{
	}
}
