package c.i.b.y.n;

import c.i.b.y.d;
import java.lang.reflect.AccessibleObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f2694a;

    static {
        f2694a = d.getMajorJavaVersion() < 9 ? new a() : new c();
    }

    public static b getInstance() {
        return f2694a;
    }

    public abstract void makeAccessible(AccessibleObject accessibleObject);
}
