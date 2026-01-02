/* Class328 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import jaggl.OpenGL;

class Class328 {
    static int anInt4099;
    static int anInt4100;
    static int anInt4101;

    static final Class39 method2608(OpenGLxToolkit openGLxToolkit, byte[] is, int i, int i_0_) {
        try {
            anInt4099++;
            if (is == null || is.length == 0) return null;
            long l = OpenGL.glCreateShaderObjectARB(i_0_);
            OpenGL.glShaderSourceRawARB(l, is);
            OpenGL.glCompileShaderARB(l);
            if (i > -95) method2608(null, null, -27, 75);
            OpenGL.glGetObjectParameterivARB(l, 35713, (TextureOpHerringbone.anIntArray9096), 0);
            if (TextureOpHerringbone.anIntArray9096[0] == 0) {
                if (TextureOpHerringbone.anIntArray9096[0] == 0) System.out.println("Shader compile failed:");
                OpenGL.glGetObjectParameterivARB(l, 35716, (TextureOpHerringbone.anIntArray9096), 1);
                if (TextureOpHerringbone.anIntArray9096[1] > 1) {
                    byte[] is_1_ = new byte[TextureOpHerringbone.anIntArray9096[1]];
                    OpenGL.glGetInfoLogARB(l, (TextureOpHerringbone.anIntArray9096[1]), TextureOpHerringbone.anIntArray9096, 0, is_1_, 0);
                    System.out.println(new String(is_1_));
                }
                if (TextureOpHerringbone.anIntArray9096[0] == 0) {
                    OpenGL.glDeleteObjectARB(l);
                    return null;
                }
            }
            return new Class39(openGLxToolkit, l, i_0_);
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("dea.E(" + (openGLxToolkit != null ? "{...}" : "null") + ',' + (is != null ? "{...}" : "null") + ',' + i + ',' + i_0_ + ')'));
        }
    }

    static final ClientScript method2609(int i, int i_2_) {
        anInt4101++;
        ClientScript clientScript = ((ClientScript) ColourImageCache.aLRUHashTable_4036.method2302(i_2_, (byte) -68));
        if (clientScript != null) return clientScript;
        byte[] is = Class113.CLIENT_SCRIPTS.method410(-1860, i_2_, 0);
        if (is == null || is.length <= 1) return null;
        try {
            clientScript = Class318_Sub4.method2502(is, -104);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage() + " S: " + i_2_);
        }
        if (i > -103) return null;
        ColourImageCache.aLRUHashTable_4036.put(i_2_, clientScript, -1);
        return clientScript;
    }
}
