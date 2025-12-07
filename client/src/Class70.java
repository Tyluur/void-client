/* Class70 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class70 {
    static int anInt1203;
    static int[] COS; // anIntArray1204
    static int anInt1205;
    static int anInt1206;
    static int[] SIN = new int[16384]; // anIntArray1207

    public static void method725(int i) {
        SIN = null;
        COS = null;
        if (i != 16384) SIN = null;
    }

    // method726
    static final void startRenderer(int i) {
        if (i <= 88) COS = null;
        anInt1206++;
        if (Class348_Sub42_Sub15.state != null) {
            Class51.renderer = new LoadingScreenRenderer();
            Class51.renderer.updateState(Class348_Sub42_Sub15.state, Class348_Sub42_Sub15.state.aClass274_1012.method2063(AnimBase.language, 544), Class348_Sub42_Sub15.state.anInt1025, Class283.lastRendererUpdate, false);
            Class348_Sub32.rendererThread = new Thread(Class51.renderer, "");
            Class348_Sub32.rendererThread.start();
        }
    }

    static final void method727(byte i, int i_0_, int i_1_, int i_2_) {
        anInt1205++;
        Class348_Sub42_Sub15 class348_sub42_sub15 = Class318_Sub9_Sub1.method2516(i_2_, (byte) 105, 9);
        class348_sub42_sub15.method3246(i + -25427);
        class348_sub42_sub15.anInt9652 = i_1_;
        class348_sub42_sub15.anInt9651 = i_0_;
        if (i != -63) SIN = null;
    }

    public final String toString() {
        anInt1203++;
        throw new IllegalStateException();
    }

    public Class70() {
        /* empty */
    }

    static {
        COS = new int[16384];
        double d = 3.834951969714103E-4;
        for (int i = 0; i < 16384; i++) {
            SIN[i] = (int) (16384.0 * Math.sin(d * (double) i));
            COS[i] = (int) (Math.cos(d * (double) i) * 16384.0);
        }
    }
}
