import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

final class StretchedMode {

    // ---------------------------------------------------------------
    // Configuration — flip these from your settings UI
    // ---------------------------------------------------------------

    /** Master toggle. Set to true to enable stretched mode. */
    static boolean enabled = true;

    /**
     * When true, adds black bars to preserve the game's aspect ratio.
     * When false, the image is stretched to fill the entire window.
     */
    static boolean keepAspectRatio = true;

    /**
     * When true, uses bilinear filtering (smooth/blurry).
     * When false, uses nearest-neighbour (sharp/pixelated, classic look).
     */
    static boolean bilinearFilter = false;

    // ---------------------------------------------------------------
    // Internal state — updated by updateStretchedDimensions()
    // ---------------------------------------------------------------

    /** Width of the destination draw rectangle on screen. */
    static int destW = 0;

    /** Height of the destination draw rectangle on screen. */
    static int destH = 0;

    /** X offset of the destination rectangle (for letterbox/pillarbox centering). */
    static int destX = 0;

    /** Y offset of the destination rectangle (for letterbox/pillarbox centering). */
    static int destY = 0;

    // ---------------------------------------------------------------
    // Core API
    // ---------------------------------------------------------------

    /**
     * Call this whenever the window or game resolution changes.
     *
     * @param gameW  Class321.anInt4017
     * @param gameH  Class348_Sub42_Sub8_Sub2.anInt10432
     * @param winW   Class272.anInt3473
     * @param winH   Class348_Sub22.anInt6857
     */
    static void updateStretchedDimensions(int gameW, int gameH, int winW, int winH) {
        if (!enabled || gameW <= 0 || gameH <= 0 || winW <= 0 || winH <= 0) {
            destX = 0;
            destY = 0;
            destW = gameW;
            destH = gameH;
            return;
        }

        if (keepAspectRatio) {
            double scaleX = (double) winW / gameW;
            double scaleY = (double) winH / gameH;
            double scale  = Math.min(scaleX, scaleY);
            destW = (int) (gameW * scale);
            destH = (int) (gameH * scale);
        } else {
            destW = winW;
            destH = winH;
        }

        destX = (winW - destW) / 2;
        destY = (winH - destH) / 2;
    }

    /**
     * Drop-in replacement for the two loading/login screen draw calls:
     *   graphics.drawImage(Class342.anImage4249, 0, 0, null);
     *
     * When stretched mode is OFF: behaves identically to the original.
     * When stretched mode is ON:  draws the image scaled into the dest rect.
     */
    static void drawScaled(Graphics g, Image src) {
        if (src == null) return;

        if (!enabled || destW <= 0 || destH <= 0) {
            g.drawImage(src, 0, 0, null);
            return;
        }

        applyInterpolation(g);

        // 10-argument form: maps src rect -> dest rect
        g.drawImage(src,
                destX, destY, destX + destW, destY + destH,
                0, 0, src.getWidth(null), src.getHeight(null),
                null);
    }

    /**
     * Apply the interpolation hint to a Graphics2D if available.
     * Safe to call with a plain Graphics object — just does nothing.
     */
    static void applyInterpolation(Graphics g) {
        if (!(g instanceof Graphics2D)) return;
        ((Graphics2D) g).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                bilinearFilter
                        ? RenderingHints.VALUE_INTERPOLATION_BILINEAR
                        : RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
    }

    /**
     * Translate a raw canvas X coordinate into game-space X.
     * Use this wherever mouse X is read from an event.
     */
    static int toGameX(int canvasX) {
        if (!enabled || destW <= 0) return canvasX;
        int gx = (canvasX - destX) * Class321.anInt4017 / destW;
        // clamp to game bounds
        if (gx < 0) gx = 0;
        if (gx >= Class321.anInt4017) gx = Class321.anInt4017 - 1;
        return gx;
    }

    /**
     * Translate a raw canvas Y coordinate into game-space Y.
     * Use this wherever mouse Y is read from an event.
     */
    static int toGameY(int canvasY) {
        if (!enabled || destH <= 0) return canvasY;
        int gy = (canvasY - destY) * Class348_Sub42_Sub8_Sub2.anInt10432 / destH;
        // clamp to game bounds
        if (gy < 0) gy = 0;
        if (gy >= Class348_Sub42_Sub8_Sub2.anInt10432) gy = Class348_Sub42_Sub8_Sub2.anInt10432 - 1;
        return gy;
    }
}