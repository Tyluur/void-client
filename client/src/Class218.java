/* Class218 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class218 {
    static int anInt2849;
    static int anInt2850;
    MSITypeList aMSITypeList_2851;
    static int anInt2852;
    int anInt2853;
    boolean aBoolean2854 = false;
    static int anInt2855;
    int anInt2856;
    static int anInt2857;
    static int anInt2858;
    static Deque aDeque_2859 = new Deque();
    static Class114 aClass114_2860;
    static int anInt2861 = 1401;

    static final void method1591(int i, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_, int i_5_, int i_6_, int i_7_) {
        anInt2855++;
        if (i >= 1 && i_5_ >= 1 && -2 + Class367_Sub4.mapLength >= i && i_5_ <= -2 + TextureOpBinary.mapWidth) {
            int i_8_ = i_7_;
            if (i_8_ < 3 && NPCDefinition.method802(i_5_, i, true)) i_8_++;
            if ((Class316.clientOptions.aClass239_Sub27_7261.method1840(-32350) == 0 && !Class58.method536(i_5_, false, i, JavaThreadResource.anInt2204, i_8_)) || Class147.aClass357ArrayArrayArray2029 == null) return;
            Class338.aClass237_Sub1_4197.method1694((MouseLog.collisionMaps[i_7_]), i_1_, i_7_, Class348_Sub8.active, i, i_5_, (byte) 106);
            if (i_3_ >= 0) {
                int i_9_ = Class316.clientOptions.aClass239_Sub4_7220.method1737(-32350);
                Class316.clientOptions.update((byte) 74, (Class316.clientOptions.aClass239_Sub4_7220), 1);
                Class338.aClass237_Sub1_4197.method1689(i, i_7_, i_3_, Class348_Sub8.active, i_8_, 50, i_4_, i_5_, i_2_, i_6_, (MouseLog.collisionMaps[i_7_]));
                Class316.clientOptions.update((byte) 74, (Class316.clientOptions.aClass239_Sub4_7220), i_9_);
            }
        }
        if (i_0_ < 12) aDeque_2859 = null;
    }

    static final void method1592(byte i, int i_10_, int i_11_, int i_12_, Player player) {
        anInt2849++;
        int i_13_ = (player.anIntArray10320[0]);
        int i_14_ = (player.anIntArray10317[0]);
        if (i_13_ >= 0 && Class367_Sub4.mapLength > i_13_ && i_14_ >= 0 && i_14_ < TextureOpBinary.mapWidth && (i_12_ >= 0 && i_12_ < Class367_Sub4.mapLength && i_10_ >= 0 && TextureOpBinary.mapWidth > i_10_)) {
            int i_15_ = (Class59_Sub2_Sub2.method574(i_12_, player.method2436((byte) 62), 0, TextureOpWeave.anIntArray9185, true, (byte) 120, -4, i_13_, i_14_, Class348_Sub42_Sub14.anIntArray9626, i_10_, (MouseLog.collisionMaps[(player.plane)]), 0, 0, 0));
            if (i_15_ >= 1) {
                if (i_11_ != 4) aDeque_2859 = null;
                if (i_15_ <= 3) {
                    for (int i_16_ = 0; i_16_ < -1 + i_15_; i_16_++)
                        player.method2451(i, Class348_Sub42_Sub14.anIntArray9626[i_16_], i_11_ + -29038, TextureOpWeave.anIntArray9185[i_16_]);
                }
            }
        }
    }

    public Class218() {
        /* empty */
    }

    final boolean method1593(int i) {
        if (i != 106) this.aMSITypeList_2851 = null;
        anInt2858++;
        return this.aMSITypeList_2851.aIndex_1965.fileReady(false, this.anInt2853);
    }

    public static void method1594(int i) {
        aDeque_2859 = null;
        if (i != -1966608624) aDeque_2859 = null;
        aClass114_2860 = null;
    }

    private final void method1595(byte i, int i_17_, Packet packet) {
        anInt2852++;
        if (i >= 5) {
            if (i_17_ == 1) this.anInt2853 = packet.readUnsignedShort(842397944);
            else if (i_17_ != 2) {
                if (i_17_ == 3) this.aBoolean2854 = true;
                else if (i_17_ == 4) this.anInt2853 = -1;
            } else this.anInt2856 = packet.readMedium(-1);
        }
    }

    final Sprite method1596(int i, boolean bool, int i_18_, Toolkit var_toolkit) {
        anInt2857++;
        if (i_18_ < 51) aClass114_2860 = null;
        long l = var_toolkit.anInt4567 << 19 | (this.anInt2853 | i << 16 | (!bool ? 0 : 262144));
        Sprite sprite = (Sprite) this.aMSITypeList_2851.aClass60_1976.method583(l, -87);
        if (sprite != null) return sprite;
        if (!this.aMSITypeList_2851.aIndex_1965.fileReady(false, this.anInt2853)) return null;
        IndexedImage indexedImage = IndexedImage.loadFirst(this.aMSITypeList_2851.aIndex_1965, this.anInt2853, 0);
        if (indexedImage != null) {
            indexedImage.innerHeight = indexedImage.offsetX = indexedImage.innerWidth = indexedImage.offsetY = 0;
            if (bool) indexedImage.method1514();
            for (int i_19_ = 0; i_19_ < i; i_19_++)
                indexedImage.method1520();
        }
        sprite = var_toolkit.method3691(indexedImage, true);
        if (sprite != null) this.aMSITypeList_2851.aClass60_1976.method582(sprite, l, (byte) -101);
        return sprite;
    }

    final void method1597(byte i, Packet packet) {
        anInt2850++;
        for (; ; ) {
            int i_20_ = packet.readUnsignedByte(255);
            if (i_20_ == 0) break;
            method1595((byte) 61, i_20_, packet);
        }
        if (i != -114) aDeque_2859 = null;
    }

    static {
        aClass114_2860 = new Class114(106, 8);
    }
}
