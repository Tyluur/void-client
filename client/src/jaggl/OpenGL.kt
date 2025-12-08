package jaggl;


import java.awt.*;
import java.util.Hashtable;

public final class OpenGL {

	private static final Hashtable b = new Hashtable();

	private Thread a;

	private Hashtable c;

	private long peer;

	public static native void glTranslatef(float arg0, float arg1, float arg2);

	public static native void glBindRenderbufferEXT(int arg0, int arg1);

	public static native void glScalef(float arg0, float arg1, float arg2);

	public static native void glActiveTexture(int arg0);

	public static native void glProgramLocalParameter4fvARB(int arg0, int arg1, float[] arg2, int arg3);

	public static native void glGetObjectParameterivARB(long arg0, int arg1, int[] arg2, int arg3);

	public static native void glFramebufferTexture3DEXT(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5);

	public static native void glDeleteLists(int arg0, int arg1);

	public static native void glUniform1iARB(int arg0, int arg1);

	public static native void glFinish();

	public static native void glDrawElements(int arg0, int arg1, int arg2, long arg3);

	public static native void glReadBuffer(int arg0);

	private static native int glGetError();

	public static native void glUseProgramObjectARB(long arg0);

	private static native void glColor4f(float arg0, float arg1, float arg2, float arg3);

	public static native void glTexGeni(int arg0, int arg1, int arg2);

	public static native void glDeleteFramebuffersEXT(int arg0, int[] arg1, int arg2);

	public static native void glColorMask(boolean arg0, boolean arg1, boolean arg2, boolean arg3);

	public static native void glCullFace(int arg0);

	public static native void glLoadMatrixf(float[] arg0, int arg1);

	public static native void glRasterPos2i(int arg0, int arg1);

	public static native void glBufferDataARBa(int arg0, int arg1, long arg2, int arg3);

	private static native void glStencilFunc(int arg0, int arg1, int arg2);

	public static native void glClearColor(float arg0, float arg1, float arg2, float arg3);

	public static native void glRenderbufferStorageEXT(int arg0, int arg1, int arg2, int arg3);

	public static native void glDeleteBuffersARB(int arg0, int[] arg1, int arg2);

