/* Class348_Sub42_Sub20 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class348_Sub42_Sub20 extends LinkedNode {
    ModelParticleEffector aModelParticleEffector_9702;
    static int anInt9703;
    Class174 aClass174_9704;
    int anInt9705;
    int anInt9706;
    int anInt9707;
    static int anInt9708;
    static int anInt9709;
    int anInt9710;
    static Deque aDeque_9711 = new Deque();
    int anInt9712;
    static int anInt9713;
    static int[] anIntArray9714 = {1, 2, 4, 8};
    static int anInt9715;

    final void method3279(int i) {
        this.anInt9706 = (this.aModelParticleEffector_9702.anInt4239);
        anInt9708++;
        this.anInt9710 = (this.aModelParticleEffector_9702.anInt4240);
        this.anInt9712 = (this.aModelParticleEffector_9702.anInt4238);
        if ((this.aModelParticleEffector_9702.aMatrix_4252) != null) this.aModelParticleEffector_9702.aMatrix_4252.method905((this.aClass174_9704.anInt2291), (this.aClass174_9704.anInt2290), (this.aClass174_9704.anInt2294), Class348_Sub8.anIntArray6666);
        this.anInt9705 = Class348_Sub8.anIntArray6666[0];
        this.anInt9707 = Class348_Sub8.anIntArray6666[i];
    }

    public static void method3280(int i) {
        aDeque_9711 = null;
        anIntArray9714 = null;
        int i_0_ = 112 / ((i - 16) / 57);
    }

    static final void method3281(byte i, Toolkit var_toolkit) {
        if (Class5_Sub1.aBoolean8335) Class303.method2288(false, var_toolkit);
        else Class119_Sub1.method1077(var_toolkit, (byte) -123);
        anInt9709++;
        if (i < 29) method3280(81);
    }

    static final void method3282(int i, int i_1_, int i_2_, int i_3_, int i_4_, int i_5_, int i_6_) {
        ClientOptions.anInt7244 = i_6_;
        Class14_Sub4.anInt8633 = i_5_;
        Class59_Sub2_Sub1.anInt8668 = i_2_;
        Class348_Sub44.anInt7092 = i;
        Class281.anInt3650 = i_4_;
        Class43.anInt620 = i_1_;
        if (i_3_ != 0) method3281((byte) 92, null);
        anInt9703++;
    }

    Class348_Sub42_Sub20(ModelParticleEffector modelParticleEffector, Class318_Sub10 class318_sub10) {
        try {
            this.aModelParticleEffector_9702 = modelParticleEffector;
            this.aClass174_9704 = this.aModelParticleEffector_9702.method2685((byte) -13);
            method3279(2);
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("jo.<init>(" + (modelParticleEffector != null ? "{...}" : "null") + ',' + (class318_sub10 != null ? "{...}" : "null") + ')'));
        }
    }

    static final void method3283(int i) {
        if (Class348_Sub23_Sub1.aClass297_8992.aBoolean3777 && (aa_Sub2.aClass161_5199.anInt2143 != -1)) Class348_Sub23_Sub1.method2972((aa_Sub2.aClass161_5199.aString2147), (aa_Sub2.aClass161_5199.anInt2143), -54);
        anInt9713++;
        int i_7_ = 9 / ((i - 60) / 50);
    }
}
