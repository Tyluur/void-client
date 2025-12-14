/* Class17 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Class17
final class AnimationType {
    static int anInt235;
    int[] primarySpeeds;
    int[] frames;
    int loopOffset;
    int priority;
    static int anInt240;
    boolean tweened;
    boolean aBoolean242 = false;
    static int anInt243;
    int maxLoops;
    int walkingPrecedence;
    static int anInt246;
    static boolean aBoolean247 = false;
    int replayMode;
    int leftHandItem;
    static Class114 aClass114_250 = new Class114(4, 1);
    AnimTypeList aAnimTypeList_251;
    static OffscreenSurface anOffscreenSurface_252;
    int[] volumes;
    boolean aBoolean254;
    static int[][] anIntArrayArray255;
    static int[] anIntArray256;
    static int anInt257;
    static int anInt258;
    static int anInt259;
    private int[] expressionFrames;
    int rightHandItem;
    int animatingPrecedence;
    boolean[] interleaveOrder;
    int[][] sounds;
    int[] secondarySpeeds;
    static int anInt266;
    int[] durations;
    boolean useSounds;
    int anInt269;

    final int method263(int i, int i_0_, int i_1_, boolean bool) {
        anInt240++;
        int i_2_ = 0;
        int i_3_ = 0;
        int i_4_ = this.frames[i_1_];
        Class348_Sub42_Sub17 class348_sub42_sub17 = null;
        Class348_Sub42_Sub17 class348_sub42_sub17_5_ = this.aAnimTypeList_251.method839(i_4_ >> 16, 3);
        i_4_ &= 0xffff;
        if (class348_sub42_sub17_5_ == null) return i_2_;
        if ((this.tweened || Class28.aBoolean5002) && i != -1 && i < this.frames.length) {
            i_3_ = this.frames[i];
            class348_sub42_sub17 = this.aAnimTypeList_251.method839(i_3_ >> 16, 3);
            i_3_ &= 0xffff;
        }
        if (i_0_ <= 96) return 11;
        if (this.aBoolean242) i_2_ |= 0x200;
        if (class348_sub42_sub17_5_.method3272(i_4_, 0)) i_2_ |= 0x80;
        if (class348_sub42_sub17_5_.method3271(i_4_, 14)) i_2_ |= 0x100;
        if (class348_sub42_sub17_5_.method3267((byte) -110, i_4_)) i_2_ |= 0x400;
        if (class348_sub42_sub17 != null) {
            if (class348_sub42_sub17.method3272(i_3_, 0)) i_2_ |= 0x80;
            if (class348_sub42_sub17.method3271(i_3_, 14)) i_2_ |= 0x100;
            if (class348_sub42_sub17.method3267((byte) -127, i_3_)) i_2_ |= 0x400;
        }
        if (expressionFrames != null && bool) {
            if (expressionFrames.length > i_1_) {
                int i_6_ = expressionFrames[i_1_];
                if (i_6_ != 65535) {
                    Class348_Sub42_Sub17 class348_sub42_sub17_7_ = this.aAnimTypeList_251.method839(i_6_ >> 16, 3);
                    i_6_ &= 0xffff;
                    if (class348_sub42_sub17_7_ != null) {
                        if (class348_sub42_sub17_7_.method3272(i_6_, 0)) i_2_ |= 0x80;
                        if (class348_sub42_sub17_7_.method3271(i_6_, 14)) i_2_ |= 0x100;
                        if (class348_sub42_sub17_7_.method3267((byte) -103, i_6_)) i_2_ |= 0x400;
                    }
                }
            }
            if ((this.tweened || Class28.aBoolean5002) && i != -1 && expressionFrames.length > i) {
                int i_8_ = expressionFrames[i];
                if (i_8_ != 65535) {
                    Class348_Sub42_Sub17 class348_sub42_sub17_9_ = this.aAnimTypeList_251.method839(i_8_ >> 16, 3);
                    i_8_ &= 0xffff;
                    if (class348_sub42_sub17_9_ != null) {
                        if (class348_sub42_sub17_9_.method3272(i_8_, 0)) i_2_ |= 0x80;
                        if (class348_sub42_sub17_9_.method3271(i_8_, 14)) i_2_ |= 0x100;
                        if (class348_sub42_sub17_9_.method3267((byte) -93, i_8_)) i_2_ |= 0x400;
                    }
                }
            }
        }
        return 0x20 | i_2_;
    }

    private final void method264(Packet packet, int opcode) {
        if (opcode == 1) {
            int length = packet.readUnsignedShort(842397944);//short
            this.durations = new int[length];
            this.frames = new int[length];
            for (int i = 0; i < length; i++)
                this.durations[i] = packet.readUnsignedShort(842397944);
            for (int i = 0; i < length; i++)
                this.frames[i] = packet.readUnsignedShort(842397944);
            for (int i = 0; i < length; i++)
                this.frames[i] = ((packet.readUnsignedShort(842397944) << 16) + this.frames[i]);
        } else if (opcode == 2) {
            this.loopOffset = packet.readUnsignedShort(-14861 ^ ~0x3235c2f4);
        } else if (opcode == 3) {
            this.interleaveOrder = new boolean[256];
            int length = packet.readUnsignedByte(255);//byte
            for (int i = 0; i < length; i++)
                this.interleaveOrder[packet.readUnsignedByte(255)] = true;
        } else if (opcode == 5) {
            this.priority = packet.readUnsignedByte(-14861 + 15116);
        } else if (opcode == 6) {
            this.leftHandItem = packet.readUnsignedShort(842397944);
        } else if (opcode == 7) {
            this.rightHandItem = packet.readUnsignedShort(842397944);
        } else if (opcode == 8) {
            this.maxLoops = packet.readUnsignedByte(255);
        } else if (opcode == 9) this.animatingPrecedence = packet.readUnsignedByte(-14861 + 15116);
        else if (opcode == 10) this.walkingPrecedence = packet.readUnsignedByte(-14861 ^ ~0x3af3);
        else if (opcode == 11) {
            this.replayMode = packet.readUnsignedByte(255);
        } else if (opcode == 12) {
            int length = packet.readUnsignedByte(-14861 ^ ~0x3af3);
            expressionFrames = new int[length];
            for (int i = 0; (i < length); i++)
                expressionFrames[i] = packet.readUnsignedShort(842397944);
            for (int i = 0; (length > i); i++)
                expressionFrames[i] = ((packet.readUnsignedShort(842397944) << 16) - -expressionFrames[i]);
        } else if (opcode == 13) {
            int length = packet.readUnsignedShort(842397944);
            this.sounds = new int[length][];
            for (int i = 0; (i < length); i++) {
                int size = packet.readUnsignedByte(255);
                if (size > 0) {
                    this.sounds[i] = new int[size];
                    this.sounds[i][0] = packet.readMedium(-1);
                    for (int j = 1; (size > j); j++)
                        this.sounds[i][j] = (packet.readUnsignedShort(842397944));
                }
            }
        } else if (opcode == 14) {
            this.aBoolean242 = true;
        } else if (opcode == 15) this.tweened = true;
        else if (opcode == 16) this.aBoolean254 = true;
        else if (opcode == 18) this.useSounds = true;
        else if (opcode == 19) {
            if (this.volumes == null) {
                this.volumes = (new int[(this.sounds).length]);
                for (int i = 0; ((this.sounds).length > i); i++)
                    this.volumes[i] = 255;
            }
            this.volumes[packet.readUnsignedByte(255)] = (packet.readUnsignedByte(Class348_Sub21.method2955(-14861, -15092)));
        } else if (opcode == 20) {
            if ((this.primarySpeeds == null) || (this.secondarySpeeds) == null) {
                this.primarySpeeds = (new int[(this.sounds).length]);
                this.secondarySpeeds = (new int[(this.sounds).length]);
                for (int i = 0; ((this.sounds).length > i); i++) {
                    this.primarySpeeds[i] = 256;
                    this.secondarySpeeds[i] = 256;
                }
            }
            int length = packet.readUnsignedByte(255);
            this.primarySpeeds[length] = packet.readUnsignedShort(842397944);
            this.secondarySpeeds[length] = packet.readUnsignedShort(842397944);
        }
        anInt257++;
    }

    public static void method265(boolean bool) {
        anIntArray256 = null;
        aClass114_250 = null;
        anIntArrayArray255 = null;
        if (bool != false) method268(-22, -54, -101, -115, -107, 90, 13, -47);
        anOffscreenSurface_252 = null;
    }

    final Model method266(Model model, int i, int i_27_, byte i_28_, int i_29_, int i_30_, int i_31_, int i_32_) {
        anInt266++;
        int i_33_ = this.durations[i_29_];
        i_29_ = this.frames[i_29_];
        Class348_Sub42_Sub17 class348_sub42_sub17 = this.aAnimTypeList_251.method839(i_29_ >> 16, 3);
        i_29_ &= 0xffff;
        if (class348_sub42_sub17 == null) return model.method614(i_28_, i_32_, true);
        Class348_Sub42_Sub17 class348_sub42_sub17_34_ = null;
        if ((this.tweened || Class28.aBoolean5002) && i_27_ != -1 && this.frames.length > i_27_) {
            i_27_ = this.frames[i_27_];
            class348_sub42_sub17_34_ = this.aAnimTypeList_251.method839(i_27_ >> 16, 3);
            i_27_ &= 0xffff;
        }
        if (this.aBoolean242) i_32_ |= 0x200;
        if (class348_sub42_sub17.method3272(i_29_, i_31_ + -663780816)) i_32_ |= 0x80;
        if (class348_sub42_sub17.method3271(i_29_, i_31_ ^ 0x27907dde)) i_32_ |= 0x100;
        if (class348_sub42_sub17.method3267((byte) -126, i_29_)) i_32_ |= 0x400;
        if (class348_sub42_sub17_34_ != null) {
            if (class348_sub42_sub17_34_.method3272(i_27_, 0)) i_32_ |= 0x80;
            if (class348_sub42_sub17_34_.method3271(i_27_, 14)) i_32_ |= 0x100;
            if (class348_sub42_sub17_34_.method3267((byte) -125, i_27_)) i_32_ |= 0x400;
        }
        i_32_ |= 0x20;
        if (i_31_ != 663780816) this.rightHandItem = -72;
        Model model_35_ = model.method614(i_28_, i_32_, true);
        model_35_.method617(i_29_, i_33_, class348_sub42_sub17_34_, i, class348_sub42_sub17, false, this.aBoolean242, i_27_, i_30_ + -1);
        return model_35_;
    }

    final void method267(Packet packet, boolean bool) {
        anInt243++;
        for (; ; ) {
            int i = packet.readUnsignedByte(255);
            if (i == 0) break;
            method264(packet, i);
        }
        if (bool != false) this.durations = null;
    }

    static final void method268(int i, int i_36_, int i_37_, int i_38_, int i_39_, int i_40_, int i_41_, int i_42_) {
        anInt259++;
        int i_43_ = -334 + i_39_;
        if (i_43_ < 0) i_43_ = 0;
        else if (i_43_ > 100) i_43_ = 100;
        int i_44_ = (i_43_ * (-Class348_Sub23_Sub3.aShort9044 + Class320.aShort3992) / 100 + Class348_Sub23_Sub3.aShort9044);
        i_42_ = i_42_ * i_44_ >> 8;
        Class132.anInt1906 = Class132.anInt1911 * i_44_ >> 8;
        int i_45_ = 16384 - i & 0x3fff;
        int i_46_ = 0x3fff & 16384 - i_37_;
        if (i_40_ != -19360) anOffscreenSurface_252 = null;
        int i_47_ = 0;
        int i_48_ = 0;
        int i_49_ = i_42_;
        if (i_45_ != 0) {
            i_48_ = -i_49_ * Class70.SIN[i_45_] >> 14;
            i_49_ = Class70.COS[i_45_] * i_49_ >> 14;
        }
        if (i_46_ != 0) {
            i_47_ = Class70.SIN[i_46_] * i_49_ >> 14;
            i_49_ = i_49_ * Class70.COS[i_46_] >> 14;
        }
        Class5.anInt4638 = i_37_;
        Class338.anInt4186 = 0;
        Class59_Sub2_Sub2.anInt8685 = i_38_ - i_49_;
        Class305.anInt3855 = -i_48_ + i_36_;
        Class286_Sub4.anInt6246 = -i_47_ + i_41_;
        ClientScript.anInt9701 = i;
    }

    final Model method269(int i, Model model, int i_50_, int i_51_, int i_52_, int i_53_) {
        anInt246++;
        int i_54_ = this.durations[i_53_];
        int i_55_ = this.frames[i_53_];
        Class348_Sub42_Sub17 class348_sub42_sub17 = this.aAnimTypeList_251.method839(i_55_ >> 16, 3);
        i_55_ &= 0xffff;
        if (class348_sub42_sub17 == null) return model.method614((byte) 1, i_52_, true);
        Class348_Sub42_Sub17 class348_sub42_sub17_56_ = null;
        if ((this.tweened || Class28.aBoolean5002) && i_50_ != -1 && this.frames.length > i_50_) {
            i_50_ = this.frames[i_50_];
            class348_sub42_sub17_56_ = this.aAnimTypeList_251.method839(i_50_ >> 16, 3);
            i_50_ &= 0xffff;
        }
        Class348_Sub42_Sub17 class348_sub42_sub17_57_ = null;
        Class348_Sub42_Sub17 class348_sub42_sub17_58_ = null;
        int i_59_ = 0;
        int i_60_ = 0;
        if (expressionFrames != null) {
            if (expressionFrames.length > i_53_) {
                i_59_ = expressionFrames[i_53_];
                if (i_59_ != 65535) {
                    class348_sub42_sub17_57_ = this.aAnimTypeList_251.method839(i_59_ >> 16, 3);
                    i_59_ &= 0xffff;
                }
            }
            if ((this.tweened || Class28.aBoolean5002) && i_50_ != -1 && i_50_ < expressionFrames.length) {
                i_60_ = expressionFrames[i_50_];
                if (i_60_ != 65535) {
                    class348_sub42_sub17_58_ = this.aAnimTypeList_251.method839(i_60_ >> 16, 3);
                    i_60_ &= 0xffff;
                }
            }
        }
        if (this.aBoolean242) i_52_ |= 0x200;
        if (class348_sub42_sub17.method3272(i_55_, 0)) i_52_ |= 0x80;
        if (class348_sub42_sub17.method3271(i_55_, 14)) i_52_ |= 0x100;
        if (class348_sub42_sub17.method3267((byte) -102, i_55_)) i_52_ |= 0x400;
        if (class348_sub42_sub17_57_ != null) {
            if (class348_sub42_sub17_57_.method3272(i_59_, 0)) i_52_ |= 0x80;
            if (class348_sub42_sub17_57_.method3271(i_59_, 14)) i_52_ |= 0x100;
            if (class348_sub42_sub17_57_.method3267((byte) -109, i_59_)) i_52_ |= 0x400;
        }
        if (class348_sub42_sub17_56_ != null) {
            if (class348_sub42_sub17_56_.method3272(i_50_, 0)) i_52_ |= 0x80;
            if (class348_sub42_sub17_56_.method3271(i_50_, 14)) i_52_ |= 0x100;
            if (class348_sub42_sub17_56_.method3267((byte) -114, i_50_)) i_52_ |= 0x400;
        }
        if (class348_sub42_sub17_58_ != null) {
            if (class348_sub42_sub17_58_.method3272(i_60_, 0)) i_52_ |= 0x80;
            if (class348_sub42_sub17_58_.method3271(i_60_, 14)) i_52_ |= 0x100;
            if (class348_sub42_sub17_58_.method3267((byte) -109, i_60_)) i_52_ |= 0x400;
        }
        i_52_ |= 0x20;
        Model model_61_ = model.method614((byte) 1, i_52_, true);
        int i_62_ = -33 / ((49 - i) / 45);
        model_61_.method617(i_55_, i_54_, class348_sub42_sub17_56_, 0, class348_sub42_sub17, false, this.aBoolean242, i_50_, -1 + i_51_);
        if (class348_sub42_sub17_57_ != null) model_61_.method617(i_59_, i_54_, class348_sub42_sub17_58_, 0, class348_sub42_sub17_57_, false, this.aBoolean242, i_60_, -1 + i_51_);
        return model_61_;
    }

    final void method270(byte i) {
        anInt258++;
        if (this.animatingPrecedence == -1) {
            if (this.interleaveOrder == null) this.animatingPrecedence = 0;
            else this.animatingPrecedence = 2;
        }
        if (this.walkingPrecedence == -1) {
            if (this.interleaveOrder != null) this.walkingPrecedence = 2;
            else this.walkingPrecedence = 0;
        }
        int i_63_ = -41 / ((i - 45) / 49);
    }

    public AnimationType() {
        this.loopOffset = -1;
        this.tweened = false;
        this.walkingPrecedence = -1;
        this.priority = 5;
        this.aBoolean254 = false;
        this.animatingPrecedence = -1;
        this.leftHandItem = -1;
        this.replayMode = 2;
        this.rightHandItem = -1;
        this.maxLoops = 99;
        this.useSounds = false;
    }
}
