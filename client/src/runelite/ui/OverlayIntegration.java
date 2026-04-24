package runelite.ui;

import runelite.adapter.VoidClientAdapter;
import runelite.api.Client;
import runelite.ui.overlay.Overlay;
import runelite.ui.overlay.OverlayManager;
import runelite.ui.overlay.OverlayRenderer;
import runelite.ui.overlay.ExampleOverlay;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

/**
 * Singleton to manage RuneLite overlay system integration with void-client.
 * Handles overlay rendering and UI initialization.
 */
public class OverlayIntegration
{
	private static OverlayIntegration instance;
	private OverlayManager overlayManager;
	private OverlayRenderer overlayRenderer;
	private DrawManager drawManager;
	private Client client;
	private boolean uiInitialized = false;

	private OverlayIntegration()
	{
		this.overlayManager = new OverlayManager();
		this.overlayRenderer = new OverlayRenderer(null, overlayManager);
		this.drawManager = new DrawManager();
	}

	public static synchronized OverlayIntegration getInstance()
	{
		if (instance == null)
		{
			instance = new OverlayIntegration();
		}
		return instance;
	}

	public void initialize(Object canvas, Object clientInstance)
	{
		if (uiInitialized)
		{
			return;
		}

		try
		{
			System.out.println("Initializing RuneLite UI system...");

			// Create client adapter
			this.client = new VoidClientAdapter((Canvas) canvas, clientInstance);

			// Don't create a separate sidebar - the frame already has the UI structure
			// Just initialize overlays
			Overlay exampleOverlay = new ExampleOverlay();
			overlayManager.add(exampleOverlay);

			uiInitialized = true;
			System.out.println("RuneLite UI system initialized successfully");
		}
		catch (Exception e)
		{
			System.err.println("Failed to initialize RuneLite UI: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void debugRender(Graphics2D graphics)
	{
		if (!uiInitialized)
		{
			System.out.println("OverlayIntegration not initialized");
			return;
		}
		System.out.println("Rendering overlays - initialized: " + uiInitialized + ", manager: " + (overlayManager != null));
		renderOverlayLayers(graphics);
	}

	public void renderOverlays(Graphics2D graphics)
	{
		if (!uiInitialized)
		{
			// Try to initialize UI if canvas is available
			try
			{
				Class class305 = Class.forName("Class305");
				Field canvasField = class305.getDeclaredField("aCanvas3869");
				canvasField.setAccessible(true);
				Object canvas = canvasField.get(null);

				if (canvas != null)
				{
					// Get client instance from somewhere
					Class class93 = Class.forName("Class93");
					Field appletField = class93.getDeclaredField("anApplet1530");
					appletField.setAccessible(true);
					Object applet = appletField.get(null);

					initialize(canvas, applet);
				}
			}
			catch (Exception e)
			{
				// Not ready yet
			}
		}

		renderOverlayLayers(graphics);
	}

	private void renderOverlayLayers(Graphics2D graphics)
	{
		overlayRenderer.renderOverlayLayer(graphics, runelite.ui.overlay.OverlayLayer.ABOVE_WIDGETS);
		overlayRenderer.renderOverlayLayer(graphics, runelite.ui.overlay.OverlayLayer.UNDER_WIDGETS);
		overlayRenderer.renderOverlayLayer(graphics, runelite.ui.overlay.OverlayLayer.ABOVE_SCENE);
		overlayRenderer.renderOverlayLayer(graphics, runelite.ui.overlay.OverlayLayer.ALWAYS_ON_TOP);
	}

	public OverlayManager getOverlayManager()
	{
		return overlayManager;
	}

	public Client getClient()
	{
		return client;
	}

	public boolean isInitialized()
	{
		return uiInitialized;
	}
}
