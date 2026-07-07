package g.a.a;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o extends a0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13269a = new a(o.class, 22);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13270b;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return o.g(x1Var.getOctets());
        }
    }

    public o(String str, boolean z) {
        Objects.requireNonNull(str, "'string' cannot be null");
        if (z && !isIA5String(str)) {
            throw new IllegalArgumentException("'string' contains illegal characters");
        }
        this.f13270b = g.a.j.q.toByteArray(str);
    }

    public o(byte[] bArr, boolean z) {
        this.f13270b = z ? g.a.j.a.clone(bArr) : bArr;
    }

    public static o g(byte[] bArr) {
        return new u1(bArr, false);
    }

    public static o getInstance(l0 l0Var, boolean z) {
        return (o) f13269a.e(l0Var, z);
    }

    public static o getInstance(Object obj) {
        if (obj == null || (obj instanceof o)) {
            return (o) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof o) {
                return (o) aSN1Primitive;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (o) f13269a.b((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }

    public static boolean isIA5String(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) > 127) {
                return false;
            }
        }
        return true;
    }

    @Override // g.a.a.a0
    public final boolean a(a0 a0Var) {
        if (a0Var instanceof o) {
            return g.a.j.a.areEqual(this.f13270b, ((o) a0Var).f13270b);
        }
        return false;
    }

    @Override // g.a.a.a0
    public final void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 22, this.f13270b);
    }

    @Override // g.a.a.a0
    public final boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public final int d(boolean z) {
        return y.e(z, this.f13270b.length);
    }

    public final byte[] getOctets() {
        return g.a.j.a.clone(this.f13270b);
    }

    @Override // g.a.a.i0
    public final String getString() {
        return g.a.j.q.fromByteArray(this.f13270b);
    }

    @Override // g.a.a.a0, g.a.a.t
    public final int hashCode() {
        return g.a.j.a.hashCode(this.f13270b);
    }

    public String toString() {
        return getString();
    }
}
