package g.a.i.b.b;

/* JADX INFO: loaded from: classes3.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f14314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f14317d;

    public i(h hVar, byte[] bArr, int i2, byte[] bArr2) {
        this.f14314a = hVar;
        this.f14315b = bArr;
        this.f14316c = i2;
        this.f14317d = bArr2;
    }

    public x a() {
        x xVar = new x(this.f14315b, this.f14317d, b.a(this.f14314a.getDigestOID()));
        xVar.setQ(this.f14316c);
        return xVar;
    }

    public m b(u uVar, byte[][] bArr) {
        byte[] bArr2 = new byte[32];
        x xVarA = a();
        xVarA.setJ(-3);
        xVarA.deriveSeed(bArr2, false);
        g.a.d.e eVarA = b.a(this.f14314a.getDigestOID());
        w.b(getI(), eVarA);
        w.e(getQ(), eVarA);
        w.d((short) -32383, eVarA);
        w.b(bArr2, eVarA);
        return new m(this, uVar, eVarA, bArr2, bArr);
    }

    public byte[] getI() {
        return this.f14315b;
    }

    public byte[] getMasterSecret() {
        return this.f14317d;
    }

    public h getParameter() {
        return this.f14314a;
    }

    public int getQ() {
        return this.f14316c;
    }
}
