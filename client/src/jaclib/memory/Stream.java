package jaclib.memory;


public final class Stream {

	private int a;

	private Buffer b;

	private int c;

	private int d;

	private final byte[] e;

	public static native int floatToRawIntBits(float arg0);

	private static native byte getLSB(int arg0);

	public static boolean c() {
		return getLSB(-65536) == -1;
	}

	public Stream() {
		this(4096);
	}

	public Stream(Buffer arg0) {
		this(arg0, 0, arg0.getSize());
	}

	public Stream(Buffer arg0, int arg1, int arg2) {
		this(arg0.getSize() >= 4096 ? 4096 : arg0.getSize());
		this.a(arg0, arg1, arg2);
	}

	private Stream(int arg0) {
		this.e = new byte[arg0];
	}

	public void a(int arg0) {
		if (this.c + 1 >= this.e.length) {
			this.a();
		}
		this.e[this.c++] = (byte) arg0;
		this.e[this.c++] = (byte) (arg0 >> 8);
	}

	public void a(float arg0) {
		if (this.e.length <= this.c + 3) {
			this.a();
		}
		int local12 = floatToRawIntBits(arg0);
		this.e[this.c++] = (byte) (local12 >> 24);
		this.e[this.c++] = (byte) (local12 >> 16);
		this.e[this.c++] = (byte) (local12 >> 8);
		this.e[this.c++] = (byte) local12;
	}

	public void a(int arg0, int arg1, int arg2, int arg3) {
		if (this.c + 3 >= this.e.length) {
			this.a();
		}
		this.e[this.c++] = (byte) arg0;
		this.e[this.c++] = (byte) arg1;
		this.e[this.c++] = (byte) arg2;
		this.e[this.c++] = (byte) arg3;
	}

	public void a(Buffer arg0) {
		this.a(arg0, 0, arg0.getSize());
	}

	public void b(int arg0) {
		if (this.c + 3 >= this.e.length) {
			this.a();
		}
		this.e[this.c++] = (byte) arg0;
		this.e[this.c++] = (byte) (arg0 >> 8);
		this.e[this.c++] = (byte) (arg0 >> 16);
		this.e[this.c++] = (byte) (arg0 >> 24);
	}

	public void a() {
		if (this.c <= 0) {
			return;
		}
		if (this.a < this.c + this.d) {
			throw new RuntimeException();
		}
		this.b.a(this.e, 0, this.d, this.c);
		this.d += this.c;
		this.c = 0;
	}

	private void a(Buffer arg0, int arg1, int arg2) {
		this.a();
		this.a = arg1 + arg2;
		this.d = arg1;
		this.b = arg0;
		if (this.a > arg0.getSize()) {
			throw new RuntimeException();
		}
	}

	public void b(int arg0, int arg1, int arg2, int arg3) {
		if (this.e.length <= this.c + 3) {
			this.a();
		}
		this.e[this.c++] = (byte) arg2;
		this.e[this.c++] = (byte) arg1;
		this.e[this.c++] = (byte) arg0;
		this.e[this.c++] = (byte) arg3;
	}

	public void c(int arg0) {
		if (this.e.length <= this.c + 3) {
			this.a();
		}
		this.e[this.c++] = (byte) (arg0 >> 16);
		this.e[this.c++] = (byte) (arg0 >> 8);
		this.e[this.c++] = (byte) arg0;
		this.e[this.c++] = (byte) (arg0 >> 24);
	}

	public int b() {
		return this.d + this.c;
	}

	public void d(int arg0) {
		if (this.e.length <= this.c + 1) {
			this.a();
		}
		this.e[this.c++] = (byte) (arg0 >> 8);
		this.e[this.c++] = (byte) arg0;
	}

	public void e(int arg0) {
		this.a();
		this.d = arg0;
	}

	public void b(float arg0) {
		if (this.e.length <= this.c + 3) {
			this.a();
		}
		int local12 = floatToRawIntBits(arg0);
		this.e[this.c++] = (byte) local12;
		this.e[this.c++] = (byte) (local12 >> 8);
		this.e[this.c++] = (byte) (local12 >> 16);
		this.e[this.c++] = (byte) (local12 >> 24);
	}

	public void f(int arg0) {
		if (this.c >= this.e.length) {
			this.a();
		}
		this.e[this.c++] = (byte) arg0;
	}
}
