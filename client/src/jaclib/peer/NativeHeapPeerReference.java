package jaclib.peer;


public final class NativeHeapPeerReference extends PeerReference {

	public NativeHeapPeerReference(uda arg0, hb arg1) {
		super(arg0, arg1);
	}

	protected native long releasePeer(long arg0);
}
