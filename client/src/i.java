/* i - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class i extends Model implements Interface19 {
    private final oa anOa5117;
    ModelParticleEffector[] aModelParticleEffectorArray5118;
    long nativeid;
    ModelParticleEmitter[] aModelParticleEmitterArray5119;
    private final ya aYa5120;

    final native void C(int i);

    final native void k(int i);

    public final native void w(boolean bool);

    final native void O(int i, int i_0_, int i_1_);

    final native void s(int i);

    final native void LA(int i);

    final native int fa();

    final native boolean NA();

    final native boolean F();

    final native void ZA(i var_i_2_, i var_i_3_, int i, boolean bool, boolean bool_4_);

    final void method613(Model model, int i, int i_5_, int i_6_, boolean bool) {
        anOa5117.method3973().method144(this, model, i, i_5_, i_6_, bool);
    }

    final native void aa(short i, short i_7_);

    final boolean method623(int i, int i_8_, Class101 class101, boolean bool, int i_9_, int i_10_) {
        return anOa5117.method3973().method143(this, i, i_8_, class101, bool, i_10_);
    }

    final native int EA();

    final ModelParticleEmitter[] method619() {
        return this.aModelParticleEmitterArray5119;
    }

    final native void wa();

    final native void P(int i, int i_11_, int i_12_, int i_13_);

    final void method608(Class101 class101, Class318_Sub3 class318_sub3, int i, int i_14_) {
        if (class318_sub3 == null) anOa5117.method3973().method149(this, class101, null, i, i_14_);
        else {
            oa.anIntArray5132[5] = 0;
            anOa5117.method3973().method149(this, class101, oa.anIntArray5132, i, i_14_);
            class318_sub3.anInt6405 = oa.anIntArray5132[0];
            class318_sub3.anInt6402 = oa.anIntArray5132[1];
            class318_sub3.anInt6406 = oa.anIntArray5132[2];
            class318_sub3.anInt6404 = oa.anIntArray5132[3];
            class318_sub3.anInt6403 = oa.anIntArray5132[4];
            class318_sub3.aBoolean6401 = oa.anIntArray5132[5] != 0;
        }
    }

    final native void v();

    private final native void l(long l, int i, int[] is, int i_15_, int i_16_, int i_17_, int i_18_, boolean bool);

    final boolean method618() {
        return true;
    }

    final void method621() {
        if (anOa5117.anInt5141 > 1) {
            synchronized (this) {
                this.aBoolean1124 = false;
                this.notifyAll();
            }
        }
    }

    final native void VA(int i);

    final boolean method628(int i, int i_19_, Class101 class101, boolean bool, int i_20_) {
        return anOa5117.method3973().method146(this, i, i_19_, class101, bool);
    }

    final Model method614(byte i, int i_21_, boolean bool) {
        return anOa5117.method3973().method152(this, i, i_21_, bool);
    }

    final native int na();

    final native int HA();

    final void method612() {
        /* empty */
    }

    final native void p(int i, int i_22_, s var_s, s var_s_23_, int i_24_, int i_25_, int i_26_);

    final native int V();

    final native int da();

    final void method605(int i, int[] is, int i_27_, int i_28_, int i_29_, int i_30_, boolean bool) {
        l(this.nativeid, i, is, i_27_, i_28_, i_29_, i_30_, bool);
    }

    final native int G();

    final native int ma();

    private final native void R(oa var_oa, ya var_ya, int i, int i_31_, int[] is, int[] is_32_, int[] is_33_, int[] is_34_, short[] is_35_, int i_36_, short[] is_37_, short[] is_38_, short[] is_39_, byte[] is_40_, byte[] is_41_, byte[] is_42_, byte[] is_43_, short[] is_44_, short[] is_45_, int[] is_46_, byte i_47_, short[] is_48_, int i_49_, byte[] is_50_, short[] is_51_, short[] is_52_, short[] is_53_, int[] is_54_, int[] is_55_, int[] is_56_, byte[] is_57_, byte[] is_58_, int[] is_59_, int[] is_60_, int[] is_61_, int[] is_62_, int i_63_, int i_64_, int i_65_, int i_66_, int i_67_, int i_68_, int[] is_69_);

    final native void FA(int i);

    final void method624(int i, int i_70_, int i_71_, int i_72_) {
        /* empty */
    }

    final native void ia(short i, short i_73_);

    protected final void finalize() {
        if (this.nativeid != 0L) Class257.method1947(0, this);
    }

    final native int WA();

    final void method610(Class101 class101, int i, boolean bool) {
        A(((ja) class101).nativeid, i, bool);
    }

    final void method622() {
        if (anOa5117.anInt5141 > 1) {
            synchronized (this) {
                while (this.aBoolean1124) {
                    try {
                        this.wait();
                    } catch (InterruptedException interruptedexception) {
                        /* empty */
                    }
                }
                this.aBoolean1124 = true;
            }
        }
    }

    final void method615(Class101 class101, Class318_Sub3 class318_sub3, int i) {
        if (class318_sub3 == null) anOa5117.method3973().method145(this, class101, null, i);
        else {
            oa.anIntArray5132[5] = 0;
            anOa5117.method3973().method145(this, class101, oa.anIntArray5132, i);
            class318_sub3.anInt6405 = oa.anIntArray5132[0];
            class318_sub3.anInt6402 = oa.anIntArray5132[1];
            class318_sub3.anInt6406 = oa.anIntArray5132[2];
            class318_sub3.anInt6404 = oa.anIntArray5132[3];
            class318_sub3.anInt6403 = oa.anIntArray5132[4];
            class318_sub3.aBoolean6401 = oa.anIntArray5132[5] != 0;
        }
    }

    final native boolean r();

    final void method620(Class101 class101) {
        method693(oa.anIntArray5140, class101);
        int i = 0;
        if (this.aModelParticleEmitterArray5119 != null) {
            for (int i_74_ = 0; i_74_ < this.aModelParticleEmitterArray5119.length; i_74_++) {
                ModelParticleEmitter modelParticleEmitter = this.aModelParticleEmitterArray5119[i_74_];
                modelParticleEmitter.anInt1882 = oa.anIntArray5140[i++];
                modelParticleEmitter.anInt1891 = oa.anIntArray5140[i++];
                modelParticleEmitter.anInt1889 = oa.anIntArray5140[i++];
                modelParticleEmitter.anInt1883 = oa.anIntArray5140[i++];
                modelParticleEmitter.anInt1890 = oa.anIntArray5140[i++];
                modelParticleEmitter.anInt1880 = oa.anIntArray5140[i++];
                modelParticleEmitter.anInt1876 = oa.anIntArray5140[i++];
                modelParticleEmitter.anInt1874 = oa.anIntArray5140[i++];
                modelParticleEmitter.anInt1884 = oa.anIntArray5140[i++];
            }
        }
        if (this.aModelParticleEffectorArray5118 != null) {
            for (int i_75_ = 0; i_75_ < this.aModelParticleEffectorArray5118.length; i_75_++) {
                ModelParticleEffector modelParticleEffector = this.aModelParticleEffectorArray5118[i_75_];
                ModelParticleEffector modelParticleEffector_76_ = modelParticleEffector;
                if (modelParticleEffector.aModelParticleEffector_4248 != null) modelParticleEffector_76_ = modelParticleEffector.aModelParticleEffector_4248;
                if (modelParticleEffector.aClass101_4252 != null) modelParticleEffector.aClass101_4252.method898(class101);
                else modelParticleEffector.aClass101_4252 = class101.method907();
                modelParticleEffector_76_.anInt4238 = oa.anIntArray5140[i++];
                modelParticleEffector_76_.anInt4239 = oa.anIntArray5140[i++];
                modelParticleEffector_76_.anInt4240 = oa.anIntArray5140[i++];
            }
        }
    }

    final native void a(int i);

    final ModelParticleEffector[] method604() {
        return this.aModelParticleEffectorArray5118;
    }

    private final void method693(int[] is, Class101 class101) {
        anOa5117.method3973().method151(this, is, class101);
    }

    final native int ua();

    final native void H(int i, int i_77_, int i_78_);

    i(oa var_oa, ya var_ya, Mesh mesh, int i, int i_79_, int i_80_, int i_81_) {
        anOa5117 = var_oa;
        aYa5120 = var_ya;
        this.aModelParticleEmitterArray5119 = mesh.emitters;
        this.aModelParticleEffectorArray5118 = mesh.effectors;
        int i_82_ = (mesh.emitters == null ? 0 : mesh.emitters.length);
        int i_83_ = (mesh.effectors == null ? 0 : mesh.effectors.length);
        int i_84_ = 0;
        int[] is = new int[i_82_ * 3 + i_83_];
        for (int i_85_ = 0; i_85_ < i_82_; i_85_++) {
            is[i_84_++] = this.aModelParticleEmitterArray5119[i_85_].anInt1881;
            is[i_84_++] = this.aModelParticleEmitterArray5119[i_85_].anInt1877;
            is[i_84_++] = this.aModelParticleEmitterArray5119[i_85_].anInt1892;
        }
        for (int i_86_ = 0; i_86_ < i_83_; i_86_++)
            is[i_84_++] = this.aModelParticleEffectorArray5118[i_86_].anInt4244;
        int i_87_ = (mesh.billboards == null ? 0 : mesh.billboards.length);
        int[] is_88_ = new int[i_87_ * 8];
        int i_89_ = 0;
        for (int i_90_ = 0; i_90_ < i_87_; i_90_++) {
            MeshBillboard meshBillboard = mesh.billboards[i_90_];
            Class189 class189 = Class73.method742(104, meshBillboard.anInt2153);
            is_88_[i_89_++] = meshBillboard.anInt2155;
            is_88_[i_89_++] = class189.anInt2526;
            is_88_[i_89_++] = class189.anInt2530;
            is_88_[i_89_++] = class189.anInt2525;
            is_88_[i_89_++] = class189.anInt2533;
            is_88_[i_89_++] = class189.anInt2534;
            is_88_[i_89_++] = class189.aBoolean2531 ? -1 : 0;
        }
        for (int i_91_ = 0; i_91_ < i_87_; i_91_++) {
            MeshBillboard meshBillboard = mesh.billboards[i_91_];
            is_88_[i_89_++] = meshBillboard.anInt2156;
        }
        R(anOa5117, aYa5120, mesh.vertexCount, mesh.maxVertex, mesh.vertexX, mesh.vertexY, mesh.vertexZ, mesh.vertexLabel, mesh.originalModels, mesh.faceCount, mesh.faceA, mesh.faceB, mesh.faceC, mesh.shadingType, mesh.facePriority, mesh.faceAlpha, mesh.faceTexSpace, mesh.faceColour, mesh.faceTexture, mesh.faceLabel, mesh.globalPriority, mesh.aShortArray1856, mesh.texSpaceCount, mesh.texMappingType, mesh.texSpaceDefA, mesh.texSpaceDefB, mesh.texSpaceDefC, mesh.texSpaceScaleX, mesh.texSpaceScaleY, mesh.texSpaceScaleZ, mesh.texRotation, mesh.rexDirection, mesh.texOffsetX, mesh.texOffsetY, mesh.texOffsetZ, is, i_82_, i_83_, i, i_79_, i_80_, i_81_, is_88_);
    }

    private final native void A(long l, int i, boolean bool);

    final native r ba(r var_r);

    private final native void oa(oa var_oa);

    i(oa var_oa) {
        anOa5117 = var_oa;
        aYa5120 = null;
        oa(var_oa);
    }

    final native int RA();

    final native void I(int i, int[] is, int i_92_, int i_93_, int i_94_, boolean bool, int i_95_, int[] is_96_);
}
