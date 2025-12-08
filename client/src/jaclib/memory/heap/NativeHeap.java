package jaclib.memory.heap;


public final class NativeHeap {

	private long peer;

	private final int b;

	private boolean a;

	public NativeHeap(int arg0) {
		this.b = arg0;
		this.allocateHeap(this.b);
		this.a = true;
	}

	private native void allocateHeap(int arg0);

	public synchronized boolean a() {
		return this.a;
	}

	public NativeHeapBuffer a(int arg0, boolean arg1) {
		if (!this.a) {
			throw new IllegalStateException();
		}
		return new NativeHeapBuffer(this, this.allocateBuffer(arg0, arg1), arg0);
	}

	@Override
	public synchronized void finalize() throws Throwable {
		super.finalize();
		this.b();
	}

	public synchronized void b() {
		if (this.a) {
			this.deallocateHeap();
		}
		this.a = false;
	}

	private synchronized native int allocateBuffer(int arg0, boolean arg1);

	private synchronized native void get(int arg0, byte[] arg1, int arg2, int arg3, int arg4);

	public synchronized native void put(int arg0, byte[] arg1, int arg2, int arg3, int arg4);

	private native void deallocateHeap();

	public synchronized native long getBufferAddress(int arg0);

	public synchronized native void deallocateBuffer(int arg0);
}
