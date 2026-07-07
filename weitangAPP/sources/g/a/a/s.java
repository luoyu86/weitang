package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s extends a0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13318a = new a(s.class, 18);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13319b;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return s.g(x1Var.getOctets());
        }
    }

    public s(String str, boolean z) {
        if (z && !isNumericString(str)) {
            throw new IllegalArgumentException("string contains illegal characters");
        }
        this.f13319b = g.a.j.q.toByteArray(str);
    }

    public s(byte[] bArr, boolean z) {
        this.f13319b = z ? g.a.j.a.clone(bArr) : bArr;
    }

    public static s g(byte[] bArr) {
        return new w1(bArr, false);
    }

    public static s getInstance(l0 l0Var, boolean z) {
        return (s) f13318a.e(l0Var, z);
    }

    public static s getInstance(Object obj) {
        if (obj == null || (obj instanceof s)) {
            return (s) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof s) {
                return (s) aSN1Primitive;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (s) f13318a.b((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }

    public static boolean isNumericString(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char cCharAt = str.charAt(length);
            if (cCharAt > 127) {
                return false;
            }
            if (('0' > cCharAt || cCharAt > '9') && cCharAt != ' ') {
                return false;
            }
        }
        return true;
    }

    @Override // g.a.a.a0
    public final boolean a(a0 a0Var) {
        if (a0Var instanceof s) {
            return g.a.j.a.areEqual(this.f13319b, ((s) a0Var).f13319b);
        }
        return false;
    }

    @Override // g.a.a.a0
    public final void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 18, this.f13319b);
    }

    @Override // g.a.a.a0
    public final boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public final int d(boolean z) {
        return y.e(z, this.f13319b.length);
    }

    public final byte[] getOctets() {
        return g.a.j.a.clone(this.f13319b);
    }

    @Override // g.a.a.i0
    public final String getString() {
        return g.a.j.q.fromByteArray(this.f13319b);
    }

    @Override // g.a.a.a0, g.a.a.t
    public final int hashCode() {
        return g.a.j.a.hashCode(this.f13319b);
    }

    public String toString() {
        return getString();
    }
}
