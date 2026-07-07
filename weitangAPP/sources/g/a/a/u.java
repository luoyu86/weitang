package g.a.a;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13346a = new a(u.class, 7);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f13347b;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 c(d0 d0Var) {
            return new u((n) n.f13251a.c(d0Var));
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return new u((n) n.f13251a.d(x1Var));
        }
    }

    public u(n nVar) {
        Objects.requireNonNull(nVar, "'baseGraphicString' cannot be null");
        this.f13347b = nVar;
    }

    public static u g(byte[] bArr) {
        return new u(n.g(bArr));
    }

    public static u getInstance(l0 l0Var, boolean z) {
        return (u) f13346a.e(l0Var, z);
    }

    public static u getInstance(Object obj) {
        if (obj == null || (obj instanceof u)) {
            return (u) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof u) {
                return (u) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (u) f13346a.b((byte[]) obj);
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct object descriptor from byte[]: " + e2.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    @Override // g.a.a.a0
    public boolean a(a0 a0Var) {
        if (a0Var instanceof u) {
            return this.f13347b.a(((u) a0Var).f13347b);
        }
        return false;
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.q(z, 7);
        this.f13347b.b(yVar, false);
    }

    @Override // g.a.a.a0
    public boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public int d(boolean z) {
        return this.f13347b.d(z);
    }

    @Override // g.a.a.a0
    public a0 e() {
        n nVar = (n) this.f13347b.e();
        return nVar == this.f13347b ? this : new u(nVar);
    }

    @Override // g.a.a.a0
    public a0 f() {
        n nVar = (n) this.f13347b.f();
        return nVar == this.f13347b ? this : new u(nVar);
    }

    public n getBaseGraphicString() {
        return this.f13347b;
    }

    @Override // g.a.a.a0, g.a.a.t
    public int hashCode() {
        return ~this.f13347b.hashCode();
    }
}
