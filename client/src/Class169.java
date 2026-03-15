/* Class169 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import jagex3.jagmisc.jagmisc;

import java.net.InetAddress;

final class Class169 implements Runnable {
    static int anInt2257;
    private Deque aDeque_2258 = new Deque();
    private Thread aThread2259 = new Thread(this);
    static Sprite[] aSpriteArray2260;
    static Class19[] aClass19Array2261;
    static int anInt2262;
    static int anInt2263;
    static int anInt2264 = 0;
    static int anInt2265 = Class299.method2253(1600, 124);
    static int anInt2266;

    public final void run() {
        anInt2263++;
        for (; ; ) {
            Class348_Sub26 class348_sub26;
            synchronized (aDeque_2258) {
                Node node;
                for (node = aDeque_2258.removeFirst(8); node == null; node = aDeque_2258.removeFirst(8)) {
                    try {
                        aDeque_2258.wait();
                    } catch (InterruptedException interruptedexception) {
                        /* empty */
                    }
                }
                if (!(node instanceof Class348_Sub26)) break;
                class348_sub26 = (Class348_Sub26) node;
            }
            int i;
            try {
                byte[] is = InetAddress.getByName(class348_sub26.aString6888).getAddress();
                i = jagmisc.ping(is[0], is[1], is[2], is[3], 1000L);
            } catch (Throwable throwable) {
                i = 1000;
            }
            class348_sub26.anInt6887 = i;
        }
    }

    public static void method1300(byte i) {
        if (i < -127) {
            aSpriteArray2260 = null;
            aClass19Array2261 = null;
        }
    }

    static final void method1301(r var_r, int i, int i_0_, int i_1_, boolean[] bools) {
        if (aa_Sub1.aGroundArray5191 != Class332.aGroundArray4142) {
            int i_2_ = Class348_Sub1_Sub1.aGroundArray8801[i].method3986(i_0_, i_1_, (byte) -93);
            for (int i_3_ = 0; i_3_ <= i; i_3_++) {
                if (bools == null || bools[i_3_]) {
                    Ground var_ground = Class348_Sub1_Sub1.aGroundArray8801[i_3_];
                    if (var_ground != null) var_ground.wa(var_r, i_0_, i_2_ - var_ground.method3986(i_0_, i_1_, (byte) -103), i_1_, 0, false);
                }
            }
        }
    }

    public Class169() {
        aThread2259.setDaemon(true);
        aThread2259.start();
    }

    final Class348_Sub26 method1302(int i, String string) {
        anInt2266++;
        if (aThread2259 == null) throw new IllegalStateException("");
        if (string == null) throw new IllegalArgumentException("");
        if (i != -5255) aDeque_2258 = null;
        Class348_Sub26 class348_sub26 = new Class348_Sub26(string);
        method1304(1000, class348_sub26);
        return class348_sub26;
    }

    final void method1303(byte i) {
        anInt2257++;
        if (aThread2259 != null) {
            method1304(1000, new Node());
            try {
                aThread2259.join();
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
            aThread2259 = null;
            if (i != 16) anInt2264 = 87;
        }
    }

    private final void method1304(int i, Node node) {
        if (i != 1000) method1303((byte) 95);
        synchronized (aDeque_2258) {
            aDeque_2258.addLast(node, -20180);
            aDeque_2258.notify();
        }
        anInt2262++;
    }
}
