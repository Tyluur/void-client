package runelite.ui;

import java.awt.Image;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Manages draw callbacks for overlay rendering.
 */
public class DrawManager
{
	private final List<Runnable> everyFrame = new CopyOnWriteArrayList<>();
	private final Queue<Consumer<Image>> nextFrame = new ConcurrentLinkedQueue<>();

	public void registerEveryFrameListener(Runnable everyFrameListener)
	{
		if (!everyFrame.contains(everyFrameListener))
		{
			everyFrame.add(everyFrameListener);
		}
	}

	public void unregisterEveryFrameListener(Runnable everyFrameListener)
	{
		everyFrame.remove(everyFrameListener);
	}

	public void requestNextFrameListener(Consumer<Image> nextFrameListener)
	{
		nextFrame.add(nextFrameListener);
	}

	public void processDrawComplete(Supplier<Image> imageSupplier)
	{
		for (Runnable everyFrameListener : everyFrame)
		{
			try
			{
				everyFrameListener.run();
			}
			catch (Exception e)
			{
				System.err.println("Error in draw consumer: " + e.getMessage());
				e.printStackTrace();
			}
		}

		Consumer<Image> nextFrameListener = nextFrame.poll();
		Image image = null;
		while (nextFrameListener != null)
		{
			if (image == null)
			{
				try
				{
					image = imageSupplier.get();
				}
				catch (Exception ex)
				{
					System.err.println("Error getting screenshot: " + ex.getMessage());
					ex.printStackTrace();
				}
			}

			if (image == null)
			{
				nextFrame.clear();
				break;
			}

			try
			{
				nextFrameListener.accept(image);
			}
			catch (Exception e)
			{
				System.err.println("Error in draw consumer: " + e.getMessage());
				e.printStackTrace();
			}
			nextFrameListener = nextFrame.poll();
		}
	}
}
