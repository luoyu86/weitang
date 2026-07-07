package g.a.a.y3;

import g.a.a.a0;
import g.a.a.l0;
import g.a.a.x1;

/* JADX INFO: loaded from: classes2.dex */
public class k extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f13484a;

    public k(g.a.a.w wVar) {
        this(wVar.getOctets());
    }

    public k(byte[] bArr) {
        this.f13484a = g.a.j.a.clone(bArr);
    }

    public static k fromExtensions(f fVar) {
        return getInstance(f.getExtensionParsedValue(fVar, e.f13463b));
    }

    public static k getInstance(l0 l0Var, boolean z) {
        return getInstance(g.a.a.w.getInstance(l0Var, z));
    }

    public static k getInstance(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(g.a.a.w.getInstance(obj));
        }
        return null;
    }

    public byte[] getKeyIdentifier() {
        return g.a.j.a.clone(this.f13484a);
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return new x1(getKeyIdentifier());
    }
}
