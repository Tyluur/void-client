/* Class365 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Class365
final class Renderer {
    String name;
    long driverVersion;
    String device;
    static Deque aDeque_4473;
    static int anInt4474 = 0;
    int version;
    int vendor;
    static Class114 aClass114_4477;

    public static void method3518(int i) {
        aDeque_4473 = null;
        if (i != 88) method3518(-49);
        aClass114_4477 = null;
    }

    Renderer(int vendor, String name, int version, String device, long driver) {
        try {
            this.driverVersion = driver;
            this.version = version;
            this.vendor = vendor;
            this.device = device;
            this.name = name;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("fia.<init>(" + vendor + ',' + (name != null ? "{...}" : "null") + ',' + version + ',' + (device != null ? "{...}" : "null") + ',' + driver + ')'));
        }
    }

    static {
        aDeque_4473 = new Deque();
        aClass114_4477 = new Class114(88, 10);
    }
}
