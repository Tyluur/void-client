package runelite;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import runelite.api.Client;
import runelite.api.ClientThread;
import runelite.api.VoidClient;
import runelite.config.ConfigManager;
import runelite.eventbus.EventBus;
import runelite.plugins.PluginManager;
import runelite.ui.ClientUI;
import runelite.ui.overlay.OverlayManager;

/**
 * Guice module that binds all core RuneLite-compatible services.
 * This is what makes @Inject work in plugins.
 */
public class VoidClientModule extends AbstractModule
{
	private final ClientUI clientUI;

	public VoidClientModule(ClientUI clientUI)
	{
		this.clientUI = clientUI;
	}

	@Override
	protected void configure()
	{
		bind(Client.class).toInstance(VoidClient.getInstance());
		bind(ClientThread.class).toInstance(ClientThread.getInstance());
		bind(EventBus.class).toInstance(EventBus.getInstance());
		bind(ConfigManager.class).toInstance(ConfigManager.getInstance());
		bind(PluginManager.class).toInstance(PluginManager.getInstance());
		bind(ClientUI.class).toInstance(clientUI);
	}

	@Provides
	@Singleton
	OverlayManager provideOverlayManager()
	{
		return OverlayManager.getInstance();
	}
}
