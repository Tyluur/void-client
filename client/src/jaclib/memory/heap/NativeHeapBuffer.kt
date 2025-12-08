package jaclib.memory.heap;

import jaclib.memory.Buffer;
import jaclib.memory.Source;

public final class NativeHeapBuffer implements Buffer, Source {

	private boolean c = true;

	public final int b;

	private final NativeHeap a;

	private final int d;

	public NativeHeapBuffer(NativeHeap arg0, int arg1, int arg2) {
		this.b = arg2;
		this.a = arg0;
		this.d = arg1;
	}

	@Override
	public long getAddress() {
		return this.a.getBufferAddress(this.d);
	}

	private synchronized boolean a() {
		return this.a.a() && this.c;
	}

	private synchronized void b() {
		if (this.a()) {
			this.a.deallocateBuffer(this.d);
		}
		this.c = false;
	}

	@Override
	public synchronized void a(byte[] arg0, int arg1, int arg2, int arg3) {
		if (arg1 < 0 | arg0 == null | !this.a() | arg3 + arg1 > arg0.length | arg2 < 0 | this.b < arg2 + arg3) {
			throw new RuntimeException();
		}
		this.a.put(this.d, arg0, arg1, arg2, arg3);
	}

	@Override
	public synchronized void finalize() throws Throwable {
		super.finalize();
		this.b();
	}

	@Override
	public int getSize() {
		return this.b;
	}
}
