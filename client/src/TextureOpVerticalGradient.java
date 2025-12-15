/* Class348_Sub40_Sub4 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class TextureOpVerticalGradient extends TextureOp {
    static Deque aDeque_9111 = new Deque();
    static int anInt9112;
    static TextureSource js5TextureSource; // aD9113
    static Matrix aMatrix_9114;
    static int anInt9115;

    final int[] monochromeOutput(int i, int i_0_) {
        anInt9115++;
        if (i_0_ != 255) aDeque_9111 = null;
        int[] is = this.monochromeCache.get(0, i);
        if (this.monochromeCache.dirty) Class214.method1579(is, 0, TextureOpPolarDistortion.anInt9139, Option_Sub18.anIntArray6035[i]);
        return is;
    }

    public static void method3057(byte i) {
        if (i > -32) method3058(-76, 25, -12);
        aMatrix_9114 = null;
        aDeque_9111 = null;
        js5TextureSource = null;
    }

    public TextureOpVerticalGradient() {
        super(0, true);
    }

    static final void method3058(int i, int i_1_, int i_2_) {
        Class357 class357 = Class147.aClass357ArrayArrayArray2029[i][i_1_][i_2_];
        if (class357 != null) {
            FloorUnderlayTypeList.method1376(class357.aClass318_Sub1_Sub4_4406);
            FloorUnderlayTypeList.method1376(class357.aClass318_Sub1_Sub4_4403);
            if (class357.aClass318_Sub1_Sub4_4406 != null) class357.aClass318_Sub1_Sub4_4406 = null;
            if (class357.aClass318_Sub1_Sub4_4403 != null) class357.aClass318_Sub1_Sub4_4403 = null;
        }
    }
}
