/* Class59_Sub1_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class59_Sub1_Sub1 extends Class59_Sub1 {
    static int anInt8652;
    static int anInt8653;
    static int anInt8654;
    static int anInt8655;
    static int anInt8656;
    private byte[] aByteArray8657;
    static int anInt8658;

    public Class59_Sub1_Sub1() {
        super(8, 5, 8, 8, 2, 0.1F, 0.55F, 3.0F);
    }

    static final void method556(boolean bool) {
        anInt8656++;
        if (Class51.renderer != null) Class51.renderer.method2319((byte) -75);
        if (bool == false) {
            if (Class348_Sub32.rendererThread != null) {
                for (; ; ) {
                    try {
                        Class348_Sub32.rendererThread.join();
                        break;
                    } catch (InterruptedException interruptedexception) {
                        /* empty */
                    }
                }
            }
        }
    }

    // method557
    static final TextureOp create(int type, byte i_0_) {
        int i_1_ = 22 / ((i_0_ - 37) / 63);
        anInt8653++;
        if (type == 0) {
            return new TextureOpMonochromeFill();
        } else if (type == 1) {
            return new TextureOpColourFill();
        } else if (type == 2) {
            return new TextureOpHorizontalGradient();
        } else if (type == 3) {
            return new TextureOpVerticalGradient();
        } else if (type == 4) {
            return new TextureOpBricks();
        } else if (type == 5) {
            return new TextureOpBoxBlur();
        } else if (type == 6) {
            return new TextureOpClamp();
        } else if (type == 7) {
            return new TextureOpCombine();
        } else if (type == 8) {
            return new TextureOpCurve();
        } else if (type == 9) {
            return new TextureOpFlip();
        } else if (type == 10) {
            return new TextureOpColourGradient();
        } else if (type == 11) {
            return new TextureOpColourise();
        } else if (type == 12) {
            return new TextureOpWaveform();
        } else if (type == 13) {
            return new TextureOpNoise();
        } else if (type == 14) {
            return new TextureOpWeave();
        } else if (type == 15) {
            return new TextureOpVoronoiNoise();
        } else if (type == 16) {
            return new TextureOpHerringbone();
        } else if (type == 17) {
            return new TextureOpHslAdjust();
        } else if (type == 18) {
            return new TextureOpTiledSprite();
        } else if (type == 19) {
            return new TextureOpPolarDistortion();
        } else if (type == 20) {
            return new TextureOpTile();
        } else if (type == 21) {
            return new TextureOpInterpolate();
        } else if (type == 22) {
            return new TextureOpInvert();
        } else if (type == 23) {
            return new TextureOpKaleidoscope();
        } else if (type == 24) {
            return new TextureOpMonochrome();
        } else if (type == 25) {
            return (new TextureOpBrightness());
        } else if (type == 26) {
            return (new TextureOpBinary());
        } else if (type == 27) {
            return (new TextureOpSquareWaveform());
        } else if (type == 28) {
            return (new TextureOpIrregularBricks());
        } else if (type == 29) {
            return (new TextureOpRasterizer());
        } else if (type == 30) {
            return (new TextureOpRange());
        } else if (type == 31) {
            return new TextureOpMandelbrot();
        } else if (type == 32) {
            return new TextureOpEmboss();
        } else if (type == 33) {
            return new TextureOpColourEdgeDetector();
        } else if (type == 34) {
            return new TextureOpPerlinNoise();
        } else if (type == 35) {
            return new TextureOpMonorchromeEdgeDetector();
        } else if (type == 36) {
            return new TextureOpTexture();
        } else if (type == 37) {
            return new TextureOp37();
        } else if (type == 38) {
            return new TextureOpLineNoise();
        } else if (type == 39) {
            return new TextureOpSprite();
        } else {
            return null;
        }
    }

    final void method550(int i, byte i_3_, byte i_4_) {
        if (i_4_ == 14) {
            anInt8654++;
            int i_5_ = i * 2;
            aByteArray8657[i_5_++] = (byte) -1;
            int i_6_ = i_3_ & 0xff;
            aByteArray8657[i_5_] = (byte) (i_6_ * 3 >> 5);
        }
    }

    static final Class345 method558(int i) {
        int i_7_ = -98 % ((i - -34) / 33);
        anInt8658++;
        try {
            return new Class345_Sub1();
        } catch (Throwable throwable) {
            return null;
        }
    }

    final byte[] method559(int i, int i_8_, byte i_9_, int i_10_) {
        aByteArray8657 = new byte[2 * (i_8_ * i) * i_10_];
        if (i_9_ < 85) aByteArray8657 = null;
        anInt8655++;
        this.method542(i_8_, i, 0, i_10_);
        return aByteArray8657;
    }

    static final void method560(Class318_Sub4 class318_sub4, int i) {
        try {
            anInt8652++;
            class318_sub4.aClass318_Sub1_6410 = null;
            int i_11_ = (class318_sub4.aClass318_Sub3Array6414).length;
            int i_12_ = 127 / ((i - 82) / 32);
            for (int i_13_ = 0; i_13_ < i_11_; i_13_++)
                class318_sub4.aClass318_Sub3Array6414[i_13_].visible = false;
            synchronized (Class318.aClass243Array3974) {
                if (Class318.aClass243Array3974.length > i_11_ && Class331.anIntArray4128[i_11_] < 200) {
                    Class318.aClass243Array3974[i_11_].method1869(-126, class318_sub4);
                    Class331.anIntArray4128[i_11_]++;
                }
            }
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("hha.E(" + (class318_sub4 != null ? "{...}" : "null") + ',' + i + ')'));
        }
    }
}
