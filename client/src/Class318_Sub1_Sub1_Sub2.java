/* Class318_Sub1_Sub1_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class318_Sub1_Sub1_Sub2 extends Class318_Sub1_Sub1 implements Interface10 {
    static int anInt9969;
    static int anInt9970;
    static int anInt9971 = 0;
    static int anInt9972;
    static int anInt9973;
    private final boolean aBoolean9974;
    static int anInt9975;
    private r aR9976;
    static int anInt9977;
    static int anInt9978;
    static int anInt9979;
    private final byte aByte9980;
    static int[] anIntArray9981 = new int[5];
    static int anInt9982;
    private boolean aBoolean9983;
    static int anInt9984;
    static int anInt9985;
    static int anInt9986;
    static int anInt9987;
    private final boolean aBoolean9988;
    private boolean aBoolean9989;
    static int anInt9990;
    private short aShort9991;
    static int anInt9992;
    private Model aModel_9993;
    static int anInt9994;
    static int anInt9995;
    static int anInt9996;
    static int anInt9997 = 1;
    static int anInt9998;
    private Class30 aClass30_9999;
    static int anInt10000;
    static int anInt10001;
    static int anInt10002;

    public static void method2400(byte i) {
        if (i != 3) anIntArray9981 = null;
        anIntArray9981 = null;
    }

    final void method2380(Toolkit var_toolkit, int i, boolean bool, Class318_Sub1 class318_sub1, int i_0_, byte i_1_, int i_2_) {
        do {
            try {
                anInt9970++;
                if (i_1_ > -106) isBuildingMap(-5, (byte) 56);
                if (!(class318_sub1 instanceof Class318_Sub1_Sub1_Sub2)) break;
                Class318_Sub1_Sub1_Sub2 class318_sub1_sub1_sub2_3_ = (Class318_Sub1_Sub1_Sub2) class318_sub1;
                if (aModel_9993 == null || class318_sub1_sub1_sub2_3_.aModel_9993 == null) break;
                aModel_9993.method613((class318_sub1_sub1_sub2_3_.aModel_9993), i_2_, i, i_0_, bool);
            } catch (RuntimeException runtimeexception) {
                throw Class348_Sub17.method2929(runtimeexception, ("uo.N(" + (var_toolkit != null ? "{...}" : "null") + ',' + i + ',' + bool + ',' + (class318_sub1 != null ? "{...}" : "null") + ',' + i_0_ + ',' + i_1_ + ',' + i_2_ + ')'));
            }
            break;
        } while (false);
    }

    final int method2379(int i) {
        anInt10000++;
        if (i != -25675) return -120;
        if (aModel_9993 == null) return 0;
        return aModel_9993.ma();
    }

    public final void method43(Toolkit var_toolkit, int i) {
        anInt9995++;
        if (i != -14218) method2404(null, -47, 49);
        Object object = null;
        r var_r;
        if (aR9976 == null && aBoolean9988) {
            Class2 class2 = method2401(var_toolkit, 262144, true, 22);
            var_r = class2 == null ? null : class2.aR118;
        } else {
            var_r = aR9976;
            aR9976 = null;
        }
        if (var_r != null) Class169.method1301(var_r, this.aByte6376, this.x, this.y, null);
    }

    private final Class2 method2401(Toolkit var_toolkit, int i, boolean bool, int i_4_) {
        anInt9985++;
        if (i_4_ != 22) method2404(null, -21, -25);
        Class51 class51 = TextureOpColourGradient.objectTypeList.method2005(0, aShort9991 & 0xffff);
        Ground var_ground;
        Ground var_ground_5_;
        if (aBoolean9983) {
            var_ground = Class332.aGroundArray4142[this.aByte6376];
            var_ground_5_ = Class348_Sub1_Sub1.aGroundArray8801[0];
        } else {
            var_ground = (Class348_Sub1_Sub1.aGroundArray8801[this.aByte6376]);
            if (this.aByte6376 < 3) var_ground_5_ = (Class348_Sub1_Sub1.aGroundArray8801[1 + this.aByte6376]);
            else var_ground_5_ = null;
        }
        return class51.method476(var_toolkit, var_ground_5_, 22, i, this.x, bool, var_ground, this.anInt6382, this.y, aByte9980, 128);
    }

    // method2402
    static final boolean isBuildingMap(int i, byte i_6_) {
        anInt9994++;
        if (i_6_ >= -52) return true;
        return i == Packet.STEP_LOGIN_SCREEN_MAP_BUILD || i == Packet.STEP_LOBBY_SCREEN_MAP_BUILD || i == Packet.STEP_GAME_SCREEN;
    }

    final void method2392(boolean bool) {
        anInt9972++;
        if (bool == true) {
            aBoolean9989 = false;
            if (aModel_9993 != null) aModel_9993.s(~0x10000 & aModel_9993.ua());
        }
    }

    public final int method42(int i) {
        anInt9969++;
        if (i >= -62) return -1;
        return aShort9991 & 0xffff;
    }

    final Class318_Sub4 method2386(int i, Toolkit var_toolkit) {
        anInt9990++;
        if (aModel_9993 == null) return null;
        Matrix matrix = var_toolkit.method3705();
        matrix.method894(this.x, this.anInt6382, this.y);
        Class318_Sub4 class318_sub4 = OutputStream_Sub2.method136(i, aBoolean9974, false);
        if (Class305.aBoolean3870) aModel_9993.render(matrix, (class318_sub4.aClass318_Sub3Array6414[0]), Class132.anInt1906, 0);
        else aModel_9993.render(matrix, (class318_sub4.aClass318_Sub3Array6414[0]), 0);
        return class318_sub4;
    }

    public final boolean method38(int i) {
        if (i != -18443) aClass30_9999 = null;
        anInt10002++;
        return aBoolean9988;
    }

    final boolean method2388(int i) {
        if (i > -65) return true;
        anInt9978++;
        return aBoolean9989;
    }

    final boolean method2376(int i) {
        if (i >= -12) method2392(true);
        anInt9975++;
        if (aModel_9993 != null) {
            return !aModel_9993.r();
        }
        return true;
    }

    final int method2394(boolean bool) {
        anInt9979++;
        if (bool != true) method38(-4);
        if (aModel_9993 != null) return aModel_9993.fa();
        return 0;
    }

    public final int method41(int i) {
        anInt10001++;
        if (i != -32228) method2394(false);
        return aByte9980;
    }

    static final void method2403(int i, int i_7_, int i_8_, int i_9_, int i_10_, int i_11_, int i_12_) {
        anInt9977++;
        if (i_10_ != 19206) isBuildingMap(-3, (byte) 46);
        Class302[] class302s = Class348_Sub27.aClass302Array6897;
        for (int i_13_ = 0; i_13_ < class302s.length; i_13_++) {
            Class302 class302 = class302s[i_13_];
            if (class302 != null && class302.anInt3840 == 2) {
                Class318_Sub5.method2505(i_9_ >> 1, 2 * class302.anInt3839, 0, i_12_, i_11_ >> 1, class302.anInt3838, class302.anInt3832, i_7_, class302.anInt3835);
                if (Option_Sub21.anIntArray6062[0] > -1 && Class367_Sub11.anInt7396 % 20 < 10) {
                    Sprite sprite = (Option_Sub9.aSpriteArray5933[class302.anInt3831]);
                    int i_14_ = -12 + (i - -Option_Sub21.anIntArray6062[0]);
                    int i_15_ = i_8_ - -Option_Sub21.anIntArray6062[1] - 28;
                    sprite.method974(i_14_, i_15_);
                    Class338.method2663(-5590, i_14_, i_14_ - -sprite.scaleWidth(), i_15_, sprite.scaleHeight() + i_15_);
                }
            }
        }
    }

    public final void method40(int i) {
        if (i == -12031) {
            anInt9982++;
            if (aModel_9993 != null) aModel_9993.method612();
        }
    }

    final boolean method2377(byte i) {
        if (i != 122) method40(3);
        anInt9973++;
        if (aModel_9993 == null) return false;
        return aModel_9993.F();
    }

    public final void method44(int i, Toolkit var_toolkit) {
        anInt9986++;
        Object object = null;
        r var_r;
        if (aR9976 != null || !aBoolean9988) {
            var_r = aR9976;
            aR9976 = null;
        } else {
            Class2 class2 = method2401(var_toolkit, 262144, true, 22);
            var_r = class2 == null ? null : class2.aR118;
        }
        if (var_r != null) Class130.method1130(var_r, this.aByte6376, this.x, this.y, null);
        if (i != 836) aShort9991 = (short) 86;
    }

    final boolean method2391(Toolkit var_toolkit, int i, int i_16_, int i_17_) {
        if (i_17_ != 0) anInt9997 = -51;
        anInt9996++;
        Model model = method2404(var_toolkit, 69, 131072);
        if (model != null) {
            Matrix matrix = var_toolkit.method3705();
            matrix.method894(this.x, this.anInt6382, this.y);
            if (Class305.aBoolean3870) return model.method623(i_16_, i, matrix, false, 0, Class132.anInt1906);
            return model.method628(i_16_, i, matrix, false, 0);
        }
        return false;
    }

    private final Model method2404(Toolkit var_toolkit, int i, int i_18_) {
        anInt9984++;
        int i_19_ = 65 / ((-34 - i) / 53);
        if (aModel_9993 != null && var_toolkit.method3667(aModel_9993.ua(), i_18_) == 0) return aModel_9993;
        Class2 class2 = method2401(var_toolkit, i_18_, false, 22);
        if (class2 != null) return class2.aModel_119;
        return null;
    }

    Class318_Sub1_Sub1_Sub2(Toolkit var_toolkit, Class51 class51, int i, int i_20_, int i_21_, int i_22_, int i_23_, boolean bool, int i_24_, boolean bool_25_) {
        super(i_21_, i_22_, i_23_, i, i_20_, class51.anInt930);
        do {
            try {
                aBoolean9983 = bool;
                aBoolean9974 = (class51.anInt874 != 0 && !bool);
                this.y = i_23_;
                aBoolean9989 = bool_25_;
                this.x = i_21_;
                aByte9980 = (byte) i_24_;
                aShort9991 = (short) class51.anInt941;
                aBoolean9988 = (var_toolkit.method3682() && class51.aBoolean894 && !aBoolean9983 && Class316.clientOptions.aClass239_Sub7_7238.method1748(-32350) != 0);
                int i_26_ = 2048;
                if (aBoolean9989) i_26_ |= 0x10000;
                Class2 class2 = method2401(var_toolkit, i_26_, aBoolean9988, 22);
                if (class2 == null) break;
                aModel_9993 = class2.aModel_119;
                aR9976 = class2.aR118;
                if (!aBoolean9989) break;
                aModel_9993 = aModel_9993.method614((byte) 0, i_26_, false);
            } catch (RuntimeException runtimeexception) {
                throw Class348_Sub17.method2929(runtimeexception, ("uo.<init>(" + (var_toolkit != null ? "{...}" : "null") + ',' + (class51 != null ? "{...}" : "null") + ',' + i + ',' + i_20_ + ',' + i_21_ + ',' + i_22_ + ',' + i_23_ + ',' + bool + ',' + i_24_ + ',' + bool_25_ + ')'));
            }
            break;
        } while (false);
    }

    final Class30 method2381(Toolkit var_toolkit, int i) {
        if (aClass30_9999 == null) aClass30_9999 = (Class348_Sub23_Sub1.method2967(this.x, method2404(var_toolkit, 86, 0), this.y, this.anInt6382, i ^ 0x5));
        if (i != 7) return null;
        anInt9998++;
        return aClass30_9999;
    }

    final void method2387(Toolkit var_toolkit, int i) {
        if (i >= -125) aBoolean9983 = false;
        anInt9987++;
    }

    public final int method39(int i) {
        int i_27_ = -125 % ((i - -91) / 35);
        anInt9992++;
        return 22;
    }
}
