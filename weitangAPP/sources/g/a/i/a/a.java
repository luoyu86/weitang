package g.a.i.a;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.q;
import g.a.a.t;
import g.a.a.w;
import g.a.a.x1;

/* JADX INFO: loaded from: classes3.dex */
public class a extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f14218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f14219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f14220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g.a.a.y3.a f14221f;

    public a(int i2, int i3, g.a.i.d.a.e eVar, g.a.i.d.a.m mVar, g.a.i.d.a.l lVar, g.a.a.y3.a aVar) {
        this.f14216a = i2;
        this.f14217b = i3;
        this.f14218c = eVar.getEncoded();
        this.f14219d = mVar.getEncoded();
        this.f14220e = lVar.getEncoded();
        this.f14221f = aVar;
    }

    public a(d0 d0Var) {
        this.f14216a = ((q) d0Var.getObjectAt(0)).intValueExact();
        this.f14217b = ((q) d0Var.getObjectAt(1)).intValueExact();
        this.f14218c = ((w) d0Var.getObjectAt(2)).getOctets();
        this.f14219d = ((w) d0Var.getObjectAt(3)).getOctets();
        this.f14220e = ((w) d0Var.getObjectAt(4)).getOctets();
        this.f14221f = g.a.a.y3.a.getInstance(d0Var.getObjectAt(5));
    }

    public static a getInstance(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.y3.a getDigest() {
        return this.f14221f;
    }

    public g.a.i.d.a.e getField() {
        return new g.a.i.d.a.e(this.f14218c);
    }

    public g.a.i.d.a.m getGoppaPoly() {
        return new g.a.i.d.a.m(getField(), this.f14219d);
    }

    public int getK() {
        return this.f14217b;
    }

    public int getN() {
        return this.f14216a;
    }

    public g.a.i.d.a.l getP() {
        return new g.a.i.d.a.l(this.f14220e);
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h();
        hVar.add(new q(this.f14216a));
        hVar.add(new q(this.f14217b));
        hVar.add(new x1(this.f14218c));
        hVar.add(new x1(this.f14219d));
        hVar.add(new x1(this.f14220e));
        hVar.add(this.f14221f);
        return new b2(hVar);
    }
}
