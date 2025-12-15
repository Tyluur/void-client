/* Class348 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Class348
class Node {
    static int anInt4285;
    static Index textureCacheIndex;
    static int anInt4287;
    static int[] anIntArray4288;
    static int anInt4289;
    static int anInt4290;
    long aLong4291;
    static int anInt4292 = 0;
    static Class318_Sub1[] aClass318_Sub1Array4293;
    Node aNode_4294;
    Node aNode_4295;
    static int anInt4296;
    static int anInt4297;
    static int anInt4298;

    static final boolean method2709(int i, int i_0_, int i_1_) {
        anInt4287++;
        if (i_1_ != -1) method2711(-42, 89, null, -113, true, -22, -35, 27, -109, null, 74, -94, -119, null);
        return (0x21 & i_0_) != 0;
    }

    static final int method2710(int i, int i_2_) {
        anInt4289++;
        if (i_2_ < 96) return 0;
        if (i >= -113) aClass318_Sub1Array4293 = null;
        if (i_2_ < 128) return 2;
        return 3;
    }

    static final Model method2711(int i, int i_3_, Model model, int i_4_, boolean bool, int i_5_, int i_6_, int i_7_, int i_8_, Toolkit var_toolkit, int i_9_, int i_10_, int i_11_, AnimationType animationType) {
        try {
            anInt4298++;
            if (model == null) return null;
            int i_12_ = 2055;
            if (bool != false) return null;
            if (animationType != null) {
                i_12_ |= animationType.method263(-1, 103, i_5_, false);
                i_12_ &= ~0x200;
            }
            long l = (((long) i_10_ << 48) + (long) (i_7_ + ((i_9_ << 16) + (i_11_ << 24))) - -((long) i_6_ << 32));
            Model model_13_;
            synchronized (ModelParticleEffector.aClass60_4254) {
                model_13_ = (Model) ModelParticleEffector.aClass60_4254.method583(l, -64);
            }
            if (model_13_ == null || (var_toolkit.method3667(model_13_.ua(), i_12_) != 0)) {
                if (model_13_ != null) i_12_ = var_toolkit.method3679(i_12_, model_13_.ua());
                int i_14_;
                if (i_7_ != 1) {
                    if (i_7_ == 2) i_14_ = 12;
                    else if (i_7_ != 3) {
                        if (i_7_ == 4) i_14_ = 18;
                        else i_14_ = 21;
                    } else i_14_ = 15;
                } else i_14_ = 9;
                int i_15_ = 3;
                int[] is = {64, 96, 128};
                Mesh mesh = new Mesh(1 + i_14_ * i_15_, 2 * i_14_ * i_15_ + -i_14_, 0);
                int i_16_ = mesh.addVertex(0, 0, 0, -44);
                int[][] is_17_ = new int[i_15_][i_14_];
                for (int i_18_ = 0; i_18_ < i_15_; i_18_++) {
                    int i_19_ = is[i_18_];
                    int i_20_ = is[i_18_];
                    for (int i_21_ = 0; i_14_ > i_21_; i_21_++) {
                        int i_22_ = (i_21_ << 14) / i_14_;
                        int i_23_ = (Class70.SIN[i_22_] * i_19_ >> 14);
                        int i_24_ = (Class70.COS[i_22_] * i_20_ >> 14);
                        is_17_[i_18_][i_21_] = mesh.addVertex(0, i_24_, i_23_, 123);
                    }
                }
                for (int i_25_ = 0; i_15_ > i_25_; i_25_++) {
                    int i_26_ = (i_25_ * 256 + 128) / i_15_;
                    int i_27_ = -i_26_ + 256;
                    byte i_28_ = (byte) (i_26_ * i_11_ + i_9_ * i_27_ >> 8);
                    short i_29_ = (short) (((0xfc0000 & ((i_10_ & 0xfc00) * i_26_ + i_27_ * (0xfc00 & i_6_))) + (((i_10_ & 0x380) * i_26_ + i_27_ * (0x380 & i_6_)) & 0x38000) + ((i_26_ * (i_10_ & 0x7f) + (0x7f & i_6_) * i_27_) & 0x7f00)) >> 8);
                    for (int i_30_ = 0; i_30_ < i_14_; i_30_++) {
                        if (i_25_ == 0) mesh.method1102(i_16_, (byte) 1, (byte) -1, (short) -1, (byte) 45, i_29_, is_17_[0][(1 + i_30_) % i_14_], i_28_, is_17_[0][i_30_]);
                        else {
                            mesh.method1102(is_17_[i_25_ - 1][i_30_], (byte) 1, (byte) -1, (short) -1, (byte) 48, i_29_, is_17_[i_25_ + -1][(1 + i_30_) % i_14_], i_28_, is_17_[i_25_][(1 + i_30_) % i_14_]);
                            mesh.method1102(is_17_[-1 + i_25_][i_30_], (byte) 1, (byte) -1, (short) -1, (byte) 100, i_29_, (is_17_[i_25_][(1 + i_30_) % i_14_]), i_28_, is_17_[i_25_][i_30_]);
                        }
                    }
                }
                model_13_ = var_toolkit.method3625(mesh, i_12_, LightTypeList.anInt2482, 64, 768);
                synchronized (ModelParticleEffector.aClass60_4254) {
                    ModelParticleEffector.aClass60_4254.method582(model_13_, l, (byte) -103);
                }
            }
            int i_31_ = model.V();
            int i_32_ = model.RA();
            int i_33_ = model.HA();
            int i_34_ = model.G();
            Class348_Sub42_Sub17 class348_sub42_sub17 = null;
            if (animationType != null) {
                i_5_ = animationType.frames[i_5_];
                class348_sub42_sub17 = Class10.animTypeList.method839(i_5_ >> 16, 3);
                i_5_ &= 0xffff;
            }
            if (class348_sub42_sub17 == null) {
                model_13_ = model_13_.method614((byte) 3, i_12_, true);
                model_13_.O(-i_31_ + i_32_ >> 1, 128, -i_33_ + i_34_ >> 1);
                model_13_.H(i_32_ + i_31_ >> 1, 0, i_34_ + i_33_ >> 1);
            } else {
                model_13_ = model_13_.method614((byte) 3, i_12_, true);
                model_13_.O(-i_31_ + i_32_ >> 1, 128, i_34_ - i_33_ >> 1);
                model_13_.H(i_32_ + i_31_ >> 1, 0, i_34_ + i_33_ >> 1);
                model_13_.method611(i_5_, -8700, class348_sub42_sub17);
            }
            if (i != 0) model_13_.FA(i);
            if (i_4_ != 0) model_13_.VA(i_4_);
            if (i_8_ != 0) model_13_.H(0, i_8_, 0);
            return model_13_;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("eh.PC(" + i + ',' + i_3_ + ',' + (model != null ? "{...}" : "null") + ',' + i_4_ + ',' + bool + ',' + i_5_ + ',' + i_6_ + ',' + i_7_ + ',' + i_8_ + ',' + (var_toolkit != null ? "{...}" : "null") + ',' + i_9_ + ',' + i_10_ + ',' + i_11_ + ',' + (animationType != null ? "{...}" : "null") + ')'));
        }
    }

    final boolean method2712(byte i) {
        if (i != 4) return true;
        anInt4297++;
        return this.aNode_4295 != null;
    }

    public static void method2713(int i) {
        textureCacheIndex = null;
        aClass318_Sub1Array4293 = null;
        if (i != 0) method2711(-47, 87, null, 85, false, -126, -116, -51, -44, null, 75, -69, 87, null);
        anIntArray4288 = null;
    }

    static final boolean method2714(int i, int i_35_) {
        if (i != 7351) method2709(-15, 59, 58);
        anInt4296++;
        return i_35_ == 1 || i_35_ == 3 || i_35_ == 5;
    }

    final void method2715(byte i) {
        anInt4285++;
        if (this.aNode_4295 != null) {
            this.aNode_4295.aNode_4294 = this.aNode_4294;
            this.aNode_4294.aNode_4295 = this.aNode_4295;
            if (i < 18) method2712((byte) 46);
            this.aNode_4294 = null;
            this.aNode_4295 = null;
        }
    }

    public Node() {
        /* empty */
    }

    static {
        anIntArray4288 = new int[6];
        anInt4290 = 0;
    }
}
