package runelite.ui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.ui.FlatNativeWindowBorder;
import runelite.ui.laf.RuneLiteLAF;
import runelite.util.ImageUtil;
import runelite.util.SwingUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.TreeSet;
import java.util.function.Function;

/**
 * RuneLite-faithful ClientUI for void-client.
 * Uses the exact same layout approach as RuneLite:
 * - Custom Layout manager
 * - JTabbedPane(RIGHT) sidebar with tab icons
 * - ClientToolbarPanel as trailing component
 * - ClientPanel for the game area
 */
public class ClientUI
{
	private static final BufferedImage ICON_16;
	private static final BufferedImage ICON_128;

	static
	{
		ICON_16 = ImageUtil.loadImageResource(ClientUI.class, "/icon-16.png");
		ICON_128 = ImageUtil.loadImageResource(ClientUI.class, "/icon-128.png");
	}

	private ContainableFrame frame;
	private JPanel content;
	private ClientPanel clientPanel;
	private JTabbedPane sidebar;
	private final TreeSet<NavigationButton> sidebarEntries = new TreeSet<>(NavigationButton.COMPARATOR);
	private final Deque<NavigationButton> selectedTabHistory = new ArrayDeque<>();
	private NavigationButton selectedTab;
	private ClientToolbarPanel toolbarPanel;
	private boolean withTitleBar;
	private JButton sidebarNavBtn;
	private BufferedImage sidebarOpenIcon;
	private BufferedImage sidebarCloseIcon;

	public void init() throws Exception
	{
		SwingUtilities.invokeAndWait(this::buildUI);
	}

	private void buildUI()
	{
		// Set sensible swing defaults (match RuneLite)
		setupDefaults();

		// Setup RuneLite LAF
		try
		{
			RuneLiteLAF.setup();
		}
		catch (Exception e)
		{
			System.err.println("Failed to set RuneLite LAF: " + e.getMessage());
			try
			{
				UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
			}
			catch (Exception ex)
			{
				// Use system default
			}
		}

		// Create main frame
		frame = new ContainableFrame();
		frame.setTitle("Void Client");
		if (ICON_128 != null && ICON_16 != null)
		{
			frame.setIconImages(Arrays.asList(ICON_128, ICON_16));
		}
		frame.setLocationRelativeTo(frame.getOwner());
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Content panel with RuneLite's custom Layout
		content = new JPanel();
		content.setLayout(new Layout());

		// Client panel (game area)
		clientPanel = new ClientPanel(null);
		content.add(clientPanel);

		// Sidebar (JTabbedPane with RIGHT tab placement, exactly like RuneLite)
		sidebar = new JTabbedPane(JTabbedPane.RIGHT);
		sidebar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		sidebar.setOpaque(true);
		sidebar.putClientProperty(FlatClientProperties.STYLE,
			"tabInsets: 4,8,4,8; variableSize: true; deselectable: true; tabHeight: 28");
		sidebar.setSelectedIndex(-1);
		sidebar.addChangeListener(ev ->
		{
			NavigationButton oldSelectedTab = selectedTab;
			NavigationButton newSelectedTab;
			int index = sidebar.getSelectedIndex();
			if (index < 0)
			{
				newSelectedTab = null;
			}
			else
			{
				int i = 0;
				newSelectedTab = null;
				for (NavigationButton nb : sidebarEntries)
				{
					if (i == index)
					{
						newSelectedTab = nb;
						break;
					}
					i++;
				}
			}

			if (oldSelectedTab == newSelectedTab)
			{
				return;
			}
			selectedTab = newSelectedTab;

			if (sidebar.isVisible())
			{
				if (oldSelectedTab != null && oldSelectedTab.getPanel() != null)
				{
					SwingUtil.deactivate(oldSelectedTab.getPanel());
				}
				if (newSelectedTab != null && newSelectedTab.getPanel() != null)
				{
					SwingUtil.activate(newSelectedTab.getPanel());
				}
			}
		});

		content.add(sidebar);
		frame.setContentPane(content);

		// Decorate window with custom chrome and titlebar
		withTitleBar = true; // always use custom chrome like RuneLite
		toolbarPanel = new ClientToolbarPanel(!withTitleBar);

		// Create sidebar open/close icons
		sidebarOpenIcon = createSidebarIcon(true);
		sidebarCloseIcon = createSidebarIcon(false);

		if (withTitleBar)
		{
			// Toolbar in the menu bar (title bar area), matching RuneLite
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBorder(new EmptyBorder(0, 0, 0, 4));
			menuBar.add(Box.createGlue());
			menuBar.add(toolbarPanel);
			frame.setJMenuBar(menuBar);

			JRootPane rp = frame.getRootPane();
			if (FlatNativeWindowBorder.isSupported())
			{
				rp.putClientProperty(FlatClientProperties.USE_WINDOW_DECORATIONS, true);
			}
			else
			{
				frame.setUndecorated(true);
				rp.setWindowDecorationStyle(JRootPane.FRAME);
			}

			// Sidebar toggle button in the toolbar
			sidebarNavBtn = toolbarPanel.add(NavigationButton.builder()
				.priority(100)
				.icon(sidebarCloseIcon)
				.tooltip("Close sidebar")
				.onClick(this::toggleSidebar)
				.build(), false);
		}
		else
		{
			// Toolbar at bottom of sidebar tab strip
			sidebar.putClientProperty(
				FlatClientProperties.TABBED_PANE_TRAILING_COMPONENT,
				toolbarPanel.createSidebarPanel());
		}
	}

