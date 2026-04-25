package runelite.api.hooks;

import java.awt.Graphics;

/**
 * Callback interface for rendering hooks in the client.
 * These methods are called at specific points during the client's rendering pipeline.
 */
public interface Callbacks
{
	/**
	 * Called after the scene is drawn (3D rendering complete).
	 * Suitable for overlays that should appear above the 3D scene but below 2D objects.
	 */
	void drawScene();

	/**
	 * Called after 2D objects/overheads are drawn.
	 * Suitable for overlays that should appear above 2D game objects but below UI widgets.
	 */
	void drawAboveOverheads();

	/**
	 * Called at the final draw point after all game rendering is complete.
	 * Suitable for overlays that should always be on top of everything.
	 *
	 * @param mainBufferProvider The main buffer provider
	 * @param graphics The graphics context
	 * @param x X offset
	 * @param y Y offset
	 */
	void draw(Object mainBufferProvider, Graphics graphics, int x, int y);
	
	/**
	 * Called during OpenGL rendering after swapBuffers.
	 * Used to render overlays in OpenGL mode using texture rendering.
	 *
	 * @param width Canvas width
	 * @param height Canvas height
	 */
	void drawOpenGL(int width, int height);
}
