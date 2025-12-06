/* Class101_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Class101_Sub1
final class JavaMatrix extends Matrix {
    float cX;
    static int anInt5656;
    static int anInt5657;
    static int anInt5658;
    static int anInt5659;
    static int anInt5660;
    static int anInt5661;
    float bZ;
    static long aLong5663;
    float bY;
    static int anInt5665;
    float aX;
    static int anInt5667;
    static int anInt5668;
    float aY;
    static int anInt5670;
    static int anInt5671;
    float cZ;
    float cY;
    static int anInt5674;
    static Class246 aClass246_5675 = Class284.method2118((byte) -42);
    static int anInt5676;
    static Class351 aClass351_5677 = new Class351(56, 7);
    float bX;
    static int anInt5679;
    float aZ;
    float tY;
    static int anInt5682;
    static int anInt5683;
    static TextureSource aD5684;
    float tZ;
    float tX;
    static int anInt5687;
    static int anInt5688;
    static Class223 aClass223_5689 = new Class223(4, 1);

    public static void method911(int i) {
        if (i != 0) method911(-121);
        aClass223_5689 = null;
        aD5684 = null;
        aClass246_5675 = null;
        aClass351_5677 = null;
    }

    final void method910() {
        anInt5688++;
        this.cZ = this.bX = this.bY = 1.0F;
        this.cX = this.bZ = this.cY = this.aZ = this.aY = this.aX = this.tX = this.tZ = this.tY = 0.0F;
    }

    final void method894(int x, int z, int y) {
        anInt5674++;
        this.tZ = (float) z;
        this.cX = this.bZ = this.cY = this.aZ = this.aY = this.aX = 0.0F;
        this.cZ = this.bX = this.bY = 1.0F;
        this.tX = (float) x;
        this.tY = (float) y;
    }

    // method903
    final void rotate(int x, int y, int z, int pitch, int yaw, int roll) {
        anInt5682++;
        float cosX = Option_Sub4.COS_TABLE[pitch & 0x3fff];
        float sinX = Option_Sub4.SIN_TABLE[0x3fff & pitch];
        float cosY = Option_Sub4.COS_TABLE[yaw & 0x3fff];
        float sinY = Option_Sub4.SIN_TABLE[0x3fff & yaw];
        float cosZ = Option_Sub4.COS_TABLE[0x3fff & roll];
        float sinZ = Option_Sub4.SIN_TABLE[0x3fff & roll];
        float cosZsinY = cosZ * sinX;
        float sinZsinY = sinX * sinZ;
        this.aX = sinZ * sinY + cosY * cosZsinY;
        this.aY = cosZ * -sinY + sinZsinY * cosY;
        this.aZ = -sinX;
        this.bX = cosX * cosZ;
        this.bY = cosY * cosX;
        this.bZ = cosX * sinY;
        this.cX = cosZsinY * sinY + -cosY * sinZ;
        this.cY = cosX * sinZ;
        this.cZ = sinZsinY * sinY + cosZ * cosY;
        this.tY = (-((float) z * this.bY) + (-((float) y * this.aZ) + (float) -x * this.bZ));
        this.tX = (this.cZ * (float) -x - (float) y * this.cY - this.aY * (float) z);
        this.tZ = (-(this.aX * (float) z) + (this.cX * (float) -x - (float) y * this.bX));
    }

    static final int method912(int i) {
        if (i != 0) return -41;
        anInt5657++;
        return Class108.anInt1663;
    }

    final void method898(Matrix matrix) {
        anInt5683++;
        JavaMatrix javaMatrix_14_ = (JavaMatrix) matrix;
        this.aY = javaMatrix_14_.aY;
        this.tY = javaMatrix_14_.tY;
        this.cX = javaMatrix_14_.cX;
        this.bY = javaMatrix_14_.bY;
        this.aX = javaMatrix_14_.aX;
        this.bX = javaMatrix_14_.bX;
        this.aZ = javaMatrix_14_.aZ;
        this.cZ = javaMatrix_14_.cZ;
        this.bZ = javaMatrix_14_.bZ;
        this.tX = javaMatrix_14_.tX;
        this.cY = javaMatrix_14_.cY;
        this.tZ = javaMatrix_14_.tZ;
    }

    final void method905(int i, int i_15_, int i_16_, int[] is) {
        is[0] = (int) ((float) i_16_ * this.aY + (this.cY * (float) i_15_ + this.cZ * (float) i));
        anInt5687++;
        is[1] = (int) (this.cX * (float) i + (float) i_15_ * this.bX + this.aX * (float) i_16_);
        is[2] = (int) (this.bY * (float) i_16_ + ((float) i * this.bZ + (float) i_15_ * this.aZ));
    }

    // method891
    final void translate(int x, int z, int y) {
        this.tZ += (float) z;
        this.tY += (float) y;
        this.tX += (float) x;
        anInt5661++;
    }

    final void method908(int i) {
        anInt5656++;
        float f = Option_Sub4.COS_TABLE[i & 0x3fff];
        float f_19_ = Option_Sub4.SIN_TABLE[i & 0x3fff];
        float f_20_ = this.cZ;
        float f_21_ = this.cY;
        float f_22_ = this.aY;
        this.cZ = -(f_19_ * this.cX) + f * f_20_;
        float f_23_ = this.tX;
        this.cY = f_21_ * f - this.bX * f_19_;
        this.cX = f * this.cX + f_20_ * f_19_;
        this.aY = f * f_22_ - this.aX * f_19_;
        this.bX = f * this.bX + f_19_ * f_21_;
        this.aX = f_19_ * f_22_ + f * this.aX;
        this.tX = -(f_19_ * this.tZ) + f_23_ * f;
        this.tZ = f * this.tZ + f_19_ * f_23_;
    }

    final void method900(int i) {
        anInt5658++;
        float f = Option_Sub4.COS_TABLE[0x3fff & i];
        float f_24_ = Option_Sub4.SIN_TABLE[0x3fff & i];
        float f_25_ = this.cX;
        float f_26_ = this.bX;
        float f_27_ = this.aX;
        this.cX = f_25_ * f - this.bZ * f_24_;
        float f_28_ = this.tZ;
        this.bZ = f_24_ * f_25_ + this.bZ * f;
        this.bX = f * f_26_ - this.aZ * f_24_;
        this.aX = -(f_24_ * this.bY) + f * f_27_;
        this.aZ = this.aZ * f + f_24_ * f_26_;
        this.tZ = f * f_28_ - f_24_ * this.tY;
        this.bY = f * this.bY + f_27_ * f_24_;
        this.tY = f_28_ * f_24_ + f * this.tY;
    }

    final void method892(int i, int i_29_, int i_30_, int[] is) {
        i_30_ -= this.tY;
        anInt5668++;
        i_29_ -= this.tZ;
        i -= this.tX;
        is[0] = (int) (this.bZ * (float) i_30_ + (this.cX * (float) i_29_ + this.cZ * (float) i));
        is[1] = (int) ((float) i_29_ * this.bX + this.cY * (float) i + (float) i_30_ * this.aZ);
        is[2] = (int) ((float) i_30_ * this.bY + ((float) i_29_ * this.aX + (float) i * this.aY));
    }

    final void method899(int i) {
        anInt5670++;
        this.cZ = 1.0F;
        this.bX = this.bY = Option_Sub4.COS_TABLE[i & 0x3fff];
        this.aZ = Option_Sub4.SIN_TABLE[0x3fff & i];
        this.aX = -this.aZ;
        this.cY = this.aY = this.tX = this.cX = this.tZ = this.bZ = this.tY = 0.0F;
    }

    final void method902(int i) {
        anInt5667++;
        this.bY = 1.0F;
        this.cZ = this.bX = Option_Sub4.COS_TABLE[0x3fff & i];
        this.cX = Option_Sub4.SIN_TABLE[0x3fff & i];
        this.aY = this.tX = this.aX = this.tZ = this.bZ = this.aZ = this.tY = 0.0F;
        this.cY = -this.cX;
    }

    final Matrix method907() {
        anInt5660++;
        JavaMatrix javaMatrix_31_ = new JavaMatrix();
        javaMatrix_31_.bY = this.bY;
        javaMatrix_31_.tY = this.tY;
        javaMatrix_31_.bZ = this.bZ;
        javaMatrix_31_.aY = this.aY;
        javaMatrix_31_.cX = this.cX;
        javaMatrix_31_.aX = this.aX;
        javaMatrix_31_.tX = this.tX;
        javaMatrix_31_.bX = this.bX;
        javaMatrix_31_.cY = this.cY;
        javaMatrix_31_.tZ = this.tZ;
        javaMatrix_31_.cZ = this.cZ;
        javaMatrix_31_.aZ = this.aZ;
        return javaMatrix_31_;
    }

    final void method895(int i) {
        this.bX = 1.0F;
        anInt5676++;
        this.cZ = this.bY = Option_Sub4.COS_TABLE[0x3fff & i];
        this.aY = Option_Sub4.SIN_TABLE[i & 0x3fff];
        this.cY = this.tX = this.cX = this.aX = this.tZ = this.aZ = this.tY = 0.0F;
        this.bZ = -this.aY;
    }

    final void method896(int i) {
        anInt5659++;
        float f = Option_Sub4.COS_TABLE[0x3fff & i];
        float f_32_ = Option_Sub4.SIN_TABLE[i & 0x3fff];
        float f_33_ = this.cZ;
        float f_34_ = this.cY;
        float f_35_ = this.aY;
        this.cZ = f_33_ * f + f_32_ * this.bZ;
        float f_36_ = this.tX;
        this.cY = f * f_34_ + f_32_ * this.aZ;
        this.bZ = -(f_32_ * f_33_) + this.bZ * f;
        this.aY = f * f_35_ + f_32_ * this.bY;
        this.aZ = -(f_32_ * f_34_) + f * this.aZ;
        this.bY = -(f_32_ * f_35_) + f * this.bY;
        this.tX = f_36_ * f + f_32_ * this.tY;
        this.tY = f * this.tY - f_32_ * f_36_;
    }

    final void method890(int[] is) {
        anInt5671++;
        float f = -this.tX + (float) is[0];
        float f_37_ = (float) is[1] - this.tZ;
        float f_38_ = (float) is[2] - this.tY;
        is[2] = (int) (this.aY * f + f_37_ * this.aX + this.bY * f_38_);
        is[1] = (int) (this.cY * f + f_37_ * this.bX + f_38_ * this.aZ);
        is[0] = (int) (this.bZ * f_38_ + (f * this.cZ + this.cX * f_37_));
    }

    static final boolean method913(byte i) {
        if (i <= 115) return true;
        anInt5679++;
        return Class73.anInt4776 > 0;
    }

    public JavaMatrix() {
        method910();
    }

    final void method897(int i, int i_39_, int i_40_, int[] destination) {
        anInt5665++;
        destination[1] = (int) ((float) i * this.cX + this.bX * (float) i_39_ + (float) i_40_ * this.aX + this.tZ);
        destination[0] = (int) ((float) i_40_ * this.aY + (this.cY * (float) i_39_ + (float) i * this.cZ) + this.tX);
        destination[2] = (int) (this.tY + (this.aZ * (float) i_39_ + (float) i * this.bZ + (float) i_40_ * this.bY));
    }
}
