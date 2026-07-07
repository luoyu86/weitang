package g.a.i.a;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.q;
import g.a.a.t;
import g.a.a.w;
import g.a.a.x1;

/* JADX INFO: loaded from: classes3.dex */
public class l extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f14277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14278b;

    public l(d0 d0Var) {
        if (!q.getInstance(d0Var.getObjectAt(0)).hasValue(0)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f14277a = g.a.j.a.clone(w.getInstance(d0Var.getObjectAt(1)).getOctets());
        this.f14278b = g.a.j.a.clone(w.getInstance(d0Var.getObjectAt(2)).getOctets());
    }

    public l(byte[] bArr, byte[] bArr2) {
        this.f14277a = g.a.j.a.clone(bArr);
        this.f14278b = g.a.j.a.clone(bArr2);
    }

    public static l getInstance(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj != null) {
            return new l(d0.getInstance(obj));
        }
        return null;
    }

    public byte[] getPublicSeed() {
        return g.a.j.a.clone(this.f14277a);
    }

    public byte[] getRoot() {
        return g.a.j.a.clone(this.f14278b);
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h();
        hVar.add(new q(0L));
        hVar.add(new x1(this.f14277a));
        hVar.add(new x1(this.f14278b));
        return new b2(hVar);
    }
}
