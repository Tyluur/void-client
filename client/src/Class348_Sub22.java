/* Class348_Sub22 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.*;

final class Class348_Sub22 extends Node {
    static int anInt6857;
    static int anInt6858;
    Npc aNpc_6859;
    static int anInt6860;
    static int anInt6861;
    static int hitmarksGroup;

    static final Class46 method2957(int i, byte i_0_, int i_1_) {
        anInt6858++;
        Class46 class46 = FontRenderer.method2570(i_0_ + 1512932774, i_1_);
        if (i_0_ != -54) method2958(-23, null);
        if (i == -1) return class46;
        if (class46 == null || class46.aClass46Array798 == null || (i >= class46.aClass46Array798.length)) return null;
        return class46.aClass46Array798[i];
    }

    static final int method2958(int i, Index index) {
        anInt6861++;
        int i_2_ = 0;
        if (index.fileReady(false, hitmarksGroup)) i_2_++;
        if (index.fileReady(false, LoadingScreenOpFactory.hitbarDefaultGroup)) i_2_++;
        if (index.fileReady(false, Class373_Sub2.timerbarDefaultGroup)) i_2_++;
        if (index.fileReady(false, Toolkit.headIconsPkGroup)) i_2_++;
        if (index.fileReady(false, VarcstrTypeList.headIconsPrayerGroup)) i_2_++;
        if (index.fileReady(false, Class115.hintHeadIconsGroup)) i_2_++;
        if (index.fileReady(false, Class291.hintMapmarkersGroup)) i_2_++;
        if (index.fileReady(false, Class86.mapFlagGround)) i_2_++;
        if (index.fileReady(false, Option_Sub10.crossGroup)) i_2_++;
        if (index.fileReady(false, Class113.mapDotsGround)) i_2_++;
        if (index.fileReady(false, Class364.scrollBarGround)) i_2_++;
        if (i != 22388) return 8;
        if (index.fileReady(false, TextureOpClamp.nameIconsGroup)) i_2_++;
        if (index.fileReady(false, QuestTypeList.floorShadowsGroup)) i_2_++;
        if (index.fileReady(false, Class52.compassGroup)) i_2_++;
        if (index.fileReady(false, Class186_Sub1.otherLevelGroup)) i_2_++;
        if (index.fileReady(false, Class5_Sub3.hintMapEdgeGroup)) i_2_++;
        return i_2_;
    }

    static final void method2959(int i) {
        Class182.aClass346_2449.method2698(14174);
        anInt6860++;
        Class258_Sub4.aClass373_8552.method3592(0);
        NPCDefinition.aClient1367.method87((byte) -49);
        Class305.aCanvas3869.setBackground(Color.black);
        Class337.anInt4179 = i;
        Class182.aClass346_2449 = Class348_Sub3.method2743(Class305.aCanvas3869, (byte) 84);
        Class258_Sub4.aClass373_8552 = Class348_Sub18.method2941(Class305.aCanvas3869, 0, true);
    }

    Class348_Sub22(Npc npc) {
        this.aNpc_6859 = npc;
    }
}
