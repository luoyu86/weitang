package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class h1 extends l0 {
    public h1(int i2) {
        super(false, i2, new d1());
    }

    public h1(int i2, int i3, int i4, g gVar) {
        super(i2, i3, i4, gVar);
    }

    public h1(int i2, int i3, g gVar) {
        super(true, i2, i3, gVar);
    }

    public h1(int i2, g gVar) {
        super(true, i2, gVar);
    }

    public h1(boolean z, int i2, int i3, g gVar) {
        super(z, i2, i3, gVar);
    }

    public h1(boolean z, int i2, g gVar) {
        super(z, i2, gVar);
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        a0 aSN1Primitive = this.f13231d.toASN1Primitive();
        boolean zIsExplicit = isExplicit();
        if (z) {
            int i2 = this.f13229b;
            if (zIsExplicit || aSN1Primitive.c()) {
                i2 |= 32;
            }
            yVar.r(true, i2, this.f13230c);
        }
        if (!zIsExplicit) {
            aSN1Primitive.b(yVar, false);
            return;
        }
        yVar.g(128);
        aSN1Primitive.b(yVar, true);
        yVar.g(0);
        yVar.g(0);
    }

    @Override // g.a.a.a0
    public boolean c() {
        return isExplicit() || this.f13231d.toASN1Primitive().c();
    }

    @Override // g.a.a.a0
    public int d(boolean z) throws IOException {
        a0 aSN1Primitive = this.f13231d.toASN1Primitive();
        boolean zIsExplicit = isExplicit();
        int iD = aSN1Primitive.d(zIsExplicit);
        if (zIsExplicit) {
            iD += 3;
        }
        return iD + (z ? y.f(this.f13230c) : 0);
    }

    @Override // g.a.a.l0
    public String k() {
        return "BER";
    }

    @Override // g.a.a.l0
    public d0 n(a0 a0Var) {
        return new d1(a0Var);
    }

    @Override // g.a.a.l0
    public l0 o(int i2, int i3) {
        return new h1(this.f13228a, i2, i3, this.f13231d);
    }
}
