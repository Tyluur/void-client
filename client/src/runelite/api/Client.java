package runelite.api;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Point;
import java.util.List;

/**
 * Client API interface for void-client integration.
 * Mirrors RuneLite's Client interface for plugin compatibility.
 * Methods return sensible defaults when not yet implemented.
 */
public interface Client
{
	Canvas getCanvas();

	Dimension getRealDimensions();

	int getViewportXOffset();

	int getViewportYOffset();

	Point getMouseCanvasPosition();

	GameState getGameState();

	boolean isResized();

	int getCanvasWidth();

	int getCanvasHeight();

	/**
	 * Gets the current game tick count.
	 */
	int getTickCount();

	/**
	 * Gets the game cycle (same as tick count in most contexts).
	 */
	int getGameCycle();

	/**
	 * Gets the current world number.
	 */
	int getWorld();

	/**
	 * Gets the FPS.
	 */
	int getFPS();

	/**
	 * Gets the current map region base X.
	 */
	int getBaseX();

	/**
	 * Gets the current map region base Y.
	 */
	int getBaseY();

	/**
	 * Gets the current plane/level.
	 */
	int getPlane();

	/**
	 * Gets the local player's name, or null if not logged in.
	 */
	String getLocalPlayerName();

	/**
	 * Gets the local player's combat level, or -1.
	 */
	int getLocalPlayerCombatLevel();

	/**
	 * Gets boosted skill level.
	 */
	int getBoostedSkillLevel(Skill skill);

	/**
	 * Gets real (unboosted) skill level.
	 */
	int getRealSkillLevel(Skill skill);

	/**
	 * Gets skill experience.
	 */
	int getSkillExperience(Skill skill);

	/**
	 * Gets the current energy level (0-10000).
	 */
	int getEnergy();

	/**
	 * Gets the current weight.
	 */
	int getWeight();

	/**
	 * Gets a varbit value.
	 */
	int getVarbitValue(int varbitId);

	/**
	 * Gets a varp (var player) value.
	 */
	int getVarpValue(int varpId);

	/**
	 * Gets widget by group and child id, or null.
	 */
	Object getWidget(int groupId, int childId);

	/**
	 * Gets the map scale (zoom).
	 */
	int getScale();

	/**
	 * Adds a chat message.
	 */
	void addChatMessage(int type, String name, String message, String sender);
}
