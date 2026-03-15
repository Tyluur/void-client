/* Class371 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class371 {
    int anInt4520;
    static int anInt4521;
    int anInt4522;
    static int anInt4523;
    int anInt4524;
    int anInt4525;

    static final Class258_Sub3_Sub1 method3583(boolean bool, byte[] is, int i, int i_0_, OpenGLToolkit var_openGLToolkit, int i_1_, int i_2_, int i_3_) {
        try {
            anInt4521++;
            if (i_1_ > -17) return null;
            if (var_openGLToolkit.aBoolean7793 || Class192.method1436(-58, i_3_) && Class192.method1436(-68, i_0_)) return new Class258_Sub3_Sub1(var_openGLToolkit, 3553, i_2_, i_3_, i_0_, bool, is, i);
            if (var_openGLToolkit.aBoolean7837) return new Class258_Sub3_Sub1(var_openGLToolkit, 34037, i_2_, i_3_, i_0_, bool, is, i);
            return new Class258_Sub3_Sub1(var_openGLToolkit, i_2_, i_3_, i_0_, EnumTypeList.method340(i_3_, (byte) 108), EnumTypeList.method340(i_0_, (byte) 108), is, i);
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("fr.B(" + bool + ',' + (is != null ? "{...}" : "null") + ',' + i + ',' + i_0_ + ',' + (var_openGLToolkit != null ? "{...}" : "null") + ',' + i_1_ + ',' + i_2_ + ',' + i_3_ + ')'));
        }
    }

    static final boolean isPress(int i, int i_4_) {
        if (i_4_ != 1) return false;
        anInt4523++;
        return i == 0 || i == 1 || i == 2;
    }

    public Class371() {
        /* empty */
    }
}
