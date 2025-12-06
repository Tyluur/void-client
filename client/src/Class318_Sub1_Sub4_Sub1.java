/* Class318_Sub1_Sub4_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class318_Sub1_Sub4_Sub1 extends Class318_Sub1_Sub4 implements Interface10 {
    private byte aByte10062;
    static int anInt10063;
    private final boolean aBoolean10064;
    static int anInt10065;
    private boolean aBoolean10066;
    static int anInt10067;
    static int anInt10068;
    static int anInt10069;
    static int anInt10070;
    Model aModel_10071;
    static int anInt10072;
    static int anInt10073;
    static int anInt10074;
    static int anInt10075;
    private final boolean aBoolean10076;
    static int anInt10077;
    static int anInt10078;
    private byte aByte10079;
    static int anInt10080;
    private short aShort10081;
    private Class30 aClass30_10082;
    static int anInt10083;
    static int anInt10084;
    static int anInt10085;
    static int anInt10086;
    static int anInt10087;
    static int anInt10088;
    static int anInt10089;
    private boolean aBoolean10090;
    static int anInt10091;
    static int anInt10092;
    static int anInt10093;
    private r aR10094;

    Class318_Sub1_Sub4_Sub1(Toolkit var_toolkit, Class51 class51, int i, int i_0_, int i_1_, int i_2_, int i_3_, boolean bool, int i_4_, int i_5_, boolean bool_6_) {
        super(i_1_, i_2_, i_3_, i, i_0_, Class286_Sub9.method2175(i_5_, (byte) -34, i_4_));
        do {
            try {
                aShort10081 = (short) class51.anInt941;
                aBoolean10066 = bool;
                aBoolean10090 = bool_6_;
                this.x = i_1_;
                aBoolean10076 = (class51.anInt874 != 0 && !bool);
                this.y = i_3_;
                aByte10079 = (byte) i_4_;
                aByte10062 = (byte) i_5_;
                aBoolean10064 = (var_toolkit.method3682() && class51.aBoolean894 && !aBoolean10066 && Class316.clientOptions.aClass239_Sub7_7238.method1748(-32350) != 0);
                int i_7_ = 2048;
                if (aBoolean10090) i_7_ |= 0x10000;
                Class2 class2 = method2481(aBoolean10064, i_7_, -4, var_toolkit);
                if (class2 == null) break;
                aR10094 = class2.aR118;
                this.aModel_10071 = class2.aModel_119;
                if (!aBoolean10090) break;
                this.aModel_10071 = this.aModel_10071.method614((byte) 0, i_7_, false);
            } catch (RuntimeException runtimeexception) {
                throw Class348_Sub17.method2929(runtimeexception, ("ge.<init>(" + (var_toolkit != null ? "{...}" : "null") + ',' + (class51 != null ? "{...}" : "null") + ',' + i + ',' + i_0_ + ',' + i_1_ + ',' + i_2_ + ',' + i_3_ + ',' + bool + ',' + i_4_ + ',' + i_5_ + ',' + bool_6_ + ')'));
            }
            break;
        } while (false);
    }

    public final int method39(int i) {
        anInt10080++;
        int i_8_ = 69 % ((i - -91) / 35);
        return aByte10079;
    }

    public final void method40(int i) {
        anInt10077++;
        if (this.aModel_10071 != null) this.aModel_10071.method612();
        if (i != -12031) method38(-122);
    }

    final boolean method2391(Toolkit var_toolkit, int i, int i_9_, int i_10_) {
        anInt10070++;
        Model model = method2482(var_toolkit, (byte) 126, 131072);
        if (i_10_ != 0) method41(-96);
        if (model != null) {
            Matrix matrix = var_toolkit.method3705();
            matrix.method894(this.x, this.anInt6382, this.y);
            if (Class305.aBoolean3870) return model.method623(i_9_, i, matrix, false, 0, Class132.anInt1906);
            return model.method628(i_9_, i, matrix, false, 0);
        }
        return false;
    }

    final void method2387(Toolkit var_toolkit, int i) {
        if (i > -125) method42(115);
        anInt10067++;
    }

    public final int method41(int i) {
        anInt10087++;
        if (i != -32228) return 1;
        return aByte10062;
    }

    final void method2392(boolean bool) {
        anInt10091++;
        if (bool != true) method2394(true);
        aBoolean10090 = false;
        if (this.aModel_10071 != null) this.aModel_10071.s(this.aModel_10071.ua() & ~0x10000);
    }

    final Class30 method2381(Toolkit var_toolkit, int i) {
        anInt10075++;
        if (aClass30_10082 == null) aClass30_10082 = (Class348_Sub23_Sub1.method2967(this.x, method2482(var_toolkit, (byte) 117, 0), this.y, this.anInt6382, i + -5));
        if (i != 7) aBoolean10066 = false;
        return aClass30_10082;
    }

    public final int method42(int i) {
        anInt10088++;
        if (i > -62) return -96;
        return aShort10081 & 0xffff;
    }

    final int method2379(int i) {
        anInt10063++;
        if (i != -25675) aByte10079 = (byte) 53;
        if (this.aModel_10071 != null) return this.aModel_10071.ma();
        return 0;
    }

    public final boolean method38(int i) {
        anInt10078++;
        if (i != -18443) aShort10081 = (short) 37;
        return aBoolean10064;
    }

    final void method2380(Toolkit var_toolkit, int i, boolean bool, Class318_Sub1 class318_sub1, int i_11_, byte i_12_, int i_13_) {
        try {
            if (i_12_ > -106) method2388(-102);
            if (class318_sub1 instanceof Class318_Sub1_Sub4_Sub1) {
                Class318_Sub1_Sub4_Sub1 class318_sub1_sub4_sub1_14_ = (Class318_Sub1_Sub4_Sub1) class318_sub1;
                if (this.aModel_10071 != null && (class318_sub1_sub4_sub1_14_.aModel_10071) != null) this.aModel_10071.method613(class318_sub1_sub4_sub1_14_.aModel_10071, i_13_, i, i_11_, bool);
            } else if (class318_sub1 instanceof Class318_Sub1_Sub3_Sub1) {
                Class318_Sub1_Sub3_Sub1 class318_sub1_sub3_sub1 = (Class318_Sub1_Sub3_Sub1) class318_sub1;
                if (this.aModel_10071 != null && (class318_sub1_sub3_sub1.aModel_10028) != null) this.aModel_10071.method613((class318_sub1_sub3_sub1.aModel_10028), i_13_, i, i_11_, bool);
            }
            anInt10083++;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("ge.N(" + (var_toolkit != null ? "{...}" : "null") + ',' + i + ',' + bool + ',' + (class318_sub1 != null ? "{...}" : "null") + ',' + i_11_ + ',' + i_12_ + ',' + i_13_ + ')'));
        }
    }

    public final void method44(int i, Toolkit var_toolkit) {
        anInt10092++;
        Object object = null;
        r var_r;
        if (aR10094 == null && aBoolean10064) {
            Class2 class2 = method2481(true, 262144, -4, var_toolkit);
            var_r = class2 == null ? null : class2.aR118;
        } else {
            var_r = aR10094;
            aR10094 = null;
        }
        if (var_r != null) Class130.method1130(var_r, this.aByte6376, this.x, this.y, null);
        if (i != 836) aR10094 = null;
    }

    private final Class2 method2481(boolean bool, int i, int i_15_, Toolkit var_toolkit) {
        if (i_15_ != -4) aClass30_10082 = null;
        anInt10086++;
        Class51 class51 = Class348_Sub40_Sub12.objectTypeList.method2005(0, aShort10081 & 0xffff);
        Ground var_ground;
        Ground var_ground_16_;
        if (aBoolean10066) {
            var_ground = Class348_Sub1_Sub1.aGroundArray8801[0];
            var_ground_16_ = Class332.aGroundArray4142[this.aByte6376];
        } else {
            var_ground_16_ = (Class348_Sub1_Sub1.aGroundArray8801[this.aByte6376]);
            if (this.aByte6376 < 3) var_ground = (Class348_Sub1_Sub1.aGroundArray8801[1 + this.aByte6376]);
            else var_ground = null;
        }
        return class51.method476(var_toolkit, var_ground, aByte10079, i, this.x, bool, var_ground_16_, this.anInt6382, this.y, aByte10062, i_15_ + 132);
    }

    final Class318_Sub4 method2386(int i, Toolkit var_toolkit) {
        anInt10069++;
        if (this.aModel_10071 == null) return null;
        Matrix matrix = var_toolkit.method3705();
        matrix.method894(this.x, this.anInt6382, this.y);
        Class318_Sub4 class318_sub4 = OutputStream_Sub2.method136(i, aBoolean10076, false);
        if (!Class305.aBoolean3870) this.aModel_10071.render(matrix, class318_sub4.aClass318_Sub3Array6414[0], 0);
        else this.aModel_10071.render(matrix, class318_sub4.aClass318_Sub3Array6414[0], Class132.anInt1906, 0);
        return class318_sub4;
    }

    private final Model method2482(Toolkit var_toolkit, byte i, int i_17_) {
        if (i <= 113) method2387(null, -99);
        anInt10072++;
        if (this.aModel_10071 != null && var_toolkit.method3667(this.aModel_10071.ua(), i_17_) == 0) return this.aModel_10071;
        Class2 class2 = method2481(false, i_17_, -4, var_toolkit);
        if (class2 != null) return class2.aModel_119;
        return null;
    }

    final int method2394(boolean bool) {
        anInt10093++;
        if (bool != true) aByte10062 = (byte) -75;
        if (this.aModel_10071 == null) return 0;
        return this.aModel_10071.fa();
    }

    final boolean method2388(int i) {
        anInt10089++;
        if (i > -65) return true;
        return aBoolean10090;
    }

    final boolean method2377(byte i) {
        anInt10065++;
        if (i != 122) return true;
        if (this.aModel_10071 == null) return false;
        return this.aModel_10071.F();
    }

    final boolean method2376(int i) {
        if (i >= -12) method2388(-68);
        anInt10085++;
        if (this.aModel_10071 != null) {
            return !this.aModel_10071.r();
        }
        return true;
    }

    public final void method43(Toolkit var_toolkit, int i) {
        if (i != -14218) aClass30_10082 = null;
        anInt10068++;
        Object object = null;
        r var_r;
        if (aR10094 == null && aBoolean10064) {
            Class2 class2 = method2481(true, 262144, -4, var_toolkit);
            var_r = class2 == null ? null : class2.aR118;
        } else {
            var_r = aR10094;
            aR10094 = null;
        }
        if (var_r != null) Class169.method1301(var_r, this.aByte6376, this.x, this.y, null);
    }
}