	private static void setupDefaults()
	{
		ToolTipManager tooltipManager = ToolTipManager.sharedInstance();
		tooltipManager.setLightWeightPopupEnabled(false);
		tooltipManager.setInitialDelay(300);
		tooltipManager.setDismissDelay(10_000);
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		System.setProperty("sun.awt.noerasebackground", "true");
	}

	/**
	 * Create a sidebar toggle icon (arrow shape).
	 * @param pointRight true for open icon (arrow pointing right), false for close (left)
	 */
	private BufferedImage createSidebarIcon(boolean pointRight)
	{
		BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = img.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(ColorScheme.LIGHT_GRAY_COLOR);
		if (pointRight)
		{
			int[] xPoints = {5, 11, 5};
			int[] yPoints = {3, 8, 13};
			g.fillPolygon(xPoints, yPoints, 3);
		}
		else
		{
			int[] xPoints = {11, 5, 11};
			int[] yPoints = {3, 8, 13};
			g.fillPolygon(xPoints, yPoints, 3);
		}
		g.dispose();
		return img;
	}

	public void addNavigation(NavigationButton navBtn)
	{
		Runnable task = () ->
		{
			if (navBtn.getPanel() == null)
			{
				toolbarPanel.add(navBtn, true);
				return;
			}

			if (!sidebarEntries.add(navBtn))
			{
				return;
			}

			final int TAB_SIZE = 16;
			Icon icon = new ImageIcon(ImageUtil.resizeImage(navBtn.getIcon(), TAB_SIZE, TAB_SIZE));
			sidebar.insertTab(null, icon, navBtn.getPanel().getWrappedPanel(), navBtn.getTooltip(),
				sidebarEntries.headSet(navBtn).size());

			// insertTab changes the selected index when the first tab is inserted, avoid this
			sidebar.setSelectedIndex(-1);
		};

		if (SwingUtilities.isEventDispatchThread())
		{
			task.run();
		}
		else
		{
			SwingUtilities.invokeLater(task);
		}
	}

	public void removeNavigation(NavigationButton navBtn)
	{
		if (navBtn.getPanel() == null)
		{
			toolbarPanel.remove(navBtn);
		}
		else
		{
			sidebar.remove(navBtn.getPanel().getWrappedPanel());
		}
		sidebarEntries.remove(navBtn);
	}

	private void toggleSidebar()
	{
		boolean open = !sidebar.isVisible();
		sidebar.setVisible(open);
		content.revalidate();

		if (sidebarNavBtn != null)
		{
			sidebarNavBtn.setIcon(new ImageIcon(open ? sidebarCloseIcon : sidebarOpenIcon));
			sidebarNavBtn.setToolTipText(open ? "Close sidebar" : "Open sidebar");
		}
	}

