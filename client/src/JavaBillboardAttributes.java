/* Class350 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class JavaBillboardAttributes {
    int anInt4307;
    int anInt4308;
    int anInt4309;
    int anInt4310;
    int anInt4311 = 128;
    int anInt4312;
    int anInt4313;
    int anInt4314 = 128;
    static int anInt4315;
    int anInt4316;
    int anInt4317;
    static int anInt4318;
    static int anInt4319;
    int anInt4320;
    static int anInt4321;

    static final int method3452(int i, byte i_0_, int i_1_) {
        if (i_0_ != -15) method3452(80, (byte) 123, -88);
        anInt4315++;
        int i_2_ = i_1_ + -1 & i >> 31;
        return (i + (i >>> 31)) % i_1_ + i_2_;
    }

    final JavaBillboardAttributes method3453(boolean bool) {
        anInt4318++;
        if (bool != true) method3453(false);
        return new JavaBillboardAttributes(this.anInt4313, this.anInt4314, this.anInt4311, this.anInt4316, this.anInt4317, this.anInt4308);
    }

    final void method3454(JavaBillboardAttributes javaBillboardAttributes_3_, boolean bool) {
        this.anInt4308 = javaBillboardAttributes_3_.anInt4308;
        this.anInt4314 = javaBillboardAttributes_3_.anInt4314;
        if (bool == true) {
            this.anInt4316 = javaBillboardAttributes_3_.anInt4316;
            this.anInt4317 = javaBillboardAttributes_3_.anInt4317;
            anInt4321++;
            this.anInt4313 = javaBillboardAttributes_3_.anInt4313;
            this.anInt4311 = javaBillboardAttributes_3_.anInt4311;
        }
    }

    // Class350
    JavaBillboardAttributes(int i) {
        this.anInt4313 = i;
    }

    private JavaBillboardAttributes(int i, int i_4_, int i_5_, int i_6_, int i_7_, int i_8_) {
        this.anInt4317 = i_7_;
        this.anInt4313 = i;
        this.anInt4316 = i_6_;
        this.anInt4311 = i_5_;
        this.anInt4308 = i_8_;
        this.anInt4314 = i_4_;
    }
}
