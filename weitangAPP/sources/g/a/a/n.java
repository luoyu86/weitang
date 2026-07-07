package g.a.a;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n extends a0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13251a = new a(n.class, 25);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13252b;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return n.g(x1Var.getOctets());
        }
    }

    public n(byte[] bArr, boolean z) {
        Objects.requireNonNull(bArr, "'contents' cannot be null");
        this.f13252b = z ? g.a.j.a.clone(bArr) : bArr;
    }

    public static n g(byte[] bArr) {
        return new t1(bArr, false);
    }

    public static n getInstance(l0 l0Var, boolean z) {
        return (n) f13251a.e(l0Var, z);
    }

    public static n getInstance(Object obj) {
        if (obj == null || (obj instanceof n)) {
            return (n) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof n) {
                return (n) aSN1Primitive;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (n) f13251a.b((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }

    @Override // g.a.a.a0
    public final boolean a(a0 a0Var) {
        if (a0Var instanceof n) {
            return g.a.j.a.areEqual(this.f13252b, ((n) a0Var).f13252b);
        }
        return false;
    }

    @Override // g.a.a.a0
    public final void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 25, this.f13252b);
    }

    @Override // g.a.a.a0
    public final boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public final int d(boolean z) {
        return y.e(z, this.f13252b.length);
    }

    public final byte[] getOctets() {
        return g.a.j.a.clone(this.f13252b);
    }

    @Override // g.a.a.i0
    public final String getString() {
        return g.a.j.q.fromByteArray(this.f13252b);
    }

    @Override // g.a.a.a0, g.a.a.t
    public final int hashCode() {
        return g.a.j.a.hashCode(this.f13252b);
    }
}
