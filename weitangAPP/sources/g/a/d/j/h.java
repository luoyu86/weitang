package g.a.d.j;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes2.dex */
public class h extends c {
    public h() {
    }

    public h(h hVar) {
        super(hVar);
    }

    public h(byte[] bArr) {
        n(bArr);
    }

    @Override // g.a.d.j.c, g.a.j.h
    public g.a.j.h copy() {
        return new h(this);
    }

    @Override // g.a.d.j.c, g.a.d.e
    public int doFinal(byte[] bArr, int i2) {
        finish();
        g.a.j.k.longToBigEndian(this.f13746f, bArr, i2);
        g.a.j.k.longToBigEndian(this.f13747g, bArr, i2 + 8);
        g.a.j.k.longToBigEndian(this.f13748h, bArr, i2 + 16);
        g.a.j.k.longToBigEndian(this.f13749i, bArr, i2 + 24);
        g.a.j.k.longToBigEndian(this.j, bArr, i2 + 32);
        g.a.j.k.longToBigEndian(this.k, bArr, i2 + 40);
        reset();
        return 48;
    }

    @Override // g.a.d.j.c, g.a.d.e
    public String getAlgorithmName() {
        return MessageDigestAlgorithms.SHA_384;
    }

    @Override // g.a.d.j.c, g.a.d.e
    public int getDigestSize() {
        return 48;
    }

    @Override // g.a.d.j.c
    public byte[] getEncodedState() {
        byte[] bArr = new byte[i()];
        super.j(bArr);
        return bArr;
    }

    @Override // g.a.d.j.c, g.a.d.e
    public void reset() {
        super.reset();
        this.f13746f = -3766243637369397544L;
        this.f13747g = 7105036623409894663L;
        this.f13748h = -7973340178411365097L;
        this.f13749i = 1526699215303891257L;
        this.j = 7436329637833083697L;
        this.k = -8163818279084223215L;
        this.l = -2662702644619276377L;
        this.m = 5167115440072839076L;
    }

    @Override // g.a.d.j.c, g.a.j.h
    public void reset(g.a.j.h hVar) {
        super.h((h) hVar);
    }
}
