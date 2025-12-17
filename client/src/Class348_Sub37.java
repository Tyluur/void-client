/* Class348_Sub37 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class348_Sub37 extends Node {
    static int anInt6996;
    static boolean aBoolean6997 = false;
    Deque aDeque_6998 = new Deque();
    static int anInt6999;

    static final void method3030(int i, OpenGLToolkit var_openGLToolkit) {
        anInt6999++;
        if (Class337.anObject4177 == null) {
            Class59_Sub1_Sub2 class59_sub1_sub2 = new Class59_Sub1_Sub2();
            byte[] is = class59_sub1_sub2.method562(128, 128, (byte) 121, 16);
            Class337.anObject4177 = Class179.method1357(is, false, (byte) 81);
        }
        if (GfxTypeList.anObject3985 == null) {
            Class59_Sub2_Sub1 class59_sub2_sub1 = new Class59_Sub2_Sub1();
            byte[] is = class59_sub2_sub1.method567(128, (byte) 111, 16, 128);
            GfxTypeList.anObject3985 = Class179.method1357(is, false, (byte) 103);
        }
        if (i != 8) decode(-39, null);
        Class188 class188 = var_openGLToolkit.aClass188_7736;
        if (class188.method1414(35632) && Class369_Sub2.anObject8592 == null) {
            byte[] is = Class5_Sub2.method194(128, -1922, 8, 0.6F, 128, 4.0F, 4.0F, 0.5F, 16.0F, new Class186_Sub1(419684), 16);
            Class369_Sub2.anObject8592 = Class179.method1357(is, false, (byte) 78);
        }
    }

    // method3031
    static final TextureOp decode(int i, Packet packet) {
        anInt6996++;
        packet.readUnsignedByte(255);
        int type = packet.readUnsignedByte(255);
        TextureOp op = Class59_Sub1_Sub1.create(type, (byte) -84);
        op.imageCacheCapacity = packet.readUnsignedByte(255);
        int i_1_ = packet.readUnsignedByte(255);
        if (i < 123) return null;
        for (int i_2_ = 0; i_1_ > i_2_; i_2_++) {
            int code = packet.readUnsignedByte(255);
            op.decode(packet, code, 31015);
        }
        op.finish(120);
        return op;
    }

    public Class348_Sub37() {
        /* empty */
    }
}
