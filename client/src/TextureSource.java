/* d - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// d
interface TextureSource {
    float[] method1(int i, float f, boolean bool, int i_0_, int i_1_, int i_2_);

    int method2(boolean bool);

    // method3
    TextureMetrics getMetrics(int i, int i_3_);

    // method4
    boolean textureReady(int i, int i_4_);

    // method5
    int[] rgbPixels(boolean bool, int i, float f, int i_5_, int i_6_, int i_7_);

    int[] pixels(int i, int i_8_, float f, int i_9_, boolean bool, int i_10_);
}
