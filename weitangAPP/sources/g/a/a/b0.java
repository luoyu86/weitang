package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 extends a0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13038a = new a(b0.class, 19);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13039b;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return b0.g(x1Var.getOctets());
        }
    }

    public b0(String str, boolean z) {
        if (z && !isPrintableString(str)) {
            throw new IllegalArgumentException("string contains illegal characters");
        }
        this.f13039b = g.a.j.q.toByteArray(str);
    }

    public b0(byte[] bArr, boolean z) {
        this.f13039b = z ? g.a.j.a.clone(bArr) : bArr;
    }

    public static b0 g(byte[] bArr) {
        return new a2(bArr, false);
    }

    public static b0 getInstance(l0 l0Var, boolean z) {
        return (b0) f13038a.e(l0Var, z);
    }

    public static b0 getInstance(Object obj) {
        if (obj == null || (obj instanceof b0)) {
            return (b0) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof b0) {
                return (b0) aSN1Primitive;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (b0) f13038a.b((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }

    public static boolean isPrintableString(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char cCharAt = str.charAt(length);
            if (cCharAt > 127) {
                return false;
            }
            if (('a' > cCharAt || cCharAt > 'z') && (('A' > cCharAt || cCharAt > 'Z') && (('0' > cCharAt || cCharAt > '9') && cCharAt != ' ' && cCharAt != ':' && cCharAt != '=' && cCharAt != '?'))) {
                switch (cCharAt) {
                    case '\'':
                    case '(':
                    case ')':
                        continue;
                    default:
                        switch (cCharAt) {
                            case '+':
                            case ',':
                            case '-':
                            case '.':
                            case '/':
                                break;
                            default:
                                return false;
                        }
                        break;
                }
            }
        }
        return true;
    }

    @Override // g.a.a.a0
    public final boolean a(a0 a0Var) {
        if (a0Var instanceof b0) {
            return g.a.j.a.areEqual(this.f13039b, ((b0) a0Var).f13039b);
        }
        return false;
    }

    @Override // g.a.a.a0
    public final void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 19, this.f13039b);
    }

    @Override // g.a.a.a0
    public final boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public final int d(boolean z) {
        return y.e(z, this.f13039b.length);
    }

    public final byte[] getOctets() {
        return g.a.j.a.clone(this.f13039b);
    }

    @Override // g.a.a.i0
    public final String getString() {
        return g.a.j.q.fromByteArray(this.f13039b);
    }

    @Override // g.a.a.a0, g.a.a.t
    public final int hashCode() {
        return g.a.j.a.hashCode(this.f13039b);
    }

    public String toString() {
        return getString();
    }
}
