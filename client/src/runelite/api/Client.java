package runelite.api;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Point;

/**
 * Minimal Client API interface for void-client integration.
 * This provides the essential methods needed for RuneLite UI overlays.
 */
public interface Client
{
	/**
	 * Gets the game canvas.
	 */
	Canvas getCanvas();

	/**
	 * Gets the real dimensions of the client.
	 */
	Dimension getRealDimensions();

	/**
	 * Gets the viewport X offset.
	 */
	int getViewportXOffset();

	/**
	 * Gets the viewport Y offset.
	 */
	int getViewportYOffset();

	/**
	 * Gets the mouse position relative to the canvas.
	 */
	Point getMouseCanvasPosition();

	/**
	 * Gets the current game state.
	 */
	GameState getGameState();

	/**
	 * Checks if the client is in resizable mode.
	 */
	boolean isResized();

	/**
	 * Gets the canvas width.
	 */
	int getCanvasWidth();

	/**
	 * Gets the canvas height.
	 */
	int getCanvasHeight();
}
