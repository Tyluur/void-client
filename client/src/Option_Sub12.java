/* Class239_Sub12 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Option_Sub12 extends Option {
    static int anInt5960;
    static int anInt5961;
    static int anInt5962;
    static int anInt5963;
    static Index aIndex_5964;
    static int anInt5965;
    static String aString5966 = null;
    static int anInt5967;
    static int anInt5968;
    static int anInt5969;
    static int anInt5970;
    static long aLong5971;
    static int anInt5972;
    static int anInt5973;

    final int method1714(int i, int i_0_) {
        anInt5972++;
        if (i != 3) return 121;
        if (!Node.method2714(7351, this.aClientOptions_3136.aClass239_Sub25_7271.method1829(-32350))) return 3;
        return 1;
    }

    final int method1771(int i) {
        anInt5960++;
        if (i != -32350) method1714(80, -99);
        return this.anInt3138;
    }

    final void method1712(int i, int i_1_) {
        int i_2_ = -19 % ((82 - i) / 35);
        this.anInt3138 = i_1_;
        anInt5963++;
    }

    static final void method1772(int i) {
        anInt5968++;
        VideoType videoType = (VideoType) Class27.aHashTable_389.head(0);
        if (i <= 4) aString5966 = null;
        for (/**/; videoType != null; videoType = (VideoType) Class27.aHashTable_389.next(0))
            Class64_Sub3.method690((byte) 108, (videoType.anInt6773));
    }

    public static void method1773(byte i) {
        int i_3_ = -86 / ((i - 13) / 45);
        aString5966 = null;
        aIndex_5964 = null;
    }

    Option_Sub12(ClientOptions clientOptions) {
        super(clientOptions);
    }

    final void method1716(boolean bool) {
        if (bool != false) method1716(false);
        anInt5962++;
        if (this.aClientOptions_3136.aClass239_Sub25_7271.method1830((byte) -119) && !Node.method2714(7351, this.aClientOptions_3136.aClass239_Sub25_7271.method1829(-32350))) this.anInt3138 = 0;
        if (this.anInt3138 < 0 || this.anInt3138 > 1) this.anInt3138 = method1710(20014);
    }

    Option_Sub12(int i, ClientOptions clientOptions) {
        super(i, clientOptions);
    }

    final boolean method1774(int i) {
        if (i < 85) method1773((byte) 116);
        anInt5961++;
        return Node.method2714(7351, this.aClientOptions_3136.aClass239_Sub25_7271.method1829(-32350));
    }

    final int method1710(int i) {
        anInt5970++;
        if (i != 20014) anInt5965 = -58;
        return 0;
    }

    static final void method1775(byte i, int i_4_, int i_5_) {
        anInt5967++;
        if (i == -8 && Class320.method2547(i_4_, (byte) 84)) TextureOpHorizontalGradient.method3097((TextureOpKaleidoscope.aClass46ArrayArray9427[i_4_]), i_5_, 119);
    }
}
