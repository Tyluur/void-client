package runelite.eventbus;

import runelite.api.Client;
import runelite.api.GameState;
import runelite.events.GameTick;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Posts GameTick events on a timer (approximately every 600ms).
 * This is a simplified version of RuneLite's game tick posting mechanism.
 */
public class GameTickPoster
{
	private static final GameTickPoster INSTANCE = new GameTickPoster();
	private static final int TICK_RATE_MS = 600; // RuneLite game tick rate

	private final EventBus eventBus = EventBus.getInstance();
	private final Timer timer = new Timer("GameTickPoster", false);
	private boolean started = false;

	public static GameTickPoster getInstance()
	{
		return INSTANCE;
	}

	public void start()
	{
		if (started)
		{
			return;
		}

		started = true;
		timer.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run()
			{
				// Drain ClientThread tasks first
				runelite.api.ClientThread.getInstance().drainTasks();

				// Post GameTick if logged in
				Client client = runelite.api.VoidClient.getInstance();
				GameState state = client != null ? client.getGameState() : null;
				if (client != null && state == GameState.LOGGED_IN)
				{
					eventBus.post(GameTick.getInstance());
				}
			}
		}, TICK_RATE_MS, TICK_RATE_MS);

		System.out.println("GameTickPoster started");
	}

	public void stop()
	{
		if (started)
		{
			timer.cancel();
			started = false;
		}
	}
}
