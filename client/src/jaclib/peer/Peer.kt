package jaclib.peer;


public abstract class Peer {

	protected PeerReference reference;

	static {
		init(PeerReference.class);
	}

	private static native void init(Class arg0);

	protected Peer() {
	}

	protected final boolean a(boolean arg0) {
		return this.reference.a((byte) -67);
	}

	protected long a() {
		return this.reference.a(false);
	}
}
