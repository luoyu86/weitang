package g.a.i.b.e;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends g.a.d.n.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f14400c;

    public b(int i2, byte[] bArr) {
        super(false);
        if (bArr.length != c.b(i2)) {
            throw new IllegalArgumentException("invalid key size for security category");
        }
        this.f14399b = i2;
        this.f14400c = g.a.j.a.clone(bArr);
    }

    public byte[] getPublicData() {
        return g.a.j.a.clone(this.f14400c);
    }

    public int getSecurityCategory() {
        return this.f14399b;
    }
}
