/* Class348_Sub40_Sub31 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class TextureOpTile extends TextureOp {
    static int anInt9404;
    private int anInt9405 = 4;
    static int anInt9406;
    static int anInt9407;
    static int anInt9408 = 0;
    static int anInt9409;
    private int anInt9410 = 4;
    static int anInt9411;
    static int anInt9412 = 0;
    static int anInt9413;

    public TextureOpTile() {
        super(1, false);
    }

    final int[][] colourOutput(int i, int i_0_) {
        anInt9407++;
        if (i_0_ != -1564599039) return null;
        int[][] is = this.colourCache.get(-111, i);
        if (this.colourCache.dirty) {
            int i_1_ = TextureOpPolarDistortion.width / anInt9405;
            int i_2_ = Class286_Sub2.height / anInt9410;
            int[][] is_3_;
            if (i_2_ > 0) {
                int i_4_ = i % i_2_;
                is_3_ = this.outputColour((byte) -86, Class286_Sub2.height * i_4_ / i_2_, 0);
            } else is_3_ = this.outputColour((byte) 105, 0, 0);
            int[] is_5_ = is_3_[0];
            int[] is_6_ = is_3_[1];
            int[] is_7_ = is_3_[2];
            int[] is_8_ = is[0];
            int[] is_9_ = is[1];
            int[] is_10_ = is[2];
            for (int i_11_ = 0; (i_11_ < TextureOpPolarDistortion.width); i_11_++) {
                int i_12_;
                if (i_1_ <= 0) i_12_ = 0;
                else {
                    int i_13_ = i_11_ % i_1_;
                    i_12_ = TextureOpPolarDistortion.width * i_13_ / i_1_;
                }
                is_8_[i_11_] = is_5_[i_12_];
                is_9_[i_11_] = is_6_[i_12_];
                is_10_[i_11_] = is_7_[i_12_];
            }
        }
        return is;
    }

    final void decode(Packet packet, int i, int i_14_) {
        if (i_14_ == 31015) {
            int i_15_ = i;
            do {
                if (i_15_ == 0) {
                    anInt9405 = packet.readUnsignedByte(255);
                    break;
                } else if (i_15_ != 1) break;
                anInt9410 = packet.readUnsignedByte(255);
            } while (false);
            anInt9413++;
        }
    }

    static final boolean method3131(byte i, String string) {
        if (i != 50) method3131((byte) -33, null);
        anInt9404++;
        return Player.aHashtable10565.containsKey(string);
    }

    final int[] monochromeOutput(int i, int i_16_) {
        if (i_16_ != 255) return null;
        anInt9409++;
        int[] is = this.monochromeCache.get(0, i);
        if (this.monochromeCache.dirty) {
            int i_17_ = TextureOpPolarDistortion.width / anInt9405;
            int i_18_ = Class286_Sub2.height / anInt9410;
            int[] is_19_;
            if (i_18_ > 0) {
                int i_20_ = i % i_18_;
                is_19_ = this.monochromeOutput(i_20_ * Class286_Sub2.height / i_18_, 633706337, 0);
            } else is_19_ = this.monochromeOutput(0, 633706337, 0);
            for (int i_21_ = 0; TextureOpPolarDistortion.width > i_21_; i_21_++) {
                if (i_17_ <= 0) is[i_21_] = is_19_[0];
                else {
                    int i_22_ = i_21_ % i_17_;
                    is[i_21_] = is_19_[(TextureOpPolarDistortion.width * i_22_ / i_17_)];
                }
            }
        }
        return is;
    }

    static {
        anInt9411 = 0;
    }
}
