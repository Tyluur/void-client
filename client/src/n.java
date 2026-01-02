/* n - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class n extends FontRenderer implements Interface19 {
    long nativeid;

    private final native void S(SafeModeToolkit var_safeModeToolkit, ya var_ya, byte[][] is, int[] is_0_, int[] is_1_, int[] is_2_, int[] is_3_, int[] is_4_);

    n(SafeModeToolkit var_safeModeToolkit, ya var_ya, FontMetrics fontMetrics, IndexedImage[] indexedImages, Sprite[] sprites) {
        super(var_safeModeToolkit, fontMetrics);
        byte[][] is = new byte[indexedImages.length][];
        int[] is_5_ = new int[indexedImages.length];
        int[] is_6_ = new int[indexedImages.length];
        int[] is_7_ = new int[indexedImages.length];
        int[] is_8_ = new int[indexedImages.length];
        for (int i = 0; i < indexedImages.length; i++) {
            is[i] = indexedImages[i].raster;
            is_5_[i] = indexedImages[i].width;
            is_6_[i] = indexedImages[i].height;
            is_7_[i] = indexedImages[i].offsetX;
            is_8_[i] = indexedImages[i].offsetY;
        }
        S(var_safeModeToolkit, var_ya, is, indexedImages[0].palette, is_5_, is_6_, is_7_, is_8_);
    }

    public final native void w(boolean bool);

    protected final void finalize() {
        if (this.nativeid != 0L) Class257.method1947(0, this);
    }

    final native void fa(char c, int i, int i_9_, int i_10_, boolean bool);

    private final native void PA(char c, int i, int i_11_, int i_12_, boolean bool, aa var_aa, int i_13_, int i_14_);

    final void method2578(char c, int i, int i_15_, int i_16_, boolean bool, aa var_aa, int i_17_, int i_18_) {
        PA(c, i, i_15_, i_16_, bool, var_aa, i_17_, i_18_);
    }
}
