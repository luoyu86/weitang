package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v0 extends a0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13366a = new a(v0.class, 26);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13367b;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return v0.g(x1Var.getOctets());
        }
    }

    public v0(String str) {
        this.f13367b = g.a.j.q.toByteArray(str);
    }

    public v0(byte[] bArr, boolean z) {
        this.f13367b = z ? g.a.j.a.clone(bArr) : bArr;
    }

    public static v0 g(byte[] bArr) {
        return new j2(bArr, false);
    }

    public static v0 getInstance(l0 l0Var, boolean z) {
        return (v0) f13366a.e(l0Var, z);
    }

    public static v0 getInstance(Object obj) {
        if (obj == null || (obj instanceof v0)) {
            return (v0) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof v0) {
                return (v0) aSN1Primitive;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (v0) f13366a.b((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }

    @Override // g.a.a.a0
    public final boolean a(a0 a0Var) {
        if (a0Var instanceof v0) {
            return g.a.j.a.areEqual(this.f13367b, ((v0) a0Var).f13367b);
        }
        return false;
    }

    @Override // g.a.a.a0
    public final void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 26, this.f13367b);
    }

    @Override // g.a.a.a0
    public final boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public final int d(boolean z) {
        return y.e(z, this.f13367b.length);
    }

    public final byte[] getOctets() {
        return g.a.j.a.clone(this.f13367b);
    }

    @Override // g.a.a.i0
    public final String getString() {
        return g.a.j.q.fromByteArray(this.f13367b);
    }

    @Override // g.a.a.a0, g.a.a.t
    public final int hashCode() {
        return g.a.j.a.hashCode(this.f13367b);
    }

    public String toString() {
        return getString();
    }
}
