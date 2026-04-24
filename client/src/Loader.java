import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Loader extends Applet {

    public static Properties aProperties1 = new Properties();
    public JFrame aJFrame2;
    public JPanel aJPanel3 = new JPanel();
    public static boolean loadRunescape = false;
    public static boolean showCoordinates = true;
    public static boolean skipLobby = true;
    public static boolean splitPorts = false;
    public static boolean debug = false;
    public static boolean trace = false;
    public static String address = "127.0.0.1";
    public static int port = 43594;
    public static final BigInteger LOGIN_SERVER_RSA_MODULUS = new BigInteger("ea3680fdebf2621da7a33601ba39925ee203b3fc80775cd3727bf27fd8c0791c803e0bdb42b8b5257567177f8569024569da9147cef59009ed016af6007e57a556f1754f09ca84dd39a03287f7e41e8626fd78ab3b53262bd63f2e37403a549980bf3077bd402b82ef5fac269eb3c04d2a9b7712a67a018321ceba6c3bfb8f7f", 16);
    public static final BigInteger FILE_SERVER_RSA_MODULUS = new BigInteger("d6808be939bbfd2ec4e96b1581ce3e1144b526e7643a72e3c64fbb902724fbfcf14ab601da6d6f8dbb57d1c369d080d9fc392abeb7886e0076d07f2aea5810e540d2817fd1967e35b39cc95cf7c9170b5fb55f5bf95524b60e938f0d64614bc365b87d66963a8cc8664e32875366099ef297180d01c7c3842162865e11d92299", 16);
    // Camera zoom constants
    static final int ZOOM_OFFSET_DEFAULT = 0; // Linear zoom offset added to the computed FOV (0 = no offset).
    static final int ZOOM_OFFSET_STEP = 15; // Scroll step size for the linear zoom offset.

    static final int FOV_MIN_FACTOR_NUM = 1; // FOV minimum as a fraction of the base min (numerator).
    static final int FOV_MIN_FACTOR_DEN = 4; // FOV minimum as a fraction of the base min (denominator).
    static final int FOV_MAX_FACTOR_NUM = 4; // FOV maximum as a fraction of the base max (numerator).
    static final int FOV_MAX_FACTOR_DEN = 1; // FOV maximum as a fraction of the base max (denominator).
    static final int FOV_MIN_ABS = 100; // Absolute minimum FOV clamp regardless of base settings.

    static final double RENDER_DISTANCE_MULTIPLIER = 2.0; // Adjust how many tiles off in the distance are rendered
    static final double CULLING_DISTANCE_MULTIPLIER = 1.8; // Adjust distance before objects go into fog

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            switch (arg) {
                case "-ip":
                case "--address":
                    address = args[i + 1];
                    break;
                case "-p":
                case "--port":
                    port = Integer.parseInt(args[i + 1]);
                    break;
                case "-d":
                case "--debug":
                    debug = true;
                    break;
                case "-t":
                case "--trace":
                    trace = true;
                    break;
            }
        }
        Loader l = new Loader();
        l.doFrame();
    }

    @Override
    public void init() {
        doApplet();
    }

    void doApplet() {
        setParms();
        startClient();
    }

    public void doFrame() {
        setParms();
        initRuneLiteFrame();
        startClient(this);
    }

    void setParms() {
        aProperties1.put("cabbase", "g.cab");
        aProperties1.put("java_arguments", "-Xmx102m -Dsun.java2d.noddraw=true");
        aProperties1.put("colourid", "0");
        aProperties1.put("worldid", "16");
        aProperties1.put("lobbyid", "15");
        aProperties1.put("lobbyaddress", loadRunescape ? "lobby16.runescape.com" : address);
        aProperties1.put("demoid", "0");
        aProperties1.put("demoaddress", "");
        aProperties1.put("modewhere", "0");
        aProperties1.put("modewhat", "0");
        aProperties1.put("lang", "0");
        aProperties1.put("objecttag", "0");
        aProperties1.put("js", "1");
        aProperties1.put("game", "0");
        aProperties1.put("affid", "0");
        aProperties1.put("advert", "1");
        aProperties1.put("settings", "wwGlrZHF5gJcZl7tf7KSRh0MZLhiU0gI0xDX6DwZ-Qk");
        aProperties1.put("country", "0");
        aProperties1.put("haveie6", "0");
        aProperties1.put("havefirefox", "1");
        aProperties1.put("cookieprefix", "");
        aProperties1.put("cookiehost", "127.0.0.3");
        aProperties1.put("cachesubdirid", "0");
        aProperties1.put("crashurl", "");
        aProperties1.put("unsignedurl", "");
        aProperties1.put("sitesettings_member", "1");
        aProperties1.put("frombilling", "false");
        aProperties1.put("sskey", "");
        aProperties1.put("force64mb", "false");
        aProperties1.put("worldflags", "8");
    }

    private runelite.ui.ClientUI clientUI;

    void initRuneLiteFrame() {
        try {
            clientUI = new runelite.ui.ClientUI();
            clientUI.init();
            aJFrame2 = clientUI.getFrame();

            // Add Loader applet into the ClientPanel (game area)
            aJPanel3.setLayout(new BorderLayout());
            aJPanel3.add(this);
            aJPanel3.setPreferredSize(new Dimension(765, 503));
            clientUI.getClientPanel().add(aJPanel3, BorderLayout.CENTER);

            // Initialize Guice DI and plugin system
            com.google.inject.Injector injector = com.google.inject.Guice.createInjector(
                new runelite.VoidClientModule(clientUI));

            runelite.plugins.PluginManager pluginManager = runelite.plugins.PluginManager.getInstance();
            pluginManager.setClientUI(clientUI);
            pluginManager.setInjector(injector);

            // Add default navigation buttons (placeholder plugins)
            addDefaultNavButtons(clientUI);

            // Load plugins (plugins can now use @Inject for Client, ConfigManager, etc.)
            pluginManager.add(runelite.plugins.tileindicators.TileIndicatorsPlugin.class);

            // Set window icons
            ArrayList<Image> icons = new ArrayList<>();
            for (String name : Arrays.asList("icon-16.png", "icon-32.png", "icon-64.png", "icon-128.png", "icon-256.png")) {
                URL resource = Loader.class.getResource(name);
                if (resource != null) {
                    icons.add(new ImageIcon(resource).getImage());
                }
            }
            aJFrame2.setIconImages(icons);

            // Show the frame
            clientUI.show();
            System.out.println("RuneLite frame initialized");
        } catch (Exception e) {
            System.err.println("Failed to create RuneLite frame: " + e.getMessage());
            e.printStackTrace();
        }
    }

    void openFrame() {
        aJFrame2 = new JFrame("Client");
        aJFrame2.setLayout(new BorderLayout());
        aJPanel3.setLayout(new BorderLayout());
        aJPanel3.add(this);
        aJPanel3.setPreferredSize(new Dimension(765, 503));
        aJFrame2.getContentPane().add(aJPanel3, "Center");
        aJFrame2.pack();
        aJFrame2.setVisible(true);
        aJFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ArrayList<Image> icons = new ArrayList<>();
        for (String name : Arrays.asList("icon-16.png", "icon-32.png", "icon-64.png", "icon-128.png", "icon-256.png")) {
            URL resource = Loader.class.getResource(name);
            if (resource != null) {
                icons.add(new ImageIcon(resource).getImage());
            }
        }
        aJFrame2.setIconImages(icons);
    }

    public static void startClient() {
        startClient(null);
    }

    public static void startClient(Applet loaderApplet) {
        try {
            System.out.println("Loading void-client...");

            // Register the Loader applet so client.getParameter() delegates to it
            if (loaderApplet != null) {
                Applet_Sub1.provideLoaderApplet(loaderApplet);
                System.out.println("Loader applet registered for parameter delegation");
            }

            // Create client instance
            Class var_client = Class.forName("client");
            Object clientInstance = var_client.newInstance();

            // Call init() which reads parameters and calls method95() to start the game thread
            Method initMethod = var_client.getMethod("init");
            initMethod.invoke(clientInstance);

            System.out.println("Client initialized successfully");
        } catch (Exception e) {
            System.err.println("Failed to start client: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void addDefaultNavButtons(runelite.ui.ClientUI clientUI) {
        // Configuration panel
        clientUI.addNavigation(runelite.ui.NavigationButton.builder()
            .priority(0)
            .icon(createIcon(new Color(200, 200, 200), 0))
            .tooltip("Configuration")
            .panel(new runelite.ui.PluginPanel() {
                { // instance initializer
                    javax.swing.JLabel title = new javax.swing.JLabel("Configuration");
                    title.setForeground(Color.WHITE);
                    title.setFont(title.getFont().deriveFont(16f));
                    add(title);
                    javax.swing.JLabel desc = new javax.swing.JLabel("<html>Plugin configuration will appear here.</html>");
                    desc.setForeground(new Color(170, 170, 170));
                    add(desc);
                }
            })
            .build());

        // Account panel
        clientUI.addNavigation(runelite.ui.NavigationButton.builder()
            .priority(1)
            .icon(createIcon(new Color(220, 138, 0), 1))
            .tooltip("Account")
            .panel(new runelite.ui.PluginPanel() {
                {
                    javax.swing.JLabel title = new javax.swing.JLabel("Account");
                    title.setForeground(Color.WHITE);
                    title.setFont(title.getFont().deriveFont(16f));
                    add(title);
                    javax.swing.JLabel desc = new javax.swing.JLabel("<html>Not logged in.</html>");
                    desc.setForeground(new Color(170, 170, 170));
                    add(desc);
                }
            })
            .build());

        // Loot Tracker panel
        clientUI.addNavigation(runelite.ui.NavigationButton.builder()
            .priority(2)
            .icon(createIcon(new Color(55, 240, 70), 2))
            .tooltip("Loot Tracker")
            .panel(new runelite.ui.PluginPanel() {
                {
                    javax.swing.JLabel title = new javax.swing.JLabel("Loot Tracker");
                    title.setForeground(Color.WHITE);
                    title.setFont(title.getFont().deriveFont(16f));
                    add(title);
                    javax.swing.JLabel desc = new javax.swing.JLabel("<html>No loot tracked yet.</html>");
                    desc.setForeground(new Color(170, 170, 170));
                    add(desc);
                }
            })
            .build());

        // HiScores panel
        clientUI.addNavigation(runelite.ui.NavigationButton.builder()
            .priority(3)
            .icon(createIcon(new Color(50, 160, 250), 3))
            .tooltip("HiScores")
            .panel(new runelite.ui.PluginPanel() {
                {
                    javax.swing.JLabel title = new javax.swing.JLabel("HiScores");
                    title.setForeground(Color.WHITE);
                    title.setFont(title.getFont().deriveFont(16f));
                    add(title);
                    javax.swing.JLabel desc = new javax.swing.JLabel("<html>Look up player hiscores.</html>");
                    desc.setForeground(new Color(170, 170, 170));
                    add(desc);
                }
            })
            .build());
    }

    private static java.awt.image.BufferedImage createIcon(Color color, int shape) {
        java.awt.image.BufferedImage img = new java.awt.image.BufferedImage(16, 16, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        switch (shape) {
            case 0: // gear (config)
                g.setStroke(new java.awt.BasicStroke(1.5f));
                g.drawOval(4, 4, 8, 8);
                g.fillOval(6, 6, 4, 4);
                for (int a = 0; a < 360; a += 45) {
                    double r = Math.toRadians(a);
                    g.drawLine(8 + (int)(5 * Math.cos(r)), 8 + (int)(5 * Math.sin(r)),
                               8 + (int)(7 * Math.cos(r)), 8 + (int)(7 * Math.sin(r)));
                }
                break;
            case 1: // person (account)
                g.fillOval(5, 2, 6, 6);
                g.fillArc(2, 9, 12, 10, 0, 180);
                break;
            case 2: // chest (loot)
                g.fillRoundRect(2, 5, 12, 9, 3, 3);
                g.setColor(color.darker());
                g.drawLine(2, 9, 14, 9);
                g.setColor(color);
                g.fillOval(6, 7, 4, 4);
                break;
            case 3: // chart (hiscores)
                g.fillRect(2, 9, 3, 5);
                g.fillRect(6, 5, 3, 9);
                g.fillRect(10, 2, 3, 12);
                break;
        }
        g.dispose();
        return img;
    }

    @Override
    public String getParameter(String arg0) {
        return (String) aProperties1.get(arg0);
    }

    @Override
    public URL getDocumentBase() {
        return getCodeBase();
    }

    @Override
    public URL getCodeBase() {
        URL url;
        try {
            if (loadRunescape) url = new URL("http://world16.runescape.com");
            else url = new URL("http://" + address);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return url;
    }

    public static String getDebug(int id) {
        return debug ? " <col=00ff00>(</col>" + id + "<col=00ff00>)</col>" : "";
    }

    public static String getDebug(int id, int component) {
        return debug ? " <col=00ff00>(</col>" + id + " - " + component + "<col=00ff00>)</col>" : "";
    }

    public static String getDebug(int id, int x, int y, int plane) {
        return debug ? " <col=00ff00>(</col>" + id + " - " + x + ", " + y + ", " + plane + "<col=00ff00>)</col>" : "";
    }
}