/* Class348_Sub18 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.*;
import java.lang.reflect.Constructor;

final class Class348_Sub18 extends Node {
    static int anInt6804;
    static int anInt6805;
    private final int anInt6806;
    static int anInt6807;
    static int anInt6808;
    int anInt6809;
    private int anInt6810;
    private int anInt6811;
    int anInt6812;
    int anInt6813;
    static Class351 aClass351_6814 = new Class351(63, 3);
    private final int anInt6815;
    static int anInt6816;
    static int anInt6817;
    static int anInt6818 = 0;
    int anInt6819;
    private final int anInt6820;
    static int anInt6821;
    static int anInt6822;
    /*synthetic*/ static Class aClass6823;

    final boolean method2934(int i, int i_0_, int i_1_) {
        anInt6822++;
        if (i != 3589) method2941(null, 70, false);
        return i_0_ >= anInt6820 && i_0_ <= anInt6806 && i_1_ >= anInt6811 && anInt6810 >= i_1_;
    }

    final boolean method2935(int i, int i_2_, int i_3_, boolean bool) {
        anInt6821++;
        if (bool != true) anInt6811 = -84;
        return i_3_ == anInt6815 && i_2_ >= anInt6820 && anInt6806 >= i_2_ && i >= anInt6811 && anInt6810 >= i;
    }

    public static void method2936(byte i) {
        if (i == -25) aClass351_6814 = null;
    }

    final void method2937(int i, int i_4_, int i_5_, int[] is) {
        anInt6816++;
        is[0] = anInt6815;
        is[1] = -this.anInt6809 - -anInt6820 + i;
        is[2] = i_4_ + (-this.anInt6812 + anInt6811);
        if (i_5_ != -3069) anInt6810 = -14;
    }

    static final void method2938(byte i) {
        anInt6804++;
        Class229.floorOverlayTypeList.method2037(10205);
        Class362.floorUnderlayTypeList.method1381(true);
        TextureOpMandelbrot.idkTypeList.method1206((byte) -37);
        TextureOpColourGradient.objectTypeList.method2012(-23828);
        BillboardType.npcTypeList.method2078(-6080);
        Exception_Sub1.itemTypeList.method1939(-110);
        Class10.animTypeList.method834((byte) -116);
        TextureOpColourFill.gfxTypeList.method2546(60);
        Class229.varBitTypeList.method1445(64);
        Class269.varPlayerTypeList.method1589((byte) 127);
        Class64_Sub3.basTypeList.method1985(0);
        Class2.msiTypeList.method1175((byte) 125);
        Class348_Sub23_Sub2.mapElementTypeList.method1219(7851);
        Class348_Sub23_Sub2.questTypeList.method1404((byte) -82);
        Class101_Sub3.paramTypeList.method2601((byte) -44);
        Class30.skyBoxTypeList.method822((byte) -120);
        Class123.skyBoxSphereTypeList.method300((byte) -123);
        Class348_Sub1.lightTypeList.method1393((byte) -13);
        Option.cursorTypeList.method1290(-8);
        Class136.structTypeList.method695(true);
        Class73.hitmarkTypeList.method1602(0);
        Class369_Sub3.method3573(-15326);
        Class164.method1277((byte) 62);
        SkyBoxTypeList.method821(-126);
        Class318.method2375(16127);
        if (Class55_Sub1.aClass364_5271 != Class8.aClass364_165) {
            for (int i_6_ = 0; LRUHashTable.aByteArrayArray3882.length > i_6_; i_6_++)
                LRUHashTable.aByteArrayArray3882[i_6_] = null;
            Class127_Sub1.anInt8388 = 0;
        }
        Class364.method3517(83);
        Class316.method2368(-1);
        Option_Sub25.method1828(87);
        if (i > 53) {
            Class24.method297(false);
            Class186_Sub1.method1402(1);
            Class66.aClass60_1174.method590(0);
            Class348_Sub8.active.method3663();
            Class238_Sub1.method1707(26469);
            Packet.method3354(-52);
            Class348_Sub29.ANIMATION_SKELETONS.discardUnpacked((byte) -124);
            Class186.ANIMATION_SKINS.discardUnpacked((byte) -119);
            Class95.CONFIGS.discardUnpacked((byte) 37);
            Class348_Sub35.INTERFACES.discardUnpacked((byte) -113);
            ModelParticleEmitter.SOUND_EFFECTS.discardUnpacked((byte) -116);
            Class367_Sub10.MAPS.discardUnpacked((byte) -110);
            Class59_Sub2_Sub1.MUSIC.discardUnpacked((byte) 64);
            aa_Sub3.MODELS.discardUnpacked((byte) 120);
            Class21.SPRITES.discardUnpacked((byte) 98);
            Class369_Sub2.TEXTURES.discardUnpacked((byte) 43);
            Class16.HUFFMAN.discardUnpacked((byte) 20);
            Class348_Sub23_Sub2.MUSIC_EFFECTS.discardUnpacked((byte) 89);
            Class113.CLIENT_SCRIPTS.discardUnpacked((byte) -125);
            Class104.FONT_INDEX.discardUnpacked((byte) -117);
            Option_Sub4.MIDI_INSTRUMENTS.discardUnpacked((byte) 29);
            Class123.aIndex_1815.discardUnpacked((byte) 80);
            Class94.OBJECTS.discardUnpacked((byte) 34);
            Class247.ENUMS.discardUnpacked((byte) -116);
            Class216.NPCS.discardUnpacked((byte) 28);
            Class174.ITEMS.discardUnpacked((byte) -115);
            r_Sub2.ANIMATIONS.discardUnpacked((byte) 22);
            Class78.GRAPHICS.discardUnpacked((byte) 36);
            Class348_Sub16_Sub3.VARBITS.discardUnpacked((byte) -114);
            Class348_Sub32.WORLD_MAP.discardUnpacked((byte) 36);
            Class130.QUICK_CHAT_MESSAGES.discardUnpacked((byte) -114);
            VarcstrTypeList.QUICK_CHAT_MENUS.discardUnpacked((byte) -117);
            Class348_Sub11.TEXTURE_DEFINITIONS.discardUnpacked((byte) 78);
            Option.PARTICLES.discardUnpacked((byte) 88);
            Class367_Sub8.DEFAULTS.discardUnpacked((byte) -109);
            Deque.BILLBOARDS.discardUnpacked((byte) 112);
            Class126.NATIVE_LIBRARIES.discardUnpacked((byte) 85);
            Class136.SHADERS.discardUnpacked((byte) 93);
            Class146.VIDEOS.discardUnpacked((byte) -122);
            Class353.aClass60_4346.method590(0);
            Class328_Sub2.aClass60_6517.method590(0);
            Class348_Sub1_Sub1.aClass60_8807.method590(0);
            Class34.aClass60_463.method590(0);
        }
    }

    final boolean method2939(int i, int i_7_, int i_8_) {
        anInt6807++;
        if (i_7_ != 2) return true;
        return this.anInt6809 <= i && this.anInt6819 >= i && (i_8_ >= this.anInt6812) && this.anInt6813 >= i_8_;
    }

    final void method2940(int i, boolean bool, int[] is, int i_9_) {
        anInt6817++;
        is[0] = 0;
        is[2] = i + -anInt6811 + this.anInt6812;
        is[1] = i_9_ - anInt6820 - -this.anInt6809;
        if (bool != true) this.anInt6812 = -26;
    }

    static final Class373 method2941(Component component, int i, boolean bool) {
        anInt6808++;
        try {
            Constructor constructor = (Class373_Sub1.class.getDeclaredConstructor((aClass6823 != null ? aClass6823 : (aClass6823 = Component.class)), Boolean.TYPE));
            return ((Class373) constructor.newInstance(new Object[]{component, new Boolean(bool)}));
        } catch (Throwable throwable) {
            if (i != 0) return null;
            return new Class373_Sub2(component, bool);
        }
    }

    static final void method2942(Class46 class46, byte i) {
        anInt6805++;
        if (class46.anInt765 == Js5TextureSource.anInt4610) {
            if (Class132.aPlayer_1907.aString10544 == null) {
                class46.anInt779 = 0;
                class46.anInt753 = 0;
            } else {
                class46.anInt757 = 150;
                class46.anInt675 = 0x7ff & (int) (256.0 * Math.sin((double) (Class367_Sub11.anInt7396) / 40.0));
                class46.anInt770 = 5;
                class46.anInt753 = Class348_Sub42_Sub11.index;
                class46.anInt779 = (Class318_Sub1_Sub3_Sub1.method2418((Class132.aPlayer_1907.aString10544), (byte) -41));
                class46.anInt699 = Class132.aPlayer_1907.anInt10268;
                class46.anInt841 = 0;
                class46.anInt730 = Class132.aPlayer_1907.anInt10312;
                class46.anInt795 = Class132.aPlayer_1907.anInt10245;
                AnimationType animationType = (class46.anInt699 != -1 ? Class10.animTypeList.method835(class46.anInt699, 7) : null);
                if (animationType != null) Class264.method2017(class46.anInt795, animationType, 50);
            }
        } else {
            int i_10_ = -14 % ((27 - i) / 59);
        }
    }

    Class348_Sub18(int i, int i_11_, int i_12_, int i_13_, int i_14_, int i_15_, int i_16_, int i_17_, int i_18_) {
        this.anInt6809 = i_15_;
        this.anInt6819 = i_17_;
        anInt6820 = i_11_;
        anInt6811 = i_12_;
        anInt6815 = i;
        this.anInt6812 = i_16_;
        anInt6806 = i_13_;
        anInt6810 = i_14_;
        this.anInt6813 = i_18_;
    }

}
