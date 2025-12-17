/* Class348_Sub40_Sub13 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class TextureOpMonochrome extends TextureOp {
    static Deque aDeque_9201;
    static int anInt9202;
    static int anInt9203 = -1;
    static float aFloat9204;

    public static void method3080(byte i) {
        aDeque_9201 = null;
        if (i < 39) method3080((byte) 100);
    }

    public TextureOpMonochrome() {
        super(1, true);
    }

    final int[] monochromeOutput(int i, int i_0_) {
        anInt9202++;
        int[] is = this.monochromeCache.get(i_0_ + -255, i);
        if (i_0_ != 255) monochromeOutput(19, -84);
        if (this.monochromeCache.dirty) {
            int[][] is_1_ = this.outputColour((byte) -119, i, 0);
            int[] is_2_ = is_1_[0];
            int[] is_3_ = is_1_[1];
            int[] is_4_ = is_1_[2];
            for (int i_5_ = 0; TextureOpPolarDistortion.textureWidth > i_5_; i_5_++)
                is[i_5_] = (is_2_[i_5_] - (-is_3_[i_5_] - is_4_[i_5_])) / 3;
        }
        return is;
    }

    static {
        aDeque_9201 = new Deque();
        aFloat9204 = 0.25F;
    }
}
