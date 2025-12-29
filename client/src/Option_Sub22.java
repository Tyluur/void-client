/* Class239_Sub22 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Option_Sub22 extends Option {
    static int anInt6070;
    static int anInt6071;
    static int anInt6072;
    static int anInt6073;
    static int anInt6074;
    static Class114 aClass114_6075 = new Class114(89, 0);
    static int widthMask;

    final int method1710(int i) {
        anInt6072++;
        if (i != 20014) return 63;
        return 1;
    }

    final void method1716(boolean bool) {
        if (this.anInt3138 != 1 && this.anInt3138 != 0) this.anInt3138 = method1710(20014);
        anInt6070++;
        if (bool != false) widthMask = 59;
    }

    final void method1712(int i, int i_0_) {
        anInt6074++;
        this.anInt3138 = i_0_;
        int i_1_ = 126 / ((82 - i) / 35);
    }

    Option_Sub22(ClientOptions clientOptions) {
        super(clientOptions);
    }

    final int method1815(int i) {
        if (i != -32350) method1816(84);
        anInt6071++;
        return this.anInt3138;
    }

    Option_Sub22(int i, ClientOptions clientOptions) {
        super(clientOptions);
    }

    public static void method1816(int i) {
        aClass114_6075 = null;
        if (i != 1) aClass114_6075 = null;
    }

    final int method1714(int i, int i_2_) {
        anInt6073++;
        if (i != 3) widthMask = -121;
        return 1;
    }
}
