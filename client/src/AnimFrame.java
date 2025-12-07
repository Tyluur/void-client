/* Class4 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Class4
final class AnimFrame {
    int transformCount;
    private static short[] transX = new short[500];
    short[] frameIndices;
    boolean frameTypeHigh;
    short[] translateIndices;
    boolean frameTypeSeven = false;
    byte[] frameAttribs;
    private static short[] transY = new short[500];
    AnimBase base;
    short[] transformZ;
    private static byte[] frameAttribute = new byte[500];
    short[] transformY;
    private static short[] indices = new short[500];
    boolean frameTypeFive;
    short[] transformX;
    private static short[] translationIndices = new short[500];
    private static short[] transZ = new short[500];

    AnimFrame(byte[] is, AnimBase animBase) {
        this.frameTypeHigh = false;
        this.base = null;
        this.frameTypeFive = false;
        this.transformCount = 0;
        this.base = animBase;
        try {
            Packet packet = new Packet(is);
            Packet base = new Packet(is);
            packet.readUnsignedByte(255);
            packet.pos += 2;
            int frameCount = packet.readUnsignedByte(255);//byte
            int index = 0;
            int startIndex = -1;
            int attributeIndex = -1;
            base.pos = packet.pos + frameCount;
            for (int i = 0; i < frameCount; i++) {
                int type = (this.base.transformTypes[i]);
                if (type == 0) startIndex = i;
                int attribute = packet.readUnsignedByte(255);//byte
                if (attribute > 0) {
                    if (type == 0) attributeIndex = i;
                    translationIndices[index] = (short) i;
                    short i_7_ = 0;
                    if (type == 3 || type == 10) i_7_ = (short) 128;
                    if ((attribute & 0x1) != 0) transX[index] = (short) base.readSmarts((byte) 77);//smart
                    else transX[index] = i_7_;
                    if ((attribute & 0x2) != 0) transY[index] = (short) base.readSmarts((byte) 77);//smart
                    else transY[index] = i_7_;
                    if ((attribute & 0x4) != 0) transZ[index] = (short) base.readSmarts((byte) 77);//smart
                    else transZ[index] = i_7_;
                    frameAttribute[index] = (byte) (attribute >>> 3 & 0x3);
                    if (type == 2 || type == 9) {
                        transX[index] = (short) (transX[index] << 2 & 0x3fff);
                        transY[index] = (short) (transY[index] << 2 & 0x3fff);
                        transZ[index] = (short) (transZ[index] << 2 & 0x3fff);
                    }
                    indices[index] = (short) -1;
                    if (type == 1 || type == 2 || type == 3) {
                        if (startIndex > attributeIndex) {
                            indices[index] = (short) startIndex;
                            attributeIndex = startIndex;
                        }
                    } else if (type == 5) this.frameTypeFive = true;
                    else if (type == 7) this.frameTypeSeven = true;
                    else if (type == 9 || type == 10 || type == 8) this.frameTypeHigh = true;
                    index++;
                }
            }
            if (base.pos != is.length) throw new RuntimeException();
            this.transformCount = index;
            this.translateIndices = new short[index];
            this.transformX = new short[index];
            this.transformY = new short[index];
            this.transformZ = new short[index];
            this.frameIndices = new short[index];
            this.frameAttribs = new byte[index];
            for (int i_8_ = 0; i_8_ < index; i_8_++) {
                this.translateIndices[i_8_] = translationIndices[i_8_];
                this.transformX[i_8_] = transX[i_8_];
                this.transformY[i_8_] = transY[i_8_];
                this.transformZ[i_8_] = transZ[i_8_];
                this.frameIndices[i_8_] = indices[i_8_];
                this.frameAttribs[i_8_] = frameAttribute[i_8_];
            }
        } catch (Exception exception) {
            this.transformCount = 0;
            this.frameTypeFive = false;
            this.frameTypeSeven = false;
        }
    }

    // method177
    public static void clearFrameDecoder() {
        translationIndices = null;
        transX = null;
        transY = null;
        transZ = null;
        indices = null;
        frameAttribute = null;
    }
}
