package runelite.adapter;

import runelite.api.Client;
import runelite.api.GameState;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Point;

/**
 * Adapter that implements RuneLite's Client API using void-client's game state.
 */
public class VoidClientAdapter implements Client
{
	private final Canvas canvas;
	private final Object clientInstance;

	public VoidClientAdapter(Canvas canvas, Object clientInstance)
	{
		this.canvas = canvas;
		this.clientInstance = clientInstance;
	}

	@Override
	public Canvas getCanvas()
	{
		return canvas;
	}

	@Override
	public Dimension getRealDimensions()
	{
		if (canvas != null)
		{
			return new Dimension(canvas.getWidth(), canvas.getHeight());
		}
		return new Dimension(765, 503); // Default RS2 client size
	}

	@Override
	public int getViewportXOffset()
	{
		// void-client doesn't have viewport offsets like modern RS
		return 0;
	}

	@Override
	public int getViewportYOffset()
	{
		// void-client doesn't have viewport offsets like modern RS
		return 0;
	}

	@Override
	public Point getMouseCanvasPosition()
	{
		// This would need to be implemented by hooking into void-client's mouse handling
		// For now, return a default position
		return new Point(0, 0);
	}

	@Override
	public GameState getGameState()
	{
		// Map void-client's login state to RuneLite's GameState
		// This needs to be implemented by examining void-client's state variables
		// For now, default to LOGGED_IN
		return GameState.LOGGED_IN;
	}

	@Override
	public boolean isResized()
	{
		// void-client revision 634 is fixed mode only
		return false;
	}

	@Override
	public int getCanvasWidth()
	{
		Dimension dim = getRealDimensions();
		return dim.width;
	}

	@Override
	public int getCanvasHeight()
	{
		Dimension dim = getRealDimensions();
		return dim.height;
	}
}
