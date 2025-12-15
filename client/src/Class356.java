/* Class356 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class356 {
    Node[] aNodeArray4374;
    static int anInt4375;
    static int anInt4376;
    int anInt4377;
    static int anInt4378;
    static int anInt4379;
    static int anInt4380;
    static int anInt4381;
    static int anInt4382;
    public static int anInt4383;
    static int anInt4384;
    private long aLong4385;
    static int anInt4386;
    static int anInt4387;
    static Class114 aClass114_4388 = new Class114(3, 3);
    private Node aNode_4389;
    private Node aNode_4390;
    private int anInt4391 = 0;

    final int method3474(int i) {
        if (i != 1) method3479(20);
        anInt4387++;
        int i_0_ = 0;
        for (int i_1_ = 0; this.anInt4377 > i_1_; i_1_++) {
            Node node = this.aNodeArray4374[i_1_];
            for (Node node_2_ = node.aNode_4294; node != node_2_; node_2_ = node_2_.aNode_4294)
                i_0_++;
        }
        return i_0_;
    }

    final int method3475(boolean bool) {
        anInt4376++;
        if (bool != true) method3478(false);
        return this.anInt4377;
    }

    final Node method3476(boolean bool) {
        anInt4384++;
        if (aNode_4389 == null) return null;
        Node node = (this.aNodeArray4374[(int) ((long) (this.anInt4377 - 1) & aLong4385)]);
        if (bool != true) method3479(4);
        for (/**/; aNode_4389 != node; aNode_4389 = aNode_4389.aNode_4294) {
            if (aNode_4389.aLong4291 == aLong4385) {
                Node node_3_ = aNode_4389;
                aNode_4389 = aNode_4389.aNode_4294;
                return node_3_;
            }
        }
        aNode_4389 = null;
        return null;
    }

    final int method3477(int i, Node[] nodes) {
        if (i != 3) anInt4383 = -76;
        anInt4380++;
        int i_4_ = 0;
        for (int i_5_ = 0; this.anInt4377 > i_5_; i_5_++) {
            Node node = this.aNodeArray4374[i_5_];
            for (Node node_6_ = node.aNode_4294; node != node_6_; node_6_ = node_6_.aNode_4294)
                nodes[i_4_++] = node_6_;
        }
        return i_4_;
    }

    public static void method3478(boolean bool) {
        aClass114_4388 = null;
        if (bool != false) anInt4383 = 67;
    }

    static final Class348_Sub21 method3479(int i) {
        anInt4378++;
        if (i != -1) anInt4383 = 43;
        if (Class75.aDeque_1254 == null || r.aClass312_9716 == null) return null;
        for (Class348_Sub21 class348_sub21 = (Class348_Sub21) r.aClass312_9716.method2329(10); class348_sub21 != null; class348_sub21 = (Class348_Sub21) r.aClass312_9716.method2329(i ^ ~0xa)) {
            Class42 class42 = Class75.aMapElementTypeList_1238.method1225(class348_sub21.anInt6847, (byte) 92);
            if (class42 != null && class42.aBoolean609 && class42.method373(Class75.anInterface17_1244, 127)) return class348_sub21;
        }
        return null;
    }

    final Node method3480(long l, int i) {
        try {
            aLong4385 = l;
            anInt4379++;
            Node node = (this.aNodeArray4374[(int) (l & (long) (this.anInt4377 + -1))]);
            if (i != -6008) method3484(80);
            for (aNode_4389 = node.aNode_4294; aNode_4389 != node; aNode_4389 = aNode_4389.aNode_4294) {
                if (l == aNode_4389.aLong4291) {
                    Node node_7_ = aNode_4389;
                    aNode_4389 = aNode_4389.aNode_4294;
                    return node_7_;
                }
            }
            aNode_4389 = null;
            return null;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, "eq.C(" + l + ',' + i + ')');
        }
    }

    final void method3481(int i) {
        anInt4375++;
        for (int i_8_ = i; this.anInt4377 > i_8_; i_8_++) {
            Node node = this.aNodeArray4374[i_8_];
            for (; ; ) {
                Node node_9_ = node.aNode_4294;
                if (node_9_ == node) break;
                node_9_.method2715((byte) 54);
            }
        }
        aNode_4389 = null;
        aNode_4390 = null;
    }

    final Node method3482(int i) {
        anInt4381++;
        if (anInt4391 > i && (aNode_4390 != this.aNodeArray4374[-1 + anInt4391])) {
            Node node = aNode_4390;
            aNode_4390 = node.aNode_4294;
            return node;
        }
        while (this.anInt4377 > anInt4391) {
            Node node = (this.aNodeArray4374[anInt4391++].aNode_4294);
            if (this.aNodeArray4374[-1 + anInt4391] != node) {
                aNode_4390 = node.aNode_4294;
                return node;
            }
        }
        return null;
    }

    final void method3483(byte i, long l, Node node) {
        try {
            anInt4382++;
            if (i < 18) method3481(71);
            if (node.aNode_4295 != null) node.method2715((byte) 57);
            Node node_10_ = (this.aNodeArray4374[(int) (l & (long) (-1 + this.anInt4377))]);
            node.aNode_4294 = node_10_;
            node.aNode_4295 = node_10_.aNode_4295;
            node.aNode_4295.aNode_4294 = node;
            node.aNode_4294.aNode_4295 = node;
            node.aLong4291 = l;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("eq.K(" + i + ',' + l + ',' + (node != null ? "{...}" : "null") + ')'));
        }
    }

    final Node method3484(int i) {
        anInt4391 = i;
        anInt4386++;
        return method3482(0);
    }

    Class356(int i) {
        this.anInt4377 = i;
        this.aNodeArray4374 = new Node[i];
        for (int i_11_ = 0; i > i_11_; i_11_++) {
            Node node = this.aNodeArray4374[i_11_] = new Node();
            node.aNode_4294 = node;
            node.aNode_4295 = node;
        }
    }
}