	public static native void glCopyTexSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8);

	public static native void glTexImage2Df(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, float[] arg8, int arg9);

	public static native void glReadPixelsi(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int[] arg6, int arg7);

	public static native void glTexCoordPointer(int arg0, int arg1, int arg2, long arg3);

	public static native void glBindTexture(int arg0, int arg1);

	public static native void glLinkProgramARB(long arg0);

	public static native void glOrtho(double arg0, double arg1, double arg2, double arg3, double arg4, double arg5);

	private static native void glUniformMatrix3fvARB(int arg0, int arg1, boolean arg2, float[] arg3, int arg4);

	private static native void glUniformMatrix2fvARB(int arg0, int arg1, boolean arg2, float[] arg3, int arg4);

	public static native void glBufferSubDataARBa(int arg0, int arg1, int arg2, long arg3);

	public static native void glDeleteRenderbuffersEXT(int arg0, int[] arg1, int arg2);

	public static native void glPixelStorei(int arg0, int arg1);

	public static native void glScissor(int arg0, int arg1, int arg2, int arg3);

	private static native void glTexCoord2i(int arg0, int arg1);

	public static native void glLineWidth(float arg0);

	public static native void glGenerateMipmapEXT(int arg0);

	public static native void glDeleteObjectARB(long arg0);

	private static native void glMultiTexCoord2i(int arg0, int arg1, int arg2);

	public static native void glRotatef(float arg0, float arg1, float arg2, float arg3);

	public static native void glMultiTexCoord2f(int arg0, float arg1, float arg2);

	public static native void glFramebufferRenderbufferEXT(int arg0, int arg1, int arg2, int arg3);

	public static native void glTexSubImage2Di(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int[] arg8, int arg9);

	public static native void glLightf(int arg0, int arg1, float arg2);

	public static native void glTexGenfv(int arg0, int arg1, float[] arg2, int arg3);

	public static native void glTexCoord3i(int arg0, int arg1, int arg2);

	public static native void glDrawArrays(int arg0, int arg1, int arg2);

	public static native void glCallList(int arg0);

	public static native void glDeleteProgramARB(int arg0);

	public static native void glBindFramebufferEXT(int arg0, int arg1);

	public static native void glTexCoord3f(float arg0, float arg1, float arg2);

	public static native void glGenBuffersARB(int arg0, int[] arg1, int arg2);

	public static native void glVertexPointer(int arg0, int arg1, int arg2, long arg3);

	public static native void glGetInfoLogARB(long arg0, int arg1, int[] arg2, int arg3, byte[] arg4, int arg5);

	private static native void glReadPixelsub(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, byte[] arg6, int arg7);

	public static native void glDepthMask(boolean arg0);

	public static native void glEnd();

	public static native void glEndList();

	public static native void glTexImage3Dub(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, byte[] arg9, int arg10);

	public static native void glTexImage1Dub(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, byte[] arg7, int arg8);

	public static native void glBlendFunc(int arg0, int arg1);

	private static native void glStencilOp(int arg0, int arg1, int arg2);

	public static native void glClearDepth(float arg0);

	public static native int glGetUniformLocationARB(long arg0, String arg1);

	public static native void glNewList(int arg0, int arg1);

	public static native void glViewport(int arg0, int arg1, int arg2, int arg3);

	public static native void glTexEnvfv(int arg0, int arg1, float[] arg2, int arg3);

	public static native void glPolygonMode(int arg0, int arg1);

	public static native void glTexParameteri(int arg0, int arg1, int arg2);

	public static native void glPushMatrix();

	public static native void glPixelTransferf(int arg0, float arg1);

	public static native void glUniform1fARB(int arg0, float arg1);

	public static native void glBlitFramebufferEXT(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9);

	public static native void glCopyTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7);

	public static native void glCompileShaderARB(long arg0);

	private static native void glMaterialfv(int arg0, int arg1, float[] arg2, int arg3);

	public static native void glDetachObjectARB(long arg0, long arg1);

	public static native void glNormalPointer(int arg0, int arg1, long arg2);

	public static native void glUniform2fARB(int arg0, float arg1, float arg2);

	public static native void glLightfv(int arg0, int arg1, float[] arg2, int arg3);

	public static native void glFogfv(int arg0, float[] arg1, int arg2);

	public static native void glGetFloatv(int arg0, float[] arg1, int arg2);

	public static native void glHint(int arg0, int arg1);

	public static native void glBufferDataARBub(int arg0, int arg1, byte[] arg2, int arg3, int arg4);

	public static native void glTexSubImage2Df(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, float[] arg8, int arg9);

	public static native void glClientActiveTexture(int arg0);

	public static native void glLightModelfv(int arg0, float[] arg1, int arg2);

	private static native void glTexParameterf(int arg0, int arg1, float arg2);

	public static native void glMatrixMode(int arg0);

	public static native void glCopyTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7);

	public static native void glTexImage2Di(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int[] arg8, int arg9);

	public static native boolean glUnmapBufferARB(int arg0);

	public static native void glColor4ub(byte arg0, byte arg1, byte arg2, byte arg3);

	public static native void glBufferSubDataARBub(int arg0, int arg1, int arg2, byte[] arg3, int arg4);

	public static native void glMultMatrixf(float[] arg0, int arg1);

	public static native void glFogi(int arg0, int arg1);

	public static native void glVertex2i(int arg0, int arg1);

	public static native void glDepthFunc(int arg0);

	private static native void glDrawPixelsi(int arg0, int arg1, int arg2, int arg3, int[] arg4, int arg5);

	private static native void glDrawPixelsub(int arg0, int arg1, int arg2, int arg3, byte[] arg4, int arg5);

	public static native void glVertex3f(float arg0, float arg1, float arg2);

	public static native void glUniform4fARB(int arg0, float arg1, float arg2, float arg3, float arg4);

	private static native void glFrustum(double arg0, double arg1, double arg2, double arg3, double arg4, double arg5);

	public static native void glTexEnvi(int arg0, int arg1, int arg2);

	public static native long glCreateProgramObjectARB();

	public static native void glNormal3f(float arg0, float arg1, float arg2);

	private static native void glGetTexImageub(int arg0, int arg1, int arg2, int arg3, byte[] arg4, int arg5);

	public static native void glGenFramebuffersEXT(int arg0, int[] arg1, int arg2);

	private static native void glGetProgramivARB(int arg0, int arg1, int[] arg2, int arg3);

	public static native void glUniform3fARB(int arg0, float arg1, float arg2, float arg3);

	private static native void glDrawBuffersARB(int arg0, int[] arg1, int arg2);

	public static native long glCreateShaderObjectARB(int arg0);

	public static native long glMapBufferARB(int arg0, int arg1);

	private static native void glColor3ub(byte arg0, byte arg1, byte arg2);

	public static native void glGetIntegerv(int arg0, int[] arg1, int arg2);

	public static native void glShadeModel(int arg0);

	public static native void glProgramStringARB(int arg0, int arg1, String arg2);

	public static native int glGenProgramARB();

	public static native void glPushAttrib(int arg0);

	public static native void glFlush();

	public static native void glRenderbufferStorageMultisampleEXT(int arg0, int arg1, int arg2, int arg3, int arg4);

	public static native void glEnable(int arg0);

	public static native void glDisable(int arg0);

	public static native void glGenTextures(int arg0, int[] arg1, int arg2);

	public static native void glFramebufferTexture2DEXT(int arg0, int arg1, int arg2, int arg3, int arg4);

	public static native void glBindBufferARB(int arg0, int arg1);

	public static native void glMultiTexCoord3i(int arg0, int arg1, int arg2, int arg3);

	public static native void glColorMaterial(int arg0, int arg1);

	public static native void glTexSubImage2Dub(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, byte[] arg8, int arg9);

	public static native void glShaderSourceARB(long arg0, String arg1);

	public static native void glGetTexImagei(int arg0, int arg1, int arg2, int arg3, int[] arg4, int arg5);

	public static native String glGetString(int arg0);

	private static native void glPixelZoom(float arg0, float arg1);

	public static native void glDisableClientState(int arg0);

	public static native void glClear(int arg0);

	public static native void glPointSize(float arg0);

	public static native void glCopyPixels(int arg0, int arg1, int arg2, int arg3, int arg4);

	public static native void glTexCoord2f(float arg0, float arg1);

	public static native void glBindProgramARB(int arg0, int arg1);

	public static native void glGenRenderbuffersEXT(int arg0, int[] arg1, int arg2);

	public static native void glPopAttrib();

	public static native void glVertex2f(float arg0, float arg1);

	public static native void glLoadIdentity();

	public static native int glGenLists(int arg0);

	public static native void glColorPointer(int arg0, int arg1, int arg2, long arg3);

	public static native void glPopMatrix();

	public static native void glEnableClientState(int arg0);

	public static native void glShaderSourceRawARB(long arg0, byte[] arg1);

	public static native void glColor3f(float arg0, float arg1, float arg2);

	public static native void glTexEnvf(int arg0, int arg1, float arg2);

	public static native void glProgramLocalParameter4fARB(int arg0, int arg1, float arg2, float arg3, float arg4, float arg5);

	public static native void glAlphaFunc(int arg0, float arg1);

	public static native void glDeleteTextures(int arg0, int[] arg1, int arg2);

	public static native void glDrawBuffer(int arg0);

	public static native void glBegin(int arg0);

	public static native void glFogf(int arg0, float arg1);

	public static native void glAttachObjectARB(long arg0, long arg1);

	public static native int glCheckFramebufferStatusEXT(int arg0);

	public static native void glTexImage2Dub(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, byte[] arg8, int arg9);

	private static native void glUniformMatrix4fvARB(int arg0, int arg1, boolean arg2, float[] arg3, int arg4);

	public static native void glProgramRawARB(int arg0, int arg1, byte[] arg2);

	private native void detachPeer();

	public native void setSwapInterval(int arg0);

	public native void surfaceResized(long arg0);

	private native void setPbuffer(long arg0);

	public native boolean arePbuffersAvailable();

	public synchronized boolean a() {
		if (this.a == Thread.currentThread()) {
			this.detachPeer();
			b.remove(this.a);
			this.a = null;
			return true;
		} else {
			return false;
		}
	}

	private native void releasePbuffer(long arg0);

	private native boolean attachPeer();

	public native void releaseSurface(Canvas arg0, long arg1);

	public native long init(Canvas arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6);

	public synchronized boolean b() {
		Thread local1 = Thread.currentThread();
		if (!this.attachPeer()) {
			return false;
		}
		OpenGL local10 = (OpenGL) b.put(local1, this);
		if (local10 != null) {
			local10.a = null;
		}
		this.a = local1;
		return true;
	}

	private native long createPbuffer(int arg0, int arg1);

	public native void swapBuffers();

	public boolean a(String arg0) {
		if (this.c == null) {
			this.c = new Hashtable();
			String local10 = glGetString(7939);
			int local12 = 0;
			while (true) {
				int local17 = local10.indexOf(32, local12);
				if (local17 == -1) {
					String local48 = local10.substring(local12).trim();
					if (local48.length() != 0) {
						this.c.put(local48, local48);
					}
					break;
				}
				String local26 = local10.substring(local12, local17).trim();
				if (local26.length() != 0) {
					this.c.put(local26, local26);
				}
				local12 = local17 + 1;
			}
		}
		return this.c.containsKey(arg0);
	}

	public native void release();

	public native long prepareSurface(Canvas arg0);

	public native boolean setSurface(long arg0);
}
