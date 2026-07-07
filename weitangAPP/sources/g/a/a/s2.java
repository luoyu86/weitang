package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class s2 extends f0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13320d;

    public s2() {
        this.f13320d = -1;
    }

    public s2(g gVar) {
        super(gVar);
        this.f13320d = -1;
    }

    public s2(h hVar) {
        super(hVar, false);
        this.f13320d = -1;
    }

    public s2(boolean z, g[] gVarArr) {
        super(z, gVarArr);
        this.f13320d = -1;
    }

    public s2(g[] gVarArr) {
        super(gVarArr, false);
        this.f13320d = -1;
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.q(z, 49);
        p2 p2VarC = yVar.c();
        int length = this.f13074b.length;
        int i2 = 0;
        if (this.f13320d >= 0 || length > 16) {
            yVar.i(j());
            while (i2 < length) {
                p2VarC.s(this.f13074b[i2].toASN1Primitive(), true);
                i2++;
            }
            return;
        }
        a0[] a0VarArr = new a0[length];
        int iD = 0;
        for (int i3 = 0; i3 < length; i3++) {
            a0 a0VarF = this.f13074b[i3].toASN1Primitive().f();
            a0VarArr[i3] = a0VarF;
            iD += a0VarF.d(true);
        }
        this.f13320d = iD;
        yVar.i(iD);
        while (i2 < length) {
            p2VarC.s(a0VarArr[i2], true);
            i2++;
        }
    }

    @Override // g.a.a.a0
    public int d(boolean z) throws IOException {
        return y.e(z, j());
    }

    @Override // g.a.a.f0, g.a.a.a0
    public a0 f() {
        return this;
    }

    public final int j() throws IOException {
        if (this.f13320d < 0) {
            int length = this.f13074b.length;
            int iD = 0;
            for (int i2 = 0; i2 < length; i2++) {
                iD += this.f13074b[i2].toASN1Primitive().f().d(true);
            }
            this.f13320d = iD;
        }
        return this.f13320d;
    }
}
