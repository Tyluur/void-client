package runelite.ui;

import com.formdev.flatlaf.ui.FlatNativeWindowsLibrary;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.IllegalComponentStateException;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import runelite.util.OSType;
import runelite.util.WinUtil;

/**
 * Custom JFrame with screen edge containment functionality.
 * Adapted from RuneLite for void-client integration.
 */
public class ContainableFrame extends JFrame
{
	public enum Mode
	{
		ALWAYS,
		RESIZING,
		NEVER;
	}

	private static final int SCREEN_EDGE_CLOSE_DISTANCE = 40;

	private Mode containedInScreen;
	private boolean rightSideSuction;
	private boolean scaleMinSize = false;
	private boolean overrideUndecorated;

	public void setContainedInScreen(Mode containedInScreen)
	{
		this.containedInScreen = containedInScreen;
	}

	public Mode getContainedInScreen()
	{
		return containedInScreen;
	}

	// we must use the deprecated variants since that it what Component ultimately delegates to
	@SuppressWarnings("deprecation")
	private void applyChange(int wX, int wY, int wWidth, int wHeight, int wOldx, int wOldY, int wOldWidth, boolean contain)
	{
		boolean isSnapped = WinUtil.isWindowArranged(this);

		if ((contain || isSnapped) && !isFullScreen())
		{
			Rectangle cDpyBounds = this.getGraphicsConfiguration().getBounds();
			Insets insets = this.getInsets();
			Rectangle cRect = new Rectangle(wX + insets.left, wY + insets.top, wWidth - (insets.left + insets.right), wHeight - (insets.top + insets.bottom));

			if (rightSideSuction || isSnapped)
			{
				// only keep suction while where are near the screen edge
				rightSideSuction = wOldx + wOldWidth - insets.right + SCREEN_EDGE_CLOSE_DISTANCE >= cDpyBounds.getMaxX();
			}

			if (rightSideSuction && wWidth < wOldWidth)
			{
				// shift the window so the right side is near the edge again
				cRect.x += wOldWidth - wWidth;
			}

			if (wWidth > wOldWidth
				&& cRect.getMaxX() > cDpyBounds.getMaxX()
				&& (wOldx + insets.left) + (wOldWidth - (insets.left + insets.right)) + SCREEN_EDGE_CLOSE_DISTANCE > cDpyBounds.getMaxX()
				&& (wOldx + insets.left) + (wOldWidth - (insets.left + insets.right)) <= cDpyBounds.getMaxX())
			{
				// attempt to retain the distance between us and the edge when shifting left
				cRect.x -= wWidth - wOldWidth;
			}

			cRect.x -= Math.max(0, cRect.getMaxX() - cDpyBounds.getMaxX());
			cRect.y -= Math.max(0, cRect.getMaxY() - cDpyBounds.getMaxY());

			// if we are just resizing don't try to move the left side out
			if (cRect.x != wOldx + insets.left)
			{
				cRect.x = Math.max(cRect.x, cDpyBounds.x);
			}

			if (cRect.y != wOldY + insets.top)
			{
				cRect.y = Math.max(cRect.y, cDpyBounds.y);
			}

			if (wWidth > wOldWidth && cRect.x < wOldx + insets.left)
			{
				// we have shifted the window left to avoid the right side going oob
				rightSideSuction = true;
			}

			wX = cRect.x - insets.left;
			wY = cRect.y - insets.top;
			wWidth = cRect.width + insets.left + insets.right;
			wHeight = cRect.height + insets.top + insets.bottom;
		}

		boolean xyDifferent = getX() != wX || getY() != wY;
		boolean whDifferent = getWidth() != wWidth || getHeight() != wHeight;

		if (xyDifferent && whDifferent)
		{
			super.reshape(wX, wY, wWidth, wHeight);
		}
		else if (xyDifferent)
		{
			super.move(wX, wY);
		}
		else if (whDifferent)
		{
			super.resize(wWidth, wHeight);
		}
	}

	/**
	 * Adjust the frame's size, containing to the screen if {@code Mode.RESIZING} is set
	 */
	public void containedSetSize(Dimension size, Rectangle oldBounds)
	{
		// accept oldSize from the outside since the min size might have been set, which forces the size to change
		applyChange(getX(), getY(), size.width, size.height, oldBounds.x, oldBounds.y, oldBounds.width, this.containedInScreen != Mode.NEVER);
	}

	/**
	 * Force minimum size of frame to be it's layout manager's minimum size
	 */
	public void revalidateMinimumSize()
	{
		Dimension minSize = getLayout().minimumLayoutSize(this);
		setMinimumSize(minSize);
	}

	@Override
	public void setMinimumSize(Dimension minSize)
	{
		if (OSType.getOSType() == OSType.Windows)
		{
			// JDK-8221452 - Window.setMinimumSize does not respect DPI scaling
			// Window::setMinimumSize will call setSize if the window is smaller
			// than the new minimum size. Because of this, and other places reading
			// minimumSize expecting scaling to be unscaled, we have to scale the size
			// only when WWindowPeer::updateMinimumSize is called. This is also called
			// during pack, but we call this afterwards so it doesn't matter much
			synchronized (getTreeLock())
			{
				try
				{
					scaleMinSize = true;
					super.setMinimumSize(minSize);
				}
				finally
				{
					scaleMinSize = false;
				}
			}
		}
		else
		{
			super.setMinimumSize(minSize);
		}
	}

	@Override
	public Dimension getMinimumSize()
	{
		Dimension minSize = super.getMinimumSize();
		if (OSType.getOSType() == OSType.Windows && minSize != null)
		{
			synchronized (getTreeLock())
			{
				if (scaleMinSize)
				{
					AffineTransform transform = getGraphicsConfiguration().getDefaultTransform();
					int scaledX = (int) Math.round(minSize.width * transform.getScaleX());
					int scaledY = (int) Math.round(minSize.height * transform.getScaleY());
					minSize = new Dimension(scaledX, scaledY);
				}
			}
		}
		return minSize;
	}

	private boolean isFullScreen()
	{
		return (getExtendedState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH;
	}

	void updateContainsInScreen()
	{
		// This method may not exist in all FlatLaf versions
		// Commented out for compatibility
		/*
		if (FlatNativeWindowsLibrary.isLoaded())
		{
			try
			{
				FlatNativeWindowsLibrary.setContainInScreen(this, containedInScreen == Mode.ALWAYS);
			}
			catch (NoSuchMethodError e)
			{
				// Method may not exist in older FlatLaf versions
			}
		}
		*/
	}

	@Override
	public void setOpacity(float opacity)
	{
		// JDK-6993784 requires the frame to be undecorated to apply opacity, but in practice it works on Windows regardless.
		// Temporarily pretend to be an undecorated frame to satisfy Frame.setOpacity().
		overrideUndecorated = true;
		try
		{
			super.setOpacity(opacity);
		}
		catch (IllegalComponentStateException | UnsupportedOperationException | IllegalArgumentException ex)
		{
			System.err.println("unable to set opacity " + opacity);
			ex.printStackTrace();
		}
		finally
		{
			overrideUndecorated = false;
		}
	}

	@Override
	public boolean isUndecorated()
	{
		return overrideUndecorated || super.isUndecorated();
	}
}
