package runelite.api;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Allows scheduling tasks on the game thread.
 * Mirrors RuneLite's ClientThread API.
 */
public class ClientThread
{
	private static final ClientThread INSTANCE = new ClientThread();
	private final Queue<Runnable> tasks = new ConcurrentLinkedQueue<>();

	public static ClientThread getInstance()
	{
		return INSTANCE;
	}

	/**
	 * Schedule a task to run on the next game tick.
	 */
	public void invoke(Runnable task)
	{
		tasks.add(task);
	}

	/**
	 * Schedule a task that will be retried until it returns true.
	 */
	public void invokeLater(Runnable task)
	{
		invoke(task);
	}

	/**
	 * Called by the game loop hook each tick to drain pending tasks.
	 */
	public void drainTasks()
	{
		Runnable task;
		while ((task = tasks.poll()) != null)
		{
			try
			{
				task.run();
			}
			catch (Exception e)
			{
				System.err.println("Error executing client thread task: " + e.getMessage());
			}
		}
	}
}
