/* Class348_Sub23 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import jagtheora.ogg.OggPacket;
import jagtheora.ogg.OggStreamState;

abstract class Class348_Sub23 extends Node {
    static int anInt6863;
    static int anInt6864;
    static float[] aFloatArray6865 = new float[16384];
    static int anInt6866;
    static float[] aFloatArray6867 = new float[16384];
    int anInt6868;
    OggStreamState anOggStreamState6869;
    static int anInt6870;

    static final int method2960(boolean bool, int i) {
        if (i >= -16) aFloatArray6865 = null;
        anInt6870++;
        int i_0_ = Packet.anInt7207;
        while_128_:
        do {
            do {
                if (i_0_ == 0) {
                    if (bool) return 0;
                    return TextureOpPerlinNoise.anInt9157;
                } else if (i_0_ != 1) {
                    if (i_0_ == 2) break;
                    break while_128_;
                }
                return TextureOpPerlinNoise.anInt9157;
            } while (false);
            return 0;
        } while (false);
        return 0;
    }

    abstract void method2961(byte i);

    public static void method2962(int i) {
        aFloatArray6865 = null;
        aFloatArray6867 = null;
        if (i != -31055) method2966(-119, -98, true);
    }

    final void method2963(OggPacket oggpacket, int i) {
        method2964((byte) -120, oggpacket);
        if (i != 16384) aFloatArray6867 = null;
        anInt6863++;
        this.anInt6868++;
    }

    abstract void method2964(byte i, OggPacket oggpacket);

    // method2965
    static final void setToolkit(String string, int i, boolean bool, int i_1_) {
        anInt6866++;
        QuestTypeList.method1406(true);
        if (i == 0) {
            Class348_Sub8.active = Class104.method958(true, 0, TextureOpVerticalGradient.js5TextureSource, Class316.clientOptions.aClass239_Sub20_7248.method1808(-32350) * 2, Class305.aCanvas3869, Class136.SHADERS);
            if (string != null) {
                Class348_Sub8.active.GA(0);
                FontMetrics fontMetrics = Option_Sub23.getFontMetrics(AnimationType.anInt235, 0, -117, Class104.FONT_INDEX);
                FontRenderer fontRenderer = (Class348_Sub8.active.method3686(fontMetrics, IndexedImage.method1519(Class21.SPRITES, AnimationType.anInt235, 0), true));
                Class140.method1170((byte) -89);
                Class362.method3511(true, fontRenderer, fontMetrics, string, 2, Class348_Sub8.active);
            }
        } else {
            Toolkit var_toolkit = null;
            if (string != null) {
                var_toolkit = Class104.method958(true, 0, TextureOpVerticalGradient.js5TextureSource, 0, Class305.aCanvas3869, Class136.SHADERS);
                var_toolkit.GA(0);
                FontMetrics fontMetrics = Option_Sub23.getFontMetrics(AnimationType.anInt235, 0, -115, Class104.FONT_INDEX);
                FontRenderer fontRenderer = var_toolkit.method3686(fontMetrics, IndexedImage.method1519((Class21.SPRITES), AnimationType.anInt235, 0), true);
                Class140.method1170((byte) -107);
                Class362.method3511(true, fontRenderer, fontMetrics, string, i_1_ + 2, var_toolkit);
            }
            try {
                Class348_Sub8.active = Class104.method958(true, i, TextureOpVerticalGradient.js5TextureSource, 2 * Class316.clientOptions.aClass239_Sub20_7248.method1808(i_1_ + -32350), Class305.aCanvas3869, Class136.SHADERS);
                if (string != null) {
                    var_toolkit.GA(0);
                    FontMetrics fontMetrics = Option_Sub23.getFontMetrics(AnimationType.anInt235, 0, -51, Class104.FONT_INDEX);
                    FontRenderer fontRenderer = (var_toolkit.method3686(fontMetrics, IndexedImage.method1519(Class21.SPRITES, AnimationType.anInt235, 0), true));
                    Class140.method1170((byte) -26);
                    Class362.method3511(true, fontRenderer, fontMetrics, string, i_1_ + 2, var_toolkit);
                }
                if (Class348_Sub8.active.method3693()) {
                    boolean bool_2_ = true;
                    try {
                        bool_2_ = (TextureOpNoise.aClass348_Sub4_9264.totalMemory) > 256;
                    } catch (Throwable throwable) {
                        /* empty */
                    }
                    za var_za;
                    if (!bool_2_) var_za = Class348_Sub8.active.method3702(104857600);
                    else var_za = Class348_Sub8.active.method3702(146800640);
                    Class348_Sub8.active.method3651(var_za);
                }
            } catch (Throwable throwable) {
                int i_3_ = Class316.clientOptions.aClass239_Sub25_7271.method1829(-32350);
                if (i_3_ == 2) Class139.aBoolean1952 = true;
                Class316.clientOptions.update((byte) 74, (Class316.clientOptions.aClass239_Sub25_7271), 0);
                setToolkit(string, i_3_, bool, i_1_);
                return;
            } finally {
                if (var_toolkit != null) {
                    try {
                        var_toolkit.method3635((byte) -111);
                    } catch (Throwable throwable) {
                        /* empty */
                    }
                }
            }
        }
        Class316.clientOptions.aClass239_Sub25_7271.method1826(!bool, -142238264);
        Class316.clientOptions.update((byte) 74, (Class316.clientOptions.aClass239_Sub25_7271), i);
        Packet.method3354(i_1_ + -78);
        Class348_Sub8.active.method3650(10000);
        Class348_Sub8.active.X(32);
        Class157.aMatrix_2123 = Class348_Sub8.active.method3654();
        Class50_Sub1.aMatrix_5209 = Class348_Sub8.active.method3654();
        Class290.method2196((byte) -9);
        Class348_Sub8.active.method3630(Class316.clientOptions.aClass239_Sub2_7228.method1726(-32350) == 1);
        if (Class348_Sub8.active.method3627()) TextureOpKaleidoscope.method3137(Class316.clientOptions.aClass239_Sub12_7243.method1771(-32350) == 1, (byte) -24);
        Class97.method873(Class367_Sub4.mapLength >> 3, 21719, Class348_Sub8.active, TextureOpBinary.mapWidth >> 3);
        Class76.method773(true);
        r.aBoolean9719 = false;
        Class228.aClass57Array2974 = null;
        RuntimeException_Sub1.aBoolean4604 = true;
        ByteArraySecondaryNode.method3179(i_1_);
    }

    Class348_Sub23(OggStreamState oggstreamstate) {
        this.anOggStreamState6869 = oggstreamstate;
    }

    static final void method2966(int i, int i_4_, boolean bool) {
        anInt6864++;
        Class348_Sub42_Sub15 class348_sub42_sub15 = Class318_Sub9_Sub1.method2516(i, (byte) 105, 14);
        if (bool != false) aFloatArray6865 = null;
        class348_sub42_sub15.method3246(-25490);
        class348_sub42_sub15.anInt9652 = i_4_;
    }

    static {
        double d = 3.834951969714103E-4;
        for (int i = 0; i < 16384; i++) {
            aFloatArray6865[i] = (float) Math.sin(d * (double) i);
            aFloatArray6867[i] = (float) Math.cos((double) i * d);
        }
    }
}
