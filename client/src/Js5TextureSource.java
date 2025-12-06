/* Class244 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Js5TextureSource implements TextureSource {
    static int anInt4609 = -1;
    static int anInt4610;
    private final TextureMetrics[] aTextureMetricsArray4611;
    static int anInt4612;
    static int anInt4613;
    static int anInt4614;
    static long aLong4615;
    static int anInt4616;
    static int anInt4617;
    static int anInt4618;
    private final Index aIndex_4619;
    static int anInt4620;
    static int anInt4621;
    private final Class308 aClass308_4622 = new Class308(256);
    static int[] anIntArray4623 = new int[8];
    private final Index aIndex_4624;
    private final int anInt4625;
    static float aFloat4626;

    public final int[] method6(int i, int i_0_, float f, int i_1_, boolean bool, int i_2_) {
        if (i != -21540) getMetrics(-46, 6);
        anInt4617++;
        return method1881(i_1_, false).method3183(this, i_2_, i_0_, (aTextureMetricsArray4611[i_1_].aBoolean207), f, aIndex_4624, (byte) 11);
    }

    public static void method1880(int i) {
        if (i >= -103) anInt4610 = -87;
        anIntArray4623 = null;
    }

    private final Class348_Sub42_Sub5 method1881(int i, boolean bool) {
        anInt4620++;
        Class348_Sub42 class348_sub42 = aClass308_4622.method2302(i, (byte) -34);
        if (class348_sub42 != null) return (Class348_Sub42_Sub5) class348_sub42;
        byte[] is = aIndex_4619.method415((byte) 73, i);
        if (is == null) return null;
        if (bool != false) method1(-58, 1.9039171F, false, -106, -22, -18);
        Class348_Sub42_Sub5 class348_sub42_sub5 = new Class348_Sub42_Sub5(new Packet(is));
        aClass308_4622.method2305(i, class348_sub42_sub5, -1);
        return class348_sub42_sub5;
    }

    public final TextureMetrics getMetrics(int i, int i_3_) {
        anInt4621++;
        if (i_3_ != -6662) return null;
        return aTextureMetricsArray4611[i];
    }

    public final int[] method5(boolean bool, int i, float f, int i_4_, int i_5_, int i_6_) {
        int i_7_ = 41 / ((i_6_ - -69) / 48);
        anInt4614++;
        return method1881(i, false).method3185(i_4_, this, 0, aTextureMetricsArray4611[i].aBoolean207, f, bool, aIndex_4624, i_5_);
    }

    public final boolean method4(int i, int i_8_) {
        anInt4616++;
        Class348_Sub42_Sub5 class348_sub42_sub5 = method1881(i_8_, false);
        if (i != -7953) method4(56, -109);
        return class348_sub42_sub5 != null && class348_sub42_sub5.method3184(this, aIndex_4624, -85);
    }

    public final float[] method1(int i, float f, boolean bool, int i_9_, int i_10_, int i_11_) {
        if (i_9_ != -30824) return null;
        anInt4612++;
        return method1881(i_11_, false).method3186(i, this, (aTextureMetricsArray4611[i_11_].aBoolean207), i_10_, aIndex_4624, -20);
    }

    public final int method2(boolean bool) {
        anInt4618++;
        if (bool != true) aLong4615 = -52L;
        return anInt4625;
    }

    // Class244
    Js5TextureSource(Index index, Index index_12_, Index index_13_) {
        try {
            aIndex_4619 = index_12_;
            aIndex_4624 = index_13_;
            Packet packet = new Packet(index.method410(-1860, 0, 0));
            anInt4625 = packet.readUnsignedShort(842397944);
            aTextureMetricsArray4611 = new TextureMetrics[anInt4625];
            for (int i = 0; anInt4625 > i; i++) {
                if (packet.readUnsignedByte(255) == 1) aTextureMetricsArray4611[i] = new TextureMetrics();
            }
            for (int i = 0; i < anInt4625; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].disableable = packet.readUnsignedByte(255) == 0;
            }
            for (int i = 0; i < anInt4625; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].aBoolean199 = packet.readUnsignedByte(255) == 1;
            }
            for (int i = 0; anInt4625 > i; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].aBoolean204 = packet.readUnsignedByte(255) == 1;
            }
            for (int i = 0; i < anInt4625; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].aByte216 = packet.readByte(-85);
            }
            for (int i = 0; i < anInt4625; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].aByte201 = packet.readByte(-113);
            }
            for (int i = 0; i < anInt4625; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].effectType = packet.readByte(-97);
            }
            for (int i = 0; i < anInt4625; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].effectParam1 = packet.readByte(-82);
            }
            for (int i = 0; i < anInt4625; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].aShort208 = (short) packet.readUnsignedShort(842397944);
            }
            for (int i = 0; anInt4625 > i; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].speedU = packet.readByte(-86);
            }
            for (int i = 0; anInt4625 > i; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].speedV = packet.readByte(-104);
            }
            for (int i = 0; anInt4625 > i; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].aBoolean212 = packet.readUnsignedByte(255) == 1;
            }
            for (int i = 0; anInt4625 > i; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].aBoolean207 = packet.readUnsignedByte(255) == 1;
            }
            for (int i = 0; i < anInt4625; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].aByte205 = packet.readByte(-77);
            }
            for (int i = 0; i < anInt4625; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].aBoolean217 = packet.readUnsignedByte(255) == 1;
            }
            for (int i = 0; anInt4625 > i; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].aBoolean215 = packet.readUnsignedByte(255) == 1;
            }
            for (int i = 0; anInt4625 > i; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].aBoolean218 = packet.readUnsignedByte(255) == 1;
            }
            for (int i = 0; i < anInt4625; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].anInt203 = packet.readUnsignedByte(255);
            }
            for (int i = 0; anInt4625 > i; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].anInt206 = packet.readInt((byte) -126);
            }
            for (int i = 0; anInt4625 > i; i++) {
                if (aTextureMetricsArray4611[i] != null) aTextureMetricsArray4611[i].alphaBlendMode = packet.readUnsignedByte(255);
            }
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("tda.<init>(" + (index != null ? "{...}" : "null") + ',' + (index_12_ != null ? "{...}" : "null") + ',' + (index_13_ != null ? "{...}" : "null") + ')'));
        }
    }

    static {
        anInt4610 = 328;
        aLong4615 = 0L;
    }
}
