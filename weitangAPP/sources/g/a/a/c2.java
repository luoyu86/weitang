package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class c2 extends f0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13055d;

    public c2() {
        this.f13055d = -1;
    }

    public c2(g gVar) {
        super(gVar);
        this.f13055d = -1;
    }

    public c2(h hVar) {
        super(hVar, true);
        this.f13055d = -1;
    }

    public c2(boolean z, g[] gVarArr) {
        super(j(z), gVarArr);
        this.f13055d = -1;
    }

    public c2(g[] gVarArr) {
        super(gVarArr, true);
        this.f13055d = -1;
    }

    public static c2 convert(f0 f0Var) {
        return (c2) f0Var.e();
    }

    public static boolean j(boolean z) {
        if (z) {
            return z;
        }
        throw new IllegalStateException("DERSet elements should always be in sorted order");
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.q(z, 49);
        z1 z1VarB = yVar.b();
        int length = this.f13074b.length;
        int i2 = 0;
        if (this.f13055d >= 0 || length > 16) {
            yVar.i(k());
            while (i2 < length) {
                this.f13074b[i2].toASN1Primitive().e().b(z1VarB, true);
                i2++;
            }
            return;
        }
        a0[] a0VarArr = new a0[length];
        int iD = 0;
        for (int i3 = 0; i3 < length; i3++) {
            a0 a0VarE = this.f13074b[i3].toASN1Primitive().e();
            a0VarArr[i3] = a0VarE;
            iD += a0VarE.d(true);
        }
        this.f13055d = iD;
        yVar.i(iD);
        while (i2 < length) {
            a0VarArr[i2].b(z1VarB, true);
            i2++;
        }
    }

    @Override // g.a.a.a0
    public int d(boolean z) throws IOException {
        return y.e(z, k());
    }

    @Override // g.a.a.f0, g.a.a.a0
    public a0 e() {
        return this.f13075c ? this : super.e();
    }

    @Override // g.a.a.f0, g.a.a.a0
    public a0 f() {
        return this;
    }

    public final int k() throws IOException {
        if (this.f13055d < 0) {
            int length = this.f13074b.length;
            int iD = 0;
            for (int i2 = 0; i2 < length; i2++) {
                iD += this.f13074b[i2].toASN1Primitive().e().d(true);
            }
            this.f13055d = iD;
        }
        return this.f13055d;
    }
}
