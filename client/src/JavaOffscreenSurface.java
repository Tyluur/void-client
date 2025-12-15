/* Class49 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Class49
final class JavaOffscreenSurface implements OffscreenSurface {
    float[] depthBuffer;
    static float aFloat4720;
    static int anInt4721;
    int height;
    static int anInt4723;
    private Class216 aClass216_4724;
    int width;
    static volatile boolean aBoolean4726 = true;
    static int anInt4727;
    static boolean aBoolean4728 = false;
    private final JavaToolkit aJavaToolkit_4729;
    static Class46 aClass46_4730 = null;
    int[] raster;

    public static void method453(int i) {
        if (i == -2001) aClass46_4730 = null;
    }

    static final int method454(int i, byte i_0_) {
        int i_1_ = 20 / ((i_0_ - -4) / 37);
        anInt4727++;
        int i_2_;
        if (i > 12000) {
            Class133.method1140(73);
            i_2_ = 4;
        } else if (i > 5000) {
            Class47.method447((byte) -59);
            i_2_ = 3;
        } else if (i <= 2000) {
            i_2_ = 1;
            TextureOpColourGradient.method3076(0, true);
        } else {
            i_2_ = 2;
            Class161.method1263(true);
        }
        if (Class316.clientOptions.aClass239_Sub25_7271.method1829(-32350) != 2) {
            Class316.clientOptions.update((byte) 74, (Class316.clientOptions.aClass239_Sub25_7251), 2);
            Class367_Sub10.method3553(false, (byte) 119, 2);
        }
        Class14_Sub2.saveOptions(37);
        return i_2_;
    }

    public final void method14(int i, int i_3_, int i_4_, int i_5_, int i_6_, int i_7_, boolean bool, boolean bool_8_) {
        anInt4723++;
        ItemDefinition.method1568((aJavaToolkit_4729.surface.raster), i_3_, i, i_7_, bool_8_ ? aJavaToolkit_4729.mainDepthBuffer : null, bool ? this.raster : null, i_4_, 115, i_5_, (aJavaToolkit_4729.surface.width), this.width, i_6_, !bool_8_ ? null : this.depthBuffer);
    }

    public final void method15(int i, int i_9_, int i_10_, int i_11_, int i_12_, int i_13_, boolean bool, boolean bool_14_) {
        anInt4721++;
        ItemDefinition.method1568(this.raster, i_9_, i, i_13_, bool_14_ ? this.depthBuffer : null, !bool ? null : (aJavaToolkit_4729.surface.raster), i_10_, 113, i_11_, this.width, (aJavaToolkit_4729.surface.width), i_12_, bool_14_ ? aJavaToolkit_4729.mainDepthBuffer : null);
    }

    JavaOffscreenSurface(JavaToolkit var_javaToolkit, Sprite sprite, Class216 class216) {
        do {
            try {
                aJavaToolkit_4729 = var_javaToolkit;
                if (sprite instanceof JavaRgbSprite) {
                    JavaRgbSprite class105_sub3_sub1 = (JavaRgbSprite) sprite;
                    this.raster = (class105_sub3_sub1.raster);
                    this.height = class105_sub3_sub1.height;
                    this.width = class105_sub3_sub1.width;
                } else if (sprite instanceof JavaArgbSprite) {
                    JavaArgbSprite class105_sub3_sub3 = (JavaArgbSprite) sprite;
                    this.width = class105_sub3_sub3.width;
                    this.height = class105_sub3_sub3.height;
                    this.raster = (class105_sub3_sub3.raster);
                } else {
                    throw new RuntimeException();
                }
                if (class216 == null) break;
                aClass216_4724 = class216;
                if ((aClass216_4724.anInt4974 != this.width) || (this.height != aClass216_4724.anInt4978)) throw new RuntimeException();
                this.depthBuffer = aClass216_4724.aFloatArray4980;
            } catch (RuntimeException runtimeexception) {
                throw Class348_Sub17.method2929(runtimeexception, ("it.<init>(" + (var_javaToolkit != null ? "{...}" : "null") + ',' + (sprite != null ? "{...}" : "null") + ',' + (class216 != null ? "{...}" : "null") + ')'));
            }
            break;
        } while (false);
    }
}
