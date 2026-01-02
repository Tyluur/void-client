/* Class348_Sub42 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Class348_Sub42
class LinkedNode extends Node {
    long linkedKey;
    static Class2 aClass2_7058;
    static int anInt7059 = 0;
    LinkedNode secondaryPrevious;
    static int anInt7061;
    static int anInt7062;
    LinkedNode secondaryNext;
    static int anInt7064;

    public static void method3161(int i) {
        if (i != 0) method3161(-27);
        aClass2_7058 = null;
    }

    final void unlinkSecondary(boolean bool) {
        anInt7064++;
        if (this.secondaryPrevious != null) {
            this.secondaryPrevious.secondaryNext = this.secondaryNext;
            this.secondaryNext.secondaryPrevious = this.secondaryPrevious;
            this.secondaryPrevious = null;
            this.secondaryNext = null;
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

    final boolean isSecondaryLinked(byte i) {
        anInt7061++;
        if (this.secondaryPrevious == null) return false;
        if (i != 1) unlinkSecondary(false);
        return true;
    }

    public LinkedNode() {
        /* empty */
    }

    static {
        aClass2_7058 = new Class2();
    }
}
