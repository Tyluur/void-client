import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

final class StretchedMode {

    // ---------------------------------------------------------------
    // Configuration
    // ---------------------------------------------------------------

    /** Master toggle. */
    static boolean enabled = true;

    /**
     * When true, black bars preserve the game's aspect ratio.
     * When false, the image stretches to fill the entire window.
     */
    static boolean keepAspectRatio = false;

    /**
     * When true, bilinear filtering (smooth).
     * When false, nearest-neighbour (sharp/pixelated).
     */
    static boolean bilinearFilter = false;

    // ---------------------------------------------------------------
    // Internal state — kept updated by drawScaled and updateStretchedDimensions.
    // method3011 in the rasterizers reads these directly.
    // ---------------------------------------------------------------

    static int destW = 0;
    static int destH = 0;
    static int destX = 0;
    static int destY = 0;

    // ---------------------------------------------------------------
    // Core API
    // ---------------------------------------------------------------

    /**
     * Call whenever the window or game resolution changes.
     * Also called automatically by drawScaled, so stored values
     * stay current even when timing is imperfect at startup.
     */
    static void updateStretchedDimensions(int gameW, int gameH, int winW, int winH) {
        if (!enabled || gameW <= 0 || gameH <= 0 || winW <= 0 || winH <= 0) {
            destX = 0;
            destY = 0;
            destW = gameW > 0 ? gameW : 0;
            destH = gameH > 0 ? gameH : 0;
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
     * Computes dest rect from explicit dimensions and stores results.
     * Used internally — call updateStretchedDimensions from outside.
     */
    private static void computeAndStore(int gameW, int gameH, int canvasW, int canvasH) {
        if (keepAspectRatio) {
            double scale = Math.min((double) canvasW / gameW, (double) canvasH / gameH);
            destW = (int) (gameW * scale);
            destH = (int) (gameH * scale);
        } else {
            destW = canvasW;
            destH = canvasH;
        }
        destX = (canvasW - destW) / 2;
        destY = (canvasH - destH) / 2;
    }

    /**
     * Drop-in replacement for:
     *   graphics.drawImage(Class342.anImage4249, 0, 0, null);
     *
     * Reads live canvas dimensions from Class305.aCanvas3869 so it is
     * always correct regardless of when updateStretchedDimensions was
     * last called (fixes startup timing issues).
     *
     * Also updates stored destX/Y/W/H as a side effect so that
     * method3011 in the rasterizers picks up fresh values.
     */
    static void drawScaled(Graphics g, Image src) {
        if (src == null) return;

        if (!enabled) {
            g.drawImage(src, 0, 0, null);
            return;
        }

        // Read LIVE canvas size — avoids startup race where the window
        // wasn't fully laid out when updateStretchedDimensions was first called.
        int canvasW = (Class305.aCanvas3869 != null) ? Class305.aCanvas3869.getWidth() : 0;
        int canvasH = (Class305.aCanvas3869 != null) ? Class305.aCanvas3869.getHeight() : 0;
        int srcW    = src.getWidth(null);
        int srcH    = src.getHeight(null);

        if (canvasW <= 0 || canvasH <= 0 || srcW <= 0 || srcH <= 0) {
            // Canvas not yet laid out — fall back to 1:1
            g.drawImage(src, 0, 0, null);
            return;
        }

        // If canvas is already game-sized there is nothing to scale.
        if (canvasW == srcW && canvasH == srcH) {
            g.drawImage(src, 0, 0, null);
            return;
        }

        // Compute fresh dest rect and update stored values for rasterizers.
        computeAndStore(srcW, srcH, canvasW, canvasH);

        applyInterpolation(g);
        g.drawImage(src,
                destX, destY, destX + destW, destY + destH,
                0, 0, srcW, srcH,
                null);
    }

    /**
     * Apply the interpolation hint if the Graphics is a Graphics2D.
     * Safe to call with a plain Graphics — just does nothing.
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
        if (gy < 0) gy = 0;
        if (gy >= Class348_Sub42_Sub8_Sub2.anInt10432) gy = Class348_Sub42_Sub8_Sub2.anInt10432 - 1;
        return gy;
    }
}