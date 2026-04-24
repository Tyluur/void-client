package runelite.api;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Point;
import java.lang.reflect.Field;

import runelite.api.Experience;

/**
 * Concrete Client implementation that bridges to void-client obfuscated classes.
 * Uses reflection to read game state from the obfuscated fields.
 * Methods that can't be mapped yet return safe defaults.
 */
public class VoidClient implements Client
{
	private static final VoidClient INSTANCE = new VoidClient();

	public static VoidClient getInstance()
	{
		return INSTANCE;
	}

	private Canvas cachedCanvas;

	@Override
	public Canvas getCanvas()
	{
		if (cachedCanvas == null)
		{
			try
			{
				Field f = Class.forName("Class305").getDeclaredField("aCanvas3869");
				f.setAccessible(true);
				cachedCanvas = (Canvas) f.get(null);
			}
			catch (Exception e)
			{
				// Canvas not yet created
			}
		}
		return cachedCanvas;
	}

	@Override
	public Dimension getRealDimensions()
	{
		Canvas c = getCanvas();
		return c != null ? c.getSize() : new Dimension(765, 503);
	}

	@Override
	public int getViewportXOffset() { return 0; }

	@Override
	public int getViewportYOffset() { return 0; }

	@Override
	public Point getMouseCanvasPosition()
	{
		Canvas c = getCanvas();
		if (c != null)
		{
			Point p = c.getMousePosition();
			if (p != null) return p;
		}
		return new Point(-1, -1);
	}

	@Override
	public GameState getGameState()
	{
		return GameState.of(getRawGameState());
	}

	public static int getRawGameState()
	{
		try
		{
			Field f = Class.forName("Class240").getDeclaredField("anInt4674");
			f.setAccessible(true);
			return f.getInt(null);
		}
		catch (Exception e)
		{
			return -1;
		}
	}

	@Override
	public boolean isResized() { return false; }

	@Override
	public int getCanvasWidth()
	{
		Canvas c = getCanvas();
		return c != null ? c.getWidth() : 765;
	}

	@Override
	public int getCanvasHeight()
	{
		Canvas c = getCanvas();
		return c != null ? c.getHeight() : 503;
	}

	@Override
	public int getTickCount() { return getIntField("client", "anInt1313", 0); }

	@Override
	public int getGameCycle() { return getTickCount(); }

	@Override
	public int getWorld() { return getIntField("client", "currentWorld", 16); }

	@Override
	public int getFPS() { return getIntField("Class348_Sub40_Sub9", "anInt9165", 0); }

	@Override
	public int getBaseX() { return getIntField("Class305", "anInt3884", 0); }

	@Override
	public int getBaseY() { return getIntField("Class305", "anInt3885", 0); }

	@Override
	public int getPlane() { return getIntField("Class305", "anInt3846", 0); }

	@Override
	public String getLocalPlayerName()
	{
		try
		{
			Field f = Class.forName("Class348_Sub40_Sub13").getDeclaredField("aString9270");
			f.setAccessible(true);
			return (String) f.get(null);
		}
		catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public int getLocalPlayerCombatLevel() { return getIntField("Class348_Sub40_Sub13", "anInt9275", -1); }

	@Override
	public int getBoostedSkillLevel(Skill skill)
	{
		return getSkillArray("Class161", "anIntArray2145", skill.ordinal());
	}

	@Override
	public int getRealSkillLevel(Skill skill)
	{
		int xp = getSkillExperience(skill);
		return Experience.getLevelForXp(xp);
	}

	@Override
	public int getSkillExperience(Skill skill)
	{
		return getSkillArray("Class186", "anIntArray2497", skill.ordinal());
	}

	@Override
	public int getEnergy() { return getIntField("Class305", "anInt3870", 0); }

	@Override
	public int getWeight() { return getIntField("Class305", "anInt3871", 0); }

	@Override
	public int getVarbitValue(int varbitId) { return 0; }

	@Override
	public int getVarpValue(int varpId)
	{
		try
		{
			Field f = Class.forName("Class305").getDeclaredField("anIntArray3858");
			f.setAccessible(true);
			int[] varps = (int[]) f.get(null);
			if (varps != null && varpId >= 0 && varpId < varps.length)
			{
				return varps[varpId];
			}
		}
		catch (Exception e)
		{
			// Not available
		}
		return 0;
	}

	@Override
	public Object getWidget(int groupId, int childId) { return null; }

	@Override
	public int getScale() { return getIntField("Class305", "anInt3875", 0); }

	@Override
	public void addChatMessage(int type, String name, String message, String sender)
	{
		// TODO: bridge to void-client chat system
		System.out.println("[Chat] " + name + ": " + message);
	}

	// ---- Reflection helpers ----

	private static int getIntField(String className, String fieldName, int defaultVal)
	{
		try
		{
			Field f = Class.forName(className).getDeclaredField(fieldName);
			f.setAccessible(true);
			return f.getInt(null);
		}
		catch (Exception e)
		{
			return defaultVal;
		}
	}

	private static int getSkillArray(String className, String fieldName, int index)
	{
		try
		{
			Field f = Class.forName(className).getDeclaredField(fieldName);
			f.setAccessible(true);
			int[] arr = (int[]) f.get(null);
			if (arr != null && index >= 0 && index < arr.length)
			{
				return arr[index];
			}
		}
		catch (Exception e)
		{
			// Not available
		}
		return 0;
	}
}
