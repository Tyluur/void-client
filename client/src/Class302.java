/* Class302 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class302 {
    int anInt3831;
    int anInt3832;
    int anInt3833;
    int anInt3834 = -1;
    int anInt3835;
    static int anInt3836;
    int anInt3837;
    int anInt3838;
    int anInt3839;
    int anInt3840;
    static int anInt3841;

    static final void method2283(boolean bool, int i, int i_0_, int i_1_, boolean bool_2_) {
        Class103.method950(i_0_, 0, Class65.aClass110_Sub1Array1146.length + -1, bool, (byte) 56, i_1_, bool_2_);
        anInt3836++;
        Class215.anInt2834 = i;
        Class176.aClass348_Sub26_2332 = null;
    }

    static final void method2284(byte i, long l) {
        try {
            anInt3841++;
            if (Class147.aClass357ArrayArrayArray2029 != null) {
                if (Class348_Sub40_Sub21.anInt9282 != 1 && Class348_Sub40_Sub21.anInt9282 != 5) {
                    if (Class348_Sub40_Sub21.anInt9282 == 4) DebugConsole.updateCamera((byte) 125, l);
                } else GameCanvas.method119(-1, l);
            }
            Class348_Sub47.method3324(Class348_Sub8.aHa6654, (byte) 83, Class367_Sub11.anInt7396);
            if (r.anInt9721 != -1) Class75_Sub1.method769(r.anInt9721, (byte) 118);
            for (int i_3_ = 0; i_3_ < Class348_Sub38.anInt7008; i_3_++) {
                if (Class152.aBooleanArray2076[i_3_]) Class268.aBooleanArray3438[i_3_] = true;
                Class175.aBooleanArray2326[i_3_] = Class152.aBooleanArray2076[i_3_];
                Class152.aBooleanArray2076[i_3_] = false;
            }
            Class58.anInt1064 = Class367_Sub11.anInt7396;
            Class5_Sub2.method198(null, false, -1, -1);
            Class175.method1343(-1, null, 1, -1);
            if (r.anInt9721 != -1) {
                Class348_Sub38.anInt7008 = 0;
                Class88.method842(false);
            }
            Class348_Sub8.aHa6654.la();
            Class348_Sub42_Sub20.method3281((byte) 46, Class348_Sub8.aHa6654);
            int i_4_ = Class112.method1053(3112);
            if (i_4_ == -1) i_4_ = Class362.anInt4458;
            if (i_4_ == -1) i_4_ = Class348_Sub42_Sub16_Sub1.anInt10447;
            Class33.method338(0, i_4_);
            if (i == -43) {
                int i_5_ = (Class132.aPlayer_1907.method2436((byte) 103) << 8);
                Class335.method2655(98, Class132.aPlayer_1907.plane, Class348_Sub51.anInt7267, i_5_ + (Class132.aPlayer_1907.y), (Class132.aPlayer_1907.x - -i_5_));
                Class348_Sub51.anInt7267 = 0;
            }
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, "wo.B(" + i + ',' + l + ')');
        }
    }

    public Class302() {
        /* empty */
    }
}
