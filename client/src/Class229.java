/* Class229 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class229 {
    static int anInt2976;
    static int anInt2977;
    static Index aIndex_2978;
    static FloorOverlayTypeList floorOverlayTypeList; // aClass268_2979
    static int anInt2980;
    static VarBitTypeListClient varBitTypeList; // aClass194_2981

    static final Class241 method1631(boolean bool) {
        anInt2980++;
        if (bool != false) varBitTypeList = null;
        try {
            return new Class241_Sub2();
        } catch (Throwable throwable) {
            try {
                return new Class241_Sub3();
            } catch (Throwable throwable_0_) {
                return new Class241_Sub1();
            }
        }
    }

    public static void method1632(int i) {
        aIndex_2978 = null;
        int i_1_ = -20 / ((-87 - i) / 34);
        varBitTypeList = null;
        floorOverlayTypeList = null;
    }

    public Class229() {
        /* empty */
    }

    static final boolean method1633(boolean bool, int i, int i_2_) {
        if (bool != false) method1633(false, 85, -80);
        anInt2977++;
        return (0x400 & i) != 0;
    }
}
