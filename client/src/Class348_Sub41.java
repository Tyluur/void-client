/* Class348_Sub41 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class348_Sub41 extends Node {
    static int anInt7046;
    static int anInt7047;
    static String aString7048;
    static int anInt7049;
    int anInt7050;
    static int anInt7051;
    static Class114 aClass114_7052 = new Class114(86, 6);
    int anInt7053;
    static int anInt7054;
    static int anInt7055;
    /*synthetic*/ static Class aClass7056;

    static final boolean method3154(int i, int i_0_, int i_1_, int i_2_, byte[] is, byte i_3_) {
        anInt7047++;
        if (i_3_ != 39) aClass114_7052 = null;
        boolean bool = true;
        Packet packet = new Packet(is);
        int i_4_ = -1;
        for (; ; ) {
            int i_5_ = packet.method3334(107);
            if (i_5_ == 0) break;
            i_4_ += i_5_;
            int i_6_ = 0;
            boolean bool_7_ = false;
            for (; ; ) {
                if (bool_7_) {
                    int i_8_ = packet.readSmart(-118);
                    if (i_8_ == 0) break;
                    packet.readUnsignedByte(255);
                } else {
                    int i_9_ = packet.readSmart(i_3_ ^ ~0x58);
                    if (i_9_ == 0) break;
                    i_6_ += -1 + i_9_;
                    int i_10_ = i_6_ & 0x3f;
                    int i_11_ = i_6_ >> 6 & 0x3f;
                    int i_12_ = packet.readUnsignedByte(255) >> 2;
                    int i_13_ = i_11_ - -i_0_;
                    int i_14_ = i_2_ + i_10_;
                    if (i_13_ > 0 && i_14_ > 0 && i_13_ < -1 + i && -1 + i_1_ > i_14_) {
                        Class51 class51 = TextureOpColourGradient.objectTypeList.method2005(0, i_4_);
                        if (i_12_ != 22 || Class316.clientOptions.aClass239_Sub4_7220.method1737(-32350) != 0 || class51.anInt874 != 0 || (class51.anInt920 == 1) || class51.aBoolean947) {
                            bool_7_ = true;
                            if (!class51.method485(9773)) {
                                Class154.anInt2101++;
                                bool = false;
                            }
                        }
                    }
                }
            }
        }
        return bool;
    }

    public static void method3155(int i) {
        aString7048 = null;
        aClass114_7052 = null;
        if (i != -5) anInt7054 = 110;
    }

    static final int parseInt(boolean bool, String string) {
        anInt7055++;
        if (bool != true) aClass114_7052 = null;
        return Option_Sub26.parseInt(-123, 10, true, string);
    }

    static final void method3157(int i, byte i_15_, int i_16_, int i_17_, boolean bool) {
        anInt7049++;
        if (bool || i_16_ != Toolkit.anInt4581 || Class327.anInt4095 != i || (QuickChatPhraseTypeList.anInt4372 != JavaThreadResource.anInt2204 && Class316.clientOptions.aClass239_Sub27_7261.method1840(-32350) != 1)) {
            Toolkit.anInt4581 = i_16_;
            Class327.anInt4095 = i;
            JavaThreadResource.anInt2204 = QuickChatPhraseTypeList.anInt4372;
            if (Class316.clientOptions.aClass239_Sub27_7261.method1840(-32350) == 1) JavaThreadResource.anInt2204 = 0;
            Packet.setStep(2, i_17_);
            Class362.method3511(true, Applet_Sub1.aFontRenderer_20, Class246.aFontMetrics_3179, Class274.aClass274_3495.method2063(AnimBase.language, 544), 2, Class348_Sub8.active);
            int i_18_ = za_Sub2.regionTileX;
            int i_19_ = Class90.regionTileY;
            za_Sub2.regionTileX = (-(Class367_Sub4.mapLength >> 4) + Toolkit.anInt4581) * 8;
            Class90.regionTileY = 8 * (Class327.anInt4095 - (TextureOpBinary.mapWidth >> 4));
            Class348_Sub26.aClass348_Sub42_Sub14_6885 = Class75.method766(Toolkit.anInt4581 * 8, Class327.anInt4095 * 8);
            r_Sub2.aClass252_10488 = null;
            int i_20_ = za_Sub2.regionTileX - i_18_;
            int i_21_ = -i_19_ + Class90.regionTileY;
            if (i_17_ == 11) {
                for (int i_22_ = 0; Class348_Sub32.anInt6930 > i_22_; i_22_++) {
                    Class348_Sub22 class348_sub22 = TextureOpIrregularBricks.aClass348_Sub22Array9319[i_22_];
                    if (class348_sub22 != null) {
                        Npc npc = (class348_sub22.aNpc_6859);
                        for (int i_23_ = 0; i_23_ < 10; i_23_++) {
                            npc.anIntArray10320[i_23_] -= i_20_;
                            npc.anIntArray10317[i_23_] -= i_21_;
                        }
                        npc.y -= i_21_ * 512;
                        npc.x -= i_20_ * 512;
                    }
                }
            } else {
                IDKTypeList.anInt2057 = 0;
                boolean bool_24_ = false;
                int i_25_ = Class367_Sub4.mapLength * 512 - 512;
                int i_26_ = 512 * (-1 + TextureOpBinary.mapWidth);
                for (int i_27_ = 0; (Class348_Sub32.anInt6930 > i_27_); i_27_++) {
                    Class348_Sub22 class348_sub22 = TextureOpIrregularBricks.aClass348_Sub22Array9319[i_27_];
                    if (class348_sub22 != null) {
                        Npc npc = (class348_sub22.aNpc_6859);
                        npc.y -= 512 * i_21_;
                        npc.x -= 512 * i_20_;
                        if ((npc.x) < 0 || i_25_ < (npc.x) || (npc.y) < 0 || i_26_ < (npc.y)) {
                            npc.method2448(null, -2);
                            class348_sub22.unlink((byte) 80);
                            bool_24_ = true;
                        } else {
                            boolean bool_28_ = true;
                            for (int i_29_ = 0; i_29_ < 10; i_29_++) {
                                npc.anIntArray10320[i_29_] -= i_20_;
                                npc.anIntArray10317[i_29_] -= i_21_;
                                if ((npc.anIntArray10320[i_29_]) < 0 || ((npc.anIntArray10320[i_29_]) >= Class367_Sub4.mapLength) || (npc.anIntArray10317[i_29_]) < 0 || (TextureOpBinary.mapWidth <= (npc.anIntArray10317[i_29_])))
                                    bool_28_ = false;
                            }
                            if (!bool_28_) {
                                npc.method2448(null, -2);
                                bool_24_ = true;
                                class348_sub22.unlink((byte) 113);
                            } else Class74.anIntArray1233[IDKTypeList.anInt2057++] = (npc.anInt10290);
                        }
                    }
                }
                if (bool_24_) {
                    Class348_Sub32.anInt6930 = Class282.aHashTable_3654.size(1);
                    Class282.aHashTable_3654.toArray(3, TextureOpIrregularBricks.aClass348_Sub22Array9319);
                }
            }
            if (i_15_ > 122) {
                for (int i_30_ = 0; i_30_ < 2048; i_30_++) {
                    Player player = (Class294.aPlayerArray5058[i_30_]);
                    if (player != null) {
                        for (int i_31_ = 0; i_31_ < 10; i_31_++) {
                            player.anIntArray10320[i_31_] -= i_20_;
                            player.anIntArray10317[i_31_] -= i_21_;
                        }
                        player.x -= i_20_ * 512;
                        player.y -= 512 * i_21_;
                    }
                }
                Class302[] class302s = Class348_Sub27.aClass302Array6897;
                for (int i_32_ = 0; class302s.length > i_32_; i_32_++) {
                    Class302 class302 = class302s[i_32_];
                    if (class302 != null) {
                        class302.anInt3832 -= i_21_ * 512;
                        class302.anInt3835 -= 512 * i_20_;
                    }
                }
                for (Class348_Sub27 class348_sub27 = ((Class348_Sub27) Class348_Sub42_Sub20.aDeque_9711.method1995(4)); class348_sub27 != null; class348_sub27 = (Class348_Sub27) Class348_Sub42_Sub20.aDeque_9711.method1990((byte) 68)) {
                    class348_sub27.anInt6896 -= i_21_;
                    class348_sub27.anInt6905 -= i_20_;
                    if (Class312.anInt3931 != 4 && (class348_sub27.anInt6905 < 0 || class348_sub27.anInt6896 < 0 || (class348_sub27.anInt6905 >= Class367_Sub4.mapLength) || (TextureOpBinary.mapWidth <= (class348_sub27.anInt6896)))) class348_sub27.unlink((byte) 101);
                }
                if (Class312.anInt3931 != 4) {
                    for (Class348_Sub37 class348_sub37 = ((Class348_Sub37) Class130.aHashTable_1895.head(0)); class348_sub37 != null; class348_sub37 = ((Class348_Sub37) Class130.aHashTable_1895.next(0))) {
                        int i_33_ = (int) (0x3fffL & class348_sub37.key);
                        int i_34_ = -za_Sub2.regionTileX + i_33_;
                        int i_35_ = (int) (0x3fffL & (class348_sub37.key >> 14));
                        int i_36_ = i_35_ + -Class90.regionTileY;
                        if (i_34_ < 0 || i_36_ < 0 || (i_34_ >= Class367_Sub4.mapLength) || i_36_ >= TextureOpBinary.mapWidth) class348_sub37.unlink((byte) 37);
                    }
                }
                if (Class248.anInt3203 != 0) {
                    Class248.anInt3203 -= i_20_;
                    Class97.anInt1548 -= i_21_;
                }
                Class348_Sub17.method2928(true);
                if (i_17_ != 11) {
                    Class275.anInt3550 -= i_21_;
                    Class286_Sub4.anInt6246 -= 512 * i_20_;
                    Class352.anInt4336 -= i_20_;
                    Class281.anInt3647 -= i_21_;
                    Class348_Sub35.anInt6981 -= i_20_;
                    Class59_Sub2_Sub2.anInt8685 -= 512 * i_21_;
                    if ((Class367_Sub4.mapLength < Math.abs(i_20_)) || Math.abs(i_21_) > TextureOpBinary.mapWidth) Class76.method773(true);
                } else if (TextureOp37.anInt9282 == 4) {
                    Class348_Sub7.anInt6652 -= i_21_ * 512;
                    Class130_Sub1.anInt5799 -= i_20_ * 512;
                    Class192.anInt2578 -= 512 * i_21_;
                    MonochromeImageCacheSlot.anInt6633 -= i_20_ * 512;
                } else {
                    TextureOp37.anInt9282 = 1;
                    Class9.anInt167 = Class318_Sub1_Sub5_Sub2.anInt10163 = -1;
                }
                TextureOpRasterizer.method3153(0);
                Class50_Sub2.method464(-1);
                r_Sub2.aDeque_10492.clear(107);
                TextureOpSprite.aDeque_9240.clear(103);
                Class225.aClass243_2957.method1876((byte) -45);
                Class250.method1911((byte) 99);
            }
        }
    }

    static final byte[] decompress(byte[] is, int i) {
        anInt7046++;
        Packet packet = new Packet(is);
        int i_37_ = packet.readUnsignedByte(255);
        if (i > -74) parseInt(true, null);
        int i_38_ = packet.readInt((byte) -126);
        if (i_38_ < 0 || (Class29.anInt401 != 0 && i_38_ > Class29.anInt401)) {
            throw new RuntimeException();
        }
        if (i_37_ != 0) {
            int i_39_ = packet.readInt((byte) -126);
            if (i_39_ < 0 || (Class29.anInt401 != 0 && i_39_ > Class29.anInt401) || i_39_ > 10000000) {
                return new byte[4];
            }
            byte[] is_40_ = new byte[i_39_];
            if (i_37_ == 1) Class212.method1547(is_40_, i_39_, is, i_38_, 9);
            else {
                synchronized (AnimBase.aClass152_6955) {
                    AnimBase.aClass152_6955.method1218(is_40_, 29123, packet);
                }
            }
            return is_40_;
        }
        byte[] is_41_ = new byte[i_38_];
        packet.method3389(2147483647, 0, i_38_, is_41_);
        return is_41_;
    }

    static final void method3159(int i, int i_42_, boolean bool, int i_43_, int i_44_, int i_45_, Toolkit var_toolkit, int i_46_, int i_47_) {
        anInt7051++;
        Interface10 interface10 = (Interface10) r_Sub2.method3297(i_43_, i_45_, i_44_);
        if (interface10 != null) {
            Class51 class51 = TextureOpColourGradient.objectTypeList.method2005(0, interface10.method42(-124));
            int i_48_ = 0x3 & interface10.method41(-32228);
            int i_49_ = interface10.method39(35);
            if (class51.anInt875 == -1) {
                int i_50_ = i_47_;
                if (class51.anInt874 > 0) i_50_ = i;
                if (i_49_ == 0 || i_49_ == 2) {
                    if (i_48_ != 0) {
                        if (i_48_ == 1) var_toolkit.method3649((byte) -79, 4, i_42_, i_50_, i_46_);
                        else if (i_48_ == 2) var_toolkit.method3660(3 + i_46_, i_50_, 4, i_42_, true);
                        else if (i_48_ == 3) var_toolkit.method3649((byte) -121, 4, i_42_ + 3, i_50_, i_46_);
                    } else var_toolkit.method3660(i_46_, i_50_, 4, i_42_, !bool);
                }
                if (i_49_ == 3) {
                    if (i_48_ != 0) {
                        if (i_48_ == 1) var_toolkit.fillRect(1, (byte) -125, 3 + i_46_, i_42_, 1, i_50_);
                        else if (i_48_ != 2) {
                            if (i_48_ == 3) var_toolkit.fillRect(1, (byte) -125, i_46_, 3 + i_42_, 1, i_50_);
                        } else var_toolkit.fillRect(1, (byte) -125, 3 + i_46_, 3 + i_42_, 1, i_50_);
                    } else var_toolkit.fillRect(1, (byte) -125, i_46_, i_42_, 1, i_50_);
                }
                if (i_49_ == 2) {
                    if (i_48_ != 0) {
                        if (i_48_ == 1) var_toolkit.method3660(3 + i_46_, i_50_, 4, i_42_, true);
                        else if (i_48_ != 2) {
                            if (i_48_ == 3) var_toolkit.method3660(i_46_, i_50_, 4, i_42_, true);
                        } else var_toolkit.method3649((byte) -106, 4, 3 + i_42_, i_50_, i_46_);
                    } else var_toolkit.method3649((byte) -96, 4, i_42_, i_50_, i_46_);
                }
            } else Class267.method2028(i_46_, class51, i_42_, var_toolkit, i_48_, 126);
        }
        if (bool != false) anInt7054 = 122;
        interface10 = ((Interface10) Class177.method1353(i_43_, i_45_, i_44_, (aClass7056 != null ? aClass7056 : (aClass7056 = Interface10.class))));
        if (interface10 != null) {
            Class51 class51 = TextureOpColourGradient.objectTypeList.method2005(0, interface10.method42(-88));
            int i_51_ = interface10.method41(-32228) & 0x3;
            int i_52_ = interface10.method39(-126);
            if (class51.anInt875 != -1) Class267.method2028(i_46_, class51, i_42_, var_toolkit, i_51_, -86);
            else if (i_52_ == 9) {
                int i_53_ = -1118482;
                if (class51.anInt874 > 0) i_53_ = -1179648;
                if (i_51_ != 0 && i_51_ != 2) var_toolkit.method3645(i_42_, i_46_, 3 + i_46_, -8003, i_53_, i_42_ + 3);
                else var_toolkit.method3645(i_42_ + 3, i_46_, 3 + i_46_, -8003, i_53_, i_42_);
            }
        }
        interface10 = (Interface10) Class348_Sub16_Sub3.method2878(i_43_, i_45_, i_44_);
        if (interface10 != null) {
            Class51 class51 = TextureOpColourGradient.objectTypeList.method2005(0, interface10.method42(-118));
            int i_54_ = interface10.method41(-32228) & 0x3;
            if (class51.anInt875 != -1) Class267.method2028(i_46_, class51, i_42_, var_toolkit, i_54_, -5);
        }
    }

    public Class348_Sub41() {
        /* empty */
    }

}