	/**
	 * Returns the client panel where the game component should be added.
	 */
	public ClientPanel getClientPanel()
	{
		return clientPanel;
	}

	public void show()
	{
		SwingUtilities.invokeLater(() ->
		{
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}

	public ContainableFrame getFrame()
	{
		return frame;
	}

	public JTabbedPane getSidebar()
	{
		return sidebar;
	}

	public ClientToolbarPanel getToolbarPanel()
	{
		return toolbarPanel;
	}

	/**
	 * Custom layout manager matching RuneLite's Layout.
	 * Component 0 = client panel, Component 1 = sidebar.
	 * Client fills left, sidebar on right.
	 */
	private class Layout implements LayoutManager2
	{
		private boolean doingLayout;

		@Override
		public void addLayoutComponent(String name, Component comp) {}

		@Override
		public void removeLayoutComponent(Component comp) {}

		@Override
		public void addLayoutComponent(Component comp, Object constraints) {}

		@Override
		public Dimension preferredLayoutSize(Container parent)
		{
			synchronized (parent.getTreeLock())
			{
				return computeSize(parent, Component::getPreferredSize);
			}
		}

		@Override
		public Dimension minimumLayoutSize(Container parent)
		{
			synchronized (parent.getTreeLock())
			{
				return computeSize(parent, c ->
				{
					if (parent.getComponentCount() > 1 && c == parent.getComponent(1))
					{
						return new Dimension(c.getPreferredSize().width, c.getMinimumSize().height);
					}
					return c.getMinimumSize();
				});
			}
		}

		@Override
		public void layoutContainer(Container parent)
		{
			Insets insets = parent.getInsets();
			int insetWidth = insets.left + insets.right;
			int insetHeight = insets.top + insets.bottom;

			if (parent.getComponentCount() < 2)
			{
				return;
			}

			Component clientComp = parent.getComponent(0);
			Component sidebarComp = parent.getComponent(1);

			int innerHeight = Math.max(parent.getHeight() - insetHeight,
				Math.max(clientComp.getMinimumSize().height, sidebarComp.getMinimumSize().height));

			sidebarComp.setSize(sidebarComp.getWidth(), innerHeight);

			int sidebarWidth = sidebarComp.isVisible()
				? sidebarComp.getPreferredSize().width
				: 0;
			int clientWidth = Math.max(clientComp.getMinimumSize().width,
				parent.getWidth() - insetWidth - sidebarWidth);

			int width = clientWidth + sidebarWidth;
			parent.setSize(width + insetWidth, innerHeight + insetHeight);
			parent.setPreferredSize(parent.getSize());

			clientComp.setBounds(insets.left, insets.top, clientWidth, innerHeight);
			sidebarComp.setBounds(insets.left + clientWidth, insets.top, sidebarWidth, innerHeight);

			Rectangle oldBounds = frame.getBounds();
			frame.revalidateMinimumSize();
			if (!frame.getPreferredSize().equals(oldBounds.getSize()))
			{
				if (!doingLayout)
				{
					try
					{
						doingLayout = true;
						frame.validate();
					}
					finally
					{
						doingLayout = false;
					}
				}
			}
		}

		private Dimension computeSize(Container parent, Function<Component, Dimension> sizer)
		{
			Dimension out = new Dimension(0, 0);
			for (int i = 0; i < parent.getComponentCount(); i++)
			{
				Component child = parent.getComponent(i);
				if (child.isVisible())
				{
					Dimension dim = sizer.apply(child);
					out.width += dim.width;
					out.height = Math.max(out.height, dim.height);
				}
			}
			Insets is = parent.getInsets();
			out.width += is.left + is.right;
			out.height += is.top + is.bottom;
			return out;
		}

		@Override
		public Dimension maximumLayoutSize(Container parent)
		{
			return computeSize(parent, Component::getMaximumSize);
		}

		@Override
		public float getLayoutAlignmentX(Container target) { return 0; }

		@Override
		public float getLayoutAlignmentY(Container target) { return 0; }

		@Override
		public void invalidateLayout(Container target) {}
	}
}
