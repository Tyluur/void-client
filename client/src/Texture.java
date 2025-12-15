/* Class348_Sub42_Sub5 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

// Class348_Sub42_Sub5
final class Texture extends LinkedNode {
    private final TextureOp[] ops;
    private final TextureOp colourOp;
    static int anInt9522;
    private final int[] textureIds;
    private final int[] spriteIds;
    static int anInt9525;
    static int anInt9526;
    private final TextureOp alphaOp;
    private final TextureOp brightnessOp;
    static int anInt9529;
    static Class138 aClass138_9530 = new Class138(6, 0, 4, 2);
    static double aDouble9531;
    static int anInt9532;
    static Class351 aClass351_9533;
    static KeyLog[] KEYBOARD_EVENT_ARRAY_1 = new KeyLog[128];

    // method3183
    final int[] pixelsAlpha(TextureSource source, int width, int height, boolean columnMajor, double brightness, Index index, byte i_1_) {
        try {
            anInt9522++;
            Class286_Sub5.textureSource = source;
            Node.textureCacheIndex = index;
            for (int i = 0; ops.length > i; i++)
                ops[i].createImageCache(width, height, -256);
            Class348_Sub42_Sub13.setBrightness(brightness, (byte) -122);
            NPCDefinition.setSize(height, width, (byte) 114);
            int[] pixels = new int[width * height];
            int idx = 0;
            for (int y = 0; height > y; y++) {
                int[] reds;
                int[] greens;
                int[] blues;
                if (colourOp.monochrome) {
                    int[] output = colourOp.monochromeOutput(y, 255);
                    blues = output;
                    reds = output;
                    greens = output;
                } else {
                    int[][] output = colourOp.colourOutput(y, -1564599039);
                    reds = output[2];
                    greens = output[1];
                    blues = output[0];
                }
                if (columnMajor) idx = y;
                int[] alphas;
                if (alphaOp.monochrome) alphas = alphaOp.monochromeOutput(y, i_1_ + 244);
                else alphas = (alphaOp.colourOutput(y, -1564599039)[0]);
                for (int x = width - 1; x >= 0; x--) {
                    int blue = blues[x] >> 4;
                    if (blue > 255) blue = 255;
                    if (blue < 0) blue = 0;
                    int green = greens[x] >> 4;
                    if (green > 255) green = 255;
                    if (green < 0) green = 0;
                    int red = reds[x] >> 4;
                    if (red > 255) red = 255;
                    green = Class318_Sub1_Sub3_Sub3.brightnessMap[green];
                    if (red < 0) red = 0;
                    blue = Class318_Sub1_Sub3_Sub3.brightnessMap[blue];
                    red = Class318_Sub1_Sub3_Sub3.brightnessMap[red];
                    int alpha;
                    if (blue == 0 && green == 0 && red == 0) alpha = 0;
                    else {
                        alpha = alphas[x] >> 4;
                        if (alpha > 255) alpha = 255;
                        if (alpha < 0) alpha = 0;
                    }
                    pixels[idx++] = (red + (alpha << 24) + ((blue << 16) + (green << 8)));
                    if (columnMajor) idx += -1 + width;
                }
            }
            for (int i = 0; (i < ops.length); i++)
                ops[i].cacheReset((byte) -116);
            if (i_1_ != 11) anInt9532 = 97;
            return pixels;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("lr.D(" + (source != null ? "{...}" : "null") + ',' + width + ',' + height + ',' + columnMajor + ',' + brightness + ',' + (index != null ? "{...}" : "null") + ',' + i_1_ + ')'));
        }
    }

    // method3184
    final boolean available(TextureSource source, Index index, int i) {
        try {
            anInt9529++;
            if (Class101_Sub2.anInt5713 < 0) {
                for (int i_17_ = 0; (spriteIds.length > i_17_); i_17_++) {
                    if (!index.fileReady(false, spriteIds[i_17_])) return false;
                }
            } else {
                for (int i_18_ = 0; (i_18_ < spriteIds.length); i_18_++) {
                    if (!index.requestDownload(-10499, Class101_Sub2.anInt5713, spriteIds[i_18_])) return false;
                }
            }
            int i_19_ = 0;
            int i_20_ = -109 / ((10 - i) / 60);
            for (/**/; i_19_ < textureIds.length; i_19_++) {
                if (!source.textureReady(-7953, textureIds[i_19_])) return false;
            }
            return true;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("lr.B(" + (source != null ? "{...}" : "null") + ',' + (index != null ? "{...}" : "null") + ',' + i + ')'));
        }
    }

    final int[] pixelsOpaque(int width, TextureSource source, int i_21_, boolean columnMajor, double brightness, boolean flipHorizontal, Index index, int height) {
        try {
            Class286_Sub5.textureSource = source;
            Node.textureCacheIndex = index;
            anInt9526++;
            for (int i = 0; ops.length > i; i++)
                ops[i].createImageCache(width, height, i_21_ + -256);
            Class348_Sub42_Sub13.setBrightness(brightness, (byte) -89);
            NPCDefinition.setSize(height, width, (byte) 122);
            int[] pixels = new int[height * width];
            int x0;
            int x1;
            int dx;
            if (flipHorizontal) {
                x0 = width - 1;
                x1 = -1;
                dx = -1;
            } else {
                x0 = 0;
                x1 = 1;
                dx = width;
            }
            int idx = 0;
            for (int y = 0; height > y; y++) {
                int[] reds;
                int[] greens;
                int[] blues;
                if (colourOp.monochrome) {
                    int[] output = colourOp.monochromeOutput(y, 255);
                    reds = output;
                    greens = output;
                    blues = output;
                } else {
                    int[][] output = colourOp.colourOutput(y, -1564599039);
                    reds = output[1];
                    greens = output[0];
                    blues = output[2];
                }
                if (columnMajor) idx = y;
                for (int x = x0; x != dx; x += x1) {
                    int green = greens[x] >> 4;
                    if (green > 255) green = 255;
                    if (green < 0) green = 0;
                    int red = reds[x] >> 4;
                    if (red > 255) red = 255;
                    if (red < 0) red = 0;
                    int blue = blues[x] >> 4;
                    if (blue > 255) blue = 255;
                    red = Class318_Sub1_Sub3_Sub3.brightnessMap[red];
                    green = Class318_Sub1_Sub3_Sub3.brightnessMap[green];
                    if (blue < 0) blue = 0;
                    blue = Class318_Sub1_Sub3_Sub3.brightnessMap[blue];
                    int colour = (red << 8) + (green << 16) + blue;
                    if (colour != 0) colour |= ~0xffffff;
                    pixels[idx++] = colour;
                    if (columnMajor) idx += -1 + width;
                }
            }
            for (int i = i_21_; (ops.length > i); i++)
                ops[i].cacheReset((byte) -106);
            return pixels;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("lr.C(" + width + ',' + (source != null ? "{...}" : "null") + ',' + i_21_ + ',' + columnMajor + ',' + brightness + ',' + flipHorizontal + ',' + (index != null ? "{...}" : "null") + ',' + height + ')'));
        }
    }

    // method3186
    final float[] pixelsBloom(int width, TextureSource source, boolean columnMajor, int height, Index index, int i_42_) {
        try {
            anInt9525++;
            Node.textureCacheIndex = index;
            Class286_Sub5.textureSource = source;
            for (int i = 0; ops.length > i; i++)
                ops[i].createImageCache(width, height, -256);
            NPCDefinition.setSize(height, width, (byte) 115);
            float[] pixels = new float[4 * width * height];
            int idx = 0;
            for (int y = 0; height > y; y++) {
                int[] reds;
                int[] greens;
                int[] blues;
                if (colourOp.monochrome) {
                    int[] output = colourOp.monochromeOutput(y, 255);
                    reds = output;
                    greens = output;
                    blues = output;
                } else {
                    int[][] output = colourOp.colourOutput(y, -1564599039);
                    greens = output[1];
                    blues = output[0];
                    reds = output[2];
                }
                int[] alphas;
                if (alphaOp.monochrome) alphas = alphaOp.monochromeOutput(y, 255);
                else alphas = (alphaOp.colourOutput(y, -1564599039)[0]);
                int[] brightnesses;
                if (brightnessOp.monochrome) brightnesses = brightnessOp.monochromeOutput(y, 255);
                else brightnesses = (brightnessOp.colourOutput(y, -1564599039)[0]);
                if (columnMajor) idx = y << 2;
                for (int x = width + -1; x >= 0; x--) {
                    float alpha = (float) alphas[x] / 4096.0F;
                    float brightness = ((31.0F * (float) brightnesses[x] / 4096.0F + 1.0F) / 4096.0F);
                    if (!(alpha < 0.0F)) {
                        if (alpha > 1.0F) alpha = 1.0F;
                    } else alpha = 0.0F;
                    pixels[idx++] = (float) blues[x] * brightness;
                    pixels[idx++] = brightness * (float) greens[x];
                    pixels[idx++] = (float) reds[x] * brightness;
                    pixels[idx++] = alpha;
                    if (columnMajor) idx += -4 + (width << 2);
                }
            }
            for (int i = 0; (ops.length > i); i++)
                ops[i].cacheReset((byte) -125);
            return pixels;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("lr.A(" + width + ',' + (source != null ? "{...}" : "null") + ',' + columnMajor + ',' + height + ',' + (index != null ? "{...}" : "null") + ',' + i_42_ + ')'));
        }
    }

    public static void method3187(byte i) {
        KEYBOARD_EVENT_ARRAY_1 = null;
        int i_55_ = 19 % ((76 - i) / 39);
        aClass351_9533 = null;
        aClass138_9530 = null;
    }

    public Texture() {
        textureIds = new int[0];
        spriteIds = new int[0];
        brightnessOp = new TextureOpMonochromeFill(0);
        brightnessOp.imageCacheCapacity = 1;
        colourOp = new TextureOpMonochromeFill();
        colourOp.imageCacheCapacity = 1;
        alphaOp = new TextureOpMonochromeFill();
        ops = new TextureOp[]{colourOp, alphaOp, brightnessOp};
        alphaOp.imageCacheCapacity = 1;
    }

    Texture(Packet packet) {
        int operations = packet.readUnsignedByte(255);
        int spriteCount = 0;
        int textureCount = 0;
        int[][] opIds = new int[operations][];
        ops = new TextureOp[operations];
        for (int i = 0; i < operations; i++) {
            TextureOp op = Class348_Sub37.decode(125, packet);
            if (op.spriteId(-121) >= 0) spriteCount++;
            if (op.textureId(-1) >= 0) textureCount++;
            int count = (op.operations).length;
            opIds[i] = new int[count];
            for (int j = 0; j < count; j++)
                opIds[i][j] = packet.readUnsignedByte(255);
            ops[i] = op;
        }
        spriteIds = new int[spriteCount];
        textureIds = new int[textureCount];
        spriteCount = 0;
        textureCount = 0;
        for (int i = 0; operations > i; i++) {
            TextureOp textureOp = ops[i];
            int count = (textureOp.operations).length;
            for (int j = 0; count > j; j++)
                textureOp.operations[j] = ops[opIds[i][j]];
            int spriteId = textureOp.spriteId(-119);
            int textureId = textureOp.textureId(-1);
            if (spriteId > 0) spriteIds[spriteCount++] = spriteId;
            if (textureId > 0) textureIds[textureCount++] = textureId;
            opIds[i] = null;
        }
        colourOp = ops[packet.readUnsignedByte(255)];
        alphaOp = ops[packet.readUnsignedByte(255)];
        brightnessOp = ops[packet.readUnsignedByte(255)];
    }

    static {
        aClass351_9533 = new Class351(57, 3);
    }
}
