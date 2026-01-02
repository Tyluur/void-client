/* Class207 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class IndexedImage {
    byte[] alpha;
    int height;
    int[] palette;
    int innerWidth;
    byte[] raster;
    int offsetY;
    int innerHeight;
    int width;
    int offsetX;

    final int method1510() {
        return (this.width + this.offsetX + this.innerWidth);
    }

    final void method1511(int i) {
        int i_0_ = -1;
        if (this.palette.length < 255) {
            for (int i_1_ = 0; i_1_ < this.palette.length; i_1_++) {
                if (this.palette[i_1_] == i) {
                    i_0_ = i_1_;
                    break;
                }
            }
            if (i_0_ == -1) {
                i_0_ = this.palette.length;
                int[] is = new int[this.palette.length + 1];
                Class214.copy(this.palette, 0, is, 0, this.palette.length);
                this.palette = is;
                is[i_0_] = i;
            }
        } else {
            int i_2_ = 2147483647;
            int i_3_ = i >> 16 & 0xff;
            int i_4_ = i >> 8 & 0xff;
            int i_5_ = i & 0xff;
            for (int i_6_ = 0; i_6_ < this.palette.length; i_6_++) {
                int i_7_ = this.palette[i_6_];
                int i_8_ = i_7_ >> 16 & 0xff;
                int i_9_ = i_7_ >> 8 & 0xff;
                int i_10_ = i_7_ & 0xff;
                int i_11_ = i_3_ - i_8_;
                if (i_11_ < 0) i_11_ = -i_11_;
                int i_12_ = i_4_ - i_9_;
                if (i_12_ < 0) i_12_ = -i_12_;
                int i_13_ = i_5_ - i_10_;
                if (i_13_ < 0) i_13_ = -i_13_;
                int i_14_ = i_11_ + i_12_ + i_13_;
                if (i_14_ < i_2_) {
                    i_2_ = i_14_;
                    i_0_ = i_6_;
                }
            }
        }
        for (int i_15_ = this.height - 1; i_15_ > 0; i_15_--) {
            int i_16_ = i_15_ * this.width;
            for (int i_17_ = this.width - 1; i_17_ > 0; i_17_--) {
                if (((this.palette[this.raster[i_17_ + i_16_] & 0xff]) == 0) && (this.palette[((this.raster[i_17_ + i_16_ - 1 - this.width]) & 0xff)]) != 0) this.raster[i_17_ + i_16_] = (byte) i_0_;
            }
        }
    }

    static final IndexedImage method1512(Index index, int i) {
        byte[] is = index.fileReady((byte) 73, i);
        if (is == null) return null;
        return load(is)[0];
    }

    final void method1513(int i) {
        int i_18_ = method1510();
        int i_19_ = method1522();
        if (this.width != i_18_ || this.height != i_19_) {
            int i_20_ = i;
            if (i_20_ > this.offsetX) i_20_ = this.offsetX;
            int i_21_ = i;
            if ((i_21_ + this.offsetX + this.width) > i_18_) i_21_ = (i_18_ - this.offsetX - this.width);
            int i_22_ = i;
            if (i_22_ > this.offsetY) i_22_ = this.offsetY;
            int i_23_ = i;
            if ((i_23_ + this.offsetY + this.height) > i_19_) i_23_ = (i_19_ - this.offsetY - this.height);
            int i_24_ = this.width + i_20_ + i_21_;
            int i_25_ = this.height + i_22_ + i_23_;
            byte[] is = new byte[i_24_ * i_25_];
            if (this.alpha == null) {
                for (int i_26_ = 0; i_26_ < this.height; i_26_++) {
                    int i_27_ = i_26_ * this.width;
                    int i_28_ = (i_26_ + i_22_) * i_24_ + i_20_;
                    for (int i_29_ = 0; i_29_ < this.width; i_29_++)
                        is[i_28_++] = this.raster[i_27_++];
                }
            } else {
                byte[] is_30_ = new byte[i_24_ * i_25_];
                for (int i_31_ = 0; i_31_ < this.height; i_31_++) {
                    int i_32_ = i_31_ * this.width;
                    int i_33_ = (i_31_ + i_22_) * i_24_ + i_20_;
                    for (int i_34_ = 0; i_34_ < this.width; i_34_++) {
                        is_30_[i_33_] = this.alpha[i_32_];
                        is[i_33_++] = this.raster[i_32_++];
                    }
                }
                this.alpha = is_30_;
            }
            this.offsetX -= i_20_;
            this.offsetY -= i_22_;
            this.innerWidth -= i_21_;
            this.innerHeight -= i_23_;
            this.width = i_24_;
            this.height = i_25_;
            this.raster = is;
        }
    }

    final void method1514() {
        byte[] is = this.raster;
        if (this.alpha == null) {
            for (int i = (this.height >> 1) - 1; i >= 0; i--) {
                int i_35_ = i * this.width;
                int i_36_ = ((this.height - i - 1) * this.width);
                for (int i_37_ = -this.width; i_37_ < 0; i_37_++) {
                    byte i_38_ = is[i_35_];
                    is[i_35_] = is[i_36_];
                    is[i_36_] = i_38_;
                    i_35_++;
                    i_36_++;
                }
            }
        } else {
            byte[] is_39_ = this.alpha;
            for (int i = (this.height >> 1) - 1; i >= 0; i--) {
                int i_40_ = i * this.width;
                int i_41_ = ((this.height - i - 1) * this.width);
                for (int i_42_ = -this.width; i_42_ < 0; i_42_++) {
                    byte i_43_ = is[i_40_];
                    is[i_40_] = is[i_41_];
                    is[i_41_] = i_43_;
                    i_43_ = is_39_[i_40_];
                    is_39_[i_40_] = is_39_[i_41_];
                    is_39_[i_41_] = i_43_;
                    i_40_++;
                    i_41_++;
                }
            }
        }
        int i = this.offsetY;
        this.offsetY = this.innerHeight;
        this.innerHeight = i;
    }

    final void method1515(int i) {
        int i_44_ = -1;
        if (this.palette.length < 255) {
            for (int i_45_ = 0; i_45_ < this.palette.length; i_45_++) {
                if (this.palette[i_45_] == i) {
                    i_44_ = i_45_;
                    break;
                }
            }
            if (i_44_ == -1) {
                i_44_ = this.palette.length;
                int[] is = new int[this.palette.length + 1];
                Class214.copy(this.palette, 0, is, 0, this.palette.length);
                this.palette = is;
                is[i_44_] = i;
            }
        } else {
            int i_46_ = 2147483647;
            int i_47_ = i >> 16 & 0xff;
            int i_48_ = i >> 8 & 0xff;
            int i_49_ = i & 0xff;
            for (int i_50_ = 0; i_50_ < this.palette.length; i_50_++) {
                int i_51_ = this.palette[i_50_];
                int i_52_ = i_51_ >> 16 & 0xff;
                int i_53_ = i_51_ >> 8 & 0xff;
                int i_54_ = i_51_ & 0xff;
                int i_55_ = i_47_ - i_52_;
                if (i_55_ < 0) i_55_ = -i_55_;
                int i_56_ = i_48_ - i_53_;
                if (i_56_ < 0) i_56_ = -i_56_;
                int i_57_ = i_49_ - i_54_;
                if (i_57_ < 0) i_57_ = -i_57_;
                int i_58_ = i_55_ + i_56_ + i_57_;
                if (i_58_ < i_46_) {
                    i_46_ = i_58_;
                    i_44_ = i_50_;
                }
            }
        }
        int i_59_ = 0;
        byte[] is = (new byte
                [this.width * this.height]);
        for (int i_60_ = 0; i_60_ < this.height; i_60_++) {
            for (int i_61_ = 0; i_61_ < this.width; i_61_++) {
                int i_62_ = this.raster[i_59_] & 0xff;
                if (this.palette[i_62_] == 0) {
                    if (i_61_ > 0 && (this.palette[(this.raster[i_59_ - 1] & 0xff)]) != 0) i_62_ = i_44_;
                    else if (i_60_ > 0 && (this.palette[((this.raster[i_59_ - this.width]) & 0xff)]) != 0) i_62_ = i_44_;
                    else if (i_61_ < this.width - 1 && (this.palette[(this.raster[i_59_ + 1] & 0xff)]) != 0) i_62_ = i_44_;
                    else if (i_60_ < this.height - 1 && (this.palette[((this.raster[i_59_ + this.width]) & 0xff)]) != 0) i_62_ = i_44_;
                }
                is[i_59_++] = (byte) i_62_;
            }
        }
        this.raster = is;
    }

    final int[] method1516() {
        int i = method1510();
        int[] is = new int[i * method1522()];
        if (this.alpha == null) {
            for (int i_67_ = 0; i_67_ < this.height; i_67_++) {
                int i_68_ = i_67_ * this.width;
                int i_69_ = (this.offsetX + (i_67_ + this.offsetY) * i);
                for (int i_70_ = 0; i_70_ < this.width; i_70_++) {
                    int i_71_ = (this.palette[this.raster[i_68_++] & 0xff]);
                    if (i_71_ != 0) is[i_69_++] = ~0xffffff | i_71_;
                    else is[i_69_++] = 0;
                }
            }
        } else {
            for (int i_63_ = 0; i_63_ < this.height; i_63_++) {
                int i_64_ = i_63_ * this.width;
                int i_65_ = (this.offsetX + (i_63_ + this.offsetY) * i);
                for (int i_66_ = 0; i_66_ < this.width; i_66_++) {
                    is[i_65_++] = (this.alpha[i_64_] << 24 | (this.palette[(this.raster[i_64_] & 0xff)]));
                    i_64_++;
                }
            }
        }
        return is;
    }

    private static final IndexedImage[] load(byte[] data) {
        Packet packet = new Packet(data);
        packet.pos = data.length - 2;
        int count = packet.readUnsignedShort(842397944);
        IndexedImage[] images = new IndexedImage[count];
        for (int i = 0; i < count; i++)
            images[i] = new IndexedImage();
        packet.pos = data.length - 7 - count * 8;
        int scaleWidth = packet.readUnsignedShort(842397944);
        int scaleHeight = packet.readUnsignedShort(842397944);
        int paletteSize = (packet.readUnsignedByte(255) & 0xff) + 1;
        for (int i = 0; i < count; i++)
            images[i].offsetX = packet.readUnsignedShort(842397944);
        for (int i = 0; i < count; i++)
            images[i].offsetY = packet.readUnsignedShort(842397944);
        for (int i = 0; i < count; i++)
            images[i].width = packet.readUnsignedShort(842397944);
        for (int i = 0; i < count; i++)
            images[i].height = packet.readUnsignedShort(842397944);
        for (int i = 0; i < count; i++) {
            IndexedImage image = images[i];
            image.innerWidth = (scaleWidth - image.width - image.offsetX);
            image.innerHeight = (scaleHeight - image.height - image.offsetY);
        }
        packet.pos = data.length - 7 - count * 8 - (paletteSize - 1) * 3;
        int[] palette = new int[paletteSize];
        for (int i = 1; i < paletteSize; i++) {
            palette[i] = packet.readMedium(-1);
            if (palette[i] == 0) palette[i] = 1;
        }
        for (int i = 0; i < count; i++)
            images[i].palette = palette;
        packet.pos = 0;
        for (int i = 0; i < count; i++) {
            IndexedImage image = images[i];
            int dimension = (image.width * image.height);
            image.raster = new byte[dimension];
            int flags = packet.readUnsignedByte(255);
            if ((flags & 0x2) == 0) {
                if ((flags & 0x1) == 0) {
                    for (int pixel = 0; pixel < dimension; pixel++)
                        image.raster[pixel] = packet.readByte(-126);
                } else {
                    for (int x = 0; x < image.width; x++) {
                        for (int y = 0; y < image.height; y++)
                            image.raster[(x + y * image.width)] = packet.readByte(-96);
                    }
                }
            } else {
                boolean transparent = false;
                image.alpha = new byte[dimension];
                if ((flags & 0x1) == 0) {
                    for (int pixel = 0; pixel < dimension; pixel++)
                        image.raster[pixel] = packet.readByte(-118);
                    for (int pixel = 0; pixel < dimension; pixel++) {
                        byte a = (image.alpha[pixel] = packet.readByte(-89));
                        transparent = transparent | a != -1;
                    }
                } else {
                    for (int x = 0; x < image.width; x++) {
                        for (int y = 0; y < image.height; y++)
                            image.raster[(x + y * image.width)] = packet.readByte(-84);
                    }
                    for (int x = 0; x < image.width; x++) {
                        for (int y = 0; y < image.height; y++) {
                            byte a = (image.alpha[x + y * (image.width)] = packet.readByte(-122));
                            transparent = transparent | a != -1;
                        }
                    }
                }
                if (!transparent) image.alpha = null;
            }
        }
        return images;
    }

    final void method1518() {
        byte[] is = this.raster;
        if (this.alpha == null) {
            for (int i = this.height - 1; i >= 0; i--) {
                int i_98_ = i * this.width;
                for (int i_99_ = (i + 1) * this.width; i_98_ < i_99_; i_98_++) {
                    i_99_--;
                    byte i_100_ = is[i_98_];
                    is[i_98_] = is[i_99_];
                    is[i_99_] = i_100_;
                }
            }
        } else {
            byte[] is_101_ = this.alpha;
            for (int i = this.height - 1; i >= 0; i--) {
                int i_102_ = i * this.width;
                for (int i_103_ = (i + 1) * this.width; i_102_ < i_103_; i_102_++) {
                    i_103_--;
                    byte i_104_ = is[i_102_];
                    is[i_102_] = is[i_103_];
                    is[i_103_] = i_104_;
                    i_104_ = is_101_[i_102_];
                    is_101_[i_102_] = is_101_[i_103_];
                    is_101_[i_103_] = i_104_;
                }
            }
        }
        int i = this.offsetX;
        this.offsetX = this.innerWidth;
        this.innerWidth = i;
    }

    static final IndexedImage[] method1519(Index index, int i, int i_105_) {
        byte[] is = index.file(-1860, i, i_105_);
        if (is == null) return null;
        return load(is);
    }

    final void method1520() {
        byte[] is = (new byte
                [this.width * this.height]);
        int i = 0;
        if (this.alpha == null) {
            for (int i_106_ = 0; i_106_ < this.width; i_106_++) {
                for (int i_107_ = this.height - 1; i_107_ >= 0; i_107_--)
                    is[i++] = (this.raster[i_106_ + i_107_ * this.width]);
            }
            this.raster = is;
        } else {
            byte[] is_108_ = new byte[(this.width * this.height)];
            for (int i_109_ = 0; i_109_ < this.width; i_109_++) {
                for (int i_110_ = this.height - 1; i_110_ >= 0; i_110_--) {
                    is[i] = (this.raster[i_109_ + i_110_ * this.width]);
                    is_108_[i++] = (this.alpha[i_109_ + i_110_ * this.width]);
                }
            }
            this.raster = is;
            this.alpha = is_108_;
        }
        int i_111_ = this.offsetY;
        this.offsetY = this.offsetX;
        this.offsetX = this.innerHeight;
        this.innerHeight = this.innerWidth;
        this.innerWidth = this.offsetY;
        i_111_ = this.height;
        this.height = this.width;
        this.width = i_111_;
    }

    public IndexedImage() {
        /* empty */
    }

    static final IndexedImage loadFirst(Index index, int i, int i_112_) {
        byte[] data = index.file(-1860, i, i_112_);
        if (data == null) return null;
        return load(data)[0];
    }

    final int method1522() {
        return (this.height + this.offsetY + this.innerHeight);
    }

    static final IndexedImage[] method1523(Index index, int i) {
        byte[] is = index.fileReady((byte) 73, i);
        if (is == null) return null;
        return load(is);
    }

    final void trim() {
        int i = method1510();
        int i_113_ = method1522();
        if (this.width != i || this.height != i_113_) {
            byte[] is = new byte[i * i_113_];
            if (this.alpha == null) {
                for (int i_119_ = 0; i_119_ < this.height; i_119_++) {
                    int i_120_ = i_119_ * this.width;
                    int i_121_ = ((i_119_ + this.offsetY) * i + this.offsetX);
                    for (int i_122_ = 0; i_122_ < this.width; i_122_++)
                        is[i_121_++] = this.raster[i_120_++];
                }
            } else {
                byte[] is_114_ = new byte[i * i_113_];
                for (int i_115_ = 0; i_115_ < this.height; i_115_++) {
                    int i_116_ = i_115_ * this.width;
                    int i_117_ = ((i_115_ + this.offsetY) * i + this.offsetX);
                    for (int i_118_ = 0; i_118_ < this.width; i_118_++) {
                        is[i_117_] = this.raster[i_116_];
                        is_114_[i_117_++] = this.alpha[i_116_++];
                    }
                }
                this.alpha = is_114_;
            }
            this.offsetX = this.innerWidth = this.offsetY = this.innerHeight = 0;
            this.width = i;
            this.height = i_113_;
            this.raster = is;
        }
    }
}
