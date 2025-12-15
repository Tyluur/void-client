/* Class79 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

/*
    Class79
 */
final class NPCDefinition {
    byte walkMask;
    static int anInt1326;
    int anInt1327;
    private short[] aShortArray1328;
    int anInt1329;
    private byte aByte1330;
    boolean aBoolean1331;
    static int anInt1332;
    int anInt1333 = -1;
    static int anInt1334;
    int anInt1335;
    int anInt1336;
    int anInt1337;
    int anInt1338;
    short aShort1339;
    int anInt1340;
    static int anInt1341;
    int[] anIntArray1342;
    int anInt1343;
    int anInt1344;
    boolean aBoolean1345;
    private int anInt1346;
    byte aByte1347;
    NPCTypeList aNPCTypeList_1348;
    String[] aStringArray1349;
    short aShort1350 = 0;
    static int anInt1351;
    private short[] aShortArray1352;
    byte aByte1353;
    private int anInt1354;
    byte aByte1355;
    int anInt1356;
    static int anInt1357;
    private int anInt1358;
    static int anInt1359 = 0;
    private byte aByte1360;
    int anInt1361;
    boolean aBoolean1362;
    int anInt1363;
    int anInt1364;
    static Sprite aSprite_1365;
    int anInt1366;
    static client aClient1367;
    private int anInt1368;
    boolean aBoolean1369;
    boolean aBoolean1370;
    int anInt1371;
    String aString1372;
    int anInt1373;
    private byte[] aByteArray1374;
    int anInt1375;
    private byte aByte1376;
    int[] anIntArray1377;
    static int anInt1378;
    static int anInt1379;
    private int[] anIntArray1380;
    boolean aBoolean1381;
    int anInt1382;
    int anInt1383;
    byte aByte1384;
    int anInt1385;
    private Class356 aClass356_1386;
    static int anInt1387;
    private int[][] anIntArrayArray1388;
    static int anInt1389;
    int anInt1390;
    private short[] aShortArray1391;
    int anInt1392;
    private short[] aShortArray1393;
    static int anInt1394;
    int anInt1395;
    boolean aBoolean1396;
    boolean aBoolean1397;
    private int anInt1398;
    int size;
    static int anInt1400;
    int anInt1401;
    private int[] anIntArray1402;
    static int anInt1403;
    static int anInt1404;
    private byte aByte1405;
    private int anInt1406;

    final boolean method793(int i) {
        anInt1403++;
        if (this.anIntArray1377 == null) {
            return this.anInt1343 != -1 || this.anInt1364 != -1 || this.anInt1327 != -1;
        }
        for (int i_0_ = i; this.anIntArray1377.length > i_0_; i_0_++) {
            if (this.anIntArray1377[i_0_] != -1) {
                NPCDefinition NPCDefinition_1_ = (this.aNPCTypeList_1348.method2079(this.anIntArray1377[i_0_], -1));
                if (NPCDefinition_1_.anInt1343 != -1 || NPCDefinition_1_.anInt1364 != -1 || NPCDefinition_1_.anInt1327 != -1) return true;
            }
        }
        return false;
    }

    final NPCDefinition method794(Interface17 interface17, int i) {
        anInt1394++;
        int i_2_ = i;
        if (anInt1368 == -1) {
            if (anInt1354 != -1) i_2_ = interface17.method61(anInt1354, (byte) -16);
        } else i_2_ = interface17.method62(anInt1368, -65536);
        if (i_2_ < 0 || (-1 + this.anIntArray1377.length <= i_2_) || this.anIntArray1377[i_2_] == -1) {
            int i_3_ = (this.anIntArray1377[this.anIntArray1377.length - 1]);
            if (i_3_ == -1) return null;
            return this.aNPCTypeList_1348.method2079(i_3_, i);
        }
        return this.aNPCTypeList_1348.method2079(this.anIntArray1377[i_2_], -1);
    }

