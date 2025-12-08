package jaclib.peer;


import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public final class hb {

	private PeerReference b;

	private PeerReference c;

	public final ReferenceQueue a = new ReferenceQueue();

	public void a(byte arg0) {
		this.a((int) 21492);
		while (this.b != null) {
			this.a(19236, this.b);
		}
		this.a((int) 21492);
	}

	public void a(PeerReference arg0, int arg1) {
		arg0.a = this.b;
		arg0.b = null;
		if (this.c == null) {
			this.c = arg0;
		} else {
			this.b.b = arg0;
		}
		this.b = arg0;
	}

	private void a(int arg0) {
		while (true) {
			Reference local3 = this.a.poll();
			if (local3 == null) {
				return;
			}
			PeerReference local9 = (PeerReference) local3;
			this.a(19236, local9);
		}
	}

	public void b(byte arg0) {
		this.a(arg0 + 21574);
	}

	private void a(int arg0, PeerReference arg1) {
		arg1.a(false);
		if (arg1 == this.b) {
			this.b = arg1.a;
		}
		if (this.c == arg1) {
			this.c = arg1.b;
		}
		if (arg1.b != null) {
			arg1.b.a = arg1.a;
		}
		if (arg1.a != null) {
			arg1.a.b = arg1.b;
		}
	}
}
