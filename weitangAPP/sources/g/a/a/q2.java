package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class q2 extends d0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13296c;

    public q2() {
        this.f13296c = -1;
    }

    public q2(g gVar) {
        super(gVar);
        this.f13296c = -1;
    }

    public q2(h hVar) {
        super(hVar);
        this.f13296c = -1;
    }

    public q2(g[] gVarArr) {
        super(gVarArr);
        this.f13296c = -1;
    }

    public q2(g[] gVarArr, boolean z) {
        super(gVarArr, z);
        this.f13296c = -1;
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.q(z, 48);
        p2 p2VarC = yVar.c();
        int length = this.f13059b.length;
        int i2 = 0;
        if (this.f13296c >= 0 || length > 16) {
            yVar.i(n());
            while (i2 < length) {
                p2VarC.s(this.f13059b[i2].toASN1Primitive(), true);
                i2++;
            }
            return;
        }
        a0[] a0VarArr = new a0[length];
        int iD = 0;
        for (int i3 = 0; i3 < length; i3++) {
            a0 a0VarF = this.f13059b[i3].toASN1Primitive().f();
            a0VarArr[i3] = a0VarF;
            iD += a0VarF.d(true);
        }
        this.f13296c = iD;
        yVar.i(iD);
        while (i2 < length) {
            p2VarC.s(a0VarArr[i2], true);
            i2++;
        }
    }

    @Override // g.a.a.a0
    public int d(boolean z) throws IOException {
        return y.e(z, n());
    }

    @Override // g.a.a.d0, g.a.a.a0
    public a0 f() {
        return this;
    }

    @Override // g.a.a.d0
    public c i() {
        return new l2(y0.j(g()), false);
    }

    @Override // g.a.a.d0
    public k j() {
        return new n2(this);
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
        if (this.f13296c < 0) {
            int length = this.f13059b.length;
            int iD = 0;
            for (int i2 = 0; i2 < length; i2++) {
                iD += this.f13059b[i2].toASN1Primitive().f().d(true);
            }
            this.f13296c = iD;
        }
        return this.f13296c;
    }
}