    private final void method795(Packet packet, int i, int i_4_) {
        if (i_4_ != 127) this.aBoolean1381 = true;
        if (i == 1) {
            int i_5_ = packet.readUnsignedByte(255);
            anIntArray1402 = new int[i_5_];
            for (int i_6_ = 0; i_5_ > i_6_; i_6_++) {
                anIntArray1402[i_6_] = packet.readUnsignedShort(842397944);
                if (anIntArray1402[i_6_] == 65535) anIntArray1402[i_6_] = -1;
            }
        } else if (i == 2) {
            this.aString1372 = packet.readString((byte) 122);
        } else {
            if (i != 12) {
                if (i < 30 || i >= 35) {
                    if (i == 40) {
                        int i_25_ = packet.readUnsignedByte(255);
                        aShortArray1328 = new short[i_25_];
                        aShortArray1352 = new short[i_25_];
                        for (int i_26_ = 0; i_26_ < i_25_; i_26_++) {
                            aShortArray1328[i_26_] = (short) packet.readUnsignedShort(842397944);
                            aShortArray1352[i_26_] = (short) packet.readUnsignedShort(842397944);
                        }
                    } else if (i == 41) {
                        int i_23_ = packet.readUnsignedByte(255);
                        aShortArray1393 = new short[i_23_];
                        aShortArray1391 = new short[i_23_];
                        for (int i_24_ = 0; i_24_ < i_23_; i_24_++) {
                            aShortArray1393[i_24_] = (short) packet.readUnsignedShort(842397944);
                            aShortArray1391[i_24_] = (short) packet.readUnsignedShort(842397944);
                        }
                    } else if (i == 42) {
                        int i_7_ = packet.readUnsignedByte(i_4_ ^ 0x80);
                        aByteArray1374 = new byte[i_7_];
                        for (int i_8_ = 0; i_8_ < i_7_; i_8_++)
                            aByteArray1374[i_8_] = packet.readByte(-88);
                    } else if (i == 60) {
                        int i_9_ = packet.readUnsignedByte(255);
                        anIntArray1380 = new int[i_9_];
                        for (int i_10_ = 0; i_9_ > i_10_; i_10_++)
                            anIntArray1380[i_10_] = packet.readUnsignedShort(842397944);
                    } else if (i != 93) {
                        if (i != 95) {
                            if (i != 97) {
                                if (i != 98) {
                                    if (i == 99) this.aBoolean1345 = true;
                                    else if (i != 100) {
                                        if (i == 101) anInt1406 = 5 * (packet.readByte(i_4_ ^ ~0x27));
                                        else if (i == 102) this.anInt1375 = (packet.readUnsignedShort(i_4_ + 842397817));
                                        else if (i == 103) this.anInt1329 = (packet.readUnsignedShort(842397944));
                                        else if ((i == 106) || i == 118) {
                                            anInt1368 = (packet.readUnsignedShort(842397944));
                                            if (anInt1368 == 65535) anInt1368 = -1;
                                            anInt1354 = (packet.readUnsignedShort(842397944));
                                            if (anInt1354 == 65535) anInt1354 = -1;
                                            int i_11_ = -1;
                                            if (i == 118) {
                                                i_11_ = (packet.readUnsignedShort(842397944));
                                                if (i_11_ == 65535) i_11_ = -1;
                                            }
                                            int i_12_ = packet.readUnsignedByte(255);
                                            this.anIntArray1377 = new int[2 + i_12_];
                                            for (int i_13_ = 0; i_13_ <= i_12_; i_13_++) {
                                                this.anIntArray1377[i_13_] = (packet.readUnsignedShort(842397944));
                                                if ((this.anIntArray1377[i_13_]) == 65535) this.anIntArray1377[i_13_] = -1;
                                            }
                                            this.anIntArray1377[1 + i_12_] = i_11_;
                                        } else if (i == 107) this.aBoolean1396 = false;
                                        else if (i != 109) {
                                            if (i == 111) this.aBoolean1369 = false;
                                            else if (i == 113) {
                                                this.aShort1339 = (short) (packet.readUnsignedShort(842397944));
                                                this.aShort1350 = (short) (packet.readUnsignedShort(842397944));
                                            } else if (i == 114) {
                                                this.aByte1353 = (packet.readByte(-110));
                                                this.aByte1347 = (packet.readByte(-85));
                                            } else if (i != 119) {
                                                if (i == 121) {
                                                    anIntArrayArray1388 = (new int
                                                            [anIntArray1402.length]
                                                            []);
                                                    int i_14_ = (packet.readUnsignedByte(255));
                                                    for (int i_15_ = 0; (i_14_ > i_15_); i_15_++) {
                                                        int i_16_ = (packet.readUnsignedByte(255));
                                                        int[] is = (anIntArrayArray1388[i_16_] = new int[3]);
                                                        is[0] = (packet.readByte(Class348_Sub21.method2955(i_4_, -50)));
                                                        is[1] = (packet.readByte(-113));
                                                        is[2] = (packet.readByte(-84));
                                                    }
                                                } else if (i == 122) this.anInt1373 = (packet.readUnsignedShort(842397944));
                                                else if (i != 123) {
                                                    if (i == 125) this.aByte1355 = (packet.readByte(-95));
                                                    else if (i == 127) this.anInt1366 = (packet.readUnsignedShort(i_4_ + 842397817));
                                                    else if (i != 128) {
                                                        if (i == 134) {
                                                            this.anInt1343 = packet.readUnsignedShort(842397944);
                                                            if (this.anInt1343 == 65535) this.anInt1343 = -1;
                                                            this.anInt1395 = packet.readUnsignedShort(842397944);
                                                            if (this.anInt1395 == 65535) this.anInt1395 = -1;
                                                            this.anInt1364 = packet.readUnsignedShort(842397944);
                                                            if (this.anInt1364 == 65535) this.anInt1364 = -1;
                                                            this.anInt1327 = packet.readUnsignedShort(i_4_ ^ 0x3235f887);
                                                            if (this.anInt1327 == 65535) this.anInt1327 = -1;
                                                            this.anInt1392 = packet.readUnsignedByte(255);
                                                        } else if (i == 135) {
                                                            this.anInt1335 = packet.readUnsignedByte(255);
                                                            this.anInt1371 = packet.readUnsignedShort(842397944);
                                                        } else if (i == 136) {
                                                            this.anInt1385 = packet.readUnsignedByte(255);
                                                            this.anInt1338 = packet.readUnsignedShort(842397944);
                                                        } else if (i != 137) {
                                                            if (i != 138) {
                                                                if (i != 139) {
                                                                    if (i != 140) {
                                                                        if (i == 141) this.aBoolean1362 = true;
                                                                        else if (i == 142) this.anInt1383 = packet.readUnsignedShort(842397944);
                                                                        else if (i != 143) {
                                                                            if (i >= 150 && i < 155) {
                                                                                this.aStringArray1349[-150 + i] = packet.readString((byte) -73);
                                                                                if (!this.aNPCTypeList_1348.aBoolean3583) this.aStringArray1349[i + -150] = null;
                                                                            } else if (i == 155) {
                                                                                aByte1376 = packet.readByte(i_4_ ^ ~0x16);
                                                                                aByte1360 = packet.readByte(-113);
                                                                                aByte1330 = packet.readByte(-112);
                                                                                aByte1405 = packet.readByte(-87);
                                                                            } else if (i == 158) this.aByte1384 = (byte) 1;
                                                                            else if (i != 159) {
                                                                                if (i == 160) {
                                                                                    int i_21_ = packet.readUnsignedByte(255);
                                                                                    this.anIntArray1342 = new int[i_21_];
                                                                                    for (int i_22_ = 0; i_22_ < i_21_; i_22_++)
                                                                                        this.anIntArray1342[i_22_] = packet.readUnsignedShort(i_4_ + 842397817);
                                                                                } else if (i == 162) this.aBoolean1370 = true;
                                                                                else if (i != 163) {
                                                                                    if (i == 164) {
                                                                                        this.anInt1340 = packet.readUnsignedShort(842397944);
                                                                                        this.anInt1363 = packet.readUnsignedShort(842397944);
                                                                                    } else if (i != 165) {
                                                                                        if (i == 249) {
                                                                                            int i_17_ = packet.readUnsignedByte(255);
                                                                                            if (aClass356_1386 == null) {
                                                                                                int i_18_ = EnumTypeList.method340(i_17_, (byte) 108);
                                                                                                aClass356_1386 = new Class356(i_18_);
                                                                                            }
                                                                                            for (int i_19_ = 0; i_17_ > i_19_; i_19_++) {
                                                                                                boolean bool = packet.readUnsignedByte(255) == 1;
                                                                                                int i_20_ = packet.readMedium(-1);
                                                                                                Node node;
                                                                                                if (!bool) node = new Class348_Sub35(packet.readInt((byte) -126));
                                                                                                else node = new Class348_Sub50(packet.readString((byte) -120));
                                                                                                aClass356_1386.method3483((byte) 61, i_20_, node);
                                                                                            }
                                                                                        }
                                                                                    } else this.anInt1337 = packet.readUnsignedByte(255);
                                                                                } else this.anInt1333 = packet.readUnsignedByte(i_4_ + 128);
                                                                            } else this.aByte1384 = (byte) 0;
                                                                        } else this.aBoolean1381 = true;
                                                                    } else this.anInt1356 = packet.readUnsignedByte(i_4_ + 128);
                                                                } else this.anInt1382 = packet.readUnsignedShort(i_4_ + 842397817);
                                                            } else this.anInt1336 = packet.readUnsignedShort(842397944);
                                                        } else this.anInt1401 = packet.readUnsignedShort(842397944);
                                                    } else packet.readUnsignedByte(255);
                                                } else this.anInt1390 = (packet.readUnsignedShort(i_4_ ^ 0x3235f887));
                                            } else this.walkMask = (packet.readByte(i_4_ + -245));
                                        } else this.aBoolean1331 = false;
                                    } else anInt1398 = packet.readByte(-123);
                                } else anInt1358 = (packet.readUnsignedShort(i_4_ + 842397817));
                            } else anInt1346 = packet.readUnsignedShort(842397944);
                        } else this.anInt1361 = packet.readUnsignedShort(842397944);
                    } else this.aBoolean1397 = false;
                } else this.aStringArray1349[-30 + i] = packet.readString((byte) 124);
            } else this.size = packet.readUnsignedByte(i_4_ + 128);
        }
        anInt1357++;
    }

