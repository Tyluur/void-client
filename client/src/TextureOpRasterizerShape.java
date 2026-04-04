/* Class50 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import jaggl.OpenGL;

// Class50
abstract class TextureOpRasterizerShape {
    static int anInt861;
    int outlineWidth;
    static String aString863 = null;
    int outlineColour;
    int fillColour;

    abstract void renderOutline(int i, int i_0_, int i_1_);

    abstract void renderFill(int i, int i_2_, int i_3_);

    abstract void render(int i, int i_4_, int i_5_);

    public static void method458(int i) {
        if (i != -14487) method459(-97, null, null, true);
        aString863 = null;
    }

    static final Class171 method459(int i, OpenGLToolkit var_openGLToolkit, String string, boolean bool) {
        try {
            anInt861++;
            int i_6_ = OpenGL.glGenProgramARB();
            OpenGL.glBindProgramARB(i, i_6_);
            if (bool != false) return null;
            OpenGL.glProgramStringARB(i, 34933, string);
            OpenGL.glGetIntegerv(34379, Class348_Sub31_Sub2.anIntArray9069, 0);
            if (Class348_Sub31_Sub2.anIntArray9069[0] != -1) {
                OpenGL.glBindProgramARB(i, 0);
                return null;
            }
            OpenGL.glBindProgramARB(i, 0);
            return new Class171(var_openGLToolkit, i, i_6_);
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("iu.I(" + i + ',' + (var_openGLToolkit != null ? "{...}" : "null") + ',' + (string != null ? "{...}" : "null") + ',' + bool + ')'));
        }
    }

    TextureOpRasterizerShape(int i, int i_7_, int i_8_) {
        this.outlineWidth = i_8_;
        this.outlineColour = i;
        this.fillColour = i_7_;
    }
}
