/* Class348_Sub42_Sub16_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class348_Sub42_Sub16_Sub2 extends Class348_Sub42_Sub16 {
    int anInt10457;
    Class137 aClass137_10458;
    static int anInt10459;
    static int anInt10460;
    byte[] aByteArray10461;
    static int anInt10462;
    static int anInt10463 = 0;
    static int anInt10464;
    static Class356 aClass356_10465 = new Class356(16);

    static final boolean method3263(boolean bool) {
        if (bool != true) return false;
        anInt10459++;
        return Class351.aBoolean4328;
    }

    public static void method3264(byte i) {
        aClass356_10465 = null;
        if (i != -24) method3265(-70, null, null);
    }

    final int method3257(int i) {
        anInt10460++;
        if (i != 16) this.aClass137_10458 = null;
        if (this.aBoolean9664) return 0;
        return 100;
    }

    static final void method3265(int i, Node node, Node node_0_) {
        try {
            if (node.aNode_4295 != null) node.unlink((byte) 27);
            int i_1_ = -109 % ((6 - i) / 43);
            anInt10462++;
            node.aNode_4295 = node_0_.aNode_4295;
            node.aNode_4294 = node_0_;
            node.aNode_4295.aNode_4294 = node;
            node.aNode_4294.aNode_4295 = node;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("qh.K(" + i + ',' + (node != null ? "{...}" : "null") + ',' + (node_0_ != null ? "{...}" : "null") + ')'));
        }
    }

    final byte[] method3259(int i) {
        anInt10464++;
        if (i != 16) method3259(8);
        if (this.aBoolean9664) throw new RuntimeException();
        return this.aByteArray10461;
    }

    public Class348_Sub42_Sub16_Sub2() {
        /* empty */
    }
}