    final boolean method796(Interface17 interface17, int i) {
        anInt1351++;
        if (this.anIntArray1377 == null) return true;
        int i_27_ = -1;
        if (anInt1368 != -1) i_27_ = interface17.method62(anInt1368, -65536);
        else if (anInt1354 != -1) i_27_ = interface17.method61(anInt1354, (byte) -16);
        if (i_27_ < 0 || (this.anIntArray1377.length - 1 <= i_27_) || this.anIntArray1377[i_27_] == -1) {
            int i_28_ = (this.anIntArray1377[this.anIntArray1377.length - 1]);
            return i_28_ != -1;
        }
        return i == 18627;
    }

    // method797
    static final void setSize(int height, int width, byte i_30_) {
        anInt1379++;
        if (TextureOpPolarDistortion.anInt9139 != width) {
            Class318_Sub6.anIntArray6432 = new int[width];
            for (int i_31_ = 0; i_31_ < width; i_31_++)
                Class318_Sub6.anIntArray6432[i_31_] = (i_31_ << 12) / width;
            Option_Sub22.anInt6076 = width + -1;
            TextureOpPolarDistortion.anInt9139 = width;
            Class248.anInt3201 = 32 * width;
        }
        if (i_30_ <= 108) aClient1367 = null;
        if (Class286_Sub2.anInt6212 != height) {
            if (TextureOpPolarDistortion.anInt9139 != height) {
                Option_Sub18.anIntArray6035 = new int[height];
                for (int i_32_ = 0; i_32_ < height; i_32_++)
                    Option_Sub18.anIntArray6035[i_32_] = (i_32_ << 12) / height;
            } else Option_Sub18.anIntArray6035 = Class318_Sub6.anIntArray6432;
            Class286_Sub2.anInt6212 = height;
            Class299_Sub2.anInt6325 = -1 + height;
        }
    }

