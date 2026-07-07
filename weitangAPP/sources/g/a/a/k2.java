package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class k2 extends a {
    public k2(int i2, g gVar) throws IOException {
        this(true, i2, gVar);
    }

    public k2(int i2, h hVar) {
        super(new u2(false, 64, i2, (g) o2.a(hVar)));
    }

    public k2(int i2, byte[] bArr) {
        super(new u2(false, 64, i2, (g) new x1(bArr)));
    }

    public k2(l0 l0Var) {
        super(l0Var);
    }

    public k2(boolean z, int i2, g gVar) throws IOException {
        super(new u2(z, 64, i2, gVar));
    }

    @Override // g.a.a.a, g.a.a.a0
    public a0 f() {
        return this;
    }
}
