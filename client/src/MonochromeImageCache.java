/* Class191 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Class191
final class MonochromeImageCache {
    static int anInt2556;
    private int count = 0;
    static int anInt2558;
    private final int capacity;
    static int anInt2560;
    private Deque history;
    private int cachedId = -1;
    private MonochromeImageCacheSlot[] slots;
    private int[][] output;
    private int height;
    static int anInt2566;
    static int anInt2567;
    static Class227 aClass227_2568 = new Class227(0);
    static int anInt2569;
    boolean dirty;
    static Class304 aClass304_2571 = new Class304(2);

    // method1427
    final int[][] get(byte i) {
        anInt2558++;
        if (capacity != height) throw new RuntimeException("Can only retrieve a full image cache");
        for (int i_0_ = 0; capacity > i_0_; i_0_++)
            slots[i_0_] = aa_Sub3.USED;
        if (i != 16) get((byte) -42);
        return output;
    }

    static final void method1428(boolean bool) {
        ModelParticleEffector.anImage4249 = null;
        anInt2569++;
        Class351.aFont4329 = null;
        if (bool != true) method1431(-122);
    }

    static final void method1429(String string, int i) {
        Class286_Sub2.method2144("", i, (byte) -125, 0, string, "", "");
        anInt2560++;
    }

    static final void method1430(int i, byte i_1_, int i_2_, int i_3_, int i_4_, int i_5_, int i_6_, int i_7_, Class318_Sub1_Sub3_Sub3 class318_sub1_sub3_sub3, Class318_Sub1_Sub3_Sub3 class318_sub1_sub3_sub3_8_) {
        try {
            anInt2567++;
            int i_9_ = class318_sub1_sub3_sub3.method2425(-1);
            if (i_9_ != -1) {
                Object object = null;
                Sprite sprite = ((Sprite) Class348_Sub1_Sub1.aClass60_8807.method583(i_9_, 118));
                if (sprite == null) {
                    Class207[] class207s = Class207.method1519(Class21.SPRITES, i_9_, 0);
                    if (class207s == null) return;
                    sprite = Class348_Sub8.active.method3691(class207s[0], true);
                    Class348_Sub1_Sub1.aClass60_8807.method582(sprite, i_9_, (byte) -115);
                }
                aa_Sub2.method165(class318_sub1_sub3_sub3_8_.plane, i_5_, 0, i_3_ >> 1, class318_sub1_sub3_sub3_8_.x, class318_sub1_sub3_sub3_8_.method2436((byte) 126) * 256, class318_sub1_sub3_sub3_8_.y, (byte) 92, i_6_ >> 1, i_2_);
                int i_10_ = i_7_ + (Option_Sub21.anIntArray6062[0] + -18);
                int i_11_ = -54 + (Option_Sub21.anIntArray6062[1] + i_4_) - 16;
                i_10_ += i / 4 * 18;
                i_11_ += 18 * (i % 4);
                int i_12_ = -76 / ((i_1_ - 3) / 38);
                sprite.method974(i_10_, i_11_);
                if (class318_sub1_sub3_sub3 == class318_sub1_sub3_sub3_8_) Class348_Sub8.active.method3668(18, -1 + i_11_, -256, i_10_ - 1, 18, 57);
                Class338.method2663(-5590, i_10_ + -1, 18 + i_10_, i_11_ + -1, i_11_ - -18);
                Class318_Sub6 class318_sub6 = Class367.method3529(32564);
                class318_sub6.anInt6426 = 16 + i_10_;
                class318_sub6.anInt6427 = i_11_;
                class318_sub6.aClass318_Sub1_Sub3_Sub3_6431 = class318_sub1_sub3_sub3;
                class318_sub6.anInt6425 = i_11_ - -16;
                class318_sub6.anInt6429 = i_10_;
                InputStream_Sub2.aClass243_83.method1869(-87, class318_sub6);
            }
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("qk.G(" + i + ',' + i_1_ + ',' + i_2_ + ',' + i_3_ + ',' + i_4_ + ',' + i_5_ + ',' + i_6_ + ',' + i_7_ + ',' + (class318_sub1_sub3_sub3 != null ? "{...}" : "null") + ',' + ((class318_sub1_sub3_sub3_8_ != null) ? "{...}" : "null") + ')'));
        }
    }

    public static void method1431(int i) {
        aClass304_2571 = null;
        aClass227_2568 = null;
        if (i != 0) aClass227_2568 = null;
    }

    // method1432
    final void reset(byte i) {
        for (int i_13_ = 0; i_13_ < capacity; i_13_++)
            output[i_13_] = null;
        anInt2556++;
        slots = null;
        output = null;
        history.clear(112);
        if (i != 124) height = -126;
        history = null;
    }

    // method1433
    final int[] get(int i, int index) {
        if (i != 0) get((byte) 108);
        anInt2566++;
        if (capacity == height) {
            this.dirty = slots[index] == null;
            slots[index] = aa_Sub3.USED;
            return output[index];
        }
        if (capacity != 1) {
            MonochromeImageCacheSlot slot = slots[index];
            if (slot == null) {
                this.dirty = true;
                if (count < capacity) {
                    slot = new MonochromeImageCacheSlot(index, count);
                    count++;
                } else {
                    MonochromeImageCacheSlot last = (MonochromeImageCacheSlot) history.last(i + -123);
                    slot = new MonochromeImageCacheSlot(index, last.slot);
                    slots[last.id] = null;
                    last.unlink((byte) 80);
                }
                slots[index] = slot;
            } else this.dirty = false;
            history.addFirst(slot, -90);
            return (output[slot.slot]);
        }
        this.dirty = index != cachedId;
        cachedId = index;
        return output[0];
    }

    MonochromeImageCache(int i, int height, int width) {
        history = new Deque();
        this.dirty = false;
        capacity = i;
        this.height = height;
        slots = new MonochromeImageCacheSlot[this.height];
        output = new int[capacity][width];
    }
}
