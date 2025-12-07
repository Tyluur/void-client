/* Class51 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class51 {
    static int anInt866;
    static int anInt867;
    int anInt868 = -1;
    int anInt869;
    static int anInt870;
    static int anInt871;
    private byte[] aByteArray872;
    private int anInt873;
    int anInt874;
    int anInt875;
    boolean aBoolean876 = false;
    int anInt877;
    int anInt878;
    private byte aByte879;
    private int anInt880;
    private Class356 aClass356_881;
    private int anInt882;
    int anInt883;
    String aString884;
    private byte[] aByteArray885;
    private byte aByte886;
    int anInt887;
    boolean aBoolean888;
    int anInt889;
    private int anInt890;
    static int anInt891;
    private short[] aShortArray892;
    private int anInt893;
    boolean aBoolean894;
    int anInt895;
    boolean aBoolean896;
    static LoadingScreenRenderer renderer;
    static int anInt898;
    static int anInt899;
    private int anInt900;
    static int anInt901;
    boolean aBoolean902;
    boolean aBoolean903;
    int[] anIntArray904;
    static Matrix aMatrix_905;
    boolean aBoolean906;
    private int[][] anIntArrayArray907;
    private short[] aShortArray908;
    int anInt909;
    static int anInt910;
    private int anInt911;
    boolean aBoolean912;
    String[] aStringArray913;
    int anInt914;
    private int anInt915;
    int anInt916;
    int[] anIntArray917;
    boolean aBoolean918;
    private short[] aShortArray919;
    int anInt920;
    int anInt921;
    private byte aByte922;
    int anInt923;
    boolean aBoolean924;
    boolean aBoolean925;
    int anInt926;
    static int anInt927;
    private int anInt928;
    boolean aBoolean929;
    int anInt930;
    boolean aBoolean931;
    static String[] aStringArray932 = new String[100];
    ObjectTypeList aObjectTypeList_933;
    private int anInt934;
    private int anInt935;
    int anInt936;
    int anInt937;
    static int anInt938;
    private int anInt939;
    private short[] aShortArray940;
    int anInt941;
    boolean aBoolean942;
    int[] anIntArray943;
    private byte aByte944;
    int[] anIntArray945;
    private int anInt946;
    boolean aBoolean947;
    static int anInt948;
    private int anInt949;
    int anInt950;
    int anInt951;
    private byte aByte952;
    int anInt953;
    private int anInt954;
    int anInt955;
    static int anInt956;
    static int anInt957;
    static int anInt958;
    private int[] anIntArray959;
    static int anInt960;
    int anInt961;
    int anInt962;

    final boolean method474(byte i) {
        anInt891++;
        if (this.anIntArray945 == null) {
            return this.anInt887 != -1 || this.anIntArray904 != null;
        }
        for (int i_0_ = 0; i_0_ < this.anIntArray945.length; i_0_++) {
            if (this.anIntArray945[i_0_] != -1) {
                Class51 class51_1_ = this.aObjectTypeList_933.method2005(0, this.anIntArray945[i_0_]);
                if (class51_1_.anInt887 != -1 || class51_1_.anIntArray904 != null) return true;
            }
        }
        int i_2_ = -28 % ((i - 3) / 46);
        return false;
    }

    final String method475(String string, int i, int i_3_) {
        anInt866++;
        if (aClass356_881 == null) return string;
        if (i_3_ != -16) return null;
        Class348_Sub50 class348_sub50 = (Class348_Sub50) aClass356_881.method3480(i, -6008);
        if (class348_sub50 == null) return string;
        return class348_sub50.aString7211;
    }

    final Class2 method476(Toolkit var_toolkit, Ground var_ground, int i, int i_4_, int i_5_, boolean bool, Ground var_ground_6_, int i_7_, int i_8_, int i_9_, int i_10_) {
        try {
            if (Class104.method955(22311, i)) i = 4;
            anInt938++;
            long l = i_9_ + (i << 3) + (this.anInt941 << 10);
            l |= var_toolkit.anInt4567 << 29;
            int i_11_ = i_4_;
            if (aByte886 == 3) i_11_ |= 0x7;
            else {
                if (aByte886 != 0 || anInt954 != 0) i_11_ |= 0x2;
                if (anInt893 != 0) i_11_ |= 0x1;
                if (anInt890 != 0) i_11_ |= 0x4;
            }
            if (bool) i_11_ |= 0x40000;
            Class2 class2;
            synchronized (this.aObjectTypeList_933.aClass60_3361) {
                class2 = (Class2) this.aObjectTypeList_933.aClass60_3361.method583(l, i_10_ + -25);
            }
            Model model = class2 == null ? null : class2.aModel_119;
            r var_r = null;
            if (model == null || var_toolkit.method3667(model.ua(), i_11_) != 0) {
                if (model != null) i_11_ = var_toolkit.method3679(i_11_, model.ua());
                int i_12_ = i_11_;
                if (i == 10 && i_9_ > 3) i_12_ |= 0x5;
                model = method477(i_9_, var_toolkit, i, i_10_ ^ ~0xec, i_12_);
                if (model == null) return null;
                if (i == 10 && i_9_ > 3) model.a(2048);
                if (bool) var_r = model.ba(null);
                model.s(i_11_);
                class2 = new Class2();
                class2.aModel_119 = model;
                class2.aR118 = var_r;
                synchronized (this.aObjectTypeList_933.aClass60_3361) {
                    this.aObjectTypeList_933.aClass60_3361.method582(class2, l, (byte) -120);
                }
            } else {
                model = class2.aModel_119;
                var_r = class2.aR118;
                if (bool && var_r == null) var_r = class2.aR118 = model.ba(null);
            }
            if (i_10_ != 128) method477(-4, null, 72, 42, -33);
            boolean bool_13_ = (aByte886 != 0 && (var_ground_6_ != null || var_ground != null));
            boolean bool_14_ = (anInt893 != 0 || anInt954 != 0 || anInt890 != 0);
            if (bool_13_ || bool_14_) {
                model = model.method614((byte) 0, i_11_, true);
                if (bool_13_) model.p(aByte886, anInt915, var_ground_6_, var_ground, i_5_, i_7_, i_8_);
                if (bool_14_) model.H(anInt893, anInt954, anInt890);
                model.s(i_4_);
            } else model = model.method614((byte) 0, i_4_, true);
            Class348_Sub42.aClass2_7058.aModel_119 = model;
            Class348_Sub42.aClass2_7058.aR118 = var_r;
            return Class348_Sub42.aClass2_7058;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("iv.B(" + (var_toolkit != null ? "{...}" : "null") + ',' + (var_ground != null ? "{...}" : "null") + ',' + i + ',' + i_4_ + ',' + i_5_ + ',' + bool + ',' + (var_ground_6_ != null ? "{...}" : "null") + ',' + i_7_ + ',' + i_8_ + ',' + i_9_ + ',' + i_10_ + ')'));
        }
    }

    private final Model method477(int i, Toolkit var_toolkit, int i_15_, int i_16_, int i_17_) {
        anInt958++;
        int i_18_ = anInt949 - -64;
        int i_19_ = 850 + anInt880;
        int i_20_ = i_17_;
        boolean bool = (this.aBoolean902 || i_15_ == 2 && i > 3);
        if (bool) i_17_ |= 0x10;
        if (i == 0) {
            if (anInt928 != 128 || anInt900 != 0) i_17_ |= 0x1;
            if (anInt882 != 128 || anInt946 != 0) i_17_ |= 0x4;
        } else i_17_ |= 0xd;
        if (anInt935 != 128 || anInt873 != 0) i_17_ |= 0x2;
        if (i_16_ > -97) aByte944 = (byte) -69;
        if (aShortArray940 != null) i_17_ |= 0x4000;
        if (aShortArray919 != null) i_17_ |= 0x8000;
        if (aByte922 != 0) i_17_ |= 0x80000;
        Model model = null;
        if (aByteArray885 == null) return null;
        int i_21_ = -1;
        for (int i_22_ = 0; aByteArray885.length > i_22_; i_22_++) {
            if (aByteArray885[i_22_] == i_15_) {
                i_21_ = i_22_;
                break;
            }
        }
        if (i_21_ == -1) return null;
        int i_23_ = anIntArrayArray907[i_21_].length;
        if (i_23_ > 0) {
            long l = var_toolkit.anInt4567;
            for (int i_24_ = 0; i_23_ > i_24_; i_24_++)
                l = l * 67783L + (long) anIntArrayArray907[i_21_][i_24_];
            synchronized (this.aObjectTypeList_933.aClass60_3360) {
                model = (Model) this.aObjectTypeList_933.aClass60_3360.method583(l, 78);
            }
            if (model != null) {
                if (i_18_ != model.WA()) i_17_ |= 0x1000;
                if (i_19_ != model.da()) i_17_ |= 0x2000;
            }
            if (model == null || var_toolkit.method3667(model.ua(), i_17_) != 0) {
                int i_25_ = i_17_ | 0x1f01f;
                if (model != null) i_25_ = var_toolkit.method3679(i_25_, model.ua());
                Mesh mesh = null;
                synchronized (Class341.aMeshArray4236) {
                    for (int i_26_ = 0; i_26_ < i_23_; i_26_++) {
                        synchronized (this.aObjectTypeList_933.aIndex_3345) {
                            mesh = Class300.method2277(0, (this.aObjectTypeList_933.aIndex_3345), (0xffff & (anIntArrayArray907[i_21_][i_26_])), -1);
                        }
                        if (mesh == null) return null;
                        if (mesh.version < 13) mesh.method1092(2, 96);
                        if (i_23_ > 1) Class341.aMeshArray4236[i_26_] = mesh;
                    }
                    if (i_23_ > 1) mesh = new Mesh(Class341.aMeshArray4236, i_23_);
                }
                model = var_toolkit.method3625(mesh, i_25_, (this.aObjectTypeList_933.anInt3363), i_18_, i_19_);
                synchronized (this.aObjectTypeList_933.aClass60_3360) {
                    this.aObjectTypeList_933.aClass60_3360.method582(model, l, (byte) -95);
                }
            }
        }
        Model model_27_ = model.method614((byte) 0, i_17_, true);
        if (i_18_ != model.WA()) model_27_.C(i_18_);
        if (model.da() != i_19_) model_27_.LA(i_19_);
        if (bool) model_27_.v();
        if (i_15_ == 4 && i > 3) {
            model_27_.k(2048);
            model_27_.H(180, 0, -180);
        }
        i &= 0x3;
        if (i == 1) model_27_.k(4096);
        else if (i != 2) {
            if (i == 3) model_27_.k(12288);
        } else model_27_.k(8192);
        if (aShortArray940 != null) {
            for (int i_28_ = 0; aShortArray940.length > i_28_; i_28_++) {
                if (aByteArray872 != null && aByteArray872.length > i_28_) model_27_.ia(aShortArray940[i_28_], (Class348_Sub26.aShortArray6889[0xff & aByteArray872[i_28_]]));
                else model_27_.ia(aShortArray940[i_28_], aShortArray908[i_28_]);
            }
        }
        if (aShortArray919 != null) {
            for (int i_29_ = 0; i_29_ < aShortArray919.length; i_29_++)
                model_27_.aa(aShortArray919[i_29_], aShortArray892[i_29_]);
        }
        if (aByte922 != 0) model_27_.method624(aByte944, aByte952, aByte879, 0xff & aByte922);
        if (anInt928 != 128 || anInt935 != 128 || anInt882 != 128) model_27_.O(anInt928, anInt935, anInt882);
        if (anInt900 != 0 || anInt873 != 0 || anInt946 != 0) model_27_.H(anInt900, anInt873, anInt946);
        model_27_.s(i_20_);
        return model_27_;
    }

    final boolean method478(int i, int i_30_) {
        if (i_30_ != -31076) return false;
        anInt901++;
        if (anIntArrayArray907 == null) return true;
        synchronized (this.aObjectTypeList_933.aIndex_3345) {
            for (int i_31_ = 0; aByteArray885.length > i_31_; i_31_++) {
                if (aByteArray885[i_31_] == i) {
                    for (int i_32_ = 0; (anIntArrayArray907[i_31_].length > i_32_); i_32_++) {
                        if (!this.aObjectTypeList_933.aIndex_3345.requestDownload(i_30_ ^ 0x5061, anIntArrayArray907[i_31_][i_32_], 0)) return false;
                    }
                    return true;
                }
            }
        }
        return true;
    }

    final void method479(byte i, Packet packet) {
        anInt867++;
        for (; ; ) {
            int i_33_ = packet.readUnsignedByte(255);
            if (i_33_ == 0) break;
            method482(packet, i_33_, (byte) -101);
        }
        if (i != 0) method486(-77);
    }

    final Class51 method480(Interface17 interface17, byte i) {
        anInt870++;
        int i_34_ = -1;
        if (anInt934 == -1) {
            if (anInt939 != -1) i_34_ = interface17.method61(anInt939, (byte) -16);
        } else i_34_ = interface17.method62(anInt934, i + -65583);
        if (i != 47) method478(101, 42);
        if (i_34_ < 0 || -1 + this.anIntArray945.length <= i_34_ || this.anIntArray945[i_34_] == -1) {
            int i_35_ = (this.anIntArray945[-1 + this.anIntArray945.length]);
            if (i_35_ == -1) return null;
            return this.aObjectTypeList_933.method2005(0, i_35_);
        }
        return this.aObjectTypeList_933.method2005(i + -47, this.anIntArray945[i_34_]);
    }

    final boolean method481(byte i, int i_36_) {
        anInt957++;
        if (i_36_ == -1) return false;
        if (i_36_ == this.anInt868) return true;
        if (this.anIntArray943 != null) {
            for (int i_37_ = 0; i_37_ < this.anIntArray943.length; i_37_++) {
                if (this.anIntArray943[i_37_] == i_36_) return true;
            }
        }
        if (i < 67) method481((byte) 127, 25);
        return false;
    }

    private final void method482(Packet packet, int i, byte i_38_) {
        anInt960++;
        if (i == 1 || i == 5) {
            if (i == 5 && this.aObjectTypeList_933.aBoolean3355) method484(packet, -528);
            int i_59_ = packet.readUnsignedByte(255);
            anIntArrayArray907 = new int[i_59_][];
            aByteArray885 = new byte[i_59_];
            for (int i_60_ = 0; i_60_ < i_59_; i_60_++) {
                aByteArray885[i_60_] = packet.readByte(-110);
                int i_61_ = packet.readUnsignedByte(255);
                anIntArrayArray907[i_60_] = new int[i_61_];
                for (int i_62_ = 0; i_62_ < i_61_; i_62_++)
                    anIntArrayArray907[i_60_][i_62_] = packet.readUnsignedShort(842397944);
            }
            if (i == 5 && !this.aObjectTypeList_933.aBoolean3355) method484(packet, -528);
        } else if (i == 2) this.aString884 = packet.readString((byte) 121);
        else if (i == 14) this.anInt961 = packet.readUnsignedByte(255);
        else if (i != 15) {
            if (i == 17) {
                this.aBoolean896 = false;
                this.anInt920 = 0;
            } else if (i == 18) this.aBoolean896 = false;
            else if (i != 19) {
                if (i == 21) aByte886 = (byte) 1;
                else if (i != 22) {
                    if (i == 23) this.anInt955 = 1;
                    else if (i == 24) {
                        this.anInt868 = packet.readUnsignedShort(842397944);
                        if (this.anInt868 == 65535) this.anInt868 = -1;
                    } else if (i == 27) this.anInt920 = 1;
                    else if (i != 28) {
                        if (i != 29) {
                            if (i == 39) anInt880 = packet.readByte(-86) * 5;
                            else if (i >= 30 && i < 35) this.aStringArray913[-30 + i] = packet.readString((byte) 88);
                            else if (i == 40) {
                                int i_57_ = packet.readUnsignedByte(255);
                                aShortArray940 = new short[i_57_];
                                aShortArray908 = new short[i_57_];
                                for (int i_58_ = 0; (i_58_ < i_57_); i_58_++) {
                                    aShortArray940[i_58_] = (short) (packet.readUnsignedShort(842397944));
                                    aShortArray908[i_58_] = (short) (packet.readUnsignedShort(842397944));
                                }
                            } else if (i == 41) {
                                int i_55_ = packet.readUnsignedByte(255);
                                aShortArray892 = new short[i_55_];
                                aShortArray919 = new short[i_55_];
                                for (int i_56_ = 0; i_56_ < i_55_; i_56_++) {
                                    aShortArray919[i_56_] = (short) (packet.readUnsignedShort(842397944));
                                    aShortArray892[i_56_] = (short) (packet.readUnsignedShort(842397944));
                                }
                            } else if (i == 42) {
                                int i_53_ = packet.readUnsignedByte(255);
                                aByteArray872 = new byte[i_53_];
                                for (int i_54_ = 0; i_53_ > i_54_; i_54_++)
                                    aByteArray872[i_54_] = packet.readByte(-92);
                            } else if (i == 62) this.aBoolean902 = true;
                            else if (i != 64) {
                                if (i == 65) anInt928 = (packet.readUnsignedShort(842397944));
                                else if (i != 66) {
                                    if (i != 67) {
                                        if (i == 69) this.anInt914 = (packet.readUnsignedByte(255));
                                        else if (i != 70) {
                                            if (i == 71) anInt873 = ((packet.readShort(13638)) << 2);
                                            else if (i != 72) {
                                                if (i == 73) this.aBoolean947 = true;
                                                else if (i == 74) this.aBoolean876 = true;
                                                else if (i != 75) {
                                                    if (i != 77 && (i != 92)) {
                                                        if (i == 78) {
                                                            this.anInt887 = packet.readUnsignedShort(842397944);
                                                            this.anInt889 = packet.readUnsignedByte(255);
                                                        } else if (i == 79) {
                                                            this.anInt962 = packet.readUnsignedShort(842397944);
                                                            this.anInt937 = packet.readUnsignedShort(842397944);
                                                            this.anInt889 = packet.readUnsignedByte(255);
                                                            int i_48_ = packet.readUnsignedByte(255);
                                                            this.anIntArray904 = new int[i_48_];
                                                            for (int i_49_ = 0; i_48_ > i_49_; i_49_++)
                                                                this.anIntArray904[i_49_] = packet.readUnsignedShort(842397944);
                                                        } else if (i == 81) {
                                                            aByte886 = (byte) 2;
                                                            anInt915 = packet.readUnsignedByte(255) * 256;
                                                        } else if (i != 82) {
                                                            if (i == 88) this.aBoolean894 = false;
                                                            else if (i != 89) {
                                                                if (i == 91) this.aBoolean942 = true;
                                                                else if (i == 93) {
                                                                    aByte886 = (byte) 3;
                                                                    anInt915 = packet.readUnsignedShort(842397944);
                                                                } else if (i == 94) aByte886 = (byte) 4;
                                                                else if (i == 95) {
                                                                    aByte886 = (byte) 5;
                                                                    anInt915 = packet.readShort(13638);
                                                                } else if (i != 97) {
                                                                    if (i != 98) {
                                                                        if (i == 99) {
                                                                            this.anInt950 = packet.readUnsignedByte(255);
                                                                            this.anInt869 = packet.readUnsignedShort(842397944);
                                                                        } else if (i == 100) {
                                                                            this.anInt951 = packet.readUnsignedByte(255);
                                                                            this.anInt877 = packet.readUnsignedShort(842397944);
                                                                        } else if (i != 101) {
                                                                            if (i == 102) this.anInt875 = packet.readUnsignedShort(842397944);
                                                                            else if (i != 103) {
                                                                                if (i == 104) this.anInt936 = packet.readUnsignedByte(255);
                                                                                else if (i != 105) {
                                                                                    if (i == 106) {
                                                                                        int i_39_ = packet.readUnsignedByte(255);
                                                                                        this.anIntArray943 = new int[i_39_];
                                                                                        anIntArray959 = new int[i_39_];
                                                                                        for (int i_40_ = 0; i_40_ < i_39_; i_40_++) {
                                                                                            this.anIntArray943[i_40_] = packet.readUnsignedShort(842397944);
                                                                                            int i_41_ = packet.readUnsignedByte(255);
                                                                                            anIntArray959[i_40_] = i_41_;
                                                                                            anInt911 += i_41_;
                                                                                        }
                                                                                    } else if (i != 107) {
                                                                                        if (i >= 150 && i < 155) {
                                                                                            this.aStringArray913[i + -150] = packet.readString((byte) -41);
                                                                                            if (!this.aObjectTypeList_933.aBoolean3359) this.aStringArray913[-150 + i] = null;
                                                                                        } else if (i == 160) {
                                                                                            int i_46_ = packet.readUnsignedByte(255);
                                                                                            this.anIntArray917 = new int[i_46_];
                                                                                            for (int i_47_ = 0; i_46_ > i_47_; i_47_++)
                                                                                                this.anIntArray917[i_47_] = packet.readUnsignedShort(842397944);
                                                                                        } else if (i == 162) {
                                                                                            aByte886 = (byte) 3;
                                                                                            anInt915 = packet.readInt((byte) -126);
                                                                                        } else if (i == 163) {
                                                                                            aByte944 = packet.readByte(-118);
                                                                                            aByte952 = packet.readByte(-83);
                                                                                            aByte879 = packet.readByte(-87);
                                                                                            aByte922 = packet.readByte(-111);
                                                                                        } else if (i != 164) {
                                                                                            if (i != 165) {
                                                                                                if (i != 166) {
                                                                                                    if (i == 167) this.anInt930 = packet.readUnsignedShort(842397944);
                                                                                                    else if (i != 168) {
                                                                                                        if (i != 169) {
                                                                                                            if (i != 170) {
                                                                                                                if (i == 171) this.anInt953 = packet.readSmart(-121);
                                                                                                                else if (i == 173) {
                                                                                                                    this.anInt878 = packet.readUnsignedShort(842397944);
                                                                                                                    this.anInt916 = packet.readUnsignedShort(842397944);
                                                                                                                } else if (i == 249) {
                                                                                                                    int i_42_ = packet.readUnsignedByte(255);
                                                                                                                    if (aClass356_881 == null) {
                                                                                                                        int i_43_ = EnumTypeList.method340(i_42_, (byte) 108);
                                                                                                                        aClass356_881 = new Class356(i_43_);
                                                                                                                    }
                                                                                                                    for (int i_44_ = 0; i_44_ < i_42_; i_44_++) {
                                                                                                                        boolean bool = packet.readUnsignedByte(255) == 1;
                                                                                                                        int i_45_ = packet.readMedium(-1);
                                                                                                                        Node node;
                                                                                                                        if (!bool) node = new Class348_Sub35(packet.readInt((byte) -126));
                                                                                                                        else node = new Class348_Sub50(packet.readString((byte) -87));
                                                                                                                        aClass356_881.method3483((byte) 86, i_45_, node);
                                                                                                                    }
                                                                                                                }
                                                                                                            } else this.anInt909 = packet.readSmart(-121);
                                                                                                        } else this.aBoolean903 = true;
                                                                                                    } else this.aBoolean888 = true;
                                                                                                } else anInt890 = packet.readShort(13638);
                                                                                            } else anInt954 = packet.readShort(13638);
                                                                                        } else anInt893 = packet.readShort(13638);
                                                                                    } else this.anInt921 = packet.readUnsignedShort(842397944);
                                                                                } else this.aBoolean925 = true;
                                                                            } else this.anInt955 = 0;
                                                                        } else this.anInt923 = packet.readUnsignedByte(255);
                                                                    } else this.aBoolean929 = true;
                                                                } else this.aBoolean912 = true;
                                                            } else this.aBoolean924 = false;
                                                        } else this.aBoolean931 = true;
                                                    } else {
                                                        anInt934 = packet.readUnsignedShort(842397944);
                                                        if (anInt934 == 65535) anInt934 = -1;
                                                        anInt939 = packet.readUnsignedShort(842397944);
                                                        if (anInt939 == 65535) anInt939 = -1;
                                                        int i_50_ = -1;
                                                        if (i == 92) {
                                                            i_50_ = packet.readUnsignedShort(842397944);
                                                            if (i_50_ == 65535) i_50_ = -1;
                                                        }
                                                        int i_51_ = packet.readUnsignedByte(255);
                                                        this.anIntArray945 = new int[2 + i_51_];
                                                        for (int i_52_ = 0; i_51_ >= i_52_; i_52_++) {
                                                            this.anIntArray945[i_52_] = packet.readUnsignedShort(842397944);
                                                            if (this.anIntArray945[i_52_] == 65535) this.anIntArray945[i_52_] = -1;
                                                        }
                                                        this.anIntArray945[i_51_ + 1] = i_50_;
                                                    }
                                                } else this.anInt895 = (packet.readUnsignedByte(255));
                                            } else anInt946 = ((packet.readShort(13638)) << 2);
                                        } else anInt900 = ((packet.readShort(13638)) << 2);
                                    } else anInt882 = (packet.readUnsignedShort(842397944));
                                } else anInt935 = (packet.readUnsignedShort(842397944));
                            } else this.aBoolean918 = false;
                        } else anInt949 = packet.readByte(-77);
                    } else this.anInt883 = (packet.readUnsignedByte(255) << 2);
                } else this.aBoolean906 = true;
            } else this.anInt874 = packet.readUnsignedByte(255);
        } else this.anInt926 = packet.readUnsignedByte(255);
        if (i_38_ >= -93) aByteArray885 = null;
    }

    final Model method483(int i, int i_63_, int i_64_, int i_65_, Toolkit var_toolkit, int i_66_, int i_67_, byte i_68_, Ground var_ground, int i_69_, int i_70_, int i_71_, AnimationType animationType, Ground var_ground_72_) {
        try {
            if (Class104.method955(22311, i_64_)) i_64_ = 4;
            anInt910++;
            long l = (this.anInt941 << 10) + ((i_64_ << 3) - -i_66_);
            int i_73_ = i_67_;
            l |= var_toolkit.anInt4567 << 29;
            if (animationType != null) i_67_ |= animationType.method263(i, 123, i_70_, false);
            if (aByte886 != 3) {
                if (aByte886 != 0 || anInt954 != 0) i_67_ |= 0x2;
                if (anInt893 != 0) i_67_ |= 0x1;
                if (anInt890 != 0) i_67_ |= 0x4;
            } else i_67_ |= 0x7;
            if (i_64_ == 10 && i_66_ > 3) i_67_ |= 0x5;
            Model model;
            synchronized (this.aObjectTypeList_933.aClass60_3362) {
                model = (Model) this.aObjectTypeList_933.aClass60_3362.method583(l, 100);
            }
            if (model == null || var_toolkit.method3667(model.ua(), i_67_) != 0) {
                if (model != null) i_67_ = var_toolkit.method3679(i_67_, model.ua());
                model = method477(i_66_, var_toolkit, i_64_, -125, i_67_);
                if (model == null) return null;
                synchronized (this.aObjectTypeList_933.aClass60_3362) {
                    this.aObjectTypeList_933.aClass60_3362.method582(model, l, (byte) -127);
                }
            }
            boolean bool = false;
            if (i_68_ <= 38) return null;
            if (animationType != null) {
                model = animationType.method266(model, 0x3 & i_66_, i, (byte) 1, i_70_, i_63_, 663780816, i_67_);
                bool = true;
            }
            if (i_64_ == 10 && i_66_ > 3) {
                if (!bool) {
                    model = model.method614((byte) 3, i_67_, true);
                    bool = true;
                }
                model.a(2048);
            }
            if (aByte886 != 0) {
                if (!bool) {
                    bool = true;
                    model = model.method614((byte) 3, i_67_, true);
                }
                model.p(aByte886, anInt915, var_ground_72_, var_ground, i_71_, i_65_, i_69_);
            }
            if (anInt893 != 0 || anInt954 != 0 || anInt890 != 0) {
                if (!bool) {
                    bool = true;
                    model = model.method614((byte) 3, i_67_, true);
                }
                model.H(anInt893, anInt954, anInt890);
            }
            if (bool) model.s(i_73_);
            return model;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("iv.L(" + i + ',' + i_63_ + ',' + i_64_ + ',' + i_65_ + ',' + (var_toolkit != null ? "{...}" : "null") + ',' + i_66_ + ',' + i_67_ + ',' + i_68_ + ',' + (var_ground != null ? "{...}" : "null") + ',' + i_69_ + ',' + i_70_ + ',' + i_71_ + ',' + (animationType != null ? "{...}" : "null") + ',' + (var_ground_72_ != null ? "{...}" : "null") + ')'));
        }
    }

    private final void method484(Packet packet, int i) {
        if (i != -528) method486(79);
        anInt871++;
        int i_74_ = packet.readUnsignedByte(255);
        for (int i_75_ = 0; i_75_ < i_74_; i_75_++) {
            packet.pos++;
            int i_76_ = packet.readUnsignedByte(i ^ ~0x2f0);
            packet.pos += i_76_ * 2;
        }
    }

    final boolean method485(int i) {
        anInt899++;
        if (i != 9773) method485(-109);
        if (anIntArrayArray907 == null) return true;
        boolean bool = true;
        synchronized (this.aObjectTypeList_933.aIndex_3345) {
            for (int i_77_ = 0; i_77_ < anIntArrayArray907.length; i_77_++) {
                for (int i_78_ = 0; (anIntArrayArray907[i_77_].length > i_78_); i_78_++)
                    bool &= (this.aObjectTypeList_933.aIndex_3345.requestDownload(-10499, anIntArrayArray907[i_77_][i_78_], 0));
            }
        }
        return bool;
    }

    public static void method486(int i) {
        aStringArray932 = null;
        if (i > -19) method486(-34);
        aMatrix_905 = null;
        renderer = null;
    }

    final int method487(int i, int i_79_, int i_80_) {
        int i_81_ = 81 % ((i_80_ - -53) / 44);
        anInt898++;
        if (aClass356_881 == null) return i_79_;
        Class348_Sub35 class348_sub35 = (Class348_Sub35) aClass356_881.method3480(i, -6008);
        if (class348_sub35 == null) return i_79_;
        return class348_sub35.anInt6976;
    }

    final void method488(int i) {
        if (this.anInt874 == -1) {
            this.anInt874 = 0;
            if (aByteArray885 != null && aByteArray885.length == 1 && aByteArray885[0] == 10) this.anInt874 = 1;
            for (int i_82_ = 0; i_82_ < 5; i_82_++) {
                if (this.aStringArray913[i_82_] != null) {
                    this.anInt874 = 1;
                    break;
                }
            }
        }
        anInt956++;
        int i_83_ = -118 / ((-55 - i) / 46);
        if (this.anInt895 == -1) this.anInt895 = this.anInt920 != 0 ? 1 : 0;
    }

    final int method489(int i) {
        anInt927++;
        if (this.anIntArray943 != null) {
            int i_84_ = (int) (Math.random() * (double) anInt911);
            int i_85_;
            for (i_85_ = 0; i_84_ >= anIntArray959[i_85_]; i_85_++)
                i_84_ -= anIntArray959[i_85_];
            return this.anIntArray943[i_85_];
        }
        if (i != -1) method483(-2, 60, -13, 88, null, -68, 4, (byte) 52, null, -111, -120, 102, null, null);
        return -1;
    }

    public Class51() {
        this.anInt869 = -1;
        anInt890 = 0;
        this.aBoolean896 = true;
        this.anInt874 = -1;
        anInt882 = 128;
        this.aString884 = "null";
        anInt880 = 0;
        aByte886 = (byte) 0;
        this.aBoolean888 = false;
        this.aBoolean906 = false;
        this.aBoolean903 = false;
        this.anInt877 = -1;
        this.anInt914 = 0;
        this.anInt875 = -1;
        this.aStringArray913 = new String[5];
        this.aBoolean912 = false;
        this.aBoolean894 = true;
        this.aBoolean924 = true;
        this.anInt923 = 0;
        anInt873 = 0;
        this.aBoolean931 = false;
        anInt911 = 0;
        this.anInt916 = 256;
        this.anInt921 = -1;
        anInt939 = -1;
        this.anInt883 = 64;
        this.anInt926 = 1;
        anInt928 = 128;
        this.anInt909 = 960;
        anInt934 = -1;
        this.anInt889 = 0;
        this.anInt895 = -1;
        aByte922 = (byte) 0;
        this.aBoolean947 = false;
        this.anInt878 = 256;
        anInt893 = 0;
        this.anInt936 = 255;
        this.anIntArray943 = null;
        this.aBoolean902 = false;
        this.aBoolean918 = true;
        anInt949 = 0;
        this.aBoolean942 = false;
        this.anInt953 = 0;
        anInt954 = 0;
        this.anInt937 = 0;
        anInt900 = 0;
        this.anInt930 = 0;
        anInt915 = -1;
        this.anInt951 = -1;
        this.anInt955 = -1;
        this.aBoolean925 = false;
        anInt946 = 0;
        this.anInt950 = -1;
        anIntArray959 = null;
        this.anInt920 = 2;
        this.anInt961 = 1;
        this.aBoolean929 = false;
        anInt935 = 128;
        this.anInt962 = 0;
        this.anInt887 = -1;
    }
}
