package runelite.ui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

public class FontManager
{
	private static final Font runescapeFont;
	private static final Font runescapeSmallFont;
	private static final Font runescapeBoldFont;

	static
	{
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font font = null;
		Font boldFont = null;
		Font smallFont = null;

		try (InputStream inRunescape = FontManager.class.getResourceAsStream("runescape.ttf");
			 InputStream inRunescapeBold = FontManager.class.getResourceAsStream("runescape_bold.ttf");
			 InputStream inRunescapeSmall = FontManager.class.getResourceAsStream("runescape_small.ttf"))
		{
			if (inRunescape != null)
			{
				font = Font.createFont(Font.TRUETYPE_FONT, inRunescape);
				ge.registerFont(font);
			}
			if (inRunescapeBold != null)
			{
				boldFont = Font.createFont(Font.TRUETYPE_FONT, inRunescapeBold);
				ge.registerFont(boldFont);
			}
			if (inRunescapeSmall != null)
			{
				smallFont = Font.createFont(Font.TRUETYPE_FONT, inRunescapeSmall);
				ge.registerFont(smallFont);
			}
		}
		catch (FontFormatException | IOException ex)
		{
			System.err.println("Failed to load RuneScape fonts: " + ex.getMessage());
		}

		runescapeFont = font != null ? font.deriveFont(Font.PLAIN, 16) : new Font(Font.DIALOG, Font.PLAIN, 16);
		runescapeBoldFont = boldFont != null ? boldFont.deriveFont(Font.BOLD, 16) : new Font(Font.DIALOG, Font.BOLD, 16);
		runescapeSmallFont = smallFont != null ? smallFont.deriveFont(Font.PLAIN, 16) : new Font(Font.DIALOG, Font.PLAIN, 12);
	}

	public static Font getRunescapeFont()
	{
		return runescapeFont;
	}

	public static Font getRunescapeSmallFont()
	{
		return runescapeSmallFont;
	}

	public static Font getRunescapeBoldFont()
	{
		return runescapeBoldFont;
	}
}
