package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13309a = new a(r.class, 5);

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return r.g(x1Var.getOctets());
        }
    }

    public static r g(byte[] bArr) {
        if (bArr.length == 0) {
            return v1.f13368b;
        }
        throw new IllegalStateException("malformed NULL encoding encountered");
    }

    public static r getInstance(l0 l0Var, boolean z) {
        return (r) f13309a.e(l0Var, z);
    }

    public static r getInstance(Object obj) {
        if (obj instanceof r) {
            return (r) obj;
        }
        if (obj == null) {
            return null;
        }
        try {
            return (r) f13309a.b((byte[]) obj);
        } catch (IOException e2) {
            throw new IllegalArgumentException("failed to construct NULL from byte[]: " + e2.getMessage());
        }
    }

    @Override // g.a.a.a0
    public boolean a(a0 a0Var) {
        return a0Var instanceof r;
    }

    @Override // g.a.a.a0, g.a.a.t
    public int hashCode() {
        return -1;
    }

    public String toString() {
        return "NULL";
    }
}
