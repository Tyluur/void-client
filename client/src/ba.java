/* ba - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class ba extends r implements Interface19 {
    long nativeid;

    ba(SafeModeToolkit var_safeModeToolkit) {
        /* empty */
    }

    protected final void finalize() {
        if (this.nativeid != 0L) Class257.method1947(0, this);
    }

    public final native void w(boolean bool);
}
