package g.a.i.b.c;

import g.a.i.d.a.l;
import g.a.i.d.a.m;
import g.a.i.d.a.o;

/* JADX INFO: loaded from: classes3.dex */
public class f extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g.a.i.d.a.e f14387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m f14388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g.a.i.d.a.c f14389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l f14390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l f14391i;
    public g.a.i.d.a.c j;
    public m[] k;

    public f(int i2, int i3, g.a.i.d.a.e eVar, m mVar, l lVar, l lVar2, g.a.i.d.a.c cVar) {
        super(true, null);
        this.f14386d = i3;
        this.f14385c = i2;
        this.f14387e = eVar;
        this.f14388f = mVar;
        this.f14389g = cVar;
        this.f14390h = lVar;
        this.f14391i = lVar2;
        this.j = g.a.i.d.a.g.createCanonicalCheckMatrix(eVar, mVar);
        this.k = new o(eVar, mVar).getSquareRootMatrix();
    }

    public f(int i2, int i3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[][] bArr7) {
        super(true, null);
        this.f14385c = i2;
        this.f14386d = i3;
        g.a.i.d.a.e eVar = new g.a.i.d.a.e(bArr);
        this.f14387e = eVar;
        this.f14388f = new m(eVar, bArr2);
        this.f14389g = new g.a.i.d.a.c(bArr3);
        this.f14390h = new l(bArr4);
        this.f14391i = new l(bArr5);
        this.j = new g.a.i.d.a.c(bArr6);
        this.k = new m[bArr7.length];
        for (int i4 = 0; i4 < bArr7.length; i4++) {
            this.k[i4] = new m(this.f14387e, bArr7[i4]);
        }
    }

    public g.a.i.d.a.e getField() {
        return this.f14387e;
    }

    public m getGoppaPoly() {
        return this.f14388f;
    }

    public g.a.i.d.a.c getH() {
        return this.j;
    }

    public int getK() {
        return this.f14386d;
    }

    public int getN() {
        return this.f14385c;
    }

    public l getP1() {
        return this.f14390h;
    }

    public l getP2() {
        return this.f14391i;
    }

    public m[] getQInv() {
        return this.k;
    }

    public g.a.i.d.a.c getSInv() {
        return this.f14389g;
    }
}
