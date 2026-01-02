/* h - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class h extends FontRenderer implements Interface19 {
    long nativeid;

    h(SafeModeToolkit var_safeModeToolkit, ya var_ya, FontMetrics fontMetrics, IndexedImage[] indexedImages, Sprite[] sprites) {
        super(var_safeModeToolkit, fontMetrics);
        byte[][] is = new byte[indexedImages.length][];
        int[] is_0_ = new int[indexedImages.length];
        int[] is_1_ = new int[indexedImages.length];
        int[] is_2_ = new int[indexedImages.length];
        int[] is_3_ = new int[indexedImages.length];
        for (int i = 0; i < indexedImages.length; i++) {
            is[i] = indexedImages[i].raster;
            is_0_[i] = indexedImages[i].width;
            is_1_[i] = indexedImages[i].height;
            is_2_[i] = indexedImages[i].offsetX;
            is_3_[i] = indexedImages[i].offsetY;
        }
        JA(var_safeModeToolkit, var_ya, is, is_0_, is_1_, is_2_, is_3_);
    }

    protected final void finalize() {
        if (this.nativeid != 0L) Class257.method1947(0, this);
    }

    public final native void w(boolean bool);

    final native void fa(char c, int i, int i_4_, int i_5_, boolean bool);

    final void method2578(char c, int i, int i_6_, int i_7_, boolean bool, aa var_aa, int i_8_, int i_9_) {
        NA(c, i, i_6_, i_7_, bool, var_aa, i_8_, i_9_);
    }

    private final native void NA(char c, int i, int i_10_, int i_11_, boolean bool, aa var_aa, int i_12_, int i_13_);

    private final native void JA(SafeModeToolkit var_safeModeToolkit, ya var_ya, byte[][] is, int[] is_14_, int[] is_15_, int[] is_16_, int[] is_17_);
}
