/* Class367_Sub6 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import jagdx.IDirect3DDevice;
import jagdx.IDirect3DVertexShader;

final class Class367_Sub6 extends Class367 {
    private static final float[] aFloatArray7338 = new float[16];
    private Class269 aClass269_7339;
    private DirectXToolkit aDirectXToolkit_7340;
    private final IDirect3DVertexShader anIDirect3DVertexShader7341;

    final void method3527(int i, Interface18 interface18, int i_0_) {
        if (i_0_ != -16776) method3526(30, 118, -114);
    }

    final void method3521(boolean bool, byte i) {
        this.aNativeToolkit_4479.method3874(Class348_Sub23_Sub2.aClass229_9011, 127, Class248.aClass229_3196);
        if (i != -103) method3524(55);
    }

    final void method3526(int i, int i_1_, int i_2_) {
        IDirect3DDevice idirect3ddevice = aDirectXToolkit_7340.anIDirect3DDevice9810;
        if (aClass269_7339.aBoolean3458) {
            float f = ((float) ((this.aNativeToolkit_4479.anInt8146) % 4000) / 4000.0F);
            this.aNativeToolkit_4479.method3850((byte) -52, aClass269_7339.anInterface18_Impl1_3452);
            idirect3ddevice.a(11, f, 0.0F, 0.0F, 0.0F);
        } else {
            int i_3_ = 16 * ((this.aNativeToolkit_4479.anInt8146) % 4000) / 4000;
            this.aNativeToolkit_4479.method3850((byte) 122, (aClass269_7339.anInterface18_Impl3Array3459[i_3_]));
            idirect3ddevice.a(11, 0.0F, 0.0F, 0.0F, 0.0F);
        }
        if (i != 10756) aClass269_7339 = null;
    }

    Class367_Sub6(DirectXToolkit directXToolkit, Index index, Class269 class269) {
        super(directXToolkit);
        aClass269_7339 = class269;
        aDirectXToolkit_7340 = directXToolkit;
        if (null == index || !aClass269_7339.method2039(123) || (257 > (aDirectXToolkit_7340.aD3DCAPS9791.VertexShaderVersion & 0xffff))) anIDirect3DVertexShader7341 = null;
        else anIDirect3DVertexShader7341 = aDirectXToolkit_7340.anIDirect3DDevice9810.b(index.method391("dx", "transparent_water", -29832));
    }

    final void method3523(byte i) {
        if (anIDirect3DVertexShader7341 != null) {
            IDirect3DDevice idirect3ddevice = aDirectXToolkit_7340.anIDirect3DDevice9810;
            Class101_Sub2 class101_sub2 = aDirectXToolkit_7340.method3948(-22036);
            idirect3ddevice.a(0, class101_sub2.method924(i ^ 0x7, aFloatArray7338));
        }
        if (i != 12) aDirectXToolkit_7340 = null;
    }

    final void method3520(byte i) {
        if (i == 87) {
            aDirectXToolkit_7340.method3957(null, (byte) -89);
            this.aNativeToolkit_4479.method3849((byte) 47, 0, ModelParticleEffector.aClass70_4247);
            this.aNativeToolkit_4479.method3849((byte) 47, 1, Class285_Sub2.aClass70_8503);
            this.aNativeToolkit_4479.method3849((byte) 47, 2, Class348_Sub40_Sub39.aClass70_9485);
            this.aNativeToolkit_4479.method3852(9, true);
        }
    }

    final void method3524(int i) {
        if (anIDirect3DVertexShader7341 != null) {
            IDirect3DDevice idirect3ddevice = aDirectXToolkit_7340.anIDirect3DDevice9810;
            idirect3ddevice.a(4, this.aNativeToolkit_4479.method3835(aFloatArray7338, -104));
        }
        if (i != -14775) aDirectXToolkit_7340 = null;
    }

    final void method3532(int i) {
        if (anIDirect3DVertexShader7341 != null) {
            IDirect3DDevice idirect3ddevice = aDirectXToolkit_7340.anIDirect3DDevice9810;
            Class101_Sub2 class101_sub2 = this.aNativeToolkit_4479.method3848(5);
            class101_sub2.method915(aFloatArray7338, i ^ 0x28b8);
            aFloatArray7338[0] *= 0.25F;
            aFloatArray7338[2] *= 0.25F;
            aFloatArray7338[3] *= 0.25F;
            aFloatArray7338[6] *= 0.25F;
            aFloatArray7338[5] *= 0.25F;
            aFloatArray7338[1] *= 0.25F;
            aFloatArray7338[7] *= 0.25F;
            aFloatArray7338[4] *= 0.25F;
            idirect3ddevice.SetVertexShaderConstantF(8, aFloatArray7338, 2);
        }
        if (i != 10425) aDirectXToolkit_7340 = null;
    }

    final boolean method3530(int i) {
        if (i >= -57) method3522(-94);
        return anIDirect3DVertexShader7341 != null;
    }

    final void method3531(boolean bool) {
        if (null != anIDirect3DVertexShader7341) {
            IDirect3DDevice idirect3ddevice = aDirectXToolkit_7340.anIDirect3DDevice9810;
            Class101_Sub2 class101_sub2 = aDirectXToolkit_7340.method3948(-22036);
            idirect3ddevice.a(0, class101_sub2.method924(11, aFloatArray7338));
        }
        if (bool) method3524(46);
    }

    final void method3522(int i) {
        if (i != -16252) method3523((byte) 62);
        if (anIDirect3DVertexShader7341 != null) {
            IDirect3DDevice idirect3ddevice = aDirectXToolkit_7340.anIDirect3DDevice9810;
            if (this.aNativeToolkit_4479.anInt8091 <= 0) idirect3ddevice.a(10, 0.0F, 0.0F, 0.0F, 0.0F);
            else {
                float f = (this.aNativeToolkit_4479.aFloat8115);
                float f_4_ = (this.aNativeToolkit_4479.aFloat8173);
                float f_5_ = f_4_ - 512.0F;
                idirect3ddevice.a(10, f_5_, 1.0F / (-f_5_ + f_4_), f_4_, 1.0F / (-f_4_ + f));
            }
            this.aNativeToolkit_4479.method3894(-28186, this.aNativeToolkit_4479.anInt8144);
        }
    }

    final void method3525(int i, boolean bool) {
        if (i != 15192) method3531(true);
        this.aNativeToolkit_4479.method3849((byte) 47, 0, ModelParticleEffector.aClass70_4247);
        this.aNativeToolkit_4479.method3849((byte) 47, 1, Class348_Sub40_Sub39.aClass70_9485);
        this.aNativeToolkit_4479.method3924(false, false, 2, Class285_Sub2.aClass70_8503, true);
        this.aNativeToolkit_4479.method3852(9, false);
        aDirectXToolkit_7340.method3957(anIDirect3DVertexShader7341, (byte) -89);
        method3523((byte) 12);
        method3532(10425);
        method3524(-14775);
        method3522(-16252);
    }
}
