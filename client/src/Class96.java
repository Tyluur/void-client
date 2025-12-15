/* Class96 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.*;
import java.lang.reflect.Method;

final class Class96 {
    static final Toolkit method870(int i, int i_0_, TextureSource var_d, Index index, Canvas canvas) {
        if (i_0_ != 18993) return null;
        Toolkit var_toolkit;
        try {
            if (!Class9.method215(27165)) throw new RuntimeException("");
            if (!TextureOpHorizontalGradient.method3098(-30282, "jagdx")) throw new RuntimeException("");
            Method method = (DirectXToolkit.class.getDeclaredMethod("createToolkit", Canvas.class, TextureSource.class, Index.class, Integer.class));
            var_toolkit = (Toolkit) method.invoke(null, new Object[]{canvas, var_d, index, new Integer(i)});
        } catch (Throwable throwable) {
            throw new RuntimeException("");
        }
        return var_toolkit;
    }
}
