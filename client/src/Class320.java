/* Class320 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class320 {
    static short aShort3992 = 320;
    static int anInt3993;
    static float aFloat3994;

    static final boolean method2547(int i, byte i_0_) {
        anInt3993++;
        if (Class163.aBooleanArray2162[i]) return true;
        if (!Class229.aIndex_2978.requestGroup((byte) -124, i)) return false;
        int i_1_ = Class229.aIndex_2978.fileLimit(0, i);
        if (i_1_ == 0) {
            Class163.aBooleanArray2162[i] = true;
            return true;
        }
        if (TextureOpKaleidoscope.aClass46ArrayArray9427[i] == null) TextureOpKaleidoscope.aClass46ArrayArray9427[i] = new Class46[i_1_];
        for (int i_2_ = 0; i_1_ > i_2_; i_2_++) {
            if (TextureOpKaleidoscope.aClass46ArrayArray9427[i][i_2_] == null) {
                byte[] is = Class229.aIndex_2978.file(i_0_ ^ ~0x717, i, i_2_);
                if (is != null) {
                    Class46 class46 = (TextureOpKaleidoscope.aClass46ArrayArray9427[i][i_2_] = new Class46());
                    class46.anInt830 = i_2_ + (i << 16);
                    if (is[0] != -1) throw new IllegalStateException("if1");
                    class46.method433(new Packet(is), true);
                }
            }
        }
        if (i_0_ != 84) aFloat3994 = -0.8522395F;
        Class163.aBooleanArray2162[i] = true;
        return true;
    }
}
