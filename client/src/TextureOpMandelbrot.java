/* Class348_Sub40_Sub25 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class TextureOpMandelbrot extends TextureOp {
    static int anInt9335 = -1;
    static int anInt9336;
    static int anInt9337;
    private int anInt9338 = 0;
    private int anInt9339 = 0;
    private int anInt9340 = 1365;
    static int anInt9341 = 0;
    static IDKTypeList idkTypeList; // aClass150_9342
    private int anInt9343 = 20;

    final void decode(Packet packet, int i, int i_0_) {
        if (i_0_ != 31015) decode(null, 44, 80);
        int i_1_ = i;
        while_200_:
        do {
            while_199_:
            do {
                do {
                    if (i_1_ == 0) {
                        anInt9340 = packet.readUnsignedShort(842397944);
                        break while_200_;
                    } else if (i_1_ != 1) {
                        if (i_1_ != 2) {
                            if (i_1_ != 3) break while_200_;
                        } else break;
                        break while_199_;
                    }
                    anInt9343 = packet.readUnsignedShort(i_0_ + 842366929);
                    break while_200_;
                } while (false);
                anInt9339 = packet.readUnsignedShort(i_0_ + 842366929);
                break while_200_;
            } while (false);
            anInt9338 = packet.readUnsignedShort(842397944);
        } while (false);
        anInt9337++;
    }

    final int[] monochromeOutput(int i, int i_2_) {
        anInt9336++;
        int[] is = this.monochromeCache.get(0, i);
        if (i_2_ != 255) return null;
        if (this.monochromeCache.dirty) {
            for (int i_3_ = 0; i_3_ < TextureOpPolarDistortion.width; i_3_++) {
                int i_4_ = anInt9339 + (Class318_Sub6.normalisedX[i_3_] << 12) / anInt9340;
                int i_5_ = anInt9338 + (Option_Sub18.normalisedY[i] << 12) / anInt9340;
                int i_6_ = i_4_;
                int i_7_ = i_5_;
                int i_8_ = i_4_;
                int i_9_ = i_5_;
                int i_10_ = i_4_ * i_4_ >> 12;
                int i_11_ = i_5_ * i_5_ >> 12;
                int i_12_;
                for (i_12_ = 0; (i_11_ + i_10_ < 16384 && anInt9343 > i_12_); i_10_ = i_8_ * i_8_ >> 12) {
                    i_9_ = i_7_ + 2 * (i_9_ * i_8_ >> 12);
                    i_8_ = i_6_ + i_10_ - i_11_;
                    i_12_++;
                    i_11_ = i_9_ * i_9_ >> 12;
                }
                is[i_3_] = (i_12_ >= anInt9343 - 1 ? 0 : (i_12_ << 12) / anInt9343);
            }
        }
        return is;
    }

    public static void method3117(int i) {
        idkTypeList = null;
        if (i < 10) anInt9335 = 113;
    }

    public TextureOpMandelbrot() {
        super(0, true);
    }
}
