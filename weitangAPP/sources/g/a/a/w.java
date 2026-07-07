package g.a.a;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w extends a0 implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13391a = new a(w.class, 4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f13392b = new byte[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f13393c;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 c(d0 d0Var) {
            return d0Var.k();
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return x1Var;
        }
    }

    public w(byte[] bArr) {
        Objects.requireNonNull(bArr, "'string' cannot be null");
        this.f13393c = bArr;
    }

    public static w g(byte[] bArr) {
        return new x1(bArr);
    }

    public static w getInstance(l0 l0Var, boolean z) {
        return (w) f13391a.e(l0Var, z);
    }

    public static w getInstance(Object obj) {
        if (obj == null || (obj instanceof w)) {
            return (w) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof w) {
                return (w) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (w) f13391a.b((byte[]) obj);
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct OCTET STRING from byte[]: " + e2.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    @Override // g.a.a.a0
    public boolean a(a0 a0Var) {
        if (a0Var instanceof w) {
            return g.a.j.a.areEqual(this.f13393c, ((w) a0Var).f13393c);
        }
        return false;
    }

    @Override // g.a.a.a0
    public a0 e() {
        return new x1(this.f13393c);
    }

    @Override // g.a.a.a0
    public a0 f() {
        return new x1(this.f13393c);
    }

    @Override // g.a.a.x, g.a.a.y2
    public a0 getLoadedObject() {
        return toASN1Primitive();
    }

    @Override // g.a.a.x
    public InputStream getOctetStream() {
        return new ByteArrayInputStream(this.f13393c);
    }

    public byte[] getOctets() {
        return this.f13393c;
    }

    @Override // g.a.a.a0, g.a.a.t
    public int hashCode() {
        return g.a.j.a.hashCode(getOctets());
    }

    public x parser() {
        return this;
    }

    public String toString() {
        return "#" + g.a.j.q.fromByteArray(g.a.j.r.c.encode(this.f13393c));
    }
}
