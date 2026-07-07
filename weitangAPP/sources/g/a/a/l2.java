package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class l2 extends c {
    public l2(byte b2, int i2) {
        super(b2, i2);
    }

    public l2(int i2) {
        super(c.h(i2), c.i(i2));
    }

    public l2(g gVar) throws IOException {
        super(gVar.toASN1Primitive().getEncoded("DER"), 0);
    }

    public l2(byte[] bArr) {
        this(bArr, 0);
    }

    public l2(byte[] bArr, int i2) {
        super(bArr, i2);
    }

    public l2(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    public static void j(y yVar, boolean z, byte b2, byte[] bArr, int i2, int i3) throws IOException {
        yVar.l(z, 3, b2, bArr, i2, i3);
    }

    public static void k(y yVar, boolean z, byte[] bArr, int i2, int i3) throws IOException {
        yVar.n(z, 3, bArr, i2, i3);
    }

    public static int l(boolean z, int i2) {
        return y.e(z, i2);
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 3, this.f13050c);
    }

    @Override // g.a.a.a0
    public boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public int d(boolean z) {
        return y.e(z, this.f13050c.length);
    }

    @Override // g.a.a.c, g.a.a.a0
    public a0 f() {
        return this;
    }
}
