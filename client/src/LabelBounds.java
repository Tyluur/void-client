/* Class318_Sub3 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Class318_Sub3
final class LabelBounds extends Class318 {
    boolean visible = false;
    int bottomY;
    int width;
    int topY;
    int bottomX;
    int topX;

    // method2500
    final boolean contains(int x, int y) {
        if (!this.visible) return false;
        int i_1_ = (this.topX - this.bottomX);
        int i_2_ = (this.topY - this.bottomY);
        int i_3_ = i_1_ * i_1_ + i_2_ * i_2_;
        int i_4_ = (x * i_1_ + y * i_2_ - (this.bottomX * i_1_ + this.bottomY * i_2_));
        if (i_4_ <= 0) {
            int i_5_ = this.bottomX - x;
            int i_6_ = this.bottomY - y;
            return i_5_ * i_5_ + i_6_ * i_6_ < (this.width * this.width);
        }
        if (i_4_ > i_3_) {
            int i_7_ = this.topX - x;
            int i_8_ = this.topY - y;
            return i_7_ * i_7_ + i_8_ * i_8_ < (this.width * this.width);
        }
        i_4_ = (i_4_ << 10) / i_3_;
        int i_9_ = this.bottomX + (i_1_ * i_4_ >> 10) - x;
        int i_10_ = this.bottomY + (i_2_ * i_4_ >> 10) - y;
        return i_9_ * i_9_ + i_10_ * i_10_ < (this.width * this.width);
    }

    public LabelBounds() {
        /* empty */
    }
}
