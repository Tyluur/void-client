/* Class42 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class42 {
    static int anInt562;
    static int anInt563;
    byte[] aByteArray564;
    String aString565;
    int anInt566;
    int anInt567;
    int anInt568;
    boolean aBoolean569;
    int anInt570 = -2147483648;
    static int anInt571;
    int[] anIntArray572;
    private int anInt573 = -1;
    boolean aBoolean574;
    int anInt575 = -1;
    int anInt576;
    String[] aStringArray577;
    int anInt578;
    static int anInt579;
    int anInt580;
    int anInt581;
    int anInt582;
    private int anInt583;
    int anInt584;
    private int anInt585;
    private int anInt586;
    private int anInt587;
    private HashTable aHashTable_588;
    static int anInt589;
    private int anInt590;
    int[] anIntArray591;
    private int anInt592;
    MapElementTypeList aMapElementTypeList_593;
    static int anInt594;
    int anInt595;
    int anInt596;
    String aString597;
    private int anInt598;
    boolean aBoolean599;
    static int anInt600;
    int anInt601;
    int anInt602;
    int anInt603;
    int anInt604;
    int anInt605;
    private int anInt606;
    int anInt607;
    static int anInt608;
    boolean aBoolean609;
    static int anInt610;

    final void method372(int i) {
        anInt608++;
        if (i != -25359) this.anInt578 = -106;
        if (this.anIntArray591 != null) {
            for (int i_0_ = 0; (this.anIntArray591.length > i_0_); i_0_ += 2) {
                if (this.anIntArray591[i_0_] >= this.anInt603) {
                    if (this.anIntArray591[i_0_] > this.anInt595) this.anInt595 = this.anIntArray591[i_0_];
                } else this.anInt603 = this.anIntArray591[i_0_];
                if (this.anIntArray591[i_0_ + 1] >= this.anInt607) {
                    if (this.anIntArray591[1 + i_0_] > this.anInt570) this.anInt570 = this.anIntArray591[i_0_ - -1];
                } else this.anInt607 = this.anIntArray591[i_0_ + 1];
            }
        }
    }

    final boolean method373(Interface17 interface17, int i) {
        anInt594++;
        int i_1_;
        if (anInt606 == -1) {
            if (anInt590 == -1) return true;
            i_1_ = interface17.method62(anInt590, -65536);
        } else i_1_ = interface17.method61(anInt606, (byte) -16);
        if (i_1_ < anInt585 || i_1_ > anInt592) return false;
        if (i < 26) anInt586 = 11;
        boolean bool = false;
        int i_2_;
        if (anInt583 == -1) {
            if (anInt573 != -1) i_2_ = interface17.method62(anInt573, -65536);
            else return true;
        } else i_2_ = interface17.method61(anInt583, (byte) -16);
        return i_2_ >= anInt587 && i_2_ <= anInt586;
    }

    final Sprite method374(boolean bool, Toolkit var_toolkit, byte i) {
        anInt579++;
        int i_3_ = bool ? this.anInt605 : this.anInt578;
        if (i != 127) return null;
        int i_4_ = i_3_ | var_toolkit.anInt4567 << 29;
        Sprite sprite = (Sprite) this.aMapElementTypeList_593.aClass60_2089.method583(i_4_, 64);
        if (sprite != null) return sprite;
        if (!this.aMapElementTypeList_593.aIndex_2087.fileReady(false, i_3_)) return null;
        Class207 class207 = Class207.method1521((this.aMapElementTypeList_593.aIndex_2087), i_3_, 0);
        if (class207 != null) {
            sprite = var_toolkit.method3691(class207, true);
            this.aMapElementTypeList_593.aClass60_2089.method582(sprite, i_4_, (byte) -111);
        }
        return sprite;
    }

    final Sprite method375(Toolkit var_toolkit, boolean bool) {
        anInt563++;
        if (bool != false) method375(null, true);
        Sprite sprite = (Sprite) (this.aMapElementTypeList_593.aClass60_2089.method583(anInt598 | 0x20000 | var_toolkit.anInt4567 << 29, -75));
        if (sprite != null) return sprite;
        this.aMapElementTypeList_593.aIndex_2087.fileReady(bool, anInt598);
        Class207 class207 = Class207.method1521((this.aMapElementTypeList_593.aIndex_2087), anInt598, 0);
        if (class207 != null) {
            sprite = var_toolkit.method3691(class207, true);
            this.aMapElementTypeList_593.aClass60_2089.method582(sprite, var_toolkit.anInt4567 << 29 | (anInt598 | 0x20000), (byte) -121);
        }
        return sprite;
    }

    final String method376(String string, int i, byte i_5_) {
        anInt589++;
        int i_6_ = -100 / ((63 - i_5_) / 58);
        if (aHashTable_588 == null) return string;
        Class348_Sub50 class348_sub50 = (Class348_Sub50) aHashTable_588.get(i, -6008);
        if (class348_sub50 == null) return string;
        return class348_sub50.aString7211;
    }

    private final void method377(int i, Packet packet, int i_7_) {
        anInt571++;
        if (i != 1) {
            if (i == 2) this.anInt605 = packet.readUnsignedShort(842397944);
            else if (i == 3) this.aString597 = packet.readString((byte) 93);
            else if (i != 4) {
                if (i == 5) this.anInt567 = packet.readMedium(-1);
                else if (i == 6) this.anInt576 = packet.readUnsignedByte(255);
                else if (i == 7) {
                    int i_8_ = packet.readUnsignedByte(255);
                    if ((0x1 & i_8_) == 0) this.aBoolean574 = false;
                    if ((i_8_ & 0x2) == 2) this.aBoolean569 = true;
                } else if (i == 8) this.aBoolean599 = packet.readUnsignedByte(255) == 1;
                else if (i == 9) {
                    anInt590 = packet.readUnsignedShort(842397944);
                    if (anInt590 == 65535) anInt590 = -1;
                    anInt606 = packet.readUnsignedShort(842397944);
                    if (anInt606 == 65535) anInt606 = -1;
                    anInt585 = packet.readInt((byte) -126);
                    anInt592 = packet.readInt((byte) -126);
                } else if (i >= 10 && i <= 14) this.aStringArray577[-10 + i] = packet.readString((byte) -45);
                else if (i == 15) {
                    int i_9_ = packet.readUnsignedByte(255);
                    this.anIntArray591 = new int[i_9_ * 2];
                    for (int i_10_ = 0; i_10_ < i_9_ * 2; i_10_++)
                        this.anIntArray591[i_10_] = packet.readShort(13638);
                    this.anInt582 = packet.readInt((byte) -126);
                    int i_11_ = packet.readUnsignedByte(255);
                    this.anIntArray572 = new int[i_11_];
                    for (int i_12_ = 0; (this.anIntArray572.length > i_12_); i_12_++)
                        this.anIntArray572[i_12_] = packet.readInt((byte) -126);
                    this.aByteArray564 = new byte[i_9_];
                    for (int i_13_ = 0; i_9_ > i_13_; i_13_++)
                        this.aByteArray564[i_13_] = packet.readByte(-107);
                } else if (i != 16) {
                    if (i == 17) this.aString565 = packet.readString((byte) 117);
                    else if (i == 18) anInt598 = packet.readUnsignedShort(842397944);
                    else if (i == 19) this.anInt596 = packet.readUnsignedShort(842397944);
                    else if (i == 20) {
                        anInt573 = packet.readUnsignedShort(842397944);
                        if (anInt573 == 65535) anInt573 = -1;
                        anInt583 = packet.readUnsignedShort(842397944);
                        if (anInt583 == 65535) anInt583 = -1;
                        anInt587 = packet.readInt((byte) -126);
                        anInt586 = packet.readInt((byte) -126);
                    } else if (i != 21) {
                        if (i == 22) this.anInt602 = packet.readInt((byte) -126);
                        else if (i == 23) {
                            this.anInt584 = packet.readUnsignedByte(255);
                            this.anInt575 = packet.readUnsignedByte(255);
                            this.anInt601 = packet.readUnsignedByte(255);
                        } else if (i == 24) {
                            this.anInt566 = packet.readShort(13638);
                            this.anInt568 = packet.readShort(13638);
                        } else if (i == 249) {
                            int i_14_ = packet.readUnsignedByte(255);
                            if (aHashTable_588 == null) {
                                int i_15_ = EnumTypeList.method340(i_14_, (byte) 108);
                                aHashTable_588 = new HashTable(i_15_);
                            }
                            for (int i_16_ = 0; (i_16_ < i_14_); i_16_++) {
                                boolean bool = (packet.readUnsignedByte(255) == 1);
                                int i_17_ = packet.readMedium(-1);
                                Node node;
                                if (!bool) node = (new Class348_Sub35(packet.readInt((byte) -126)));
                                else node = (new Class348_Sub50(packet.readString((byte) -41)));
                                aHashTable_588.put((byte) 60, i_17_, node);
                            }
                        }
                    } else this.anInt604 = packet.readInt((byte) -126);
                } else this.aBoolean609 = false;
            } else this.anInt580 = packet.readMedium(-1);
        } else this.anInt578 = packet.readUnsignedShort(842397944);
        if (i_7_ > -113) method375(null, true);
    }

    final int method378(int i, int i_18_, boolean bool) {
        anInt600++;
        if (aHashTable_588 == null) return i;
        if (bool != false) return -1;
        Class348_Sub35 class348_sub35 = (Class348_Sub35) aHashTable_588.get(i_18_, -6008);
        if (class348_sub35 == null) return i;
        return class348_sub35.anInt6976;
    }

    final void method379(Packet packet, int i) {
        if (i < 81) anInt590 = 17;
        anInt610++;
        for (; ; ) {
            int i_19_ = packet.readUnsignedByte(255);
            if (i_19_ == 0) break;
            method377(i_19_, packet, -121);
        }
    }

    public Class42() {
        this.aBoolean574 = true;
        this.anInt578 = -1;
        anInt583 = -1;
        this.anInt596 = -1;
        this.aBoolean599 = true;
        this.anInt567 = -1;
        this.anInt576 = 0;
        this.aStringArray577 = new String[5];
        anInt598 = -1;
        this.anInt595 = -2147483648;
        this.anInt584 = -1;
        this.anInt603 = 2147483647;
        anInt590 = -1;
        anInt606 = -1;
        this.aBoolean609 = true;
        this.aBoolean569 = false;
        this.anInt601 = -1;
        this.anInt607 = 2147483647;
        this.anInt605 = -1;
    }
}
