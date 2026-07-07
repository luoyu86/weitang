package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j0 extends a0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13180a = new a(j0.class, 20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13181b;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return j0.g(x1Var.getOctets());
        }
    }

    public j0(String str) {
        this.f13181b = g.a.j.q.toByteArray(str);
    }

    public j0(byte[] bArr, boolean z) {
        this.f13181b = z ? g.a.j.a.clone(bArr) : bArr;
    }

    public static j0 g(byte[] bArr) {
        return new d2(bArr, false);
    }

    public static j0 getInstance(l0 l0Var, boolean z) {
        return (j0) f13180a.e(l0Var, z);
    }

    public static j0 getInstance(Object obj) {
        if (obj == null || (obj instanceof j0)) {
            return (j0) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof j0) {
                return (j0) aSN1Primitive;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (j0) f13180a.b((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }

    @Override // g.a.a.a0
    public final boolean a(a0 a0Var) {
        if (a0Var instanceof j0) {
            return g.a.j.a.areEqual(this.f13181b, ((j0) a0Var).f13181b);
        }
        return false;
    }

    @Override // g.a.a.a0
    public final void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 20, this.f13181b);
    }

    @Override // g.a.a.a0
    public final boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public final int d(boolean z) {
        return y.e(z, this.f13181b.length);
    }

    public final byte[] getOctets() {
        return g.a.j.a.clone(this.f13181b);
    }

    @Override // g.a.a.i0
    public final String getString() {
        return g.a.j.q.fromByteArray(this.f13181b);
    }

    @Override // g.a.a.a0, g.a.a.t
    public final int hashCode() {
        return g.a.j.a.hashCode(this.f13181b);
    }

    public String toString() {
        return getString();
    }
}
