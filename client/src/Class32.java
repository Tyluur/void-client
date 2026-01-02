/* Class32 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class32 {
    static int anInt447;
    private final int anInt448;
    static int anInt449;
    static int anInt450;
    static int anInt451 = -1;
    private final LinkedNode[] aLinkedNodeArray452;
    private long aLong453;
    private LinkedNode aLinkedNode_454;
    static int anInt455;

    final LinkedNode method334(long l, byte i) {
        try {
            aLong453 = l;
            anInt449++;
            LinkedNode linkedNode = aLinkedNodeArray452[(int) ((long) (anInt448 - 1) & l)];
            for (aLinkedNode_454 = linkedNode.secondaryNext; linkedNode != aLinkedNode_454; aLinkedNode_454 = (aLinkedNode_454.secondaryNext)) {
                if (aLinkedNode_454.linkedKey == l) {
                    LinkedNode linkedNode_0_ = aLinkedNode_454;
                    aLinkedNode_454 = (aLinkedNode_454.secondaryNext);
                    return linkedNode_0_;
                }
            }
            if (i <= 0) aLinkedNode_454 = null;
            aLinkedNode_454 = null;
            return null;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, "ib.C(" + l + ',' + i + ')');
        }
    }

    final void method335(LinkedNode linkedNode, int i, long l) {
        try {
            anInt447++;
            if (i != -8098) aLinkedNode_454 = null;
            if (linkedNode.secondaryPrevious != null) linkedNode.unlinkSecondary(true);
            LinkedNode linkedNode_1_ = aLinkedNodeArray452[(int) (l & (long) (anInt448 - 1))];
            linkedNode.secondaryPrevious = linkedNode_1_.secondaryPrevious;
            linkedNode.secondaryNext = linkedNode_1_;
            linkedNode.secondaryPrevious.secondaryNext = linkedNode;
            linkedNode.secondaryNext.secondaryPrevious = linkedNode;
            linkedNode.linkedKey = l;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("ib.A(" + (linkedNode != null ? "{...}" : "null") + ',' + i + ',' + l + ')'));
        }
    }

    Class32(int i) {
        aLinkedNodeArray452 = new LinkedNode[i];
        anInt448 = i;
        for (int i_2_ = 0; i_2_ < i; i_2_++) {
            LinkedNode linkedNode = aLinkedNodeArray452[i_2_] = new LinkedNode();
            linkedNode.secondaryNext = linkedNode;
            linkedNode.secondaryPrevious = linkedNode;
        }
    }

    final LinkedNode method336(boolean bool) {
        anInt455++;
        if (aLinkedNode_454 == null) return null;
        if (bool != true) return null;
        for (LinkedNode linkedNode = aLinkedNodeArray452[(int) (aLong453 & (long) (-1 + anInt448))]; linkedNode != aLinkedNode_454; aLinkedNode_454 = (aLinkedNode_454.secondaryNext)) {
            if (aLong453 == aLinkedNode_454.linkedKey) {
                LinkedNode linkedNode_3_ = aLinkedNode_454;
                aLinkedNode_454 = (aLinkedNode_454.secondaryNext);
                return linkedNode_3_;
            }
        }
        aLinkedNode_454 = null;
        return null;
    }
}
