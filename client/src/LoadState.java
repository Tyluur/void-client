/* Class56 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.*;

final class LoadState {
    Class274 aClass274_1012;
    boolean displayPercentage; // aBoolean1013
    static int anInt1014;
    Class274 aClass274_1015;
    boolean updatePercentage; // aBoolean1016
    private final int anInt1017;
    static LoadState WAIT_FOR_MEMORY = new LoadState(0, Class274.aClass274_3499, Class274.aClass274_3499, 0, 1);
    static int anInt1019;
    static int anInt1020;
    int anInt1021;
    static int anInt1022;
    static LoadState INIT_LOADING_SCREEN_ARCHIVES = new LoadState(1, Class274.aClass274_3499, 2);
    static LoadState FETCH_LOADING_SCREEN_RESOURCES = new LoadState(2, Class274.aClass274_3499, Class274.aClass274_3499, 2, 3);
    int anInt1025;
    static LoadState INIT_FONT_INFO = new LoadState(3, Class274.aClass274_3499, 3);
    static LoadState LOAD_FONTS = new LoadState(4, Class274.aClass274_3499, Class274.aClass274_3499, 3, 4);
    static LoadState FETCH_FONTS = new LoadState(5, Class274.aClass274_3499, 4);
    static LoadState CREATE_COLLISION_MAPS = new LoadState(6, Class274.aClass274_3499, 4);
    static LoadState OPEN_JS5_GROUPS = new LoadState(7, Class274.aClass274_3499, Class274.aClass274_3499, 4, 5);
    static LoadState GET_JS5_INDEXES = new LoadState(8, Class274.aClass274_3499, Class274.aClass274_3499, 5, 98, true, true);//
    static LoadState PLAY_THEME_MUSIC = new LoadState(9, Class274.aClass274_3499, 99);
    static LoadState SETUP_LIB_PATH = new LoadState(10, Class274.aClass274_3499, 100);
    static LoadState DOWNLOAD_STUFF = new LoadState(11, Class274.aClass274_3500, Class274.aClass274_3500, 0, 92, true, true);
    static LoadState SETUP_CONFIG_DECODERS = new LoadState(12, Class274.aClass274_3500, Class274.aClass274_3500, 92, 92);
    private static LoadState A_LOAD_STATE_13 = new LoadState(13, Class274.aClass274_3500, Class274.aClass274_3500, 92, 93);
    static LoadState SETUP_STATIC_SPRITES = new LoadState(14, Class274.aClass274_3500, Class274.aClass274_3500, 94, 95);
    static LoadState SETUP_WORLD_MAP = new LoadState(15, Class274.aClass274_3500, Class274.aClass274_3500, 96, 97);
    static LoadState SETUP_VARC_SYSTEM = new LoadState(16, Class274.aClass274_3500, 97);
    static LoadState LOAD_LOGIN_WINDOW = new LoadState(17, Class274.aClass274_3500, 97);
    static LoadState SHOW_LOGIN_WINDOW = new LoadState(18, Class274.aClass274_3500, 100);
    static LoadState CLEANUP = new LoadState(19, Class274.aClass274_3500, 100);
    static LoadState COMPLETE = new LoadState(20, Class274.aClass274_3500, 100);
    static int anInt1044;
    static int[] anIntArray1045 = new int[2];

    private LoadState(int i, Class274 class274, int i_0_) {
        this(i, class274, class274, i_0_, i_0_, true, false);
    }

    final int method525(int i) {
        if (i >= -109) SETUP_VARC_SYSTEM = null;
        anInt1019++;
        return anInt1017;
    }

    public final String toString() {
        anInt1022++;
        throw new IllegalStateException();
    }

    public static void method526(int i) {
        LOAD_LOGIN_WINDOW = null;
        PLAY_THEME_MUSIC = null;
        CLEANUP = null;
        SETUP_WORLD_MAP = null;
        DOWNLOAD_STUFF = null;
        LOAD_FONTS = null;
        WAIT_FOR_MEMORY = null;
        INIT_FONT_INFO = null;
        if (i > 42) {
            SETUP_VARC_SYSTEM = null;
            GET_JS5_INDEXES = null;
            COMPLETE = null;
            SETUP_LIB_PATH = null;
            FETCH_LOADING_SCREEN_RESOURCES = null;
            CREATE_COLLISION_MAPS = null;
            INIT_LOADING_SCREEN_ARCHIVES = null;
            A_LOAD_STATE_13 = null;
            anIntArray1045 = null;
            SHOW_LOGIN_WINDOW = null;
            OPEN_JS5_GROUPS = null;
            SETUP_STATIC_SPRITES = null;
            FETCH_FONTS = null;
            SETUP_CONFIG_DECODERS = null;
        }
    }

    static final void method527(Frame frame, Class297 class297, boolean bool) {
        try {
            anInt1020++;
            for (; ; ) {
                Class144 class144 = class297.method2248((byte) 89, frame);
                while (class144.anInt1997 == 0) Class286_Sub5.method2161((byte) -124, 10L);
                if (class144.anInt1997 == 1) break;
                Class286_Sub5.method2161((byte) 33, 100L);
            }
            frame.setVisible(bool);
            frame.dispose();
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("jj.D(" + (frame != null ? "{...}" : "null") + ',' + (class297 != null ? "{...}" : "null") + ',' + bool + ')'));
        }
    }

    // Class56
    private LoadState(int i, Class274 class274, Class274 class274_1_, int i_2_, int i_3_) {
        this(i, class274, class274_1_, i_2_, i_3_, true, false);
    }

    // method528
    static final LoadState[] values(int i) {
        anInt1014++;
        int i_4_ = 108 / ((i - 34) / 55);
        return (new LoadState[]{WAIT_FOR_MEMORY, INIT_LOADING_SCREEN_ARCHIVES, FETCH_LOADING_SCREEN_RESOURCES, INIT_FONT_INFO, LOAD_FONTS, FETCH_FONTS, CREATE_COLLISION_MAPS, OPEN_JS5_GROUPS, GET_JS5_INDEXES, PLAY_THEME_MUSIC, SETUP_LIB_PATH, DOWNLOAD_STUFF, SETUP_CONFIG_DECODERS, A_LOAD_STATE_13, SETUP_STATIC_SPRITES, SETUP_WORLD_MAP, SETUP_VARC_SYSTEM, LOAD_LOGIN_WINDOW, SHOW_LOGIN_WINDOW, CLEANUP, COMPLETE});
    }

    private LoadState(int i, Class274 class274, Class274 class274_5_, int i_6_, int i_7_, boolean bool, boolean bool_8_) {
        try {
            this.aClass274_1012 = class274;
            this.anInt1021 = i_7_;
            anInt1017 = i;
            this.anInt1025 = i_6_;
            this.aClass274_1015 = class274_5_;
            this.updatePercentage = bool_8_;
            this.displayPercentage = bool;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("jj.<init>(" + i + ',' + (class274 != null ? "{...}" : "null") + ',' + (class274_5_ != null ? "{...}" : "null") + ',' + i_6_ + ',' + i_7_ + ',' + bool + ',' + bool_8_ + ')'));
        }
    }
}
