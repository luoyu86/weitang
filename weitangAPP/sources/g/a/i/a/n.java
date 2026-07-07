package g.a.i.a;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.q;
import g.a.a.t;
import g.a.a.w;
import g.a.a.x1;

/* JADX INFO: loaded from: classes3.dex */
public class n extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f14287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14288b;

    public n(d0 d0Var) {
        if (!q.getInstance(d0Var.getObjectAt(0)).hasValue(0)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f14287a = g.a.j.a.clone(w.getInstance(d0Var.getObjectAt(1)).getOctets());
        this.f14288b = g.a.j.a.clone(w.getInstance(d0Var.getObjectAt(2)).getOctets());
    }

    public n(byte[] bArr, byte[] bArr2) {
        this.f14287a = g.a.j.a.clone(bArr);
        this.f14288b = g.a.j.a.clone(bArr2);
    }

    public static n getInstance(Object obj) {
        if (obj instanceof n) {
            return (n) obj;
        }
        if (obj != null) {
            return new n(d0.getInstance(obj));
        }
        return null;
    }

    public byte[] getPublicSeed() {
        return g.a.j.a.clone(this.f14287a);
    }

    public byte[] getRoot() {
        return g.a.j.a.clone(this.f14288b);
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h();
        hVar.add(new q(0L));
        hVar.add(new x1(this.f14287a));
        hVar.add(new x1(this.f14288b));
        return new b2(hVar);
    }
}
