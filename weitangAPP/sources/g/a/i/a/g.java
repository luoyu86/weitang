package g.a.i.a;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.q;
import g.a.a.t;
import g.a.a.v;
import g.a.a.w;
import g.a.a.x1;

/* JADX INFO: loaded from: classes3.dex */
public class g extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f14254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f14255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q f14256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[][] f14257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[][] f14258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f14259f;

    public g(int i2, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f14254a = new q(0L);
        this.f14256c = new q(i2);
        this.f14257d = g.a.i.b.f.e.b.convertArray(sArr);
        this.f14258e = g.a.i.b.f.e.b.convertArray(sArr2);
        this.f14259f = g.a.i.b.f.e.b.convertArray(sArr3);
    }

    public g(d0 d0Var) {
        if (d0Var.getObjectAt(0) instanceof q) {
            this.f14254a = q.getInstance(d0Var.getObjectAt(0));
        } else {
            this.f14255b = v.getInstance(d0Var.getObjectAt(0));
        }
        this.f14256c = q.getInstance(d0Var.getObjectAt(1));
        d0 d0Var2 = d0.getInstance(d0Var.getObjectAt(2));
        this.f14257d = new byte[d0Var2.size()][];
        for (int i2 = 0; i2 < d0Var2.size(); i2++) {
            this.f14257d[i2] = w.getInstance(d0Var2.getObjectAt(i2)).getOctets();
        }
        d0 d0Var3 = (d0) d0Var.getObjectAt(3);
        this.f14258e = new byte[d0Var3.size()][];
        for (int i3 = 0; i3 < d0Var3.size(); i3++) {
            this.f14258e[i3] = w.getInstance(d0Var3.getObjectAt(i3)).getOctets();
        }
        this.f14259f = w.getInstance(((d0) d0Var.getObjectAt(4)).getObjectAt(0)).getOctets();
    }

    public static g getInstance(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(d0.getInstance(obj));
        }
        return null;
    }

    public short[][] getCoeffQuadratic() {
        return g.a.i.b.f.e.b.convertArray(this.f14257d);
    }

    public short[] getCoeffScalar() {
        return g.a.i.b.f.e.b.convertArray(this.f14259f);
    }

    public short[][] getCoeffSingular() {
        return g.a.i.b.f.e.b.convertArray(this.f14258e);
    }

    public int getDocLength() {
        return this.f14256c.intValueExact();
    }

    public q getVersion() {
        return this.f14254a;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h();
        g.a.a.g gVar = this.f14254a;
        if (gVar == null) {
            gVar = this.f14255b;
        }
        hVar.add(gVar);
        hVar.add(this.f14256c);
        g.a.a.h hVar2 = new g.a.a.h();
        for (int i2 = 0; i2 < this.f14257d.length; i2++) {
            hVar2.add(new x1(this.f14257d[i2]));
        }
        hVar.add(new b2(hVar2));
        g.a.a.h hVar3 = new g.a.a.h();
        for (int i3 = 0; i3 < this.f14258e.length; i3++) {
            hVar3.add(new x1(this.f14258e[i3]));
        }
        hVar.add(new b2(hVar3));
        g.a.a.h hVar4 = new g.a.a.h();
        hVar4.add(new x1(this.f14259f));
        hVar.add(new b2(hVar4));
        return new b2(hVar);
    }
}
