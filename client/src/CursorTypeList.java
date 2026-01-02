/* Class166 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.io.File;

final class CursorTypeList {
    static int anInt2178;
    static int anInt2179;
    Index aIndex_2180;
    static int anInt2181;
    static int anInt2182;
    static Class114 aClass114_2183 = new Class114(0, -1);
    static int anInt2184;
    private final Class60 aClass60_2185 = new Class60(64);
    static int anInt2186;
    static Deque aDeque_2187 = new Deque();
    private final Index aIndex_2188;
    static int anInt2189;
    Class60 aClass60_2190 = new Class60(2);

    final void method1283(int i) {
        synchronized (aClass60_2185) {
            aClass60_2185.method587(-76);
        }
        anInt2178++;
        synchronized (this.aClass60_2190) {
            this.aClass60_2190.method587(-110);
        }
        if (i != 1) method1286(null, -124, null);
    }

    public static void method1284(int i) {
        aClass114_2183 = null;
        if (i == -21165) aDeque_2187 = null;
    }

    final void method1285(int i, int i_0_) {
        anInt2189++;
        synchronized (aClass60_2185) {
            aClass60_2185.method578(2, i);
        }
        synchronized (this.aClass60_2190) {
            if (i_0_ != 8) this.aIndex_2180 = null;
            this.aClass60_2190.method578(i_0_ + -6, i);
        }
    }

    static final void method1286(File file, int i, String string) {
        do {
            try {
                anInt2181++;
                Class275.aHashtable3548.put(string, file);
                if (i == 64) break;
                aClass114_2183 = null;
            } catch (RuntimeException runtimeexception) {
                throw Class348_Sub17.method2929(runtimeexception, ("pg.F(" + (file != null ? "{...}" : "null") + ',' + i + ',' + (string != null ? "{...}" : "null") + ')'));
            }
            break;
        } while (false);
    }

    final Class222 method1287(byte i, int i_1_) {
        anInt2182++;
        Class222 class222;
        synchronized (aClass60_2185) {
            class222 = (Class222) aClass60_2185.method583(i_1_, i ^ ~0x1d);
        }
        if (class222 != null) return class222;
        if (i != -104) this.aClass60_2190 = null;
        byte[] is;
        synchronized (aIndex_2188) {
            is = aIndex_2188.file(-1860, 33, i_1_);
        }
        class222 = new Class222();
        class222.aCursorTypeList_2886 = this;
        if (is != null) class222.method1611(new Packet(is), false);
        synchronized (aClass60_2185) {
            aClass60_2185.method582(class222, i_1_, (byte) -116);
        }
        return class222;
    }

    static final void method1288(int i, int i_2_) {
        anInt2186++;
        for (Node node = QuickChatCatTypeList.aHashTable_2959.head(0); node != null; node = QuickChatCatTypeList.aHashTable_2959.next(0)) {
            if ((node.key >> 48 & 0xffffL) == (long) i_2_) node.unlink((byte) 119);
        }
    }

    static final void method1289(int i, int i_3_, int i_4_, int i_5_, int i_6_) {
        anInt2179++;
        int i_7_ = Class26.anInt385;
        if (i_5_ != 8) method1284(-59);
        int i_8_ = Class93.anInt1534;
        if (Class59_Sub1.aBoolean5300) {
            i_7_ += s_Sub3.method4008((byte) -126);
            i_8_ += Class16.method260(false);
        }
        if (Option_Sub20.anInt6048 == 1) {
            Sprite sprite = (TextureOpBoxBlur.aSpriteArray9467[Node.anInt4292 / 100]);
            sprite.method974(i_7_ - 8, i_8_ + -8);
            Class338.method2663(-5590, -8 + i_7_, -8 + (i_7_ - -sprite.scaleWidth()), -8 + i_8_, sprite.scaleHeight() + -8 + i_8_);
        }
        if (Option_Sub20.anInt6048 == 2) {
            Sprite sprite = (TextureOpBoxBlur.aSpriteArray9467[Node.anInt4292 / 100 + 4]);
            sprite.method974(i_7_ + -8, -8 + i_8_);
            Class338.method2663(-5590, i_7_ - 8, sprite.scaleWidth() + i_7_ + -8, -8 + i_8_, sprite.scaleHeight() + -8 + i_8_);
        }
        Class289.method2192((byte) 80);
    }

    final void method1290(int i) {
        anInt2184++;
        synchronized (aClass60_2185) {
            aClass60_2185.method590(0);
        }
        synchronized (this.aClass60_2190) {
            this.aClass60_2190.method590(0);
            if (i != -8) aClass114_2183 = null;
        }
    }

    // Class166
    CursorTypeList(Class230 class230, int i, Index index, Index index_9_) {
        try {
            aIndex_2188 = index;
            this.aIndex_2180 = index_9_;
            aIndex_2188.fileLimit(0, 33);
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("pg.<init>(" + (class230 != null ? "{...}" : "null") + ',' + i + ',' + (index != null ? "{...}" : "null") + ',' + (index_9_ != null ? "{...}" : "null") + ')'));
        }
    }
}
