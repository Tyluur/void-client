/* Class12 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Class12
final class TextureMetrics {
    byte speedU;
    boolean aBoolean199;
    int alphaBlendMode;
    byte aByte201;
    byte effectParam1;
    int anInt203;
    boolean aBoolean204;
    byte aByte205;
    int anInt206;
    boolean aBoolean207;
    short aShort208;
    boolean disableable;
    static int anInt210;
    byte speedV;
    boolean aBoolean212;
    byte effectType;
    static int anInt214;
    boolean aBoolean215;
    byte aByte216;
    boolean aBoolean217;
    boolean aBoolean218;

    static final void method223(int i, int i_0_, int i_1_, int i_2_, byte i_3_) {
        if (i_2_ > i) Class135_Sub2.method1156(-27, i_2_, AnimationType.anIntArrayArray255[i_1_], i, i_0_);
        else Class135_Sub2.method1156(-27, i, AnimationType.anIntArrayArray255[i_1_], i_2_, i_0_);
        anInt214++;
        if (i_3_ >= 20) {
            /* empty */
        }
    }

    static final void method224(byte i, int[][] is) {
        AnimationType.anIntArrayArray255 = is;
        anInt210++;
        if (i != -40) method224((byte) 100, null);
    }

    public TextureMetrics() {
        /* empty */
    }
}
