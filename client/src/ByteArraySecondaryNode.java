/* Class348_Sub42_Sub3 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Class348_Sub42_Sub3
final class ByteArraySecondaryNode extends LinkedNode {
    static boolean aBoolean9498;
    byte[] value;
    static int anInt9500;
    static int anInt9501;
    static short[] aShortArray9502;
    static Class114 aClass114_9503;
    static int anInt9504;
    static int[] anIntArray9505 = new int[3];
    static int anInt9506;
    static int anInt9507;
    static int anInt9508;
    static int anInt9509;

    static final void method3174(int viewX, int viewY, int viewHeight, boolean drawBars, byte i_2_, int screenHeight) {
        if (viewHeight < 1) viewHeight = 1;
        anInt9507++;
        if (screenHeight < 1) screenHeight = 1;
        int heightExcess = screenHeight - 334;
        if (heightExcess < 0) heightExcess = 0;
        else if (heightExcess > 100) heightExcess = 100;
        int adjustedZoom = ((-Class110.baseZoom + Class168.zoom) * heightExcess / 100 + Class110.baseZoom);
        if (adjustedZoom < Class348_Sub42_Sub8.minZoom) adjustedZoom = Class348_Sub42_Sub8.minZoom;
        else if (Class48.maxZoom < adjustedZoom) adjustedZoom = Class48.maxZoom;
        int scaledWidth = 512 * adjustedZoom * screenHeight / (viewHeight * 334);
        if (scaledWidth >= Class367_Sub8.minWidth) {
            if (scaledWidth > Class171.maxWidth) {
                scaledWidth = Class171.maxWidth;
                adjustedZoom = viewHeight * scaledWidth * 334 / (screenHeight * 512);
                if (adjustedZoom < Class348_Sub42_Sub8.minZoom) {
                    adjustedZoom = Class348_Sub42_Sub8.minZoom;
                    int fittedScreenHeight = scaledWidth * (viewHeight * 334) / (adjustedZoom * 512);
                    int letterboxBarHeight = (-fittedScreenHeight + screenHeight) / 2;
                    if (drawBars) {
                        Class348_Sub8.active.la();
                        Class348_Sub8.active.method3675(viewHeight, (byte) -125, viewX, viewY, letterboxBarHeight, -16777216);
                        Class348_Sub8.active.method3675(viewHeight, (byte) -125, viewX, screenHeight + viewY - letterboxBarHeight, letterboxBarHeight, -16777216);
                    }
                    viewY += letterboxBarHeight;
                    screenHeight -= 2 * letterboxBarHeight;
                }
            }
        } else {
            scaledWidth = Class367_Sub8.minWidth;
            adjustedZoom = scaledWidth * (viewHeight * 334) / (screenHeight * 512);
            if (Class48.maxZoom < adjustedZoom) {
                adjustedZoom = Class48.maxZoom;
                int fittedScreenWidth = adjustedZoom * screenHeight * 512 / (334 * scaledWidth);
                int barWidth = (viewHeight + -fittedScreenWidth) / 2;
                if (drawBars) {
                    Class348_Sub8.active.la();
                    Class348_Sub8.active.method3675(barWidth, (byte) -125, viewX, viewY, screenHeight, -16777216);
                    Class348_Sub8.active.method3675(barWidth, (byte) -125, -barWidth + viewX + viewHeight, viewY, screenHeight, -16777216);
                }
                viewX += barWidth;
                viewHeight -= barWidth * 2;
            }
        }
        Class97.anInt1550 = screenHeight * adjustedZoom / 334;
        Class234.anInt3047 = viewY;
        Class280.anInt3643 = (short) screenHeight;
        Class127.anInt4656 = (short) viewHeight;
        Class295.anInt3764 = viewX;
    }

    static final void method3175(byte i) {
        if (!Class348_Sub42_Sub8.method3196(Class240.mainLogicStep, -114) && !Js5MasterIndex.method2672(Class240.mainLogicStep, -103)) {
            int i_12_ = ((Class132.aPlayer_1907.anIntArray10320[0]) >> 3);
            int i_13_ = ((Class132.aPlayer_1907.anIntArray10317[0]) >> 3);
            if (i_12_ < 0 || Class367_Sub4.mapLength >> 3 <= i_12_ || i_13_ < 0 || (TextureOpBinary.mapWidth >> 3 <= i_13_)) Class346_Sub1.method2703(0, Class367_Sub4.mapLength >> 4, (TextureOpBinary.mapWidth >> 4), (byte) -13);
            else Class346_Sub1.method2703(5000, i_12_, i_13_, (byte) -13);
        } else Class346_Sub1.method2703(5000, Class286_Sub4.anInt6246 >> 12, Class59_Sub2_Sub2.anInt8685 >> 12, (byte) -13);
        anInt9509++;
        TextureOpInvert.method3134(-1);
        Class348_Sub23_Sub4.method2988(true);
        int i_14_ = -8 % ((-30 - i) / 38);
        TextureOpHslAdjust.method3126((byte) 98);
        Class130_Sub1.method1131(117);
    }

    ByteArraySecondaryNode(byte[] is) {
        this.value = is;
    }

    public static void method3176(boolean bool) {
        anIntArray9505 = null;
        aShortArray9502 = null;
        if (bool != true) aShortArray9502 = null;
        aClass114_9503 = null;
    }

    static final void method3177(int i, boolean bool) {
        if (!bool || Class75.aClass348_Sub42_Sub14_1243 == null) Option_Sub13.anInt5976 = -1;
        else Option_Sub13.anInt5976 = (Class75.aClass348_Sub42_Sub14_1243.anInt9628);
        anInt9500++;
        Class75.aClass348_Sub42_Sub14_1243 = null;
        Class168.aClass46_2249 = null;
        Node.anInt4290 = 0;
        Class289.aDeque_3705 = null;
        Class75.method749();
        Class75.aDeque_1254.clear(127);
        Class285.aClass323_4754 = null;
        Class168.aClass323_2252 = null;
        Class67.aSprite_4643 = null;
        Class125.aClass323_4921 = null;
        Class176.aClass323_2333 = null;
        Class348_Sub3.aClass323_6581 = null;
        Class39.aClass323_521 = null;
        Class75.aClass252_1246 = null;
        Class14_Sub4.aClass323_8644 = null;
        Class48.anInt859 = -1;
        if (i <= -44) {
            Js5TextureSource.anInt4609 = -1;
            Class240.aClass323_4672 = null;
            if (Class75.aMapElementTypeList_1238 != null) {
                Class75.aMapElementTypeList_1238.method1219(7851);
                Class75.aMapElementTypeList_1238.method1220((byte) -100, 64, 128);
            }
            if (Class75.aMSITypeList_1242 != null) Class75.aMSITypeList_1242.method1178(64, 1, 64);
            if (Class75.aObjectTypeList_1245 != null) Class75.aObjectTypeList_1245.method2014(64, true);
            Class229.varBitTypeList.method1444(64, -124);
        }
    }

    // method3178
    static final void initFontTypeList(Index index, int i, int[] is, Index index_15_) {
        try {
            anInt9506++;
            if (is != null) Class348_Sub1.anIntArray6547 = is;
            Ground.aIndex_4585 = index;
            if (i >= -6) method3177(-36, true);
            Class39.aIndex_518 = index_15_;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("lk.F(" + (index != null ? "{...}" : "null") + ',' + i + ',' + (is != null ? "{...}" : "null") + ',' + (index_15_ != null ? "{...}" : "null") + ')'));
        }
    }

    static final void method3179(int i) {
        Class3.method175((byte) -50);
        anInt9508++;
        int i_16_ = Class316.clientOptions.aClass239_Sub3_7222.method1727(-32350);
        do {
            if (i_16_ == 2) {
                Class121.method1083(Class348_Sub8.active, 100, (byte) 9, Class348_Sub42_Sub8_Sub2.anInt10432, 100, Class321.anInt4017);
                break;
            } else if (i_16_ != 3) break;
            Class18.method282(2, Class348_Sub8.active, Class321.anInt4017, (byte) 73, Index.anInt666, Class186_Sub1.anInt5812, Class348_Sub42_Sub8_Sub2.anInt10432, 2);
        } while (false);
        if (Class316.clientOptions.aClass239_Sub3_7222.method1735(false)) Ground.method3980(i + 93, Class305.aCanvas3869);
        if (Class348_Sub8.active != null) Class290.method2196((byte) -9);
        Class305.aBoolean3870 = i != Class316.clientOptions.aClass239_Sub3_7222.method1727(-32350);
        Class59_Sub1.aBoolean5300 = Class316.clientOptions.aClass239_Sub3_7222.method1735(false);
    }

    static {
        anInt9501 = 0;
        aShortArray9502 = new short[256];
        aClass114_9503 = new Class114(9, -1);
    }
}
