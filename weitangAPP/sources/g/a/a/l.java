package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l extends a0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13226a = new a(l.class, 27);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13227b;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return l.g(x1Var.getOctets());
        }
    }

    public l(String str) {
        this.f13227b = g.a.j.q.toByteArray(str);
    }

    public l(byte[] bArr, boolean z) {
        this.f13227b = z ? g.a.j.a.clone(bArr) : bArr;
    }

    public static l g(byte[] bArr) {
        return new r1(bArr, false);
    }

    public static l getInstance(l0 l0Var, boolean z) {
        return (l) f13226a.e(l0Var, z);
    }

    public static l getInstance(Object obj) {
        if (obj == null || (obj instanceof l)) {
            return (l) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof l) {
                return (l) aSN1Primitive;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (l) f13226a.b((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }

    @Override // g.a.a.a0
    public final boolean a(a0 a0Var) {
        if (a0Var instanceof l) {
            return g.a.j.a.areEqual(this.f13227b, ((l) a0Var).f13227b);
        }
        return false;
    }

    @Override // g.a.a.a0
    public final void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 27, this.f13227b);
    }

    @Override // g.a.a.a0
    public final boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public final int d(boolean z) {
        return y.e(z, this.f13227b.length);
    }

    public final byte[] getOctets() {
        return g.a.j.a.clone(this.f13227b);
    }

    @Override // g.a.a.i0
    public final String getString() {
        return g.a.j.q.fromByteArray(this.f13227b);
    }

    @Override // g.a.a.a0, g.a.a.t
    public final int hashCode() {
        return g.a.j.a.hashCode(this.f13227b);
    }

    public String toString() {
        return getString();
    }
}
