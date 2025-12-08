package jaclib.memory;


public class NativeBuffer implements Buffer, Source {

	private long a;

	private int b = -1;

	@Override
	public final long getAddress() {
		return this.a;
	}

	@Override
	public void a(byte[] arg0, int arg1, int arg2, int arg3) {
		if (arg2 + arg3 > this.b | arg2 < 0 | arg0.length < arg3 + arg1 | arg1 < 0 | arg0 == null | this.a == 0L) {
			throw new RuntimeException();
		}
		this.put(this.a, arg0, arg1, arg2, arg3);
	}

	@Override
	public final int getSize() {
		return this.b;
	}

	protected final void a(long arg0, int arg1) {
		this.b = arg1;
		this.a = arg0;
	}

	private native void get(long arg0, byte[] arg1, int arg2, int arg3, int arg4);

	private native void put(long arg0, byte[] arg1, int arg2, int arg3, int arg4);
}
