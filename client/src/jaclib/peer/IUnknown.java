package jaclib.peer;


public class IUnknown extends Peer {

	public IUnknown(hb arg0) {
		this.reference = new IUnknownReference(this, arg0);
	}

	private native long AddRef();

	public final long a(int arg0) {
		return super.a();
	}
}
