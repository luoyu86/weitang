package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class u2 extends l0 {
    public u2(int i2, int i3, int i4, g gVar) {
        super(i2, i3, i4, gVar);
    }

    public u2(int i2, int i3, g gVar) {
        super(true, i2, i3, gVar);
    }

    public u2(int i2, g gVar) {
        super(true, i2, gVar);
    }

    public u2(boolean z, int i2, int i3, g gVar) {
        super(z, i2, i3, gVar);
    }

    public u2(boolean z, int i2, g gVar) {
        super(z, i2, gVar);
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        a0 a0VarF = this.f13231d.toASN1Primitive().f();
        boolean zIsExplicit = isExplicit();
        if (z) {
            int i2 = this.f13229b;
            if (zIsExplicit || a0VarF.c()) {
                i2 |= 32;
            }
            yVar.r(true, i2, this.f13230c);
        }
        if (zIsExplicit) {
            yVar.i(a0VarF.d(true));
        }
        a0VarF.b(yVar.c(), zIsExplicit);
    }

    @Override // g.a.a.a0
    public boolean c() {
        return isExplicit() || this.f13231d.toASN1Primitive().f().c();
    }

    @Override // g.a.a.a0
    public int d(boolean z) throws IOException {
        a0 a0VarF = this.f13231d.toASN1Primitive().f();
        boolean zIsExplicit = isExplicit();
        int iD = a0VarF.d(zIsExplicit);
        if (zIsExplicit) {
            iD += y.d(iD);
        }
        return iD + (z ? y.f(this.f13230c) : 0);
    }

    @Override // g.a.a.l0, g.a.a.a0
    public a0 f() {
        return this;
    }

    @Override // g.a.a.l0
    public String k() {
        return "DL";
    }

    @Override // g.a.a.l0
    public d0 n(a0 a0Var) {
        return new q2(a0Var);
    }

    @Override // g.a.a.l0
    public l0 o(int i2, int i3) {
        return new u2(this.f13228a, i2, i3, this.f13231d);
    }
}
