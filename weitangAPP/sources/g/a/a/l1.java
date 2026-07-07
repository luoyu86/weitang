package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class l1 extends a {
    public l1(int i2, g gVar) throws IOException {
        this(true, i2, gVar);
    }

    public l1(int i2, h hVar) {
        super(new e2(false, 64, i2, (g) q1.a(hVar)));
    }

    public l1(int i2, byte[] bArr) {
        super(new e2(false, 64, i2, (g) new x1(bArr)));
    }

    public l1(l0 l0Var) {
        super(l0Var);
    }

    public l1(boolean z, int i2, g gVar) throws IOException {
        super(new e2(z, 64, i2, gVar));
    }

    @Override // g.a.a.a, g.a.a.a0
    public a0 e() {
        return this;
    }

    @Override // g.a.a.a, g.a.a.a0
    public a0 f() {
        return this;
    }
}
