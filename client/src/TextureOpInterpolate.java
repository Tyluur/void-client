/* Class348_Sub40_Sub27 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.datatransfer.Clipboard;

final class TextureOpInterpolate extends TextureOp {
    static int anInt9356;
    static Clipboard aClipboard9357;
    static int anInt9358;
    static int anInt9359;
    static int anInt9360;

    final int[][] colourOutput(int i, int i_0_) {
        if (i_0_ != -1564599039) return null;
        anInt9356++;
        int[][] is = this.colourCache.get(-90, i);
        if (this.colourCache.dirty) {
            int[] is_1_ = this.monochromeOutput(i, i_0_ + -2096661920, 2);
            int[][] is_2_ = this.outputColour((byte) -74, i, 0);
            int[][] is_3_ = this.outputColour((byte) -58, i, 1);
            int[] is_4_ = is[0];
            int[] is_5_ = is[1];
            int[] is_6_ = is[2];
            int[] is_7_ = is_2_[0];
            int[] is_8_ = is_2_[1];
            int[] is_9_ = is_2_[2];
            int[] is_10_ = is_3_[0];
            int[] is_11_ = is_3_[1];
            int[] is_12_ = is_3_[2];
            for (int i_13_ = 0; (i_13_ < TextureOpPolarDistortion.textureWidth); i_13_++) {
                int i_14_ = is_1_[i_13_];
                if (i_14_ == 4096) {
                    is_4_[i_13_] = is_7_[i_13_];
                    is_5_[i_13_] = is_8_[i_13_];
                    is_6_[i_13_] = is_9_[i_13_];
                } else if (i_14_ == 0) {
                    is_4_[i_13_] = is_10_[i_13_];
                    is_5_[i_13_] = is_11_[i_13_];
                    is_6_[i_13_] = is_12_[i_13_];
                } else {
                    int i_15_ = 4096 + -i_14_;
                    is_4_[i_13_] = (is_10_[i_13_] * i_15_ + is_7_[i_13_] * i_14_ >> 12);
                    is_5_[i_13_] = (is_11_[i_13_] * i_15_ + is_8_[i_13_] * i_14_ >> 12);
                    is_6_[i_13_] = (is_9_[i_13_] * i_14_ - -(is_12_[i_13_] * i_15_) >> 12);
                }
            }
        }
        return is;
    }

    final int[] monochromeOutput(int i, int i_16_) {
        if (i_16_ != 255) return null;
        anInt9359++;
        int[] is = this.monochromeCache.get(0, i);
        if (this.monochromeCache.dirty) {
            int[] is_17_ = this.monochromeOutput(i, i_16_ ^ 0x25c5979e, 0);
            int[] is_18_ = this.monochromeOutput(i, 633706337, 1);
            int[] is_19_ = this.monochromeOutput(i, i_16_ + 633706082, 2);
            for (int i_20_ = 0; TextureOpPolarDistortion.textureWidth > i_20_; i_20_++) {
                int i_21_ = is_19_[i_20_];
                if (i_21_ != 4096) {
                    if (i_21_ == 0) is[i_20_] = is_18_[i_20_];
                    else is[i_20_] = (i_21_ * is_17_[i_20_] - -(is_18_[i_20_] * (-i_21_ + 4096)) >> 12);
                } else is[i_20_] = is_17_[i_20_];
            }
        }
        return is;
    }

    public static void method3121(byte i) {
        aClipboard9357 = null;
        if (i <= 21) aClipboard9357 = null;
    }

    public TextureOpInterpolate() {
        super(3, false);
    }

    final void decode(Packet packet, int i, int i_22_) {
        anInt9358++;
        if (i_22_ != 31015) anInt9360 = -16;
        if (i == 0) this.monochrome = packet.readUnsignedByte(255) == 1;
    }
}
