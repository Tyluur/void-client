package jagtheora.misc;


public abstract class SimplePeer {

	private long peer;

	static {
		init();
	}

	protected static native void init();

	protected abstract void clear();

	public final void a() {
		if (!this.b()) {
			this.clear();
		}
	}

	@Override
	public final void finalize() throws Throwable {
		if (!this.b()) {
			this.a();
		}
		super.finalize();
	}

	public final boolean b() {
		return this.peer == 0L;
	}

	private void setPeer(long arg0) {
		this.peer = arg0;
	}
}
