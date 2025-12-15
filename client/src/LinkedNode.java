/* Class348_Sub42 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Class348_Sub42
class LinkedNode extends Node {
    long aLong7057;
    static Class2 aClass2_7058;
    static int anInt7059 = 0;
    LinkedNode aLinkedNode_7060;
    static int anInt7061;
    static int anInt7062;
    LinkedNode aLinkedNode_7063;
    static int anInt7064;

    public static void method3161(int i) {
        if (i != 0) method3161(-27);
        aClass2_7058 = null;
    }

    final void method3162(boolean bool) {
        anInt7064++;
        if (bool != true) method3163((byte) 50);
        if (this.aLinkedNode_7060 != null) {
            this.aLinkedNode_7060.aLinkedNode_7063 = this.aLinkedNode_7063;
            this.aLinkedNode_7063.aLinkedNode_7060 = this.aLinkedNode_7060;
            this.aLinkedNode_7060 = null;
            this.aLinkedNode_7063 = null;
        }
    }

    static final void method3163(byte i) {
        Class328_Sub1.anInt6513 = 0;
        anInt7062++;
        if (i == -114) {
            for (int i_0_ = 0; i_0_ < 2048; i_0_++) {
                Class154.aPacketArray2105[i_0_] = null;
                VarcTypeList.aByteArray3300[i_0_] = (byte) 1;
                Class348_Sub17.aClass359Array6802[i_0_] = null;
            }
        }
    }

    final boolean method3164(byte i) {
        anInt7061++;
        if (this.aLinkedNode_7060 == null) return false;
        if (i != 1) method3162(false);
        return true;
    }

    public LinkedNode() {
        /* empty */
    }

    static {
        aClass2_7058 = new Class2();
    }
}
