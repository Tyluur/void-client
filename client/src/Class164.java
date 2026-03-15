/* Class164 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import jagex3.jagmisc.jagmisc;

final class Class164 {
    static int anInt2172;
    static int anInt2173;
    static int anInt2174;
    static int anInt2175;

    static final void method1277(byte i) {
        anInt2175++;
        Class351.aClass60_4327.method590(i + -62);
        TextureUniverse.aClass60_4417.method590(0);
        Option_Sub24.aClass60_6096.method590(0);
        if (i != 62) method1277((byte) 43);
        TextureOpMonorchromeEdgeDetector.aClass60_9171.method590(0);
    }

    // method1278
    static final int essentials(int i) {
        if (Class316.clientOptions.safeMode.getValue(i + -3690) == 0) {
            for (int i_0_ = 0; (i_0_ < ClientScript.anInt9699); i_0_++) {
                if (Texture.KEYBOARD_EVENT_ARRAY_1[i_0_].getKeyChar((byte) 31) == 115 || Texture.KEYBOARD_EVENT_ARRAY_1[i_0_].getKeyChar((byte) 71) == 83) {
                    Class316.clientOptions.update((byte) 74, (Class316.clientOptions.safeMode), 1);
                    Class304.aBoolean3847 = true;
                    break;
                }
            }
        }
        anInt2174++;
        if (Class348_Sub42_Sub15.state == LoadState.WAIT_FOR_MEMORY) {
            Runtime runtime = Runtime.getRuntime();
            int usedMemory = (int) ((runtime.totalMemory() + -runtime.freeMemory()) / 1024L);
            long now = Class62.safeTime(i + 28559);
            if (Class348_Sub17.lastmemoryCheck == 0) Class348_Sub17.lastmemoryCheck = now;
            if (usedMemory > 16384 && -Class348_Sub17.lastmemoryCheck + now < 5000) {
                if (-Class173.lastGc + now > 1000L) {
                    System.gc();
                    Class173.lastGc = now;
                }
                return 0;
            }
        }
        if (LoadState.INIT_LOADING_SCREEN_ARCHIVES == Class348_Sub42_Sub15.state) {
            if (Class175.js5MasterIndex == null) Class175.js5MasterIndex = new Js5MasterIndex(SystemInfo.aClass248_6601, Class39.aClass112_520, Class52.aBigInteger4896, Class348_Sub42_Sub15.aBigInteger9657);
            if (!Class175.js5MasterIndex.method2674(7)) return 0;
            Class348_Sub23.setToolkit(null, 0, true, 0);
            Class286_Sub7.loadSpritesRaw = !Class348_Sub14.method2804((byte) -63);
            Class286_Sub7.LOADING_SPRITES = Class369_Sub2.index(false, (Class286_Sub7.loadSpritesRaw ? 34 : 32), (byte) -23, 1);
            TextureOpTiledSprite.LOADING_SCREENS = Class369_Sub2.index(false, 33, (byte) -23, 1);
            Class104.FONT_INDEX = Class369_Sub2.index(false, 13, (byte) -23, 1);
        }
        if (LoadState.FETCH_LOADING_SCREEN_RESOURCES == Class348_Sub42_Sub15.state) {
            boolean bool = TextureOpTiledSprite.LOADING_SCREENS.isComplete(89);
            int i_2_ = Class13.js5ResourceProviders[33].indexPercentage(1);
            i_2_ = i_2_ + Class13.js5ResourceProviders[!Class286_Sub7.loadSpritesRaw ? 32 : 34].indexPercentage(1);
            i_2_ += Class13.js5ResourceProviders[13].indexPercentage(1);
            i_2_ = i_2_ + (!bool ? TextureOpTiledSprite.LOADING_SCREENS.completePercentage((byte) -31) : 100);
            if (i_2_ != 400) return i_2_ / 4;
            JavaSurface.anInt6924 = Class286_Sub7.LOADING_SPRITES.indexCrc(77);
            Class108.anInt1663 = TextureOpTiledSprite.LOADING_SCREENS.indexCrc(i + 28561);
            LoadingScreenOpFactory.loadFonts(Class286_Sub7.LOADING_SPRITES, 0);
            int i_3_ = Class316.clientOptions.aClass239_Sub19_7257.method1805(i ^ 0x11ae);
            Class186_Sub1.loadingScreenManager = new LoadingScreenManager(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, TextureOpTiledSprite.LOADING_SCREENS);
            int[] is = Class186_Sub1.loadingScreenManager.getSequence(i_3_, 0);
            if (is.length == 0) is = Class186_Sub1.loadingScreenManager.getSequence(0, 0);
            LoadingScreenOpFactory opFactory = new LoadingScreenOpFactory(Class286_Sub7.LOADING_SPRITES, Class104.FONT_INDEX);
            if (is.length > 0) {
                Class182.loadingScreens = new LoadingScreen[is.length];
                for (int i_4_ = 0; (Class182.loadingScreens.length > i_4_); i_4_++)
                    Class182.loadingScreens[i_4_] = new Class195(Class186_Sub1.loadingScreenManager.get(is[i_4_], (byte) 102), opFactory);
            }
        }
        if (Class348_Sub42_Sub15.state == LoadState.INIT_FONT_INFO) ByteArraySecondaryNode.initFontTypeList(Class104.FONT_INDEX, -81, Class5_Sub1.method184(1084489728), Class286_Sub7.LOADING_SPRITES);
        if (LoadState.LOAD_FONTS == Class348_Sub42_Sub15.state) {
            int i_5_ = Class348_Sub50.method3420(0);
            int i_6_ = Class348_Sub42_Sub16.method3256(2);
            if (i_6_ > i_5_) return 100 * i_5_ / i_6_;
        }
        if (Class348_Sub42_Sub15.state == LoadState.FETCH_FONTS) {
            if (Class182.loadingScreens != null && (Class182.loadingScreens.length > 0)) {
                if (Class182.loadingScreens[0].percentage(-19079) < 100) return 0;
                if (Class182.loadingScreens.length > 1 && Class186_Sub1.loadingScreenManager.hasDefault(86) && (Class182.loadingScreens[1].percentage(i + 9581) < 100)) return 0;
            }
            TimedVarDomain.method1311(5139, Class348_Sub8.active);
            Class369.method3568(Class348_Sub8.active, 4);
            Packet.setStep(2, 1);
        }
        if (Class348_Sub42_Sub15.state == LoadState.CREATE_COLLISION_MAPS) {
            for (int i_7_ = 0; i_7_ < 4; i_7_++)
                MouseLog.collisionMaps[i_7_] = Sprite_Sub1.method988(TextureOpBinary.mapWidth, 1, Class367_Sub4.mapLength);
        }
        if (Class348_Sub42_Sub15.state == LoadState.OPEN_JS5_GROUPS) {
            Class21.SPRITES = Class369_Sub2.index(false, 8, (byte) -23, 1);
            Class348_Sub29.ANIMATION_SKELETONS = Class369_Sub2.index(false, 0, (byte) -23, 1);
            Class186.ANIMATION_SKINS = Class369_Sub2.index(false, 1, (byte) -23, 1);
            Class95.CONFIGS = Class369_Sub2.index(false, 2, (byte) -23, 1);
            Class348_Sub35.INTERFACES = Class369_Sub2.index(false, 3, (byte) -23, 1);
            ModelParticleEmitter.SOUND_EFFECTS = Class369_Sub2.index(false, 4, (byte) -23, 1);
            Class367_Sub10.MAPS = Class369_Sub2.index(true, 5, (byte) -23, 1);
            Class59_Sub2_Sub1.MUSIC = Class369_Sub2.index(true, 6, (byte) -23, 1);
            aa_Sub3.MODELS = Class369_Sub2.index(false, 7, (byte) -23, 1);
            Class369_Sub2.TEXTURES = Class369_Sub2.index(false, 9, (byte) -23, 1);
            Class16.HUFFMAN = Class369_Sub2.index(false, 10, (byte) -23, 1);
            Class348_Sub23_Sub2.MUSIC_EFFECTS = Class369_Sub2.index(false, 11, (byte) -23, 1);
            Class113.CLIENT_SCRIPTS = Class369_Sub2.index(false, 12, (byte) -23, 1);
            Option_Sub4.MIDI_INSTRUMENTS = Class369_Sub2.index(false, 14, (byte) -23, 1);
            Class123.aIndex_1815 = Class369_Sub2.index(false, 15, (byte) -23, 1);
            Class94.OBJECTS = Class369_Sub2.index(false, 16, (byte) -23, 1);
            Class247.ENUMS = Class369_Sub2.index(false, 17, (byte) -23, 1);
            Class216.NPCS = Class369_Sub2.index(false, 18, (byte) -23, 1);
            Class174.ITEMS = Class369_Sub2.index(false, 19, (byte) -23, 1);
            r_Sub2.ANIMATIONS = Class369_Sub2.index(false, 20, (byte) -23, 1);
            Class78.GRAPHICS = Class369_Sub2.index(false, 21, (byte) -23, 1);
            Class348_Sub16_Sub3.VARBITS = Class369_Sub2.index(false, 22, (byte) -23, 1);
            Class348_Sub32.WORLD_MAP = Class369_Sub2.index(true, 23, (byte) -23, 1);
            Class130.QUICK_CHAT_MESSAGES = Class369_Sub2.index(false, 24, (byte) -23, 1);
            VarcstrTypeList.QUICK_CHAT_MENUS = Class369_Sub2.index(false, 25, (byte) -23, 1);
            Class348_Sub11.TEXTURE_DEFINITIONS = Class369_Sub2.index(true, 26, (byte) -23, 1);
            Option.PARTICLES = Class369_Sub2.index(false, 27, (byte) -23, 1);
            Class367_Sub8.DEFAULTS = Class369_Sub2.index(true, 28, (byte) -23, 1);
            Deque.BILLBOARDS = Class369_Sub2.index(false, 29, (byte) -23, 1);
            Class126.NATIVE_LIBRARIES = Class369_Sub2.index(true, 30, (byte) -23, 1);
            Class136.SHADERS = Class369_Sub2.index(true, 31, (byte) -23, 1);
            Class146.VIDEOS = Class369_Sub2.index(true, 36, (byte) -23, 2);
        }
        if (LoadState.GET_JS5_INDEXES == Class348_Sub42_Sub15.state) {
            int percentage = 0;
            for (int i_9_ = 0; i_9_ < 37; i_9_++) {
                if (Class13.js5ResourceProviders[i_9_] != null) percentage += (Class13.js5ResourceProviders[i_9_].indexPercentage(i + 28661) * Class8.JS5_PERCENTAGES[i_9_] / 100);
            }
            if (percentage != 100) {
                if (FloorOverlayTypeList.anInt3435 < 0) FloorOverlayTypeList.anInt3435 = percentage;
                return ((percentage + -FloorOverlayTypeList.anInt3435) * 100 / (-FloorOverlayTypeList.anInt3435 + 100));
            }
            Class286_Sub5.getJs5Indexes((byte) -109, Class21.SPRITES);
            ByteArraySecondaryNode.initFontTypeList(Class104.FONT_INDEX, -124, Class5_Sub1.method184(i ^ ~0x40a46ff3), Class21.SPRITES);
        }
        if (LoadState.PLAY_THEME_MUSIC == Class348_Sub42_Sub15.state) {
            if (Class345.anInt4270 == -1) Class345.anInt4270 = Class59_Sub2_Sub1.MUSIC.groupId("scape main", 0);
            r_Sub1.method3290(56);
            Packet.setStep(2, 2);
        }
        if (LoadState.SETUP_LIB_PATH == Class348_Sub42_Sub15.state) Class30.method323(Class126.NATIVE_LIBRARIES, Class348_Sub23_Sub1.aClass297_8992, (byte) 95);
        if (LoadState.DOWNLOAD_STUFF == Class348_Sub42_Sub15.state) {
            int i_10_ = SafeModeOption.method1770((byte) -25);
            if (i_10_ < 100) return i_10_;
            ObjectTypeList.method2013(Class367_Sub8.DEFAULTS.fileReady((byte) 73, 1), (byte) 112);
            RuntimeException_Sub1.method4012(Class367_Sub8.DEFAULTS.fileReady((byte) 73, 3), (byte) -111);
        }
        if (i != -28660) return 2;
        if (Class348_Sub42_Sub15.state == LoadState.SETUP_CONFIG_DECODERS) {
            if (JavaSurface.anInt6923 != -1 && !aa_Sub3.MODELS.requestDownload(-10499, JavaSurface.anInt6923, 0)) return 99;
            TextureOpVerticalGradient.js5TextureSource = new Js5TextureSource(Class348_Sub11.TEXTURE_DEFINITIONS, Class369_Sub2.TEXTURES, Class21.SPRITES);
            Class101_Sub3.paramTypeList = new ParamTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS);
            Class64_Sub3.basTypeList = new BASTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS);
            Option.cursorTypeList = new CursorTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS, Class21.SPRITES);
            Class348_Sub7.enumTypeList = new EnumTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class247.ENUMS);
            Class229.floorOverlayTypeList = new FloorOverlayTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS);
            Class362.floorUnderlayTypeList = new FloorUnderlayTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS);
            Class73.hitmarkTypeList = new HitmarkTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS, Class21.SPRITES);
            TextureOpMandelbrot.idkTypeList = new IDKTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS, aa_Sub3.MODELS);
            Class127_Sub1.invTypeList = new InvTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS);
            Class348_Sub1.lightTypeList = new LightTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS);
            TextureOpColourGradient.objectTypeList = new ObjectTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, true, Class94.OBJECTS, aa_Sub3.MODELS);
            Class348_Sub23_Sub2.mapElementTypeList = new MapElementTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS, Class21.SPRITES);
            Class2.msiTypeList = new MSITypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS, Class21.SPRITES);
            BillboardType.npcTypeList = new NPCTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, true, Class216.NPCS, aa_Sub3.MODELS);
            Exception_Sub1.itemTypeList = new ItemTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, true, Class101_Sub3.paramTypeList, Class174.ITEMS, aa_Sub3.MODELS);
            Class348_Sub23_Sub2.questTypeList = new QuestTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS);
            Class10.animTypeList = new AnimTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, r_Sub2.ANIMATIONS, Class348_Sub29.ANIMATION_SKELETONS, Class186.ANIMATION_SKINS);
            Class30.skyBoxTypeList = new SkyBoxTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS);
            Class123.skyBoxSphereTypeList = new SkyBoxSphereTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS);
            TextureOpColourFill.gfxTypeList = new GfxTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class78.GRAPHICS, aa_Sub3.MODELS);
            Class136.structTypeList = new StructTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS);
            Class91.varcStrTypeList = new VarcstrTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS);
            Option_Sub14.varcTypeList = new VarcTypeList(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS);
            Class229.varBitTypeList = new VarBitTypeListClient(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class348_Sub16_Sub3.VARBITS);
            Class269.varPlayerTypeList = new VarPlayerTypeListClient(Class348_Sub42_Sub8_Sub2.modeGame, AnimBase.language, Class95.CONFIGS);
            StructTypeList.initInterfaces(Class104.FONT_INDEX, (byte) -100, Class348_Sub35.INTERFACES, Class21.SPRITES, aa_Sub3.MODELS);
            Applet_Sub1.setBillboardJs5(0, Deque.BILLBOARDS);
            Class200.quickChatCatTypeList = new QuickChatCatTypeList(AnimBase.language, Class130.QUICK_CHAT_MESSAGES, VarcstrTypeList.QUICK_CHAT_MENUS);
            Option_Sub6.quickChatPhraseTypeList = new QuickChatPhraseTypeList(AnimBase.language, Class130.QUICK_CHAT_MESSAGES, VarcstrTypeList.QUICK_CHAT_MENUS, new Class28());
            IDKTypeList.initWornItemIds(0);
            TextureOpColourGradient.objectTypeList.method2008(i + 28539, Class316.clientOptions.aClass239_Sub27_7261.method1840(i + -3690) == 0);
            Class318_Sub1_Sub3_Sub3.timedVarDomain = new TimedVarDomain();
            TextureOp.updateFeatureMask(-1);
            RuntimeException_Sub1.method4011(i + 29684, Option.PARTICLES);
            Class348_Sub29.method3004(aa_Sub3.MODELS, false, TextureOpVerticalGradient.js5TextureSource);
            Class296 codec = new Class296(Class16.HUFFMAN.file("huffman", "", -29832));
            NativeToolkit.setHuffman(codec, (byte) 13);
            try {
                jagmisc.init();
            } catch (Throwable throwable) {
                /* empty */
            }
            Class348_Sub8.tickScheduler = Class229.method1631(false);
            TextureOpNoise.aClass348_Sub4_9264 = new SystemInfo(true, Class348_Sub23_Sub1.aClass297_8992);
        }
        if (Class348_Sub42_Sub15.state == LoadState.SETUP_STATIC_SPRITES) {
            int i_11_ = (Class348_Sub22.method2958(22388, Class21.SPRITES) + Class348_Sub49_Sub2.method3405(2012104999, true));
            int i_12_ = (Class288_Sub1.method2188(-30477) - -Class348_Sub42_Sub16.method3256(2));
            if (i_11_ < i_12_) return i_11_ * 100 / i_12_;
        }
        if (LoadState.SETUP_WORLD_MAP == Class348_Sub42_Sub15.state)
            Class75.method752(Class348_Sub32.WORLD_MAP, Class229.floorOverlayTypeList, Class362.floorUnderlayTypeList, TextureOpColourGradient.objectTypeList, Class348_Sub23_Sub2.mapElementTypeList, Class2.msiTypeList, Class318_Sub1_Sub3_Sub3.timedVarDomain);
        if (LoadState.SETUP_VARC_SYSTEM == Class348_Sub42_Sub15.state) {
            // TODO make cache edit to extend these or change id's
            Class77.anIntArray1303 = (new int[Option_Sub14.varcTypeList.anInt3305 + 1000]);
            Class286_Sub6.aBooleanArray6270 = (new boolean[Option_Sub14.varcTypeList.anInt3305 + 1000]);
            Class258_Sub2.aStringArray8532 = new String[Class91.varcStrTypeList.anInt1439];
            for (int i_13_ = 0; Option_Sub14.varcTypeList.anInt3305 + 1000 > i_13_; i_13_++) {
                if (Option_Sub14.varcTypeList.method1976(i_13_, i ^ ~0x6fc0).anInt2135 == 0) {
                    Class286_Sub6.aBooleanArray6270[i_13_] = true;
                    Class335.anInt4168++;
                }
                Class77.anIntArray1303[i_13_] = -1;
            }
            Class116.method1063(1);
            Class285.anInt4737 = Class348_Sub35.INTERFACES.groupId("loginscreen", i ^ ~0x6ff3);
            Class54.anInt970 = Class348_Sub35.INTERFACES.groupId("lobbyscreen", 0);
            Class367_Sub10.MAPS.clear(0, true, false);
            Class59_Sub2_Sub1.MUSIC.clear(0, true, true);
            Class21.SPRITES.clear(i + 28660, true, true);
            Class104.FONT_INDEX.clear(0, true, true);
            Class16.HUFFMAN.clear(0, true, true);
            Class348_Sub35.INTERFACES.clear(0, true, true);
            Class95.CONFIGS.discardUnpacked = 2;
            GfxTypeList.aBoolean3988 = true;
            Class247.ENUMS.discardUnpacked = 2;
            Class94.OBJECTS.discardUnpacked = 2;
            Class216.NPCS.discardUnpacked = 2;
            Class174.ITEMS.discardUnpacked = 2;
            r_Sub2.ANIMATIONS.discardUnpacked = 2;
            Class78.GRAPHICS.discardUnpacked = 2;
        }
        if (Class348_Sub42_Sub15.state == LoadState.LOAD_LOGIN_WINDOW) {
            if (!Class320.method2547(Class285.anInt4737, (byte) 84)) return 0;
            boolean bool = true;
            for (int i_14_ = 0; i_14_ < (TextureOpKaleidoscope.aClass46ArrayArray9427[Class285.anInt4737]).length; i_14_++) {
                Class46 class46 = (TextureOpKaleidoscope.aClass46ArrayArray9427[Class285.anInt4737][i_14_]);
                if (class46.anInt774 == 5 && class46.anInt756 != -1 && !Class21.SPRITES.requestDownload(-10499, (class46.anInt756), 0)) bool = false;
            }
            if (!bool) return 0;
        }
        if (LoadState.SHOW_LOGIN_WINDOW == Class348_Sub42_Sub15.state) Class348_Sub42_Sub8.method3198(true, (byte) -45);
        if (Class348_Sub42_Sub15.state == LoadState.CLEANUP) {
            Class51.renderer.method2319((byte) -56);
            try {
                Class348_Sub32.rendererThread.join();
            } catch (InterruptedException interruptedexception) {
                return 0;
            }
            Class186_Sub1.loadingScreenManager = null;
            TextureOpTiledSprite.LOADING_SCREENS = null;
            Class51.renderer = null;
            Class182.loadingScreens = null;
            Class348_Sub32.rendererThread = null;
            Class286_Sub7.LOADING_SPRITES = null;
            NativeToolkit.method3886(i + 28556);
            Class348_Sub23_Sub2.aBoolean9038 = Class316.clientOptions.safeMode.getValue(-32350) == 1;
            Class316.clientOptions.update((byte) 74, (Class316.clientOptions.safeMode), 1);
            if (Class348_Sub23_Sub2.aBoolean9038) Class316.clientOptions.update((byte) 74, (Class316.clientOptions.aClass239_Sub25_7251), 0);
            else if (Class316.clientOptions.aClass239_Sub25_7251.aBoolean6113 && TextureOpNoise.aClass348_Sub4_9264.totalMemory < 512 && TextureOpNoise.aClass348_Sub4_9264.totalMemory != 0)
                Class316.clientOptions.update((byte) 74, (Class316.clientOptions.aClass239_Sub25_7251), 0);
            Class14_Sub2.saveOptions(i ^ ~0x6fd6);
            if (Class348_Sub23_Sub2.aBoolean9038) Class367_Sub10.method3553(false, (byte) 108, 0);
            else Class367_Sub10.method3553(false, (byte) 102, Class316.clientOptions.aClass239_Sub25_7251.method1829(-32350));
            Class85.method830(Class316.clientOptions.aClass239_Sub8_7227.method1751(-32350), -1, (byte) 102, false, -1);
            TimedVarDomain.method1311(5139, Class348_Sub8.active);
            Class369.method3568(Class348_Sub8.active, i ^ ~0x6ff7);
            ItemTypeList.method1933(Class21.SPRITES, Class348_Sub8.active, true);
            Matrix.method901(Class113.aSpriteArray1744, 515880227);
        }
        return TextureOpPolarDistortion.method3063(false);
    }

    static final String method1279(boolean bool, int i, String[] strings, int i_15_) {
        try {
            anInt2172++;
            if (i == 0) return "";
            if (i == 1) {
                String string = strings[i_15_];
                if (string == null) return "null";
                return string;
            }
            int i_16_ = i + i_15_;
            int i_17_ = 0;
            for (int i_18_ = i_15_; i_16_ > i_18_; i_18_++) {
                String string = strings[i_18_];
                if (string == null) i_17_ += 4;
                else i_17_ += string.length();
            }
            StringBuffer stringbuffer = new StringBuffer(i_17_);
            for (int i_19_ = i_15_; i_19_ < i_16_; i_19_++) {
                String string = strings[i_19_];
                if (string == null) stringbuffer.append("null");
                else stringbuffer.append(string);
            }
            if (bool != true) method1277((byte) -20);
            return stringbuffer.toString();
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("pea.C(" + bool + ',' + i + ',' + (strings != null ? "{...}" : "null") + ',' + i_15_ + ')'));
        }
    }
}
