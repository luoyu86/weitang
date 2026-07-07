package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r0 extends n0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0 f13310b;

    public r0(Class cls, int i2) {
        super(cls);
        this.f13310b = k0.a(0, i2);
    }

    public final a0 a(a0 a0Var) {
        if (this.f13253a.isInstance(a0Var)) {
            return a0Var;
        }
        throw new IllegalStateException("unexpected object: " + a0Var.getClass().getName());
    }

    public final a0 b(byte[] bArr) throws IOException {
        return a(a0.fromByteArray(bArr));
    }

    public a0 c(d0 d0Var) {
        throw new IllegalStateException("unexpected implicit constructed encoding");
    }

    public a0 d(x1 x1Var) {
        throw new IllegalStateException("unexpected implicit primitive encoding");
    }

    public final a0 e(l0 l0Var, boolean z) {
        if (128 == l0Var.getTagClass()) {
            return a(l0Var.l(z, this));
        }
        throw new IllegalStateException("this method only valid for CONTEXT_SPECIFIC tags");
    }
}
