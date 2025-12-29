/* Class348_Sub40_Sub16 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class TextureOpCombine extends TextureOp {
    static int anInt9222;
    static int anInt9223;
    static int anInt9224;
    static Class114 aClass114_9225;
    private int anInt9226 = 6;
    static int anInt9227;
    static int anInt9228;
    static volatile boolean aBoolean9229 = true;
    static int[] anIntArray9230 = {0, -1, 0, 1};
    static int anInt9231;

    final void decode(Packet packet, int i, int i_0_) {
        if (i_0_ != 31015) anInt9226 = -83;
        int i_1_ = i;
        if (i_1_ == 0) {
            anInt9226 = packet.readUnsignedByte(255);
        } else if (i_1_ == 1) {
            this.monochrome = packet.readUnsignedByte(255) == 1;
        }
        anInt9227++;
    }

    final int[][] colourOutput(int i, int i_2_) {
        if (i_2_ != -1564599039) method3089(-88);
        anInt9223++;
        int[][] is = this.colourCache.get(i_2_ ^ 0x5d41e2a7, i);
        if (this.colourCache.dirty) {
            int[][] is_3_ = this.outputColour((byte) -51, i, 0);
            int[][] is_4_ = this.outputColour((byte) -66, i, 1);
            int[] is_5_ = is[0];
            int[] is_6_ = is[1];
            int[] is_7_ = is[2];
            int[] is_8_ = is_3_[0];
            int[] is_9_ = is_3_[1];
            int[] is_10_ = is_3_[2];
            int[] is_11_ = is_4_[0];
            int[] is_12_ = is_4_[1];
            int[] is_13_ = is_4_[2];
            int i_14_ = anInt9226;
            if (i_14_ == 1) {
                for (i_14_ = 0; ((TextureOpPolarDistortion.width) > i_14_); i_14_++) {
                    is_5_[i_14_] = ((is_11_[i_14_]) + (is_8_[i_14_]));
                    is_6_[i_14_] = ((is_9_[i_14_]) + (is_12_[i_14_]));
                    is_7_[i_14_] = ((is_10_[i_14_]) + (is_13_[i_14_]));
                }
            } else if (i_14_ == 2) {
                for (i_14_ = 0; ((TextureOpPolarDistortion.width) > i_14_); i_14_++) {
                    is_5_[i_14_] = (is_8_[i_14_] - (is_11_[i_14_]));
                    is_6_[i_14_] = (is_9_[i_14_] + -(is_12_[i_14_]));
                    is_7_[i_14_] = (-(is_13_[i_14_]) + (is_10_[i_14_]));
                }
            } else if (i_14_ == 3) {
                for (i_14_ = 0; (i_14_ < (TextureOpPolarDistortion.width)); i_14_++) {
                    is_5_[i_14_] = ((is_11_[i_14_] * is_8_[i_14_]) >> 12);
                    is_6_[i_14_] = ((is_12_[i_14_] * is_9_[i_14_]) >> 12);
                    is_7_[i_14_] = ((is_10_[i_14_] * (is_13_[i_14_])) >> 12);
                }
            } else if (i_14_ == 4) {
                for (i_14_ = 0; (i_14_ < (TextureOpPolarDistortion.width)); i_14_++) {
                    int i_15_ = is_11_[i_14_];
                    int i_16_ = is_13_[i_14_];
                    int i_17_ = is_12_[i_14_];
                    is_5_[i_14_] = (i_15_ != 0 ? ((is_8_[i_14_] << 12) / i_15_) : 4096);
                    is_6_[i_14_] = (i_17_ == 0 ? 4096 : ((is_9_[i_14_] << 12) / i_17_));
                    is_7_[i_14_] = (i_16_ == 0 ? 4096 : ((is_10_[i_14_] << 12) / i_16_));
                }
            } else if (i_14_ == 5) {
                for (i_14_ = 0; (i_14_ < (TextureOpPolarDistortion.width)); i_14_++) {
                    is_5_[i_14_] = (4096 + -(((-is_11_[i_14_] + 4096) * (4096 - is_8_[i_14_])) >> 12));
                    is_6_[i_14_] = (4096 + -(((4096 + -is_12_[i_14_]) * (4096 - is_9_[i_14_])) >> 12));
                    is_7_[i_14_] = (4096 - (((-is_13_[i_14_] + 4096) * (4096 - is_10_[i_14_])) >> 12));
                }
            } else if (i_14_ == 6) {
                for (i_14_ = 0; (TextureOpPolarDistortion.width > i_14_); i_14_++) {
                    int i_18_ = is_11_[i_14_];
                    int i_19_ = is_13_[i_14_];
                    int i_20_ = is_12_[i_14_];
                    is_5_[i_14_] = ((i_18_ >= 2048) ? -(((4096 - is_8_[i_14_]) * (-i_18_ + 4096)) >> 11) + 4096 : (is_8_[i_14_] * i_18_ >> 11));
                    is_6_[i_14_] = (i_20_ >= 2048 ? -(((-i_20_ + 4096) * (4096 - is_9_[i_14_])) >> 11) + 4096 : (i_20_ * is_9_[i_14_] >> 11));
                    is_7_[i_14_] = (i_19_ < 2048 ? (i_19_ * is_10_[i_14_] >> 11) : -(((-is_10_[i_14_] + 4096) * (-i_19_ + 4096)) >> 11) + 4096);
                }
            } else if (i_14_ == 7) {
                for (i_14_ = 0; TextureOpPolarDistortion.width > i_14_; i_14_++) {
                    int i_21_ = is_10_[i_14_];
                    int i_22_ = is_9_[i_14_];
                    int i_23_ = is_8_[i_14_];
                    is_5_[i_14_] = (i_23_ == 4096 ? 4096 : ((is_11_[i_14_] << 12) / (-i_23_ + 4096)));
                    is_6_[i_14_] = (i_22_ != 4096 ? ((is_12_[i_14_] << 12) / (-i_22_ + 4096)) : 4096);
                    is_7_[i_14_] = (i_21_ == 4096 ? 4096 : ((is_13_[i_14_] << 12) / (4096 - i_21_)));
                }
            } else if (i_14_ == 8) {
                for (i_14_ = 0; (TextureOpPolarDistortion.width > i_14_); i_14_++) {
                    int i_24_ = is_9_[i_14_];
                    int i_25_ = is_8_[i_14_];
                    int i_26_ = is_10_[i_14_];
                    is_5_[i_14_] = (i_25_ == 0 ? 0 : -((-is_11_[i_14_] + 4096 << 12) / i_25_) + 4096);
                    is_6_[i_14_] = i_24_ != 0 ? -((4096 + -is_12_[i_14_] << 12) / i_24_) + 4096 : 0;
                    is_7_[i_14_] = (i_26_ == 0 ? 0 : -((-is_13_[i_14_] + 4096 << 12) / i_26_) + 4096);
                }
            } else if (i_14_ == 9) {
                for (i_14_ = 0; i_14_ < TextureOpPolarDistortion.width; i_14_++) {
                    int i_27_ = is_9_[i_14_];
                    int i_28_ = is_12_[i_14_];
                    int i_29_ = is_13_[i_14_];
                    int i_30_ = is_11_[i_14_];
                    int i_31_ = is_10_[i_14_];
                    int i_32_ = is_8_[i_14_];
                    is_5_[i_14_] = (Math.min(i_30_, i_32_));
                    is_6_[i_14_] = (Math.min(i_28_, i_27_));
                    is_7_[i_14_] = Math.min(i_29_, i_31_);
                }
            } else if (i_14_ == 10) {
                for (i_14_ = 0; (TextureOpPolarDistortion.width > i_14_); i_14_++) {
                    int i_33_ = is_9_[i_14_];
                    int i_34_ = is_10_[i_14_];
                    int i_35_ = is_12_[i_14_];
                    int i_36_ = is_11_[i_14_];
                    int i_37_ = is_13_[i_14_];
                    int i_38_ = is_8_[i_14_];
                    is_5_[i_14_] = Math.max(i_36_, i_38_);
                    is_6_[i_14_] = (Math.max(i_33_, i_35_));
                    is_7_[i_14_] = (Math.max(i_37_, i_34_));
                }
            } else if (i_14_ == 11) {
                for (i_14_ = 0; TextureOpPolarDistortion.width > i_14_; i_14_++) {
                    int i_39_ = is_13_[i_14_];
                    int i_40_ = is_9_[i_14_];
                    int i_41_ = is_10_[i_14_];
                    int i_42_ = is_11_[i_14_];
                    int i_43_ = is_8_[i_14_];
                    int i_44_ = is_12_[i_14_];
                    is_5_[i_14_] = (i_43_ > i_42_ ? -i_42_ + i_43_ : i_42_ - i_43_);
                    is_6_[i_14_] = (i_44_ >= i_40_ ? i_44_ + -i_40_ : -i_44_ + i_40_);
                    is_7_[i_14_] = i_41_ <= i_39_ ? i_39_ - i_41_ : -i_39_ + i_41_;
                }
            } else if (i_14_ == 12) {
                for (i_14_ = 0; (TextureOpPolarDistortion.width > i_14_); i_14_++) {
                    int i_45_ = is_8_[i_14_];
                    int i_46_ = is_10_[i_14_];
                    int i_47_ = is_13_[i_14_];
                    int i_48_ = is_11_[i_14_];
                    int i_49_ = is_9_[i_14_];
                    int i_50_ = is_12_[i_14_];
                    is_5_[i_14_] = -(i_45_ * i_48_ >> 11) + (i_48_ + i_45_);
                    is_6_[i_14_] = -(i_49_ * i_50_ >> 11) + (i_49_ + i_50_);
                    is_7_[i_14_] = i_47_ + i_46_ - (i_46_ * i_47_ >> 11);
                }
            }
        }
        return is;
    }

    public static void method3087(boolean bool) {
        anIntArray9230 = null;
        aClass114_9225 = null;
        if (bool != false) method3089(-42);
    }

    public TextureOpCombine() {
        super(2, false);
    }

    final int[] monochromeOutput(int i, int i_51_) {
        if (i_51_ != 255) colourOutput(50, -18);
        anInt9224++;
        int[] is = this.monochromeCache.get(0, i);
        if (this.monochromeCache.dirty) {
            int[] is_52_ = this.monochromeOutput(i, 633706337, 0);
            int[] is_53_ = this.monochromeOutput(i, 633706337, 1);
            int i_54_ = anInt9226;
            if (i_54_ == 1) {
                for (i_54_ = 0; ((TextureOpPolarDistortion.width) > i_54_); i_54_++)
                    is[i_54_] = ((is_52_[i_54_]) + (is_53_[i_54_]));
            } else if (i_54_ == 2) {
                for (i_54_ = 0; ((TextureOpPolarDistortion.width) > i_54_); i_54_++)
                    is[i_54_] = ((is_52_[i_54_]) + -(is_53_[i_54_]));
            } else if (i_54_ == 3) {
                for (i_54_ = 0; ((TextureOpPolarDistortion.width) > i_54_); i_54_++)
                    is[i_54_] = ((is_53_[i_54_] * (is_52_[i_54_])) >> 12);
            } else if (i_54_ == 4) {
                for (i_54_ = 0; ((TextureOpPolarDistortion.width) > i_54_); i_54_++) {
                    int i_55_ = is_53_[i_54_];
                    is[i_54_] = (i_55_ != 0 ? ((is_52_[i_54_] << 12) / i_55_) : 4096);
                }
            } else if (i_54_ == 5) {
                for (i_54_ = 0; (TextureOpPolarDistortion.width > i_54_); i_54_++)
                    is[i_54_] = -(((4096 - is_52_[i_54_]) * (4096 - is_53_[i_54_])) >> 12) + 4096;
            } else if (i_54_ == 6) {
                for (i_54_ = 0; (i_54_ < TextureOpPolarDistortion.width); i_54_++) {
                    int i_56_ = is_53_[i_54_];
                    is[i_54_] = (i_56_ >= 2048 ? (4096 + -(((-i_56_ + 4096) * (4096 - is_52_[i_54_])) >> 11)) : (i_56_ * is_52_[i_54_] >> 11));
                }
            } else if (i_54_ == 7) {
                for (i_54_ = 0; i_54_ < TextureOpPolarDistortion.width; i_54_++) {
                    int i_57_ = is_52_[i_54_];
                    is[i_54_] = (i_57_ != 4096 ? ((is_53_[i_54_] << 12) / (-i_57_ + 4096)) : 4096);
                }
            } else if (i_54_ == 8) {
                for (i_54_ = 0; i_54_ < TextureOpPolarDistortion.width; i_54_++) {
                    int i_58_ = is_52_[i_54_];
                    is[i_54_] = (i_58_ == 0 ? 0 : -((4096 - is_53_[i_54_] << 12) / i_58_) + 4096);
                }
            } else if (i_54_ == 9) {
                for (i_54_ = 0; i_54_ < TextureOpPolarDistortion.width; i_54_++) {
                    int i_59_ = is_53_[i_54_];
                    int i_60_ = is_52_[i_54_];
                    is[i_54_] = (Math.min(i_59_, i_60_));
                }
            } else if (i_54_ == 10) {
                for (i_54_ = 0; TextureOpPolarDistortion.width > i_54_; i_54_++) {
                    int i_61_ = is_53_[i_54_];
                    int i_62_ = is_52_[i_54_];
                    is[i_54_] = Math.max(i_62_, i_61_);
                }
            } else if (i_54_ == 11) {
                for (i_54_ = 0; i_54_ < TextureOpPolarDistortion.width; i_54_++) {
                    int i_63_ = is_53_[i_54_];
                    int i_64_ = is_52_[i_54_];
                    is[i_54_] = (i_63_ >= i_64_ ? i_63_ + -i_64_ : i_64_ - i_63_);
                }
            } else if (i_54_ == 12) {
                for (i_54_ = 0; TextureOpPolarDistortion.width > i_54_; i_54_++) {
                    int i_65_ = is_53_[i_54_];
                    int i_66_ = is_52_[i_54_];
                    is[i_54_] = i_66_ - -i_65_ - (i_66_ * i_65_ >> 11);
                }
            }
        }
        return is;
    }

    static final void method3088(int i) {
        anInt9228++;
        if (Class76.aClass364_1279 != Class8.aClass364_165 && i == 9) {
            try {
                Class224.method1617((byte) 125, NPCDefinition.aClient1367, "tbrefresh");
            } catch (Throwable throwable) {
                /* empty */
            }
        }
    }

    static final void method3089(int i) {
        Class248.anInt3203 = -1;
        Class97.anInt1548 = -1;
        Class334.anInt4155 = -1;
        anInt9222++;
        VarcTypeList.anInt3306 = 0;
        int i_67_ = -95 % ((i - -46) / 52);
    }

    static {
        aClass114_9225 = new Class114(28, -2);
    }
}
