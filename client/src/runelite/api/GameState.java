package runelite.api;

/**
 * Game state enum mapping void-client states to RuneLite states.
 */
public enum GameState
{
	STARTING,
	LOGIN_SCREEN,
	LOGIN_SCREEN_AUTHENTICATOR,
	LOGGING_IN,
	LOADING,
	LOGGED_IN,
	HOPPING,
	CONNECTION_LOST,
	UNKNOWN;

	/**
	 * Returns the state for a given void-client state integer, or UNKNOWN.
	 */
	public static GameState of(int state)
	{
		switch (state)
		{
			case 0: return STARTING;
			case 1: return LOGIN_SCREEN; // early connected state
			case 2: return LOGGING_IN;
			case 3: return LOGIN_SCREEN_AUTHENTICATOR;
			case 5: return LOADING;
			case 7: return LOGGED_IN;
			case 8: return LOGGED_IN;
			case 9: return LOGGED_IN;
			case 10: return LOGGED_IN; // lobby/world select, method1977 considers in-game
			case 11: return LOGGED_IN;
			case 12: return LOADING;
			case 13: return HOPPING;
			case 14: return CONNECTION_LOST;
			case 20: return LOGGING_IN;
			case 25: return LOADING;
			case 30: return LOGGED_IN;
			case 40: return HOPPING;
			case 50: return CONNECTION_LOST;
			default: return UNKNOWN;
		}
	}
}
