/* Class348_Sub40_Sub5 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.util.Random;

final class TextureOpVoronoiNoise extends TextureOp {
    private short[] aShortArray9116 = new short[512];
    private int anInt9117;
    private int anInt9118 = 1;
    private byte[] permutation = new byte[512];
    static int anInt9120;
    static boolean aBoolean9121 = false;
    private int anInt9122;
    static int anInt9123;
    private int anInt9124;
    private int anInt9125 = 2048;
    static int anInt9126;
    static int anInt9127;
    static int anInt9128;
    private int anInt9129;
    static Class351 aClass351_9130 = new Class351(1, -1);

    public static void method3059(int i) {
        aClass351_9130 = null;
        if (i >= -111) method3059(-83);
    }

    static final int method3060(int i, boolean bool) {
        anInt9128++;
        if (bool != true) aClass351_9130 = null;
        return 0x7f & i >> 11;
    }

    private final void method3061(boolean bool) {
        anInt9120++;
        if (bool == true) {
            Random random = new Random(anInt9122);
            aShortArray9116 = new short[512];
            if (anInt9125 > 0) {
                for (int i = 0; i < 512; i++)
                    aShortArray9116[i] = (short) Mesh.method1097((byte) 81, anInt9125, random);
            }
        }
    }

    public TextureOpVoronoiNoise() {
        super(0, true);
        anInt9124 = 2;
        anInt9122 = 0;
        anInt9117 = 5;
        anInt9129 = 5;
    }

    final void finish(int i) {
        if (i > 108) {
            permutation = Toolkit.getPermutation(anInt9122, 124);
            anInt9126++;
            method3061(true);
        }
    }

    final int[] monochromeOutput(int i, int i_0_) {
        anInt9123++;
        int[] is = this.monochromeCache.get(0, i);
        if (i_0_ != 255) finish(-57);
        if (this.monochromeCache.dirty) {
            int i_1_ = anInt9117 * Option_Sub18.normalisedY[i] + 2048;
            int i_2_ = i_1_ >> 12;
            int i_3_ = 1 + i_2_;
            int i_4_ = 0;
            for (/**/; TextureOpPolarDistortion.width > i_4_; i_4_++) {
                Class348_Sub42_Sub20.anInt9715 = Class215.anInt2835 = Class147.anInt2023 = Class135_Sub1.anInt4715 = 2147483647;
                int i_5_ = 2048 - -(Class318_Sub6.normalisedX[i_4_] * anInt9129);
                int i_6_ = i_5_ >> 12;
                int i_7_ = i_6_ + 1;
                for (int i_8_ = i_2_ + -1; i_8_ <= i_3_; i_8_++) {
                    int i_9_ = 0xff & permutation[0xff & (i_8_ >= anInt9117 ? i_8_ + -anInt9117 : i_8_)];
                    for (int i_10_ = -1 + i_6_; i_7_ >= i_10_; i_10_++) {
                        int i_11_ = 2 * (0xff & permutation[((anInt9129 > i_10_ ? i_10_ : -anInt9129 + i_10_) + i_9_) & 0xff]);
                        int i_12_ = (-(i_10_ << 12) - (aShortArray9116[i_11_++] - i_5_));
                        int i_13_ = (-(i_8_ << 12) + (-aShortArray9116[i_11_] + i_1_));
                        int i_14_ = anInt9118;
                        int i_15_;
                        if (i_14_ == 1) {
                            i_15_ = ((i_13_ * i_13_ + i_12_ * i_12_) >> 12);
                        } else if (i_14_ == 3) {
                            i_12_ = i_12_ < 0 ? -i_12_ : i_12_;
                            i_13_ = (i_13_ < 0 ? -i_13_ : i_13_);
                            i_15_ = (Math.max(i_12_, i_13_));
                        } else if (i_14_ == 4) {
                            i_12_ = (int) ((Math.sqrt((float) ((i_12_ < 0) ? -i_12_ : i_12_) / 4096.0F)) * 4096.0);
                            i_13_ = (int) (4096.0 * (Math.sqrt((float) ((i_13_ < 0) ? -i_13_ : i_13_) / 4096.0F)));
                            i_15_ = i_13_ + i_12_;
                            i_15_ = i_15_ * i_15_ >> 12;
                        } else if (i_14_ == 5) {
                            i_13_ *= i_13_;
                            i_12_ *= i_12_;
                            i_15_ = (int) (4096.0 * (Math.sqrt(Math.sqrt((float) (i_12_ + i_13_) / 1.6777216E7F))));
                        } else if (i_14_ == 2) {
                            i_15_ = ((i_12_ < 0 ? -i_12_ : i_12_) - -(i_13_ >= 0 ? i_13_ : -i_13_));
                        } else {
                            i_15_ = (int) (4096.0 * (Math.sqrt((float) (i_12_ * i_12_ - -(i_13_ * i_13_)) / 1.6777216E7F)));
                        }
                        if (Class348_Sub42_Sub20.anInt9715 <= i_15_) {
                            if (i_15_ >= Class215.anInt2835) {
                                if (i_15_ < Class147.anInt2023) {
                                    Class135_Sub1.anInt4715 = Class147.anInt2023;
                                    Class147.anInt2023 = i_15_;
                                } else if (i_15_ < Class135_Sub1.anInt4715) Class135_Sub1.anInt4715 = i_15_;
                            } else {
                                Class135_Sub1.anInt4715 = Class147.anInt2023;
                                Class147.anInt2023 = Class215.anInt2835;
                                Class215.anInt2835 = i_15_;
                            }
                        } else {
                            Class135_Sub1.anInt4715 = Class147.anInt2023;
                            Class147.anInt2023 = Class215.anInt2835;
                            Class215.anInt2835 = Class348_Sub42_Sub20.anInt9715;
                            Class348_Sub42_Sub20.anInt9715 = i_15_;
                        }
                    }
                }
                int i_16_ = anInt9124;
                if (i_16_ == 0) {
                    is[i_4_] = Class348_Sub42_Sub20.anInt9715;
                } else if (i_16_ == 1) {
                    is[i_4_] = Class215.anInt2835;
                } else if (i_16_ == 3) {
                    is[i_4_] = Class147.anInt2023;
                } else if (i_16_ == 4) {
                    is[i_4_] = Class135_Sub1.anInt4715;
                } else if (i_16_ == 2) {
                    is[i_4_] = Class215.anInt2835 + -Class348_Sub42_Sub20.anInt9715;
                }
            }
        }
        return is;
    }

    final void decode(Packet packet, int i, int i_17_) {
        if (i_17_ == 31015) {
            int i_18_ = i;
            if (i_18_ == 0) {
                anInt9129 = anInt9117 = packet.readUnsignedByte(i_17_ ^ 0x79d8);
            } else if (i_18_ == 1) {
                anInt9122 = packet.readUnsignedByte(i_17_ + -30760);
            } else if (i_18_ == 2) {
                anInt9117 = packet.readUnsignedByte(255);
            } else if (i_18_ == 3) {
                anInt9125 = packet.readUnsignedShort(842397944);
            } else if (i_18_ == 4) {
                anInt9124 = packet.readUnsignedByte(i_17_ ^ 0x79d8);
            } else if (i_18_ == 5) {
                anInt9118 = packet.readUnsignedByte(i_17_ ^ 0x79d8);
            } else if (i_18_ == 6) {
                anInt9129 = packet.readUnsignedByte(255);
            }
            anInt9127++;
        }
    }
}
