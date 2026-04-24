package runelite.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.TreeMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import runelite.util.ImageUtil;
import runelite.util.SwingUtil;

/**
 * Non-tab toolbar items, in the title bar or bottom of the sidebar.
 * Adapted from RuneLite for void-client integration.
 */
class ClientToolbarPanel extends JPanel
{
	private final TreeMap<NavigationButton, Component> entries = new TreeMap<>(NavigationButton.COMPARATOR);

	ClientToolbarPanel(boolean isInSidebar)
	{
		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		if (isInSidebar)
		{
			setLayout(new DynamicGridLayout(0, 1, 0, 4));
		}
		else
		{
			setLayout(new DynamicGridLayout(1, 0, 4, 0));
		}

		revalidate();
	}

	JButton add(NavigationButton nb, boolean resize)
	{
		java.awt.Image iconImg = resize ? ImageUtil.resizeImage(nb.getIcon(), 16, 16) : nb.getIcon();
		Icon icon = new ImageIcon(iconImg);
		JButton jb = new JButton(icon);
		SwingUtil.removeButtonDecorations(jb);
		jb.setToolTipText(nb.getTooltip());
		jb.setFocusable(false);
		jb.setPreferredSize(new Dimension(23, 23));
		jb.setAlignmentX(.5f);
		jb.setAlignmentY(.5f);

		jb.addActionListener(l ->
		{
			if (nb.getOnClick() != null)
			{
				nb.getOnClick().run();
			}
		});

		if (nb.getPopup() != null)
		{
			JPopupMenu menu = new JPopupMenu();
			nb.getPopup().forEach((name, cb) ->
			{
				JMenuItem menuItem = new JMenuItem(name);
				menuItem.addActionListener(e -> cb.run());
				menu.add(menuItem);
			});
			jb.setComponentPopupMenu(menu);
		}

		if (entries.putIfAbsent(nb, jb) != null)
		{
			return null;
		}
		add(jb, entries.headMap(nb).size());
		revalidate();
		revalidateMaxSize();
		return jb;
	}

	void remove(NavigationButton btn)
	{
		Component c = entries.remove(btn);
		if (c != null)
		{
			remove(c);
			revalidate();
			revalidateMaxSize();
		}
	}

	private void revalidateMaxSize()
	{
		setMaximumSize(getPreferredSize());
	}

	public JPanel createSidebarPanel()
	{
		JPanel wrap = new JPanel();
		wrap.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		wrap.setLayout(new BorderLayout());
		wrap.add(this, BorderLayout.SOUTH);
		return wrap;
	}
}
