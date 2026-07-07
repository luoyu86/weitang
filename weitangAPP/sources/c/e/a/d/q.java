package c.e.a.d;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f1224a = c.e.a.a.a.getInstance().isDebug();

    public static boolean a(String str) {
        return c.e.a.a.a.getInstance().isDebug() && str != null;
    }

    public static void d(String str) {
        if (a(str)) {
            c.o.a.f.d(str);
        }
    }

    public static void e(String str) {
        if (a(str)) {
            c.o.a.f.e(str, new Object[0]);
        }
    }

    public static void i(String str) {
        if (a(str)) {
            c.o.a.f.i(str, new Object[0]);
        }
    }

    public static void v(String str) {
        if (a(str)) {
            c.o.a.f.v(str, new Object[0]);
        }
    }

    public static void d(String str, String str2) {
        if (a(str2)) {
            c.o.a.f.d(str + ":" + str2);
        }
    }

    public static void e(String str, String str2) {
        if (a(str2)) {
            c.o.a.f.e(str + ":" + str2, new Object[0]);
        }
    }

    public static void i(String str, String str2) {
        if (c.e.a.a.a.getInstance().isDebug()) {
            c.o.a.f.i(str + ":" + str2, new Object[0]);
        }
    }

    public static void v(String str, String str2) {
        if (a(str2)) {
            c.o.a.f.v(str + ":" + str2, new Object[0]);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (a(str2 + ":" + th)) {
            c.o.a.f.e(str + ":" + str2 + ":" + th, new Object[0]);
        }
    }
}
