package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p0 extends a0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13280a = new a(p0.class, 12);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13281b;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return p0.g(x1Var.getOctets());
        }
    }

    public p0(String str) {
        this(g.a.j.q.toUTF8ByteArray(str), false);
    }

    public p0(byte[] bArr, boolean z) {
        this.f13281b = z ? g.a.j.a.clone(bArr) : bArr;
    }

    public static p0 g(byte[] bArr) {
        return new g2(bArr, false);
    }

    public static p0 getInstance(l0 l0Var, boolean z) {
        return (p0) f13280a.e(l0Var, z);
    }

    public static p0 getInstance(Object obj) {
        if (obj == null || (obj instanceof p0)) {
            return (p0) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof p0) {
                return (p0) aSN1Primitive;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (p0) f13280a.b((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }

    @Override // g.a.a.a0
    public final boolean a(a0 a0Var) {
        if (a0Var instanceof p0) {
            return g.a.j.a.areEqual(this.f13281b, ((p0) a0Var).f13281b);
        }
        return false;
    }

    @Override // g.a.a.a0
    public final void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 12, this.f13281b);
    }

    @Override // g.a.a.a0
    public final boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public final int d(boolean z) {
        return y.e(z, this.f13281b.length);
    }

    @Override // g.a.a.i0
    public final String getString() {
        return g.a.j.q.fromUTF8ByteArray(this.f13281b);
    }

    @Override // g.a.a.a0, g.a.a.t
    public final int hashCode() {
        return g.a.j.a.hashCode(this.f13281b);
    }

    public String toString() {
        return getString();
    }
}
