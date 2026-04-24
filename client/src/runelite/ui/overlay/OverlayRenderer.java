package runelite.ui.overlay;

import runelite.api.Client;
import runelite.api.GameState;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collection;

/**
 * Simplified overlay renderer for void-client integration.
 */
public class OverlayRenderer
{
	private final Client client;
	private final OverlayManager overlayManager;
	private Font overlayFont;

	public OverlayRenderer(Client client, OverlayManager overlayManager)
	{
		this.client = client;
		this.overlayManager = overlayManager;
		this.overlayFont = new Font("SansSerif", Font.PLAIN, 12);
	}

	public void setOverlayFont(Font font)
	{
		this.overlayFont = font;
	}

	public void renderOverlayLayer(Graphics2D graphics, OverlayLayer layer)
	{
		Collection<Overlay> overlays = overlayManager.getLayer(layer);
		if (overlays != null && !overlays.isEmpty())
		{
			System.out.println("Rendering layer " + layer + " with " + overlays.size() + " overlays");
		}
		renderOverlays(graphics, overlays, layer);
	}

	private void renderOverlays(Graphics2D graphics, Collection<Overlay> overlays, OverlayLayer layer)
	{
		if (overlays == null || overlays.isEmpty())
		{
			return;
		}

		System.out.println("renderOverlays called for layer " + layer + ", gameState: " + client.getGameState());

		if (client.getGameState() != GameState.LOGGED_IN)
		{
			System.out.println("Skipping overlay render - not logged in");
			return;
		}

		// Save graphics state
		java.awt.Composite composite = graphics.getComposite();
		java.awt.Stroke stroke = graphics.getStroke();
		java.awt.Paint paint = graphics.getPaint();
		java.awt.Font font = graphics.getFont();

		graphics.setFont(overlayFont);

		for (Overlay overlay : overlays)
		{
			Point location = calculateOverlayPosition(overlay);
			
			if (overlay.getPreferredSize() != null)
			{
				overlay.getBounds().setSize(overlay.getPreferredSize());
			}

			graphics.translate(location.x, location.y);
			overlay.getBounds().setLocation(location);

			try
			{
				Dimension dimension = overlay.render(graphics);
				if (dimension != null)
				{
					overlay.getBounds().setSize(dimension);
				}
			}
			catch (Exception ex)
			{
				System.err.println("Error rendering overlay " + overlay.getName() + ": " + ex.getMessage());
				ex.printStackTrace();
			}

			// Restore graphics state for next overlay
			graphics.translate(-location.x, -location.y);
			graphics.setComposite(composite);
			graphics.setStroke(stroke);
			graphics.setPaint(paint);
			graphics.setFont(font);
		}
	}

	private Point calculateOverlayPosition(Overlay overlay)
	{
		Point preferredLocation = overlay.getPreferredLocation();
		if (preferredLocation != null)
		{
			return preferredLocation;
		}

		OverlayPosition position = overlay.getPreferredPosition();
		if (position == null)
		{
			position = overlay.getPosition();
		}

		Dimension clientSize = client.getRealDimensions();
		Rectangle bounds = overlay.getBounds();
		int padding = 5;

		switch (position)
		{
			case TOP_LEFT:
				return new Point(padding, padding);
			case TOP_CENTER:
				return new Point(clientSize.width / 2 - bounds.width / 2, padding);
			case TOP_RIGHT:
				return new Point(clientSize.width - bounds.width - padding, padding);
			case BOTTOM_LEFT:
				return new Point(padding, clientSize.height - bounds.height - padding);
			case BOTTOM_RIGHT:
				return new Point(clientSize.width - bounds.width - padding, clientSize.height - bounds.height - padding);
			case DYNAMIC:
			case TOOLTIP:
			case DETACHED:
			default:
				return new Point(padding, padding);
		}
	}
}
