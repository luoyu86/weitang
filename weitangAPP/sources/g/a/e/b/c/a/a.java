package g.a.e.b.c.a;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: g.a.e.b.c.a.a$a, reason: collision with other inner class name */
    public static class C0256a implements PrivilegedAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13838a;

        public C0256a(String str) {
            this.f13838a = str;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            try {
                return Class.forName(this.f13838a);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static Class loadClass(Class cls, String str) {
        try {
            ClassLoader classLoader = cls.getClassLoader();
            return classLoader != null ? classLoader.loadClass(str) : (Class) AccessController.doPrivileged(new C0256a(str));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
