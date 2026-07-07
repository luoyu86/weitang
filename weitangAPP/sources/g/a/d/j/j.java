package g.a.d.j;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes2.dex */
public class j extends c {
    public j() {
    }

    public j(j jVar) {
        super(jVar);
    }

    public j(byte[] bArr) {
        n(bArr);
    }

    @Override // g.a.d.j.c, g.a.j.h
    public g.a.j.h copy() {
        return new j(this);
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
        g.a.j.k.longToBigEndian(this.l, bArr, i2 + 48);
        g.a.j.k.longToBigEndian(this.m, bArr, i2 + 56);
        reset();
        return 64;
    }

    @Override // g.a.d.j.c, g.a.d.e
    public String getAlgorithmName() {
        return MessageDigestAlgorithms.SHA_512;
    }

    @Override // g.a.d.j.c, g.a.d.e
    public int getDigestSize() {
        return 64;
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
        this.f13746f = 7640891576956012808L;
        this.f13747g = -4942790177534073029L;
        this.f13748h = 4354685564936845355L;
        this.f13749i = -6534734903238641935L;
        this.j = 5840696475078001361L;
        this.k = -7276294671716946913L;
        this.l = 2270897969802886507L;
        this.m = 6620516959819538809L;
    }

    @Override // g.a.d.j.c, g.a.j.h
    public void reset(g.a.j.h hVar) {
        h((j) hVar);
    }
}
