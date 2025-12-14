/* Class105_Sub3 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Sprite_Sub3
abstract class JavaSprite extends Sprite {
    static int textureDvDx;
    static int pixelOffset;
    static int textureDvDy;
    static int surfaceStride;
    int offsetY;
    private static int addInvAlpha;
    int offsetX;
    static int textureDuDy;
    static int textureU;
    private static int addAlpha;
    JavaToolkit toolkit;
    int baseY;
    private int[] anIntArray8462;
    static int green;
    int baseX;
    static int blue = 0;
    private static int clipMinY;
    static int textureV;
    static int clipMaxY;
    static int red;
    int height;
    int width;
    static int invAlpha;
    private static int clipMinX;
    static int additiveBase = 0;
    static int textureVOffsetX;
    private static int subPixelOffsetX;
    static int alpha;
    static int clipMaxX;
    static int textureUOffsetX;
    static int colourRgb;
    static int textureDuDx;
    private static int subPixelOffsetY;

    abstract void method964(int i, int i_0_, int i_1_, int i_2_, int i_3_);

    // method971
    final int getWidth() {
        return this.width;
    }

    final void projectOffsets(int[] is) {
        is[0] = this.baseY;
        is[1] = this.baseX;
        is[2] = this.offsetY;
        is[3] = this.offsetX;
    }

    final void method965(int i, int i_4_, int i_5_, int i_6_, int i_7_, int i_8_, int i_9_) {
        if (this.toolkit.method3716()) throw new IllegalStateException();
        if (anIntArray8462 == null) anIntArray8462 = new int[4];
        this.toolkit.K(anIntArray8462);
        this.toolkit.T(this.toolkit.clipX1, this.toolkit.clipY1, i + i_5_, i_4_ + i_6_);
        int i_10_ = scaleWidth();
        int i_11_ = scaleHeight();
        int i_12_ = (i_5_ + i_10_ - 1) / i_10_;
        int i_13_ = (i_6_ + i_11_ - 1) / i_11_;
        for (int i_14_ = 0; i_14_ < i_13_; i_14_++) {
            int i_15_ = i_14_ * i_11_;
            for (int i_16_ = 0; i_16_ < i_12_; i_16_++)
                method964(i + i_16_ * i_10_, i_4_ + i_15_, i_7_, i_8_, i_9_);
        }
        this.toolkit.KA(anIntArray8462[0], anIntArray8462[1], anIntArray8462[2], anIntArray8462[3]);
    }

    final void method983(float f, float f_17_, float f_18_, float f_19_, float f_20_, float f_21_, int i, aa var_aa, int i_22_, int i_23_) {
        if (this.toolkit.method3716()) throw new IllegalStateException();
        if (calcSpriteTransform(f, f_17_, f_18_, f_19_, f_20_, f_21_)) {
            aa_Sub3 var_aa_Sub3 = (aa_Sub3) var_aa;
            method995(var_aa_Sub3.anIntArray5201, var_aa_Sub3.anIntArray5202, clipMinX - i_22_, -i_23_ - (clipMaxY - clipMinY));
        }
    }

    final void setOffsets(int y1, int x1, int y2, int x2) {
        this.baseY = y1;
        this.baseX = x1;
        this.offsetY = y2;
        this.offsetX = x2;
    }

    // method994
    abstract void rasterizeSprite(int blendMode, int alphaMode);

    abstract void method995(int[] is, int[] is_28_, int i, int i_29_);

    // method962
    final void method962(float topLeftX, float topLeftY, float topRightX, float topRightY, float bottomLeftX, float bottomLeftY, int blendMode, int colourArgb, int alphaMode, int i_37_) {
        if (this.toolkit.method3716()) throw new IllegalStateException();
        if (calcSpriteTransform(topLeftX, topLeftY, topRightX, topRightY, bottomLeftX, bottomLeftY)) {
            colourRgb = colourArgb;
            if (blendMode != 1) { // Opaque
                alpha = colourArgb >>> 24;
                invAlpha = 256 - alpha;
                if (blendMode == 0) { // transparent
                    red = (colourArgb & 0xff0000) >> 16;
                    green = (colourArgb & 0xff00) >> 8;
                    blue = colourArgb & 0xff;
                } else if (blendMode == 2) { // additive
                    addAlpha = colourArgb >>> 24;
                    addInvAlpha = 256 - addAlpha;
                    int i_38_ = (colourArgb & 0xff00ff) * addInvAlpha & ~0xff00ff;
                    int i_39_ = (colourArgb & 0xff00) * addInvAlpha & 0xff0000;
                    additiveBase = (i_38_ | i_39_) >>> 8;
                }
            }
            if (blendMode == 1) {
                if (alphaMode == 0) rasterizeSprite(1, 0);
                else if (alphaMode == 1) rasterizeSprite(1, 1);
                else if (alphaMode == 2) rasterizeSprite(1, 2);
            } else if (blendMode == 0) {
                if (alphaMode == 0) rasterizeSprite(0, 0);
                else if (alphaMode == 1) rasterizeSprite(0, 1);
                else if (alphaMode == 2) rasterizeSprite(0, 2);
            } else if (blendMode == 3) {
                if (alphaMode == 0) rasterizeSprite(3, 0);
                else if (alphaMode == 1) rasterizeSprite(3, 1);
                else if (alphaMode == 2) rasterizeSprite(3, 2);
            } else if (blendMode == 2) {
                if (alphaMode == 0) rasterizeSprite(2, 0);
                else if (alphaMode == 1) rasterizeSprite(2, 1);
                else if (alphaMode == 2) rasterizeSprite(2, 2);
            }
        }
    }

    abstract void method996(int i, int i_40_, int i_41_, int i_42_, int i_43_, int i_44_, int i_45_, int i_46_, int i_47_);

    abstract void method982(int i, int i_48_, int i_49_, int i_50_, int i_51_, int i_52_, int i_53_, int i_54_);

    // method969
    final int getHeight() {
        return this.height;
    }

    // method980
    final int scaleHeight() {
        return (this.baseX + this.height + this.offsetX);
    }

    JavaSprite(JavaToolkit var_javaToolkit, int i, int i_55_) {
        this.toolkit = var_javaToolkit;
        this.width = i;
        this.height = i_55_;
    }

    final int scaleWidth() {
        return (this.baseY + this.width + this.offsetY);
    }

    abstract void method963(int i, int i_56_, aa var_aa, int i_57_, int i_58_);

    // method997
    private final boolean calcSpriteTransform(float topLeftX, float topLeftY, float topRightX, float topRightY, float bottomLeftX, float bottomLeftY) {
        int actualHeight = (this.baseY + this.width + this.offsetY);
        int actualWidth = (this.baseX + this.height + this.offsetX);
        if (actualHeight != this.width || actualWidth != this.height) {
            float horizontalX = (topRightX - topLeftX) / (float) actualHeight;
            float horizontalY = (topRightY - topLeftY) / (float) actualHeight;
            float verticalX = (bottomLeftX - topLeftX) / (float) actualWidth;
            float verticalY = (bottomLeftY - topLeftY) / (float) actualWidth;
            float baseXOffsetH = verticalX * (float) this.baseX;
            float baseXOffsetV = verticalY * (float) this.baseX;
            float baseYOffsetH = horizontalX * (float) this.baseY;
            float baseYOffsetV = horizontalY * (float) this.baseY;
            float cropOffsetH = -horizontalX * (float) this.offsetY;
            float cropOffsetV = -horizontalY * (float) this.offsetY;
            float cropLeftH = -verticalX * (float) this.offsetX;
            float cropLeftV = -verticalY * (float) this.offsetX;
            topLeftX += baseYOffsetH + baseXOffsetH;
            topLeftY += baseYOffsetV + baseXOffsetV;
            topRightX += cropOffsetH + baseXOffsetH;
            topRightY += cropOffsetV + baseXOffsetV;
            bottomLeftX += baseYOffsetH + cropLeftH;
            bottomLeftY += baseYOffsetV + cropLeftV;
        }
        float bottomRightX = bottomLeftX + (topRightX - topLeftX);
        float bottomRightY = topRightY + (bottomLeftY - topLeftY);
        float minX;
        float maxX;
        if (topLeftX < topRightX) {
            minX = topLeftX;
            maxX = topRightX;
        } else {
            minX = topRightX;
            maxX = topLeftX;
        }
        if (bottomLeftX < minX) minX = bottomLeftX;
        if (bottomRightX < minX) minX = bottomRightX;
        if (bottomLeftX > maxX) maxX = bottomLeftX;
        if (bottomRightX > maxX) maxX = bottomRightX;
        float minY;
        float maxY;
        if (topLeftY < topRightY) {
            minY = topLeftY;
            maxY = topRightY;
        } else {
            minY = topRightY;
            maxY = topLeftY;
        }
        if (bottomLeftY < minY) minY = bottomLeftY;
        if (bottomRightY < minY) minY = bottomRightY;
        if (bottomLeftY > maxY) maxY = bottomLeftY;
        if (bottomRightY > maxY) maxY = bottomRightY;
        if (minX < (float) (this.toolkit.clipX1)) minX = (float) (this.toolkit.clipX1);
        if (maxX > (float) (this.toolkit.clipX2)) maxX = (float) (this.toolkit.clipX2);
        if (minY < (float) (this.toolkit.clipY1)) minY = (float) (this.toolkit.clipY1);
        if (maxY > (float) (this.toolkit.clipY2)) maxY = (float) (this.toolkit.clipY2);
        maxX = minX - maxX;
        if (maxX >= 0.0F) return false;
        maxY = minY - maxY;
        if (maxY >= 0.0F) return false;
        surfaceStride = this.toolkit.surfaceWidth;
        pixelOffset = (int) ((float) ((int) minY * surfaceStride) + minX);
        float product1 = (topRightX - topLeftX) * (bottomLeftY - topLeftY) - (topRightY - topLeftY) * (bottomLeftX - topLeftX);
        float product2 = (bottomLeftX - topLeftX) * (topRightY - topLeftY) - (bottomLeftY - topLeftY) * (topRightX - topLeftX);
        textureDuDx = (int) ((bottomLeftY - topLeftY) * 4096.0F * (float) this.width / product1);
        textureDvDx = (int) ((topRightY - topLeftY) * 4096.0F * (float) this.height / product2);
        textureDuDy = (int) ((bottomLeftX - topLeftX) * 4096.0F * (float) this.width / product2);
        textureDvDy = (int) ((topRightX - topLeftX) * 4096.0F * (float) this.height / product1);
        subPixelOffsetX = (int) (minX * 16.0F + 8.0F - (topLeftX + topRightX + bottomLeftX + bottomRightX) / 4.0F * 16.0F);
        subPixelOffsetY = (int) (minY * 16.0F + 8.0F - (topLeftY + topRightY + bottomLeftY + bottomRightY) / 4.0F * 16.0F);
        textureU = ((this.width >> 1 << 12) + (subPixelOffsetY * textureDuDy >> 4));
        textureV = ((this.height >> 1 << 12) + (subPixelOffsetY * textureDvDy >> 4));
        textureUOffsetX = subPixelOffsetX * textureDuDx >> 4;
        textureVOffsetX = subPixelOffsetX * textureDvDx >> 4;
        clipMinX = (int) minX;
        clipMaxX = (int) maxX;
        clipMinY = (int) minY;
        clipMaxY = (int) maxY;
        return true;
    }

    static {
        invAlpha = 0;
        green = 0;
        red = 0;
        alpha = 0;
        addAlpha = 0;
        addInvAlpha = 0;
    }
}
