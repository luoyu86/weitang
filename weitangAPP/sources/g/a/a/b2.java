package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class b2 extends d0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13046c;

    public b2() {
        this.f13046c = -1;
    }

    public b2(g gVar) {
        super(gVar);
        this.f13046c = -1;
    }

    public b2(h hVar) {
        super(hVar);
        this.f13046c = -1;
    }

    public b2(g[] gVarArr) {
        super(gVarArr);
        this.f13046c = -1;
    }

    public b2(g[] gVarArr, boolean z) {
        super(gVarArr, z);
        this.f13046c = -1;
    }

    public static b2 convert(d0 d0Var) {
        return (b2) d0Var.e();
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.q(z, 48);
        z1 z1VarB = yVar.b();
        int length = this.f13059b.length;
        int i2 = 0;
        if (this.f13046c >= 0 || length > 16) {
            yVar.i(n());
            while (i2 < length) {
                this.f13059b[i2].toASN1Primitive().e().b(z1VarB, true);
                i2++;
            }
            return;
        }
        a0[] a0VarArr = new a0[length];
        int iD = 0;
        for (int i3 = 0; i3 < length; i3++) {
            a0 a0VarE = this.f13059b[i3].toASN1Primitive().e();
            a0VarArr[i3] = a0VarE;
            iD += a0VarE.d(true);
        }
        this.f13046c = iD;
        yVar.i(iD);
        while (i2 < length) {
            a0VarArr[i2].b(z1VarB, true);
            i2++;
        }
    }

    @Override // g.a.a.a0
    public int d(boolean z) throws IOException {
        return y.e(z, n());
    }

    @Override // g.a.a.d0, g.a.a.a0
    public a0 e() {
        return this;
    }

    @Override // g.a.a.d0, g.a.a.a0
    public a0 f() {
        return this;
    }

    @Override // g.a.a.d0
    public c i() {
        return new n1(y0.j(g()), false);
    }

    @Override // g.a.a.d0
    public k j() {
        return new o1(this);
    }

    @Override // g.a.a.d0
    public w k() {
        return new x1(b1.j(h()));
    }

    @Override // g.a.a.d0
    public f0 l() {
        return new s2(false, m());
    }

    public final int n() throws IOException {
        if (this.f13046c < 0) {
            int length = this.f13059b.length;
            int iD = 0;
            for (int i2 = 0; i2 < length; i2++) {
                iD += this.f13059b[i2].toASN1Primitive().e().d(true);
            }
            this.f13046c = iD;
        }
        return this.f13046c;
    }
}
