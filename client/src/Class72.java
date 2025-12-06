/* Class72 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class72 {
    private static Sprite aSprite_1215;
    private final int anInt1216;
    private int anInt1217;
    private final int anInt1218;
    private int anInt1219;
    private int anInt1220;
    private Sprite aSprite_1221;
    private final int anInt1222;
    private final boolean aBoolean1223;
    private final int anInt1224;
    private final int anInt1225;
    private static int[] anIntArray1226 = new int[4];
    private static Model aModel_1227;
    private static Sprite aSprite_1228;
    private final int anInt1229;
    private final int anInt1230;
    private int anInt1231;
    int anInt1232;

    private final boolean method730(Toolkit var_toolkit, Class72 class72_0_) {
        if (aSprite_1221 == null) {
            if (anInt1230 == 0) {
                if (JavaMatrix.aD5684.method4(-7953, anInt1224)) {
                    int[] is = JavaMatrix.aD5684.method6(-21540, anInt1220, 0.7F, anInt1224, false, anInt1220);
                    aSprite_1221 = var_toolkit.method3662(anInt1220, is, (byte) 94, 0, anInt1220, anInt1220);
                }
            } else if (anInt1230 == 2) method740(var_toolkit, class72_0_);
            else if (anInt1230 == 1) method735(var_toolkit, class72_0_);
        }
        return aSprite_1221 != null;
    }

    public static void method731() {
        aModel_1227 = null;
        aSprite_1215 = null;
        aSprite_1228 = null;
        anIntArray1226 = null;
    }

    private static final void method732(Toolkit var_toolkit) {
        if (aSprite_1228 == null) {
            int[] is = new int[16384];
            int[] is_1_ = new int[16384];
            for (int i = 0; i < 64; i++) {
                int i_2_ = 64 - i;
                i_2_ *= i_2_;
                int i_3_ = 128 - i - 1;
                int i_4_ = i * 128;
                int i_5_ = i_3_ * 128;
                for (int i_6_ = 0; i_6_ < 64; i_6_++) {
                    int i_7_ = 64 - i_6_;
                    i_7_ *= i_7_;
                    int i_8_ = 128 - i_6_ - 1;
                    int i_9_ = 256 - (i_7_ + i_2_ << 8) / 4096;
                    i_9_ = i_9_ * 16 * 192 / 1536;
                    if (i_9_ < 0) i_9_ = 0;
                    else if (i_9_ > 255) i_9_ = 255;
                    int i_10_ = i_9_ / 2;
                    is_1_[i_4_ + i_6_] = is_1_[i_4_ + i_8_] = is_1_[i_5_ + i_6_] = is_1_[i_5_ + i_8_] = ~0xffffff | i_9_ << 16;
                    is[i_4_ + i_6_] = is[i_4_ + i_8_] = is[i_5_ + i_6_] = is[i_5_ + i_8_] = 127 - i_10_ << 24 | 0xffffff;
                }
            }
            aSprite_1228 = var_toolkit.method3662(128, is_1_, (byte) 94, 0, 128, 128);
            aSprite_1215 = var_toolkit.method3662(128, is, (byte) 94, 0, 128, 128);
        }
    }

    final boolean method733(int i, int i_11_, int i_12_, int i_13_) {
        int i_14_;
        int i_15_;
        int i_16_;
        if (aBoolean1223) {
            this.anInt1232 = 1073741823;
            i_14_ = anInt1225;
            i_15_ = anInt1216;
            i_16_ = anInt1229;
        } else {
            i_14_ = anInt1225 - i;
            i_15_ = anInt1216 - i_11_;
            i_16_ = anInt1229 - i_12_;
            this.anInt1232 = (int) Math.sqrt(i_14_ * i_14_ + i_15_ * i_15_ + i_16_ * i_16_);
            if (this.anInt1232 == 0) this.anInt1232 = 1;
            i_14_ = (i_14_ << 8) / this.anInt1232;
            i_15_ = (i_15_ << 8) / this.anInt1232;
            i_16_ = (i_16_ << 8) / this.anInt1232;
        }
        int i_17_ = (int) (Math.sqrt(i_14_ * i_14_ + i_15_ * i_15_ + i_16_ * i_16_) * 256.0);
        if (i_17_ > 128) {
            i_14_ = (i_14_ << 16) / i_17_;
            i_15_ = (i_15_ << 16) / i_17_;
            i_16_ = (i_16_ << 16) / i_17_;
            anInt1217 = anInt1218 * i_13_ / (aBoolean1223 ? 1024 : this.anInt1232);
        } else anInt1217 = 0;
        if (anInt1217 < 8) {
            aSprite_1221 = null;
            return false;
        }
        int i_18_ = EnumTypeList.method340(anInt1217, (byte) 108);
        if (i_18_ > i_13_) i_18_ = Class348_Sub40_Sub1.method3051(i_13_, 4096);
        if (i_18_ > 512) i_18_ = 512;
        if (i_18_ != anInt1220) anInt1220 = i_18_;
        anInt1231 = (int) (Math.asin((float) i_15_ / 256.0F) * 2607.5945876176133) & 0x3fff;
        anInt1219 = (int) (Math.atan2(i_14_, -i_16_) * 2607.5945876176133) & 0x3fff;
        aSprite_1221 = null;
        return true;
    }

    final void method734() {
        aSprite_1221 = null;
    }

    private final void method735(Toolkit var_toolkit, Class72 class72_19_) {
        method738(var_toolkit);
        method732(var_toolkit);
        var_toolkit.K(anIntArray1226);
        var_toolkit.KA(0, 0, anInt1220, anInt1220);
        var_toolkit.ya();
        var_toolkit.aa(0, 0, anInt1220, anInt1220, ~0xffffff | anInt1222, 0);
        int i = 0;
        int i_20_ = 0;
        int i_21_ = 256;
        if (class72_19_ != null) {
            if (class72_19_.aBoolean1223) {
                i = -class72_19_.anInt1225;
                i_20_ = -class72_19_.anInt1216;
                i_21_ = -class72_19_.anInt1229;
            } else {
                i = class72_19_.anInt1225 - anInt1225;
                i_20_ = class72_19_.anInt1216 - anInt1216;
                i_21_ = class72_19_.anInt1229 - anInt1229;
            }
        }
        if (anInt1231 != 0) {
            int i_22_ = Class70.SIN[anInt1231];
            int i_23_ = Class70.COS[anInt1231];
            int i_24_ = i_20_ * i_23_ - i_21_ * i_22_ >> 14;
            i_21_ = i_20_ * i_22_ + i_21_ * i_23_ >> 14;
            i_20_ = i_24_;
        }
        if (anInt1219 != 0) {
            int i_25_ = Class70.SIN[anInt1219];
            int i_26_ = Class70.COS[anInt1219];
            int i_27_ = i_21_ * i_25_ + i * i_26_ >> 14;
            i_21_ = i_21_ * i_26_ - i * i_25_ >> 14;
            i = i_27_;
        }
        Model model = aModel_1227.method614((byte) 0, 51200, true);
        model.aa((short) 0, (short) anInt1224);
        var_toolkit.xa(1.0F);
        var_toolkit.ZA(16777215, 1.0F, 1.0F, (float) i, (float) i_20_, (float) i_21_);
        int i_28_ = 1024 * anInt1220 / (model.RA() - model.V());
        if (anInt1222 != 0) i_28_ = i_28_ * 13 / 16;
        var_toolkit.DA(anInt1220 / 2, anInt1220 / 2, i_28_, i_28_);
        var_toolkit.setCamera(var_toolkit.method3654());
        Matrix matrix = var_toolkit.method3654();
        matrix.method894(0, 0, var_toolkit.i() - model.HA());
        model.method608(matrix, null, 1024, 1);
        int i_29_ = anInt1220 * 13 / 16;
        int i_30_ = (anInt1220 - i_29_) / 2;
        aSprite_1215.method970(i_30_, i_30_, i_29_, i_29_, 0, ~0xffffff | anInt1222, 1);
        aSprite_1221 = var_toolkit.method3683(0, 0, anInt1220, anInt1220, true);
        var_toolkit.ya();
        var_toolkit.aa(0, 0, anInt1220, anInt1220, 0, 0);
        aSprite_1228.method970(0, 0, anInt1220, anInt1220, 1, 0, 0);
        aSprite_1221.method968(0, 0, 0);
        var_toolkit.KA(anIntArray1226[0], anIntArray1226[1], anIntArray1226[2], anIntArray1226[3]);
    }

    final boolean method736(Toolkit var_toolkit, Class72 class72_31_) {
        return aSprite_1221 != null || method730(var_toolkit, class72_31_);
    }

    final void method737(Toolkit var_toolkit, int i, int i_32_, int i_33_, int i_34_, int i_35_, int i_36_) {
        if (aSprite_1221 != null) {
            int i_37_ = anInt1231 - i_35_ & 0x3fff;
            int i_38_ = anInt1219 - i_36_ & 0x3fff;
            if (i_38_ > 8192) i_38_ -= 16384;
            if (i_37_ > 8192) i_37_ -= 16384;
            int i_39_ = i_37_ * i_34_ / 4096 + (i_34_ - anInt1217) / 2;
            int i_40_ = i_38_ * i_34_ / -4096 + (i_33_ - anInt1217) / 2;
            if (i_39_ < i_34_ && i_39_ + anInt1217 > 0 && i_40_ < i_33_ && i_40_ + anInt1217 > 0) aSprite_1221.method973(i_40_ + i, i_39_ + i_32_, anInt1217, anInt1217);
        }
    }

    private static final void method738(Toolkit var_toolkit) {
        if (aModel_1227 == null) {
            Mesh mesh = new Mesh(580, 1104, 1);
            mesh.method1105(109, (byte) 0, (byte) 0, (short) 0, (short) 1024, (byte) 0, (short) 0, (short) 32767, (short) 1024, (short) 1024);
            mesh.addVertex(128, 0, 0, -93);
            mesh.addVertex(-128, 0, 0, 108);
            for (int i = 0; i <= 24; i++) {
                int i_41_ = i * 8192 / 24;
                int i_42_ = Class70.SIN[i_41_];
                int i_43_ = Class70.COS[i_41_];
                for (int i_44_ = 1; i_44_ < 24; i_44_++) {
                    int i_45_ = i_44_ * 8192 / 24;
                    int i_46_ = Class70.COS[i_45_] >> 7;
                    int i_47_ = Class70.SIN[i_45_] * i_42_ >> 21;
                    int i_48_ = Class70.SIN[i_45_] * i_43_ >> 21;
                    mesh.addVertex(i_46_, -i_47_, i_48_, 127);
                }
                if (i > 0) {
                    int i_49_ = i * 23 + 2;
                    int i_50_ = i_49_ - 23;
                    mesh.method1102(0, (byte) 0, (byte) 0, (short) 0, (byte) 52, (short) 127, i_50_, (byte) 0, i_49_);
                    for (int i_51_ = 1; i_51_ < 23; i_51_++) {
                        int i_52_ = i_50_ + 1;
                        int i_53_ = i_49_ + 1;
                        mesh.method1102(i_50_, (byte) 0, (byte) 0, (short) 0, (byte) 41, (short) 127, i_52_, (byte) 0, i_49_);
                        mesh.method1102(i_52_, (byte) 0, (byte) 0, (short) 0, (byte) 67, (short) 127, i_53_, (byte) 0, i_49_);
                        i_50_ = i_52_;
                        i_49_ = i_53_;
                    }
                    mesh.method1102(i_49_, (byte) 0, (byte) 0, (short) 0, (byte) 98, (short) 127, i_50_, (byte) 0, 1);
                }
            }
            mesh.maxVertex = mesh.vertexCount;
            mesh.faceLabel = null;
            mesh.vertexLabel = null;
            mesh.facePriority = null;
            aModel_1227 = var_toolkit.method3625(mesh, 51200, 33, 64, 768);
        }
    }

    static final void method739() {
        aModel_1227 = null;
        aSprite_1228 = null;
    }

    Class72(int i, int i_54_, int i_55_, int i_56_, int i_57_, int i_58_, int i_59_, boolean bool) {
        anInt1225 = i_55_;
        anInt1216 = i_56_;
        anInt1229 = i_57_;
        aBoolean1223 = bool;
        anInt1224 = i_54_;
        anInt1222 = i_59_;
        anInt1218 = i_58_;
        anInt1230 = i;
    }

    private final void method740(Toolkit var_toolkit, Class72 class72_60_) {
        Mesh mesh = Class300.method2277(0, Class260.aIndex_3309, anInt1224, -1);
        if (mesh != null) {
            var_toolkit.K(anIntArray1226);
            var_toolkit.KA(0, 0, anInt1220, anInt1220);
            var_toolkit.aa(0, 0, anInt1220, anInt1220, 0, 0);
            int i = 0;
            int i_61_ = 0;
            int i_62_ = 256;
            if (class72_60_ != null) {
                if (class72_60_.aBoolean1223) {
                    i = -class72_60_.anInt1225;
                    i_61_ = -class72_60_.anInt1216;
                    i_62_ = -class72_60_.anInt1229;
                } else {
                    i = anInt1225 - class72_60_.anInt1225;
                    i_61_ = anInt1216 - class72_60_.anInt1216;
                    i_62_ = anInt1229 - class72_60_.anInt1229;
                }
            }
            if (anInt1231 != 0) {
                int i_63_ = -anInt1231 & 0x3fff;
                int i_64_ = Class70.SIN[i_63_];
                int i_65_ = Class70.COS[i_63_];
                int i_66_ = i_61_ * i_65_ - i_62_ * i_64_ >> 14;
                i_62_ = i_61_ * i_64_ + i_62_ * i_65_ >> 14;
                i_61_ = i_66_;
            }
            if (anInt1219 != 0) {
                int i_67_ = -anInt1219 & 0x3fff;
                int i_68_ = Class70.SIN[i_67_];
                int i_69_ = Class70.COS[i_67_];
                int i_70_ = i_62_ * i_68_ + i * i_69_ >> 14;
                i_62_ = i_62_ * i_69_ - i * i_68_ >> 14;
                i = i_70_;
            }
            var_toolkit.xa(1.0F);
            var_toolkit.ZA(16777215, 1.0F, 1.0F, (float) i, (float) i_61_, (float) i_62_);
            Model model = var_toolkit.method3625(mesh, 2048, 0, 64, 768);
            int i_71_ = model.RA() - model.V();
            int i_72_ = model.EA() - model.fa();
            int i_73_ = model.V() + i_71_ / 2;
            int i_74_ = model.fa() + i_72_ / 2;
            int i_75_ = Math.max(i_71_, i_72_);
            var_toolkit.DA(i_73_, i_74_, i_75_, i_75_);
            var_toolkit.setCamera(var_toolkit.method3654());
            Matrix matrix = var_toolkit.method3705();
            matrix.method894(0, 0, var_toolkit.i() - model.HA());
            model.method608(matrix, null, var_toolkit.i(), 1);
            aSprite_1221 = var_toolkit.method3683(0, 0, anInt1220, anInt1220, true);
            aSprite_1221.method968(0, 0, 3);
            var_toolkit.KA(anIntArray1226[0], anIntArray1226[1], anIntArray1226[2], anIntArray1226[3]);
        }
    }
}
