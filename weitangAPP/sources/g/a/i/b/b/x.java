package g.a.i.b.b;

/* JADX INFO: loaded from: classes3.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f14363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g.a.d.e f14365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14367e;

    public x(byte[] bArr, byte[] bArr2, g.a.d.e eVar) {
        this.f14363a = bArr;
        this.f14364b = bArr2;
        this.f14365c = eVar;
    }

    public void deriveSeed(byte[] bArr, boolean z) {
        deriveSeed(bArr, z, 0);
    }

    public void deriveSeed(byte[] bArr, boolean z, int i2) {
        deriveSeed(bArr, i2);
        if (z) {
            this.f14367e++;
        }
    }

    public byte[] deriveSeed(byte[] bArr, int i2) {
        if (bArr.length < this.f14365c.getDigestSize()) {
            throw new IllegalArgumentException("target length is less than digest size.");
        }
        g.a.d.e eVar = this.f14365c;
        byte[] bArr2 = this.f14363a;
        eVar.update(bArr2, 0, bArr2.length);
        this.f14365c.update((byte) (this.f14366d >>> 24));
        this.f14365c.update((byte) (this.f14366d >>> 16));
        this.f14365c.update((byte) (this.f14366d >>> 8));
        this.f14365c.update((byte) this.f14366d);
        this.f14365c.update((byte) (this.f14367e >>> 8));
        this.f14365c.update((byte) this.f14367e);
        this.f14365c.update((byte) -1);
        g.a.d.e eVar2 = this.f14365c;
        byte[] bArr3 = this.f14364b;
        eVar2.update(bArr3, 0, bArr3.length);
        this.f14365c.doFinal(bArr, i2);
        return bArr;
    }

    public byte[] getI() {
        return this.f14363a;
    }

    public int getJ() {
        return this.f14367e;
    }

    public byte[] getMasterSeed() {
        return this.f14364b;
    }

    public int getQ() {
        return this.f14366d;
    }

    public void setJ(int i2) {
        this.f14367e = i2;
    }

    public void setQ(int i2) {
        this.f14366d = i2;
    }
}
