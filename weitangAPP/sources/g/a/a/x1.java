package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class x1 extends w {
    public x1(g gVar) throws IOException {
        super(gVar.toASN1Primitive().getEncoded("DER"));
    }

    public x1(byte[] bArr) {
        super(bArr);
    }

    public static void h(y yVar, boolean z, byte[] bArr, int i2, int i3) throws IOException {
        yVar.n(z, 4, bArr, i2, i3);
    }

    public static int i(boolean z, int i2) {
        return y.e(z, i2);
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 4, this.f13393c);
    }

    @Override // g.a.a.a0
    public boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public int d(boolean z) {
        return y.e(z, this.f13393c.length);
    }

    @Override // g.a.a.w, g.a.a.a0
    public a0 e() {
        return this;
    }

    @Override // g.a.a.w, g.a.a.a0
    public a0 f() {
        return this;
    }
}
