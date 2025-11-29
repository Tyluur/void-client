/* Class340 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.math.BigInteger;

final class Js5MasterIndex {
    private final Class248 aClass248_4212;
    private final BigInteger aBigInteger4213;
    static int anInt4214;
    private Packet aPacket_4215;
    private Js5ResourceProvider[] aClass314_Sub1Array4216;
    private Class112 aClass112_4217;
    private final BigInteger aBigInteger4218;
    static int anInt4219;
    private Class348_Sub42_Sub16_Sub1 aClass348_Sub42_Sub16_Sub1_4220;
    static int anInt4221;
    static int anInt4222;
    static Class351 aClass351_4223 = new Class351(4, 0);
    static int anInt4224;
    static Class351 aClass351_4225 = new Class351(43, -1);

    final void method2670(int i) {
        anInt4222++;
        if (aClass314_Sub1Array4216 != null) {
            for (int i_0_ = 0; (i_0_ < aClass314_Sub1Array4216.length); i_0_++) {
                if (aClass314_Sub1Array4216[i_0_] != null) aClass314_Sub1Array4216[i_0_].method2342(0);
            }
            for (int i_1_ = i; i_1_ < aClass314_Sub1Array4216.length; i_1_++) {
                if (aClass314_Sub1Array4216[i_1_] != null) aClass314_Sub1Array4216[i_1_].method2343(-1);
            }
        }
    }

    public static void method2671(int i) {
        aClass351_4225 = null;
        aClass351_4223 = null;
        if (i != 0) method2672(92, 5);
    }

    static final boolean method2672(int i, int i_2_) {
        anInt4224++;
        if (i_2_ >= -89) return true;
        return i == 7 || i == 8 || i == 9;
    }

    final Js5ResourceProvider method2673(Class137 class137, int i, Class137 class137_3_, int i_4_) {
        try {
            anInt4219++;
            if (i_4_ != 255) method2671(-43);
            return method2675((byte) -123, true, i, class137, class137_3_);
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("eb.D(" + (class137 != null ? "{...}" : "null") + ',' + i + ',' + (class137_3_ != null ? "{...}" : "null") + ',' + i_4_ + ')'));
        }
    }

    final boolean method2674(int i) {
        anInt4214++;
        if (aPacket_4215 != null) {
            return true;
        }
        if (aClass348_Sub42_Sub16_Sub1_4220 == null) {
            if (aClass248_4212.method1900(-71)) {
                return false;
            }
            aClass348_Sub42_Sub16_Sub1_4220 = aClass248_4212.method1906((byte) -84, (byte) 0, true, 255, 255);
        }
        if (aClass348_Sub42_Sub16_Sub1_4220.aBoolean9664) {
            return false;
        }
        Packet packet = new Packet(aClass348_Sub42_Sub16_Sub1_4220.method3259(i ^ 0x17));
        packet.pos = 5;
        int idxCount = packet.readUnsignedByte(i ^ 0xf8);
        packet.pos += idxCount * 72;
        byte[] is = new byte[(packet.aByteArray7154.length - packet.pos)];
        packet.method3389(2147483647, 0, is.length, is);
        byte[] is_6_;
        if (aBigInteger4213 != null && aBigInteger4218 != null) {
            BigInteger biginteger = new BigInteger(is);
            BigInteger biginteger_7_ = biginteger.modPow(aBigInteger4213, aBigInteger4218);
            is_6_ = biginteger_7_.toByteArray();
        } else {
            is_6_ = is;
        }
        if (is_6_.length != 65) {
            throw new RuntimeException();
        }
        byte[] is_8_ = Class348_Sub1_Sub2.method2730(4567, 5, (packet.aByteArray7154), (packet.pos) - (is.length + 5));
        for (int i_9_ = 0; i_9_ < 64; i_9_++) {
            if (is_8_[i_9_] != is_6_[i_9_ + 1]) {
                throw new RuntimeException();
            }
        }
        aPacket_4215 = packet;
        aClass314_Sub1Array4216 = new Js5ResourceProvider[idxCount];
        return true;
    }

    private final Js5ResourceProvider method2675(byte i, boolean bool, int i_10_, Class137 class137, Class137 class137_11_) {
        try {
            anInt4221++;
            if (aPacket_4215 == null) throw new RuntimeException();
            if (i_10_ < 0 || i_10_ >= aClass314_Sub1Array4216.length) throw new RuntimeException();
            if (aClass314_Sub1Array4216[i_10_] != null) return aClass314_Sub1Array4216[i_10_];
            aPacket_4215.pos = 6 + i_10_ * 72;
            int i_12_ = aPacket_4215.readInt((byte) -126);
            int i_13_ = aPacket_4215.readInt((byte) -126);
            byte[] is = new byte[64];
            aPacket_4215.method3389(2147483647, 0, 64, is);
            if (i >= -18) method2671(103);
            Js5ResourceProvider class314_sub1 = new Js5ResourceProvider(i_10_, class137, class137_11_, aClass248_4212, aClass112_4217, i_12_, is, i_13_, bool);
            aClass314_Sub1Array4216[i_10_] = class314_sub1;
            return class314_sub1;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("eb.E(" + i + ',' + bool + ',' + i_10_ + ',' + (class137 != null ? "{...}" : "null") + ',' + (class137_11_ != null ? "{...}" : "null") + ')'));
        }
    }

    // Class340
    Js5MasterIndex(Class248 class248, Class112 class112, BigInteger biginteger, BigInteger biginteger_14_) {
        do {
            try {
                aClass112_4217 = class112;
                aBigInteger4218 = biginteger_14_;
                aBigInteger4213 = biginteger;
                aClass248_4212 = class248;
                if (aClass248_4212.method1900(-31)) break;
                aClass348_Sub42_Sub16_Sub1_4220 = aClass248_4212.method1906((byte) -80, (byte) 0, true, 255, 255);
            } catch (RuntimeException runtimeexception) {
                throw Class348_Sub17.method2929(runtimeexception, ("eb.<init>(" + (class248 != null ? "{...}" : "null") + ',' + (class112 != null ? "{...}" : "null") + ',' + (biginteger != null ? "{...}" : "null") + ',' + (biginteger_14_ != null ? "{...}" : "null") + ')'));
            }
            break;
        } while (false);
    }
}
