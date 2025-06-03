import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.math.BigInteger;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;

public class Loader extends Applet {

    public static Properties parameters = new Properties();
    public JFrame frame;
    public JPanel panel = new JPanel();
    public static boolean loadRunescape = false;
    public static boolean showCoordinates = true;
    public static boolean skipLobby = true;
    public static boolean splitPorts = false;
    public static boolean debug = false;
    public static boolean trace = false;
    public static int port = 43594;
    public static final BigInteger LOGIN_SERVER_RSA_MODULUS = new BigInteger("ea3680fdebf2621da7a33601ba39925ee203b3fc80775cd3727bf27fd8c0791c803e0bdb42b8b5257567177f8569024569da9147cef59009ed016af6007e57a556f1754f09ca84dd39a03287f7e41e8626fd78ab3b53262bd63f2e37403a549980bf3077bd402b82ef5fac269eb3c04d2a9b7712a67a018321ceba6c3bfb8f7f", 16);
    public static final BigInteger FILE_SERVER_RSA_MODULUS = new BigInteger("d6808be939bbfd2ec4e96b1581ce3e1144b526e7643a72e3c64fbb902724fbfcf14ab601da6d6f8dbb57d1c369d080d9fc392abeb7886e0076d07f2aea5810e540d2817fd1967e35b39cc95cf7c9170b5fb55f5bf95524b60e938f0d64614bc365b87d66963a8cc8664e32875366099ef297180d01c7c3842162865e11d92299", 16);

    public static void main(String[] arg0) {
        debug = debug || Arrays.stream(arg0).anyMatch(it -> it.equals("--debug") || it.equals("-d"));
        trace = trace || Arrays.stream(arg0).anyMatch(it -> it.equals("--trace") || it.equals("-t"));
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
        openFrame();
        startClient();
    }

    void setParms() {
        parameters.put("cabbase", "g.cab");
        parameters.put("java_arguments", "-Xmx102m -Dsun.java2d.noddraw=true");
        parameters.put("colourid", "0");
        parameters.put("worldid", "16");
        parameters.put("lobbyid", "15");
        parameters.put("lobbyaddress", loadRunescape ? "lobby16.runescape.com" : "127.0.0.1");
        parameters.put("demoid", "0");
        parameters.put("demoaddress", "");
        parameters.put("modewhere", "0");
        parameters.put("modewhat", "0");
        parameters.put("lang", "0");
        parameters.put("objecttag", "0");
        parameters.put("js", "1");
        parameters.put("game", "0");
        parameters.put("affid", "0");
        parameters.put("advert", "1");
        parameters.put("settings", "wwGlrZHF5gJcZl7tf7KSRh0MZLhiU0gI0xDX6DwZ-Qk");
        parameters.put("country", "0");
        parameters.put("haveie6", "0");
        parameters.put("havefirefox", "1");
        parameters.put("cookieprefix", "");
        parameters.put("cookiehost", "127.0.0.1");
        parameters.put("cachesubdirid", "0");
        parameters.put("crashurl", "");
        parameters.put("unsignedurl", "");
        parameters.put("sitesettings_member", "1");
        parameters.put("frombilling", "false");
        parameters.put("sskey", "");
        parameters.put("force64mb", "false");
        parameters.put("worldflags", "8");
    }

    void openFrame() {
        frame = new JFrame("Client");
        frame.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        panel.add(this);
        panel.setPreferredSize(new Dimension(765, 503));
        frame.getContentPane().add(panel, "Center");
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void startClient() {
        try {
            BaseApplet.provideLoaderApplet(this);
            client gameClient = new client();
            gameClient.init();
            gameClient.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getParameter(String arg0) {
        return (String) parameters.get(arg0);
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
            else url = new URL("http://127.0.0.1");
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