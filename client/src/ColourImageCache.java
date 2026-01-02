/* Class322 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Class322
final class ColourImageCache {
    static int anInt4018;
    static int anInt4019;
    private final int capacity;
    private Deque history;
    private int cachedId;
    static int anInt4023;
    private final int height;
    private int count = 0;
    static int anInt4026;
    static Class114 aClass114_4027;
    static int anInt4028;
    private int[][][] pixels;
    static int anInt4030;
    static int[] mapNpcs;
    static int anInt4032 = -1;
    private ColourImageCacheSlot[] slots;
    static int anInt4034;
    boolean dirty;
    static LRUHashTable aLRUHashTable_4036;

    static final int method2552(boolean bool, int i, int i_0_, int i_1_) {
        if (i_1_ != -24667) method2554((byte) 95);
        anInt4023++;
        Class348_Sub13 class348_sub13 = Class258_Sub4.method1974((byte) 4, i, bool);
        if (class348_sub13 == null) return -1;
        if (i_0_ < 0 || i_0_ >= class348_sub13.anIntArray6757.length) return -1;
        return class348_sub13.anIntArray6757[i_0_];
    }

    // method2553
    final int[][][] get() {
        anInt4018++;
        if (height != capacity) throw new RuntimeException("Can only retrieve a full image cache");
        for (int i = 0; i < capacity; i++)
            slots[i] = Class341.USED;
        return pixels;
    }

    static final void method2554(byte i) {
        if (i != -45) anInt4032 = 61;
        anInt4030++;
        if (Class312.anInt3931 == 1 || Class312.anInt3931 == 3 || (Class312.anInt3931 != Class83.anInt1447 && (Class312.anInt3931 == 0 || Class83.anInt1447 == 0))) {
            Class348_Sub32.anInt6930 = 0;
            IDKTypeList.anInt2057 = 0;
            Class282.aHashTable_3654.clear(0);
        }
        Class83.anInt1447 = Class312.anInt3931;
    }

    public static void method2555(byte i) {
        if (i != 28) method2554((byte) 21);
        mapNpcs = null;
        aClass114_4027 = null;
        aLRUHashTable_4036 = null;
    }

    static final void method2556(boolean bool, int i, Class318_Sub1_Sub3_Sub3 class318_sub1_sub3_sub3) {
        anInt4028++;
        int i_3_ = -1;
        int i_4_ = 0;
        if (Class367_Sub11.anInt7396 < class318_sub1_sub3_sub3.anInt10239) Option_Sub26.method1834(class318_sub1_sub3_sub3, (byte) -16);
        else if (Class367_Sub11.anInt7396 <= (class318_sub1_sub3_sub3.anInt10300)) Class110_Sub1.method1041(-1, class318_sub1_sub3_sub3);
        else {
            HitmarkTypeList.method1600(false, 0, class318_sub1_sub3_sub3);
            i_3_ = Class235.anInt3062;
            i_4_ = Class127_Sub1.anInt8387;
        }
        if (bool != false) aClass114_4027 = null;
        if ((class318_sub1_sub3_sub3.x < 512) || class318_sub1_sub3_sub3.y < 512 || (-512 + Class367_Sub4.mapLength * 512 <= class318_sub1_sub3_sub3.x) || (-512 + TextureOpBinary.mapWidth * 512 <= class318_sub1_sub3_sub3.y)) {
            class318_sub1_sub3_sub3.anInt10291 = -1;
            class318_sub1_sub3_sub3.anInt10300 = 0;
            i_4_ = 0;
            i_3_ = -1;
            class318_sub1_sub3_sub3.anIntArray10236 = null;
            class318_sub1_sub3_sub3.anInt10269 = -1;
            class318_sub1_sub3_sub3.anInt10286 = -1;
            class318_sub1_sub3_sub3.anInt10239 = 0;
            class318_sub1_sub3_sub3.x = (512 * (class318_sub1_sub3_sub3.anIntArray10320[0]) + 256 * class318_sub1_sub3_sub3.method2436((byte) 120));
            class318_sub1_sub3_sub3.y = (512 * (class318_sub1_sub3_sub3.anIntArray10317[0]) + class318_sub1_sub3_sub3.method2436((byte) 88) * 256);
            class318_sub1_sub3_sub3.method2427(70);
        }
        if ((Class132.aPlayer_1907 == class318_sub1_sub3_sub3) && (class318_sub1_sub3_sub3.x < 6144 || class318_sub1_sub3_sub3.y < 6144 || (class318_sub1_sub3_sub3.x >= 512 * (Class367_Sub4.mapLength + -12)) || (512 * (TextureOpBinary.mapWidth - 12) <= class318_sub1_sub3_sub3.y))) {
            class318_sub1_sub3_sub3.anInt10291 = -1;
            i_3_ = -1;
            class318_sub1_sub3_sub3.anInt10300 = 0;
            class318_sub1_sub3_sub3.anInt10269 = -1;
            class318_sub1_sub3_sub3.anInt10239 = 0;
            i_4_ = 0;
            class318_sub1_sub3_sub3.anIntArray10236 = null;
            class318_sub1_sub3_sub3.anInt10286 = -1;
            class318_sub1_sub3_sub3.x = (512 * (class318_sub1_sub3_sub3.anIntArray10320[0]) + 256 * class318_sub1_sub3_sub3.method2436((byte) 115));
            class318_sub1_sub3_sub3.y = (512 * (class318_sub1_sub3_sub3.anIntArray10317[0]) + 256 * class318_sub1_sub3_sub3.method2436((byte) 115));
            class318_sub1_sub3_sub3.method2427(54);
        }
        int i_5_ = Class348_Sub8.method2774((byte) 108, class318_sub1_sub3_sub3);
        za_Sub2.method3443(true, class318_sub1_sub3_sub3);
        Class71.method729(i_3_, i_5_, (byte) 67, class318_sub1_sub3_sub3, i_4_);
        Class348_Sub42_Sub9_Sub1.method3208(class318_sub1_sub3_sub3, i_3_, -98);
        Class230.method1635(-69, class318_sub1_sub3_sub3);
    }

    // method2557
    final int[][] get(int i, int index) {
        anInt4034++;
        if (i >= -75) method2554((byte) -61);
        if (capacity == height) {
            this.dirty = slots[index] == null;
            slots[index] = Class341.USED;
            return pixels[index];
        } else {
            if (capacity == 1) {
                this.dirty = index != cachedId;
                cachedId = index;
                return pixels[0];
            }
            ColourImageCacheSlot slot = slots[index];
            if (slot == null) {
                this.dirty = true;
                if (capacity <= count) {
                    ColourImageCacheSlot last = (ColourImageCacheSlot) history.last(-126);
                    slot = new ColourImageCacheSlot(index, last.slot);
                    slots[last.id] = null;
                    last.unlink((byte) 56);
                } else {
                    slot = new ColourImageCacheSlot(index, count);
                    count++;
                }
                slots[index] = slot;
            } else this.dirty = false;
            history.addFirst(slot, -110);
            return (pixels[slot.slot]);
        }
    }

    // method2558
    final void reset(int i) {
        anInt4019++;
        if (i != 6144) pixels = null;
        for (int i_8_ = 0; capacity > i_8_; i_8_++) {
            pixels[i_8_][0] = null;
            pixels[i_8_][1] = null;
            pixels[i_8_][2] = null;
            pixels[i_8_] = null;
        }
        slots = null;
        pixels = null;
        history.clear(99);
        history = null;
    }

    ColourImageCache(int i, int height, int width) {
        cachedId = -1;
        history = new Deque();
        this.dirty = false;
        capacity = i;
        this.height = height;
        slots = new ColourImageCacheSlot[this.height];
        pixels = new int[capacity][3][width];
    }

    static {
        aClass114_4027 = new Class114(90, 10);
        aLRUHashTable_4036 = new LRUHashTable(128);
    }
}
