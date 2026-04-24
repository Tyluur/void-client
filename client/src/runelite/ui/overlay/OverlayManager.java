package runelite.ui.overlay;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages all registered overlays and their rendering layers.
 */
public class OverlayManager
{
	private static final OverlayManager INSTANCE = new OverlayManager();

	public static OverlayManager getInstance()
	{
		return INSTANCE;
	}

	private final List<Overlay> overlays = new ArrayList<>();
	private final Map<OverlayLayer, List<Overlay>> overlayLayers = new HashMap<>();

	public void add(Overlay overlay)
	{
		if (!overlays.contains(overlay))
		{
			overlays.add(overlay);
			rebuildOverlayLayers();
		}
	}

	public void remove(Overlay overlay)
	{
		overlays.remove(overlay);
		rebuildOverlayLayers();
	}

	public Collection<Overlay> getLayer(OverlayLayer layer)
	{
		return overlayLayers.getOrDefault(layer, Collections.emptyList());
	}

	public Collection<Overlay> getForInterface(int interfaceId)
	{
		// For now, return empty - interface-specific overlays can be added later
		return Collections.emptyList();
	}

	public Collection<Overlay> getForLayer(int layerId)
	{
		// For now, return empty - layer-specific overlays can be added later
		return Collections.emptyList();
	}

	public void rebuildOverlayLayers()
	{
		overlayLayers.clear();
		for (OverlayLayer layer : OverlayLayer.values())
		{
			overlayLayers.put(layer, new ArrayList<>());
		}

		for (Overlay overlay : overlays)
		{
			if (!overlay.isMuted())
			{
				overlayLayers.get(overlay.getLayer()).add(overlay);
			}
		}
	}

	public void resetOverlay(Overlay overlay)
	{
		overlay.setPreferredLocation(null);
		overlay.setPreferredPosition(null);
		overlay.revalidate();
	}

	public void saveOverlay(Overlay overlay)
	{
		// Configuration persistence can be added later
	}

	public void setWidgetItems(Collection<?> widgetItems)
	{
		// Widget item tracking can be added later
	}
}