    final void method798(int i, Packet packet) {
        for (; ; ) {
            int i_33_ = packet.readUnsignedByte(255);
            if (i_33_ == 0) break;
            method795(packet, i_33_, 127);
        }
        anInt1400++;
        if (i <= 35) method798(-16, null);
    }

    final void method799(int i) {
        if (anIntArray1402 == null) anIntArray1402 = new int[0];
        if (i >= -75) aByte1376 = (byte) 102;
        anInt1334++;
        if (this.aByte1384 == -1) {
            if (Class10.aClass230_186 == this.aNPCTypeList_1348.aClass230_3578) this.aByte1384 = (byte) 1;
            else this.aByte1384 = (byte) 0;
        }
    }

    final Model method800(int i, Class182[] class182s, AnimTypeList animTypeList, boolean bool, AnimationType animationType, int i_34_, BASTypeList BASTypeList, int i_35_, AnimationType animationType_36_, Interface17 interface17, Toolkit var_toolkit, int i_37_, int[] is, int i_38_, int i_39_, int i_40_, int i_41_) {
        try {
            anInt1341++;
            if (this.anIntArray1377 != null) {
                NPCDefinition NPCDefinition_42_ = method794(interface17, -1);
                if (NPCDefinition_42_ == null) return null;
                return NPCDefinition_42_.method800(i, class182s, animTypeList, false, animationType, i_34_, BASTypeList, i_35_, animationType_36_, interface17, var_toolkit, i_37_, is, i_38_, i_39_, i_40_, i_41_);
            }
            int i_43_ = i_40_;
            if (anInt1358 != 128) i_43_ |= 0x2;
            if (anInt1346 != 128) i_43_ |= 0x5;
            boolean bool_44_ = animationType_36_ != null || animationType != null;
            boolean bool_45_ = false;
            boolean bool_46_ = false;
            boolean bool_47_ = false;
            boolean bool_48_ = bool;
            int i_49_ = class182s == null ? 0 : class182s.length;
            for (int i_50_ = 0; i_50_ < i_49_; i_50_++) {
                Class318_Sub1_Sub3_Sub1.aClass348_Sub42_Sub17Array10010[i_50_] = null;
                if (class182s[i_50_] != null) {
                    AnimationType animationType_51_ = animTypeList.method835((class182s[i_50_].anInt2454), 7);
                    if (animationType_51_.frames != null) {
                        bool_44_ = true;
                        Class163.aAnimationTypeArray2169[i_50_] = animationType_51_;
                        int i_52_ = class182s[i_50_].anInt2451;
                        int i_53_ = class182s[i_50_].anInt2455;
                        int i_54_ = animationType_51_.frames[i_52_];
                        Class318_Sub1_Sub3_Sub1.aClass348_Sub42_Sub17Array10010[i_50_] = animTypeList.method839(i_54_ >>> 16, 3);
                        i_54_ &= 0xffff;
                        Class90.anIntArray1518[i_50_] = i_54_;
                        if ((Class318_Sub1_Sub3_Sub1.aClass348_Sub42_Sub17Array10010[i_50_]) != null) {
                            bool_46_ |= Class318_Sub1_Sub3_Sub1.aClass348_Sub42_Sub17Array10010[i_50_].method3272(i_54_, 0);
                            bool_45_ |= Class318_Sub1_Sub3_Sub1.aClass348_Sub42_Sub17Array10010[i_50_].method3271(i_54_, 14);
                            bool_48_ |= Class318_Sub1_Sub3_Sub1.aClass348_Sub42_Sub17Array10010[i_50_].method3267((byte) -92, i_54_);
                            bool_47_ |= animationType_51_.aBoolean242;
                        }
                        if ((animationType_51_.tweened || Class28.aBoolean5002) && i_53_ != -1 && i_53_ < (animationType_51_.frames).length) {
                            Class348_Sub23_Sub4.anIntArray9050[i_50_] = animationType_51_.durations[i_52_];
                            Class67.anIntArray4648[i_50_] = class182s[i_50_].anInt2456;
                            int i_55_ = animationType_51_.frames[i_53_];
                            Class348_Sub42_Sub17.aClass348_Sub42_Sub17Array9672[i_50_] = animTypeList.method839(i_55_ >>> 16, 3);
                            i_55_ &= 0xffff;
                            FloorUnderlayTypeList.anIntArray2466[i_50_] = i_55_;
                            if ((Class348_Sub42_Sub17.aClass348_Sub42_Sub17Array9672[i_50_]) != null) {
                                bool_46_ |= Class348_Sub42_Sub17.aClass348_Sub42_Sub17Array9672[i_50_].method3272(i_55_, 0);
                                bool_45_ |= Class348_Sub42_Sub17.aClass348_Sub42_Sub17Array9672[i_50_].method3271(i_55_, 14);
                                bool_48_ |= Class348_Sub42_Sub17.aClass348_Sub42_Sub17Array9672[i_50_].method3267((byte) -99, i_55_);
                            }
                        } else {
                            Class348_Sub23_Sub4.anIntArray9050[i_50_] = 0;
                            Class67.anIntArray4648[i_50_] = 0;
                            Class348_Sub42_Sub17.aClass348_Sub42_Sub17Array9672[i_50_] = null;
                            FloorUnderlayTypeList.anIntArray2466[i_50_] = -1;
                        }
                    }
                }
            }
            int i_56_ = -1;
            int i_57_ = -1;
            int i_58_ = 0;
            Class348_Sub42_Sub17 class348_sub42_sub17 = null;
            Class348_Sub42_Sub17 class348_sub42_sub17_59_ = null;
            int i_60_ = -1;
            int i_61_ = -1;
            int i_62_ = 0;
            Class348_Sub42_Sub17 class348_sub42_sub17_63_ = null;
            Class348_Sub42_Sub17 class348_sub42_sub17_64_ = null;
            if (bool_44_) {
                i_43_ |= 0x20;
                if (animationType_36_ != null) {
                    i_56_ = animationType_36_.frames[i_35_];
                    int i_65_ = i_56_ >>> 16;
                    i_56_ &= 0xffff;
                    class348_sub42_sub17 = animTypeList.method839(i_65_, 3);
                    if (class348_sub42_sub17 != null) {
                        bool_46_ |= class348_sub42_sub17.method3272(i_56_, 0);
                        bool_45_ |= class348_sub42_sub17.method3271(i_56_, 14);
                        bool_48_ |= class348_sub42_sub17.method3267((byte) -125, i_56_);
                        bool_47_ |= animationType_36_.aBoolean242;
                    }
                    if ((animationType_36_.tweened || Class28.aBoolean5002) && i_38_ != -1 && (animationType_36_.frames.length > i_38_)) {
                        i_57_ = animationType_36_.frames[i_38_];
                        i_58_ = animationType_36_.durations[i_35_];
                        int i_66_ = i_57_ >>> 16;
                        if (i_65_ == i_66_) class348_sub42_sub17_59_ = class348_sub42_sub17;
                        else class348_sub42_sub17_59_ = animTypeList.method839(i_66_, 3);
                        i_57_ &= 0xffff;
                        if (class348_sub42_sub17_59_ != null) {
                            bool_46_ |= class348_sub42_sub17_59_.method3272(i_57_, 0);
                            bool_45_ |= class348_sub42_sub17_59_.method3271(i_57_, 14);
                            bool_48_ |= class348_sub42_sub17_59_.method3267((byte) -122, i_57_);
                        }
                    }
                }
                if (animationType != null) {
                    i_60_ = animationType.frames[i_39_];
                    int i_67_ = i_60_ >>> 16;
                    class348_sub42_sub17_63_ = animTypeList.method839(i_67_, 3);
                    i_60_ &= 0xffff;
                    if (class348_sub42_sub17_63_ != null) {
                        bool_46_ |= class348_sub42_sub17_63_.method3272(i_60_, 0);
                        bool_45_ |= class348_sub42_sub17_63_.method3271(i_60_, 14);
                        bool_48_ |= class348_sub42_sub17_63_.method3267((byte) -102, i_60_);
                        bool_47_ |= animationType.aBoolean242;
                    }
                    if ((animationType.tweened || Class28.aBoolean5002) && i_37_ != -1 && animationType.frames.length > i_37_) {
                        i_62_ = animationType.durations[i_39_];
                        i_61_ = animationType.frames[i_37_];
                        int i_68_ = i_61_ >>> 16;
                        if (i_68_ == i_67_) class348_sub42_sub17_64_ = class348_sub42_sub17_63_;
                        else class348_sub42_sub17_64_ = animTypeList.method839(i_68_, 3);
                        i_61_ &= 0xffff;
                        if (class348_sub42_sub17_64_ != null) {
                            bool_46_ |= class348_sub42_sub17_64_.method3272(i_61_, 0);
                            bool_45_ |= class348_sub42_sub17_64_.method3271(i_61_, 14);
                            bool_48_ |= class348_sub42_sub17_64_.method3267((byte) -104, i_61_);
                        }
                    }
                }
                if (bool_46_) i_43_ |= 0x80;
                if (bool_45_) i_43_ |= 0x100;
                if (bool_47_) i_43_ |= 0x200;
                if (bool_48_) i_43_ |= 0x400;
            }
            long l = var_toolkit.anInt4567 << 16 | this.anInt1344;
            Model model;
            synchronized (this.aNPCTypeList_1348.aClass60_3590) {
                model = (Model) this.aNPCTypeList_1348.aClass60_3590.method583(l, 80);
            }
            Class225 class225 = null;
            if (this.anInt1366 != -1) class225 = BASTypeList.method1983(this.anInt1366, 32);
            if (model == null || i_43_ != (i_43_ & model.ua())) {
                if (model != null) i_43_ |= model.ua();
                int i_69_ = i_43_;
                boolean bool_70_ = false;
                synchronized (this.aNPCTypeList_1348.aIndex_3576) {
                    for (int i_71_ = 0; (anIntArray1402.length > i_71_); i_71_++) {
                        if (anIntArray1402[i_71_] != -1 && !(this.aNPCTypeList_1348.aIndex_3576.requestDownload(-10499, anIntArray1402[i_71_], 0))) bool_70_ = true;
                    }
                }
                if (bool_70_) return null;
                Mesh[] meshes = new Mesh[anIntArray1402.length];
                for (int i_72_ = 0; i_72_ < anIntArray1402.length; i_72_++) {
                    if (anIntArray1402[i_72_] != -1) {
                        synchronized (this.aNPCTypeList_1348.aIndex_3576) {
                            meshes[i_72_] = Class300.method2277(0, (this.aNPCTypeList_1348.aIndex_3576), anIntArray1402[i_72_], -1);
                        }
                        if (meshes[i_72_] != null) {
                            if (meshes[i_72_].version < 13) meshes[i_72_].method1092(2, 115);
                            if (anIntArrayArray1388 != null && anIntArrayArray1388[i_72_] != null) meshes[i_72_].translate((byte) 44, anIntArrayArray1388[i_72_][2], anIntArrayArray1388[i_72_][0], anIntArrayArray1388[i_72_][1]);
                        }
                    }
                }
                if (class225 != null && class225.anIntArrayArray2939 != null) {
                    for (int i_73_ = 0; (i_73_ < class225.anIntArrayArray2939.length); i_73_++) {
                        if (meshes.length > i_73_ && meshes[i_73_] != null) {
                            int i_74_ = 0;
                            int i_75_ = 0;
                            int i_76_ = 0;
                            int i_77_ = 0;
                            int i_78_ = 0;
                            int i_79_ = 0;
                            if ((class225.anIntArrayArray2939[i_73_]) != null) {
                                i_78_ = ((class225.anIntArrayArray2939[i_73_][4]) << 3);
                                i_79_ = ((class225.anIntArrayArray2939[i_73_][5]) << 3);
                                i_75_ = (class225.anIntArrayArray2939[i_73_][1]);
                                i_76_ = (class225.anIntArrayArray2939[i_73_][2]);
                                i_77_ = ((class225.anIntArrayArray2939[i_73_][3]) << 3);
                                i_74_ = (class225.anIntArrayArray2939[i_73_][0]);
                            }
                            if (i_77_ != 0 || i_78_ != 0 || i_79_ != 0) meshes[i_73_].rotate( i_78_, i_79_, i_77_);
                            if (i_74_ != 0 || i_75_ != 0 || i_76_ != 0) meshes[i_73_].translate((byte) 93, i_76_, i_74_, i_75_);
                        }
                    }
                }
                Mesh mesh;
                if (meshes.length == 1) mesh = meshes[0];
                else mesh = new Mesh(meshes, meshes.length);
                if (aShortArray1328 != null) i_69_ |= 0x4000;
                if (aShortArray1393 != null) i_69_ |= 0x8000;
                if (aByte1405 != 0) i_69_ |= 0x80000;
                model = var_toolkit.method3625(mesh, i_69_, (this.aNPCTypeList_1348.anInt3593), 64 + anInt1398, 850 + anInt1406);
                if (aShortArray1328 != null) {
                    for (int i_80_ = 0; (i_80_ < aShortArray1328.length); i_80_++) {
                        if (aByteArray1374 == null || aByteArray1374.length <= i_80_) model.ia(aShortArray1328[i_80_], aShortArray1352[i_80_]);
                        else model.ia(aShortArray1328[i_80_], (Class348_Sub42_Sub3.aShortArray9502[aByteArray1374[i_80_] & 0xff]));
                    }
                }
                if (aShortArray1393 != null) {
                    for (int i_81_ = 0; aShortArray1393.length > i_81_; i_81_++)
                        model.aa(aShortArray1393[i_81_], aShortArray1391[i_81_]);
                }
                if (aByte1405 != 0) model.method624(aByte1376, aByte1360, aByte1330, aByte1405 & 0xff);
                model.s(i_43_);
                synchronized (this.aNPCTypeList_1348.aClass60_3590) {
                    this.aNPCTypeList_1348.aClass60_3590.method582(model, this.anInt1344 | var_toolkit.anInt4567 << 16, (byte) -125);
                }
            }
            Model model_82_ = model.method614((byte) 4, i_43_, true);
            boolean bool_83_ = false;
            if (is != null) {
                for (int i_84_ = 0; i_84_ < 12; i_84_++) {
                    if (is[i_84_] != -1) bool_83_ = true;
                }
            }
            if (!bool_44_ && !bool_83_) return model_82_;
            Matrix[] matrices = null;
            if (class225 != null) matrices = class225.method1618(var_toolkit, 0);
            if (bool_83_ && matrices != null) {
                for (int i_85_ = 0; i_85_ < 12; i_85_++) {
                    if (matrices[i_85_] != null) model_82_.method610(matrices[i_85_], 1 << i_85_, true);
                }
            }
            int i_86_ = 0;
            int i_87_ = 1;
            while (i_86_ < i_49_) {
                if ((Class318_Sub1_Sub3_Sub1.aClass348_Sub42_Sub17Array10010[i_86_]) != null)
                    model_82_.method603((byte) -55, -1 + Class67.anIntArray4648[i_86_], null, i_87_, Class90.anIntArray1518[i_86_], FloorUnderlayTypeList.anIntArray2466[i_86_], (Class348_Sub42_Sub17.aClass348_Sub42_Sub17Array9672[i_86_]), 0, (Class318_Sub1_Sub3_Sub1.aClass348_Sub42_Sub17Array10010[i_86_]), (Class163.aAnimationTypeArray2169[i_86_].aBoolean242), Class348_Sub23_Sub4.anIntArray9050[i_86_]);
                i_86_++;
                i_87_ <<= 1;
            }
            if (bool_83_) {
                for (int i_88_ = 0; i_88_ < 12; i_88_++) {
                    if (is[i_88_] != -1) {
                        int i_89_ = -i + is[i_88_];
                        i_89_ &= 0x3fff;
                        Matrix matrix = var_toolkit.method3654();
                        matrix.method895(i_89_);
                        model_82_.method610(matrix, 1 << i_88_, false);
                    }
                }
            }
            if (bool_83_ && matrices != null) {
                for (int i_90_ = 0; i_90_ < 12; i_90_++) {
                    if (matrices[i_90_] != null) model_82_.method610(matrices[i_90_], 1 << i_90_, false);
                }
            }
            if (class348_sub42_sub17 != null && class348_sub42_sub17_63_ != null)
                model_82_.method625(class348_sub42_sub17_59_, i_58_, (byte) 122, i_62_, class348_sub42_sub17_63_, i_56_, i_60_, -1 + i_41_, class348_sub42_sub17, (animationType_36_.aBoolean242 | animationType.aBoolean242), i_57_, class348_sub42_sub17_64_, -1 + i_34_, animationType_36_.interleaveOrder, i_61_);
            else if (class348_sub42_sub17 != null) model_82_.method617(i_56_, i_58_, class348_sub42_sub17_59_, 0, class348_sub42_sub17, bool, animationType_36_.aBoolean242, i_57_, i_41_ + -1);
            else if (class348_sub42_sub17_63_ != null) model_82_.method617(i_60_, i_62_, class348_sub42_sub17_64_, 0, class348_sub42_sub17_63_, false, animationType.aBoolean242, i_61_, i_34_ - 1);
            for (int i_91_ = 0; i_49_ > i_91_; i_91_++) {
                Class318_Sub1_Sub3_Sub1.aClass348_Sub42_Sub17Array10010[i_91_] = null;
                Class348_Sub42_Sub17.aClass348_Sub42_Sub17Array9672[i_91_] = null;
                Class163.aAnimationTypeArray2169[i_91_] = null;
            }
            if (anInt1346 != 128 || anInt1358 != 128) model_82_.O(anInt1346, anInt1358, anInt1346);
            model_82_.s(i_40_);
            return model_82_;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("bb.F(" + i + ',' + (class182s != null ? "{...}" : "null") + ',' + (animTypeList != null ? "{...}" : "null") + ',' + bool + ',' + (animationType != null ? "{...}" : "null") + ',' + i_34_ + ',' + (BASTypeList != null ? "{...}" : "null") + ',' + i_35_ + ',' + (animationType_36_ != null ? "{...}" : "null") + ',' + (interface17 != null ? "{...}" : "null") + ',' + (var_toolkit != null ? "{...}" : "null") + ',' + i_37_ + ',' + (is != null ? "{...}" : "null") + ',' + i_38_ + ',' + i_39_ + ',' + i_40_ + ',' + i_41_ + ')'));
        }
    }

    final String method801(byte i, int i_92_, String string) {
        anInt1378++;
        if (aClass356_1386 == null) return string;
        if (i != 17) method801((byte) -115, -68, null);
        Class348_Sub50 class348_sub50 = ((Class348_Sub50) aClass356_1386.method3480(i_92_, i + -6025));
        if (class348_sub50 == null) return string;
        return class348_sub50.aString7211;
    }

    static final boolean method802(int y, int x, boolean bool) {
        if (bool != true) return false;
        anInt1332++;
        if (x < 0 || y < 0 || x >= AnimBase.tileFlags[1].length || y >= AnimBase.tileFlags[1][x].length) return false;
        return (AnimBase.tileFlags[1][x][y] & 0x2) != 0;
    }

    final Model method803(Interface17 interface17, Toolkit var_toolkit, int i, int i_94_, AnimationType animationType, AnimTypeList animTypeList, int i_95_, int i_96_, int i_97_) {
        try {
            anInt1389++;
            if (this.anIntArray1377 != null) {
                NPCDefinition NPCDefinition_98_ = method794(interface17, -1);
                if (NPCDefinition_98_ == null) return null;
                return NPCDefinition_98_.method803(interface17, var_toolkit, i, i_94_, animationType, animTypeList, i_95_, 104, i_97_);
            }
            if (i_96_ <= 98) method796(null, -10);
            if (anIntArray1380 == null) return null;
            int i_99_ = i_97_;
            if (animationType != null && i_95_ != -1) i_99_ |= animationType.method263(i_94_, 97, i_95_, true);
            Model model;
            synchronized (this.aNPCTypeList_1348.aClass60_3592) {
                model = ((Model) (this.aNPCTypeList_1348.aClass60_3592.method583(var_toolkit.anInt4567 << 16 | this.anInt1344, 64)));
            }
            if (model == null || i_99_ != (model.ua() & i_99_)) {
                if (model != null) i_99_ |= model.ua();
                int i_100_ = i_99_;
                boolean bool = false;
                synchronized (this.aNPCTypeList_1348.aIndex_3576) {
                    for (int i_101_ = 0; (anIntArray1380.length > i_101_); i_101_++) {
                        if (!this.aNPCTypeList_1348.aIndex_3576.requestDownload(-10499, anIntArray1380[i_101_], 0)) bool = true;
                    }
                }
                if (bool) return null;
                Mesh[] meshes = new Mesh[anIntArray1380.length];
                synchronized (this.aNPCTypeList_1348.aIndex_3576) {
                    for (int i_102_ = 0; (anIntArray1380.length > i_102_); i_102_++)
                        meshes[i_102_] = Class300.method2277(0, (this.aNPCTypeList_1348.aIndex_3576), anIntArray1380[i_102_], -1);
                }
                for (int i_103_ = 0; (i_103_ < anIntArray1380.length); i_103_++) {
                    if (meshes[i_103_] != null && meshes[i_103_].version < 13) meshes[i_103_].method1092(2, 66);
                }
                Mesh mesh;
                if (meshes.length == 1) mesh = meshes[0];
                else mesh = new Mesh(meshes, meshes.length);
                if (aShortArray1328 != null) i_100_ |= 0x4000;
                if (aShortArray1393 != null) i_100_ |= 0x8000;
                if (aByte1405 != 0) i_100_ |= 0x80000;
                model = var_toolkit.method3625(mesh, i_100_, (this.aNPCTypeList_1348.anInt3593), 64, 768);
                if (aShortArray1328 != null) {
                    for (int i_104_ = 0; (aShortArray1328.length > i_104_); i_104_++) {
                        if (aByteArray1374 != null && aByteArray1374.length > i_104_) model.ia(aShortArray1328[i_104_], (Class348_Sub42_Sub3.aShortArray9502[0xff & aByteArray1374[i_104_]]));
                        else model.ia(aShortArray1328[i_104_], aShortArray1352[i_104_]);
                    }
                }
                if (aShortArray1393 != null) {
                    for (int i_105_ = 0; aShortArray1393.length > i_105_; i_105_++)
                        model.aa(aShortArray1393[i_105_], aShortArray1391[i_105_]);
                }
                if (aByte1405 != 0) model.method624(aByte1376, aByte1360, aByte1330, aByte1405 & 0xff);
                model.s(i_99_);
                synchronized (this.aNPCTypeList_1348.aClass60_3592) {
                    this.aNPCTypeList_1348.aClass60_3592.method582(model, var_toolkit.anInt4567 << 16 | this.anInt1344, (byte) -96);
                }
            }
            if (animationType != null && i_95_ != -1) model = animationType.method269(-9, model, i_94_, i, i_99_, i_95_);
            model.s(i_97_);
            return model;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("bb.H(" + (interface17 != null ? "{...}" : "null") + ',' + (var_toolkit != null ? "{...}" : "null") + ',' + i + ',' + i_94_ + ',' + (animationType != null ? "{...}" : "null") + ',' + (animTypeList != null ? "{...}" : "null") + ',' + i_95_ + ',' + i_96_ + ',' + i_97_ + ')'));
        }
    }

    public static void method804(int i) {
        aSprite_1365 = null;
        aClient1367 = null;
        if (i != -3752) anInt1387 = 14;
    }

    final int method805(int i, int i_106_, int i_107_) {
        anInt1326++;
        if (aClass356_1386 == null) return i;
        if (i_107_ <= 12) method805(46, 116, 126);
        Class348_Sub35 class348_sub35 = (Class348_Sub35) aClass356_1386.method3480(i_106_, -6008);
        if (class348_sub35 == null) return i;
        return class348_sub35.anInt6976;
    }

    public NPCDefinition() {
        anInt1346 = 128;
        this.anInt1335 = -1;
        this.anInt1337 = 0;
        anInt1354 = -1;
        this.aBoolean1345 = false;
        this.anInt1336 = -1;
        this.aByte1355 = (byte) 4;
        this.anInt1356 = 255;
        this.anInt1340 = 256;
        this.anInt1373 = -1;
        this.anInt1375 = -1;
        this.anInt1338 = -1;
        this.anInt1363 = 256;
        this.aShort1339 = (short) 0;
        this.aStringArray1349 = new String[5];
        anInt1358 = 128;
        this.aByte1353 = (byte) -96;
        this.aBoolean1362 = false;
        this.anInt1343 = -1;
        this.aByte1384 = (byte) -1;
        this.aBoolean1381 = false;
        this.anInt1383 = -1;
        this.aString1372 = "null";
        this.anInt1382 = -1;
        this.anInt1371 = -1;
        this.walkMask = (byte) 0;
        anInt1368 = -1;
        this.anInt1390 = -1;
        this.aBoolean1331 = true;
        this.aByte1347 = (byte) -16;
        this.anInt1366 = -1;
        anInt1398 = 0;
        this.anInt1392 = 0;
        this.anInt1364 = -1;
        this.anInt1327 = -1;
        this.anInt1361 = -1;
        this.anInt1329 = 32;
        aByte1405 = (byte) 0;
        this.anInt1385 = -1;
        this.anInt1395 = -1;
        this.aBoolean1369 = true;
        this.size = 1;
        this.anInt1401 = -1;
        this.aBoolean1396 = true;
        this.aBoolean1397 = true;
        anInt1406 = 0;
    }
}
