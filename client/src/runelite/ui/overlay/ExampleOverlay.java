package runelite.ui.overlay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

/**
 * Example overlay for testing the RuneLite UI integration.
 * This overlay displays a simple text message on the screen.
 */
public class ExampleOverlay extends Overlay
{
	public ExampleOverlay()
	{
		super("Example Overlay", OverlayPosition.TOP_LEFT, OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		System.out.println("ExampleOverlay.render() called");
		graphics.setColor(Color.YELLOW);
		graphics.drawString("RuneLite Overlay System Active!", 10, 20);
		graphics.drawString("This is a test overlay rendering on void-client", 10, 40);
		return new Dimension(300, 50);
	}
}
