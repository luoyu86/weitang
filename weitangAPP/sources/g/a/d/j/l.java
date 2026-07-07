package g.a.d.j;

/* JADX INFO: loaded from: classes2.dex */
public class l extends b implements g.a.d.i {
    public l() {
        this(128);
    }

    public l(int i2) {
        super(k(i2));
    }

    public l(l lVar) {
        super(lVar);
    }

    public static int k(int i2) {
        if (i2 == 128 || i2 == 256) {
            return i2;
        }
        throw new IllegalArgumentException("'bitLength' " + i2 + " not supported for SHAKE");
    }

    @Override // g.a.d.j.b, g.a.d.e
    public int doFinal(byte[] bArr, int i2) {
        return doFinal(bArr, i2, getDigestSize());
    }

    @Override // g.a.d.i
    public int doFinal(byte[] bArr, int i2, int i3) {
        int iDoOutput = doOutput(bArr, i2, i3);
        reset();
        return iDoOutput;
    }

    @Override // g.a.d.i
    public int doOutput(byte[] bArr, int i2, int i3) {
        if (!this.f13740g) {
            f(15, 4);
        }
        j(bArr, i2, ((long) i3) * 8);
        return i3;
    }

    @Override // g.a.d.j.b, g.a.d.e
    public String getAlgorithmName() {
        return "SHAKE" + this.f13739f;
    }

    @Override // g.a.d.j.b, g.a.d.e
    public int getDigestSize() {
        return this.f13739f / 4;
    }
}
