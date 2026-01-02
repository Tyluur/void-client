/* Class348_Sub42_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import jaggl.OpenGL;

final class Class348_Sub42_Sub2 extends LinkedNode implements Interface9 {
    static int anInt8561;
    private int anInt8562 = -1;
    private int anInt8563 = -1;
    private final OpenGLToolkit aOpenGLToolkit_8564;
    int anInt8565;
    static int anInt8566;
    private final int anInt8567;
    static int anInt8568;
    private int anInt8569;
    static int anInt8570;
    private final int anInt8571;
    int anInt8572;
    static long aLong8573 = 0L;

    protected final void finalize() throws Throwable {
        anInt8570++;
        method3172(4);
        super.finalize();
    }

    static final void method3171(Toolkit var_toolkit, int i, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_, boolean bool, boolean bool_5_) {
        Class9.aToolkit171 = var_toolkit;
        Npc.anInt10503 = i;
        TextureOpVoronoiNoise.aBoolean9121 = (Npc.anInt10503 > 1 && Class9.aToolkit171.method3708());
        Class362.anInt4459 = i_0_;
        Class270.anInt3465 = 1 << Class362.anInt4459;
        Class348_Sub23_Sub2.anInt9037 = Class270.anInt3465 >> 1;
        Math.sqrt((Class348_Sub23_Sub2.anInt9037 * Class348_Sub23_Sub2.anInt9037) + (Class348_Sub23_Sub2.anInt9037 * Class348_Sub23_Sub2.anInt9037));
        BillboardType.anInt2524 = i_1_;
        Class318_Sub7.anInt6451 = i_2_;
        Class348_Sub41.anInt7054 = i_3_;
        Class318_Sub1_Sub4_Sub1.anInt10084 = i_4_;
        Class50_Sub4.aClass47_5262 = Class348_Sub16_Sub1.method2826(15);
        Class348_Sub45.method3309(-124);
        StructTypeList.aClass357ArrayArrayArray1148 = (new Class357[i_1_][Class318_Sub7.anInt6451]
                [Class348_Sub41.anInt7054]);
        Class348_Sub1_Sub1.aGroundArray8801 = new Ground[i_1_];
        if (bool) {
            ModelParticleEffector.anIntArrayArray4253 = new int[Class318_Sub7.anInt6451][Class348_Sub41.anInt7054];
            Class348_Sub1_Sub2.aByteArrayArray8816 = new byte[Class318_Sub7.anInt6451][Class348_Sub41.anInt7054];
            Option_Sub1.aShortArrayArray5847 = new short[Class318_Sub7.anInt6451][Class348_Sub41.anInt7054];
            Class348_Sub31_Sub2.aClass357ArrayArrayArray9082 = (new Class357[1][Class318_Sub7.anInt6451]
                    [Class348_Sub41.anInt7054]);
            Class332.aGroundArray4142 = new Ground[1];
        } else {
            ModelParticleEffector.anIntArrayArray4253 = null;
            Class348_Sub1_Sub2.aByteArrayArray8816 = null;
            Option_Sub1.aShortArrayArray5847 = null;
            Class348_Sub31_Sub2.aClass357ArrayArrayArray9082 = null;
            Class332.aGroundArray4142 = null;
        }
        if (bool_5_) {
            Class348_Sub42_Sub8_Sub2.aLongArrayArrayArray10431 = new long[i_1_][i_2_][i_3_];
            Option_Sub14.aClass211Array5993 = new Class211[65535];
            r.aBooleanArray9718 = new boolean[65535];
            Class331.anInt4135 = 0;
        } else {
            Class348_Sub42_Sub8_Sub2.aLongArrayArrayArray10431 = null;
            Option_Sub14.aClass211Array5993 = null;
            r.aBooleanArray9718 = null;
            Class331.anInt4135 = 0;
        }
        Class243.method1879(false);
        Node.aClass318_Sub1Array4293 = new Class318_Sub1[2];
        Class250.aClass318_Sub1Array3226 = new Class318_Sub1[2];
        Class115.aClass318_Sub1Array1754 = new Class318_Sub1[2];
        Option_Sub21.aClass318_Sub1Array6066 = new Class318_Sub1[10000];
        Class5_Sub1_Sub1.anInt9930 = 0;
        Class291.aClass318_Sub1Array3737 = new Class318_Sub1[5000];
        ByteArraySecondaryNode.anInt9504 = 0;
        Class24.aClass318_Sub1_Sub3Array357 = new Class318_Sub1_Sub3[5000];
        Class86.anInt1477 = 0;
        Class99.aBooleanArrayArray1572 = (new boolean
                [(Class318_Sub1_Sub4_Sub1.anInt10084 + Class318_Sub1_Sub4_Sub1.anInt10084 + 1)]
                [(Class318_Sub1_Sub4_Sub1.anInt10084 + Class318_Sub1_Sub4_Sub1.anInt10084 + 1)]);
        Class348_Sub8.aBooleanArrayArray6656 = (new boolean
                [(Class318_Sub1_Sub4_Sub1.anInt10084 + Class318_Sub1_Sub4_Sub1.anInt10084 + 2)]
                [(Class318_Sub1_Sub4_Sub1.anInt10084 + Class318_Sub1_Sub4_Sub1.anInt10084 + 2)]);
        Class171.anIntArray2272 = new int[(Class318_Sub1_Sub4_Sub1.anInt10084 + Class318_Sub1_Sub4_Sub1.anInt10084 + 2)];
        Class71.aClass76_1208 = Class71.aClass76_1210;
        if (TextureOpVoronoiNoise.aBoolean9121) {
            Class115.aBooleanArrayArrayArray1751 = (new boolean[i_1_]
                    [(Class318_Sub1_Sub4_Sub1.anInt10084 + Class318_Sub1_Sub4_Sub1.anInt10084 + 1)]
                    [(Class318_Sub1_Sub4_Sub1.anInt10084 + Class318_Sub1_Sub4_Sub1.anInt10084 + 1)]);
            Class5_Sub2.aBooleanArrayArrayArray8361 = new boolean[i_1_][][];
            if (TextureOpColourEdgeDetector.aClass293Array9432 != null) Class260.method1978();
            TextureOpColourEdgeDetector.aClass293Array9432 = new Class293[Npc.anInt10503];
            Class9.aToolkit171.allocateThreads((TextureOpColourEdgeDetector.aClass293Array9432).length + 1);
            Class9.aToolkit171.method3659(0);
            for (int i_6_ = 0; i_6_ < TextureOpColourEdgeDetector.aClass293Array9432.length; i_6_++) {
                TextureOpColourEdgeDetector.aClass293Array9432[i_6_] = new Class293(i_6_ + 1, Class9.aToolkit171);
                new Thread(TextureOpColourEdgeDetector.aClass293Array9432[i_6_], "wr" + i_6_).start();
            }
            int i_7_;
            if (Npc.anInt10503 == 2) {
                i_7_ = 4;
                Class75_Sub1.anInt5652 = 2;
            } else if (Npc.anInt10503 == 3) {
                i_7_ = 6;
                Class75_Sub1.anInt5652 = 3;
            } else {
                i_7_ = 8;
                Class75_Sub1.anInt5652 = 4;
            }
            GfxTypeList.aClass315Array3982 = new Class315[i_7_];
            for (int i_8_ = 0; i_8_ < i_7_; i_8_++)
                GfxTypeList.aClass315Array3982[i_8_] = new Class315(Option_Sub24.aStringArrayArray6093[(Npc.anInt10503 - 2)][i_8_]);
        } else Class75_Sub1.anInt5652 = 1;
        AnimationType.anIntArray256 = new int[Class75_Sub1.anInt5652 - 1];
        Class345.anIntArray4271 = new int[Class75_Sub1.anInt5652 - 1];
    }

    final void method3172(int i) {
        anInt8566++;
        if (anInt8569 > 0) {
            aOpenGLToolkit_8564.method3810(anInt8569, anInt8571, -101);
            anInt8569 = 0;
        }
        if (i != 4) method3171(null, 57, 49, -22, 43, -43, -45, true, true);
    }

    final void method3173(int i, int i_9_, int i_10_) {
        OpenGL.glFramebufferRenderbufferEXT(i_10_, i_9_, i, anInt8569);
        anInt8568++;
        anInt8562 = i_10_;
        anInt8563 = i_9_;
    }

    public final void method37(int i) {
        anInt8561++;
        if (i != -3022) this.anInt8572 = 15;
        OpenGL.glFramebufferRenderbufferEXT(anInt8562, anInt8563, 36161, 0);
        anInt8562 = -1;
        anInt8563 = -1;
    }

    Class348_Sub42_Sub2(OpenGLToolkit var_openGLToolkit, int i, int i_11_, int i_12_) {
        try {
            this.anInt8572 = i_11_;
            aOpenGLToolkit_8564 = var_openGLToolkit;
            this.anInt8565 = i_12_;
            anInt8567 = i;
            OpenGL.glGenRenderbuffersEXT(1, TextureOpColourEdgeDetector.anIntArray9431, 0);
            anInt8569 = TextureOpColourEdgeDetector.anIntArray9431[0];
            OpenGL.glBindRenderbufferEXT(36161, anInt8569);
            OpenGL.glRenderbufferStorageEXT(36161, anInt8567, (this.anInt8572), (this.anInt8565));
            anInt8571 = (this.anInt8565 * this.anInt8572 * aOpenGLToolkit_8564.method3798(anInt8567, 2));
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("kw.<init>(" + (var_openGLToolkit != null ? "{...}" : "null") + ',' + i + ',' + i_11_ + ',' + i_12_ + ')'));
        }
    }

    Class348_Sub42_Sub2(OpenGLToolkit var_openGLToolkit, int i, int i_13_, int i_14_, int i_15_) {
        try {
            this.anInt8572 = i_13_;
            anInt8567 = i;
            this.anInt8565 = i_14_;
            aOpenGLToolkit_8564 = var_openGLToolkit;
            OpenGL.glGenRenderbuffersEXT(1, TextureOpColourEdgeDetector.anIntArray9431, 0);
            anInt8569 = TextureOpColourEdgeDetector.anIntArray9431[0];
            OpenGL.glBindRenderbufferEXT(36161, anInt8569);
            OpenGL.glRenderbufferStorageMultisampleEXT(36161, i_15_, anInt8567, this.anInt8572, this.anInt8565);
            anInt8571 = (this.anInt8565 * this.anInt8572 * aOpenGLToolkit_8564.method3798(anInt8567, 2));
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("kw.<init>(" + (var_openGLToolkit != null ? "{...}" : "null") + ',' + i + ',' + i_13_ + ',' + i_14_ + ',' + i_15_ + ')'));
        }
    }
}
