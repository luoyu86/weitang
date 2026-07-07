package g.a.d.j;

/* JADX INFO: loaded from: classes2.dex */
public class i extends b {
    public i() {
        this(256);
    }

    public i(int i2) {
        super(k(i2));
    }

    public i(i iVar) {
        super(iVar);
    }

    public static int k(int i2) {
        if (i2 == 224 || i2 == 256 || i2 == 384 || i2 == 512) {
            return i2;
        }
        throw new IllegalArgumentException("'bitLength' " + i2 + " not supported for SHA-3");
    }

    @Override // g.a.d.j.b, g.a.d.e
    public int doFinal(byte[] bArr, int i2) {
        f(2, 2);
        return super.doFinal(bArr, i2);
    }

    @Override // g.a.d.j.b, g.a.d.e
    public String getAlgorithmName() {
        return "SHA3-" + this.f13739f;
    }
}
