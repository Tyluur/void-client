package jaggl;

import jaclib.memory.NativeBuffer;

public final class MapBuffer extends NativeBuffer {

	private int c;

	@Override
	public void a(byte[] arg0, int arg1, int arg2, int arg3) {
		if (this.c == 0) {
			throw new RuntimeException();
		}
		super.a(arg0, arg1, arg2, arg3);
	}

	public boolean a(int arg0, int arg1, int arg2) {
		if (this.c != 0) {
			return false;
		}
		long local8 = OpenGL.glMapBufferARB(arg0, arg2);
		if (local8 == 0L) {
			return false;
		} else {
			this.a(local8, arg1);
			this.c = arg0;
			return true;
		}
	}

	public boolean a() {
		return this.c != 0;
	}

	public boolean b() {
		boolean local1 = true;
		if (this.c != 0) {
			local1 = OpenGL.glUnmapBufferARB(this.c);
			this.a(0L, 0);
			this.c = 0;
		}
		return local1;
	}
}
