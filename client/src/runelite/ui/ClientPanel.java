package runelite.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Panel that wraps the void-client canvas.
 */
public class ClientPanel extends JPanel
{
	private static final Dimension GAME_FIXED_SIZE = new Dimension(765, 503);

	public ClientPanel(Component client)
	{
		setSize(GAME_FIXED_SIZE);
		setMinimumSize(GAME_FIXED_SIZE);
		setPreferredSize(GAME_FIXED_SIZE);
		setLayout(new BorderLayout());
		setBackground(Color.black);

		if (client != null)
		{
			add(client, BorderLayout.CENTER);
		}
	}
}
