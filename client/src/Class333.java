/* Class333 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class333 {
    static int anInt4144 = -1;
    static int anInt4145;
    private Class356 aClass356_4146;
    static Index aIndex_4147;
    private int anInt4148 = 0;
    static int anInt4149;
    private Node aNode_4150;

    static final void method2643(int i, int i_0_, int i_1_, int i_2_, int i_3_) {
        if (Class342.anIntArrayArray4253 != null) Class342.anIntArrayArray4253[i][i_0_] = ~0xffffff | i_1_;
        if (Option_Sub1.aShortArrayArray5847 != null) Option_Sub1.aShortArrayArray5847[i][i_0_] = (short) i_2_;
        if (Class348_Sub1_Sub2.aByteArrayArray8816 != null) Class348_Sub1_Sub2.aByteArrayArray8816[i][i_0_] = (byte) i_3_;
    }

    final Node method2644(byte i) {
        anInt4148 = 0;
        if (i != 123) method2643(-115, 5, -49, 81, 25);
        anInt4145++;
        return method2646((byte) 117);
    }

    public static void method2645(int i) {
        if (i != -16777216) method2643(-59, 61, -83, 34, -32);
        aIndex_4147 = null;
    }

    final Node method2646(byte i) {
        anInt4149++;
        int i_4_ = -49 / ((i - 44) / 40);
        if (anInt4148 > 0 && (aClass356_4146.aNodeArray4374[-1 + anInt4148] != aNode_4150)) {
            Node node = aNode_4150;
            aNode_4150 = node.aNode_4294;
            return node;
        }
        while (aClass356_4146.anInt4377 > anInt4148) {
            Node node = (aClass356_4146.aNodeArray4374[anInt4148++].aNode_4294);
            if (aClass356_4146.aNodeArray4374[anInt4148 + -1] != node) {
                aNode_4150 = node.aNode_4294;
                return node;
            }
        }
        return null;
    }

    public Class333() {
        /* empty */
    }

    Class333(Class356 class356) {
        aClass356_4146 = class356;
    }
}
