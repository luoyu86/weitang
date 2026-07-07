package g.a.i.b.c;

import g.a.i.d.a.l;
import g.a.i.d.a.m;
import g.a.i.d.a.o;

/* JADX INFO: loaded from: classes3.dex */
public class b extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g.a.i.d.a.e f14371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m f14372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l f14373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g.a.i.d.a.c f14374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public m[] f14375i;

    public b(int i2, int i3, g.a.i.d.a.e eVar, m mVar, g.a.i.d.a.c cVar, l lVar, String str) {
        super(true, str);
        this.f14369c = i2;
        this.f14370d = i3;
        this.f14371e = eVar;
        this.f14372f = mVar;
        this.f14374h = cVar;
        this.f14373g = lVar;
        this.f14375i = new o(eVar, mVar).getSquareRootMatrix();
    }

    public b(int i2, int i3, g.a.i.d.a.e eVar, m mVar, l lVar, String str) {
        this(i2, i3, eVar, mVar, g.a.i.d.a.g.createCanonicalCheckMatrix(eVar, mVar), lVar, str);
    }

    public g.a.i.d.a.e getField() {
        return this.f14371e;
    }

    public m getGoppaPoly() {
        return this.f14372f;
    }

    public g.a.i.d.a.c getH() {
        return this.f14374h;
    }

    public int getK() {
        return this.f14370d;
    }

    public int getN() {
        return this.f14369c;
    }

    public l getP() {
        return this.f14373g;
    }

    public m[] getQInv() {
        return this.f14375i;
    }

    public int getT() {
        return this.f14372f.getDegree();
    }
}
