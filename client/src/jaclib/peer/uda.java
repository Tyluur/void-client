package jaclib.peer;


public class uda extends Peer {

	public uda(hb arg0) {
		this.reference = new NativeHeapPeerReference(this, arg0);
	}
}
