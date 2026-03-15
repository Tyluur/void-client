/* Class356 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class HashTable {
    Node[] buckets;
    static int anInt4375;
    static int anInt4376;
    int bucketCount;
    static int anInt4378;
    static int anInt4379;
    static int anInt4380;
    static int anInt4381;
    static int anInt4382;
    public static int randomSeed;
    static int anInt4384;
    private long searchKey;
    static int anInt4386;
    static int anInt4387;
    static Class114 aClass114_4388 = new Class114(3, 3);
    private Node searchCursor;
    private Node iteratorCursor;
    private int iteratorBucket = 0;

    final int size(int i) {
        if (i != 1) method3479(20);
        anInt4387++;
        int count = 0;
        for (int i_1_ = 0; this.bucketCount > i_1_; i_1_++) {
            Node node = this.buckets[i_1_];
            for (Node node_2_ = node.prev; node != node_2_; node_2_ = node_2_.prev)
                count++;
        }
        return count;
    }

    final int bucketCount(boolean bool) {
        anInt4376++;
        if (bool != true) method3478(false);
        return this.bucketCount;
    }

    final Node nextWithKey(boolean bool) {
        anInt4384++;
        if (searchCursor == null) return null;
        Node node = (this.buckets[(int) ((long) (this.bucketCount - 1) & searchKey)]);
        if (bool != true) method3479(4);
        for (/**/; searchCursor != node; searchCursor = searchCursor.prev) {
            if (searchCursor.key == searchKey) {
                Node node_3_ = searchCursor;
                searchCursor = searchCursor.prev;
                return node_3_;
            }
        }
        searchCursor = null;
        return null;
    }

    final int toArray(int i, Node[] nodes) {
        if (i != 3) randomSeed = -76;
        anInt4380++;
        int size = 0;
        for (int index = 0; this.bucketCount > index; index++) {
            Node node = this.buckets[index];
            for (Node next = node.prev; node != next; next = next.prev)
                nodes[size++] = next;
        }
        return size;
    }

    public static void method3478(boolean bool) {
        aClass114_4388 = null;
        if (bool != false) randomSeed = 67;
    }

    static final Class348_Sub21 method3479(int i) {
        anInt4378++;
        if (i != -1) randomSeed = 43;
        if (Class75.aDeque_1254 == null || r.aClass312_9716 == null) return null;
        for (Class348_Sub21 class348_sub21 = (Class348_Sub21) r.aClass312_9716.method2329(10); class348_sub21 != null; class348_sub21 = (Class348_Sub21) r.aClass312_9716.method2329(i ^ ~0xa)) {
            Class42 class42 = Class75.aMapElementTypeList_1238.method1225(class348_sub21.anInt6847, (byte) 92);
            if (class42 != null && class42.aBoolean609 && class42.method373(Class75.anInterface17_1244, 127)) return class348_sub21;
        }
        return null;
    }

    final Node get(long key, int i) {
        try {
            searchKey = key;
            anInt4379++;
            Node node = (this.buckets[(int) (key & (long) (this.bucketCount + -1))]);
            if (i != -6008) head(80);
            for (searchCursor = node.prev; searchCursor != node; searchCursor = searchCursor.prev) {
                if (searchCursor.key == key) {
                    Node value = searchCursor;
                    searchCursor = searchCursor.prev;
                    return value;
                }
            }
            searchCursor = null;
            return null;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, "eq.C(" + key + ',' + i + ')');
        }
    }

    final void clear(int i) {
        anInt4375++;
        for (int i_8_ = i; this.bucketCount > i_8_; i_8_++) {
            Node node = this.buckets[i_8_];
            for (; ; ) {
                Node node_9_ = node.prev;
                if (node_9_ == node) break;
                node_9_.unlink((byte) 54);
            }
        }
        searchCursor = null;
        iteratorCursor = null;
    }

    final Node next(int i) {
        anInt4381++;
        if (iteratorBucket > i && (iteratorCursor != this.buckets[-1 + iteratorBucket])) {
            Node node = iteratorCursor;
            iteratorCursor = node.prev;
            return node;
        }
        while (this.bucketCount > iteratorBucket) {
            Node node = (this.buckets[iteratorBucket++].prev);
            if (this.buckets[iteratorBucket - 1] != node) {
                iteratorCursor = node.prev;
                return node;
            }
        }
        return null;
    }

    final void put(byte i, long key, Node node) {
        try {
            anInt4382++;
            if (node.next != null) node.unlink((byte) 57);
            Node prev = (this.buckets[(int) (key & (long) (-1 + this.bucketCount))]);
            node.prev = prev;
            node.next = prev.next;
            node.next.prev = node;
            node.prev.next = node;
            node.key = key;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("eq.K(" + i + ',' + key + ',' + (node != null ? "{...}" : "null") + ')'));
        }
    }

    final Node head(int i) {
        iteratorBucket = i;
        anInt4386++;
        return next(0);
    }

    HashTable(int bucketCount) {
        this.bucketCount = bucketCount;
        this.buckets = new Node[bucketCount];
        for (int i = 0; bucketCount > i; i++) {
            Node node = this.buckets[i] = new Node();
            node.prev = node;
            node.next = node;
        }
    }
}
