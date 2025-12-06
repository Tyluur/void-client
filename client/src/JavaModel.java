/* Class64_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Class64_Sub1
final class JavaModel extends Model {
    private short[] faceColour;
    private int[] vertexZ;
    private VertexNormal[] aVertexNormalArray5313;
    private float[][] texCoordU;
    private int[] clippedX;
    private int functionMask;
    private short[] faceIndexX;
    private int[] anIntArray5318;
    private JavaModel aJavaModel_5319;
    private JavaMatrix transform;
    private int[] renderVertexX;
    private ModelParticleEmitter[] emitters;
    private boolean calculatedBounds = false;
    private short distance2D;
    private byte[] faceAlphas;
    private int[] anIntArray5326;
    private short[] faceIndices;
    private JavaModel aJavaModel_5328;
    private short minVertexY;
    private int[][] anIntArrayArray5330;
    private short maxVertexZ;
    private int[] vertexY;
    private short[] originalModels;
    private int[][] anIntArrayArray5334;
    private ModelParticleEffector[] effectors;
    private JavaThreadResource aJavaThreadResource_5336;
    private int[] shadeFacesY;
    private int anInt5338;
    private JavaModel aJavaModel_5339;
    private int vertexCount = 0;
    private static int anInt5341;
    private int anInt5342;
    private int[] renderVertexY;
    private int anInt5344;
    private float[][] texCoordV;
    static int anInt5346 = 4096;
    private JavaModel aJavaModel_5347;
    private short distance3D;
    private int anInt5349;
    static int anInt5350;
    private int faceCount;
    private short minVertexZ;
    private final JavaToolkit toolkit;
    private int renderPoints;
    private int[] renderVertexZ;
    private int[] vertexX;
    private boolean aBoolean5357 = false;
    private byte[] facePriority;
    private int[] tempX;
    private VertexNormal[] normals;
    private JavaBillboardFace[] billboardFaces;
    private int[] originalZ;
    private JavaBillboardAttributes[] billboardAttributes;
    private short[] faceIndexZ;
    private short maxVertexY;
    private int[] shadeFacesZ;
    private JavaThreadResource aJavaThreadResource_5367;
    private int[] shadeFacesX;
    private boolean aBoolean5369;
    private short[] aShortArray5370;
    private int[] clippedY;
    private boolean aBoolean5372;
    private int[] tempY;
    private JavaModel aJavaModel_5374;
    private int anInt5375;
    private JavaModel aJavaModel_5376;
    private int[] clippedColour;
    private JavaModel aJavaModel_5378;
    private int[][] anIntArrayArray5379;
    private boolean aBoolean5380;
    private int[] clippedZ;
    private boolean transparent;
    private Rasterizer aRasterizer_5383;
    private int[] cameraY;
    private Class41[] aClass41Array5385;
    private byte[] shadingType;
    private int maxVertex;
    private short[] faceTextures;
    private int billboardCount;
    private JavaModel aJavaModel_5390;
    private boolean movingTextures;
    private int[] cameraZ;
    private short maxVertexX;
    private short[] faceIndexY;
    private short minVertexX;
    private JavaModel aJavaModel_5396;
    private JavaModel aJavaModel_5397;
    private int[] tempZ;
    private int[] cameraX;
    private int[] billboardIndices;

    private final boolean noAlpha(int i) {
        if (faceAlphas == null) return false;
        return faceAlphas[i] != 0;
    }

    private final boolean method630(int i, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_, int i_5_, int i_6_) {
        if (i_0_ < i_1_ && i_0_ < i_2_ && i_0_ < i_3_) return false;
        if (i_0_ > i_1_ && i_0_ > i_2_ && i_0_ > i_3_) return false;
        if (i < i_4_ && i < i_5_ && i < i_6_) return false;
        return i <= i_4_ || i <= i_5_ || i <= i_6_;
    }

    private final void method631() {
        normals = null;
        aVertexNormalArray5313 = null;
        aClass41Array5385 = null;
        calculatedBounds = false;
    }

    final int EA() {
        if (!calculatedBounds) calculateBounds();
        return maxVertexY;
    }

    private final void method632(Thread thread) {
        JavaThreadResource javaThreadResource = toolkit.method3724(thread);
        aRasterizer_5383 = javaThreadResource.aRasterizer_2220;
        if (javaThreadResource != aJavaThreadResource_5367) {
            aJavaThreadResource_5367 = javaThreadResource;
            originalZ = aJavaThreadResource_5367.anIntArray2222;
            cameraX = aJavaThreadResource_5367.anIntArray2244;
            cameraY = aJavaThreadResource_5367.anIntArray2214;
            cameraZ = aJavaThreadResource_5367.anIntArray2237;
            renderVertexX = aJavaThreadResource_5367.anIntArray2234;
            renderVertexY = aJavaThreadResource_5367.anIntArray2230;
            renderVertexZ = aJavaThreadResource_5367.anIntArray2213;
            tempX = aJavaThreadResource_5367.anIntArray2218;
            tempY = aJavaThreadResource_5367.anIntArray2241;
            tempZ = aJavaThreadResource_5367.anIntArray2245;
            clippedX = aJavaThreadResource_5367.anIntArray2238;
            clippedY = aJavaThreadResource_5367.anIntArray2247;
            clippedZ = aJavaThreadResource_5367.anIntArray2235;
            clippedColour = aJavaThreadResource_5367.anIntArray2240;
            anIntArray5326 = aJavaThreadResource_5367.anIntArray2236;
            anIntArray5318 = aJavaThreadResource_5367.anIntArray2216;
            billboardIndices = aJavaThreadResource_5367.anIntArray2242;
        }
    }

    private final Model method633(JavaModel javaModel_7_, JavaModel javaModel_8_, int i, boolean bool, boolean bool_9_) {
        javaModel_7_.calculatedBounds = calculatedBounds;
        if (calculatedBounds) {
            javaModel_7_.maxVertexX = maxVertexX;
            javaModel_7_.maxVertexY = maxVertexY;
            javaModel_7_.maxVertexZ = maxVertexZ;
            javaModel_7_.minVertexX = minVertexX;
            javaModel_7_.minVertexY = minVertexY;
            javaModel_7_.minVertexZ = minVertexZ;
            javaModel_7_.distance2D = distance2D;
            javaModel_7_.distance3D = distance3D;
        }
        javaModel_7_.anInt5344 = anInt5344;
        javaModel_7_.anInt5349 = anInt5349;
        javaModel_7_.vertexCount = vertexCount;
        javaModel_7_.maxVertex = maxVertex;
        javaModel_7_.faceCount = faceCount;
        javaModel_7_.billboardCount = billboardCount;
        if ((i & 0x100) != 0) javaModel_7_.transparent = true;
        else javaModel_7_.transparent = transparent;
        javaModel_7_.movingTextures = movingTextures;
        boolean bool_10_ = (i & 0x7) == 7 | (i & 0x20) != 0;
        boolean bool_11_ = bool_10_ || (i & 0x1) != 0;
        boolean bool_12_ = bool_10_ || (i & 0x2) != 0;
        boolean bool_13_ = bool_10_ || (i & 0x4) != 0 || (i & 0x10) != 0;
        if (bool_11_ || bool_12_ || bool_13_) {
            if (bool_11_) {
                if (javaModel_8_.vertexX == null || javaModel_8_.vertexX.length < vertexCount) javaModel_7_.vertexX = javaModel_8_.vertexX = new int[vertexCount];
                else javaModel_7_.vertexX = javaModel_8_.vertexX;
                for (int i_14_ = 0; i_14_ < vertexCount; i_14_++)
                    javaModel_7_.vertexX[i_14_] = vertexX[i_14_];
            } else javaModel_7_.vertexX = vertexX;
            if (bool_12_) {
                if (javaModel_8_.vertexY == null || javaModel_8_.vertexY.length < vertexCount) javaModel_7_.vertexY = javaModel_8_.vertexY = new int[vertexCount];
                else javaModel_7_.vertexY = javaModel_8_.vertexY;
                for (int i_15_ = 0; i_15_ < vertexCount; i_15_++)
                    javaModel_7_.vertexY[i_15_] = vertexY[i_15_];
            } else javaModel_7_.vertexY = vertexY;
            if (bool_13_) {
                if (javaModel_8_.vertexZ == null || javaModel_8_.vertexZ.length < vertexCount) javaModel_7_.vertexZ = javaModel_8_.vertexZ = new int[vertexCount];
                else javaModel_7_.vertexZ = javaModel_8_.vertexZ;
                for (int i_16_ = 0; i_16_ < vertexCount; i_16_++)
                    javaModel_7_.vertexZ[i_16_] = vertexZ[i_16_];
            } else javaModel_7_.vertexZ = vertexZ;
        } else {
            javaModel_7_.vertexX = vertexX;
            javaModel_7_.vertexY = vertexY;
            javaModel_7_.vertexZ = vertexZ;
        }
        if ((i & 0x84080) != 0) {
            if (javaModel_8_.faceColour == null || javaModel_8_.faceColour.length < faceCount) {
                int i_17_ = faceCount;
                javaModel_7_.faceColour = javaModel_8_.faceColour = new short[i_17_];
            } else javaModel_7_.faceColour = javaModel_8_.faceColour;
            for (int i_18_ = 0; i_18_ < faceCount; i_18_++)
                javaModel_7_.faceColour[i_18_] = faceColour[i_18_];
        } else javaModel_7_.faceColour = faceColour;
        if ((i & 0x97018) != 0) {
            javaModel_7_.renderPoints = 0;
            javaModel_7_.shadeFacesX = javaModel_7_.shadeFacesY = javaModel_7_.shadeFacesZ = null;
        } else if ((i & 0x80) == 0) {
            if (bool_9_) method634(false);
            javaModel_7_.shadeFacesX = shadeFacesX;
            javaModel_7_.shadeFacesY = shadeFacesY;
            javaModel_7_.shadeFacesZ = shadeFacesZ;
            javaModel_7_.renderPoints = renderPoints;
        } else {
            if (bool_9_) method634(false);
            if (shadeFacesX != null) {
                if (javaModel_8_.shadeFacesX == null || javaModel_8_.shadeFacesX.length < faceCount) {
                    int i_19_ = faceCount;
                    javaModel_7_.shadeFacesX = javaModel_8_.shadeFacesX = new int[i_19_];
                    javaModel_7_.shadeFacesY = javaModel_8_.shadeFacesY = new int[i_19_];
                    javaModel_7_.shadeFacesZ = javaModel_8_.shadeFacesZ = new int[i_19_];
                } else {
                    javaModel_7_.shadeFacesX = javaModel_8_.shadeFacesX;
                    javaModel_7_.shadeFacesY = javaModel_8_.shadeFacesY;
                    javaModel_7_.shadeFacesZ = javaModel_8_.shadeFacesZ;
                }
                for (int i_20_ = 0; i_20_ < faceCount; i_20_++) {
                    javaModel_7_.shadeFacesX[i_20_] = shadeFacesX[i_20_];
                    javaModel_7_.shadeFacesY[i_20_] = shadeFacesY[i_20_];
                    javaModel_7_.shadeFacesZ[i_20_] = shadeFacesZ[i_20_];
                }
            }
            javaModel_7_.renderPoints = renderPoints;
        }
        if ((i & 0x100) != 0) {
            if (javaModel_8_.faceAlphas == null || javaModel_8_.faceAlphas.length < faceCount) {
                int i_21_ = faceCount;
                javaModel_7_.faceAlphas = javaModel_8_.faceAlphas = new byte[i_21_];
            } else javaModel_7_.faceAlphas = javaModel_8_.faceAlphas;
            if (faceAlphas == null) {
                for (int i_23_ = 0; i_23_ < faceCount; i_23_++)
                    javaModel_7_.faceAlphas[i_23_] = (byte) 0;
            } else {
                for (int i_22_ = 0; i_22_ < faceCount; i_22_++)
                    javaModel_7_.faceAlphas[i_22_] = faceAlphas[i_22_];
            }
        } else javaModel_7_.faceAlphas = faceAlphas;
        if ((i & 0x8) != 0 || (i & 0x10) != 0) {
            if (javaModel_8_.normals == null || javaModel_8_.normals.length < maxVertex) {
                int i_24_ = maxVertex;
                javaModel_7_.normals = javaModel_8_.normals = new VertexNormal[i_24_];
            } else javaModel_7_.normals = javaModel_8_.normals;
            if (normals != null) {
                for (int i_25_ = 0; i_25_ < maxVertex; i_25_++)
                    javaModel_7_.normals[i_25_] = new VertexNormal(normals[i_25_]);
            } else javaModel_7_.normals = null;
            if (aClass41Array5385 != null) {
                if (javaModel_8_.aClass41Array5385 == null || javaModel_8_.aClass41Array5385.length < faceCount) {
                    int i_26_ = faceCount;
                    javaModel_7_.aClass41Array5385 = javaModel_8_.aClass41Array5385 = new Class41[i_26_];
                } else javaModel_7_.aClass41Array5385 = javaModel_8_.aClass41Array5385;
                for (int i_27_ = 0; i_27_ < faceCount; i_27_++)
                    javaModel_7_.aClass41Array5385[i_27_] = (aClass41Array5385[i_27_] != null ? new Class41(aClass41Array5385[i_27_]) : null);
            } else javaModel_7_.aClass41Array5385 = null;
        } else {
            if (bool_9_) method636();
            javaModel_7_.normals = normals;
            javaModel_7_.aClass41Array5385 = aClass41Array5385;
        }
        if ((i & 0x8000) != 0) {
            if (faceTextures == null) javaModel_7_.faceTextures = null;
            else {
                if (javaModel_8_.faceTextures == null || javaModel_8_.faceTextures.length < faceCount) {
                    int i_28_ = faceCount;
                    javaModel_7_.faceTextures = javaModel_8_.faceTextures = new short[i_28_];
                } else javaModel_7_.faceTextures = javaModel_8_.faceTextures;
                for (int i_29_ = 0; i_29_ < faceCount; i_29_++)
                    javaModel_7_.faceTextures[i_29_] = faceTextures[i_29_];
            }
        } else javaModel_7_.faceTextures = faceTextures;
        if ((i & 0x10000) != 0) {
            if (shadingType == null) javaModel_7_.shadingType = null;
            else {
                if (javaModel_8_.shadingType == null || javaModel_8_.shadingType.length < faceCount) {
                    int i_30_ = bool ? faceCount + 100 : faceCount;
                    javaModel_7_.shadingType = javaModel_8_.shadingType = new byte[i_30_];
                } else javaModel_7_.shadingType = javaModel_8_.shadingType;
                for (int i_31_ = 0; i_31_ < faceCount; i_31_++)
                    javaModel_7_.shadingType[i_31_] = shadingType[i_31_];
            }
        } else javaModel_7_.shadingType = shadingType;
        if ((i & 0xc580) != 0) {
            if (javaModel_8_.billboardAttributes == null || javaModel_8_.billboardAttributes.length < billboardCount) {
                int i_32_ = billboardCount;
                javaModel_7_.billboardAttributes = javaModel_8_.billboardAttributes = new JavaBillboardAttributes[i_32_];
                for (int i_33_ = 0; i_33_ < billboardCount; i_33_++)
                    javaModel_7_.billboardAttributes[i_33_] = billboardAttributes[i_33_].method3453(true);
            } else {
                javaModel_7_.billboardAttributes = javaModel_8_.billboardAttributes;
                for (int i_34_ = 0; i_34_ < billboardCount; i_34_++)
                    javaModel_7_.billboardAttributes[i_34_].method3454(billboardAttributes[i_34_], true);
            }
        } else javaModel_7_.billboardAttributes = billboardAttributes;
        if (texCoordU == null || (i & 0x10) == 0) {
            javaModel_7_.texCoordU = texCoordU;
            javaModel_7_.texCoordV = texCoordV;
        } else {
            if (javaModel_8_.texCoordU == null || javaModel_8_.texCoordU.length < faceCount) {
                int i_35_ = bool ? faceCount + 100 : faceCount;
                javaModel_7_.texCoordU = javaModel_8_.texCoordU = new float[i_35_][3];
            } else javaModel_7_.texCoordU = javaModel_8_.texCoordU;
            for (int i_36_ = 0; i_36_ < faceCount; i_36_++) {
                if (texCoordU[i_36_] != null) {
                    javaModel_7_.texCoordU[i_36_][0] = texCoordU[i_36_][0];
                    javaModel_7_.texCoordU[i_36_][1] = texCoordU[i_36_][1];
                    javaModel_7_.texCoordU[i_36_][2] = texCoordU[i_36_][2];
                }
            }
            if (javaModel_8_.texCoordV == null || javaModel_8_.texCoordV.length < faceCount) {
                int i_37_ = bool ? faceCount + 100 : faceCount;
                javaModel_7_.texCoordV = javaModel_8_.texCoordV = new float[i_37_][3];
            } else javaModel_7_.texCoordV = javaModel_8_.texCoordV;
            for (int i_38_ = 0; i_38_ < faceCount; i_38_++) {
                if (texCoordV[i_38_] != null) {
                    javaModel_7_.texCoordV[i_38_][0] = texCoordV[i_38_][0];
                    javaModel_7_.texCoordV[i_38_][1] = texCoordV[i_38_][1];
                    javaModel_7_.texCoordV[i_38_][2] = texCoordV[i_38_][2];
                }
            }
        }
        javaModel_7_.anIntArrayArray5334 = anIntArrayArray5334;
        javaModel_7_.anIntArrayArray5330 = anIntArrayArray5330;
        javaModel_7_.anIntArrayArray5379 = anIntArrayArray5379;
        javaModel_7_.originalModels = originalModels;
        javaModel_7_.aShortArray5370 = aShortArray5370;
        javaModel_7_.facePriority = facePriority;
        javaModel_7_.faceIndexX = faceIndexX;
        javaModel_7_.faceIndexY = faceIndexY;
        javaModel_7_.faceIndexZ = faceIndexZ;
        javaModel_7_.emitters = emitters;
        javaModel_7_.effectors = effectors;
        javaModel_7_.billboardFaces = billboardFaces;
        javaModel_7_.faceIndices = faceIndices;
        javaModel_7_.functionMask = i;
        return javaModel_7_;
    }

    private final void method634(boolean bool) {
        if (toolkit.threadCount > 1) {
            synchronized (this) {
                method657(bool);
            }
        } else method657(bool);
    }

    final ModelParticleEmitter[] method619() {
        return emitters;
    }

    final int V() {
        if (!calculatedBounds) calculateBounds();
        return minVertexX;
    }

    // method635
    private final void drawFace(int i) {
        short x = faceIndexX[i];
        short y = faceIndexY[i];
        short z = faceIndexZ[i];
        if (faceTextures == null || faceTextures[i] == -1) {
            if (faceAlphas == null) aRasterizer_5383.alpha = 0;
            else aRasterizer_5383.alpha = faceAlphas[i] & 0xff;
            if (shadeFacesZ[i] == -1)
                aRasterizer_5383.drawColouredTriangle((float) renderVertexY[x], (float) renderVertexY[y], (float) renderVertexY[z], (float) renderVertexX[x], (float) renderVertexX[y], (float) renderVertexX[z], (float) renderVertexZ[x], (float) renderVertexZ[y], (float) renderVertexZ[z], (Class126.HSV_TO_RGB[shadeFacesX[i] & 0xffff]));
            else
                aRasterizer_5383.drawGouraudTriangle((float) renderVertexY[x], (float) renderVertexY[y], (float) renderVertexY[z], (float) renderVertexX[x], (float) renderVertexX[y], (float) renderVertexX[z], (float) renderVertexZ[x], (float) renderVertexZ[y], (float) renderVertexZ[z], (float) (shadeFacesX[i] & 0xffff), (float) (shadeFacesY[i] & 0xffff), (float) (shadeFacesZ[i] & 0xffff));
        } else {
            int alpha = -16777216;
            if (faceAlphas != null) alpha = 255 - (faceAlphas[i] & 0xff) << 24;
            if (shadeFacesZ[i] == -1) {
                int colour = alpha | shadeFacesX[i] & 0xffffff;
                aRasterizer_5383.drawTexturedTriangle((float) renderVertexY[x], (float) renderVertexY[y], (float) renderVertexY[z], (float) renderVertexX[x], (float) renderVertexX[y], (float) renderVertexX[z], (float) renderVertexZ[x], (float) renderVertexZ[y], (float) renderVertexZ[z], texCoordU[i][0], texCoordU[i][1], texCoordU[i][2], texCoordV[i][0], texCoordV[i][1], texCoordV[i][2], colour, colour, colour, aJavaThreadResource_5367.anInt2192, 0, 0, 0, faceTextures[i]);
            } else
                aRasterizer_5383.drawTexturedTriangle((float) renderVertexY[x], (float) renderVertexY[y], (float) renderVertexY[z], (float) renderVertexX[x], (float) renderVertexX[y], (float) renderVertexX[z], (float) renderVertexZ[x], (float) renderVertexZ[y], (float) renderVertexZ[z], texCoordU[i][0], texCoordU[i][1], texCoordU[i][2], texCoordV[i][0], texCoordV[i][1], texCoordV[i][2], alpha | shadeFacesX[i] & 0xffffff, alpha | shadeFacesY[i] & 0xffffff, alpha | shadeFacesZ[i] & 0xffffff, (aJavaThreadResource_5367.anInt2192), 0, 0, 0, faceTextures[i]);
        }
    }

    // method615
    final void render(Matrix matrix, LabelBounds class318_sub3, int i) {
        renderModel(matrix, class318_sub3, -1, i);
    }

    final int HA() {
        if (!calculatedBounds) calculateBounds();
        return minVertexZ;
    }

    final void method605(int i, int[] is, int i_44_, int i_45_, int i_46_, int i_47_, boolean bool) {
        int i_48_ = is.length;
        if (i == 0) {
            i_44_ <<= 4;
            i_45_ <<= 4;
            i_46_ <<= 4;
            if (!aBoolean5372) {
                for (int i_49_ = 0; i_49_ < vertexCount; i_49_++) {
                    vertexX[i_49_] <<= 4;
                    vertexY[i_49_] <<= 4;
                    vertexZ[i_49_] <<= 4;
                }
                aBoolean5372 = true;
            }
            int i_50_ = 0;
            anInt5338 = 0;
            anInt5375 = 0;
            anInt5342 = 0;
            for (int i_51_ = 0; i_51_ < i_48_; i_51_++) {
                int i_52_ = is[i_51_];
                if (i_52_ < anIntArrayArray5334.length) {
                    int[] is_53_ = anIntArrayArray5334[i_52_];
                    for (int i_54_ = 0; i_54_ < is_53_.length; i_54_++) {
                        int i_55_ = is_53_[i_54_];
                        anInt5338 += vertexX[i_55_];
                        anInt5375 += vertexY[i_55_];
                        anInt5342 += vertexZ[i_55_];
                        i_50_++;
                    }
                }
            }
            if (i_50_ > 0) {
                anInt5338 = anInt5338 / i_50_ + i_44_;
                anInt5375 = anInt5375 / i_50_ + i_45_;
                anInt5342 = anInt5342 / i_50_ + i_46_;
            } else {
                anInt5338 = i_44_;
                anInt5375 = i_45_;
                anInt5342 = i_46_;
            }
        } else if (i == 1) {
            i_44_ <<= 4;
            i_45_ <<= 4;
            i_46_ <<= 4;
            if (!aBoolean5372) {
                for (int i_56_ = 0; i_56_ < vertexCount; i_56_++) {
                    vertexX[i_56_] <<= 4;
                    vertexY[i_56_] <<= 4;
                    vertexZ[i_56_] <<= 4;
                }
                aBoolean5372 = true;
            }
            for (int i_57_ = 0; i_57_ < i_48_; i_57_++) {
                int i_58_ = is[i_57_];
                if (i_58_ < anIntArrayArray5334.length) {
                    int[] is_59_ = anIntArrayArray5334[i_58_];
                    for (int i_60_ = 0; i_60_ < is_59_.length; i_60_++) {
                        int i_61_ = is_59_[i_60_];
                        vertexX[i_61_] += i_44_;
                        vertexY[i_61_] += i_45_;
                        vertexZ[i_61_] += i_46_;
                    }
                }
            }
        } else if (i == 2) {
            for (int i_62_ = 0; i_62_ < i_48_; i_62_++) {
                int i_63_ = is[i_62_];
                if (i_63_ < anIntArrayArray5334.length) {
                    int[] is_64_ = anIntArrayArray5334[i_63_];
                    if ((i_47_ & 0x1) == 0) {
                        for (int i_65_ = 0; i_65_ < is_64_.length; i_65_++) {
                            int i_66_ = is_64_[i_65_];
                            vertexX[i_66_] -= anInt5338;
                            vertexY[i_66_] -= anInt5375;
                            vertexZ[i_66_] -= anInt5342;
                            if (i_46_ != 0) {
                                int i_67_ = Class70.SIN[i_46_];
                                int i_68_ = Class70.COS[i_46_];
                                int i_69_ = ((vertexY[i_66_] * i_67_ + vertexX[i_66_] * i_68_ + 16383) >> 14);
                                vertexY[i_66_] = (vertexY[i_66_] * i_68_ - vertexX[i_66_] * i_67_ + 16383) >> 14;
                                vertexX[i_66_] = i_69_;
                            }
                            if (i_44_ != 0) {
                                int i_70_ = Class70.SIN[i_44_];
                                int i_71_ = Class70.COS[i_44_];
                                int i_72_ = ((vertexY[i_66_] * i_71_ - vertexZ[i_66_] * i_70_ + 16383) >> 14);
                                vertexZ[i_66_] = (vertexY[i_66_] * i_70_ + vertexZ[i_66_] * i_71_ + 16383) >> 14;
                                vertexY[i_66_] = i_72_;
                            }
                            if (i_45_ != 0) {
                                int i_73_ = Class70.SIN[i_45_];
                                int i_74_ = Class70.COS[i_45_];
                                int i_75_ = ((vertexZ[i_66_] * i_73_ + vertexX[i_66_] * i_74_ + 16383) >> 14);
                                vertexZ[i_66_] = (vertexZ[i_66_] * i_74_ - vertexX[i_66_] * i_73_ + 16383) >> 14;
                                vertexX[i_66_] = i_75_;
                            }
                            vertexX[i_66_] += anInt5338;
                            vertexY[i_66_] += anInt5375;
                            vertexZ[i_66_] += anInt5342;
                        }
                    } else {
                        for (int i_76_ = 0; i_76_ < is_64_.length; i_76_++) {
                            int i_77_ = is_64_[i_76_];
                            vertexX[i_77_] -= anInt5338;
                            vertexY[i_77_] -= anInt5375;
                            vertexZ[i_77_] -= anInt5342;
                            if (i_44_ != 0) {
                                int i_78_ = Class70.SIN[i_44_];
                                int i_79_ = Class70.COS[i_44_];
                                int i_80_ = ((vertexY[i_77_] * i_79_ - vertexZ[i_77_] * i_78_ + 16383) >> 14);
                                vertexZ[i_77_] = (vertexY[i_77_] * i_78_ + vertexZ[i_77_] * i_79_ + 16383) >> 14;
                                vertexY[i_77_] = i_80_;
                            }
                            if (i_46_ != 0) {
                                int i_81_ = Class70.SIN[i_46_];
                                int i_82_ = Class70.COS[i_46_];
                                int i_83_ = ((vertexY[i_77_] * i_81_ + vertexX[i_77_] * i_82_ + 16383) >> 14);
                                vertexY[i_77_] = (vertexY[i_77_] * i_82_ - vertexX[i_77_] * i_81_ + 16383) >> 14;
                                vertexX[i_77_] = i_83_;
                            }
                            if (i_45_ != 0) {
                                int i_84_ = Class70.SIN[i_45_];
                                int i_85_ = Class70.COS[i_45_];
                                int i_86_ = ((vertexZ[i_77_] * i_84_ + vertexX[i_77_] * i_85_ + 16383) >> 14);
                                vertexZ[i_77_] = (vertexZ[i_77_] * i_85_ - vertexX[i_77_] * i_84_ + 16383) >> 14;
                                vertexX[i_77_] = i_86_;
                            }
                            vertexX[i_77_] += anInt5338;
                            vertexY[i_77_] += anInt5375;
                            vertexZ[i_77_] += anInt5342;
                        }
                    }
                }
            }
        } else if (i == 3) {
            for (int i_87_ = 0; i_87_ < i_48_; i_87_++) {
                int i_88_ = is[i_87_];
                if (i_88_ < anIntArrayArray5334.length) {
                    int[] is_89_ = anIntArrayArray5334[i_88_];
                    for (int i_90_ = 0; i_90_ < is_89_.length; i_90_++) {
                        int i_91_ = is_89_[i_90_];
                        vertexX[i_91_] -= anInt5338;
                        vertexY[i_91_] -= anInt5375;
                        vertexZ[i_91_] -= anInt5342;
                        vertexX[i_91_] = vertexX[i_91_] * i_44_ / 128;
                        vertexY[i_91_] = vertexY[i_91_] * i_45_ / 128;
                        vertexZ[i_91_] = vertexZ[i_91_] * i_46_ / 128;
                        vertexX[i_91_] += anInt5338;
                        vertexY[i_91_] += anInt5375;
                        vertexZ[i_91_] += anInt5342;
                    }
                }
            }
        } else if (i == 5) {
            if (anIntArrayArray5330 != null && faceAlphas != null) {
                for (int i_92_ = 0; i_92_ < i_48_; i_92_++) {
                    int i_93_ = is[i_92_];
                    if (i_93_ < anIntArrayArray5330.length) {
                        int[] is_94_ = anIntArrayArray5330[i_93_];
                        for (int i_95_ = 0; i_95_ < is_94_.length; i_95_++) {
                            int i_96_ = is_94_[i_95_];
                            int i_97_ = (faceAlphas[i_96_] & 0xff) + i_44_ * 8;
                            if (i_97_ < 0) i_97_ = 0;
                            else if (i_97_ > 255) i_97_ = 255;
                            faceAlphas[i_96_] = (byte) i_97_;
                        }
                    }
                }
                if (billboardFaces != null) {
                    for (int i_98_ = 0; i_98_ < billboardCount; i_98_++) {
                        JavaBillboardFace javaBillboardFace = billboardFaces[i_98_];
                        JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[i_98_];
                        javaBillboardAttributes.anInt4313 = (javaBillboardAttributes.anInt4313 & 0xffffff | (255 - (faceAlphas[javaBillboardFace.index] & 0xff)) << 24);
                    }
                }
            }
        } else if (i == 7) {
            if (anIntArrayArray5330 != null) {
                for (int i_99_ = 0; i_99_ < i_48_; i_99_++) {
                    int i_100_ = is[i_99_];
                    if (i_100_ < anIntArrayArray5330.length) {
                        int[] is_101_ = anIntArrayArray5330[i_100_];
                        for (int i_102_ = 0; i_102_ < is_101_.length; i_102_++) {
                            int i_103_ = is_101_[i_102_];
                            int i_104_ = faceColour[i_103_] & 0xffff;
                            int i_105_ = i_104_ >> 10 & 0x3f;
                            int i_106_ = i_104_ >> 7 & 0x7;
                            int i_107_ = i_104_ & 0x7f;
                            i_105_ = i_105_ + i_44_ & 0x3f;
                            i_106_ += i_45_;
                            if (i_106_ < 0) i_106_ = 0;
                            else if (i_106_ > 7) i_106_ = 7;
                            i_107_ += i_46_;
                            if (i_107_ < 0) i_107_ = 0;
                            else if (i_107_ > 127) i_107_ = 127;
                            faceColour[i_103_] = (short) (i_105_ << 10 | i_106_ << 7 | i_107_);
                        }
                        aBoolean5380 = true;
                    }
                }
                if (billboardFaces != null) {
                    for (int i_108_ = 0; i_108_ < billboardCount; i_108_++) {
                        JavaBillboardFace javaBillboardFace = billboardFaces[i_108_];
                        JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[i_108_];
                        javaBillboardAttributes.anInt4313 = (javaBillboardAttributes.anInt4313 & ~0xffffff | ((Class126.HSV_TO_RGB[SkyBoxSphereTypeList.method303((faceColour[(javaBillboardFace.index)]) & 0xffff, 30) & 0xffff]) & 0xffffff));
                    }
                }
            }
        } else if (i == 8) {
            if (anIntArrayArray5379 != null) {
                for (int i_109_ = 0; i_109_ < i_48_; i_109_++) {
                    int i_110_ = is[i_109_];
                    if (i_110_ < anIntArrayArray5379.length) {
                        int[] is_111_ = anIntArrayArray5379[i_110_];
                        for (int i_112_ = 0; i_112_ < is_111_.length; i_112_++) {
                            JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[is_111_[i_112_]];
                            javaBillboardAttributes.anInt4316 += i_44_;
                            javaBillboardAttributes.anInt4317 += i_45_;
                        }
                    }
                }
            }
        } else if (i == 10) {
            if (anIntArrayArray5379 != null) {
                for (int i_113_ = 0; i_113_ < i_48_; i_113_++) {
                    int i_114_ = is[i_113_];
                    if (i_114_ < anIntArrayArray5379.length) {
                        int[] is_115_ = anIntArrayArray5379[i_114_];
                        for (int i_116_ = 0; i_116_ < is_115_.length; i_116_++) {
                            JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[is_115_[i_116_]];
                            javaBillboardAttributes.anInt4314 = javaBillboardAttributes.anInt4314 * i_44_ >> 7;
                            javaBillboardAttributes.anInt4311 = javaBillboardAttributes.anInt4311 * i_45_ >> 7;
                        }
                    }
                }
            }
        } else if (i == 9 && anIntArrayArray5379 != null) {
            for (int i_117_ = 0; i_117_ < i_48_; i_117_++) {
                int i_118_ = is[i_117_];
                if (i_118_ < anIntArrayArray5379.length) {
                    int[] is_119_ = anIntArrayArray5379[i_118_];
                    for (int i_120_ = 0; i_120_ < is_119_.length; i_120_++) {
                        JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[is_119_[i_120_]];
                        javaBillboardAttributes.anInt4308 = javaBillboardAttributes.anInt4308 + i_44_ & 0x3fff;
                    }
                }
            }
        }
    }

    final void FA(int i) {
        if ((functionMask & 0x6) != 6) throw new IllegalStateException();
        int i_121_ = Class70.SIN[i];
        int i_122_ = Class70.COS[i];
        synchronized (this) {
            for (int i_123_ = 0; i_123_ < vertexCount; i_123_++) {
                int i_124_ = ((vertexY[i_123_] * i_122_ - vertexZ[i_123_] * i_121_) >> 14);
                vertexZ[i_123_] = (vertexY[i_123_] * i_121_ + vertexZ[i_123_] * i_122_) >> 14;
                vertexY[i_123_] = i_124_;
            }
            method631();
        }
    }

    final void method622() {
        if (toolkit.threadCount > 1) {
            synchronized (this) {
                while (this.aBoolean1124) {
                    try {
                        this.wait();
                    } catch (InterruptedException interruptedexception) {
                        /* empty */
                    }
                }
                this.aBoolean1124 = true;
            }
        }
    }

    final int G() {
        if (!calculatedBounds) calculateBounds();
        return maxVertexZ;
    }

    final void I(int i, int[] is, int i_125_, int i_126_, int i_127_, boolean bool, int i_128_, int[] is_129_) {
        int i_130_ = is.length;
        if (i == 0) {
            i_125_ <<= 4;
            i_126_ <<= 4;
            i_127_ <<= 4;
            if (!aBoolean5372) {
                for (int i_131_ = 0; i_131_ < vertexCount; i_131_++) {
                    vertexX[i_131_] <<= 4;
                    vertexY[i_131_] <<= 4;
                    vertexZ[i_131_] <<= 4;
                }
                aBoolean5372 = true;
            }
            int i_132_ = 0;
            anInt5338 = 0;
            anInt5375 = 0;
            anInt5342 = 0;
            for (int i_133_ = 0; i_133_ < i_130_; i_133_++) {
                int i_134_ = is[i_133_];
                if (i_134_ < anIntArrayArray5334.length) {
                    int[] is_135_ = anIntArrayArray5334[i_134_];
                    for (int i_136_ = 0; i_136_ < is_135_.length; i_136_++) {
                        int i_137_ = is_135_[i_136_];
                        if (originalModels == null || (i_128_ & originalModels[i_137_]) != 0) {
                            anInt5338 += vertexX[i_137_];
                            anInt5375 += vertexY[i_137_];
                            anInt5342 += vertexZ[i_137_];
                            i_132_++;
                        }
                    }
                }
            }
            if (i_132_ > 0) {
                anInt5338 = anInt5338 / i_132_ + i_125_;
                anInt5375 = anInt5375 / i_132_ + i_126_;
                anInt5342 = anInt5342 / i_132_ + i_127_;
                aBoolean5369 = true;
            } else {
                anInt5338 = i_125_;
                anInt5375 = i_126_;
                anInt5342 = i_127_;
            }
        } else if (i == 1) {
            if (is_129_ != null) {
                int i_138_ = ((is_129_[0] * i_125_ + is_129_[1] * i_126_ + is_129_[2] * i_127_ + 8192) >> 14);
                int i_139_ = ((is_129_[3] * i_125_ + is_129_[4] * i_126_ + is_129_[5] * i_127_ + 8192) >> 14);
                int i_140_ = ((is_129_[6] * i_125_ + is_129_[7] * i_126_ + is_129_[8] * i_127_ + 8192) >> 14);
                i_125_ = i_138_;
                i_126_ = i_139_;
                i_127_ = i_140_;
            }
            i_125_ <<= 4;
            i_126_ <<= 4;
            i_127_ <<= 4;
            if (!aBoolean5372) {
                for (int i_141_ = 0; i_141_ < vertexCount; i_141_++) {
                    vertexX[i_141_] <<= 4;
                    vertexY[i_141_] <<= 4;
                    vertexZ[i_141_] <<= 4;
                }
                aBoolean5372 = true;
            }
            for (int i_142_ = 0; i_142_ < i_130_; i_142_++) {
                int i_143_ = is[i_142_];
                if (i_143_ < anIntArrayArray5334.length) {
                    int[] is_144_ = anIntArrayArray5334[i_143_];
                    for (int i_145_ = 0; i_145_ < is_144_.length; i_145_++) {
                        int i_146_ = is_144_[i_145_];
                        if (originalModels == null || (i_128_ & originalModels[i_146_]) != 0) {
                            vertexX[i_146_] += i_125_;
                            vertexY[i_146_] += i_126_;
                            vertexZ[i_146_] += i_127_;
                        }
                    }
                }
            }
        } else if (i == 2) {
            if (is_129_ == null) {
                for (int i_196_ = 0; i_196_ < i_130_; i_196_++) {
                    int i_197_ = is[i_196_];
                    if (i_197_ < anIntArrayArray5334.length) {
                        int[] is_198_ = anIntArrayArray5334[i_197_];
                        for (int i_199_ = 0; i_199_ < is_198_.length; i_199_++) {
                            int i_200_ = is_198_[i_199_];
                            if (originalModels == null || (i_128_ & originalModels[i_200_]) != 0) {
                                vertexX[i_200_] -= anInt5338;
                                vertexY[i_200_] -= anInt5375;
                                vertexZ[i_200_] -= anInt5342;
                                if (i_127_ != 0) {
                                    int i_201_ = Class70.SIN[i_127_];
                                    int i_202_ = Class70.COS[i_127_];
                                    int i_203_ = ((vertexY[i_200_] * i_201_ + vertexX[i_200_] * i_202_ + 16383) >> 14);
                                    vertexY[i_200_] = (vertexY[i_200_] * i_202_ - vertexX[i_200_] * i_201_ + 16383) >> 14;
                                    vertexX[i_200_] = i_203_;
                                }
                                if (i_125_ != 0) {
                                    int i_204_ = Class70.SIN[i_125_];
                                    int i_205_ = Class70.COS[i_125_];
                                    int i_206_ = ((vertexY[i_200_] * i_205_ - vertexZ[i_200_] * i_204_ + 16383) >> 14);
                                    vertexZ[i_200_] = (vertexY[i_200_] * i_204_ + vertexZ[i_200_] * i_205_ + 16383) >> 14;
                                    vertexY[i_200_] = i_206_;
                                }
                                if (i_126_ != 0) {
                                    int i_207_ = Class70.SIN[i_126_];
                                    int i_208_ = Class70.COS[i_126_];
                                    int i_209_ = ((vertexZ[i_200_] * i_207_ + vertexX[i_200_] * i_208_ + 16383) >> 14);
                                    vertexZ[i_200_] = (vertexZ[i_200_] * i_208_ - vertexX[i_200_] * i_207_ + 16383) >> 14;
                                    vertexX[i_200_] = i_209_;
                                }
                                vertexX[i_200_] += anInt5338;
                                vertexY[i_200_] += anInt5375;
                                vertexZ[i_200_] += anInt5342;
                            }
                        }
                    }
                }
            } else {
                if (!aBoolean5372) {
                    for (int i_147_ = 0; i_147_ < vertexCount; i_147_++) {
                        vertexX[i_147_] <<= 4;
                        vertexY[i_147_] <<= 4;
                        vertexZ[i_147_] <<= 4;
                    }
                    aBoolean5372 = true;
                }
                int i_148_ = is_129_[9] << 4;
                int i_149_ = is_129_[10] << 4;
                int i_150_ = is_129_[11] << 4;
                int i_151_ = is_129_[12] << 4;
                int i_152_ = is_129_[13] << 4;
                int i_153_ = is_129_[14] << 4;
                if (aBoolean5369) {
                    int i_154_ = ((is_129_[0] * anInt5338 + is_129_[3] * anInt5375 + is_129_[6] * anInt5342 + 8192) >> 14);
                    int i_155_ = ((is_129_[1] * anInt5338 + is_129_[4] * anInt5375 + is_129_[7] * anInt5342 + 8192) >> 14);
                    int i_156_ = ((is_129_[2] * anInt5338 + is_129_[5] * anInt5375 + is_129_[8] * anInt5342 + 8192) >> 14);
                    i_154_ += i_151_;
                    i_155_ += i_152_;
                    i_156_ += i_153_;
                    anInt5338 = i_154_;
                    anInt5375 = i_155_;
                    anInt5342 = i_156_;
                    aBoolean5369 = false;
                }
                int[] is_157_ = new int[9];
                int i_158_ = Class70.COS[i_125_];
                int i_159_ = Class70.SIN[i_125_];
                int i_160_ = Class70.COS[i_126_];
                int i_161_ = Class70.SIN[i_126_];
                int i_162_ = Class70.COS[i_127_];
                int i_163_ = Class70.SIN[i_127_];
                int i_164_ = i_159_ * i_162_ + 8192 >> 14;
                int i_165_ = i_159_ * i_163_ + 8192 >> 14;
                is_157_[0] = i_160_ * i_162_ + i_161_ * i_165_ + 8192 >> 14;
                is_157_[1] = -i_160_ * i_163_ + i_161_ * i_164_ + 8192 >> 14;
                is_157_[2] = i_161_ * i_158_ + 8192 >> 14;
                is_157_[3] = i_158_ * i_163_ + 8192 >> 14;
                is_157_[4] = i_158_ * i_162_ + 8192 >> 14;
                is_157_[5] = -i_159_;
                is_157_[6] = -i_161_ * i_162_ + i_160_ * i_165_ + 8192 >> 14;
                is_157_[7] = i_161_ * i_163_ + i_160_ * i_164_ + 8192 >> 14;
                is_157_[8] = i_160_ * i_158_ + 8192 >> 14;
                int i_166_ = (is_157_[0] * -anInt5338 + is_157_[1] * -anInt5375 + is_157_[2] * -anInt5342 + 8192) >> 14;
                int i_167_ = (is_157_[3] * -anInt5338 + is_157_[4] * -anInt5375 + is_157_[5] * -anInt5342 + 8192) >> 14;
                int i_168_ = (is_157_[6] * -anInt5338 + is_157_[7] * -anInt5375 + is_157_[8] * -anInt5342 + 8192) >> 14;
                int i_169_ = i_166_ + anInt5338;
                int i_170_ = i_167_ + anInt5375;
                int i_171_ = i_168_ + anInt5342;
                int[] is_172_ = new int[9];
                for (int i_173_ = 0; i_173_ < 3; i_173_++) {
                    for (int i_174_ = 0; i_174_ < 3; i_174_++) {
                        int i_175_ = 0;
                        for (int i_176_ = 0; i_176_ < 3; i_176_++)
                            i_175_ += (is_157_[i_173_ * 3 + i_176_] * is_129_[i_174_ * 3 + i_176_]);
                        is_172_[i_173_ * 3 + i_174_] = i_175_ + 8192 >> 14;
                    }
                }
                int i_177_ = ((is_157_[0] * i_151_ + is_157_[1] * i_152_ + is_157_[2] * i_153_ + 8192) >> 14);
                int i_178_ = ((is_157_[3] * i_151_ + is_157_[4] * i_152_ + is_157_[5] * i_153_ + 8192) >> 14);
                int i_179_ = ((is_157_[6] * i_151_ + is_157_[7] * i_152_ + is_157_[8] * i_153_ + 8192) >> 14);
                i_177_ += i_169_;
                i_178_ += i_170_;
                i_179_ += i_171_;
                int[] is_180_ = new int[9];
                for (int i_181_ = 0; i_181_ < 3; i_181_++) {
                    for (int i_182_ = 0; i_182_ < 3; i_182_++) {
                        int i_183_ = 0;
                        for (int i_184_ = 0; i_184_ < 3; i_184_++)
                            i_183_ += (is_129_[i_181_ * 3 + i_184_] * is_172_[i_182_ + i_184_ * 3]);
                        is_180_[i_181_ * 3 + i_182_] = i_183_ + 8192 >> 14;
                    }
                }
                int i_185_ = ((is_129_[0] * i_177_ + is_129_[1] * i_178_ + is_129_[2] * i_179_ + 8192) >> 14);
                int i_186_ = ((is_129_[3] * i_177_ + is_129_[4] * i_178_ + is_129_[5] * i_179_ + 8192) >> 14);
                int i_187_ = ((is_129_[6] * i_177_ + is_129_[7] * i_178_ + is_129_[8] * i_179_ + 8192) >> 14);
                i_185_ += i_148_;
                i_186_ += i_149_;
                i_187_ += i_150_;
                for (int i_188_ = 0; i_188_ < i_130_; i_188_++) {
                    int i_189_ = is[i_188_];
                    if (i_189_ < anIntArrayArray5334.length) {
                        int[] is_190_ = anIntArrayArray5334[i_189_];
                        for (int i_191_ = 0; i_191_ < is_190_.length; i_191_++) {
                            int i_192_ = is_190_[i_191_];
                            if (originalModels == null || (i_128_ & originalModels[i_192_]) != 0) {
                                int i_193_ = ((is_180_[0] * vertexX[i_192_] + is_180_[1] * vertexY[i_192_] + is_180_[2] * vertexZ[i_192_] + 8192) >> 14);
                                int i_194_ = ((is_180_[3] * vertexX[i_192_] + is_180_[4] * vertexY[i_192_] + is_180_[5] * vertexZ[i_192_] + 8192) >> 14);
                                int i_195_ = ((is_180_[6] * vertexX[i_192_] + is_180_[7] * vertexY[i_192_] + is_180_[8] * vertexZ[i_192_] + 8192) >> 14);
                                i_193_ += i_185_;
                                i_194_ += i_186_;
                                i_195_ += i_187_;
                                vertexX[i_192_] = i_193_;
                                vertexY[i_192_] = i_194_;
                                vertexZ[i_192_] = i_195_;
                            }
                        }
                    }
                }
            }
        } else if (i == 3) {
            if (is_129_ == null) {
                for (int i_249_ = 0; i_249_ < i_130_; i_249_++) {
                    int i_250_ = is[i_249_];
                    if (i_250_ < anIntArrayArray5334.length) {
                        int[] is_251_ = anIntArrayArray5334[i_250_];
                        for (int i_252_ = 0; i_252_ < is_251_.length; i_252_++) {
                            int i_253_ = is_251_[i_252_];
                            if (originalModels == null || (i_128_ & originalModels[i_253_]) != 0) {
                                vertexX[i_253_] -= anInt5338;
                                vertexY[i_253_] -= anInt5375;
                                vertexZ[i_253_] -= anInt5342;
                                vertexX[i_253_] = vertexX[i_253_] * i_125_ / 128;
                                vertexY[i_253_] = vertexY[i_253_] * i_126_ / 128;
                                vertexZ[i_253_] = vertexZ[i_253_] * i_127_ / 128;
                                vertexX[i_253_] += anInt5338;
                                vertexY[i_253_] += anInt5375;
                                vertexZ[i_253_] += anInt5342;
                            }
                        }
                    }
                }
            } else {
                if (!aBoolean5372) {
                    for (int i_210_ = 0; i_210_ < vertexCount; i_210_++) {
                        vertexX[i_210_] <<= 4;
                        vertexY[i_210_] <<= 4;
                        vertexZ[i_210_] <<= 4;
                    }
                    aBoolean5372 = true;
                }
                int i_211_ = is_129_[9] << 4;
                int i_212_ = is_129_[10] << 4;
                int i_213_ = is_129_[11] << 4;
                int i_214_ = is_129_[12] << 4;
                int i_215_ = is_129_[13] << 4;
                int i_216_ = is_129_[14] << 4;
                if (aBoolean5369) {
                    int i_217_ = ((is_129_[0] * anInt5338 + is_129_[3] * anInt5375 + is_129_[6] * anInt5342 + 8192) >> 14);
                    int i_218_ = ((is_129_[1] * anInt5338 + is_129_[4] * anInt5375 + is_129_[7] * anInt5342 + 8192) >> 14);
                    int i_219_ = ((is_129_[2] * anInt5338 + is_129_[5] * anInt5375 + is_129_[8] * anInt5342 + 8192) >> 14);
                    i_217_ += i_214_;
                    i_218_ += i_215_;
                    i_219_ += i_216_;
                    anInt5338 = i_217_;
                    anInt5375 = i_218_;
                    anInt5342 = i_219_;
                    aBoolean5369 = false;
                }
                int i_220_ = i_125_ << 15 >> 7;
                int i_221_ = i_126_ << 15 >> 7;
                int i_222_ = i_127_ << 15 >> 7;
                int i_223_ = i_220_ * -anInt5338 + 8192 >> 14;
                int i_224_ = i_221_ * -anInt5375 + 8192 >> 14;
                int i_225_ = i_222_ * -anInt5342 + 8192 >> 14;
                int i_226_ = i_223_ + anInt5338;
                int i_227_ = i_224_ + anInt5375;
                int i_228_ = i_225_ + anInt5342;
                int[] is_229_ = new int[9];
                is_229_[0] = i_220_ * is_129_[0] + 8192 >> 14;
                is_229_[1] = i_220_ * is_129_[3] + 8192 >> 14;
                is_229_[2] = i_220_ * is_129_[6] + 8192 >> 14;
                is_229_[3] = i_221_ * is_129_[1] + 8192 >> 14;
                is_229_[4] = i_221_ * is_129_[4] + 8192 >> 14;
                is_229_[5] = i_221_ * is_129_[7] + 8192 >> 14;
                is_229_[6] = i_222_ * is_129_[2] + 8192 >> 14;
                is_229_[7] = i_222_ * is_129_[5] + 8192 >> 14;
                is_229_[8] = i_222_ * is_129_[8] + 8192 >> 14;
                int i_230_ = i_220_ * i_214_ + 8192 >> 14;
                int i_231_ = i_221_ * i_215_ + 8192 >> 14;
                int i_232_ = i_222_ * i_216_ + 8192 >> 14;
                i_230_ += i_226_;
                i_231_ += i_227_;
                i_232_ += i_228_;
                int[] is_233_ = new int[9];
                for (int i_234_ = 0; i_234_ < 3; i_234_++) {
                    for (int i_235_ = 0; i_235_ < 3; i_235_++) {
                        int i_236_ = 0;
                        for (int i_237_ = 0; i_237_ < 3; i_237_++)
                            i_236_ += (is_129_[i_234_ * 3 + i_237_] * is_229_[i_235_ + i_237_ * 3]);
                        is_233_[i_234_ * 3 + i_235_] = i_236_ + 8192 >> 14;
                    }
                }
                int i_238_ = ((is_129_[0] * i_230_ + is_129_[1] * i_231_ + is_129_[2] * i_232_ + 8192) >> 14);
                int i_239_ = ((is_129_[3] * i_230_ + is_129_[4] * i_231_ + is_129_[5] * i_232_ + 8192) >> 14);
                int i_240_ = ((is_129_[6] * i_230_ + is_129_[7] * i_231_ + is_129_[8] * i_232_ + 8192) >> 14);
                i_238_ += i_211_;
                i_239_ += i_212_;
                i_240_ += i_213_;
                for (int i_241_ = 0; i_241_ < i_130_; i_241_++) {
                    int i_242_ = is[i_241_];
                    if (i_242_ < anIntArrayArray5334.length) {
                        int[] is_243_ = anIntArrayArray5334[i_242_];
                        for (int i_244_ = 0; i_244_ < is_243_.length; i_244_++) {
                            int i_245_ = is_243_[i_244_];
                            if (originalModels == null || (i_128_ & originalModels[i_245_]) != 0) {
                                int i_246_ = ((is_233_[0] * vertexX[i_245_] + is_233_[1] * vertexY[i_245_] + is_233_[2] * vertexZ[i_245_] + 8192) >> 14);
                                int i_247_ = ((is_233_[3] * vertexX[i_245_] + is_233_[4] * vertexY[i_245_] + is_233_[5] * vertexZ[i_245_] + 8192) >> 14);
                                int i_248_ = ((is_233_[6] * vertexX[i_245_] + is_233_[7] * vertexY[i_245_] + is_233_[8] * vertexZ[i_245_] + 8192) >> 14);
                                i_246_ += i_238_;
                                i_247_ += i_239_;
                                i_248_ += i_240_;
                                vertexX[i_245_] = i_246_;
                                vertexY[i_245_] = i_247_;
                                vertexZ[i_245_] = i_248_;
                            }
                        }
                    }
                }
            }
        } else if (i == 5) {
            if (anIntArrayArray5330 != null && faceAlphas != null) {
                for (int i_254_ = 0; i_254_ < i_130_; i_254_++) {
                    int i_255_ = is[i_254_];
                    if (i_255_ < anIntArrayArray5330.length) {
                        int[] is_256_ = anIntArrayArray5330[i_255_];
                        for (int i_257_ = 0; i_257_ < is_256_.length; i_257_++) {
                            int i_258_ = is_256_[i_257_];
                            if (aShortArray5370 == null || (i_128_ & aShortArray5370[i_258_]) != 0) {
                                int i_259_ = ((faceAlphas[i_258_] & 0xff) + i_125_ * 8);
                                if (i_259_ < 0) i_259_ = 0;
                                else if (i_259_ > 255) i_259_ = 255;
                                faceAlphas[i_258_] = (byte) i_259_;
                            }
                        }
                    }
                }
                if (billboardFaces != null) {
                    for (int i_260_ = 0; i_260_ < billboardCount; i_260_++) {
                        JavaBillboardFace javaBillboardFace = billboardFaces[i_260_];
                        JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[i_260_];
                        javaBillboardAttributes.anInt4313 = (javaBillboardAttributes.anInt4313 & 0xffffff | (255 - (faceAlphas[javaBillboardFace.index] & 0xff)) << 24);
                    }
                }
            }
        } else if (i == 7) {
            if (anIntArrayArray5330 != null) {
                for (int i_261_ = 0; i_261_ < i_130_; i_261_++) {
                    int i_262_ = is[i_261_];
                    if (i_262_ < anIntArrayArray5330.length) {
                        int[] is_263_ = anIntArrayArray5330[i_262_];
                        for (int i_264_ = 0; i_264_ < is_263_.length; i_264_++) {
                            int i_265_ = is_263_[i_264_];
                            if (aShortArray5370 == null || (i_128_ & aShortArray5370[i_265_]) != 0) {
                                int i_266_ = faceColour[i_265_] & 0xffff;
                                int i_267_ = i_266_ >> 10 & 0x3f;
                                int i_268_ = i_266_ >> 7 & 0x7;
                                int i_269_ = i_266_ & 0x7f;
                                i_267_ = i_267_ + i_125_ & 0x3f;
                                i_268_ += i_126_;
                                if (i_268_ < 0) i_268_ = 0;
                                else if (i_268_ > 7) i_268_ = 7;
                                i_269_ += i_127_;
                                if (i_269_ < 0) i_269_ = 0;
                                else if (i_269_ > 127) i_269_ = 127;
                                faceColour[i_265_] = (short) (i_267_ << 10 | i_268_ << 7 | i_269_);
                            }
                        }
                        aBoolean5380 = true;
                    }
                }
                if (billboardFaces != null) {
                    for (int i_270_ = 0; i_270_ < billboardCount; i_270_++) {
                        JavaBillboardFace javaBillboardFace = billboardFaces[i_270_];
                        JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[i_270_];
                        javaBillboardAttributes.anInt4313 = (javaBillboardAttributes.anInt4313 & ~0xffffff | ((Class126.HSV_TO_RGB[SkyBoxSphereTypeList.method303((faceColour[(javaBillboardFace.index)]) & 0xffff, 30) & 0xffff]) & 0xffffff));
                    }
                }
            }
        } else if (i == 8) {
            if (anIntArrayArray5379 != null) {
                for (int i_271_ = 0; i_271_ < i_130_; i_271_++) {
                    int i_272_ = is[i_271_];
                    if (i_272_ < anIntArrayArray5379.length) {
                        int[] is_273_ = anIntArrayArray5379[i_272_];
                        for (int i_274_ = 0; i_274_ < is_273_.length; i_274_++) {
                            JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[is_273_[i_274_]];
                            javaBillboardAttributes.anInt4316 += i_125_;
                            javaBillboardAttributes.anInt4317 += i_126_;
                        }
                    }
                }
            }
        } else if (i == 10) {
            if (anIntArrayArray5379 != null) {
                for (int i_275_ = 0; i_275_ < i_130_; i_275_++) {
                    int i_276_ = is[i_275_];
                    if (i_276_ < anIntArrayArray5379.length) {
                        int[] is_277_ = anIntArrayArray5379[i_276_];
                        for (int i_278_ = 0; i_278_ < is_277_.length; i_278_++) {
                            JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[is_277_[i_278_]];
                            javaBillboardAttributes.anInt4314 = (javaBillboardAttributes.anInt4314 * i_125_ >> 7);
                            javaBillboardAttributes.anInt4311 = (javaBillboardAttributes.anInt4311 * i_126_ >> 7);
                        }
                    }
                }
            }
        } else if (i == 9 && anIntArrayArray5379 != null) {
            for (int i_279_ = 0; i_279_ < i_130_; i_279_++) {
                int i_280_ = is[i_279_];
                if (i_280_ < anIntArrayArray5379.length) {
                    int[] is_281_ = anIntArrayArray5379[i_280_];
                    for (int i_282_ = 0; i_282_ < is_281_.length; i_282_++) {
                        JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[is_281_[i_282_]];
                        javaBillboardAttributes.anInt4308 = (javaBillboardAttributes.anInt4308 + i_125_ & 0x3fff);
                    }
                }
            }
        }
    }

    private final void method636() {
        if (renderPoints == 0 && normals == null) {
            if (toolkit.threadCount > 1) {
                synchronized (this) {
                    method649();
                }
            } else method649();
        }
    }

    final void wa() {
        if (aBoolean5372) {
            for (int i = 0; i < vertexCount; i++) {
                vertexX[i] = vertexX[i] + 7 >> 4;
                vertexY[i] = vertexY[i] + 7 >> 4;
                vertexZ[i] = vertexZ[i] + 7 >> 4;
            }
            aBoolean5372 = false;
        }
        if (aBoolean5380) {
            method647();
            aBoolean5380 = false;
        }
        calculatedBounds = false;
    }

    final int fa() {
        if (!calculatedBounds) calculateBounds();
        return minVertexY;
    }

    private final int method637(int i, int i_283_) {
        i_283_ = i_283_ * (i & 0x7f) >> 7;
        if (i_283_ < 2) i_283_ = 2;
        else if (i_283_ > 126) i_283_ = 126;
        return (i & 0xff80) + i_283_;
    }

    private final boolean noBillboard(int i) {
        if (billboardIndices == null) return false;
        return billboardIndices[i] != -1;
    }

    final int da() {
        return anInt5349;
    }

    private final void method639() {
        synchronized (this) {
            for (int i = 0; i < vertexCount; i++) {
                int i_284_ = vertexZ[i];
                vertexZ[i] = vertexX[i];
                vertexX[i] = -i_284_;
            }
            method631();
        }
    }

    final boolean method618() {
        if (faceTextures == null) return true;
        for (int i = 0; i < faceTextures.length; i++) {
            if (faceTextures[i] != -1 && !toolkit.method3725(faceTextures[i])) return false;
        }
        return true;
    }

    final void method620(Matrix matrix) {
        JavaMatrix javaMatrix = (JavaMatrix) matrix;
        if (emitters != null) {
            for (int i = 0; i < emitters.length; i++) {
                ModelParticleEmitter modelParticleEmitter = emitters[i];
                ModelParticleEmitter modelParticleEmitter_285_ = modelParticleEmitter;
                if (modelParticleEmitter.aModelParticleEmitter_1888 != null) modelParticleEmitter_285_ = modelParticleEmitter.aModelParticleEmitter_1888;
                modelParticleEmitter_285_.anInt1882 = (int) (javaMatrix.tX + ((javaMatrix.cZ * (float) (vertexX[modelParticleEmitter.anInt1881])) + (javaMatrix.cY * (float) (vertexY[(modelParticleEmitter.anInt1881)])) + (javaMatrix.aY * (float) (vertexZ[(modelParticleEmitter.anInt1881)]))));
                modelParticleEmitter_285_.anInt1891 = (int) (javaMatrix.tZ + ((javaMatrix.cX * (float) (vertexX[modelParticleEmitter.anInt1881])) + (javaMatrix.bX * (float) (vertexY[(modelParticleEmitter.anInt1881)])) + (javaMatrix.aX * (float) (vertexZ[(modelParticleEmitter.anInt1881)]))));
                modelParticleEmitter_285_.anInt1889 = (int) (javaMatrix.tY + ((javaMatrix.bZ * (float) (vertexX[modelParticleEmitter.anInt1881])) + (javaMatrix.aZ * (float) (vertexY[(modelParticleEmitter.anInt1881)])) + (javaMatrix.bY * (float) (vertexZ[(modelParticleEmitter.anInt1881)]))));
                modelParticleEmitter_285_.anInt1883 = (int) (javaMatrix.tX + ((javaMatrix.cZ * (float) (vertexX[modelParticleEmitter.anInt1877])) + (javaMatrix.cY * (float) (vertexY[(modelParticleEmitter.anInt1877)])) + (javaMatrix.aY * (float) (vertexZ[(modelParticleEmitter.anInt1877)]))));
                modelParticleEmitter_285_.anInt1890 = (int) (javaMatrix.tZ + ((javaMatrix.cX * (float) (vertexX[modelParticleEmitter.anInt1877])) + (javaMatrix.bX * (float) (vertexY[(modelParticleEmitter.anInt1877)])) + (javaMatrix.aX * (float) (vertexZ[(modelParticleEmitter.anInt1877)]))));
                modelParticleEmitter_285_.anInt1880 = (int) (javaMatrix.tY + ((javaMatrix.bZ * (float) (vertexX[modelParticleEmitter.anInt1877])) + (javaMatrix.aZ * (float) (vertexY[(modelParticleEmitter.anInt1877)])) + (javaMatrix.bY * (float) (vertexZ[(modelParticleEmitter.anInt1877)]))));
                modelParticleEmitter_285_.anInt1876 = (int) (javaMatrix.tX + ((javaMatrix.cZ * (float) (vertexX[modelParticleEmitter.anInt1892])) + (javaMatrix.cY * (float) (vertexY[(modelParticleEmitter.anInt1892)])) + (javaMatrix.aY * (float) (vertexZ[(modelParticleEmitter.anInt1892)]))));
                modelParticleEmitter_285_.anInt1874 = (int) (javaMatrix.tZ + ((javaMatrix.cX * (float) (vertexX[modelParticleEmitter.anInt1892])) + (javaMatrix.bX * (float) (vertexY[(modelParticleEmitter.anInt1892)])) + (javaMatrix.aX * (float) (vertexZ[(modelParticleEmitter.anInt1892)]))));
                modelParticleEmitter_285_.anInt1884 = (int) (javaMatrix.tY + ((javaMatrix.bZ * (float) (vertexX[modelParticleEmitter.anInt1892])) + (javaMatrix.aZ * (float) (vertexY[(modelParticleEmitter.anInt1892)])) + (javaMatrix.bY * (float) (vertexZ[(modelParticleEmitter.anInt1892)]))));
            }
        }
        if (effectors != null) {
            for (int i = 0; i < effectors.length; i++) {
                ModelParticleEffector modelParticleEffector = effectors[i];
                ModelParticleEffector modelParticleEffector_286_ = modelParticleEffector;
                if (modelParticleEffector.aModelParticleEffector_4248 != null) modelParticleEffector_286_ = modelParticleEffector.aModelParticleEffector_4248;
                if (modelParticleEffector.aMatrix_4252 != null) modelParticleEffector.aMatrix_4252.method898(javaMatrix);
                else modelParticleEffector.aMatrix_4252 = javaMatrix.method907();
                modelParticleEffector_286_.anInt4238 = (int) (javaMatrix.tX + ((javaMatrix.cZ * (float) (vertexX[modelParticleEffector.anInt4244])) + (javaMatrix.cY * (float) (vertexY[(modelParticleEffector.anInt4244)])) + (javaMatrix.aY * (float) (vertexZ[(modelParticleEffector.anInt4244)]))));
                modelParticleEffector_286_.anInt4239 = (int) (javaMatrix.tZ + ((javaMatrix.cX * (float) (vertexX[modelParticleEffector.anInt4244])) + (javaMatrix.bX * (float) (vertexY[(modelParticleEffector.anInt4244)])) + (javaMatrix.aX * (float) (vertexZ[(modelParticleEffector.anInt4244)]))));
                modelParticleEffector_286_.anInt4240 = (int) (javaMatrix.tY + ((javaMatrix.bZ * (float) (vertexX[modelParticleEffector.anInt4244])) + (javaMatrix.aZ * (float) (vertexY[(modelParticleEffector.anInt4244)])) + (javaMatrix.bY * (float) (vertexZ[(modelParticleEffector.anInt4244)]))));
            }
        }
    }

    private final void method640() {
        for (int i = 0; i < faceCount; i++) {
            short i_287_ = faceTextures != null ? faceTextures[i] : (short) -1;
            if (i_287_ == -1) {
                int i_288_ = faceColour[i] & 0xffff;
                int i_289_ = (i_288_ & 0x7f) * anInt5344 >> 7;
                short i_290_ = SkyBoxSphereTypeList.method303(i_288_ & ~0x7f | i_289_, 30);
                if (shadeFacesZ[i] == -1) {
                    int i_291_ = shadeFacesX[i] & ~0x1ffff;
                    shadeFacesX[i] = i_291_ | Class291.method2198(0, i_291_ >> 17, i_290_);
                } else if (shadeFacesZ[i] != -2) {
                    int i_292_ = shadeFacesX[i] & ~0x1ffff;
                    shadeFacesX[i] = i_292_ | Class291.method2198(0, i_292_ >> 17, i_290_);
                    i_292_ = shadeFacesY[i] & ~0x1ffff;
                    shadeFacesY[i] = i_292_ | Class291.method2198(0, i_292_ >> 17, i_290_);
                    i_292_ = shadeFacesZ[i] & ~0x1ffff;
                    shadeFacesZ[i] = i_292_ | Class291.method2198(0, i_292_ >> 17, i_290_);
                }
            }
        }
        renderPoints = 2;
    }

    final void k(int i) {
        if ((functionMask & 0xd) != 13) throw new IllegalStateException();
        if (normals != null) {
            if (i == 4096) method653();
            else if (i == 8192) method652();
            else if (i == 12288) method641();
            else {
                int i_293_ = Class70.SIN[i];
                int i_294_ = Class70.COS[i];
                synchronized (this) {
                    for (int i_295_ = 0; i_295_ < maxVertex; i_295_++) {
                        int i_296_ = ((vertexZ[i_295_] * i_293_ + vertexX[i_295_] * i_294_) >> 14);
                        vertexZ[i_295_] = (vertexZ[i_295_] * i_294_ - vertexX[i_295_] * i_293_) >> 14;
                        vertexX[i_295_] = i_296_;
                        if (normals[i_295_] != null) {
                            i_296_ = ((normals[i_295_].z) * i_293_ + (normals[i_295_].x) * i_294_) >> 14;
                            normals[i_295_].z = ((normals[i_295_].z) * i_294_ - (normals[i_295_].x) * i_293_) >> 14;
                            normals[i_295_].x = i_296_;
                        }
                    }
                    if (aClass41Array5385 != null) {
                        for (int i_297_ = 0; i_297_ < faceCount; i_297_++) {
                            if (aClass41Array5385[i_297_] != null) {
                                int i_298_ = ((aClass41Array5385[i_297_].z) * i_293_ + (aClass41Array5385[i_297_].x) * i_294_) >> 14;
                                aClass41Array5385[i_297_].z = ((aClass41Array5385[i_297_].z) * i_294_ - (aClass41Array5385[i_297_].x) * i_293_) >> 14;
                                aClass41Array5385[i_297_].x = i_298_;
                            }
                        }
                    }
                    for (int i_299_ = maxVertex; i_299_ < vertexCount; i_299_++) {
                        int i_300_ = ((vertexZ[i_299_] * i_293_ + vertexX[i_299_] * i_294_) >> 14);
                        vertexZ[i_299_] = (vertexZ[i_299_] * i_294_ - vertexX[i_299_] * i_293_) >> 14;
                        vertexX[i_299_] = i_300_;
                    }
                    renderPoints = 0;
                    calculatedBounds = false;
                }
            }
        } else a(i);
    }

    final void method610(Matrix matrix, int i, boolean bool) {
        if (originalModels != null) {
            int[] is = new int[3];
            for (int i_301_ = 0; i_301_ < maxVertex; i_301_++) {
                if ((i & originalModels[i_301_]) != 0) {
                    if (bool) matrix.method892(vertexX[i_301_], vertexY[i_301_], vertexZ[i_301_], is);
                    else matrix.method897(vertexX[i_301_], vertexY[i_301_], vertexZ[i_301_], is);
                    vertexX[i_301_] = is[0];
                    vertexY[i_301_] = is[1];
                    vertexZ[i_301_] = is[2];
                }
            }
        }
    }

    final void method612() {
        /* empty */
    }

    private final void method641() {
        synchronized (this) {
            for (int i = 0; i < maxVertex; i++) {
                int i_302_ = vertexZ[i];
                vertexZ[i] = vertexX[i];
                vertexX[i] = -i_302_;
                if (normals[i] != null) {
                    i_302_ = normals[i].z;
                    normals[i].z = normals[i].x;
                    normals[i].x = -i_302_;
                }
            }
            if (aClass41Array5385 != null) {
                for (int i = 0; i < faceCount; i++) {
                    if (aClass41Array5385[i] != null) {
                        int i_303_ = aClass41Array5385[i].z;
                        aClass41Array5385[i].z = aClass41Array5385[i].x;
                        aClass41Array5385[i].x = -i_303_;
                    }
                }
            }
            for (int i = maxVertex; i < vertexCount; i++) {
                int i_304_ = vertexZ[i];
                vertexZ[i] = vertexX[i];
                vertexX[i] = -i_304_;
            }
            renderPoints = 0;
            calculatedBounds = false;
        }
    }

    private final int method642(int i, short i_305_, int i_306_) {
        int i_307_ = Class10.HSL_TO_RGB[method637(i, i_306_)];
        TextureMetrics textureMetrics = toolkit.aD4579.getMetrics(i_305_ & 0xffff, -6662);
        int i_308_ = textureMetrics.aByte201 & 0xff;
        if (i_308_ != 0) {
            int i_309_ = 131586 * i_306_;
            if (i_308_ == 256) i_307_ = i_309_;
            else {
                int i_310_ = i_308_;
                int i_311_ = 256 - i_308_;
                i_307_ = ((((i_309_ & 0xff00ff) * i_310_ + (i_307_ & 0xff00ff) * i_311_) & ~0xff00ff) + (((i_309_ & 0xff00) * i_310_ + (i_307_ & 0xff00) * i_311_) & 0xff0000)) >> 8;
            }
        }
        int i_312_ = textureMetrics.aByte216 & 0xff;
        if (i_312_ != 0) {
            i_312_ += 256;
            int i_313_ = ((i_307_ & 0xff0000) >> 16) * i_312_;
            if (i_313_ > 65535) i_313_ = 65535;
            int i_314_ = ((i_307_ & 0xff00) >> 8) * i_312_;
            if (i_314_ > 65535) i_314_ = 65535;
            int i_315_ = (i_307_ & 0xff) * i_312_;
            if (i_315_ > 65535) i_315_ = 65535;
            i_307_ = (i_313_ << 8 & 0xff0000) + (i_314_ & 0xff00) + (i_315_ >> 8);
        }
        return i_307_;
    }

    // method608
    final void render(Matrix matrix, LabelBounds class318_sub3, int i, int i_316_) {
        renderModel(matrix, class318_sub3, i, i_316_);
    }

    final boolean NA() {
        if (anIntArrayArray5334 == null) return false;
        anInt5338 = 0;
        anInt5375 = 0;
        anInt5342 = 0;
        return true;
    }

    private final void method643(int i, boolean bool, boolean bool_317_) {
        if (shadeFacesZ[i] != -2) {
            short faceX = faceIndexX[i];
            short faceY = faceIndexY[i];
            short faceZ = faceIndexZ[i];
            int x = renderVertexX[faceX];
            int y = renderVertexX[faceY];
            int z = renderVertexX[faceZ];
            if (bool && (x == -5000 || y == -5000 || z == -5000)) {
                int aX = cameraX[faceX];
                int bX = cameraX[faceY];
                int cX = cameraX[faceZ];
                int aY = cameraY[faceX];
                int bY = cameraY[faceY];
                int cY = cameraY[faceZ];
                int aZ = cameraZ[faceX];
                int bZ = cameraZ[faceY];
                int cZ = cameraZ[faceZ];
                aX -= bX;
                cX -= bX;
                aY -= bY;
                cY -= bY;
                aZ -= bZ;
                cZ -= bZ;
                int i_333_ = aY * cZ - aZ * cY;
                int i_334_ = aZ * cX - aX * cZ;
                int i_335_ = aX * cY - aY * cX;
                if (bX * i_333_ + bY * i_334_ + bZ * i_335_ > 0) renderFaceClipping(i);
            } else if (billboardIndices[i] != -1 || ((x - y) * (renderVertexY[faceZ] - renderVertexY[faceY]) - ((renderVertexY[faceX] - renderVertexY[faceY]) * (z - y))) > 0) {
                aRasterizer_5383.restrictEdges = x < 0 || y < 0 || z < 0 || x > aJavaThreadResource_5367.width || y > aJavaThreadResource_5367.width || z > aJavaThreadResource_5367.width;
                if (bool_317_) {
                    int i_336_ = billboardIndices[i];
                    if (i_336_ == -1 || !billboardFaces[i_336_].aBoolean145) method658(i);
                } else {
                    int i_337_ = billboardIndices[i];
                    if (i_337_ != -1) {
                        JavaBillboardFace javaBillboardFace = billboardFaces[i_337_];
                        JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[i_337_];
                        if (!javaBillboardFace.aBoolean145) drawFace(i);
                        toolkit.method3720(javaBillboardAttributes.screenX, javaBillboardAttributes.screenY, javaBillboardAttributes.screenZ, javaBillboardAttributes.screenWidth, javaBillboardAttributes.screenHeight, javaBillboardAttributes.anInt4308, javaBillboardFace.aShort146 & 0xffff, javaBillboardAttributes.anInt4313, javaBillboardFace.aByte148, javaBillboardFace.aByte156);
                    } else drawFace(i);
                }
            }
        }
    }

    final boolean F() {
        return transparent;
    }

    final void P(int i, int i_338_, int i_339_, int i_340_) {
        if (i == 0) {
            int i_341_ = 0;
            anInt5338 = 0;
            anInt5375 = 0;
            anInt5342 = 0;
            for (int i_342_ = 0; i_342_ < vertexCount; i_342_++) {
                anInt5338 += vertexX[i_342_];
                anInt5375 += vertexY[i_342_];
                anInt5342 += vertexZ[i_342_];
                i_341_++;
            }
            if (i_341_ > 0) {
                anInt5338 = anInt5338 / i_341_ + i_338_;
                anInt5375 = anInt5375 / i_341_ + i_339_;
                anInt5342 = anInt5342 / i_341_ + i_340_;
            } else {
                anInt5338 = i_338_;
                anInt5375 = i_339_;
                anInt5342 = i_340_;
            }
        } else if (i == 1) {
            for (int i_343_ = 0; i_343_ < vertexCount; i_343_++) {
                vertexX[i_343_] += i_338_;
                vertexY[i_343_] += i_339_;
                vertexZ[i_343_] += i_340_;
            }
        } else if (i == 2) {
            for (int i_344_ = 0; i_344_ < vertexCount; i_344_++) {
                vertexX[i_344_] -= anInt5338;
                vertexY[i_344_] -= anInt5375;
                vertexZ[i_344_] -= anInt5342;
                if (i_340_ != 0) {
                    int i_345_ = Class70.SIN[i_340_];
                    int i_346_ = Class70.COS[i_340_];
                    int i_347_ = ((vertexY[i_344_] * i_345_ + vertexX[i_344_] * i_346_ + 16383) >> 14);
                    vertexY[i_344_] = (vertexY[i_344_] * i_346_ - vertexX[i_344_] * i_345_ + 16383) >> 14;
                    vertexX[i_344_] = i_347_;
                }
                if (i_338_ != 0) {
                    int i_348_ = Class70.SIN[i_338_];
                    int i_349_ = Class70.COS[i_338_];
                    int i_350_ = ((vertexY[i_344_] * i_349_ - vertexZ[i_344_] * i_348_ + 16383) >> 14);
                    vertexZ[i_344_] = (vertexY[i_344_] * i_348_ + vertexZ[i_344_] * i_349_ + 16383) >> 14;
                    vertexY[i_344_] = i_350_;
                }
                if (i_339_ != 0) {
                    int i_351_ = Class70.SIN[i_339_];
                    int i_352_ = Class70.COS[i_339_];
                    int i_353_ = ((vertexZ[i_344_] * i_351_ + vertexX[i_344_] * i_352_ + 16383) >> 14);
                    vertexZ[i_344_] = (vertexZ[i_344_] * i_352_ - vertexX[i_344_] * i_351_ + 16383) >> 14;
                    vertexX[i_344_] = i_353_;
                }
                vertexX[i_344_] += anInt5338;
                vertexY[i_344_] += anInt5375;
                vertexZ[i_344_] += anInt5342;
            }
        } else if (i == 3) {
            for (int i_354_ = 0; i_354_ < vertexCount; i_354_++) {
                vertexX[i_354_] -= anInt5338;
                vertexY[i_354_] -= anInt5375;
                vertexZ[i_354_] -= anInt5342;
                vertexX[i_354_] = vertexX[i_354_] * i_338_ / 128;
                vertexY[i_354_] = vertexY[i_354_] * i_339_ / 128;
                vertexZ[i_354_] = vertexZ[i_354_] * i_340_ / 128;
                vertexX[i_354_] += anInt5338;
                vertexY[i_354_] += anInt5375;
                vertexZ[i_354_] += anInt5342;
            }
        } else if (i == 5) {
            for (int i_355_ = 0; i_355_ < faceCount; i_355_++) {
                int i_356_ = (faceAlphas[i_355_] & 0xff) + i_338_ * 8;
                if (i_356_ < 0) i_356_ = 0;
                else if (i_356_ > 255) i_356_ = 255;
                faceAlphas[i_355_] = (byte) i_356_;
            }
            if (billboardFaces != null) {
                for (int i_357_ = 0; i_357_ < billboardCount; i_357_++) {
                    JavaBillboardFace javaBillboardFace = billboardFaces[i_357_];
                    JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[i_357_];
                    javaBillboardAttributes.anInt4313 = (javaBillboardAttributes.anInt4313 & 0xffffff | 255 - (faceAlphas[javaBillboardFace.index] & 0xff) << 24);
                }
            }
        } else if (i == 7) {
            for (int i_358_ = 0; i_358_ < faceCount; i_358_++) {
                int i_359_ = faceColour[i_358_] & 0xffff;
                int i_360_ = i_359_ >> 10 & 0x3f;
                int i_361_ = i_359_ >> 7 & 0x7;
                int i_362_ = i_359_ & 0x7f;
                i_360_ = i_360_ + i_338_ & 0x3f;
                i_361_ += i_339_;
                if (i_361_ < 0) i_361_ = 0;
                else if (i_361_ > 7) i_361_ = 7;
                i_362_ += i_340_;
                if (i_362_ < 0) i_362_ = 0;
                else if (i_362_ > 127) i_362_ = 127;
                faceColour[i_358_] = (short) (i_360_ << 10 | i_361_ << 7 | i_362_);
            }
            aBoolean5380 = true;
            if (billboardFaces != null) {
                for (int i_363_ = 0; i_363_ < billboardCount; i_363_++) {
                    JavaBillboardFace javaBillboardFace = billboardFaces[i_363_];
                    JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[i_363_];
                    javaBillboardAttributes.anInt4313 = (javaBillboardAttributes.anInt4313 & ~0xffffff | (Class126.HSV_TO_RGB[SkyBoxSphereTypeList.method303((faceColour[(javaBillboardFace.index)]) & 0xffff, 30) & 0xffff]) & 0xffffff);
                }
            }
        } else if (i == 8) {
            for (int i_364_ = 0; i_364_ < billboardCount; i_364_++) {
                JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[i_364_];
                javaBillboardAttributes.anInt4316 += i_338_;
                javaBillboardAttributes.anInt4317 += i_339_;
            }
        } else if (i == 10) {
            for (int i_365_ = 0; i_365_ < billboardCount; i_365_++) {
                JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[i_365_];
                javaBillboardAttributes.anInt4314 = javaBillboardAttributes.anInt4314 * i_338_ >> 7;
                javaBillboardAttributes.anInt4311 = javaBillboardAttributes.anInt4311 * i_339_ >> 7;
            }
        } else if (i == 9) {
            for (int i_366_ = 0; i_366_ < billboardCount; i_366_++) {
                JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[i_366_];
                javaBillboardAttributes.anInt4308 = javaBillboardAttributes.anInt4308 + i_338_ & 0x3fff;
            }
        }
    }

    final int na() {
        if (!calculatedBounds) calculateBounds();
        return distance2D;
    }

    final r ba(r var_r) {
        return null;
    }

    final void p(int i, int i_367_, Ground var_ground, Ground var_ground_368_, int i_369_, int i_370_, int i_371_) {
        if (i == 3) {
            if ((functionMask & 0x7) != 7) throw new IllegalStateException();
        } else if ((functionMask & 0x2) != 2) throw new IllegalStateException();
        if (!calculatedBounds) calculateBounds();
        int i_372_ = i_369_ + minVertexX;
        int i_373_ = i_369_ + maxVertexX;
        int i_374_ = i_371_ + minVertexZ;
        int i_375_ = i_371_ + maxVertexZ;
        if (i == 4 || (i_372_ >= 0 && (i_373_ + var_ground.anInt4592 >> var_ground.anInt4588 < var_ground.anInt4587) && i_374_ >= 0 && (i_375_ + var_ground.anInt4592 >> var_ground.anInt4588 < var_ground.anInt4590))) {
            int[][] is = var_ground.tileHeights;
            int[][] is_376_ = null;
            if (var_ground_368_ != null) is_376_ = var_ground_368_.tileHeights;
            if (i == 4 || i == 5) {
                if (var_ground_368_ == null || (i_372_ < 0 || ((i_373_ + var_ground_368_.anInt4592 >> var_ground_368_.anInt4588) >= var_ground_368_.anInt4587) || i_374_ < 0 || ((i_375_ + var_ground_368_.anInt4592 >> var_ground_368_.anInt4588) >= var_ground_368_.anInt4590))) return;
            } else {
                i_372_ >>= var_ground.anInt4588;
                i_373_ = (i_373_ + (var_ground.anInt4592 - 1) >> var_ground.anInt4588);
                i_374_ >>= var_ground.anInt4588;
                i_375_ = (i_375_ + (var_ground.anInt4592 - 1) >> var_ground.anInt4588);
                if (is[i_372_][i_374_] == i_370_ && is[i_373_][i_374_] == i_370_ && is[i_372_][i_375_] == i_370_ && is[i_373_][i_375_] == i_370_) return;
            }
            synchronized (this) {
                if (i == 1) {
                    int i_377_ = var_ground.anInt4592 - 1;
                    for (int i_378_ = 0; i_378_ < maxVertex; i_378_++) {
                        int i_379_ = vertexX[i_378_] + i_369_;
                        int i_380_ = vertexZ[i_378_] + i_371_;
                        int i_381_ = i_379_ & i_377_;
                        int i_382_ = i_380_ & i_377_;
                        int i_383_ = i_379_ >> var_ground.anInt4588;
                        int i_384_ = i_380_ >> var_ground.anInt4588;
                        int i_385_ = ((is[i_383_][i_384_] * (var_ground.anInt4592 - i_381_) + is[i_383_ + 1][i_384_] * i_381_) >> var_ground.anInt4588);
                        int i_386_ = ((is[i_383_][i_384_ + 1] * (var_ground.anInt4592 - i_381_) + is[i_383_ + 1][i_384_ + 1] * i_381_) >> var_ground.anInt4588);
                        int i_387_ = (i_385_ * (var_ground.anInt4592 - i_382_) + i_386_ * i_382_ >> var_ground.anInt4588);
                        vertexY[i_378_] = vertexY[i_378_] + i_387_ - i_370_;
                    }
                    for (int i_388_ = maxVertex; i_388_ < vertexCount; i_388_++) {
                        int i_389_ = vertexX[i_388_] + i_369_;
                        int i_390_ = vertexZ[i_388_] + i_371_;
                        int i_391_ = i_389_ & i_377_;
                        int i_392_ = i_390_ & i_377_;
                        int i_393_ = i_389_ >> var_ground.anInt4588;
                        int i_394_ = i_390_ >> var_ground.anInt4588;
                        if (i_393_ >= 0 && i_393_ < is.length - 1 && i_394_ >= 0 && i_394_ < is[0].length - 1) {
                            int i_395_ = ((is[i_393_][i_394_] * (var_ground.anInt4592 - i_391_) + is[i_393_ + 1][i_394_] * i_391_) >> var_ground.anInt4588);
                            int i_396_ = (((is[i_393_][i_394_ + 1] * (var_ground.anInt4592 - i_391_)) + is[i_393_ + 1][i_394_ + 1] * i_391_) >> var_ground.anInt4588);
                            int i_397_ = (i_395_ * (var_ground.anInt4592 - i_392_) + i_396_ * i_392_ >> var_ground.anInt4588);
                            vertexY[i_388_] = vertexY[i_388_] + i_397_ - i_370_;
                        }
                    }
                } else if (i == 2) {
                    int i_398_ = var_ground.anInt4592 - 1;
                    for (int i_399_ = 0; i_399_ < maxVertex; i_399_++) {
                        int i_400_ = (vertexY[i_399_] << 16) / minVertexY;
                        if (i_400_ < i_367_) {
                            int i_401_ = vertexX[i_399_] + i_369_;
                            int i_402_ = vertexZ[i_399_] + i_371_;
                            int i_403_ = i_401_ & i_398_;
                            int i_404_ = i_402_ & i_398_;
                            int i_405_ = i_401_ >> var_ground.anInt4588;
                            int i_406_ = i_402_ >> var_ground.anInt4588;
                            int i_407_ = ((is[i_405_][i_406_] * (var_ground.anInt4592 - i_403_) + is[i_405_ + 1][i_406_] * i_403_) >> var_ground.anInt4588);
                            int i_408_ = (((is[i_405_][i_406_ + 1] * (var_ground.anInt4592 - i_403_)) + is[i_405_ + 1][i_406_ + 1] * i_403_) >> var_ground.anInt4588);
                            int i_409_ = (i_407_ * (var_ground.anInt4592 - i_404_) + i_408_ * i_404_ >> var_ground.anInt4588);
                            vertexY[i_399_] = vertexY[i_399_] + ((i_409_ - i_370_) * (i_367_ - i_400_) / i_367_);
                        } else vertexY[i_399_] = vertexY[i_399_];
                    }
                    for (int i_410_ = maxVertex; i_410_ < vertexCount; i_410_++) {
                        int i_411_ = (vertexY[i_410_] << 16) / minVertexY;
                        if (i_411_ < i_367_) {
                            int i_412_ = vertexX[i_410_] + i_369_;
                            int i_413_ = vertexZ[i_410_] + i_371_;
                            int i_414_ = i_412_ & i_398_;
                            int i_415_ = i_413_ & i_398_;
                            int i_416_ = i_412_ >> var_ground.anInt4588;
                            int i_417_ = i_413_ >> var_ground.anInt4588;
                            if (i_416_ >= 0 && i_416_ < var_ground.anInt4587 - 1 && i_417_ >= 0 && i_417_ < var_ground.anInt4590 - 1) {
                                int i_418_ = (((is[i_416_][i_417_] * (var_ground.anInt4592 - i_414_)) + is[i_416_ + 1][i_417_] * i_414_) >> var_ground.anInt4588);
                                int i_419_ = (((is[i_416_][i_417_ + 1] * (var_ground.anInt4592 - i_414_)) + is[i_416_ + 1][i_417_ + 1] * i_414_) >> var_ground.anInt4588);
                                int i_420_ = (i_418_ * (var_ground.anInt4592 - i_415_) + i_419_ * i_415_ >> var_ground.anInt4588);
                                vertexY[i_410_] = (vertexY[i_410_] + ((i_420_ - i_370_) * (i_367_ - i_411_) / i_367_));
                            }
                        } else vertexY[i_410_] = vertexY[i_410_];
                    }
                } else if (i == 3) {
                    int i_421_ = (i_367_ & 0xff) * 4;
                    int i_422_ = (i_367_ >> 8 & 0xff) * 4;
                    int i_423_ = (i_367_ >> 16 & 0xff) << 6;
                    int i_424_ = (i_367_ >> 24 & 0xff) << 6;
                    if (i_369_ - (i_421_ >> 1) < 0 || (i_369_ + (i_421_ >> 1) + var_ground.anInt4592 >= var_ground.anInt4587 << var_ground.anInt4588) || i_371_ - (i_422_ >> 1) < 0 || (i_371_ + (i_422_ >> 1) + var_ground.anInt4592 >= var_ground.anInt4590 << var_ground.anInt4588)) return;
                    this.method626(i_421_, 10947, i_424_, i_369_, i_422_, i_370_, i_423_, var_ground, i_371_);
                } else if (i == 4) {
                    int i_425_ = var_ground_368_.anInt4592 - 1;
                    int i_426_ = maxVertexY - minVertexY;
                    for (int i_427_ = 0; i_427_ < maxVertex; i_427_++) {
                        int i_428_ = vertexX[i_427_] + i_369_;
                        int i_429_ = vertexZ[i_427_] + i_371_;
                        int i_430_ = i_428_ & i_425_;
                        int i_431_ = i_429_ & i_425_;
                        int i_432_ = i_428_ >> var_ground_368_.anInt4588;
                        int i_433_ = i_429_ >> var_ground_368_.anInt4588;
                        int i_434_ = (((is_376_[i_432_][i_433_] * (var_ground_368_.anInt4592 - i_430_)) + is_376_[i_432_ + 1][i_433_] * i_430_) >> var_ground_368_.anInt4588);
                        int i_435_ = (((is_376_[i_432_][i_433_ + 1] * (var_ground_368_.anInt4592 - i_430_)) + is_376_[i_432_ + 1][i_433_ + 1] * i_430_) >> var_ground_368_.anInt4588);
                        int i_436_ = (i_434_ * (var_ground_368_.anInt4592 - i_431_) + i_435_ * i_431_ >> var_ground_368_.anInt4588);
                        vertexY[i_427_] = (vertexY[i_427_] + (i_436_ - i_370_) + i_426_);
                    }
                    for (int i_437_ = maxVertex; i_437_ < vertexCount; i_437_++) {
                        int i_438_ = vertexX[i_437_] + i_369_;
                        int i_439_ = vertexZ[i_437_] + i_371_;
                        int i_440_ = i_438_ & i_425_;
                        int i_441_ = i_439_ & i_425_;
                        int i_442_ = i_438_ >> var_ground_368_.anInt4588;
                        int i_443_ = i_439_ >> var_ground_368_.anInt4588;
                        if (i_442_ >= 0 && i_442_ < var_ground_368_.anInt4587 - 1 && i_443_ >= 0 && i_443_ < var_ground_368_.anInt4590 - 1) {
                            int i_444_ = (((is_376_[i_442_][i_443_] * (var_ground_368_.anInt4592 - i_440_)) + is_376_[i_442_ + 1][i_443_] * i_440_) >> var_ground_368_.anInt4588);
                            int i_445_ = (((is_376_[i_442_][i_443_ + 1] * (var_ground_368_.anInt4592 - i_440_)) + is_376_[i_442_ + 1][i_443_ + 1] * i_440_) >> var_ground_368_.anInt4588);
                            int i_446_ = (i_444_ * (var_ground_368_.anInt4592 - i_441_) + i_445_ * i_441_ >> var_ground_368_.anInt4588);
                            vertexY[i_437_] = (vertexY[i_437_] + (i_446_ - i_370_) + i_426_);
                        }
                    }
                } else if (i == 5) {
                    int i_447_ = var_ground_368_.anInt4592 - 1;
                    int i_448_ = maxVertexY - minVertexY;
                    for (int i_449_ = 0; i_449_ < maxVertex; i_449_++) {
                        int i_450_ = vertexX[i_449_] + i_369_;
                        int i_451_ = vertexZ[i_449_] + i_371_;
                        int i_452_ = i_450_ & i_447_;
                        int i_453_ = i_451_ & i_447_;
                        int i_454_ = i_450_ >> var_ground.anInt4588;
                        int i_455_ = i_451_ >> var_ground.anInt4588;
                        int i_456_ = ((is[i_454_][i_455_] * (var_ground.anInt4592 - i_452_) + is[i_454_ + 1][i_455_] * i_452_) >> var_ground.anInt4588);
                        int i_457_ = ((is[i_454_][i_455_ + 1] * (var_ground.anInt4592 - i_452_) + is[i_454_ + 1][i_455_ + 1] * i_452_) >> var_ground.anInt4588);
                        int i_458_ = (i_456_ * (var_ground.anInt4592 - i_453_) + i_457_ * i_453_ >> var_ground.anInt4588);
                        i_456_ = (((is_376_[i_454_][i_455_] * (var_ground_368_.anInt4592 - i_452_)) + is_376_[i_454_ + 1][i_455_] * i_452_) >> var_ground_368_.anInt4588);
                        i_457_ = (((is_376_[i_454_][i_455_ + 1] * (var_ground_368_.anInt4592 - i_452_)) + is_376_[i_454_ + 1][i_455_ + 1] * i_452_) >> var_ground_368_.anInt4588);
                        int i_459_ = (i_456_ * (var_ground_368_.anInt4592 - i_453_) + i_457_ * i_453_ >> var_ground_368_.anInt4588);
                        int i_460_ = i_458_ - i_459_ - i_367_;
                        vertexY[i_449_] = ((vertexY[i_449_] << 8) / i_448_ * i_460_ >> 8) - (i_370_ - i_458_);
                    }
                    for (int i_461_ = maxVertex; i_461_ < vertexCount; i_461_++) {
                        int i_462_ = vertexX[i_461_] + i_369_;
                        int i_463_ = vertexZ[i_461_] + i_371_;
                        int i_464_ = i_462_ & i_447_;
                        int i_465_ = i_463_ & i_447_;
                        int i_466_ = i_462_ >> var_ground.anInt4588;
                        int i_467_ = i_463_ >> var_ground.anInt4588;
                        if (i_466_ >= 0 && i_466_ < var_ground.anInt4587 - 1 && i_466_ < var_ground_368_.anInt4587 - 1 && i_467_ >= 0 && i_467_ < var_ground.anInt4590 - 1 && i_467_ < var_ground_368_.anInt4590 - 1) {
                            int i_468_ = ((is[i_466_][i_467_] * (var_ground.anInt4592 - i_464_) + is[i_466_ + 1][i_467_] * i_464_) >> var_ground.anInt4588);
                            int i_469_ = (((is[i_466_][i_467_ + 1] * (var_ground.anInt4592 - i_464_)) + is[i_466_ + 1][i_467_ + 1] * i_464_) >> var_ground.anInt4588);
                            int i_470_ = (i_468_ * (var_ground.anInt4592 - i_465_) + i_469_ * i_465_ >> var_ground.anInt4588);
                            i_468_ = (((is_376_[i_466_][i_467_] * (var_ground_368_.anInt4592 - i_464_)) + is_376_[i_466_ + 1][i_467_] * i_464_) >> var_ground_368_.anInt4588);
                            i_469_ = (((is_376_[i_466_][i_467_ + 1] * (var_ground_368_.anInt4592 - i_464_)) + is_376_[i_466_ + 1][i_467_ + 1] * i_464_) >> var_ground_368_.anInt4588);
                            int i_471_ = (i_468_ * (var_ground_368_.anInt4592 - i_465_) + i_469_ * i_465_ >> var_ground_368_.anInt4588);
                            int i_472_ = i_470_ - i_471_ - i_367_;
                            vertexY[i_461_] = (((vertexY[i_461_] << 8) / i_448_ * i_472_) >> 8) - (i_370_ - i_470_);
                        }
                    }
                }
                calculatedBounds = false;
            }
        }
    }

    final void C(int i) {
        if ((functionMask & 0x1000) != 4096) throw new IllegalStateException();
        anInt5344 = i;
        renderPoints = 0;
    }

    private final void method644() {
        synchronized (this) {
            for (int i = 0; i < vertexCount; i++) {
                int i_473_ = vertexX[i];
                vertexX[i] = vertexZ[i];
                vertexZ[i] = -i_473_;
            }
            method631();
        }
    }

    final int RA() {
        if (!calculatedBounds) calculateBounds();
        return maxVertexX;
    }

    final boolean method623(int i, int i_474_, Matrix matrix, boolean bool, int i_475_, int i_476_) {
        return method645(i, i_474_, matrix, bool, i_475_, i_476_);
    }

    final ModelParticleEffector[] method604() {
        return effectors;
    }

    final int WA() {
        return anInt5344;
    }

    final void s(int i) {
        if (toolkit.threadCount > 1) {
            synchronized (this) {
                if ((functionMask & 0x10000) == 65536 && (i & 0x10000) == 0) method634(true);
                functionMask = i;
            }
        } else {
            if ((functionMask & 0x10000) == 65536 && (i & 0x10000) == 0) method634(true);
            functionMask = i;
        }
    }

    final void method621() {
        if (toolkit.threadCount > 1) {
            synchronized (this) {
                this.aBoolean1124 = false;
                this.notifyAll();
            }
        }
    }

    final void method624(int i, int i_477_, int i_478_, int i_479_) {
        if ((functionMask & 0x80000) != 524288) throw new IllegalStateException("FMT");
        for (int i_480_ = 0; i_480_ < faceCount; i_480_++) {
            int i_481_ = faceColour[i_480_] & 0xffff;
            int i_482_ = i_481_ >> 10 & 0x3f;
            int i_483_ = i_481_ >> 7 & 0x7;
            int i_484_ = i_481_ & 0x7f;
            if (i != -1) i_482_ += (i - i_482_) * i_479_ >> 7;
            if (i_477_ != -1) i_483_ += (i_477_ - i_483_) * i_479_ >> 7;
            if (i_478_ != -1) i_484_ += (i_478_ - i_484_) * i_479_ >> 7;
            faceColour[i_480_] = (short) (i_482_ << 10 | i_483_ << 7 | i_484_);
        }
        if (billboardFaces != null) {
            for (int i_485_ = 0; i_485_ < billboardCount; i_485_++) {
                JavaBillboardFace javaBillboardFace = billboardFaces[i_485_];
                JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[i_485_];
                javaBillboardAttributes.anInt4313 = (javaBillboardAttributes.anInt4313 & ~0xffffff | (Class126.HSV_TO_RGB[SkyBoxSphereTypeList.method303(((faceColour[javaBillboardFace.index]) & 0xffff), 30)]) & 0xffffff);
            }
        }
        if (renderPoints == 2) renderPoints = 1;
    }

    final boolean method628(int i, int i_486_, Matrix matrix, boolean bool, int i_487_) {
        return method645(i, i_486_, matrix, bool, i_487_, -1);
    }

    final int ma() {
        if (!calculatedBounds) calculateBounds();
        return distance3D;
    }

    private final boolean method645(int mouseX, int mouseY, Matrix matrix, boolean useBoundingBox, int scale, int depth) {
        transform = (JavaMatrix) matrix;
        JavaMatrix camera = toolkit.camera;
        float translateX = (camera.tX + ((camera.cZ * transform.tX) + (camera.cY * transform.tZ) + (camera.aY * transform.tY)));
        float translateY = (camera.tZ + ((camera.cX * transform.tX) + (camera.bX * transform.tZ) + (camera.aX * transform.tY)));
        float translateZ = (camera.tY + ((camera.bZ * transform.tX) + (camera.aZ * transform.tZ) + (camera.bY * transform.tY)));
        float aX = ((camera.cZ * transform.cZ) + (camera.cY * transform.cX) + (camera.aY * transform.bZ));
        float aY = ((camera.cZ * transform.cY) + (camera.cY * transform.bX) + (camera.aY * transform.aZ));
        float aZ = ((camera.cZ * transform.aY) + (camera.cY * transform.aX) + (camera.aY * transform.bY));
        float bX = ((camera.cX * transform.cZ) + (camera.bX * transform.cX) + (camera.aX * transform.bZ));
        float bY = ((camera.cX * transform.cY) + (camera.bX * transform.bX) + (camera.aX * transform.aZ));
        float bZ = ((camera.cX * transform.aY) + (camera.bX * transform.aX) + (camera.aX * transform.bY));
        float cX = ((camera.bZ * transform.cZ) + (camera.aZ * transform.cX) + (camera.bY * transform.bZ));
        float cY = ((camera.bZ * transform.cY) + (camera.aZ * transform.bX) + (camera.bY * transform.aZ));
        float cZ = ((camera.bZ * transform.aY) + (camera.aZ * transform.aX) + (camera.bY * transform.bY));
        boolean intersects = false;
        int projCenterX = toolkit.projectionCenterX;
        int projCenterY = toolkit.projectionCenterY;
        int projScaleX = toolkit.projectionScaleX;
        int projScaleY = toolkit.projectionScaleY;
        int minX = 2147483647;
        int maxX = -2147483648;
        int minY = 2147483647;
        int maxY = -2147483648;
        method632(Thread.currentThread());
        if (!calculatedBounds) calculateBounds();
        int halfX = maxVertexX - minVertexX >> 1;
        int halfY = maxVertexY - minVertexY >> 1;
        int halfZ = maxVertexZ - minVertexZ >> 1;
        int centerX = minVertexX + halfX;
        int centerY = minVertexY + halfY;
        int centerZ = minVertexZ + halfZ;
        int scaledMinX = centerX - (halfX << scale);
        int scaledMinY = centerY - (halfY << scale);
        int scaledMinZ = centerZ - (halfZ << scale);
        int scaledMaxX = centerX + (halfX << scale);
        int scaledMaxY = centerY + (halfY << scale);
        int scaledMaxZ = centerZ + (halfZ << scale);
        tempX[0] = scaledMinX;
        tempY[0] = scaledMinY;
        tempZ[0] = scaledMinZ;
        tempX[1] = scaledMaxX;
        tempY[1] = scaledMinY;
        tempZ[1] = scaledMinZ;
        tempX[2] = scaledMinX;
        tempY[2] = scaledMaxY;
        tempZ[2] = scaledMinZ;
        tempX[3] = scaledMaxX;
        tempY[3] = scaledMaxY;
        tempZ[3] = scaledMinZ;
        tempX[4] = scaledMinX;
        tempY[4] = scaledMinY;
        tempZ[4] = scaledMaxZ;
        tempX[5] = scaledMaxX;
        tempY[5] = scaledMinY;
        tempZ[5] = scaledMaxZ;
        tempX[6] = scaledMinX;
        tempY[6] = scaledMaxY;
        tempZ[6] = scaledMaxZ;
        tempX[7] = scaledMaxX;
        tempY[7] = scaledMaxY;
        tempZ[7] = scaledMaxZ;
        for (int vertex = 0; vertex < 8; vertex++) {
            int x = tempX[vertex];
            int y = tempY[vertex];
            int z = tempZ[vertex];
            float vertexX = translateX + (aX * (float) x + aY * (float) y + aZ * (float) z);
            float vertexY = translateY + (bX * (float) x + bY * (float) y + bZ * (float) z);
            float vertexZ = translateZ + (cX * (float) x + cY * (float) y + cZ * (float) z);
            if (vertexZ >= (float) toolkit.zNear) {
                if (depth > 0) vertexZ = (float) depth;
                int actualX = projCenterX + (int) (vertexX * (float) projScaleX / vertexZ);
                int actualY = projCenterY + (int) (vertexY * (float) projScaleY / vertexZ);
                if (actualX < minX) minX = actualX;
                if (actualX > maxX) maxX = actualX;
                if (actualY < minY) minY = actualY;
                if (actualY > maxY) maxY = actualY;
                intersects = true;
            }
        }
        if (intersects && mouseX > minX && mouseX < maxX && mouseY > minY && mouseY < maxY) {
            if (useBoundingBox) return true;
            for (int vertex = 0; vertex < vertexCount; vertex++) {
                int x = vertexX[vertex];
                int y = vertexY[vertex];
                int z = vertexZ[vertex];
                float vertexX = translateX + (aX * (float) x + aY * (float) y + aZ * (float) z);
                float vertexY = translateY + (bX * (float) x + bY * (float) y + bZ * (float) z);
                float vertexZ = translateZ + (cX * (float) x + cY * (float) y + cZ * (float) z);
                if (vertexZ >= (float) toolkit.zNear) {
                    if (depth > 0) vertexZ = (float) depth;
                    renderVertexX[vertex] = projCenterX + (int) (vertexX * (float) projScaleX / vertexZ);
                    renderVertexY[vertex] = projCenterY + (int) (vertexY * (float) projScaleY / vertexZ);
                } else renderVertexX[vertex] = -999999;
            }
            for (int face = 0; face < faceCount; face++) {
                if (renderVertexX[faceIndexX[face]] != -999999 && renderVertexX[faceIndexY[face]] != -999999 && renderVertexX[faceIndexZ[face]] != -999999 && method630(mouseX, mouseY, renderVertexY[faceIndexX[face]], renderVertexY[faceIndexY[face]], renderVertexY[faceIndexZ[face]], renderVertexX[faceIndexX[face]], renderVertexX[faceIndexY[face]], renderVertexX[faceIndexZ[face]]))
                    return true;
            }
        }
        return false;
    }

    // method646
    private final void renderFaceClipping(int face) {
        int i = 0;
        int zNear = toolkit.zNear;
        short x = faceIndexX[face];
        short y = faceIndexY[face];
        short z = faceIndexZ[face];
        int zA = cameraZ[x];
        int zB = cameraZ[y];
        int zC = cameraZ[z];
        if (faceAlphas == null) aRasterizer_5383.alpha = 0;
        else aRasterizer_5383.alpha = faceAlphas[face] & 0xff;
        if (zA >= zNear) {
            clippedX[i] = renderVertexX[x];
            clippedY[i] = renderVertexY[x];
            clippedZ[i] = renderVertexZ[x];
            clippedColour[i++] = shadeFacesX[face] & 0xffff;
        } else {
            int camX = cameraX[x];
            int camY = cameraY[x];
            int colour = shadeFacesX[face] & 0xffff;
            if (zC >= zNear) {
                int t = (zNear - zA) * (65536 / (zC - zA));
                clippedX[i] = (aJavaThreadResource_5367.minX + ((camX + ((cameraX[z] - camX) * t >> 16)) * toolkit.projectionScaleX / zNear));
                clippedY[i] = (aJavaThreadResource_5367.minY + ((camY + ((cameraY[z] - camY) * t >> 16)) * toolkit.projectionScaleY / zNear));
                clippedZ[i] = zNear;
                clippedColour[i++] = (colour + (((shadeFacesZ[face] & 0xffff) - colour) * t >> 16));
            }
            if (zB >= zNear) {
                int t = (zNear - zA) * (65536 / (zB - zA));
                clippedX[i] = (aJavaThreadResource_5367.minX + ((camX + ((cameraX[y] - camX) * t >> 16)) * toolkit.projectionScaleX / zNear));
                clippedY[i] = (aJavaThreadResource_5367.minY + ((camY + ((cameraY[y] - camY) * t >> 16)) * toolkit.projectionScaleY / zNear));
                clippedZ[i] = zNear;
                clippedColour[i++] = (colour + (((shadeFacesY[face] & 0xffff) - colour) * t >> 16));
            }
        }
        if (zB >= zNear) {
            clippedX[i] = renderVertexX[y];
            clippedY[i] = renderVertexY[y];
            clippedZ[i] = renderVertexZ[y];
            clippedColour[i++] = shadeFacesY[face] & 0xffff;
        } else {
            int camX = cameraX[y];
            int camY = cameraY[y];
            int colour = shadeFacesY[face] & 0xffff;
            if (zA >= zNear) {
                int t = (zNear - zB) * (65536 / (zA - zB));
                clippedX[i] = (aJavaThreadResource_5367.minX + ((camX + ((cameraX[x] - camX) * t >> 16)) * toolkit.projectionScaleX / zNear));
                clippedY[i] = (aJavaThreadResource_5367.minY + ((camY + ((cameraY[x] - camY) * t >> 16)) * toolkit.projectionScaleY / zNear));
                clippedZ[i] = zNear;
                clippedColour[i++] = (colour + (((shadeFacesX[face] & 0xffff) - colour) * t >> 16));
            }
            if (zC >= zNear) {
                int t = (zNear - zB) * (65536 / (zC - zB));
                clippedX[i] = (aJavaThreadResource_5367.minX + ((camX + ((cameraX[z] - camX) * t >> 16)) * toolkit.projectionScaleX / zNear));
                clippedY[i] = (aJavaThreadResource_5367.minY + ((camY + ((cameraY[z] - camY) * t >> 16)) * toolkit.projectionScaleY / zNear));
                clippedZ[i] = zNear;
                clippedColour[i++] = (colour + (((shadeFacesZ[face] & 0xffff) - colour) * t >> 16));
            }
        }
        if (zC >= zNear) {
            clippedX[i] = renderVertexX[z];
            clippedY[i] = renderVertexY[z];
            clippedZ[i] = renderVertexZ[z];
            clippedColour[i++] = shadeFacesZ[face] & 0xffff;
        } else {
            int camX = cameraX[z];
            int camY = cameraY[z];
            int colour = shadeFacesZ[face] & 0xffff;
            if (zB >= zNear) {
                int t = (zNear - zC) * (65536 / (zB - zC));
                clippedX[i] = (aJavaThreadResource_5367.minX + ((camX + ((cameraX[y] - camX) * t >> 16)) * toolkit.projectionScaleX / zNear));
                clippedY[i] = (aJavaThreadResource_5367.minY + ((camY + ((cameraY[y] - camY) * t >> 16)) * toolkit.projectionScaleY / zNear));
                clippedZ[i] = zNear;
                clippedColour[i++] = (colour + (((shadeFacesY[face] & 0xffff) - colour) * t >> 16));
            }
            if (zA >= zNear) {
                int t = (zNear - zC) * (65536 / (zA - zC));
                clippedX[i] = (aJavaThreadResource_5367.minX + ((camX + ((cameraX[x] - camX) * t >> 16)) * toolkit.projectionScaleX / zNear));
                clippedY[i] = (aJavaThreadResource_5367.minY + ((camY + ((cameraY[x] - camY) * t >> 16)) * toolkit.projectionScaleY / zNear));
                clippedZ[i] = zNear;
                clippedColour[i++] = (colour + (((shadeFacesX[face] & 0xffff) - colour) * t >> 16));
            }
        }
        int xA = clippedX[0];
        int xB = clippedX[1];
        int xC = clippedX[2];
        int yA = clippedY[0];
        int yB = clippedY[1];
        int yC = clippedY[2];
        zA = clippedZ[0];
        zB = clippedZ[1];
        zC = clippedZ[2];
        aRasterizer_5383.restrictEdges = false;
        if (i == 3) {
            if (xA < 0 || xB < 0 || xC < 0 || xA > aJavaThreadResource_5367.width || xB > aJavaThreadResource_5367.width || xC > aJavaThreadResource_5367.width) aRasterizer_5383.restrictEdges = true;
            if (faceTextures == null || faceTextures[face] == -1) {
                if (shadeFacesZ[face] == -1) aRasterizer_5383.drawColouredTriangle((float) yA, (float) yB, (float) yC, (float) xA, (float) xB, (float) xC, (float) zA, (float) zB, (float) zC, (Class126.HSV_TO_RGB[shadeFacesX[face] & 0xffff]));
                else aRasterizer_5383.drawGouraudTriangle((float) yA, (float) yB, (float) yC, (float) xA, (float) xB, (float) xC, (float) zA, (float) zB, (float) zC, (float) clippedColour[0], (float) clippedColour[1], (float) clippedColour[2]);
            } else {
                int alpha = -16777216;
                if (faceAlphas != null) alpha = 255 - (faceAlphas[face] & 0xff) << 24;
                int colour = alpha | shadeFacesX[face] & 0xffffff;
                if (shadeFacesZ[face] == -1)
                    aRasterizer_5383.drawTexturedTriangle((float) yA, (float) yB, (float) yC, (float) xA, (float) xB, (float) xC, (float) zA, (float) zB, (float) zC, texCoordU[face][0], texCoordU[face][1], texCoordU[face][2], texCoordV[face][0], texCoordV[face][1], texCoordV[face][2], colour, colour, colour, (aJavaThreadResource_5367.anInt2192), 0, 0, 0, faceTextures[face]);
                else
                    aRasterizer_5383.drawTexturedTriangle((float) yA, (float) yB, (float) yC, (float) xA, (float) xB, (float) xC, (float) zA, (float) zB, (float) zC, texCoordU[face][0], texCoordU[face][1], texCoordU[face][2], texCoordV[face][0], texCoordV[face][1], texCoordV[face][2], colour, colour, colour, (aJavaThreadResource_5367.anInt2192), 0, 0, 0, faceTextures[face]);
            }
        }
        if (i == 4) {
            if (xA < 0 || xB < 0 || xC < 0 || xA > aJavaThreadResource_5367.width || xB > aJavaThreadResource_5367.width || xC > aJavaThreadResource_5367.width || clippedX[3] < 0 || clippedX[3] > aJavaThreadResource_5367.width) aRasterizer_5383.restrictEdges = true;
            if (faceTextures == null || faceTextures[face] == -1) {
                if (shadeFacesZ[face] == -1) {
                    int colour = Class126.HSV_TO_RGB[shadeFacesX[face] & 0xffff];
                    aRasterizer_5383.drawColouredTriangle((float) yA, (float) yB, (float) yC, (float) xA, (float) xB, (float) xC, (float) zA, (float) zB, (float) zC, colour);
                    aRasterizer_5383.drawColouredTriangle((float) yA, (float) yC, (float) clippedY[3], (float) xA, (float) xC, (float) clippedX[3], (float) zA, (float) zB, (float) clippedZ[3], colour);
                } else {
                    aRasterizer_5383.drawGouraudTriangle((float) yA, (float) yB, (float) yC, (float) xA, (float) xB, (float) xC, (float) zA, (float) zB, (float) zC, (float) clippedColour[0], (float) clippedColour[1], (float) clippedColour[2]);
                    aRasterizer_5383.drawGouraudTriangle((float) yA, (float) yC, (float) clippedY[3], (float) xA, (float) xC, (float) clippedX[3], (float) zA, (float) zB, (float) clippedZ[3], (float) clippedColour[0], (float) clippedColour[2], (float) clippedColour[3]);
                }
            } else {
                int alpha = -16777216;
                if (faceAlphas != null) alpha = 255 - (faceAlphas[face] & 0xff) << 24;
                int colour = alpha | shadeFacesX[face] & 0xffffff;
                if (shadeFacesZ[face] == -1) {
                    aRasterizer_5383.drawTexturedTriangle((float) yA, (float) yB, (float) yC, (float) xA, (float) xB, (float) xC, (float) zA, (float) zB, (float) zC, texCoordU[face][0], texCoordU[face][1], texCoordU[face][2], texCoordV[face][0], texCoordV[face][1], texCoordV[face][2], colour, colour, colour, (aJavaThreadResource_5367.anInt2192), 0, 0, 0, faceTextures[face]);
                    aRasterizer_5383.drawTexturedTriangle((float) yA, (float) yC, (float) clippedY[3], (float) xA, (float) xC, (float) clippedX[3], (float) zA, (float) zC, (float) clippedZ[3], texCoordU[face][0], texCoordU[face][1], texCoordU[face][2], texCoordV[face][0], texCoordV[face][1], texCoordV[face][2], colour, colour, colour, (aJavaThreadResource_5367.anInt2192), 0, 0, 0, faceTextures[face]);
                } else {
                    aRasterizer_5383.drawTexturedTriangle((float) yA, (float) yB, (float) yC, (float) xA, (float) xB, (float) xC, (float) zA, (float) zB, (float) zC, texCoordU[face][0], texCoordU[face][1], texCoordU[face][2], texCoordV[face][0], texCoordV[face][1], texCoordV[face][2], colour, colour, colour, (aJavaThreadResource_5367.anInt2192), 0, 0, 0, faceTextures[face]);
                    aRasterizer_5383.drawTexturedTriangle((float) yA, (float) yC, (float) clippedY[3], (float) xA, (float) xC, (float) clippedX[3], (float) zA, (float) zC, (float) clippedZ[3], texCoordU[face][0], texCoordU[face][1], texCoordU[face][2], texCoordV[face][0], texCoordV[face][1], texCoordV[face][2], colour, colour, colour, (aJavaThreadResource_5367.anInt2192), 0, 0, 0, faceTextures[face]);
                }
            }
        }
    }

    private final void method647() {
        if (renderPoints == 0) method634(false);
        else if (toolkit.threadCount > 1) {
            synchronized (this) {
                method640();
            }
        } else method640();
    }

    private final void method648(Thread thread) {
        JavaThreadResource javaThreadResource = toolkit.method3724(thread);
        if (javaThreadResource != aJavaThreadResource_5336) {
            aJavaThreadResource_5336 = javaThreadResource;
            aJavaModel_5378 = aJavaThreadResource_5336.aJavaModel_2243;
            aJavaModel_5339 = aJavaThreadResource_5336.aJavaModel_2224;
            aJavaModel_5396 = aJavaThreadResource_5336.aJavaModel_2219;
            aJavaModel_5347 = aJavaThreadResource_5336.aJavaModel_2239;
            aJavaModel_5390 = aJavaThreadResource_5336.aJavaModel_2233;
            aJavaModel_5374 = aJavaThreadResource_5336.aJavaModel_2231;
            aJavaModel_5328 = aJavaThreadResource_5336.aJavaModel_2223;
            aJavaModel_5376 = aJavaThreadResource_5336.aJavaModel_2227;
            aJavaModel_5397 = aJavaThreadResource_5336.aJavaModel_2246;
            aJavaModel_5319 = aJavaThreadResource_5336.aJavaModel_2225;
        }
    }

    final void LA(int i) {
        if ((functionMask & 0x2000) != 8192) throw new IllegalStateException();
        anInt5349 = i;
        renderPoints = 0;
    }

    final void VA(int i) {
        if ((functionMask & 0x3) != 3) throw new IllegalStateException();
        int i_574_ = Class70.SIN[i];
        int i_575_ = Class70.COS[i];
        synchronized (this) {
            for (int i_576_ = 0; i_576_ < vertexCount; i_576_++) {
                int i_577_ = ((vertexY[i_576_] * i_574_ + vertexX[i_576_] * i_575_) >> 14);
                vertexY[i_576_] = (vertexY[i_576_] * i_575_ - vertexX[i_576_] * i_574_) >> 14;
                vertexX[i_576_] = i_577_;
            }
            method631();
        }
    }

    final void a(int i) {
        if ((functionMask & 0x5) != 5) throw new IllegalStateException();
        if (i == 4096) method644();
        else if (i == 8192) method651();
        else if (i == 12288) method639();
        else {
            int i_578_ = Class70.SIN[i];
            int i_579_ = Class70.COS[i];
            synchronized (this) {
                for (int i_580_ = 0; i_580_ < vertexCount; i_580_++) {
                    int i_581_ = ((vertexZ[i_580_] * i_578_ + vertexX[i_580_] * i_579_) >> 14);
                    vertexZ[i_580_] = (vertexZ[i_580_] * i_579_ - vertexX[i_580_] * i_578_) >> 14;
                    vertexX[i_580_] = i_581_;
                }
                method631();
            }
        }
    }

    final void aa(short i, short i_582_) {
        if (faceTextures != null) {
            if (!movingTextures && i_582_ >= 0) {
                TextureMetrics textureMetrics = toolkit.aD4579.getMetrics(i_582_ & 0xffff, -6662);
                if (textureMetrics.speedU != 0 || textureMetrics.speedV != 0) movingTextures = true;
            }
            for (int i_583_ = 0; i_583_ < faceCount; i_583_++) {
                if (faceTextures[i_583_] == i) faceTextures[i_583_] = i_582_;
            }
        }
    }

    final void method613(Model model, int i, int i_584_, int i_585_, boolean bool) {
        JavaModel javaModel_586_ = (JavaModel) model;
        if ((functionMask & 0x10000) != 65536) throw new IllegalStateException("");
        if ((javaModel_586_.functionMask & 0x10000) != 65536) throw new IllegalStateException("");
        method632(Thread.currentThread());
        calculateBounds();
        method636();
        javaModel_586_.calculateBounds();
        javaModel_586_.method636();
        anInt5341++;
        int i_587_ = 0;
        int[] is = javaModel_586_.vertexX;
        int i_588_ = javaModel_586_.maxVertex;
        for (int i_589_ = 0; i_589_ < maxVertex; i_589_++) {
            VertexNormal vertexNormal = normals[i_589_];
            if (vertexNormal.faceCount != 0) {
                int i_590_ = vertexY[i_589_] - i_584_;
                if (i_590_ >= javaModel_586_.minVertexY && i_590_ <= javaModel_586_.maxVertexY) {
                    int i_591_ = vertexX[i_589_] - i;
                    if (i_591_ >= javaModel_586_.minVertexX && i_591_ <= javaModel_586_.maxVertexX) {
                        int i_592_ = vertexZ[i_589_] - i_585_;
                        if (i_592_ >= javaModel_586_.minVertexZ && i_592_ <= javaModel_586_.maxVertexZ) {
                            for (int i_593_ = 0; i_593_ < i_588_; i_593_++) {
                                VertexNormal vertexNormal_594_ = (javaModel_586_.normals[i_593_]);
                                if (i_591_ == is[i_593_] && i_592_ == (javaModel_586_.vertexZ[i_593_]) && i_590_ == (javaModel_586_.vertexY[i_593_]) && (vertexNormal_594_.faceCount != 0)) {
                                    if (aVertexNormalArray5313 == null) aVertexNormalArray5313 = new VertexNormal[maxVertex];
                                    if (javaModel_586_.aVertexNormalArray5313 == null) javaModel_586_.aVertexNormalArray5313 = new VertexNormal[i_588_];
                                    VertexNormal vertexNormal_595_ = aVertexNormalArray5313[i_589_];
                                    if (vertexNormal_595_ == null) vertexNormal_595_ = aVertexNormalArray5313[i_589_] = new VertexNormal(vertexNormal);
                                    VertexNormal vertexNormal_596_ = (javaModel_586_.aVertexNormalArray5313[i_593_]);
                                    if (vertexNormal_596_ == null) vertexNormal_596_ = javaModel_586_.aVertexNormalArray5313[i_593_] = new VertexNormal(vertexNormal_594_);
                                    vertexNormal_595_.x += (vertexNormal_594_.x);
                                    vertexNormal_595_.y += (vertexNormal_594_.y);
                                    vertexNormal_595_.z += (vertexNormal_594_.z);
                                    vertexNormal_595_.faceCount += (vertexNormal_594_.faceCount);
                                    vertexNormal_596_.x += vertexNormal.x;
                                    vertexNormal_596_.y += vertexNormal.y;
                                    vertexNormal_596_.z += vertexNormal.z;
                                    vertexNormal_596_.faceCount += vertexNormal.faceCount;
                                    i_587_++;
                                    anIntArray5326[i_589_] = anInt5341;
                                    anIntArray5318[i_593_] = anInt5341;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (i_587_ >= 3 && bool) {
            for (int i_597_ = 0; i_597_ < faceCount; i_597_++) {
                if (anIntArray5326[faceIndexX[i_597_]] == anInt5341 && anIntArray5326[faceIndexY[i_597_]] == anInt5341 && anIntArray5326[faceIndexZ[i_597_]] == anInt5341) {
                    if (shadingType == null) shadingType = new byte[faceCount];
                    shadingType[i_597_] = (byte) 2;
                }
            }
            for (int i_598_ = 0; i_598_ < javaModel_586_.faceCount; i_598_++) {
                if ((anIntArray5318[javaModel_586_.faceIndexX[i_598_]] == anInt5341) && anIntArray5318[(javaModel_586_.faceIndexY[i_598_])] == anInt5341 && anIntArray5318[(javaModel_586_.faceIndexZ[i_598_])] == anInt5341) {
                    if (javaModel_586_.shadingType == null) javaModel_586_.shadingType = new byte[javaModel_586_.faceCount];
                    javaModel_586_.shadingType[i_598_] = (byte) 2;
                }
            }
        }
    }

    private final void method649() {
        normals = new VertexNormal[maxVertex];
        for (int i = 0; i < maxVertex; i++)
            normals[i] = new VertexNormal();
        for (int i = 0; i < faceCount; i++) {
            short faceX = faceIndexX[i];
            short faceY = faceIndexY[i];
            short faceZ = faceIndexZ[i];
            int i_602_ = vertexX[faceY] - vertexX[faceX];
            int i_603_ = vertexY[faceY] - vertexY[faceX];
            int i_604_ = vertexZ[faceY] - vertexZ[faceX];
            int i_605_ = vertexX[faceZ] - vertexX[faceX];
            int i_606_ = vertexY[faceZ] - vertexY[faceX];
            int i_607_ = vertexZ[faceZ] - vertexZ[faceX];
            int dx = i_603_ * i_607_ - i_606_ * i_604_;
            int dy = i_604_ * i_605_ - i_607_ * i_602_;
            int dz;
            for (dz = i_602_ * i_606_ - i_605_ * i_603_; (dx > 8192 || dy > 8192 || dz > 8192 || dx < -8192 || dy < -8192 || dz < -8192); dz >>= 1) {
                dx >>= 1;
                dy >>= 1;
            }
            int deltaLength = (int) Math.sqrt(dx * dx + dy * dy + dz * dz);
            if (deltaLength <= 0) deltaLength = 1;
            dx = dx * 256 / deltaLength;
            dy = dy * 256 / deltaLength;
            dz = dz * 256 / deltaLength;
            byte type;
            if (shadingType == null) type = (byte) 0;
            else type = shadingType[i];
            if (type == 0) {
                VertexNormal vertexNormal = normals[faceX];
                vertexNormal.x += dx;
                vertexNormal.y += dy;
                vertexNormal.z += dz;
                vertexNormal.faceCount++;
                vertexNormal = normals[faceY];
                vertexNormal.x += dx;
                vertexNormal.y += dy;
                vertexNormal.z += dz;
                vertexNormal.faceCount++;
                vertexNormal = normals[faceZ];
                vertexNormal.x += dx;
                vertexNormal.y += dy;
                vertexNormal.z += dz;
                vertexNormal.faceCount++;
            } else if (type == 1) {
                if (aClass41Array5385 == null) aClass41Array5385 = new Class41[faceCount];
                Class41 class41 = aClass41Array5385[i] = new Class41();
                class41.x = dx;
                class41.y = dy;
                class41.z = dz;
            }
        }
    }

    final void H(int i, int i_613_, int i_614_) {
        if (i != 0 && (functionMask & 0x1) != 1) throw new IllegalStateException();
        if (i_613_ != 0 && (functionMask & 0x2) != 2) throw new IllegalStateException();
        if (i_614_ != 0 && (functionMask & 0x4) != 4) throw new IllegalStateException();
        synchronized (this) {
            for (int i_615_ = 0; i_615_ < vertexCount; i_615_++) {
                vertexX[i_615_] += i;
                vertexY[i_615_] += i_613_;
                vertexZ[i_615_] += i_614_;
            }
        }
    }

    final void v() {
        if ((functionMask & 0x10) != 16) throw new IllegalStateException();
        synchronized (this) {
            for (int i = 0; i < vertexCount; i++)
                vertexZ[i] = -vertexZ[i];
            if (normals != null) {
                for (int i = 0; i < maxVertex; i++) {
                    if (normals[i] != null) normals[i].z = -normals[i].z;
                }
            }
            if (aVertexNormalArray5313 != null) {
                for (int i = 0; i < maxVertex; i++) {
                    if (aVertexNormalArray5313[i] != null) aVertexNormalArray5313[i].z = -aVertexNormalArray5313[i].z;
                }
            }
            if (aClass41Array5385 != null) {
                for (int i = 0; i < faceCount; i++) {
                    if (aClass41Array5385[i] != null) aClass41Array5385[i].z = -aClass41Array5385[i].z;
                }
            }
            short[] is = faceIndexX;
            faceIndexX = faceIndexZ;
            faceIndexZ = is;
            if (texCoordU != null) {
                for (int i = 0; i < faceCount; i++) {
                    if (texCoordU[i] != null) {
                        float f = texCoordU[i][0];
                        texCoordU[i][0] = texCoordU[i][2];
                        texCoordU[i][2] = f;
                    }
                    if (texCoordV[i] != null) {
                        float f = texCoordV[i][0];
                        texCoordV[i][0] = texCoordV[i][2];
                        texCoordV[i][2] = f;
                    }
                }
            }
            calculatedBounds = false;
            renderPoints = 0;
        }
    }

    private final void method650(boolean clippedVertices, boolean billboards, int nearDepth, int length) {
        if (billboardFaces != null) {
            for (int i = 0; i < billboardCount; i++) {
                JavaBillboardFace billboard = billboardFaces[i];
                billboardIndices[billboard.index] = i;
            }
        }
        if (transparent || billboardFaces != null) {
            if ((functionMask & 0x100) == 0 && faceIndices != null) {
                for (int i = 0; i < faceCount; i++) {
                    short face = faceIndices[i];
                    method643(face, clippedVertices, billboards);
                }
            } else {
                for (int i = 0; i < faceCount; i++) {
                    if (!noAlpha(i) && !noBillboard(i)) method643(i, clippedVertices, billboards);
                }
                if (facePriority == null) {
                    for (int i = 0; i < faceCount; i++) {
                        if (noAlpha(i) || noBillboard(i)) method643(i, clippedVertices, billboards);
                    }
                } else {
                    for (int i = 0; i < 12; i++) {
                        for (int j = 0; j < faceCount; j++) {
                            if (facePriority[j] == i && (noAlpha(j) || noBillboard(j))) method643(j, clippedVertices, billboards);
                        }
                    }
                }
            }
        } else {
            for (int i_625_ = 0; i_625_ < faceCount; i_625_++)
                method643(i_625_, clippedVertices, billboards);
        }
    }

    private final void method651() {
        synchronized (this) {
            for (int i = 0; i < vertexCount; i++) {
                vertexX[i] = -vertexX[i];
                vertexZ[i] = -vertexZ[i];
            }
            method631();
        }
    }

    final void ia(short i, short i_626_) {
        for (int i_627_ = 0; i_627_ < faceCount; i_627_++) {
            if (faceColour[i_627_] == i) faceColour[i_627_] = i_626_;
        }
        if (billboardFaces != null) {
            for (int i_628_ = 0; i_628_ < billboardCount; i_628_++) {
                JavaBillboardFace javaBillboardFace = billboardFaces[i_628_];
                JavaBillboardAttributes javaBillboardAttributes = billboardAttributes[i_628_];
                javaBillboardAttributes.anInt4313 = (javaBillboardAttributes.anInt4313 & ~0xffffff | (Class126.HSV_TO_RGB[SkyBoxSphereTypeList.method303((faceColour[javaBillboardFace.index]), 30) & 0xffff]) & 0xffffff);
            }
        }
        if (renderPoints == 2) renderPoints = 1;
    }

    private final void method652() {
        synchronized (this) {
            for (int i = 0; i < maxVertex; i++) {
                vertexX[i] = -vertexX[i];
                vertexZ[i] = -vertexZ[i];
                if (normals[i] != null) {
                    normals[i].x = -normals[i].x;
                    normals[i].z = -normals[i].z;
                }
            }
            if (aClass41Array5385 != null) {
                for (int i = 0; i < faceCount; i++) {
                    if (aClass41Array5385[i] != null) {
                        aClass41Array5385[i].x = -aClass41Array5385[i].x;
                        aClass41Array5385[i].z = -aClass41Array5385[i].z;
                    }
                }
            }
            for (int i = maxVertex; i < vertexCount; i++) {
                vertexX[i] = -vertexX[i];
                vertexZ[i] = -vertexZ[i];
            }
            renderPoints = 0;
            calculatedBounds = false;
        }
    }

    private final void method653() {
        synchronized (this) {
            for (int i = 0; i < maxVertex; i++) {
                int i_629_ = vertexX[i];
                vertexX[i] = vertexZ[i];
                vertexZ[i] = -i_629_;
                if (normals[i] != null) {
                    i_629_ = normals[i].x;
                    normals[i].x = normals[i].z;
                    normals[i].z = -i_629_;
                }
            }
            if (aClass41Array5385 != null) {
                for (int i = 0; i < faceCount; i++) {
                    if (aClass41Array5385[i] != null) {
                        int i_630_ = aClass41Array5385[i].x;
                        aClass41Array5385[i].x = aClass41Array5385[i].z;
                        aClass41Array5385[i].z = -i_630_;
                    }
                }
            }
            for (int i = maxVertex; i < vertexCount; i++) {
                int i_631_ = vertexX[i];
                vertexX[i] = vertexZ[i];
                vertexZ[i] = -i_631_;
            }
            renderPoints = 0;
            calculatedBounds = false;
        }
    }

    // method654
    private final void renderModel(Matrix matrix, LabelBounds label, int fixedDepth, int flag) {
        if (maxVertex < 1) {
            return;
        }
        transform = (JavaMatrix) matrix;
        JavaMatrix javaMatrix = toolkit.camera;
        if (!calculatedBounds) calculateBounds();
        boolean translateOnly = transform.cZ == 16384.0F && transform.cY == 0.0F && transform.aY == 0.0F && transform.cX == 0.0F && transform.bX == 16384.0F && transform.aX == 0.0F && transform.bZ == 0.0F && transform.aZ == 0.0F && (transform.bY == 16384.0F);
        float tY = (javaMatrix.tY + (javaMatrix.bZ * transform.tX) + (javaMatrix.aZ * transform.tZ) + (javaMatrix.bY * transform.tY));
        float bY = (translateOnly ? javaMatrix.aZ : ((javaMatrix.bZ * transform.cY) + (javaMatrix.aZ * transform.bX) + (javaMatrix.bY * transform.aZ)));
        int minDepth = (int) (tY + (float) minVertexY * bY);
        int maxDepth = (int) (tY + (float) maxVertexY * bY);
        int nearDepth;
        int farDepth;
        if (minDepth > maxDepth) {
            nearDepth = maxDepth - distance2D;
            farDepth = minDepth + distance2D;
        } else {
            nearDepth = minDepth - distance2D;
            farDepth = maxDepth + distance2D;
        }
        if (nearDepth >= toolkit.zFar || farDepth <= toolkit.zNear) {
            return;
        }
        float f_638_ = (javaMatrix.tX + (javaMatrix.cZ * transform.tX) + (javaMatrix.cY * transform.tZ) + (javaMatrix.aY * transform.tY));
        float f_639_ = (translateOnly ? javaMatrix.cY : ((javaMatrix.cZ * transform.cY) + (javaMatrix.cY * (transform.bX)) + (javaMatrix.aY * (transform.aZ))));
        int minScreenX = (int) (f_638_ + (float) minVertexY * f_639_);
        int maxScreenX = (int) (f_638_ + (float) maxVertexY * f_639_);
        int projMinX;
        int projMaxX;
        if (minScreenX > maxScreenX) {
            projMinX = ((maxScreenX - distance2D) * toolkit.projectionScaleX);
            projMaxX = ((minScreenX + distance2D) * toolkit.projectionScaleX);
        } else {
            projMinX = ((minScreenX - distance2D) * toolkit.projectionScaleX);
            projMaxX = ((maxScreenX + distance2D) * toolkit.projectionScaleX);
        }
        if (fixedDepth == -1) {
            if (projMinX / farDepth >= toolkit.viewX2 || (projMaxX / farDepth <= toolkit.viewX1)) return;
        } else if (projMinX / fixedDepth >= toolkit.viewX2 || (projMaxX / fixedDepth <= toolkit.viewX1)) return;
        float f_644_ = (javaMatrix.tZ + (javaMatrix.cX * transform.tX) + (javaMatrix.bX * transform.tZ) + (javaMatrix.aX * transform.tY));
        float f_645_ = (translateOnly ? javaMatrix.bX : ((javaMatrix.cX * transform.cY) + (javaMatrix.bX * (transform.bX)) + (javaMatrix.aX * (transform.aZ))));
        int minScreenY = (int) (f_644_ + (float) minVertexY * f_645_);
        int maxScreenY = (int) (f_644_ + (float) maxVertexY * f_645_);
        int projMinY;
        int projMaxY;
        if (minScreenY > maxScreenY) {
            projMinY = ((maxScreenY - distance2D) * toolkit.projectionScaleY);
            projMaxY = ((minScreenY + distance2D) * toolkit.projectionScaleY);
        } else {
            projMinY = ((minScreenY - distance2D) * toolkit.projectionScaleY);
            projMaxY = ((maxScreenY + distance2D) * toolkit.projectionScaleY);
        }
        if (fixedDepth == -1) {
            if (projMinY / farDepth >= toolkit.viewY2 || (projMaxY / farDepth <= toolkit.viewY1)) return;
        } else if (projMinY / fixedDepth >= toolkit.viewY2 || (projMaxY / fixedDepth <= toolkit.viewY1)) return;
        float aX;
        float bX;
        float cX;
        float aZ;
        float bZ;
        float cZ;
        if (translateOnly) {
            aX = javaMatrix.cZ;
            bX = javaMatrix.cX;
            cX = javaMatrix.bZ;
            aZ = javaMatrix.aY;
            bZ = javaMatrix.aX;
            cZ = javaMatrix.bY;
        } else {
            aX = ((javaMatrix.cZ * transform.cZ) + (javaMatrix.cY * (transform.cX)) + (javaMatrix.aY * (transform.bZ)));
            bX = ((javaMatrix.cX * transform.cZ) + (javaMatrix.bX * (transform.cX)) + (javaMatrix.aX * (transform.bZ)));
            cX = ((javaMatrix.bZ * transform.cZ) + (javaMatrix.aZ * (transform.cX)) + (javaMatrix.bY * (transform.bZ)));
            aZ = ((javaMatrix.cZ * transform.aY) + (javaMatrix.cY * (transform.aX)) + (javaMatrix.aY * (transform.bY)));
            bZ = ((javaMatrix.cX * transform.aY) + (javaMatrix.bX * (transform.aX)) + (javaMatrix.aX * (transform.bY)));
            cZ = ((javaMatrix.bZ * transform.aY) + (javaMatrix.aZ * (transform.aX)) + (javaMatrix.bY * (transform.bY)));
        }
        if (toolkit.threadCount > 1) {
            synchronized (this) {
                while (aBoolean5357) {
                    try {
                        this.wait();
                    } catch (InterruptedException interruptedexception) {
                        /* empty */
                    }
                }
                aBoolean5357 = true;
            }
        }
        method632(Thread.currentThread());
        aRasterizer_5383.method1023((flag & 0x2) != 0);
        boolean clippedVertices = false;
        boolean clipNear = nearDepth <= toolkit.zNear;
        boolean particles = (clipNear || emitters != null || effectors != null);
        aJavaThreadResource_5367.width = aRasterizer_5383.width;
        aJavaThreadResource_5367.minX = aRasterizer_5383.minX;
        aJavaThreadResource_5367.minY = aRasterizer_5383.minY;
        int scaleX = toolkit.projectionScaleX;
        int scaleY = toolkit.projectionScaleY;
        int nearPLane = toolkit.zNear;
        if (fixedDepth == -1) {
            for (int vertex = 0; vertex < vertexCount; vertex++) {
                int x = vertexX[vertex];
                int y = vertexY[vertex];
                int z = vertexZ[vertex];
                float camX = (f_638_ + aX * (float) x + f_639_ * (float) y + aZ * (float) z);
                float camY = (f_644_ + bX * (float) x + f_645_ * (float) y + bZ * (float) z);
                float camZ = (tY + cX * (float) x + bY * (float) y + cZ * (float) z);
                renderVertexZ[vertex] = (int) camZ;
                if (camZ >= (float) nearPLane) {
                    renderVertexX[vertex] = (aJavaThreadResource_5367.minX + (int) (camX * (float) scaleX / camZ));
                    renderVertexY[vertex] = (aJavaThreadResource_5367.minY + (int) (camY * (float) scaleY / camZ));
                } else {
                    renderVertexX[vertex] = -5000;
                    clippedVertices = true;
                }
                if (particles) {
                    cameraX[vertex] = (int) camX;
                    cameraY[vertex] = (int) camY;
                    cameraZ[vertex] = (int) camZ;
                }
                if (aJavaThreadResource_5367.fogEnabled) originalZ[vertex] = (int) ((transform.tZ) + ((transform.cX * (float) x) + (transform.bX * (float) y) + (transform.aX * (float) z)));
            }
            if (billboardFaces != null) {
                for (int i = 0; i < billboardCount; i++) {
                    JavaBillboardFace billboard = billboardFaces[i];
                    JavaBillboardAttributes attributes = billboardAttributes[i];
                    short faceX = faceIndexX[billboard.index];
                    short faceY = faceIndexY[billboard.index];
                    short faceZ = faceIndexZ[billboard.index];
                    int centerX = ((vertexX[faceX] + vertexX[faceY] + vertexX[faceZ]) / 3);
                    int centerY = ((vertexY[faceX] + vertexY[faceY] + vertexY[faceZ]) / 3);
                    int centerZ = ((vertexZ[faceX] + vertexZ[faceY] + vertexZ[faceZ]) / 3);
                    float camX = ((float) attributes.anInt4316 + (f_638_ + aX * (float) centerX + f_639_ * (float) centerY + aZ * (float) centerZ));
                    float camY = ((float) attributes.anInt4317 + (f_644_ + bX * (float) centerX + f_645_ * (float) centerY + bZ * (float) centerZ));
                    float camZ = (tY + cX * (float) centerX + bY * (float) centerY + cZ * (float) centerZ);
                    if (camZ > (float) (toolkit.zNear)) {
                        attributes.screenX = (toolkit.projectionCenterX + (int) (camX * (float) scaleX / camZ));
                        attributes.screenY = (toolkit.projectionCenterY + (int) (camY * (float) scaleY / camZ));
                        attributes.screenZ = ((int) camZ - billboard.anInt154);
                        attributes.screenWidth = (int) ((float) ((attributes.anInt4314) * (billboard.aShort150) * scaleX) / (camZ * 128.0F));
                        attributes.screenHeight = (int) ((float) ((attributes.anInt4311) * (billboard.aShort143) * scaleY) / (camZ * 128.0F));
                    } else attributes.screenWidth = attributes.screenHeight = 0;
                }
            }
        } else {
            for (int v = 0; v < vertexCount; v++) {
                int x = vertexX[v];
                int y = vertexY[v];
                int z = vertexZ[v];
                float camX = (f_638_ + aX * (float) x + f_639_ * (float) y + aZ * (float) z);
                float camY = (f_644_ + bX * (float) x + f_645_ * (float) y + bZ * (float) z);
                float camZ = (tY + cX * (float) x + bY * (float) y + cZ * (float) z);
                renderVertexZ[v] = (int) camZ;
                renderVertexX[v] = (aJavaThreadResource_5367.minX + (int) (camX * (float) scaleX / (float) fixedDepth));
                renderVertexY[v] = (aJavaThreadResource_5367.minY + (int) (camY * (float) scaleY / (float) fixedDepth));
                if (particles) {
                    cameraX[v] = (int) camX;
                    cameraY[v] = (int) camY;
                    cameraZ[v] = fixedDepth;
                }
                if (aJavaThreadResource_5367.fogEnabled) originalZ[v] = (int) ((transform.tZ) + ((transform.cX * (float) x) + (transform.bX * (float) y) + (transform.aX * (float) z)));
            }
            if (billboardFaces != null) {
                for (int i_686_ = 0; i_686_ < billboardCount; i_686_++) {
                    JavaBillboardFace billboard = billboardFaces[i_686_];
                    JavaBillboardAttributes attributes = billboardAttributes[i_686_];
                    short a = faceIndexX[billboard.index];
                    short b = faceIndexY[billboard.index];
                    short c = faceIndexZ[billboard.index];
                    int centerX = ((vertexX[a] + vertexX[b] + vertexX[c]) / 3);
                    int centerY = ((vertexY[a] + vertexY[b] + vertexY[c]) / 3);
                    int centerZ = ((vertexZ[a] + vertexZ[b] + vertexZ[c]) / 3);
                    float camX = (f_638_ + aX * (float) centerX + f_639_ * (float) centerY + aZ * (float) centerZ);
                    float camY = (f_644_ + bX * (float) centerX + f_645_ * (float) centerY + bZ * (float) centerZ);
                    float camZ = (tY + cX * (float) centerX + bY * (float) centerY + cZ * (float) centerZ);
                    attributes.screenX = (toolkit.projectionCenterX + (int) (camX * (float) scaleX / (float) fixedDepth));
                    attributes.screenY = (toolkit.projectionCenterY + (int) (camY * (float) scaleY / (float) fixedDepth));
                    attributes.screenZ = fixedDepth - billboard.anInt154;
                    attributes.screenWidth = (attributes.anInt4314 * billboard.aShort150 * scaleX / (fixedDepth << 7));
                    attributes.screenHeight = (attributes.anInt4311 * billboard.aShort143 * scaleY / (fixedDepth << 7));
                }
            }
        }
        if (label != null) {
            boolean bottomClipped = false;
            boolean visiblePoint = true;
            int modelCenterX = minVertexX + maxVertexX >> 1;
            int modelCenterZ = minVertexZ + maxVertexZ >> 1;
            int x = modelCenterX;
            short y = minVertexY;
            int z = modelCenterZ;
            float camX = (f_638_ + aX * (float) x + f_639_ * (float) y + aZ * (float) z);
            float camY = (f_644_ + bX * (float) x + f_645_ * (float) y + bZ * (float) z);
            float camZ = (tY + cX * (float) x + bY * (float) y + cZ * (float) z);
            if (camZ >= (float) nearPLane) {
                int depth = (int) camZ;
                if (fixedDepth != -1) depth = fixedDepth;
                label.bottomX = (toolkit.projectionCenterX + (int) (camX * (float) scaleX / (float) depth));
                label.bottomY = (toolkit.projectionCenterY + (int) (camY * (float) scaleY / (float) depth));
            } else bottomClipped = true;
            x = modelCenterX;
            y = maxVertexY;
            z = modelCenterZ;
            float cam2X = (f_638_ + aX * (float) x + f_639_ * (float) y + aZ * (float) z);
            float cam2Y = (f_644_ + bX * (float) x + f_645_ * (float) y + bZ * (float) z);
            float cam2Z = (tY + cX * (float) x + bY * (float) y + cZ * (float) z);
            if (cam2Z >= (float) nearPLane) {
                int depth = (int) cam2Z;
                if (fixedDepth != -1) depth = fixedDepth;
                label.topX = (toolkit.projectionCenterX + (int) (cam2X * (float) scaleX / (float) depth));
                label.topY = (toolkit.projectionCenterY + (int) (cam2Y * (float) scaleY / (float) depth));
            } else bottomClipped = true;
            if (bottomClipped) {
                if (camZ < (float) nearPLane && cam2Z < (float) nearPLane) visiblePoint = false;
                else if (camZ < (float) nearPLane) {
                    float t = ((cam2Z - (float) (toolkit.zNear)) / (cam2Z - camZ));
                    int interpX = (int) (cam2X + (cam2X - camX) * t);
                    int interpY = (int) (cam2Y + (cam2Y - camY) * t);
                    int depth = nearPLane;
                    if (fixedDepth != -1) depth = fixedDepth;
                    label.bottomX = (toolkit.projectionCenterX + interpX * scaleX / depth);
                    label.bottomY = (toolkit.projectionCenterY + interpY * scaleY / depth);
                } else if (cam2Z < (float) nearPLane) {
                    float t = ((camZ - (float) nearPLane) / (camZ - cam2Z));
                    int interpX = (int) (camX + (camX - cam2X) * t);
                    int interpY = (int) (camY + (camY - cam2Y) * t);
                    int depth = nearPLane;
                    if (fixedDepth != -1) depth = fixedDepth;
                    label.bottomX = (toolkit.projectionCenterX + interpX * scaleX / depth);
                    label.bottomY = (toolkit.projectionCenterY + interpY * scaleY / depth);
                }
            }
            if (visiblePoint) {
                if (camZ > cam2Z) {
                    int depth = (int) camZ;
                    if (fixedDepth != -1) depth = fixedDepth;
                    label.width = (toolkit.projectionCenterX + (int) ((camX + (float) distance2D) * (float) scaleX / (float) depth) - (label.bottomX));
                } else {
                    int depth = (int) cam2Z;
                    if (fixedDepth != -1) depth = fixedDepth;
                    label.width = (toolkit.projectionCenterX + (int) ((cam2X + (float) distance2D) * (float) scaleX / (float) depth) - (label.topX));
                }
                label.visible = true;
            }
        }
        method634(true);
        aRasterizer_5383.aBoolean1669 = (flag & 0x1) == 0;
        aRasterizer_5383.aBoolean1667 = false;
        try {
            method650(clippedVertices, ((aJavaThreadResource_5367.fogActive && (farDepth > aJavaThreadResource_5367.fogPlane)) || aJavaThreadResource_5367.fogEnabled), nearDepth, farDepth - nearDepth);
        } catch (Exception exception) {
            /* empty */
        }
        if (billboardFaces != null) {
            for (int i = 0; i < faceCount; i++)
                billboardIndices[i] = -1;
        }
        aRasterizer_5383 = null;
        if (toolkit.threadCount > 1) {
            synchronized (this) {
                aBoolean5357 = false;
                this.notifyAll();
            }
        }
    }

    final boolean r() {
        return movingTextures;
    }

    // method655
    private final void calculateBounds() {
        if (!calculatedBounds) {
            int maxDist = 0;
            int maxLen = 0;
            int minX = 32767;
            int minY = 32767;
            int minZ = 32767;
            int maxX = -32768;
            int maxY = -32768;
            int maxZ = -32768;
            for (int vertex = 0; vertex < maxVertex; vertex++) {
                int x = vertexX[vertex];
                int y = vertexY[vertex];
                int z = vertexZ[vertex];
                if (x < minX) minX = x;
                if (x > maxX) maxX = x;
                if (y < minY) minY = y;
                if (y > maxY) maxY = y;
                if (z < minZ) minZ = z;
                if (z > maxZ) maxZ = z;
                int dist = x * x + z * z;
                if (dist > maxDist) maxDist = dist;
                dist += y * y;
                if (dist > maxLen) maxLen = dist;
            }
            minVertexX = (short) minX;
            maxVertexX = (short) maxX;
            minVertexY = (short) minY;
            maxVertexY = (short) maxY;
            minVertexZ = (short) minZ;
            maxVertexZ = (short) maxZ;
            distance2D = (short) (int) (Math.sqrt(maxDist) + 0.99);
            distance3D = (short) (int) (Math.sqrt(maxLen) + 0.99);
            calculatedBounds = true;
        }
    }

    private final int method656(int i) {
        if (i < 2) i = 2;
        else if (i > 126) i = 126;
        return i;
    }

    private final void method657(boolean bool) {
        if (renderPoints == 1) method647();
        else if (renderPoints == 2) {
            if ((functionMask & 0x97098) == 0 && texCoordU == null) faceColour = null;
            if (bool) shadingType = null;
        } else {
            method636();
            int i = toolkit.anInt7484;
            int i_734_ = toolkit.anInt7473;
            int i_735_ = toolkit.anInt7479;
            int i_736_ = toolkit.anInt7500 >> 8;
            int i_737_ = toolkit.anInt7474 * 768 / anInt5349;
            int i_738_ = toolkit.anInt7478 * 768 / anInt5349;
            if (shadeFacesX == null) {
                shadeFacesX = new int[faceCount];
                shadeFacesY = new int[faceCount];
                shadeFacesZ = new int[faceCount];
            }
            for (int i_739_ = 0; i_739_ < faceCount; i_739_++) {
                byte i_740_;
                if (shadingType == null) i_740_ = (byte) 0;
                else i_740_ = shadingType[i_739_];
                byte i_741_;
                if (faceAlphas == null) i_741_ = (byte) 0;
                else i_741_ = faceAlphas[i_739_];
                short i_742_;
                if (faceTextures == null) i_742_ = (short) -1;
                else i_742_ = faceTextures[i_739_];
                if (i_741_ == -2) i_740_ = (byte) 3;
                if (i_741_ == -1) i_740_ = (byte) 2;
                if (i_742_ == -1) {
                    if (i_740_ == 0) {
                        int i_743_ = faceColour[i_739_] & 0xffff;
                        int i_744_ = (i_743_ & 0x7f) * anInt5344 >> 7;
                        short i_745_ = SkyBoxSphereTypeList.method303(i_743_ & ~0x7f | i_744_, 30);
                        VertexNormal vertexNormal;
                        if (aVertexNormalArray5313 != null && (aVertexNormalArray5313[faceIndexX[i_739_]] != null)) vertexNormal = aVertexNormalArray5313[faceIndexX[i_739_]];
                        else vertexNormal = normals[faceIndexX[i_739_]];
                        int i_746_ = (((i * vertexNormal.x + i_734_ * vertexNormal.y + i_735_ * vertexNormal.z) / vertexNormal.faceCount) >> 16);
                        int i_747_ = i_746_ > 256 ? i_737_ : i_738_;
                        int i_748_ = (i_736_ >> 1) + (i_747_ * i_746_ >> 17);
                        shadeFacesX[i_739_] = i_748_ << 17 | Class291.method2198(0, i_748_, i_745_);
                        if (aVertexNormalArray5313 != null && (aVertexNormalArray5313[faceIndexY[i_739_]] != null)) vertexNormal = aVertexNormalArray5313[faceIndexY[i_739_]];
                        else vertexNormal = normals[faceIndexY[i_739_]];
                        i_746_ = ((i * vertexNormal.x + i_734_ * vertexNormal.y + i_735_ * vertexNormal.z) / vertexNormal.faceCount) >> 16;
                        i_747_ = i_746_ > 256 ? i_737_ : i_738_;
                        i_748_ = (i_736_ >> 1) + (i_747_ * i_746_ >> 17);
                        shadeFacesY[i_739_] = i_748_ << 17 | Class291.method2198(0, i_748_, i_745_);
                        if (aVertexNormalArray5313 != null && (aVertexNormalArray5313[faceIndexZ[i_739_]] != null)) vertexNormal = aVertexNormalArray5313[faceIndexZ[i_739_]];
                        else vertexNormal = normals[faceIndexZ[i_739_]];
                        i_746_ = ((i * vertexNormal.x + i_734_ * vertexNormal.y + i_735_ * vertexNormal.z) / vertexNormal.faceCount) >> 16;
                        i_747_ = i_746_ > 256 ? i_737_ : i_738_;
                        i_748_ = (i_736_ >> 1) + (i_747_ * i_746_ >> 17);
                        shadeFacesZ[i_739_] = i_748_ << 17 | Class291.method2198(0, i_748_, i_745_);
                    } else if (i_740_ == 1) {
                        int i_749_ = faceColour[i_739_] & 0xffff;
                        int i_750_ = (i_749_ & 0x7f) * anInt5344 >> 7;
                        short i_751_ = SkyBoxSphereTypeList.method303(i_749_ & ~0x7f | i_750_, 30);
                        Class41 class41 = aClass41Array5385[i_739_];
                        int i_752_ = ((i * class41.x + i_734_ * class41.y + i_735_ * class41.z) >> 16);
                        int i_753_ = i_752_ > 256 ? i_737_ : i_738_;
                        int i_754_ = (i_736_ >> 1) + (i_753_ * i_752_ >> 17);
                        shadeFacesX[i_739_] = i_754_ << 17 | Class291.method2198(0, i_754_, i_751_);
                        shadeFacesZ[i_739_] = -1;
                    } else if (i_740_ == 3) {
                        shadeFacesX[i_739_] = 128;
                        shadeFacesZ[i_739_] = -1;
                    } else shadeFacesZ[i_739_] = -2;
                } else {
                    int i_755_ = faceColour[i_739_] & 0xffff;
                    if (i_740_ == 0) {
                        VertexNormal vertexNormal;
                        if (aVertexNormalArray5313 != null && (aVertexNormalArray5313[faceIndexX[i_739_]] != null)) vertexNormal = aVertexNormalArray5313[faceIndexX[i_739_]];
                        else vertexNormal = normals[faceIndexX[i_739_]];
                        int i_756_ = (((i * vertexNormal.x + i_734_ * vertexNormal.y + i_735_ * vertexNormal.z) / vertexNormal.faceCount) >> 16);
                        int i_757_ = i_756_ > 256 ? i_737_ : i_738_;
                        int i_758_ = method656((i_736_ >> 2) + (i_757_ * i_756_ >> 18));
                        shadeFacesX[i_739_] = i_758_ << 24 | method642(i_755_, i_742_, i_758_);
                        if (aVertexNormalArray5313 != null && (aVertexNormalArray5313[faceIndexY[i_739_]] != null)) vertexNormal = aVertexNormalArray5313[faceIndexY[i_739_]];
                        else vertexNormal = normals[faceIndexY[i_739_]];
                        i_756_ = ((i * vertexNormal.x + i_734_ * vertexNormal.y + i_735_ * vertexNormal.z) / vertexNormal.faceCount) >> 16;
                        i_757_ = i_756_ > 256 ? i_737_ : i_738_;
                        i_758_ = method656((i_736_ >> 2) + (i_757_ * i_756_ >> 18));
                        shadeFacesY[i_739_] = i_758_ << 24 | method642(i_755_, i_742_, i_758_);
                        if (aVertexNormalArray5313 != null && (aVertexNormalArray5313[faceIndexZ[i_739_]] != null)) vertexNormal = aVertexNormalArray5313[faceIndexZ[i_739_]];
                        else vertexNormal = normals[faceIndexZ[i_739_]];
                        i_756_ = ((i * vertexNormal.x + i_734_ * vertexNormal.y + i_735_ * vertexNormal.z) / vertexNormal.faceCount) >> 16;
                        i_757_ = i_756_ > 256 ? i_737_ : i_738_;
                        i_758_ = method656((i_736_ >> 2) + (i_757_ * i_756_ >> 18));
                        shadeFacesZ[i_739_] = i_758_ << 24 | method642(i_755_, i_742_, i_758_);
                    } else if (i_740_ == 1) {
                        Class41 class41 = aClass41Array5385[i_739_];
                        int i_759_ = ((i * class41.x + i_734_ * class41.y + i_735_ * class41.z) >> 16);
                        int i_760_ = i_759_ > 256 ? i_737_ : i_738_;
                        int i_761_ = method656((i_736_ >> 2) + (i_760_ * i_759_ >> 18));
                        shadeFacesX[i_739_] = i_761_ << 24 | method642(i_755_, i_742_, i_761_);
                        shadeFacesZ[i_739_] = -1;
                    } else shadeFacesZ[i_739_] = -2;
                }
            }
            normals = null;
            aVertexNormalArray5313 = null;
            aClass41Array5385 = null;
            if ((functionMask & 0x97098) == 0 && texCoordU == null) faceColour = null;
            if (bool) shadingType = null;
            renderPoints = 2;
        }
    }

    final Model method614(byte i, int i_762_, boolean bool) {
        method648(Thread.currentThread());
        JavaModel javaModel_763_;
        JavaModel javaModel_764_;
        if (i == 1) {
            javaModel_763_ = aJavaModel_5374;
            javaModel_764_ = aJavaModel_5378;
        } else if (i == 2) {
            javaModel_763_ = aJavaModel_5328;
            javaModel_764_ = aJavaModel_5339;
        } else if (i == 3) {
            javaModel_763_ = aJavaModel_5376;
            javaModel_764_ = aJavaModel_5396;
        } else if (i == 4) {
            javaModel_763_ = aJavaModel_5397;
            javaModel_764_ = aJavaModel_5347;
        } else if (i == 5) {
            javaModel_763_ = aJavaModel_5319;
            javaModel_764_ = aJavaModel_5390;
        } else javaModel_764_ = javaModel_763_ = new JavaModel(toolkit);
        return method633(javaModel_764_, javaModel_763_, i_762_, i != 0, bool);
    }

    final void O(int i, int i_765_, int i_766_) {
        if (i != 128 && (functionMask & 0x1) != 1) throw new IllegalStateException();
        if (i_765_ != 128 && (functionMask & 0x2) != 2) throw new IllegalStateException();
        if (i_766_ != 128 && (functionMask & 0x4) != 4) throw new IllegalStateException();
        synchronized (this) {
            for (int i_767_ = 0; i_767_ < vertexCount; i_767_++) {
                vertexX[i_767_] = vertexX[i_767_] * i >> 7;
                vertexY[i_767_] = vertexY[i_767_] * i_765_ >> 7;
                vertexZ[i_767_] = vertexZ[i_767_] * i_766_ >> 7;
            }
            calculatedBounds = false;
        }
    }

    final int ua() {
        return functionMask;
    }

    private final void method658(int i) {
        if (aJavaThreadResource_5367.fogEnabled) {
            short x = faceIndexX[i];
            short y = faceIndexY[i];
            short z = faceIndexZ[i];
            int i_780_ = 0;
            int i_781_ = 0;
            int i_782_ = 0;
            if (originalZ[x] > aJavaThreadResource_5367.anInt2197) i_780_ = 255;
            else if (originalZ[x] > aJavaThreadResource_5367.anInt2211) i_780_ = ((aJavaThreadResource_5367.anInt2211 - originalZ[x]) * 255 / (aJavaThreadResource_5367.anInt2211 - aJavaThreadResource_5367.anInt2197));
            if (originalZ[y] > aJavaThreadResource_5367.anInt2197) i_781_ = 255;
            else if (originalZ[y] > aJavaThreadResource_5367.anInt2211) i_781_ = ((aJavaThreadResource_5367.anInt2211 - originalZ[y]) * 255 / (aJavaThreadResource_5367.anInt2211 - aJavaThreadResource_5367.anInt2197));
            if (originalZ[z] > aJavaThreadResource_5367.anInt2197) i_782_ = 255;
            else if (originalZ[z] > aJavaThreadResource_5367.anInt2211) i_782_ = ((aJavaThreadResource_5367.anInt2211 - originalZ[z]) * 255 / (aJavaThreadResource_5367.anInt2211 - aJavaThreadResource_5367.anInt2197));
            if (faceAlphas == null) aRasterizer_5383.alpha = 0;
            else aRasterizer_5383.alpha = faceAlphas[i] & 0xff;
            if (faceTextures == null || faceTextures[i] == -1) {
                if (shadeFacesZ[i] == -1)
                    aRasterizer_5383.renderTriangleRgb((float) renderVertexY[x], (float) renderVertexY[y], (float) renderVertexY[z], (float) renderVertexX[x], (float) renderVertexX[y], (float) renderVertexX[z], (float) renderVertexZ[x], (float) renderVertexZ[y], (float) renderVertexZ[z], JavaBillboardFace.method206((Class126.HSV_TO_RGB[shadeFacesX[i] & 0xffff]), (i_780_ << 24 | (aJavaThreadResource_5367.anInt2192)), 255), JavaBillboardFace.method206((Class126.HSV_TO_RGB[shadeFacesX[i] & 0xffff]), (i_781_ << 24 | (aJavaThreadResource_5367.anInt2192)), 255), JavaBillboardFace.method206((Class126.HSV_TO_RGB[shadeFacesX[i] & 0xffff]), (i_782_ << 24 | (aJavaThreadResource_5367.anInt2192)), 255));
                else
                    aRasterizer_5383.renderTriangleRgb((float) renderVertexY[x], (float) renderVertexY[y], (float) renderVertexY[z], (float) renderVertexX[x], (float) renderVertexX[y], (float) renderVertexX[z], (float) renderVertexZ[x], (float) renderVertexZ[y], (float) renderVertexZ[z], JavaBillboardFace.method206((Class126.HSV_TO_RGB[shadeFacesX[i] & 0xffff]), (i_780_ << 24 | (aJavaThreadResource_5367.anInt2192)), 255), JavaBillboardFace.method206((Class126.HSV_TO_RGB[shadeFacesY[i] & 0xffff]), (i_781_ << 24 | (aJavaThreadResource_5367.anInt2192)), 255), JavaBillboardFace.method206((Class126.HSV_TO_RGB[shadeFacesZ[i] & 0xffff]), (i_782_ << 24 | (aJavaThreadResource_5367.anInt2192)), 255));
            } else {
                int i_783_ = -16777216;
                if (faceAlphas != null) i_783_ = 255 - (faceAlphas[i] & 0xff) << 24;
                if (shadeFacesZ[i] == -1) {
                    int i_784_ = i_783_ | shadeFacesX[i] & 0xffffff;
                    aRasterizer_5383.drawTexturedTriangle((float) renderVertexY[x], (float) renderVertexY[y], (float) renderVertexY[z], (float) renderVertexX[x], (float) renderVertexX[y], (float) renderVertexX[z], (float) renderVertexZ[x], (float) renderVertexZ[y], (float) renderVertexZ[z], texCoordU[i][0], texCoordU[i][1], texCoordU[i][2], texCoordV[i][0], texCoordV[i][1], texCoordV[i][2], i_784_, i_784_, i_784_, (aJavaThreadResource_5367.anInt2192), i_780_, i_781_, i_782_, faceTextures[i]);
                } else
                    aRasterizer_5383.drawTexturedTriangle((float) renderVertexY[x], (float) renderVertexY[y], (float) renderVertexY[z], (float) renderVertexX[x], (float) renderVertexX[y], (float) renderVertexX[z], (float) renderVertexZ[x], (float) renderVertexZ[y], (float) renderVertexZ[z], texCoordU[i][0], texCoordU[i][1], texCoordU[i][2], texCoordV[i][0], texCoordV[i][1], texCoordV[i][2], i_783_ | shadeFacesX[i] & 0xffffff, i_783_ | shadeFacesY[i] & 0xffffff, i_783_ | shadeFacesZ[i] & 0xffffff, aJavaThreadResource_5367.anInt2192, i_780_, i_781_, i_782_, faceTextures[i]);
            }
        } else {
            short x = faceIndexX[i];
            short y = faceIndexY[i];
            short z = faceIndexZ[i];
            int i_771_ = (renderVertexZ[x] - aJavaThreadResource_5367.fogPlane);
            if (i_771_ > 255) i_771_ = 255;
            else if (i_771_ < 0) i_771_ = 0;
            int i_772_ = (renderVertexZ[y] - aJavaThreadResource_5367.fogPlane);
            if (i_772_ > 255) i_772_ = 255;
            else if (i_772_ < 0) i_772_ = 0;
            int i_773_ = (renderVertexZ[z] - aJavaThreadResource_5367.fogPlane);
            if (i_773_ > 255) i_773_ = 255;
            else if (i_773_ < 0) i_773_ = 0;
            int i_774_ = i_771_ + i_772_ + i_773_;
            if (i_774_ != 765) {
                if (i_774_ == 0) drawFace(i);
                else {
                    if (faceAlphas == null) aRasterizer_5383.alpha = 0;
                    else aRasterizer_5383.alpha = faceAlphas[i] & 0xff;
                    if (faceTextures == null || faceTextures[i] == -1) {
                        if (shadeFacesZ[i] == -1)
                            aRasterizer_5383.renderTriangleRgb((float) renderVertexY[x], (float) renderVertexY[y], (float) renderVertexY[z], (float) renderVertexX[x], (float) renderVertexX[y], (float) renderVertexX[z], (float) renderVertexZ[x], (float) renderVertexZ[y], (float) renderVertexZ[z], JavaBillboardFace.method206((Class126.HSV_TO_RGB[(shadeFacesX[i] & 0xffff)]), (i_771_ << 24 | (aJavaThreadResource_5367.anInt2192)), 255), JavaBillboardFace.method206((Class126.HSV_TO_RGB[(shadeFacesX[i] & 0xffff)]), (i_772_ << 24 | (aJavaThreadResource_5367.anInt2192)), 255), JavaBillboardFace.method206((Class126.HSV_TO_RGB[(shadeFacesX[i] & 0xffff)]), (i_773_ << 24 | (aJavaThreadResource_5367.anInt2192)), 255));
                        else
                            aRasterizer_5383.renderTriangleRgb((float) renderVertexY[x], (float) renderVertexY[y], (float) renderVertexY[z], (float) renderVertexX[x], (float) renderVertexX[y], (float) renderVertexX[z], (float) renderVertexZ[x], (float) renderVertexZ[y], (float) renderVertexZ[z], JavaBillboardFace.method206((Class126.HSV_TO_RGB[(shadeFacesX[i] & 0xffff)]), (i_771_ << 24 | (aJavaThreadResource_5367.anInt2192)), 255), JavaBillboardFace.method206((Class126.HSV_TO_RGB[(shadeFacesY[i] & 0xffff)]), (i_772_ << 24 | (aJavaThreadResource_5367.anInt2192)), 255), JavaBillboardFace.method206((Class126.HSV_TO_RGB[(shadeFacesZ[i] & 0xffff)]), (i_773_ << 24 | (aJavaThreadResource_5367.anInt2192)), 255));
                    } else {
                        int i_775_ = -16777216;
                        if (faceAlphas != null) i_775_ = 255 - (faceAlphas[i] & 0xff) << 24;
                        if (shadeFacesZ[i] == -1) {
                            int i_776_ = i_775_ | shadeFacesX[i] & 0xffffff;
                            aRasterizer_5383.drawTexturedTriangle((float) renderVertexY[x], (float) renderVertexY[y], (float) renderVertexY[z], (float) renderVertexX[x], (float) renderVertexX[y], (float) renderVertexX[z], (float) renderVertexZ[x], (float) renderVertexZ[y], (float) renderVertexZ[z], texCoordU[i][0], texCoordU[i][1], texCoordU[i][2], texCoordV[i][0], texCoordV[i][1], texCoordV[i][2], i_776_, i_776_, i_776_, aJavaThreadResource_5367.anInt2192, i_771_, i_772_, i_773_, faceTextures[i]);
                        } else
                            aRasterizer_5383.drawTexturedTriangle((float) renderVertexY[x], (float) renderVertexY[y], (float) renderVertexY[z], (float) renderVertexX[x], (float) renderVertexX[y], (float) renderVertexX[z], (float) renderVertexZ[x], (float) renderVertexZ[y], (float) renderVertexZ[z], texCoordU[i][0], texCoordU[i][1], texCoordU[i][2], texCoordV[i][0], texCoordV[i][1], texCoordV[i][2], i_775_ | shadeFacesX[i] & 0xffffff, i_775_ | shadeFacesY[i] & 0xffffff, i_775_ | shadeFacesZ[i] & 0xffffff, aJavaThreadResource_5367.anInt2192, i_771_, i_772_, i_773_, faceTextures[i]);
                    }
                }
            }
        }
    }

    JavaModel(JavaToolkit var_javaToolkit) {
        renderPoints = 0;
        aBoolean5369 = false;
        faceCount = 0;
        aBoolean5372 = false;
        movingTextures = false;
        maxVertex = 0;
        transparent = false;
        toolkit = var_javaToolkit;
    }

    JavaModel(JavaToolkit var_javaToolkit, Mesh mesh, int arg3, int i_785_, int i_786_, int featureMask) {
        renderPoints = 0;
        aBoolean5369 = false;
        faceCount = 0;
        aBoolean5372 = false;
        movingTextures = false;
        maxVertex = 0;
        transparent = false;
        toolkit = var_javaToolkit;
        functionMask = arg3;
        anInt5344 = i_785_;
        anInt5349 = i_786_;
        TextureSource var_d = toolkit.aD4579;
        vertexCount = mesh.vertexCount;
        maxVertex = mesh.maxVertex;
        vertexX = mesh.vertexX;
        vertexY = mesh.vertexY;
        vertexZ = mesh.vertexZ;
        faceCount = mesh.faceCount;
        faceIndexX = mesh.faceA;
        faceIndexY = mesh.faceB;
        faceIndexZ = mesh.faceC;
        facePriority = mesh.facePriority;
        faceColour = mesh.faceColour;
        faceAlphas = mesh.faceAlpha;
        aShortArray5370 = mesh.aShortArray1856;
        shadingType = mesh.shadingType;
        emitters = mesh.emitters;
        effectors = mesh.effectors;
        originalModels = mesh.originalModels;
        int[] faceIndex = new int[faceCount];
        for (int i = 0; i < faceCount; i++)
            faceIndex[i] = i;
        long[] faceIds = new long[faceCount];
        boolean transparentMesh = (functionMask & 0x100) != 0;
        for (int i = 0; i < faceCount; i++) {
            int index = faceIndex[i];
            TextureMetrics textureMetrics = null;
            int idHi = 0;
            int idLo = 0;
            int effectType = 0;
            int effectParam1 = 0;
            if (mesh.billboards != null) {
                boolean hideFace = false;
                for (int j = 0; j < mesh.billboards.length; j++) {
                    MeshBillboard billboard = mesh.billboards[j];
                    if (index == billboard.face) {
                        BillboardType type = Class73.billboardTypeList(104, (billboard.anInt2153));
                        if (type.hideFace) hideFace = true;
                        if (type.texture != -1) {
                            TextureMetrics textureMetrics_797_ = var_d.getMetrics((type.texture), -6662);
                            if (textureMetrics_797_.alphaBlendMode == 2) transparent = true;
                        }
                    }
                }
                if (hideFace) faceIds[i] = 9223372036854775807L;
            }
            int texture = -1;
            if (mesh.faceTexture != null) {
                texture = mesh.faceTexture[index];
                if (texture != -1) {
                    textureMetrics = var_d.getMetrics(texture & 0xffff, -6662);
                    if ((featureMask & 0x40) == 0 || !textureMetrics.disableable) {
                        effectType = textureMetrics.effectType;
                        effectParam1 = textureMetrics.effectParam1;
                    } else texture = -1;
                }
            }
            boolean transparentFace = (faceAlphas != null && faceAlphas[index] != 0 || textureMetrics != null && textureMetrics.alphaBlendMode == 2);
            if ((transparentMesh || transparentFace) && facePriority != null) idHi += facePriority[index] << 17;
            if (transparentFace) idHi += 65536;
            idHi += (effectType & 0xff) << 8;
            idHi += effectParam1 & 0xff;
            idLo += (texture & 0xffff) << 16;
            idLo += i & 0xffff;
            faceIds[i] = ((long) idHi << 32) + (long) idLo;
            transparent |= transparentFace;
        }
        Class348_Sub16_Sub2.quickSort(faceIndex, faceIds, 0);
        if (mesh.billboards != null) {
            billboardCount = mesh.billboards.length;
            billboardFaces = new JavaBillboardFace[billboardCount];
            billboardAttributes = new JavaBillboardAttributes[billboardCount];
            for (int index = 0; index < mesh.billboards.length; index++) {
                MeshBillboard billboard = mesh.billboards[index];
                BillboardType type = Class73.billboardTypeList(104, billboard.anInt2153);
                int colour = ((Class126.HSV_TO_RGB[(mesh.faceColour[billboard.face]) & 0xffff]) & 0xffffff);
                colour = (colour | 255 - (mesh.faceAlpha != null ? (mesh.faceAlpha[billboard.face]) & 0xff : 0) << 24);
                billboardFaces[index] = new JavaBillboardFace(billboard.face, (mesh.faceA[billboard.face]), (mesh.faceB[billboard.face]), (mesh.faceC[billboard.face]), type.anInt2526, type.anInt2530, type.texture, type.anInt2533, type.anInt2534, type.hideFace, billboard.anInt2158);
                billboardAttributes[index] = new JavaBillboardAttributes(colour);
            }
        }
        texCoordU = new float[faceCount][];
        texCoordV = new float[faceCount][];
        TextureUniverse textureUniverse = Class59_Sub2_Sub1.method565(255, faceCount, mesh, faceIndex);
        JavaThreadResource javaThreadResource = toolkit.method3724(Thread.currentThread());
        float[] fs = javaThreadResource.aFloatArray2226;
        boolean hasTextureCoords = false;
        for (int i = 0; i < faceCount; i++) {
            int index = faceIndex[i];
            int texSpace;
            if (mesh.faceTexSpace == null) texSpace = -1;
            else texSpace = mesh.faceTexSpace[index];
            int tex = (mesh.faceTexture == null ? -1 : mesh.faceTexture[index]);
            if (tex != -1 && (featureMask & 0x40) != 0) {
                TextureMetrics textureMetrics = var_d.getMetrics(tex & 0xffff, -6662);
                if (textureMetrics.disableable) tex = -1;
            }
            if (tex != -1) {
                hasTextureCoords = true;
                float[] us = texCoordU[index] = new float[3];
                float[] uv = texCoordV[index] = new float[3];
                boolean bool_809_ = false;
                if (texSpace == -1) {
                    us[0] = 0.0F;
                    uv[0] = 1.0F;
                    us[1] = 1.0F;
                    uv[1] = 1.0F;
                    us[2] = 0.0F;
                    uv[2] = 0.0F;
                } else {
                    texSpace &= 0xff;
                    byte mappingType = mesh.texMappingType[texSpace];
                    if (mappingType == 0) {
                        short faceA = faceIndexX[index];
                        short faceB = faceIndexY[index];
                        short faceC = faceIndexZ[index];
                        short texSpaceDefA = mesh.texSpaceDefA[texSpace];
                        short texSpaceDefB = mesh.texSpaceDefB[texSpace];
                        short texSpaceDefC = mesh.texSpaceDefC[texSpace];
                        float vertexX = (float) this.vertexX[texSpaceDefA];
                        float vertexY = (float) this.vertexY[texSpaceDefA];
                        float vertexZ = (float) this.vertexZ[texSpaceDefA];
                        float relativeXSB = (float) this.vertexX[texSpaceDefB] - vertexX;
                        float relativeYSB = (float) this.vertexY[texSpaceDefB] - vertexY;
                        float relativeZSB = (float) this.vertexZ[texSpaceDefB] - vertexZ;
                        float relativeXSC = (float) this.vertexX[texSpaceDefC] - vertexX;
                        float relativeYSC = (float) this.vertexY[texSpaceDefC] - vertexY;
                        float relativeZSC = (float) this.vertexZ[texSpaceDefC] - vertexZ;
                        float relativeXFA = (float) this.vertexX[faceA] - vertexX;
                        float relativeYFA = (float) this.vertexY[faceA] - vertexY;
                        float relativeZFA = (float) this.vertexZ[faceA] - vertexZ;
                        float relativeXFB = (float) this.vertexX[faceB] - vertexX;
                        float relativeYFB = (float) this.vertexY[faceB] - vertexY;
                        float relativeZFB = (float) this.vertexZ[faceB] - vertexZ;
                        float relativeXFC = (float) this.vertexX[faceC] - vertexX;
                        float relativeYFC = (float) this.vertexY[faceC] - vertexY;
                        float relativeZFC = (float) this.vertexZ[faceC] - vertexZ;
                        float f_834_ = relativeYSB * relativeZSC - relativeZSB * relativeYSC;
                        float f_835_ = relativeZSB * relativeXSC - relativeXSB * relativeZSC;
                        float f_836_ = relativeXSB * relativeYSC - relativeYSB * relativeXSC;
                        float f_837_ = relativeYSC * f_836_ - relativeZSC * f_835_;
                        float f_838_ = relativeZSC * f_834_ - relativeXSC * f_836_;
                        float f_839_ = relativeXSC * f_835_ - relativeYSC * f_834_;
                        float scale = 1.0F / (f_837_ * relativeXSB + f_838_ * relativeYSB + f_839_ * relativeZSB);
                        us[0] = (f_837_ * relativeXFA + f_838_ * relativeYFA + f_839_ * relativeZFA) * scale;
                        us[1] = (f_837_ * relativeXFB + f_838_ * relativeYFB + f_839_ * relativeZFB) * scale;
                        us[2] = (f_837_ * relativeXFC + f_838_ * relativeYFC + f_839_ * relativeZFC) * scale;
                        f_837_ = relativeYSB * f_836_ - relativeZSB * f_835_;
                        f_838_ = relativeZSB * f_834_ - relativeXSB * f_836_;
                        f_839_ = relativeXSB * f_835_ - relativeYSB * f_834_;
                        scale = 1.0F / (f_837_ * relativeXSC + f_838_ * relativeYSC + f_839_ * relativeZSC);
                        uv[0] = (f_837_ * relativeXFA + f_838_ * relativeYFA + f_839_ * relativeZFA) * scale;
                        uv[1] = (f_837_ * relativeXFB + f_838_ * relativeYFB + f_839_ * relativeZFB) * scale;
                        uv[2] = (f_837_ * relativeXFC + f_838_ * relativeYFC + f_839_ * relativeZFC) * scale;
                    } else {
                        short faceA = faceIndexX[index];
                        short faceB = faceIndexY[index];
                        short faceC = faceIndexZ[index];
                        int originX = textureUniverse.originX[texSpace];
                        int originY = textureUniverse.originY[texSpace];
                        int originZ = textureUniverse.originZ[texSpace];
                        float[] matrix = (textureUniverse.matrices[texSpace]);
                        byte direction = mesh.rexDirection[texSpace];
                        float offsetX = ((float) (mesh.texOffsetX[texSpace]) / 256.0F);
                        if (mappingType == 1) {
                            float scaleZ = ((float) (mesh.texSpaceScaleZ[texSpace]) / 1024.0F);
                            Class246.cylinderMap(originZ, vertexZ[faceA], direction, 8, vertexX[faceA], fs, vertexY[faceA], offsetX, originY, originX, scaleZ, matrix);
                            us[0] = fs[0];
                            uv[0] = fs[1];
                            Class246.cylinderMap(originZ, vertexZ[faceB], direction, 8, vertexX[faceB], fs, vertexY[faceB], offsetX, originY, originX, scaleZ, matrix);
                            us[1] = fs[0];
                            uv[1] = fs[1];
                            Class246.cylinderMap(originZ, vertexZ[faceC], direction, 8, vertexX[faceC], fs, vertexY[faceC], offsetX, originY, originX, scaleZ, matrix);
                            us[2] = fs[0];
                            uv[2] = fs[1];
                            float scale = scaleZ / 2.0F;
                            if ((direction & 0x1) == 0) {
                                if (us[1] - us[0] > scale) us[1] -= scaleZ;
                                else if (us[0] - us[1] > scale) us[1] += scaleZ;
                                if (us[2] - us[0] > scale) us[2] -= scaleZ;
                                else if (us[0] - us[2] > scale) us[2] += scaleZ;
                            } else {
                                if (uv[1] - uv[0] > scale) uv[1] -= scaleZ;
                                else if (uv[0] - uv[1] > scale) uv[1] += scaleZ;
                                if (uv[2] - uv[0] > scale) uv[2] -= scaleZ;
                                else if (uv[0] - uv[2] > scale) uv[2] += scaleZ;
                            }
                        } else if (mappingType == 2) {
                            float offsetY = ((float) (mesh.texOffsetY[texSpace]) / 256.0F);
                            float offsetZ = ((float) (mesh.texOffsetZ[texSpace]) / 256.0F);
                            int deltaX1 = (vertexX[faceB] - vertexX[faceA]);
                            int deltaY1 = (vertexY[faceB] - vertexY[faceA]);
                            int deltaZ1 = (vertexZ[faceB] - vertexZ[faceA]);
                            int deltaX2 = (vertexX[faceC] - vertexX[faceA]);
                            int deltaY2 = (vertexY[faceC] - vertexY[faceA]);
                            int deltaZ2 = (vertexZ[faceC] - vertexZ[faceA]);
                            int relativeX = deltaY1 * deltaZ2 - deltaY2 * deltaZ1;
                            int relativeY = deltaZ1 * deltaX2 - deltaZ2 * deltaX1;
                            int relativeZ = deltaX1 * deltaY2 - deltaX2 * deltaY1;
                            float scaleX = 64.0F / (float) (mesh.texSpaceScaleX[texSpace]);
                            float scaleY = 64.0F / (float) (mesh.texSpaceScaleY[texSpace]);
                            float scaleZ = 64.0F / (float) (mesh.texSpaceScaleZ[texSpace]);
                            float x = (((float) relativeX * matrix[0] + (float) relativeY * matrix[1] + (float) relativeZ * matrix[2]) / scaleX);
                            float y = (((float) relativeX * matrix[3] + (float) relativeY * matrix[4] + (float) relativeZ * matrix[5]) / scaleY);
                            float z = (((float) relativeX * matrix[6] + (float) relativeY * matrix[7] + (float) relativeZ * matrix[8]) / scaleZ);
                            int cubeFace = Class331.cubeFace(y, false, z, x);
                            Class262.cubeMap(offsetZ, offsetX, matrix, vertexZ[faceA], originZ, false, direction, originX, vertexX[faceA], vertexY[faceA], offsetY, fs, originY, cubeFace);
                            us[0] = fs[0];
                            uv[0] = fs[1];
                            Class262.cubeMap(offsetZ, offsetX, matrix, vertexZ[faceB], originZ, false, direction, originX, vertexX[faceB], vertexY[faceB], offsetY, fs, originY, cubeFace);
                            us[1] = fs[0];
                            uv[1] = fs[1];
                            Class262.cubeMap(offsetZ, offsetX, matrix, vertexZ[faceC], originZ, false, direction, originX, vertexX[faceC], vertexY[faceC], offsetY, fs, originY, cubeFace);
                            us[2] = fs[0];
                            uv[2] = fs[1];
                        } else if (mappingType == 3) {
                            Class181.sphereMap(originZ, direction, offsetX, vertexX[faceA], fs, vertexZ[faceA], originX, vertexY[faceA], originY, -4, matrix);
                            us[0] = fs[0];
                            uv[0] = fs[1];
                            Class181.sphereMap(originZ, direction, offsetX, vertexX[faceB], fs, vertexZ[faceB], originX, vertexY[faceB], originY, -4, matrix);
                            us[1] = fs[0];
                            uv[1] = fs[1];
                            Class181.sphereMap(originZ, direction, offsetX, vertexX[faceC], fs, vertexZ[faceC], originX, vertexY[faceC], originY, -4, matrix);
                            us[2] = fs[0];
                            uv[2] = fs[1];
                            if ((direction & 0x1) == 0) {
                                if (us[1] - us[0] > 0.5F) us[1]--;
                                else if (us[0] - us[1] > 0.5F) us[1]++;
                                if (us[2] - us[0] > 0.5F) us[2]--;
                                else if (us[0] - us[2] > 0.5F) us[2]++;
                            } else {
                                if (uv[1] - uv[0] > 0.5F) uv[1]--;
                                else if (uv[0] - uv[1] > 0.5F) uv[1]++;
                                if (uv[2] - uv[0] > 0.5F) uv[2]--;
                                else if (uv[0] - uv[2] > 0.5F) uv[2]++;
                            }
                        }
                    }
                }
            }
        }
        if (!hasTextureCoords) texCoordU = texCoordV = null;
        if (mesh.vertexLabel != null && (functionMask & 0x20) != 0) anIntArrayArray5334 = mesh.method1100(true, -122);
        if (mesh.faceLabel != null && (functionMask & 0x180) != 0) anIntArrayArray5330 = mesh.method1094((byte) 30);
        if (mesh.billboards != null && (functionMask & 0x400) != 0) anIntArrayArray5379 = mesh.method1093((byte) -75);
        if (mesh.faceTexture != null) {
            faceTextures = new short[faceCount];
            boolean hasTextures = false;
            for (int i = 0; i < faceCount; i++) {
                short tex = mesh.faceTexture[i];
                if (tex != -1) {
                    TextureMetrics metrics = toolkit.aD4579.getMetrics(tex, -6662);
                    if ((featureMask & 0x40) == 0 || !metrics.disableable) {
                        faceTextures[i] = tex;
                        hasTextures = true;
                        if (metrics.alphaBlendMode == 2) transparent = true;
                        if (metrics.speedU != 0 || metrics.speedV != 0) movingTextures = true;
                    } else faceTextures[i] = (short) -1;
                } else faceTextures[i] = (short) -1;
            }
            if (!hasTextures) faceTextures = null;
        } else faceTextures = null;
        if (transparent || billboardFaces != null) {
            faceIndices = new short[faceCount];
            for (int i = 0; i < faceCount; i++)
                faceIndices[i] = (short) faceIndex[i];
        }
    }

    static {
        anInt5341 = 0;
        anInt5350 = 4096;
    }
}
