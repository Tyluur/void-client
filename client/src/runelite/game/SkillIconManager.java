package runelite.game;

import runelite.api.Skill;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class SkillIconManager
{
	private final BufferedImage[] imgCache = new BufferedImage[Skill.values().length * 2];

	public BufferedImage getSkillImage(Skill skill, boolean small)
	{
		int skillIdx = skill.ordinal() + (small ? Skill.values().length : 0);

		if (imgCache[skillIdx] != null)
		{
			return imgCache[skillIdx];
		}

		String skillName = skill.getName().toLowerCase();
		if (skill == Skill.HITPOINTS)
		{
			skillName = "constitution";
		}
		String skillIconPath = "/skill_icons_634/" + skillName + ".png";

		try (InputStream in = getClass().getResourceAsStream(skillIconPath))
		{
			if (in != null)
			{
				BufferedImage skillImage = ImageIO.read(in);
				imgCache[skillIdx] = skillImage;
				return skillImage;
			}
		}
		catch (IOException e)
		{
			System.err.println("Failed to load skill icon: " + skillIconPath);
		}

		return null;
	}

	public BufferedImage getSkillImage(Skill skill)
	{
		return getSkillImage(skill, false);
	}
}
