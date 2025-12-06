/* Class73 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class73 implements Interface7 {
    static float[] aFloatArray4772;
    static int anInt4773;
    static int anInt4774;
    static int anInt4775;
    static int anInt4776;
    static int anInt4777;
    private final String aString4778;
    static Class114 aClass114_4779;
    static int[] anIntArray4780;
    static int anInt4781;
    static HitmarkTypeList hitmarkTypeList; // aClass219_4782
    static long aLong4783 = 20000000L;
    static int anInt4784;
    private final Index aIndex_4785;
    static int anInt4786;

    public static void method741(byte i) {
        aFloatArray4772 = null;
        anIntArray4780 = null;
        if (i != -128) method743(113, -98);
        aClass114_4779 = null;
        hitmarkTypeList = null;
    }

    static final BillboardType billboardTypeList(int i, int i_0_) {
        anInt4777++;
        BillboardType billboardType = (BillboardType) VarPlayerTypeListClient.aClass60_2844.method583(i_0_, -104);
        if (billboardType != null) return billboardType;
        byte[] is = Class369_Sub3.aIndex_8601.method410(-1860, 0, i_0_);
        if (i != 104) method741((byte) 98);
        billboardType = new BillboardType();
        if (is != null) billboardType.method1419(i_0_, new Packet(is), (byte) 64);
        VarPlayerTypeListClient.aClass60_2844.method582(billboardType, i_0_, (byte) -114);
        return billboardType;
    }

    public final int method31(int i) {
        int i_1_ = -62 / ((i - -43) / 62);
        anInt4774++;
        if (aIndex_4785.method416((byte) -74, aString4778)) return 100;
        return 0;
    }

    static final void method743(int i, int i_2_) {
        anInt4775++;
        Class348_Sub42_Sub15 class348_sub42_sub15 = Class318_Sub9_Sub1.method2516(i_2_, (byte) 105, i);//9
        class348_sub42_sub15.method3251(i ^ ~0x3eb0);
    }

    public final Class69 method32(int i) {
        anInt4781++;
        if (i != -15004) aFloatArray4772 = null;
        return Class69.aClass69_1197;
    }

    Class73(Index index, String string) {
        try {
            aIndex_4785 = index;
            aString4778 = string;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("kk.<init>(" + (index != null ? "{...}" : "null") + ',' + (string != null ? "{...}" : "null") + ')'));
        }
    }

    static {
        anInt4776 = 0;
        aFloatArray4772 = new float[16];
        anIntArray4780 = new int[]{104, 120, 136, 168};
        aClass114_4779 = new Class114(76, 6);
    }
}
