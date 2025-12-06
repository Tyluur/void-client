/* Class235 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class235 {
    static int anInt3050;
    private final Class318_Sub1 aClass318_Sub1_3051;
    int anInt3052;
    private int anInt3053;
    private int anInt3054;
    private int anInt3055;
    private int anInt3056;
    private Class17 aClass17_3057;
    static int anInt3058;
    private Model aModel_3059;
    private int anInt3060 = 0;
    static int anInt3061;
    static int anInt3062;
    int anInt3063;
    private boolean aBoolean3064;
    private final boolean aBoolean3065;
    static int anInt3066;
    private final byte aByte3067;
    static int[] anIntArray3068;
    private boolean aBoolean3069;
    static int anInt3070;
    private r aR3071;
    private boolean[] aBooleanArray3072;
    private int anInt3073;
    private int anInt3074;
    static Class78 aClass78_3075;
    static int anInt3076;
    static int anInt3077;
    static int anInt3078;
    int anInt3079;
    static int anInt3080;
    Class318_Sub10 aClass318_Sub10_3081;
    static int anInt3082;
    private int anInt3083;
    private int anInt3084;
    private final byte aByte3085;
    static int anInt3086;
    static int anInt3087;

    final int method1663(int i) {
        if (i < 31) return 48;
        anInt3087++;
        return anInt3060;
    }

    final int method1664(int i) {
        if (i > -20) finalize();
        anInt3076++;
        return anInt3055;
    }

    final boolean method1665(int i) {
        if (i != 2) anInt3056 = -73;
        anInt3070++;
        return aBoolean3065;
    }

    private final void method1666(byte i, int i_0_) {
        anInt3077++;
        if (i != 69) aModel_3059 = null;
        int i_1_ = i_0_;
        boolean bool = false;
        if (i_1_ == -1) {
            Class51 class51 = Class348_Sub40_Sub12.objectTypeList.method2005(i ^ 0x45, this.anInt3063);
            Class51 class51_2_ = class51;
            if (class51.anIntArray945 != null) class51 = class51.method480((Class318_Sub1_Sub3_Sub3.timedVarDomain), (byte) 47);
            if (class51 == null) return;
            if (class51_2_ == class51) class51_2_ = null;
            if (class51.anIntArray943 == null) {
                if (class51.anInt868 != -1) {
                    if (anInt3053 != class51.anInt941) {
                        i_1_ = class51.anInt868;
                        bool = class51.aBoolean924;
                    }
                } else if (class51_2_ != null && class51_2_.anIntArray943 != null) {
                    if (aClass17_3057 != null && class51_2_.method481((byte) 105, (aClass17_3057.anInt269))) return;
                    i_1_ = class51_2_.method489(i ^ ~0x45);
                    if (anInt3053 != class51_2_.anInt941) bool = class51_2_.aBoolean924;
                } else if (class51_2_ != null && (class51_2_.anInt868 != -1) && (anInt3053 != class51_2_.anInt941)) {
                    bool = class51_2_.aBoolean924;
                    i_1_ = class51_2_.anInt868;
                }
            } else {
                if (aClass17_3057 != null && class51.method481((byte) 73, aClass17_3057.anInt269)) return;
                i_1_ = class51.method489(i + -70);
                if (anInt3053 != class51.anInt941) bool = class51.aBoolean924;
            }
        }
        if (i_1_ == -1) aClass17_3057 = null;
        else {
            aModel_3059 = null;
            if (aClass17_3057 != null && i_1_ == aClass17_3057.anInt269) {
                if (aClass17_3057.anInt248 == 0) return;
            } else aClass17_3057 = Class10.seqTypeList.method835(i_1_, i + -62);
            if (aClass17_3057.anIntArray237 == null) aClass17_3057 = null;
            else {
                if (bool) {
                    anInt3084 = (int) ((double) (aClass17_3057.anIntArray237).length * Math.random());
                    anInt3054 = 1 + (int) ((double) (aClass17_3057.anIntArray267[anInt3084]) * Math.random());
                } else {
                    anInt3084 = 0;
                    anInt3054 = 1;
                }
                anInt3083 = anInt3084 - -1;
                if (anInt3083 < 0 || anInt3083 >= aClass17_3057.anIntArray237.length) anInt3083 = -1;
                anInt3074 = -anInt3054 + Class367_Sub11.anInt7396;
            }
        }
    }

    final void method1667(byte i, Toolkit var_toolkit) {
        anInt3061++;
        method1668(true, true, i + -244, 262144, var_toolkit);
        if (i != 116) this.anInt3063 = 99;
    }

    final Model method1668(boolean bool, boolean bool_3_, int i, int i_4_, Toolkit var_toolkit) {
        anInt3082++;
        Class51 class51 = Class348_Sub40_Sub12.objectTypeList.method2005(0, this.anInt3063);
        if (class51.anIntArray945 != null) class51 = class51.method480(Class318_Sub1_Sub3_Sub3.timedVarDomain, (byte) 47);
        if (class51 == null) {
            method1674(-1, var_toolkit);
            anInt3073 = -1;
            anInt3056 = -1;
            anInt3053 = -1;
            return null;
        }
        if (!aBoolean3064 && class51.anInt941 != anInt3053) {
            aModel_3059 = null;
            method1666((byte) 69, -1);
        }
        method1672(aClass318_Sub1_3051, true);
        if (bool_3_) {
            bool_3_ = bool_3_ & (aBoolean3065 & Class316.clientOptions.aClass239_Sub7_7238.method1748(-32350) != 0);
            bool_3_ = (bool_3_ & (class51.anInt941 != anInt3056 || (aClass17_3057 != null && Class316.clientOptions.aClass239_Sub7_7238.method1748(-32350) >= 2 && (anInt3084 != anInt3073 || ((aClass17_3057.aBoolean254 || Class28.aBoolean5002) && (anInt3083 != anInt3084))))));
        }
        if (bool && !bool_3_) {
            anInt3053 = class51.anInt941;
            return null;
        }
        if (bool_3_) {
            Class169.method1301(aR3071, aByte3067, (aClass318_Sub1_3051.x), (aClass318_Sub1_3051.y), aBooleanArray3072);
            anInt3056 = -1;
            anInt3073 = -1;
        }
        if (i > -126) return null;
        Ground var_ground = aa_Sub1.aGroundArray5191[aByte3067];
        Ground var_ground_5_;
        if (!aBoolean3069) var_ground_5_ = aByte3067 >= 3 ? null : aa_Sub1.aGroundArray5191[1 + aByte3067];
        else var_ground_5_ = Class348_Sub1_Sub1.aGroundArray8801[0];
        Model model = null;
        if (aClass17_3057 == null) {
            if (aModel_3059 == null || i_4_ != (i_4_ & aModel_3059.ua()) || (anInt3053 != class51.anInt941)) {
                if (aModel_3059 != null) i_4_ |= aModel_3059.ua();
                Class2 class2 = (class51.method476(var_toolkit, var_ground_5_, (this.anInt3079 != 11 ? this.anInt3079 : 10), i_4_, aClass318_Sub1_3051.x, bool_3_, var_ground, var_ground.method3986((aClass318_Sub1_3051.x), (aClass318_Sub1_3051.y), (byte) -114), aClass318_Sub1_3051.y, (this.anInt3079 == 11 ? 4 + this.anInt3052 : this.anInt3052), 128));
                if (class2 == null) {
                    anInt3055 = 0;
                    aBooleanArray3072 = null;
                    aR3071 = null;
                    anInt3060 = 0;
                    aModel_3059 = null;
                } else {
                    aModel_3059 = model = class2.aModel_119;
                    if (bool_3_) {
                        aBooleanArray3072 = null;
                        aR3071 = class2.aR118;
                        Class130.method1130(aR3071, aByte3067, aClass318_Sub1_3051.x, aClass318_Sub1_3051.y, null);
                        anInt3073 = -1;
                        anInt3056 = class51.anInt941;
                    }
                    anInt3060 = model.fa();
                    anInt3055 = model.ma();
                }
            } else model = aModel_3059;
        } else {
            if (bool_3_) i_4_ |= 0x40000;
            model = (class51.method483(anInt3083, anInt3054, (this.anInt3079 == 11 ? 10 : this.anInt3079), var_ground.method3986((aClass318_Sub1_3051.x), (aClass318_Sub1_3051.y), (byte) -2), var_toolkit, (this.anInt3079 == 11 ? this.anInt3052 + 4 : this.anInt3052), i_4_, (byte) 76, var_ground_5_, aClass318_Sub1_3051.y, anInt3084, aClass318_Sub1_3051.x, aClass17_3057, var_ground));
            if (model == null) {
                anInt3055 = 0;
                aBooleanArray3072 = null;
                anInt3060 = 0;
                aR3071 = null;
            } else {
                if (bool_3_) {
                    if (aBooleanArray3072 == null) aBooleanArray3072 = new boolean[4];
                    aR3071 = model.ba(aR3071);
                    Class130.method1130(aR3071, aByte3067, (aClass318_Sub1_3051.x), (aClass318_Sub1_3051.y), aBooleanArray3072);
                    anInt3073 = anInt3084;
                    anInt3056 = class51.anInt941;
                }
                anInt3060 = model.fa();
                anInt3055 = model.ma();
            }
            aModel_3059 = null;
        }
        anInt3053 = class51.anInt941;
        return model;
    }

    static final String method1669(int i, int i_6_) {
        if (i != -19918) method1669(75, 33);
        anInt3066++;
        return ((0xff & i_6_ >> 24) + "." + ((i_6_ & 0xffb428) >> 16) + "." + (i_6_ >> 8 & 0xff) + "." + (i_6_ & 0xff));
    }

    final void method1670(int i, Matrix matrix, int i_7_, Toolkit var_toolkit, int i_8_, Model model, boolean bool, byte i_9_, int i_10_) {
        do {
            try {
                anInt3058++;
                if (i_9_ != -73) this.anInt3052 = 62;
                ModelParticleEmitter[] modelParticleEmitters = model.method619();
                ModelParticleEffector[] modelParticleEffectors = model.method604();
                if ((this.aClass318_Sub10_3081 == null || this.aClass318_Sub10_3081.aBoolean6470) && (modelParticleEmitters != null || modelParticleEffectors != null)) {
                    Class51 class51 = Class348_Sub40_Sub12.objectTypeList.method2005(0, this.anInt3063);
                    if (class51.anIntArray945 != null) class51 = class51.method480((Class318_Sub1_Sub3_Sub3.timedVarDomain), (byte) 47);
                    if (class51 != null) this.aClass318_Sub10_3081 = Class318_Sub10.method2526(Class367_Sub11.anInt7396, true);
                }
                if (this.aClass318_Sub10_3081 == null) break;
                model.method620(matrix);
                if (bool) this.aClass318_Sub10_3081.method2536(var_toolkit, Class367_Sub11.anInt7396, modelParticleEmitters, modelParticleEffectors, false);
                else this.aClass318_Sub10_3081.method2540(Class367_Sub11.anInt7396);
                this.aClass318_Sub10_3081.method2533(aByte3085, i_8_, i, i_10_, i_7_);
            } catch (RuntimeException runtimeexception) {
                throw Class348_Sub17.method2929(runtimeexception, ("bv.E(" + i + ',' + (matrix != null ? "{...}" : "null") + ',' + i_7_ + ',' + (var_toolkit != null ? "{...}" : "null") + ',' + i_8_ + ',' + (model != null ? "{...}" : "null") + ',' + bool + ',' + i_9_ + ',' + i_10_ + ')'));
            }
            break;
        } while (false);
    }

    final void method1671(int i, int i_11_) {
        aBoolean3064 = true;
        anInt3078++;
        method1666((byte) 69, i_11_);
        if (i != 262144) aClass78_3075 = null;
    }

    protected final void finalize() {
        anInt3080++;
        if (this.aClass318_Sub10_3081 != null) this.aClass318_Sub10_3081.method2534();
    }

    private final void method1672(Class318_Sub1 class318_sub1, boolean bool) {
        if (bool != true) method1674(-55, null);
        anInt3086++;
        int i;
        while_76_:
        for (; ; ) {
            if (aClass17_3057 == null) {
                if (aBoolean3064) return;
                method1666((byte) 69, -1);
                if (aClass17_3057 == null) return;
            }
            i = -anInt3074 + Class367_Sub11.anInt7396;
            if (i > 100 && aClass17_3057.anInt238 > 0) {
                int i_12_;
                for (i_12_ = (-aClass17_3057.anInt238 + aClass17_3057.anIntArray237.length); (anInt3084 < i_12_ && (aClass17_3057.anIntArray267[anInt3084] < i)); anInt3084++)
                    i -= aClass17_3057.anIntArray267[anInt3084];
                if (i_12_ <= anInt3084) {
                    int i_13_ = 0;
                    for (int i_14_ = i_12_; (aClass17_3057.anIntArray237.length > i_14_); i_14_++)
                        i_13_ += aClass17_3057.anIntArray267[i_14_];
                    i %= i_13_;
                }
                anInt3083 = 1 + anInt3084;
                if (anInt3083 >= aClass17_3057.anIntArray237.length) {
                    anInt3083 -= aClass17_3057.anInt238;
                    if (anInt3083 < 0 || anInt3083 >= aClass17_3057.anIntArray237.length) anInt3083 = -1;
                }
            }
            for (; ; ) {
                if (aClass17_3057.anIntArray267[anInt3084] >= i) break while_76_;
                Class287.method2178(class318_sub1, anInt3084, aClass17_3057, -99);
                i -= aClass17_3057.anIntArray267[anInt3084];
                anInt3084++;
                if (aClass17_3057.anIntArray237.length <= anInt3084) {
                    anInt3084 -= aClass17_3057.anInt238;
                    if (anInt3084 < 0 || anInt3084 >= aClass17_3057.anIntArray237.length) {
                        aClass17_3057 = null;
                        break;
                    }
                }
                anInt3083 = anInt3084 + 1;
                if (aClass17_3057.anIntArray237.length <= anInt3083) {
                    anInt3083 -= aClass17_3057.anInt238;
                    if (anInt3083 < 0 || (anInt3083 >= aClass17_3057.anIntArray237.length)) anInt3083 = -1;
                }
            }
        }
        anInt3054 = i;
        anInt3074 = -i + Class367_Sub11.anInt7396;
    }

    public static void method1673(int i) {
        aClass78_3075 = null;
        anIntArray3068 = null;
        if (i >= -19) method1669(-110, -13);
    }

    Class235(Toolkit var_toolkit, Class51 class51, int i, int i_15_, int i_16_, int i_17_, Class318_Sub1 class318_sub1, boolean bool, int i_18_) {
        anInt3055 = 0;
        aBoolean3064 = false;
        anInt3053 = -1;
        aBoolean3069 = false;
        anInt3056 = -1;
        anInt3073 = -1;
        try {
            this.anInt3079 = i;
            this.anInt3063 = class51.anInt941;
            aClass318_Sub1_3051 = class318_sub1;
            aByte3085 = (byte) i_16_;
            aByte3067 = (byte) i_17_;
            aBoolean3069 = bool;
            this.anInt3052 = i_15_;
            aBoolean3065 = (var_toolkit.method3682() && class51.aBoolean894 && !aBoolean3069);
            if (i_18_ != -1) aBoolean3064 = true;
            method1666((byte) 69, i_18_);
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("bv.<init>(" + (var_toolkit != null ? "{...}" : "null") + ',' + (class51 != null ? "{...}" : "null") + ',' + i + ',' + i_15_ + ',' + i_16_ + ',' + i_17_ + ',' + (class318_sub1 != null ? "{...}" : "null") + ',' + bool + ',' + i_18_ + ')'));
        }
    }

    final void method1674(int i, Toolkit var_toolkit) {
        if (i != -1) aBoolean3064 = false;
        if (aR3071 != null) {
            Class169.method1301(aR3071, aByte3067, (aClass318_Sub1_3051.x), (aClass318_Sub1_3051.y), aBooleanArray3072);
            aR3071 = null;
            aBooleanArray3072 = null;
        }
        anInt3050++;
    }
}
