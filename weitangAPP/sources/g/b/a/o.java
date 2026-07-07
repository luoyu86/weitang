package g.b.a;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f14725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f14726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class<?> f14727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f14729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f14730f;

    public o(Method method, Class<?> cls, r rVar, int i2, boolean z) {
        this.f14725a = method;
        this.f14726b = rVar;
        this.f14727c = cls;
        this.f14728d = i2;
        this.f14729e = z;
    }

    public final synchronized void a() {
        if (this.f14730f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f14725a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f14725a.getName());
            sb.append('(');
            sb.append(this.f14727c.getName());
            this.f14730f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        a();
        o oVar = (o) obj;
        oVar.a();
        return this.f14730f.equals(oVar.f14730f);
    }

    public int hashCode() {
        return this.f14725a.hashCode();
    }
}
