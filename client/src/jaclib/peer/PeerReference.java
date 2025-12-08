package jaclib.peer;


import java.lang.ref.WeakReference;

public abstract class PeerReference extends WeakReference {

	public PeerReference a;

	private long peer;

	public PeerReference b;

	protected PeerReference(Peer arg0, hb arg1) {
		super(arg0, arg1.a);
		arg1.a(this, -22143);
	}

	protected abstract long releasePeer(long arg0);

	public final boolean a(byte arg0) {
		return this.peer != 0L;
	}

	private void setPeer(long arg0) {
		this.a(false);
		this.peer = arg0;
	}

	public final long a(boolean arg0) {
		long local11;
		if (this.peer == 0L) {
			local11 = 0L;
		} else {
			local11 = this.releasePeer(this.peer);
			this.peer = 0L;
		}
		return local11;
	}
}
