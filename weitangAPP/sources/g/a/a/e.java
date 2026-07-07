package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class e extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13067a = new a(e.class, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f13068b = new e((byte) 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f13069c = new e((byte) -1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte f13070d;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return e.g(x1Var.getOctets());
        }
    }

    public e(byte b2) {
        this.f13070d = b2;
    }

    public static e g(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
        }
        byte b2 = bArr[0];
        return b2 != -1 ? b2 != 0 ? new e(b2) : f13068b : f13069c;
    }

    public static e getInstance(int i2) {
        return i2 != 0 ? f13069c : f13068b;
    }

    public static e getInstance(l0 l0Var, boolean z) {
        return (e) f13067a.e(l0Var, z);
    }

    public static e getInstance(Object obj) {
        if (obj == null || (obj instanceof e)) {
            return (e) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (e) f13067a.b((byte[]) obj);
        } catch (IOException e2) {
            throw new IllegalArgumentException("failed to construct boolean from byte[]: " + e2.getMessage());
        }
    }

    public static e getInstance(boolean z) {
        return z ? f13069c : f13068b;
    }

    @Override // g.a.a.a0
    public boolean a(a0 a0Var) {
        return (a0Var instanceof e) && isTrue() == ((e) a0Var).isTrue();
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.k(z, 1, this.f13070d);
    }

    @Override // g.a.a.a0
    public boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public int d(boolean z) {
        return y.e(z, 1);
    }

    @Override // g.a.a.a0
    public a0 e() {
        return isTrue() ? f13069c : f13068b;
    }

    @Override // g.a.a.a0, g.a.a.t
    public int hashCode() {
        return isTrue() ? 1 : 0;
    }

    public boolean isTrue() {
        return this.f13070d != 0;
    }

    public String toString() {
        return isTrue() ? "TRUE" : "FALSE";
    }
}
