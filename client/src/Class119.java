/* Class119 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import jaclib.memory.Buffer;

class Class119 {
    Buffer aBuffer1792;
    private final OpenGLToolkit aOpenGLToolkit_1793;

    final void method1076(byte[] is, int i) {
        if (this.aBuffer1792 == null || this.aBuffer1792.getSize() < i) this.aBuffer1792 = aOpenGLToolkit_1793.aNativeHeap7730.a(i, false);
        this.aBuffer1792.a(is, 0, 0, i);
    }

    Class119(OpenGLToolkit var_openGLToolkit, byte[] is, int i) {
        aOpenGLToolkit_1793 = var_openGLToolkit;
        this.aBuffer1792 = aOpenGLToolkit_1793.aNativeHeap7730.a(i, false);
        if (is != null) this.aBuffer1792.a(is, 0, 0, i);
    }

    Class119(OpenGLToolkit var_openGLToolkit, Buffer buffer) {
        aOpenGLToolkit_1793 = var_openGLToolkit;
        this.aBuffer1792 = buffer;
    }
}
