/* Class308 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class LRUHashTable {
    static int anInt3879;
    static int anInt3880;
    static int anInt3881;
    static byte[][] aByteArrayArray3882;
    static int[] anIntArray3883;
    static KeyLog[] KEYBOARD_EVENT_ARRAY_2 = new KeyLog[75];
    static int anInt3885;
    static int anInt3886;
    private LinkedNode aLinkedNode_3887 = new LinkedNode();
    private final HashTable table;
    private SecondaryLinkedList aSecondaryLinkedList_3889 = new SecondaryLinkedList();
    private final int capacity;
    private int available;

    final LinkedNode method2302(long l, byte i) {
        try {
            if (i > -25) aSecondaryLinkedList_3889 = null;
            anInt3885++;
            LinkedNode linkedNode = (LinkedNode) table.get(l, -6008);
            if (linkedNode != null) aSecondaryLinkedList_3889.addTail(true, linkedNode);
            return linkedNode;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, "wu.D(" + l + ',' + i + ')');
        }
    }

    final void method2303(boolean bool) {
        anInt3879++;
        if (bool != true) put(-121L, null, -1);
        aSecondaryLinkedList_3889.clear(2110355138);
        table.clear(0);
        aLinkedNode_3887 = new LinkedNode();
        available = capacity;
    }

    final void method2304(int i, long l) {
        do {
            try {
                anInt3880++;
                LinkedNode linkedNode = (LinkedNode) table.get(l, -6008);
                if (linkedNode != null) {
                    linkedNode.unlink((byte) 73);
                    linkedNode.unlinkSecondary(true);
                    available++;
                }
                if (i <= -110) break;
                method2304(36, -86L);
            } catch (RuntimeException runtimeexception) {
                throw Class348_Sub17.method2929(runtimeexception, "wu.C(" + i + ',' + l + ')');
            }
            break;
        } while (false);
    }

    final void put(long l, LinkedNode linkedNode, int i) {
        try {
            anInt3881++;
            if ((~available) == i) {
                LinkedNode linkedNode_0_ = aSecondaryLinkedList_3889.removeHead(20);
                linkedNode_0_.unlink((byte) 113);
                linkedNode_0_.unlinkSecondary(true);
                if (linkedNode_0_ == aLinkedNode_3887) {
                    linkedNode_0_ = aSecondaryLinkedList_3889.removeHead(20);
                    linkedNode_0_.unlink((byte) 79);
                    linkedNode_0_.unlinkSecondary(true);
                }
            } else available--;
            table.put((byte) 37, l, linkedNode);
            aSecondaryLinkedList_3889.addTail(true, linkedNode);
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("wu.E(" + l + ',' + (linkedNode != null ? "{...}" : "null") + ',' + i + ')'));
        }
    }

    public static void method2306(byte i) {
        if (i != -90) method2306((byte) -74);
        anIntArray3883 = null;
        KEYBOARD_EVENT_ARRAY_2 = null;
        aByteArrayArray3882 = null;
    }

    LRUHashTable(int capacity) {
        available = capacity;
        this.capacity = capacity;
        int buckets;
        for (buckets = 1; buckets + buckets < capacity; buckets += buckets) {
            /* empty */
        }
        table = new HashTable(buckets);
    }

    static {
        anIntArray3883 = new int[6];
    }
}
