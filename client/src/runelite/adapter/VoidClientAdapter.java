package runelite.adapter;

import runelite.api.Client;
import runelite.api.GameState;
import runelite.api.Skill;
import runelite.api.VoidClient;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Point;

/**
 * Legacy adapter — delegates to VoidClient singleton.
 * @deprecated Use VoidClient directly via @Inject Client.
 */
@Deprecated
public class VoidClientAdapter implements Client
{
	private final VoidClient delegate = VoidClient.getInstance();

	public VoidClientAdapter(Canvas canvas, Object clientInstance) {}

	@Override public Canvas getCanvas() { return delegate.getCanvas(); }
	@Override public Dimension getRealDimensions() { return delegate.getRealDimensions(); }
	@Override public int getViewportXOffset() { return delegate.getViewportXOffset(); }
	@Override public int getViewportYOffset() { return delegate.getViewportYOffset(); }
	@Override public Point getMouseCanvasPosition() { return delegate.getMouseCanvasPosition(); }
	@Override public GameState getGameState() { return delegate.getGameState(); }
	@Override public boolean isResized() { return delegate.isResized(); }
	@Override public int getCanvasWidth() { return delegate.getCanvasWidth(); }
	@Override public int getCanvasHeight() { return delegate.getCanvasHeight(); }
	@Override public int getTickCount() { return delegate.getTickCount(); }
	@Override public int getGameCycle() { return delegate.getGameCycle(); }
	@Override public int getWorld() { return delegate.getWorld(); }
	@Override public int getFPS() { return delegate.getFPS(); }
	@Override public int getBaseX() { return delegate.getBaseX(); }
	@Override public int getBaseY() { return delegate.getBaseY(); }
	@Override public int getPlane() { return delegate.getPlane(); }
	@Override public String getLocalPlayerName() { return delegate.getLocalPlayerName(); }
	@Override public int getLocalPlayerCombatLevel() { return delegate.getLocalPlayerCombatLevel(); }
	@Override public int getBoostedSkillLevel(Skill skill) { return delegate.getBoostedSkillLevel(skill); }
	@Override public int getRealSkillLevel(Skill skill) { return delegate.getRealSkillLevel(skill); }
	@Override public int getSkillExperience(Skill skill) { return delegate.getSkillExperience(skill); }
	@Override public int getEnergy() { return delegate.getEnergy(); }
	@Override public int getWeight() { return delegate.getWeight(); }
	@Override public int getVarbitValue(int varbitId) { return delegate.getVarbitValue(varbitId); }
	@Override public int getVarpValue(int varpId) { return delegate.getVarpValue(varpId); }
	@Override public Object getWidget(int groupId, int childId) { return delegate.getWidget(groupId, childId); }
	@Override public int getScale() { return delegate.getScale(); }
	@Override public void addChatMessage(int type, String name, String message, String sender) { delegate.addChatMessage(type, name, message, sender); }
}
