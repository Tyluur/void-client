package jaclib.peer;


public final class IUnknownReference extends PeerReference {

	public IUnknownReference(IUnknown arg0, hb arg1) {
		super(arg0, arg1);
	}

	protected native long releasePeer(long arg0);
}
