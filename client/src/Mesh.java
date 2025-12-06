/* Class124 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.*;
import java.util.Random;

// Class124
final class Mesh {
    int[] texSpaceScaleY;
    int faceCount;
    int texSpaceCount;
    static int anInt1819;
    byte[] faceTexSpace;
    int maxVertex;
    short[] faceTexture;
    byte[] texMappingType;
    int[] faceLabel;
    short[] texSpaceDefC;
    static int anInt1826;
    static int anInt1827;
    static int anInt1828;
    short[] texSpaceDefA;
    int version = 12;
    static int anInt1831;
    MeshBillboard[] billboards;
    byte[] texRotation;
    byte[] faceAlpha;
    short[] faceB;
    int vertexCount = 0;
    static int anInt1837;
    static int anInt1838;
    byte[] facePriority;
    static int anInt1840;
    int[] vertexX;
    short[] originalModels;
    byte[] shadingType;
    int[] texSpaceScaleZ;
    static int anInt1845;
    ModelParticleEmitter[] emitters;
    int[] vertexY;
    static Index aIndex_1848;
    short[] texSpaceDefB;
    static int anInt1850;
    byte globalPriority;
    int[] vertexZ;
    byte[] rexDirection;
    static int anInt1854;
    short[] faceC;
    short[] aShortArray1856;
    int[] texOffsetY;
    static int anInt1858;
    int[] texSpaceScaleX;
    static int anInt1860;
    static int anInt1861;
    short[] faceColour;
    short[] faceA;
    static int anInt1864;
    int[] texOffsetZ;
    ModelParticleEffector[] effectors;
    int[] texOffsetX;
    int[] vertexLabel;
    static int anInt1869;

    final void method1092(int i, int i_0_) {
        anInt1819++;
        for (int i_1_ = 0; this.vertexCount > i_1_; i_1_++) {
            this.vertexX[i_1_] <<= i;
            this.vertexY[i_1_] <<= i;
            this.vertexZ[i_1_] <<= i;
        }
        if (i_0_ <= 39) rotate(40, -7, -80, -24);
        if (this.texSpaceCount > 0 && this.texSpaceScaleX != null) {
            for (int i_2_ = 0; i_2_ < this.texSpaceScaleX.length; i_2_++) {
                this.texSpaceScaleX[i_2_] <<= i;
                this.texSpaceScaleY[i_2_] <<= i;
                if (this.texMappingType[i_2_] != 1) this.texSpaceScaleZ[i_2_] <<= i;
            }
        }
    }

    final int[][] method1093(byte i) {
        anInt1854++;
        int[] is = new int[256];
        int i_3_ = 0;
        for (int i_4_ = 0; this.billboards.length > i_4_; i_4_++) {
            int i_5_ = (this.billboards[i_4_].anInt2156);
            if (i_5_ >= 0) {
                is[i_5_]++;
                if (i_3_ < i_5_) i_3_ = i_5_;
            }
        }
        int[][] is_6_ = new int[1 + i_3_][];
        for (int i_7_ = 0; i_7_ <= i_3_; i_7_++) {
            is_6_[i_7_] = new int[is[i_7_]];
            is[i_7_] = 0;
        }
        if (i > -68) return null;
        for (int i_8_ = 0; i_8_ < this.billboards.length; i_8_++) {
            int i_9_ = (this.billboards[i_8_].anInt2156);
            if (i_9_ >= 0) is_6_[i_9_][is[i_9_]++] = i_8_;
        }
        return is_6_;
    }

    final int[][] method1094(byte i) {
        anInt1864++;
        int[] is = new int[256];
        int i_10_ = 0;
        for (int i_11_ = 0; i_11_ < this.faceCount; i_11_++) {
            int i_12_ = this.faceLabel[i_11_];
            if (i_12_ >= 0) {
                if (i_10_ < i_12_) i_10_ = i_12_;
                is[i_12_]++;
            }
        }
        int[][] is_13_ = new int[i_10_ - -1][];
        if (i <= 13) method1102(-65, (byte) -8, (byte) 94, (short) -89, (byte) 6, (short) -117, 21, (byte) 21, -31);
        for (int i_14_ = 0; i_10_ >= i_14_; i_14_++) {
            is_13_[i_14_] = new int[is[i_14_]];
            is[i_14_] = 0;
        }
        for (int i_15_ = 0; i_15_ < this.faceCount; i_15_++) {
            int i_16_ = this.faceLabel[i_15_];
            if (i_16_ >= 0) is_13_[i_16_][is[i_16_]++] = i_15_;
        }
        return is_13_;
    }

    final void method1095(short i, int i_17_, short i_18_) {
        anInt1869++;
        if (this.faceTexture != null) {
            for (int i_19_ = i_17_; this.faceCount > i_19_; i_19_++) {
                if (i == this.faceTexture[i_19_]) this.faceTexture[i_19_] = i_18_;
            }
        }
    }

    public static void method1096(int i) {
        if (i >= 88) aIndex_1848 = null;
    }

    static final int method1097(byte i, int i_20_, Random random) {
        anInt1861++;
        if (i_20_ <= 0) throw new IllegalArgumentException();
        if (Class192.method1436(-19, i_20_)) return (int) ((long) i_20_ * (0xffffffffL & (long) random.nextInt()) >> 32);
        int i_21_ = -2147483648 + -(int) (4294967296L % (long) i_20_);
        if (i < 78) aIndex_1848 = null;
        int i_22_;
        do i_22_ = random.nextInt(); while (i_22_ >= i_21_);
        return JavaBillboardAttributes.method3452(i_22_, (byte) -15, i_20_);
    }

    final void method1098(short i, byte i_23_, short i_24_) {
        if (i_23_ == 126) {
            for (int i_25_ = 0; i_25_ < this.faceCount; i_25_++) {
                if (i == this.faceColour[i_25_]) this.faceColour[i_25_] = i_24_;
            }
            anInt1826++;
        }
    }

    // method1099
    final void translate(byte i, int i_26_, int i_27_, int i_28_) {
        int i_29_ = 0;
        int i_30_ = 19 % ((-40 - i) / 33);
        for (/**/; this.vertexCount > i_29_; i_29_++) {
            this.vertexX[i_29_] += i_27_;
            this.vertexY[i_29_] += i_28_;
            this.vertexZ[i_29_] += i_26_;
        }
        anInt1840++;
    }

    final int[][] method1100(boolean bool, int i) {
        anInt1845++;
        int[] is = new int[256];
        int i_31_ = 0;
        int i_32_ = (!bool ? this.maxVertex : this.vertexCount);
        for (int i_33_ = 0; i_33_ < i_32_; i_33_++) {
            int i_34_ = this.vertexLabel[i_33_];
            if (i_34_ >= 0) {
                is[i_34_]++;
                if (i_31_ < i_34_) i_31_ = i_34_;
            }
        }
        int[][] is_35_ = new int[1 + i_31_][];
        for (int i_36_ = 0; i_36_ <= i_31_; i_36_++) {
            is_35_[i_36_] = new int[is[i_36_]];
            is[i_36_] = 0;
        }
        for (int i_37_ = 0; i_32_ > i_37_; i_37_++) {
            int i_38_ = this.vertexLabel[i_37_];
            if (i_38_ >= 0) is_35_[i_38_][is[i_38_]++] = i_37_;
        }
        if (i > -14) method1098((short) 9, (byte) 80, (short) -118);
        return is_35_;
    }

    // method1101
    final int addVertex(int i, int i_39_, int i_40_, int i_41_) {
        anInt1827++;
        int i_42_ = 0;
        int i_43_ = 120 / ((38 - i_41_) / 61);
        for (/**/; i_42_ < this.vertexCount; i_42_++) {
            if (this.vertexX[i_42_] == i_40_ && i == this.vertexY[i_42_] && this.vertexZ[i_42_] == i_39_) return i_42_;
        }
        this.vertexX[this.vertexCount] = i_40_;
        this.vertexY[this.vertexCount] = i;
        this.vertexZ[this.vertexCount] = i_39_;
        this.maxVertex = 1 + this.vertexCount;
        return this.vertexCount++;
    }

    final int method1102(int i, byte i_44_, byte i_45_, short i_46_, byte i_47_, short i_48_, int i_49_, byte i_50_, int i_51_) {
        this.faceA[this.faceCount] = (short) i;
        anInt1860++;
        this.faceB[this.faceCount] = (short) i_49_;
        this.faceC[this.faceCount] = (short) i_51_;
        if (i_47_ < 30) return -92;
        this.shadingType[this.faceCount] = i_44_;
        this.faceTexSpace[this.faceCount] = i_45_;
        this.faceColour[this.faceCount] = i_48_;
        this.faceAlpha[this.faceCount] = i_50_;
        this.faceTexture[this.faceCount] = i_46_;
        return this.faceCount++;
    }

    // method1103
    private final void decodeOld(byte[] is) {
        anInt1831++;
        boolean hasFlatShading = false;
        boolean hasTextures = false;
        Packet packet = new Packet(is);
        Packet packet2 = new Packet(is);
        Packet packet3 = new Packet(is);
        Packet packet4 = new Packet(is);
        Packet packet5 = new Packet(is);
        packet.pos = is.length - 18;
        this.vertexCount = packet.readUnsignedShort(1 ^ 0x3235f8f9);
        this.faceCount = packet.readUnsignedShort(842397944);
        this.texSpaceCount = packet.readUnsignedByte(255);
        int customShadingFlag = packet.readUnsignedByte(255);
        int priorityFlag = packet.readUnsignedByte(255);
        int alphaFlag = packet.readUnsignedByte(255);
        int faceLabelFlag = packet.readUnsignedByte(255);
        int vertexLabelFlag = packet.readUnsignedByte(255);
        int xLen = packet.readUnsignedShort(842397944);
        int yLen = packet.readUnsignedShort(842397944);
        int zLen = packet.readUnsignedShort(842397944);
        int faceLen = packet.readUnsignedShort(842397944);
        int ptr = 0;
        int vTypePtr = ptr;
        ptr += this.vertexCount;
        int fTypePtr = ptr;
        ptr += this.faceCount;
        int priPtr = ptr;
        if (priorityFlag == 255) ptr += this.faceCount;
        int fGroupPtr = ptr;
        if (faceLabelFlag == 1) ptr += this.faceCount;
        int texPtr = ptr;
        if (customShadingFlag == 1) ptr += this.faceCount;
        int vGroupPtr = ptr;
        if (vertexLabelFlag == 1) ptr += this.vertexCount;
        int alphaPtr = ptr;
        if (1 == alphaFlag) ptr += this.faceCount;
        int facePtr = ptr;
        ptr += faceLen;
        int faceCountPtr = ptr;
        ptr += this.faceCount * 2;
        int textFacePtr = ptr;
        ptr += this.texSpaceCount * 6;
        int vXPtr = ptr;
        ptr += xLen;
        int vYPtr = ptr;
        ptr += yLen;
        int vZPtr = ptr;
        this.faceColour = new short[this.faceCount];
        if (priorityFlag == 255) this.facePriority = new byte[this.faceCount];
        else this.globalPriority = (byte) priorityFlag;
        if (vertexLabelFlag == 1) this.vertexLabel = new int[this.vertexCount];
        if (alphaFlag == 1) this.faceAlpha = new byte[this.faceCount];
        this.faceA = new short[this.faceCount];
        if (customShadingFlag == 1) {
            this.faceTexture = new short[this.faceCount];
            this.faceTexSpace = new byte[this.faceCount];
            this.shadingType = new byte[this.faceCount];
        }
        this.vertexY = new int[this.vertexCount];
        if (faceLabelFlag == 1) this.faceLabel = new int[this.faceCount];
        this.faceC = new short[this.faceCount];
        if (this.texSpaceCount > 0) {
            this.texMappingType = new byte[this.texSpaceCount];
            this.texSpaceDefA = new short[this.texSpaceCount];
            this.texSpaceDefB = new short[this.texSpaceCount];
            this.texSpaceDefC = new short[this.texSpaceCount];
        }
        this.faceB = new short[this.faceCount];
        this.vertexZ = new int[this.vertexCount];
        this.vertexX = new int[this.vertexCount];
        packet.pos = vTypePtr;
        ptr += zLen;
        packet2.pos = vXPtr;
        packet3.pos = vYPtr;
        packet4.pos = vZPtr;
        packet5.pos = vGroupPtr;
        int pvX = 0;
        int pvY = 0;
        int pvZ = 0;
        for (int i = 0; i < this.vertexCount; i++) {
            int vertexData = packet.readUnsignedByte(255);
            int x = 0;
            if ((vertexData & 0x1) != 0) x = packet2.readSmarts((byte) 77);
            int y = 0;
            if ((vertexData & 0x2) != 0) y = packet3.readSmarts((byte) 77);
            int z = 0;
            if ((0x4 & vertexData) != 0) z = packet4.readSmarts((byte) 77);
            this.vertexX[i] = x + pvX;
            this.vertexY[i] = pvY - -y;
            this.vertexZ[i] = pvZ + z;
            pvZ = this.vertexZ[i];
            pvY = this.vertexY[i];
            pvX = this.vertexX[i];
            if (vertexLabelFlag == 1) this.vertexLabel[i] = packet5.readUnsignedByte(Class348_Sub21.method2955(1, 254));
        }
        packet.pos = faceCountPtr;
        packet2.pos = texPtr;
        packet3.pos = priPtr;
        packet4.pos = alphaPtr;
        packet5.pos = fGroupPtr;
        for (int i = 0; i < this.faceCount; i++) {
            this.faceColour[i] = (short) packet.readUnsignedShort(842397944);
            if (customShadingFlag == 1) {
                int type = packet2.readUnsignedByte(255);
                if ((0x1 & type) == 1) {
                    this.shadingType[i] = (byte) 1;
                    hasFlatShading = true;
                } else this.shadingType[i] = (byte) 0;
                if ((type & 0x2) == 2) {
                    this.faceTexSpace[i] = (byte) (type >> 2);
                    this.faceTexture[i] = this.faceColour[i];
                    this.faceColour[i] = (short) 127;
                    if (this.faceTexture[i] != -1) hasTextures = true;
                } else {
                    this.faceTexSpace[i] = (byte) -1;
                    this.faceTexture[i] = (short) -1;
                }
            }
            if (priorityFlag == 255) this.facePriority[i] = packet3.readByte(-108);
            if (alphaFlag == 1) this.faceAlpha[i] = packet4.readByte(Class348_Sub21.method2955(1, -120));
            if (faceLabelFlag == 1) this.faceLabel[i] = packet5.readUnsignedByte(255);
        }
        packet.pos = facePtr;
        this.maxVertex = -1;
        packet2.pos = fTypePtr;
        short faceA = 0;
        short faceB = 0;
        short faceC = 0;
        int facePriority = 0;
        for (int i = 0; i < this.faceCount; i++) {
            int type = packet2.readUnsignedByte(255);
            if (type == 1) {
                faceA = (short) (facePriority + packet.readSmarts((byte) 77));
                facePriority = faceA;
                faceB = (short) (packet.readSmarts((byte) 77) + facePriority);
                facePriority = faceB;
                faceC = (short) (facePriority + packet.readSmarts((byte) 77));
                this.faceA[i] = faceA;
                facePriority = faceC;
                this.faceB[i] = faceB;
                this.faceC[i] = faceC;
                if (faceA > this.maxVertex) this.maxVertex = faceA;
                if (this.maxVertex < faceB) this.maxVertex = faceB;
                if (this.maxVertex < faceC) this.maxVertex = faceC;
            }
            if (type == 2) {
                faceB = faceC;
                faceC = (short) (packet.readSmarts((byte) 77) + facePriority);
                this.faceA[i] = faceA;
                facePriority = faceC;
                this.faceB[i] = faceB;
                this.faceC[i] = faceC;
                if (faceC > this.maxVertex) this.maxVertex = faceC;
            }
            if (type == 3) {
                faceA = faceC;
                faceC = (short) (packet.readSmarts((byte) 77) + facePriority);
                facePriority = faceC;
                this.faceA[i] = faceA;
                this.faceB[i] = faceB;
                this.faceC[i] = faceC;
                if (this.maxVertex < faceC) this.maxVertex = faceC;
            }
            if (type == 4) {
                short i_96_ = faceA;
                faceA = faceB;
                faceC = (short) (packet.readSmarts((byte) 77) + facePriority);
                faceB = i_96_;
                facePriority = faceC;
                this.faceA[i] = faceA;
                this.faceB[i] = faceB;
                this.faceC[i] = faceC;
                if (this.maxVertex < faceC) this.maxVertex = faceC;
            }
        }
        this.maxVertex++;
        packet.pos = textFacePtr;
        for (int i = 0; i < this.texSpaceCount; i++) {
            this.texMappingType[i] = (byte) 0;
            this.texSpaceDefA[i] = (short) packet.readUnsignedShort(842397944);
            this.texSpaceDefB[i] = (short) packet.readUnsignedShort(842397944);
            this.texSpaceDefC[i] = (short) packet.readUnsignedShort(842397944);
        }
        if (this.faceTexSpace != null) {
            boolean hasTexSpaces = false;
            for (int i = 0; i < this.faceCount; i++) {
                int space = this.faceTexSpace[i] & 0xff;
                if (space != 255) {
                    if (((0xffff & this.texSpaceDefA[space]) != this.faceA[i]) || (this.faceB[i] != (0xffff & this.texSpaceDefB[space])) || ((0xffff & this.texSpaceDefC[space]) != this.faceC[i])) hasTexSpaces = true;
                    else this.faceTexSpace[i] = (byte) -1;
                }
            }
            if (!hasTexSpaces) this.faceTexSpace = null;
        }
        if (!hasFlatShading) this.shadingType = null;
        if (!hasTextures) this.faceTexture = null;
    }

    // method1104
    private final int addVertex(Mesh mesh, int v, short modelFlag) {
        anInt1858++;
        int x = mesh.vertexX[v];
        int y = mesh.vertexY[v];
        int z = mesh.vertexZ[v];
        for (int i = 0; i < this.vertexCount; i++) {
            if (this.vertexX[i] == x && y == this.vertexY[i] && (z == this.vertexZ[i])) {
                this.originalModels[i] = (short) Class273.method2057((this.originalModels[i]), modelFlag);
                return i;
            }
        }
        this.vertexX[this.vertexCount] = x;
        this.vertexY[this.vertexCount] = y;
        this.vertexZ[this.vertexCount] = z;
        this.originalModels[this.vertexCount] = modelFlag;
        this.vertexLabel[this.vertexCount] = (mesh.vertexLabel != null ? mesh.vertexLabel[v] : -1);
        return this.vertexCount++;
    }

    final byte method1105(int i, byte i_108_, byte i_109_, short i_110_, short i_111_, byte i_112_, short i_113_, short i_114_, short i_115_, short i_116_) {
        anInt1838++;
        if (this.texSpaceCount >= 255) throw new IllegalStateException();
        this.texMappingType[this.texSpaceCount] = (byte) 3;
        this.texSpaceDefA[this.texSpaceCount] = i_110_;
        this.texSpaceDefB[this.texSpaceCount] = i_114_;
        this.texSpaceDefC[this.texSpaceCount] = i_113_;
        this.texSpaceScaleX[this.texSpaceCount] = i_115_;
        this.texSpaceScaleY[this.texSpaceCount] = i_111_;
        this.texSpaceScaleZ[this.texSpaceCount] = i_116_;
        this.texRotation[this.texSpaceCount] = i_108_;
        this.rexDirection[this.texSpaceCount] = i_112_;
        this.texOffsetX[this.texSpaceCount] = i_109_;
        int i_117_ = 93 % ((i - -19) / 56);
        return (byte) this.texSpaceCount++;
    }

    // method1106
    private final void decodeNew(byte[] data) {
        anInt1828++;
        Packet packet = new Packet(data);
        Packet packet2 = new Packet(data);
        Packet packet3 = new Packet(data);
        Packet packet4 = new Packet(data);
        Packet packet5 = new Packet(data);
        Packet packet6 = new Packet(data);
        Packet packet7 = new Packet(data);
        packet.pos = -23 + data.length;
        this.vertexCount = packet.readUnsignedShort(842397944);
        this.faceCount = packet.readUnsignedShort(842397944);
        this.texSpaceCount = packet.readUnsignedByte(255);
        int globalFlags = packet.readUnsignedByte(255);
        boolean hasFlatShading = (0x1 & globalFlags) == 1;
        boolean hasParticleEffects = (globalFlags & 0x2) == 2;
        boolean hasBillboards = (globalFlags & 0x4) == 4;
        boolean hasVersion = (globalFlags & 0x8) == 8;
        if (hasVersion) {
            packet.pos -= 7;
            this.version = packet.readUnsignedByte(255);
            packet.pos += 6;
        }
        int priorityFlag = packet.readUnsignedByte(255);
        int faceAlphaFlag = packet.readUnsignedByte(255);
        int faceGroupFlag = packet.readUnsignedByte(255);
        int faceTextureFlag = packet.readUnsignedByte(255);
        int vertexLabelFlag = packet.readUnsignedByte(255);
        int vertexLengthX = packet.readUnsignedShort(842397944);
        int vertexLengthY = packet.readUnsignedShort(842397944);
        int vertexLengthZ = packet.readUnsignedShort(842397944);
        int faceDataSize = packet.readUnsignedShort(842397944);
        int texSpaceSize = packet.readUnsignedShort(842397944);
        int planarMappingCount = 0;
        int complexMappingCount = 0;
        int cubeMappingCount = 0;
        if (this.texSpaceCount > 0) {
            packet.pos = 0;
            this.texMappingType = new byte[this.texSpaceCount];
            for (int i = 0; (i < this.texSpaceCount); i++) {
                byte type = (this.texMappingType[i] = packet.readByte(-124));
                if (type >= 1 && type <= 3) complexMappingCount++;
                if (type == 2) cubeMappingCount++;
                if (type == 0) planarMappingCount++;
            }
        }
        int ptr = this.texSpaceCount;
        int vertexFlagsPtr = ptr;
        ptr += this.vertexCount;
        int smoothingPtr = ptr;
        if (hasFlatShading) ptr += this.faceCount;
        int faceTypePtr = ptr;
        ptr += this.faceCount;
        int facePriPtr = ptr;
        if (priorityFlag == 255) ptr += this.faceCount;
        int faceGroupPtr = ptr;
        if (faceGroupFlag == 1) ptr += this.faceCount;
        int vertexLabelPtr = ptr;
        if (vertexLabelFlag == 1) ptr += this.vertexCount;
        int faceAlphaPtr = ptr;
        if (faceAlphaFlag == 1) ptr += this.faceCount;
        int faceDataSizePtr = ptr;
        ptr += faceDataSize;
        int faceTextureFlagPtr = ptr;
        if (faceTextureFlag == 1) ptr += 2 * this.faceCount;
        int faceTextureSpacePtr = ptr;
        ptr += texSpaceSize;
        int faceColourPtr = ptr;
        ptr += 2 * this.faceCount;
        int vertexXPtr = ptr;
        ptr += vertexLengthX;
        int vertexYPtr = ptr;
        ptr += vertexLengthY;
        int vertexZPtr = ptr;
        ptr += vertexLengthZ;
        int planarMappingPtr = ptr;
        ptr += planarMappingCount * 6;
        int complexMappingPtr = ptr;
        ptr += 6 * complexMappingCount;
        int texSpaceScaleSize = 6;
        if (this.version == 14) texSpaceScaleSize = 7;
        else if (this.version >= 15) texSpaceScaleSize = 9;
        int texSpaceScalePtr = ptr;
        ptr += texSpaceScaleSize * complexMappingCount;
        int texSpaceRotationPtr = ptr;
        ptr += complexMappingCount;
        int texSpaceOrientationPtr = ptr;
        ptr += complexMappingCount;
        int texSpaceOffsePtr = ptr;
        ptr += 2 * cubeMappingCount + complexMappingCount;
        this.faceB = new short[this.faceCount];
        this.faceColour = new short[this.faceCount];
        if (faceGroupFlag == 1) this.faceLabel = new int[this.faceCount];
        if (this.texSpaceCount > 0) {
            if (cubeMappingCount > 0) {
                this.texOffsetY = new int[cubeMappingCount];
                this.texOffsetZ = new int[cubeMappingCount];
            }
            this.texSpaceDefB = new short[this.texSpaceCount];
            this.texSpaceDefA = new short[this.texSpaceCount];
            if (complexMappingCount > 0) {
                this.texOffsetX = new int[complexMappingCount];
                this.rexDirection = new byte[complexMappingCount];
                this.texSpaceScaleY = new int[complexMappingCount];
                this.texRotation = new byte[complexMappingCount];
                this.texSpaceScaleZ = new int[complexMappingCount];
                this.texSpaceScaleX = new int[complexMappingCount];
            }
            this.texSpaceDefC = new short[this.texSpaceCount];
        }
        if (hasFlatShading) this.shadingType = new byte[this.faceCount];
        if (faceAlphaFlag == 1) this.faceAlpha = new byte[this.faceCount];
        if (priorityFlag == 255) this.facePriority = new byte[this.faceCount];
        else this.globalPriority = (byte) priorityFlag;
        this.faceC = new short[this.faceCount];
        this.vertexY = new int[this.vertexCount];
        this.faceA = new short[this.faceCount];
        if (faceTextureFlag == 1 && this.texSpaceCount > 0) this.faceTexSpace = new byte[this.faceCount];
        int i_165_ = ptr;
        this.vertexZ = new int[this.vertexCount];
        this.vertexX = new int[this.vertexCount];
        if (vertexLabelFlag == 1) this.vertexLabel = new int[this.vertexCount];
        packet.pos = vertexFlagsPtr;
        if (faceTextureFlag == 1) this.faceTexture = new short[this.faceCount];
        packet2.pos = vertexXPtr;
        packet3.pos = vertexYPtr;
        packet4.pos = vertexZPtr;
        packet5.pos = vertexLabelPtr;
        int pvX = 0;
        int pvY = 0;
        int pvZ = 0;
        for (int i = 0; this.vertexCount > i; i++) {
            int vertexData = packet.readUnsignedByte(255);
            int x = 0;
            if ((vertexData & 0x1) != 0) x = packet2.readSmarts((byte) 77);
            int y = 0;
            if ((vertexData & 0x2) != 0) y = packet3.readSmarts((byte) 77);
            int z = 0;
            if ((0x4 & vertexData) != 0) z = packet4.readSmarts((byte) 77);
            this.vertexX[i] = x + pvX;
            this.vertexY[i] = y + pvY;
            this.vertexZ[i] = z + pvZ;
            pvY = this.vertexY[i];
            pvX = this.vertexX[i];
            pvZ = this.vertexZ[i];
            if (vertexLabelFlag == 1) this.vertexLabel[i] = packet5.readUnsignedByte(255);
        }
        packet.pos = faceColourPtr;
        packet2.pos = smoothingPtr;
        packet3.pos = facePriPtr;
        packet4.pos = faceAlphaPtr;
        packet5.pos = faceGroupPtr;
        packet6.pos = faceTextureFlagPtr;
        packet7.pos = faceTextureSpacePtr;
        for (int i = 0; (this.faceCount > i); i++) {
            this.faceColour[i] = (short) packet.readUnsignedShort(842397944);
            if (hasFlatShading) this.shadingType[i] = packet2.readByte(-98);
            if (priorityFlag == 255) this.facePriority[i] = packet3.readByte(-78);
            if (faceAlphaFlag == 1) this.faceAlpha[i] = packet4.readByte(-99);
            if (faceGroupFlag == 1) this.faceLabel[i] = packet5.readUnsignedByte(255);
            if (faceTextureFlag == 1) this.faceTexture[i] = (short) (packet6.readUnsignedShort(842397944) + -1);
            if (this.faceTexSpace != null) {
                if (this.faceTexture[i] == -1) this.faceTexSpace[i] = (byte) -1;
                else this.faceTexSpace[i] = (byte) (-1 + packet7.readUnsignedByte(255));
            }
        }
        packet.pos = faceDataSizePtr;
        this.maxVertex = -1;
        packet2.pos = faceTypePtr;
        short faceA = 0;
        short faceB = 0;
        short faceC = 0;
        int facePriority = 0;
        for (int i = 0; (i < this.faceCount); i++) {
            int type = packet2.readUnsignedByte(255);
            if (type == 1) {
                faceA = (short) (packet.readSmarts((byte) 77) + facePriority);
                facePriority = faceA;
                faceB = (short) (packet.readSmarts((byte) 77) + facePriority);
                facePriority = faceB;
                faceC = (short) (facePriority + packet.readSmarts((byte) 77));
                facePriority = faceC;
                this.faceA[i] = faceA;
                this.faceB[i] = faceB;
                this.faceC[i] = faceC;
                if (faceA > this.maxVertex) this.maxVertex = faceA;
                if (this.maxVertex < faceB) this.maxVertex = faceB;
                if (faceC > this.maxVertex) this.maxVertex = faceC;
            }
            if (type == 2) {
                faceB = faceC;
                faceC = (short) (packet.readSmarts((byte) 77) + facePriority);
                this.faceA[i] = faceA;
                facePriority = faceC;
                this.faceB[i] = faceB;
                this.faceC[i] = faceC;
                if (this.maxVertex < faceC) this.maxVertex = faceC;
            }
            if (type == 3) {
                faceA = faceC;
                faceC = (short) (packet.readSmarts((byte) 77) + facePriority);
                facePriority = faceC;
                this.faceA[i] = faceA;
                this.faceB[i] = faceB;
                this.faceC[i] = faceC;
                if (this.maxVertex < faceC) this.maxVertex = faceC;
            }
            if (type == 4) {
                short i_181_ = faceA;
                faceA = faceB;
                faceC = (short) (facePriority + packet.readSmarts((byte) 77));
                faceB = i_181_;
                this.faceA[i] = faceA;
                facePriority = faceC;
                this.faceB[i] = faceB;
                this.faceC[i] = faceC;
                if (this.maxVertex < faceC) this.maxVertex = faceC;
            }
        }
        packet.pos = planarMappingPtr;
        this.maxVertex++;
        packet2.pos = complexMappingPtr;
        packet3.pos = texSpaceScalePtr;
        packet4.pos = texSpaceRotationPtr;
        packet5.pos = texSpaceOrientationPtr;
        packet6.pos = texSpaceOffsePtr;
        for (int i = 0; this.texSpaceCount > i; i++) {
            int type = this.texMappingType[i] & 0xff;
            if (type == 0) {
                this.texSpaceDefA[i] = (short) packet.readUnsignedShort(842397944);
                this.texSpaceDefB[i] = (short) packet.readUnsignedShort(842397944);
                this.texSpaceDefC[i] = (short) packet.readUnsignedShort(842397944);
            }
            if (type == 1) {
                this.texSpaceDefA[i] = (short) packet2.readUnsignedShort(842397944);
                this.texSpaceDefB[i] = (short) packet2.readUnsignedShort(842397944);
                this.texSpaceDefC[i] = (short) packet2.readUnsignedShort(842397944);
                if (this.version >= 15) {
                    this.texSpaceScaleX[i] = packet3.readMedium(-1);
                    this.texSpaceScaleY[i] = packet3.readMedium(-1);
                    this.texSpaceScaleZ[i] = packet3.readMedium(-1);
                } else {
                    this.texSpaceScaleX[i] = packet3.readUnsignedShort(842397944);
                    if (this.version >= 14) this.texSpaceScaleY[i] = packet3.readMedium(-1);
                    else this.texSpaceScaleY[i] = packet3.readUnsignedShort(842397944);
                    this.texSpaceScaleZ[i] = packet3.readUnsignedShort(842397944);
                }
                this.texRotation[i] = packet4.readByte(-86);
                this.rexDirection[i] = packet5.readByte(-116);
                this.texOffsetX[i] = packet6.readByte(-79);
            }
            if (type == 2) {
                this.texSpaceDefA[i] = (short) packet2.readUnsignedShort(842397944);
                this.texSpaceDefB[i] = (short) packet2.readUnsignedShort(842397944);
                this.texSpaceDefC[i] = (short) packet2.readUnsignedShort(842397944);
                if (this.version >= 15) {
                    this.texSpaceScaleX[i] = packet3.readMedium(-1);
                    this.texSpaceScaleY[i] = packet3.readMedium(-1);
                    this.texSpaceScaleZ[i] = packet3.readMedium(-1);
                } else {
                    this.texSpaceScaleX[i] = packet3.readUnsignedShort(842397944);
                    if (this.version < 14) this.texSpaceScaleY[i] = packet3.readUnsignedShort(842397944);
                    else this.texSpaceScaleY[i] = packet3.readMedium(-1);
                    this.texSpaceScaleZ[i] = packet3.readUnsignedShort(842397944);
                }
                this.texRotation[i] = packet4.readByte(-97);
                this.rexDirection[i] = packet5.readByte(-100);
                this.texOffsetX[i] = packet6.readByte(-124);
                this.texOffsetY[i] = packet6.readByte(-112);
                this.texOffsetZ[i] = packet6.readByte(-114);
            }
            if (type == 3) {
                this.texSpaceDefA[i] = (short) packet2.readUnsignedShort(842397944);
                this.texSpaceDefB[i] = (short) packet2.readUnsignedShort(842397944);
                this.texSpaceDefC[i] = (short) packet2.readUnsignedShort(842397944);
                if (this.version < 15) {
                    this.texSpaceScaleX[i] = packet3.readUnsignedShort(842397944);
                    if (this.version < 14) this.texSpaceScaleY[i] = packet3.readUnsignedShort(842397944);
                    else this.texSpaceScaleY[i] = packet3.readMedium(-1);
                    this.texSpaceScaleZ[i] = packet3.readUnsignedShort(842397944);
                } else {
                    this.texSpaceScaleX[i] = packet3.readMedium(-1);
                    this.texSpaceScaleY[i] = packet3.readMedium(-1);
                    this.texSpaceScaleZ[i] = packet3.readMedium(-1);
                }
                this.texRotation[i] = packet4.readByte(-104);
                this.rexDirection[i] = packet5.readByte(-127);
                this.texOffsetX[i] = packet6.readByte(-109);
            }
        }
        packet.pos = i_165_;
        if (hasParticleEffects) {
            int emitterCount = packet.readUnsignedByte(255);
            if (emitterCount > 0) {
                this.emitters = new ModelParticleEmitter[emitterCount];
                for (int i = 0; emitterCount > i; i++) {
                    int type = packet.readUnsignedShort(842397944);
                    int face = packet.readUnsignedShort(842397944);
                    byte priority;
                    if (priorityFlag != 255) priority = (byte) priorityFlag;
                    else priority = this.facePriority[face];
                    this.emitters[i] = (new ModelParticleEmitter(type, this.faceA[face], this.faceB[face], this.faceC[face], priority));
                }
            }
            int effectorCount = packet.readUnsignedByte(255);
            if (effectorCount > 0) {
                this.effectors = new ModelParticleEffector[effectorCount];
                for (int i = 0; effectorCount > i; i++) {
                    int i_191_ = packet.readUnsignedShort(842397944);
                    int i_192_ = packet.readUnsignedShort(842397944);
                    this.effectors[i] = new ModelParticleEffector(i_191_, i_192_);
                }
            }
        }
        if (hasBillboards) {
            int billboardCount = packet.readUnsignedByte(255);
            if (billboardCount > 0) {
                this.billboards = new MeshBillboard[billboardCount];
                for (int i = 0; billboardCount > i; i++) {
                    int type = packet.readUnsignedShort(842397944);
                    int face = packet.readUnsignedShort(842397944);
                    int group = packet.readUnsignedByte(255);
                    byte priority = packet.readByte(-127);
                    this.billboards[i] = new MeshBillboard(type, face, group, priority);
                }
            }
        }
    }

    // method1107
    final void rotate(int i_199_, int z, int i_201_) {
        if (z != 0) {
            int sinZ = Class70.SIN[z];
            int cosZ = Class70.COS[z];
            for (int i = 0; i < this.vertexCount; i++) {
                int t = ((cosZ * this.vertexX[i] + this.vertexY[i] * sinZ) >> 14);
                this.vertexY[i] = ((-(this.vertexX[i] * sinZ) + this.vertexY[i] * cosZ) >> 14);
                this.vertexX[i] = t;
            }
        }
        anInt1837++;
        if (i_201_ != 0) {
            int sinX = Class70.SIN[i_201_];
            int cosX = Class70.COS[i_201_];
            for (int i = 0; i < this.vertexCount; i++) {
                int t = ((this.vertexY[i] * cosX + -(sinX * this.vertexZ[i])) >> 14);
                this.vertexZ[i] = ((this.vertexY[i] * sinX - -(cosX * this.vertexZ[i])) >> 14);
                this.vertexY[i] = t;
            }
        }
        if (i_199_ != 0) {
            int sinY = Class70.SIN[i_199_];
            int cosY = Class70.COS[i_199_];
            for (int i = 0; this.vertexCount > i; i++) {
                int t = ((cosY * this.vertexX[i] + this.vertexZ[i] * sinY) >> 14);
                this.vertexZ[i] = ((cosY * this.vertexZ[i] + -(this.vertexX[i] * sinY)) >> 14);
                this.vertexX[i] = t;
            }
        }
    }

    public Mesh() {
        this.faceCount = 0;
        this.globalPriority = (byte) 0;
        this.maxVertex = 0;
        this.texSpaceCount = 0;
    }

    Mesh(byte[] is) {
        this.faceCount = 0;
        this.globalPriority = (byte) 0;
        this.maxVertex = 0;
        this.texSpaceCount = 0;
        if (is[is.length + -1] == -1 && is[-2 + is.length] == -1) decodeNew(is);
        else decodeOld(is);
    }

    static final void method1108(byte i, Canvas canvas) {
        anInt1850++;
        Dimension dimension = canvas.getSize();
        if (i != -99) method1096(57);
        Class85.method828((byte) 38, dimension.height, dimension.width);
        if (Packet.anInt7207 != 1) Class21.aHa326.method3643(canvas, Class59_Sub1.anInt5283, Class107.anInt1651);
        else Class21.aHa326.method3643(canvas, Class348_Sub16_Sub1.anInt8854, Option_Sub16.anInt6008);
    }

    Mesh(int i, int i_214_, int i_215_) {
        this.faceCount = 0;
        this.globalPriority = (byte) 0;
        this.maxVertex = 0;
        this.texSpaceCount = 0;
        this.faceTexSpace = new byte[i_214_];
        this.faceA = new short[i_214_];
        this.faceColour = new short[i_214_];
        this.vertexLabel = new int[i];
        this.faceLabel = new int[i_214_];
        this.vertexZ = new int[i];
        if (i_215_ > 0) {
            this.texOffsetY = new int[i_215_];
            this.texOffsetX = new int[i_215_];
            this.texSpaceDefB = new short[i_215_];
            this.texSpaceScaleZ = new int[i_215_];
            this.texSpaceDefC = new short[i_215_];
            this.texOffsetZ = new int[i_215_];
            this.texRotation = new byte[i_215_];
            this.texSpaceScaleX = new int[i_215_];
            this.texSpaceDefA = new short[i_215_];
            this.texMappingType = new byte[i_215_];
            this.texSpaceScaleY = new int[i_215_];
            this.rexDirection = new byte[i_215_];
        }
        this.faceTexture = new short[i_214_];
        this.facePriority = new byte[i_214_];
        this.faceC = new short[i_214_];
        this.faceB = new short[i_214_];
        this.vertexX = new int[i];
        this.shadingType = new byte[i_214_];
        this.vertexY = new int[i];
        this.faceAlpha = new byte[i_214_];
    }

    Mesh(Mesh[] meshes, int meshCount) {
        this.faceCount = 0;
        this.globalPriority = (byte) 0;
        this.maxVertex = 0;
        this.texSpaceCount = 0;
        this.texSpaceCount = 0;
        this.faceCount = 0;
        this.vertexCount = 0;
        int emitterCount = 0;
        int effectorCount = 0;
        int billboardCount = 0;
        boolean hasShadingTypes = false;
        boolean hasPriorities = false;
        boolean hasTexSpaces = false;
        boolean hasAlpha = false;
        boolean hasFaceTextures = false;
        this.globalPriority = (byte) -1;
        boolean hasFaceGroups = false;
        for (int i = 0; meshCount > i; i++) {
            Mesh mesh = meshes[i];
            if (mesh != null) {
                this.faceCount += mesh.faceCount;
                this.vertexCount += mesh.vertexCount;
                this.texSpaceCount += mesh.texSpaceCount;
                hasShadingTypes = hasShadingTypes | mesh.shadingType != null;
                if (mesh.billboards != null) billboardCount += (mesh.billboards).length;
                if (mesh.emitters != null) emitterCount += (mesh.emitters).length;
                if (mesh.effectors != null) effectorCount += (mesh.effectors).length;
                hasFaceTextures = (hasFaceTextures | mesh.faceTexture != null);
                hasAlpha = (hasAlpha | mesh.faceTexSpace != null);
                if (mesh.facePriority == null) {
                    if (this.globalPriority == -1) this.globalPriority = mesh.globalPriority;
                    if (this.globalPriority != mesh.globalPriority) hasPriorities = true;
                } else hasPriorities = true;
                hasTexSpaces = (hasTexSpaces | mesh.faceAlpha != null);
                hasFaceGroups = (hasFaceGroups | mesh.faceLabel != null);
            }
        }
        this.faceB = new short[this.faceCount];
        if (this.texSpaceCount > 0) {
            this.texSpaceDefA = new short[this.texSpaceCount];
            this.texMappingType = new byte[this.texSpaceCount];
            this.texOffsetX = new int[this.texSpaceCount];
            this.texSpaceScaleZ = new int[this.texSpaceCount];
            this.texRotation = new byte[this.texSpaceCount];
            this.texOffsetY = new int[this.texSpaceCount];
            this.texOffsetZ = new int[this.texSpaceCount];
            this.texSpaceScaleX = new int[this.texSpaceCount];
            this.rexDirection = new byte[this.texSpaceCount];
            this.texSpaceDefB = new short[this.texSpaceCount];
            this.texSpaceScaleY = new int[this.texSpaceCount];
            this.texSpaceDefC = new short[this.texSpaceCount];
        }
        this.aShortArray1856 = new short[this.faceCount];
        if (hasFaceTextures) this.faceTexture = new short[this.faceCount];
        this.faceA = new short[this.faceCount];
        if (hasFaceGroups) this.faceLabel = new int[this.faceCount];
        if (hasPriorities) this.facePriority = new byte[this.faceCount];
        if (hasShadingTypes) this.shadingType = new byte[this.faceCount];
        if (billboardCount > 0) this.billboards = new MeshBillboard[billboardCount];
        if (effectorCount > 0) this.effectors = new ModelParticleEffector[effectorCount];
        this.vertexLabel = new int[this.vertexCount];
        if (hasAlpha) this.faceTexSpace = new byte[this.faceCount];
        this.vertexZ = new int[this.vertexCount];
        this.faceColour = new short[this.faceCount];
        this.vertexX = new int[this.vertexCount];
        this.vertexY = new int[this.vertexCount];
        if (emitterCount > 0) this.emitters = new ModelParticleEmitter[emitterCount];
        this.faceC = new short[this.faceCount];
        if (hasTexSpaces) this.faceAlpha = new byte[this.faceCount];
        this.originalModels = new short[this.vertexCount];
        this.texSpaceCount = 0;
        effectorCount = 0;
        billboardCount = 0;
        emitterCount = 0;
        this.faceCount = 0;
        this.vertexCount = 0;
        for (int i = 0; meshCount > i; i++) {
            short s = (short) (1 << i);
            Mesh mesh = meshes[i];
            if (mesh != null) {
                if (mesh.billboards != null) {
                    for (int j = 0; (mesh.billboards.length > j); j++) {
                        MeshBillboard meshBillboard = (mesh.billboards[j]);
                        this.billboards[billboardCount++] = meshBillboard.method1266(5, ((meshBillboard.face) - -(this.faceCount)));
                    }
                }
                for (int j = 0; mesh.faceCount > j; j++) {
                    if (hasShadingTypes && mesh.shadingType != null) this.shadingType[(this.faceCount)] = (mesh.shadingType[j]);
                    if (hasPriorities) {
                        if (mesh.facePriority != null) this.facePriority[(this.faceCount)] = (mesh.facePriority[j]);
                        else this.facePriority[(this.faceCount)] = mesh.globalPriority;
                    }
                    if (hasTexSpaces && mesh.faceAlpha != null) this.faceAlpha[(this.faceCount)] = (mesh.faceAlpha[j]);
                    if (hasFaceTextures) {
                        if (mesh.faceTexture == null) this.faceTexture[this.faceCount] = (short) -1;
                        else this.faceTexture[this.faceCount] = (mesh.faceTexture[j]);
                    }
                    if (hasFaceGroups) {
                        if (mesh.faceLabel == null) this.faceLabel[(this.faceCount)] = -1;
                        else this.faceLabel[(this.faceCount)] = (mesh.faceLabel[j]);
                    }
                    this.faceA[(this.faceCount)] = (short) addVertex(mesh, (mesh.faceA[j]), s);
                    this.faceB[(this.faceCount)] = (short) addVertex(mesh, (mesh.faceB[j]), s);
                    this.faceC[(this.faceCount)] = (short) addVertex(mesh, (mesh.faceC[j]), s);
                    this.aShortArray1856[(this.faceCount)] = s;
                    this.faceColour[(this.faceCount)] = mesh.faceColour[j];
                    this.faceCount++;
                }
                if (mesh.emitters != null) {
                    for (int i_231_ = 0; (mesh.emitters.length > i_231_); i_231_++) {
                        int a = addVertex(mesh, mesh.emitters[i_231_].anInt1881, s);
                        int b = addVertex(mesh, mesh.emitters[i_231_].anInt1877, s);
                        int c = addVertex(mesh, mesh.emitters[i_231_].anInt1892, s);
                        this.emitters[emitterCount] = mesh.emitters[i_231_].copy(b, -1, c, a);
                        emitterCount++;
                    }
                }
                if (mesh.effectors != null) {
                    for (int i_235_ = 0; (mesh.effectors).length > i_235_; i_235_++) {
                        int i_236_ = addVertex(mesh, mesh.effectors[i_235_].anInt4244, s);
                        this.effectors[effectorCount] = mesh.effectors[i_235_].method2687((byte) 94, i_236_);
                        effectorCount++;
                    }
                }
            }
        }
        int texSpaceCount = 0;
        this.maxVertex = this.vertexCount;
        for (int i = 0; meshCount > i; i++) {
            short modelFlag = (short) (1 << i);
            Mesh mesh = meshes[i];
            if (mesh != null) {
                for (int j = 0; mesh.faceCount > j; j++) {
                    if (hasAlpha) this.faceTexSpace[texSpaceCount++] = (byte) (((mesh.faceTexSpace) != null && (mesh.faceTexSpace[j]) != -1) ? ((mesh.faceTexSpace[j]) + this.texSpaceCount) : -1);
                }
                for (int j = 0; (mesh.texSpaceCount > j); j++) {
                    byte type = (this.texMappingType[(this.texSpaceCount)] = (mesh.texMappingType[j]));
                    if (type == 0) {
                        this.texSpaceDefA[(this.texSpaceCount)] = (short) addVertex(mesh, (mesh.texSpaceDefA[j]), modelFlag);
                        this.texSpaceDefB[(this.texSpaceCount)] = (short) addVertex(mesh, (mesh.texSpaceDefB[j]), modelFlag);
                        this.texSpaceDefC[(this.texSpaceCount)] = (short) addVertex(mesh, (mesh.texSpaceDefC[j]), modelFlag);
                    }
                    if (type >= 1 && type <= 3) {
                        this.texSpaceDefA[(this.texSpaceCount)] = (mesh.texSpaceDefA[j]);
                        this.texSpaceDefB[(this.texSpaceCount)] = (mesh.texSpaceDefB[j]);
                        this.texSpaceDefC[(this.texSpaceCount)] = (mesh.texSpaceDefC[j]);
                        this.texSpaceScaleX[(this.texSpaceCount)] = (mesh.texSpaceScaleX[j]);
                        this.texSpaceScaleY[(this.texSpaceCount)] = (mesh.texSpaceScaleY[j]);
                        this.texSpaceScaleZ[(this.texSpaceCount)] = (mesh.texSpaceScaleZ[j]);
                        this.texRotation[(this.texSpaceCount)] = (mesh.texRotation[j]);
                        this.rexDirection[(this.texSpaceCount)] = (mesh.rexDirection[j]);
                        this.texOffsetX[(this.texSpaceCount)] = (mesh.texOffsetX[j]);
                    }
                    if (type == 2) {
                        this.texOffsetY[(this.texSpaceCount)] = (mesh.texOffsetY[j]);
                        this.texOffsetZ[(this.texSpaceCount)] = (mesh.texOffsetZ[j]);
                    }
                    this.texSpaceCount++;
                }
            }
        }
    }
}
