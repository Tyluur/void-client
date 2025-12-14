/* Class109 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Class109
final class Rasterizer {
    int minX;
    private final JavaToolkit aJavaToolkit_1666;
    boolean aBoolean1667 = false;
    int minY;
    boolean aBoolean1669;
    private final JavaThreadResource aJavaThreadResource_1670;
    boolean restrictEdges;
    int height;
    private final int[] raster;
    int alpha = 0;
    private boolean useExternalRenderer = false;
    int[] lineOffsets = new int[4096];
    private final float[] depthBuffer;
    private final int rasterWidth;
    int width;
    private final boolean aBoolean1680;
    private float aFloat1681;
    private float aFloat1682;
    private int textureAlphaBlendMode;
    private float aFloat1684;
    private int[] anIntArray1685;
    private int anInt1686;
    private final int anInt1687;
    private int anInt1688;
    private final int anInt1689;
    private int textureLastIndex;
    private int anInt1691;
    private int[] anIntArray1692;
    private int textureSize;
    private boolean repeatTexture;
    private int anInt1695;
    private int anInt1696;
    private final int anInt1697;
    private int[] texturePixels;

    // method1016
    private final void drawTexturedScanline(int[] is, int[] is_0_, int i, int i_1_, int i_2_, float f, float f_3_, float f_4_, float f_5_, float f_6_, float f_7_, float f_8_, float f_9_, float f_10_, float f_11_, float f_12_, float f_13_, float f_14_, float f_15_, float f_16_, float f_17_) {
        int i_18_ = i_2_ - i_1_;
        float f_19_ = 1.0F / (float) i_18_;
        float f_20_ = (f_3_ - f) * f_19_;
        float f_21_ = (f_5_ - f_4_) * f_19_;
        float f_22_ = (f_7_ - f_6_) * f_19_;
        float f_23_ = (f_9_ - f_8_) * f_19_;
        float f_24_ = (f_11_ - f_10_) * f_19_;
        float f_25_ = (f_13_ - f_12_) * f_19_;
        float f_26_ = (f_15_ - f_14_) * f_19_;
        float f_27_ = (f_17_ - f_16_) * f_19_;
        if (this.restrictEdges) {
            if (i_2_ > this.width) i_2_ = this.width;
            if (i_1_ < 0) {
                f -= f_20_ * (float) i_1_;
                f_4_ -= f_21_ * (float) i_1_;
                f_6_ -= f_22_ * (float) i_1_;
                f_8_ -= f_23_ * (float) i_1_;
                f_10_ -= f_24_ * (float) i_1_;
                f_12_ -= f_25_ * (float) i_1_;
                f_14_ -= f_26_ * (float) i_1_;
                f_16_ -= f_27_ * (float) i_1_;
                i_1_ = 0;
            }
        }
        if (i_1_ < i_2_) {
            i_18_ = i_2_ - i_1_;
            i += i_1_;
            while (i_18_-- > 0) {
                float f_28_ = 1.0F / f;
                if (f_28_ < depthBuffer[i]) {
                    int i_29_ = (int) (f_4_ * f_28_ * (float) textureSize);
                    if (repeatTexture) i_29_ &= textureLastIndex;
                    else if (i_29_ < 0) i_29_ = 0;
                    else if (i_29_ > textureLastIndex) i_29_ = textureLastIndex;
                    int i_30_ = (int) (f_6_ * f_28_ * (float) textureSize);
                    if (repeatTexture) i_30_ &= textureLastIndex;
                    else if (i_30_ < 0) i_30_ = 0;
                    else if (i_30_ > textureLastIndex) i_30_ = textureLastIndex;
                    int i_31_ = texturePixels[i_30_ * textureSize + i_29_];
                    int i_32_ = 255;
                    if (textureAlphaBlendMode == 2) i_32_ = i_31_ >> 24 & 0xff;
                    else if (textureAlphaBlendMode == 1) i_32_ = i_31_ == 0 ? 0 : 255;
                    else i_32_ = (int) f_10_;
                    if (i_32_ != 0) {
                        if (i_32_ == 255) {
                            int i_38_ = (~0xffffff | ((int) (f_12_ * (float) (i_31_ >> 16 & 0xff)) << 8 & 0xff0000) | (int) (f_14_ * (float) (i_31_ >> 8 & 0xff)) & 0xff00 | ((int) (f_16_ * (float) (i_31_ & 0xff)) >> 8));
                            if (f_8_ != 0.0F) {
                                int i_39_ = (int) (255.0F - f_8_);
                                int i_40_ = ((((anInt1696 & 0xff00ff) * (int) f_8_ & ~0xff00ff) | ((anInt1696 & 0xff00) * (int) f_8_ & 0xff0000)) >>> 8);
                                i_38_ = (((i_38_ & 0xff00ff) * i_39_ & ~0xff00ff | (i_38_ & 0xff00) * i_39_ & 0xff0000) >>> 8) + i_40_;
                            }
                            is[i] = i_38_;
                            depthBuffer[i] = f_28_;
                        } else {
                            int i_33_ = (~0xffffff | ((int) (f_12_ * (float) (i_31_ >> 16 & 0xff)) << 8 & 0xff0000) | (int) (f_14_ * (float) (i_31_ >> 8 & 0xff)) & 0xff00 | ((int) (f_16_ * (float) (i_31_ & 0xff)) >> 8));
                            if (f_8_ != 0.0F) {
                                int i_34_ = (int) (255.0F - f_8_);
                                int i_35_ = ((((anInt1696 & 0xff00ff) * (int) f_8_ & ~0xff00ff) | ((anInt1696 & 0xff00) * (int) f_8_ & 0xff0000)) >>> 8);
                                i_33_ = (((i_33_ & 0xff00ff) * i_34_ & ~0xff00ff | (i_33_ & 0xff00) * i_34_ & 0xff0000) >>> 8) + i_35_;
                            }
                            int i_36_ = is[i];
                            int i_37_ = 255 - i_32_;
                            i_33_ = ((((i_36_ & 0xff00ff) * i_37_ + (i_33_ & 0xff00ff) * i_32_) & ~0xff00ff) + (((i_36_ & 0xff00) * i_37_ + (i_33_ & 0xff00) * i_32_) & 0xff0000)) >> 8;
                            is[i] = i_33_;
                            depthBuffer[i] = f_28_;
                        }
                    }
                }
                i++;
                f += f_20_;
                f_4_ += f_21_;
                f_6_ += f_22_;
                f_8_ += f_23_;
                f_10_ += f_24_;
                f_12_ += f_25_;
                f_14_ += f_26_;
                f_16_ += f_27_;
            }
        }
    }

    final int method1017() {
        return this.lineOffsets[0] / rasterWidth;
    }

    // method1018
    final void drawColouredTriangle(float yA, float yB, float yC, float xA, float xB, float xC, float zA, float zB, float zC, int colour) {
        if (useExternalRenderer) {
            aJavaToolkit_1666.method3645((int) yA, (int) xA, (int) xB, -8003, colour, (int) yB);
            aJavaToolkit_1666.method3645((int) yB, (int) xB, (int) xC, -8003, colour, (int) yC);
            aJavaToolkit_1666.method3645((int) yC, (int) xC, (int) xA, -8003, colour, (int) yA);
        } else {
            float baX = xB - xA;
            float baY = yB - yA;
            float caX = xC - xA;
            float caY = yC - yA;
            float baZ = zB - zA;
            float caZ = zC - zA;
            float aToB = 0.0F;
            if (yB != yA) aToB = (xB - xA) / (yB - yA);
            float bToC = 0.0F;
            if (yC != yB) bToC = (xC - xB) / (yC - yB);
            float cToA = 0.0F;
            if (yC != yA) cToA = (xA - xC) / (yA - yC);
            float div = baX * caY - caX * baY;
            if (div != 0.0F) {
                float depthSlope = (baZ * caY - caZ * baY) / div;
                float depth_increment = (caZ * baX - baZ * caX) / div;
                if (yA <= yB && yA <= yC) {
                    if (!(yA >= (float) this.height)) {
                        if (yB > (float) this.height) yB = (float) this.height;
                        if (yC > (float) this.height) yC = (float) this.height;
                        zA = zA - depthSlope * xA + depthSlope;
                        if (yB < yC) {
                            xC = xA;
                            if (yA < 0.0F) {
                                xC -= cToA * yA;
                                xA -= aToB * yA;
                                zA -= depth_increment * yA;
                                yA = 0.0F;
                            }
                            if (yB < 0.0F) {
                                xB -= bToC * yB;
                                yB = 0.0F;
                            }
                            if (yA != yB && cToA < aToB || yA == yB && cToA > bToC) {
                                yC -= yB;
                                yB -= yA;
                                yA = (float) (this.lineOffsets[(int) yA]);
                                while (--yB >= 0.0F) {
                                    drawFlatScanLine(raster, depthBuffer, (int) yA, colour, 0, (int) xC, (int) xA, zA, depthSlope);
                                    xC += cToA;
                                    xA += aToB;
                                    zA += depth_increment;
                                    yA += (float) rasterWidth;
                                }
                                while (--yC >= 0.0F) {
                                    drawFlatScanLine(raster, depthBuffer, (int) yA, colour, 0, (int) xC, (int) xB, zA, depthSlope);
                                    xC += cToA;
                                    xB += bToC;
                                    zA += depth_increment;
                                    yA += (float) rasterWidth;
                                }
                            } else {
                                yC -= yB;
                                yB -= yA;
                                yA = (float) (this.lineOffsets[(int) yA]);
                                while (--yB >= 0.0F) {
                                    drawFlatScanLine(raster, depthBuffer, (int) yA, colour, 0, (int) xA, (int) xC, zA, depthSlope);
                                    xC += cToA;
                                    xA += aToB;
                                    zA += depth_increment;
                                    yA += (float) rasterWidth;
                                }
                                while (--yC >= 0.0F) {
                                    drawFlatScanLine(raster, depthBuffer, (int) yA, colour, 0, (int) xB, (int) xC, zA, depthSlope);
                                    xC += cToA;
                                    xB += bToC;
                                    zA += depth_increment;
                                    yA += (float) rasterWidth;
                                }
                            }
                        } else {
                            xB = xA;
                            if (yA < 0.0F) {
                                xB -= cToA * yA;
                                xA -= aToB * yA;
                                zA -= depth_increment * yA;
                                yA = 0.0F;
                            }
                            if (yC < 0.0F) {
                                xC -= bToC * yC;
                                yC = 0.0F;
                            }
                            if (yA != yC && cToA < aToB || yA == yC && bToC > aToB) {
                                yB -= yC;
                                yC -= yA;
                                yA = (float) (this.lineOffsets[(int) yA]);
                                while (--yC >= 0.0F) {
                                    drawFlatScanLine(raster, depthBuffer, (int) yA, colour, 0, (int) xB, (int) xA, zA, depthSlope);
                                    xB += cToA;
                                    xA += aToB;
                                    zA += depth_increment;
                                    yA += (float) rasterWidth;
                                }
                                while (--yB >= 0.0F) {
                                    drawFlatScanLine(raster, depthBuffer, (int) yA, colour, 0, (int) xC, (int) xA, zA, depthSlope);
                                    xC += bToC;
                                    xA += aToB;
                                    zA += depth_increment;
                                    yA += (float) rasterWidth;
                                }
                            } else {
                                yB -= yC;
                                yC -= yA;
                                yA = (float) (this.lineOffsets[(int) yA]);
                                while (--yC >= 0.0F) {
                                    drawFlatScanLine(raster, depthBuffer, (int) yA, colour, 0, (int) xA, (int) xB, zA, depthSlope);
                                    xB += cToA;
                                    xA += aToB;
                                    zA += depth_increment;
                                    yA += (float) rasterWidth;
                                }
                                while (--yB >= 0.0F) {
                                    drawFlatScanLine(raster, depthBuffer, (int) yA, colour, 0, (int) xA, (int) xC, zA, depthSlope);
                                    xC += bToC;
                                    xA += aToB;
                                    zA += depth_increment;
                                    yA += (float) rasterWidth;
                                }
                            }
                        }
                    }
                } else if (yB <= yC) {
                    if (!(yB >= (float) this.height)) {
                        if (yC > (float) this.height) yC = (float) this.height;
                        if (yA > (float) this.height) yA = (float) this.height;
                        zB = zB - depthSlope * xB + depthSlope;
                        if (yC < yA) {
                            xA = xB;
                            if (yB < 0.0F) {
                                xA -= aToB * yB;
                                xB -= bToC * yB;
                                zB -= depth_increment * yB;
                                yB = 0.0F;
                            }
                            if (yC < 0.0F) {
                                xC -= cToA * yC;
                                yC = 0.0F;
                            }
                            if (yB != yC && aToB < bToC || yB == yC && aToB > cToA) {
                                yA -= yC;
                                yC -= yB;
                                yB = (float) (this.lineOffsets[(int) yB]);
                                while (--yC >= 0.0F) {
                                    drawFlatScanLine(raster, depthBuffer, (int) yB, colour, 0, (int) xA, (int) xB, zB, depthSlope);
                                    xA += aToB;
                                    xB += bToC;
                                    zB += depth_increment;
                                    yB += (float) rasterWidth;
                                }
                                while (--yA >= 0.0F) {
                                    drawFlatScanLine(raster, depthBuffer, (int) yB, colour, 0, (int) xA, (int) xC, zB, depthSlope);
                                    xA += aToB;
                                    xC += cToA;
                                    zB += depth_increment;
                                    yB += (float) rasterWidth;
                                }
                            } else {
                                yA -= yC;
                                yC -= yB;
                                yB = (float) (this.lineOffsets[(int) yB]);
                                while (--yC >= 0.0F) {
                                    drawFlatScanLine(raster, depthBuffer, (int) yB, colour, 0, (int) xB, (int) xA, zB, depthSlope);
                                    xA += aToB;
                                    xB += bToC;
                                    zB += depth_increment;
                                    yB += (float) rasterWidth;
                                }
                                while (--yA >= 0.0F) {
                                    drawFlatScanLine(raster, depthBuffer, (int) yB, colour, 0, (int) xC, (int) xA, zB, depthSlope);
                                    xA += aToB;
                                    xC += cToA;
                                    zB += depth_increment;
                                    yB += (float) rasterWidth;
                                }
                            }
                        } else {
                            xC = xB;
                            if (yB < 0.0F) {
                                xC -= aToB * yB;
                                xB -= bToC * yB;
                                zB -= depth_increment * yB;
                                yB = 0.0F;
                            }
                            if (yA < 0.0F) {
                                xA -= cToA * yA;
                                yA = 0.0F;
                            }
                            if (aToB < bToC) {
                                yC -= yA;
                                yA -= yB;
                                yB = (float) (this.lineOffsets[(int) yB]);
                                while (--yA >= 0.0F) {
                                    drawFlatScanLine(raster, depthBuffer, (int) yB, colour, 0, (int) xC, (int) xB, zB, depthSlope);
                                    xC += aToB;
                                    xB += bToC;
                                    zB += depth_increment;
                                    yB += (float) rasterWidth;
                                }
                                while (--yC >= 0.0F) {
                                    drawFlatScanLine(raster, depthBuffer, (int) yB, colour, 0, (int) xA, (int) xB, zB, depthSlope);
                                    xA += cToA;
                                    xB += bToC;
                                    zB += depth_increment;
                                    yB += (float) rasterWidth;
                                }
                            } else {
                                yC -= yA;
                                yA -= yB;
                                yB = (float) (this.lineOffsets[(int) yB]);
                                while (--yA >= 0.0F) {
                                    drawFlatScanLine(raster, depthBuffer, (int) yB, colour, 0, (int) xB, (int) xC, zB, depthSlope);
                                    xC += aToB;
                                    xB += bToC;
                                    zB += depth_increment;
                                    yB += (float) rasterWidth;
                                }
                                while (--yC >= 0.0F) {
                                    drawFlatScanLine(raster, depthBuffer, (int) yB, colour, 0, (int) xB, (int) xA, zB, depthSlope);
                                    xA += cToA;
                                    xB += bToC;
                                    zB += depth_increment;
                                    yB += (float) rasterWidth;
                                }
                            }
                        }
                    }
                } else if (!(yC >= (float) this.height)) {
                    if (yA > (float) this.height) yA = (float) this.height;
                    if (yB > (float) this.height) yB = (float) this.height;
                    zC = zC - depthSlope * xC + depthSlope;
                    if (yA < yB) {
                        xB = xC;
                        if (yC < 0.0F) {
                            xB -= bToC * yC;
                            xC -= cToA * yC;
                            zC -= depth_increment * yC;
                            yC = 0.0F;
                        }
                        if (yA < 0.0F) {
                            xA -= aToB * yA;
                            yA = 0.0F;
                        }
                        if (bToC < cToA) {
                            yB -= yA;
                            yA -= yC;
                            yC = (float) (this.lineOffsets[(int) yC]);
                            while (--yA >= 0.0F) {
                                drawFlatScanLine(raster, depthBuffer, (int) yC, colour, 0, (int) xB, (int) xC, zC, depthSlope);
                                xB += bToC;
                                xC += cToA;
                                zC += depth_increment;
                                yC += (float) rasterWidth;
                            }
                            while (--yB >= 0.0F) {
                                drawFlatScanLine(raster, depthBuffer, (int) yC, colour, 0, (int) xB, (int) xA, zC, depthSlope);
                                xB += bToC;
                                xA += aToB;
                                zC += depth_increment;
                                yC += (float) rasterWidth;
                            }
                        } else {
                            yB -= yA;
                            yA -= yC;
                            yC = (float) (this.lineOffsets[(int) yC]);
                            while (--yA >= 0.0F) {
                                drawFlatScanLine(raster, depthBuffer, (int) yC, colour, 0, (int) xC, (int) xB, zC, depthSlope);
                                xB += bToC;
                                xC += cToA;
                                zC += depth_increment;
                                yC += (float) rasterWidth;
                            }
                            while (--yB >= 0.0F) {
                                drawFlatScanLine(raster, depthBuffer, (int) yC, colour, 0, (int) xA, (int) xB, zC, depthSlope);
                                xB += bToC;
                                xA += aToB;
                                zC += depth_increment;
                                yC += (float) rasterWidth;
                            }
                        }
                    } else {
                        xA = xC;
                        if (yC < 0.0F) {
                            xA -= bToC * yC;
                            xC -= cToA * yC;
                            zC -= depth_increment * yC;
                            yC = 0.0F;
                        }
                        if (yB < 0.0F) {
                            xB -= aToB * yB;
                            yB = 0.0F;
                        }
                        if (bToC < cToA) {
                            yA -= yB;
                            yB -= yC;
                            yC = (float) (this.lineOffsets[(int) yC]);
                            while (--yB >= 0.0F) {
                                drawFlatScanLine(raster, depthBuffer, (int) yC, colour, 0, (int) xA, (int) xC, zC, depthSlope);
                                xA += bToC;
                                xC += cToA;
                                zC += depth_increment;
                                yC += (float) rasterWidth;
                            }
                            while (--yA >= 0.0F) {
                                drawFlatScanLine(raster, depthBuffer, (int) yC, colour, 0, (int) xB, (int) xC, zC, depthSlope);
                                xB += aToB;
                                xC += cToA;
                                zC += depth_increment;
                                yC += (float) rasterWidth;
                            }
                        } else {
                            yA -= yB;
                            yB -= yC;
                            yC = (float) (this.lineOffsets[(int) yC]);
                            while (--yB >= 0.0F) {
                                drawFlatScanLine(raster, depthBuffer, (int) yC, colour, 0, (int) xC, (int) xA, zC, depthSlope);
                                xA += bToC;
                                xC += cToA;
                                zC += depth_increment;
                                yC += (float) rasterWidth;
                            }
                            while (--yA >= 0.0F) {
                                drawFlatScanLine(raster, depthBuffer, (int) yC, colour, 0, (int) xC, (int) xB, zC, depthSlope);
                                xB += aToB;
                                xC += cToA;
                                zC += depth_increment;
                                yC += (float) rasterWidth;
                            }
                        }
                    }
                }
            }
        }
    }

    // method1019
    private final void drawGoraudScanline(int[] is, float[] fs, int i, int i_61_, int i_62_, int i_63_, int i_64_, float f, float f_65_, float f_66_, float f_67_) {
        if (this.restrictEdges) {
            if (i_64_ > this.width) i_64_ = this.width;
            if (i_63_ < 0) i_63_ = 0;
        }
        if (i_63_ < i_64_) {
            i += i_63_ - 1;
            f += f_65_ * (float) i_63_;
            f_66_ += f_67_ * (float) i_63_;
            if (aJavaThreadResource_1670.aBoolean2202) {
                do {
                    if (this.aBoolean1669) {
                        i_62_ = i_64_ - i_63_ >> 2;
                        f_65_ *= 4.0F;
                        if (this.alpha == 0) {
                            if (i_62_ > 0) {
                                do {
                                    i_61_ = Class126.HSV_TO_RGB[(int) f];
                                    f += f_65_;
                                    if (f_66_ < fs[++i]) {
                                        is[i] = i_61_;
                                        fs[i] = f_66_;
                                    }
                                    f_66_ += f_67_;
                                    if (f_66_ < fs[++i]) {
                                        is[i] = i_61_;
                                        fs[i] = f_66_;
                                    }
                                    f_66_ += f_67_;
                                    if (f_66_ < fs[++i]) {
                                        is[i] = i_61_;
                                        fs[i] = f_66_;
                                    }
                                    f_66_ += f_67_;
                                    if (f_66_ < fs[++i]) {
                                        is[i] = i_61_;
                                        fs[i] = f_66_;
                                    }
                                    f_66_ += f_67_;
                                } while (--i_62_ > 0);
                            }
                            i_62_ = i_64_ - i_63_ & 0x3;
                            if (i_62_ > 0) {
                                i_61_ = Class126.HSV_TO_RGB[(int) f];
                                do {
                                    if (f_66_ < fs[++i]) {
                                        is[i] = i_61_;
                                        fs[i] = f_66_;
                                    }
                                    f_66_ += f_67_;
                                } while (--i_62_ > 0);
                            }
                        } else {
                            int i_68_ = this.alpha;
                            int i_69_ = 256 - this.alpha;
                            if (i_62_ > 0) {
                                do {
                                    i_61_ = Class126.HSV_TO_RGB[(int) f];
                                    f += f_65_;
                                    i_61_ = (((i_61_ & 0xff00ff) * i_69_ >> 8 & 0xff00ff) + ((i_61_ & 0xff00) * i_69_ >> 8 & 0xff00));
                                    if (f_66_ < fs[++i]) {
                                        int i_70_ = is[i];
                                        is[i] = (i_61_ + (((i_70_ & 0xff00ff) * i_68_ >> 8) & 0xff00ff) + ((i_70_ & 0xff00) * i_68_ >> 8 & 0xff00));
                                        fs[i] = f_66_;
                                    }
                                    f_66_ += f_67_;
                                    if (f_66_ < fs[++i]) {
                                        int i_71_ = is[i];
                                        is[i] = (i_61_ + (((i_71_ & 0xff00ff) * i_68_ >> 8) & 0xff00ff) + ((i_71_ & 0xff00) * i_68_ >> 8 & 0xff00));
                                        fs[i] = f_66_;
                                    }
                                    f_66_ += f_67_;
                                    if (f_66_ < fs[++i]) {
                                        int i_72_ = is[i];
                                        is[i] = (i_61_ + (((i_72_ & 0xff00ff) * i_68_ >> 8) & 0xff00ff) + ((i_72_ & 0xff00) * i_68_ >> 8 & 0xff00));
                                        fs[i] = f_66_;
                                    }
                                    f_66_ += f_67_;
                                    if (f_66_ < fs[++i]) {
                                        int i_73_ = is[i];
                                        is[i] = (i_61_ + (((i_73_ & 0xff00ff) * i_68_ >> 8) & 0xff00ff) + ((i_73_ & 0xff00) * i_68_ >> 8 & 0xff00));
                                        fs[i] = f_66_;
                                    }
                                    f_66_ += f_67_;
                                } while (--i_62_ > 0);
                            }
                            i_62_ = i_64_ - i_63_ & 0x3;
                            if (i_62_ <= 0) break;
                            i_61_ = Class126.HSV_TO_RGB[(int) f];
                            i_61_ = (((i_61_ & 0xff00ff) * i_69_ >> 8 & 0xff00ff) + ((i_61_ & 0xff00) * i_69_ >> 8 & 0xff00));
                            do {
                                if (f_66_ < fs[++i]) {
                                    int i_74_ = is[i];
                                    is[i] = (i_61_ + ((i_74_ & 0xff00ff) * i_68_ >> 8 & 0xff00ff) + ((i_74_ & 0xff00) * i_68_ >> 8 & 0xff00));
                                    fs[i] = f_66_;
                                }
                                f_66_ += f_67_;
                            } while (--i_62_ > 0);
                        }
                        break;
                    }
                    i_62_ = i_64_ - i_63_;
                    if (this.alpha == 0) {
                        do {
                            if (f_66_ < fs[++i]) {
                                is[i] = Class126.HSV_TO_RGB[(int) f];
                                fs[i] = f_66_;
                            }
                            f_66_ += f_67_;
                            f += f_65_;
                        } while (--i_62_ > 0);
                        break;
                    }
                    int i_75_ = this.alpha;
                    int i_76_ = 256 - this.alpha;
                    do {
                        if (f_66_ < fs[++i]) {
                            i_61_ = Class126.HSV_TO_RGB[(int) f];
                            i_61_ = (((i_61_ & 0xff00ff) * i_76_ >> 8 & 0xff00ff) + ((i_61_ & 0xff00) * i_76_ >> 8 & 0xff00));
                            int i_77_ = is[i];
                            is[i] = (i_61_ + ((i_77_ & 0xff00ff) * i_75_ >> 8 & 0xff00ff) + ((i_77_ & 0xff00) * i_75_ >> 8 & 0xff00));
                            fs[i] = f_66_;
                        }
                        f += f_65_;
                        f_66_ += f_67_;
                    } while (--i_62_ > 0);
                } while (false);
            } else {
                do {
                    if (this.aBoolean1669) {
                        i_62_ = i_64_ - i_63_ >> 2;
                        f_65_ *= 4.0F;
                        if (this.alpha == 0) {
                            if (i_62_ > 0) {
                                do {
                                    i_61_ = Class126.HSV_TO_RGB[(int) f];
                                    f += f_65_;
                                    if (f_66_ < fs[++i]) is[i] = i_61_;
                                    f_66_ += f_67_;
                                    if (f_66_ < fs[++i]) is[i] = i_61_;
                                    f_66_ += f_67_;
                                    if (f_66_ < fs[++i]) is[i] = i_61_;
                                    f_66_ += f_67_;
                                    if (f_66_ < fs[++i]) is[i] = i_61_;
                                    f_66_ += f_67_;
                                } while (--i_62_ > 0);
                            }
                            i_62_ = i_64_ - i_63_ & 0x3;
                            if (i_62_ > 0) {
                                i_61_ = Class126.HSV_TO_RGB[(int) f];
                                do {
                                    if (f_66_ < fs[++i]) is[i] = i_61_;
                                    f_66_ += f_67_;
                                } while (--i_62_ > 0);
                            }
                        } else {
                            int i_78_ = this.alpha;
                            int i_79_ = 256 - this.alpha;
                            if (i_62_ > 0) {
                                do {
                                    i_61_ = Class126.HSV_TO_RGB[(int) f];
                                    f += f_65_;
                                    i_61_ = (((i_61_ & 0xff00ff) * i_79_ >> 8 & 0xff00ff) + ((i_61_ & 0xff00) * i_79_ >> 8 & 0xff00));
                                    if (f_66_ < fs[++i]) {
                                        int i_80_ = is[i];
                                        is[i] = (i_61_ + (((i_80_ & 0xff00ff) * i_78_ >> 8) & 0xff00ff) + ((i_80_ & 0xff00) * i_78_ >> 8 & 0xff00));
                                    }
                                    f_66_ += f_67_;
                                    if (f_66_ < fs[++i]) {
                                        int i_81_ = is[i];
                                        is[i] = (i_61_ + (((i_81_ & 0xff00ff) * i_78_ >> 8) & 0xff00ff) + ((i_81_ & 0xff00) * i_78_ >> 8 & 0xff00));
                                    }
                                    f_66_ += f_67_;
                                    if (f_66_ < fs[++i]) {
                                        int i_82_ = is[i];
                                        is[i] = (i_61_ + (((i_82_ & 0xff00ff) * i_78_ >> 8) & 0xff00ff) + ((i_82_ & 0xff00) * i_78_ >> 8 & 0xff00));
                                    }
                                    f_66_ += f_67_;
                                    if (f_66_ < fs[++i]) {
                                        int i_83_ = is[i];
                                        is[i] = (i_61_ + (((i_83_ & 0xff00ff) * i_78_ >> 8) & 0xff00ff) + ((i_83_ & 0xff00) * i_78_ >> 8 & 0xff00));
                                    }
                                    f_66_ += f_67_;
                                } while (--i_62_ > 0);
                            }
                            i_62_ = i_64_ - i_63_ & 0x3;
                            if (i_62_ <= 0) break;
                            i_61_ = Class126.HSV_TO_RGB[(int) f];
                            i_61_ = (((i_61_ & 0xff00ff) * i_79_ >> 8 & 0xff00ff) + ((i_61_ & 0xff00) * i_79_ >> 8 & 0xff00));
                            do {
                                if (f_66_ < fs[++i]) {
                                    int i_84_ = is[i];
                                    is[i] = (i_61_ + ((i_84_ & 0xff00ff) * i_78_ >> 8 & 0xff00ff) + ((i_84_ & 0xff00) * i_78_ >> 8 & 0xff00));
                                }
                                f_66_ += f_67_;
                            } while (--i_62_ > 0);
                        }
                        break;
                    }
                    i_62_ = i_64_ - i_63_;
                    if (this.alpha == 0) {
                        do {
                            if (f_66_ < fs[++i]) is[i] = Class126.HSV_TO_RGB[(int) f];
                            f_66_ += f_67_;
                            f += f_65_;
                        } while (--i_62_ > 0);
                        break;
                    }
                    int i_85_ = this.alpha;
                    int i_86_ = 256 - this.alpha;
                    do {
                        if (f_66_ < fs[++i]) {
                            i_61_ = Class126.HSV_TO_RGB[(int) f];
                            i_61_ = (((i_61_ & 0xff00ff) * i_86_ >> 8 & 0xff00ff) + ((i_61_ & 0xff00) * i_86_ >> 8 & 0xff00));
                            int i_87_ = is[i];
                            is[i] = (i_61_ + ((i_87_ & 0xff00ff) * i_85_ >> 8 & 0xff00ff) + ((i_87_ & 0xff00) * i_85_ >> 8 & 0xff00));
                        }
                        f += f_65_;
                        f_66_ += f_67_;
                    } while (--i_62_ > 0);
                } while (false);
            }
        }
    }

    final void method1020(float f, float f_88_, float f_89_, float f_90_, float f_91_, float f_92_, float f_93_, float f_94_, float f_95_, float f_96_, float f_97_, float f_98_, float f_99_, float f_100_, float f_101_, int i, int i_102_, int i_103_, int i_104_, int i_105_, int i_106_, int i_107_, int i_108_, float f_109_, int i_110_, float f_111_, int i_112_, float f_113_) {
        if (i_108_ != anInt1697) {
            texturePixels = aJavaToolkit_1666.method3718(i_108_);
            if (texturePixels == null) {
                renderTriangleRgb((float) (int) f, (float) (int) f_88_, (float) (int) f_89_, (float) (int) f_90_, (float) (int) f_91_, (float) (int) f_92_, (float) (int) f_93_, (float) (int) f_94_, (float) (int) f_95_, JavaBillboardFace.method206(i, i_104_ | i_105_ << 24, 255), JavaBillboardFace.method206(i_102_, i_104_ | i_106_ << 24, 255), JavaBillboardFace.method206(i_103_, i_104_ | i_107_ << 24, 255));
                return;
            }
            textureSize = (aJavaToolkit_1666.smallTexture(i_108_) ? 64 : aJavaToolkit_1666.textureSize);
            textureLastIndex = textureSize - 1;
            textureAlphaBlendMode = aJavaToolkit_1666.textureAlphaBlendMode(i_108_);
        }
        aFloat1681 = f_109_;
        if (i_110_ != anInt1689) {
            anIntArray1685 = aJavaToolkit_1666.method3718(i_110_);
            if (anIntArray1685 == null) {
                renderTriangleRgb((float) (int) f, (float) (int) f_88_, (float) (int) f_89_, (float) (int) f_90_, (float) (int) f_91_, (float) (int) f_92_, (float) (int) f_93_, (float) (int) f_94_, (float) (int) f_95_, JavaBillboardFace.method206(i, i_104_ | i_105_ << 24, 255), JavaBillboardFace.method206(i_102_, i_104_ | i_106_ << 24, 255), JavaBillboardFace.method206(i_103_, i_104_ | i_107_ << 24, 255));
                return;
            }
            anInt1691 = (aJavaToolkit_1666.smallTexture(i_110_) ? 64 : aJavaToolkit_1666.textureSize);
            anInt1686 = anInt1691 - 1;
        }
        aFloat1684 = f_111_;
        if (i_112_ != anInt1687) {
            anIntArray1692 = aJavaToolkit_1666.method3718(i_112_);
            if (anIntArray1692 == null) {
                renderTriangleRgb((float) (int) f, (float) (int) f_88_, (float) (int) f_89_, (float) (int) f_90_, (float) (int) f_91_, (float) (int) f_92_, (float) (int) f_93_, (float) (int) f_94_, (float) (int) f_95_, JavaBillboardFace.method206(i, i_104_ | i_105_ << 24, 255), JavaBillboardFace.method206(i_102_, i_104_ | i_106_ << 24, 255), JavaBillboardFace.method206(i_103_, i_104_ | i_107_ << 24, 255));
                return;
            }
            anInt1695 = (aJavaToolkit_1666.smallTexture(i_112_) ? 64 : aJavaToolkit_1666.textureSize);
            anInt1688 = anInt1695 - 1;
        }
        aFloat1682 = f_113_;
        anInt1696 = i_104_;
        float f_114_ = (float) (i >> 24 & 0xff);
        float f_115_ = (float) (i_102_ >> 24 & 0xff);
        float f_116_ = (float) (i_103_ >> 24 & 0xff);
        float f_117_ = (float) (i >> 16 & 0xff);
        float f_118_ = (float) (i_102_ >> 16 & 0xff);
        float f_119_ = (float) (i_103_ >> 16 & 0xff);
        float f_120_ = (float) (i >> 8 & 0xff);
        float f_121_ = (float) (i_102_ >> 8 & 0xff);
        float f_122_ = (float) (i_103_ >> 8 & 0xff);
        float f_123_ = (float) (i & 0xff);
        float f_124_ = (float) (i_102_ & 0xff);
        float f_125_ = (float) (i_103_ & 0xff);
        f_96_ /= f_93_;
        f_97_ /= f_94_;
        f_98_ /= f_95_;
        f_99_ /= f_93_;
        f_100_ /= f_94_;
        f_101_ /= f_95_;
        f_93_ = 1.0F / f_93_;
        f_94_ = 1.0F / f_94_;
        f_95_ = 1.0F / f_95_;
        float f_126_ = 1.0F;
        float f_127_ = 0.0F;
        float f_128_ = 0.0F;
        float f_129_ = 0.0F;
        float f_130_ = 1.0F;
        float f_131_ = 0.0F;
        float f_132_ = 0.0F;
        float f_133_ = 0.0F;
        float f_134_ = 0.0F;
        float f_135_ = 0.0F;
        float f_136_ = 0.0F;
        float f_137_ = 0.0F;
        float f_138_ = 0.0F;
        float f_139_ = 0.0F;
        float f_140_ = 0.0F;
        float f_141_ = 0.0F;
        float f_142_ = 0.0F;
        if (f_88_ != f) {
            float f_143_ = f_88_ - f;
            f_132_ = (f_91_ - f_90_) / f_143_;
            f_133_ = (f_94_ - f_93_) / f_143_;
            f_134_ = (f_97_ - f_96_) / f_143_;
            f_135_ = (f_100_ - f_99_) / f_143_;
            f_136_ = (float) (i_106_ - i_105_) / f_143_;
            f_137_ = (f_115_ - f_114_) / f_143_;
            f_138_ = (f_118_ - f_117_) / f_143_;
            f_139_ = (f_121_ - f_120_) / f_143_;
            f_140_ = (f_124_ - f_123_) / f_143_;
            f_141_ = (f_127_ - f_126_) / f_143_;
            f_142_ = (f_130_ - f_129_) / f_143_;
        }
        float f_144_ = 0.0F;
        float f_145_ = 0.0F;
        float f_146_ = 0.0F;
        float f_147_ = 0.0F;
        float f_148_ = 0.0F;
        float f_149_ = 0.0F;
        float f_150_ = 0.0F;
        float f_151_ = 0.0F;
        float f_152_ = 0.0F;
        float f_153_ = 0.0F;
        float f_154_ = 0.0F;
        if (f_89_ != f_88_) {
            float f_155_ = f_89_ - f_88_;
            f_144_ = (f_92_ - f_91_) / f_155_;
            f_145_ = (f_95_ - f_94_) / f_155_;
            f_146_ = (f_98_ - f_97_) / f_155_;
            f_147_ = (f_101_ - f_100_) / f_155_;
            f_148_ = (float) (i_107_ - i_106_) / f_155_;
            f_149_ = (f_116_ - f_115_) / f_155_;
            f_150_ = (f_119_ - f_118_) / f_155_;
            f_151_ = (f_122_ - f_121_) / f_155_;
            f_152_ = (f_125_ - f_124_) / f_155_;
            f_153_ = (f_128_ - f_127_) / f_155_;
            f_154_ = (f_131_ - f_130_) / f_155_;
        }
        float f_156_ = 0.0F;
        float f_157_ = 0.0F;
        float f_158_ = 0.0F;
        float f_159_ = 0.0F;
        float f_160_ = 0.0F;
        float f_161_ = 0.0F;
        float f_162_ = 0.0F;
        float f_163_ = 0.0F;
        float f_164_ = 0.0F;
        float f_165_ = 0.0F;
        float f_166_ = 0.0F;
        if (f != f_89_) {
            float f_167_ = f - f_89_;
            f_156_ = (f_90_ - f_92_) / f_167_;
            f_157_ = (f_93_ - f_95_) / f_167_;
            f_158_ = (f_96_ - f_98_) / f_167_;
            f_159_ = (f_99_ - f_101_) / f_167_;
            f_160_ = (float) (i_105_ - i_107_) / f_167_;
            f_161_ = (f_114_ - f_116_) / f_167_;
            f_162_ = (f_117_ - f_119_) / f_167_;
            f_163_ = (f_120_ - f_122_) / f_167_;
            f_164_ = (f_123_ - f_125_) / f_167_;
            f_165_ = (f_126_ - f_128_) / f_167_;
            f_166_ = (f_129_ - f_131_) / f_167_;
        }
        if (f <= f_88_ && f <= f_89_) {
            if (!(f >= (float) this.height)) {
                if (f_88_ > (float) this.height) f_88_ = (float) this.height;
                if (f_89_ > (float) this.height) f_89_ = (float) this.height;
                if (f_88_ < f_89_) {
                    f_92_ = f_90_;
                    f_95_ = f_93_;
                    f_98_ = f_96_;
                    f_101_ = f_99_;
                    i_107_ = i_105_;
                    f_116_ = f_114_;
                    f_119_ = f_117_;
                    f_122_ = f_120_;
                    f_125_ = f_123_;
                    f_128_ = f_126_;
                    f_131_ = f_129_;
                    if (f < 0.0F) {
                        f_90_ -= f_132_ * f;
                        f_92_ -= f_156_ * f;
                        f_93_ -= f_133_ * f;
                        f_95_ -= f_157_ * f;
                        f_96_ -= f_134_ * f;
                        f_98_ -= f_158_ * f;
                        f_99_ -= f_135_ * f;
                        f_101_ -= f_159_ * f;
                        i_105_ -= f_136_ * f;
                        i_107_ -= f_160_ * f;
                        f_114_ -= f_137_ * f;
                        f_116_ -= f_161_ * f;
                        f_117_ -= f_138_ * f;
                        f_119_ -= f_162_ * f;
                        f_120_ -= f_139_ * f;
                        f_122_ -= f_163_ * f;
                        f_123_ -= f_140_ * f;
                        f_125_ -= f_164_ * f;
                        f_126_ -= f_141_ * f;
                        f_128_ -= f_165_ * f;
                        f_129_ -= f_142_ * f;
                        f_131_ -= f_166_ * f;
                        f = 0.0F;
                    }
                    if (f_88_ < 0.0F) {
                        f_91_ -= f_144_ * f_88_;
                        f_94_ -= f_145_ * f_88_;
                        f_97_ -= f_146_ * f_88_;
                        f_100_ -= f_147_ * f_88_;
                        i_106_ -= f_148_ * f_88_;
                        f_115_ -= f_149_ * f_88_;
                        f_118_ -= f_150_ * f_88_;
                        f_121_ -= f_151_ * f_88_;
                        f_124_ -= f_152_ * f_88_;
                        f_127_ -= f_153_ * f_88_;
                        f_130_ -= f_154_ * f_88_;
                        f_88_ = 0.0F;
                    }
                    if (f != f_88_ && f_156_ < f_132_ || f == f_88_ && f_156_ > f_144_) {
                        f_89_ -= f_88_;
                        f_88_ -= f;
                        f = (float) this.lineOffsets[(int) f];
                        while (--f_88_ >= 0.0F) {
                            method1025(raster, texturePixels, (int) f, (int) f_92_, (int) f_90_, f_95_, f_93_, f_98_, f_96_, f_101_, f_99_, (float) i_107_, (float) i_105_, f_116_, f_114_, f_119_, f_117_, f_122_, f_120_, f_125_, f_123_, f_128_, f_126_, f_131_, f_129_);
                            f_90_ += f_132_;
                            f_92_ += f_156_;
                            f_93_ += f_133_;
                            f_95_ += f_157_;
                            f_96_ += f_134_;
                            f_98_ += f_158_;
                            f_99_ += f_135_;
                            f_101_ += f_159_;
                            i_105_ += f_136_;
                            i_107_ += f_160_;
                            f_114_ += f_137_;
                            f_116_ += f_161_;
                            f_117_ += f_138_;
                            f_119_ += f_162_;
                            f_120_ += f_139_;
                            f_122_ += f_163_;
                            f_123_ += f_140_;
                            f_125_ += f_164_;
                            f_126_ += f_141_;
                            f_128_ += f_165_;
                            f_129_ += f_142_;
                            f_131_ += f_142_;
                            f += (float) rasterWidth;
                        }
                        while (--f_89_ >= 0.0F) {
                            method1025(raster, texturePixels, (int) f, (int) f_92_, (int) f_91_, f_95_, f_94_, f_98_, f_97_, f_101_, f_100_, (float) i_107_, (float) i_106_, f_116_, f_115_, f_119_, f_118_, f_122_, f_121_, f_125_, f_124_, f_128_, f_127_, f_131_, f_130_);
                            f_91_ += f_144_;
                            f_92_ += f_156_;
                            f_94_ += f_145_;
                            f_95_ += f_157_;
                            f_97_ += f_146_;
                            f_98_ += f_158_;
                            f_100_ += f_147_;
                            f_101_ += f_159_;
                            i_106_ += f_148_;
                            i_107_ += f_160_;
                            f_115_ += f_149_;
                            f_116_ += f_161_;
                            f_118_ += f_150_;
                            f_119_ += f_162_;
                            f_121_ += f_151_;
                            f_122_ += f_163_;
                            f_124_ += f_152_;
                            f_125_ += f_164_;
                            f_127_ += f_153_;
                            f_128_ += f_165_;
                            f_130_ += f_154_;
                            f_131_ += f_166_;
                            f += (float) rasterWidth;
                        }
                    } else {
                        f_89_ -= f_88_;
                        f_88_ -= f;
                        f = (float) this.lineOffsets[(int) f];
                        while (--f_88_ >= 0.0F) {
                            method1025(raster, texturePixels, (int) f, (int) f_90_, (int) f_92_, f_93_, f_95_, f_96_, f_98_, f_99_, f_101_, (float) i_105_, (float) i_107_, f_114_, f_116_, f_117_, f_119_, f_120_, f_122_, f_123_, f_125_, f_126_, f_128_, f_129_, f_131_);
                            f_90_ += f_132_;
                            f_92_ += f_156_;
                            f_93_ += f_133_;
                            f_95_ += f_157_;
                            f_96_ += f_134_;
                            f_98_ += f_158_;
                            f_99_ += f_135_;
                            f_101_ += f_159_;
                            i_105_ += f_136_;
                            i_107_ += f_160_;
                            f_114_ += f_137_;
                            f_116_ += f_161_;
                            f_117_ += f_138_;
                            f_119_ += f_162_;
                            f_120_ += f_139_;
                            f_122_ += f_163_;
                            f_123_ += f_140_;
                            f_125_ += f_164_;
                            f_126_ += f_141_;
                            f_128_ += f_165_;
                            f_129_ += f_142_;
                            f_131_ += f_166_;
                            f += (float) rasterWidth;
                        }
                        while (--f_89_ >= 0.0F) {
                            method1025(raster, texturePixels, (int) f, (int) f_91_, (int) f_92_, f_94_, f_95_, f_97_, f_98_, f_100_, f_101_, (float) i_106_, (float) i_107_, f_115_, f_116_, f_118_, f_119_, f_121_, f_122_, f_124_, f_125_, f_127_, f_128_, f_130_, f_131_);
                            f_91_ += f_144_;
                            f_92_ += f_156_;
                            f_94_ += f_145_;
                            f_95_ += f_157_;
                            f_97_ += f_146_;
                            f_98_ += f_158_;
                            f_100_ += f_147_;
                            f_101_ += f_159_;
                            i_106_ += f_148_;
                            i_107_ += f_160_;
                            f_115_ += f_149_;
                            f_116_ += f_161_;
                            f_118_ += f_150_;
                            f_119_ += f_162_;
                            f_121_ += f_151_;
                            f_122_ += f_163_;
                            f_124_ += f_152_;
                            f_125_ += f_164_;
                            f_127_ += f_153_;
                            f_128_ += f_165_;
                            f_130_ += f_154_;
                            f_131_ += f_166_;
                            f += (float) rasterWidth;
                        }
                    }
                } else {
                    f_91_ = f_90_;
                    f_94_ = f_93_;
                    f_97_ = f_96_;
                    f_100_ = f_99_;
                    i_106_ = i_105_;
                    f_115_ = f_114_;
                    f_118_ = f_117_;
                    f_121_ = f_120_;
                    f_124_ = f_123_;
                    f_127_ = f_126_;
                    f_130_ = f_129_;
                    if (f < 0.0F) {
                        f_90_ -= f_132_ * f;
                        f_91_ -= f_156_ * f;
                        f_93_ -= f_133_ * f;
                        f_94_ -= f_157_ * f;
                        f_96_ -= f_134_ * f;
                        f_97_ -= f_158_ * f;
                        f_99_ -= f_135_ * f;
                        f_100_ -= f_159_ * f;
                        i_105_ -= f_136_ * f;
                        i_106_ -= f_160_ * f;
                        f_114_ -= f_137_ * f;
                        f_115_ -= f_161_ * f;
                        f_117_ -= f_138_ * f;
                        f_118_ -= f_162_ * f;
                        f_120_ -= f_139_ * f;
                        f_121_ -= f_163_ * f;
                        f_123_ -= f_140_ * f;
                        f_124_ -= f_164_ * f;
                        f_126_ -= f_141_ * f;
                        f_127_ -= f_165_ * f;
                        f_129_ -= f_142_ * f;
                        f_130_ -= f_166_ * f;
                        f = 0.0F;
                    }
                    if (f_89_ < 0.0F) {
                        f_92_ -= f_144_ * f_89_;
                        f_95_ -= f_145_ * f_89_;
                        f_98_ -= f_146_ * f_89_;
                        f_101_ -= f_147_ * f_89_;
                        i_107_ -= f_148_ * f_89_;
                        f_116_ -= f_149_ * f_89_;
                        f_119_ -= f_150_ * f_89_;
                        f_122_ -= f_151_ * f_89_;
                        f_125_ -= f_152_ * f_89_;
                        f_128_ -= f_153_ * f_89_;
                        f_131_ -= f_154_ * f_89_;
                        f_89_ = 0.0F;
                    }
                    if (f != f_89_ && f_156_ < f_132_ || f == f_89_ && f_144_ > f_132_) {
                        f_88_ -= f_89_;
                        f_89_ -= f;
                        f = (float) this.lineOffsets[(int) f];
                        while (--f_89_ >= 0.0F) {
                            method1025(raster, texturePixels, (int) f, (int) f_91_, (int) f_90_, f_94_, f_93_, f_97_, f_96_, f_100_, f_99_, (float) i_106_, (float) i_105_, f_115_, f_114_, f_118_, f_117_, f_121_, f_120_, f_124_, f_123_, f_127_, f_126_, f_130_, f_129_);
                            f_90_ += f_132_;
                            f_91_ += f_156_;
                            f_93_ += f_133_;
                            f_94_ += f_157_;
                            f_96_ += f_134_;
                            f_97_ += f_158_;
                            f_99_ += f_135_;
                            f_100_ += f_159_;
                            i_105_ += f_136_;
                            i_106_ += f_160_;
                            f_114_ += f_137_;
                            f_115_ += f_161_;
                            f_117_ += f_138_;
                            f_118_ += f_162_;
                            f_120_ += f_139_;
                            f_121_ += f_163_;
                            f_123_ += f_140_;
                            f_124_ += f_164_;
                            f_126_ += f_141_;
                            f_127_ += f_165_;
                            f_129_ += f_142_;
                            f_130_ += f_166_;
                            f += (float) rasterWidth;
                        }
                        while (--f_88_ >= 0.0F) {
                            method1025(raster, texturePixels, (int) f, (int) f_92_, (int) f_90_, f_95_, f_93_, f_98_, f_96_, f_101_, f_99_, (float) i_107_, (float) i_105_, f_116_, f_114_, f_119_, f_117_, f_122_, f_120_, f_125_, f_123_, f_128_, f_126_, f_131_, f_129_);
                            f_92_ += f_144_;
                            f_90_ += f_132_;
                            f_95_ += f_145_;
                            f_93_ += f_133_;
                            f_98_ += f_146_;
                            f_96_ += f_134_;
                            f_101_ += f_147_;
                            f_99_ += f_135_;
                            i_107_ += f_148_;
                            i_105_ += f_136_;
                            f_116_ += f_149_;
                            f_114_ += f_137_;
                            f_119_ += f_150_;
                            f_117_ += f_138_;
                            f_122_ += f_151_;
                            f_120_ += f_139_;
                            f_125_ += f_152_;
                            f_123_ += f_140_;
                            f_128_ += f_153_;
                            f_126_ += f_141_;
                            f_131_ += f_154_;
                            f_129_ += f_142_;
                            f += (float) rasterWidth;
                        }
                    } else {
                        f_88_ -= f_89_;
                        f_89_ -= f;
                        f = (float) this.lineOffsets[(int) f];
                        while (--f_89_ >= 0.0F) {
                            method1025(raster, texturePixels, (int) f, (int) f_90_, (int) f_91_, f_93_, f_94_, f_96_, f_97_, f_99_, f_100_, (float) i_105_, (float) i_106_, f_114_, f_115_, f_117_, f_118_, f_120_, f_121_, f_123_, f_124_, f_126_, f_127_, f_129_, f_130_);
                            f_91_ += f_156_;
                            f_90_ += f_132_;
                            f_94_ += f_157_;
                            f_93_ += f_133_;
                            f_97_ += f_158_;
                            f_96_ += f_134_;
                            f_100_ += f_159_;
                            f_99_ += f_135_;
                            i_106_ += f_160_;
                            i_105_ += f_136_;
                            f_115_ += f_161_;
                            f_114_ += f_137_;
                            f_118_ += f_162_;
                            f_117_ += f_138_;
                            f_121_ += f_163_;
                            f_120_ += f_139_;
                            f_124_ += f_164_;
                            f_123_ += f_140_;
                            f_127_ += f_165_;
                            f_126_ += f_141_;
                            f_130_ += f_166_;
                            f_129_ += f_142_;
                            f += (float) rasterWidth;
                        }
                        while (--f_88_ >= 0.0F) {
                            method1025(raster, texturePixels, (int) f, (int) f_90_, (int) f_92_, f_93_, f_95_, f_96_, f_98_, f_99_, f_101_, (float) i_105_, (float) i_107_, f_114_, f_116_, f_117_, f_119_, f_120_, f_122_, f_123_, f_125_, f_126_, f_128_, f_129_, f_131_);
                            f_90_ += f_132_;
                            f_92_ += f_144_;
                            f_93_ += f_133_;
                            f_95_ += f_145_;
                            f_96_ += f_134_;
                            f_98_ += f_146_;
                            f_99_ += f_135_;
                            f_101_ += f_147_;
                            i_105_ += f_136_;
                            i_107_ += f_148_;
                            f_114_ += f_137_;
                            f_116_ += f_149_;
                            f_117_ += f_138_;
                            f_119_ += f_150_;
                            f_120_ += f_139_;
                            f_122_ += f_151_;
                            f_123_ += f_140_;
                            f_125_ += f_152_;
                            f_126_ += f_141_;
                            f_128_ += f_153_;
                            f_129_ += f_142_;
                            f_131_ += f_154_;
                            f += (float) rasterWidth;
                        }
                    }
                }
            }
        } else if (f_88_ <= f_89_) {
            if (!(f_88_ >= (float) this.height)) {
                if (f_89_ > (float) this.height) f_89_ = (float) this.height;
                if (f > (float) this.height) f = (float) this.height;
                if (f_89_ < f) {
                    f_90_ = f_91_;
                    f_93_ = f_94_;
                    f_96_ = f_97_;
                    f_99_ = f_100_;
                    i_105_ = i_106_;
                    f_114_ = f_115_;
                    f_117_ = f_118_;
                    f_120_ = f_121_;
                    f_123_ = f_124_;
                    f_126_ = f_127_;
                    f_129_ = f_130_;
                    if (f_88_ < 0.0F) {
                        f_90_ -= f_132_ * f_88_;
                        f_91_ -= f_144_ * f_88_;
                        f_93_ -= f_133_ * f_88_;
                        f_94_ -= f_145_ * f_88_;
                        f_96_ -= f_134_ * f_88_;
                        f_97_ -= f_146_ * f_88_;
                        f_99_ -= f_135_ * f_88_;
                        f_100_ -= f_147_ * f_88_;
                        i_105_ -= f_136_ * f_88_;
                        i_106_ -= f_148_ * f_88_;
                        f_114_ -= f_137_ * f_88_;
                        f_115_ -= f_149_ * f_88_;
                        f_117_ -= f_138_ * f_88_;
                        f_118_ -= f_150_ * f_88_;
                        f_120_ -= f_139_ * f_88_;
                        f_121_ -= f_151_ * f_88_;
                        f_123_ -= f_140_ * f_88_;
                        f_124_ -= f_152_ * f_88_;
                        f_126_ -= f_141_ * f_88_;
                        f_127_ -= f_153_ * f_88_;
                        f_129_ -= f_142_ * f_88_;
                        f_130_ -= f_154_ * f_88_;
                        f_88_ = 0.0F;
                    }
                    if (f_89_ < 0.0F) {
                        f_92_ -= f_156_ * f_89_;
                        f_95_ -= f_157_ * f_89_;
                        f_98_ -= f_158_ * f_89_;
                        f_101_ -= f_159_ * f_89_;
                        i_107_ -= f_160_ * f_89_;
                        f_116_ -= f_161_ * f_89_;
                        f_119_ -= f_162_ * f_89_;
                        f_122_ -= f_163_ * f_89_;
                        f_125_ -= f_164_ * f_89_;
                        f_128_ -= f_165_ * f_89_;
                        f_131_ -= f_166_ * f_89_;
                        f_89_ = 0.0F;
                    }
                    if (f_88_ != f_89_ && f_132_ < f_144_ || f_88_ == f_89_ && f_132_ > f_156_) {
                        f -= f_89_;
                        f_89_ -= f_88_;
                        f_88_ = (float) (this.lineOffsets[(int) f_88_]);
                        while (--f_89_ >= 0.0F) {
                            method1025(raster, texturePixels, (int) f_88_, (int) f_90_, (int) f_91_, f_93_, f_94_, f_96_, f_97_, f_99_, f_100_, (float) i_105_, (float) i_106_, f_114_, f_115_, f_117_, f_118_, f_120_, f_121_, f_123_, f_124_, f_126_, f_127_, f_129_, f_130_);
                            f_90_ += f_132_;
                            f_91_ += f_144_;
                            f_93_ += f_133_;
                            f_94_ += f_145_;
                            f_96_ += f_134_;
                            f_97_ += f_146_;
                            f_99_ += f_135_;
                            f_100_ += f_147_;
                            i_105_ += f_136_;
                            i_106_ += f_148_;
                            f_114_ += f_137_;
                            f_115_ += f_149_;
                            f_117_ += f_138_;
                            f_118_ += f_150_;
                            f_120_ += f_139_;
                            f_121_ += f_151_;
                            f_123_ += f_140_;
                            f_124_ += f_152_;
                            f_126_ += f_141_;
                            f_127_ += f_153_;
                            f_129_ += f_142_;
                            f_130_ += f_154_;
                            f_88_ += (float) rasterWidth;
                        }
                        while (--f >= 0.0F) {
                            method1025(raster, texturePixels, (int) f_88_, (int) f_90_, (int) f_92_, f_93_, f_95_, f_96_, f_98_, f_99_, f_101_, (float) i_105_, (float) i_107_, f_114_, f_116_, f_117_, f_119_, f_120_, f_122_, f_123_, f_125_, f_126_, f_128_, f_129_, f_131_);
                            f_90_ += f_132_;
                            f_92_ += f_156_;
                            f_93_ += f_133_;
                            f_95_ += f_157_;
                            f_96_ += f_134_;
                            f_98_ += f_158_;
                            f_99_ += f_135_;
                            f_101_ += f_159_;
                            i_105_ += f_136_;
                            i_107_ += f_160_;
                            f_114_ += f_137_;
                            f_116_ += f_161_;
                            f_117_ += f_138_;
                            f_119_ += f_162_;
                            f_120_ += f_139_;
                            f_122_ += f_163_;
                            f_123_ += f_140_;
                            f_125_ += f_164_;
                            f_126_ += f_141_;
                            f_128_ += f_165_;
                            f_129_ += f_142_;
                            f_131_ += f_166_;
                            f_88_ += (float) rasterWidth;
                        }
                    } else {
                        f -= f_89_;
                        f_89_ -= f_88_;
                        f_88_ = (float) (this.lineOffsets[(int) f_88_]);
                        while (--f_89_ >= 0.0F) {
                            method1025(raster, texturePixels, (int) f_88_, (int) f_91_, (int) f_90_, f_94_, f_93_, f_97_, f_96_, f_100_, f_99_, (float) i_106_, (float) i_105_, f_115_, f_114_, f_118_, f_117_, f_121_, f_120_, f_124_, f_123_, f_127_, f_126_, f_130_, f_129_);
                            f_91_ += f_144_;
                            f_90_ += f_132_;
                            f_94_ += f_145_;
                            f_93_ += f_133_;
                            f_97_ += f_146_;
                            f_96_ += f_134_;
                            f_100_ += f_147_;
                            f_99_ += f_135_;
                            i_106_ += f_148_;
                            i_105_ += f_136_;
                            f_115_ += f_149_;
                            f_114_ += f_137_;
                            f_118_ += f_150_;
                            f_117_ += f_138_;
                            f_121_ += f_151_;
                            f_120_ += f_139_;
                            f_124_ += f_152_;
                            f_123_ += f_140_;
                            f_128_ += f_153_;
                            f_126_ += f_141_;
                            f_130_ += f_154_;
                            f_129_ += f_142_;
                            f_88_ += (float) rasterWidth;
                        }
                        while (--f >= 0.0F) {
                            method1025(raster, texturePixels, (int) f_88_, (int) f_92_, (int) f_90_, f_95_, f_93_, f_98_, f_96_, f_101_, f_99_, (float) i_107_, (float) i_105_, f_116_, f_114_, f_119_, f_117_, f_122_, f_120_, f_125_, f_123_, f_128_, f_126_, f_131_, f_129_);
                            f_92_ += f_156_;
                            f_90_ += f_132_;
                            f_95_ += f_157_;
                            f_93_ += f_133_;
                            f_98_ += f_158_;
                            f_96_ += f_134_;
                            f_101_ += f_159_;
                            f_99_ += f_135_;
                            i_107_ += f_160_;
                            i_105_ += f_136_;
                            f_116_ += f_161_;
                            f_114_ += f_137_;
                            f_119_ += f_162_;
                            f_117_ += f_138_;
                            f_122_ += f_163_;
                            f_120_ += f_139_;
                            f_125_ += f_164_;
                            f_123_ += f_140_;
                            f_128_ += f_165_;
                            f_126_ += f_141_;
                            f_131_ += f_166_;
                            f_129_ += f_142_;
                            f_88_ += (float) rasterWidth;
                        }
                    }
                } else {
                    f_92_ = f_91_;
                    f_95_ = f_94_;
                    f_98_ = f_97_;
                    f_101_ = f_100_;
                    i_107_ = i_106_;
                    f_116_ = f_115_;
                    f_119_ = f_118_;
                    f_122_ = f_121_;
                    f_125_ = f_124_;
                    f_128_ = f_127_;
                    f_131_ = f_130_;
                    if (f_88_ < 0.0F) {
                        f_92_ -= f_132_ * f_88_;
                        f_91_ -= f_144_ * f_88_;
                        f_95_ -= f_133_ * f_88_;
                        f_94_ -= f_145_ * f_88_;
                        f_98_ -= f_134_ * f_88_;
                        f_97_ -= f_146_ * f_88_;
                        f_101_ -= f_135_ * f_88_;
                        f_100_ -= f_147_ * f_88_;
                        i_107_ -= f_136_ * f_88_;
                        i_106_ -= f_148_ * f_88_;
                        f_116_ -= f_137_ * f_88_;
                        f_115_ -= f_149_ * f_88_;
                        f_119_ -= f_138_ * f_88_;
                        f_118_ -= f_150_ * f_88_;
                        f_122_ -= f_139_ * f_88_;
                        f_121_ -= f_151_ * f_88_;
                        f_125_ -= f_140_ * f_88_;
                        f_124_ -= f_152_ * f_88_;
                        f_128_ -= f_141_ * f_88_;
                        f_127_ -= f_153_ * f_88_;
                        f_131_ -= f_142_ * f_88_;
                        f_130_ -= f_154_ * f_88_;
                        f_88_ = 0.0F;
                    }
                    if (f < 0.0F) {
                        f_90_ -= f_156_ * f;
                        f_93_ -= f_157_ * f;
                        f_96_ -= f_158_ * f;
                        f_99_ -= f_159_ * f;
                        i_105_ -= f_160_ * f;
                        f_114_ -= f_161_ * f;
                        f_117_ -= f_162_ * f;
                        f_120_ -= f_163_ * f;
                        f_123_ -= f_164_ * f;
                        f_126_ -= f_165_ * f;
                        f_129_ -= f_166_ * f;
                        f = 0.0F;
                    }
                    f_89_ -= f;
                    f -= f_88_;
                    f_88_ = (float) (this.lineOffsets[(int) f_88_]);
                    if (f_132_ < f_144_) {
                        while (--f >= 0.0F) {
                            method1025(raster, texturePixels, (int) f_88_, (int) f_92_, (int) f_91_, f_95_, f_94_, f_98_, f_97_, f_101_, f_100_, (float) i_107_, (float) i_106_, f_116_, f_115_, f_119_, f_118_, f_122_, f_121_, f_125_, f_124_, f_128_, f_127_, f_131_, f_130_);
                            f_92_ += f_132_;
                            f_91_ += f_144_;
                            f_95_ += f_133_;
                            f_94_ += f_145_;
                            f_98_ += f_134_;
                            f_97_ += f_146_;
                            f_101_ += f_135_;
                            f_100_ += f_147_;
                            i_107_ += f_136_;
                            i_106_ += f_148_;
                            f_116_ += f_137_;
                            f_115_ += f_149_;
                            f_119_ += f_138_;
                            f_118_ += f_150_;
                            f_122_ += f_139_;
                            f_121_ += f_151_;
                            f_125_ += f_140_;
                            f_124_ += f_152_;
                            f_128_ += f_141_;
                            f_127_ += f_153_;
                            f_131_ += f_142_;
                            f_130_ += f_154_;
                            f_88_ += (float) rasterWidth;
                        }
                        while (--f_89_ >= 0.0F) {
                            method1025(raster, texturePixels, (int) f_88_, (int) f_90_, (int) f_91_, f_93_, f_94_, f_96_, f_97_, f_99_, f_100_, (float) i_105_, (float) i_106_, f_114_, f_115_, f_117_, f_118_, f_120_, f_121_, f_123_, f_124_, f_126_, f_127_, f_129_, f_130_);
                            f_90_ += f_156_;
                            f_91_ += f_144_;
                            f_93_ += f_157_;
                            f_94_ += f_145_;
                            f_96_ += f_158_;
                            f_97_ += f_146_;
                            f_99_ += f_159_;
                            f_100_ += f_147_;
                            i_105_ += f_160_;
                            i_106_ += f_148_;
                            f_114_ += f_161_;
                            f_115_ += f_149_;
                            f_117_ += f_162_;
                            f_118_ += f_150_;
                            f_120_ += f_163_;
                            f_121_ += f_151_;
                            f_123_ += f_164_;
                            f_124_ += f_152_;
                            f_126_ += f_165_;
                            f_127_ += f_153_;
                            f_129_ += f_166_;
                            f_130_ += f_154_;
                            f_88_ += (float) rasterWidth;
                        }
                    } else {
                        while (--f >= 0.0F) {
                            method1025(raster, texturePixels, (int) f_88_, (int) f_91_, (int) f_92_, f_94_, f_95_, f_97_, f_98_, f_100_, f_101_, (float) i_106_, (float) i_107_, f_115_, f_116_, f_118_, f_119_, f_121_, f_122_, f_124_, f_125_, f_127_, f_128_, f_130_, f_131_);
                            f_91_ += f_144_;
                            f_92_ += f_132_;
                            f_94_ += f_145_;
                            f_95_ += f_133_;
                            f_97_ += f_146_;
                            f_98_ += f_134_;
                            f_100_ += f_147_;
                            f_101_ += f_135_;
                            i_106_ += f_148_;
                            i_107_ += f_136_;
                            f_115_ += f_149_;
                            f_116_ += f_137_;
                            f_118_ += f_150_;
                            f_119_ += f_138_;
                            f_121_ += f_151_;
                            f_122_ += f_139_;
                            f_124_ += f_152_;
                            f_125_ += f_140_;
                            f_127_ += f_153_;
                            f_128_ += f_141_;
                            f_130_ += f_154_;
                            f_131_ += f_142_;
                            f_88_ += (float) rasterWidth;
                        }
                        while (--f_89_ >= 0.0F) {
                            method1025(raster, texturePixels, (int) f_88_, (int) f_91_, (int) f_90_, f_94_, f_93_, f_97_, f_96_, f_100_, f_99_, (float) i_106_, (float) i_105_, f_115_, f_114_, f_118_, f_117_, f_121_, f_120_, f_124_, f_123_, f_127_, f_126_, f_130_, f_129_);
                            f_91_ += f_144_;
                            f_90_ += f_156_;
                            f_94_ += f_145_;
                            f_93_ += f_157_;
                            f_97_ += f_146_;
                            f_96_ += f_158_;
                            f_100_ += f_147_;
                            f_99_ += f_159_;
                            i_106_ += f_148_;
                            i_105_ += f_160_;
                            f_115_ += f_149_;
                            f_114_ += f_161_;
                            f_118_ += f_150_;
                            f_117_ += f_162_;
                            f_121_ += f_151_;
                            f_120_ += f_163_;
                            f_124_ += f_152_;
                            f_123_ += f_164_;
                            f_127_ += f_153_;
                            f_126_ += f_165_;
                            f_130_ += f_154_;
                            f_129_ += f_166_;
                            f_88_ += (float) rasterWidth;
                        }
                    }
                }
            }
        } else if (!(f_89_ >= (float) this.height)) {
            if (f > (float) this.height) f = (float) this.height;
            if (f_88_ > (float) this.height) f_88_ = (float) this.height;
            if (f < f_88_) {
                f_91_ = f_92_;
                f_94_ = f_95_;
                f_97_ = f_98_;
                f_100_ = f_101_;
                i_106_ = i_107_;
                f_115_ = f_116_;
                f_118_ = f_119_;
                f_121_ = f_122_;
                f_124_ = f_125_;
                f_127_ = f_128_;
                f_130_ = f_131_;
                if (f_89_ < 0.0F) {
                    f_92_ -= f_156_ * f_89_;
                    f_91_ -= f_144_ * f_89_;
                    f_95_ -= f_157_ * f_89_;
                    f_94_ -= f_145_ * f_89_;
                    f_98_ -= f_158_ * f_89_;
                    f_97_ -= f_146_ * f_89_;
                    f_101_ -= f_159_ * f_89_;
                    f_100_ -= f_147_ * f_89_;
                    i_107_ -= f_160_ * 3.0F;
                    i_106_ -= f_148_ * f_89_;
                    f_116_ -= f_161_ * f_89_;
                    f_115_ -= f_149_ * f_89_;
                    f_119_ -= f_162_ * f_89_;
                    f_118_ -= f_150_ * f_89_;
                    f_122_ -= f_163_ * f_89_;
                    f_121_ -= f_151_ * f_89_;
                    f_125_ -= f_164_ * f_89_;
                    f_124_ -= f_152_ * f_89_;
                    f_128_ -= f_165_ * f_89_;
                    f_127_ -= f_153_ * f_89_;
                    f_131_ -= f_166_ * f_89_;
                    f_130_ -= f_154_ * f_89_;
                    f_89_ = 0.0F;
                }
                if (f < 0.0F) {
                    f_90_ -= f_132_ * f;
                    f_93_ -= f_133_ * f;
                    f_96_ -= f_134_ * f;
                    f_99_ -= f_135_ * f;
                    i_105_ -= f_136_ * f;
                    f_114_ -= f_137_ * f;
                    f_117_ -= f_138_ * f;
                    f_120_ -= f_139_ * f;
                    f_123_ -= f_140_ * f;
                    f_126_ -= f_141_ * f;
                    f_129_ -= f_142_ * f;
                    f = 0.0F;
                }
                if (f_144_ < f_156_) {
                    f_88_ -= f;
                    f -= f_89_;
                    f_89_ = (float) (this.lineOffsets[(int) f_89_]);
                    while (--f >= 0.0F) {
                        method1025(raster, texturePixels, (int) f_89_, (int) f_91_, (int) f_92_, f_94_, f_95_, f_97_, f_98_, f_100_, f_101_, (float) i_106_, (float) i_107_, f_115_, f_116_, f_118_, f_119_, f_121_, f_122_, f_124_, f_125_, f_127_, f_128_, f_130_, f_131_);
                        f_91_ += f_144_;
                        f_92_ += f_156_;
                        f_94_ += f_145_;
                        f_95_ += f_157_;
                        f_97_ += f_146_;
                        f_98_ += f_158_;
                        f_100_ += f_147_;
                        f_101_ += f_159_;
                        i_106_ += f_148_;
                        i_107_ += f_160_;
                        f_115_ += f_149_;
                        f_116_ += f_161_;
                        f_118_ += f_150_;
                        f_119_ += f_162_;
                        f_121_ += f_151_;
                        f_122_ += f_163_;
                        f_124_ += f_152_;
                        f_125_ += f_164_;
                        f_127_ += f_153_;
                        f_128_ += f_165_;
                        f_130_ += f_154_;
                        f_131_ += f_166_;
                        f_89_ += (float) rasterWidth;
                    }
                    while (--f_88_ >= 0.0F) {
                        method1025(raster, texturePixels, (int) f_89_, (int) f_91_, (int) f_90_, f_94_, f_93_, f_97_, f_96_, f_100_, f_99_, (float) i_106_, (float) i_105_, f_115_, f_114_, f_118_, f_117_, f_121_, f_120_, f_124_, f_123_, f_127_, f_126_, f_130_, f_129_);
                        f_91_ += f_144_;
                        f_90_ += f_132_;
                        f_94_ += f_145_;
                        f_93_ += f_133_;
                        f_97_ += f_146_;
                        f_96_ += f_134_;
                        f_100_ += f_147_;
                        f_99_ += f_135_;
                        i_106_ += f_148_;
                        i_105_ += f_136_;
                        f_115_ += f_149_;
                        f_114_ += f_137_;
                        f_118_ += f_150_;
                        f_117_ += f_138_;
                        f_121_ += f_151_;
                        f_120_ += f_139_;
                        f_124_ += f_152_;
                        f_123_ += f_140_;
                        f_127_ += f_153_;
                        f_126_ += f_141_;
                        f_130_ += f_154_;
                        f_129_ += f_142_;
                        f_89_ += (float) rasterWidth;
                    }
                } else {
                    f_88_ -= f;
                    f -= f_89_;
                    f_89_ = (float) (this.lineOffsets[(int) f_89_]);
                    while (--f >= 0.0F) {
                        method1025(raster, texturePixels, (int) f_89_, (int) f_92_, (int) f_91_, f_95_, f_94_, f_98_, f_97_, f_101_, f_100_, (float) i_107_, (float) i_106_, f_116_, f_115_, f_119_, f_118_, f_122_, f_121_, f_125_, f_124_, f_128_, f_127_, f_131_, f_130_);
                        f_92_ += f_156_;
                        f_91_ += f_144_;
                        f_95_ += f_157_;
                        f_94_ += f_145_;
                        f_98_ += f_158_;
                        f_97_ += f_146_;
                        f_101_ += f_159_;
                        f_100_ += f_147_;
                        i_107_ += f_160_;
                        i_106_ += f_148_;
                        f_116_ += f_161_;
                        f_115_ += f_149_;
                        f_119_ += f_162_;
                        f_118_ += f_150_;
                        f_122_ += f_163_;
                        f_121_ += f_151_;
                        f_125_ += f_164_;
                        f_124_ += f_152_;
                        f_128_ += f_165_;
                        f_127_ += f_153_;
                        f_131_ += f_166_;
                        f_130_ += f_154_;
                        f_89_ += (float) rasterWidth;
                    }
                    while (--f_88_ >= 0.0F) {
                        method1025(raster, texturePixels, (int) f_89_, (int) f_90_, (int) f_91_, f_93_, f_94_, f_96_, f_97_, f_99_, f_100_, (float) i_105_, (float) i_106_, f_114_, f_115_, f_117_, f_118_, f_120_, f_121_, f_123_, f_124_, f_126_, f_127_, f_129_, f_130_);
                        f_90_ += f_132_;
                        f_91_ += f_144_;
                        f_93_ += f_133_;
                        f_94_ += f_145_;
                        f_96_ += f_134_;
                        f_97_ += f_146_;
                        f_99_ += f_135_;
                        f_100_ += f_147_;
                        i_105_ += f_136_;
                        i_106_ += f_148_;
                        f_114_ += f_137_;
                        f_115_ += f_149_;
                        f_117_ += f_138_;
                        f_118_ += f_150_;
                        f_120_ += f_139_;
                        f_121_ += f_151_;
                        f_123_ += f_140_;
                        f_124_ += f_152_;
                        f_126_ += f_141_;
                        f_127_ += f_153_;
                        f_129_ += f_142_;
                        f_130_ += f_154_;
                        f_89_ += (float) rasterWidth;
                    }
                }
            } else {
                f_90_ = f_92_;
                f_93_ = f_95_;
                f_96_ = f_98_;
                f_99_ = f_101_;
                i_105_ = i_107_;
                f_114_ = f_116_;
                f_117_ = f_119_;
                f_120_ = f_122_;
                f_123_ = f_125_;
                f_126_ = f_128_;
                f_129_ = f_131_;
                if (f_89_ < 0.0F) {
                    f_92_ -= f_156_ * f_89_;
                    f_90_ -= f_144_ * f_89_;
                    f_95_ -= f_157_ * f_89_;
                    f_93_ -= f_145_ * f_89_;
                    f_98_ -= f_158_ * f_89_;
                    f_96_ -= f_146_ * f_89_;
                    f_101_ -= f_159_ * f_89_;
                    f_99_ -= f_147_ * f_89_;
                    i_107_ -= f_160_ * 3.0F;
                    i_105_ -= f_148_ * f_89_;
                    f_116_ -= f_161_ * f_89_;
                    f_114_ -= f_149_ * f_89_;
                    f_119_ -= f_162_ * f_89_;
                    f_117_ -= f_150_ * f_89_;
                    f_122_ -= f_163_ * f_89_;
                    f_120_ -= f_151_ * f_89_;
                    f_125_ -= f_164_ * f_89_;
                    f_123_ -= f_152_ * f_89_;
                    f_128_ -= f_165_ * f_89_;
                    f_126_ -= f_153_ * f_89_;
                    f_131_ -= f_166_ * f_89_;
                    f_129_ -= f_154_ * f_89_;
                    f_89_ = 0.0F;
                }
                if (f_88_ < 0.0F) {
                    f_91_ -= f_132_ * f_88_;
                    f_94_ -= f_133_ * f_88_;
                    f_97_ -= f_134_ * f_88_;
                    f_100_ -= f_135_ * f_88_;
                    i_106_ -= f_136_ * f_88_;
                    f_115_ -= f_137_ * f_88_;
                    f_118_ -= f_138_ * f_88_;
                    f_121_ -= f_139_ * f_88_;
                    f_124_ -= f_140_ * f_88_;
                    f_127_ -= f_141_ * f_88_;
                    f_130_ -= f_142_ * f_88_;
                    f_88_ = 0.0F;
                }
                if (f_144_ < f_156_) {
                    f -= f_88_;
                    f_88_ -= f_89_;
                    f_89_ = (float) (this.lineOffsets[(int) f_89_]);
                    while (--f_88_ >= 0.0F) {
                        method1025(raster, texturePixels, (int) f_89_, (int) f_90_, (int) f_92_, f_93_, f_95_, f_96_, f_98_, f_99_, f_101_, (float) i_105_, (float) i_107_, f_114_, f_116_, f_117_, f_119_, f_120_, f_122_, f_123_, f_125_, f_126_, f_128_, f_129_, f_131_);
                        f_90_ += f_144_;
                        f_92_ += f_156_;
                        f_93_ += f_145_;
                        f_95_ += f_157_;
                        f_96_ += f_146_;
                        f_98_ += f_158_;
                        f_99_ += f_147_;
                        f_101_ += f_159_;
                        i_105_ += f_148_;
                        i_107_ += f_160_;
                        f_114_ += f_149_;
                        f_116_ += f_161_;
                        f_117_ += f_150_;
                        f_119_ += f_162_;
                        f_120_ += f_151_;
                        f_122_ += f_163_;
                        f_123_ += f_152_;
                        f_125_ += f_164_;
                        f_126_ += f_153_;
                        f_128_ += f_165_;
                        f_129_ += f_154_;
                        f_131_ += f_166_;
                        f_89_ += (float) rasterWidth;
                    }
                    while (--f >= 0.0F) {
                        method1025(raster, texturePixels, (int) f_89_, (int) f_91_, (int) f_92_, f_94_, f_95_, f_97_, f_98_, f_100_, f_101_, (float) i_106_, (float) i_107_, f_115_, f_116_, f_118_, f_119_, f_121_, f_122_, f_124_, f_125_, f_127_, f_128_, f_130_, f_131_);
                        f_91_ += f_132_;
                        f_92_ += f_156_;
                        f_94_ += f_133_;
                        f_95_ += f_157_;
                        f_97_ += f_134_;
                        f_98_ += f_158_;
                        f_100_ += f_135_;
                        f_101_ += f_159_;
                        i_106_ += f_136_;
                        i_107_ += f_160_;
                        f_115_ += f_137_;
                        f_116_ += f_161_;
                        f_118_ += f_138_;
                        f_119_ += f_162_;
                        f_121_ += f_139_;
                        f_122_ += f_163_;
                        f_124_ += f_140_;
                        f_125_ += f_164_;
                        f_127_ += f_141_;
                        f_128_ += f_165_;
                        f_130_ += f_142_;
                        f_131_ += f_166_;
                        f_89_ += (float) rasterWidth;
                    }
                } else {
                    f -= f_88_;
                    f_88_ -= f_89_;
                    f_89_ = (float) (this.lineOffsets[(int) f_89_]);
                    while (--f_88_ >= 0.0F) {
                        method1025(raster, texturePixels, (int) f_89_, (int) f_92_, (int) f_90_, f_95_, f_93_, f_98_, f_96_, f_101_, f_99_, (float) i_107_, (float) i_105_, f_116_, f_114_, f_119_, f_117_, f_122_, f_120_, f_125_, f_123_, f_128_, f_126_, f_131_, f_129_);
                        f_92_ += f_156_;
                        f_90_ += f_144_;
                        f_95_ += f_157_;
                        f_93_ += f_145_;
                        f_98_ += f_158_;
                        f_96_ += f_146_;
                        f_101_ += f_159_;
                        f_99_ += f_147_;
                        i_107_ += f_160_;
                        i_105_ += f_148_;
                        f_116_ += f_161_;
                        f_114_ += f_149_;
                        f_119_ += f_162_;
                        f_117_ += f_150_;
                        f_122_ += f_163_;
                        f_120_ += f_151_;
                        f_125_ += f_164_;
                        f_123_ += f_152_;
                        f_128_ += f_165_;
                        f_126_ += f_153_;
                        f_131_ += f_166_;
                        f_129_ += f_154_;
                        f_89_ += (float) rasterWidth;
                    }
                    while (--f >= 0.0F) {
                        method1025(raster, texturePixels, (int) f_89_, (int) f_92_, (int) f_91_, f_95_, f_94_, f_98_, f_97_, f_101_, f_100_, (float) i_107_, (float) i_106_, f_116_, f_115_, f_119_, f_118_, f_122_, f_121_, f_125_, f_124_, f_128_, f_127_, f_131_, f_130_);
                        f_92_ += f_156_;
                        f_91_ += f_132_;
                        f_95_ += f_157_;
                        f_94_ += f_133_;
                        f_98_ += f_158_;
                        f_97_ += f_134_;
                        f_101_ += f_159_;
                        f_100_ += f_135_;
                        i_107_ += f_160_;
                        i_106_ += f_136_;
                        f_116_ += f_161_;
                        f_115_ += f_137_;
                        f_119_ += f_162_;
                        f_118_ += f_138_;
                        f_122_ += f_163_;
                        f_121_ += f_139_;
                        f_125_ += f_164_;
                        f_124_ += f_140_;
                        f_128_ += f_165_;
                        f_127_ += f_141_;
                        f_131_ += f_166_;
                        f_130_ += f_142_;
                        f_89_ += (float) rasterWidth;
                    }
                }
            }
        }
    }

    private final void method1021(int[] is, float[] fs, int i, int i_168_, int i_169_, int i_170_, int i_171_, float f, float f_172_, float f_173_, float f_174_, float f_175_, float f_176_, float f_177_, float f_178_) {
        if (this.restrictEdges) {
            if (i_171_ > this.width) i_171_ = this.width;
            if (i_170_ < 0) i_170_ = 0;
        }
        if (i_170_ < i_171_) {
            if (aBoolean1680) {
                i += i_170_;
                f_173_ += f_174_ * (float) i_170_;
                f_175_ += f_176_ * (float) i_170_;
                f_177_ += f_178_ * (float) i_170_;
                if (this.aBoolean1669) {
                    i_169_ = i_171_ - i_170_ >> 2;
                    f_174_ *= 4.0F;
                    f_176_ *= 4.0F;
                    f_178_ *= 4.0F;
                    if (this.alpha == 0) {
                        if (i_169_ > 0) {
                            do {
                                i_168_ = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                f_173_ += f_174_;
                                f_175_ += f_176_;
                                f_177_ += f_178_;
                                is[i++] = i_168_;
                                is[i++] = i_168_;
                                is[i++] = i_168_;
                                is[i++] = i_168_;
                            } while (--i_169_ > 0);
                        }
                        i_169_ = i_171_ - i_170_ & 0x3;
                        if (i_169_ > 0) {
                            i_168_ = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                            do is[i++] = i_168_; while (--i_169_ > 0);
                        }
                    } else if (this.aBoolean1667) {
                        if (i_169_ > 0) {
                            do {
                                i_168_ = ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                f_173_ += f_174_;
                                f_175_ += f_176_;
                                f_177_ += f_178_;
                                int[] is_183_ = is;
                                int i_184_ = i++;
                                int i_185_ = i_168_;
                                int i_186_ = is_183_[i_184_];
                                int i_187_ = i_185_ + i_186_;
                                int i_188_ = ((i_185_ & 0xff00ff) + (i_186_ & 0xff00ff));
                                i_186_ = (i_188_ & 0x1000100) + (i_187_ - i_188_ & 0x10000);
                                is_183_[i_184_] = (~0xffffff | i_187_ - i_186_ | i_186_ - (i_186_ >>> 8));
                                int[] is_189_ = is;
                                int i_190_ = i++;
                                int i_191_ = i_168_;
                                int i_192_ = is_189_[i_190_];
                                int i_193_ = i_191_ + i_192_;
                                int i_194_ = ((i_191_ & 0xff00ff) + (i_192_ & 0xff00ff));
                                i_192_ = (i_194_ & 0x1000100) + (i_193_ - i_194_ & 0x10000);
                                is_189_[i_190_] = (~0xffffff | i_193_ - i_192_ | i_192_ - (i_192_ >>> 8));
                                int[] is_195_ = is;
                                int i_196_ = i++;
                                int i_197_ = i_168_;
                                int i_198_ = is_195_[i_196_];
                                int i_199_ = i_197_ + i_198_;
                                int i_200_ = ((i_197_ & 0xff00ff) + (i_198_ & 0xff00ff));
                                i_198_ = (i_200_ & 0x1000100) + (i_199_ - i_200_ & 0x10000);
                                is_195_[i_196_] = (~0xffffff | i_199_ - i_198_ | i_198_ - (i_198_ >>> 8));
                                int[] is_201_ = is;
                                int i_202_ = i++;
                                int i_203_ = i_168_;
                                int i_204_ = is_201_[i_202_];
                                int i_205_ = i_203_ + i_204_;
                                int i_206_ = ((i_203_ & 0xff00ff) + (i_204_ & 0xff00ff));
                                i_204_ = (i_206_ & 0x1000100) + (i_205_ - i_206_ & 0x10000);
                                is_201_[i_202_] = (~0xffffff | i_205_ - i_204_ | i_204_ - (i_204_ >>> 8));
                            } while (--i_169_ > 0);
                        }
                        i_169_ = i_171_ - i_170_ & 0x3;
                        if (i_169_ > 0) {
                            i_168_ = ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                            do {
                                int[] is_207_ = is;
                                int i_208_ = i++;
                                int i_209_ = i_168_;
                                int i_210_ = is_207_[i_208_];
                                int i_211_ = i_209_ + i_210_;
                                int i_212_ = ((i_209_ & 0xff00ff) + (i_210_ & 0xff00ff));
                                i_210_ = (i_212_ & 0x1000100) + (i_211_ - i_212_ & 0x10000);
                                is_207_[i_208_] = (~0xffffff | i_211_ - i_210_ | i_210_ - (i_210_ >>> 8));
                            } while (--i_169_ > 0);
                        }
                    } else {
                        int i_179_ = this.alpha;
                        int i_180_ = 256 - this.alpha;
                        if (i_169_ > 0) {
                            do {
                                i_168_ = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                f_173_ += f_174_;
                                f_175_ += f_176_;
                                f_177_ += f_178_;
                                i_168_ = (((i_168_ & 0xff00ff) * i_180_ >> 8 & 0xff00ff) + ((i_168_ & 0xff00) * i_180_ >> 8 & 0xff00));
                                int i_181_ = is[i];
                                is[i++] = (i_168_ + ((i_181_ & 0xff00ff) * i_179_ >> 8 & 0xff00ff) + ((i_181_ & 0xff00) * i_179_ >> 8 & 0xff00));
                                i_181_ = is[i];
                                is[i++] = (i_168_ + ((i_181_ & 0xff00ff) * i_179_ >> 8 & 0xff00ff) + ((i_181_ & 0xff00) * i_179_ >> 8 & 0xff00));
                                i_181_ = is[i];
                                is[i++] = (i_168_ + ((i_181_ & 0xff00ff) * i_179_ >> 8 & 0xff00ff) + ((i_181_ & 0xff00) * i_179_ >> 8 & 0xff00));
                                i_181_ = is[i];
                                is[i++] = (i_168_ + ((i_181_ & 0xff00ff) * i_179_ >> 8 & 0xff00ff) + ((i_181_ & 0xff00) * i_179_ >> 8 & 0xff00));
                            } while (--i_169_ > 0);
                        }
                        i_169_ = i_171_ - i_170_ & 0x3;
                        if (i_169_ > 0) {
                            i_168_ = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                            i_168_ = (((i_168_ & 0xff00ff) * i_180_ >> 8 & 0xff00ff) + ((i_168_ & 0xff00) * i_180_ >> 8 & 0xff00));
                            do {
                                int i_182_ = is[i];
                                is[i++] = (i_168_ + ((i_182_ & 0xff00ff) * i_179_ >> 8 & 0xff00ff) + ((i_182_ & 0xff00) * i_179_ >> 8 & 0xff00));
                            } while (--i_169_ > 0);
                        }
                    }
                } else {
                    i_169_ = i_171_ - i_170_;
                    if (this.alpha == 0) {
                        do {
                            is[i++] = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                            f_173_ += f_174_;
                            f_175_ += f_176_;
                            f_177_ += f_178_;
                        } while (--i_169_ > 0);
                    } else if (this.aBoolean1667) {
                        do {
                            int[] is_216_ = is;
                            int i_217_ = i++;
                            int i_218_ = ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                            int i_219_ = is_216_[i_217_];
                            int i_220_ = i_218_ + i_219_;
                            int i_221_ = (i_218_ & 0xff00ff) + (i_219_ & 0xff00ff);
                            i_219_ = (i_221_ & 0x1000100) + (i_220_ - i_221_ & 0x10000);
                            is_216_[i_217_] = (~0xffffff | i_220_ - i_219_ | i_219_ - (i_219_ >>> 8));
                            f_173_ += f_174_;
                            f_175_ += f_176_;
                            f_177_ += f_178_;
                        } while (--i_169_ > 0);
                    } else {
                        int i_213_ = this.alpha;
                        int i_214_ = 256 - this.alpha;
                        do {
                            i_168_ = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                            f_173_ += f_174_;
                            f_175_ += f_176_;
                            f_177_ += f_178_;
                            i_168_ = (((i_168_ & 0xff00ff) * i_214_ >> 8 & 0xff00ff) + ((i_168_ & 0xff00) * i_214_ >> 8 & 0xff00));
                            int i_215_ = is[i];
                            is[i++] = (i_168_ + ((i_215_ & 0xff00ff) * i_213_ >> 8 & 0xff00ff) + ((i_215_ & 0xff00) * i_213_ >> 8 & 0xff00));
                        } while (--i_169_ > 0);
                    }
                }
            } else {
                i += i_170_ - 1;
                f += f_172_ * (float) i_170_;
                f_173_ += f_174_ * (float) i_170_;
                f_175_ += f_176_ * (float) i_170_;
                f_177_ += f_178_ * (float) i_170_;
                if (aJavaThreadResource_1670.aBoolean2202) {
                    if (this.aBoolean1669) {
                        i_169_ = i_171_ - i_170_ >> 2;
                        f_174_ *= 4.0F;
                        f_176_ *= 4.0F;
                        f_178_ *= 4.0F;
                        if (this.alpha == 0) {
                            if (i_169_ > 0) {
                                do {
                                    i_168_ = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                    f_173_ += f_174_;
                                    f_175_ += f_176_;
                                    f_177_ += f_178_;
                                    if (f < fs[++i]) {
                                        is[i] = i_168_;
                                        fs[i] = f;
                                    }
                                    f += f_172_;
                                    if (f < fs[++i]) {
                                        is[i] = i_168_;
                                        fs[i] = f;
                                    }
                                    f += f_172_;
                                    if (f < fs[++i]) {
                                        is[i] = i_168_;
                                        fs[i] = f;
                                    }
                                    f += f_172_;
                                    if (f < fs[++i]) {
                                        is[i] = i_168_;
                                        fs[i] = f;
                                    }
                                    f += f_172_;
                                } while (--i_169_ > 0);
                            }
                            i_169_ = i_171_ - i_170_ & 0x3;
                            if (i_169_ > 0) {
                                i_168_ = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                do {
                                    if (f < fs[++i]) {
                                        is[i] = i_168_;
                                        fs[i] = f;
                                    }
                                    f += f_172_;
                                } while (--i_169_ > 0);
                            }
                        } else if (this.aBoolean1667) {
                            if (i_169_ > 0) {
                                do {
                                    i_168_ = ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                    f_173_ += f_174_;
                                    f_175_ += f_176_;
                                    f_177_ += f_178_;
                                    if (f < fs[++i]) {
                                        int[] is_229_ = is;
                                        int i_230_ = i;
                                        int i_231_ = i_168_;
                                        int i_232_ = is_229_[i_230_];
                                        int i_233_ = i_231_ + i_232_;
                                        int i_234_ = ((i_231_ & 0xff00ff) + (i_232_ & 0xff00ff));
                                        i_232_ = ((i_234_ & 0x1000100) + (i_233_ - i_234_ & 0x10000));
                                        is_229_[i_230_] = (~0xffffff | i_233_ - i_232_ | i_232_ - (i_232_ >>> 8));
                                        fs[i] = f;
                                    }
                                    f += f_172_;
                                    if (f < fs[++i]) {
                                        int[] is_235_ = is;
                                        int i_236_ = i;
                                        int i_237_ = i_168_;
                                        int i_238_ = is_235_[i_236_];
                                        int i_239_ = i_237_ + i_238_;
                                        int i_240_ = ((i_237_ & 0xff00ff) + (i_238_ & 0xff00ff));
                                        i_238_ = ((i_240_ & 0x1000100) + (i_239_ - i_240_ & 0x10000));
                                        is_235_[i_236_] = (~0xffffff | i_239_ - i_238_ | i_238_ - (i_238_ >>> 8));
                                        fs[i] = f;
                                    }
                                    f += f_172_;
                                    if (f < fs[++i]) {
                                        int[] is_241_ = is;
                                        int i_242_ = i;
                                        int i_243_ = i_168_;
                                        int i_244_ = is_241_[i_242_];
                                        int i_245_ = i_243_ + i_244_;
                                        int i_246_ = ((i_243_ & 0xff00ff) + (i_244_ & 0xff00ff));
                                        i_244_ = ((i_246_ & 0x1000100) + (i_245_ - i_246_ & 0x10000));
                                        is_241_[i_242_] = (~0xffffff | i_245_ - i_244_ | i_244_ - (i_244_ >>> 8));
                                        fs[i] = f;
                                    }
                                    f += f_172_;
                                    if (f < fs[++i]) {
                                        int[] is_247_ = is;
                                        int i_248_ = i;
                                        int i_249_ = i_168_;
                                        int i_250_ = is_247_[i_248_];
                                        int i_251_ = i_249_ + i_250_;
                                        int i_252_ = ((i_249_ & 0xff00ff) + (i_250_ & 0xff00ff));
                                        i_250_ = ((i_252_ & 0x1000100) + (i_251_ - i_252_ & 0x10000));
                                        is_247_[i_248_] = (~0xffffff | i_251_ - i_250_ | i_250_ - (i_250_ >>> 8));
                                        fs[i] = f;
                                    }
                                    f += f_172_;
                                } while (--i_169_ > 0);
                            }
                            i_169_ = i_171_ - i_170_ & 0x3;
                            if (i_169_ > 0) {
                                i_168_ = ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                do {
                                    if (f < fs[++i]) {
                                        int[] is_253_ = is;
                                        int i_254_ = i;
                                        int i_255_ = i_168_;
                                        int i_256_ = is_253_[i_254_];
                                        int i_257_ = i_255_ + i_256_;
                                        int i_258_ = ((i_255_ & 0xff00ff) + (i_256_ & 0xff00ff));
                                        i_256_ = ((i_258_ & 0x1000100) + (i_257_ - i_258_ & 0x10000));
                                        is_253_[i_254_] = (~0xffffff | i_257_ - i_256_ | i_256_ - (i_256_ >>> 8));
                                        fs[i] = f;
                                    }
                                    f += f_172_;
                                } while (--i_169_ > 0);
                            }
                        } else {
                            int i_222_ = this.alpha;
                            int i_223_ = 256 - this.alpha;
                            if (i_169_ > 0) {
                                do {
                                    i_168_ = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                    f_173_ += f_174_;
                                    f_175_ += f_176_;
                                    f_177_ += f_178_;
                                    i_168_ = (((i_168_ & 0xff00ff) * i_223_ >> 8 & 0xff00ff) + ((i_168_ & 0xff00) * i_223_ >> 8 & 0xff00));
                                    if (f < fs[++i]) {
                                        int i_224_ = is[i];
                                        is[i] = (i_168_ + (((i_224_ & 0xff00ff) * i_222_ >> 8) & 0xff00ff) + (((i_224_ & 0xff00) * i_222_ >> 8) & 0xff00));
                                        fs[i] = f;
                                    }
                                    f += f_172_;
                                    if (f < fs[++i]) {
                                        int i_225_ = is[i];
                                        is[i] = (i_168_ + (((i_225_ & 0xff00ff) * i_222_ >> 8) & 0xff00ff) + (((i_225_ & 0xff00) * i_222_ >> 8) & 0xff00));
                                        fs[i] = f;
                                    }
                                    f += f_172_;
                                    if (f < fs[++i]) {
                                        int i_226_ = is[i];
                                        is[i] = (i_168_ + (((i_226_ & 0xff00ff) * i_222_ >> 8) & 0xff00ff) + (((i_226_ & 0xff00) * i_222_ >> 8) & 0xff00));
                                        fs[i] = f;
                                    }
                                    f += f_172_;
                                    if (f < fs[++i]) {
                                        int i_227_ = is[i];
                                        is[i] = (i_168_ + (((i_227_ & 0xff00ff) * i_222_ >> 8) & 0xff00ff) + (((i_227_ & 0xff00) * i_222_ >> 8) & 0xff00));
                                        fs[i] = f;
                                    }
                                    f += f_172_;
                                } while (--i_169_ > 0);
                            }
                            i_169_ = i_171_ - i_170_ & 0x3;
                            if (i_169_ > 0) {
                                i_168_ = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                i_168_ = (((i_168_ & 0xff00ff) * i_223_ >> 8 & 0xff00ff) + ((i_168_ & 0xff00) * i_223_ >> 8 & 0xff00));
                                do {
                                    if (f < fs[++i]) {
                                        int i_228_ = is[i];
                                        is[i] = (i_168_ + (((i_228_ & 0xff00ff) * i_222_ >> 8) & 0xff00ff) + (((i_228_ & 0xff00) * i_222_ >> 8) & 0xff00));
                                        fs[i] = f;
                                    }
                                    f += f_172_;
                                } while (--i_169_ > 0);
                            }
                        }
                    } else {
                        i_169_ = i_171_ - i_170_;
                        if (this.alpha == 0) {
                            do {
                                if (f < fs[++i]) {
                                    is[i] = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                    fs[i] = f;
                                }
                                f += f_172_;
                                f_173_ += f_174_;
                                f_175_ += f_176_;
                                f_177_ += f_178_;
                            } while (--i_169_ > 0);
                        } else if (this.aBoolean1667) {
                            do {
                                if (f < fs[++i]) {
                                    int[] is_262_ = is;
                                    int i_263_ = i;
                                    int i_264_ = ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                    int i_265_ = is_262_[i_263_];
                                    int i_266_ = i_264_ + i_265_;
                                    int i_267_ = ((i_264_ & 0xff00ff) + (i_265_ & 0xff00ff));
                                    i_265_ = ((i_267_ & 0x1000100) + (i_266_ - i_267_ & 0x10000));
                                    is_262_[i_263_] = (~0xffffff | i_266_ - i_265_ | i_265_ - (i_265_ >>> 8));
                                    fs[i] = f;
                                }
                                f += f_172_;
                                f_173_ += f_174_;
                                f_175_ += f_176_;
                                f_177_ += f_178_;
                            } while (--i_169_ > 0);
                        } else {
                            int i_259_ = this.alpha;
                            int i_260_ = 256 - this.alpha;
                            do {
                                if (f < fs[++i]) {
                                    i_168_ = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                    i_168_ = (((i_168_ & 0xff00ff) * i_260_ >> 8 & 0xff00ff) + ((i_168_ & 0xff00) * i_260_ >> 8 & 0xff00));
                                    int i_261_ = is[i];
                                    is[i] = (i_168_ + ((i_261_ & 0xff00ff) * i_259_ >> 8 & 0xff00ff) + ((i_261_ & 0xff00) * i_259_ >> 8 & 0xff00));
                                    fs[i] = f;
                                }
                                f += f_172_;
                                f_173_ += f_174_;
                                f_175_ += f_176_;
                                f_177_ += f_178_;
                            } while (--i_169_ > 0);
                        }
                    }
                } else if (this.aBoolean1669) {
                    i_169_ = i_171_ - i_170_ >> 2;
                    f_174_ *= 4.0F;
                    f_176_ *= 4.0F;
                    f_178_ *= 4.0F;
                    if (this.alpha == 0) {
                        if (i_169_ > 0) {
                            do {
                                i_168_ = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                f_173_ += f_174_;
                                f_175_ += f_176_;
                                f_177_ += f_178_;
                                if (f < fs[++i]) is[i] = i_168_;
                                f += f_172_;
                                if (f < fs[++i]) is[i] = i_168_;
                                f += f_172_;
                                if (f < fs[++i]) is[i] = i_168_;
                                f += f_172_;
                                if (f < fs[++i]) is[i] = i_168_;
                                f += f_172_;
                            } while (--i_169_ > 0);
                        }
                        i_169_ = i_171_ - i_170_ & 0x3;
                        if (i_169_ > 0) {
                            i_168_ = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                            do {
                                if (f < fs[++i]) is[i] = i_168_;
                                f += f_172_;
                            } while (--i_169_ > 0);
                        }
                    } else if (this.aBoolean1667) {
                        if (i_169_ > 0) {
                            do {
                                i_168_ = ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                f_173_ += f_174_;
                                f_175_ += f_176_;
                                f_177_ += f_178_;
                                if (f < fs[++i]) {
                                    int[] is_275_ = is;
                                    int i_276_ = i;
                                    int i_277_ = i_168_;
                                    int i_278_ = is_275_[i_276_];
                                    int i_279_ = i_277_ + i_278_;
                                    int i_280_ = ((i_277_ & 0xff00ff) + (i_278_ & 0xff00ff));
                                    i_278_ = ((i_280_ & 0x1000100) + (i_279_ - i_280_ & 0x10000));
                                    is_275_[i_276_] = (~0xffffff | i_279_ - i_278_ | i_278_ - (i_278_ >>> 8));
                                }
                                f += f_172_;
                                if (f < fs[++i]) {
                                    int[] is_281_ = is;
                                    int i_282_ = i;
                                    int i_283_ = i_168_;
                                    int i_284_ = is_281_[i_282_];
                                    int i_285_ = i_283_ + i_284_;
                                    int i_286_ = ((i_283_ & 0xff00ff) + (i_284_ & 0xff00ff));
                                    i_284_ = ((i_286_ & 0x1000100) + (i_285_ - i_286_ & 0x10000));
                                    is_281_[i_282_] = (~0xffffff | i_285_ - i_284_ | i_284_ - (i_284_ >>> 8));
                                }
                                f += f_172_;
                                if (f < fs[++i]) {
                                    int[] is_287_ = is;
                                    int i_288_ = i;
                                    int i_289_ = i_168_;
                                    int i_290_ = is_287_[i_288_];
                                    int i_291_ = i_289_ + i_290_;
                                    int i_292_ = ((i_289_ & 0xff00ff) + (i_290_ & 0xff00ff));
                                    i_290_ = ((i_292_ & 0x1000100) + (i_291_ - i_292_ & 0x10000));
                                    is_287_[i_288_] = (~0xffffff | i_291_ - i_290_ | i_290_ - (i_290_ >>> 8));
                                }
                                f += f_172_;
                                if (f < fs[++i]) {
                                    int[] is_293_ = is;
                                    int i_294_ = i;
                                    int i_295_ = i_168_;
                                    int i_296_ = is_293_[i_294_];
                                    int i_297_ = i_295_ + i_296_;
                                    int i_298_ = ((i_295_ & 0xff00ff) + (i_296_ & 0xff00ff));
                                    i_296_ = ((i_298_ & 0x1000100) + (i_297_ - i_298_ & 0x10000));
                                    is_293_[i_294_] = (~0xffffff | i_297_ - i_296_ | i_296_ - (i_296_ >>> 8));
                                }
                                f += f_172_;
                            } while (--i_169_ > 0);
                        }
                        i_169_ = i_171_ - i_170_ & 0x3;
                        if (i_169_ > 0) {
                            i_168_ = ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                            do {
                                if (f < fs[++i]) {
                                    int[] is_299_ = is;
                                    int i_300_ = i;
                                    int i_301_ = i_168_;
                                    int i_302_ = is_299_[i_300_];
                                    int i_303_ = i_301_ + i_302_;
                                    int i_304_ = ((i_301_ & 0xff00ff) + (i_302_ & 0xff00ff));
                                    i_302_ = ((i_304_ & 0x1000100) + (i_303_ - i_304_ & 0x10000));
                                    is_299_[i_300_] = (~0xffffff | i_303_ - i_302_ | i_302_ - (i_302_ >>> 8));
                                }
                                f += f_172_;
                            } while (--i_169_ > 0);
                        }
                    } else {
                        int i_268_ = this.alpha;
                        int i_269_ = 256 - this.alpha;
                        if (i_169_ > 0) {
                            do {
                                i_168_ = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                f_173_ += f_174_;
                                f_175_ += f_176_;
                                f_177_ += f_178_;
                                i_168_ = (((i_168_ & 0xff00ff) * i_269_ >> 8 & 0xff00ff) + ((i_168_ & 0xff00) * i_269_ >> 8 & 0xff00));
                                if (f < fs[++i]) {
                                    int i_270_ = is[i];
                                    is[i] = (i_168_ + ((i_270_ & 0xff00ff) * i_268_ >> 8 & 0xff00ff) + ((i_270_ & 0xff00) * i_268_ >> 8 & 0xff00));
                                }
                                f += f_172_;
                                if (f < fs[++i]) {
                                    int i_271_ = is[i];
                                    is[i] = (i_168_ + ((i_271_ & 0xff00ff) * i_268_ >> 8 & 0xff00ff) + ((i_271_ & 0xff00) * i_268_ >> 8 & 0xff00));
                                }
                                f += f_172_;
                                if (f < fs[++i]) {
                                    int i_272_ = is[i];
                                    is[i] = (i_168_ + ((i_272_ & 0xff00ff) * i_268_ >> 8 & 0xff00ff) + ((i_272_ & 0xff00) * i_268_ >> 8 & 0xff00));
                                }
                                f += f_172_;
                                if (f < fs[++i]) {
                                    int i_273_ = is[i];
                                    is[i] = (i_168_ + ((i_273_ & 0xff00ff) * i_268_ >> 8 & 0xff00ff) + ((i_273_ & 0xff00) * i_268_ >> 8 & 0xff00));
                                }
                                f += f_172_;
                            } while (--i_169_ > 0);
                        }
                        i_169_ = i_171_ - i_170_ & 0x3;
                        if (i_169_ > 0) {
                            i_168_ = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                            i_168_ = (((i_168_ & 0xff00ff) * i_269_ >> 8 & 0xff00ff) + ((i_168_ & 0xff00) * i_269_ >> 8 & 0xff00));
                            do {
                                if (f < fs[++i]) {
                                    int i_274_ = is[i];
                                    is[i] = (i_168_ + ((i_274_ & 0xff00ff) * i_268_ >> 8 & 0xff00ff) + ((i_274_ & 0xff00) * i_268_ >> 8 & 0xff00));
                                }
                                f += f_172_;
                            } while (--i_169_ > 0);
                        }
                    }
                } else {
                    i_169_ = i_171_ - i_170_;
                    if (this.alpha == 0) {
                        do {
                            if (f < fs[++i]) is[i] = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                            f += f_172_;
                            f_173_ += f_174_;
                            f_175_ += f_176_;
                            f_177_ += f_178_;
                        } while (--i_169_ > 0);
                    } else if (this.aBoolean1667) {
                        do {
                            if (f < fs[++i]) {
                                int[] is_308_ = is;
                                int i_309_ = i;
                                int i_310_ = ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                int i_311_ = is_308_[i_309_];
                                int i_312_ = i_310_ + i_311_;
                                int i_313_ = ((i_310_ & 0xff00ff) + (i_311_ & 0xff00ff));
                                i_311_ = (i_313_ & 0x1000100) + (i_312_ - i_313_ & 0x10000);
                                is_308_[i_309_] = (~0xffffff | i_312_ - i_311_ | i_311_ - (i_311_ >>> 8));
                            }
                            f += f_172_;
                            f_173_ += f_174_;
                            f_175_ += f_176_;
                            f_177_ += f_178_;
                        } while (--i_169_ > 0);
                    } else {
                        int i_305_ = this.alpha;
                        int i_306_ = 256 - this.alpha;
                        do {
                            if (f < fs[++i]) {
                                i_168_ = ~0xffffff | ((int) f_173_ & 0xff0000 | (int) f_175_ & 0xff00 | (int) f_177_ & 0xff);
                                i_168_ = (((i_168_ & 0xff00ff) * i_306_ >> 8 & 0xff00ff) + ((i_168_ & 0xff00) * i_306_ >> 8 & 0xff00));
                                int i_307_ = is[i];
                                is[i] = (i_168_ + ((i_307_ & 0xff00ff) * i_305_ >> 8 & 0xff00ff) + ((i_307_ & 0xff00) * i_305_ >> 8 & 0xff00));
                            }
                            f += f_172_;
                            f_173_ += f_174_;
                            f_175_ += f_176_;
                            f_177_ += f_178_;
                        } while (--i_169_ > 0);
                    }
                }
            }
        }
    }

    // method1022
    final void drawGouraudTriangle(float yA, float yB, float yC, float xA, float xB, float xC, float zA, float zB, float zC, float hsvA, float hsvB, float hsvC) {
        if (useExternalRenderer) {
            aJavaToolkit_1666.method3645((int) yA, (int) xA, (int) xB, -8003, Class126.HSV_TO_RGB[(int) hsvA], (int) yB);
            aJavaToolkit_1666.method3645((int) yB, (int) xB, (int) xC, -8003, Class126.HSV_TO_RGB[(int) hsvA], (int) yC);
            aJavaToolkit_1666.method3645((int) yC, (int) xC, (int) xA, -8003, Class126.HSV_TO_RGB[(int) hsvA], (int) yA);
        } else {
            float baX = xB - xA;
            float baY = yB - yA;
            float caX = xC - xA;
            float caY = yC - yA;
            float hsv1 = hsvB - hsvA;
            float hsv2 = hsvC - hsvA;
            float baZ = zB - zA;
            float caZ = zC - zA;
            float aToB;
            if (yC != yB) aToB = (xC - xB) / (yC - yB);
            else aToB = 0.0F;
            float bToC;
            if (yB != yA) bToC = baX / baY;
            else bToC = 0.0F;
            float cToA;
            if (yC != yA) cToA = caX / caY;
            else cToA = 0.0F;
            float div = baX * caY - caX * baY;
            if (div != 0.0F) {
                float dhsv1 = (hsv1 * caY - hsv2 * baY) / div;
                float dhsv2 = (hsv2 * baX - hsv1 * caX) / div;
                float depthSlope = (baZ * caY - caZ * baY) / div;
                float depthIncrement = (caZ * baX - baZ * caX) / div;
                if (yA <= yB && yA <= yC) {
                    if (yA >= (float) this.height) {
                        return;
                    }
                    if (yB > (float) this.height) yB = (float) this.height;
                    if (yC > (float) this.height) yC = (float) this.height;
                    hsvA = hsvA - dhsv1 * xA + dhsv1;
                    zA = zA - depthSlope * xA + depthSlope;
                    if (yB < yC) {
                        xC = xA;
                        if (yA < 0.0F) {
                            xC -= cToA * yA;
                            xA -= bToC * yA;
                            hsvA -= dhsv2 * yA;
                            zA -= depthIncrement * yA;
                            yA = 0.0F;
                        }
                        if (yB < 0.0F) {
                            xB -= aToB * yB;
                            yB = 0.0F;
                        }
                        if (yA != yB && cToA < bToC || yA == yB && cToA > aToB) {
                            yC -= yB;
                            yB -= yA;
                            yA = (float) (this.lineOffsets[(int) yA]);
                            while (--yB >= 0.0F) {
                                drawGoraudScanline(raster, depthBuffer, (int) yA, 0, 0, (int) xC, (int) xA, hsvA, dhsv1, zA, depthSlope);
                                xC += cToA;
                                xA += bToC;
                                hsvA += dhsv2;
                                zA += depthIncrement;
                                yA += (float) rasterWidth;
                            }
                            while (--yC >= 0.0F) {
                                drawGoraudScanline(raster, depthBuffer, (int) yA, 0, 0, (int) xC, (int) xB, hsvA, dhsv1, zA, depthSlope);
                                xC += cToA;
                                xB += aToB;
                                hsvA += dhsv2;
                                zA += depthIncrement;
                                yA += (float) rasterWidth;
                            }
                        } else {
                            yC -= yB;
                            yB -= yA;
                            yA = (float) (this.lineOffsets[(int) yA]);
                            while (--yB >= 0.0F) {
                                drawGoraudScanline(raster, depthBuffer, (int) yA, 0, 0, (int) xA, (int) xC, hsvA, dhsv1, zA, depthSlope);
                                xC += cToA;
                                xA += bToC;
                                hsvA += dhsv2;
                                zA += depthIncrement;
                                yA += (float) rasterWidth;
                            }
                            while (--yC >= 0.0F) {
                                drawGoraudScanline(raster, depthBuffer, (int) yA, 0, 0, (int) xB, (int) xC, hsvA, dhsv1, zA, depthSlope);
                                xC += cToA;
                                xB += aToB;
                                hsvA += dhsv2;
                                zA += depthIncrement;
                                yA += (float) rasterWidth;
                            }
                        }
                    } else {
                        xB = xA;
                        if (yA < 0.0F) {
                            xB -= cToA * yA;
                            xA -= bToC * yA;
                            hsvA -= dhsv2 * yA;
                            zA -= depthIncrement * yA;
                            yA = 0.0F;
                        }
                        if (yC < 0.0F) {
                            xC -= aToB * yC;
                            yC = 0.0F;
                        }
                        if (yA != yC && cToA < bToC || yA == yC && aToB > bToC) {
                            yB -= yC;
                            yC -= yA;
                            yA = (float) (this.lineOffsets[(int) yA]);
                            while (--yC >= 0.0F) {
                                drawGoraudScanline(raster, depthBuffer, (int) yA, 0, 0, (int) xB, (int) xA, hsvA, dhsv1, zA, depthSlope);
                                xB += cToA;
                                xA += bToC;
                                hsvA += dhsv2;
                                zA += depthIncrement;
                                yA += (float) rasterWidth;
                            }
                            while (--yB >= 0.0F) {
                                drawGoraudScanline(raster, depthBuffer, (int) yA, 0, 0, (int) xC, (int) xA, hsvA, dhsv1, zA, depthSlope);
                                xC += aToB;
                                xA += bToC;
                                hsvA += dhsv2;
                                zA += depthIncrement;
                                yA += (float) rasterWidth;
                            }
                        } else {
                            yB -= yC;
                            yC -= yA;
                            yA = (float) (this.lineOffsets[(int) yA]);
                            while (--yC >= 0.0F) {
                                drawGoraudScanline(raster, depthBuffer, (int) yA, 0, 0, (int) xA, (int) xB, hsvA, dhsv1, zA, depthSlope);
                                xB += cToA;
                                xA += bToC;
                                hsvA += dhsv2;
                                zA += depthIncrement;
                                yA += (float) rasterWidth;
                            }
                            while (--yB >= 0.0F) {
                                drawGoraudScanline(raster, depthBuffer, (int) yA, 0, 0, (int) xA, (int) xC, hsvA, dhsv1, zA, depthSlope);
                                xC += aToB;
                                xA += bToC;
                                hsvA += dhsv2;
                                zA += depthIncrement;
                                yA += (float) rasterWidth;
                            }
                        }
                    }
                } else if (yB <= yC) {
                    if (!(yB >= (float) this.height)) {
                        if (yC > (float) this.height) yC = (float) this.height;
                        if (yA > (float) this.height) yA = (float) this.height;
                        hsvB = hsvB - dhsv1 * xB + dhsv1;
                        zB = zB - depthSlope * xB + depthSlope;
                        if (yC < yA) {
                            xA = xB;
                            if (yB < 0.0F) {
                                xA -= bToC * yB;
                                xB -= aToB * yB;
                                hsvB -= dhsv2 * yB;
                                zB -= depthIncrement * yB;
                                yB = 0.0F;
                            }
                            if (yC < 0.0F) {
                                xC -= cToA * yC;
                                yC = 0.0F;
                            }
                            if (yB != yC && bToC < aToB || yB == yC && bToC > cToA) {
                                yA -= yC;
                                yC -= yB;
                                yB = (float) (this.lineOffsets[(int) yB]);
                                while (--yC >= 0.0F) {
                                    drawGoraudScanline(raster, depthBuffer, (int) yB, 0, 0, (int) xA, (int) xB, hsvB, dhsv1, zB, depthSlope);
                                    xA += bToC;
                                    xB += aToB;
                                    hsvB += dhsv2;
                                    zB += depthIncrement;
                                    yB += (float) rasterWidth;
                                }
                                while (--yA >= 0.0F) {
                                    drawGoraudScanline(raster, depthBuffer, (int) yB, 0, 0, (int) xA, (int) xC, hsvB, dhsv1, zB, depthSlope);
                                    xA += bToC;
                                    xC += cToA;
                                    hsvB += dhsv2;
                                    zB += depthIncrement;
                                    yB += (float) rasterWidth;
                                }
                            } else {
                                yA -= yC;
                                yC -= yB;
                                yB = (float) (this.lineOffsets[(int) yB]);
                                while (--yC >= 0.0F) {
                                    drawGoraudScanline(raster, depthBuffer, (int) yB, 0, 0, (int) xB, (int) xA, hsvB, dhsv1, zB, depthSlope);
                                    xA += bToC;
                                    xB += aToB;
                                    hsvB += dhsv2;
                                    zB += depthIncrement;
                                    yB += (float) rasterWidth;
                                }
                                while (--yA >= 0.0F) {
                                    drawGoraudScanline(raster, depthBuffer, (int) yB, 0, 0, (int) xC, (int) xA, hsvB, dhsv1, zB, depthSlope);
                                    xA += bToC;
                                    xC += cToA;
                                    hsvB += dhsv2;
                                    zB += depthIncrement;
                                    yB += (float) rasterWidth;
                                }
                            }
                        } else {
                            xC = xB;
                            if (yB < 0.0F) {
                                xC -= bToC * yB;
                                xB -= aToB * yB;
                                hsvB -= dhsv2 * yB;
                                zB -= depthIncrement * yB;
                                yB = 0.0F;
                            }
                            if (yA < 0.0F) {
                                xA -= cToA * yA;
                                yA = 0.0F;
                            }
                            if (bToC < aToB) {
                                yC -= yA;
                                yA -= yB;
                                yB = (float) (this.lineOffsets[(int) yB]);
                                while (--yA >= 0.0F) {
                                    drawGoraudScanline(raster, depthBuffer, (int) yB, 0, 0, (int) xC, (int) xB, hsvB, dhsv1, zB, depthSlope);
                                    xC += bToC;
                                    xB += aToB;
                                    hsvB += dhsv2;
                                    zB += depthIncrement;
                                    yB += (float) rasterWidth;
                                }
                                while (--yC >= 0.0F) {
                                    drawGoraudScanline(raster, depthBuffer, (int) yB, 0, 0, (int) xA, (int) xB, hsvB, dhsv1, zB, depthSlope);
                                    xA += cToA;
                                    xB += aToB;
                                    hsvB += dhsv2;
                                    zB += depthIncrement;
                                    yB += (float) rasterWidth;
                                }
                            } else {
                                yC -= yA;
                                yA -= yB;
                                yB = (float) (this.lineOffsets[(int) yB]);
                                while (--yA >= 0.0F) {
                                    drawGoraudScanline(raster, depthBuffer, (int) yB, 0, 0, (int) xB, (int) xC, hsvB, dhsv1, zB, depthSlope);
                                    xC += bToC;
                                    xB += aToB;
                                    hsvB += dhsv2;
                                    zB += depthIncrement;
                                    yB += (float) rasterWidth;
                                }
                                while (--yC >= 0.0F) {
                                    drawGoraudScanline(raster, depthBuffer, (int) yB, 0, 0, (int) xB, (int) xA, hsvB, dhsv1, zB, depthSlope);
                                    xA += cToA;
                                    xB += aToB;
                                    hsvB += dhsv2;
                                    zB += depthIncrement;
                                    yB += (float) rasterWidth;
                                }
                            }
                        }
                    }
                } else {
                    if (yC >= (float) this.height) {
                        return;
                    }
                    if (yA > (float) this.height) yA = (float) this.height;
                    if (yB > (float) this.height) yB = (float) this.height;
                    hsvC = hsvC - dhsv1 * xC + dhsv1;
                    zC = zC - depthSlope * xC + depthSlope;
                    if (yA < yB) {
                        xB = xC;
                        if (yC < 0.0F) {
                            xB -= aToB * yC;
                            xC -= cToA * yC;
                            hsvC -= dhsv2 * yC;
                            zC -= depthIncrement * yC;
                            yC = 0.0F;
                        }
                        if (yA < 0.0F) {
                            xA -= bToC * yA;
                            yA = 0.0F;
                        }
                        if (aToB < cToA) {
                            yB -= yA;
                            yA -= yC;
                            yC = (float) (this.lineOffsets[(int) yC]);
                            while (--yA >= 0.0F) {
                                drawGoraudScanline(raster, depthBuffer, (int) yC, 0, 0, (int) xB, (int) xC, hsvC, dhsv1, zC, depthSlope);
                                xB += aToB;
                                xC += cToA;
                                hsvC += dhsv2;
                                zC += depthIncrement;
                                yC += (float) rasterWidth;
                            }
                            while (--yB >= 0.0F) {
                                drawGoraudScanline(raster, depthBuffer, (int) yC, 0, 0, (int) xB, (int) xA, hsvC, dhsv1, zC, depthSlope);
                                xB += aToB;
                                xA += bToC;
                                hsvC += dhsv2;
                                zC += depthIncrement;
                                yC += (float) rasterWidth;
                            }
                        } else {
                            yB -= yA;
                            yA -= yC;
                            yC = (float) (this.lineOffsets[(int) yC]);
                            while (--yA >= 0.0F) {
                                drawGoraudScanline(raster, depthBuffer, (int) yC, 0, 0, (int) xC, (int) xB, hsvC, dhsv1, zC, depthSlope);
                                xB += aToB;
                                xC += cToA;
                                hsvC += dhsv2;
                                zC += depthIncrement;
                                yC += (float) rasterWidth;
                            }
                            while (--yB >= 0.0F) {
                                drawGoraudScanline(raster, depthBuffer, (int) yC, 0, 0, (int) xA, (int) xB, hsvC, dhsv1, zC, depthSlope);
                                xB += aToB;
                                xA += bToC;
                                hsvC += dhsv2;
                                zC += depthIncrement;
                                yC += (float) rasterWidth;
                            }
                        }
                    } else {
                        xA = xC;
                        if (yC < 0.0F) {
                            xA -= aToB * yC;
                            xC -= cToA * yC;
                            hsvC -= dhsv2 * yC;
                            zC -= depthIncrement * yC;
                            yC = 0.0F;
                        }
                        if (yB < 0.0F) {
                            xB -= bToC * yB;
                            yB = 0.0F;
                        }
                        if (aToB < cToA) {
                            yA -= yB;
                            yB -= yC;
                            yC = (float) (this.lineOffsets[(int) yC]);
                            while (--yB >= 0.0F) {
                                drawGoraudScanline(raster, depthBuffer, (int) yC, 0, 0, (int) xA, (int) xC, hsvC, dhsv1, zC, depthSlope);
                                xA += aToB;
                                xC += cToA;
                                hsvC += dhsv2;
                                zC += depthIncrement;
                                yC += (float) rasterWidth;
                            }
                            while (--yA >= 0.0F) {
                                drawGoraudScanline(raster, depthBuffer, (int) yC, 0, 0, (int) xB, (int) xC, hsvC, dhsv1, zC, depthSlope);
                                xB += bToC;
                                xC += cToA;
                                hsvC += dhsv2;
                                zC += depthIncrement;
                                yC += (float) rasterWidth;
                            }
                        } else {
                            yA -= yB;
                            yB -= yC;
                            yC = (float) (this.lineOffsets[(int) yC]);
                            while (--yB >= 0.0F) {
                                drawGoraudScanline(raster, depthBuffer, (int) yC, 0, 0, (int) xC, (int) xA, hsvC, dhsv1, zC, depthSlope);
                                xA += aToB;
                                xC += cToA;
                                hsvC += dhsv2;
                                zC += depthIncrement;
                                yC += (float) rasterWidth;
                            }
                            while (--yA >= 0.0F) {
                                drawGoraudScanline(raster, depthBuffer, (int) yC, 0, 0, (int) xC, (int) xB, hsvC, dhsv1, zC, depthSlope);
                                xB += bToC;
                                xC += cToA;
                                hsvC += dhsv2;
                                zC += depthIncrement;
                                yC += (float) rasterWidth;
                            }
                        }
                    }
                }
            }
        }
    }

    final void method1023(boolean bool) {
        useExternalRenderer = bool;
    }

    // method1024
    final void drawTexturedTriangle(float yA, float yB, float yC, float xA, float xB, float xC, float zA, float zB, float zC, float texCoordUA, float texCoordUB, float texCoordUC, float texCoordVA, float texCoordVB, float texCoordVC, int hsvA, int hsvB, int hsvC, int i_357_, int i_358_, int i_359_, int i_360_, int texture) {
        if (texture != anInt1697) {
            texturePixels = aJavaToolkit_1666.getArgbTexture(texture);
            if (texturePixels == null) {
                renderTriangleRgb((float) (int) yA, (float) (int) yB, (float) (int) yC, (float) (int) xA, (float) (int) xB, (float) (int) xC, (float) (int) zA, (float) (int) zB, (float) (int) zC, JavaBillboardFace.method206(hsvA, i_357_ | i_358_ << 24, 255), JavaBillboardFace.method206(hsvB, i_357_ | i_359_ << 24, 255), JavaBillboardFace.method206(hsvC, i_357_ | i_360_ << 24, 255));
                return;
            }
            textureSize = (aJavaToolkit_1666.smallTexture(texture) ? 64 : aJavaToolkit_1666.textureSize);
            textureLastIndex = textureSize - 1;
            textureAlphaBlendMode = aJavaToolkit_1666.textureAlphaBlendMode(texture);
            repeatTexture = aJavaToolkit_1666.textureRepeats(texture);
        }
        anInt1696 = i_357_;
        float f_362_ = (float) (hsvA >> 24 & 0xff);
        float f_363_ = (float) (hsvB >> 24 & 0xff);
        float f_364_ = (float) (hsvC >> 24 & 0xff);
        float f_365_ = (float) (hsvA >> 16 & 0xff);
        float f_366_ = (float) (hsvB >> 16 & 0xff);
        float f_367_ = (float) (hsvC >> 16 & 0xff);
        float f_368_ = (float) (hsvA >> 8 & 0xff);
        float f_369_ = (float) (hsvB >> 8 & 0xff);
        float f_370_ = (float) (hsvC >> 8 & 0xff);
        float f_371_ = (float) (hsvA & 0xff);
        float f_372_ = (float) (hsvB & 0xff);
        float f_373_ = (float) (hsvC & 0xff);
        texCoordUA /= zA;
        texCoordUB /= zB;
        texCoordUC /= zC;
        texCoordVA /= zA;
        texCoordVB /= zB;
        texCoordVC /= zC;
        zA = 1.0F / zA;
        zB = 1.0F / zB;
        zC = 1.0F / zC;
        float f_374_ = 0.0F;
        float f_375_ = 0.0F;
        float f_376_ = 0.0F;
        float f_377_ = 0.0F;
        float f_378_ = 0.0F;
        float f_379_ = 0.0F;
        float f_380_ = 0.0F;
        float f_381_ = 0.0F;
        float f_382_ = 0.0F;
        if (yB != yA) {
            float f_383_ = yB - yA;
            f_374_ = (xB - xA) / f_383_;
            f_375_ = (zB - zA) / f_383_;
            f_376_ = (texCoordUB - texCoordUA) / f_383_;
            f_377_ = (texCoordVB - texCoordVA) / f_383_;
            f_378_ = (float) (i_359_ - i_358_) / f_383_;
            f_379_ = (f_363_ - f_362_) / f_383_;
            f_380_ = (f_366_ - f_365_) / f_383_;
            f_381_ = (f_369_ - f_368_) / f_383_;
            f_382_ = (f_372_ - f_371_) / f_383_;
        }
        float f_384_ = 0.0F;
        float f_385_ = 0.0F;
        float f_386_ = 0.0F;
        float f_387_ = 0.0F;
        float f_388_ = 0.0F;
        float f_389_ = 0.0F;
        float f_390_ = 0.0F;
        float f_391_ = 0.0F;
        float f_392_ = 0.0F;
        if (yC != yB) {
            float f_393_ = yC - yB;
            f_384_ = (xC - xB) / f_393_;
            f_385_ = (zC - zB) / f_393_;
            f_386_ = (texCoordUC - texCoordUB) / f_393_;
            f_387_ = (texCoordVC - texCoordVB) / f_393_;
            f_388_ = (float) (i_360_ - i_359_) / f_393_;
            f_389_ = (f_364_ - f_363_) / f_393_;
            f_390_ = (f_367_ - f_366_) / f_393_;
            f_391_ = (f_370_ - f_369_) / f_393_;
            f_392_ = (f_373_ - f_372_) / f_393_;
        }
        float f_394_ = 0.0F;
        float f_395_ = 0.0F;
        float f_396_ = 0.0F;
        float f_397_ = 0.0F;
        float f_398_ = 0.0F;
        float f_399_ = 0.0F;
        float f_400_ = 0.0F;
        float f_401_ = 0.0F;
        float f_402_ = 0.0F;
        if (yA != yC) {
            float f_403_ = yA - yC;
            f_394_ = (xA - xC) / f_403_;
            f_395_ = (zA - zC) / f_403_;
            f_396_ = (texCoordUA - texCoordUC) / f_403_;
            f_397_ = (texCoordVA - texCoordVC) / f_403_;
            f_398_ = (float) (i_358_ - i_360_) / f_403_;
            f_399_ = (f_362_ - f_364_) / f_403_;
            f_400_ = (f_365_ - f_367_) / f_403_;
            f_401_ = (f_368_ - f_370_) / f_403_;
            f_402_ = (f_371_ - f_373_) / f_403_;
        }
        if (yA <= yB && yA <= yC) {
            if (yA >= (float) this.height) {
                return;
            }
            if (yB > (float) this.height) yB = (float) this.height;
            if (yC > (float) this.height) yC = (float) this.height;
            if (yB < yC) {
                xC = xA;
                zC = zA;
                texCoordUC = texCoordUA;
                texCoordVC = texCoordVA;
                i_360_ = i_358_;
                f_364_ = f_362_;
                f_367_ = f_365_;
                f_370_ = f_368_;
                f_373_ = f_371_;
                if (yA < 0.0F) {
                    xA -= f_374_ * yA;
                    xC -= f_394_ * yA;
                    zA -= f_375_ * yA;
                    zC -= f_395_ * yA;
                    texCoordUA -= f_376_ * yA;
                    texCoordUC -= f_396_ * yA;
                    texCoordVA -= f_377_ * yA;
                    texCoordVC -= f_397_ * yA;
                    i_358_ -= f_378_ * yA;
                    i_360_ -= f_398_ * yA;
                    f_362_ -= f_379_ * yA;
                    f_364_ -= f_399_ * yA;
                    f_365_ -= f_379_ * yA;
                    f_367_ -= f_399_ * yA;
                    f_368_ -= f_379_ * yA;
                    f_370_ -= f_399_ * yA;
                    f_371_ -= f_379_ * yA;
                    f_373_ -= f_399_ * yA;
                    yA = 0.0F;
                }
                if (yB < 0.0F) {
                    xB -= f_384_ * yB;
                    zB -= f_385_ * yB;
                    texCoordUB -= f_386_ * yB;
                    texCoordVB -= f_387_ * yB;
                    i_359_ -= f_388_ * yB;
                    f_363_ -= f_389_ * yB;
                    f_366_ -= f_390_ * yB;
                    f_369_ -= f_391_ * yB;
                    f_372_ -= f_392_ * yB;
                    yB = 0.0F;
                }
                if (yA != yB && f_394_ < f_374_ || yA == yB && f_394_ > f_384_) {
                    yC -= yB;
                    yB -= yA;
                    yA = (float) this.lineOffsets[(int) yA];
                    while (--yB >= 0.0F) {
                        drawTexturedScanline(raster, texturePixels, (int) yA, (int) xC, (int) xA, zC, zA, texCoordUC, texCoordUA, texCoordVC, texCoordVA, (float) i_360_, (float) i_358_, f_364_, f_362_, f_367_, f_365_, f_370_, f_368_, f_373_, f_371_);
                        xA += f_374_;
                        xC += f_394_;
                        zA += f_375_;
                        zC += f_395_;
                        texCoordUA += f_376_;
                        texCoordUC += f_396_;
                        texCoordVA += f_377_;
                        texCoordVC += f_397_;
                        i_358_ += f_378_;
                        i_360_ += f_398_;
                        f_362_ += f_379_;
                        f_364_ += f_399_;
                        f_365_ += f_380_;
                        f_367_ += f_400_;
                        f_368_ += f_381_;
                        f_370_ += f_401_;
                        f_371_ += f_382_;
                        f_373_ += f_402_;
                        yA += (float) rasterWidth;
                    }
                    while (--yC >= 0.0F) {
                        drawTexturedScanline(raster, texturePixels, (int) yA, (int) xC, (int) xB, zC, zB, texCoordUC, texCoordUB, texCoordVC, texCoordVB, (float) i_360_, (float) i_359_, f_364_, f_363_, f_367_, f_366_, f_370_, f_369_, f_373_, f_372_);
                        xB += f_384_;
                        xC += f_394_;
                        zB += f_385_;
                        zC += f_395_;
                        texCoordUB += f_386_;
                        texCoordUC += f_396_;
                        texCoordVB += f_387_;
                        texCoordVC += f_397_;
                        i_359_ += f_388_;
                        i_360_ += f_398_;
                        f_363_ += f_389_;
                        f_364_ += f_399_;
                        f_366_ += f_390_;
                        f_367_ += f_400_;
                        f_369_ += f_391_;
                        f_370_ += f_401_;
                        f_372_ += f_392_;
                        f_373_ += f_402_;
                        yA += (float) rasterWidth;
                    }
                } else {
                    yC -= yB;
                    yB -= yA;
                    yA = (float) this.lineOffsets[(int) yA];
                    while (--yB >= 0.0F) {
                        drawTexturedScanline(raster, texturePixels, (int) yA, (int) xA, (int) xC, zA, zC, texCoordUA, texCoordUC, texCoordVA, texCoordVC, (float) i_358_, (float) i_360_, f_362_, f_364_, f_365_, f_367_, f_368_, f_370_, f_371_, f_373_);
                        xA += f_374_;
                        xC += f_394_;
                        zA += f_375_;
                        zC += f_395_;
                        texCoordUA += f_376_;
                        texCoordUC += f_396_;
                        texCoordVA += f_377_;
                        texCoordVC += f_397_;
                        i_358_ += f_378_;
                        i_360_ += f_398_;
                        f_362_ += f_379_;
                        f_364_ += f_399_;
                        f_365_ += f_380_;
                        f_367_ += f_400_;
                        f_368_ += f_381_;
                        f_370_ += f_401_;
                        f_371_ += f_382_;
                        f_373_ += f_402_;
                        yA += (float) rasterWidth;
                    }
                    while (--yC >= 0.0F) {
                        drawTexturedScanline(raster, texturePixels, (int) yA, (int) xB, (int) xC, zB, zC, texCoordUB, texCoordUC, texCoordVB, texCoordVC, (float) i_359_, (float) i_360_, f_363_, f_364_, f_366_, f_367_, f_369_, f_370_, f_372_, f_373_);
                        xB += f_384_;
                        xC += f_394_;
                        zB += f_385_;
                        zC += f_395_;
                        texCoordUB += f_386_;
                        texCoordUC += f_396_;
                        texCoordVB += f_387_;
                        texCoordVC += f_397_;
                        i_359_ += f_388_;
                        i_360_ += f_398_;
                        f_363_ += f_389_;
                        f_364_ += f_399_;
                        f_366_ += f_390_;
                        f_367_ += f_400_;
                        f_369_ += f_391_;
                        f_370_ += f_401_;
                        f_372_ += f_392_;
                        f_373_ += f_402_;
                        yA += (float) rasterWidth;
                    }
                }
            } else {
                xB = xA;
                zB = zA;
                texCoordUB = texCoordUA;
                texCoordVB = texCoordVA;
                i_359_ = i_358_;
                f_363_ = f_362_;
                f_366_ = f_365_;
                f_369_ = f_368_;
                f_372_ = f_371_;
                if (yA < 0.0F) {
                    xA -= f_374_ * yA;
                    xB -= f_394_ * yA;
                    zA -= f_375_ * yA;
                    zB -= f_395_ * yA;
                    texCoordUA -= f_376_ * yA;
                    texCoordUB -= f_396_ * yA;
                    texCoordVA -= f_377_ * yA;
                    texCoordVB -= f_397_ * yA;
                    i_358_ -= f_378_ * yA;
                    i_359_ -= f_398_ * yA;
                    f_362_ -= f_379_ * yA;
                    f_363_ -= f_399_ * yA;
                    f_365_ -= f_379_ * yA;
                    f_366_ -= f_399_ * yA;
                    f_368_ -= f_379_ * yA;
                    f_369_ -= f_399_ * yA;
                    f_371_ -= f_379_ * yA;
                    f_372_ -= f_399_ * yA;
                    yA = 0.0F;
                }
                if (yC < 0.0F) {
                    xC -= f_384_ * yC;
                    zC -= f_385_ * yC;
                    texCoordUC -= f_386_ * yC;
                    texCoordVC -= f_387_ * yC;
                    i_360_ -= f_388_ * yC;
                    f_364_ -= f_389_ * yC;
                    f_367_ -= f_390_ * yC;
                    f_370_ -= f_391_ * yC;
                    f_373_ -= f_392_ * yC;
                    yC = 0.0F;
                }
                if (yA != yC && f_394_ < f_374_ || yA == yC && f_384_ > f_374_) {
                    yB -= yC;
                    yC -= yA;
                    yA = (float) this.lineOffsets[(int) yA];
                    while (--yC >= 0.0F) {
                        drawTexturedScanline(raster, texturePixels, (int) yA, (int) xB, (int) xA, zB, zA, texCoordUB, texCoordUA, texCoordVB, texCoordVA, (float) i_359_, (float) i_358_, f_363_, f_362_, f_366_, f_365_, f_369_, f_368_, f_372_, f_371_);
                        xA += f_374_;
                        xB += f_394_;
                        zA += f_375_;
                        zB += f_395_;
                        texCoordUA += f_376_;
                        texCoordUB += f_396_;
                        texCoordVA += f_377_;
                        texCoordVB += f_397_;
                        i_358_ += f_378_;
                        i_359_ += f_398_;
                        f_362_ += f_379_;
                        f_363_ += f_399_;
                        f_365_ += f_380_;
                        f_366_ += f_400_;
                        f_368_ += f_381_;
                        f_369_ += f_401_;
                        f_371_ += f_382_;
                        f_372_ += f_402_;
                        yA += (float) rasterWidth;
                    }
                    while (--yB >= 0.0F) {
                        drawTexturedScanline(raster, texturePixels, (int) yA, (int) xC, (int) xA, zC, zA, texCoordUC, texCoordUA, texCoordVC, texCoordVA, (float) i_360_, (float) i_358_, f_364_, f_362_, f_367_, f_365_, f_370_, f_368_, f_373_, f_371_);
                        xC += f_384_;
                        xA += f_374_;
                        zC += f_385_;
                        zA += f_375_;
                        texCoordUC += f_386_;
                        texCoordUA += f_376_;
                        texCoordVC += f_387_;
                        texCoordVA += f_377_;
                        i_360_ += f_388_;
                        i_358_ += f_378_;
                        f_364_ += f_389_;
                        f_362_ += f_379_;
                        f_367_ += f_390_;
                        f_365_ += f_380_;
                        f_370_ += f_391_;
                        f_368_ += f_381_;
                        f_373_ += f_392_;
                        f_371_ += f_382_;
                        yA += (float) rasterWidth;
                    }
                } else {
                    yB -= yC;
                    yC -= yA;
                    yA = (float) this.lineOffsets[(int) yA];
                    while (--yC >= 0.0F) {
                        drawTexturedScanline(raster, texturePixels, (int) yA, (int) xA, (int) xB, zA, zB, texCoordUA, texCoordUB, texCoordVA, texCoordVB, (float) i_358_, (float) i_359_, f_362_, f_363_, f_365_, f_366_, f_368_, f_369_, f_371_, f_372_);
                        xB += f_394_;
                        xA += f_374_;
                        zB += f_395_;
                        zA += f_375_;
                        texCoordUB += f_396_;
                        texCoordUA += f_376_;
                        texCoordVB += f_397_;
                        texCoordVA += f_377_;
                        i_359_ += f_398_;
                        i_358_ += f_378_;
                        f_363_ += f_399_;
                        f_362_ += f_379_;
                        f_366_ += f_400_;
                        f_365_ += f_380_;
                        f_369_ += f_401_;
                        f_368_ += f_381_;
                        f_372_ += f_402_;
                        f_371_ += f_382_;
                        yA += (float) rasterWidth;
                    }
                    while (--yB >= 0.0F) {
                        drawTexturedScanline(raster, texturePixels, (int) yA, (int) xA, (int) xC, zA, zC, texCoordUA, texCoordUC, texCoordVA, texCoordVC, (float) i_358_, (float) i_360_, f_362_, f_364_, f_365_, f_367_, f_368_, f_370_, f_371_, f_373_);
                        xA += f_374_;
                        xC += f_384_;
                        zA += f_375_;
                        zC += f_385_;
                        texCoordUA += f_376_;
                        texCoordUC += f_386_;
                        texCoordVA += f_377_;
                        texCoordVC += f_387_;
                        i_358_ += f_378_;
                        i_360_ += f_388_;
                        f_362_ += f_379_;
                        f_364_ += f_389_;
                        f_365_ += f_380_;
                        f_367_ += f_390_;
                        f_368_ += f_381_;
                        f_370_ += f_391_;
                        f_371_ += f_382_;
                        f_373_ += f_392_;
                        yA += (float) rasterWidth;
                    }
                }
            }
        } else if (yB <= yC) {
            if (!(yB >= (float) this.height)) {
                if (yC > (float) this.height) yC = (float) this.height;
                if (yA > (float) this.height) yA = (float) this.height;
                if (yC < yA) {
                    xA = xB;
                    zA = zB;
                    texCoordUA = texCoordUB;
                    texCoordVA = texCoordVB;
                    i_358_ = i_359_;
                    f_362_ = f_363_;
                    f_365_ = f_366_;
                    f_368_ = f_369_;
                    f_371_ = f_372_;
                    if (yB < 0.0F) {
                        xA -= f_374_ * yB;
                        xB -= f_384_ * yB;
                        zA -= f_375_ * yB;
                        zB -= f_385_ * yB;
                        texCoordUA -= f_376_ * yB;
                        texCoordUB -= f_386_ * yB;
                        texCoordVA -= f_377_ * yB;
                        texCoordVB -= f_387_ * yB;
                        i_358_ -= f_378_ * yB;
                        i_359_ -= f_388_ * yB;
                        f_362_ -= f_379_ * yB;
                        f_363_ -= f_389_ * yB;
                        f_365_ -= f_380_ * yB;
                        f_366_ -= f_390_ * yB;
                        f_368_ -= f_381_ * yB;
                        f_369_ -= f_391_ * yB;
                        f_371_ -= f_382_ * yB;
                        f_372_ -= f_392_ * yB;
                        yB = 0.0F;
                    }
                    if (yC < 0.0F) {
                        xC -= f_394_ * yC;
                        zC -= f_395_ * yC;
                        texCoordUC -= f_396_ * yC;
                        texCoordVC -= f_397_ * yC;
                        i_360_ -= f_398_ * yC;
                        f_364_ -= f_399_ * yC;
                        f_367_ -= f_400_ * yC;
                        f_370_ -= f_401_ * yC;
                        f_373_ -= f_402_ * yC;
                        yC = 0.0F;
                    }
                    if (yB != yC && f_374_ < f_384_ || yB == yC && f_374_ > f_394_) {
                        yA -= yC;
                        yC -= yB;
                        yB = (float) (this.lineOffsets[(int) yB]);
                        while (--yC >= 0.0F) {
                            drawTexturedScanline(raster, texturePixels, (int) yB, (int) xA, (int) xB, zA, zB, texCoordUA, texCoordUB, texCoordVA, texCoordVB, (float) i_358_, (float) i_359_, f_362_, f_363_, f_365_, f_366_, f_368_, f_369_, f_371_, f_372_);
                            xA += f_374_;
                            xB += f_384_;
                            zA += f_375_;
                            zB += f_385_;
                            texCoordUA += f_376_;
                            texCoordUB += f_386_;
                            texCoordVA += f_377_;
                            texCoordVB += f_387_;
                            i_358_ += f_378_;
                            i_359_ += f_388_;
                            f_362_ += f_379_;
                            f_363_ += f_389_;
                            f_365_ += f_380_;
                            f_366_ += f_390_;
                            f_368_ += f_381_;
                            f_369_ += f_391_;
                            f_371_ += f_382_;
                            f_372_ += f_392_;
                            yB += (float) rasterWidth;
                        }
                        while (--yA >= 0.0F) {
                            drawTexturedScanline(raster, texturePixels, (int) yB, (int) xA, (int) xC, zA, zC, texCoordUA, texCoordUC, texCoordVA, texCoordVC, (float) i_358_, (float) i_360_, f_362_, f_364_, f_365_, f_367_, f_368_, f_370_, f_371_, f_373_);
                            xA += f_374_;
                            xC += f_394_;
                            zA += f_375_;
                            zC += f_395_;
                            texCoordUA += f_376_;
                            texCoordUC += f_396_;
                            texCoordVA += f_377_;
                            texCoordVC += f_397_;
                            i_358_ += f_378_;
                            i_360_ += f_398_;
                            f_362_ += f_379_;
                            f_364_ += f_399_;
                            f_365_ += f_380_;
                            f_367_ += f_400_;
                            f_368_ += f_381_;
                            f_370_ += f_401_;
                            f_371_ += f_382_;
                            f_373_ += f_402_;
                            yB += (float) rasterWidth;
                        }
                    } else {
                        yA -= yC;
                        yC -= yB;
                        yB = (float) (this.lineOffsets[(int) yB]);
                        while (--yC >= 0.0F) {
                            drawTexturedScanline(raster, texturePixels, (int) yB, (int) xB, (int) xA, zB, zA, texCoordUB, texCoordUA, texCoordVB, texCoordVA, (float) i_359_, (float) i_358_, f_363_, f_362_, f_366_, f_365_, f_369_, f_368_, f_372_, f_371_);
                            xB += f_384_;
                            xA += f_374_;
                            zB += f_385_;
                            zA += f_375_;
                            texCoordUB += f_386_;
                            texCoordUA += f_376_;
                            texCoordVB += f_387_;
                            texCoordVA += f_377_;
                            i_359_ += f_388_;
                            i_358_ += f_378_;
                            f_363_ += f_389_;
                            f_362_ += f_379_;
                            f_366_ += f_390_;
                            f_365_ += f_380_;
                            f_369_ += f_391_;
                            f_368_ += f_381_;
                            f_372_ += f_392_;
                            f_371_ += f_382_;
                            yB += (float) rasterWidth;
                        }
                        while (--yA >= 0.0F) {
                            drawTexturedScanline(raster, texturePixels, (int) yB, (int) xC, (int) xA, zC, zA, texCoordUC, texCoordUA, texCoordVC, texCoordVA, (float) i_360_, (float) i_358_, f_364_, f_362_, f_367_, f_365_, f_370_, f_368_, f_373_, f_371_);
                            xC += f_394_;
                            xA += f_374_;
                            zC += f_395_;
                            zA += f_375_;
                            texCoordUC += f_396_;
                            texCoordUA += f_376_;
                            texCoordVC += f_397_;
                            texCoordVA += f_377_;
                            i_360_ += f_398_;
                            i_358_ += f_378_;
                            f_364_ += f_399_;
                            f_362_ += f_379_;
                            f_367_ += f_400_;
                            f_365_ += f_380_;
                            f_370_ += f_401_;
                            f_368_ += f_381_;
                            f_373_ += f_402_;
                            f_371_ += f_382_;
                            yB += (float) rasterWidth;
                        }
                    }
                } else {
                    xC = xB;
                    zC = zB;
                    texCoordUC = texCoordUB;
                    texCoordVC = texCoordVB;
                    i_360_ = i_359_;
                    f_364_ = f_363_;
                    f_367_ = f_366_;
                    f_370_ = f_369_;
                    f_373_ = f_372_;
                    if (yB < 0.0F) {
                        xC -= f_374_ * yB;
                        xB -= f_384_ * yB;
                        zC -= f_375_ * yB;
                        zB -= f_385_ * yB;
                        texCoordUC -= f_376_ * yB;
                        texCoordUB -= f_386_ * yB;
                        texCoordVC -= f_377_ * yB;
                        texCoordVB -= f_387_ * yB;
                        i_360_ -= f_378_ * yB;
                        i_359_ -= f_388_ * yB;
                        f_364_ -= f_379_ * yB;
                        f_363_ -= f_389_ * yB;
                        f_367_ -= f_380_ * yB;
                        f_366_ -= f_390_ * yB;
                        f_370_ -= f_381_ * yB;
                        f_369_ -= f_391_ * yB;
                        f_373_ -= f_382_ * yB;
                        f_372_ -= f_392_ * yB;
                        yB = 0.0F;
                    }
                    if (yA < 0.0F) {
                        xA -= f_394_ * yA;
                        zA -= f_395_ * yA;
                        texCoordUA -= f_396_ * yA;
                        texCoordVA -= f_397_ * yA;
                        i_358_ -= f_398_ * yA;
                        f_362_ -= f_399_ * yA;
                        f_365_ -= f_400_ * yA;
                        f_368_ -= f_401_ * yA;
                        f_371_ -= f_402_ * yA;
                        yA = 0.0F;
                    }
                    yC -= yA;
                    yA -= yB;
                    yB = (float) (this.lineOffsets[(int) yB]);
                    if (f_374_ < f_384_) {
                        while (--yA >= 0.0F) {
                            drawTexturedScanline(raster, texturePixels, (int) yB, (int) xC, (int) xB, zC, zB, texCoordUC, texCoordUB, texCoordVC, texCoordVB, (float) i_360_, (float) i_359_, f_364_, f_363_, f_367_, f_366_, f_370_, f_369_, f_373_, f_372_);
                            xC += f_374_;
                            xB += f_384_;
                            zC += f_375_;
                            zB += f_385_;
                            texCoordUC += f_376_;
                            texCoordUB += f_386_;
                            texCoordVC += f_377_;
                            texCoordVB += f_387_;
                            i_360_ += f_378_;
                            i_359_ += f_388_;
                            f_364_ += f_379_;
                            f_363_ += f_389_;
                            f_367_ += f_380_;
                            f_366_ += f_390_;
                            f_370_ += f_381_;
                            f_369_ += f_391_;
                            f_373_ += f_382_;
                            f_372_ += f_392_;
                            yB += (float) rasterWidth;
                        }
                        while (--yC >= 0.0F) {
                            drawTexturedScanline(raster, texturePixels, (int) yB, (int) xA, (int) xB, zA, zB, texCoordUA, texCoordUB, texCoordVA, texCoordVB, (float) i_358_, (float) i_359_, f_362_, f_363_, f_365_, f_366_, f_368_, f_369_, f_371_, f_372_);
                            xA += f_394_;
                            xB += f_384_;
                            zA += f_395_;
                            zB += f_385_;
                            texCoordUA += f_396_;
                            texCoordUB += f_386_;
                            texCoordVA += f_397_;
                            texCoordVB += f_387_;
                            i_358_ += f_398_;
                            i_359_ += f_388_;
                            f_362_ += f_399_;
                            f_363_ += f_389_;
                            f_365_ += f_400_;
                            f_366_ += f_390_;
                            f_368_ += f_401_;
                            f_369_ += f_391_;
                            f_371_ += f_402_;
                            f_372_ += f_392_;
                            yB += (float) rasterWidth;
                        }
                    } else {
                        while (--yA >= 0.0F) {
                            drawTexturedScanline(raster, texturePixels, (int) yB, (int) xB, (int) xC, zB, zC, texCoordUB, texCoordUC, texCoordVB, texCoordVC, (float) i_359_, (float) i_360_, f_363_, f_364_, f_366_, f_367_, f_369_, f_370_, f_372_, f_373_);
                            xB += f_384_;
                            xC += f_374_;
                            zB += f_385_;
                            zC += f_375_;
                            texCoordUB += f_386_;
                            texCoordUC += f_376_;
                            texCoordVB += f_387_;
                            texCoordVC += f_377_;
                            i_359_ += f_388_;
                            i_360_ += f_378_;
                            f_363_ += f_389_;
                            f_364_ += f_379_;
                            f_366_ += f_390_;
                            f_367_ += f_380_;
                            f_369_ += f_391_;
                            f_370_ += f_381_;
                            f_372_ += f_392_;
                            f_373_ += f_382_;
                            yB += (float) rasterWidth;
                        }
                        while (--yC >= 0.0F) {
                            drawTexturedScanline(raster, texturePixels, (int) yB, (int) xB, (int) xA, zB, zA, texCoordUB, texCoordUA, texCoordVB, texCoordVA, (float) i_359_, (float) i_358_, f_363_, f_362_, f_366_, f_365_, f_369_, f_368_, f_372_, f_371_);
                            xB += f_384_;
                            xA += f_394_;
                            zB += f_385_;
                            zA += f_395_;
                            texCoordUB += f_386_;
                            texCoordUA += f_396_;
                            texCoordVB += f_387_;
                            texCoordVA += f_397_;
                            i_359_ += f_388_;
                            i_358_ += f_398_;
                            f_363_ += f_389_;
                            f_362_ += f_399_;
                            f_366_ += f_390_;
                            f_365_ += f_400_;
                            f_369_ += f_391_;
                            f_368_ += f_401_;
                            f_372_ += f_392_;
                            f_371_ += f_402_;
                            yB += (float) rasterWidth;
                        }
                    }
                }
            }
        } else if (!(yC >= (float) this.height)) {
            if (yA > (float) this.height) yA = (float) this.height;
            if (yB > (float) this.height) yB = (float) this.height;
            if (yA < yB) {
                xB = xC;
                zB = zC;
                texCoordUB = texCoordUC;
                texCoordVB = texCoordVC;
                i_359_ = i_360_;
                f_363_ = f_364_;
                f_366_ = f_367_;
                f_369_ = f_370_;
                f_372_ = f_373_;
                if (yC < 0.0F) {
                    xC -= f_394_ * yC;
                    xB -= f_384_ * yC;
                    zC -= f_395_ * yC;
                    zB -= f_385_ * yC;
                    texCoordUC -= f_396_ * yC;
                    texCoordUB -= f_386_ * yC;
                    texCoordVC -= f_397_ * yC;
                    texCoordVB -= f_387_ * yC;
                    i_360_ -= f_398_ * 3.0F;
                    i_359_ -= f_388_ * yC;
                    f_364_ -= f_399_ * yC;
                    f_363_ -= f_389_ * yC;
                    f_367_ -= f_400_ * yC;
                    f_366_ -= f_390_ * yC;
                    f_370_ -= f_401_ * yC;
                    f_369_ -= f_391_ * yC;
                    f_373_ -= f_402_ * yC;
                    f_372_ -= f_392_ * yC;
                    yC = 0.0F;
                }
                if (yA < 0.0F) {
                    xA -= f_374_ * yA;
                    zA -= f_375_ * yA;
                    texCoordUA -= f_376_ * yA;
                    texCoordVA -= f_377_ * yA;
                    i_358_ -= f_378_ * yA;
                    f_362_ -= f_379_ * yA;
                    f_365_ -= f_380_ * yA;
                    f_368_ -= f_381_ * yA;
                    f_371_ -= f_382_ * yA;
                    yA = 0.0F;
                }
                if (f_384_ < f_394_) {
                    yB -= yA;
                    yA -= yC;
                    yC = (float) (this.lineOffsets[(int) yC]);
                    while (--yA >= 0.0F) {
                        drawTexturedScanline(raster, texturePixels, (int) yC, (int) xB, (int) xC, zB, zC, texCoordUB, texCoordUC, texCoordVB, texCoordVC, (float) i_359_, (float) i_360_, f_363_, f_364_, f_366_, f_367_, f_369_, f_370_, f_372_, f_373_);
                        xB += f_384_;
                        xC += f_394_;
                        zB += f_385_;
                        zC += f_395_;
                        texCoordUB += f_386_;
                        texCoordUC += f_396_;
                        texCoordVB += f_387_;
                        texCoordVC += f_397_;
                        i_359_ += f_388_;
                        i_360_ += f_398_;
                        f_363_ += f_389_;
                        f_364_ += f_399_;
                        f_366_ += f_390_;
                        f_367_ += f_400_;
                        f_369_ += f_391_;
                        f_370_ += f_401_;
                        f_372_ += f_392_;
                        f_373_ += f_402_;
                        yC += (float) rasterWidth;
                    }
                    while (--yB >= 0.0F) {
                        drawTexturedScanline(raster, texturePixels, (int) yC, (int) xB, (int) xA, zB, zA, texCoordUB, texCoordUA, texCoordVB, texCoordVA, (float) i_359_, (float) i_358_, f_363_, f_362_, f_366_, f_365_, f_369_, f_368_, f_372_, f_371_);
                        xB += f_384_;
                        xA += f_374_;
                        zB += f_385_;
                        zA += f_375_;
                        texCoordUB += f_386_;
                        texCoordUA += f_376_;
                        texCoordVB += f_387_;
                        texCoordVA += f_377_;
                        i_359_ += f_388_;
                        i_358_ += f_378_;
                        f_363_ += f_389_;
                        f_362_ += f_379_;
                        f_366_ += f_390_;
                        f_365_ += f_380_;
                        f_369_ += f_391_;
                        f_368_ += f_381_;
                        f_372_ += f_392_;
                        f_371_ += f_382_;
                        yC += (float) rasterWidth;
                    }
                } else {
                    yB -= yA;
                    yA -= yC;
                    yC = (float) (this.lineOffsets[(int) yC]);
                    while (--yA >= 0.0F) {
                        drawTexturedScanline(raster, texturePixels, (int) yC, (int) xC, (int) xB, zC, zB, texCoordUC, texCoordUB, texCoordVC, texCoordVB, (float) i_360_, (float) i_359_, f_364_, f_363_, f_367_, f_366_, f_370_, f_369_, f_373_, f_372_);
                        xC += f_394_;
                        xB += f_384_;
                        zC += f_395_;
                        zB += f_385_;
                        texCoordUC += f_396_;
                        texCoordUB += f_386_;
                        texCoordVC += f_397_;
                        texCoordVB += f_387_;
                        i_360_ += f_398_;
                        i_359_ += f_388_;
                        f_364_ += f_399_;
                        f_363_ += f_389_;
                        f_367_ += f_400_;
                        f_366_ += f_390_;
                        f_370_ += f_401_;
                        f_369_ += f_391_;
                        f_373_ += f_402_;
                        f_372_ += f_392_;
                        yC += (float) rasterWidth;
                    }
                    while (--yB >= 0.0F) {
                        drawTexturedScanline(raster, texturePixels, (int) yC, (int) xA, (int) xB, zA, zB, texCoordUA, texCoordUB, texCoordVA, texCoordVB, (float) i_358_, (float) i_359_, f_362_, f_363_, f_365_, f_366_, f_368_, f_369_, f_371_, f_372_);
                        xA += f_374_;
                        xB += f_384_;
                        zA += f_375_;
                        zB += f_385_;
                        texCoordUA += f_376_;
                        texCoordUB += f_386_;
                        texCoordVA += f_377_;
                        texCoordVB += f_387_;
                        i_358_ += f_378_;
                        i_359_ += f_388_;
                        f_362_ += f_379_;
                        f_363_ += f_389_;
                        f_365_ += f_380_;
                        f_366_ += f_390_;
                        f_368_ += f_381_;
                        f_369_ += f_391_;
                        f_371_ += f_382_;
                        f_372_ += f_392_;
                        yC += (float) rasterWidth;
                    }
                }
            } else {
                xA = xC;
                zA = zC;
                texCoordUA = texCoordUC;
                texCoordVA = texCoordVC;
                i_358_ = i_360_;
                f_362_ = f_364_;
                f_365_ = f_367_;
                f_368_ = f_370_;
                f_371_ = f_373_;
                if (yC < 0.0F) {
                    xC -= f_394_ * yC;
                    xA -= f_384_ * yC;
                    zC -= f_395_ * yC;
                    zA -= f_385_ * yC;
                    texCoordUC -= f_396_ * yC;
                    texCoordUA -= f_386_ * yC;
                    texCoordVC -= f_397_ * yC;
                    texCoordVA -= f_387_ * yC;
                    i_360_ -= f_398_ * 3.0F;
                    i_358_ -= f_388_ * yC;
                    f_364_ -= f_399_ * yC;
                    f_362_ -= f_389_ * yC;
                    f_367_ -= f_400_ * yC;
                    f_365_ -= f_390_ * yC;
                    f_370_ -= f_401_ * yC;
                    f_368_ -= f_391_ * yC;
                    f_373_ -= f_402_ * yC;
                    f_371_ -= f_392_ * yC;
                    yC = 0.0F;
                }
                if (yB < 0.0F) {
                    xB -= f_374_ * yB;
                    zB -= f_375_ * yB;
                    texCoordUB -= f_376_ * yB;
                    texCoordVB -= f_377_ * yB;
                    i_359_ -= f_378_ * yB;
                    f_363_ -= f_379_ * yB;
                    f_366_ -= f_380_ * yB;
                    f_369_ -= f_381_ * yB;
                    f_372_ -= f_382_ * yB;
                    yB = 0.0F;
                }
                if (f_384_ < f_394_) {
                    yA -= yB;
                    yB -= yC;
                    yC = (float) (this.lineOffsets[(int) yC]);
                    while (--yB >= 0.0F) {
                        drawTexturedScanline(raster, texturePixels, (int) yC, (int) xA, (int) xC, zA, zC, texCoordUA, texCoordUC, texCoordVA, texCoordVC, (float) i_358_, (float) i_360_, f_362_, f_364_, f_365_, f_367_, f_368_, f_370_, f_371_, f_373_);
                        xA += f_384_;
                        xC += f_394_;
                        zA += f_385_;
                        zC += f_395_;
                        texCoordUA += f_386_;
                        texCoordUC += f_396_;
                        texCoordVA += f_387_;
                        texCoordVC += f_397_;
                        i_358_ += f_388_;
                        i_360_ += f_398_;
                        f_362_ += f_389_;
                        f_364_ += f_399_;
                        f_365_ += f_390_;
                        f_367_ += f_400_;
                        f_368_ += f_391_;
                        f_370_ += f_401_;
                        f_371_ += f_392_;
                        f_373_ += f_402_;
                        yC += (float) rasterWidth;
                    }
                    while (--yA >= 0.0F) {
                        drawTexturedScanline(raster, texturePixels, (int) yC, (int) xB, (int) xC, zB, zC, texCoordUB, texCoordUC, texCoordVB, texCoordVC, (float) i_359_, (float) i_360_, f_363_, f_364_, f_366_, f_367_, f_369_, f_370_, f_372_, f_373_);
                        xB += f_374_;
                        xC += f_394_;
                        zB += f_375_;
                        zC += f_395_;
                        texCoordUB += f_376_;
                        texCoordUC += f_396_;
                        texCoordVB += f_377_;
                        texCoordVC += f_397_;
                        i_359_ += f_378_;
                        i_360_ += f_398_;
                        f_363_ += f_379_;
                        f_364_ += f_399_;
                        f_366_ += f_380_;
                        f_367_ += f_400_;
                        f_369_ += f_381_;
                        f_370_ += f_401_;
                        f_372_ += f_382_;
                        f_373_ += f_402_;
                        yC += (float) rasterWidth;
                    }
                } else {
                    yA -= yB;
                    yB -= yC;
                    yC = (float) (this.lineOffsets[(int) yC]);
                    while (--yB >= 0.0F) {
                        drawTexturedScanline(raster, texturePixels, (int) yC, (int) xC, (int) xA, zC, zA, texCoordUC, texCoordUA, texCoordVC, texCoordVA, (float) i_360_, (float) i_358_, f_364_, f_362_, f_367_, f_365_, f_370_, f_368_, f_373_, f_371_);
                        xC += f_394_;
                        xA += f_384_;
                        zC += f_395_;
                        zA += f_385_;
                        texCoordUC += f_396_;
                        texCoordUA += f_386_;
                        texCoordVC += f_397_;
                        texCoordVA += f_387_;
                        i_360_ += f_398_;
                        i_358_ += f_388_;
                        f_364_ += f_399_;
                        f_362_ += f_389_;
                        f_367_ += f_400_;
                        f_365_ += f_390_;
                        f_370_ += f_401_;
                        f_368_ += f_391_;
                        f_373_ += f_402_;
                        f_371_ += f_392_;
                        yC += (float) rasterWidth;
                    }
                    while (--yA >= 0.0F) {
                        drawTexturedScanline(raster, texturePixels, (int) yC, (int) xC, (int) xB, zC, zB, texCoordUC, texCoordUB, texCoordVC, texCoordVB, (float) i_360_, (float) i_359_, f_364_, f_363_, f_367_, f_366_, f_370_, f_369_, f_373_, f_372_);
                        xC += f_394_;
                        xB += f_374_;
                        zC += f_395_;
                        zB += f_375_;
                        texCoordUC += f_396_;
                        texCoordUB += f_376_;
                        texCoordVC += f_397_;
                        texCoordVB += f_377_;
                        i_360_ += f_398_;
                        i_359_ += f_378_;
                        f_364_ += f_399_;
                        f_363_ += f_379_;
                        f_367_ += f_400_;
                        f_366_ += f_380_;
                        f_370_ += f_401_;
                        f_369_ += f_381_;
                        f_373_ += f_402_;
                        f_372_ += f_382_;
                        yC += (float) rasterWidth;
                    }
                }
            }
        }
    }

    private final void method1025(int[] is, int[] is_404_, int i, int i_405_, int i_406_, float f, float f_407_, float f_408_, float f_409_, float f_410_, float f_411_, float f_412_, float f_413_, float f_414_, float f_415_, float f_416_, float f_417_, float f_418_, float f_419_, float f_420_, float f_421_, float f_422_, float f_423_, float f_424_, float f_425_) {
        int i_426_ = i_406_ - i_405_;
        float f_427_ = 1.0F / (float) i_426_;
        float f_428_ = (f_407_ - f) * f_427_;
        float f_429_ = (f_409_ - f_408_) * f_427_;
        float f_430_ = (f_411_ - f_410_) * f_427_;
        float f_431_ = (f_413_ - f_412_) * f_427_;
        float f_432_ = (f_417_ - f_416_) * f_427_;
        float f_433_ = (f_419_ - f_418_) * f_427_;
        float f_434_ = (f_421_ - f_420_) * f_427_;
        float f_435_ = (f_423_ - f_422_) * f_427_;
        float f_436_ = (f_425_ - f_424_) * f_427_;
        if (this.restrictEdges) {
            if (i_406_ > this.width) i_406_ = this.width;
            if (i_405_ < 0) {
                f -= f_428_ * (float) i_405_;
                f_408_ -= f_429_ * (float) i_405_;
                f_410_ -= f_430_ * (float) i_405_;
                f_412_ -= f_431_ * (float) i_405_;
                f_416_ -= f_432_ * (float) i_405_;
                f_418_ -= f_433_ * (float) i_405_;
                f_420_ -= f_434_ * (float) i_405_;
                f_422_ -= f_435_ * (float) i_405_;
                f_424_ -= f_436_ * (float) i_405_;
                i_405_ = 0;
            }
        }
        if (i_405_ < i_406_) {
            i_426_ = i_406_ - i_405_;
            i += i_405_;
            while (i_426_-- > 0) {
                float f_437_ = 1.0F / f;
                if (f_437_ < depthBuffer[i]) {
                    float f_438_ = f_408_ * f_437_;
                    float f_439_ = f_410_ * f_437_;
                    int i_440_ = ((int) (f_438_ * (float) textureSize * aFloat1681) & textureLastIndex);
                    int i_441_ = ((int) (f_439_ * (float) textureSize * aFloat1681) & textureLastIndex);
                    int i_442_ = texturePixels[i_441_ * textureSize + i_440_];
                    i_440_ = ((int) (f_438_ * (float) anInt1691 * aFloat1684) & anInt1686);
                    i_441_ = ((int) (f_439_ * (float) anInt1691 * aFloat1684) & anInt1686);
                    int i_443_ = anIntArray1685[i_441_ * anInt1691 + i_440_];
                    i_440_ = ((int) (f_438_ * (float) anInt1695 * aFloat1682) & anInt1688);
                    i_441_ = ((int) (f_439_ * (float) anInt1695 * aFloat1682) & anInt1688);
                    int i_444_ = anIntArray1692[i_441_ * anInt1695 + i_440_];
                    float f_445_ = 1.0F - (f_422_ + f_424_);
                    i_442_ = (~0xffffff | ((int) (f_422_ * (float) (i_442_ >> 16 & 0xff)) << 16) | (int) (f_422_ * (float) (i_442_ >> 8 & 0xff)) << 8 | (int) (f_422_ * (float) (i_442_ & 0xff)));
                    i_443_ = (~0xffffff | ((int) (f_424_ * (float) (i_443_ >> 16 & 0xff)) << 16) | (int) (f_424_ * (float) (i_443_ >> 8 & 0xff)) << 8 | (int) (f_424_ * (float) (i_443_ & 0xff)));
                    i_444_ = (~0xffffff | ((int) (f_445_ * (float) (i_444_ >> 16 & 0xff)) << 16) | (int) (f_445_ * (float) (i_444_ >> 8 & 0xff)) << 8 | (int) (f_445_ * (float) (i_444_ & 0xff)));
                    int i_446_ = i_442_ + i_443_ + i_444_;
                    int i_447_ = (~0xffffff | ((int) (f_416_ * (float) (i_446_ >> 16 & 0xff)) << 8) & 0xff0000 | ((int) (f_418_ * (float) (i_446_ >> 8 & 0xff)) & 0xff00) | (int) (f_420_ * (float) (i_446_ & 0xff)) >> 8);
                    if (f_412_ != 0.0F) {
                        int i_448_ = (int) (255.0F - f_412_);
                        int i_449_ = ((((anInt1696 & 0xff00ff) * (int) f_412_ & ~0xff00ff) | ((anInt1696 & 0xff00) * (int) f_412_ & 0xff0000)) >>> 8);
                        i_447_ = (((i_447_ & 0xff00ff) * i_448_ & ~0xff00ff | (i_447_ & 0xff00) * i_448_ & 0xff0000) >>> 8) + i_449_;
                    }
                    is[i] = i_447_;
                    depthBuffer[i] = f_437_;
                }
                i++;
                f += f_428_;
                f_408_ += f_429_;
                f_410_ += f_430_;
                f_412_ += f_431_;
                f_416_ += f_432_;
                f_418_ += f_433_;
                f_420_ += f_434_;
                f_422_ += f_435_;
                f_424_ += f_436_;
            }
        }
    }

    // method1026
    private final void drawFlatScanLine(int[] dest, float[] depthBuffer, int destOff, int i_450_, int loops, int startX, int endX, float depth, float depthSlope) {
        if (this.restrictEdges) {
            if (endX > this.width) endX = this.width;
            if (startX < 0) startX = 0;
        }
        if (startX < endX) {
            destOff += startX - 1;
            loops = endX - startX >> 2;
            depth += depthSlope * (float) startX;
            if (aJavaThreadResource_1670.aBoolean2202) {
                if (this.alpha == 0) {
                    while (--loops >= 0) {
                        if (depth < depthBuffer[++destOff]) {
                            dest[destOff] = i_450_;
                            depthBuffer[destOff] = depth;
                        }
                        depth += depthSlope;
                        if (depth < depthBuffer[++destOff]) {
                            dest[destOff] = i_450_;
                            depthBuffer[destOff] = depth;
                        }
                        depth += depthSlope;
                        if (depth < depthBuffer[++destOff]) {
                            dest[destOff] = i_450_;
                            depthBuffer[destOff] = depth;
                        }
                        depth += depthSlope;
                        if (depth < depthBuffer[++destOff]) {
                            dest[destOff] = i_450_;
                            depthBuffer[destOff] = depth;
                        }
                        depth += depthSlope;
                    }
                    loops = endX - startX & 0x3;
                    while (--loops >= 0) {
                        if (depth < depthBuffer[++destOff]) {
                            dest[destOff] = i_450_;
                            depthBuffer[destOff] = depth;
                        }
                        depth += depthSlope;
                    }
                } else if (this.alpha == 254) {
                    if (startX != 0 && endX <= this.width - 1) {
                        while (--loops >= 0) {
                            if (depth < depthBuffer[++destOff]) dest[destOff - 1] = dest[destOff];
                            depth += depthSlope;
                            if (depth < depthBuffer[++destOff]) dest[destOff - 1] = dest[destOff];
                            depth += depthSlope;
                            if (depth < depthBuffer[++destOff]) dest[destOff - 1] = dest[destOff];
                            depth += depthSlope;
                            if (depth < depthBuffer[++destOff]) dest[destOff - 1] = dest[destOff];
                            depth += depthSlope;
                        }
                        loops = endX - startX & 0x3;
                        while (--loops >= 0) {
                            if (depth < depthBuffer[++destOff]) dest[destOff - 1] = dest[destOff];
                            depth += depthSlope;
                        }
                    }
                } else {
                    int i_455_ = this.alpha;
                    int i_456_ = 256 - this.alpha;
                    i_450_ = (((i_450_ & 0xff00ff) * i_456_ >> 8 & 0xff00ff) + ((i_450_ & 0xff00) * i_456_ >> 8 & 0xff00));
                    while (--loops >= 0) {
                        if (depth < depthBuffer[++destOff]) {
                            int i_457_ = dest[destOff];
                            dest[destOff] = (i_450_ + ((i_457_ & 0xff00ff) * i_455_ >> 8 & 0xff00ff) + ((i_457_ & 0xff00) * i_455_ >> 8 & 0xff00));
                            depthBuffer[destOff] = depth;
                        }
                        depth += depthSlope;
                        if (depth < depthBuffer[++destOff]) {
                            int i_458_ = dest[destOff];
                            dest[destOff] = (i_450_ + ((i_458_ & 0xff00ff) * i_455_ >> 8 & 0xff00ff) + ((i_458_ & 0xff00) * i_455_ >> 8 & 0xff00));
                            depthBuffer[destOff] = depth;
                        }
                        depth += depthSlope;
                        if (depth < depthBuffer[++destOff]) {
                            int i_459_ = dest[destOff];
                            dest[destOff] = (i_450_ + ((i_459_ & 0xff00ff) * i_455_ >> 8 & 0xff00ff) + ((i_459_ & 0xff00) * i_455_ >> 8 & 0xff00));
                            depthBuffer[destOff] = depth;
                        }
                        depth += depthSlope;
                        if (depth < depthBuffer[++destOff]) {
                            int i_460_ = dest[destOff];
                            dest[destOff] = (i_450_ + ((i_460_ & 0xff00ff) * i_455_ >> 8 & 0xff00ff) + ((i_460_ & 0xff00) * i_455_ >> 8 & 0xff00));
                            depthBuffer[destOff] = depth;
                        }
                        depth += depthSlope;
                    }
                    loops = endX - startX & 0x3;
                    while (--loops >= 0) {
                        if (depth < depthBuffer[++destOff]) {
                            int i_461_ = dest[destOff];
                            dest[destOff] = (i_450_ + ((i_461_ & 0xff00ff) * i_455_ >> 8 & 0xff00ff) + ((i_461_ & 0xff00) * i_455_ >> 8 & 0xff00));
                            depthBuffer[destOff] = depth;
                        }
                        depth += depthSlope;
                    }
                }
            } else if (this.alpha == 0) {
                while (--loops >= 0) {
                    if (depth < depthBuffer[++destOff]) dest[destOff] = i_450_;
                    depth += depthSlope;
                    if (depth < depthBuffer[++destOff]) dest[destOff] = i_450_;
                    depth += depthSlope;
                    if (depth < depthBuffer[++destOff]) dest[destOff] = i_450_;
                    depth += depthSlope;
                    if (depth < depthBuffer[++destOff]) dest[destOff] = i_450_;
                    depth += depthSlope;
                }
                loops = endX - startX & 0x3;
                while (--loops >= 0) {
                    if (depth < depthBuffer[++destOff]) dest[destOff] = i_450_;
                    depth += depthSlope;
                }
            } else if (this.alpha == 254) {
                if (startX != 0 && endX <= this.width - 1) {
                    while (--loops >= 0) {
                        if (depth < depthBuffer[++destOff]) dest[destOff - 1] = dest[destOff];
                        depth += depthSlope;
                        if (depth < depthBuffer[++destOff]) dest[destOff - 1] = dest[destOff];
                        depth += depthSlope;
                        if (depth < depthBuffer[++destOff]) dest[destOff - 1] = dest[destOff];
                        depth += depthSlope;
                        if (depth < depthBuffer[++destOff]) dest[destOff - 1] = dest[destOff];
                        depth += depthSlope;
                    }
                    loops = endX - startX & 0x3;
                    while (--loops >= 0) {
                        if (depth < depthBuffer[++destOff]) dest[destOff - 1] = dest[destOff];
                        depth += depthSlope;
                    }
                }
            } else {
                int i_462_ = this.alpha;
                int i_463_ = 256 - this.alpha;
                i_450_ = (((i_450_ & 0xff00ff) * i_463_ >> 8 & 0xff00ff) + ((i_450_ & 0xff00) * i_463_ >> 8 & 0xff00));
                while (--loops >= 0) {
                    if (depth < depthBuffer[++destOff]) {
                        int i_464_ = dest[destOff];
                        dest[destOff] = (i_450_ + ((i_464_ & 0xff00ff) * i_462_ >> 8 & 0xff00ff) + ((i_464_ & 0xff00) * i_462_ >> 8 & 0xff00));
                    }
                    depth += depthSlope;
                    if (depth < depthBuffer[++destOff]) {
                        int i_465_ = dest[destOff];
                        dest[destOff] = (i_450_ + ((i_465_ & 0xff00ff) * i_462_ >> 8 & 0xff00ff) + ((i_465_ & 0xff00) * i_462_ >> 8 & 0xff00));
                    }
                    depth += depthSlope;
                    if (depth < depthBuffer[++destOff]) {
                        int i_466_ = dest[destOff];
                        dest[destOff] = (i_450_ + ((i_466_ & 0xff00ff) * i_462_ >> 8 & 0xff00ff) + ((i_466_ & 0xff00) * i_462_ >> 8 & 0xff00));
                    }
                    depth += depthSlope;
                    if (depth < depthBuffer[++destOff]) {
                        int i_467_ = dest[destOff];
                        dest[destOff] = (i_450_ + ((i_467_ & 0xff00ff) * i_462_ >> 8 & 0xff00ff) + ((i_467_ & 0xff00) * i_462_ >> 8 & 0xff00));
                    }
                    depth += depthSlope;
                }
                loops = endX - startX & 0x3;
                while (--loops >= 0) {
                    if (depth < depthBuffer[++destOff]) {
                        int i_468_ = dest[destOff];
                        dest[destOff] = (i_450_ + ((i_468_ & 0xff00ff) * i_462_ >> 8 & 0xff00ff) + ((i_468_ & 0xff00) * i_462_ >> 8 & 0xff00));
                    }
                    depth += depthSlope;
                }
            }
        }
    }

    // method1027
    final void renderTriangleRgb(float f, float f_469_, float f_470_, float f_471_, float f_472_, float f_473_, float f_474_, float f_475_, float f_476_, int i, int i_477_, int i_478_) {
        if (useExternalRenderer) {
            aJavaToolkit_1666.method3645((int) f, (int) f_471_, (int) f_472_, -8003, ~0xffffff | i, (int) f_469_);
            aJavaToolkit_1666.method3645((int) f_469_, (int) f_472_, (int) f_473_, -8003, ~0xffffff | i, (int) f_470_);
            aJavaToolkit_1666.method3645((int) f_470_, (int) f_473_, (int) f_471_, -8003, ~0xffffff | i, (int) f);
        } else {
            float f_479_ = f_472_ - f_471_;
            float f_480_ = f_469_ - f;
            float f_481_ = f_473_ - f_471_;
            float f_482_ = f_470_ - f;
            float f_483_ = f_475_ - f_474_;
            float f_484_ = f_476_ - f_474_;
            float f_485_ = (float) ((i_477_ & 0xff0000) - (i & 0xff0000));
            float f_486_ = (float) ((i_478_ & 0xff0000) - (i & 0xff0000));
            float f_487_ = (float) ((i_477_ & 0xff00) - (i & 0xff00));
            float f_488_ = (float) ((i_478_ & 0xff00) - (i & 0xff00));
            float f_489_ = (float) ((i_477_ & 0xff) - (i & 0xff));
            float f_490_ = (float) ((i_478_ & 0xff) - (i & 0xff));
            float f_491_;
            if (f_470_ != f_469_) f_491_ = (f_473_ - f_472_) / (f_470_ - f_469_);
            else f_491_ = 0.0F;
            float f_492_;
            if (f_469_ != f) f_492_ = f_479_ / f_480_;
            else f_492_ = 0.0F;
            float f_493_;
            if (f_470_ != f) f_493_ = f_481_ / f_482_;
            else f_493_ = 0.0F;
            float f_494_ = f_479_ * f_482_ - f_481_ * f_480_;
            if (f_494_ != 0.0F) {
                float f_495_ = (f_483_ * f_482_ - f_484_ * f_480_) / f_494_;
                float f_496_ = (f_484_ * f_479_ - f_483_ * f_481_) / f_494_;
                float f_497_ = (f_485_ * f_482_ - f_486_ * f_480_) / f_494_;
                float f_498_ = (f_486_ * f_479_ - f_485_ * f_481_) / f_494_;
                float f_499_ = (f_487_ * f_482_ - f_488_ * f_480_) / f_494_;
                float f_500_ = (f_488_ * f_479_ - f_487_ * f_481_) / f_494_;
                float f_501_ = (f_489_ * f_482_ - f_490_ * f_480_) / f_494_;
                float f_502_ = (f_490_ * f_479_ - f_489_ * f_481_) / f_494_;
                if (f <= f_469_ && f <= f_470_) {
                    if (!(f >= (float) this.height)) {
                        if (f_469_ > (float) this.height) f_469_ = (float) this.height;
                        if (f_470_ > (float) this.height) f_470_ = (float) this.height;
                        f_474_ = f_474_ - f_495_ * f_471_ + f_495_;
                        float f_503_ = ((float) (i & 0xff0000) - f_497_ * f_471_ + f_497_);
                        float f_504_ = (float) (i & 0xff00) - f_499_ * f_471_ + f_499_;
                        float f_505_ = (float) (i & 0xff) - f_501_ * f_471_ + f_501_;
                        if (f_469_ < f_470_) {
                            f_473_ = f_471_;
                            if (f < 0.0F) {
                                f_473_ -= f_493_ * f;
                                f_471_ -= f_492_ * f;
                                f_474_ -= f_496_ * f;
                                f_503_ -= f_498_ * f;
                                f_504_ -= f_500_ * f;
                                f_505_ -= f_502_ * f;
                                f = 0.0F;
                            }
                            if (f_469_ < 0.0F) {
                                f_472_ -= f_491_ * f_469_;
                                f_469_ = 0.0F;
                            }
                            if (f != f_469_ && f_493_ < f_492_ || f == f_469_ && f_493_ > f_491_) {
                                f_470_ -= f_469_;
                                f_469_ -= f;
                                f = (float) (this.lineOffsets[(int) f]);
                                while (--f_469_ >= 0.0F) {
                                    method1021(raster, depthBuffer, (int) f, 0, 0, (int) f_473_, (int) f_471_, f_474_, f_495_, f_503_, f_497_, f_504_, f_499_, f_505_, f_501_);
                                    f_473_ += f_493_;
                                    f_471_ += f_492_;
                                    f_474_ += f_496_;
                                    f_503_ += f_498_;
                                    f_504_ += f_500_;
                                    f_505_ += f_502_;
                                    f += (float) rasterWidth;
                                }
                                while (--f_470_ >= 0.0F) {
                                    method1021(raster, depthBuffer, (int) f, 0, 0, (int) f_473_, (int) f_472_, f_474_, f_495_, f_503_, f_497_, f_504_, f_499_, f_505_, f_501_);
                                    f_473_ += f_493_;
                                    f_472_ += f_491_;
                                    f_474_ += f_496_;
                                    f_503_ += f_498_;
                                    f_504_ += f_500_;
                                    f_505_ += f_502_;
                                    f += (float) rasterWidth;
                                }
                            } else {
                                f_470_ -= f_469_;
                                f_469_ -= f;
                                f = (float) (this.lineOffsets[(int) f]);
                                while (--f_469_ >= 0.0F) {
                                    method1021(raster, depthBuffer, (int) f, 0, 0, (int) f_471_, (int) f_473_, f_474_, f_495_, f_503_, f_497_, f_504_, f_499_, f_505_, f_501_);
                                    f_473_ += f_493_;
                                    f_471_ += f_492_;
                                    f_474_ += f_496_;
                                    f_503_ += f_498_;
                                    f_504_ += f_500_;
                                    f_505_ += f_502_;
                                    f += (float) rasterWidth;
                                }
                                while (--f_470_ >= 0.0F) {
                                    method1021(raster, depthBuffer, (int) f, 0, 0, (int) f_472_, (int) f_473_, f_474_, f_495_, f_503_, f_497_, f_504_, f_499_, f_505_, f_501_);
                                    f_473_ += f_493_;
                                    f_472_ += f_491_;
                                    f_474_ += f_496_;
                                    f_503_ += f_498_;
                                    f_504_ += f_500_;
                                    f_505_ += f_502_;
                                    f += (float) rasterWidth;
                                }
                            }
                        } else {
                            f_472_ = f_471_;
                            if (f < 0.0F) {
                                f_472_ -= f_493_ * f;
                                f_471_ -= f_492_ * f;
                                f_474_ -= f_496_ * f;
                                f_503_ -= f_498_ * f;
                                f_504_ -= f_500_ * f;
                                f_505_ -= f_502_ * f;
                                f = 0.0F;
                            }
                            if (f_470_ < 0.0F) {
                                f_473_ -= f_491_ * f_470_;
                                f_470_ = 0.0F;
                            }
                            if (f != f_470_ && f_493_ < f_492_ || f == f_470_ && f_491_ > f_492_) {
                                f_469_ -= f_470_;
                                f_470_ -= f;
                                f = (float) (this.lineOffsets[(int) f]);
                                while (--f_470_ >= 0.0F) {
                                    method1021(raster, depthBuffer, (int) f, 0, 0, (int) f_472_, (int) f_471_, f_474_, f_495_, f_503_, f_497_, f_504_, f_499_, f_505_, f_501_);
                                    f_472_ += f_493_;
                                    f_471_ += f_492_;
                                    f_474_ += f_496_;
                                    f_503_ += f_498_;
                                    f_504_ += f_500_;
                                    f_505_ += f_502_;
                                    f += (float) rasterWidth;
                                }
                                while (--f_469_ >= 0.0F) {
                                    method1021(raster, depthBuffer, (int) f, 0, 0, (int) f_473_, (int) f_471_, f_474_, f_495_, f_503_, f_497_, f_504_, f_499_, f_505_, f_501_);
                                    f_473_ += f_491_;
                                    f_471_ += f_492_;
                                    f_474_ += f_496_;
                                    f_503_ += f_498_;
                                    f_504_ += f_500_;
                                    f_505_ += f_502_;
                                    f += (float) rasterWidth;
                                }
                            } else {
                                f_469_ -= f_470_;
                                f_470_ -= f;
                                f = (float) (this.lineOffsets[(int) f]);
                                while (--f_470_ >= 0.0F) {
                                    method1021(raster, depthBuffer, (int) f, 0, 0, (int) f_471_, (int) f_472_, f_474_, f_495_, f_503_, f_497_, f_504_, f_499_, f_505_, f_501_);
                                    f_472_ += f_493_;
                                    f_471_ += f_492_;
                                    f_474_ += f_496_;
                                    f_503_ += f_498_;
                                    f_504_ += f_500_;
                                    f_505_ += f_502_;
                                    f += (float) rasterWidth;
                                }
                                while (--f_469_ >= 0.0F) {
                                    method1021(raster, depthBuffer, (int) f, 0, 0, (int) f_471_, (int) f_473_, f_474_, f_495_, f_503_, f_497_, f_504_, f_499_, f_505_, f_501_);
                                    f_473_ += f_491_;
                                    f_471_ += f_492_;
                                    f_474_ += f_496_;
                                    f_503_ += f_498_;
                                    f_504_ += f_500_;
                                    f_505_ += f_502_;
                                    f += (float) rasterWidth;
                                }
                            }
                        }
                    }
                } else if (f_469_ <= f_470_) {
                    if (!(f_469_ >= (float) this.height)) {
                        if (f_470_ > (float) this.height) f_470_ = (float) this.height;
                        if (f > (float) this.height) f = (float) this.height;
                        f_475_ = f_475_ - f_495_ * f_472_ + f_495_;
                        float f_506_ = ((float) (i_477_ & 0xff0000) - f_497_ * f_472_ + f_497_);
                        float f_507_ = ((float) (i_477_ & 0xff00) - f_499_ * f_472_ + f_499_);
                        float f_508_ = ((float) (i_477_ & 0xff) - f_501_ * f_472_ + f_501_);
                        if (f_470_ < f) {
                            f_471_ = f_472_;
                            if (f_469_ < 0.0F) {
                                f_471_ -= f_492_ * f_469_;
                                f_472_ -= f_491_ * f_469_;
                                f_475_ -= f_496_ * f_469_;
                                f_506_ -= f_498_ * f_469_;
                                f_507_ -= f_500_ * f_469_;
                                f_508_ -= f_502_ * f_469_;
                                f_469_ = 0.0F;
                            }
                            if (f_470_ < 0.0F) {
                                f_473_ -= f_493_ * f_470_;
                                f_470_ = 0.0F;
                            }
                            if (f_469_ != f_470_ && f_492_ < f_491_ || f_469_ == f_470_ && f_492_ > f_493_) {
                                f -= f_470_;
                                f_470_ -= f_469_;
                                f_469_ = (float) (this.lineOffsets[(int) f_469_]);
                                while (--f_470_ >= 0.0F) {
                                    method1021(raster, depthBuffer, (int) f_469_, 0, 0, (int) f_471_, (int) f_472_, f_475_, f_495_, f_506_, f_497_, f_507_, f_499_, f_508_, f_501_);
                                    f_471_ += f_492_;
                                    f_472_ += f_491_;
                                    f_475_ += f_496_;
                                    f_506_ += f_498_;
                                    f_507_ += f_500_;
                                    f_508_ += f_502_;
                                    f_469_ += (float) rasterWidth;
                                }
                                while (--f >= 0.0F) {
                                    method1021(raster, depthBuffer, (int) f_469_, 0, 0, (int) f_471_, (int) f_473_, f_475_, f_495_, f_506_, f_497_, f_507_, f_499_, f_508_, f_501_);
                                    f_471_ += f_492_;
                                    f_473_ += f_493_;
                                    f_475_ += f_496_;
                                    f_506_ += f_498_;
                                    f_507_ += f_500_;
                                    f_508_ += f_502_;
                                    f_469_ += (float) rasterWidth;
                                }
                            } else {
                                f -= f_470_;
                                f_470_ -= f_469_;
                                f_469_ = (float) (this.lineOffsets[(int) f_469_]);
                                while (--f_470_ >= 0.0F) {
                                    method1021(raster, depthBuffer, (int) f_469_, 0, 0, (int) f_472_, (int) f_471_, f_475_, f_495_, f_506_, f_497_, f_507_, f_499_, f_508_, f_501_);
                                    f_471_ += f_492_;
                                    f_472_ += f_491_;
                                    f_475_ += f_496_;
                                    f_506_ += f_498_;
                                    f_507_ += f_500_;
                                    f_508_ += f_502_;
                                    f_469_ += (float) rasterWidth;
                                }
                                while (--f >= 0.0F) {
                                    method1021(raster, depthBuffer, (int) f_469_, 0, 0, (int) f_473_, (int) f_471_, f_475_, f_495_, f_506_, f_497_, f_507_, f_499_, f_508_, f_501_);
                                    f_471_ += f_492_;
                                    f_473_ += f_493_;
                                    f_475_ += f_496_;
                                    f_506_ += f_498_;
                                    f_507_ += f_500_;
                                    f_508_ += f_502_;
                                    f_469_ += (float) rasterWidth;
                                }
                            }
                        } else {
                            f_473_ = f_472_;
                            if (f_469_ < 0.0F) {
                                f_473_ -= f_492_ * f_469_;
                                f_472_ -= f_491_ * f_469_;
                                f_475_ -= f_496_ * f_469_;
                                f_506_ -= f_498_ * f_469_;
                                f_507_ -= f_500_ * f_469_;
                                f_508_ -= f_502_ * f_469_;
                                f_469_ = 0.0F;
                            }
                            if (f < 0.0F) {
                                f_471_ -= f_493_ * f;
                                f = 0.0F;
                            }
                            if (f_492_ < f_491_) {
                                f_470_ -= f;
                                f -= f_469_;
                                f_469_ = (float) (this.lineOffsets[(int) f_469_]);
                                while (--f >= 0.0F) {
                                    method1021(raster, depthBuffer, (int) f_469_, 0, 0, (int) f_473_, (int) f_472_, f_475_, f_495_, f_506_, f_497_, f_507_, f_499_, f_508_, f_501_);
                                    f_473_ += f_492_;
                                    f_472_ += f_491_;
                                    f_475_ += f_496_;
                                    f_506_ += f_498_;
                                    f_507_ += f_500_;
                                    f_508_ += f_502_;
                                    f_469_ += (float) rasterWidth;
                                }
                                while (--f_470_ >= 0.0F) {
                                    method1021(raster, depthBuffer, (int) f_469_, 0, 0, (int) f_471_, (int) f_472_, f_475_, f_495_, f_506_, f_497_, f_507_, f_499_, f_508_, f_501_);
                                    f_471_ += f_493_;
                                    f_472_ += f_491_;
                                    f_475_ += f_496_;
                                    f_506_ += f_498_;
                                    f_507_ += f_500_;
                                    f_508_ += f_502_;
                                    f_469_ += (float) rasterWidth;
                                }
                            } else {
                                f_470_ -= f;
                                f -= f_469_;
                                f_469_ = (float) (this.lineOffsets[(int) f_469_]);
                                while (--f >= 0.0F) {
                                    method1021(raster, depthBuffer, (int) f_469_, 0, 0, (int) f_472_, (int) f_473_, f_475_, f_495_, f_506_, f_497_, f_507_, f_499_, f_508_, f_501_);
                                    f_473_ += f_492_;
                                    f_472_ += f_491_;
                                    f_475_ += f_496_;
                                    f_506_ += f_498_;
                                    f_507_ += f_500_;
                                    f_508_ += f_502_;
                                    f_469_ += (float) rasterWidth;
                                }
                                while (--f_470_ >= 0.0F) {
                                    method1021(raster, depthBuffer, (int) f_469_, 0, 0, (int) f_472_, (int) f_471_, f_475_, f_495_, f_506_, f_497_, f_507_, f_499_, f_508_, f_501_);
                                    f_471_ += f_493_;
                                    f_472_ += f_491_;
                                    f_475_ += f_496_;
                                    f_506_ += f_498_;
                                    f_507_ += f_500_;
                                    f_508_ += f_502_;
                                    f_469_ += (float) rasterWidth;
                                }
                            }
                        }
                    }
                } else if (!(f_470_ >= (float) this.height)) {
                    if (f > (float) this.height) f = (float) this.height;
                    if (f_469_ > (float) this.height) f_469_ = (float) this.height;
                    f_476_ = f_476_ - f_495_ * f_473_ + f_495_;
                    float f_509_ = ((float) (i_478_ & 0xff0000) - f_497_ * f_473_ + f_497_);
                    float f_510_ = (float) (i_478_ & 0xff00) - f_499_ * f_473_ + f_499_;
                    float f_511_ = (float) (i_478_ & 0xff) - f_501_ * f_473_ + f_501_;
                    if (f < f_469_) {
                        f_472_ = f_473_;
                        if (f_470_ < 0.0F) {
                            f_472_ -= f_491_ * f_470_;
                            f_473_ -= f_493_ * f_470_;
                            f_476_ -= f_496_ * f_470_;
                            f_509_ -= f_498_ * f_470_;
                            f_510_ -= f_500_ * f_470_;
                            f_511_ -= f_502_ * f_470_;
                            f_470_ = 0.0F;
                        }
                        if (f < 0.0F) {
                            f_471_ -= f_492_ * f;
                            f = 0.0F;
                        }
                        if (f_491_ < f_493_) {
                            f_469_ -= f;
                            f -= f_470_;
                            f_470_ = (float) (this.lineOffsets[(int) f_470_]);
                            while (--f >= 0.0F) {
                                method1021(raster, depthBuffer, (int) f_470_, 0, 0, (int) f_472_, (int) f_473_, f_476_, f_495_, f_509_, f_497_, f_510_, f_499_, f_511_, f_501_);
                                f_472_ += f_491_;
                                f_473_ += f_493_;
                                f_476_ += f_496_;
                                f_509_ += f_498_;
                                f_510_ += f_500_;
                                f_511_ += f_502_;
                                f_470_ += (float) rasterWidth;
                            }
                            while (--f_469_ >= 0.0F) {
                                method1021(raster, depthBuffer, (int) f_470_, 0, 0, (int) f_472_, (int) f_471_, f_476_, f_495_, f_509_, f_497_, f_510_, f_499_, f_511_, f_501_);
                                f_472_ += f_491_;
                                f_471_ += f_492_;
                                f_476_ += f_496_;
                                f_509_ += f_498_;
                                f_510_ += f_500_;
                                f_511_ += f_502_;
                                f_470_ += (float) rasterWidth;
                            }
                        } else {
                            f_469_ -= f;
                            f -= f_470_;
                            f_470_ = (float) (this.lineOffsets[(int) f_470_]);
                            while (--f >= 0.0F) {
                                method1021(raster, depthBuffer, (int) f_470_, 0, 0, (int) f_473_, (int) f_472_, f_476_, f_495_, f_509_, f_497_, f_510_, f_499_, f_511_, f_501_);
                                f_472_ += f_491_;
                                f_473_ += f_493_;
                                f_476_ += f_496_;
                                f_509_ += f_498_;
                                f_510_ += f_500_;
                                f_511_ += f_502_;
                                f_470_ += (float) rasterWidth;
                            }
                            while (--f_469_ >= 0.0F) {
                                method1021(raster, depthBuffer, (int) f_470_, 0, 0, (int) f_471_, (int) f_472_, f_476_, f_495_, f_509_, f_497_, f_510_, f_499_, f_511_, f_501_);
                                f_472_ += f_491_;
                                f_471_ += f_492_;
                                f_476_ += f_496_;
                                f_509_ += f_498_;
                                f_510_ += f_500_;
                                f_511_ += f_502_;
                                f_470_ += (float) rasterWidth;
                            }
                        }
                    } else {
                        f_471_ = f_473_;
                        if (f_470_ < 0.0F) {
                            f_471_ -= f_491_ * f_470_;
                            f_473_ -= f_493_ * f_470_;
                            f_476_ -= f_496_ * f_470_;
                            f_509_ -= f_498_ * f_470_;
                            f_510_ -= f_500_ * f_470_;
                            f_511_ -= f_502_ * f_470_;
                            f_470_ = 0.0F;
                        }
                        if (f_469_ < 0.0F) {
                            f_472_ -= f_492_ * f_469_;
                            f_469_ = 0.0F;
                        }
                        if (f_491_ < f_493_) {
                            f -= f_469_;
                            f_469_ -= f_470_;
                            f_470_ = (float) (this.lineOffsets[(int) f_470_]);
                            while (--f_469_ >= 0.0F) {
                                method1021(raster, depthBuffer, (int) f_470_, 0, 0, (int) f_471_, (int) f_473_, f_476_, f_495_, f_509_, f_497_, f_510_, f_499_, f_511_, f_501_);
                                f_471_ += f_491_;
                                f_473_ += f_493_;
                                f_476_ += f_496_;
                                f_509_ += f_498_;
                                f_510_ += f_500_;
                                f_511_ += f_502_;
                                f_470_ += (float) rasterWidth;
                            }
                            while (--f >= 0.0F) {
                                method1021(raster, depthBuffer, (int) f_470_, 0, 0, (int) f_472_, (int) f_473_, f_476_, f_495_, f_509_, f_497_, f_510_, f_499_, f_511_, f_501_);
                                f_472_ += f_492_;
                                f_473_ += f_493_;
                                f_476_ += f_496_;
                                f_509_ += f_498_;
                                f_510_ += f_500_;
                                f_511_ += f_502_;
                                f_470_ += (float) rasterWidth;
                            }
                        } else {
                            f -= f_469_;
                            f_469_ -= f_470_;
                            f_470_ = (float) (this.lineOffsets[(int) f_470_]);
                            while (--f_469_ >= 0.0F) {
                                method1021(raster, depthBuffer, (int) f_470_, 0, 0, (int) f_473_, (int) f_471_, f_476_, f_495_, f_509_, f_497_, f_510_, f_499_, f_511_, f_501_);
                                f_471_ += f_491_;
                                f_473_ += f_493_;
                                f_476_ += f_496_;
                                f_509_ += f_498_;
                                f_510_ += f_500_;
                                f_511_ += f_502_;
                                f_470_ += (float) rasterWidth;
                            }
                            while (--f >= 0.0F) {
                                method1021(raster, depthBuffer, (int) f_470_, 0, 0, (int) f_473_, (int) f_472_, f_476_, f_495_, f_509_, f_497_, f_510_, f_499_, f_511_, f_501_);
                                f_472_ += f_492_;
                                f_473_ += f_493_;
                                f_476_ += f_496_;
                                f_509_ += f_498_;
                                f_510_ += f_500_;
                                f_511_ += f_502_;
                                f_470_ += (float) rasterWidth;
                            }
                        }
                    }
                }
            }
        }
    }

    final int method1028() {
        return this.lineOffsets[0] % rasterWidth;
    }

    Rasterizer(JavaToolkit var_javaToolkit, JavaThreadResource javaThreadResource) {
        this.aBoolean1669 = true;
        this.restrictEdges = false;
        aBoolean1680 = false;
        aFloat1682 = 0.0F;
        anIntArray1685 = null;
        anInt1687 = -1;
        aFloat1684 = 0.0F;
        textureSize = 0;
        anInt1691 = 0;
        anIntArray1692 = null;
        anInt1689 = -1;
        textureAlphaBlendMode = 0;
        aFloat1681 = 0.0F;
        repeatTexture = true;
        anInt1688 = 0;
        anInt1695 = 0;
        anInt1686 = 0;
        textureLastIndex = 0;
        anInt1697 = -1;
        texturePixels = null;
        aJavaToolkit_1666 = var_javaToolkit;
        aJavaThreadResource_1670 = javaThreadResource;
        rasterWidth = aJavaToolkit_1666.surfaceWidth;
        raster = aJavaToolkit_1666.surfaceRaster;
        depthBuffer = aJavaToolkit_1666.depthBuffer;
    }
}
