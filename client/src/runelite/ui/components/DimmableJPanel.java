package runelite.ui.components;

import javax.swing.*;
import java.awt.*;

public class DimmableJPanel extends JPanel
{
	private boolean dimmed = false;
	private Color dimmedForeground = null;
	private Color dimmedBackground = null;
	private Color undimmedForeground = null;
	private Color undimmedBackground = null;

	@Override
	public void setForeground(Color color)
	{
		undimmedForeground = color;
		dimmedForeground = color.darker();
		super.setForeground(color);
	}

	@Override
	public void setBackground(Color color)
	{
		undimmedBackground = color;
		dimmedBackground = color.darker();
		super.setBackground(color);
	}

	@Override
	public Color getForeground()
	{
		return dimmed ? dimmedForeground : undimmedForeground;
	}

	@Override
	public Color getBackground()
	{
		return dimmed ? dimmedBackground : undimmedBackground;
	}

	public boolean isDimmed()
	{
		return dimmed;
	}

	public void setDimmed(boolean dimmed)
	{
		this.dimmed = dimmed;

		if (dimmed)
		{
			super.setBackground(dimmedBackground);
			super.setForeground(dimmedForeground);
		}
		else
		{
			super.setBackground(undimmedBackground);
			super.setForeground(undimmedForeground);
		}
	}
}
