package g.a.i.b.e;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends g.a.d.n.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f14398c;

    public a(int i2, byte[] bArr) {
        super(true);
        if (bArr.length != c.a(i2)) {
            throw new IllegalArgumentException("invalid key size for security category");
        }
        this.f14397b = i2;
        this.f14398c = g.a.j.a.clone(bArr);
    }

    public byte[] getSecret() {
        return g.a.j.a.clone(this.f14398c);
    }

    public int getSecurityCategory() {
        return this.f14397b;
    }
}
