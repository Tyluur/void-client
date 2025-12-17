/* Class348_Sub40_Sub10 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class TextureOpRange extends TextureOp {
    static int anInt9174;
    private int anInt9175;
    private int anInt9176 = 1024;
    static int anInt9177;
    static int anInt9178;
    static int anInt9179;
    static Class308 aClass308_9180;
    static boolean aBoolean9181 = false;
    private int anInt9182;
    static int[] anIntArray9183;
    static boolean aBoolean9184;

    final void decode(Packet packet, int i, int i_0_) {
        anInt9179++;
        int i_1_ = i;
        while_152_:
        do {
            do {
                if (i_1_ == 0) {
                    anInt9176 = packet.readUnsignedShort(i_0_ ^ 0x323581df);
                    break while_152_;
                } else if (i_1_ != 1) {
                    if (i_1_ == 2) break;
                    break while_152_;
                }
                anInt9175 = packet.readUnsignedShort(842397944);
                break while_152_;
            } while (false);
            this.monochrome = packet.readUnsignedByte(255) == 1;
        } while (false);
        if (i_0_ != 31015) decode(null, -85, -85);
    }

    final void finish(int i) {
        anInt9174++;
        anInt9182 = anInt9175 - anInt9176;
        if (i < 108) monochromeOutput(-31, 9);
    }

    final int[] monochromeOutput(int i, int i_2_) {
        anInt9177++;
        int[] is = this.monochromeCache.get(0, i);
        if (this.monochromeCache.dirty) {
            int[] is_3_ = this.monochromeOutput(i, 633706337, 0);
            for (int i_4_ = 0; TextureOpPolarDistortion.textureWidth > i_4_; i_4_++)
                is[i_4_] = anInt9176 - -(anInt9182 * is_3_[i_4_] >> 12);
        }
        if (i_2_ != 255) return null;
        return is;
    }

    final int[][] colourOutput(int i, int i_5_) {
        anInt9178++;
        int[][] is = this.colourCache.get(-113, i);
        if (i_5_ != -1564599039) decode(null, -10, -112);
        if (this.colourCache.dirty) {
            int[][] is_6_ = this.outputColour((byte) -55, i, 0);
            int[] is_7_ = is_6_[0];
            int[] is_8_ = is_6_[1];
            int[] is_9_ = is_6_[2];
            int[] is_10_ = is[0];
            int[] is_11_ = is[1];
            int[] is_12_ = is[2];
            for (int i_13_ = 0; (TextureOpPolarDistortion.textureWidth > i_13_); i_13_++) {
                is_10_[i_13_] = (anInt9182 * is_7_[i_13_] >> 12) + anInt9176;
                is_11_[i_13_] = (anInt9182 * is_8_[i_13_] >> 12) + anInt9176;
                is_12_[i_13_] = (is_9_[i_13_] * anInt9182 >> 12) + anInt9176;
            }
        }
        return is;
    }

    public static void method3074(int i) {
        anIntArray9183 = null;
        aClass308_9180 = null;
        if (i != 0) anIntArray9183 = null;
    }

    public TextureOpRange() {
        super(1, false);
        anInt9175 = 3072;
        anInt9182 = 2048;
    }

    static {
        aClass308_9180 = new Class308(64);
        anIntArray9183 = new int[4];
        aBoolean9184 = false;
    }
}
